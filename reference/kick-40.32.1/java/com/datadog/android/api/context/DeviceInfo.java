package com.datadog.android.api.context;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010%J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u00100\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J \u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u000eHÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u0013\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010&\u001a\u0004\b*\u0010%¨\u0006?"}, d2 = {"Lcom/datadog/android/api/context/DeviceInfo;", "", "deviceName", "", "deviceBrand", "deviceModel", "deviceType", "Lcom/datadog/android/api/context/DeviceType;", "deviceBuildId", "osName", "osMajorVersion", "osVersion", "architecture", "numberOfDisplays", "", "localeInfo", "Lcom/datadog/android/api/context/LocaleInfo;", "logicalCpuCount", "totalRam", "isLowRam", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/api/context/DeviceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/datadog/android/api/context/LocaleInfo;ILjava/lang/Integer;Ljava/lang/Boolean;)V", "getArchitecture", "()Ljava/lang/String;", "getDeviceBrand", "getDeviceBuildId", "getDeviceModel", "getDeviceName", "getDeviceType", "()Lcom/datadog/android/api/context/DeviceType;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocaleInfo", "()Lcom/datadog/android/api/context/LocaleInfo;", "getLogicalCpuCount", "()I", "getNumberOfDisplays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOsMajorVersion", "getOsName", "getOsVersion", "getTotalRam", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/api/context/DeviceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/datadog/android/api/context/LocaleInfo;ILjava/lang/Integer;Ljava/lang/Boolean;)Lcom/datadog/android/api/context/DeviceInfo;", "equals", "other", "hashCode", "toString", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DeviceInfo {
    private final String architecture;
    private final String deviceBrand;
    private final String deviceBuildId;
    private final String deviceModel;
    private final String deviceName;
    private final DeviceType deviceType;
    private final Boolean isLowRam;
    private final LocaleInfo localeInfo;
    private final int logicalCpuCount;
    private final Integer numberOfDisplays;
    private final String osMajorVersion;
    private final String osName;
    private final String osVersion;
    private final Integer totalRam;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getNumberOfDisplays() {
        return this.numberOfDisplays;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final LocaleInfo getLocaleInfo() {
        return this.localeInfo;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getLogicalCpuCount() {
        return this.logicalCpuCount;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getTotalRam() {
        return this.totalRam;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Boolean getIsLowRam() {
        return this.isLowRam;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceBrand() {
        return this.deviceBrand;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeviceBuildId() {
        return this.deviceBuildId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOsName() {
        return this.osName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOsMajorVersion() {
        return this.osMajorVersion;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getArchitecture() {
        return this.architecture;
    }

    public final DeviceInfo copy(String deviceName, String deviceBrand, String deviceModel, DeviceType deviceType, String deviceBuildId, String osName, String osMajorVersion, String osVersion, String architecture, Integer numberOfDisplays, LocaleInfo localeInfo, int logicalCpuCount, Integer totalRam, Boolean isLowRam) {
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(deviceBrand, "deviceBrand");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(deviceBuildId, "deviceBuildId");
        Intrinsics.checkNotNullParameter(osName, "osName");
        Intrinsics.checkNotNullParameter(osMajorVersion, "osMajorVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(architecture, "architecture");
        Intrinsics.checkNotNullParameter(localeInfo, "localeInfo");
        return new DeviceInfo(deviceName, deviceBrand, deviceModel, deviceType, deviceBuildId, osName, osMajorVersion, osVersion, architecture, numberOfDisplays, localeInfo, logicalCpuCount, totalRam, isLowRam);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) other;
        return Intrinsics.areEqual(this.deviceName, deviceInfo.deviceName) && Intrinsics.areEqual(this.deviceBrand, deviceInfo.deviceBrand) && Intrinsics.areEqual(this.deviceModel, deviceInfo.deviceModel) && this.deviceType == deviceInfo.deviceType && Intrinsics.areEqual(this.deviceBuildId, deviceInfo.deviceBuildId) && Intrinsics.areEqual(this.osName, deviceInfo.osName) && Intrinsics.areEqual(this.osMajorVersion, deviceInfo.osMajorVersion) && Intrinsics.areEqual(this.osVersion, deviceInfo.osVersion) && Intrinsics.areEqual(this.architecture, deviceInfo.architecture) && Intrinsics.areEqual(this.numberOfDisplays, deviceInfo.numberOfDisplays) && Intrinsics.areEqual(this.localeInfo, deviceInfo.localeInfo) && this.logicalCpuCount == deviceInfo.logicalCpuCount && Intrinsics.areEqual(this.totalRam, deviceInfo.totalRam) && Intrinsics.areEqual(this.isLowRam, deviceInfo.isLowRam);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.deviceName.hashCode() * 31) + this.deviceBrand.hashCode()) * 31) + this.deviceModel.hashCode()) * 31) + this.deviceType.hashCode()) * 31) + this.deviceBuildId.hashCode()) * 31) + this.osName.hashCode()) * 31) + this.osMajorVersion.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.architecture.hashCode()) * 31;
        Integer num = this.numberOfDisplays;
        int iHashCode2 = (((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.localeInfo.hashCode()) * 31) + Integer.hashCode(this.logicalCpuCount)) * 31;
        Integer num2 = this.totalRam;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.isLowRam;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "DeviceInfo(deviceName=" + this.deviceName + ", deviceBrand=" + this.deviceBrand + ", deviceModel=" + this.deviceModel + ", deviceType=" + this.deviceType + ", deviceBuildId=" + this.deviceBuildId + ", osName=" + this.osName + ", osMajorVersion=" + this.osMajorVersion + ", osVersion=" + this.osVersion + ", architecture=" + this.architecture + ", numberOfDisplays=" + this.numberOfDisplays + ", localeInfo=" + this.localeInfo + ", logicalCpuCount=" + this.logicalCpuCount + ", totalRam=" + this.totalRam + ", isLowRam=" + this.isLowRam + ")";
    }

    public DeviceInfo(String deviceName, String deviceBrand, String deviceModel, DeviceType deviceType, String deviceBuildId, String osName, String osMajorVersion, String osVersion, String architecture, Integer num, LocaleInfo localeInfo, int i, Integer num2, Boolean bool) {
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(deviceBrand, "deviceBrand");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(deviceBuildId, "deviceBuildId");
        Intrinsics.checkNotNullParameter(osName, "osName");
        Intrinsics.checkNotNullParameter(osMajorVersion, "osMajorVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(architecture, "architecture");
        Intrinsics.checkNotNullParameter(localeInfo, "localeInfo");
        this.deviceName = deviceName;
        this.deviceBrand = deviceBrand;
        this.deviceModel = deviceModel;
        this.deviceType = deviceType;
        this.deviceBuildId = deviceBuildId;
        this.osName = osName;
        this.osMajorVersion = osMajorVersion;
        this.osVersion = osVersion;
        this.architecture = architecture;
        this.numberOfDisplays = num;
        this.localeInfo = localeInfo;
        this.logicalCpuCount = i;
        this.totalRam = num2;
        this.isLowRam = bool;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDeviceBrand() {
        return this.deviceBrand;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final String getDeviceBuildId() {
        return this.deviceBuildId;
    }

    public final String getOsName() {
        return this.osName;
    }

    public final String getOsMajorVersion() {
        return this.osMajorVersion;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getArchitecture() {
        return this.architecture;
    }

    public final Integer getNumberOfDisplays() {
        return this.numberOfDisplays;
    }

    public final LocaleInfo getLocaleInfo() {
        return this.localeInfo;
    }

    public final int getLogicalCpuCount() {
        return this.logicalCpuCount;
    }

    public final Integer getTotalRam() {
        return this.totalRam;
    }

    public final Boolean isLowRam() {
        return this.isLowRam;
    }
}
