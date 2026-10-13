package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.graph.GraphListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2DeviceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fHÆ\u0003JM\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017¨\u0006%"}, d2 = {"Landroidx/camera/camera2/pipe/compat/RequestOpen;", "Landroidx/camera/camera2/pipe/compat/CameraRequest;", "virtualCamera", "Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", "sharedCameraIds", "", "Landroidx/camera/camera2/pipe/CameraId;", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "isPrewarm", "", "isForegroundObserver", "Lkotlin/Function1;", "", "<init>", "(Landroidx/camera/camera2/pipe/compat/VirtualCameraState;Ljava/util/List;Landroidx/camera/camera2/pipe/graph/GraphListener;ZLkotlin/jvm/functions/Function1;)V", "getVirtualCamera", "()Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", "getSharedCameraIds", "()Ljava/util/List;", "getGraphListener", "()Landroidx/camera/camera2/pipe/graph/GraphListener;", "()Z", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RequestOpen extends CameraRequest {
    private final GraphListener graphListener;
    private final Function1<Unit, Boolean> isForegroundObserver;
    private final boolean isPrewarm;
    private final List<CameraId> sharedCameraIds;
    private final VirtualCameraState virtualCamera;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestOpen copy$default(RequestOpen requestOpen, VirtualCameraState virtualCameraState, List list, GraphListener graphListener, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            virtualCameraState = requestOpen.virtualCamera;
        }
        if ((i & 2) != 0) {
            list = requestOpen.sharedCameraIds;
        }
        if ((i & 4) != 0) {
            graphListener = requestOpen.graphListener;
        }
        if ((i & 8) != 0) {
            z = requestOpen.isPrewarm;
        }
        if ((i & 16) != 0) {
            function1 = requestOpen.isForegroundObserver;
        }
        Function1 function2 = function1;
        GraphListener graphListener2 = graphListener;
        return requestOpen.copy(virtualCameraState, list, graphListener2, z, function2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final VirtualCameraState getVirtualCamera() {
        return this.virtualCamera;
    }

    public final List<CameraId> component2() {
        return this.sharedCameraIds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GraphListener getGraphListener() {
        return this.graphListener;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsPrewarm() {
        return this.isPrewarm;
    }

    public final Function1<Unit, Boolean> component5() {
        return this.isForegroundObserver;
    }

    public final RequestOpen copy(VirtualCameraState virtualCamera, List<CameraId> sharedCameraIds, GraphListener graphListener, boolean isPrewarm, Function1<? super Unit, Boolean> isForegroundObserver) {
        Intrinsics.checkNotNullParameter(virtualCamera, "virtualCamera");
        Intrinsics.checkNotNullParameter(sharedCameraIds, "sharedCameraIds");
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(isForegroundObserver, "isForegroundObserver");
        return new RequestOpen(virtualCamera, sharedCameraIds, graphListener, isPrewarm, isForegroundObserver);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestOpen)) {
            return false;
        }
        RequestOpen requestOpen = (RequestOpen) other;
        return Intrinsics.areEqual(this.virtualCamera, requestOpen.virtualCamera) && Intrinsics.areEqual(this.sharedCameraIds, requestOpen.sharedCameraIds) && Intrinsics.areEqual(this.graphListener, requestOpen.graphListener) && this.isPrewarm == requestOpen.isPrewarm && Intrinsics.areEqual(this.isForegroundObserver, requestOpen.isForegroundObserver);
    }

    public int hashCode() {
        return (((((((this.virtualCamera.hashCode() * 31) + this.sharedCameraIds.hashCode()) * 31) + this.graphListener.hashCode()) * 31) + Boolean.hashCode(this.isPrewarm)) * 31) + this.isForegroundObserver.hashCode();
    }

    public String toString() {
        return "RequestOpen(virtualCamera=" + this.virtualCamera + ", sharedCameraIds=" + this.sharedCameraIds + ", graphListener=" + this.graphListener + ", isPrewarm=" + this.isPrewarm + ", isForegroundObserver=" + this.isForegroundObserver + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RequestOpen(VirtualCameraState virtualCamera, List<CameraId> sharedCameraIds, GraphListener graphListener, boolean z, Function1<? super Unit, Boolean> isForegroundObserver) {
        super(null);
        Intrinsics.checkNotNullParameter(virtualCamera, "virtualCamera");
        Intrinsics.checkNotNullParameter(sharedCameraIds, "sharedCameraIds");
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(isForegroundObserver, "isForegroundObserver");
        this.virtualCamera = virtualCamera;
        this.sharedCameraIds = sharedCameraIds;
        this.graphListener = graphListener;
        this.isPrewarm = z;
        this.isForegroundObserver = isForegroundObserver;
    }

    public final VirtualCameraState getVirtualCamera() {
        return this.virtualCamera;
    }

    public final List<CameraId> getSharedCameraIds() {
        return this.sharedCameraIds;
    }

    public final GraphListener getGraphListener() {
        return this.graphListener;
    }

    public final boolean isPrewarm() {
        return this.isPrewarm;
    }

    public final Function1<Unit, Boolean> isForegroundObserver() {
        return this.isForegroundObserver;
    }
}
