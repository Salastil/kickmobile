package com.facebook.fresco.vito.core.impl;

import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.fresco.ui.common.VitoUtils;
import com.facebook.fresco.urimod.ClassicFetchStrategy;
import com.facebook.fresco.urimod.Dimensions;
import com.facebook.fresco.urimod.DimensionsKt;
import com.facebook.fresco.urimod.FetchStrategy;
import com.facebook.fresco.urimod.NoPrefetchInOnPrepareStrategy;
import com.facebook.fresco.urimod.SmartFetchStrategy;
import com.facebook.fresco.urimod.UriModifier;
import com.facebook.fresco.urimod.UriModifierInterface;
import com.facebook.fresco.vito.core.FrescoVitoConfig;
import com.facebook.fresco.vito.core.ImagePipelineUtils;
import com.facebook.fresco.vito.core.VitoImagePipeline;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.source.FirstAvailableImageSource;
import com.facebook.fresco.vito.source.ImageSource;
import com.facebook.fresco.vito.source.ImageSourceProvider;
import com.facebook.fresco.vito.source.IncreasingQualityImageSource;
import com.facebook.fresco.vito.source.SmartFetchOptIn;
import com.facebook.fresco.vito.source.SmartImageSource;
import com.facebook.fresco.vito.source.UriImageSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VitoImagePipelineImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJR\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016JB\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0!2\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010\u0014\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000bH\u0016J'\u0010'\u001a\u0004\u0018\u00010\u00132\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u0010\u00100\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u00102\u001a\u00020\u0013H\u0002J\b\u00103\u001a\u00020\u0013H\u0002J&\u00104\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J#\u00106\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u00107J\u001c\u00108\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/VitoImagePipelineImpl;", "Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "imagePipeline", "Lcom/facebook/imagepipeline/core/ImagePipeline;", "imagePipelineUtils", "Lcom/facebook/fresco/vito/core/ImagePipelineUtils;", "config", "Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "<init>", "(Lcom/facebook/imagepipeline/core/ImagePipeline;Lcom/facebook/fresco/vito/core/ImagePipelineUtils;Lcom/facebook/fresco/vito/core/FrescoVitoConfig;)V", "createImageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "imageSource", "Lcom/facebook/fresco/vito/source/ImageSource;", "options", "Lcom/facebook/fresco/vito/options/ImageOptions;", "logWithHighSamplingRate", "", "viewport", "Landroid/graphics/Rect;", "callerContext", "", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "fetchStrategy", "Lcom/facebook/fresco/urimod/FetchStrategy;", "getCachedImage", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "imageRequest", "fetchDecodedImage", "Lcom/facebook/datasource/DataSource;", "requestListener", "Lcom/facebook/imagepipeline/listener/RequestListener;", "uiComponentId", "", "Lcom/facebook/fresco/urimod/Dimensions;", "isInDiskCacheSync", "vitoImageRequest", InstrumentationTags.TIMEOUT, "unit", "Ljava/util/concurrent/TimeUnit;", "(Lcom/facebook/fresco/vito/core/VitoImageRequest;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Boolean;", "returnImageToCache", "", "imageReference", "evictFromCaches", "hintUnmodifiedUri", "experimentalDynamicSizeVito2", "experimentalDynamicSizeWithCacheFallbackVito2", "determineFetchStrategy", "requestBeforeLayout", "isProductEnabled", "(Ljava/lang/Object;Lcom/facebook/common/callercontext/ContextChain;)Ljava/lang/Boolean;", "isFallbackEnabled", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VitoImagePipelineImpl implements VitoImagePipeline {
    private final FrescoVitoConfig config;
    private final ImagePipeline imagePipeline;
    private final ImagePipelineUtils imagePipelineUtils;

    /* JADX INFO: compiled from: VitoImagePipelineImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SmartFetchOptIn.values().length];
            try {
                iArr[SmartFetchOptIn.ENABLED_NO_FALLBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SmartFetchOptIn.ENABLED_WITH_FALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VitoImagePipelineImpl(ImagePipeline imagePipeline, ImagePipelineUtils imagePipelineUtils, FrescoVitoConfig config) {
        Intrinsics.checkNotNullParameter(imagePipeline, "imagePipeline");
        Intrinsics.checkNotNullParameter(imagePipelineUtils, "imagePipelineUtils");
        Intrinsics.checkNotNullParameter(config, "config");
        this.imagePipeline = imagePipeline;
        this.imagePipelineUtils = imagePipelineUtils;
        this.config = config;
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePipeline
    public VitoImageRequest createImageRequest(Resources resources, ImageSource imageSource, ImageOptions options, boolean logWithHighSamplingRate, Rect viewport, Object callerContext, ContextChain contextChain, FetchStrategy fetchStrategy) {
        SmartImageSource smartImageSourceForUri$default;
        String comment;
        Map<String, Object> extras;
        Dimensions dimensionsAsDimensions;
        CacheKey cacheKey;
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        ImageOptions imageOptionsDefaults = options == null ? ImageOptions.INSTANCE.defaults() : options;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (fetchStrategy instanceof SmartFetchStrategy) {
            if (imageSource instanceof UriImageSource) {
                UriImageSource uriImageSource = (UriImageSource) imageSource;
                UriModifierInterface.ModificationResult modificationResultModifyUri = UriModifier.INSTANCE.modifyUri(uriImageSource, viewport != null ? new Dimensions(viewport.width(), viewport.height()) : null, imageOptionsDefaults.getActualImageScaleType(), callerContext, contextChain);
                comment = modificationResultModifyUri.getComment();
                if (modificationResultModifyUri instanceof UriModifierInterface.ModificationResult.Modified) {
                    if (imageSource instanceof SmartImageSource) {
                        SmartImageSource smartImageSource = (SmartImageSource) imageSource;
                        smartImageSourceForUri$default = new SmartImageSource(((UriModifierInterface.ModificationResult.Modified) modificationResultModifyUri).getNewUri(), smartImageSource.getSizingHint(), smartImageSource.getExtras(), smartImageSource.getSmartFetchOptIn());
                    } else {
                        smartImageSourceForUri$default = ImageSourceProvider.forUri$default(((UriModifierInterface.ModificationResult.Modified) modificationResultModifyUri).getNewUri(), (Map) null, 2, (Object) null);
                    }
                    linkedHashMap.put("smart_original_url", uriImageSource.getImageUri());
                }
            } else {
                comment = "NotSupportedImageSource: " + imageSource.getClassNameString();
            }
            smartImageSourceForUri$default = imageSource;
        } else {
            if (fetchStrategy instanceof ClassicFetchStrategy) {
                comment = "classic";
            } else if (fetchStrategy instanceof NoPrefetchInOnPrepareStrategy) {
                comment = "noprefetch";
            } else {
                if (fetchStrategy != null) {
                    throw new NoWhenBranchMatchedException();
                }
                smartImageSourceForUri$default = imageSource;
                comment = null;
            }
            smartImageSourceForUri$default = imageSource;
        }
        if (fetchStrategy != null) {
            linkedHashMap.put("smart_fetch_strategy", fetchStrategy);
        }
        if (comment != null) {
            linkedHashMap.put("smart_mod_result", comment);
        }
        if (imageSource instanceof IncreasingQualityImageSource) {
            Map<String, Object> extras2 = ((IncreasingQualityImageSource) imageSource).getExtras();
            if (extras2 != null) {
                linkedHashMap.put("image_source_extras", extras2);
            }
        } else if (imageSource instanceof UriImageSource) {
            Map<String, Object> extras3 = ((UriImageSource) imageSource).getExtras();
            if (extras3 != null) {
                linkedHashMap.put("image_source_extras", extras3);
            }
        } else if (imageSource instanceof FirstAvailableImageSource) {
            ImageSource imageSource2 = (ImageSource) ArraysKt.firstOrNull(((FirstAvailableImageSource) imageSource).getImageSources());
            if ((imageSource2 instanceof UriImageSource) && (extras = ((UriImageSource) imageSource2).getExtras()) != null) {
                linkedHashMap.put("image_source_extras", extras);
            }
        }
        ImageRequest imageRequestMaybeExtractFinalImageRequest = ImageSourceToImagePipelineAdapter.maybeExtractFinalImageRequest(smartImageSourceForUri$default, this.imagePipelineUtils, imageOptionsDefaults);
        if (imageRequestMaybeExtractFinalImageRequest != null) {
            cacheKey = this.imagePipeline.getCacheKey(imageRequestMaybeExtractFinalImageRequest, callerContext);
            dimensionsAsDimensions = null;
        } else {
            dimensionsAsDimensions = null;
            cacheKey = null;
        }
        if (viewport != null) {
            dimensionsAsDimensions = DimensionsKt.asDimensions(viewport);
        }
        return new VitoImageRequest(resources, smartImageSourceForUri$default, imageOptionsDefaults, logWithHighSamplingRate, imageRequestMaybeExtractFinalImageRequest, cacheKey, linkedHashMap, dimensionsAsDimensions);
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePipeline
    public CloseableReference<CloseableImage> getCachedImage(VitoImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            if (this.config.disableBitmapCacheShortcut()) {
                return null;
            }
            CloseableReference<CloseableImage> cachedImage = this.imagePipeline.getCachedImage(imageRequest.finalImageCacheKey);
            if (CloseableReference.isValid(cachedImage)) {
                return cachedImage;
            }
            return null;
        }
        FrescoSystrace.beginSection("VitoImagePipeline#getCachedImage");
        try {
            if (this.config.disableBitmapCacheShortcut()) {
                return null;
            }
            CloseableReference<CloseableImage> cachedImage2 = this.imagePipeline.getCachedImage(imageRequest.finalImageCacheKey);
            return CloseableReference.isValid(cachedImage2) ? cachedImage2 : null;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePipeline
    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(VitoImageRequest imageRequest, Object callerContext, RequestListener requestListener, long uiComponentId, Dimensions viewport) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        DataSource<CloseableReference<CloseableImage>> dataSource = ImageSourceToImagePipelineAdapter.createDataSourceSupplier(imageRequest.imageSource, this.imagePipeline, this.imagePipelineUtils, imageRequest.imageOptions, callerContext, requestListener, VitoUtils.getStringId(uiComponentId), imageRequest.extras, viewport).get();
        Intrinsics.checkNotNullExpressionValue(dataSource, "get(...)");
        return dataSource;
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePipeline
    public boolean isInDiskCacheSync(VitoImageRequest vitoImageRequest) {
        Intrinsics.checkNotNullParameter(vitoImageRequest, "vitoImageRequest");
        ImageRequest imageRequest = vitoImageRequest.finalImageRequest;
        if (imageRequest == null) {
            return false;
        }
        return this.imagePipeline.isInDiskCacheSync(imageRequest);
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePipeline
    public Boolean isInDiskCacheSync(VitoImageRequest vitoImageRequest, long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(vitoImageRequest, "vitoImageRequest");
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (timeout <= 0) {
            return Boolean.valueOf(isInDiskCacheSync(vitoImageRequest));
        }
        ImageRequest imageRequest = vitoImageRequest.finalImageRequest;
        if (imageRequest == null) {
            return null;
        }
        try {
            return (Boolean) DataSources.waitForFinalResult(this.imagePipeline.isInDiskCache(imageRequest), timeout, unit);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePipeline
    public void returnImageToCache(VitoImageRequest imageRequest, CloseableReference<CloseableImage> imageReference) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(imageReference, "imageReference");
        CacheKey cacheKey = imageRequest.finalImageCacheKey;
        if (cacheKey == null) {
            return;
        }
        this.imagePipeline.returnImageToCache(cacheKey, imageReference);
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePipeline
    public void evictFromCaches(VitoImageRequest imageRequest) {
        Uri sourceUri;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        ImageRequest imageRequest2 = imageRequest.finalImageRequest;
        if (imageRequest2 == null || (sourceUri = imageRequest2.getSourceUri()) == null) {
            return;
        }
        this.imagePipeline.evictFromCache(sourceUri);
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePipeline
    public void hintUnmodifiedUri(VitoImageRequest imageRequest) {
        Uri sourceUri;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        ImageRequest imageRequest2 = imageRequest.finalImageRequest;
        if (imageRequest2 == null || (sourceUri = imageRequest2.getSourceUri()) == null) {
            return;
        }
        UriModifier.INSTANCE.unregisterReverseFallbackUri(sourceUri);
    }

    private final boolean experimentalDynamicSizeVito2() {
        return this.config.experimentalDynamicSizeVito2();
    }

    private final boolean experimentalDynamicSizeWithCacheFallbackVito2() {
        return this.config.experimentalDynamicSizeWithCacheFallbackVito2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0081, code lost:
    
        if (isFallbackEnabled(r5, r6) == false) goto L48;
     */
    @Override // com.facebook.fresco.vito.core.VitoImagePipeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.facebook.fresco.urimod.FetchStrategy determineFetchStrategy(com.facebook.fresco.vito.core.VitoImageRequest r4, java.lang.Object r5, com.facebook.common.callercontext.ContextChain r6) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.vito.core.impl.VitoImagePipelineImpl.determineFetchStrategy(com.facebook.fresco.vito.core.VitoImageRequest, java.lang.Object, com.facebook.common.callercontext.ContextChain):com.facebook.fresco.urimod.FetchStrategy");
    }

    private final Boolean isProductEnabled(Object callerContext, ContextChain contextChain) {
        if (this.config.experimentalDynamicSizeCheckIfProductIsEnabled()) {
            return Boolean.valueOf(this.config.experimentalDynamicSizeIsProductEnabled(callerContext, contextChain));
        }
        return null;
    }

    private final boolean isFallbackEnabled(Object callerContext, ContextChain contextChain) {
        return this.config.experimentalDynamicSizeIsFallbackEnabled(callerContext, contextChain);
    }
}
