package com.kick.imagecache;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$3"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.kick.imagecache.KickImageCacheModule$definition$lambda$0$$inlined$Coroutine$2", f = "KickImageCacheModule.kt", i = {0, 0, 0, 0, 0}, l = {271}, m = "invokeSuspend", n = {"<destruct>", "p0", "$completion", "urlString", "$i$a$-Coroutine-KickImageCacheModule$definition$1$3"}, nl = {272}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
public final class KickImageCacheModule$definition$lambda$0$$inlined$Coroutine$2 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ KickImageCacheModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KickImageCacheModule$definition$lambda$0$$inlined$Coroutine$2(Continuation continuation, KickImageCacheModule kickImageCacheModule) {
        super(3, continuation);
        this.this$0 = kickImageCacheModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        KickImageCacheModule$definition$lambda$0$$inlined$Coroutine$2 kickImageCacheModule$definition$lambda$0$$inlined$Coroutine$2 = new KickImageCacheModule$definition$lambda$0$$inlined$Coroutine$2(continuation, this.this$0);
        kickImageCacheModule$definition$lambda$0$$inlined$Coroutine$2.L$0 = objArr;
        return kickImageCacheModule$definition$lambda$0$$inlined$Coroutine$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object[] objArr = (Object[]) this.L$0;
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
        Object obj2 = objArr[0];
        String str = (String) obj2;
        CoroutineDispatcher io2 = Dispatchers.getIO();
        KickImageCacheModule$definition$1$3$1 kickImageCacheModule$definition$1$3$1 = new KickImageCacheModule$definition$1$3$1(str, this.this$0, null);
        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
        this.L$2 = SpillingKt.nullOutSpilledVariable(this);
        this.L$3 = SpillingKt.nullOutSpilledVariable(str);
        this.I$0 = 0;
        this.label = 1;
        Object objWithContext = BuildersKt.withContext(io2, kickImageCacheModule$definition$1$3$1, this);
        return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
    }
}
