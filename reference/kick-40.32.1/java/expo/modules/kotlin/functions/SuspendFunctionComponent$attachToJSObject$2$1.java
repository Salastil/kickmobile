package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.PromiseImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: SuspendFunctionComponent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.kotlin.functions.SuspendFunctionComponent$attachToJSObject$2$1", f = "SuspendFunctionComponent.kt", i = {0, 0, 0, 0, 0, 0}, l = {47}, m = "invokeSuspend", n = {"$this$launch", "$this$exceptionDecorator$iv", "$completion", "$this$invokeSuspend_u24lambda_u241", "$i$f$exceptionDecorator", "$i$a$-exceptionDecorator-SuspendFunctionComponent$attachToJSObject$2$1$2"}, nl = {48}, s = {"L$0", "L$1", "L$5", "L$6", "I$0", "I$1"}, v = 2)
final class SuspendFunctionComponent$attachToJSObject$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppContext $appContext;
    final /* synthetic */ Object[] $args;
    final /* synthetic */ String $moduleName;
    final /* synthetic */ PromiseImpl $promiseImpl;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ SuspendFunctionComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuspendFunctionComponent$attachToJSObject$2$1(PromiseImpl promiseImpl, SuspendFunctionComponent suspendFunctionComponent, String str, Object[] objArr, AppContext appContext, Continuation<? super SuspendFunctionComponent$attachToJSObject$2$1> continuation) {
        super(2, continuation);
        this.$promiseImpl = promiseImpl;
        this.this$0 = suspendFunctionComponent;
        this.$moduleName = str;
        this.$args = objArr;
        this.$appContext = appContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuspendFunctionComponent$attachToJSObject$2$1 suspendFunctionComponent$attachToJSObject$2$1 = new SuspendFunctionComponent$attachToJSObject$2$1(this.$promiseImpl, this.this$0, this.$moduleName, this.$args, this.$appContext, continuation);
        suspendFunctionComponent$attachToJSObject$2$1.L$0 = obj;
        return suspendFunctionComponent$attachToJSObject$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuspendFunctionComponent$attachToJSObject$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0097 A[Catch: all -> 0x00cc, TryCatch #2 {all -> 0x00cc, blocks: (B:25:0x0093, B:27:0x0097, B:29:0x009b, B:32:0x00c0, B:33:0x00cb, B:30:0x00b5, B:31:0x00bd, B:13:0x0039), top: B:52:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x009b A[Catch: all -> 0x00cc, TryCatch #2 {all -> 0x00cc, blocks: (B:25:0x0093, B:27:0x0097, B:29:0x009b, B:32:0x00c0, B:33:0x00cb, B:30:0x00b5, B:31:0x00bd, B:13:0x0039), top: B:52:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b5 A[Catch: all -> 0x00cc, TryCatch #2 {all -> 0x00cc, blocks: (B:25:0x0093, B:27:0x0097, B:29:0x009b, B:32:0x00c0, B:33:0x00cb, B:30:0x00b5, B:31:0x00bd, B:13:0x0039), top: B:52:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00bd A[Catch: all -> 0x00cc, TryCatch #2 {all -> 0x00cc, blocks: (B:25:0x0093, B:27:0x0097, B:29:0x009b, B:32:0x00c0, B:33:0x00cb, B:30:0x00b5, B:31:0x00bd, B:13:0x0039), top: B:52:0x0039 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        SuspendFunctionComponent suspendFunctionComponent;
        PromiseImpl promiseImpl;
        UnexpectedException unexpectedException;
        Throwable th;
        UnexpectedException unexpectedException2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                SuspendFunctionComponent suspendFunctionComponent2 = this.this$0;
                str = this.$moduleName;
                Object[] objArr = this.$args;
                AppContext appContext = this.$appContext;
                PromiseImpl promiseImpl2 = this.$promiseImpl;
                try {
                    Function3 function3 = suspendFunctionComponent2.body;
                    Object[] objArrConvertArgs$default = AnyFunction.convertArgs$default(suspendFunctionComponent2, objArr, appContext, false, 4, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$2 = suspendFunctionComponent2;
                    this.L$3 = str;
                    this.L$4 = promiseImpl2;
                    this.L$5 = SpillingKt.nullOutSpilledVariable(this);
                    this.L$6 = coroutineScope;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    Object objInvoke = function3.invoke(coroutineScope, objArrConvertArgs$default, this);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    suspendFunctionComponent = suspendFunctionComponent2;
                    obj = objInvoke;
                    promiseImpl = promiseImpl2;
                } catch (Throwable th2) {
                    th = th2;
                    suspendFunctionComponent = suspendFunctionComponent2;
                    th = th;
                    if (!(th instanceof CodedException)) {
                        unexpectedException2 = (CodedException) th;
                    } else if (th instanceof expo.modules.core.errors.CodedException) {
                        unexpectedException2 = new CodedException(((expo.modules.core.errors.CodedException) th).getCode(), ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                    } else {
                        unexpectedException2 = new UnexpectedException(th);
                    }
                    throw new FunctionCallException(suspendFunctionComponent.getName(), str, unexpectedException2);
                }
            } catch (Throwable th3) {
                if (this.$promiseImpl.getWasSettled$expo_modules_core_release()) {
                    throw th3;
                }
                PromiseImpl promiseImpl3 = this.$promiseImpl;
                if (th3 instanceof CodedException) {
                    unexpectedException = (CodedException) th3;
                } else if (th3 instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th3;
                    unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th3);
                }
                promiseImpl3.reject(unexpectedException);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$6;
            promiseImpl = (PromiseImpl) this.L$4;
            str = (String) this.L$3;
            suspendFunctionComponent = (SuspendFunctionComponent) this.L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
                th = th;
                if (!(th instanceof CodedException)) {
                    unexpectedException2 = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    unexpectedException2 = new CodedException(((expo.modules.core.errors.CodedException) th).getCode(), ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                } else {
                    unexpectedException2 = new UnexpectedException(th);
                }
                throw new FunctionCallException(suspendFunctionComponent.getName(), str, unexpectedException2);
            }
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            promiseImpl.resolve(obj);
        }
        Unit unit = Unit.INSTANCE;
        return Unit.INSTANCE;
    }
}
