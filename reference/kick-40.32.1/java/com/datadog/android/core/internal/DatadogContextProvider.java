package com.datadog.android.core.internal;

import com.datadog.android.DatadogSite;
import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.DeviceInfo;
import com.datadog.android.api.context.DeviceType;
import com.datadog.android.api.context.LocaleInfo;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.ProcessInfo;
import com.datadog.android.api.context.TimeInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.core.internal.system.AndroidInfoProvider;
import com.datadog.android.core.internal.time.TimeProviderExtKt;
import com.datadog.android.privacy.TrackingConsent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogContextProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/core/internal/DatadogContextProvider;", "Lcom/datadog/android/core/internal/ContextProvider;", "coreFeature", "Lcom/datadog/android/core/internal/CoreFeature;", "featureContextProvider", "Lcom/datadog/android/core/internal/FeatureContextProvider;", "(Lcom/datadog/android/core/internal/CoreFeature;Lcom/datadog/android/core/internal/FeatureContextProvider;)V", "getContext", "Lcom/datadog/android/api/context/DatadogContext;", "withFeatureContexts", "", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogContextProvider implements ContextProvider {
    private final CoreFeature coreFeature;
    private final FeatureContextProvider featureContextProvider;

    public DatadogContextProvider(CoreFeature coreFeature, FeatureContextProvider featureContextProvider) {
        Intrinsics.checkNotNullParameter(coreFeature, "coreFeature");
        Intrinsics.checkNotNullParameter(featureContextProvider, "featureContextProvider");
        this.coreFeature = coreFeature;
        this.featureContextProvider = featureContextProvider;
    }

    @Override // com.datadog.android.core.internal.ContextProvider
    public DatadogContext getContext(Set<String> withFeatureContexts) {
        Intrinsics.checkNotNullParameter(withFeatureContexts, "withFeatureContexts");
        DatadogSite site = this.coreFeature.getSite();
        String clientToken = this.coreFeature.getClientToken();
        String serviceName = this.coreFeature.getServiceName();
        String envName = this.coreFeature.getEnvName();
        String version = this.coreFeature.getPackageVersionProvider().getVersion();
        int versionCode = this.coreFeature.getPackageVersionProvider().getVersionCode();
        String variant = this.coreFeature.getVariant();
        String sdkVersion = this.coreFeature.getSdkVersion();
        String sourceName = this.coreFeature.getSourceName();
        TimeInfo timeInfoComposeTimeInfo = TimeProviderExtKt.composeTimeInfo(this.coreFeature.getTimeProvider());
        ProcessInfo processInfo = new ProcessInfo(this.coreFeature.getIsMainProcess());
        NetworkInfo lastNetworkInfo = this.coreFeature.getNetworkInfoProvider().getLastNetworkInfo();
        AndroidInfoProvider androidInfoProvider = this.coreFeature.getAndroidInfoProvider();
        String deviceName = androidInfoProvider.getDeviceName();
        String deviceBrand = androidInfoProvider.getDeviceBrand();
        DeviceType deviceType = androidInfoProvider.getDeviceType();
        String deviceModel = androidInfoProvider.getDeviceModel();
        String deviceBuildId = androidInfoProvider.getDeviceBuildId();
        String osName = androidInfoProvider.getOsName();
        String osVersion = androidInfoProvider.getOsVersion();
        String osMajorVersion = androidInfoProvider.getOsMajorVersion();
        String architecture = androidInfoProvider.getArchitecture();
        Integer numberOfDisplays = androidInfoProvider.getNumberOfDisplays();
        AndroidInfoProvider androidInfoProvider2 = this.coreFeature.getAndroidInfoProvider();
        DeviceInfo deviceInfo = new DeviceInfo(deviceName, deviceBrand, deviceModel, deviceType, deviceBuildId, osName, osMajorVersion, osVersion, architecture, numberOfDisplays, new LocaleInfo(androidInfoProvider2.getLocales(), androidInfoProvider2.getCurrentLocale(), androidInfoProvider2.getTimeZone()), androidInfoProvider.getLogicalCpuCount(), androidInfoProvider.getTotalRam(), androidInfoProvider.getIsLowRam());
        UserInfo userInfo = this.coreFeature.getUserInfoProvider().getInternalUserInfo();
        AccountInfo accountInfo = this.coreFeature.getAccountInfoProvider().getInternalAccountInfo();
        TrackingConsent consent = this.coreFeature.getTrackingConsentProvider().getConsent();
        String appBuildId = this.coreFeature.getAppBuildId();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : withFeatureContexts) {
            Map<String, Object> featureContext = this.featureContextProvider.getFeatureContext(str);
            if (!featureContext.isEmpty()) {
                linkedHashMap.put(str, featureContext);
            }
        }
        return new DatadogContext(site, clientToken, serviceName, envName, version, versionCode, variant, sourceName, sdkVersion, timeInfoComposeTimeInfo, processInfo, lastNetworkInfo, deviceInfo, userInfo, accountInfo, consent, appBuildId, linkedHashMap);
    }
}
