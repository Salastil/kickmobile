package io.ktor.network.sockets;

import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.notifications.service.NotificationsService;
import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.util.PoolsKt;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.io.Buffer;

/* JADX INFO: compiled from: DatagramSocketImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082P¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010!\u001a\b\u0012\u0004\u0012\u00020\r0 8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010\fR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lio/ktor/network/sockets/DatagramSocketImpl;", "Lio/ktor/network/sockets/BoundDatagramSocket;", "Lio/ktor/network/sockets/ConnectedDatagramSocket;", "Lio/ktor/network/sockets/NIOSocketImpl;", "Ljava/nio/channels/DatagramChannel;", "channel", "Lio/ktor/network/selector/SelectorManager;", "selector", "<init>", "(Ljava/nio/channels/DatagramChannel;Lio/ktor/network/selector/SelectorManager;)V", "", "close", "()V", "Lio/ktor/network/sockets/Datagram;", "receiveImpl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/ByteBuffer;", "buffer", "receiveSuspend", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/channels/DatagramChannel;", "getChannel", "()Ljava/nio/channels/DatagramChannel;", "Lio/ktor/network/sockets/SocketAddress;", "getLocalAddress", "()Lio/ktor/network/sockets/SocketAddress;", "localAddress", "getRemoteAddress", "remoteAddress", "Lkotlinx/coroutines/channels/SendChannel;", "sender", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", NotificationsService.RECEIVER_KEY, "Lkotlinx/coroutines/channels/ReceiveChannel;", "getReceiver$annotations", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatagramSocketImpl extends NIOSocketImpl<DatagramChannel> implements BoundDatagramSocket, ConnectedDatagramSocket {
    private final DatagramChannel channel;
    private final ReceiveChannel<Datagram> receiver;
    private final SendChannel<Datagram> sender;

    /* JADX INFO: renamed from: io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: DatagramSocketImpl.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.DatagramSocketImpl", f = "DatagramSocketImpl.kt", i = {0}, l = {RotationOptions.ROTATE_90}, m = "receiveSuspend", n = {"buffer"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatagramSocketImpl.this.receiveSuspend(null, this);
        }
    }

    private static /* synthetic */ void getReceiver$annotations() {
    }

    @Override // io.ktor.network.sockets.DatagramReadChannel
    public /* bridge */ Object receive(Continuation<? super Datagram> continuation) {
        return super.receive(continuation);
    }

    @Override // io.ktor.network.sockets.DatagramWriteChannel
    public /* bridge */ Object send(Datagram datagram, Continuation<? super Unit> continuation) {
        return super.send(datagram, continuation);
    }

    @Override // io.ktor.network.sockets.NIOSocketImpl, io.ktor.network.selector.Selectable
    public DatagramChannel getChannel() {
        return this.channel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatagramSocketImpl(DatagramChannel channel, SelectorManager selector) {
        super(channel, selector, PoolsKt.getDefaultDatagramByteBufferPool(), null, 8, null);
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.channel = channel;
        this.sender = new DatagramSendChannel(getChannel(), this);
        this.receiver = ProduceKt.produce$default(this, Dispatchers.getIO(), 0, new DatagramSocketImpl$receiver$1(this, null), 2, null);
    }

    @Override // io.ktor.network.sockets.ABoundSocket
    public SocketAddress getLocalAddress() throws IOException {
        java.net.SocketAddress localSocketAddress;
        SocketAddress socketAddress;
        if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
            localSocketAddress = getChannel().getLocalAddress();
        } else {
            localSocketAddress = getChannel().socket().getLocalSocketAddress();
        }
        if (localSocketAddress == null || (socketAddress = JavaSocketAddressUtilsKt.toSocketAddress(localSocketAddress)) == null) {
            throw new IllegalStateException("Channel is not yet bound");
        }
        return socketAddress;
    }

    @Override // io.ktor.network.sockets.AConnectedSocket
    public SocketAddress getRemoteAddress() throws IOException {
        java.net.SocketAddress remoteSocketAddress;
        SocketAddress socketAddress;
        if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
            remoteSocketAddress = getChannel().getRemoteAddress();
        } else {
            remoteSocketAddress = getChannel().socket().getRemoteSocketAddress();
        }
        if (remoteSocketAddress == null || (socketAddress = JavaSocketAddressUtilsKt.toSocketAddress(remoteSocketAddress)) == null) {
            throw new IllegalStateException("Channel is not yet connected");
        }
        return socketAddress;
    }

    @Override // io.ktor.network.sockets.DatagramReadChannel
    public ReceiveChannel<Datagram> getIncoming() {
        return this.receiver;
    }

    @Override // io.ktor.network.sockets.DatagramWriteChannel
    public SendChannel<Datagram> getOutgoing() {
        return this.sender;
    }

    @Override // io.ktor.network.sockets.SocketBase, io.ktor.network.selector.SelectableBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) this.receiver, (CancellationException) null, 1, (Object) null);
        super.close();
        SendChannel.DefaultImpls.close$default(this.sender, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveImpl(Continuation<? super Datagram> continuation) {
        ByteBuffer byteBufferBorrow = PoolsKt.getDefaultDatagramByteBufferPool().borrow();
        try {
            java.net.SocketAddress socketAddressReceive = getChannel().receive(byteBufferBorrow);
            if (socketAddressReceive == null) {
                return receiveSuspend(byteBufferBorrow, continuation);
            }
            interestOp(SelectInterest.READ, false);
            byteBufferBorrow.flip();
            Buffer buffer = new Buffer();
            BytePacketBuilderExtensions_jvmKt.writeFully(buffer, byteBufferBorrow);
            Datagram datagram = new Datagram(buffer, JavaSocketAddressUtilsKt.toSocketAddress(socketAddressReceive));
            PoolsKt.getDefaultDatagramByteBufferPool().recycle(byteBufferBorrow);
            return datagram;
        } catch (Throwable th) {
            PoolsKt.getDefaultDatagramByteBufferPool().recycle(byteBufferBorrow);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0057 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:26:0x0058). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object receiveSuspend(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super io.ktor.network.sockets.Datagram> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.network.sockets.DatagramSocketImpl.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1 r0 = (io.ktor.network.sockets.DatagramSocketImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1 r0 = new io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            io.ktor.network.sockets.DatagramSocketImpl r5 = (io.ktor.network.sockets.DatagramSocketImpl) r5
            java.lang.Object r6 = r0.L$0
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L58
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
        L3d:
            io.ktor.network.selector.SelectInterest r7 = io.ktor.network.selector.SelectInterest.READ
            r5.interestOp(r7, r3)
            io.ktor.network.selector.SelectorManager r7 = r5.getSelector()
            r2 = r5
            io.ktor.network.selector.Selectable r2 = (io.ktor.network.selector.Selectable) r2
            io.ktor.network.selector.SelectInterest r4 = io.ktor.network.selector.SelectInterest.READ
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r7.select(r2, r4, r0)
            if (r7 != r1) goto L58
            return r1
        L58:
            java.nio.channels.DatagramChannel r7 = r5.getChannel()     // Catch: java.lang.Throwable -> L8a
            java.net.SocketAddress r7 = r7.receive(r6)     // Catch: java.lang.Throwable -> L8a
            if (r7 != 0) goto L63
            goto L3d
        L63:
            io.ktor.network.selector.SelectInterest r0 = io.ktor.network.selector.SelectInterest.READ
            r1 = 0
            r5.interestOp(r0, r1)
            r6.flip()
            kotlinx.io.Buffer r5 = new kotlinx.io.Buffer
            r5.<init>()
            r0 = r5
            kotlinx.io.Sink r0 = (kotlinx.io.Sink) r0
            io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt.writeFully(r0, r6)
            kotlinx.io.Source r5 = (kotlinx.io.Source) r5
            io.ktor.network.sockets.SocketAddress r7 = io.ktor.network.sockets.JavaSocketAddressUtilsKt.toSocketAddress(r7)
            io.ktor.network.sockets.Datagram r0 = new io.ktor.network.sockets.Datagram
            r0.<init>(r5, r7)
            io.ktor.utils.io.pool.ObjectPool r5 = io.ktor.network.util.PoolsKt.getDefaultDatagramByteBufferPool()
            r5.recycle(r6)
            return r0
        L8a:
            r5 = move-exception
            io.ktor.utils.io.pool.ObjectPool r7 = io.ktor.network.util.PoolsKt.getDefaultDatagramByteBufferPool()
            r7.recycle(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSocketImpl.receiveSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
