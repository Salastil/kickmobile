package com.datadog.reactnative;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.trace.TracingHeaderType;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u001d\u0010;\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u0011HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÞ\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010AJ\u0014\u0010B\u001a\u00020\u00052\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010D\u001a\u00020EHÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b%\u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b&\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b(\u0010\u001dR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b)\u0010\u001dR%\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b,\u0010\u001dR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010 R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001b¨\u0006G"}, d2 = {"Lcom/datadog/reactnative/RumConfiguration;", "", "applicationId", "", "trackFrustrations", "", "longTaskThresholdMs", "", RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, "resourceTraceSampleRate", "vitalsUpdateFrequency", "trackBackgroundEvents", "nativeCrashReportEnabled", "nativeLongTaskThresholdMs", "nativeViewTracking", "nativeInteractionTracking", "firstPartyHosts", "", "", "Lcom/datadog/android/trace/TracingHeaderType;", "trackNonFatalAnrs", "initialResourceThreshold", "telemetrySampleRate", "customEndpoint", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getApplicationId", "()Ljava/lang/String;", "getTrackFrustrations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLongTaskThresholdMs", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSessionSampleRate", "getResourceTraceSampleRate", "getVitalsUpdateFrequency", "getTrackBackgroundEvents", "getNativeCrashReportEnabled", "getNativeLongTaskThresholdMs", "getNativeViewTracking", "getNativeInteractionTracking", "getFirstPartyHosts", "()Ljava/util/Map;", "getTrackNonFatalAnrs", "getInitialResourceThreshold", "getTelemetrySampleRate", "getCustomEndpoint", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/datadog/reactnative/RumConfiguration;", "equals", "other", "hashCode", "", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class RumConfiguration {
    private final String applicationId;
    private final String customEndpoint;
    private final Map<String, Set<TracingHeaderType>> firstPartyHosts;
    private final Double initialResourceThreshold;
    private final Double longTaskThresholdMs;
    private final Boolean nativeCrashReportEnabled;
    private final Boolean nativeInteractionTracking;
    private final Double nativeLongTaskThresholdMs;
    private final Boolean nativeViewTracking;
    private final Double resourceTraceSampleRate;
    private final Double sessionSampleRate;
    private final Double telemetrySampleRate;
    private final Boolean trackBackgroundEvents;
    private final Boolean trackFrustrations;
    private final Boolean trackNonFatalAnrs;
    private final String vitalsUpdateFrequency;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RumConfiguration copy$default(RumConfiguration rumConfiguration, String str, Boolean bool, Double d, Double d2, Double d3, String str2, Boolean bool2, Boolean bool3, Double d4, Boolean bool4, Boolean bool5, Map map, Boolean bool6, Double d5, Double d6, String str3, int i, Object obj) {
        String str4 = (i & 1) != 0 ? rumConfiguration.applicationId : str;
        return rumConfiguration.copy(str4, (i & 2) != 0 ? rumConfiguration.trackFrustrations : bool, (i & 4) != 0 ? rumConfiguration.longTaskThresholdMs : d, (i & 8) != 0 ? rumConfiguration.sessionSampleRate : d2, (i & 16) != 0 ? rumConfiguration.resourceTraceSampleRate : d3, (i & 32) != 0 ? rumConfiguration.vitalsUpdateFrequency : str2, (i & 64) != 0 ? rumConfiguration.trackBackgroundEvents : bool2, (i & 128) != 0 ? rumConfiguration.nativeCrashReportEnabled : bool3, (i & 256) != 0 ? rumConfiguration.nativeLongTaskThresholdMs : d4, (i & 512) != 0 ? rumConfiguration.nativeViewTracking : bool4, (i & 1024) != 0 ? rumConfiguration.nativeInteractionTracking : bool5, (i & 2048) != 0 ? rumConfiguration.firstPartyHosts : map, (i & 4096) != 0 ? rumConfiguration.trackNonFatalAnrs : bool6, (i & 8192) != 0 ? rumConfiguration.initialResourceThreshold : d5, (i & 16384) != 0 ? rumConfiguration.telemetrySampleRate : d6, (i & 32768) != 0 ? rumConfiguration.customEndpoint : str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getNativeViewTracking() {
        return this.nativeViewTracking;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getNativeInteractionTracking() {
        return this.nativeInteractionTracking;
    }

    public final Map<String, Set<TracingHeaderType>> component12() {
        return this.firstPartyHosts;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getTrackNonFatalAnrs() {
        return this.trackNonFatalAnrs;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Double getInitialResourceThreshold() {
        return this.initialResourceThreshold;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Double getTelemetrySampleRate() {
        return this.telemetrySampleRate;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getTrackFrustrations() {
        return this.trackFrustrations;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getLongTaskThresholdMs() {
        return this.longTaskThresholdMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getSessionSampleRate() {
        return this.sessionSampleRate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getResourceTraceSampleRate() {
        return this.resourceTraceSampleRate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getVitalsUpdateFrequency() {
        return this.vitalsUpdateFrequency;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getTrackBackgroundEvents() {
        return this.trackBackgroundEvents;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getNativeCrashReportEnabled() {
        return this.nativeCrashReportEnabled;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Double getNativeLongTaskThresholdMs() {
        return this.nativeLongTaskThresholdMs;
    }

    public final RumConfiguration copy(String applicationId, Boolean trackFrustrations, Double longTaskThresholdMs, Double sessionSampleRate, Double resourceTraceSampleRate, String vitalsUpdateFrequency, Boolean trackBackgroundEvents, Boolean nativeCrashReportEnabled, Double nativeLongTaskThresholdMs, Boolean nativeViewTracking, Boolean nativeInteractionTracking, Map<String, ? extends Set<? extends TracingHeaderType>> firstPartyHosts, Boolean trackNonFatalAnrs, Double initialResourceThreshold, Double telemetrySampleRate, String customEndpoint) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        return new RumConfiguration(applicationId, trackFrustrations, longTaskThresholdMs, sessionSampleRate, resourceTraceSampleRate, vitalsUpdateFrequency, trackBackgroundEvents, nativeCrashReportEnabled, nativeLongTaskThresholdMs, nativeViewTracking, nativeInteractionTracking, firstPartyHosts, trackNonFatalAnrs, initialResourceThreshold, telemetrySampleRate, customEndpoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RumConfiguration)) {
            return false;
        }
        RumConfiguration rumConfiguration = (RumConfiguration) other;
        return Intrinsics.areEqual(this.applicationId, rumConfiguration.applicationId) && Intrinsics.areEqual(this.trackFrustrations, rumConfiguration.trackFrustrations) && Intrinsics.areEqual((Object) this.longTaskThresholdMs, (Object) rumConfiguration.longTaskThresholdMs) && Intrinsics.areEqual((Object) this.sessionSampleRate, (Object) rumConfiguration.sessionSampleRate) && Intrinsics.areEqual((Object) this.resourceTraceSampleRate, (Object) rumConfiguration.resourceTraceSampleRate) && Intrinsics.areEqual(this.vitalsUpdateFrequency, rumConfiguration.vitalsUpdateFrequency) && Intrinsics.areEqual(this.trackBackgroundEvents, rumConfiguration.trackBackgroundEvents) && Intrinsics.areEqual(this.nativeCrashReportEnabled, rumConfiguration.nativeCrashReportEnabled) && Intrinsics.areEqual((Object) this.nativeLongTaskThresholdMs, (Object) rumConfiguration.nativeLongTaskThresholdMs) && Intrinsics.areEqual(this.nativeViewTracking, rumConfiguration.nativeViewTracking) && Intrinsics.areEqual(this.nativeInteractionTracking, rumConfiguration.nativeInteractionTracking) && Intrinsics.areEqual(this.firstPartyHosts, rumConfiguration.firstPartyHosts) && Intrinsics.areEqual(this.trackNonFatalAnrs, rumConfiguration.trackNonFatalAnrs) && Intrinsics.areEqual((Object) this.initialResourceThreshold, (Object) rumConfiguration.initialResourceThreshold) && Intrinsics.areEqual((Object) this.telemetrySampleRate, (Object) rumConfiguration.telemetrySampleRate) && Intrinsics.areEqual(this.customEndpoint, rumConfiguration.customEndpoint);
    }

    public int hashCode() {
        int iHashCode = this.applicationId.hashCode() * 31;
        Boolean bool = this.trackFrustrations;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Double d = this.longTaskThresholdMs;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.sessionSampleRate;
        int iHashCode4 = (iHashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.resourceTraceSampleRate;
        int iHashCode5 = (iHashCode4 + (d3 == null ? 0 : d3.hashCode())) * 31;
        String str = this.vitalsUpdateFrequency;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool2 = this.trackBackgroundEvents;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.nativeCrashReportEnabled;
        int iHashCode8 = (iHashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Double d4 = this.nativeLongTaskThresholdMs;
        int iHashCode9 = (iHashCode8 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Boolean bool4 = this.nativeViewTracking;
        int iHashCode10 = (iHashCode9 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.nativeInteractionTracking;
        int iHashCode11 = (iHashCode10 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Map<String, Set<TracingHeaderType>> map = this.firstPartyHosts;
        int iHashCode12 = (iHashCode11 + (map == null ? 0 : map.hashCode())) * 31;
        Boolean bool6 = this.trackNonFatalAnrs;
        int iHashCode13 = (iHashCode12 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Double d5 = this.initialResourceThreshold;
        int iHashCode14 = (iHashCode13 + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.telemetrySampleRate;
        int iHashCode15 = (iHashCode14 + (d6 == null ? 0 : d6.hashCode())) * 31;
        String str2 = this.customEndpoint;
        return iHashCode15 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RumConfiguration(applicationId=" + this.applicationId + ", trackFrustrations=" + this.trackFrustrations + ", longTaskThresholdMs=" + this.longTaskThresholdMs + ", sessionSampleRate=" + this.sessionSampleRate + ", resourceTraceSampleRate=" + this.resourceTraceSampleRate + ", vitalsUpdateFrequency=" + this.vitalsUpdateFrequency + ", trackBackgroundEvents=" + this.trackBackgroundEvents + ", nativeCrashReportEnabled=" + this.nativeCrashReportEnabled + ", nativeLongTaskThresholdMs=" + this.nativeLongTaskThresholdMs + ", nativeViewTracking=" + this.nativeViewTracking + ", nativeInteractionTracking=" + this.nativeInteractionTracking + ", firstPartyHosts=" + this.firstPartyHosts + ", trackNonFatalAnrs=" + this.trackNonFatalAnrs + ", initialResourceThreshold=" + this.initialResourceThreshold + ", telemetrySampleRate=" + this.telemetrySampleRate + ", customEndpoint=" + this.customEndpoint + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RumConfiguration(String applicationId, Boolean bool, Double d, Double d2, Double d3, String str, Boolean bool2, Boolean bool3, Double d4, Boolean bool4, Boolean bool5, Map<String, ? extends Set<? extends TracingHeaderType>> map, Boolean bool6, Double d5, Double d6, String str2) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        this.applicationId = applicationId;
        this.trackFrustrations = bool;
        this.longTaskThresholdMs = d;
        this.sessionSampleRate = d2;
        this.resourceTraceSampleRate = d3;
        this.vitalsUpdateFrequency = str;
        this.trackBackgroundEvents = bool2;
        this.nativeCrashReportEnabled = bool3;
        this.nativeLongTaskThresholdMs = d4;
        this.nativeViewTracking = bool4;
        this.nativeInteractionTracking = bool5;
        this.firstPartyHosts = map;
        this.trackNonFatalAnrs = bool6;
        this.initialResourceThreshold = d5;
        this.telemetrySampleRate = d6;
        this.customEndpoint = str2;
    }

    public /* synthetic */ RumConfiguration(String str, Boolean bool, Double d, Double d2, Double d3, String str2, Boolean bool2, Boolean bool3, Double d4, Boolean bool4, Boolean bool5, Map map, Boolean bool6, Double d5, Double d6, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : d2, (i & 16) != 0 ? null : d3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : bool2, (i & 128) != 0 ? null : bool3, (i & 256) != 0 ? null : d4, (i & 512) != 0 ? null : bool4, (i & 1024) != 0 ? null : bool5, (i & 2048) != 0 ? null : map, (i & 4096) != 0 ? null : bool6, (i & 8192) != 0 ? null : d5, (i & 16384) != 0 ? null : d6, (i & 32768) != 0 ? null : str3);
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final Boolean getTrackFrustrations() {
        return this.trackFrustrations;
    }

    public final Double getLongTaskThresholdMs() {
        return this.longTaskThresholdMs;
    }

    public final Double getSessionSampleRate() {
        return this.sessionSampleRate;
    }

    public final Double getResourceTraceSampleRate() {
        return this.resourceTraceSampleRate;
    }

    public final String getVitalsUpdateFrequency() {
        return this.vitalsUpdateFrequency;
    }

    public final Boolean getTrackBackgroundEvents() {
        return this.trackBackgroundEvents;
    }

    public final Boolean getNativeCrashReportEnabled() {
        return this.nativeCrashReportEnabled;
    }

    public final Double getNativeLongTaskThresholdMs() {
        return this.nativeLongTaskThresholdMs;
    }

    public final Boolean getNativeViewTracking() {
        return this.nativeViewTracking;
    }

    public final Boolean getNativeInteractionTracking() {
        return this.nativeInteractionTracking;
    }

    public final Map<String, Set<TracingHeaderType>> getFirstPartyHosts() {
        return this.firstPartyHosts;
    }

    public final Boolean getTrackNonFatalAnrs() {
        return this.trackNonFatalAnrs;
    }

    public final Double getInitialResourceThreshold() {
        return this.initialResourceThreshold;
    }

    public final Double getTelemetrySampleRate() {
        return this.telemetrySampleRate;
    }

    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }
}
