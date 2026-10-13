package com.datadog.android.core.internal.configuration;

import com.datadog.android.core.configuration.UploadFrequency;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataUploadConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0014J\u000e\u0010\u0015\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0016J\u001d\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/core/internal/configuration/DataUploadConfiguration;", "", "frequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "maxBatchesPerUploadJob", "", "(Lcom/datadog/android/core/configuration/UploadFrequency;I)V", "defaultDelayMs", "", "getDefaultDelayMs$dd_sdk_android_core_release", "()J", "getFrequency$dd_sdk_android_core_release", "()Lcom/datadog/android/core/configuration/UploadFrequency;", "getMaxBatchesPerUploadJob$dd_sdk_android_core_release", "()I", "maxDelayMs", "getMaxDelayMs$dd_sdk_android_core_release", "minDelayMs", "getMinDelayMs$dd_sdk_android_core_release", "component1", "component1$dd_sdk_android_core_release", "component2", "component2$dd_sdk_android_core_release", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DataUploadConfiguration {
    public static final int DEFAULT_DELAY_FACTOR = 5;
    public static final int MAX_DELAY_FACTOR = 10;
    public static final int MIN_DELAY_FACTOR = 1;
    private final long defaultDelayMs;
    private final UploadFrequency frequency;
    private final int maxBatchesPerUploadJob;
    private final long maxDelayMs;
    private final long minDelayMs;

    public static /* synthetic */ DataUploadConfiguration copy$default(DataUploadConfiguration dataUploadConfiguration, UploadFrequency uploadFrequency, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uploadFrequency = dataUploadConfiguration.frequency;
        }
        if ((i2 & 2) != 0) {
            i = dataUploadConfiguration.maxBatchesPerUploadJob;
        }
        return dataUploadConfiguration.copy(uploadFrequency, i);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_core_release, reason: from getter */
    public final UploadFrequency getFrequency() {
        return this.frequency;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_core_release, reason: from getter */
    public final int getMaxBatchesPerUploadJob() {
        return this.maxBatchesPerUploadJob;
    }

    public final DataUploadConfiguration copy(UploadFrequency frequency, int maxBatchesPerUploadJob) {
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        return new DataUploadConfiguration(frequency, maxBatchesPerUploadJob);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataUploadConfiguration)) {
            return false;
        }
        DataUploadConfiguration dataUploadConfiguration = (DataUploadConfiguration) other;
        return this.frequency == dataUploadConfiguration.frequency && this.maxBatchesPerUploadJob == dataUploadConfiguration.maxBatchesPerUploadJob;
    }

    public int hashCode() {
        return (this.frequency.hashCode() * 31) + Integer.hashCode(this.maxBatchesPerUploadJob);
    }

    public String toString() {
        return "DataUploadConfiguration(frequency=" + this.frequency + ", maxBatchesPerUploadJob=" + this.maxBatchesPerUploadJob + ")";
    }

    public DataUploadConfiguration(UploadFrequency frequency, int i) {
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        this.frequency = frequency;
        this.maxBatchesPerUploadJob = i;
        this.minDelayMs = frequency.getBaseStepMs();
        this.maxDelayMs = 10 * frequency.getBaseStepMs();
        this.defaultDelayMs = 5 * frequency.getBaseStepMs();
    }

    public final UploadFrequency getFrequency$dd_sdk_android_core_release() {
        return this.frequency;
    }

    public final int getMaxBatchesPerUploadJob$dd_sdk_android_core_release() {
        return this.maxBatchesPerUploadJob;
    }

    /* JADX INFO: renamed from: getMinDelayMs$dd_sdk_android_core_release, reason: from getter */
    public final long getMinDelayMs() {
        return this.minDelayMs;
    }

    /* JADX INFO: renamed from: getMaxDelayMs$dd_sdk_android_core_release, reason: from getter */
    public final long getMaxDelayMs() {
        return this.maxDelayMs;
    }

    /* JADX INFO: renamed from: getDefaultDelayMs$dd_sdk_android_core_release, reason: from getter */
    public final long getDefaultDelayMs() {
        return this.defaultDelayMs;
    }
}
