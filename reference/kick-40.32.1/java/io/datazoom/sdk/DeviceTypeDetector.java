package io.datazoom.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceInfo.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/datazoom/sdk/DeviceTypeDetector;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isAndroidTV", "", "isGoogleTV", "isFireTV", "isFireTV3rdGen", "isTablet", "isFoldable", "isMobile", "getDeviceType", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DeviceTypeDetector {
    private final Context context;

    public DeviceTypeDetector(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final boolean isAndroidTV() {
        PackageManager packageManager = this.context.getPackageManager();
        return packageManager.hasSystemFeature("android.software.leanback") || packageManager.hasSystemFeature("android.hardware.type.television");
    }

    public final boolean isGoogleTV() {
        return StringsKt.equals(Build.MANUFACTURER, "Google", true);
    }

    public final boolean isFireTV() {
        return this.context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
    }

    public final boolean isFireTV3rdGen() {
        return Build.MODEL.equals("AFTN");
    }

    public final boolean isTablet() {
        return (this.context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public final boolean isFoldable() {
        return Build.VERSION.SDK_INT >= 30 && this.context.getResources().getConfiguration().smallestScreenWidthDp >= 600 && this.context.getResources().getConfiguration().screenLayout == 3 && this.context.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle");
    }

    public final boolean isMobile() {
        return (isFireTV() || isAndroidTV() || isTablet()) ? false : true;
    }

    public final String getDeviceType() {
        if (isAndroidTV()) {
            return isGoogleTV() ? "Google TV" : "Android TV";
        }
        if (isFireTV()) {
            return isFireTV3rdGen() ? "Fire TV 3rd Gen" : "Fire TV";
        }
        if (isTablet()) {
            return "Tablet";
        }
        if (isFoldable()) {
            return "Foldable";
        }
        return isMobile() ? "Mobile" : "Unknown Device";
    }
}
