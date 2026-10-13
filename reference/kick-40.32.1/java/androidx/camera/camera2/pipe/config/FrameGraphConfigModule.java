package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.FrameGraph;
import androidx.camera.camera2.pipe.graph.Controller3A;
import androidx.camera.camera2.pipe.graph.GraphProcessor;
import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameGraphComponent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/camera/camera2/pipe/config/FrameGraphConfigModule;", "", "cameraGraphComponent", "Landroidx/camera/camera2/pipe/config/CameraGraphComponent;", "config", "Landroidx/camera/camera2/pipe/FrameGraph$Config;", "<init>", "(Landroidx/camera/camera2/pipe/config/CameraGraphComponent;Landroidx/camera/camera2/pipe/FrameGraph$Config;)V", "provideCameraGraphConfig", "provideCameraGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "provideGraphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "provideFrameCaptureQueue", "Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;", "provideSessionLock", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "provideFrameDistributor", "Landroidx/camera/camera2/pipe/internal/FrameDistributor;", "provideController3A", "Landroidx/camera/camera2/pipe/graph/Controller3A;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public final class FrameGraphConfigModule {
    private final CameraGraphComponent cameraGraphComponent;
    private final FrameGraph.Config config;

    public FrameGraphConfigModule(CameraGraphComponent cameraGraphComponent, FrameGraph.Config config) {
        Intrinsics.checkNotNullParameter(cameraGraphComponent, "cameraGraphComponent");
        Intrinsics.checkNotNullParameter(config, "config");
        this.cameraGraphComponent = cameraGraphComponent;
        this.config = config;
    }

    @Provides
    /* JADX INFO: renamed from: provideCameraGraphConfig, reason: from getter */
    public final FrameGraph.Config getConfig() {
        return this.config;
    }

    @Provides
    public final CameraGraph provideCameraGraph() {
        return this.cameraGraphComponent.cameraGraph();
    }

    @Provides
    public final GraphProcessor provideGraphProcessor() {
        return this.cameraGraphComponent.graphProcessor();
    }

    @Provides
    public final FrameCaptureQueue provideFrameCaptureQueue() {
        return this.cameraGraphComponent.frameCaptureQueue();
    }

    @Provides
    public final GraphSessionLock provideSessionLock() {
        return this.cameraGraphComponent.sessionLock();
    }

    @Provides
    public final FrameDistributor provideFrameDistributor() {
        return this.cameraGraphComponent.frameDistributor();
    }

    @Provides
    public final Controller3A provideController3A() {
        return this.cameraGraphComponent.controller3A();
    }
}
