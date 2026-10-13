package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\b\u000eJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\b\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/compat/OpenCameraResult;", "", "cameraState", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "errorCode", "Landroidx/camera/camera2/pipe/CameraError;", "<init>", "(Landroidx/camera/camera2/pipe/compat/AndroidCameraState;Landroidx/camera/camera2/pipe/CameraError;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCameraState", "()Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "getErrorCode-mVEW8x0", "()Landroidx/camera/camera2/pipe/CameraError;", "component1", "component2", "component2-mVEW8x0", "copy", "copy-8d-yNqA", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class OpenCameraResult {
    private final AndroidCameraState cameraState;
    private final CameraError errorCode;

    public /* synthetic */ OpenCameraResult(AndroidCameraState androidCameraState, CameraError cameraError, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidCameraState, cameraError);
    }

    /* JADX INFO: renamed from: copy-8d-yNqA$default, reason: not valid java name */
    public static /* synthetic */ OpenCameraResult m876copy8dyNqA$default(OpenCameraResult openCameraResult, AndroidCameraState androidCameraState, CameraError cameraError, int i, Object obj) {
        if ((i & 1) != 0) {
            androidCameraState = openCameraResult.cameraState;
        }
        if ((i & 2) != 0) {
            cameraError = openCameraResult.errorCode;
        }
        return openCameraResult.m878copy8dyNqA(androidCameraState, cameraError);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AndroidCameraState getCameraState() {
        return this.cameraState;
    }

    /* JADX INFO: renamed from: component2-mVEW8x0, reason: not valid java name and from getter */
    public final CameraError getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: copy-8d-yNqA, reason: not valid java name */
    public final OpenCameraResult m878copy8dyNqA(AndroidCameraState cameraState, CameraError errorCode) {
        return new OpenCameraResult(cameraState, errorCode, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenCameraResult)) {
            return false;
        }
        OpenCameraResult openCameraResult = (OpenCameraResult) other;
        return Intrinsics.areEqual(this.cameraState, openCameraResult.cameraState) && Intrinsics.areEqual(this.errorCode, openCameraResult.errorCode);
    }

    public int hashCode() {
        AndroidCameraState androidCameraState = this.cameraState;
        int iHashCode = (androidCameraState == null ? 0 : androidCameraState.hashCode()) * 31;
        CameraError cameraError = this.errorCode;
        return iHashCode + (cameraError != null ? CameraError.m355hashCodeimpl(cameraError.m358unboximpl()) : 0);
    }

    public String toString() {
        return "OpenCameraResult(cameraState=" + this.cameraState + ", errorCode=" + this.errorCode + ')';
    }

    private OpenCameraResult(AndroidCameraState androidCameraState, CameraError cameraError) {
        this.cameraState = androidCameraState;
        this.errorCode = cameraError;
    }

    public /* synthetic */ OpenCameraResult(AndroidCameraState androidCameraState, CameraError cameraError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : androidCameraState, (i & 2) != 0 ? null : cameraError, null);
    }

    public final AndroidCameraState getCameraState() {
        return this.cameraState;
    }

    /* JADX INFO: renamed from: getErrorCode-mVEW8x0, reason: not valid java name */
    public final CameraError m879getErrorCodemVEW8x0() {
        return this.errorCode;
    }
}
