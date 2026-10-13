package com.datadog.reactnative;

import com.datadog.trace.api.config.GeneralConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0017HÆ\u0003JÓ\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001J\u0014\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010D\u001a\u00020EHÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006G"}, d2 = {"Lcom/datadog/reactnative/JSONDdSdkConfiguration;", "", "clientToken", "", "env", "trackingConsent", "additionalConfiguration", "", "batchSize", "batchProcessingLevel", "proxyConfiguration", "Lcom/datadog/reactnative/JSONProxyConfiguration;", "service", "uploadFrequency", "verbosity", "version", "versionSuffix", GeneralConfig.SITE, "rumConfiguration", "Lcom/datadog/reactnative/JSONRumConfiguration;", "logsConfiguration", "Lcom/datadog/reactnative/JSONLogsConfiguration;", "traceConfiguration", "Lcom/datadog/reactnative/JSONTraceConfiguration;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/reactnative/JSONProxyConfiguration;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/reactnative/JSONRumConfiguration;Lcom/datadog/reactnative/JSONLogsConfiguration;Lcom/datadog/reactnative/JSONTraceConfiguration;)V", "getClientToken", "()Ljava/lang/String;", "getEnv", "getTrackingConsent", "getAdditionalConfiguration", "()Ljava/util/Map;", "getBatchSize", "getBatchProcessingLevel", "getProxyConfiguration", "()Lcom/datadog/reactnative/JSONProxyConfiguration;", "getService", "getUploadFrequency", "getVerbosity", "getVersion", "getVersionSuffix", "getSite", "getRumConfiguration", "()Lcom/datadog/reactnative/JSONRumConfiguration;", "getLogsConfiguration", "()Lcom/datadog/reactnative/JSONLogsConfiguration;", "getTraceConfiguration", "()Lcom/datadog/reactnative/JSONTraceConfiguration;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "hashCode", "", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class JSONDdSdkConfiguration {
    private final Map<String, Object> additionalConfiguration;
    private final String batchProcessingLevel;
    private final String batchSize;
    private final String clientToken;
    private final String env;
    private final JSONLogsConfiguration logsConfiguration;
    private final JSONProxyConfiguration proxyConfiguration;
    private final JSONRumConfiguration rumConfiguration;
    private final String service;
    private final String site;
    private final JSONTraceConfiguration traceConfiguration;
    private final String trackingConsent;
    private final String uploadFrequency;
    private final String verbosity;
    private final String version;
    private final String versionSuffix;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONDdSdkConfiguration copy$default(JSONDdSdkConfiguration jSONDdSdkConfiguration, String str, String str2, String str3, Map map, String str4, String str5, JSONProxyConfiguration jSONProxyConfiguration, String str6, String str7, String str8, String str9, String str10, String str11, JSONRumConfiguration jSONRumConfiguration, JSONLogsConfiguration jSONLogsConfiguration, JSONTraceConfiguration jSONTraceConfiguration, int i, Object obj) {
        String str12 = (i & 1) != 0 ? jSONDdSdkConfiguration.clientToken : str;
        return jSONDdSdkConfiguration.copy(str12, (i & 2) != 0 ? jSONDdSdkConfiguration.env : str2, (i & 4) != 0 ? jSONDdSdkConfiguration.trackingConsent : str3, (i & 8) != 0 ? jSONDdSdkConfiguration.additionalConfiguration : map, (i & 16) != 0 ? jSONDdSdkConfiguration.batchSize : str4, (i & 32) != 0 ? jSONDdSdkConfiguration.batchProcessingLevel : str5, (i & 64) != 0 ? jSONDdSdkConfiguration.proxyConfiguration : jSONProxyConfiguration, (i & 128) != 0 ? jSONDdSdkConfiguration.service : str6, (i & 256) != 0 ? jSONDdSdkConfiguration.uploadFrequency : str7, (i & 512) != 0 ? jSONDdSdkConfiguration.verbosity : str8, (i & 1024) != 0 ? jSONDdSdkConfiguration.version : str9, (i & 2048) != 0 ? jSONDdSdkConfiguration.versionSuffix : str10, (i & 4096) != 0 ? jSONDdSdkConfiguration.site : str11, (i & 8192) != 0 ? jSONDdSdkConfiguration.rumConfiguration : jSONRumConfiguration, (i & 16384) != 0 ? jSONDdSdkConfiguration.logsConfiguration : jSONLogsConfiguration, (i & 32768) != 0 ? jSONDdSdkConfiguration.traceConfiguration : jSONTraceConfiguration);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClientToken() {
        return this.clientToken;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVerbosity() {
        return this.verbosity;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getVersionSuffix() {
        return this.versionSuffix;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSite() {
        return this.site;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final JSONRumConfiguration getRumConfiguration() {
        return this.rumConfiguration;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final JSONLogsConfiguration getLogsConfiguration() {
        return this.logsConfiguration;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final JSONTraceConfiguration getTraceConfiguration() {
        return this.traceConfiguration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTrackingConsent() {
        return this.trackingConsent;
    }

    public final Map<String, Object> component4() {
        return this.additionalConfiguration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBatchSize() {
        return this.batchSize;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBatchProcessingLevel() {
        return this.batchProcessingLevel;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final JSONProxyConfiguration getProxyConfiguration() {
        return this.proxyConfiguration;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getService() {
        return this.service;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getUploadFrequency() {
        return this.uploadFrequency;
    }

    public final JSONDdSdkConfiguration copy(String clientToken, String env, String trackingConsent, Map<String, ? extends Object> additionalConfiguration, String batchSize, String batchProcessingLevel, JSONProxyConfiguration proxyConfiguration, String service, String uploadFrequency, String verbosity, String version, String versionSuffix, String site, JSONRumConfiguration rumConfiguration, JSONLogsConfiguration logsConfiguration, JSONTraceConfiguration traceConfiguration) {
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(env, "env");
        return new JSONDdSdkConfiguration(clientToken, env, trackingConsent, additionalConfiguration, batchSize, batchProcessingLevel, proxyConfiguration, service, uploadFrequency, verbosity, version, versionSuffix, site, rumConfiguration, logsConfiguration, traceConfiguration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSONDdSdkConfiguration)) {
            return false;
        }
        JSONDdSdkConfiguration jSONDdSdkConfiguration = (JSONDdSdkConfiguration) other;
        return Intrinsics.areEqual(this.clientToken, jSONDdSdkConfiguration.clientToken) && Intrinsics.areEqual(this.env, jSONDdSdkConfiguration.env) && Intrinsics.areEqual(this.trackingConsent, jSONDdSdkConfiguration.trackingConsent) && Intrinsics.areEqual(this.additionalConfiguration, jSONDdSdkConfiguration.additionalConfiguration) && Intrinsics.areEqual(this.batchSize, jSONDdSdkConfiguration.batchSize) && Intrinsics.areEqual(this.batchProcessingLevel, jSONDdSdkConfiguration.batchProcessingLevel) && Intrinsics.areEqual(this.proxyConfiguration, jSONDdSdkConfiguration.proxyConfiguration) && Intrinsics.areEqual(this.service, jSONDdSdkConfiguration.service) && Intrinsics.areEqual(this.uploadFrequency, jSONDdSdkConfiguration.uploadFrequency) && Intrinsics.areEqual(this.verbosity, jSONDdSdkConfiguration.verbosity) && Intrinsics.areEqual(this.version, jSONDdSdkConfiguration.version) && Intrinsics.areEqual(this.versionSuffix, jSONDdSdkConfiguration.versionSuffix) && Intrinsics.areEqual(this.site, jSONDdSdkConfiguration.site) && Intrinsics.areEqual(this.rumConfiguration, jSONDdSdkConfiguration.rumConfiguration) && Intrinsics.areEqual(this.logsConfiguration, jSONDdSdkConfiguration.logsConfiguration) && Intrinsics.areEqual(this.traceConfiguration, jSONDdSdkConfiguration.traceConfiguration);
    }

    public int hashCode() {
        int iHashCode = ((this.clientToken.hashCode() * 31) + this.env.hashCode()) * 31;
        String str = this.trackingConsent;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, Object> map = this.additionalConfiguration;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.batchSize;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.batchProcessingLevel;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        JSONProxyConfiguration jSONProxyConfiguration = this.proxyConfiguration;
        int iHashCode6 = (iHashCode5 + (jSONProxyConfiguration == null ? 0 : jSONProxyConfiguration.hashCode())) * 31;
        String str4 = this.service;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.uploadFrequency;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.verbosity;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.version;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.versionSuffix;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.site;
        int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        JSONRumConfiguration jSONRumConfiguration = this.rumConfiguration;
        int iHashCode13 = (iHashCode12 + (jSONRumConfiguration == null ? 0 : jSONRumConfiguration.hashCode())) * 31;
        JSONLogsConfiguration jSONLogsConfiguration = this.logsConfiguration;
        int iHashCode14 = (iHashCode13 + (jSONLogsConfiguration == null ? 0 : jSONLogsConfiguration.hashCode())) * 31;
        JSONTraceConfiguration jSONTraceConfiguration = this.traceConfiguration;
        return iHashCode14 + (jSONTraceConfiguration != null ? jSONTraceConfiguration.hashCode() : 0);
    }

    public String toString() {
        return "JSONDdSdkConfiguration(clientToken=" + this.clientToken + ", env=" + this.env + ", trackingConsent=" + this.trackingConsent + ", additionalConfiguration=" + this.additionalConfiguration + ", batchSize=" + this.batchSize + ", batchProcessingLevel=" + this.batchProcessingLevel + ", proxyConfiguration=" + this.proxyConfiguration + ", service=" + this.service + ", uploadFrequency=" + this.uploadFrequency + ", verbosity=" + this.verbosity + ", version=" + this.version + ", versionSuffix=" + this.versionSuffix + ", site=" + this.site + ", rumConfiguration=" + this.rumConfiguration + ", logsConfiguration=" + this.logsConfiguration + ", traceConfiguration=" + this.traceConfiguration + ")";
    }

    public JSONDdSdkConfiguration(String clientToken, String env, String str, Map<String, ? extends Object> map, String str2, String str3, JSONProxyConfiguration jSONProxyConfiguration, String str4, String str5, String str6, String str7, String str8, String str9, JSONRumConfiguration jSONRumConfiguration, JSONLogsConfiguration jSONLogsConfiguration, JSONTraceConfiguration jSONTraceConfiguration) {
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(env, "env");
        this.clientToken = clientToken;
        this.env = env;
        this.trackingConsent = str;
        this.additionalConfiguration = map;
        this.batchSize = str2;
        this.batchProcessingLevel = str3;
        this.proxyConfiguration = jSONProxyConfiguration;
        this.service = str4;
        this.uploadFrequency = str5;
        this.verbosity = str6;
        this.version = str7;
        this.versionSuffix = str8;
        this.site = str9;
        this.rumConfiguration = jSONRumConfiguration;
        this.logsConfiguration = jSONLogsConfiguration;
        this.traceConfiguration = jSONTraceConfiguration;
    }

    public /* synthetic */ JSONDdSdkConfiguration(String str, String str2, String str3, Map map, String str4, String str5, JSONProxyConfiguration jSONProxyConfiguration, String str6, String str7, String str8, String str9, String str10, String str11, JSONRumConfiguration jSONRumConfiguration, JSONLogsConfiguration jSONLogsConfiguration, JSONTraceConfiguration jSONTraceConfiguration, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : jSONProxyConfiguration, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : jSONRumConfiguration, (i & 16384) != 0 ? null : jSONLogsConfiguration, (i & 32768) != 0 ? null : jSONTraceConfiguration);
    }

    public final String getClientToken() {
        return this.clientToken;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getTrackingConsent() {
        return this.trackingConsent;
    }

    public final Map<String, Object> getAdditionalConfiguration() {
        return this.additionalConfiguration;
    }

    public final String getBatchSize() {
        return this.batchSize;
    }

    public final String getBatchProcessingLevel() {
        return this.batchProcessingLevel;
    }

    public final JSONProxyConfiguration getProxyConfiguration() {
        return this.proxyConfiguration;
    }

    public final String getService() {
        return this.service;
    }

    public final String getUploadFrequency() {
        return this.uploadFrequency;
    }

    public final String getVerbosity() {
        return this.verbosity;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getVersionSuffix() {
        return this.versionSuffix;
    }

    public final String getSite() {
        return this.site;
    }

    public final JSONRumConfiguration getRumConfiguration() {
        return this.rumConfiguration;
    }

    public final JSONLogsConfiguration getLogsConfiguration() {
        return this.logsConfiguration;
    }

    public final JSONTraceConfiguration getTraceConfiguration() {
        return this.traceConfiguration;
    }
}
