package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraExtensionSession;
import androidx.camera.camera2.pipe.UnsafeWrapper;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExtensionSessionWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0001\rJ\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraExtensionSessionWrapper;", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "device", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "getDevice", "()Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "stopRepeating", "", "getRealTimeCaptureLatency", "Landroid/hardware/camera2/CameraExtensionSession$StillCaptureLatency;", "StateCallback", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraExtensionSessionWrapper extends CameraCaptureSessionWrapper, UnsafeWrapper, AutoCloseable {

    /* JADX INFO: compiled from: ExtensionSessionWrapper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraExtensionSessionWrapper$StateCallback;", "Landroidx/camera/camera2/pipe/compat/SessionStateCallback;", "onClosed", "", "session", "Landroidx/camera/camera2/pipe/compat/CameraExtensionSessionWrapper;", "onConfigureFailed", "onConfigured", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface StateCallback extends SessionStateCallback {
        void onClosed(CameraExtensionSessionWrapper session);

        void onConfigureFailed(CameraExtensionSessionWrapper session);

        void onConfigured(CameraExtensionSessionWrapper session);
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    CameraDeviceWrapper getDevice();

    CameraExtensionSession.StillCaptureLatency getRealTimeCaptureLatency();

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper
    boolean stopRepeating();
}
