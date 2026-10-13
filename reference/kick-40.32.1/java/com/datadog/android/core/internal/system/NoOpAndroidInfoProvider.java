package com.datadog.android.core.internal.system;

import com.datadog.android.api.context.DeviceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: NoOpAndroidInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0015\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u001eX\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0014\u0010'\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0014\u0010)\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0014\u0010+\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0018\u0010-\u001a\u0004\u0018\u00010\u001eX\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b.\u0010#¨\u0006/"}, d2 = {"Lcom/datadog/android/core/internal/system/NoOpAndroidInfoProvider;", "Lcom/datadog/android/core/internal/system/AndroidInfoProvider;", "()V", "architecture", "", "getArchitecture", "()Ljava/lang/String;", "currentLocale", "getCurrentLocale", "deviceBrand", "getDeviceBrand", "deviceBuildId", "getDeviceBuildId", "deviceModel", "getDeviceModel", "deviceName", "getDeviceName", "deviceType", "Lcom/datadog/android/api/context/DeviceType;", "getDeviceType", "()Lcom/datadog/android/api/context/DeviceType;", "isLowRam", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "locales", "", "getLocales", "()Ljava/util/List;", "logicalCpuCount", "", "getLogicalCpuCount", "()I", "numberOfDisplays", "getNumberOfDisplays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "osMajorVersion", "getOsMajorVersion", "osName", "getOsName", "osVersion", "getOsVersion", "timeZone", "getTimeZone", "totalRam", "getTotalRam", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpAndroidInfoProvider implements AndroidInfoProvider {
    private final Boolean isLowRam;
    private final int logicalCpuCount;
    private final Integer numberOfDisplays;
    private final Integer totalRam;
    private final String deviceName = "";
    private final String deviceBrand = "";
    private final String deviceModel = "";
    private final DeviceType deviceType = DeviceType.MOBILE;
    private final String deviceBuildId = "";
    private final String osName = "";
    private final String osMajorVersion = "";
    private final String osVersion = "";
    private final String architecture = "";
    private final List<String> locales = CollectionsKt.emptyList();
    private final String currentLocale = "";
    private final String timeZone = "";

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceName() {
        return this.deviceName;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceBrand() {
        return this.deviceBrand;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceModel() {
        return this.deviceModel;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public DeviceType getDeviceType() {
        return this.deviceType;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceBuildId() {
        return this.deviceBuildId;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsName() {
        return this.osName;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsMajorVersion() {
        return this.osMajorVersion;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsVersion() {
        return this.osVersion;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getArchitecture() {
        return this.architecture;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public Integer getNumberOfDisplays() {
        return this.numberOfDisplays;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public List<String> getLocales() {
        return this.locales;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getCurrentLocale() {
        return this.currentLocale;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getTimeZone() {
        return this.timeZone;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public int getLogicalCpuCount() {
        return this.logicalCpuCount;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public Integer getTotalRam() {
        return this.totalRam;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    /* JADX INFO: renamed from: isLowRam, reason: from getter */
    public Boolean getIsLowRam() {
        return this.isLowRam;
    }
}
