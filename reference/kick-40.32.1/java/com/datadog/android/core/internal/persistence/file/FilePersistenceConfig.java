package com.datadog.android.core.internal.persistence.file;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FilePersistenceConfig.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 #2\u00020\u0001:\u0001#BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "", "recentDelayMs", "", "maxBatchSize", "maxItemSize", "maxItemsPerBatch", "", "oldFileThreshold", "maxDiskSpace", "cleanupFrequencyThreshold", "(JJJIJJJ)V", "getCleanupFrequencyThreshold", "()J", "getMaxBatchSize", "getMaxDiskSpace", "getMaxItemSize", "getMaxItemsPerBatch", "()I", "getOldFileThreshold", "getRecentDelayMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FilePersistenceConfig {
    public static final long CLEANUP_FREQUENCY_THRESHOLD_MS = 5000;
    public static final long MAX_BATCH_SIZE = 5242880;
    public static final long MAX_DELAY_BETWEEN_MESSAGES_MS = 5000;
    public static final long MAX_DISK_SPACE = 536870912;
    public static final int MAX_ITEMS_PER_BATCH = 1000;
    public static final long MAX_ITEM_SIZE = 1048576;
    public static final long OLD_FILE_THRESHOLD = 64800000;
    private final long cleanupFrequencyThreshold;
    private final long maxBatchSize;
    private final long maxDiskSpace;
    private final long maxItemSize;
    private final int maxItemsPerBatch;
    private final long oldFileThreshold;
    private final long recentDelayMs;

    public FilePersistenceConfig() {
        this(0L, 0L, 0L, 0, 0L, 0L, 0L, 127, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getRecentDelayMs() {
        return this.recentDelayMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMaxBatchSize() {
        return this.maxBatchSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMaxItemSize() {
        return this.maxItemSize;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMaxItemsPerBatch() {
        return this.maxItemsPerBatch;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getOldFileThreshold() {
        return this.oldFileThreshold;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getMaxDiskSpace() {
        return this.maxDiskSpace;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getCleanupFrequencyThreshold() {
        return this.cleanupFrequencyThreshold;
    }

    public final FilePersistenceConfig copy(long recentDelayMs, long maxBatchSize, long maxItemSize, int maxItemsPerBatch, long oldFileThreshold, long maxDiskSpace, long cleanupFrequencyThreshold) {
        return new FilePersistenceConfig(recentDelayMs, maxBatchSize, maxItemSize, maxItemsPerBatch, oldFileThreshold, maxDiskSpace, cleanupFrequencyThreshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilePersistenceConfig)) {
            return false;
        }
        FilePersistenceConfig filePersistenceConfig = (FilePersistenceConfig) other;
        return this.recentDelayMs == filePersistenceConfig.recentDelayMs && this.maxBatchSize == filePersistenceConfig.maxBatchSize && this.maxItemSize == filePersistenceConfig.maxItemSize && this.maxItemsPerBatch == filePersistenceConfig.maxItemsPerBatch && this.oldFileThreshold == filePersistenceConfig.oldFileThreshold && this.maxDiskSpace == filePersistenceConfig.maxDiskSpace && this.cleanupFrequencyThreshold == filePersistenceConfig.cleanupFrequencyThreshold;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.recentDelayMs) * 31) + Long.hashCode(this.maxBatchSize)) * 31) + Long.hashCode(this.maxItemSize)) * 31) + Integer.hashCode(this.maxItemsPerBatch)) * 31) + Long.hashCode(this.oldFileThreshold)) * 31) + Long.hashCode(this.maxDiskSpace)) * 31) + Long.hashCode(this.cleanupFrequencyThreshold);
    }

    public String toString() {
        return "FilePersistenceConfig(recentDelayMs=" + this.recentDelayMs + ", maxBatchSize=" + this.maxBatchSize + ", maxItemSize=" + this.maxItemSize + ", maxItemsPerBatch=" + this.maxItemsPerBatch + ", oldFileThreshold=" + this.oldFileThreshold + ", maxDiskSpace=" + this.maxDiskSpace + ", cleanupFrequencyThreshold=" + this.cleanupFrequencyThreshold + ")";
    }

    public FilePersistenceConfig(long j, long j2, long j3, int i, long j4, long j5, long j6) {
        this.recentDelayMs = j;
        this.maxBatchSize = j2;
        this.maxItemSize = j3;
        this.maxItemsPerBatch = i;
        this.oldFileThreshold = j4;
        this.maxDiskSpace = j5;
        this.cleanupFrequencyThreshold = j6;
    }

    public /* synthetic */ FilePersistenceConfig(long j, long j2, long j3, int i, long j4, long j5, long j6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 5000L : j, (i2 & 2) != 0 ? MAX_BATCH_SIZE : j2, (i2 & 4) != 0 ? 1048576L : j3, (i2 & 8) != 0 ? 1000 : i, (i2 & 16) != 0 ? OLD_FILE_THRESHOLD : j4, (i2 & 32) != 0 ? MAX_DISK_SPACE : j5, (i2 & 64) != 0 ? 5000L : j6);
    }

    public final long getRecentDelayMs() {
        return this.recentDelayMs;
    }

    public final long getMaxBatchSize() {
        return this.maxBatchSize;
    }

    public final long getMaxItemSize() {
        return this.maxItemSize;
    }

    public final int getMaxItemsPerBatch() {
        return this.maxItemsPerBatch;
    }

    public final long getOldFileThreshold() {
        return this.oldFileThreshold;
    }

    public final long getMaxDiskSpace() {
        return this.maxDiskSpace;
    }

    public final long getCleanupFrequencyThreshold() {
        return this.cleanupFrequencyThreshold;
    }
}
