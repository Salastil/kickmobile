package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.camera.camera2.pipe.UnsafeWrapper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: CaptureSessionWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001%J\b\u0010\u0013\u001a\u00020\rH&J\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u0004\u0018\u00010\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H&¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u0004\u0018\u00010\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H&¢\u0006\u0002\u0010\u001eJ\u001f\u0010 \u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&¢\u0006\u0002\u0010\u001aJ\b\u0010!\u001a\u00020\rH&J\u0016\u0010\"\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001dH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "id", "Landroidx/camera/camera2/pipe/CameraInterop$CameraCaptureSessionId;", "getId-159jkk4", "()I", "device", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "getDevice", "()Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "isReprocessable", "", "()Z", "inputSurface", "Landroid/view/Surface;", "getInputSurface", "()Landroid/view/Surface;", "abortCaptures", "capture", "", "request", "Landroid/hardware/camera2/CaptureRequest;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", "captureBurst", "requests", "", "(Ljava/util/List;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Ljava/lang/Integer;", "setRepeatingBurst", "setRepeatingRequest", "stopRepeating", "finalizeOutputConfigurations", "outputConfigs", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "StateCallback", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraCaptureSessionWrapper extends UnsafeWrapper, AutoCloseable {

    /* JADX INFO: compiled from: CaptureSessionWrapper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "Landroidx/camera/camera2/pipe/compat/SessionStateCallback;", "onActive", "", "session", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;", "onClosed", "onConfigureFailed", "onConfigured", "onReady", "onCaptureQueueEmpty", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface StateCallback extends SessionStateCallback {
        void onActive(CameraCaptureSessionWrapper session);

        void onCaptureQueueEmpty(CameraCaptureSessionWrapper session);

        void onClosed(CameraCaptureSessionWrapper session);

        void onConfigureFailed(CameraCaptureSessionWrapper session);

        void onConfigured(CameraCaptureSessionWrapper session);

        void onReady(CameraCaptureSessionWrapper session);
    }

    boolean abortCaptures();

    Integer capture(CaptureRequest request, CameraCaptureSession.CaptureCallback listener);

    Integer captureBurst(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener);

    boolean finalizeOutputConfigurations(List<? extends OutputConfigurationWrapper> outputConfigs);

    CameraDeviceWrapper getDevice();

    /* JADX INFO: renamed from: getId-159jkk4 */
    int mo799getId159jkk4();

    Surface getInputSurface();

    boolean isReprocessable();

    Integer setRepeatingBurst(List<CaptureRequest> requests, CameraCaptureSession.CaptureCallback listener);

    Integer setRepeatingRequest(CaptureRequest request, CameraCaptureSession.CaptureCallback listener);

    boolean stopRepeating();
}
