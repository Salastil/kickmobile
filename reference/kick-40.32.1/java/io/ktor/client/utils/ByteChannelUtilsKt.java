package io.ktor.client.utils;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.ktor.client.content.ProgressListener;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: ByteChannelUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/CoroutineContext;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "", "contentLength", "Lio/ktor/client/content/ProgressListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "observable", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Long;Lio/ktor/client/content/ProgressListener;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ByteChannelUtilsKt {

    /* JADX INFO: renamed from: io.ktor.client.utils.ByteChannelUtilsKt$observable$1, reason: invalid class name */
    /* JADX INFO: compiled from: ByteChannelUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {22, 24, 26, 31}, m = "invokeSuspend", n = {"$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "$i$f$useInstance", "$i$a$-useInstance-ByteChannelUtilsKt$observable$1$1", "bytesSend", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "$i$f$useInstance", "$i$a$-useInstance-ByteChannelUtilsKt$observable$1$1", "bytesSend", "read", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "$i$f$useInstance", "$i$a$-useInstance-ByteChannelUtilsKt$observable$1$1", "bytesSend", "read", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "closedCause", "$i$f$useInstance", "$i$a$-useInstance-ByteChannelUtilsKt$observable$1$1", "bytesSend"}, s = {"L$0", "L$1", "L$5", "L$6", "I$0", "I$1", "J$0", "L$0", "L$1", "L$5", "L$6", "I$0", "I$1", "J$0", "I$2", "L$0", "L$1", "L$5", "L$6", "I$0", "I$1", "J$0", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "J$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $contentLength;
        final /* synthetic */ ProgressListener $listener;
        final /* synthetic */ ByteReadChannel $this_observable;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteReadChannel byteReadChannel, ProgressListener progressListener, Long l, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_observable = byteReadChannel;
            this.$listener = progressListener;
            this.$contentLength = l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_observable, this.$listener, this.$contentLength, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00fc A[Catch: all -> 0x01e3, TryCatch #1 {all -> 0x01e3, blocks: (B:31:0x00f6, B:33:0x00fc, B:37:0x0129, B:39:0x0131, B:52:0x019b, B:56:0x01ae), top: B:70:0x00f6 }] */
        /* JADX WARN: Code duplicated, block: B:35:0x0125  */
        /* JADX WARN: Code duplicated, block: B:36:0x0127  */
        /* JADX WARN: Code duplicated, block: B:39:0x0131 A[Catch: all -> 0x01e3, TRY_LEAVE, TryCatch #1 {all -> 0x01e3, blocks: (B:31:0x00f6, B:33:0x00fc, B:37:0x0129, B:39:0x0131, B:52:0x019b, B:56:0x01ae), top: B:70:0x00f6 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0156  */
        /* JADX WARN: Code duplicated, block: B:47:0x0186  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x00d3: MOVE (r1 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:27:0x00d3 */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r15v12 */
        /* JADX WARN: Type inference failed for: r15v2, types: [io.ktor.utils.io.pool.ObjectPool] */
        /* JADX WARN: Type inference failed for: r15v4 */
        /* JADX WARN: Type inference failed for: r15v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r15v9 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v25, types: [io.ktor.utils.io.pool.ObjectPool] */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v6, types: [io.ktor.utils.io.pool.ObjectPool] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8, types: [io.ktor.utils.io.pool.ObjectPool] */
        /* JADX WARN: Type inference failed for: r2v9, types: [io.ktor.utils.io.pool.ObjectPool] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instruction units count: 493
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.utils.ByteChannelUtilsKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final ByteReadChannel observable(ByteReadChannel byteReadChannel, CoroutineContext context, Long l, ProgressListener listener) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return ByteWriteChannelOperationsKt.writer((CoroutineScope) GlobalScope.INSTANCE, context, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(byteReadChannel, listener, l, null)).getChannel();
    }
}
