package expo.modules.updates;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: UpdatesPackage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1", f = "UpdatesPackage.kt", i = {}, l = {80, EACTags.ANSWER_TO_RESET}, m = "invokeSuspend", n = {}, nl = {EACTags.ANSWER_TO_RESET, EACTags.HISTORICAL_BYTES}, s = {}, v = 2)
final class UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $useDeveloperSupport;
    final /* synthetic */ Runnable $whenReadyRunnable;
    int label;
    final /* synthetic */ UpdatesPackage$createReactActivityHandlers$handler$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1(UpdatesPackage$createReactActivityHandlers$handler$1 updatesPackage$createReactActivityHandlers$handler$1, Context context, boolean z, Runnable runnable, Continuation<? super UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1> continuation) {
        super(2, continuation);
        this.this$0 = updatesPackage$createReactActivityHandlers$handler$1;
        this.$context = context;
        this.$useDeveloperSupport = z;
        this.$whenReadyRunnable = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1(this.this$0, this.$context, this.$useDeveloperSupport, this.$whenReadyRunnable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if (r7.invokeReadyRunnable(r1, r6) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L36
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1 r7 = r6.this$0
            android.content.Context r1 = r6.$context
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r4 = r6.$useDeveloperSupport
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.label = r3
            java.lang.Object r7 = expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1.access$startUpdatesController(r7, r1, r4, r5)
            if (r7 != r0) goto L36
            goto L48
        L36:
            expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1 r7 = r6.this$0
            java.lang.Runnable r1 = r6.$whenReadyRunnable
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.label = r2
            java.lang.Object r6 = expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1.access$invokeReadyRunnable(r7, r1, r3)
            if (r6 != r0) goto L49
        L48:
            return r0
        L49:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
