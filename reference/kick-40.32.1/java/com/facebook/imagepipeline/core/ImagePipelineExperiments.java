package com.facebook.imagepipeline.core;

import android.content.Context;
import android.os.Looper;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.platform.PlatformDecoderOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePipelineExperiments.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 r2\u00020\u0001:\u0004opqrB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\fR\u0011\u0010!\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010#\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0011\u0010$\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\fR\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0*¢\u0006\b\n\u0000\u001a\u0004\b)\u0010+R\u0011\u0010,\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\fR\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0*¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0011\u00100\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\fR\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0011\u00107\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\fR\u0011\u00109\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\fR\u0011\u0010;\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\fR\u0011\u0010<\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\fR\u0011\u0010=\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\fR\u0011\u0010>\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\fR\u0011\u0010?\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001aR\u0011\u0010A\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\fR\u0011\u0010C\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\fR\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0F¢\u0006\b\n\u0000\u001a\u0004\bE\u0010GR\u0011\u0010H\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\fR\u0011\u0010J\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\fR\u0011\u0010L\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\fR\u0011\u0010N\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\fR\u0011\u0010P\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\fR\u0011\u0010R\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u001aR\u0011\u0010T\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\fR\u0011\u0010V\u001a\u00020W¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0011\u0010Z\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\fR\u0011\u0010[\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\fR\u0011\u0010]\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\fR\u0011\u0010_\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\fR\u0011\u0010a\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\fR\u0011\u0010c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\fR\u0011\u0010e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\fR\u0011\u0010g\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\fR\u0011\u0010i\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\fR\u0011\u0010k\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\fR\u0011\u0010m\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bn\u0010\f¨\u0006s"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "", "builder", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "<init>", "(Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;)V", "webpErrorLogger", "Lcom/facebook/common/webp/WebpBitmapFactory$WebpErrorLogger;", "getWebpErrorLogger", "()Lcom/facebook/common/webp/WebpBitmapFactory$WebpErrorLogger;", "isDecodeCancellationEnabled", "", "()Z", "webpBitmapFactory", "Lcom/facebook/common/webp/WebpBitmapFactory;", "getWebpBitmapFactory", "()Lcom/facebook/common/webp/WebpBitmapFactory;", "useDownsamplingRatioForResizing", "getUseDownsamplingRatioForResizing", "useBitmapPrepareToDraw", "getUseBitmapPrepareToDraw", "useBalancedAnimationStrategy", "getUseBalancedAnimationStrategy", "animationStrategyBufferLengthMilliseconds", "", "getAnimationStrategyBufferLengthMilliseconds", "()I", "bitmapPrepareToDrawMinSizeBytes", "getBitmapPrepareToDrawMinSizeBytes", "bitmapPrepareToDrawMaxSizeBytes", "getBitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "getBitmapPrepareToDrawForPrefetch", "maxBitmapDimension", "getMaxBitmapDimension", "isNativeCodeDisabled", "isPartialImageCachingEnabled", "producerFactoryMethod", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "getProducerFactoryMethod", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "isLazyDataSource", "Lcom/facebook/common/internal/Supplier;", "()Lcom/facebook/common/internal/Supplier;", "downscaleFrameToDrawableDimensions", "getDownscaleFrameToDrawableDimensions", "suppressBitmapPrefetchingSupplier", "getSuppressBitmapPrefetchingSupplier", "isExperimentalThreadHandoffQueueEnabled", "throttlingProducerMaxSimultaneousRequests", "", "getThrottlingProducerMaxSimultaneousRequests", "()J", "memoryType", "getMemoryType", "keepCancelledFetchAsLowPriority", "getKeepCancelledFetchAsLowPriority", "downsampleIfLargeBitmap", "getDownsampleIfLargeBitmap", "isEncodedCacheEnabled", "isEnsureTranscoderLibraryLoaded", "isEncodedMemoryCacheProbingEnabled", "isDiskCacheProbingEnabled", "trackedKeysSize", "getTrackedKeysSize", "allowDelay", "getAllowDelay", "handOffOnUiThreadOnly", "getHandOffOnUiThreadOnly", "isCriticalThread", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "shouldStoreCacheEntrySize", "getShouldStoreCacheEntrySize", "shouldIgnoreCacheSizeMismatch", "getShouldIgnoreCacheSizeMismatch", "shouldUseDecodingBufferHelper", "getShouldUseDecodingBufferHelper", "allowProgressiveOnPrefetch", "getAllowProgressiveOnPrefetch", "cancelDecodeOnCacheMiss", "getCancelDecodeOnCacheMiss", "animationRenderFpsLimit", "getAnimationRenderFpsLimit", "prefetchShortcutEnabled", "getPrefetchShortcutEnabled", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "getPlatformDecoderOptions", "()Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "isBinaryXmlEnabled", "loadThumbnailFromContentResolverFirst", "getLoadThumbnailFromContentResolverFirst", "loadThumbnailFromContentResolverForContentUriOnly", "getLoadThumbnailFromContentResolverForContentUriOnly", "preserveMetadataOnDisk", "getPreserveMetadataOnDisk", "preserveMetadataOnDiskDuringStartup", "getPreserveMetadataOnDiskDuringStartup", "intermediateProgressUpdatesDisabled", "getIntermediateProgressUpdatesDisabled", "intermediateProgressUpdatesForPrefetchDisabled", "getIntermediateProgressUpdatesForPrefetchDisabled", "throwCacheMissExceptionOnCacheMiss", "getThrowCacheMissExceptionOnCacheMiss", "usePostProcessedCacheKey", "getUsePostProcessedCacheKey", "usePostprocessorDuringDecodedPrefetch", "getUsePostprocessorDuringDecodedPrefetch", "useSeparateNonBitmapImageCache", "getUseSeparateNonBitmapImageCache", "Builder", "ProducerFactoryMethod", "DefaultProducerFactoryMethod", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImagePipelineExperiments {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean allowDelay;
    private final boolean allowProgressiveOnPrefetch;
    private final int animationRenderFpsLimit;
    private final int animationStrategyBufferLengthMilliseconds;
    private final boolean bitmapPrepareToDrawForPrefetch;
    private final int bitmapPrepareToDrawMaxSizeBytes;
    private final int bitmapPrepareToDrawMinSizeBytes;
    private final boolean cancelDecodeOnCacheMiss;
    private final boolean downsampleIfLargeBitmap;
    private final boolean downscaleFrameToDrawableDimensions;
    private final boolean handOffOnUiThreadOnly;
    private final boolean intermediateProgressUpdatesDisabled;
    private final boolean intermediateProgressUpdatesForPrefetchDisabled;
    private final boolean isBinaryXmlEnabled;
    private final Function0<Boolean> isCriticalThread;
    private final boolean isDecodeCancellationEnabled;
    private final boolean isDiskCacheProbingEnabled;
    private final boolean isEncodedCacheEnabled;
    private final boolean isEncodedMemoryCacheProbingEnabled;
    private final boolean isEnsureTranscoderLibraryLoaded;
    private final boolean isExperimentalThreadHandoffQueueEnabled;
    private final Supplier<Boolean> isLazyDataSource;
    private final boolean isNativeCodeDisabled;
    private final boolean isPartialImageCachingEnabled;
    private final boolean keepCancelledFetchAsLowPriority;
    private final boolean loadThumbnailFromContentResolverFirst;
    private final boolean loadThumbnailFromContentResolverForContentUriOnly;
    private final int maxBitmapDimension;
    private final long memoryType;
    private final PlatformDecoderOptions platformDecoderOptions;
    private final boolean prefetchShortcutEnabled;
    private final boolean preserveMetadataOnDisk;
    private final boolean preserveMetadataOnDiskDuringStartup;
    private final ProducerFactoryMethod producerFactoryMethod;
    private final boolean shouldIgnoreCacheSizeMismatch;
    private final boolean shouldStoreCacheEntrySize;
    private final boolean shouldUseDecodingBufferHelper;
    private final Supplier<Boolean> suppressBitmapPrefetchingSupplier;
    private final long throttlingProducerMaxSimultaneousRequests;
    private final boolean throwCacheMissExceptionOnCacheMiss;
    private final int trackedKeysSize;
    private final boolean useBalancedAnimationStrategy;
    private final boolean useBitmapPrepareToDraw;
    private final boolean useDownsamplingRatioForResizing;
    private final boolean usePostProcessedCacheKey;
    private final boolean usePostprocessorDuringDecodedPrefetch;
    private final boolean useSeparateNonBitmapImageCache;
    private final WebpBitmapFactory webpBitmapFactory;
    private final WebpBitmapFactory.WebpErrorLogger webpErrorLogger;

    /* JADX INFO: compiled from: ImagePipelineExperiments.kt */
    @Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JÞ\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c0\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H&¨\u0006/À\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "", "createProducerFactory", "Lcom/facebook/imagepipeline/core/ProducerFactory;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "byteArrayPool", "Lcom/facebook/common/memory/ByteArrayPool;", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "resizeAndRotateEnabledForNetwork", "", "decodeCancellationEnabled", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "bitmapMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapPrepareToDrawMinSizeBytes", "", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapSize", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "keepCancelledFetchAsLowPriority", "trackedKeysSize", "config", "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ProducerFactoryMethod {
        ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, DownsampleMode downsampleMode, boolean resizeAndRotateEnabledForNetwork, boolean decodeCancellationEnabled, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache, Supplier<DiskCachesStore> diskCachesStoreSupplier, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int bitmapPrepareToDrawMinSizeBytes, int bitmapPrepareToDrawMaxSizeBytes, boolean bitmapPrepareToDrawForPrefetch, int maxBitmapSize, CloseableReferenceFactory closeableReferenceFactory, boolean keepCancelledFetchAsLowPriority, int trackedKeysSize, ImagePipelineConfigInterface config);
    }

    public /* synthetic */ ImagePipelineExperiments(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    public static final Builder newBuilder(ImagePipelineConfig.Builder builder) {
        return INSTANCE.newBuilder(builder);
    }

    private ImagePipelineExperiments(Builder builder) {
        this.webpErrorLogger = builder.webpErrorLogger;
        this.isDecodeCancellationEnabled = builder.decodeCancellationEnabled;
        this.webpBitmapFactory = builder.webpBitmapFactory;
        this.useDownsamplingRatioForResizing = builder.useDownsamplingRatioForResizing;
        this.useBitmapPrepareToDraw = builder.useBitmapPrepareToDraw;
        this.useBalancedAnimationStrategy = builder.useBalancedAnimationStrategy;
        this.animationStrategyBufferLengthMilliseconds = builder.animationStrategyBufferLengthMilliseconds;
        this.bitmapPrepareToDrawMinSizeBytes = builder.bitmapPrepareToDrawMinSizeBytes;
        this.bitmapPrepareToDrawMaxSizeBytes = builder.bitmapPrepareToDrawMaxSizeBytes;
        this.bitmapPrepareToDrawForPrefetch = builder.bitmapPrepareToDrawForPrefetch;
        this.maxBitmapDimension = builder.maxBitmapDimension;
        this.isNativeCodeDisabled = builder.nativeCodeDisabled;
        this.isPartialImageCachingEnabled = builder.isPartialImageCachingEnabled;
        DefaultProducerFactoryMethod defaultProducerFactoryMethod = builder.producerFactoryMethod;
        this.producerFactoryMethod = defaultProducerFactoryMethod == null ? new DefaultProducerFactoryMethod() : defaultProducerFactoryMethod;
        Supplier<Boolean> BOOLEAN_FALSE = builder.lazyDataSource;
        if (BOOLEAN_FALSE == null) {
            BOOLEAN_FALSE = Suppliers.BOOLEAN_FALSE;
            Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        }
        this.isLazyDataSource = BOOLEAN_FALSE;
        this.downscaleFrameToDrawableDimensions = builder.downscaleFrameToDrawableDimensions;
        this.suppressBitmapPrefetchingSupplier = builder.suppressBitmapPrefetchingSupplier;
        this.isExperimentalThreadHandoffQueueEnabled = builder.experimentalThreadHandoffQueueEnabled;
        this.throttlingProducerMaxSimultaneousRequests = builder.throttlingProducerMaxSimultaneousRequests;
        this.memoryType = builder.memoryType;
        this.keepCancelledFetchAsLowPriority = builder.keepCancelledFetchAsLowPriority;
        this.downsampleIfLargeBitmap = builder.downsampleIfLargeBitmap;
        this.isEncodedCacheEnabled = builder.encodedCacheEnabled;
        this.isEnsureTranscoderLibraryLoaded = builder.ensureTranscoderLibraryLoaded;
        this.isEncodedMemoryCacheProbingEnabled = builder.isEncodedMemoryCacheProbingEnabled;
        this.isDiskCacheProbingEnabled = builder.isDiskCacheProbingEnabled;
        this.trackedKeysSize = builder.trackedKeysSize;
        this.allowProgressiveOnPrefetch = builder.allowProgressiveOnPrefetch;
        this.animationRenderFpsLimit = builder.animationRenderFpsLimit;
        this.allowDelay = builder.allowDelay;
        this.handOffOnUiThreadOnly = builder.handOffOnUiThreadOnly;
        Function0<Boolean> function0 = builder.isCriticalThread;
        this.isCriticalThread = function0 == null ? new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ImagePipelineExperiments._init_$lambda$0(this.f$0));
            }
        } : function0;
        this.shouldStoreCacheEntrySize = builder.shouldStoreCacheEntrySize;
        this.shouldIgnoreCacheSizeMismatch = builder.shouldIgnoreCacheSizeMismatch;
        this.shouldUseDecodingBufferHelper = builder.shouldUseDecodingBufferHelper;
        this.cancelDecodeOnCacheMiss = builder.cancelDecodeOnCacheMiss;
        this.prefetchShortcutEnabled = builder.prefetchShortcutEnabled;
        this.platformDecoderOptions = builder.platformDecoderOptions;
        this.isBinaryXmlEnabled = builder.isBinaryXmlEnabled;
        this.loadThumbnailFromContentResolverFirst = builder.loadThumbnailFromContentResolverFirst;
        this.loadThumbnailFromContentResolverForContentUriOnly = builder.loadThumbnailFromContentResolverForContentUriOnly;
        this.preserveMetadataOnDisk = builder.preserveMetadataOnDisk;
        this.preserveMetadataOnDiskDuringStartup = builder.preserveMetadataOnDiskDuringStartup;
        this.intermediateProgressUpdatesDisabled = builder.intermediateProgressUpdatesDisabled;
        this.intermediateProgressUpdatesForPrefetchDisabled = builder.intermediateProgressUpdatesForPrefetchDisabled;
        this.throwCacheMissExceptionOnCacheMiss = builder.throwCacheMissExceptionOnCacheMiss;
        this.usePostProcessedCacheKey = builder.usePostProcessedCacheKey;
        this.usePostprocessorDuringDecodedPrefetch = builder.usePostprocessorDuringDecodedPrefetch;
        this.useSeparateNonBitmapImageCache = builder.useSeparateNonBitmapImageCache;
    }

    public final WebpBitmapFactory.WebpErrorLogger getWebpErrorLogger() {
        return this.webpErrorLogger;
    }

    /* JADX INFO: renamed from: isDecodeCancellationEnabled, reason: from getter */
    public final boolean getIsDecodeCancellationEnabled() {
        return this.isDecodeCancellationEnabled;
    }

    public final WebpBitmapFactory getWebpBitmapFactory() {
        return this.webpBitmapFactory;
    }

    public final boolean getUseDownsamplingRatioForResizing() {
        return this.useDownsamplingRatioForResizing;
    }

    public final boolean getUseBitmapPrepareToDraw() {
        return this.useBitmapPrepareToDraw;
    }

    public final boolean getUseBalancedAnimationStrategy() {
        return this.useBalancedAnimationStrategy;
    }

    public final int getAnimationStrategyBufferLengthMilliseconds() {
        return this.animationStrategyBufferLengthMilliseconds;
    }

    public final int getBitmapPrepareToDrawMinSizeBytes() {
        return this.bitmapPrepareToDrawMinSizeBytes;
    }

    public final int getBitmapPrepareToDrawMaxSizeBytes() {
        return this.bitmapPrepareToDrawMaxSizeBytes;
    }

    public final boolean getBitmapPrepareToDrawForPrefetch() {
        return this.bitmapPrepareToDrawForPrefetch;
    }

    public final int getMaxBitmapDimension() {
        return this.maxBitmapDimension;
    }

    /* JADX INFO: renamed from: isNativeCodeDisabled, reason: from getter */
    public final boolean getIsNativeCodeDisabled() {
        return this.isNativeCodeDisabled;
    }

    /* JADX INFO: renamed from: isPartialImageCachingEnabled, reason: from getter */
    public final boolean getIsPartialImageCachingEnabled() {
        return this.isPartialImageCachingEnabled;
    }

    public final ProducerFactoryMethod getProducerFactoryMethod() {
        return this.producerFactoryMethod;
    }

    public final Supplier<Boolean> isLazyDataSource() {
        return this.isLazyDataSource;
    }

    public final boolean getDownscaleFrameToDrawableDimensions() {
        return this.downscaleFrameToDrawableDimensions;
    }

    public final Supplier<Boolean> getSuppressBitmapPrefetchingSupplier() {
        return this.suppressBitmapPrefetchingSupplier;
    }

    /* JADX INFO: renamed from: isExperimentalThreadHandoffQueueEnabled, reason: from getter */
    public final boolean getIsExperimentalThreadHandoffQueueEnabled() {
        return this.isExperimentalThreadHandoffQueueEnabled;
    }

    public final long getThrottlingProducerMaxSimultaneousRequests() {
        return this.throttlingProducerMaxSimultaneousRequests;
    }

    public final long getMemoryType() {
        return this.memoryType;
    }

    public final boolean getKeepCancelledFetchAsLowPriority() {
        return this.keepCancelledFetchAsLowPriority;
    }

    public final boolean getDownsampleIfLargeBitmap() {
        return this.downsampleIfLargeBitmap;
    }

    /* JADX INFO: renamed from: isEncodedCacheEnabled, reason: from getter */
    public final boolean getIsEncodedCacheEnabled() {
        return this.isEncodedCacheEnabled;
    }

    /* JADX INFO: renamed from: isEnsureTranscoderLibraryLoaded, reason: from getter */
    public final boolean getIsEnsureTranscoderLibraryLoaded() {
        return this.isEnsureTranscoderLibraryLoaded;
    }

    /* JADX INFO: renamed from: isEncodedMemoryCacheProbingEnabled, reason: from getter */
    public final boolean getIsEncodedMemoryCacheProbingEnabled() {
        return this.isEncodedMemoryCacheProbingEnabled;
    }

    /* JADX INFO: renamed from: isDiskCacheProbingEnabled, reason: from getter */
    public final boolean getIsDiskCacheProbingEnabled() {
        return this.isDiskCacheProbingEnabled;
    }

    public final int getTrackedKeysSize() {
        return this.trackedKeysSize;
    }

    public final boolean getAllowDelay() {
        return this.allowDelay;
    }

    public final boolean getHandOffOnUiThreadOnly() {
        return this.handOffOnUiThreadOnly;
    }

    public final Function0<Boolean> isCriticalThread() {
        return this.isCriticalThread;
    }

    public final boolean getShouldStoreCacheEntrySize() {
        return this.shouldStoreCacheEntrySize;
    }

    public final boolean getShouldIgnoreCacheSizeMismatch() {
        return this.shouldIgnoreCacheSizeMismatch;
    }

    public final boolean getShouldUseDecodingBufferHelper() {
        return this.shouldUseDecodingBufferHelper;
    }

    public final boolean getAllowProgressiveOnPrefetch() {
        return this.allowProgressiveOnPrefetch;
    }

    public final boolean getCancelDecodeOnCacheMiss() {
        return this.cancelDecodeOnCacheMiss;
    }

    public final int getAnimationRenderFpsLimit() {
        return this.animationRenderFpsLimit;
    }

    public final boolean getPrefetchShortcutEnabled() {
        return this.prefetchShortcutEnabled;
    }

    public final PlatformDecoderOptions getPlatformDecoderOptions() {
        return this.platformDecoderOptions;
    }

    /* JADX INFO: renamed from: isBinaryXmlEnabled, reason: from getter */
    public final boolean getIsBinaryXmlEnabled() {
        return this.isBinaryXmlEnabled;
    }

    public final boolean getLoadThumbnailFromContentResolverFirst() {
        return this.loadThumbnailFromContentResolverFirst;
    }

    public final boolean getLoadThumbnailFromContentResolverForContentUriOnly() {
        return this.loadThumbnailFromContentResolverForContentUriOnly;
    }

    public final boolean getPreserveMetadataOnDisk() {
        return this.preserveMetadataOnDisk;
    }

    public final boolean getPreserveMetadataOnDiskDuringStartup() {
        return this.preserveMetadataOnDiskDuringStartup;
    }

    public final boolean getIntermediateProgressUpdatesDisabled() {
        return this.intermediateProgressUpdatesDisabled;
    }

    public final boolean getIntermediateProgressUpdatesForPrefetchDisabled() {
        return this.intermediateProgressUpdatesForPrefetchDisabled;
    }

    public final boolean getThrowCacheMissExceptionOnCacheMiss() {
        return this.throwCacheMissExceptionOnCacheMiss;
    }

    public final boolean getUsePostProcessedCacheKey() {
        return this.usePostProcessedCacheKey;
    }

    public final boolean getUsePostprocessorDuringDecodedPrefetch() {
        return this.usePostprocessorDuringDecodedPrefetch;
    }

    public final boolean getUseSeparateNonBitmapImageCache() {
        return this.useSeparateNonBitmapImageCache;
    }

    /* JADX INFO: compiled from: ImagePipelineExperiments.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b9\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010A\u001a\u00020\u00002\f\u0010B\u001a\b\u0012\u0004\u0012\u00020C0-H\u0002J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0007J\u0014\u0010E\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070-J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0007J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0007J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010N\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010O\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ&\u0010P\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\u0007J\u000e\u0010T\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010W\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007J\u0010\u0010X\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0016\u0010Y\u001a\u00020\u00002\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001bJ\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0007J\u0014\u0010[\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bJ\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020!J\u000e\u0010_\u001a\u00020\u00002\u0006\u0010`\u001a\u00020!J\u000e\u0010a\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0007J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010c\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010d\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010e\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010f\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0011J\u000e\u0010h\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010i\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0007J\u000e\u0010j\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0011J\u000e\u0010k\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0007J\u000e\u0010l\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u0010m\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u0007J\u000e\u0010o\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0007J\u000e\u0010p\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0007J\u000e\u0010q\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0007J\u000e\u0010s\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0007J\u000e\u0010t\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u0007J\u000e\u0010v\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u0007J\u000e\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020\u0007J\u000e\u0010y\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0007J\u000e\u0010z\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0007J\u000e\u0010{\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0007J\u0006\u0010|\u001a\u00020}R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00070\u00070\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010@\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "", "configBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "<init>", "(Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;)V", "shouldUseDecodingBufferHelper", "", "webpErrorLogger", "Lcom/facebook/common/webp/WebpBitmapFactory$WebpErrorLogger;", "decodeCancellationEnabled", "webpBitmapFactory", "Lcom/facebook/common/webp/WebpBitmapFactory;", "useDownsamplingRatioForResizing", "useBitmapPrepareToDraw", "useBalancedAnimationStrategy", "animationStrategyBufferLengthMilliseconds", "", "bitmapPrepareToDrawMinSizeBytes", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapDimension", "nativeCodeDisabled", "isPartialImageCachingEnabled", "producerFactoryMethod", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "lazyDataSource", "Lcom/facebook/common/internal/Supplier;", "downscaleFrameToDrawableDimensions", "suppressBitmapPrefetchingSupplier", "kotlin.jvm.PlatformType", "experimentalThreadHandoffQueueEnabled", "throttlingProducerMaxSimultaneousRequests", "", "memoryType", "keepCancelledFetchAsLowPriority", "downsampleIfLargeBitmap", "encodedCacheEnabled", "ensureTranscoderLibraryLoaded", "isEncodedMemoryCacheProbingEnabled", "isDiskCacheProbingEnabled", "trackedKeysSize", "allowDelay", "handOffOnUiThreadOnly", "isCriticalThread", "Lkotlin/Function0;", "shouldStoreCacheEntrySize", "shouldIgnoreCacheSizeMismatch", "allowProgressiveOnPrefetch", "animationRenderFpsLimit", "cancelDecodeOnCacheMiss", "prefetchShortcutEnabled", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "isBinaryXmlEnabled", "loadThumbnailFromContentResolverFirst", "loadThumbnailFromContentResolverForContentUriOnly", "preserveMetadataOnDisk", "preserveMetadataOnDiskDuringStartup", "intermediateProgressUpdatesDisabled", "intermediateProgressUpdatesForPrefetchDisabled", "throwCacheMissExceptionOnCacheMiss", "usePostProcessedCacheKey", "usePostprocessorDuringDecodedPrefetch", "useSeparateNonBitmapImageCache", "asBuilder", "block", "", "setHandOffOnUiThreadOnly", "setIsCriticalThread", "setStoreCacheEntrySize", "setIgnoreCacheSizeMismatch", "setPrefetchShortcutEnabled", "setShouldUseDecodingBufferHelper", "setUseDownsampligRatioForResizing", "setPartialImageCachingEnabled", "partialImageCachingEnabled", "setDecodeCancellationEnabled", "setWebpErrorLogger", "setWebpBitmapFactory", "setBitmapPrepareToDraw", "minBitmapSizeBytes", "maxBitmapSizeBytes", "preparePrefetch", "setBalancedAnimationStrategy", "setAnimationStrategyBufferLengthMilliseconds", "setMaxBitmapDimension", "setNativeCodeDisabled", "setProducerFactoryMethod", "setLazyDataSource", "setShouldDownscaleFrameToDrawableDimensions", "setSuppressBitmapPrefetchingSupplier", "setExperimentalThreadHandoffQueueEnabled", "setThrottlingProducerMaxSimultaneousRequests", "maxSimultaneousRequests", "setExperimentalMemoryType", "MemoryType", "setKeepCancelledFetchAsLowPriority", "setDownsampleIfLargeBitmap", "setEncodedCacheEnabled", "setEnsureTranscoderLibraryLoaded", "setIsDiskCacheProbingEnabled", "setIsEncodedMemoryCacheProbingEnabled", "setTrackedKeysSize", "setAllowDelay", "setAllowProgressiveOnPrefetch", "setAnimationRenderFpsLimit", "setCancelDecodeOnCacheMiss", "setPlatformDecoderOptions", "setBinaryXmlEnabled", "binaryXmlEnabled", "setLoadThumbnailFromContentResolverFirst", "setLoadThumbnailFromContentResolverForContentUriOnly", "setPreserveMetadataOnDisk", "preserve", "setPreserveMetadataOnDiskDuringStartup", "setIntermediateProgressUpdatesDisabled", "updatesDisabled", "setIntermediateProgressUpdatesForPrefetchDisabled", "setThrowCacheMissExceptionOnCacheMiss", "throwException", "setUsePostProcessedCacheKey", "setUsePostprocessorDuringDecodedPrefetch", "setUseSeparateNonBitmapImageCache", "build", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public boolean allowDelay;
        public boolean allowProgressiveOnPrefetch;
        public int animationRenderFpsLimit;
        public int animationStrategyBufferLengthMilliseconds;
        public boolean bitmapPrepareToDrawForPrefetch;
        public int bitmapPrepareToDrawMaxSizeBytes;
        public int bitmapPrepareToDrawMinSizeBytes;
        public boolean cancelDecodeOnCacheMiss;
        private final ImagePipelineConfig.Builder configBuilder;
        public boolean decodeCancellationEnabled;
        public boolean downsampleIfLargeBitmap;
        public boolean downscaleFrameToDrawableDimensions;
        public boolean encodedCacheEnabled;
        public boolean ensureTranscoderLibraryLoaded;
        public boolean experimentalThreadHandoffQueueEnabled;
        public boolean handOffOnUiThreadOnly;
        public boolean intermediateProgressUpdatesDisabled;
        public boolean intermediateProgressUpdatesForPrefetchDisabled;
        public boolean isBinaryXmlEnabled;
        public Function0<Boolean> isCriticalThread;
        public boolean isDiskCacheProbingEnabled;
        public boolean isEncodedMemoryCacheProbingEnabled;
        public boolean isPartialImageCachingEnabled;
        public boolean keepCancelledFetchAsLowPriority;
        public Supplier<Boolean> lazyDataSource;
        public boolean loadThumbnailFromContentResolverFirst;
        public boolean loadThumbnailFromContentResolverForContentUriOnly;
        public int maxBitmapDimension;
        public long memoryType;
        public boolean nativeCodeDisabled;
        public PlatformDecoderOptions platformDecoderOptions;
        public boolean prefetchShortcutEnabled;
        public boolean preserveMetadataOnDisk;
        public boolean preserveMetadataOnDiskDuringStartup;
        public ProducerFactoryMethod producerFactoryMethod;
        public boolean shouldIgnoreCacheSizeMismatch;
        public boolean shouldStoreCacheEntrySize;
        public boolean shouldUseDecodingBufferHelper;
        public Supplier<Boolean> suppressBitmapPrefetchingSupplier;
        public long throttlingProducerMaxSimultaneousRequests;
        public boolean throwCacheMissExceptionOnCacheMiss;
        public int trackedKeysSize;
        public boolean useBalancedAnimationStrategy;
        public boolean useBitmapPrepareToDraw;
        public boolean useDownsamplingRatioForResizing;
        public boolean usePostProcessedCacheKey;
        public boolean usePostprocessorDuringDecodedPrefetch;
        public boolean useSeparateNonBitmapImageCache;
        public WebpBitmapFactory webpBitmapFactory;
        public WebpBitmapFactory.WebpErrorLogger webpErrorLogger;

        public Builder(ImagePipelineConfig.Builder configBuilder) {
            Intrinsics.checkNotNullParameter(configBuilder, "configBuilder");
            this.configBuilder = configBuilder;
            this.animationStrategyBufferLengthMilliseconds = 1000;
            this.maxBitmapDimension = 2048;
            Supplier<Boolean> supplierOf = Suppliers.of(false);
            Intrinsics.checkNotNullExpressionValue(supplierOf, "of(...)");
            this.suppressBitmapPrefetchingSupplier = supplierOf;
            this.throttlingProducerMaxSimultaneousRequests = 5L;
            this.encodedCacheEnabled = true;
            this.ensureTranscoderLibraryLoaded = true;
            this.trackedKeysSize = 20;
            this.animationRenderFpsLimit = 30;
            this.platformDecoderOptions = new PlatformDecoderOptions(false, false, false, false, null, false, false, false, false, false, false, 2047, null);
        }

        private final Builder asBuilder(Function0<Unit> block) {
            block.invoke();
            return this;
        }

        public final Builder setHandOffOnUiThreadOnly(final boolean handOffOnUiThreadOnly) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setHandOffOnUiThreadOnly$lambda$0(this.f$0, handOffOnUiThreadOnly);
                }
            });
        }

        static final Unit setHandOffOnUiThreadOnly$lambda$0(Builder builder, boolean z) {
            builder.handOffOnUiThreadOnly = z;
            return Unit.INSTANCE;
        }

        public final Builder setIsCriticalThread(final Function0<Boolean> isCriticalThread) {
            Intrinsics.checkNotNullParameter(isCriticalThread, "isCriticalThread");
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setIsCriticalThread$lambda$1(this.f$0, isCriticalThread);
                }
            });
        }

        static final Unit setIsCriticalThread$lambda$1(Builder builder, Function0 function0) {
            builder.isCriticalThread = function0;
            return Unit.INSTANCE;
        }

        public final Builder setStoreCacheEntrySize(final boolean shouldStoreCacheEntrySize) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setStoreCacheEntrySize$lambda$2(this.f$0, shouldStoreCacheEntrySize);
                }
            });
        }

        static final Unit setStoreCacheEntrySize$lambda$2(Builder builder, boolean z) {
            builder.shouldStoreCacheEntrySize = z;
            return Unit.INSTANCE;
        }

        public final Builder setIgnoreCacheSizeMismatch(final boolean shouldIgnoreCacheSizeMismatch) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setIgnoreCacheSizeMismatch$lambda$3(this.f$0, shouldIgnoreCacheSizeMismatch);
                }
            });
        }

        static final Unit setIgnoreCacheSizeMismatch$lambda$3(Builder builder, boolean z) {
            builder.shouldIgnoreCacheSizeMismatch = z;
            return Unit.INSTANCE;
        }

        public final Builder setPrefetchShortcutEnabled(final boolean prefetchShortcutEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setPrefetchShortcutEnabled$lambda$4(this.f$0, prefetchShortcutEnabled);
                }
            });
        }

        static final Unit setPrefetchShortcutEnabled$lambda$4(Builder builder, boolean z) {
            builder.prefetchShortcutEnabled = z;
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: shouldUseDecodingBufferHelper, reason: from getter */
        public final boolean getShouldUseDecodingBufferHelper() {
            return this.shouldUseDecodingBufferHelper;
        }

        public final Builder setShouldUseDecodingBufferHelper(final boolean shouldUseDecodingBufferHelper) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setShouldUseDecodingBufferHelper$lambda$5(this.f$0, shouldUseDecodingBufferHelper);
                }
            });
        }

        static final Unit setShouldUseDecodingBufferHelper$lambda$5(Builder builder, boolean z) {
            builder.shouldUseDecodingBufferHelper = z;
            return Unit.INSTANCE;
        }

        public final Builder setUseDownsampligRatioForResizing(final boolean useDownsamplingRatioForResizing) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setUseDownsampligRatioForResizing$lambda$6(this.f$0, useDownsamplingRatioForResizing);
                }
            });
        }

        static final Unit setUseDownsampligRatioForResizing$lambda$6(Builder builder, boolean z) {
            builder.useDownsamplingRatioForResizing = z;
            return Unit.INSTANCE;
        }

        public final Builder setPartialImageCachingEnabled(final boolean partialImageCachingEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setPartialImageCachingEnabled$lambda$7(this.f$0, partialImageCachingEnabled);
                }
            });
        }

        static final Unit setPartialImageCachingEnabled$lambda$7(Builder builder, boolean z) {
            builder.isPartialImageCachingEnabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setDecodeCancellationEnabled(final boolean decodeCancellationEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setDecodeCancellationEnabled$lambda$8(this.f$0, decodeCancellationEnabled);
                }
            });
        }

        static final Unit setDecodeCancellationEnabled$lambda$8(Builder builder, boolean z) {
            builder.decodeCancellationEnabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setWebpErrorLogger(final WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setWebpErrorLogger$lambda$9(this.f$0, webpErrorLogger);
                }
            });
        }

        static final Unit setWebpErrorLogger$lambda$9(Builder builder, WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            builder.webpErrorLogger = webpErrorLogger;
            return Unit.INSTANCE;
        }

        public final Builder setWebpBitmapFactory(final WebpBitmapFactory webpBitmapFactory) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setWebpBitmapFactory$lambda$10(this.f$0, webpBitmapFactory);
                }
            });
        }

        static final Unit setWebpBitmapFactory$lambda$10(Builder builder, WebpBitmapFactory webpBitmapFactory) {
            builder.webpBitmapFactory = webpBitmapFactory;
            return Unit.INSTANCE;
        }

        public final Builder setBitmapPrepareToDraw(final boolean useBitmapPrepareToDraw, final int minBitmapSizeBytes, final int maxBitmapSizeBytes, final boolean preparePrefetch) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setBitmapPrepareToDraw$lambda$11(this.f$0, useBitmapPrepareToDraw, minBitmapSizeBytes, maxBitmapSizeBytes, preparePrefetch);
                }
            });
        }

        static final Unit setBitmapPrepareToDraw$lambda$11(Builder builder, boolean z, int i, int i2, boolean z2) {
            builder.useBitmapPrepareToDraw = z;
            builder.bitmapPrepareToDrawMinSizeBytes = i;
            builder.bitmapPrepareToDrawMaxSizeBytes = i2;
            builder.bitmapPrepareToDrawForPrefetch = z2;
            return Unit.INSTANCE;
        }

        public final Builder setBalancedAnimationStrategy(final boolean useBalancedAnimationStrategy) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setBalancedAnimationStrategy$lambda$12(this.f$0, useBalancedAnimationStrategy);
                }
            });
        }

        static final Unit setBalancedAnimationStrategy$lambda$12(Builder builder, boolean z) {
            builder.useBalancedAnimationStrategy = z;
            return Unit.INSTANCE;
        }

        public final Builder setAnimationStrategyBufferLengthMilliseconds(final int animationStrategyBufferLengthMilliseconds) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setAnimationStrategyBufferLengthMilliseconds$lambda$13(this.f$0, animationStrategyBufferLengthMilliseconds);
                }
            });
        }

        static final Unit setAnimationStrategyBufferLengthMilliseconds$lambda$13(Builder builder, int i) {
            builder.animationStrategyBufferLengthMilliseconds = i;
            return Unit.INSTANCE;
        }

        public final Builder setMaxBitmapDimension(final int maxBitmapDimension) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setMaxBitmapDimension$lambda$14(this.f$0, maxBitmapDimension);
                }
            });
        }

        static final Unit setMaxBitmapDimension$lambda$14(Builder builder, int i) {
            builder.maxBitmapDimension = i;
            return Unit.INSTANCE;
        }

        public final Builder setNativeCodeDisabled(final boolean nativeCodeDisabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setNativeCodeDisabled$lambda$15(this.f$0, nativeCodeDisabled);
                }
            });
        }

        static final Unit setNativeCodeDisabled$lambda$15(Builder builder, boolean z) {
            builder.nativeCodeDisabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setProducerFactoryMethod(final ProducerFactoryMethod producerFactoryMethod) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setProducerFactoryMethod$lambda$16(this.f$0, producerFactoryMethod);
                }
            });
        }

        static final Unit setProducerFactoryMethod$lambda$16(Builder builder, ProducerFactoryMethod producerFactoryMethod) {
            builder.producerFactoryMethod = producerFactoryMethod;
            return Unit.INSTANCE;
        }

        public final Builder setLazyDataSource(final Supplier<Boolean> lazyDataSource) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setLazyDataSource$lambda$17(this.f$0, lazyDataSource);
                }
            });
        }

        static final Unit setLazyDataSource$lambda$17(Builder builder, Supplier supplier) {
            builder.lazyDataSource = supplier;
            return Unit.INSTANCE;
        }

        public final Builder setShouldDownscaleFrameToDrawableDimensions(final boolean downscaleFrameToDrawableDimensions) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setShouldDownscaleFrameToDrawableDimensions$lambda$18(this.f$0, downscaleFrameToDrawableDimensions);
                }
            });
        }

        static final Unit setShouldDownscaleFrameToDrawableDimensions$lambda$18(Builder builder, boolean z) {
            builder.downscaleFrameToDrawableDimensions = z;
            return Unit.INSTANCE;
        }

        public final Builder setSuppressBitmapPrefetchingSupplier(final Supplier<Boolean> suppressBitmapPrefetchingSupplier) {
            Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "suppressBitmapPrefetchingSupplier");
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setSuppressBitmapPrefetchingSupplier$lambda$19(this.f$0, suppressBitmapPrefetchingSupplier);
                }
            });
        }

        static final Unit setSuppressBitmapPrefetchingSupplier$lambda$19(Builder builder, Supplier supplier) {
            builder.suppressBitmapPrefetchingSupplier = supplier;
            return Unit.INSTANCE;
        }

        public final Builder setExperimentalThreadHandoffQueueEnabled(final boolean experimentalThreadHandoffQueueEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setExperimentalThreadHandoffQueueEnabled$lambda$20(this.f$0, experimentalThreadHandoffQueueEnabled);
                }
            });
        }

        static final Unit setExperimentalThreadHandoffQueueEnabled$lambda$20(Builder builder, boolean z) {
            builder.experimentalThreadHandoffQueueEnabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setThrottlingProducerMaxSimultaneousRequests(final long maxSimultaneousRequests) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setThrottlingProducerMaxSimultaneousRequests$lambda$21(maxSimultaneousRequests, this);
                }
            });
        }

        static final Unit setThrottlingProducerMaxSimultaneousRequests$lambda$21(long j, Builder builder) {
            if (j >= 1) {
                builder.throttlingProducerMaxSimultaneousRequests = j;
            }
            return Unit.INSTANCE;
        }

        static final Unit setExperimentalMemoryType$lambda$22(Builder builder, long j) {
            builder.memoryType = j;
            return Unit.INSTANCE;
        }

        public final Builder setExperimentalMemoryType(final long MemoryType) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setExperimentalMemoryType$lambda$22(this.f$0, MemoryType);
                }
            });
        }

        public final Builder setKeepCancelledFetchAsLowPriority(final boolean keepCancelledFetchAsLowPriority) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setKeepCancelledFetchAsLowPriority$lambda$23(this.f$0, keepCancelledFetchAsLowPriority);
                }
            });
        }

        static final Unit setKeepCancelledFetchAsLowPriority$lambda$23(Builder builder, boolean z) {
            builder.keepCancelledFetchAsLowPriority = z;
            return Unit.INSTANCE;
        }

        public final Builder setDownsampleIfLargeBitmap(final boolean downsampleIfLargeBitmap) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setDownsampleIfLargeBitmap$lambda$24(this.f$0, downsampleIfLargeBitmap);
                }
            });
        }

        static final Unit setDownsampleIfLargeBitmap$lambda$24(Builder builder, boolean z) {
            builder.downsampleIfLargeBitmap = z;
            return Unit.INSTANCE;
        }

        public final Builder setEncodedCacheEnabled(final boolean encodedCacheEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setEncodedCacheEnabled$lambda$25(this.f$0, encodedCacheEnabled);
                }
            });
        }

        static final Unit setEncodedCacheEnabled$lambda$25(Builder builder, boolean z) {
            builder.encodedCacheEnabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setEnsureTranscoderLibraryLoaded(final boolean ensureTranscoderLibraryLoaded) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setEnsureTranscoderLibraryLoaded$lambda$26(this.f$0, ensureTranscoderLibraryLoaded);
                }
            });
        }

        static final Unit setEnsureTranscoderLibraryLoaded$lambda$26(Builder builder, boolean z) {
            builder.ensureTranscoderLibraryLoaded = z;
            return Unit.INSTANCE;
        }

        public final Builder setIsDiskCacheProbingEnabled(final boolean isDiskCacheProbingEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setIsDiskCacheProbingEnabled$lambda$27(this.f$0, isDiskCacheProbingEnabled);
                }
            });
        }

        static final Unit setIsDiskCacheProbingEnabled$lambda$27(Builder builder, boolean z) {
            builder.isDiskCacheProbingEnabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setIsEncodedMemoryCacheProbingEnabled(final boolean isEncodedMemoryCacheProbingEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setIsEncodedMemoryCacheProbingEnabled$lambda$28(this.f$0, isEncodedMemoryCacheProbingEnabled);
                }
            });
        }

        static final Unit setIsEncodedMemoryCacheProbingEnabled$lambda$28(Builder builder, boolean z) {
            builder.isEncodedMemoryCacheProbingEnabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setTrackedKeysSize(final int trackedKeysSize) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setTrackedKeysSize$lambda$29(this.f$0, trackedKeysSize);
                }
            });
        }

        static final Unit setTrackedKeysSize$lambda$29(Builder builder, int i) {
            builder.trackedKeysSize = i;
            return Unit.INSTANCE;
        }

        static final Unit setAllowDelay$lambda$30(Builder builder, boolean z) {
            builder.allowDelay = z;
            return Unit.INSTANCE;
        }

        public final Builder setAllowDelay(final boolean allowDelay) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setAllowDelay$lambda$30(this.f$0, allowDelay);
                }
            });
        }

        public final Builder setAllowProgressiveOnPrefetch(final boolean allowProgressiveOnPrefetch) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setAllowProgressiveOnPrefetch$lambda$31(this.f$0, allowProgressiveOnPrefetch);
                }
            });
        }

        static final Unit setAllowProgressiveOnPrefetch$lambda$31(Builder builder, boolean z) {
            builder.allowProgressiveOnPrefetch = z;
            return Unit.INSTANCE;
        }

        public final Builder setAnimationRenderFpsLimit(final int animationRenderFpsLimit) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setAnimationRenderFpsLimit$lambda$32(this.f$0, animationRenderFpsLimit);
                }
            });
        }

        static final Unit setAnimationRenderFpsLimit$lambda$32(Builder builder, int i) {
            builder.animationRenderFpsLimit = i;
            return Unit.INSTANCE;
        }

        public final Builder setCancelDecodeOnCacheMiss(final boolean cancelDecodeOnCacheMiss) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setCancelDecodeOnCacheMiss$lambda$33(this.f$0, cancelDecodeOnCacheMiss);
                }
            });
        }

        static final Unit setCancelDecodeOnCacheMiss$lambda$33(Builder builder, boolean z) {
            builder.cancelDecodeOnCacheMiss = z;
            return Unit.INSTANCE;
        }

        public final Builder setPlatformDecoderOptions(final PlatformDecoderOptions platformDecoderOptions) {
            Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setPlatformDecoderOptions$lambda$34(this.f$0, platformDecoderOptions);
                }
            });
        }

        static final Unit setPlatformDecoderOptions$lambda$34(Builder builder, PlatformDecoderOptions platformDecoderOptions) {
            builder.platformDecoderOptions = platformDecoderOptions;
            return Unit.INSTANCE;
        }

        public final Builder setBinaryXmlEnabled(final boolean binaryXmlEnabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setBinaryXmlEnabled$lambda$35(this.f$0, binaryXmlEnabled);
                }
            });
        }

        static final Unit setBinaryXmlEnabled$lambda$35(Builder builder, boolean z) {
            builder.isBinaryXmlEnabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setLoadThumbnailFromContentResolverFirst(final boolean loadThumbnailFromContentResolverFirst) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setLoadThumbnailFromContentResolverFirst$lambda$36(this.f$0, loadThumbnailFromContentResolverFirst);
                }
            });
        }

        static final Unit setLoadThumbnailFromContentResolverFirst$lambda$36(Builder builder, boolean z) {
            builder.loadThumbnailFromContentResolverFirst = z;
            return Unit.INSTANCE;
        }

        public final Builder setLoadThumbnailFromContentResolverForContentUriOnly(final boolean loadThumbnailFromContentResolverForContentUriOnly) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setLoadThumbnailFromContentResolverForContentUriOnly$lambda$37(this.f$0, loadThumbnailFromContentResolverForContentUriOnly);
                }
            });
        }

        static final Unit setLoadThumbnailFromContentResolverForContentUriOnly$lambda$37(Builder builder, boolean z) {
            builder.loadThumbnailFromContentResolverForContentUriOnly = z;
            return Unit.INSTANCE;
        }

        public final Builder setPreserveMetadataOnDisk(final boolean preserve) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setPreserveMetadataOnDisk$lambda$38(this.f$0, preserve);
                }
            });
        }

        static final Unit setPreserveMetadataOnDisk$lambda$38(Builder builder, boolean z) {
            builder.preserveMetadataOnDisk = z;
            return Unit.INSTANCE;
        }

        public final Builder setPreserveMetadataOnDiskDuringStartup(final boolean preserve) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setPreserveMetadataOnDiskDuringStartup$lambda$39(this.f$0, preserve);
                }
            });
        }

        static final Unit setPreserveMetadataOnDiskDuringStartup$lambda$39(Builder builder, boolean z) {
            builder.preserveMetadataOnDiskDuringStartup = z;
            return Unit.INSTANCE;
        }

        public final Builder setIntermediateProgressUpdatesDisabled(final boolean updatesDisabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setIntermediateProgressUpdatesDisabled$lambda$40(this.f$0, updatesDisabled);
                }
            });
        }

        static final Unit setIntermediateProgressUpdatesDisabled$lambda$40(Builder builder, boolean z) {
            builder.intermediateProgressUpdatesDisabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setIntermediateProgressUpdatesForPrefetchDisabled(final boolean updatesDisabled) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setIntermediateProgressUpdatesForPrefetchDisabled$lambda$41(this.f$0, updatesDisabled);
                }
            });
        }

        static final Unit setIntermediateProgressUpdatesForPrefetchDisabled$lambda$41(Builder builder, boolean z) {
            builder.intermediateProgressUpdatesForPrefetchDisabled = z;
            return Unit.INSTANCE;
        }

        public final Builder setThrowCacheMissExceptionOnCacheMiss(final boolean throwException) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setThrowCacheMissExceptionOnCacheMiss$lambda$42(this.f$0, throwException);
                }
            });
        }

        static final Unit setThrowCacheMissExceptionOnCacheMiss$lambda$42(Builder builder, boolean z) {
            builder.throwCacheMissExceptionOnCacheMiss = z;
            return Unit.INSTANCE;
        }

        public final Builder setUsePostProcessedCacheKey(final boolean usePostProcessedCacheKey) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setUsePostProcessedCacheKey$lambda$43(this.f$0, usePostProcessedCacheKey);
                }
            });
        }

        static final Unit setUsePostProcessedCacheKey$lambda$43(Builder builder, boolean z) {
            builder.usePostProcessedCacheKey = z;
            return Unit.INSTANCE;
        }

        public final Builder setUsePostprocessorDuringDecodedPrefetch(final boolean usePostprocessorDuringDecodedPrefetch) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setUsePostprocessorDuringDecodedPrefetch$lambda$44(this.f$0, usePostprocessorDuringDecodedPrefetch);
                }
            });
        }

        static final Unit setUsePostprocessorDuringDecodedPrefetch$lambda$44(Builder builder, boolean z) {
            builder.usePostprocessorDuringDecodedPrefetch = z;
            return Unit.INSTANCE;
        }

        public final Builder setUseSeparateNonBitmapImageCache(final boolean useSeparateNonBitmapImageCache) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setUseSeparateNonBitmapImageCache$lambda$45(this.f$0, useSeparateNonBitmapImageCache);
                }
            });
        }

        static final Unit setUseSeparateNonBitmapImageCache$lambda$45(Builder builder, boolean z) {
            builder.useSeparateNonBitmapImageCache = z;
            return Unit.INSTANCE;
        }

        public final ImagePipelineExperiments build() {
            return new ImagePipelineExperiments(this, null);
        }
    }

    /* JADX INFO: compiled from: ImagePipelineExperiments.kt */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JÞ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001e0\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u000200H\u0016¨\u00061"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$DefaultProducerFactoryMethod;", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "<init>", "()V", "createProducerFactory", "Lcom/facebook/imagepipeline/core/ProducerFactory;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "byteArrayPool", "Lcom/facebook/common/memory/ByteArrayPool;", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "resizeAndRotateEnabledForNetwork", "", "decodeCancellationEnabled", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "bitmapMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapPrepareToDrawMinSizeBytes", "", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapSize", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "keepCancelledFetchAsLowPriority", "trackedKeysSize", "config", "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
        @Override // com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod
        public ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, DownsampleMode downsampleMode, boolean resizeAndRotateEnabledForNetwork, boolean decodeCancellationEnabled, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache, Supplier<DiskCachesStore> diskCachesStoreSupplier, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int bitmapPrepareToDrawMinSizeBytes, int bitmapPrepareToDrawMaxSizeBytes, boolean bitmapPrepareToDrawForPrefetch, int maxBitmapSize, CloseableReferenceFactory closeableReferenceFactory, boolean keepCancelledFetchAsLowPriority, int trackedKeysSize, ImagePipelineConfigInterface config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(byteArrayPool, "byteArrayPool");
            Intrinsics.checkNotNullParameter(imageDecoder, "imageDecoder");
            Intrinsics.checkNotNullParameter(progressiveJpegConfig, "progressiveJpegConfig");
            Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
            Intrinsics.checkNotNullParameter(executorSupplier, "executorSupplier");
            Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
            Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
            Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
            Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
            Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
            Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
            Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
            Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
            Intrinsics.checkNotNullParameter(config, "config");
            return new ProducerFactory(context, byteArrayPool, imageDecoder, progressiveJpegConfig, downsampleMode, resizeAndRotateEnabledForNetwork, decodeCancellationEnabled, executorSupplier, pooledByteBufferFactory, bitmapMemoryCache, encodedMemoryCache, diskCachesStoreSupplier, cacheKeyFactory, platformBitmapFactory, bitmapPrepareToDrawMinSizeBytes, bitmapPrepareToDrawMaxSizeBytes, bitmapPrepareToDrawForPrefetch, maxBitmapSize, closeableReferenceFactory, keepCancelledFetchAsLowPriority, trackedKeysSize, config);
        }
    }

    static final boolean _init_$lambda$0(ImagePipelineExperiments imagePipelineExperiments) {
        return !imagePipelineExperiments.handOffOnUiThreadOnly || Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: compiled from: ImagePipelineExperiments.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Companion;", "", "<init>", "()V", "newBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "configBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder newBuilder(ImagePipelineConfig.Builder configBuilder) {
            Intrinsics.checkNotNullParameter(configBuilder, "configBuilder");
            return new Builder(configBuilder);
        }
    }
}
