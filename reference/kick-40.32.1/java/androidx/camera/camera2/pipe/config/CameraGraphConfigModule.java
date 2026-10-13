package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraGraphComponent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0007J\b\u0010\t\u001a\u00020\u0005H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/config/CameraGraphConfigModule;", "", "config", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "cameraGraphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph$Config;Landroidx/camera/camera2/pipe/CameraGraphId;)V", "provideCameraGraphConfig", "provideCameraGraphId", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public final class CameraGraphConfigModule {
    private final CameraGraphId cameraGraphId;
    private final CameraGraph.Config config;

    public CameraGraphConfigModule(CameraGraph.Config config, CameraGraphId cameraGraphId) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(cameraGraphId, "cameraGraphId");
        this.config = config;
        this.cameraGraphId = cameraGraphId;
    }

    @Provides
    /* JADX INFO: renamed from: provideCameraGraphConfig, reason: from getter */
    public final CameraGraph.Config getConfig() {
        return this.config;
    }

    @Provides
    /* JADX INFO: renamed from: provideCameraGraphId, reason: from getter */
    public final CameraGraphId getCameraGraphId() {
        return this.cameraGraphId;
    }
}
