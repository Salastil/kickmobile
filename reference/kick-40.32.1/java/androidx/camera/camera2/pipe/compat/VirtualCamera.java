package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraError;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: VirtualCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0019\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\b\u000eR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/compat/VirtualCamera;", "", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/camera/camera2/pipe/compat/CameraState;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "value", "getValue", "()Landroidx/camera/camera2/pipe/compat/CameraState;", "disconnect", "", "lastCameraError", "Landroidx/camera/camera2/pipe/CameraError;", "disconnect-TPqeGZw", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface VirtualCamera {
    /* JADX INFO: renamed from: disconnect-TPqeGZw, reason: not valid java name */
    void mo909disconnectTPqeGZw(CameraError lastCameraError);

    Flow<CameraState> getState();

    CameraState getValue();

    /* JADX INFO: compiled from: VirtualCamera.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX INFO: renamed from: disconnect-TPqeGZw$default, reason: not valid java name */
    static /* synthetic */ void m908disconnectTPqeGZw$default(VirtualCamera virtualCamera, CameraError cameraError, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disconnect-TPqeGZw");
        }
        if ((i & 1) != 0) {
            cameraError = null;
        }
        virtualCamera.mo909disconnectTPqeGZw(cameraError);
    }
}
