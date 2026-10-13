package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BucketsBitmapPool.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B%\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0014¨\u0006\u001c"}, d2 = {"Lcom/facebook/imagepipeline/memory/BucketsBitmapPool;", "Lcom/facebook/imagepipeline/memory/BasePool;", "Landroid/graphics/Bitmap;", "Lcom/facebook/imagepipeline/memory/BitmapPool;", "memoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "poolParams", "Lcom/facebook/imagepipeline/memory/PoolParams;", "poolStatsTracker", "Lcom/facebook/imagepipeline/memory/PoolStatsTracker;", "<init>", "(Lcom/facebook/common/memory/MemoryTrimmableRegistry;Lcom/facebook/imagepipeline/memory/PoolParams;Lcom/facebook/imagepipeline/memory/PoolStatsTracker;)V", "alloc", ContentDisposition.Parameters.Size, "", "free", "", "value", "getBucketedSize", "requestSize", "getBucketedSizeForValue", "getSizeInBytes", "bucketedSize", "isReusable", "", "getValue", InstrumentationTags.BUCKET, "Lcom/facebook/imagepipeline/memory/Bucket;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSize(int requestSize) {
        return requestSize;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getSizeInBytes(int bucketedSize) {
        return bucketedSize;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BucketsBitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        Intrinsics.checkNotNull(memoryTrimmableRegistry);
        Intrinsics.checkNotNull(poolParams);
        Intrinsics.checkNotNull(poolStatsTracker);
        initialize();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: alloc */
    public Bitmap alloc2(int size) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) size) / 2.0d), Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public void free(Bitmap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (CloseableReference.shouldSkipBitmapRecycleForNoopRefs()) {
            return;
        }
        value.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSizeForValue(Bitmap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.getAllocationByteCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public boolean isReusable(Bitmap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Preconditions.checkNotNull(value);
        return !value.isRecycled() && value.isMutable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public Bitmap getValue(Bucket<Bitmap> bucket) {
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Bitmap bitmap = (Bitmap) super.getValue((Bucket) bucket);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }
}
