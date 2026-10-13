package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AwaitOpenCameraResult;", "", "cameraDeviceWrapper", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "androidCameraState", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;Landroidx/camera/camera2/pipe/compat/AndroidCameraState;)V", "getCameraDeviceWrapper", "()Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "getAndroidCameraState", "()Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AwaitOpenCameraResult {
    private final AndroidCameraState androidCameraState;
    private final CameraDeviceWrapper cameraDeviceWrapper;

    /* JADX WARN: Multi-variable type inference failed */
    public AwaitOpenCameraResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AwaitOpenCameraResult copy$default(AwaitOpenCameraResult awaitOpenCameraResult, CameraDeviceWrapper cameraDeviceWrapper, AndroidCameraState androidCameraState, int i, Object obj) {
        if ((i & 1) != 0) {
            cameraDeviceWrapper = awaitOpenCameraResult.cameraDeviceWrapper;
        }
        if ((i & 2) != 0) {
            androidCameraState = awaitOpenCameraResult.androidCameraState;
        }
        return awaitOpenCameraResult.copy(cameraDeviceWrapper, androidCameraState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CameraDeviceWrapper getCameraDeviceWrapper() {
        return this.cameraDeviceWrapper;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AndroidCameraState getAndroidCameraState() {
        return this.androidCameraState;
    }

    public final AwaitOpenCameraResult copy(CameraDeviceWrapper cameraDeviceWrapper, AndroidCameraState androidCameraState) {
        return new AwaitOpenCameraResult(cameraDeviceWrapper, androidCameraState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwaitOpenCameraResult)) {
            return false;
        }
        AwaitOpenCameraResult awaitOpenCameraResult = (AwaitOpenCameraResult) other;
        return Intrinsics.areEqual(this.cameraDeviceWrapper, awaitOpenCameraResult.cameraDeviceWrapper) && Intrinsics.areEqual(this.androidCameraState, awaitOpenCameraResult.androidCameraState);
    }

    public int hashCode() {
        CameraDeviceWrapper cameraDeviceWrapper = this.cameraDeviceWrapper;
        int iHashCode = (cameraDeviceWrapper == null ? 0 : cameraDeviceWrapper.hashCode()) * 31;
        AndroidCameraState androidCameraState = this.androidCameraState;
        return iHashCode + (androidCameraState != null ? androidCameraState.hashCode() : 0);
    }

    public String toString() {
        return "AwaitOpenCameraResult(cameraDeviceWrapper=" + this.cameraDeviceWrapper + ", androidCameraState=" + this.androidCameraState + ')';
    }

    public AwaitOpenCameraResult(CameraDeviceWrapper cameraDeviceWrapper, AndroidCameraState androidCameraState) {
        this.cameraDeviceWrapper = cameraDeviceWrapper;
        this.androidCameraState = androidCameraState;
    }

    public /* synthetic */ AwaitOpenCameraResult(CameraDeviceWrapper cameraDeviceWrapper, AndroidCameraState androidCameraState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cameraDeviceWrapper, (i & 2) != 0 ? null : androidCameraState);
    }

    public final CameraDeviceWrapper getCameraDeviceWrapper() {
        return this.cameraDeviceWrapper;
    }

    public final AndroidCameraState getAndroidCameraState() {
        return this.androidCameraState;
    }
}
