package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.compat.Camera2CameraController;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ControllerConfig_ProvideShutdownListenerFactory implements Factory<Camera2CameraController.ShutdownListener> {
    private final Camera2ControllerConfig module;

    private Camera2ControllerConfig_ProvideShutdownListenerFactory(Camera2ControllerConfig camera2ControllerConfig) {
        this.module = camera2ControllerConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2CameraController.ShutdownListener get() {
        return provideShutdownListener(this.module);
    }

    public static Camera2ControllerConfig_ProvideShutdownListenerFactory create(Camera2ControllerConfig camera2ControllerConfig) {
        return new Camera2ControllerConfig_ProvideShutdownListenerFactory(camera2ControllerConfig);
    }

    public static Camera2CameraController.ShutdownListener provideShutdownListener(Camera2ControllerConfig camera2ControllerConfig) {
        return (Camera2CameraController.ShutdownListener) Preconditions.checkNotNullFromProvides(camera2ControllerConfig.getShutdownListener());
    }
}
