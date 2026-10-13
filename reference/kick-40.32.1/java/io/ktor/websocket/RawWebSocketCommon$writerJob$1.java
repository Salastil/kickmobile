package io.ktor.websocket;

import androidx.appcompat.app.AppCompatDelegate;
import com.swmansion.gesturehandler.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RawWebSocketCommon.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", i = {1, 2}, l = {86, BuildConfig.REACT_NATIVE_MINOR_VERSION, 89, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", n = {"message", "message"}, s = {"L$0", "L$0"}, v = 1)
final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$writerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RawWebSocketCommon$writerJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RawWebSocketCommon$writerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0051 A[Catch: all -> 0x0033, ChannelWriteException -> 0x0036, PHI: r10
      0x0051: PHI (r10v26 java.lang.Object) = (r10v0 java.lang.Object), (r10v32 java.lang.Object) binds: [B:13:0x002f, B:21:0x004d] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {ChannelWriteException -> 0x0036, all -> 0x0033, blocks: (B:9:0x0025, B:32:0x008b, B:20:0x003c, B:23:0x0051, B:25:0x0055, B:29:0x0075, B:38:0x00bf, B:40:0x00c3, B:41:0x00ce, B:42:0x00e4, B:34:0x008f, B:12:0x002b, B:13:0x002f), top: B:67:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00bf A[Catch: all -> 0x0033, ChannelWriteException -> 0x0036, TRY_ENTER, TryCatch #3 {ChannelWriteException -> 0x0036, all -> 0x0033, blocks: (B:9:0x0025, B:32:0x008b, B:20:0x003c, B:23:0x0051, B:25:0x0055, B:29:0x0075, B:38:0x00bf, B:40:0x00c3, B:41:0x00ce, B:42:0x00e4, B:34:0x008f, B:12:0x002b, B:13:0x002f), top: B:67:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c3 A[Catch: all -> 0x0033, ChannelWriteException -> 0x0036, TryCatch #3 {ChannelWriteException -> 0x0036, all -> 0x0033, blocks: (B:9:0x0025, B:32:0x008b, B:20:0x003c, B:23:0x0051, B:25:0x0055, B:29:0x0075, B:38:0x00bf, B:40:0x00c3, B:41:0x00ce, B:42:0x00e4, B:34:0x008f, B:12:0x002b, B:13:0x002f), top: B:67:0x000a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0087 -> B:32:0x008b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00c3 -> B:20:0x003c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$writerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
