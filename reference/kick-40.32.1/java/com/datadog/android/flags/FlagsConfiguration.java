package com.datadog.android.flags;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FlagsConfiguration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 02\u00020\u0001:\u0002/0BM\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u000e\u0010\u0019\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001aJ\u000e\u0010\u001b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b\"J\u000e\u0010#\u001a\u00020\nHÀ\u0003¢\u0006\u0002\b$J\u000e\u0010%\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b&J\u000e\u0010'\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b(J_\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\f\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u00061"}, d2 = {"Lcom/datadog/android/flags/FlagsConfiguration;", "", "trackExposures", "", "trackEvaluations", "customExposureEndpoint", "", "customEvaluationEndpoint", "customFlagEndpoint", "evaluationFlushIntervalMs", "", "rumIntegrationEnabled", "gracefulModeEnabled", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZ)V", "getCustomEvaluationEndpoint$dd_sdk_android_flags_release", "()Ljava/lang/String;", "getCustomExposureEndpoint$dd_sdk_android_flags_release", "getCustomFlagEndpoint$dd_sdk_android_flags_release", "getEvaluationFlushIntervalMs$dd_sdk_android_flags_release", "()J", "getGracefulModeEnabled$dd_sdk_android_flags_release", "()Z", "getRumIntegrationEnabled$dd_sdk_android_flags_release", "getTrackEvaluations$dd_sdk_android_flags_release", "getTrackExposures$dd_sdk_android_flags_release", "component1", "component1$dd_sdk_android_flags_release", "component2", "component2$dd_sdk_android_flags_release", "component3", "component3$dd_sdk_android_flags_release", "component4", "component4$dd_sdk_android_flags_release", "component5", "component5$dd_sdk_android_flags_release", "component6", "component6$dd_sdk_android_flags_release", "component7", "component7$dd_sdk_android_flags_release", "component8", "component8$dd_sdk_android_flags_release", "copy", "equals", "other", "hashCode", "", "toString", "Builder", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FlagsConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final FlagsConfiguration f40default = new Builder().build();
    private final String customEvaluationEndpoint;
    private final String customExposureEndpoint;
    private final String customFlagEndpoint;
    private final long evaluationFlushIntervalMs;
    private final boolean gracefulModeEnabled;
    private final boolean rumIntegrationEnabled;
    private final boolean trackEvaluations;
    private final boolean trackExposures;

    public static /* synthetic */ FlagsConfiguration copy$default(FlagsConfiguration flagsConfiguration, boolean z, boolean z2, String str, String str2, String str3, long j, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = flagsConfiguration.trackExposures;
        }
        if ((i & 2) != 0) {
            z2 = flagsConfiguration.trackEvaluations;
        }
        if ((i & 4) != 0) {
            str = flagsConfiguration.customExposureEndpoint;
        }
        if ((i & 8) != 0) {
            str2 = flagsConfiguration.customEvaluationEndpoint;
        }
        if ((i & 16) != 0) {
            str3 = flagsConfiguration.customFlagEndpoint;
        }
        if ((i & 32) != 0) {
            j = flagsConfiguration.evaluationFlushIntervalMs;
        }
        if ((i & 64) != 0) {
            z3 = flagsConfiguration.rumIntegrationEnabled;
        }
        if ((i & 128) != 0) {
            z4 = flagsConfiguration.gracefulModeEnabled;
        }
        long j2 = j;
        String str4 = str2;
        String str5 = str3;
        String str6 = str;
        return flagsConfiguration.copy(z, z2, str6, str4, str5, j2, z3, z4);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_flags_release, reason: from getter */
    public final boolean getTrackExposures() {
        return this.trackExposures;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_flags_release, reason: from getter */
    public final boolean getTrackEvaluations() {
        return this.trackEvaluations;
    }

    /* JADX INFO: renamed from: component3$dd_sdk_android_flags_release, reason: from getter */
    public final String getCustomExposureEndpoint() {
        return this.customExposureEndpoint;
    }

    /* JADX INFO: renamed from: component4$dd_sdk_android_flags_release, reason: from getter */
    public final String getCustomEvaluationEndpoint() {
        return this.customEvaluationEndpoint;
    }

    /* JADX INFO: renamed from: component5$dd_sdk_android_flags_release, reason: from getter */
    public final String getCustomFlagEndpoint() {
        return this.customFlagEndpoint;
    }

    /* JADX INFO: renamed from: component6$dd_sdk_android_flags_release, reason: from getter */
    public final long getEvaluationFlushIntervalMs() {
        return this.evaluationFlushIntervalMs;
    }

    /* JADX INFO: renamed from: component7$dd_sdk_android_flags_release, reason: from getter */
    public final boolean getRumIntegrationEnabled() {
        return this.rumIntegrationEnabled;
    }

    /* JADX INFO: renamed from: component8$dd_sdk_android_flags_release, reason: from getter */
    public final boolean getGracefulModeEnabled() {
        return this.gracefulModeEnabled;
    }

    public final FlagsConfiguration copy(boolean trackExposures, boolean trackEvaluations, String customExposureEndpoint, String customEvaluationEndpoint, String customFlagEndpoint, long evaluationFlushIntervalMs, boolean rumIntegrationEnabled, boolean gracefulModeEnabled) {
        return new FlagsConfiguration(trackExposures, trackEvaluations, customExposureEndpoint, customEvaluationEndpoint, customFlagEndpoint, evaluationFlushIntervalMs, rumIntegrationEnabled, gracefulModeEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlagsConfiguration)) {
            return false;
        }
        FlagsConfiguration flagsConfiguration = (FlagsConfiguration) other;
        return this.trackExposures == flagsConfiguration.trackExposures && this.trackEvaluations == flagsConfiguration.trackEvaluations && Intrinsics.areEqual(this.customExposureEndpoint, flagsConfiguration.customExposureEndpoint) && Intrinsics.areEqual(this.customEvaluationEndpoint, flagsConfiguration.customEvaluationEndpoint) && Intrinsics.areEqual(this.customFlagEndpoint, flagsConfiguration.customFlagEndpoint) && this.evaluationFlushIntervalMs == flagsConfiguration.evaluationFlushIntervalMs && this.rumIntegrationEnabled == flagsConfiguration.rumIntegrationEnabled && this.gracefulModeEnabled == flagsConfiguration.gracefulModeEnabled;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.trackExposures) * 31) + Boolean.hashCode(this.trackEvaluations)) * 31;
        String str = this.customExposureEndpoint;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.customEvaluationEndpoint;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.customFlagEndpoint;
        return ((((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Long.hashCode(this.evaluationFlushIntervalMs)) * 31) + Boolean.hashCode(this.rumIntegrationEnabled)) * 31) + Boolean.hashCode(this.gracefulModeEnabled);
    }

    public String toString() {
        return "FlagsConfiguration(trackExposures=" + this.trackExposures + ", trackEvaluations=" + this.trackEvaluations + ", customExposureEndpoint=" + this.customExposureEndpoint + ", customEvaluationEndpoint=" + this.customEvaluationEndpoint + ", customFlagEndpoint=" + this.customFlagEndpoint + ", evaluationFlushIntervalMs=" + this.evaluationFlushIntervalMs + ", rumIntegrationEnabled=" + this.rumIntegrationEnabled + ", gracefulModeEnabled=" + this.gracefulModeEnabled + ")";
    }

    public FlagsConfiguration(boolean z, boolean z2, String str, String str2, String str3, long j, boolean z3, boolean z4) {
        this.trackExposures = z;
        this.trackEvaluations = z2;
        this.customExposureEndpoint = str;
        this.customEvaluationEndpoint = str2;
        this.customFlagEndpoint = str3;
        this.evaluationFlushIntervalMs = j;
        this.rumIntegrationEnabled = z3;
        this.gracefulModeEnabled = z4;
    }

    public final boolean getTrackExposures$dd_sdk_android_flags_release() {
        return this.trackExposures;
    }

    public final boolean getTrackEvaluations$dd_sdk_android_flags_release() {
        return this.trackEvaluations;
    }

    public final String getCustomExposureEndpoint$dd_sdk_android_flags_release() {
        return this.customExposureEndpoint;
    }

    public final String getCustomEvaluationEndpoint$dd_sdk_android_flags_release() {
        return this.customEvaluationEndpoint;
    }

    public final String getCustomFlagEndpoint$dd_sdk_android_flags_release() {
        return this.customFlagEndpoint;
    }

    public final long getEvaluationFlushIntervalMs$dd_sdk_android_flags_release() {
        return this.evaluationFlushIntervalMs;
    }

    public final boolean getRumIntegrationEnabled$dd_sdk_android_flags_release() {
        return this.rumIntegrationEnabled;
    }

    public final boolean getGracefulModeEnabled$dd_sdk_android_flags_release() {
        return this.gracefulModeEnabled;
    }

    /* JADX INFO: compiled from: FlagsConfiguration.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/flags/FlagsConfiguration$Builder;", "", "()V", "customEvaluationEndpoint", "", "customExposureEndpoint", "customFlagEndpoint", "evaluationFlushIntervalMs", "", "gracefulModeEnabled", "", "rumIntegrationEnabled", "trackEvaluations", "trackExposures", "build", "Lcom/datadog/android/flags/FlagsConfiguration;", "evaluationFlushInterval", "intervalMs", "enabled", "useCustomEvaluationEndpoint", "endpoint", "useCustomExposureEndpoint", "useCustomFlagEndpoint", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private static final long DEFAULT_EVALUATION_FLUSH_INTERVAL_MS = 10000;
        private static final long MAX_EVALUATION_FLUSH_INTERVAL_MS = 60000;
        private static final long MIN_EVALUATION_FLUSH_INTERVAL_MS = 1000;
        private String customEvaluationEndpoint;
        private String customExposureEndpoint;
        private String customFlagEndpoint;
        private boolean trackExposures = true;
        private boolean trackEvaluations = true;
        private long evaluationFlushIntervalMs = 10000;
        private boolean rumIntegrationEnabled = true;
        private boolean gracefulModeEnabled = true;

        public final Builder trackExposures(boolean enabled) {
            this.trackExposures = enabled;
            return this;
        }

        public final Builder trackEvaluations(boolean enabled) {
            this.trackEvaluations = enabled;
            return this;
        }

        public final Builder useCustomExposureEndpoint(String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.customExposureEndpoint = endpoint;
            return this;
        }

        public final Builder useCustomEvaluationEndpoint(String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.customEvaluationEndpoint = endpoint;
            return this;
        }

        public final Builder evaluationFlushInterval(long intervalMs) {
            this.evaluationFlushIntervalMs = RangesKt.coerceIn(intervalMs, 1000L, 60000L);
            return this;
        }

        public final Builder useCustomFlagEndpoint(String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.customFlagEndpoint = endpoint;
            return this;
        }

        public final Builder rumIntegrationEnabled(boolean enabled) {
            this.rumIntegrationEnabled = enabled;
            return this;
        }

        public final Builder gracefulModeEnabled(boolean enabled) {
            this.gracefulModeEnabled = enabled;
            return this;
        }

        public final FlagsConfiguration build() {
            return new FlagsConfiguration(this.trackExposures, this.trackEvaluations, this.customExposureEndpoint, this.customEvaluationEndpoint, this.customFlagEndpoint, this.evaluationFlushIntervalMs, this.rumIntegrationEnabled, this.gracefulModeEnabled);
        }
    }

    /* JADX INFO: compiled from: FlagsConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/flags/FlagsConfiguration$Companion;", "", "()V", Constants.COLLATION_DEFAULT, "Lcom/datadog/android/flags/FlagsConfiguration;", "getDefault$dd_sdk_android_flags_release", "()Lcom/datadog/android/flags/FlagsConfiguration;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FlagsConfiguration getDefault$dd_sdk_android_flags_release() {
            return FlagsConfiguration.f40default;
        }
    }
}
