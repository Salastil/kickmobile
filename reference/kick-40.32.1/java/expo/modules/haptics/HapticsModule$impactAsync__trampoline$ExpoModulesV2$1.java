package expo.modules.haptics;

import expo.modules.haptics.arguments.ImpactStyle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: HapticsModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.haptics.HapticsModule$impactAsync__trampoline$ExpoModulesV2$1", f = "HapticsModule.kt", i = {}, l = {-1}, m = "invokeSuspend", n = {}, s = {})
final class HapticsModule$impactAsync__trampoline$ExpoModulesV2$1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
    final /* synthetic */ Ref.ObjectRef<ImpactStyle> $v0;
    int label;
    final /* synthetic */ HapticsModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HapticsModule$impactAsync__trampoline$ExpoModulesV2$1(HapticsModule hapticsModule, Ref.ObjectRef<ImpactStyle> objectRef, Continuation<? super HapticsModule$impactAsync__trampoline$ExpoModulesV2$1> continuation) {
        super(1, continuation);
        this.this$0 = hapticsModule;
        this.$v0 = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HapticsModule$impactAsync__trampoline$ExpoModulesV2$1(this.this$0, this.$v0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
        return invoke2((Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<Object> continuation) {
        return ((HapticsModule$impactAsync__trampoline$ExpoModulesV2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.impactAsync(this.$v0.element, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
