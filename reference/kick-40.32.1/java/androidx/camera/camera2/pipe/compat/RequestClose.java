package androidx.camera.camera2.pipe.compat;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2DeviceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/compat/RequestClose;", "Landroidx/camera/camera2/pipe/compat/CameraRequest;", "activeCamera", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "<init>", "(Landroidx/camera/camera2/pipe/compat/ActiveCamera;)V", "getActiveCamera", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RequestClose extends CameraRequest {
    private final ActiveCamera activeCamera;

    public static /* synthetic */ RequestClose copy$default(RequestClose requestClose, ActiveCamera activeCamera, int i, Object obj) {
        if ((i & 1) != 0) {
            activeCamera = requestClose.activeCamera;
        }
        return requestClose.copy(activeCamera);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ActiveCamera getActiveCamera() {
        return this.activeCamera;
    }

    public final RequestClose copy(ActiveCamera activeCamera) {
        Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
        return new RequestClose(activeCamera);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RequestClose) && Intrinsics.areEqual(this.activeCamera, ((RequestClose) other).activeCamera);
    }

    public int hashCode() {
        return this.activeCamera.hashCode();
    }

    public String toString() {
        return "RequestClose(activeCamera=" + this.activeCamera + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestClose(ActiveCamera activeCamera) {
        super(null);
        Intrinsics.checkNotNullParameter(activeCamera, "activeCamera");
        this.activeCamera = activeCamera;
    }

    public final ActiveCamera getActiveCamera() {
        return this.activeCamera;
    }
}
