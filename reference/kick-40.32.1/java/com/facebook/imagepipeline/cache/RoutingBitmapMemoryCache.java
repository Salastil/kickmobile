package com.facebook.imagepipeline.cache;

import com.datadog.trace.api.DDSpanTypes;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoutingBitmapMemoryCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016J&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016J\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0017\u0010\u0015\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0096\u0002J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/facebook/imagepipeline/cache/RoutingBitmapMemoryCache;", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "bitmapCache", "nonBitmapCache", "<init>", "(Lcom/facebook/imagepipeline/cache/MemoryCache;Lcom/facebook/imagepipeline/cache/MemoryCache;)V", DDSpanTypes.CACHE, "Lcom/facebook/common/references/CloseableReference;", "key", "value", "cacheOnRelease", "get", "inspect", "probe", "", "removeAll", "", "predicate", "Lcom/facebook/common/internal/Predicate;", "contains", "", "count", "getCount", "()I", "sizeInBytes", "getSizeInBytes", "trim", "trimType", "Lcom/facebook/common/memory/MemoryTrimType;", "debugData", "", "getDebugData", "()Ljava/lang/String;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RoutingBitmapMemoryCache implements MemoryCache<CacheKey, CloseableImage> {
    private final MemoryCache<CacheKey, CloseableImage> bitmapCache;
    private final MemoryCache<CacheKey, CloseableImage> nonBitmapCache;

    public RoutingBitmapMemoryCache(MemoryCache<CacheKey, CloseableImage> bitmapCache, MemoryCache<CacheKey, CloseableImage> nonBitmapCache) {
        Intrinsics.checkNotNullParameter(bitmapCache, "bitmapCache");
        Intrinsics.checkNotNullParameter(nonBitmapCache, "nonBitmapCache");
        this.bitmapCache = bitmapCache;
        this.nonBitmapCache = nonBitmapCache;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<CloseableImage> cache(CacheKey key, CloseableReference<CloseableImage> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        CloseableImage closeableImage = value.get();
        if (closeableImage == null) {
            return null;
        }
        if (closeableImage instanceof CloseableBitmap) {
            return this.bitmapCache.cache(key, value);
        }
        return this.nonBitmapCache.cache(key, value);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<CloseableImage> cacheOnRelease(CacheKey key, CloseableReference<CloseableImage> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        CloseableImage closeableImage = value.get();
        if (closeableImage == null) {
            return null;
        }
        if (closeableImage instanceof CloseableBitmap) {
            return this.bitmapCache.cacheOnRelease(key, value);
        }
        return this.nonBitmapCache.cacheOnRelease(key, value);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<CloseableImage> get(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CloseableReference<CloseableImage> closeableReference = this.bitmapCache.get(key);
        return closeableReference == null ? this.nonBitmapCache.get(key) : closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableImage inspect(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CloseableImage closeableImageInspect = this.bitmapCache.inspect(key);
        return closeableImageInspect == null ? this.nonBitmapCache.inspect(key) : closeableImageInspect;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.bitmapCache.probe(key);
        this.nonBitmapCache.probe(key);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<CacheKey> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return this.bitmapCache.removeAll(predicate) + this.nonBitmapCache.removeAll(predicate);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(Predicate<CacheKey> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return this.bitmapCache.contains(predicate) || this.nonBitmapCache.contains(predicate);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.bitmapCache.contains(key) || this.nonBitmapCache.contains(key);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getCount() {
        return this.bitmapCache.getCount() + this.nonBitmapCache.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getSizeInBytes() {
        return this.bitmapCache.getSizeInBytes() + this.nonBitmapCache.getSizeInBytes();
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType trimType) {
        Intrinsics.checkNotNullParameter(trimType, "trimType");
        this.bitmapCache.trim(trimType);
        this.nonBitmapCache.trim(trimType);
    }

    @Override // com.facebook.cache.common.HasDebugData
    public String getDebugData() {
        return "RoutingBitmapMemoryCache{bitmap=" + this.bitmapCache.getDebugData() + ", nonBitmap=" + this.nonBitmapCache.getDebugData() + "}";
    }
}
