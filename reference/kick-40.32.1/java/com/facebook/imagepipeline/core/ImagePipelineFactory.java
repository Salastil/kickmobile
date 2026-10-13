package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactoryProvider;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCacheBitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.RoutingBitmapMemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoderFactory;
import com.facebook.imagepipeline.producers.ExperimentalThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory;
import com.facebook.imagepipeline.xml.XmlDrawableFactory;
import com.facebook.imagepipeline.xml.XmlFormatDecoder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class ImagePipelineFactory {
    private static final Class<?> TAG = ImagePipelineFactory.class;
    private static boolean sForceSingleInstance;

    @Nullable
    private static ImagePipeline sImagePipeline;

    @Nullable
    private static ImagePipelineFactory sInstance;
    private static boolean sResetImagePipelineWhenFactoryChanges;

    @Nullable
    private AnimatedFactory mAnimatedFactory;

    @Nullable
    private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;

    @Nullable
    private InstrumentedMemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private final CloseableReferenceFactory mCloseableReferenceFactory;
    private final ImagePipelineConfigInterface mConfig;
    private final Supplier<DiskCachesStore> mDiskCachesStoreSupplier;

    @Nullable
    private MemoryCache<CacheKey, CloseableImage> mEffectiveBitmapMemoryCache;

    @Nullable
    private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;

    @Nullable
    private InstrumentedMemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;

    @Nullable
    private ImageDecoder mImageDecoder;

    @Nullable
    private ImageTranscoderFactory mImageTranscoderFactory;

    @Nullable
    private CountingMemoryCache<CacheKey, CloseableImage> mNonBitmapImageCountingMemoryCache;

    @Nullable
    private InstrumentedMemoryCache<CacheKey, CloseableImage> mNonBitmapImageMemoryCache;

    @Nullable
    private PlatformBitmapFactory mPlatformBitmapFactory;

    @Nullable
    private PlatformDecoder mPlatformDecoder;

    @Nullable
    private ProducerFactory mProducerFactory;

    @Nullable
    private ProducerSequenceFactory mProducerSequenceFactory;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public static ImagePipelineFactory getInstance() {
        return (ImagePipelineFactory) Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
    }

    @Nullable
    public static ImagePipelineFactory getInstanceOrNull() {
        return sInstance;
    }

    public static void setInstance(ImagePipelineFactory imagePipelineFactory) {
        sInstance = imagePipelineFactory;
    }

    public static synchronized void initialize(Context context) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineFactory#initialize");
        }
        initialize(ImagePipelineConfig.newBuilder(context).build());
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public static synchronized void initialize(ImagePipelineConfigInterface imagePipelineConfigInterface) {
        if (sInstance != null) {
            FLog.wtf(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            if (sForceSingleInstance) {
                return;
            }
        }
        sInstance = new ImagePipelineFactory(imagePipelineConfigInterface);
        if (sResetImagePipelineWhenFactoryChanges) {
            sImagePipeline = null;
        }
    }

    public static synchronized void forceSingleInstance() {
        sForceSingleInstance = true;
    }

    public static synchronized void forceSingleInstance(boolean z) {
        sForceSingleInstance = z;
    }

    public static synchronized void resetImagePipelineWhenFactoryChanges(boolean z) {
        sResetImagePipelineWhenFactoryChanges = z;
    }

    public static synchronized boolean hasBeenInitialized() {
        return sInstance != null;
    }

    public static synchronized void shutDown() {
        ImagePipelineFactory imagePipelineFactory = sInstance;
        if (imagePipelineFactory != null) {
            imagePipelineFactory.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
            InstrumentedMemoryCache<CacheKey, CloseableImage> instrumentedMemoryCache = sInstance.mNonBitmapImageMemoryCache;
            if (instrumentedMemoryCache != null) {
                instrumentedMemoryCache.removeAll(AndroidPredicates.True());
            }
            sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
            sInstance = null;
        }
    }

    public ImagePipelineFactory(ImagePipelineConfigInterface imagePipelineConfigInterface) {
        ThreadHandoffProducerQueue threadHandoffProducerQueueImpl;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        ImagePipelineConfigInterface imagePipelineConfigInterface2 = (ImagePipelineConfigInterface) Preconditions.checkNotNull(imagePipelineConfigInterface);
        this.mConfig = imagePipelineConfigInterface2;
        if (imagePipelineConfigInterface2.getExperiments().getIsExperimentalThreadHandoffQueueEnabled()) {
            threadHandoffProducerQueueImpl = new ExperimentalThreadHandoffProducerQueueImpl(imagePipelineConfigInterface.getExecutorSupplier().getLightWeightBackgroundExecutor());
        } else {
            threadHandoffProducerQueueImpl = new ThreadHandoffProducerQueueImpl(imagePipelineConfigInterface.getExecutorSupplier().getLightWeightBackgroundExecutor());
        }
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueueImpl;
        this.mCloseableReferenceFactory = new CloseableReferenceFactory(imagePipelineConfigInterface.getCloseableReferenceLeakTracker());
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        this.mDiskCachesStoreSupplier = imagePipelineConfigInterface2.getDiskCachesStoreSupplier();
        if (imagePipelineConfigInterface2.getExperiments().getIsBinaryXmlEnabled()) {
            ImageFormatChecker.getInstance().setBinaryXmlEnabled(true);
        }
    }

    @Nullable
    private AnimatedFactory getAnimatedFactory() {
        if (this.mAnimatedFactory == null) {
            this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier(), getBitmapCountingMemoryCache(), this.mConfig.getExperiments().getDownscaleFrameToDrawableDimensions(), this.mConfig.getExperiments().getUseBalancedAnimationStrategy(), this.mConfig.getExperiments().getAnimationRenderFpsLimit(), this.mConfig.getExperiments().getAnimationStrategyBufferLengthMilliseconds(), this.mConfig.getExecutorServiceForAnimatedImages());
        }
        return this.mAnimatedFactory;
    }

    @Nullable
    public DrawableFactory getAnimatedDrawableFactory(@Nullable Context context) {
        AnimatedFactory animatedFactory = getAnimatedFactory();
        if (animatedFactory == null) {
            return null;
        }
        return animatedFactory.getAnimatedDrawableFactory(context);
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
        if (this.mBitmapCountingMemoryCache == null) {
            BitmapMemoryCacheFactory bitmapMemoryCacheFactory = this.mConfig.getBitmapMemoryCacheFactory();
            if (isNoopWithNonGcSafeFactory(bitmapMemoryCacheFactory)) {
                FLog.wtf(TAG, "Bitmap refs are REF_TYPE_NOOP but bitmap cache factory %s is not GC-safe; its counting cache will never evict under NOOP -> unbounded growth/OOM.", bitmapMemoryCacheFactory.getClass().getName());
            }
            this.mBitmapCountingMemoryCache = bitmapMemoryCacheFactory.create(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapMemoryCacheTrimStrategy(), this.mConfig.getExperiments().getShouldStoreCacheEntrySize(), this.mConfig.getExperiments().getShouldIgnoreCacheSizeMismatch(), this.mConfig.getBitmapMemoryCacheEntryStateObserver());
        }
        return this.mBitmapCountingMemoryCache;
    }

    public static boolean isNoopWithNonGcSafeFactory(BitmapMemoryCacheFactory bitmapMemoryCacheFactory) {
        return CloseableReference.getBitmapCloseableRefType() == 3 && !bitmapMemoryCacheFactory.isGcSafe();
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        if (this.mBitmapMemoryCache == null) {
            this.mBitmapMemoryCache = InstrumentedMemoryCacheBitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mBitmapMemoryCache;
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getNonBitmapImageCountingMemoryCache() {
        if (this.mNonBitmapImageCountingMemoryCache == null) {
            Supplier<MemoryCacheParams> nonBitmapImageMemoryCacheParamsSupplier = this.mConfig.getNonBitmapImageMemoryCacheParamsSupplier();
            if (nonBitmapImageMemoryCacheParamsSupplier == null) {
                nonBitmapImageMemoryCacheParamsSupplier = this.mConfig.getBitmapMemoryCacheParamsSupplier();
            }
            this.mNonBitmapImageCountingMemoryCache = new CountingLruBitmapMemoryCacheFactory().create(nonBitmapImageMemoryCacheParamsSupplier, this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapMemoryCacheTrimStrategy(), this.mConfig.getExperiments().getShouldStoreCacheEntrySize(), this.mConfig.getExperiments().getShouldIgnoreCacheSizeMismatch(), this.mConfig.getBitmapMemoryCacheEntryStateObserver());
        }
        return this.mNonBitmapImageCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getNonBitmapImageMemoryCache() {
        if (this.mNonBitmapImageMemoryCache == null) {
            this.mNonBitmapImageMemoryCache = InstrumentedMemoryCacheBitmapMemoryCacheFactory.get(getNonBitmapImageCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mNonBitmapImageMemoryCache;
    }

    private MemoryCache<CacheKey, CloseableImage> getEffectiveBitmapMemoryCache() {
        if (this.mEffectiveBitmapMemoryCache == null) {
            if (this.mConfig.getExperiments().getUseSeparateNonBitmapImageCache()) {
                this.mEffectiveBitmapMemoryCache = new RoutingBitmapMemoryCache(getBitmapMemoryCache(), getNonBitmapImageMemoryCache());
            } else {
                this.mEffectiveBitmapMemoryCache = getBitmapMemoryCache();
            }
        }
        return this.mEffectiveBitmapMemoryCache;
    }

    public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache() {
        if (this.mEncodedCountingMemoryCache == null) {
            this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getEncodedMemoryCacheTrimStrategy());
        }
        return this.mEncodedCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
        MemoryCache<CacheKey, PooledByteBuffer> encodedCountingMemoryCache;
        if (this.mEncodedMemoryCache == null) {
            if (this.mConfig.getEncodedMemoryCacheOverride() != null) {
                encodedCountingMemoryCache = this.mConfig.getEncodedMemoryCacheOverride();
            } else {
                encodedCountingMemoryCache = getEncodedCountingMemoryCache();
            }
            this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(encodedCountingMemoryCache, this.mConfig.getImageCacheStatsTracker());
        }
        return this.mEncodedMemoryCache;
    }

    private ImageDecoder getImageDecoder() {
        if (this.mImageDecoder == null) {
            if (this.mConfig.getImageDecoder() != null) {
                this.mImageDecoder = this.mConfig.getImageDecoder();
            } else {
                ImageDecoder xmlImageDecoder = getXmlImageDecoder();
                if (this.mConfig.getImageDecoderConfig() == null) {
                    HashMap map = new HashMap();
                    addAnimatedDecoders(map);
                    this.mImageDecoder = new DefaultImageDecoder(xmlImageDecoder, getPlatformDecoder(), map, this.mConfig.getDefaultIntermediateImageBitmapTransformation());
                } else {
                    HashMap map2 = new HashMap();
                    addAnimatedDecoders(map2);
                    if (this.mConfig.getImageDecoderConfig().getCustomImageDecoders() != null) {
                        map2.putAll(this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
                    }
                    this.mImageDecoder = new DefaultImageDecoder(xmlImageDecoder, getPlatformDecoder(), map2, this.mConfig.getDefaultIntermediateImageBitmapTransformation());
                    ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.getImageDecoderConfig().getCustomImageFormats());
                }
            }
        }
        return this.mImageDecoder;
    }

    public Supplier<DiskCachesStore> getDiskCachesStoreSupplier() {
        return this.mDiskCachesStoreSupplier;
    }

    public FileCache getMainFileCache() {
        return this.mDiskCachesStoreSupplier.get().getMainFileCache();
    }

    public FileCache getSmallImageFileCache() {
        return this.mDiskCachesStoreSupplier.get().getSmallImageFileCache();
    }

    public ImagePipeline getImagePipeline() {
        if (sImagePipeline == null) {
            sImagePipeline = createImagePipeline();
        }
        return sImagePipeline;
    }

    private ImagePipeline createImagePipeline() {
        return new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getRequestListener2s(), this.mConfig.isPrefetchEnabledSupplier(), getEffectiveBitmapMemoryCache(), getEncodedMemoryCache(), this.mDiskCachesStoreSupplier, this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, this.mConfig.getExperiments().getSuppressBitmapPrefetchingSupplier(), this.mConfig.getExperiments().isLazyDataSource(), this.mConfig.getCallerContextVerifier(), this.mConfig);
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        if (this.mPlatformBitmapFactory == null) {
            this.mPlatformBitmapFactory = PlatformBitmapFactoryProvider.buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder(), getCloseableReferenceFactory());
        }
        return this.mPlatformBitmapFactory;
    }

    public PlatformDecoder getPlatformDecoder() {
        if (this.mPlatformDecoder == null) {
            this.mPlatformDecoder = PlatformDecoderFactory.buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().getShouldUseDecodingBufferHelper(), this.mConfig.getExperiments().getPlatformDecoderOptions());
        }
        return this.mPlatformDecoder;
    }

    private ProducerFactory getProducerFactory() {
        if (this.mProducerFactory == null) {
            this.mProducerFactory = this.mConfig.getExperiments().getProducerFactoryMethod().createProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.getDownsampleMode(), this.mConfig.getIsResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().getIsDecodeCancellationEnabled(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), getEffectiveBitmapMemoryCache(), getEncodedMemoryCache(), this.mDiskCachesStoreSupplier, this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawForPrefetch(), this.mConfig.getExperiments().getMaxBitmapDimension(), getCloseableReferenceFactory(), this.mConfig.getExperiments().getKeepCancelledFetchAsLowPriority(), this.mConfig.getExperiments().getTrackedKeysSize(), this.mConfig);
        }
        return this.mProducerFactory;
    }

    private ProducerSequenceFactory getProducerSequenceFactory() {
        boolean useBitmapPrepareToDraw = this.mConfig.getExperiments().getUseBitmapPrepareToDraw();
        if (this.mProducerSequenceFactory == null) {
            this.mProducerSequenceFactory = new ProducerSequenceFactory(this.mConfig.getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.getIsResizeAndRotateEnabledForNetwork(), this.mThreadHandoffProducerQueue, this.mConfig.getDownsampleMode(), useBitmapPrepareToDraw, this.mConfig.getExperiments().getIsPartialImageCachingEnabled(), this.mConfig.getIsDiskCacheEnabled(), getImageTranscoderFactory(), this.mConfig.getExperiments().getIsEncodedMemoryCacheProbingEnabled(), this.mConfig.getExperiments().getIsDiskCacheProbingEnabled(), this.mConfig.getExperiments().getAllowDelay(), this.mConfig.getCustomProducerSequenceFactories(), this.mConfig.getExperiments().getThrottlingProducerMaxSimultaneousRequests(), this.mConfig.getExperiments().getLoadThumbnailFromContentResolverFirst(), this.mConfig.getExperiments().getLoadThumbnailFromContentResolverForContentUriOnly(), this.mConfig.getExperiments().getUsePostprocessorDuringDecodedPrefetch());
        }
        return this.mProducerSequenceFactory;
    }

    public CloseableReferenceFactory getCloseableReferenceFactory() {
        return this.mCloseableReferenceFactory;
    }

    private ImageTranscoderFactory getImageTranscoderFactory() {
        if (this.mImageTranscoderFactory == null) {
            if (this.mConfig.getImageTranscoderFactory() == null && this.mConfig.getImageTranscoderType() == null && this.mConfig.getExperiments().getIsNativeCodeDisabled()) {
                this.mImageTranscoderFactory = new SimpleImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapDimension());
            } else {
                this.mImageTranscoderFactory = new MultiImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapDimension(), this.mConfig.getExperiments().getUseDownsamplingRatioForResizing(), this.mConfig.getImageTranscoderFactory(), this.mConfig.getImageTranscoderType(), this.mConfig.getExperiments().getIsEnsureTranscoderLibraryLoaded());
            }
        }
        return this.mImageTranscoderFactory;
    }

    @Nullable
    public String reportData() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper("ImagePipelineFactory");
        CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache = this.mBitmapCountingMemoryCache;
        if (countingMemoryCache != null) {
            stringHelper.add("bitmapCountingMemoryCache", countingMemoryCache.getDebugData());
        }
        CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache2 = this.mNonBitmapImageCountingMemoryCache;
        if (countingMemoryCache2 != null) {
            stringHelper.add("nonBitmapImageCountingMemoryCache", countingMemoryCache2.getDebugData());
        }
        CountingMemoryCache<CacheKey, PooledByteBuffer> countingMemoryCache3 = this.mEncodedCountingMemoryCache;
        if (countingMemoryCache3 != null) {
            stringHelper.add("encodedCountingMemoryCache", countingMemoryCache3.getDebugData());
        }
        return stringHelper.toString();
    }

    @Nullable
    public ImageDecoder getXmlImageDecoder() {
        if (this.mConfig.getExperiments().getIsBinaryXmlEnabled()) {
            return new XmlFormatDecoder(this.mConfig.getContext().getApplicationContext().getResources());
        }
        return null;
    }

    @Nullable
    public DrawableFactory getXmlDrawableFactory() {
        if (this.mConfig.getExperiments().getIsBinaryXmlEnabled()) {
            return new XmlDrawableFactory();
        }
        return null;
    }

    private void addAnimatedDecoders(Map<ImageFormat, ImageDecoder> map) {
        try {
            map.put(DefaultImageFormats.GIF, (ImageDecoder) Class.forName("com.facebook.animated.gif.GifImageDecoder").getConstructor(PlatformBitmapFactory.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE).newInstance(getPlatformBitmapFactory(), Boolean.valueOf(this.mConfig.getExperiments().getUseBalancedAnimationStrategy()), Boolean.valueOf(this.mConfig.getExperiments().getDownscaleFrameToDrawableDimensions()), true));
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            FLog.w(TAG, "Failed to instantiate GIF decoder via reflection", e);
        }
        try {
            map.put(DefaultImageFormats.WEBP_ANIMATED, (ImageDecoder) Class.forName("com.facebook.animated.webp.WebPImageDecoder").getConstructor(PlatformBitmapFactory.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE).newInstance(getPlatformBitmapFactory(), Boolean.valueOf(this.mConfig.getExperiments().getUseBalancedAnimationStrategy()), Boolean.valueOf(this.mConfig.getExperiments().getDownscaleFrameToDrawableDimensions()), true));
        } catch (ClassNotFoundException unused2) {
        } catch (Exception e2) {
            FLog.w(TAG, "Failed to instantiate WebP decoder via reflection", e2);
        }
    }
}
