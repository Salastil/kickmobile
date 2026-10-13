package com.datadog.reactnative;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/datadog/reactnative/ConfigurationForTelemetry;", "", "initializationType", "", "trackErrors", "", "trackInteractions", "trackNetworkRequests", "reactVersion", "reactNativeVersion", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getInitializationType", "()Ljava/lang/String;", "getTrackErrors", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrackInteractions", "getTrackNetworkRequests", "getReactVersion", "getReactNativeVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/datadog/reactnative/ConfigurationForTelemetry;", "equals", "other", "hashCode", "", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ConfigurationForTelemetry {
    private final String initializationType;
    private final String reactNativeVersion;
    private final String reactVersion;
    private final Boolean trackErrors;
    private final Boolean trackInteractions;
    private final Boolean trackNetworkRequests;

    public ConfigurationForTelemetry() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ConfigurationForTelemetry copy$default(ConfigurationForTelemetry configurationForTelemetry, String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = configurationForTelemetry.initializationType;
        }
        if ((i & 2) != 0) {
            bool = configurationForTelemetry.trackErrors;
        }
        if ((i & 4) != 0) {
            bool2 = configurationForTelemetry.trackInteractions;
        }
        if ((i & 8) != 0) {
            bool3 = configurationForTelemetry.trackNetworkRequests;
        }
        if ((i & 16) != 0) {
            str2 = configurationForTelemetry.reactVersion;
        }
        if ((i & 32) != 0) {
            str3 = configurationForTelemetry.reactNativeVersion;
        }
        String str4 = str2;
        String str5 = str3;
        return configurationForTelemetry.copy(str, bool, bool2, bool3, str4, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInitializationType() {
        return this.initializationType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getTrackErrors() {
        return this.trackErrors;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getTrackInteractions() {
        return this.trackInteractions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getTrackNetworkRequests() {
        return this.trackNetworkRequests;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getReactVersion() {
        return this.reactVersion;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReactNativeVersion() {
        return this.reactNativeVersion;
    }

    public final ConfigurationForTelemetry copy(String initializationType, Boolean trackErrors, Boolean trackInteractions, Boolean trackNetworkRequests, String reactVersion, String reactNativeVersion) {
        return new ConfigurationForTelemetry(initializationType, trackErrors, trackInteractions, trackNetworkRequests, reactVersion, reactNativeVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigurationForTelemetry)) {
            return false;
        }
        ConfigurationForTelemetry configurationForTelemetry = (ConfigurationForTelemetry) other;
        return Intrinsics.areEqual(this.initializationType, configurationForTelemetry.initializationType) && Intrinsics.areEqual(this.trackErrors, configurationForTelemetry.trackErrors) && Intrinsics.areEqual(this.trackInteractions, configurationForTelemetry.trackInteractions) && Intrinsics.areEqual(this.trackNetworkRequests, configurationForTelemetry.trackNetworkRequests) && Intrinsics.areEqual(this.reactVersion, configurationForTelemetry.reactVersion) && Intrinsics.areEqual(this.reactNativeVersion, configurationForTelemetry.reactNativeVersion);
    }

    public int hashCode() {
        String str = this.initializationType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.trackErrors;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.trackInteractions;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.trackNetworkRequests;
        int iHashCode4 = (iHashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str2 = this.reactVersion;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reactNativeVersion;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ConfigurationForTelemetry(initializationType=" + this.initializationType + ", trackErrors=" + this.trackErrors + ", trackInteractions=" + this.trackInteractions + ", trackNetworkRequests=" + this.trackNetworkRequests + ", reactVersion=" + this.reactVersion + ", reactNativeVersion=" + this.reactNativeVersion + ")";
    }

    public ConfigurationForTelemetry(String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3) {
        this.initializationType = str;
        this.trackErrors = bool;
        this.trackInteractions = bool2;
        this.trackNetworkRequests = bool3;
        this.reactVersion = str2;
        this.reactNativeVersion = str3;
    }

    public /* synthetic */ ConfigurationForTelemetry(String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
    }

    public final String getInitializationType() {
        return this.initializationType;
    }

    public final Boolean getTrackErrors() {
        return this.trackErrors;
    }

    public final Boolean getTrackInteractions() {
        return this.trackInteractions;
    }

    public final Boolean getTrackNetworkRequests() {
        return this.trackNetworkRequests;
    }

    public final String getReactVersion() {
        return this.reactVersion;
    }

    public final String getReactNativeVersion() {
        return this.reactNativeVersion;
    }
}
