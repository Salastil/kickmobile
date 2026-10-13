package com.datadog.android.rum.configuration;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SlowFramesConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0014J\u000e\u0010\u0015\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u001aJ;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006#"}, d2 = {"Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "", "maxSlowFramesAmount", "", "maxSlowFrameThresholdNs", "", "continuousSlowFrameThresholdNs", "freezeDurationThresholdNs", "minViewLifetimeThresholdNs", "(IJJJJ)V", "getContinuousSlowFrameThresholdNs$dd_sdk_android_rum_release", "()J", "getFreezeDurationThresholdNs$dd_sdk_android_rum_release", "getMaxSlowFrameThresholdNs$dd_sdk_android_rum_release", "getMaxSlowFramesAmount$dd_sdk_android_rum_release", "()I", "getMinViewLifetimeThresholdNs$dd_sdk_android_rum_release", "component1", "component1$dd_sdk_android_rum_release", "component2", "component2$dd_sdk_android_rum_release", "component3", "component3$dd_sdk_android_rum_release", "component4", "component4$dd_sdk_android_rum_release", "component5", "component5$dd_sdk_android_rum_release", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SlowFramesConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SlowFramesConfiguration DEFAULT = new SlowFramesConfiguration(0, 0, 0, 0, 0, 31, null);
    private static final long DEFAULT_CONTINUOUS_SLOW_FRAME_THRESHOLD_NS = 16666666;
    private static final long DEFAULT_FREEZE_DURATION_NS = 5000000000L;
    private static final long DEFAULT_FROZEN_FRAME_THRESHOLD_NS = 700000000;
    private static final int DEFAULT_SLOW_FRAME_RECORDS_MAX_AMOUNT = 1000;
    private static final long DEFAULT_VIEW_LIFETIME_THRESHOLD_NS = 1000000000;
    private final long continuousSlowFrameThresholdNs;
    private final long freezeDurationThresholdNs;
    private final long maxSlowFrameThresholdNs;
    private final int maxSlowFramesAmount;
    private final long minViewLifetimeThresholdNs;

    public SlowFramesConfiguration() {
        this(0, 0L, 0L, 0L, 0L, 31, null);
    }

    public static /* synthetic */ SlowFramesConfiguration copy$default(SlowFramesConfiguration slowFramesConfiguration, int i, long j, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slowFramesConfiguration.maxSlowFramesAmount;
        }
        if ((i2 & 2) != 0) {
            j = slowFramesConfiguration.maxSlowFrameThresholdNs;
        }
        if ((i2 & 4) != 0) {
            j2 = slowFramesConfiguration.continuousSlowFrameThresholdNs;
        }
        if ((i2 & 8) != 0) {
            j3 = slowFramesConfiguration.freezeDurationThresholdNs;
        }
        if ((i2 & 16) != 0) {
            j4 = slowFramesConfiguration.minViewLifetimeThresholdNs;
        }
        long j5 = j4;
        long j6 = j3;
        return slowFramesConfiguration.copy(i, j, j2, j6, j5);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_rum_release, reason: from getter */
    public final int getMaxSlowFramesAmount() {
        return this.maxSlowFramesAmount;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_rum_release, reason: from getter */
    public final long getMaxSlowFrameThresholdNs() {
        return this.maxSlowFrameThresholdNs;
    }

    /* JADX INFO: renamed from: component3$dd_sdk_android_rum_release, reason: from getter */
    public final long getContinuousSlowFrameThresholdNs() {
        return this.continuousSlowFrameThresholdNs;
    }

    /* JADX INFO: renamed from: component4$dd_sdk_android_rum_release, reason: from getter */
    public final long getFreezeDurationThresholdNs() {
        return this.freezeDurationThresholdNs;
    }

    /* JADX INFO: renamed from: component5$dd_sdk_android_rum_release, reason: from getter */
    public final long getMinViewLifetimeThresholdNs() {
        return this.minViewLifetimeThresholdNs;
    }

    public final SlowFramesConfiguration copy(int maxSlowFramesAmount, long maxSlowFrameThresholdNs, long continuousSlowFrameThresholdNs, long freezeDurationThresholdNs, long minViewLifetimeThresholdNs) {
        return new SlowFramesConfiguration(maxSlowFramesAmount, maxSlowFrameThresholdNs, continuousSlowFrameThresholdNs, freezeDurationThresholdNs, minViewLifetimeThresholdNs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlowFramesConfiguration)) {
            return false;
        }
        SlowFramesConfiguration slowFramesConfiguration = (SlowFramesConfiguration) other;
        return this.maxSlowFramesAmount == slowFramesConfiguration.maxSlowFramesAmount && this.maxSlowFrameThresholdNs == slowFramesConfiguration.maxSlowFrameThresholdNs && this.continuousSlowFrameThresholdNs == slowFramesConfiguration.continuousSlowFrameThresholdNs && this.freezeDurationThresholdNs == slowFramesConfiguration.freezeDurationThresholdNs && this.minViewLifetimeThresholdNs == slowFramesConfiguration.minViewLifetimeThresholdNs;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.maxSlowFramesAmount) * 31) + Long.hashCode(this.maxSlowFrameThresholdNs)) * 31) + Long.hashCode(this.continuousSlowFrameThresholdNs)) * 31) + Long.hashCode(this.freezeDurationThresholdNs)) * 31) + Long.hashCode(this.minViewLifetimeThresholdNs);
    }

    public String toString() {
        return "SlowFramesConfiguration(maxSlowFramesAmount=" + this.maxSlowFramesAmount + ", maxSlowFrameThresholdNs=" + this.maxSlowFrameThresholdNs + ", continuousSlowFrameThresholdNs=" + this.continuousSlowFrameThresholdNs + ", freezeDurationThresholdNs=" + this.freezeDurationThresholdNs + ", minViewLifetimeThresholdNs=" + this.minViewLifetimeThresholdNs + ")";
    }

    public SlowFramesConfiguration(int i, long j, long j2, long j3, long j4) {
        this.maxSlowFramesAmount = i;
        this.maxSlowFrameThresholdNs = j;
        this.continuousSlowFrameThresholdNs = j2;
        this.freezeDurationThresholdNs = j3;
        this.minViewLifetimeThresholdNs = j4;
    }

    public /* synthetic */ SlowFramesConfiguration(int i, long j, long j2, long j3, long j4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1000 : i, (i2 & 2) != 0 ? DEFAULT_FROZEN_FRAME_THRESHOLD_NS : j, (i2 & 4) != 0 ? DEFAULT_CONTINUOUS_SLOW_FRAME_THRESHOLD_NS : j2, (i2 & 8) != 0 ? DEFAULT_FREEZE_DURATION_NS : j3, (i2 & 16) != 0 ? 1000000000L : j4);
    }

    public final int getMaxSlowFramesAmount$dd_sdk_android_rum_release() {
        return this.maxSlowFramesAmount;
    }

    public final long getMaxSlowFrameThresholdNs$dd_sdk_android_rum_release() {
        return this.maxSlowFrameThresholdNs;
    }

    public final long getContinuousSlowFrameThresholdNs$dd_sdk_android_rum_release() {
        return this.continuousSlowFrameThresholdNs;
    }

    public final long getFreezeDurationThresholdNs$dd_sdk_android_rum_release() {
        return this.freezeDurationThresholdNs;
    }

    public final long getMinViewLifetimeThresholdNs$dd_sdk_android_rum_release() {
        return this.minViewLifetimeThresholdNs;
    }

    /* JADX INFO: compiled from: SlowFramesConfiguration.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/configuration/SlowFramesConfiguration$Companion;", "", "()V", "DEFAULT", "Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "getDEFAULT", "()Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "DEFAULT_CONTINUOUS_SLOW_FRAME_THRESHOLD_NS", "", "DEFAULT_FREEZE_DURATION_NS", "DEFAULT_FROZEN_FRAME_THRESHOLD_NS", "DEFAULT_SLOW_FRAME_RECORDS_MAX_AMOUNT", "", "DEFAULT_VIEW_LIFETIME_THRESHOLD_NS", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SlowFramesConfiguration getDEFAULT() {
            return SlowFramesConfiguration.DEFAULT;
        }
    }
}
