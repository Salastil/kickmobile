package com.datadog.android.core.internal.system;

import com.datadog.android.api.context.DeviceType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0012\u0010$\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u0012\u0010&\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0005R\u0012\u0010(\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0005R\u0014\u0010*\u001a\u0004\u0018\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010!¨\u0006,"}, d2 = {"Lcom/datadog/android/core/internal/system/AndroidInfoProvider;", "", "architecture", "", "getArchitecture", "()Ljava/lang/String;", "currentLocale", "getCurrentLocale", "deviceBrand", "getDeviceBrand", "deviceBuildId", "getDeviceBuildId", "deviceModel", "getDeviceModel", "deviceName", "getDeviceName", "deviceType", "Lcom/datadog/android/api/context/DeviceType;", "getDeviceType", "()Lcom/datadog/android/api/context/DeviceType;", "isLowRam", "", "()Ljava/lang/Boolean;", "locales", "", "getLocales", "()Ljava/util/List;", "logicalCpuCount", "", "getLogicalCpuCount", "()I", "numberOfDisplays", "getNumberOfDisplays", "()Ljava/lang/Integer;", "osMajorVersion", "getOsMajorVersion", "osName", "getOsName", "osVersion", "getOsVersion", "timeZone", "getTimeZone", "totalRam", "getTotalRam", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AndroidInfoProvider {
    String getArchitecture();

    String getCurrentLocale();

    String getDeviceBrand();

    String getDeviceBuildId();

    String getDeviceModel();

    String getDeviceName();

    DeviceType getDeviceType();

    List<String> getLocales();

    int getLogicalCpuCount();

    Integer getNumberOfDisplays();

    String getOsMajorVersion();

    String getOsName();

    String getOsVersion();

    String getTimeZone();

    Integer getTotalRam();

    Boolean isLowRam();
}
