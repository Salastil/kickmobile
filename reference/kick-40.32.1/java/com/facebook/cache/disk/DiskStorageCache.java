package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import io.ktor.http.ContentDisposition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiskStorageCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0003Z[\\BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u000201H\u0007J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00122\u0006\u00106\u001a\u000207H\u0016J\u001c\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u001d2\b\u00106\u001a\u0004\u0018\u000107H\u0002J$\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020:2\b\u00106\u001a\u0004\u0018\u0001072\b\u0010;\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010>\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u0002012\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u0016H\u0016J\b\u0010D\u001a\u000201H\u0002J\u001a\u0010E\u001a\u0002012\u0006\u0010F\u001a\u00020\u00162\b\u0010G\u001a\u0004\u0018\u00010HH\u0003J\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020K0JH\u0002J\b\u0010M\u001a\u000201H\u0003J\b\u0010N\u001a\u00020\u0016H\u0016J\b\u0010O\u001a\u00020\u0016H\u0016J\b\u0010P\u001a\u000201H\u0016J\u0010\u0010Q\u001a\u00020\u00122\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010R\u001a\u00020\u00122\u0006\u00106\u001a\u000207H\u0016J\b\u0010S\u001a\u000201H\u0016J\b\u0010T\u001a\u000201H\u0016J\u0010\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020\u0012H\u0003J\b\u0010Y\u001a\u00020\u0012H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00102\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b2\u00103¨\u0006]"}, d2 = {"Lcom/facebook/cache/disk/DiskStorageCache;", "Lcom/facebook/cache/disk/FileCache;", "Lcom/facebook/common/disk/DiskTrimmable;", "storage", "Lcom/facebook/cache/disk/DiskStorage;", "entryEvictionComparatorSupplier", "Lcom/facebook/cache/disk/EntryEvictionComparatorSupplier;", "params", "Lcom/facebook/cache/disk/DiskStorageCache$Params;", "cacheEventListener", "Lcom/facebook/cache/common/CacheEventListener;", "cacheErrorLogger", "Lcom/facebook/cache/common/CacheErrorLogger;", "diskTrimmableRegistry", "Lcom/facebook/common/disk/DiskTrimmableRegistry;", "executorForBackgrountInit", "Ljava/util/concurrent/Executor;", "indexPopulateAtStartupEnabled", "", "<init>", "(Lcom/facebook/cache/disk/DiskStorage;Lcom/facebook/cache/disk/EntryEvictionComparatorSupplier;Lcom/facebook/cache/disk/DiskStorageCache$Params;Lcom/facebook/cache/common/CacheEventListener;Lcom/facebook/cache/common/CacheErrorLogger;Lcom/facebook/common/disk/DiskTrimmableRegistry;Ljava/util/concurrent/Executor;Z)V", "lowDiskSpaceCacheSizeLimit", "", "defaultCacheSizeLimit", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "cacheSizeLimit", "resourceIndex", "", "", "getResourceIndex$annotations", "()V", "getResourceIndex", "()Ljava/util/Set;", "cacheSizeLastUpdateTime", "cacheSizeLimitMinimum", "statFsHelper", "Lcom/facebook/common/statfs/StatFsHelper;", "cacheStats", "Lcom/facebook/cache/disk/DiskStorageCache$CacheStats;", "clock", "Lcom/facebook/common/time/Clock;", "lock", "", "indexReady", "getDumpInfo", "Lcom/facebook/cache/disk/DiskStorage$DiskDumpInfo;", "isEnabled", "awaitIndex", "", "isIndexReady", "()Z", "getResource", "Lcom/facebook/binaryresource/BinaryResource;", "key", "Lcom/facebook/cache/common/CacheKey;", "probe", "startInsert", "Lcom/facebook/cache/disk/DiskStorage$Inserter;", "resourceId", "endInsert", "inserter", "insert", "callback", "Lcom/facebook/cache/common/WriterCallback;", "remove", "clearOldEntries", "cacheExpirationMs", "maybeEvictFilesInCacheDir", "evictAboveSize", "desiredSize", "reason", "Lcom/facebook/cache/common/CacheEventListener$EvictionReason;", "getSortedEntries", "", "Lcom/facebook/cache/disk/DiskStorage$Entry;", "allEntries", "updateFileCacheSizeLimit", "getSize", "getCount", "clearAll", "hasKeySync", "hasKey", "trimToMinimum", "trimToNothing", "trimBy", "trimRatio", "", "maybeUpdateFileCacheSize", "maybeUpdateFileCacheSizeAndIndex", "CacheStats", "Params", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiskStorageCache implements FileCache, DiskTrimmable {
    private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS;
    private static final long FUTURE_TIMESTAMP_THRESHOLD_MS;
    public static final int START_OF_VERSIONING = 1;
    private static final double TRIMMING_LOWER_BOUND = 0.02d;
    private static final long UNINITIALIZED;
    private final CacheErrorLogger cacheErrorLogger;
    private final CacheEventListener cacheEventListener;
    private long cacheSizeLastUpdateTime;
    private long cacheSizeLimit;
    private final long cacheSizeLimitMinimum;
    private final CacheStats cacheStats;
    private final Clock clock;
    private CountDownLatch countDownLatch;
    private final long defaultCacheSizeLimit;
    private final EntryEvictionComparatorSupplier entryEvictionComparatorSupplier;
    private final boolean indexPopulateAtStartupEnabled;
    private boolean indexReady;
    private final Object lock;
    private final long lowDiskSpaceCacheSizeLimit;
    private final Set<String> resourceIndex;
    private final StatFsHelper statFsHelper;
    private final DiskStorage storage;
    private static final Class<?> TAG = DiskStorageCache.class;

    public static /* synthetic */ void getResourceIndex$annotations() {
    }

    @Override // com.facebook.cache.disk.FileCache
    public String getMetadata(CacheKey cacheKey) {
        return super.getMetadata(cacheKey);
    }

    @Override // com.facebook.cache.disk.FileCache
    public void setMetadata(CacheKey cacheKey, String str) {
        super.setMetadata(cacheKey, str);
    }

    public DiskStorageCache(DiskStorage storage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, DiskTrimmableRegistry diskTrimmableRegistry, Executor executorForBackgrountInit, boolean z) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(entryEvictionComparatorSupplier, "entryEvictionComparatorSupplier");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(cacheErrorLogger, "cacheErrorLogger");
        Intrinsics.checkNotNullParameter(executorForBackgrountInit, "executorForBackgrountInit");
        this.storage = storage;
        this.entryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
        this.cacheEventListener = cacheEventListener;
        this.cacheErrorLogger = cacheErrorLogger;
        this.indexPopulateAtStartupEnabled = z;
        this.lock = new Object();
        this.lowDiskSpaceCacheSizeLimit = params.getLowDiskSpaceCacheSizeLimit();
        this.defaultCacheSizeLimit = params.getDefaultCacheSizeLimit();
        this.cacheSizeLimit = params.getDefaultCacheSizeLimit();
        StatFsHelper statFsHelper = StatFsHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(statFsHelper, "getInstance(...)");
        this.statFsHelper = statFsHelper;
        this.cacheSizeLastUpdateTime = UNINITIALIZED;
        this.cacheSizeLimitMinimum = params.getCacheSizeLimitMinimum();
        this.cacheStats = new CacheStats();
        SystemClock systemClock = SystemClock.get();
        Intrinsics.checkNotNullExpressionValue(systemClock, "get(...)");
        this.clock = systemClock;
        this.resourceIndex = new HashSet();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        if (z) {
            this.countDownLatch = new CountDownLatch(1);
            executorForBackgrountInit.execute(new Runnable() { // from class: com.facebook.cache.disk.DiskStorageCache.1
                @Override // java.lang.Runnable
                public void run() {
                    Object obj = DiskStorageCache.this.lock;
                    DiskStorageCache diskStorageCache = DiskStorageCache.this;
                    synchronized (obj) {
                        diskStorageCache.maybeUpdateFileCacheSize();
                    }
                    DiskStorageCache.this.indexReady = true;
                    CountDownLatch countDownLatch = DiskStorageCache.this.countDownLatch;
                    Intrinsics.checkNotNull(countDownLatch);
                    countDownLatch.countDown();
                }
            });
        } else {
            this.countDownLatch = new CountDownLatch(0);
        }
    }

    public final Set<String> getResourceIndex() {
        return this.resourceIndex;
    }

    /* JADX INFO: compiled from: DiskStorageCache.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/facebook/cache/disk/DiskStorageCache$CacheStats;", "", "<init>", "()V", "value", "", "isInitialized", "()Z", "", ContentDisposition.Parameters.Size, "getSize", "()J", "count", "getCount", "reset", "", "set", "increment", "sizeIncrement", "countIncrement", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CacheStats {
        private boolean isInitialized;
        private long size = DiskStorageCache.UNINITIALIZED;
        private long count = DiskStorageCache.UNINITIALIZED;

        public final synchronized boolean isInitialized() {
            return this.isInitialized;
        }

        public final synchronized long getSize() {
            return this.size;
        }

        public final synchronized long getCount() {
            return this.count;
        }

        public final synchronized void reset() {
            this.isInitialized = false;
            this.count = DiskStorageCache.UNINITIALIZED;
            this.size = DiskStorageCache.UNINITIALIZED;
        }

        public final synchronized void set(long size, long count) {
            this.count = count;
            this.size = size;
            this.isInitialized = true;
        }

        public final synchronized void increment(long sizeIncrement, long countIncrement) {
            if (this.isInitialized) {
                this.size += sizeIncrement;
                this.count += countIncrement;
            }
        }
    }

    /* JADX INFO: compiled from: DiskStorageCache.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/facebook/cache/disk/DiskStorageCache$Params;", "", "cacheSizeLimitMinimum", "", "lowDiskSpaceCacheSizeLimit", "defaultCacheSizeLimit", "<init>", "(JJJ)V", "getCacheSizeLimitMinimum", "()J", "getLowDiskSpaceCacheSizeLimit", "getDefaultCacheSizeLimit", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Params {
        private final long cacheSizeLimitMinimum;
        private final long defaultCacheSizeLimit;
        private final long lowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            this.cacheSizeLimitMinimum = j;
            this.lowDiskSpaceCacheSizeLimit = j2;
            this.defaultCacheSizeLimit = j3;
        }

        public final long getCacheSizeLimitMinimum() {
            return this.cacheSizeLimitMinimum;
        }

        public final long getLowDiskSpaceCacheSizeLimit() {
            return this.lowDiskSpaceCacheSizeLimit;
        }

        public final long getDefaultCacheSizeLimit() {
            return this.defaultCacheSizeLimit;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        DiskStorage.DiskDumpInfo dumpInfo = this.storage.getDumpInfo();
        Intrinsics.checkNotNullExpressionValue(dumpInfo, "getDumpInfo(...)");
        return dumpInfo;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean isEnabled() {
        return this.storage.isEnabled();
    }

    public final void awaitIndex() {
        try {
            CountDownLatch countDownLatch = this.countDownLatch;
            Intrinsics.checkNotNull(countDownLatch);
            countDownLatch.await();
        } catch (InterruptedException unused) {
            FLog.e(TAG, "Memory Index is not ready yet. ");
        }
    }

    public final boolean isIndexReady() {
        return this.indexReady || !this.indexPopulateAtStartupEnabled;
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource getResource(CacheKey key) {
        BinaryResource resource;
        Intrinsics.checkNotNullParameter(key, "key");
        SettableCacheEvent cacheKey = SettableCacheEvent.obtain().setCacheKey(key);
        Intrinsics.checkNotNullExpressionValue(cacheKey, "setCacheKey(...)");
        try {
            try {
                synchronized (this.lock) {
                    List<String> resourceIds = CacheKeyUtil.getResourceIds(key);
                    int size = resourceIds.size();
                    String str = null;
                    resource = null;
                    for (int i = 0; i < size; i++) {
                        str = resourceIds.get(i);
                        Intrinsics.checkNotNull(str);
                        cacheKey.setResourceId(str);
                        resource = this.storage.getResource(str, key);
                        if (resource != null) {
                            break;
                        }
                    }
                    if (resource == null) {
                        CacheEventListener cacheEventListener = this.cacheEventListener;
                        if (cacheEventListener != null) {
                            cacheEventListener.onMiss(cacheKey);
                        }
                        this.resourceIndex.remove(str);
                    } else {
                        if (str == null) {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        CacheEventListener cacheEventListener2 = this.cacheEventListener;
                        if (cacheEventListener2 != null) {
                            cacheEventListener2.onHit(cacheKey);
                        }
                        this.resourceIndex.add(str);
                    }
                }
                cacheKey.recycle();
                return resource;
            } catch (IOException e) {
                this.cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", e);
                cacheKey.setException(e);
                CacheEventListener cacheEventListener3 = this.cacheEventListener;
                if (cacheEventListener3 != null) {
                    cacheEventListener3.onReadException(cacheKey);
                }
                cacheKey.recycle();
                return null;
            }
        } catch (Throwable th) {
            cacheKey.recycle();
            throw th;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean probe(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String str = null;
        try {
            synchronized (this.lock) {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(key);
                int size = resourceIds.size();
                for (int i = 0; i < size; i++) {
                    str = resourceIds.get(i);
                    DiskStorage diskStorage = this.storage;
                    Intrinsics.checkNotNull(str);
                    if (diskStorage.touch(str, key)) {
                        this.resourceIndex.add(str);
                        return true;
                    }
                }
                return false;
            }
        } catch (IOException e) {
            SettableCacheEvent cacheKey = SettableCacheEvent.obtain().setCacheKey(key);
            Intrinsics.checkNotNull(str);
            SettableCacheEvent exception = cacheKey.setResourceId(str).setException(e);
            Intrinsics.checkNotNullExpressionValue(exception, "setException(...)");
            CacheEventListener cacheEventListener = this.cacheEventListener;
            if (cacheEventListener != null) {
                cacheEventListener.onReadException(exception);
            }
            exception.recycle();
            return false;
        }
    }

    private final DiskStorage.Inserter startInsert(String resourceId, CacheKey key) throws IOException {
        maybeEvictFilesInCacheDir();
        DiskStorage diskStorage = this.storage;
        Intrinsics.checkNotNull(resourceId);
        Intrinsics.checkNotNull(key);
        DiskStorage.Inserter inserterInsert = diskStorage.insert(resourceId, key);
        Intrinsics.checkNotNullExpressionValue(inserterInsert, "insert(...)");
        return inserterInsert;
    }

    private final BinaryResource endInsert(DiskStorage.Inserter inserter, CacheKey key, String resourceId) throws IOException {
        BinaryResource binaryResourceCommit;
        synchronized (this.lock) {
            Intrinsics.checkNotNull(key);
            binaryResourceCommit = inserter.commit(key);
            Intrinsics.checkNotNullExpressionValue(binaryResourceCommit, "commit(...)");
            this.resourceIndex.add(resourceId);
            this.cacheStats.increment(binaryResourceCommit.size(), 1L);
        }
        return binaryResourceCommit;
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource insert(CacheKey key, WriterCallback callback) throws IOException {
        String firstResourceId;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SettableCacheEvent cacheKey = SettableCacheEvent.obtain().setCacheKey(key);
        Intrinsics.checkNotNullExpressionValue(cacheKey, "setCacheKey(...)");
        CacheEventListener cacheEventListener = this.cacheEventListener;
        if (cacheEventListener != null) {
            cacheEventListener.onWriteAttempt(cacheKey);
        }
        synchronized (this.lock) {
            firstResourceId = CacheKeyUtil.getFirstResourceId(key);
            Unit unit = Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(firstResourceId);
        cacheKey.setResourceId(firstResourceId);
        try {
            try {
                DiskStorage.Inserter inserterStartInsert = startInsert(firstResourceId, key);
                try {
                    inserterStartInsert.writeData(callback, key);
                    BinaryResource binaryResourceEndInsert = endInsert(inserterStartInsert, key, firstResourceId);
                    cacheKey.setItemSize(binaryResourceEndInsert.size()).setCacheSize(this.cacheStats.getSize());
                    CacheEventListener cacheEventListener2 = this.cacheEventListener;
                    if (cacheEventListener2 != null) {
                        cacheEventListener2.onWriteSuccess(cacheKey);
                    }
                    if (!inserterStartInsert.cleanUp()) {
                        FLog.e(TAG, "Failed to delete temp file");
                    }
                    cacheKey.recycle();
                    return binaryResourceEndInsert;
                } catch (Throwable th) {
                    if (!inserterStartInsert.cleanUp()) {
                        FLog.e(TAG, "Failed to delete temp file");
                    }
                    throw th;
                }
            } catch (IOException e) {
                cacheKey.setException(e);
                CacheEventListener cacheEventListener3 = this.cacheEventListener;
                if (cacheEventListener3 != null) {
                    cacheEventListener3.onWriteException(cacheKey);
                }
                FLog.e(TAG, "Failed inserting a file into the cache", e);
                throw e;
            }
        } catch (Throwable th2) {
            cacheKey.recycle();
            throw th2;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void remove(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            try {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(key);
                int size = resourceIds.size();
                for (int i = 0; i < size; i++) {
                    String str = resourceIds.get(i);
                    this.storage.remove(str);
                    this.resourceIndex.remove(str);
                }
            } catch (IOException e) {
                this.cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + e.getMessage(), e);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long clearOldEntries(long cacheExpirationMs) {
        long j;
        long jMax;
        synchronized (this.lock) {
            try {
                long jNow = this.clock.now();
                Collection<DiskStorage.Entry> entries = this.storage.getEntries();
                Intrinsics.checkNotNullExpressionValue(entries, "getEntries(...)");
                long size = this.cacheStats.getSize();
                int i = 0;
                long j2 = 0;
                jMax = 0;
                for (DiskStorage.Entry entry : entries) {
                    try {
                        long j3 = jNow;
                        long jMax2 = (long) Math.max(1.0d, Math.abs(jNow - entry.getTimestamp()));
                        if (jMax2 >= cacheExpirationMs) {
                            long jRemove = this.storage.remove(entry);
                            this.resourceIndex.remove(entry.getId());
                            if (jRemove > 0) {
                                i++;
                                j2 += jRemove;
                                SettableCacheEvent cacheSize = SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(jRemove).setCacheSize(size - j2);
                                Intrinsics.checkNotNullExpressionValue(cacheSize, "setCacheSize(...)");
                                CacheEventListener cacheEventListener = this.cacheEventListener;
                                if (cacheEventListener != null) {
                                    cacheEventListener.onEviction(cacheSize);
                                }
                                cacheSize.recycle();
                            }
                        } else {
                            jMax = (long) Math.max(jMax, jMax2);
                        }
                        jNow = j3;
                    } catch (IOException e) {
                        e = e;
                        j = jMax;
                        this.cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);
                        jMax = j;
                    }
                }
                this.storage.purgeUnexpectedResources();
                if (i > 0) {
                    maybeUpdateFileCacheSize();
                    this.cacheStats.increment(-j2, -i);
                }
            } catch (IOException e2) {
                e = e2;
                j = 0;
            }
            Unit unit = Unit.INSTANCE;
        }
        return jMax;
    }

    private final void maybeEvictFilesInCacheDir() throws IOException {
        synchronized (this.lock) {
            boolean zMaybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
            updateFileCacheSizeLimit();
            long size = this.cacheStats.getSize();
            if (size > this.cacheSizeLimit && !zMaybeUpdateFileCacheSize) {
                this.cacheStats.reset();
                maybeUpdateFileCacheSize();
            }
            long j = this.cacheSizeLimit;
            if (size > j) {
                evictAboveSize((j * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void evictAboveSize(long desiredSize, CacheEventListener.EvictionReason reason) throws IOException {
        try {
            Collection<DiskStorage.Entry> entries = this.storage.getEntries();
            Intrinsics.checkNotNullExpressionValue(entries, "getEntries(...)");
            Collection<DiskStorage.Entry> sortedEntries = getSortedEntries(entries);
            long size = this.cacheStats.getSize();
            long j = size - desiredSize;
            int i = 0;
            long j2 = 0;
            for (DiskStorage.Entry entry : sortedEntries) {
                if (j2 > j) {
                    break;
                }
                long jRemove = this.storage.remove(entry);
                this.resourceIndex.remove(entry.getId());
                if (jRemove > 0) {
                    i++;
                    j2 += jRemove;
                    SettableCacheEvent resourceId = SettableCacheEvent.obtain().setResourceId(entry.getId());
                    Intrinsics.checkNotNull(reason);
                    SettableCacheEvent cacheLimit = resourceId.setEvictionReason(reason).setItemSize(jRemove).setCacheSize(size - j2).setCacheLimit(desiredSize);
                    Intrinsics.checkNotNullExpressionValue(cacheLimit, "setCacheLimit(...)");
                    CacheEventListener cacheEventListener = this.cacheEventListener;
                    if (cacheEventListener != null) {
                        cacheEventListener.onEviction(cacheLimit);
                    }
                    cacheLimit.recycle();
                }
            }
            this.cacheStats.increment(-j2, -i);
            this.storage.purgeUnexpectedResources();
        } catch (IOException e) {
            this.cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private final Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> allEntries) {
        long jNow = this.clock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
        ArrayList arrayList = new ArrayList(allEntries.size());
        ArrayList arrayList2 = new ArrayList(allEntries.size());
        for (DiskStorage.Entry entry : allEntries) {
            if (entry.getTimestamp() > jNow) {
                arrayList.add(entry);
            } else {
                arrayList2.add(entry);
            }
        }
        EntryEvictionComparator entryEvictionComparator = this.entryEvictionComparatorSupplier.get();
        Intrinsics.checkNotNullExpressionValue(entryEvictionComparator, "get(...)");
        CollectionsKt.sortWith(arrayList2, entryEvictionComparator);
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private final void updateFileCacheSizeLimit() {
        if (this.statFsHelper.testLowDiskSpace(this.storage.getMIsExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.defaultCacheSizeLimit - this.cacheStats.getSize())) {
            this.cacheSizeLimit = this.lowDiskSpaceCacheSizeLimit;
        } else {
            this.cacheSizeLimit = this.defaultCacheSizeLimit;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getSize() {
        return this.cacheStats.getSize();
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getCount() {
        return this.cacheStats.getCount();
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearAll() {
        synchronized (this.lock) {
            try {
                this.storage.clearAll();
                this.resourceIndex.clear();
                CacheEventListener cacheEventListener = this.cacheEventListener;
                if (cacheEventListener != null) {
                    cacheEventListener.onCleared();
                }
            } catch (IOException e) {
                this.cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + e.getMessage(), e);
            } catch (NullPointerException e2) {
                this.cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + e2.getMessage(), e2);
            }
            this.cacheStats.reset();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKeySync(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            List<String> resourceIds = CacheKeyUtil.getResourceIds(key);
            int size = resourceIds.size();
            for (int i = 0; i < size; i++) {
                if (this.resourceIndex.contains(resourceIds.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKey(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            if (hasKeySync(key)) {
                return true;
            }
            try {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(key);
                int size = resourceIds.size();
                for (int i = 0; i < size; i++) {
                    String str = resourceIds.get(i);
                    if (this.storage.contains(str, key)) {
                        this.resourceIndex.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToMinimum() {
        synchronized (this.lock) {
            maybeUpdateFileCacheSize();
            long size = this.cacheStats.getSize();
            long j = this.cacheSizeLimitMinimum;
            if (j > 0 && size > 0 && size >= j) {
                double d = 1.0d - (j / size);
                if (d > TRIMMING_LOWER_BOUND) {
                    trimBy(d);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToNothing() {
        clearAll();
    }

    private final void trimBy(double trimRatio) {
        synchronized (this.lock) {
            try {
                this.cacheStats.reset();
                maybeUpdateFileCacheSize();
                long size = this.cacheStats.getSize();
                evictAboveSize(size - ((long) (trimRatio * size)), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (IOException e) {
                this.cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + e.getMessage(), e);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean maybeUpdateFileCacheSize() {
        long jNow = this.clock.now();
        if (this.cacheStats.isInitialized()) {
            long j = this.cacheSizeLastUpdateTime;
            if (j != UNINITIALIZED && jNow - j <= FILECACHE_SIZE_UPDATE_PERIOD_MS) {
                return false;
            }
        }
        return maybeUpdateFileCacheSizeAndIndex();
    }

    private final boolean maybeUpdateFileCacheSizeAndIndex() {
        HashSet hashSet;
        boolean z;
        Set<String> set;
        long jNow = this.clock.now();
        long j = FUTURE_TIMESTAMP_THRESHOLD_MS + jNow;
        if (this.indexPopulateAtStartupEnabled && this.resourceIndex.isEmpty()) {
            hashSet = this.resourceIndex;
        } else {
            hashSet = this.indexPopulateAtStartupEnabled ? new HashSet() : null;
        }
        try {
            Collection<DiskStorage.Entry> entries = this.storage.getEntries();
            Intrinsics.checkNotNullExpressionValue(entries, "getEntries(...)");
            long size = 0;
            long jMax = -1;
            int size2 = 0;
            boolean z2 = false;
            int i = 0;
            int i2 = 0;
            z = false;
            for (DiskStorage.Entry entry : entries) {
                try {
                    i++;
                    size += entry.getSize();
                    if (entry.getTimestamp() > j) {
                        i2++;
                        size2 += (int) entry.getSize();
                        jMax = (long) Math.max(entry.getTimestamp() - jNow, jMax);
                        z2 = true;
                    } else {
                        int i3 = size2;
                        if (this.indexPopulateAtStartupEnabled) {
                            if (hashSet == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            hashSet.add(entry.getId());
                        }
                        size2 = i3;
                    }
                    j = j;
                } catch (IOException e) {
                    e = e;
                    this.cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + e.getMessage(), e);
                    return z;
                }
            }
            int i4 = size2;
            if (z2) {
                this.cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + i2 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + jMax + "ms", null);
            }
            long j2 = i;
            if (this.cacheStats.getCount() != j2 || this.cacheStats.getSize() != size) {
                if (this.indexPopulateAtStartupEnabled && (set = this.resourceIndex) != hashSet) {
                    if (hashSet == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    set.clear();
                    this.resourceIndex.addAll(hashSet);
                }
                this.cacheStats.set(size, j2);
            }
            this.cacheSizeLastUpdateTime = jNow;
            return true;
        } catch (IOException e2) {
            e = e2;
            z = false;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.HOURS;
        FUTURE_TIMESTAMP_THRESHOLD_MS = 7200000L;
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        FILECACHE_SIZE_UPDATE_PERIOD_MS = 1800000L;
        UNINITIALIZED = -1L;
    }
}
