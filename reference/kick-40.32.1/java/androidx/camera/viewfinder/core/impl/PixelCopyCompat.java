package androidx.camera.viewfinder.core.impl;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.Surface;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Consumer;
import androidx.tracing.Trace;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;

/* JADX INFO: compiled from: PixelCopyCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \r2\u00020\u0001:\u0005\r\u000e\u000f\u0010\u0011J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&\u0082\u0001\u0003\u0012\u0013\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/camera/viewfinder/core/impl/PixelCopyCompat;", "", "requestImpl", "", "source", "Landroid/view/Surface;", "dest", "Landroid/graphics/Bitmap;", "executor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/core/util/Consumer;", "", "Companion", "PixelCopyApi24Impl", "PixelCopyApi34Impl", "PixelCopyStub", "CopyResultStatus", "Landroidx/camera/viewfinder/core/impl/PixelCopyCompat$PixelCopyApi24Impl;", "Landroidx/camera/viewfinder/core/impl/PixelCopyCompat$PixelCopyApi34Impl;", "Landroidx/camera/viewfinder/core/impl/PixelCopyCompat$PixelCopyStub;", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PixelCopyCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: PixelCopyCompat.kt */
    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/camera/viewfinder/core/impl/PixelCopyCompat$CopyResultStatus;", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CopyResultStatus {
    }

    @JvmStatic
    static void request(Surface surface, Bitmap bitmap, Executor executor, Consumer<Integer> consumer) {
        INSTANCE.request(surface, bitmap, executor, consumer);
    }

    @JvmStatic
    static int requestSync(Surface surface, Bitmap bitmap) {
        return INSTANCE.requestSync(surface, bitmap);
    }

    @JvmStatic
    static int requestSync(Surface surface, Bitmap bitmap, long j) {
        return INSTANCE.requestSync(surface, bitmap, j);
    }

    void requestImpl(Surface source, Bitmap dest, Executor executor, Consumer<Integer> listener);

    /* JADX INFO: compiled from: PixelCopyCompat.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J.\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0007R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/camera/viewfinder/core/impl/PixelCopyCompat$Companion;", "", "<init>", "()V", "requestSync", "", "source", "Landroid/view/Surface;", "dest", "Landroid/graphics/Bitmap;", "timeoutMs", "", "request", "", "executor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/core/util/Consumer;", "impl", "Landroidx/camera/viewfinder/core/impl/PixelCopyCompat;", "getImpl", "()Landroidx/camera/viewfinder/core/impl/PixelCopyCompat;", "impl$delegate", "Lkotlin/Lazy;", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: impl$delegate, reason: from kotlin metadata */
        private static final Lazy<PixelCopyCompat> impl = LazyKt.lazy(new Function0() { // from class: androidx.camera.viewfinder.core.impl.PixelCopyCompat$Companion$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PixelCopyCompat.Companion.impl_delegate$lambda$1();
            }
        });

        @JvmStatic
        public final int requestSync(Surface source, Bitmap dest) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            return requestSync$default(this, source, dest, 0L, 4, null);
        }

        private Companion() {
        }

        public static /* synthetic */ int requestSync$default(Companion companion, Surface surface, Bitmap bitmap, long j, int i, Object obj) {
            if ((i & 4) != 0) {
                j = -1;
            }
            return companion.requestSync(surface, bitmap, j);
        }

        @JvmStatic
        public final int requestSync(Surface source, Bitmap dest, long timeoutMs) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            Trace.beginSection("PixelCopyCompat.requestSync");
            try {
                final AtomicInt atomicIntAtomic = AtomicFU.atomic(2);
                final Semaphore semaphore = new Semaphore(0);
                $$INSTANCE.getImpl().requestImpl(source, dest, new PixelCopyCompat$Companion$$ExternalSyntheticLambda1(), new Consumer() { // from class: androidx.camera.viewfinder.core.impl.PixelCopyCompat$Companion$requestSync$1$2
                    @Override // androidx.core.util.Consumer
                    public final void accept(Integer num) {
                        AtomicInt atomicInt = atomicIntAtomic;
                        Intrinsics.checkNotNull(num);
                        atomicInt.setValue(num.intValue());
                        semaphore.release();
                    }
                });
                if (timeoutMs >= 0) {
                    semaphore.tryAcquire(timeoutMs, TimeUnit.MILLISECONDS);
                } else {
                    semaphore.acquire();
                }
                return atomicIntAtomic.getValue();
            } finally {
                Trace.endSection();
            }
        }

        @JvmStatic
        public final void request(Surface source, Bitmap dest, Executor executor, Consumer<Integer> listener) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(listener, "listener");
            getImpl().requestImpl(source, dest, executor, listener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PixelCopyCompat getImpl() {
            return impl.getValue();
        }

        static final PixelCopyCompat impl_delegate$lambda$1() {
            if (Build.VERSION.SDK_INT >= 34) {
                return PixelCopyApi34Impl.INSTANCE;
            }
            return PixelCopyApi24Impl.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PixelCopyCompat.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u000b\u001a\u00020\f2<\u0010\r\u001a8\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u000eH\u0002J.\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/camera/viewfinder/core/impl/PixelCopyCompat$PixelCopyApi24Impl;", "Landroidx/camera/viewfinder/core/impl/PixelCopyCompat;", "<init>", "()V", "KEEP_ALIVE_MILLIS", "", "lock", "", "_backgroundHandler", "Landroidx/camera/viewfinder/core/impl/RefCounted;", "Landroid/os/Handler;", "withHandlerScope", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "handler", "Lkotlin/Function0;", "onComplete", "requestImpl", "source", "Landroid/view/Surface;", "dest", "Landroid/graphics/Bitmap;", "executor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/core/util/Consumer;", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class PixelCopyApi24Impl implements PixelCopyCompat {
        public static final long KEEP_ALIVE_MILLIS = 500;
        private static RefCounted<Handler> _backgroundHandler;
        public static final PixelCopyApi24Impl INSTANCE = new PixelCopyApi24Impl();
        private static final Object lock = new Object();

        private PixelCopyApi24Impl() {
        }

        private final void withHandlerScope(Function2<? super Handler, ? super Function0<Unit>, Unit> action) {
            Pair pair;
            Handler handlerAcquire;
            synchronized (lock) {
                RefCounted<Handler> refCounted = _backgroundHandler;
                if (refCounted == null || (handlerAcquire = refCounted.acquire()) == null) {
                    final HandlerThread handlerThread = new HandlerThread("pixelCopyRequest Thread");
                    handlerThread.start();
                    Handler handlerCreateAsync = HandlerCompat.createAsync(handlerThread.getLooper());
                    Intrinsics.checkNotNullExpressionValue(handlerCreateAsync, "createAsync(...)");
                    RefCounted<Handler> refCounted2 = new RefCounted<>(false, new Function1() { // from class: androidx.camera.viewfinder.core.impl.PixelCopyCompat$PixelCopyApi24Impl$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PixelCopyCompat.PixelCopyApi24Impl.withHandlerScope$lambda$5$lambda$4$lambda$2(handlerThread, (Handler) obj);
                        }
                    });
                    refCounted2.initialize(handlerCreateAsync);
                    _backgroundHandler = refCounted2;
                    pair = new Pair(handlerCreateAsync, refCounted2);
                } else {
                    pair = new Pair(handlerAcquire, refCounted);
                }
            }
            Handler handler = (Handler) pair.component1();
            final RefCounted refCounted3 = (RefCounted) pair.component2();
            refCounted3.acquire();
            if (!handler.postDelayed(new Runnable() { // from class: androidx.camera.viewfinder.core.impl.PixelCopyCompat$PixelCopyApi24Impl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    refCounted3.release();
                }
            }, 500L)) {
                throw new AssertionError("Handler thread killed unexpectedly.");
            }
            action.invoke(handler, new PixelCopyCompat$PixelCopyApi24Impl$withHandlerScope$3(refCounted3));
        }

        static final Unit withHandlerScope$lambda$5$lambda$4$lambda$2(HandlerThread handlerThread, Handler it) {
            Intrinsics.checkNotNullParameter(it, "it");
            handlerThread.quit();
            return Unit.INSTANCE;
        }

        @Override // androidx.camera.viewfinder.core.impl.PixelCopyCompat
        public void requestImpl(final Surface source, final Bitmap dest, final Executor executor, final Consumer<Integer> listener) throws Throwable {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Trace.beginAsyncSection("PixelCopyApi24Impl.request", dest.hashCode());
            withHandlerScope(new Function2() { // from class: androidx.camera.viewfinder.core.impl.PixelCopyCompat$PixelCopyApi24Impl$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PixelCopyCompat.PixelCopyApi24Impl.requestImpl$lambda$9(source, dest, executor, listener, (Handler) obj, (Function0) obj2);
                }
            });
        }

        static final Unit requestImpl$lambda$9(Surface surface, final Bitmap bitmap, final Executor executor, final Consumer consumer, Handler handler, final Function0 onComplete) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            PixelCopy.request(surface, bitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.camera.viewfinder.core.impl.PixelCopyCompat$PixelCopyApi24Impl$$ExternalSyntheticLambda1
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public final void onPixelCopyFinished(int i) throws Throwable {
                    PixelCopyCompat.PixelCopyApi24Impl.requestImpl$lambda$9$lambda$8(bitmap, executor, onComplete, consumer, i);
                }
            }, handler);
            return Unit.INSTANCE;
        }

        static final void requestImpl$lambda$9$lambda$8(Bitmap bitmap, Executor executor, Function0 function0, final Consumer consumer, final int i) throws Throwable {
            Trace.endAsyncSection("PixelCopyApi24Impl.request", bitmap.hashCode());
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.viewfinder.core.impl.PixelCopyCompat$PixelCopyApi24Impl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        consumer.accept(Integer.valueOf(i));
                    }
                });
            } finally {
                function0.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PixelCopyCompat.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Landroidx/camera/viewfinder/core/impl/PixelCopyCompat$PixelCopyApi34Impl;", "Landroidx/camera/viewfinder/core/impl/PixelCopyCompat;", "<init>", "()V", "requestImpl", "", "source", "Landroid/view/Surface;", "dest", "Landroid/graphics/Bitmap;", "executor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/core/util/Consumer;", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class PixelCopyApi34Impl implements PixelCopyCompat {
        public static final PixelCopyApi34Impl INSTANCE = new PixelCopyApi34Impl();

        private PixelCopyApi34Impl() {
        }

        @Override // androidx.camera.viewfinder.core.impl.PixelCopyCompat
        public void requestImpl(Surface source, final Bitmap dest, Executor executor, final Consumer<Integer> listener) throws Throwable {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Trace.beginAsyncSection("PixelCopyApi34Impl.request", dest.hashCode());
            PixelCopy.Request requestBuild = PixelCopy.Request.Builder.ofSurface(source).setDestinationBitmap(dest).build();
            Intrinsics.checkNotNullExpressionValue(requestBuild, "build(...)");
            PixelCopy.request(requestBuild, executor, new java.util.function.Consumer() { // from class: androidx.camera.viewfinder.core.impl.PixelCopyCompat$PixelCopyApi34Impl$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) throws Throwable {
                    PixelCopyCompat.PixelCopyApi34Impl.requestImpl$lambda$0(dest, listener, (PixelCopy.Result) obj);
                }
            });
        }

        static final void requestImpl$lambda$0(Bitmap bitmap, Consumer consumer, PixelCopy.Result result) throws Throwable {
            Trace.endAsyncSection("PixelCopyApi34Impl.request", bitmap.hashCode());
            consumer.accept(Integer.valueOf(result.getStatus()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: PixelCopyCompat.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Landroidx/camera/viewfinder/core/impl/PixelCopyCompat$PixelCopyStub;", "Landroidx/camera/viewfinder/core/impl/PixelCopyCompat;", "<init>", "()V", "requestImpl", "", "source", "Landroid/view/Surface;", "dest", "Landroid/graphics/Bitmap;", "executor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/core/util/Consumer;", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class PixelCopyStub implements PixelCopyCompat {
        public static final PixelCopyStub INSTANCE = new PixelCopyStub();

        private PixelCopyStub() {
        }

        @Override // androidx.camera.viewfinder.core.impl.PixelCopyCompat
        public void requestImpl(Surface source, Bitmap dest, Executor executor, final Consumer<Integer> listener) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(listener, "listener");
            executor.execute(new Runnable() { // from class: androidx.camera.viewfinder.core.impl.PixelCopyCompat$PixelCopyStub$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    listener.accept(1);
                }
            });
        }
    }
}
