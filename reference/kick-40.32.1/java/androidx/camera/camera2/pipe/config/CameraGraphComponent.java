package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.graph.Controller3A;
import androidx.camera.camera2.pipe.graph.GraphProcessor;
import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import dagger.Subcomponent;
import kotlin.Metadata;

/* JADX INFO: compiled from: CameraGraphComponent.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Subcomponent(modules = {SharedCameraGraphModules.class, InternalCameraGraphModules.class, CameraGraphConfigModule.class})
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u000eJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/config/CameraGraphComponent;", "", "cameraGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "graphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "frameCaptureQueue", "Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;", "sessionLock", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "frameDistributor", "Landroidx/camera/camera2/pipe/internal/FrameDistributor;", "controller3A", "Landroidx/camera/camera2/pipe/graph/Controller3A;", "Builder", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraGraphComponent {

    /* JADX INFO: compiled from: CameraGraphComponent.kt */
    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/config/CameraGraphComponent$Builder;", "", "cameraGraphConfigModule", "config", "Landroidx/camera/camera2/pipe/config/CameraGraphConfigModule;", "build", "Landroidx/camera/camera2/pipe/config/CameraGraphComponent;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Builder {
        CameraGraphComponent build();

        Builder cameraGraphConfigModule(CameraGraphConfigModule config);
    }

    CameraGraph cameraGraph();

    Controller3A controller3A();

    FrameCaptureQueue frameCaptureQueue();

    FrameDistributor frameDistributor();

    GraphProcessor graphProcessor();

    GraphSessionLock sessionLock();
}
