package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiskCachesStoreFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001b\u0010\u0002\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u0005R\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000bR'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"com/facebook/imagepipeline/core/DiskCachesStoreFactory$diskCachesStore$2$1", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "mainFileCache", "Lcom/facebook/cache/disk/FileCache;", "getMainFileCache", "()Lcom/facebook/cache/disk/FileCache;", "mainFileCache$delegate", "Lkotlin/Lazy;", "mainBufferedDiskCache", "Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "getMainBufferedDiskCache", "()Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "mainBufferedDiskCache$delegate", "smallImageFileCache", "getSmallImageFileCache", "smallImageFileCache$delegate", "smallImageBufferedDiskCache", "getSmallImageBufferedDiskCache", "smallImageBufferedDiskCache$delegate", "dynamicFileCaches", "", "", "getDynamicFileCaches", "()Ljava/util/Map;", "dynamicFileCaches$delegate", "dynamicBufferedDiskCaches", "Lcom/facebook/common/internal/ImmutableMap;", "getDynamicBufferedDiskCaches", "()Lcom/facebook/common/internal/ImmutableMap;", "dynamicBufferedDiskCaches$delegate", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiskCachesStoreFactory$diskCachesStore$2$1 implements DiskCachesStore {

    /* JADX INFO: renamed from: dynamicBufferedDiskCaches$delegate, reason: from kotlin metadata */
    private final Lazy dynamicBufferedDiskCaches;

    /* JADX INFO: renamed from: dynamicFileCaches$delegate, reason: from kotlin metadata */
    private final Lazy dynamicFileCaches;

    /* JADX INFO: renamed from: mainBufferedDiskCache$delegate, reason: from kotlin metadata */
    private final Lazy mainBufferedDiskCache;

    /* JADX INFO: renamed from: mainFileCache$delegate, reason: from kotlin metadata */
    private final Lazy mainFileCache;

    /* JADX INFO: renamed from: smallImageBufferedDiskCache$delegate, reason: from kotlin metadata */
    private final Lazy smallImageBufferedDiskCache;

    /* JADX INFO: renamed from: smallImageFileCache$delegate, reason: from kotlin metadata */
    private final Lazy smallImageFileCache;

    DiskCachesStoreFactory$diskCachesStore$2$1(final DiskCachesStoreFactory diskCachesStoreFactory) {
        this.mainFileCache = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DiskCachesStoreFactory diskCachesStoreFactory2 = diskCachesStoreFactory;
                return diskCachesStoreFactory2.fileCacheFactory.get(diskCachesStoreFactory2.mainDiskCacheConfig);
            }
        });
        this.mainBufferedDiskCache = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.mainBufferedDiskCache_delegate$lambda$1(this.f$0, diskCachesStoreFactory);
            }
        });
        this.smallImageFileCache = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DiskCachesStoreFactory diskCachesStoreFactory2 = diskCachesStoreFactory;
                return diskCachesStoreFactory2.fileCacheFactory.get(diskCachesStoreFactory2.smallImageDiskCacheConfig);
            }
        });
        this.smallImageBufferedDiskCache = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.smallImageBufferedDiskCache_delegate$lambda$3(this.f$0, diskCachesStoreFactory);
            }
        });
        this.dynamicFileCaches = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.dynamicFileCaches_delegate$lambda$7(diskCachesStoreFactory, this);
            }
        });
        this.dynamicBufferedDiskCaches = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.dynamicBufferedDiskCaches_delegate$lambda$9(this.f$0, diskCachesStoreFactory);
            }
        });
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public FileCache getMainFileCache() {
        return (FileCache) this.mainFileCache.getValue();
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public BufferedDiskCache getMainBufferedDiskCache() {
        return (BufferedDiskCache) this.mainBufferedDiskCache.getValue();
    }

    static final BufferedDiskCache mainBufferedDiskCache_delegate$lambda$1(DiskCachesStoreFactory$diskCachesStore$2$1 diskCachesStoreFactory$diskCachesStore$2$1, DiskCachesStoreFactory diskCachesStoreFactory) {
        return new BufferedDiskCache(diskCachesStoreFactory$diskCachesStore$2$1.getMainFileCache(), diskCachesStoreFactory.poolFactory.getPooledByteBufferFactory(diskCachesStoreFactory.memoryChunkType), diskCachesStoreFactory.poolFactory.getPooledByteStreams(), diskCachesStoreFactory.executorSupplier.getIoBoundExecutor(), diskCachesStoreFactory.executorSupplier.forLocalStorageWrite(), diskCachesStoreFactory.imageCacheStatsTracker, false, false, null);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public FileCache getSmallImageFileCache() {
        return (FileCache) this.smallImageFileCache.getValue();
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public BufferedDiskCache getSmallImageBufferedDiskCache() {
        return (BufferedDiskCache) this.smallImageBufferedDiskCache.getValue();
    }

    static final BufferedDiskCache smallImageBufferedDiskCache_delegate$lambda$3(DiskCachesStoreFactory$diskCachesStore$2$1 diskCachesStoreFactory$diskCachesStore$2$1, DiskCachesStoreFactory diskCachesStoreFactory) {
        return new BufferedDiskCache(diskCachesStoreFactory$diskCachesStore$2$1.getSmallImageFileCache(), diskCachesStoreFactory.poolFactory.getPooledByteBufferFactory(diskCachesStoreFactory.memoryChunkType), diskCachesStoreFactory.poolFactory.getPooledByteStreams(), diskCachesStoreFactory.executorSupplier.getIoBoundExecutor(), diskCachesStoreFactory.executorSupplier.forLocalStorageWrite(), diskCachesStoreFactory.imageCacheStatsTracker, false, false, null);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public Map<String, FileCache> getDynamicFileCaches() {
        return (Map) this.dynamicFileCaches.getValue();
    }

    static final Map dynamicFileCaches_delegate$lambda$7(DiskCachesStoreFactory diskCachesStoreFactory, DiskCachesStoreFactory$diskCachesStore$2$1 diskCachesStoreFactory$diskCachesStore$2$1) {
        Map map = diskCachesStoreFactory.dynamicDiskCacheConfigMap;
        if (map == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), diskCachesStoreFactory.fileCacheFactory.get((DiskCacheConfig) entry.getValue()));
        }
        return linkedHashMap;
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public ImmutableMap<String, BufferedDiskCache> getDynamicBufferedDiskCaches() {
        Object value = this.dynamicBufferedDiskCaches.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImmutableMap) value;
    }

    static final ImmutableMap dynamicBufferedDiskCaches_delegate$lambda$9(DiskCachesStoreFactory$diskCachesStore$2$1 diskCachesStoreFactory$diskCachesStore$2$1, DiskCachesStoreFactory diskCachesStoreFactory) {
        Map<String, FileCache> dynamicFileCaches = diskCachesStoreFactory$diskCachesStore$2$1.getDynamicFileCaches();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(dynamicFileCaches.size()));
        Iterator<T> it = dynamicFileCaches.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), new BufferedDiskCache((FileCache) entry.getValue(), diskCachesStoreFactory.poolFactory.getPooledByteBufferFactory(diskCachesStoreFactory.memoryChunkType), diskCachesStoreFactory.poolFactory.getPooledByteStreams(), diskCachesStoreFactory.executorSupplier.getIoBoundExecutor(), diskCachesStoreFactory.executorSupplier.forLocalStorageWrite(), diskCachesStoreFactory.imageCacheStatsTracker, false, false, null));
        }
        return ImmutableMap.copyOf((Map) linkedHashMap);
    }
}
