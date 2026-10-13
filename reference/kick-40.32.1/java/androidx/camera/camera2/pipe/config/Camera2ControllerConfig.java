package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.SurfaceTracker;
import androidx.camera.camera2.pipe.compat.Camera2CameraController;
import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2Component.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0007H\u0007J\b\u0010\u0013\u001a\u00020\u0005H\u0007J\b\u0010\u0014\u001a\u00020\u0003H\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0007J\b\u0010\u0018\u001a\u00020\rH\u0007J\b\u0010\u0019\u001a\u00020\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/pipe/config/Camera2ControllerConfig;", "", "cameraBackend", "Landroidx/camera/camera2/pipe/CameraBackend;", "graphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "streamGraph", "Landroidx/camera/camera2/pipe/StreamGraph;", "surfaceTracker", "Landroidx/camera/camera2/pipe/SurfaceTracker;", "shutdownListener", "Landroidx/camera/camera2/pipe/compat/Camera2CameraController$ShutdownListener;", "<init>", "(Landroidx/camera/camera2/pipe/CameraBackend;Landroidx/camera/camera2/pipe/CameraGraphId;Landroidx/camera/camera2/pipe/CameraGraph$Config;Landroidx/camera/camera2/pipe/graph/GraphListener;Landroidx/camera/camera2/pipe/StreamGraph;Landroidx/camera/camera2/pipe/SurfaceTracker;Landroidx/camera/camera2/pipe/compat/Camera2CameraController$ShutdownListener;)V", "provideCameraGraphConfig", "provideCameraGraphId", "provideCameraBackend", "provideStreamGraph", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "provideGraphListener", "provideSurfaceGraph", "provideShutdownListener", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public final class Camera2ControllerConfig {
    private final CameraBackend cameraBackend;
    private final CameraGraph.Config graphConfig;
    private final CameraGraphId graphId;
    private final GraphListener graphListener;
    private final Camera2CameraController.ShutdownListener shutdownListener;
    private final StreamGraph streamGraph;
    private final SurfaceTracker surfaceTracker;

    public Camera2ControllerConfig(CameraBackend cameraBackend, CameraGraphId graphId, CameraGraph.Config graphConfig, GraphListener graphListener, StreamGraph streamGraph, SurfaceTracker surfaceTracker, Camera2CameraController.ShutdownListener shutdownListener) {
        Intrinsics.checkNotNullParameter(cameraBackend, "cameraBackend");
        Intrinsics.checkNotNullParameter(graphId, "graphId");
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        Intrinsics.checkNotNullParameter(surfaceTracker, "surfaceTracker");
        Intrinsics.checkNotNullParameter(shutdownListener, "shutdownListener");
        this.cameraBackend = cameraBackend;
        this.graphId = graphId;
        this.graphConfig = graphConfig;
        this.graphListener = graphListener;
        this.streamGraph = streamGraph;
        this.surfaceTracker = surfaceTracker;
        this.shutdownListener = shutdownListener;
    }

    @Provides
    /* JADX INFO: renamed from: provideCameraGraphConfig, reason: from getter */
    public final CameraGraph.Config getGraphConfig() {
        return this.graphConfig;
    }

    @Provides
    /* JADX INFO: renamed from: provideCameraGraphId, reason: from getter */
    public final CameraGraphId getGraphId() {
        return this.graphId;
    }

    @Provides
    /* JADX INFO: renamed from: provideCameraBackend, reason: from getter */
    public final CameraBackend getCameraBackend() {
        return this.cameraBackend;
    }

    @Provides
    public final StreamGraphImpl provideStreamGraph() {
        StreamGraph streamGraph = this.streamGraph;
        Intrinsics.checkNotNull(streamGraph, "null cannot be cast to non-null type androidx.camera.camera2.pipe.graph.StreamGraphImpl");
        return (StreamGraphImpl) streamGraph;
    }

    @Provides
    /* JADX INFO: renamed from: provideGraphListener, reason: from getter */
    public final GraphListener getGraphListener() {
        return this.graphListener;
    }

    @Provides
    /* JADX INFO: renamed from: provideSurfaceGraph, reason: from getter */
    public final SurfaceTracker getSurfaceTracker() {
        return this.surfaceTracker;
    }

    @Provides
    /* JADX INFO: renamed from: provideShutdownListener, reason: from getter */
    public final Camera2CameraController.ShutdownListener getShutdownListener() {
        return this.shutdownListener;
    }
}
