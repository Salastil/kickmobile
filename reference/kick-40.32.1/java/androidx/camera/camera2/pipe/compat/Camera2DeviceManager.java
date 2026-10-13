package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.graph.GraphListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: Camera2DeviceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2DeviceManager;", "", "open", "Landroidx/camera/camera2/pipe/compat/VirtualCamera;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "sharedCameraIds", "", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "isPrewarm", "", "isForegroundObserver", "Lkotlin/Function1;", "", "open-zDSwpeU", "(Ljava/lang/String;Ljava/util/List;Landroidx/camera/camera2/pipe/graph/GraphListener;ZLkotlin/jvm/functions/Function1;)Landroidx/camera/camera2/pipe/compat/VirtualCamera;", "prewarm", "prewarm-EfqyGwQ", "(Ljava/lang/String;)V", "close", "Lkotlinx/coroutines/Deferred;", "close-EfqyGwQ", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "closeAll", "forceCancelOpen", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Camera2DeviceManager {
    /* JADX INFO: renamed from: close-EfqyGwQ, reason: not valid java name */
    Deferred<Unit> mo834closeEfqyGwQ(String cameraId);

    Deferred<Unit> closeAll(boolean forceCancelOpen);

    /* JADX INFO: renamed from: open-zDSwpeU, reason: not valid java name */
    VirtualCamera mo835openzDSwpeU(String cameraId, List<CameraId> sharedCameraIds, GraphListener graphListener, boolean isPrewarm, Function1<? super Unit, Boolean> isForegroundObserver);

    /* JADX INFO: renamed from: prewarm-EfqyGwQ, reason: not valid java name */
    void mo836prewarmEfqyGwQ(String cameraId);

    static /* synthetic */ Deferred closeAll$default(Camera2DeviceManager camera2DeviceManager, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeAll");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return camera2DeviceManager.closeAll(z);
    }
}
