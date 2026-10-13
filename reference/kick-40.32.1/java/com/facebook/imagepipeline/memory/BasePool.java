package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasePool.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004IJKLB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0004J\u001d\u0010\u001f\u001a\u0004\u0018\u00018\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0014¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020$H\u0096\u0002¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0016J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020$H$¢\u0006\u0002\u0010%J\u0015\u0010\u001b\u001a\u00020\u001e2\u0006\u0010'\u001a\u00028\u0000H%¢\u0006\u0002\u0010(J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$H$J\u0015\u00100\u001a\u00020$2\u0006\u0010'\u001a\u00028\u0000H$¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020$2\u0006\u0010-\u001a\u00020$H$J\b\u00103\u001a\u00020\u001eH\u0004J\u0015\u00104\u001a\u00020\u00172\u0006\u0010'\u001a\u00028\u0000H\u0014¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\u001eH\u0002J\u0010\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u000208H\u0002J\u0014\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100=H\u0002J\b\u0010>\u001a\u00020\u001eH\u0007J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020$H\u0007J\u0018\u0010A\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\u0006\u0010-\u001a\u00020$H\u0002J\u0018\u0010B\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\u0006\u0010-\u001a\u00020$H\u0007J\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010-\u001a\u00020$H\u0016J\b\u0010D\u001a\u00020\u001eH\u0003R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0F8F¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/facebook/imagepipeline/memory/BasePool;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lcom/facebook/common/memory/Pool;", "memoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "poolParams", "Lcom/facebook/imagepipeline/memory/PoolParams;", "poolStatsTracker", "Lcom/facebook/imagepipeline/memory/PoolStatsTracker;", "<init>", "(Lcom/facebook/common/memory/MemoryTrimmableRegistry;Lcom/facebook/imagepipeline/memory/PoolParams;Lcom/facebook/imagepipeline/memory/PoolStatsTracker;)V", "TAG", "", "buckets", "Landroid/util/SparseArray;", "Lcom/facebook/imagepipeline/memory/Bucket;", "getBuckets$annotations", "()V", "inUseValues", "", "getInUseValues$annotations", "allowNewBuckets", "", "used", "Lcom/facebook/imagepipeline/memory/BasePool$Counter;", "getUsed$annotations", "free", "getFree$annotations", "initialize", "", "getValue", InstrumentationTags.BUCKET, "(Lcom/facebook/imagepipeline/memory/Bucket;)Ljava/lang/Object;", "get", ContentDisposition.Parameters.Size, "", "(I)Ljava/lang/Object;", "release", "value", "(Ljava/lang/Object;)V", "trim", "memoryTrimType", "Lcom/facebook/common/memory/MemoryTrimType;", "alloc", "bucketedSize", "getBucketedSize", "requestSize", "getBucketedSizeForValue", "(Ljava/lang/Object;)I", "getSizeInBytes", "onParamsChanged", "isReusable", "(Ljava/lang/Object;)Z", "legacyInitBuckets", "inUseCounts", "Landroid/util/SparseIntArray;", "initBuckets", "fillBuckets", "bucketSizes", "refillBuckets", "", "trimToNothing", "trimToSize", "targetSize", "getBucketIfPresent", "getBucket", "newBucket", "logStats", "stats", "", "getStats", "()Ljava/util/Map;", "Counter", "InvalidValueException", "InvalidSizeException", "SizeTooLargeException", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BasePool<V> implements Pool<V> {
    private final String TAG;
    private boolean allowNewBuckets;
    public final SparseArray<Bucket<V>> buckets;
    public final Counter free;
    public final Set<V> inUseValues;
    public final MemoryTrimmableRegistry memoryTrimmableRegistry;
    public final PoolParams poolParams;
    private final PoolStatsTracker poolStatsTracker;
    public final Counter used;

    public static /* synthetic */ void getBuckets$annotations() {
    }

    public static /* synthetic */ void getFree$annotations() {
    }

    public static /* synthetic */ void getInUseValues$annotations() {
    }

    public static /* synthetic */ void getUsed$annotations() {
    }

    protected abstract V alloc(int bucketedSize);

    protected abstract void free(V value);

    protected abstract int getBucketedSize(int requestSize);

    protected abstract int getBucketedSizeForValue(V value);

    protected abstract int getSizeInBytes(int bucketedSize);

    protected boolean isReusable(V value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return true;
    }

    protected final void onParamsChanged() {
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        Intrinsics.checkNotNullParameter(memoryTrimmableRegistry, "memoryTrimmableRegistry");
        Intrinsics.checkNotNullParameter(poolParams, "poolParams");
        Intrinsics.checkNotNullParameter(poolStatsTracker, "poolStatsTracker");
        this.TAG = getClass().getSimpleName().toString();
        this.memoryTrimmableRegistry = memoryTrimmableRegistry;
        this.poolParams = poolParams;
        this.buckets = new SparseArray<>();
        this.poolStatsTracker = poolStatsTracker;
        if (poolParams.fixBucketsReinitialization) {
            initBuckets();
        } else {
            legacyInitBuckets(new SparseIntArray(0));
        }
        Set<V> setNewIdentityHashSet = Sets.newIdentityHashSet();
        Intrinsics.checkNotNullExpressionValue(setNewIdentityHashSet, "newIdentityHashSet(...)");
        this.inUseValues = setNewIdentityHashSet;
        this.free = new Counter();
        this.used = new Counter();
    }

    protected final void initialize() {
        this.memoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.poolStatsTracker.setBasePool(this);
    }

    protected synchronized V getValue(Bucket<V> bucket) {
        V vPop;
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        vPop = bucket.pop();
        if (vPop != null) {
            bucket.incrementInUseCount();
        }
        return vPop;
    }

    @Override // com.facebook.common.memory.Pool
    public V get(int size) throws Throwable {
        V vAlloc;
        V value;
        int bucketedSize = getBucketedSize(size);
        synchronized (this) {
            Bucket<V> bucket = getBucket(bucketedSize);
            if (bucket != null && (value = getValue(bucket)) != null) {
                if (!this.inUseValues.add(value)) {
                    throw new IllegalStateException("Check failed.");
                }
                int bucketedSizeForValue = getBucketedSizeForValue(value);
                int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
                this.used.increment(sizeInBytes);
                this.free.decrement(sizeInBytes);
                this.poolStatsTracker.onValueReuse(sizeInBytes);
                logStats();
                if (FLog.isLoggable(FLog.VERBOSE)) {
                    FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSizeForValue));
                }
                return value;
            }
            int sizeInBytes2 = getSizeInBytes(bucketedSize);
            this.used.increment(sizeInBytes2);
            if (bucket != null) {
                bucket.incrementInUseCount();
                Unit unit = Unit.INSTANCE;
            }
            try {
                vAlloc = alloc(bucketedSize);
            } catch (Throwable th) {
                synchronized (this) {
                    this.used.decrement(sizeInBytes2);
                    Bucket<V> bucket2 = getBucket(bucketedSize);
                    if (bucket2 != null) {
                        bucket2.decrementInUseCount();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    Throwables.propagateIfPossible(th);
                    vAlloc = null;
                }
            }
            synchronized (this) {
                if (!this.inUseValues.add(vAlloc)) {
                    throw new IllegalStateException("Check failed.");
                }
                this.poolStatsTracker.onAlloc(sizeInBytes2);
                logStats();
                if (FLog.isLoggable(FLog.VERBOSE)) {
                    FLog.v(this.TAG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(vAlloc)), Integer.valueOf(bucketedSize));
                }
                Unit unit3 = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(vAlloc);
            return vAlloc;
        }
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(V value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int bucketedSizeForValue = getBucketedSizeForValue(value);
        int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
        synchronized (this) {
            Bucket<V> bucketIfPresent = getBucketIfPresent(bucketedSizeForValue);
            if (!this.inUseValues.remove(value)) {
                FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSizeForValue));
                free(value);
                this.poolStatsTracker.onFree(sizeInBytes);
            } else if (bucketIfPresent == null || bucketIfPresent.isMaxLengthExceeded() || !isReusable(value)) {
                if (bucketIfPresent != null) {
                    bucketIfPresent.decrementInUseCount();
                }
                if (FLog.isLoggable(FLog.VERBOSE)) {
                    FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSizeForValue));
                }
                free(value);
                this.used.decrement(sizeInBytes);
                this.poolStatsTracker.onFree(sizeInBytes);
            } else {
                bucketIfPresent.release(value);
                this.free.increment(sizeInBytes);
                this.used.decrement(sizeInBytes);
                this.poolStatsTracker.onValueRelease(sizeInBytes);
                if (FLog.isLoggable(FLog.VERBOSE)) {
                    FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSizeForValue));
                }
            }
            logStats();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        Intrinsics.checkNotNullParameter(memoryTrimType, "memoryTrimType");
        trimToNothing();
    }

    private final synchronized void legacyInitBuckets(SparseIntArray inUseCounts) {
        try {
            if (inUseCounts == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            this.buckets.clear();
            SparseIntArray sparseIntArray = this.poolParams.bucketSizes;
            if (sparseIntArray != null) {
                int size = sparseIntArray.size();
                for (int i = 0; i < size; i++) {
                    int iKeyAt = sparseIntArray.keyAt(i);
                    this.buckets.put(iKeyAt, new Bucket<>(getSizeInBytes(iKeyAt), sparseIntArray.valueAt(i), inUseCounts.get(iKeyAt, 0), this.poolParams.fixBucketsReinitialization));
                }
                this.allowNewBuckets = false;
            } else {
                this.allowNewBuckets = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void initBuckets() {
        SparseIntArray sparseIntArray = this.poolParams.bucketSizes;
        if (sparseIntArray != null) {
            fillBuckets(sparseIntArray);
            this.allowNewBuckets = false;
        } else {
            this.allowNewBuckets = true;
        }
    }

    private final void fillBuckets(SparseIntArray bucketSizes) {
        this.buckets.clear();
        int size = bucketSizes.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = bucketSizes.keyAt(i);
            this.buckets.put(iKeyAt, new Bucket<>(getSizeInBytes(iKeyAt), bucketSizes.valueAt(i), 0, this.poolParams.fixBucketsReinitialization));
        }
    }

    private final List<Bucket<V>> refillBuckets() {
        ArrayList arrayList = new ArrayList(this.buckets.size());
        int size = this.buckets.size();
        for (int i = 0; i < size; i++) {
            Bucket<V> bucketValueAt = this.buckets.valueAt(i);
            if (bucketValueAt == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Bucket<V> bucket = bucketValueAt;
            int i2 = bucket.mItemSize;
            int i3 = bucket.mMaxLength;
            int inUseCount = bucket.getInUseCount();
            if (bucket.getFreeListSize() > 0) {
                arrayList.add(bucket);
            }
            this.buckets.setValueAt(i, new Bucket<>(getSizeInBytes(i2), i3, inUseCount, this.poolParams.fixBucketsReinitialization));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void trimToNothing() {
        int i;
        List listRefillBuckets;
        synchronized (this) {
            if (this.poolParams.fixBucketsReinitialization) {
                listRefillBuckets = refillBuckets();
            } else {
                ArrayList arrayList = new ArrayList(this.buckets.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                int size = this.buckets.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Bucket<V> bucketValueAt = this.buckets.valueAt(i2);
                    if (bucketValueAt == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    Bucket<V> bucket = bucketValueAt;
                    if (bucket.getFreeListSize() > 0) {
                        arrayList.add(bucket);
                    }
                    sparseIntArray.put(this.buckets.keyAt(i2), bucket.getInUseCount());
                }
                legacyInitBuckets(sparseIntArray);
                listRefillBuckets = arrayList;
            }
            this.free.reset();
            logStats();
            Unit unit = Unit.INSTANCE;
        }
        onParamsChanged();
        int size2 = listRefillBuckets.size();
        for (i = 0; i < size2; i++) {
            Bucket bucket2 = (Bucket) listRefillBuckets.get(i);
            while (true) {
                Object objPop = bucket2.pop();
                if (objPop == null) {
                    break;
                } else {
                    free(objPop);
                }
            }
        }
    }

    public final synchronized void trimToSize(int targetSize) {
        int iMin = (int) Math.min((this.used.numBytes + this.free.numBytes) - targetSize, this.free.numBytes);
        if (iMin <= 0) {
            return;
        }
        if (FLog.isLoggable(FLog.VERBOSE)) {
            FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(targetSize), Integer.valueOf(this.used.numBytes + this.free.numBytes), Integer.valueOf(iMin));
        }
        logStats();
        int size = this.buckets.size();
        for (int i = 0; i < size && iMin > 0; i++) {
            Bucket<V> bucketValueAt = this.buckets.valueAt(i);
            if (bucketValueAt == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Bucket<V> bucket = bucketValueAt;
            while (iMin > 0) {
                V vPop = bucket.pop();
                if (vPop == null) {
                    break;
                }
                free(vPop);
                iMin -= bucket.mItemSize;
                this.free.decrement(bucket.mItemSize);
            }
        }
        logStats();
        if (FLog.isLoggable(FLog.VERBOSE)) {
            FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(targetSize), Integer.valueOf(this.used.numBytes + this.free.numBytes));
        }
    }

    private final synchronized Bucket<V> getBucketIfPresent(int bucketedSize) {
        return this.buckets.get(bucketedSize);
    }

    public final synchronized Bucket<V> getBucket(int bucketedSize) {
        Bucket<V> bucket = this.buckets.get(bucketedSize);
        if (bucket == null && this.allowNewBuckets) {
            if (FLog.isLoggable(FLog.VERBOSE)) {
                FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(bucketedSize));
            }
            Bucket<V> bucketNewBucket = newBucket(bucketedSize);
            this.buckets.put(bucketedSize, bucketNewBucket);
            return bucketNewBucket;
        }
        return bucket;
    }

    public Bucket<V> newBucket(int bucketedSize) {
        return new Bucket<>(getSizeInBytes(bucketedSize), Integer.MAX_VALUE, 0, this.poolParams.fixBucketsReinitialization);
    }

    private final void logStats() {
        if (FLog.isLoggable(FLog.VERBOSE)) {
            FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.used.count), Integer.valueOf(this.used.numBytes), Integer.valueOf(this.free.count), Integer.valueOf(this.free.numBytes));
        }
    }

    public final synchronized Map<String, Integer> getStats() {
        HashMap map;
        map = new HashMap();
        int size = this.buckets.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = this.buckets.keyAt(i);
            Bucket<V> bucketValueAt = this.buckets.valueAt(i);
            if (bucketValueAt == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            map.put("buckets_used_" + getSizeInBytes(iKeyAt), Integer.valueOf(bucketValueAt.getInUseCount()));
        }
        map.put("used_count", Integer.valueOf(this.used.count));
        map.put("used_bytes", Integer.valueOf(this.used.numBytes));
        map.put("free_count", Integer.valueOf(this.free.count));
        map.put("free_bytes", Integer.valueOf(this.free.numBytes));
        return map;
    }

    /* JADX INFO: compiled from: BasePool.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\bR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/memory/BasePool$Counter;", "", "<init>", "()V", "count", "", "numBytes", "increment", "", "decrement", "reset", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Counter {
        private static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
        public int count;
        public int numBytes;

        public final void increment(int numBytes) {
            this.count++;
            this.numBytes += numBytes;
        }

        public final void decrement(int numBytes) {
            int i;
            int i2 = this.numBytes;
            if (i2 >= numBytes && (i = this.count) > 0) {
                this.count = i - 1;
                this.numBytes = i2 - numBytes;
            } else {
                FLog.wtf(TAG, "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(numBytes), Integer.valueOf(this.numBytes), Integer.valueOf(this.count));
            }
        }

        public final void reset() {
            this.count = 0;
            this.numBytes = 0;
        }
    }

    /* JADX INFO: compiled from: BasePool.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/imagepipeline/memory/BasePool$InvalidValueException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "value", "", "<init>", "(Ljava/lang/Object;)V", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class InvalidValueException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidValueException(Object value) {
            super("Invalid value: " + value);
            Intrinsics.checkNotNullParameter(value, "value");
        }
    }

    /* JADX INFO: compiled from: BasePool.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/imagepipeline/memory/BasePool$InvalidSizeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", ContentDisposition.Parameters.Size, "", "<init>", "(Ljava/lang/Object;)V", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class InvalidSizeException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidSizeException(Object size) {
            super("Invalid size: " + size);
            Intrinsics.checkNotNullParameter(size, "size");
        }
    }

    /* JADX INFO: compiled from: BasePool.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/imagepipeline/memory/BasePool$SizeTooLargeException;", "Lcom/facebook/imagepipeline/memory/BasePool$InvalidSizeException;", ContentDisposition.Parameters.Size, "", "<init>", "(Ljava/lang/Object;)V", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SizeTooLargeException extends InvalidSizeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SizeTooLargeException(Object size) {
            super(size);
            Intrinsics.checkNotNullParameter(size, "size");
        }
    }
}
