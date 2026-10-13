package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class PoolParams {
    public static final int IGNORE_THREADS = -1;

    @Nullable
    public final SparseIntArray bucketSizes;
    public boolean fixBucketsReinitialization;
    public final int maxBucketSize;
    public final int maxNumThreads;
    public final int minBucketSize;

    public PoolParams(@Nullable SparseIntArray sparseIntArray) {
        this(sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public PoolParams(@Nullable SparseIntArray sparseIntArray, int i, int i2, int i3) {
        this.bucketSizes = sparseIntArray;
        this.minBucketSize = i;
        this.maxBucketSize = i2;
        this.maxNumThreads = i3;
    }
}
