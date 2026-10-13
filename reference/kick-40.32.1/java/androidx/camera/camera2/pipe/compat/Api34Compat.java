package androidx.camera.camera2.pipe.compat;

import android.graphics.ColorSpace;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.params.ExtensionSessionConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.util.Size;
import androidx.camera.camera2.pipe.CameraMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007¨\u0006\u001e"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Api34Compat;", "", "<init>", "()V", "isPostviewAvailable", "", "extensionCharacteristics", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "extension", "", "isCaptureProcessProgressAvailable", "getPostviewSupportedSizes", "", "Landroid/util/Size;", "captureSize", "format", "setPostviewOutputConfiguration", "", "extensionSessionConfiguration", "Landroid/hardware/camera2/params/ExtensionSessionConfiguration;", "postviewOutputConfiguration", "Landroid/hardware/camera2/params/OutputConfiguration;", "isZoomOverrideSupported", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "setColorSpace", "sessionConfiguration", "Landroid/hardware/camera2/params/SessionConfiguration;", "colorSpace", "Landroid/graphics/ColorSpace$Named;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Api34Compat {
    public static final Api34Compat INSTANCE = new Api34Compat();

    private Api34Compat() {
    }

    @JvmStatic
    public static final boolean isPostviewAvailable(CameraExtensionCharacteristics extensionCharacteristics, int extension) {
        Intrinsics.checkNotNullParameter(extensionCharacteristics, "extensionCharacteristics");
        return extensionCharacteristics.isPostviewAvailable(extension);
    }

    @JvmStatic
    public static final boolean isCaptureProcessProgressAvailable(CameraExtensionCharacteristics extensionCharacteristics, int extension) {
        Intrinsics.checkNotNullParameter(extensionCharacteristics, "extensionCharacteristics");
        return extensionCharacteristics.isCaptureProcessProgressAvailable(extension);
    }

    @JvmStatic
    public static final List<Size> getPostviewSupportedSizes(CameraExtensionCharacteristics extensionCharacteristics, int extension, Size captureSize, int format) {
        Intrinsics.checkNotNullParameter(extensionCharacteristics, "extensionCharacteristics");
        Intrinsics.checkNotNullParameter(captureSize, "captureSize");
        List<Size> postviewSupportedSizes = extensionCharacteristics.getPostviewSupportedSizes(extension, captureSize, format);
        Intrinsics.checkNotNullExpressionValue(postviewSupportedSizes, "getPostviewSupportedSizes(...)");
        return postviewSupportedSizes;
    }

    @JvmStatic
    public static final void setPostviewOutputConfiguration(ExtensionSessionConfiguration extensionSessionConfiguration, OutputConfiguration postviewOutputConfiguration) {
        Intrinsics.checkNotNullParameter(extensionSessionConfiguration, "extensionSessionConfiguration");
        Intrinsics.checkNotNullParameter(postviewOutputConfiguration, "postviewOutputConfiguration");
        extensionSessionConfiguration.setPostviewOutputConfiguration(postviewOutputConfiguration);
    }

    @JvmStatic
    public static final boolean isZoomOverrideSupported(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        CameraCharacteristics.Key CONTROL_AVAILABLE_SETTINGS_OVERRIDES = CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AVAILABLE_SETTINGS_OVERRIDES, "CONTROL_AVAILABLE_SETTINGS_OVERRIDES");
        int[] iArr = (int[]) cameraMetadata.get(CONTROL_AVAILABLE_SETTINGS_OVERRIDES);
        return iArr != null && ArraysKt.contains(iArr, 1);
    }

    @JvmStatic
    public static final void setColorSpace(SessionConfiguration sessionConfiguration, ColorSpace.Named colorSpace) {
        Intrinsics.checkNotNullParameter(sessionConfiguration, "sessionConfiguration");
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        sessionConfiguration.setColorSpace(colorSpace);
    }
}
