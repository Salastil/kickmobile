package expo.modules.crypto;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: CryptoModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.crypto.CryptoModule$digestStringAsync__trampoline$ExpoModulesV2$1", f = "CryptoModule.kt", i = {}, l = {-1}, m = "invokeSuspend", n = {}, s = {})
final class CryptoModule$digestStringAsync__trampoline$ExpoModulesV2$1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
    final /* synthetic */ Ref.ObjectRef<DigestAlgorithm> $v0;
    final /* synthetic */ Ref.ObjectRef<String> $v1;
    final /* synthetic */ Ref.ObjectRef<DigestOptions> $v2;
    int label;
    final /* synthetic */ CryptoModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CryptoModule$digestStringAsync__trampoline$ExpoModulesV2$1(CryptoModule cryptoModule, Ref.ObjectRef<DigestAlgorithm> objectRef, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<DigestOptions> objectRef3, Continuation<? super CryptoModule$digestStringAsync__trampoline$ExpoModulesV2$1> continuation) {
        super(1, continuation);
        this.this$0 = cryptoModule;
        this.$v0 = objectRef;
        this.$v1 = objectRef2;
        this.$v2 = objectRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new CryptoModule$digestStringAsync__trampoline$ExpoModulesV2$1(this.this$0, this.$v0, this.$v1, this.$v2, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
        return invoke2((Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<Object> continuation) {
        return ((CryptoModule$digestStringAsync__trampoline$ExpoModulesV2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object objDigestStringAsync = this.this$0.digestStringAsync(this.$v0.element, this.$v1.element, this.$v2.element, this);
        return objDigestStringAsync == coroutine_suspended ? coroutine_suspended : objDigestStringAsync;
    }
}
