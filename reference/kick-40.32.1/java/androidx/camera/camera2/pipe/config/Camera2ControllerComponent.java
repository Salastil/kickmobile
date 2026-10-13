package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.compat.Camera2CaptureSessionsModule;
import dagger.Subcomponent;
import kotlin.Metadata;

/* JADX INFO: compiled from: Camera2Component.kt */
/* JADX INFO: loaded from: classes.dex */
@Subcomponent(modules = {Camera2ControllerConfig.class, Camera2ControllerModule.class, Camera2CaptureSessionsModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/config/Camera2ControllerComponent;", "", "cameraController", "Landroidx/camera/camera2/pipe/CameraController;", "Builder", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Camera2ControllerScope
public interface Camera2ControllerComponent {

    /* JADX INFO: compiled from: Camera2Component.kt */
    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/config/Camera2ControllerComponent$Builder;", "", "camera2ControllerConfig", "config", "Landroidx/camera/camera2/pipe/config/Camera2ControllerConfig;", "build", "Landroidx/camera/camera2/pipe/config/Camera2ControllerComponent;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Builder {
        Camera2ControllerComponent build();

        Builder camera2ControllerConfig(Camera2ControllerConfig config);
    }

    CameraController cameraController();
}
