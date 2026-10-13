package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.core.MutexToken;
import androidx.camera.camera2.pipe.core.MutexesKt;
import androidx.camera.camera2.pipe.core.Token;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: GraphSessionLock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.pipe.internal.GraphSessionLock$withTokenIn$1", f = "GraphSessionLock.kt", i = {0}, l = {105, 54}, m = "invokeSuspend", n = {"$this$acquireTokenAndSuspend$iv"}, s = {"L$0"}, v = 1)
final class GraphSessionLock$withTokenIn$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function2<Token, Continuation<? super T>, Object> $action;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GraphSessionLock this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    GraphSessionLock$withTokenIn$1(GraphSessionLock graphSessionLock, Function2<? super Token, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super GraphSessionLock$withTokenIn$1> continuation) {
        super(2, continuation);
        this.this$0 = graphSessionLock;
        this.$action = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GraphSessionLock$withTokenIn$1(this.this$0, this.$action, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((GraphSessionLock$withTokenIn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GraphSessionLock graphSessionLock;
        Mutex mutex;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            graphSessionLock = this.this$0;
            Mutex mutex2 = graphSessionLock.mutex;
            this.L$0 = mutex2;
            this.L$1 = graphSessionLock;
            this.label = 1;
            if (MutexesKt.lockAndSuspend(mutex2, this) != coroutine_suspended) {
                mutex = mutex2;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        graphSessionLock = (GraphSessionLock) this.L$1;
        mutex = (Mutex) this.L$0;
        ResultKt.throwOnFailure(obj);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        Object objUse = graphSessionLock.use(new MutexToken(mutex), new AnonymousClass1(this.$action, null), this);
        return objUse == coroutine_suspended ? coroutine_suspended : objUse;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.internal.GraphSessionLock$withTokenIn$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: GraphSessionLock.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "token", "Landroidx/camera/camera2/pipe/core/Token;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.internal.GraphSessionLock$withTokenIn$1$1", f = "GraphSessionLock.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Token, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<Token, Continuation<? super T>, Object> $action;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super Token, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$action = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$action, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Token token, Continuation<? super T> continuation) {
            return ((AnonymousClass1) create(token, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Token token = (Token) this.L$0;
            Function2<Token, Continuation<? super T>, Object> function2 = this.$action;
            this.label = 1;
            Object objInvoke = function2.invoke(token, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }
}
