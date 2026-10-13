package io.ktor.network.sockets;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.foundation.style.ResolvedStyleKt;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.Selectable;
import io.ktor.network.selector.SelectorManager;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CIOReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aM\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a?\u0010\u0011\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteChannel;", "channel", "Ljava/nio/channels/ReadableByteChannel;", "nioChannel", "Lio/ktor/network/selector/Selectable;", "selectable", "Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/utils/io/WriterJob;", "attachForReadingImpl", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteChannel;Ljava/nio/channels/ReadableByteChannel;Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lio/ktor/utils/io/pool/ObjectPool;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)Lio/ktor/utils/io/WriterJob;", "attachForReadingDirectImpl", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteChannel;Ljava/nio/channels/ReadableByteChannel;Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteWriteChannel;", "", "readFrom", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/channels/ReadableByteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "selectForRead", "(Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-network"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CIOReaderKt {

    /* JADX INFO: renamed from: io.ktor.network.sockets.CIOReaderKt$readFrom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CIOReader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.CIOReaderKt", f = "CIOReader.kt", i = {0, 0, 0}, l = {133}, m = "readFrom", n = {"$this$readFrom", "nioChannel", "count"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C10431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10431(Continuation<? super C10431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOReaderKt.readFrom(null, null, this);
        }
    }

    public static /* synthetic */ WriterJob attachForReadingImpl$default(CoroutineScope coroutineScope, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, Selectable selectable, SelectorManager selectorManager, ObjectPool objectPool, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, Object obj) {
        if ((i & 32) != 0) {
            tCPClientSocketOptions = null;
        }
        return attachForReadingImpl(coroutineScope, byteChannel, readableByteChannel, selectable, selectorManager, objectPool, tCPClientSocketOptions);
    }

    /* JADX INFO: renamed from: io.ktor.network.sockets.CIOReaderKt$attachForReadingImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CIOReader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingImpl$1", f = "CIOReader.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4}, l = {42, 44, 42, 44, 55}, m = "invokeSuspend", n = {"$this$writer", InstrumentationTags.TIMEOUT, "rc", "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingImpl$1$1", "$this$writer", InstrumentationTags.TIMEOUT, "rc", "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingImpl$1$1", "$this$writer", InstrumentationTags.TIMEOUT, "rc", "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingImpl$1$1", "$this$writer", InstrumentationTags.TIMEOUT, "rc", "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingImpl$1$1", "$this$writer", InstrumentationTags.TIMEOUT, "rc"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C10421 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteBuffer $buffer;
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ ReadableByteChannel $nioChannel;
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
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
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10421(SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, ByteChannel byteChannel, Selectable selectable, ByteBuffer byteBuffer, ObjectPool<ByteBuffer> objectPool, ReadableByteChannel readableByteChannel, SelectorManager selectorManager, Continuation<? super C10421> continuation) {
            super(2, continuation);
            this.$socketOptions = tCPClientSocketOptions;
            this.$channel = byteChannel;
            this.$selectable = selectable;
            this.$buffer = byteBuffer;
            this.$pool = objectPool;
            this.$nioChannel = readableByteChannel;
            this.$selector = selectorManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10421 c10421 = new C10421(this.$socketOptions, this.$channel, this.$selectable, this.$buffer, this.$pool, this.$nioChannel, this.$selector, continuation);
            c10421.L$0 = obj;
            return c10421;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((C10421) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:59:0x01e9 A[Catch: all -> 0x0064, TryCatch #1 {all -> 0x0064, blocks: (B:57:0x01df, B:59:0x01e9, B:63:0x0216, B:68:0x024e, B:70:0x0252, B:15:0x005c), top: B:107:0x005c }] */
        /* JADX WARN: Code duplicated, block: B:61:0x020c  */
        /* JADX WARN: Code duplicated, block: B:62:0x020e  */
        /* JADX WARN: Code duplicated, block: B:65:0x0241  */
        /* JADX WARN: Code duplicated, block: B:66:0x0243 A[PHI: r3 r4 r5 r6 r8 r9 r11 r12 r13 r15
          0x0243: PHI (r3v12 int) = (r3v14 int), (r3v29 int) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0243: PHI (r4v3 java.nio.channels.ReadableByteChannel) = (r4v5 java.nio.channels.ReadableByteChannel), (r4v28 java.nio.channels.ReadableByteChannel) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0243: PHI (r5v4 kotlin.jvm.internal.Ref$IntRef) = (r5v6 kotlin.jvm.internal.Ref$IntRef), (r5v29 kotlin.jvm.internal.Ref$IntRef) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0243: PHI (r6v2 io.ktor.network.util.Timeout) = (r6v4 io.ktor.network.util.Timeout), (r6v26 io.ktor.network.util.Timeout) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0243: PHI (r8v3 io.ktor.network.util.Timeout) = (r8v4 io.ktor.network.util.Timeout), (r8v26 io.ktor.network.util.Timeout) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0243: PHI (r9v2 io.ktor.utils.io.ByteChannel) = (r9v3 io.ktor.utils.io.ByteChannel), (r9v18 io.ktor.utils.io.ByteChannel) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0243: PHI (r11v1 int) = (r11v3 int), (r11v21 int) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0243: PHI (r12v1 io.ktor.network.selector.SelectorManager) = (r12v2 io.ktor.network.selector.SelectorManager), (r12v20 io.ktor.network.selector.SelectorManager) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0243: PHI (r13v1 io.ktor.network.selector.Selectable) = (r13v3 io.ktor.network.selector.Selectable), (r13v22 io.ktor.network.selector.Selectable) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]
          0x0243: PHI (r15v1 java.nio.ByteBuffer) = (r15v2 java.nio.ByteBuffer), (r15v22 java.nio.ByteBuffer) binds: [B:64:0x023f, B:16:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:70:0x0252 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #1 {all -> 0x0064, blocks: (B:57:0x01df, B:59:0x01e9, B:63:0x0216, B:68:0x024e, B:70:0x0252, B:15:0x005c), top: B:107:0x005c }] */
        /* JADX WARN: Code duplicated, block: B:90:0x02d3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01d5 -> B:41:0x0140). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x02c6 -> B:89:0x02c9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x02d3 -> B:57:0x01df). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instruction units count: 772
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOReaderKt.C10421.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final WriterJob attachForReadingImpl(CoroutineScope coroutineScope, ByteChannel channel, ReadableByteChannel nioChannel, Selectable selectable, SelectorManager selector, ObjectPool<ByteBuffer> pool, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(nioChannel, "nioChannel");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullParameter(pool, "pool");
        return ByteWriteChannelOperationsKt.writer(coroutineScope, Dispatchers.getIO().plus(new CoroutineName("cio-from-nio-reader")), channel, new C10421(tCPClientSocketOptions, channel, selectable, pool.borrow(), pool, nioChannel, selector, null));
    }

    public static /* synthetic */ WriterJob attachForReadingDirectImpl$default(CoroutineScope coroutineScope, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, Selectable selectable, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, Object obj) {
        if ((i & 16) != 0) {
            tCPClientSocketOptions = null;
        }
        return attachForReadingDirectImpl(coroutineScope, byteChannel, readableByteChannel, selectable, selectorManager, tCPClientSocketOptions);
    }

    /* JADX INFO: renamed from: io.ktor.network.sockets.CIOReaderKt$attachForReadingDirectImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: CIOReader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingDirectImpl$1", f = "CIOReader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7}, l = {ResolvedStyleKt.InheritedFlags, 105, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, ResolvedStyleKt.InheritedFlags, 105, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m = "invokeSuspend", n = {"$this$writer", InstrumentationTags.TIMEOUT, "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingDirectImpl$1$1", "$this$writer", InstrumentationTags.TIMEOUT, "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingDirectImpl$1$1", "rc", "$this$writer", InstrumentationTags.TIMEOUT, "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingDirectImpl$1$1", "rc", "$this$writer", InstrumentationTags.TIMEOUT, "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingDirectImpl$1$1", "rc", "$this$writer", InstrumentationTags.TIMEOUT, "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingDirectImpl$1$1", "$this$writer", InstrumentationTags.TIMEOUT, "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingDirectImpl$1$1", "rc", "$this$writer", InstrumentationTags.TIMEOUT, "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingDirectImpl$1$1", "rc", "$this$writer", InstrumentationTags.TIMEOUT, "$this$withTimeout$iv", "$i$f$withTimeout", "$i$a$-withTimeout-CIOReaderKt$attachForReadingDirectImpl$1$1", "rc"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ ReadableByteChannel $nioChannel;
        final /* synthetic */ Selectable $selectable;
        final /* synthetic */ SelectorManager $selector;
        final /* synthetic */ SocketOptions.TCPClientSocketOptions $socketOptions;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Selectable selectable, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, ByteChannel byteChannel, ReadableByteChannel readableByteChannel, SelectorManager selectorManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$selectable = selectable;
            this.$socketOptions = tCPClientSocketOptions;
            this.$channel = byteChannel;
            this.$nioChannel = readableByteChannel;
            this.$selector = selectorManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$selectable, this.$socketOptions, this.$channel, this.$nioChannel, this.$selector, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:55:0x01ef A[Catch: all -> 0x0339, PHI: r2 r5 r6 r7 r8 r9 r10 r11 r12
          0x01ef: PHI (r2v15 int) = (r2v6 int), (r2v13 int), (r2v16 int) binds: [B:27:0x0111, B:62:0x0246, B:53:0x01eb] A[DONT_GENERATE, DONT_INLINE]
          0x01ef: PHI (r5v15 int) = (r5v5 int), (r5v13 int), (r5v16 int) binds: [B:27:0x0111, B:62:0x0246, B:53:0x01eb] A[DONT_GENERATE, DONT_INLINE]
          0x01ef: PHI (r6v15 int) = (r6v4 int), (r6v13 int), (r6v16 int) binds: [B:27:0x0111, B:62:0x0246, B:53:0x01eb] A[DONT_GENERATE, DONT_INLINE]
          0x01ef: PHI (r7v20 io.ktor.network.selector.SelectorManager) = 
          (r7v5 io.ktor.network.selector.SelectorManager)
          (r7v18 io.ktor.network.selector.SelectorManager)
          (r7v21 io.ktor.network.selector.SelectorManager)
         binds: [B:27:0x0111, B:62:0x0246, B:53:0x01eb] A[DONT_GENERATE, DONT_INLINE]
          0x01ef: PHI (r8v19 io.ktor.network.selector.Selectable) = 
          (r8v4 io.ktor.network.selector.Selectable)
          (r8v17 io.ktor.network.selector.Selectable)
          (r8v20 io.ktor.network.selector.Selectable)
         binds: [B:27:0x0111, B:62:0x0246, B:53:0x01eb] A[DONT_GENERATE, DONT_INLINE]
          0x01ef: PHI (r9v21 java.nio.channels.ReadableByteChannel) = 
          (r9v6 java.nio.channels.ReadableByteChannel)
          (r9v19 java.nio.channels.ReadableByteChannel)
          (r9v22 java.nio.channels.ReadableByteChannel)
         binds: [B:27:0x0111, B:62:0x0246, B:53:0x01eb] A[DONT_GENERATE, DONT_INLINE]
          0x01ef: PHI (r10v22 io.ktor.utils.io.ByteChannel) = (r10v6 io.ktor.utils.io.ByteChannel), (r10v20 io.ktor.utils.io.ByteChannel), (r10v23 io.ktor.utils.io.ByteChannel) binds: [B:27:0x0111, B:62:0x0246, B:53:0x01eb] A[DONT_GENERATE, DONT_INLINE]
          0x01ef: PHI (r11v21 io.ktor.network.util.Timeout) = (r11v7 io.ktor.network.util.Timeout), (r11v19 io.ktor.network.util.Timeout), (r11v22 io.ktor.network.util.Timeout) binds: [B:27:0x0111, B:62:0x0246, B:53:0x01eb] A[DONT_GENERATE, DONT_INLINE]
          0x01ef: PHI (r12v16 io.ktor.network.util.Timeout) = (r12v3 io.ktor.network.util.Timeout), (r12v14 io.ktor.network.util.Timeout), (r12v17 io.ktor.network.util.Timeout) binds: [B:27:0x0111, B:62:0x0246, B:53:0x01eb] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x0339, blocks: (B:85:0x02fc, B:40:0x0177, B:42:0x017f, B:44:0x0189, B:48:0x01b9, B:50:0x01c1, B:52:0x01c8, B:55:0x01ef, B:58:0x0216, B:61:0x0240, B:64:0x024a, B:90:0x0308, B:91:0x030b, B:93:0x0313, B:103:0x0338, B:87:0x0302, B:88:0x0305, B:21:0x00cb, B:24:0x00ee, B:27:0x0111, B:30:0x0132, B:33:0x0142, B:35:0x014e, B:38:0x015a, B:7:0x0035, B:82:0x02f2, B:76:0x02aa, B:79:0x02cc, B:84:0x02fa, B:65:0x024d, B:69:0x0279, B:71:0x0281, B:73:0x0288, B:10:0x0058, B:13:0x007b, B:16:0x009d), top: B:121:0x000c, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0214  */
        /* JADX WARN: Code duplicated, block: B:58:0x0216 A[Catch: all -> 0x0339, PHI: r2 r5 r6 r7 r8 r9 r10 r11 r12
          0x0216: PHI (r2v14 int) = (r2v7 int), (r2v15 int) binds: [B:24:0x00ee, B:56:0x0212] A[DONT_GENERATE, DONT_INLINE]
          0x0216: PHI (r5v14 int) = (r5v6 int), (r5v15 int) binds: [B:24:0x00ee, B:56:0x0212] A[DONT_GENERATE, DONT_INLINE]
          0x0216: PHI (r6v14 int) = (r6v5 int), (r6v15 int) binds: [B:24:0x00ee, B:56:0x0212] A[DONT_GENERATE, DONT_INLINE]
          0x0216: PHI (r7v19 io.ktor.network.selector.SelectorManager) = (r7v7 io.ktor.network.selector.SelectorManager), (r7v20 io.ktor.network.selector.SelectorManager) binds: [B:24:0x00ee, B:56:0x0212] A[DONT_GENERATE, DONT_INLINE]
          0x0216: PHI (r8v18 io.ktor.network.selector.Selectable) = (r8v6 io.ktor.network.selector.Selectable), (r8v19 io.ktor.network.selector.Selectable) binds: [B:24:0x00ee, B:56:0x0212] A[DONT_GENERATE, DONT_INLINE]
          0x0216: PHI (r9v20 java.nio.channels.ReadableByteChannel) = (r9v8 java.nio.channels.ReadableByteChannel), (r9v21 java.nio.channels.ReadableByteChannel) binds: [B:24:0x00ee, B:56:0x0212] A[DONT_GENERATE, DONT_INLINE]
          0x0216: PHI (r10v21 io.ktor.utils.io.ByteChannel) = (r10v8 io.ktor.utils.io.ByteChannel), (r10v22 io.ktor.utils.io.ByteChannel) binds: [B:24:0x00ee, B:56:0x0212] A[DONT_GENERATE, DONT_INLINE]
          0x0216: PHI (r11v20 io.ktor.network.util.Timeout) = (r11v9 io.ktor.network.util.Timeout), (r11v21 io.ktor.network.util.Timeout) binds: [B:24:0x00ee, B:56:0x0212] A[DONT_GENERATE, DONT_INLINE]
          0x0216: PHI (r12v15 io.ktor.network.util.Timeout) = (r12v5 io.ktor.network.util.Timeout), (r12v16 io.ktor.network.util.Timeout) binds: [B:24:0x00ee, B:56:0x0212] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x0339, blocks: (B:85:0x02fc, B:40:0x0177, B:42:0x017f, B:44:0x0189, B:48:0x01b9, B:50:0x01c1, B:52:0x01c8, B:55:0x01ef, B:58:0x0216, B:61:0x0240, B:64:0x024a, B:90:0x0308, B:91:0x030b, B:93:0x0313, B:103:0x0338, B:87:0x0302, B:88:0x0305, B:21:0x00cb, B:24:0x00ee, B:27:0x0111, B:30:0x0132, B:33:0x0142, B:35:0x014e, B:38:0x015a, B:7:0x0035, B:82:0x02f2, B:76:0x02aa, B:79:0x02cc, B:84:0x02fa, B:65:0x024d, B:69:0x0279, B:71:0x0281, B:73:0x0288, B:10:0x0058, B:13:0x007b, B:16:0x009d), top: B:121:0x000c, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:60:0x023e  */
        /* JADX WARN: Code duplicated, block: B:61:0x0240 A[Catch: all -> 0x0339, PHI: r2 r5 r6 r7 r8 r9 r10 r11 r12 r15
          0x0240: PHI (r2v13 int) = (r2v8 int), (r2v14 int) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE]
          0x0240: PHI (r5v13 int) = (r5v7 int), (r5v14 int) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE]
          0x0240: PHI (r6v13 int) = (r6v6 int), (r6v14 int) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE]
          0x0240: PHI (r7v18 io.ktor.network.selector.SelectorManager) = (r7v9 io.ktor.network.selector.SelectorManager), (r7v19 io.ktor.network.selector.SelectorManager) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE]
          0x0240: PHI (r8v17 io.ktor.network.selector.Selectable) = (r8v8 io.ktor.network.selector.Selectable), (r8v18 io.ktor.network.selector.Selectable) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE]
          0x0240: PHI (r9v19 java.nio.channels.ReadableByteChannel) = (r9v10 java.nio.channels.ReadableByteChannel), (r9v20 java.nio.channels.ReadableByteChannel) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE]
          0x0240: PHI (r10v20 io.ktor.utils.io.ByteChannel) = (r10v10 io.ktor.utils.io.ByteChannel), (r10v21 io.ktor.utils.io.ByteChannel) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE]
          0x0240: PHI (r11v19 io.ktor.network.util.Timeout) = (r11v11 io.ktor.network.util.Timeout), (r11v20 io.ktor.network.util.Timeout) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE]
          0x0240: PHI (r12v14 io.ktor.network.util.Timeout) = (r12v7 io.ktor.network.util.Timeout), (r12v15 io.ktor.network.util.Timeout) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE]
          0x0240: PHI (r15v15 java.lang.Object) = (r15v0 java.lang.Object), (r15v20 java.lang.Object) binds: [B:21:0x00cb, B:59:0x023c] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x0339, blocks: (B:85:0x02fc, B:40:0x0177, B:42:0x017f, B:44:0x0189, B:48:0x01b9, B:50:0x01c1, B:52:0x01c8, B:55:0x01ef, B:58:0x0216, B:61:0x0240, B:64:0x024a, B:90:0x0308, B:91:0x030b, B:93:0x0313, B:103:0x0338, B:87:0x0302, B:88:0x0305, B:21:0x00cb, B:24:0x00ee, B:27:0x0111, B:30:0x0132, B:33:0x0142, B:35:0x014e, B:38:0x015a, B:7:0x0035, B:82:0x02f2, B:76:0x02aa, B:79:0x02cc, B:84:0x02fa, B:65:0x024d, B:69:0x0279, B:71:0x0281, B:73:0x0288, B:10:0x0058, B:13:0x007b, B:16:0x009d), top: B:121:0x000c, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x0248  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x01c1 -> B:86:0x02ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01c6 -> B:86:0x02ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0246 -> B:55:0x01ef). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0248 -> B:86:0x02ff). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0281 -> B:84:0x02fa). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x0286 -> B:84:0x02fa). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x02ef -> B:82:0x02f2). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 880
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOReaderKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final WriterJob attachForReadingDirectImpl(CoroutineScope coroutineScope, ByteChannel channel, ReadableByteChannel nioChannel, Selectable selectable, SelectorManager selector, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(nioChannel, "nioChannel");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return ByteWriteChannelOperationsKt.writer(coroutineScope, Dispatchers.getIO().plus(new CoroutineName("cio-from-nio-reader")), channel, new AnonymousClass1(selectable, tCPClientSocketOptions, channel, nioChannel, selector, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readFrom(ByteWriteChannel byteWriteChannel, final ReadableByteChannel readableByteChannel, Continuation<? super Integer> continuation) {
        C10431 c10431;
        Ref.IntRef intRef;
        if (continuation instanceof C10431) {
            c10431 = (C10431) continuation;
            if ((c10431.label & Integer.MIN_VALUE) != 0) {
                c10431.label -= Integer.MIN_VALUE;
            } else {
                c10431 = new C10431(continuation);
            }
        } else {
            c10431 = new C10431(continuation);
        }
        C10431 c10432 = c10431;
        Object obj = c10432.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10432.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.IntRef intRef2 = new Ref.IntRef();
            Function1 function1 = new Function1() { // from class: io.ktor.network.sockets.CIOReaderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return CIOReaderKt.readFrom$lambda$0(intRef2, readableByteChannel, (ByteBuffer) obj2);
                }
            };
            c10432.L$0 = SpillingKt.nullOutSpilledVariable(byteWriteChannel);
            c10432.L$1 = SpillingKt.nullOutSpilledVariable(readableByteChannel);
            c10432.L$2 = intRef2;
            c10432.label = 1;
            if (ByteWriteChannelOperations_jvmKt.write$default(byteWriteChannel, 0, function1, c10432, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef = intRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (Ref.IntRef) c10432.L$2;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxInt(intRef.element);
    }

    static final Unit readFrom$lambda$0(Ref.IntRef intRef, ReadableByteChannel readableByteChannel, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        intRef.element = readableByteChannel.read(buffer);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object selectForRead(Selectable selectable, SelectorManager selectorManager, Continuation<? super Unit> continuation) {
        selectable.interestOp(SelectInterest.READ, true);
        Object objSelect = selectorManager.select(selectable, SelectInterest.READ, continuation);
        return objSelect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSelect : Unit.INSTANCE;
    }
}
