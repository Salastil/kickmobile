package expo.modules.kicktimers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: KickTimersModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.kicktimers.KickTimersModule$definition$1$1$1", f = "KickTimersModule.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, nl = {28}, s = {}, v = 2)
final class KickTimersModule$definition$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $interval;
    final /* synthetic */ String $intervalID;
    int label;
    final /* synthetic */ KickTimersModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KickTimersModule$definition$1$1$1(int i, KickTimersModule kickTimersModule, String str, Continuation<? super KickTimersModule$definition$1$1$1> continuation) {
        super(2, continuation);
        this.$interval = i;
        this.this$0 = kickTimersModule;
        this.$intervalID = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KickTimersModule$definition$1$1$1(this.$interval, this.this$0, this.$intervalID, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KickTimersModule$definition$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0037  */
    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:12:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:14:0x0037
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r6)
            goto L29
        Lf:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L17:
            kotlin.ResultKt.throwOnFailure(r6)
        L1a:
            int r6 = r5.$interval
            long r3 = (long) r6
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.label = r2
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L29
            return r0
        L29:
            expo.modules.kicktimers.KickTimersModule r6 = r5.this$0
            java.util.Map r6 = r6.getIntervals()
            java.lang.String r1 = r5.$intervalID
            boolean r6 = r6.containsKey(r1)
            if (r6 != 0) goto L3a
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L3a:
            expo.modules.kicktimers.KickTimersModule r6 = r5.this$0
            java.lang.String r1 = "intervalId"
            java.lang.String r3 = r5.$intervalID
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r3)
            java.util.Map r1 = kotlin.collections.MapsKt.mapOf(r1)
            java.lang.String r3 = "onInterval"
            r6.sendEvent(r3, r1)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kicktimers.KickTimersModule$definition$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
