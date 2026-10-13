package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0007J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nH\u0007J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\u0011\u001a\u00020\nH\u0007J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0013H\u0007J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0007¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Api26Compat;", "", "<init>", "()V", "finalizeOutputConfigurations", "", "cameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "outputConfiguration", "", "Landroid/hardware/camera2/params/OutputConfiguration;", "newOutputConfiguration", ContentDisposition.Parameters.Size, "Landroid/util/Size;", "klass", "Ljava/lang/Class;", "enableSurfaceSharing", "outputConfig", "getSurfaces", "Landroid/view/Surface;", "addSurfaces", "surface", "onCaptureQueueEmpty", "interopSessionStateCallback", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "session", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Api26Compat {
    public static final Api26Compat INSTANCE = new Api26Compat();

    private Api26Compat() {
    }

    @JvmStatic
    public static final void finalizeOutputConfigurations(CameraCaptureSession cameraCaptureSession, List<OutputConfiguration> outputConfiguration) throws CameraAccessException {
        Intrinsics.checkNotNullParameter(cameraCaptureSession, "cameraCaptureSession");
        Intrinsics.checkNotNullParameter(outputConfiguration, "outputConfiguration");
        cameraCaptureSession.finalizeOutputConfigurations(outputConfiguration);
    }

    @JvmStatic
    public static final OutputConfiguration newOutputConfiguration(Size size, Class<?> klass) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(klass, "klass");
        return CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(size, klass);
    }

    @JvmStatic
    public static final void enableSurfaceSharing(OutputConfiguration outputConfig) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        outputConfig.enableSurfaceSharing();
    }

    @JvmStatic
    public static final List<Surface> getSurfaces(OutputConfiguration outputConfig) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        List<Surface> surfaces = outputConfig.getSurfaces();
        Intrinsics.checkNotNullExpressionValue(surfaces, "getSurfaces(...)");
        return surfaces;
    }

    @JvmStatic
    public static final void addSurfaces(OutputConfiguration outputConfig, Surface surface) {
        Intrinsics.checkNotNullParameter(outputConfig, "outputConfig");
        Intrinsics.checkNotNullParameter(surface, "surface");
        outputConfig.addSurface(surface);
    }

    @JvmStatic
    public static final void onCaptureQueueEmpty(CameraCaptureSession.StateCallback interopSessionStateCallback, CameraCaptureSession session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (interopSessionStateCallback != null) {
            interopSessionStateCallback.onCaptureQueueEmpty(session);
        }
    }
}
