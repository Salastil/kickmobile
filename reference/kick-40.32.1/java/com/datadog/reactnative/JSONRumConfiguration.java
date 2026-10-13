package com.datadog.reactnative;

import androidx.core.view.ViewCompat;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\bM\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u00ad\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010G\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010H\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010J\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010M\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010N\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010U\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J´\u0002\u0010W\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010XJ\u0014\u0010Y\u001a\u00020\u00052\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010[\u001a\u00020\\HÖ\u0081\u0004J\n\u0010]\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b'\u0010$R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b(\u0010$R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b/\u0010-R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b0\u0010-R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b1\u0010$R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b2\u0010-R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b3\u0010$R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b4\u0010$R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b5\u0010-R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b6\u0010-R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b7\u0010$R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b8\u0010$R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b9\u0010$R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b:\u0010$R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\"R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b<\u0010$R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b=\u0010-R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"¨\u0006^"}, d2 = {"Lcom/datadog/reactnative/JSONRumConfiguration;", "", "applicationId", "", "useAccessibilityLabel", "", "trackInteractions", "trackResources", "trackErrors", "actionNameAttribute", "firstPartyHosts", "", "Lcom/datadog/reactnative/JSONFirstPartyHost;", "appHangThreshold", "", "initialResourceThreshold", "longTaskThresholdMs", "nativeCrashReportEnabled", "nativeLongTaskThresholdMs", "nativeViewTracking", "nativeInteractionTracking", RumSessionScope.RUM_SESSION_SAMPLE_RATE_BUS_MESSAGE_KEY, "resourceTraceSampleRate", "trackBackgroundEvents", "trackFrustrations", "trackNonFatalAnrs", "trackWatchdogTerminations", "vitalsUpdateFrequency", "trackMemoryWarnings", "telemetrySampleRate", "customEndpoint", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/String;)V", "getApplicationId", "()Ljava/lang/String;", "getUseAccessibilityLabel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrackInteractions", "getTrackResources", "getTrackErrors", "getActionNameAttribute", "getFirstPartyHosts", "()Ljava/util/List;", "getAppHangThreshold", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getInitialResourceThreshold", "getLongTaskThresholdMs", "getNativeCrashReportEnabled", "getNativeLongTaskThresholdMs", "getNativeViewTracking", "getNativeInteractionTracking", "getSessionSampleRate", "getResourceTraceSampleRate", "getTrackBackgroundEvents", "getTrackFrustrations", "getTrackNonFatalAnrs", "getTrackWatchdogTerminations", "getVitalsUpdateFrequency", "getTrackMemoryWarnings", "getTelemetrySampleRate", "getCustomEndpoint", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/String;)Lcom/datadog/reactnative/JSONRumConfiguration;", "equals", "other", "hashCode", "", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class JSONRumConfiguration {
    private final String actionNameAttribute;
    private final Double appHangThreshold;
    private final String applicationId;
    private final String customEndpoint;
    private final List<JSONFirstPartyHost> firstPartyHosts;
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
    private final Boolean trackErrors;
    private final Boolean trackFrustrations;
    private final Boolean trackInteractions;
    private final Boolean trackMemoryWarnings;
    private final Boolean trackNonFatalAnrs;
    private final Boolean trackResources;
    private final Boolean trackWatchdogTerminations;
    private final Boolean useAccessibilityLabel;
    private final String vitalsUpdateFrequency;

    public JSONRumConfiguration() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ViewCompat.MEASURED_SIZE_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONRumConfiguration copy$default(JSONRumConfiguration jSONRumConfiguration, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str2, List list, Double d, Double d2, Double d3, Boolean bool5, Double d4, Boolean bool6, Boolean bool7, Double d5, Double d6, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, String str3, Boolean bool12, Double d7, String str4, int i, Object obj) {
        String str5;
        Double d8;
        String str6 = (i & 1) != 0 ? jSONRumConfiguration.applicationId : str;
        Boolean bool13 = (i & 2) != 0 ? jSONRumConfiguration.useAccessibilityLabel : bool;
        Boolean bool14 = (i & 4) != 0 ? jSONRumConfiguration.trackInteractions : bool2;
        Boolean bool15 = (i & 8) != 0 ? jSONRumConfiguration.trackResources : bool3;
        Boolean bool16 = (i & 16) != 0 ? jSONRumConfiguration.trackErrors : bool4;
        String str7 = (i & 32) != 0 ? jSONRumConfiguration.actionNameAttribute : str2;
        List list2 = (i & 64) != 0 ? jSONRumConfiguration.firstPartyHosts : list;
        Double d9 = (i & 128) != 0 ? jSONRumConfiguration.appHangThreshold : d;
        Double d10 = (i & 256) != 0 ? jSONRumConfiguration.initialResourceThreshold : d2;
        Double d11 = (i & 512) != 0 ? jSONRumConfiguration.longTaskThresholdMs : d3;
        Boolean bool17 = (i & 1024) != 0 ? jSONRumConfiguration.nativeCrashReportEnabled : bool5;
        Double d12 = (i & 2048) != 0 ? jSONRumConfiguration.nativeLongTaskThresholdMs : d4;
        Boolean bool18 = (i & 4096) != 0 ? jSONRumConfiguration.nativeViewTracking : bool6;
        Boolean bool19 = (i & 8192) != 0 ? jSONRumConfiguration.nativeInteractionTracking : bool7;
        String str8 = str6;
        Double d13 = (i & 16384) != 0 ? jSONRumConfiguration.sessionSampleRate : d5;
        Double d14 = (i & 32768) != 0 ? jSONRumConfiguration.resourceTraceSampleRate : d6;
        Boolean bool20 = (i & 65536) != 0 ? jSONRumConfiguration.trackBackgroundEvents : bool8;
        Boolean bool21 = (i & 131072) != 0 ? jSONRumConfiguration.trackFrustrations : bool9;
        Boolean bool22 = (i & 262144) != 0 ? jSONRumConfiguration.trackNonFatalAnrs : bool10;
        Boolean bool23 = (i & 524288) != 0 ? jSONRumConfiguration.trackWatchdogTerminations : bool11;
        String str9 = (i & 1048576) != 0 ? jSONRumConfiguration.vitalsUpdateFrequency : str3;
        Boolean bool24 = (i & 2097152) != 0 ? jSONRumConfiguration.trackMemoryWarnings : bool12;
        Double d15 = (i & 4194304) != 0 ? jSONRumConfiguration.telemetrySampleRate : d7;
        if ((i & 8388608) != 0) {
            d8 = d15;
            str5 = jSONRumConfiguration.customEndpoint;
        } else {
            str5 = str4;
            d8 = d15;
        }
        return jSONRumConfiguration.copy(str8, bool13, bool14, bool15, bool16, str7, list2, d9, d10, d11, bool17, d12, bool18, bool19, d13, d14, bool20, bool21, bool22, bool23, str9, bool24, d8, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Double getLongTaskThresholdMs() {
        return this.longTaskThresholdMs;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getNativeCrashReportEnabled() {
        return this.nativeCrashReportEnabled;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Double getNativeLongTaskThresholdMs() {
        return this.nativeLongTaskThresholdMs;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getNativeViewTracking() {
        return this.nativeViewTracking;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Boolean getNativeInteractionTracking() {
        return this.nativeInteractionTracking;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Double getSessionSampleRate() {
        return this.sessionSampleRate;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Double getResourceTraceSampleRate() {
        return this.resourceTraceSampleRate;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Boolean getTrackBackgroundEvents() {
        return this.trackBackgroundEvents;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Boolean getTrackFrustrations() {
        return this.trackFrustrations;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Boolean getTrackNonFatalAnrs() {
        return this.trackNonFatalAnrs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getUseAccessibilityLabel() {
        return this.useAccessibilityLabel;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Boolean getTrackWatchdogTerminations() {
        return this.trackWatchdogTerminations;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getVitalsUpdateFrequency() {
        return this.vitalsUpdateFrequency;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Boolean getTrackMemoryWarnings() {
        return this.trackMemoryWarnings;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Double getTelemetrySampleRate() {
        return this.telemetrySampleRate;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getTrackInteractions() {
        return this.trackInteractions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getTrackResources() {
        return this.trackResources;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getTrackErrors() {
        return this.trackErrors;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getActionNameAttribute() {
        return this.actionNameAttribute;
    }

    public final List<JSONFirstPartyHost> component7() {
        return this.firstPartyHosts;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Double getAppHangThreshold() {
        return this.appHangThreshold;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Double getInitialResourceThreshold() {
        return this.initialResourceThreshold;
    }

    public final JSONRumConfiguration copy(String applicationId, Boolean useAccessibilityLabel, Boolean trackInteractions, Boolean trackResources, Boolean trackErrors, String actionNameAttribute, List<JSONFirstPartyHost> firstPartyHosts, Double appHangThreshold, Double initialResourceThreshold, Double longTaskThresholdMs, Boolean nativeCrashReportEnabled, Double nativeLongTaskThresholdMs, Boolean nativeViewTracking, Boolean nativeInteractionTracking, Double sessionSampleRate, Double resourceTraceSampleRate, Boolean trackBackgroundEvents, Boolean trackFrustrations, Boolean trackNonFatalAnrs, Boolean trackWatchdogTerminations, String vitalsUpdateFrequency, Boolean trackMemoryWarnings, Double telemetrySampleRate, String customEndpoint) {
        return new JSONRumConfiguration(applicationId, useAccessibilityLabel, trackInteractions, trackResources, trackErrors, actionNameAttribute, firstPartyHosts, appHangThreshold, initialResourceThreshold, longTaskThresholdMs, nativeCrashReportEnabled, nativeLongTaskThresholdMs, nativeViewTracking, nativeInteractionTracking, sessionSampleRate, resourceTraceSampleRate, trackBackgroundEvents, trackFrustrations, trackNonFatalAnrs, trackWatchdogTerminations, vitalsUpdateFrequency, trackMemoryWarnings, telemetrySampleRate, customEndpoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSONRumConfiguration)) {
            return false;
        }
        JSONRumConfiguration jSONRumConfiguration = (JSONRumConfiguration) other;
        return Intrinsics.areEqual(this.applicationId, jSONRumConfiguration.applicationId) && Intrinsics.areEqual(this.useAccessibilityLabel, jSONRumConfiguration.useAccessibilityLabel) && Intrinsics.areEqual(this.trackInteractions, jSONRumConfiguration.trackInteractions) && Intrinsics.areEqual(this.trackResources, jSONRumConfiguration.trackResources) && Intrinsics.areEqual(this.trackErrors, jSONRumConfiguration.trackErrors) && Intrinsics.areEqual(this.actionNameAttribute, jSONRumConfiguration.actionNameAttribute) && Intrinsics.areEqual(this.firstPartyHosts, jSONRumConfiguration.firstPartyHosts) && Intrinsics.areEqual((Object) this.appHangThreshold, (Object) jSONRumConfiguration.appHangThreshold) && Intrinsics.areEqual((Object) this.initialResourceThreshold, (Object) jSONRumConfiguration.initialResourceThreshold) && Intrinsics.areEqual((Object) this.longTaskThresholdMs, (Object) jSONRumConfiguration.longTaskThresholdMs) && Intrinsics.areEqual(this.nativeCrashReportEnabled, jSONRumConfiguration.nativeCrashReportEnabled) && Intrinsics.areEqual((Object) this.nativeLongTaskThresholdMs, (Object) jSONRumConfiguration.nativeLongTaskThresholdMs) && Intrinsics.areEqual(this.nativeViewTracking, jSONRumConfiguration.nativeViewTracking) && Intrinsics.areEqual(this.nativeInteractionTracking, jSONRumConfiguration.nativeInteractionTracking) && Intrinsics.areEqual((Object) this.sessionSampleRate, (Object) jSONRumConfiguration.sessionSampleRate) && Intrinsics.areEqual((Object) this.resourceTraceSampleRate, (Object) jSONRumConfiguration.resourceTraceSampleRate) && Intrinsics.areEqual(this.trackBackgroundEvents, jSONRumConfiguration.trackBackgroundEvents) && Intrinsics.areEqual(this.trackFrustrations, jSONRumConfiguration.trackFrustrations) && Intrinsics.areEqual(this.trackNonFatalAnrs, jSONRumConfiguration.trackNonFatalAnrs) && Intrinsics.areEqual(this.trackWatchdogTerminations, jSONRumConfiguration.trackWatchdogTerminations) && Intrinsics.areEqual(this.vitalsUpdateFrequency, jSONRumConfiguration.vitalsUpdateFrequency) && Intrinsics.areEqual(this.trackMemoryWarnings, jSONRumConfiguration.trackMemoryWarnings) && Intrinsics.areEqual((Object) this.telemetrySampleRate, (Object) jSONRumConfiguration.telemetrySampleRate) && Intrinsics.areEqual(this.customEndpoint, jSONRumConfiguration.customEndpoint);
    }

    public int hashCode() {
        String str = this.applicationId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.useAccessibilityLabel;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.trackInteractions;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.trackResources;
        int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.trackErrors;
        int iHashCode5 = (iHashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str2 = this.actionNameAttribute;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<JSONFirstPartyHost> list = this.firstPartyHosts;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        Double d = this.appHangThreshold;
        int iHashCode8 = (iHashCode7 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.initialResourceThreshold;
        int iHashCode9 = (iHashCode8 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.longTaskThresholdMs;
        int iHashCode10 = (iHashCode9 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Boolean bool5 = this.nativeCrashReportEnabled;
        int iHashCode11 = (iHashCode10 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Double d4 = this.nativeLongTaskThresholdMs;
        int iHashCode12 = (iHashCode11 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Boolean bool6 = this.nativeViewTracking;
        int iHashCode13 = (iHashCode12 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.nativeInteractionTracking;
        int iHashCode14 = (iHashCode13 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Double d5 = this.sessionSampleRate;
        int iHashCode15 = (iHashCode14 + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.resourceTraceSampleRate;
        int iHashCode16 = (iHashCode15 + (d6 == null ? 0 : d6.hashCode())) * 31;
        Boolean bool8 = this.trackBackgroundEvents;
        int iHashCode17 = (iHashCode16 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.trackFrustrations;
        int iHashCode18 = (iHashCode17 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Boolean bool10 = this.trackNonFatalAnrs;
        int iHashCode19 = (iHashCode18 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        Boolean bool11 = this.trackWatchdogTerminations;
        int iHashCode20 = (iHashCode19 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
        String str3 = this.vitalsUpdateFrequency;
        int iHashCode21 = (iHashCode20 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool12 = this.trackMemoryWarnings;
        int iHashCode22 = (iHashCode21 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
        Double d7 = this.telemetrySampleRate;
        int iHashCode23 = (iHashCode22 + (d7 == null ? 0 : d7.hashCode())) * 31;
        String str4 = this.customEndpoint;
        return iHashCode23 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "JSONRumConfiguration(applicationId=" + this.applicationId + ", useAccessibilityLabel=" + this.useAccessibilityLabel + ", trackInteractions=" + this.trackInteractions + ", trackResources=" + this.trackResources + ", trackErrors=" + this.trackErrors + ", actionNameAttribute=" + this.actionNameAttribute + ", firstPartyHosts=" + this.firstPartyHosts + ", appHangThreshold=" + this.appHangThreshold + ", initialResourceThreshold=" + this.initialResourceThreshold + ", longTaskThresholdMs=" + this.longTaskThresholdMs + ", nativeCrashReportEnabled=" + this.nativeCrashReportEnabled + ", nativeLongTaskThresholdMs=" + this.nativeLongTaskThresholdMs + ", nativeViewTracking=" + this.nativeViewTracking + ", nativeInteractionTracking=" + this.nativeInteractionTracking + ", sessionSampleRate=" + this.sessionSampleRate + ", resourceTraceSampleRate=" + this.resourceTraceSampleRate + ", trackBackgroundEvents=" + this.trackBackgroundEvents + ", trackFrustrations=" + this.trackFrustrations + ", trackNonFatalAnrs=" + this.trackNonFatalAnrs + ", trackWatchdogTerminations=" + this.trackWatchdogTerminations + ", vitalsUpdateFrequency=" + this.vitalsUpdateFrequency + ", trackMemoryWarnings=" + this.trackMemoryWarnings + ", telemetrySampleRate=" + this.telemetrySampleRate + ", customEndpoint=" + this.customEndpoint + ")";
    }

    public JSONRumConfiguration(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str2, List<JSONFirstPartyHost> list, Double d, Double d2, Double d3, Boolean bool5, Double d4, Boolean bool6, Boolean bool7, Double d5, Double d6, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, String str3, Boolean bool12, Double d7, String str4) {
        this.applicationId = str;
        this.useAccessibilityLabel = bool;
        this.trackInteractions = bool2;
        this.trackResources = bool3;
        this.trackErrors = bool4;
        this.actionNameAttribute = str2;
        this.firstPartyHosts = list;
        this.appHangThreshold = d;
        this.initialResourceThreshold = d2;
        this.longTaskThresholdMs = d3;
        this.nativeCrashReportEnabled = bool5;
        this.nativeLongTaskThresholdMs = d4;
        this.nativeViewTracking = bool6;
        this.nativeInteractionTracking = bool7;
        this.sessionSampleRate = d5;
        this.resourceTraceSampleRate = d6;
        this.trackBackgroundEvents = bool8;
        this.trackFrustrations = bool9;
        this.trackNonFatalAnrs = bool10;
        this.trackWatchdogTerminations = bool11;
        this.vitalsUpdateFrequency = str3;
        this.trackMemoryWarnings = bool12;
        this.telemetrySampleRate = d7;
        this.customEndpoint = str4;
    }

    public /* synthetic */ JSONRumConfiguration(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str2, List list, Double d, Double d2, Double d3, Boolean bool5, Double d4, Boolean bool6, Boolean bool7, Double d5, Double d6, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, String str3, Boolean bool12, Double d7, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : d, (i & 256) != 0 ? null : d2, (i & 512) != 0 ? null : d3, (i & 1024) != 0 ? null : bool5, (i & 2048) != 0 ? null : d4, (i & 4096) != 0 ? null : bool6, (i & 8192) != 0 ? null : bool7, (i & 16384) != 0 ? null : d5, (i & 32768) != 0 ? null : d6, (i & 65536) != 0 ? null : bool8, (i & 131072) != 0 ? null : bool9, (i & 262144) != 0 ? null : bool10, (i & 524288) != 0 ? null : bool11, (i & 1048576) != 0 ? null : str3, (i & 2097152) != 0 ? null : bool12, (i & 4194304) != 0 ? null : d7, (i & 8388608) != 0 ? null : str4);
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final Boolean getUseAccessibilityLabel() {
        return this.useAccessibilityLabel;
    }

    public final Boolean getTrackInteractions() {
        return this.trackInteractions;
    }

    public final Boolean getTrackResources() {
        return this.trackResources;
    }

    public final Boolean getTrackErrors() {
        return this.trackErrors;
    }

    public final String getActionNameAttribute() {
        return this.actionNameAttribute;
    }

    public final List<JSONFirstPartyHost> getFirstPartyHosts() {
        return this.firstPartyHosts;
    }

    public final Double getAppHangThreshold() {
        return this.appHangThreshold;
    }

    public final Double getInitialResourceThreshold() {
        return this.initialResourceThreshold;
    }

    public final Double getLongTaskThresholdMs() {
        return this.longTaskThresholdMs;
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

    public final Double getSessionSampleRate() {
        return this.sessionSampleRate;
    }

    public final Double getResourceTraceSampleRate() {
        return this.resourceTraceSampleRate;
    }

    public final Boolean getTrackBackgroundEvents() {
        return this.trackBackgroundEvents;
    }

    public final Boolean getTrackFrustrations() {
        return this.trackFrustrations;
    }

    public final Boolean getTrackNonFatalAnrs() {
        return this.trackNonFatalAnrs;
    }

    public final Boolean getTrackWatchdogTerminations() {
        return this.trackWatchdogTerminations;
    }

    public final String getVitalsUpdateFrequency() {
        return this.vitalsUpdateFrequency;
    }

    public final Boolean getTrackMemoryWarnings() {
        return this.trackMemoryWarnings;
    }

    public final Double getTelemetrySampleRate() {
        return this.telemetrySampleRate;
    }

    public final String getCustomEndpoint() {
        return this.customEndpoint;
    }
}
