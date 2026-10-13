package com.facebook.imagepipeline.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.SimilarImageLookup;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.CustomProducerSequenceFactory;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ImagePipelineConfigInterface.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR \u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0019R \u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0018\u00010-X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u000203X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0018\u00106\u001a\b\u0012\u0004\u0012\u00020*0\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0019R\u0012\u00108\u001a\u00020&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010(R\u001a\u0010:\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010;X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R \u0010>\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020?\u0018\u00010-X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u00101R\u001a\u0010A\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0019R\u0016\u0010C\u001a\u0004\u0018\u00010D8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010G\u001a\u0006\u0012\u0002\b\u00030HX¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0012\u0010K\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0014R\u0014\u0010L\u001a\u0004\u0018\u00010MX¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u0004\u0018\u00010QX¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\u0004\u0018\u00010UX¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0012\u0010X\u001a\u00020YX¦\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u0004\u0018\u00010]X¦\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0014\u0010`\u001a\u0004\u0018\u00010aX¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0018\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010\u0019R\u0012\u0010f\u001a\u00020gX¦\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0014\u0010j\u001a\u0004\u0018\u00010kX¦\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0016\u0010n\u001a\u0004\u0018\u00010o8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0012\u0010r\u001a\u00020aX¦\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0012\u0010u\u001a\u00020vX¦\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0018\u0010y\u001a\b\u0012\u0004\u0012\u00020z0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b{\u0010\u0006R\u0012\u0010|\u001a\u00020}X¦\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0016\u0010\u0080\u0001\u001a\u00030\u0081\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0084\u0001\u001a\u00030\u0085\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0016\u0010\u0088\u0001\u001a\u00030\u0089\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010\u0019R\u0018\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010\u0006R\u001e\u0010\u0098\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0099\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u009a\u0001R\u0016\u0010\u009b\u0001\u001a\u00030\u009c\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001¨\u0006\u009f\u0001À\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "", "requestListeners", "", "Lcom/facebook/imagepipeline/listener/RequestListener;", "getRequestListeners", "()Ljava/util/Set;", "requestListener2s", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "getRequestListener2s", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "getCacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "imageCacheStatsTracker", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "getImageCacheStatsTracker", "()Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "isDiskCacheEnabled", "", "()Z", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "getDiskCachesStoreSupplier", "()Lcom/facebook/common/internal/Supplier;", "mainDiskCacheConfig", "Lcom/facebook/cache/disk/DiskCacheConfig;", "getMainDiskCacheConfig", "()Lcom/facebook/cache/disk/DiskCacheConfig;", "smallImageDiskCacheConfig", "getSmallImageDiskCacheConfig", "dynamicDiskCacheConfigMap", "", "", "getDynamicDiskCacheConfigMap", "()Ljava/util/Map;", "encodedMemoryCacheTrimStrategy", "Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "getEncodedMemoryCacheTrimStrategy", "()Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "encodedMemoryCacheParamsSupplier", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "getEncodedMemoryCacheParamsSupplier", "encodedMemoryCacheOverride", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/common/memory/PooledByteBuffer;", "getEncodedMemoryCacheOverride", "()Lcom/facebook/imagepipeline/cache/MemoryCache;", "bitmapMemoryCacheFactory", "Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "getBitmapMemoryCacheFactory", "()Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "bitmapMemoryCacheParamsSupplier", "getBitmapMemoryCacheParamsSupplier", "bitmapMemoryCacheTrimStrategy", "getBitmapMemoryCacheTrimStrategy", "bitmapMemoryCacheEntryStateObserver", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "getBitmapMemoryCacheEntryStateObserver", "()Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "bitmapCacheOverride", "Lcom/facebook/imagepipeline/image/CloseableImage;", "getBitmapCacheOverride", "nonBitmapImageMemoryCacheParamsSupplier", "getNonBitmapImageMemoryCacheParamsSupplier", "similarImageLookup", "Lcom/facebook/imagepipeline/cache/SimilarImageLookup;", "getSimilarImageLookup", "()Lcom/facebook/imagepipeline/cache/SimilarImageLookup;", "networkFetcher", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "getNetworkFetcher", "()Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "isResizeAndRotateEnabledForNetwork", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "getImageDecoder", "()Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "imageDecoderConfig", "Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "getImageDecoderConfig", "()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "getDownsampleMode", "()Lcom/facebook/imagepipeline/core/DownsampleMode;", "imageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "getImageTranscoderFactory", "()Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "imageTranscoderType", "", "getImageTranscoderType", "()Ljava/lang/Integer;", "enableEncodedImageColorSpaceUsage", "getEnableEncodedImageColorSpaceUsage", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "getProgressiveJpegConfig", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "getPlatformBitmapFactory", "()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "defaultIntermediateImageBitmapTransformation", "Lcom/facebook/imagepipeline/transformation/BitmapTransformation;", "getDefaultIntermediateImageBitmapTransformation", "()Lcom/facebook/imagepipeline/transformation/BitmapTransformation;", "memoryChunkType", "getMemoryChunkType", "()I", "memoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "getMemoryTrimmableRegistry", "()Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "customProducerSequenceFactories", "Lcom/facebook/imagepipeline/producers/CustomProducerSequenceFactory;", "getCustomProducerSequenceFactories", "closeableReferenceLeakTracker", "Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "getCloseableReferenceLeakTracker", "()Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "poolFactory", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "getPoolFactory", "()Lcom/facebook/imagepipeline/memory/PoolFactory;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "getExecutorSupplier", "()Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "executorServiceForAnimatedImages", "Lcom/facebook/common/executors/SerialExecutorService;", "getExecutorServiceForAnimatedImages", "()Lcom/facebook/common/executors/SerialExecutorService;", "isPrefetchEnabledSupplier", "callerContextVerifier", "Lcom/facebook/callercontext/CallerContextVerifier;", "getCallerContextVerifier", "()Lcom/facebook/callercontext/CallerContextVerifier;", "decodedOriginalImageAnalyzers", "Lcom/facebook/imagepipeline/producers/DecodeProducer$DecodedOriginalImageAnalyzer;", "getDecodedOriginalImageAnalyzers", "isAppStarting", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "experiments", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "getExperiments", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ImagePipelineConfigInterface {
    MemoryCache<CacheKey, CloseableImage> getBitmapCacheOverride();

    Bitmap.Config getBitmapConfig();

    CountingMemoryCache.EntryStateObserver<CacheKey> getBitmapMemoryCacheEntryStateObserver();

    BitmapMemoryCacheFactory getBitmapMemoryCacheFactory();

    Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier();

    MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy();

    CacheKeyFactory getCacheKeyFactory();

    CallerContextVerifier getCallerContextVerifier();

    CloseableReferenceLeakTracker getCloseableReferenceLeakTracker();

    Context getContext();

    Set<CustomProducerSequenceFactory> getCustomProducerSequenceFactories();

    Set<DecodeProducer.DecodedOriginalImageAnalyzer> getDecodedOriginalImageAnalyzers();

    default BitmapTransformation getDefaultIntermediateImageBitmapTransformation() {
        return null;
    }

    Supplier<DiskCachesStore> getDiskCachesStoreSupplier();

    DownsampleMode getDownsampleMode();

    Map<String, DiskCacheConfig> getDynamicDiskCacheConfigMap();

    Supplier<Boolean> getEnableEncodedImageColorSpaceUsage();

    MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCacheOverride();

    Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier();

    MemoryCache.CacheTrimStrategy getEncodedMemoryCacheTrimStrategy();

    SerialExecutorService getExecutorServiceForAnimatedImages();

    ExecutorSupplier getExecutorSupplier();

    ImagePipelineExperiments getExperiments();

    ImageCacheStatsTracker getImageCacheStatsTracker();

    ImageDecoder getImageDecoder();

    ImageDecoderConfig getImageDecoderConfig();

    ImageTranscoderFactory getImageTranscoderFactory();

    Integer getImageTranscoderType();

    DiskCacheConfig getMainDiskCacheConfig();

    int getMemoryChunkType();

    MemoryTrimmableRegistry getMemoryTrimmableRegistry();

    NetworkFetcher<?> getNetworkFetcher();

    Supplier<MemoryCacheParams> getNonBitmapImageMemoryCacheParamsSupplier();

    PlatformBitmapFactory getPlatformBitmapFactory();

    PoolFactory getPoolFactory();

    ProgressiveJpegConfig getProgressiveJpegConfig();

    Set<RequestListener2> getRequestListener2s();

    Set<RequestListener> getRequestListeners();

    default SimilarImageLookup getSimilarImageLookup() {
        return null;
    }

    DiskCacheConfig getSmallImageDiskCacheConfig();

    Function0<Boolean> isAppStarting();

    /* JADX INFO: renamed from: isDiskCacheEnabled */
    boolean getIsDiskCacheEnabled();

    Supplier<Boolean> isPrefetchEnabledSupplier();

    /* JADX INFO: renamed from: isResizeAndRotateEnabledForNetwork */
    boolean getIsResizeAndRotateEnabledForNetwork();

    /* JADX INFO: compiled from: ImagePipelineConfigInterface.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static SimilarImageLookup getSimilarImageLookup(ImagePipelineConfigInterface imagePipelineConfigInterface) {
            return ImagePipelineConfigInterface.super.getSimilarImageLookup();
        }

        @Deprecated
        public static BitmapTransformation getDefaultIntermediateImageBitmapTransformation(ImagePipelineConfigInterface imagePipelineConfigInterface) {
            return ImagePipelineConfigInterface.super.getDefaultIntermediateImageBitmapTransformation();
        }
    }
}
