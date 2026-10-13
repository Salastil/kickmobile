package com.datadog.reactnative;

import com.datadog.trace.api.config.GeneralConfig;
import java.net.Proxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0019\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000fHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0019HÆ\u0003JÕ\u0001\u0010A\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0014\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020FHÖ\u0081\u0004J\n\u0010G\u001a\u00020\u0004HÖ\u0081\u0004R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006H"}, d2 = {"Lcom/datadog/reactnative/DdSdkConfiguration;", "", "additionalConfiguration", "", "", "clientToken", "env", GeneralConfig.SITE, "service", "verbosity", "trackingConsent", "uploadFrequency", "batchSize", "batchProcessingLevel", "proxyConfiguration", "Lkotlin/Pair;", "Ljava/net/Proxy;", "Lcom/datadog/reactnative/ProxyAuthenticator;", "rumConfiguration", "Lcom/datadog/reactnative/RumConfiguration;", "logsConfiguration", "Lcom/datadog/reactnative/LogsConfiguration;", "traceConfiguration", "Lcom/datadog/reactnative/TraceConfiguration;", "configurationForTelemetry", "Lcom/datadog/reactnative/ConfigurationForTelemetry;", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/Pair;Lcom/datadog/reactnative/RumConfiguration;Lcom/datadog/reactnative/LogsConfiguration;Lcom/datadog/reactnative/TraceConfiguration;Lcom/datadog/reactnative/ConfigurationForTelemetry;)V", "getAdditionalConfiguration", "()Ljava/util/Map;", "getClientToken", "()Ljava/lang/String;", "getEnv", "getSite", "getService", "getVerbosity", "getTrackingConsent", "getUploadFrequency", "getBatchSize", "getBatchProcessingLevel", "getProxyConfiguration", "()Lkotlin/Pair;", "getRumConfiguration", "()Lcom/datadog/reactnative/RumConfiguration;", "getLogsConfiguration", "()Lcom/datadog/reactnative/LogsConfiguration;", "getTraceConfiguration", "()Lcom/datadog/reactnative/TraceConfiguration;", "getConfigurationForTelemetry", "()Lcom/datadog/reactnative/ConfigurationForTelemetry;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "", "toString", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DdSdkConfiguration {
    private final Map<String, Object> additionalConfiguration;
    private final String batchProcessingLevel;
    private final String batchSize;
    private final String clientToken;
    private final ConfigurationForTelemetry configurationForTelemetry;
    private final String env;
    private final LogsConfiguration logsConfiguration;
    private final Pair<Proxy, ProxyAuthenticator> proxyConfiguration;
    private final RumConfiguration rumConfiguration;
    private final String service;
    private final String site;
    private final TraceConfiguration traceConfiguration;
    private final String trackingConsent;
    private final String uploadFrequency;
    private final String verbosity;

    public final Map<String, Object> component1() {
        return this.additionalConfiguration;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getBatchProcessingLevel() {
        return this.batchProcessingLevel;
    }

    public final Pair<Proxy, ProxyAuthenticator> component11() {
        return this.proxyConfiguration;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final RumConfiguration getRumConfiguration() {
        return this.rumConfiguration;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final LogsConfiguration getLogsConfiguration() {
        return this.logsConfiguration;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final TraceConfiguration getTraceConfiguration() {
        return this.traceConfiguration;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ConfigurationForTelemetry getConfigurationForTelemetry() {
        return this.configurationForTelemetry;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientToken() {
        return this.clientToken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSite() {
        return this.site;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getService() {
        return this.service;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getVerbosity() {
        return this.verbosity;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTrackingConsent() {
        return this.trackingConsent;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getUploadFrequency() {
        return this.uploadFrequency;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getBatchSize() {
        return this.batchSize;
    }

    public final DdSdkConfiguration copy(Map<String, ? extends Object> additionalConfiguration, String clientToken, String env, String site, String service, String verbosity, String trackingConsent, String uploadFrequency, String batchSize, String batchProcessingLevel, Pair<? extends Proxy, ProxyAuthenticator> proxyConfiguration, RumConfiguration rumConfiguration, LogsConfiguration logsConfiguration, TraceConfiguration traceConfiguration, ConfigurationForTelemetry configurationForTelemetry) {
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(env, "env");
        return new DdSdkConfiguration(additionalConfiguration, clientToken, env, site, service, verbosity, trackingConsent, uploadFrequency, batchSize, batchProcessingLevel, proxyConfiguration, rumConfiguration, logsConfiguration, traceConfiguration, configurationForTelemetry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DdSdkConfiguration)) {
            return false;
        }
        DdSdkConfiguration ddSdkConfiguration = (DdSdkConfiguration) other;
        return Intrinsics.areEqual(this.additionalConfiguration, ddSdkConfiguration.additionalConfiguration) && Intrinsics.areEqual(this.clientToken, ddSdkConfiguration.clientToken) && Intrinsics.areEqual(this.env, ddSdkConfiguration.env) && Intrinsics.areEqual(this.site, ddSdkConfiguration.site) && Intrinsics.areEqual(this.service, ddSdkConfiguration.service) && Intrinsics.areEqual(this.verbosity, ddSdkConfiguration.verbosity) && Intrinsics.areEqual(this.trackingConsent, ddSdkConfiguration.trackingConsent) && Intrinsics.areEqual(this.uploadFrequency, ddSdkConfiguration.uploadFrequency) && Intrinsics.areEqual(this.batchSize, ddSdkConfiguration.batchSize) && Intrinsics.areEqual(this.batchProcessingLevel, ddSdkConfiguration.batchProcessingLevel) && Intrinsics.areEqual(this.proxyConfiguration, ddSdkConfiguration.proxyConfiguration) && Intrinsics.areEqual(this.rumConfiguration, ddSdkConfiguration.rumConfiguration) && Intrinsics.areEqual(this.logsConfiguration, ddSdkConfiguration.logsConfiguration) && Intrinsics.areEqual(this.traceConfiguration, ddSdkConfiguration.traceConfiguration) && Intrinsics.areEqual(this.configurationForTelemetry, ddSdkConfiguration.configurationForTelemetry);
    }

    public int hashCode() {
        Map<String, Object> map = this.additionalConfiguration;
        int iHashCode = (((((map == null ? 0 : map.hashCode()) * 31) + this.clientToken.hashCode()) * 31) + this.env.hashCode()) * 31;
        String str = this.site;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.service;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.verbosity;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.trackingConsent;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.uploadFrequency;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.batchSize;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.batchProcessingLevel;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Pair<Proxy, ProxyAuthenticator> pair = this.proxyConfiguration;
        int iHashCode9 = (iHashCode8 + (pair == null ? 0 : pair.hashCode())) * 31;
        RumConfiguration rumConfiguration = this.rumConfiguration;
        int iHashCode10 = (iHashCode9 + (rumConfiguration == null ? 0 : rumConfiguration.hashCode())) * 31;
        LogsConfiguration logsConfiguration = this.logsConfiguration;
        int iHashCode11 = (iHashCode10 + (logsConfiguration == null ? 0 : logsConfiguration.hashCode())) * 31;
        TraceConfiguration traceConfiguration = this.traceConfiguration;
        int iHashCode12 = (iHashCode11 + (traceConfiguration == null ? 0 : traceConfiguration.hashCode())) * 31;
        ConfigurationForTelemetry configurationForTelemetry = this.configurationForTelemetry;
        return iHashCode12 + (configurationForTelemetry != null ? configurationForTelemetry.hashCode() : 0);
    }

    public String toString() {
        return "DdSdkConfiguration(additionalConfiguration=" + this.additionalConfiguration + ", clientToken=" + this.clientToken + ", env=" + this.env + ", site=" + this.site + ", service=" + this.service + ", verbosity=" + this.verbosity + ", trackingConsent=" + this.trackingConsent + ", uploadFrequency=" + this.uploadFrequency + ", batchSize=" + this.batchSize + ", batchProcessingLevel=" + this.batchProcessingLevel + ", proxyConfiguration=" + this.proxyConfiguration + ", rumConfiguration=" + this.rumConfiguration + ", logsConfiguration=" + this.logsConfiguration + ", traceConfiguration=" + this.traceConfiguration + ", configurationForTelemetry=" + this.configurationForTelemetry + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DdSdkConfiguration(Map<String, ? extends Object> map, String clientToken, String env, String str, String str2, String str3, String str4, String str5, String str6, String str7, Pair<? extends Proxy, ProxyAuthenticator> pair, RumConfiguration rumConfiguration, LogsConfiguration logsConfiguration, TraceConfiguration traceConfiguration, ConfigurationForTelemetry configurationForTelemetry) {
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(env, "env");
        this.additionalConfiguration = map;
        this.clientToken = clientToken;
        this.env = env;
        this.site = str;
        this.service = str2;
        this.verbosity = str3;
        this.trackingConsent = str4;
        this.uploadFrequency = str5;
        this.batchSize = str6;
        this.batchProcessingLevel = str7;
        this.proxyConfiguration = pair;
        this.rumConfiguration = rumConfiguration;
        this.logsConfiguration = logsConfiguration;
        this.traceConfiguration = traceConfiguration;
        this.configurationForTelemetry = configurationForTelemetry;
    }

    public /* synthetic */ DdSdkConfiguration(Map map, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Pair pair, RumConfiguration rumConfiguration, LogsConfiguration logsConfiguration, TraceConfiguration traceConfiguration, ConfigurationForTelemetry configurationForTelemetry, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : pair, (i & 2048) != 0 ? null : rumConfiguration, (i & 4096) != 0 ? null : logsConfiguration, (i & 8192) != 0 ? null : traceConfiguration, (i & 16384) != 0 ? null : configurationForTelemetry);
    }

    public final Map<String, Object> getAdditionalConfiguration() {
        return this.additionalConfiguration;
    }

    public final String getClientToken() {
        return this.clientToken;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getSite() {
        return this.site;
    }

    public final String getService() {
        return this.service;
    }

    public final String getVerbosity() {
        return this.verbosity;
    }

    public final String getTrackingConsent() {
        return this.trackingConsent;
    }

    public final String getUploadFrequency() {
        return this.uploadFrequency;
    }

    public final String getBatchSize() {
        return this.batchSize;
    }

    public final String getBatchProcessingLevel() {
        return this.batchProcessingLevel;
    }

    public final Pair<Proxy, ProxyAuthenticator> getProxyConfiguration() {
        return this.proxyConfiguration;
    }

    public final RumConfiguration getRumConfiguration() {
        return this.rumConfiguration;
    }

    public final LogsConfiguration getLogsConfiguration() {
        return this.logsConfiguration;
    }

    public final TraceConfiguration getTraceConfiguration() {
        return this.traceConfiguration;
    }

    public final ConfigurationForTelemetry getConfigurationForTelemetry() {
        return this.configurationForTelemetry;
    }
}
