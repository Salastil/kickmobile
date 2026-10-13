package com.datadog.android.api.context;

import com.datadog.android.DatadogSite;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.trace.api.config.GeneralConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogContext.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B³\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012 \u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0\u001e¢\u0006\u0002\u0010\u001fJ\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u000fHÆ\u0003J\t\u0010?\u001a\u00020\u0011HÆ\u0003J\t\u0010@\u001a\u00020\u0013HÆ\u0003J\t\u0010A\u001a\u00020\u0015HÆ\u0003J\t\u0010B\u001a\u00020\u0017HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010D\u001a\u00020\u001bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J#\u0010F\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0\u001eHÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003JÛ\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\"\b\u0002\u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0\u001eHÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\nHÖ\u0001J\t\u0010T\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R+\u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0\u001e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006U"}, d2 = {"Lcom/datadog/android/api/context/DatadogContext;", "", GeneralConfig.SITE, "Lcom/datadog/android/DatadogSite;", "clientToken", "", "service", "env", "version", "versionCode", "", "variant", "source", "sdkVersion", "time", "Lcom/datadog/android/api/context/TimeInfo;", "processInfo", "Lcom/datadog/android/api/context/ProcessInfo;", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", "deviceInfo", "Lcom/datadog/android/api/context/DeviceInfo;", "userInfo", "Lcom/datadog/android/api/context/UserInfo;", "accountInfo", "Lcom/datadog/android/api/context/AccountInfo;", "trackingConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "appBuildId", "featuresContext", "", "(Lcom/datadog/android/DatadogSite;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/api/context/TimeInfo;Lcom/datadog/android/api/context/ProcessInfo;Lcom/datadog/android/api/context/NetworkInfo;Lcom/datadog/android/api/context/DeviceInfo;Lcom/datadog/android/api/context/UserInfo;Lcom/datadog/android/api/context/AccountInfo;Lcom/datadog/android/privacy/TrackingConsent;Ljava/lang/String;Ljava/util/Map;)V", "getAccountInfo", "()Lcom/datadog/android/api/context/AccountInfo;", "getAppBuildId", "()Ljava/lang/String;", "getClientToken", "getDeviceInfo", "()Lcom/datadog/android/api/context/DeviceInfo;", "getEnv", "getFeaturesContext", "()Ljava/util/Map;", "getNetworkInfo", "()Lcom/datadog/android/api/context/NetworkInfo;", "getProcessInfo", "()Lcom/datadog/android/api/context/ProcessInfo;", "getSdkVersion", "getService", "getSite", "()Lcom/datadog/android/DatadogSite;", "getSource", "getTime", "()Lcom/datadog/android/api/context/TimeInfo;", "getTrackingConsent", "()Lcom/datadog/android/privacy/TrackingConsent;", "getUserInfo", "()Lcom/datadog/android/api/context/UserInfo;", "getVariant", "getVersion", "getVersionCode", "()I", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DatadogContext {
    private final AccountInfo accountInfo;
    private final String appBuildId;
    private final String clientToken;
    private final DeviceInfo deviceInfo;
    private final String env;
    private final Map<String, Map<String, Object>> featuresContext;
    private final NetworkInfo networkInfo;
    private final ProcessInfo processInfo;
    private final String sdkVersion;
    private final String service;
    private final DatadogSite site;
    private final String source;
    private final TimeInfo time;
    private final TrackingConsent trackingConsent;
    private final UserInfo userInfo;
    private final String variant;
    private final String version;
    private final int versionCode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DatadogContext copy$default(DatadogContext datadogContext, DatadogSite datadogSite, String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, TimeInfo timeInfo, ProcessInfo processInfo, NetworkInfo networkInfo, DeviceInfo deviceInfo, UserInfo userInfo, AccountInfo accountInfo, TrackingConsent trackingConsent, String str8, Map map, int i2, Object obj) {
        Map map2;
        String str9;
        DatadogSite datadogSite2 = (i2 & 1) != 0 ? datadogContext.site : datadogSite;
        String str10 = (i2 & 2) != 0 ? datadogContext.clientToken : str;
        String str11 = (i2 & 4) != 0 ? datadogContext.service : str2;
        String str12 = (i2 & 8) != 0 ? datadogContext.env : str3;
        String str13 = (i2 & 16) != 0 ? datadogContext.version : str4;
        int i3 = (i2 & 32) != 0 ? datadogContext.versionCode : i;
        String str14 = (i2 & 64) != 0 ? datadogContext.variant : str5;
        String str15 = (i2 & 128) != 0 ? datadogContext.source : str6;
        String str16 = (i2 & 256) != 0 ? datadogContext.sdkVersion : str7;
        TimeInfo timeInfo2 = (i2 & 512) != 0 ? datadogContext.time : timeInfo;
        ProcessInfo processInfo2 = (i2 & 1024) != 0 ? datadogContext.processInfo : processInfo;
        NetworkInfo networkInfo2 = (i2 & 2048) != 0 ? datadogContext.networkInfo : networkInfo;
        DeviceInfo deviceInfo2 = (i2 & 4096) != 0 ? datadogContext.deviceInfo : deviceInfo;
        UserInfo userInfo2 = (i2 & 8192) != 0 ? datadogContext.userInfo : userInfo;
        DatadogSite datadogSite3 = datadogSite2;
        AccountInfo accountInfo2 = (i2 & 16384) != 0 ? datadogContext.accountInfo : accountInfo;
        TrackingConsent trackingConsent2 = (i2 & 32768) != 0 ? datadogContext.trackingConsent : trackingConsent;
        String str17 = (i2 & 65536) != 0 ? datadogContext.appBuildId : str8;
        if ((i2 & 131072) != 0) {
            str9 = str17;
            map2 = datadogContext.featuresContext;
        } else {
            map2 = map;
            str9 = str17;
        }
        return datadogContext.copy(datadogSite3, str10, str11, str12, str13, i3, str14, str15, str16, timeInfo2, processInfo2, networkInfo2, deviceInfo2, userInfo2, accountInfo2, trackingConsent2, str9, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DatadogSite getSite() {
        return this.site;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final TimeInfo getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ProcessInfo getProcessInfo() {
        return this.processInfo;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final NetworkInfo getNetworkInfo() {
        return this.networkInfo;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final AccountInfo getAccountInfo() {
        return this.accountInfo;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final TrackingConsent getTrackingConsent() {
        return this.trackingConsent;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getAppBuildId() {
        return this.appBuildId;
    }

    public final Map<String, Map<String, Object>> component18() {
        return this.featuresContext;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientToken() {
        return this.clientToken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getService() {
        return this.service;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final DatadogContext copy(DatadogSite site, String clientToken, String service, String env, String version, int versionCode, String variant, String source, String sdkVersion, TimeInfo time, ProcessInfo processInfo, NetworkInfo networkInfo, DeviceInfo deviceInfo, UserInfo userInfo, AccountInfo accountInfo, TrackingConsent trackingConsent, String appBuildId, Map<String, ? extends Map<String, ? extends Object>> featuresContext) {
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(processInfo, "processInfo");
        Intrinsics.checkNotNullParameter(networkInfo, "networkInfo");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        Intrinsics.checkNotNullParameter(featuresContext, "featuresContext");
        return new DatadogContext(site, clientToken, service, env, version, versionCode, variant, source, sdkVersion, time, processInfo, networkInfo, deviceInfo, userInfo, accountInfo, trackingConsent, appBuildId, featuresContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DatadogContext)) {
            return false;
        }
        DatadogContext datadogContext = (DatadogContext) other;
        return this.site == datadogContext.site && Intrinsics.areEqual(this.clientToken, datadogContext.clientToken) && Intrinsics.areEqual(this.service, datadogContext.service) && Intrinsics.areEqual(this.env, datadogContext.env) && Intrinsics.areEqual(this.version, datadogContext.version) && this.versionCode == datadogContext.versionCode && Intrinsics.areEqual(this.variant, datadogContext.variant) && Intrinsics.areEqual(this.source, datadogContext.source) && Intrinsics.areEqual(this.sdkVersion, datadogContext.sdkVersion) && Intrinsics.areEqual(this.time, datadogContext.time) && Intrinsics.areEqual(this.processInfo, datadogContext.processInfo) && Intrinsics.areEqual(this.networkInfo, datadogContext.networkInfo) && Intrinsics.areEqual(this.deviceInfo, datadogContext.deviceInfo) && Intrinsics.areEqual(this.userInfo, datadogContext.userInfo) && Intrinsics.areEqual(this.accountInfo, datadogContext.accountInfo) && this.trackingConsent == datadogContext.trackingConsent && Intrinsics.areEqual(this.appBuildId, datadogContext.appBuildId) && Intrinsics.areEqual(this.featuresContext, datadogContext.featuresContext);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((this.site.hashCode() * 31) + this.clientToken.hashCode()) * 31) + this.service.hashCode()) * 31) + this.env.hashCode()) * 31) + this.version.hashCode()) * 31) + Integer.hashCode(this.versionCode)) * 31) + this.variant.hashCode()) * 31) + this.source.hashCode()) * 31) + this.sdkVersion.hashCode()) * 31) + this.time.hashCode()) * 31) + this.processInfo.hashCode()) * 31) + this.networkInfo.hashCode()) * 31) + this.deviceInfo.hashCode()) * 31) + this.userInfo.hashCode()) * 31;
        AccountInfo accountInfo = this.accountInfo;
        int iHashCode2 = (((iHashCode + (accountInfo == null ? 0 : accountInfo.hashCode())) * 31) + this.trackingConsent.hashCode()) * 31;
        String str = this.appBuildId;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.featuresContext.hashCode();
    }

    public String toString() {
        return "DatadogContext(site=" + this.site + ", clientToken=" + this.clientToken + ", service=" + this.service + ", env=" + this.env + ", version=" + this.version + ", versionCode=" + this.versionCode + ", variant=" + this.variant + ", source=" + this.source + ", sdkVersion=" + this.sdkVersion + ", time=" + this.time + ", processInfo=" + this.processInfo + ", networkInfo=" + this.networkInfo + ", deviceInfo=" + this.deviceInfo + ", userInfo=" + this.userInfo + ", accountInfo=" + this.accountInfo + ", trackingConsent=" + this.trackingConsent + ", appBuildId=" + this.appBuildId + ", featuresContext=" + this.featuresContext + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DatadogContext(DatadogSite site, String clientToken, String service, String env, String version, int i, String variant, String source, String sdkVersion, TimeInfo time, ProcessInfo processInfo, NetworkInfo networkInfo, DeviceInfo deviceInfo, UserInfo userInfo, AccountInfo accountInfo, TrackingConsent trackingConsent, String str, Map<String, ? extends Map<String, ? extends Object>> featuresContext) {
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(processInfo, "processInfo");
        Intrinsics.checkNotNullParameter(networkInfo, "networkInfo");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        Intrinsics.checkNotNullParameter(featuresContext, "featuresContext");
        this.site = site;
        this.clientToken = clientToken;
        this.service = service;
        this.env = env;
        this.version = version;
        this.versionCode = i;
        this.variant = variant;
        this.source = source;
        this.sdkVersion = sdkVersion;
        this.time = time;
        this.processInfo = processInfo;
        this.networkInfo = networkInfo;
        this.deviceInfo = deviceInfo;
        this.userInfo = userInfo;
        this.accountInfo = accountInfo;
        this.trackingConsent = trackingConsent;
        this.appBuildId = str;
        this.featuresContext = featuresContext;
    }

    public final DatadogSite getSite() {
        return this.site;
    }

    public final String getClientToken() {
        return this.clientToken;
    }

    public final String getService() {
        return this.service;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getVersion() {
        return this.version;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVariant() {
        return this.variant;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final TimeInfo getTime() {
        return this.time;
    }

    public final ProcessInfo getProcessInfo() {
        return this.processInfo;
    }

    public final NetworkInfo getNetworkInfo() {
        return this.networkInfo;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final AccountInfo getAccountInfo() {
        return this.accountInfo;
    }

    public final TrackingConsent getTrackingConsent() {
        return this.trackingConsent;
    }

    public final String getAppBuildId() {
        return this.appBuildId;
    }

    public final Map<String, Map<String, Object>> getFeaturesContext() {
        return this.featuresContext;
    }
}
