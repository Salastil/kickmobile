package androidx.camera.camera2.pipe.internal;

import kotlin.Metadata;

/* JADX INFO: compiled from: CameraErrorListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "", "onCameraError", "", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "cameraError", "Landroidx/camera/camera2/pipe/CameraError;", "willAttemptRetry", "", "onCameraError-3M5Xam4", "(Ljava/lang/String;IZ)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraErrorListener {
    /* JADX INFO: renamed from: onCameraError-3M5Xam4 */
    void mo837onCameraError3M5Xam4(String cameraId, int cameraError, boolean willAttemptRetry);

    /* JADX INFO: compiled from: CameraErrorListener.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX INFO: renamed from: onCameraError-3M5Xam4$default, reason: not valid java name */
    static /* synthetic */ void m1000onCameraError3M5Xam4$default(CameraErrorListener cameraErrorListener, String str, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCameraError-3M5Xam4");
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        cameraErrorListener.mo837onCameraError3M5Xam4(str, i, z);
    }
}
