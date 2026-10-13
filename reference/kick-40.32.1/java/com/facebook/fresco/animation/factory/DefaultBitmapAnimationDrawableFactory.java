package com.facebook.fresco.animation.factory;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.cache.AnimationFrameCacheKey;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.FrameLoaderStrategy;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderListener;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.KAnimatedDrawable2;
import com.facebook.fresco.vito.core.AnimatedImagePerfLoggingListener;
import com.facebook.fresco.vito.options.AnimatedOptions;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultBitmapAnimationDrawableFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=BÓ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010%\u001a\u00020\u0010H\u0016J\"\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,H\u0016J$\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u001a\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0010\u00107\u001a\u0002082\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010/\u001a\u000200H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/facebook/fresco/animation/factory/DefaultBitmapAnimationDrawableFactory;", "Lcom/facebook/imagepipeline/drawable/DrawableFactory;", "Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "animatedDrawableBackendProvider", "Lcom/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendProvider;", "scheduledExecutorServiceForUiThread", "Ljava/util/concurrent/ScheduledExecutorService;", "executorServiceForFramePreparing", "Ljava/util/concurrent/ExecutorService;", "monotonicClock", "Lcom/facebook/common/time/MonotonicClock;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "backingCache", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "cachingStrategySupplier", "Lcom/facebook/common/internal/Supplier;", "", "numberOfFramesToPrepareSupplier", "useDeepEqualsForCacheKey", "", "useNewBitmapRender", "downscaleFrameToDrawableDimensions", "animationFpsLimit", "bufferLengthMilliseconds", "animatedImagePerfLoggingListener", "Lcom/facebook/fresco/vito/core/AnimatedImagePerfLoggingListener;", "enableBufferFrameLoaderFix", "frameLoaderListener", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderListener;", "enableSingleFrameRendering", "<init>", "(Lcom/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendProvider;Ljava/util/concurrent/ScheduledExecutorService;Ljava/util/concurrent/ExecutorService;Lcom/facebook/common/time/MonotonicClock;Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;Lcom/facebook/imagepipeline/cache/CountingMemoryCache;Lcom/facebook/common/internal/Supplier;Lcom/facebook/common/internal/Supplier;Lcom/facebook/common/internal/Supplier;Lcom/facebook/common/internal/Supplier;Lcom/facebook/common/internal/Supplier;Lcom/facebook/common/internal/Supplier;Lcom/facebook/common/internal/Supplier;Lcom/facebook/fresco/vito/core/AnimatedImagePerfLoggingListener;ZLcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderListener;Z)V", "useRendererAnimatedDrawable", "supportsImageType", "image", "createDrawable", "Landroid/graphics/drawable/Drawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "closeableImage", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "createAnimationBackend", "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "animatedImageResult", "Lcom/facebook/imagepipeline/animated/base/AnimatedImageResult;", "animatedBitmapConfig", "Landroid/graphics/Bitmap$Config;", "createBitmapFramePreparer", "Lcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparer;", "bitmapFrameRenderer", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;", "createAnimatedDrawableBackend", "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableBackend;", "createBitmapFrameCache", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;", "createAnimatedFrameCache", "Lcom/facebook/imagepipeline/animated/impl/AnimatedFrameCache;", "Companion", "animated-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultBitmapAnimationDrawableFactory implements DrawableFactory, ImageOptionsDrawableFactory {
    public static final int CACHING_STRATEGY_FRESCO_CACHE = 1;
    public static final int CACHING_STRATEGY_FRESCO_CACHE_NO_REUSING = 2;
    public static final int CACHING_STRATEGY_KEEP_LAST_CACHE = 3;
    public static final int CACHING_STRATEGY_NO_CACHE = 0;
    private final AnimatedDrawableBackendProvider animatedDrawableBackendProvider;
    private final AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener;
    private final Supplier<Integer> animationFpsLimit;
    private final CountingMemoryCache<CacheKey, CloseableImage> backingCache;
    private final Supplier<Integer> bufferLengthMilliseconds;
    private final Supplier<Integer> cachingStrategySupplier;
    private final Supplier<Boolean> downscaleFrameToDrawableDimensions;
    private final boolean enableBufferFrameLoaderFix;
    private final boolean enableSingleFrameRendering;
    private final ExecutorService executorServiceForFramePreparing;
    private final FrameLoaderListener frameLoaderListener;
    private final MonotonicClock monotonicClock;
    private final Supplier<Integer> numberOfFramesToPrepareSupplier;
    private final PlatformBitmapFactory platformBitmapFactory;
    private final ScheduledExecutorService scheduledExecutorServiceForUiThread;
    private final Supplier<Boolean> useDeepEqualsForCacheKey;
    private final Supplier<Boolean> useNewBitmapRender;
    private final Supplier<Boolean> useRendererAnimatedDrawable;

    public DefaultBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorServiceForUiThread, ExecutorService executorServiceForFramePreparing, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, Supplier<Integer> cachingStrategySupplier, Supplier<Integer> numberOfFramesToPrepareSupplier, Supplier<Boolean> useDeepEqualsForCacheKey, Supplier<Boolean> useNewBitmapRender, Supplier<Boolean> downscaleFrameToDrawableDimensions, Supplier<Integer> animationFpsLimit, Supplier<Integer> bufferLengthMilliseconds, AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener, boolean z, FrameLoaderListener frameLoaderListener, boolean z2) {
        Intrinsics.checkNotNullParameter(animatedDrawableBackendProvider, "animatedDrawableBackendProvider");
        Intrinsics.checkNotNullParameter(scheduledExecutorServiceForUiThread, "scheduledExecutorServiceForUiThread");
        Intrinsics.checkNotNullParameter(executorServiceForFramePreparing, "executorServiceForFramePreparing");
        Intrinsics.checkNotNullParameter(monotonicClock, "monotonicClock");
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(cachingStrategySupplier, "cachingStrategySupplier");
        Intrinsics.checkNotNullParameter(numberOfFramesToPrepareSupplier, "numberOfFramesToPrepareSupplier");
        Intrinsics.checkNotNullParameter(useDeepEqualsForCacheKey, "useDeepEqualsForCacheKey");
        Intrinsics.checkNotNullParameter(useNewBitmapRender, "useNewBitmapRender");
        Intrinsics.checkNotNullParameter(downscaleFrameToDrawableDimensions, "downscaleFrameToDrawableDimensions");
        Intrinsics.checkNotNullParameter(animationFpsLimit, "animationFpsLimit");
        Intrinsics.checkNotNullParameter(bufferLengthMilliseconds, "bufferLengthMilliseconds");
        this.animatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.scheduledExecutorServiceForUiThread = scheduledExecutorServiceForUiThread;
        this.executorServiceForFramePreparing = executorServiceForFramePreparing;
        this.monotonicClock = monotonicClock;
        this.platformBitmapFactory = platformBitmapFactory;
        this.backingCache = countingMemoryCache;
        this.cachingStrategySupplier = cachingStrategySupplier;
        this.numberOfFramesToPrepareSupplier = numberOfFramesToPrepareSupplier;
        this.useDeepEqualsForCacheKey = useDeepEqualsForCacheKey;
        this.useNewBitmapRender = useNewBitmapRender;
        this.downscaleFrameToDrawableDimensions = downscaleFrameToDrawableDimensions;
        this.animationFpsLimit = animationFpsLimit;
        this.bufferLengthMilliseconds = bufferLengthMilliseconds;
        this.animatedImagePerfLoggingListener = animatedImagePerfLoggingListener;
        this.enableBufferFrameLoaderFix = z;
        this.frameLoaderListener = frameLoaderListener;
        this.enableSingleFrameRendering = z2;
        Supplier<Boolean> BOOLEAN_FALSE = Suppliers.BOOLEAN_FALSE;
        Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        this.useRendererAnimatedDrawable = BOOLEAN_FALSE;
    }

    public /* synthetic */ DefaultBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache countingMemoryCache, Supplier supplier, Supplier supplier2, Supplier supplier3, Supplier supplier4, Supplier supplier5, Supplier supplier6, Supplier supplier7, AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener, boolean z, FrameLoaderListener frameLoaderListener, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(animatedDrawableBackendProvider, scheduledExecutorService, executorService, monotonicClock, platformBitmapFactory, countingMemoryCache, supplier, supplier2, supplier3, supplier4, supplier5, supplier6, supplier7, (i & 8192) != 0 ? null : animatedImagePerfLoggingListener, (i & 16384) != 0 ? false : z, (32768 & i) != 0 ? null : frameLoaderListener, (i & 65536) != 0 ? false : z2);
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return image instanceof CloseableAnimatedImage;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public Drawable createDrawable(CloseableImage image) {
        Intrinsics.checkNotNullParameter(image, "image");
        if (!supportsImageType(image)) {
            return null;
        }
        CloseableAnimatedImage closeableAnimatedImage = (CloseableAnimatedImage) image;
        AnimatedImage image2 = closeableAnimatedImage.getImage();
        Object objCheckNotNull = Preconditions.checkNotNull(closeableAnimatedImage.getImageResult());
        Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(...)");
        AnimationBackend animationBackendCreateAnimationBackend = createAnimationBackend((AnimatedImageResult) objCheckNotNull, image2 != null ? image2.get_animatedBitmapConfig() : null, null);
        if (this.useRendererAnimatedDrawable.get().booleanValue()) {
            return new KAnimatedDrawable2(animationBackendCreateAnimationBackend);
        }
        return new AnimatedDrawable2(animationBackendCreateAnimationBackend);
    }

    @Override // com.facebook.fresco.vito.options.ImageOptionsDrawableFactory
    public Drawable createDrawable(Resources resources, CloseableImage closeableImage, ImageOptions imageOptions) throws Throwable {
        String source;
        Object objM12684constructorimpl;
        Drawable animatedDrawable2;
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(closeableImage, "closeableImage");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (!supportsImageType(closeableImage)) {
            return null;
        }
        CloseableAnimatedImage closeableAnimatedImage = (CloseableAnimatedImage) closeableImage;
        AnimatedImage image = closeableAnimatedImage.getImage();
        AnimatedImageResult imageResult = closeableAnimatedImage.getImageResult();
        if (imageResult == null || (source = imageResult.getSource()) == null) {
            source = "unknown_" + System.identityHashCode(closeableImage);
        }
        long jNanoTime = System.nanoTime();
        AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener = this.animatedImagePerfLoggingListener;
        if (animatedImagePerfLoggingListener != null) {
            animatedImagePerfLoggingListener.onDrawableCreationStart(source, jNanoTime);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            DefaultBitmapAnimationDrawableFactory defaultBitmapAnimationDrawableFactory = this;
            Object objCheckNotNull = Preconditions.checkNotNull(closeableAnimatedImage.getImageResult());
            Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(...)");
            objM12684constructorimpl = Result.m12684constructorimpl(createAnimationBackend((AnimatedImageResult) objCheckNotNull, image != null ? image.get_animatedBitmapConfig() : null, imageOptions));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            if (thM12687exceptionOrNullimpl instanceof NullPointerException) {
                Object extra = closeableAnimatedImage.getExtra("uri_source");
                Intrinsics.checkNotNullExpressionValue(extra, "getExtra(...)");
                if (extra != null) {
                    throw new NullPointerException(thM12687exceptionOrNullimpl.getMessage() + " uri=" + extra);
                }
                throw thM12687exceptionOrNullimpl;
            }
            throw thM12687exceptionOrNullimpl;
        }
        AnimationBackend animationBackend = (AnimationBackend) objM12684constructorimpl;
        if (this.useRendererAnimatedDrawable.get().booleanValue()) {
            animatedDrawable2 = new KAnimatedDrawable2(animationBackend);
        } else {
            animatedDrawable2 = new AnimatedDrawable2(animationBackend);
        }
        long jNanoTime2 = System.nanoTime();
        AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener2 = this.animatedImagePerfLoggingListener;
        if (animatedImagePerfLoggingListener2 != null) {
            animatedImagePerfLoggingListener2.onDrawableCreationEnd(source, jNanoTime2, true);
        }
        return animatedDrawable2;
    }

    private final AnimationBackend createAnimationBackend(AnimatedImageResult animatedImageResult, Bitmap.Config animatedBitmapConfig, ImageOptions imageOptions) {
        FrameLoaderStrategy frameLoaderStrategy;
        BitmapFramePreparer bitmapFramePreparerCreateBitmapFramePreparer;
        AnimatedDrawableBackend animatedDrawableBackendCreateAnimatedDrawableBackend = createAnimatedDrawableBackend(animatedImageResult);
        AnimatedDrawableBackendAnimationInformation animatedDrawableBackendAnimationInformation = new AnimatedDrawableBackendAnimationInformation(animatedDrawableBackendCreateAnimatedDrawableBackend);
        BitmapFrameCache bitmapFrameCacheCreateBitmapFrameCache = createBitmapFrameCache(animatedImageResult);
        Boolean bool = this.useNewBitmapRender.get();
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(bitmapFrameCacheCreateBitmapFrameCache, animatedDrawableBackendCreateAnimatedDrawableBackend, bool.booleanValue());
        Integer num = this.numberOfFramesToPrepareSupplier.get();
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        int iIntValue = num.intValue();
        if (iIntValue > 0) {
            frameLoaderStrategy = new FixedNumberBitmapFramePreparationStrategy(iIntValue);
            bitmapFramePreparerCreateBitmapFramePreparer = createBitmapFramePreparer(animatedDrawableBackendFrameRenderer, animatedBitmapConfig);
        } else {
            frameLoaderStrategy = null;
            bitmapFramePreparerCreateBitmapFramePreparer = null;
        }
        RoundingOptions roundingOptions = imageOptions != null ? imageOptions.getRoundingOptions() : null;
        AnimatedOptions animatedOptions = imageOptions != null ? imageOptions.getAnimatedOptions() : null;
        if (this.useNewBitmapRender.get().booleanValue()) {
            PlatformBitmapFactory platformBitmapFactory = this.platformBitmapFactory;
            Integer num2 = this.animationFpsLimit.get();
            Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
            int iIntValue2 = num2.intValue();
            Integer num3 = this.bufferLengthMilliseconds.get();
            Intrinsics.checkNotNullExpressionValue(num3, "get(...)");
            FrameLoaderFactory frameLoaderFactory = new FrameLoaderFactory(platformBitmapFactory, iIntValue2, num3.intValue(), this.enableBufferFrameLoaderFix, this.frameLoaderListener, this.enableSingleFrameRendering);
            Boolean bool2 = this.downscaleFrameToDrawableDimensions.get();
            Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
            frameLoaderStrategy = new FrameLoaderStrategy(animatedImageResult.getSource(), animatedDrawableBackendAnimationInformation, animatedDrawableBackendFrameRenderer, frameLoaderFactory, bool2.booleanValue());
        }
        Boolean bool3 = this.useNewBitmapRender.get();
        Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        BitmapAnimationBackend bitmapAnimationBackend = new BitmapAnimationBackend(this.platformBitmapFactory, bitmapFrameCacheCreateBitmapFrameCache, animatedDrawableBackendAnimationInformation, animatedDrawableBackendFrameRenderer, bool3.booleanValue(), frameLoaderStrategy, bitmapFramePreparerCreateBitmapFramePreparer, roundingOptions, animatedOptions);
        bitmapAnimationBackend.setAnimatedImagePerfLoggingListener(this.animatedImagePerfLoggingListener);
        AnimationBackendDelegate animationBackendDelegateCreateForBackend = AnimationBackendDelegateWithInactivityCheck.createForBackend(bitmapAnimationBackend, this.monotonicClock, this.scheduledExecutorServiceForUiThread);
        Intrinsics.checkNotNullExpressionValue(animationBackendDelegateCreateForBackend, "createForBackend(...)");
        return animationBackendDelegateCreateForBackend;
    }

    private final BitmapFramePreparer createBitmapFramePreparer(BitmapFrameRenderer bitmapFrameRenderer, Bitmap.Config animatedBitmapConfig) {
        PlatformBitmapFactory platformBitmapFactory = this.platformBitmapFactory;
        if (animatedBitmapConfig == null) {
            animatedBitmapConfig = Bitmap.Config.ARGB_8888;
        }
        return new DefaultBitmapFramePreparer(platformBitmapFactory, bitmapFrameRenderer, animatedBitmapConfig, this.executorServiceForFramePreparing);
    }

    private final AnimatedDrawableBackend createAnimatedDrawableBackend(AnimatedImageResult animatedImageResult) {
        AnimatedImage image = animatedImageResult.getImage();
        Intrinsics.checkNotNullExpressionValue(image, "getImage(...)");
        AnimatedDrawableBackend animatedDrawableBackend = this.animatedDrawableBackendProvider.get(animatedImageResult, new Rect(0, 0, image.getWidth(), image.getHeight()));
        Intrinsics.checkNotNullExpressionValue(animatedDrawableBackend, "get(...)");
        return animatedDrawableBackend;
    }

    private final BitmapFrameCache createBitmapFrameCache(AnimatedImageResult animatedImageResult) {
        int iIntValue = this.cachingStrategySupplier.get().intValue();
        if (iIntValue == 0) {
            return new NoOpCache();
        }
        if (iIntValue == 1) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), true);
        }
        if (iIntValue == 2) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), false);
        }
        if (iIntValue == 3) {
            return new KeepLastFrameCache();
        }
        return new NoOpCache();
    }

    private final AnimatedFrameCache createAnimatedFrameCache(AnimatedImageResult animatedImageResult) {
        int iHashCode = animatedImageResult.hashCode();
        Boolean bool = this.useDeepEqualsForCacheKey.get();
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        AnimationFrameCacheKey animationFrameCacheKey = new AnimationFrameCacheKey(iHashCode, bool.booleanValue());
        CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache = this.backingCache;
        if (countingMemoryCache != null) {
            return new AnimatedFrameCache(animationFrameCacheKey, countingMemoryCache);
        }
        throw new IllegalStateException("backingCache is null");
    }
}
