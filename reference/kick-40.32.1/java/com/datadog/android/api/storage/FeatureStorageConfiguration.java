package com.datadog.android.api.storage;

import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FeatureStorageConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "", "maxItemSize", "", "maxItemsPerBatch", "", "maxBatchSize", "oldBatchThreshold", "(JIJJ)V", "getMaxBatchSize", "()J", "getMaxItemSize", "getMaxItemsPerBatch", "()I", "getOldBatchThreshold", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FeatureStorageConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FeatureStorageConfiguration DEFAULT = new FeatureStorageConfiguration(1048576, 1000, FilePersistenceConfig.MAX_BATCH_SIZE, FilePersistenceConfig.OLD_FILE_THRESHOLD);
    private final long maxBatchSize;
    private final long maxItemSize;
    private final int maxItemsPerBatch;
    private final long oldBatchThreshold;

    public static /* synthetic */ FeatureStorageConfiguration copy$default(FeatureStorageConfiguration featureStorageConfiguration, long j, int i, long j2, long j3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = featureStorageConfiguration.maxItemSize;
        }
        long j4 = j;
        if ((i2 & 2) != 0) {
            i = featureStorageConfiguration.maxItemsPerBatch;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            j2 = featureStorageConfiguration.maxBatchSize;
        }
        long j5 = j2;
        if ((i2 & 8) != 0) {
            j3 = featureStorageConfiguration.oldBatchThreshold;
        }
        return featureStorageConfiguration.copy(j4, i3, j5, j3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMaxItemSize() {
        return this.maxItemSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxItemsPerBatch() {
        return this.maxItemsPerBatch;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMaxBatchSize() {
        return this.maxBatchSize;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getOldBatchThreshold() {
        return this.oldBatchThreshold;
    }

    public final FeatureStorageConfiguration copy(long maxItemSize, int maxItemsPerBatch, long maxBatchSize, long oldBatchThreshold) {
        return new FeatureStorageConfiguration(maxItemSize, maxItemsPerBatch, maxBatchSize, oldBatchThreshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeatureStorageConfiguration)) {
            return false;
        }
        FeatureStorageConfiguration featureStorageConfiguration = (FeatureStorageConfiguration) other;
        return this.maxItemSize == featureStorageConfiguration.maxItemSize && this.maxItemsPerBatch == featureStorageConfiguration.maxItemsPerBatch && this.maxBatchSize == featureStorageConfiguration.maxBatchSize && this.oldBatchThreshold == featureStorageConfiguration.oldBatchThreshold;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.maxItemSize) * 31) + Integer.hashCode(this.maxItemsPerBatch)) * 31) + Long.hashCode(this.maxBatchSize)) * 31) + Long.hashCode(this.oldBatchThreshold);
    }

    public String toString() {
        return "FeatureStorageConfiguration(maxItemSize=" + this.maxItemSize + ", maxItemsPerBatch=" + this.maxItemsPerBatch + ", maxBatchSize=" + this.maxBatchSize + ", oldBatchThreshold=" + this.oldBatchThreshold + ")";
    }

    public FeatureStorageConfiguration(long j, int i, long j2, long j3) {
        this.maxItemSize = j;
        this.maxItemsPerBatch = i;
        this.maxBatchSize = j2;
        this.oldBatchThreshold = j3;
    }

    public final long getMaxItemSize() {
        return this.maxItemSize;
    }

    public final int getMaxItemsPerBatch() {
        return this.maxItemsPerBatch;
    }

    public final long getMaxBatchSize() {
        return this.maxBatchSize;
    }

    public final long getOldBatchThreshold() {
        return this.oldBatchThreshold;
    }

    /* JADX INFO: compiled from: FeatureStorageConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/api/storage/FeatureStorageConfiguration$Companion;", "", "()V", "DEFAULT", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "getDEFAULT", "()Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FeatureStorageConfiguration getDEFAULT() {
            return FeatureStorageConfiguration.DEFAULT;
        }
    }
}
