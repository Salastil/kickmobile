package androidx.camera.extensions.internal;

import android.hardware.camera2.CameraExtensionCharacteristics;
import android.util.Size;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: Camera2ExtensionsInfoProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/camera/extensions/internal/Camera2ExtensionsInfoProvider;", "", "getExtensionCharacteristics", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "cameraId", "", "isExtensionAvailable", "", "mode", "", "getSupportedOutputSizes", "", "Landroid/util/Size;", "format", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Camera2ExtensionsInfoProvider {
    CameraExtensionCharacteristics getExtensionCharacteristics(String cameraId);

    List<Size> getSupportedOutputSizes(String cameraId, int mode, int format);

    boolean isExtensionAvailable(String cameraId, int mode);
}
