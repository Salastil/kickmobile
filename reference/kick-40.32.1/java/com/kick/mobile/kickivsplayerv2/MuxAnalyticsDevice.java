package com.kick.mobile.kickivsplayerv2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import androidx.core.app.NotificationCompat;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.mux.stats.sdk.muxstats.IDevice;
import com.mux.stats.sdk.muxstats.LogPriority;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MuxAnalyticsListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0017J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(H\u0016J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsDevice;", "Lcom/mux/stats/sdk/muxstats/IDevice;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "packageInfo", "Landroid/content/pm/PackageInfo;", "kotlin.jvm.PlatformType", "getHardwareArchitecture", "", "getOSFamily", "getMuxOSFamily", "getOSVersion", "getMuxOSVersion", "getDeviceName", "getMuxDeviceName", "getDeviceCategory", "getMuxDeviceCategory", "getManufacturer", "getMuxManufacturer", "getModelName", "getMuxModelName", "getPlayerVersion", "getDeviceId", "getAppName", "getAppVersion", "getPluginName", "getPluginVersion", "getPlayerSoftware", "getNetworkConnectionType", "getElapsedRealtime", "", "outputLog", "", "priority", "Lcom/mux/stats/sdk/muxstats/LogPriority;", "tag", NotificationCompat.CATEGORY_MESSAGE, RumFeature.EVENT_THROWABLE_PROPERTY, "", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class MuxAnalyticsDevice implements IDevice {
    private final Context context;
    private final PackageInfo packageInfo;

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public void outputLog(LogPriority priority, String tag, String msg) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public void outputLog(LogPriority priority, String tag, String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public void outputLog(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    public MuxAnalyticsDevice(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getHardwareArchitecture() {
        String str = Build.HARDWARE;
        return str == null ? "" : str;
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getOSFamily() {
        return GetDeviceInfoUseCaseKt.PLATFORM;
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getMuxOSFamily() {
        return getOSFamily();
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getOSVersion() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "" : str;
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getMuxOSVersion() {
        return getOSVersion();
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getDeviceName() {
        String str = Build.DEVICE;
        return str == null ? "" : str;
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getMuxDeviceName() {
        return getDeviceName();
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getDeviceCategory() {
        return "mobile";
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getMuxDeviceCategory() {
        return getDeviceCategory();
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getManufacturer() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str;
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getMuxManufacturer() {
        return getManufacturer();
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getModelName() {
        String str = Build.MODEL;
        return str == null ? "" : str;
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getMuxModelName() {
        return getModelName();
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getPlayerVersion() {
        return BuildConfig.IVS_PLAYER_VERSION;
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getDeviceId() {
        String string = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
        return string == null ? "" : string;
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getAppName() {
        return "KICK Live Streaming";
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getAppVersion() {
        String str = this.packageInfo.versionName;
        return str == null ? "" : str;
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getPluginName() {
        return "kick-ivs-player-v2-mux";
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getPluginVersion() {
        return "0.1.0";
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getPlayerSoftware() {
        return "Amazon IVS Player";
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public String getNetworkConnectionType() {
        return "unknown";
    }

    @Override // com.mux.stats.sdk.muxstats.IDevice
    public long getElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
