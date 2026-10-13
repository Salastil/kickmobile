package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CacheKeyConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\n¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J!\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u001d\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nHÆ\u0003J\u0093\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nHÆ\u0001J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R)\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R%\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001e¨\u00063"}, d2 = {"Lcom/facebook/imagepipeline/cache/CacheKeyConfig;", "", "includeDimensionsInBitmapKey", "", "includeDimensionsInEncodedKey", "enableDiskSimilarity", "hashThreshold", "", "excludeBitmapConfigFromComparison", "resizeOptionsFilter", "Lkotlin/Function2;", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "dimensionExtractor", "Lcom/facebook/imagepipeline/cache/DimensionExtractor;", "encodedKeyEnricher", "Lcom/facebook/imagepipeline/cache/EncodedCacheKeyEnricher;", "debugImageTracker", "Lcom/facebook/imagepipeline/request/ImageRequest;", "Lcom/facebook/cache/common/CacheKey;", "", "<init>", "(ZZZIZLkotlin/jvm/functions/Function2;Lcom/facebook/imagepipeline/cache/DimensionExtractor;Lcom/facebook/imagepipeline/cache/EncodedCacheKeyEnricher;Lkotlin/jvm/functions/Function2;)V", "getIncludeDimensionsInBitmapKey", "()Z", "getIncludeDimensionsInEncodedKey", "getEnableDiskSimilarity", "getHashThreshold", "()I", "getExcludeBitmapConfigFromComparison", "getResizeOptionsFilter", "()Lkotlin/jvm/functions/Function2;", "getDimensionExtractor", "()Lcom/facebook/imagepipeline/cache/DimensionExtractor;", "getEncodedKeyEnricher", "()Lcom/facebook/imagepipeline/cache/EncodedCacheKeyEnricher;", "getDebugImageTracker", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CacheKeyConfig {
    private final Function2<ImageRequest, CacheKey, Unit> debugImageTracker;
    private final DimensionExtractor dimensionExtractor;
    private final boolean enableDiskSimilarity;
    private final EncodedCacheKeyEnricher encodedKeyEnricher;
    private final boolean excludeBitmapConfigFromComparison;
    private final int hashThreshold;
    private final boolean includeDimensionsInBitmapKey;
    private final boolean includeDimensionsInEncodedKey;
    private final Function2<Integer, ResizeOptions, ResizeOptions> resizeOptionsFilter;

    public CacheKeyConfig() {
        this(false, false, false, 0, false, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CacheKeyConfig copy$default(CacheKeyConfig cacheKeyConfig, boolean z, boolean z2, boolean z3, int i, boolean z4, Function2 function2, DimensionExtractor dimensionExtractor, EncodedCacheKeyEnricher encodedCacheKeyEnricher, Function2 function3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = cacheKeyConfig.includeDimensionsInBitmapKey;
        }
        if ((i2 & 2) != 0) {
            z2 = cacheKeyConfig.includeDimensionsInEncodedKey;
        }
        if ((i2 & 4) != 0) {
            z3 = cacheKeyConfig.enableDiskSimilarity;
        }
        if ((i2 & 8) != 0) {
            i = cacheKeyConfig.hashThreshold;
        }
        if ((i2 & 16) != 0) {
            z4 = cacheKeyConfig.excludeBitmapConfigFromComparison;
        }
        if ((i2 & 32) != 0) {
            function2 = cacheKeyConfig.resizeOptionsFilter;
        }
        if ((i2 & 64) != 0) {
            dimensionExtractor = cacheKeyConfig.dimensionExtractor;
        }
        if ((i2 & 128) != 0) {
            encodedCacheKeyEnricher = cacheKeyConfig.encodedKeyEnricher;
        }
        if ((i2 & 256) != 0) {
            function3 = cacheKeyConfig.debugImageTracker;
        }
        EncodedCacheKeyEnricher encodedCacheKeyEnricher2 = encodedCacheKeyEnricher;
        Function2 function4 = function3;
        Function2 function5 = function2;
        DimensionExtractor dimensionExtractor2 = dimensionExtractor;
        boolean z5 = z4;
        boolean z6 = z3;
        return cacheKeyConfig.copy(z, z2, z6, i, z5, function5, dimensionExtractor2, encodedCacheKeyEnricher2, function4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIncludeDimensionsInBitmapKey() {
        return this.includeDimensionsInBitmapKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIncludeDimensionsInEncodedKey() {
        return this.includeDimensionsInEncodedKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEnableDiskSimilarity() {
        return this.enableDiskSimilarity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHashThreshold() {
        return this.hashThreshold;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getExcludeBitmapConfigFromComparison() {
        return this.excludeBitmapConfigFromComparison;
    }

    public final Function2<Integer, ResizeOptions, ResizeOptions> component6() {
        return this.resizeOptionsFilter;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final DimensionExtractor getDimensionExtractor() {
        return this.dimensionExtractor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final EncodedCacheKeyEnricher getEncodedKeyEnricher() {
        return this.encodedKeyEnricher;
    }

    public final Function2<ImageRequest, CacheKey, Unit> component9() {
        return this.debugImageTracker;
    }

    public final CacheKeyConfig copy(boolean includeDimensionsInBitmapKey, boolean includeDimensionsInEncodedKey, boolean enableDiskSimilarity, int hashThreshold, boolean excludeBitmapConfigFromComparison, Function2<? super Integer, ? super ResizeOptions, ResizeOptions> resizeOptionsFilter, DimensionExtractor dimensionExtractor, EncodedCacheKeyEnricher encodedKeyEnricher, Function2<? super ImageRequest, ? super CacheKey, Unit> debugImageTracker) {
        return new CacheKeyConfig(includeDimensionsInBitmapKey, includeDimensionsInEncodedKey, enableDiskSimilarity, hashThreshold, excludeBitmapConfigFromComparison, resizeOptionsFilter, dimensionExtractor, encodedKeyEnricher, debugImageTracker);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheKeyConfig)) {
            return false;
        }
        CacheKeyConfig cacheKeyConfig = (CacheKeyConfig) other;
        return this.includeDimensionsInBitmapKey == cacheKeyConfig.includeDimensionsInBitmapKey && this.includeDimensionsInEncodedKey == cacheKeyConfig.includeDimensionsInEncodedKey && this.enableDiskSimilarity == cacheKeyConfig.enableDiskSimilarity && this.hashThreshold == cacheKeyConfig.hashThreshold && this.excludeBitmapConfigFromComparison == cacheKeyConfig.excludeBitmapConfigFromComparison && Intrinsics.areEqual(this.resizeOptionsFilter, cacheKeyConfig.resizeOptionsFilter) && Intrinsics.areEqual(this.dimensionExtractor, cacheKeyConfig.dimensionExtractor) && Intrinsics.areEqual(this.encodedKeyEnricher, cacheKeyConfig.encodedKeyEnricher) && Intrinsics.areEqual(this.debugImageTracker, cacheKeyConfig.debugImageTracker);
    }

    public int hashCode() {
        int iHashCode = ((((((((Boolean.hashCode(this.includeDimensionsInBitmapKey) * 31) + Boolean.hashCode(this.includeDimensionsInEncodedKey)) * 31) + Boolean.hashCode(this.enableDiskSimilarity)) * 31) + Integer.hashCode(this.hashThreshold)) * 31) + Boolean.hashCode(this.excludeBitmapConfigFromComparison)) * 31;
        Function2<Integer, ResizeOptions, ResizeOptions> function2 = this.resizeOptionsFilter;
        int iHashCode2 = (iHashCode + (function2 == null ? 0 : function2.hashCode())) * 31;
        DimensionExtractor dimensionExtractor = this.dimensionExtractor;
        int iHashCode3 = (iHashCode2 + (dimensionExtractor == null ? 0 : dimensionExtractor.hashCode())) * 31;
        EncodedCacheKeyEnricher encodedCacheKeyEnricher = this.encodedKeyEnricher;
        int iHashCode4 = (iHashCode3 + (encodedCacheKeyEnricher == null ? 0 : encodedCacheKeyEnricher.hashCode())) * 31;
        Function2<ImageRequest, CacheKey, Unit> function3 = this.debugImageTracker;
        return iHashCode4 + (function3 != null ? function3.hashCode() : 0);
    }

    public String toString() {
        return "CacheKeyConfig(includeDimensionsInBitmapKey=" + this.includeDimensionsInBitmapKey + ", includeDimensionsInEncodedKey=" + this.includeDimensionsInEncodedKey + ", enableDiskSimilarity=" + this.enableDiskSimilarity + ", hashThreshold=" + this.hashThreshold + ", excludeBitmapConfigFromComparison=" + this.excludeBitmapConfigFromComparison + ", resizeOptionsFilter=" + this.resizeOptionsFilter + ", dimensionExtractor=" + this.dimensionExtractor + ", encodedKeyEnricher=" + this.encodedKeyEnricher + ", debugImageTracker=" + this.debugImageTracker + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CacheKeyConfig(boolean z, boolean z2, boolean z3, int i, boolean z4, Function2<? super Integer, ? super ResizeOptions, ResizeOptions> function2, DimensionExtractor dimensionExtractor, EncodedCacheKeyEnricher encodedCacheKeyEnricher, Function2<? super ImageRequest, ? super CacheKey, Unit> function3) {
        this.includeDimensionsInBitmapKey = z;
        this.includeDimensionsInEncodedKey = z2;
        this.enableDiskSimilarity = z3;
        this.hashThreshold = i;
        this.excludeBitmapConfigFromComparison = z4;
        this.resizeOptionsFilter = function2;
        this.dimensionExtractor = dimensionExtractor;
        this.encodedKeyEnricher = encodedCacheKeyEnricher;
        this.debugImageTracker = function3;
    }

    public /* synthetic */ CacheKeyConfig(boolean z, boolean z2, boolean z3, int i, boolean z4, Function2 function2, DimensionExtractor dimensionExtractor, EncodedCacheKeyEnricher encodedCacheKeyEnricher, Function2 function3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? Integer.MAX_VALUE : i, (i2 & 16) != 0 ? false : z4, (i2 & 32) != 0 ? null : function2, (i2 & 64) != 0 ? null : dimensionExtractor, (i2 & 128) != 0 ? null : encodedCacheKeyEnricher, (i2 & 256) != 0 ? null : function3);
    }

    public final boolean getIncludeDimensionsInBitmapKey() {
        return this.includeDimensionsInBitmapKey;
    }

    public final boolean getIncludeDimensionsInEncodedKey() {
        return this.includeDimensionsInEncodedKey;
    }

    public final boolean getEnableDiskSimilarity() {
        return this.enableDiskSimilarity;
    }

    public final int getHashThreshold() {
        return this.hashThreshold;
    }

    public final boolean getExcludeBitmapConfigFromComparison() {
        return this.excludeBitmapConfigFromComparison;
    }

    public final Function2<Integer, ResizeOptions, ResizeOptions> getResizeOptionsFilter() {
        return this.resizeOptionsFilter;
    }

    public final DimensionExtractor getDimensionExtractor() {
        return this.dimensionExtractor;
    }

    public final EncodedCacheKeyEnricher getEncodedKeyEnricher() {
        return this.encodedKeyEnricher;
    }

    public final Function2<ImageRequest, CacheKey, Unit> getDebugImageTracker() {
        return this.debugImageTracker;
    }
}
