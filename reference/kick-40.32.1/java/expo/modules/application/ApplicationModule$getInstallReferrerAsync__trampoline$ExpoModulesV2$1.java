package expo.modules.application;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ApplicationModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.application.ApplicationModule$getInstallReferrerAsync__trampoline$ExpoModulesV2$1", f = "ApplicationModule.kt", i = {}, l = {-1}, m = "invokeSuspend", n = {}, s = {})
final class ApplicationModule$getInstallReferrerAsync__trampoline$ExpoModulesV2$1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
    int label;
    final /* synthetic */ ApplicationModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApplicationModule$getInstallReferrerAsync__trampoline$ExpoModulesV2$1(ApplicationModule applicationModule, Continuation<? super ApplicationModule$getInstallReferrerAsync__trampoline$ExpoModulesV2$1> continuation) {
        super(1, continuation);
        this.this$0 = applicationModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ApplicationModule$getInstallReferrerAsync__trampoline$ExpoModulesV2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
        return invoke2((Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<Object> continuation) {
        return ((ApplicationModule$getInstallReferrerAsync__trampoline$ExpoModulesV2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object installReferrerAsync = this.this$0.getInstallReferrerAsync(this);
        return installReferrerAsync == coroutine_suspended ? coroutine_suspended : installReferrerAsync;
    }
}
