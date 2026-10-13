package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Rect;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderListener;
import com.facebook.fresco.vito.core.AnimatedImagePerfLoggingListener;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedFactoryV2Impl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0083\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020'H\u0002J\b\u00100\u001a\u00020%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/facebook/fresco/animation/factory/AnimatedFactoryV2Impl;", "Lcom/facebook/imagepipeline/animated/factory/AnimatedFactory;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "backingCache", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "downscaleFrameToDrawableDimensions", "", "useBufferLoaderStrategy", "animationFpsLimit", "", "bufferLengthMilliseconds", "serialExecutorService", "Lcom/facebook/common/executors/SerialExecutorService;", "enableBufferFrameLoaderFix", "frameLoaderListener", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderListener;", "enableSingleFrameRendering", "animatedImagePerfLoggingListener", "Lcom/facebook/fresco/vito/core/AnimatedImagePerfLoggingListener;", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;Lcom/facebook/imagepipeline/core/ExecutorSupplier;Lcom/facebook/imagepipeline/cache/CountingMemoryCache;ZZIILcom/facebook/common/executors/SerialExecutorService;ZLcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderListener;ZLcom/facebook/fresco/vito/core/AnimatedImagePerfLoggingListener;)V", "getAnimationFpsLimit", "()I", "setAnimationFpsLimit", "(I)V", "getBufferLengthMilliseconds", "setBufferLengthMilliseconds", "getSerialExecutorService", "()Lcom/facebook/common/executors/SerialExecutorService;", "setSerialExecutorService", "(Lcom/facebook/common/executors/SerialExecutorService;)V", "animatedDrawableBackendProvider", "Lcom/facebook/imagepipeline/animated/impl/AnimatedDrawableBackendProvider;", "animatedDrawableUtil", "Lcom/facebook/imagepipeline/animated/util/AnimatedDrawableUtil;", "animatedDrawableFactory", "Lcom/facebook/imagepipeline/drawable/DrawableFactory;", "getAnimatedDrawableFactory", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "createDrawableFactory", "Lcom/facebook/fresco/animation/factory/DefaultBitmapAnimationDrawableFactory;", "getAnimatedDrawableUtil", "getAnimatedDrawableBackendProvider", "Companion", "animated-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnimatedFactoryV2Impl implements AnimatedFactory {
    private static final int NUMBER_OF_FRAMES_TO_PREPARE = 3;
    private AnimatedDrawableBackendProvider animatedDrawableBackendProvider;
    private DrawableFactory animatedDrawableFactory;
    private AnimatedDrawableUtil animatedDrawableUtil;
    private final AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener;
    private int animationFpsLimit;
    private final CountingMemoryCache<CacheKey, CloseableImage> backingCache;
    private int bufferLengthMilliseconds;
    private final boolean downscaleFrameToDrawableDimensions;
    private final boolean enableBufferFrameLoaderFix;
    private final boolean enableSingleFrameRendering;
    private final ExecutorSupplier executorSupplier;
    private final FrameLoaderListener frameLoaderListener;
    private final PlatformBitmapFactory platformBitmapFactory;
    private SerialExecutorService serialExecutorService;
    private final boolean useBufferLoaderStrategy;

    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> backingCache, boolean z, boolean z2, int i, int i2, SerialExecutorService serialExecutorService, boolean z3, FrameLoaderListener frameLoaderListener, boolean z4, AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener) {
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        Intrinsics.checkNotNullParameter(executorSupplier, "executorSupplier");
        Intrinsics.checkNotNullParameter(backingCache, "backingCache");
        this.platformBitmapFactory = platformBitmapFactory;
        this.executorSupplier = executorSupplier;
        this.backingCache = backingCache;
        this.downscaleFrameToDrawableDimensions = z;
        this.useBufferLoaderStrategy = z2;
        this.animationFpsLimit = i;
        this.bufferLengthMilliseconds = i2;
        this.serialExecutorService = serialExecutorService;
        this.enableBufferFrameLoaderFix = z3;
        this.frameLoaderListener = frameLoaderListener;
        this.enableSingleFrameRendering = z4;
        this.animatedImagePerfLoggingListener = animatedImagePerfLoggingListener;
    }

    public /* synthetic */ AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache countingMemoryCache, boolean z, boolean z2, int i, int i2, SerialExecutorService serialExecutorService, boolean z3, FrameLoaderListener frameLoaderListener, boolean z4, AnimatedImagePerfLoggingListener animatedImagePerfLoggingListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformBitmapFactory, executorSupplier, countingMemoryCache, z, z2, i, i2, serialExecutorService, (i3 & 256) != 0 ? false : z3, (i3 & 512) != 0 ? null : frameLoaderListener, (i3 & 1024) != 0 ? false : z4, (i3 & 2048) != 0 ? null : animatedImagePerfLoggingListener);
    }

    public final int getAnimationFpsLimit() {
        return this.animationFpsLimit;
    }

    public final void setAnimationFpsLimit(int i) {
        this.animationFpsLimit = i;
    }

    public final int getBufferLengthMilliseconds() {
        return this.bufferLengthMilliseconds;
    }

    public final void setBufferLengthMilliseconds(int i) {
        this.bufferLengthMilliseconds = i;
    }

    public final SerialExecutorService getSerialExecutorService() {
        return this.serialExecutorService;
    }

    public final void setSerialExecutorService(SerialExecutorService serialExecutorService) {
        this.serialExecutorService = serialExecutorService;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        if (this.animatedDrawableFactory == null) {
            this.animatedDrawableFactory = createDrawableFactory();
        }
        return this.animatedDrawableFactory;
    }

    private final DefaultBitmapAnimationDrawableFactory createDrawableFactory() {
        Supplier supplier = new Supplier() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$$ExternalSyntheticLambda0
            @Override // com.facebook.common.internal.Supplier
            public final Object get() {
                return AnimatedFactoryV2Impl.createDrawableFactory$lambda$0();
            }
        };
        DefaultSerialExecutorService defaultSerialExecutorService = this.serialExecutorService;
        if (defaultSerialExecutorService == null) {
            defaultSerialExecutorService = new DefaultSerialExecutorService(this.executorSupplier.getDecodeExecutor());
        }
        Supplier supplier2 = new Supplier() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$$ExternalSyntheticLambda1
            @Override // com.facebook.common.internal.Supplier
            public final Object get() {
                return AnimatedFactoryV2Impl.createDrawableFactory$lambda$1();
            }
        };
        Supplier<Boolean> supplier3 = Suppliers.BOOLEAN_FALSE;
        SerialExecutorService serialExecutorService = defaultSerialExecutorService;
        AnimatedDrawableBackendProvider animatedDrawableBackendProvider = getAnimatedDrawableBackendProvider();
        UiThreadImmediateExecutorService uiThreadImmediateExecutorService = UiThreadImmediateExecutorService.getInstance();
        Intrinsics.checkNotNullExpressionValue(uiThreadImmediateExecutorService, "getInstance(...)");
        RealtimeSinceBootClock realtimeSinceBootClock = RealtimeSinceBootClock.get();
        Intrinsics.checkNotNullExpressionValue(realtimeSinceBootClock, "get(...)");
        RealtimeSinceBootClock realtimeSinceBootClock2 = realtimeSinceBootClock;
        PlatformBitmapFactory platformBitmapFactory = this.platformBitmapFactory;
        CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache = this.backingCache;
        Intrinsics.checkNotNull(supplier3);
        Supplier supplierOf = Suppliers.of(Boolean.valueOf(this.useBufferLoaderStrategy));
        Intrinsics.checkNotNullExpressionValue(supplierOf, "of(...)");
        Supplier supplierOf2 = Suppliers.of(Boolean.valueOf(this.downscaleFrameToDrawableDimensions));
        Intrinsics.checkNotNullExpressionValue(supplierOf2, "of(...)");
        Supplier supplierOf3 = Suppliers.of(Integer.valueOf(this.animationFpsLimit));
        Intrinsics.checkNotNullExpressionValue(supplierOf3, "of(...)");
        Supplier supplierOf4 = Suppliers.of(Integer.valueOf(this.bufferLengthMilliseconds));
        Intrinsics.checkNotNullExpressionValue(supplierOf4, "of(...)");
        return new DefaultBitmapAnimationDrawableFactory(animatedDrawableBackendProvider, uiThreadImmediateExecutorService, serialExecutorService, realtimeSinceBootClock2, platformBitmapFactory, countingMemoryCache, supplier, supplier2, supplier3, supplierOf, supplierOf2, supplierOf3, supplierOf4, this.animatedImagePerfLoggingListener, this.enableBufferFrameLoaderFix, this.frameLoaderListener, this.enableSingleFrameRendering);
    }

    static final Integer createDrawableFactory$lambda$0() {
        return 2;
    }

    static final Integer createDrawableFactory$lambda$1() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnimatedDrawableUtil getAnimatedDrawableUtil() {
        AnimatedDrawableUtil animatedDrawableUtil = this.animatedDrawableUtil;
        if (animatedDrawableUtil != null) {
            return animatedDrawableUtil;
        }
        AnimatedDrawableUtil animatedDrawableUtil2 = new AnimatedDrawableUtil();
        this.animatedDrawableUtil = animatedDrawableUtil2;
        return animatedDrawableUtil2;
    }

    private final AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider() {
        if (this.animatedDrawableBackendProvider == null) {
            this.animatedDrawableBackendProvider = new AnimatedDrawableBackendProvider() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.getAnimatedDrawableBackendProvider.1
                @Override // com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider
                public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect bounds) {
                    Intrinsics.checkNotNullParameter(animatedImageResult, "animatedImageResult");
                    return new AnimatedDrawableBackendImpl(AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, bounds, AnimatedFactoryV2Impl.this.downscaleFrameToDrawableDimensions);
                }
            };
        }
        AnimatedDrawableBackendProvider animatedDrawableBackendProvider = this.animatedDrawableBackendProvider;
        Intrinsics.checkNotNull(animatedDrawableBackendProvider, "null cannot be cast to non-null type com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider");
        return animatedDrawableBackendProvider;
    }
}
