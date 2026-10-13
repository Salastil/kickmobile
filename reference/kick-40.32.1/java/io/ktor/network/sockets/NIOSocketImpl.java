package io.ktor.network.sockets;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.network.selector.SelectorManager;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NIOSocketImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u000e\b\u0000\u0010\u0003 \u0001*\u00020\u0001*\u00020\u00022\u00020\u00042\u00020\u0005B3\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0010¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010$¨\u0006%"}, d2 = {"Lio/ktor/network/sockets/NIOSocketImpl;", "Ljava/nio/channels/ByteChannel;", "Ljava/nio/channels/SelectableChannel;", ExifInterface.LATITUDE_SOUTH, "Lio/ktor/network/sockets/ReadWriteSocket;", "Lio/ktor/network/sockets/SocketBase;", "channel", "Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "<init>", "(Ljava/nio/channels/SelectableChannel;Lio/ktor/network/selector/SelectorManager;Lio/ktor/utils/io/pool/ObjectPool;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)V", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/WriterJob;", "attachForReadingImpl", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ReaderJob;", "attachForWritingImpl", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/ReaderJob;", "", "actualClose$ktor_network", "()Ljava/lang/Throwable;", "actualClose", "Ljava/nio/channels/SelectableChannel;", "getChannel", "()Ljava/nio/channels/SelectableChannel;", "Lio/ktor/network/selector/SelectorManager;", "getSelector", "()Lio/ktor/network/selector/SelectorManager;", "Lio/ktor/utils/io/pool/ObjectPool;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class NIOSocketImpl<S extends SelectableChannel & ByteChannel> extends SocketBase implements ReadWriteSocket {
    private final S channel;
    private final ObjectPool<ByteBuffer> pool;
    private final SelectorManager selector;
    private final SocketOptions.TCPClientSocketOptions socketOptions;

    public /* synthetic */ NIOSocketImpl(SelectableChannel selectableChannel, SelectorManager selectorManager, ObjectPool objectPool, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(selectableChannel, selectorManager, objectPool, (i & 8) != 0 ? null : tCPClientSocketOptions);
    }

    @Override // io.ktor.network.selector.Selectable
    public S getChannel() {
        return this.channel;
    }

    public final SelectorManager getSelector() {
        return this.selector;
    }

    public final ObjectPool<ByteBuffer> getPool() {
        return this.pool;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NIOSocketImpl(S channel, SelectorManager selector, ObjectPool<ByteBuffer> objectPool, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        super(EmptyCoroutineContext.INSTANCE);
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.channel = channel;
        this.selector = selector;
        this.pool = objectPool;
        this.socketOptions = tCPClientSocketOptions;
    }

    @Override // io.ktor.network.sockets.SocketBase
    public final WriterJob attachForReadingImpl(io.ktor.utils.io.ByteChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (this.pool != null) {
            return CIOReaderKt.attachForReadingImpl(this, channel, (ReadableByteChannel) getChannel(), this, this.selector, this.pool, this.socketOptions);
        }
        return CIOReaderKt.attachForReadingDirectImpl(this, channel, (ReadableByteChannel) getChannel(), this, this.selector, this.socketOptions);
    }

    @Override // io.ktor.network.sockets.SocketBase
    public final ReaderJob attachForWritingImpl(io.ktor.utils.io.ByteChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        return CIOWriterKt.attachForWritingDirectImpl(this, channel, (WritableByteChannel) getChannel(), this, this.selector, this.socketOptions);
    }

    @Override // io.ktor.network.sockets.SocketBase
    public Throwable actualClose$ktor_network() {
        try {
            getChannel().close();
            super.close();
            this.selector.notifyClosed(this);
            return null;
        } catch (Throwable th) {
            this.selector.notifyClosed(this);
            return th;
        }
    }
}
