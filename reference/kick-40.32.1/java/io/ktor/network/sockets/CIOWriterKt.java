package io.ktor.network.sockets;

import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import io.ktor.network.selector.Selectable;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.util.Timeout;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.ReaderScope;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: CIOWriter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteChannel;", "channel", "Ljava/nio/channels/WritableByteChannel;", "nioChannel", "Lio/ktor/network/selector/Selectable;", "selectable", "Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/utils/io/ReaderJob;", "attachForWritingDirectImpl", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteChannel;Ljava/nio/channels/WritableByteChannel;Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)Lio/ktor/utils/io/ReaderJob;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CIOWriterKt {
    public static /* synthetic */ ReaderJob attachForWritingDirectImpl$default(CoroutineScope coroutineScope, ByteChannel byteChannel, WritableByteChannel writableByteChannel, Selectable selectable, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, Object obj) {
        if ((i & 16) != 0) {
            tCPClientSocketOptions = null;
        }
        return attachForWritingDirectImpl(coroutineScope, byteChannel, writableByteChannel, selectable, selectorManager, tCPClientSocketOptions);
    }

    /* JADX INFO: renamed from: io.ktor.network.sockets.CIOWriterKt$attachForWritingDirectImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: CIOWriter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.CIOWriterKt$attachForWritingDirectImpl$1", f = "CIOWriter.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {33, EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY, 78, 50}, m = "invokeSuspend", n = {"$this$reader", InstrumentationTags.TIMEOUT, "$this$reader", InstrumentationTags.TIMEOUT, "rc", "$this$read_u24default$iv", "consumer$iv", "min$iv", "$i$f$read", "$this$reader", InstrumentationTags.TIMEOUT, "rc", "$this$read_u24default$iv", "consumer$iv", "min$iv", "$i$f$read", "$this$reader", InstrumentationTags.TIMEOUT, "rc"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ReaderScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ WritableByteChannel $nioChannel;
        final /* synthetic */ Selectable $selectable;
        final /* synthetic */ SelectorManager $selector;
        final /* synthetic */ SocketOptions.TCPClientSocketOptions $socketOptions;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Selectable selectable, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, ByteChannel byteChannel, SelectorManager selectorManager, WritableByteChannel writableByteChannel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$selectable = selectable;
            this.$socketOptions = tCPClientSocketOptions;
            this.$channel = byteChannel;
            this.$selector = selectorManager;
            this.$nioChannel = writableByteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$selectable, this.$socketOptions, this.$channel, this.$selector, this.$nioChannel, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ReaderScope readerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x00bb A[Catch: all -> 0x01aa, TryCatch #1 {all -> 0x01aa, blocks: (B:10:0x0024, B:32:0x00b3, B:34:0x00bb, B:36:0x00c5, B:39:0x00e4, B:43:0x0116, B:45:0x011e, B:46:0x0127, B:48:0x012b, B:51:0x0156, B:52:0x017d, B:54:0x0180, B:15:0x0041, B:17:0x004e, B:20:0x006a, B:24:0x0083, B:26:0x0087, B:29:0x0093), top: B:78:0x0011 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00c5 A[Catch: all -> 0x01aa, TryCatch #1 {all -> 0x01aa, blocks: (B:10:0x0024, B:32:0x00b3, B:34:0x00bb, B:36:0x00c5, B:39:0x00e4, B:43:0x0116, B:45:0x011e, B:46:0x0127, B:48:0x012b, B:51:0x0156, B:52:0x017d, B:54:0x0180, B:15:0x0041, B:17:0x004e, B:20:0x006a, B:24:0x0083, B:26:0x0087, B:29:0x0093), top: B:78:0x0011 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0112 A[EDGE_INSN: B:41:0x0112->B:50:0x0155 BREAK  A[LOOP:0: B:32:0x00b3->B:86:?]] */
        /* JADX WARN: Code duplicated, block: B:42:0x0113  */
        /* JADX WARN: Code duplicated, block: B:45:0x011e A[Catch: all -> 0x01aa, TryCatch #1 {all -> 0x01aa, blocks: (B:10:0x0024, B:32:0x00b3, B:34:0x00bb, B:36:0x00c5, B:39:0x00e4, B:43:0x0116, B:45:0x011e, B:46:0x0127, B:48:0x012b, B:51:0x0156, B:52:0x017d, B:54:0x0180, B:15:0x0041, B:17:0x004e, B:20:0x006a, B:24:0x0083, B:26:0x0087, B:29:0x0093), top: B:78:0x0011 }] */
        /* JADX WARN: Code duplicated, block: B:48:0x012b A[Catch: all -> 0x01aa, TryCatch #1 {all -> 0x01aa, blocks: (B:10:0x0024, B:32:0x00b3, B:34:0x00bb, B:36:0x00c5, B:39:0x00e4, B:43:0x0116, B:45:0x011e, B:46:0x0127, B:48:0x012b, B:51:0x0156, B:52:0x017d, B:54:0x0180, B:15:0x0041, B:17:0x004e, B:20:0x006a, B:24:0x0083, B:26:0x0087, B:29:0x0093), top: B:78:0x0011 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x0180 A[Catch: all -> 0x01aa, TRY_LEAVE, TryCatch #1 {all -> 0x01aa, blocks: (B:10:0x0024, B:32:0x00b3, B:34:0x00bb, B:36:0x00c5, B:39:0x00e4, B:43:0x0116, B:45:0x011e, B:46:0x0127, B:48:0x012b, B:51:0x0156, B:52:0x017d, B:54:0x0180, B:15:0x0041, B:17:0x004e, B:20:0x006a, B:24:0x0083, B:26:0x0087, B:29:0x0093), top: B:78:0x0011 }] */
        /* JADX WARN: Code duplicated, block: B:60:0x0198 A[Catch: ClosedChannelException -> 0x01a7, TRY_ENTER, TryCatch #0 {ClosedChannelException -> 0x01a7, blocks: (B:57:0x0190, B:60:0x0198, B:61:0x019e), top: B:76:0x0190 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x019e A[Catch: ClosedChannelException -> 0x01a7, TRY_LEAVE, TryCatch #0 {ClosedChannelException -> 0x01a7, blocks: (B:57:0x0190, B:60:0x0198, B:61:0x019e), top: B:76:0x0190 }] */
        /* JADX WARN: Code duplicated, block: B:76:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x017e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:83:0x00e4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:85:? A[PHI: r12
          PHI (r12v3 io.ktor.network.util.Timeout) = (r12v0 io.ktor.network.util.Timeout), (r12v0 io.ktor.network.util.Timeout), (r12v5 io.ktor.network.util.Timeout) binds: [B:47:0x0129, B:49:0x0153, B:31:0x00b2] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0129 -> B:32:0x00b3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0153 -> B:32:0x00b3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 464
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOWriterKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        static final Unit invokeSuspend$lambda$0(Timeout timeout, Ref.IntRef intRef, WritableByteChannel writableByteChannel, ByteBuffer byteBuffer) {
            while (byteBuffer.hasRemaining()) {
                if (timeout == null) {
                    do {
                        intRef.element = writableByteChannel.write(byteBuffer);
                        if (!byteBuffer.hasRemaining()) {
                            break;
                        }
                    } while (intRef.element > 0);
                } else {
                    timeout.start();
                    do {
                        try {
                            intRef.element = writableByteChannel.write(byteBuffer);
                            if (!byteBuffer.hasRemaining()) {
                                break;
                            }
                        } catch (Throwable th) {
                            timeout.stop();
                            throw th;
                        }
                    } while (intRef.element > 0);
                    Unit unit = Unit.INSTANCE;
                    timeout.stop();
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final ReaderJob attachForWritingDirectImpl(CoroutineScope coroutineScope, ByteChannel channel, WritableByteChannel nioChannel, Selectable selectable, SelectorManager selector, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(nioChannel, "nioChannel");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return ByteReadChannelOperationsKt.reader(coroutineScope, Dispatchers.getIO().plus(new CoroutineName("cio-to-nio-writer")), channel, new AnonymousClass1(selectable, tCPClientSocketOptions, channel, selector, nioChannel, null));
    }
}
