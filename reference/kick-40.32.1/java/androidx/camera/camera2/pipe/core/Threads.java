package androidx.camera.camera2.pipe.core;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: Threads.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020&2\u001c\u0010'\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H$0)\u0012\u0006\u0012\u0004\u0018\u00010\u00010(¢\u0006\u0002\u0010*J9\u0010+\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020&2\u001c\u0010'\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H$0)\u0012\u0006\u0012\u0004\u0018\u00010\u00010(¢\u0006\u0002\u0010*J?\u0010,\u001a\b\u0012\u0004\u0012\u0002H$0-\"\u0004\b\u0000\u0010$2\u0006\u0010.\u001a\u00020\b2\u001c\u0010'\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H$0)\u0012\u0006\u0012\u0004\u0018\u00010\u00010(H\u0002¢\u0006\u0002\u0010/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0016¨\u00060"}, d2 = {"Landroidx/camera/camera2/pipe/core/Threads;", "", "cameraPipeScope", "Lkotlinx/coroutines/CoroutineScope;", "cameraPipeDispatchScope", "blockingExecutor", "Ljava/util/concurrent/Executor;", "blockingDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "backgroundExecutor", "backgroundDispatcher", "lightweightExecutor", "lightweightDispatcher", "camera2Handler", "Lkotlin/Function0;", "Landroid/os/Handler;", "camera2Executor", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/Executor;Lkotlinx/coroutines/CoroutineDispatcher;Ljava/util/concurrent/Executor;Lkotlinx/coroutines/CoroutineDispatcher;Ljava/util/concurrent/Executor;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getCameraPipeScope", "()Lkotlinx/coroutines/CoroutineScope;", "getBlockingExecutor", "()Ljava/util/concurrent/Executor;", "getBlockingDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getBackgroundExecutor", "getBackgroundDispatcher", "getLightweightExecutor", "getLightweightDispatcher", "_camera2Handler", "Lkotlin/Lazy;", "_camera2Executor", "getCamera2Handler", "()Landroid/os/Handler;", "getCamera2Executor", "runBlockingChecked", ExifInterface.GPS_DIRECTION_TRUE, "timeoutMs", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "runBlockingCheckedOrNull", "runAsyncSupervised", "Lkotlinx/coroutines/Deferred;", "dispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Deferred;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Threads {
    private final Lazy<Executor> _camera2Executor;
    private final Lazy<Handler> _camera2Handler;
    private final CoroutineDispatcher backgroundDispatcher;
    private final Executor backgroundExecutor;
    private final CoroutineDispatcher blockingDispatcher;
    private final Executor blockingExecutor;
    private final CoroutineScope cameraPipeDispatchScope;
    private final CoroutineScope cameraPipeScope;
    private final CoroutineDispatcher lightweightDispatcher;
    private final Executor lightweightExecutor;

    public Threads(CoroutineScope cameraPipeScope, CoroutineScope cameraPipeDispatchScope, Executor blockingExecutor, CoroutineDispatcher blockingDispatcher, Executor backgroundExecutor, CoroutineDispatcher backgroundDispatcher, Executor lightweightExecutor, CoroutineDispatcher lightweightDispatcher, final Function0<? extends Handler> camera2Handler, final Function0<? extends Executor> camera2Executor) {
        Intrinsics.checkNotNullParameter(cameraPipeScope, "cameraPipeScope");
        Intrinsics.checkNotNullParameter(cameraPipeDispatchScope, "cameraPipeDispatchScope");
        Intrinsics.checkNotNullParameter(blockingExecutor, "blockingExecutor");
        Intrinsics.checkNotNullParameter(blockingDispatcher, "blockingDispatcher");
        Intrinsics.checkNotNullParameter(backgroundExecutor, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(lightweightExecutor, "lightweightExecutor");
        Intrinsics.checkNotNullParameter(lightweightDispatcher, "lightweightDispatcher");
        Intrinsics.checkNotNullParameter(camera2Handler, "camera2Handler");
        Intrinsics.checkNotNullParameter(camera2Executor, "camera2Executor");
        this.cameraPipeScope = cameraPipeScope;
        this.cameraPipeDispatchScope = cameraPipeDispatchScope;
        this.blockingExecutor = blockingExecutor;
        this.blockingDispatcher = blockingDispatcher;
        this.backgroundExecutor = backgroundExecutor;
        this.backgroundDispatcher = backgroundDispatcher;
        this.lightweightExecutor = lightweightExecutor;
        this.lightweightDispatcher = lightweightDispatcher;
        this._camera2Handler = kotlin.LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.pipe.core.Threads$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Threads._camera2Handler$lambda$0(camera2Handler);
            }
        });
        this._camera2Executor = kotlin.LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.pipe.core.Threads$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Threads._camera2Executor$lambda$0(camera2Executor);
            }
        });
    }

    public final CoroutineScope getCameraPipeScope() {
        return this.cameraPipeScope;
    }

    public final Executor getBlockingExecutor() {
        return this.blockingExecutor;
    }

    public final CoroutineDispatcher getBlockingDispatcher() {
        return this.blockingDispatcher;
    }

    public final Executor getBackgroundExecutor() {
        return this.backgroundExecutor;
    }

    public final CoroutineDispatcher getBackgroundDispatcher() {
        return this.backgroundDispatcher;
    }

    public final Executor getLightweightExecutor() {
        return this.lightweightExecutor;
    }

    public final CoroutineDispatcher getLightweightDispatcher() {
        return this.lightweightDispatcher;
    }

    static final Handler _camera2Handler$lambda$0(Function0 function0) {
        return (Handler) function0.invoke();
    }

    static final Executor _camera2Executor$lambda$0(Function0 function0) {
        return (Executor) function0.invoke();
    }

    public final Handler getCamera2Handler() {
        return this._camera2Handler.getValue();
    }

    public final Executor getCamera2Executor() {
        return this._camera2Executor.getValue();
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.Threads$runBlockingChecked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Threads.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.Threads$runBlockingChecked$1", f = "Threads.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02121<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
        final /* synthetic */ long $timeoutMs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02121(Function1<? super Continuation<? super T>, ? extends Object> function1, long j, Continuation<? super C02121> continuation) {
            super(2, continuation);
            this.$block = function1;
            this.$timeoutMs = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Threads.this.new C02121(this.$block, this.$timeoutMs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C02121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                Threads threads = Threads.this;
                Deferred deferredRunAsyncSupervised = threads.runAsyncSupervised(threads.getBackgroundDispatcher(), this.$block);
                this.label = 1;
                Object objWithTimeout = TimeoutKt.withTimeout(this.$timeoutMs, new C00041(deferredRunAsyncSupervised, null), this);
                return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
            } catch (TimeoutCancellationException unused) {
                Log log = Log.INSTANCE;
                long j = this.$timeoutMs;
                Function1<Continuation<? super T>, Object> function1 = this.$block;
                if (log.getERROR_LOGGABLE()) {
                    android.util.Log.e(Log.TAG, "Timed out after " + j + "ms running " + function1 + '!');
                }
                throw new IllegalStateException("Timed out after " + this.$timeoutMs + "ms running " + this.$block + '!');
            }
        }

        /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.Threads$runBlockingChecked$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Threads.kt */
        @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.camera.camera2.pipe.core.Threads$runBlockingChecked$1$1", f = "Threads.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C00041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
            final /* synthetic */ Deferred<T> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00041(Deferred<? extends T> deferred, Continuation<? super C00041> continuation) {
                super(2, continuation);
                this.$result = deferred;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00041(this.$result, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
                return ((C00041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object objAwait = this.$result.await(this);
                return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
            }
        }
    }

    public final <T> T runBlockingChecked(long timeoutMs, Function1<? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return (T) BuildersKt.runBlocking(this.blockingDispatcher, new C02121(block, timeoutMs, null));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.Threads$runBlockingCheckedOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Threads.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.Threads$runBlockingCheckedOrNull$1", f = "Threads.kt", i = {}, l = {JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02131<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
        final /* synthetic */ long $timeoutMs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02131(Function1<? super Continuation<? super T>, ? extends Object> function1, long j, Continuation<? super C02131> continuation) {
            super(2, continuation);
            this.$block = function1;
            this.$timeoutMs = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Threads.this.new C02131(this.$block, this.$timeoutMs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C02131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Threads threads = Threads.this;
            Deferred deferredRunAsyncSupervised = threads.runAsyncSupervised(threads.getBackgroundDispatcher(), this.$block);
            this.label = 1;
            Object objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(this.$timeoutMs, new C00051(deferredRunAsyncSupervised, null), this);
            return objWithTimeoutOrNull == coroutine_suspended ? coroutine_suspended : objWithTimeoutOrNull;
        }

        /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.Threads$runBlockingCheckedOrNull$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Threads.kt */
        @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.camera.camera2.pipe.core.Threads$runBlockingCheckedOrNull$1$1", f = "Threads.kt", i = {}, l = {JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C00051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
            final /* synthetic */ Deferred<T> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00051(Deferred<? extends T> deferred, Continuation<? super C00051> continuation) {
                super(2, continuation);
                this.$result = deferred;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00051(this.$result, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
                return ((C00051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object objAwait = this.$result.await(this);
                return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
            }
        }
    }

    public final <T> T runBlockingCheckedOrNull(long timeoutMs, Function1<? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return (T) BuildersKt.runBlocking(this.blockingDispatcher, new C02131(block, timeoutMs, null));
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            if (!Log.INSTANCE.getINFO_LOGGABLE()) {
                return null;
            }
            android.util.Log.i(Log.TAG, "runBlockingCheckedOrNull cancelled by thread interruption", interruptedException);
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.core.Threads$runAsyncSupervised$1, reason: invalid class name */
    /* JADX INFO: compiled from: Threads.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.core.Threads$runAsyncSupervised$1", f = "Threads.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Function1<Continuation<? super T>, Object> function1 = this.$block;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Deferred<T> runAsyncSupervised(CoroutineDispatcher dispatcher, Function1<? super Continuation<? super T>, ? extends Object> block) {
        return BuildersKt__Builders_commonKt.async$default(this.cameraPipeDispatchScope, dispatcher, null, new AnonymousClass1(block, null), 2, null);
    }
}
