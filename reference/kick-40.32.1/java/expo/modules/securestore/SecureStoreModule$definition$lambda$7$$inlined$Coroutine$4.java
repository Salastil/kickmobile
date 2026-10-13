package expo.modules.securestore;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$7"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.securestore.SecureStoreModule$definition$lambda$7$$inlined$Coroutine$4", f = "SecureStoreModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {272}, m = "invokeSuspend", n = {"<destruct>", "p0", "p1", "p2", "$completion", "options", "key", "value", "$i$a$-Coroutine-SecureStoreModule$definition$1$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
public final class SecureStoreModule$definition$lambda$7$$inlined$Coroutine$4 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ SecureStoreModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecureStoreModule$definition$lambda$7$$inlined$Coroutine$4(Continuation continuation, SecureStoreModule secureStoreModule) {
        super(3, continuation);
        this.this$0 = secureStoreModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        SecureStoreModule$definition$lambda$7$$inlined$Coroutine$4 secureStoreModule$definition$lambda$7$$inlined$Coroutine$4 = new SecureStoreModule$definition$lambda$7$$inlined$Coroutine$4(continuation, this.this$0);
        secureStoreModule$definition$lambda$7$$inlined$Coroutine$4.L$0 = objArr;
        return secureStoreModule$definition$lambda$7$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws NullKeyException {
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            Object obj4 = objArr[2];
            SecureStoreModule$definition$lambda$7$$inlined$Coroutine$4 secureStoreModule$definition$lambda$7$$inlined$Coroutine$4 = this;
            SecureStoreOptions secureStoreOptions = (SecureStoreOptions) obj4;
            String str = (String) obj3;
            String str2 = (String) obj2;
            if (str == null) {
                throw new NullKeyException();
            }
            SecureStoreModule secureStoreModule = this.this$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
            this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
            this.L$4 = SpillingKt.nullOutSpilledVariable(secureStoreModule$definition$lambda$7$$inlined$Coroutine$4);
            this.L$5 = SpillingKt.nullOutSpilledVariable(secureStoreOptions);
            this.L$6 = SpillingKt.nullOutSpilledVariable(str);
            this.L$7 = SpillingKt.nullOutSpilledVariable(str2);
            this.I$0 = 0;
            this.label = 1;
            if (secureStoreModule.setItemImpl(str, str2, secureStoreOptions, false, this) == coroutine_suspended) {
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
