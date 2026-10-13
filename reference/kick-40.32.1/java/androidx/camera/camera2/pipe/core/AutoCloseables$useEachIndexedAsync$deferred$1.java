package androidx.camera.camera2.pipe.core;

import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.YieldKt;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: AutoCloseables.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
@DebugMetadata(c = "androidx.camera.camera2.pipe.core.AutoCloseables$useEachIndexedAsync$deferred$1", f = "AutoCloseables.kt", i = {0}, l = {103, 107}, m = "invokeSuspend", n = {"it"}, s = {"L$2"}, v = 1)
public final class AutoCloseables$useEachIndexedAsync$deferred$1<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function4<CoroutineScope, Integer, T, Continuation<? super R>, Object> $action;

    /* JADX INFO: Incorrect field signature: TT; */
    final /* synthetic */ AutoCloseable $closeable;
    final /* synthetic */ int $i;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/jvm/functions/Function4<-Lkotlinx/coroutines/CoroutineScope;-Ljava/lang/Integer;-TT;-Lkotlin/coroutines/Continuation<-TR;>;+Ljava/lang/Object;>;ILkotlin/coroutines/Continuation<-Landroidx/camera/camera2/pipe/core/AutoCloseables$useEachIndexedAsync$deferred$1;>;)V */
    public AutoCloseables$useEachIndexedAsync$deferred$1(AutoCloseable autoCloseable, Function4 function4, int i, Continuation continuation) {
        super(2, continuation);
        this.$closeable = autoCloseable;
        this.$action = function4;
        this.$i = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutoCloseables$useEachIndexedAsync$deferred$1(this.$closeable, this.$action, this.$i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((AutoCloseables$useEachIndexedAsync$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AutoCloseable autoCloseable;
        Function4 function4;
        int i;
        AutoCloseable autoCloseable2;
        Throwable th;
        AutoCloseable autoCloseable3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                i = this.I$0;
                autoCloseable2 = (AutoCloseable) this.L$2;
                function4 = (Function4) this.L$1;
                AutoCloseable autoCloseable4 = (AutoCloseable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    autoCloseable = autoCloseable4;
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseable3 = autoCloseable4;
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                autoCloseable3 = (AutoCloseable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    AutoCloseableKt.closeFinally(autoCloseable3, null);
                    return obj;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            try {
                throw th;
            } catch (Throwable th4) {
                AutoCloseableKt.closeFinally(autoCloseable3, th);
                throw th4;
            }
        }
        ResultKt.throwOnFailure(obj);
        autoCloseable = this.$closeable;
        function4 = this.$action;
        i = this.$i;
        try {
            this.L$0 = autoCloseable;
            this.L$1 = function4;
            this.L$2 = autoCloseable;
            this.I$0 = i;
            this.label = 1;
            if (YieldKt.yield(this) != coroutine_suspended) {
                autoCloseable2 = autoCloseable;
            }
            return coroutine_suspended;
        } catch (Throwable th5) {
            AutoCloseable autoCloseable5 = autoCloseable;
            th = th5;
            autoCloseable3 = autoCloseable5;
        }
        AutoCloseables$useEachIndexedAsync$deferred$1$1$1 autoCloseables$useEachIndexedAsync$deferred$1$1$1 = new AutoCloseables$useEachIndexedAsync$deferred$1$1$1(function4, i, autoCloseable2, null);
        this.L$0 = autoCloseable;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(autoCloseables$useEachIndexedAsync$deferred$1$1$1, this);
        if (objCoroutineScope != coroutine_suspended) {
            AutoCloseable autoCloseable6 = autoCloseable;
            obj = objCoroutineScope;
            autoCloseable3 = autoCloseable6;
            AutoCloseableKt.closeFinally(autoCloseable3, null);
            return obj;
        }
        return coroutine_suspended;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        AutoCloseable autoCloseable = this.$closeable;
        Function4<CoroutineScope, Integer, T, Continuation<? super R>, Object> function4 = this.$action;
        int i = this.$i;
        try {
            YieldKt.yield(null);
            Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AutoCloseables$useEachIndexedAsync$deferred$1$1$1(function4, i, autoCloseable, null), null);
            AutoCloseableKt.closeFinally(autoCloseable, null);
            return objCoroutineScope;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(autoCloseable, th);
                throw th2;
            }
        }
    }
}
