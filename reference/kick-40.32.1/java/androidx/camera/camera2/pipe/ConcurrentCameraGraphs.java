package androidx.camera.camera2.pipe;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConcurrentCameraGraphs.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/ConcurrentCameraGraphs;", "", "cameraGraphIds", "", "Landroidx/camera/camera2/pipe/CameraGraphId;", "cameraIds", "Landroidx/camera/camera2/pipe/CameraId;", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "getCameraGraphIds", "()Ljava/util/Set;", "getCameraIds", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ConcurrentCameraGraphs {
    private final Set<CameraGraphId> cameraGraphIds;
    private final Set<CameraId> cameraIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConcurrentCameraGraphs copy$default(ConcurrentCameraGraphs concurrentCameraGraphs, Set set, Set set2, int i, Object obj) {
        if ((i & 1) != 0) {
            set = concurrentCameraGraphs.cameraGraphIds;
        }
        if ((i & 2) != 0) {
            set2 = concurrentCameraGraphs.cameraIds;
        }
        return concurrentCameraGraphs.copy(set, set2);
    }

    public final Set<CameraGraphId> component1() {
        return this.cameraGraphIds;
    }

    public final Set<CameraId> component2() {
        return this.cameraIds;
    }

    public final ConcurrentCameraGraphs copy(Set<CameraGraphId> cameraGraphIds, Set<CameraId> cameraIds) {
        Intrinsics.checkNotNullParameter(cameraGraphIds, "cameraGraphIds");
        Intrinsics.checkNotNullParameter(cameraIds, "cameraIds");
        return new ConcurrentCameraGraphs(cameraGraphIds, cameraIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConcurrentCameraGraphs)) {
            return false;
        }
        ConcurrentCameraGraphs concurrentCameraGraphs = (ConcurrentCameraGraphs) other;
        return Intrinsics.areEqual(this.cameraGraphIds, concurrentCameraGraphs.cameraGraphIds) && Intrinsics.areEqual(this.cameraIds, concurrentCameraGraphs.cameraIds);
    }

    public int hashCode() {
        return (this.cameraGraphIds.hashCode() * 31) + this.cameraIds.hashCode();
    }

    public String toString() {
        return "ConcurrentCameraGraphs(cameraGraphIds=" + this.cameraGraphIds + ", cameraIds=" + this.cameraIds + ')';
    }

    public ConcurrentCameraGraphs(Set<CameraGraphId> cameraGraphIds, Set<CameraId> cameraIds) {
        Intrinsics.checkNotNullParameter(cameraGraphIds, "cameraGraphIds");
        Intrinsics.checkNotNullParameter(cameraIds, "cameraIds");
        this.cameraGraphIds = cameraGraphIds;
        this.cameraIds = cameraIds;
        if (cameraGraphIds.size() <= 1) {
            throw new IllegalStateException("Check failed.");
        }
        if (cameraGraphIds.size() != cameraIds.size()) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final Set<CameraGraphId> getCameraGraphIds() {
        return this.cameraGraphIds;
    }

    public final Set<CameraId> getCameraIds() {
        return this.cameraIds;
    }
}
