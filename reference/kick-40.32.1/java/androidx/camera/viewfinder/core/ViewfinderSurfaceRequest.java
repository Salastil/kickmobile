package androidx.camera.viewfinder.core;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewfinderSurfaceRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J2\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/camera/viewfinder/core/ViewfinderSurfaceRequest;", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "implementationMode", "Landroidx/camera/viewfinder/core/ImplementationMode;", "requestId", "", "<init>", "(IILandroidx/camera/viewfinder/core/ImplementationMode;Ljava/lang/String;)V", "getWidth", "()I", "getHeight", "getImplementationMode", "()Landroidx/camera/viewfinder/core/ImplementationMode;", "getRequestId", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "toString", "copy", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewfinderSurfaceRequest {
    private final int height;
    private final ImplementationMode implementationMode;
    private final String requestId;
    private final int width;

    public ViewfinderSurfaceRequest(int i, int i2) {
        this(i, i2, null, null, 12, null);
    }

    public ViewfinderSurfaceRequest(int i, int i2, ImplementationMode implementationMode) {
        this(i, i2, implementationMode, null, 8, null);
    }

    public ViewfinderSurfaceRequest(int i, int i2, ImplementationMode implementationMode, String str) {
        this.width = i;
        this.height = i2;
        this.implementationMode = implementationMode;
        this.requestId = str;
    }

    public /* synthetic */ ViewfinderSurfaceRequest(int i, int i2, ImplementationMode implementationMode, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : implementationMode, (i3 & 8) != 0 ? null : str);
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final ImplementationMode getImplementationMode() {
        return this.implementationMode;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewfinderSurfaceRequest)) {
            return false;
        }
        ViewfinderSurfaceRequest viewfinderSurfaceRequest = (ViewfinderSurfaceRequest) other;
        return this.width == viewfinderSurfaceRequest.width && this.height == viewfinderSurfaceRequest.height && this.implementationMode == viewfinderSurfaceRequest.implementationMode && Intrinsics.areEqual(this.requestId, viewfinderSurfaceRequest.requestId);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31;
        ImplementationMode implementationMode = this.implementationMode;
        int iHashCode2 = (iHashCode + (implementationMode != null ? implementationMode.hashCode() : 0)) * 31;
        String str = this.requestId;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ViewfinderSurfaceRequest(width=" + this.width + ", height=" + this.height + ", implementationMode=" + this.implementationMode + ", requestId=" + this.requestId + ')';
    }

    public static /* synthetic */ ViewfinderSurfaceRequest copy$default(ViewfinderSurfaceRequest viewfinderSurfaceRequest, int i, int i2, ImplementationMode implementationMode, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = viewfinderSurfaceRequest.width;
        }
        if ((i3 & 2) != 0) {
            i2 = viewfinderSurfaceRequest.height;
        }
        if ((i3 & 4) != 0) {
            implementationMode = viewfinderSurfaceRequest.implementationMode;
        }
        if ((i3 & 8) != 0) {
            str = viewfinderSurfaceRequest.requestId;
        }
        return viewfinderSurfaceRequest.copy(i, i2, implementationMode, str);
    }

    public final /* synthetic */ ViewfinderSurfaceRequest copy(int width, int height, ImplementationMode implementationMode, String requestId) {
        return new ViewfinderSurfaceRequest(width, height, implementationMode, requestId);
    }
}
