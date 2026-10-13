package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirtualCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\b\tJ\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\b\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CameraStateClosing;", "Landroidx/camera/camera2/pipe/compat/CameraState;", "cameraErrorCode", "Landroidx/camera/camera2/pipe/CameraError;", "<init>", "(Landroidx/camera/camera2/pipe/CameraError;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCameraErrorCode-mVEW8x0", "()Landroidx/camera/camera2/pipe/CameraError;", "component1", "component1-mVEW8x0", "copy", "copy-TPqeGZw", "equals", "", "other", "", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CameraStateClosing extends CameraState {
    private final CameraError cameraErrorCode;

    public /* synthetic */ CameraStateClosing(CameraError cameraError, DefaultConstructorMarker defaultConstructorMarker) {
        this(cameraError);
    }

    /* JADX INFO: renamed from: copy-TPqeGZw$default, reason: not valid java name */
    public static /* synthetic */ CameraStateClosing m867copyTPqeGZw$default(CameraStateClosing cameraStateClosing, CameraError cameraError, int i, Object obj) {
        if ((i & 1) != 0) {
            cameraError = cameraStateClosing.cameraErrorCode;
        }
        return cameraStateClosing.m869copyTPqeGZw(cameraError);
    }

    /* JADX INFO: renamed from: component1-mVEW8x0, reason: not valid java name and from getter */
    public final CameraError getCameraErrorCode() {
        return this.cameraErrorCode;
    }

    /* JADX INFO: renamed from: copy-TPqeGZw, reason: not valid java name */
    public final CameraStateClosing m869copyTPqeGZw(CameraError cameraErrorCode) {
        return new CameraStateClosing(cameraErrorCode, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CameraStateClosing) && Intrinsics.areEqual(this.cameraErrorCode, ((CameraStateClosing) other).cameraErrorCode);
    }

    public int hashCode() {
        CameraError cameraError = this.cameraErrorCode;
        if (cameraError == null) {
            return 0;
        }
        return CameraError.m355hashCodeimpl(cameraError.m358unboximpl());
    }

    public String toString() {
        return "CameraStateClosing(cameraErrorCode=" + this.cameraErrorCode + ')';
    }

    private CameraStateClosing(CameraError cameraError) {
        super(null);
        this.cameraErrorCode = cameraError;
    }

    public /* synthetic */ CameraStateClosing(CameraError cameraError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cameraError, null);
    }

    /* JADX INFO: renamed from: getCameraErrorCode-mVEW8x0, reason: not valid java name */
    public final CameraError m870getCameraErrorCodemVEW8x0() {
        return this.cameraErrorCode;
    }
}
