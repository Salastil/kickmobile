package io.github.expo.modules.v2.async;

import io.github.expo.modules.v2.types.TypeDescriptor;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Promise.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.github.expo.modules.v2.async.Promise$launch$1$1", f = "Promise.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class Promise$launch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<Object>, Object> $block;
    final /* synthetic */ boolean $buffered;
    final /* synthetic */ TypeDescriptor $type;
    Object L$0;
    int label;
    final /* synthetic */ Promise this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Promise$launch$1$1(Promise promise, Function1<? super Continuation<Object>, ? extends Object> function1, TypeDescriptor typeDescriptor, boolean z, Continuation<? super Promise$launch$1$1> continuation) {
        super(2, continuation);
        this.this$0 = promise;
        this.$block = function1;
        this.$type = typeDescriptor;
        this.$buffered = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Promise$launch$1$1(this.this$0, this.$block, this.$type, this.$buffered, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Promise$launch$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Promise promise;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Promise promise2 = this.this$0;
                Function1<Continuation<Object>, Object> function1 = this.$block;
                this.L$0 = promise2;
                this.label = 1;
                Object objInvoke = function1.invoke(this);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                promise = promise2;
                obj = objInvoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                promise = (Promise) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            promise.resolve(obj, this.$type, this.$buffered);
        } catch (CancellationException e) {
            this.this$0.reject(e);
            throw e;
        } catch (Throwable th) {
            this.this$0.reject(th);
        }
        return Unit.INSTANCE;
    }
}
