package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.graph.GraphListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ControllerConfig_ProvideGraphListenerFactory implements Factory<GraphListener> {
    private final Camera2ControllerConfig module;

    private Camera2ControllerConfig_ProvideGraphListenerFactory(Camera2ControllerConfig camera2ControllerConfig) {
        this.module = camera2ControllerConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GraphListener get() {
        return provideGraphListener(this.module);
    }

    public static Camera2ControllerConfig_ProvideGraphListenerFactory create(Camera2ControllerConfig camera2ControllerConfig) {
        return new Camera2ControllerConfig_ProvideGraphListenerFactory(camera2ControllerConfig);
    }

    public static GraphListener provideGraphListener(Camera2ControllerConfig camera2ControllerConfig) {
        return (GraphListener) Preconditions.checkNotNullFromProvides(camera2ControllerConfig.getGraphListener());
    }
}
