package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceInfoLogger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/impl/DeviceInfoLogger;", "", "<init>", "()V", "logDeviceInfo", "", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "logDeviceLevel", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceInfoLogger {
    public static final DeviceInfoLogger INSTANCE = new DeviceInfoLogger();

    private DeviceInfoLogger() {
    }

    public final void logDeviceInfo(CameraProperties cameraProperties) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        logDeviceLevel(cameraProperties);
    }

    private final void logDeviceLevel(CameraProperties cameraProperties) {
        String str;
        CameraMetadata metadata = cameraProperties.getMetadata();
        CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        Intrinsics.checkNotNullExpressionValue(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
        Integer num = (Integer) metadata.getOrDefault((CameraCharacteristics.Key<int>) INFO_SUPPORTED_HARDWARE_LEVEL, -1);
        if (num != null && num.intValue() == 2) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (num != null && num.intValue() == 4) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        } else if (num != null && num.intValue() == 0) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (num != null && num.intValue() == 1) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (num != null && num.intValue() == 3) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        } else {
            str = "Unknown value: " + num;
        }
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isInfoEnabled(Log.TAG)) {
            android.util.Log.i(Camera2Logger.TRUNCATED_TAG, "Device Level: " + str);
        }
    }
}
