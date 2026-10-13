package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.config.CameraGraphScope;
import androidx.camera.camera2.pipe.core.MutexToken;
import androidx.camera.camera2.pipe.core.MutexesKt;
import androidx.camera.camera2.pipe.core.Token;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.interfaces.permissions.PermissionsResponse;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: GraphSessionLock.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u000bJV\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u001021\u0010\u0011\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\\\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u001027\u0010\u0011\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\r0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0000¢\u0006\u0004\b\u001a\u0010\u0018JJ\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102'\u0010\u001c\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\u0002\b\u001dH\u0002¢\u0006\u0002\u0010\u0018J<\u0010\u001e\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u00072\"\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0082@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "acquireToken", "Landroidx/camera/camera2/pipe/core/Token;", "acquireToken$camera_camera2_pipe", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAcquireToken", "tryAcquireToken$camera_camera2_pipe", "withTokenIn", "Lkotlinx/coroutines/Deferred;", ExifInterface.GPS_DIRECTION_TRUE, PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "token", "Lkotlin/coroutines/Continuation;", "withTokenIn$camera_camera2_pipe", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "withTokenInAsync", "withTokenInAsync$camera_camera2_pipe", "asyncUndispatched", "block", "Lkotlin/ExtensionFunctionType;", "use", "(Landroidx/camera/camera2/pipe/core/Token;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GraphSessionLock {
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.internal.GraphSessionLock$use$1, reason: invalid class name */
    /* JADX INFO: compiled from: GraphSessionLock.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.internal.GraphSessionLock", f = "GraphSessionLock.kt", i = {0}, l = {98}, m = "use", n = {"$this$use"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GraphSessionLock.this.use(null, null, this);
        }
    }

    @Inject
    public GraphSessionLock() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object acquireToken$camera_camera2_pipe(Continuation<? super Token> continuation) {
        GraphSessionLock$acquireToken$1 graphSessionLock$acquireToken$1;
        Mutex mutex;
        if (continuation instanceof GraphSessionLock$acquireToken$1) {
            graphSessionLock$acquireToken$1 = (GraphSessionLock$acquireToken$1) continuation;
            if ((graphSessionLock$acquireToken$1.label & Integer.MIN_VALUE) != 0) {
                graphSessionLock$acquireToken$1.label -= Integer.MIN_VALUE;
            } else {
                graphSessionLock$acquireToken$1 = new GraphSessionLock$acquireToken$1(this, continuation);
            }
        } else {
            graphSessionLock$acquireToken$1 = new GraphSessionLock$acquireToken$1(this, continuation);
        }
        Object obj = graphSessionLock$acquireToken$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = graphSessionLock$acquireToken$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            graphSessionLock$acquireToken$1.L$0 = mutex;
            graphSessionLock$acquireToken$1.label = 1;
            if (Mutex.DefaultImpls.lock$default(mutex, null, graphSessionLock$acquireToken$1, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) graphSessionLock$acquireToken$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new MutexToken(mutex);
    }

    public final Token tryAcquireToken$camera_camera2_pipe() {
        return MutexesKt.tryAcquireToken(this.mutex);
    }

    public final <T> Deferred<T> withTokenIn$camera_camera2_pipe(CoroutineScope scope, Function2<? super Token, ? super Continuation<? super T>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(action, "action");
        return asyncUndispatched(scope, new GraphSessionLock$withTokenIn$1(this, action, null));
    }

    public final <T> Deferred<T> withTokenInAsync$camera_camera2_pipe(CoroutineScope scope, Function2<? super Token, ? super Continuation<? super Deferred<? extends T>>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(action, "action");
        return asyncUndispatched(scope, new GraphSessionLock$withTokenInAsync$1(this, action, null));
    }

    private final <T> Deferred<T> asyncUndispatched(CoroutineScope scope, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        final CompletableJob completableJobJob = JobKt.Job((Job) scope.getCoroutineContext().get(Job.INSTANCE));
        Deferred<T> deferredAsync = BuildersKt.async(scope, scope.getCoroutineContext().plus(completableJobJob), CoroutineStart.UNDISPATCHED, new GraphSessionLock$asyncUndispatched$result$1(block, null));
        deferredAsync.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.pipe.internal.GraphSessionLock$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GraphSessionLock.asyncUndispatched$lambda$0(completableJobJob, (Throwable) obj);
            }
        });
        return deferredAsync;
    }

    static final Unit asyncUndispatched$lambda$0(CompletableJob completableJob, Throwable th) {
        completableJob.complete();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <T> Object use(Token token, Function2<? super Token, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objInvoke = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                anonymousClass1.L$0 = token;
                anonymousClass1.label = 1;
                objInvoke = function2.invoke(token, anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                token = (Token) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            token.release();
            return objInvoke;
        } catch (Throwable th) {
            token.release();
            throw th;
        }
    }
}
