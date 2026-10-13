package androidx.camera.camera2.compat.workaround;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import java.nio.BufferUnderflowException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlashAvailabilityChecker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"isFlashAvailable", "", "Landroidx/camera/camera2/impl/CameraProperties;", "allowRethrowOnError", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FlashAvailabilityCheckerKt {
    public static /* synthetic */ boolean isFlashAvailable$default(CameraProperties cameraProperties, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return isFlashAvailable(cameraProperties, z);
    }

    public static final boolean isFlashAvailable(CameraProperties cameraProperties, boolean z) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(cameraProperties, "<this>");
        try {
            CameraMetadata metadata = cameraProperties.getMetadata();
            CameraCharacteristics.Key FLASH_INFO_AVAILABLE = CameraCharacteristics.FLASH_INFO_AVAILABLE;
            Intrinsics.checkNotNullExpressionValue(FLASH_INFO_AVAILABLE, "FLASH_INFO_AVAILABLE");
            bool = (Boolean) metadata.get(FLASH_INFO_AVAILABLE);
        } catch (BufferUnderflowException e) {
            if (DeviceQuirks.INSTANCE.get(FlashAvailabilityBufferUnderflowQuirk.class) != null) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Device is known to throw an exception while checking flash availability. Flash is not available. [Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", API Level: " + Build.VERSION.SDK_INT + "].");
                }
            } else {
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                BufferUnderflowException bufferUnderflowException = e;
                if (Logger.isErrorEnabled(Log.TAG)) {
                    android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Exception thrown while checking for flash availability on device not known to throw exceptions during this check. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", API Level: " + Build.VERSION.SDK_INT + "]. Flash is not available.", bufferUnderflowException);
                }
            }
            if (z) {
                throw e;
            }
            bool = false;
        }
        if (bool == null) {
            Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
            if (Logger.isWarnEnabled(Log.TAG)) {
                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
            }
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
