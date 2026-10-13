package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.SurfaceTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ControllerConfig_ProvideSurfaceGraphFactory implements Factory<SurfaceTracker> {
    private final Camera2ControllerConfig module;

    private Camera2ControllerConfig_ProvideSurfaceGraphFactory(Camera2ControllerConfig camera2ControllerConfig) {
        this.module = camera2ControllerConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SurfaceTracker get() {
        return provideSurfaceGraph(this.module);
    }

    public static Camera2ControllerConfig_ProvideSurfaceGraphFactory create(Camera2ControllerConfig camera2ControllerConfig) {
        return new Camera2ControllerConfig_ProvideSurfaceGraphFactory(camera2ControllerConfig);
    }

    public static SurfaceTracker provideSurfaceGraph(Camera2ControllerConfig camera2ControllerConfig) {
        return (SurfaceTracker) Preconditions.checkNotNullFromProvides(camera2ControllerConfig.getSurfaceTracker());
    }
}
