package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnifiedCacheKeyFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J.\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/imagepipeline/cache/UnifiedCacheKeyFactory;", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "uriNormalizer", "Lcom/facebook/imagepipeline/cache/UriNormalizer;", "config", "Lcom/facebook/imagepipeline/cache/CacheKeyConfig;", "<init>", "(Lcom/facebook/imagepipeline/cache/UriNormalizer;Lcom/facebook/imagepipeline/cache/CacheKeyConfig;)V", "getBitmapCacheKey", "Lcom/facebook/cache/common/CacheKey;", "request", "Lcom/facebook/imagepipeline/request/ImageRequest;", "callerContext", "", "getPostprocessedBitmapCacheKey", "getEncodedCacheKey", "sourceUri", "Landroid/net/Uri;", "createBitmapCacheKey", "postprocessorCacheKey", "postprocessorName", "", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UnifiedCacheKeyFactory implements CacheKeyFactory {
    private final CacheKeyConfig config;
    private final UriNormalizer uriNormalizer;

    public UnifiedCacheKeyFactory(UriNormalizer uriNormalizer, CacheKeyConfig config) {
        Intrinsics.checkNotNullParameter(uriNormalizer, "uriNormalizer");
        Intrinsics.checkNotNullParameter(config, "config");
        this.uriNormalizer = uriNormalizer;
        this.config = config;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getBitmapCacheKey(ImageRequest request, Object callerContext) {
        Intrinsics.checkNotNullParameter(request, "request");
        return createBitmapCacheKey(request, callerContext, null, null);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getPostprocessedBitmapCacheKey(ImageRequest request, Object callerContext) {
        Intrinsics.checkNotNullParameter(request, "request");
        Postprocessor postprocessor = request.getPostprocessor();
        if (postprocessor != null) {
            return createBitmapCacheKey(request, callerContext, postprocessor.getCacheKey(), postprocessor.getClass().getName());
        }
        return createBitmapCacheKey(request, callerContext, null, null);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest request, Object callerContext) {
        Intrinsics.checkNotNullParameter(request, "request");
        Uri sourceUri = request.getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        return getEncodedCacheKey(request, sourceUri, callerContext);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest request, Uri sourceUri, Object callerContext) {
        CacheKey cacheKeyEnrich;
        String str;
        CacheKey cacheKeyEnrich2;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(sourceUri, "sourceUri");
        String customCacheKey = request.getCustomCacheKey();
        if (customCacheKey != null) {
            EncodedCacheKeyEnricher encodedKeyEnricher = this.config.getEncodedKeyEnricher();
            return (encodedKeyEnricher == null || (cacheKeyEnrich2 = encodedKeyEnricher.enrich(customCacheKey, callerContext, sourceUri)) == null) ? new SimpleCacheKey(customCacheKey) : cacheKeyEnrich2;
        }
        NormalizedUri normalizedUriNormalize = this.uriNormalizer.normalize(sourceUri, callerContext);
        String cacheKeyString = normalizedUriNormalize.getCacheKeyString();
        if (this.config.getIncludeDimensionsInEncodedKey()) {
            DimensionExtractor dimensionExtractor = this.config.getDimensionExtractor();
            Pair<Integer, Integer> pairExtractDimensions = dimensionExtractor != null ? dimensionExtractor.extractDimensions(request, sourceUri, callerContext) : null;
            if (pairExtractDimensions != null) {
                if (this.config.getEnableDiskSimilarity() && normalizedUriNormalize.getGroupKey() != null) {
                    str = normalizedUriNormalize.getGroupKey() + "_" + pairExtractDimensions.getFirst() + "_" + pairExtractDimensions.getSecond();
                } else {
                    str = cacheKeyString + pairExtractDimensions.getFirst() + "_" + pairExtractDimensions.getSecond();
                }
                cacheKeyString = str;
            }
        }
        if (cacheKeyString.length() >= this.config.getHashThreshold()) {
            cacheKeyString = String.valueOf(cacheKeyString.hashCode());
        }
        EncodedCacheKeyEnricher encodedKeyEnricher2 = this.config.getEncodedKeyEnricher();
        return (encodedKeyEnricher2 == null || (cacheKeyEnrich = encodedKeyEnricher2.enrich(cacheKeyString, callerContext, sourceUri)) == null) ? new SimpleCacheKey(cacheKeyString) : cacheKeyEnrich;
    }

    private final CacheKey createBitmapCacheKey(ImageRequest request, Object callerContext, CacheKey postprocessorCacheKey, String postprocessorName) {
        String strValueOf;
        ResizeOptions resizeOptions;
        ImageDecodeOptions imageDecodeOptions;
        Pair<Integer, Integer> pairExtractDimensions;
        String customCacheKey = request.getCustomCacheKey();
        if (customCacheKey == null) {
            UriNormalizer uriNormalizer = this.uriNormalizer;
            Uri sourceUri = request.getSourceUri();
            Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
            strValueOf = uriNormalizer.normalize(sourceUri, callerContext).getCacheKeyString();
        } else {
            strValueOf = customCacheKey;
        }
        if (customCacheKey == null && this.config.getIncludeDimensionsInBitmapKey()) {
            DimensionExtractor dimensionExtractor = this.config.getDimensionExtractor();
            if (dimensionExtractor != null) {
                Uri sourceUri2 = request.getSourceUri();
                Intrinsics.checkNotNullExpressionValue(sourceUri2, "getSourceUri(...)");
                pairExtractDimensions = dimensionExtractor.extractDimensions(request, sourceUri2, callerContext);
            } else {
                pairExtractDimensions = null;
            }
            if (pairExtractDimensions != null) {
                strValueOf = strValueOf + pairExtractDimensions.getFirst() + "_" + pairExtractDimensions.getSecond();
            }
        }
        if (customCacheKey == null && strValueOf.length() >= this.config.getHashThreshold()) {
            strValueOf = String.valueOf(strValueOf.hashCode());
        }
        String str = strValueOf;
        Function2<Integer, ResizeOptions, ResizeOptions> resizeOptionsFilter = this.config.getResizeOptionsFilter();
        if (resizeOptionsFilter == null || (resizeOptions = resizeOptionsFilter.invoke(Integer.valueOf(request.getSourceUriType()), request.getResizeOptions())) == null) {
            resizeOptions = request.getResizeOptions();
        }
        ResizeOptions resizeOptions2 = resizeOptions;
        if (this.config.getExcludeBitmapConfigFromComparison()) {
            imageDecodeOptions = new ImageDecodeOptionsBuilder().setFrom(request.getImageDecodeOptions()).setExcludeBitmapConfigFromComparison(true).build();
        } else {
            imageDecodeOptions = request.getImageDecodeOptions();
        }
        ImageDecodeOptions imageDecodeOptions2 = imageDecodeOptions;
        Intrinsics.checkNotNull(imageDecodeOptions2);
        RotationOptions rotationOptions = request.getRotationOptions();
        Intrinsics.checkNotNullExpressionValue(rotationOptions, "getRotationOptions(...)");
        BitmapMemoryCacheKey bitmapMemoryCacheKey = new BitmapMemoryCacheKey(str, resizeOptions2, rotationOptions, imageDecodeOptions2, postprocessorCacheKey, postprocessorName);
        Function2<ImageRequest, CacheKey, Unit> debugImageTracker = this.config.getDebugImageTracker();
        if (debugImageTracker != null) {
            debugImageTracker.invoke(request, bitmapMemoryCacheKey);
        }
        return bitmapMemoryCacheKey;
    }
}
