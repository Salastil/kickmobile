package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import io.ktor.http.ContentDisposition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlexByteArrayPool.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140\u00198F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;", "", "memoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "params", "Lcom/facebook/imagepipeline/memory/PoolParams;", "<init>", "(Lcom/facebook/common/memory/MemoryTrimmableRegistry;Lcom/facebook/imagepipeline/memory/PoolParams;)V", "resourceReleaser", "Lcom/facebook/common/references/ResourceReleaser;", "", "delegatePool", "Lcom/facebook/imagepipeline/memory/FlexByteArrayPool$SoftRefByteArrayPool;", "getDelegatePool$annotations", "()V", "getDelegatePool", "()Lcom/facebook/imagepipeline/memory/FlexByteArrayPool$SoftRefByteArrayPool;", "get", "Lcom/facebook/common/references/CloseableReference;", ContentDisposition.Parameters.Size, "", "release", "", "value", "stats", "", "", "getStats", "()Ljava/util/Map;", "minBufferSize", "getMinBufferSize", "()I", "SoftRefByteArrayPool", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FlexByteArrayPool {
    private final SoftRefByteArrayPool delegatePool;
    private final ResourceReleaser<byte[]> resourceReleaser;

    public static /* synthetic */ void getDelegatePool$annotations() {
    }

    public FlexByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Preconditions.checkArgument(Boolean.valueOf(params.maxNumThreads > 0));
        this.delegatePool = new SoftRefByteArrayPool(memoryTrimmableRegistry, params, NoOpPoolStatsTracker.getInstance());
        this.resourceReleaser = new ResourceReleaser() { // from class: com.facebook.imagepipeline.memory.FlexByteArrayPool$$ExternalSyntheticLambda0
            @Override // com.facebook.common.references.ResourceReleaser
            public final void release(Object obj) {
                FlexByteArrayPool._init_$lambda$0(this.f$0, (byte[]) obj);
            }
        };
    }

    public final SoftRefByteArrayPool getDelegatePool() {
        return this.delegatePool;
    }

    static final void _init_$lambda$0(FlexByteArrayPool flexByteArrayPool, byte[] unused) {
        Intrinsics.checkNotNullParameter(unused, "unused");
        flexByteArrayPool.release(unused);
    }

    public final CloseableReference<byte[]> get(int size) {
        CloseableReference<byte[]> closeableReferenceOf = CloseableReference.of(this.delegatePool.get(size), this.resourceReleaser);
        Intrinsics.checkNotNullExpressionValue(closeableReferenceOf, "of(...)");
        return closeableReferenceOf;
    }

    public final void release(byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.delegatePool.release(value);
    }

    public final Map<String, Integer> getStats() {
        return this.delegatePool.getStats();
    }

    public final int getMinBufferSize() {
        return this.delegatePool.getMinBufferSize();
    }

    /* JADX INFO: compiled from: FlexByteArrayPool.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/memory/FlexByteArrayPool$SoftRefByteArrayPool;", "Lcom/facebook/imagepipeline/memory/GenericByteArrayPool;", "memoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "poolParams", "Lcom/facebook/imagepipeline/memory/PoolParams;", "poolStatsTracker", "Lcom/facebook/imagepipeline/memory/PoolStatsTracker;", "<init>", "(Lcom/facebook/common/memory/MemoryTrimmableRegistry;Lcom/facebook/imagepipeline/memory/PoolParams;Lcom/facebook/imagepipeline/memory/PoolStatsTracker;)V", "newBucket", "Lcom/facebook/imagepipeline/memory/Bucket;", "", "bucketedSize", "", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SoftRefByteArrayPool extends GenericByteArrayPool {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SoftRefByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
            super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
            Intrinsics.checkNotNull(memoryTrimmableRegistry);
            Intrinsics.checkNotNull(poolParams);
            Intrinsics.checkNotNull(poolStatsTracker);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        public Bucket<byte[]> newBucket(int bucketedSize) {
            return new OOMSoftReferenceBucket(getSizeInBytes(bucketedSize), this.poolParams.maxNumThreads, 0);
        }
    }
}
