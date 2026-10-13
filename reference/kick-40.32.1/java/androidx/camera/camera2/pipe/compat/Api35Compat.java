package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.util.Size;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import androidx.camera.camera2.pipe.CameraMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0007J\u001c\u0010\u001a\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b\u0018\u00010\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0007¨\u0006\u001e"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Api35Compat;", "", "<init>", "()V", "isTorchStrengthSupported", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "getDefaultTorchStrengthLevel", "", "getMaxTorchStrengthLevel", "newImageReaderOutputConfiguration", "Landroid/hardware/camera2/params/OutputConfiguration;", "format", "surfaceSize", "Landroid/util/Size;", "newSessionConfiguration", "Landroid/hardware/camera2/params/SessionConfiguration;", "sessionType", "outputs", "", "createCaptureRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "cameraDeviceSetup", "Landroid/hardware/camera2/CameraDevice$CameraDeviceSetup;", "templateType", "getAvailableSessionCharacteristicsKeys", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "cameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Api35Compat {
    public static final Api35Compat INSTANCE = new Api35Compat();

    private Api35Compat() {
    }

    @JvmStatic
    public static final boolean isTorchStrengthSupported(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        CameraCharacteristics.Key FLASH_TORCH_STRENGTH_MAX_LEVEL = CameraCharacteristics.FLASH_TORCH_STRENGTH_MAX_LEVEL;
        Intrinsics.checkNotNullExpressionValue(FLASH_TORCH_STRENGTH_MAX_LEVEL, "FLASH_TORCH_STRENGTH_MAX_LEVEL");
        Integer num = (Integer) cameraMetadata.get(FLASH_TORCH_STRENGTH_MAX_LEVEL);
        return num != null && num.intValue() > 1;
    }

    @JvmStatic
    public static final int getDefaultTorchStrengthLevel(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        CameraCharacteristics.Key FLASH_TORCH_STRENGTH_DEFAULT_LEVEL = CameraCharacteristics.FLASH_TORCH_STRENGTH_DEFAULT_LEVEL;
        Intrinsics.checkNotNullExpressionValue(FLASH_TORCH_STRENGTH_DEFAULT_LEVEL, "FLASH_TORCH_STRENGTH_DEFAULT_LEVEL");
        Integer num = (Integer) cameraMetadata.get(FLASH_TORCH_STRENGTH_DEFAULT_LEVEL);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    @JvmStatic
    public static final int getMaxTorchStrengthLevel(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        CameraCharacteristics.Key FLASH_TORCH_STRENGTH_MAX_LEVEL = CameraCharacteristics.FLASH_TORCH_STRENGTH_MAX_LEVEL;
        Intrinsics.checkNotNullExpressionValue(FLASH_TORCH_STRENGTH_MAX_LEVEL, "FLASH_TORCH_STRENGTH_MAX_LEVEL");
        Integer num = (Integer) cameraMetadata.get(FLASH_TORCH_STRENGTH_MAX_LEVEL);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    @JvmStatic
    public static final OutputConfiguration newImageReaderOutputConfiguration(int format, Size surfaceSize) {
        Intrinsics.checkNotNullParameter(surfaceSize, "surfaceSize");
        return CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(format, surfaceSize);
    }

    @JvmStatic
    public static final SessionConfiguration newSessionConfiguration(int sessionType, List<OutputConfiguration> outputs) {
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        return CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(sessionType, outputs);
    }

    @JvmStatic
    public static final CaptureRequest.Builder createCaptureRequest(CameraDevice.CameraDeviceSetup cameraDeviceSetup, int templateType) {
        Intrinsics.checkNotNullParameter(cameraDeviceSetup, "cameraDeviceSetup");
        CaptureRequest.Builder builderCreateCaptureRequest = cameraDeviceSetup.createCaptureRequest(templateType);
        Intrinsics.checkNotNullExpressionValue(builderCreateCaptureRequest, "createCaptureRequest(...)");
        return builderCreateCaptureRequest;
    }

    @JvmStatic
    public static final List<CameraCharacteristics.Key<?>> getAvailableSessionCharacteristicsKeys(CameraCharacteristics cameraCharacteristics) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return cameraCharacteristics.getAvailableSessionCharacteristicsKeys();
    }
}
