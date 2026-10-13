package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2ControllerConfig_ProvideStreamGraphFactory implements Factory<StreamGraphImpl> {
    private final Camera2ControllerConfig module;

    private Camera2ControllerConfig_ProvideStreamGraphFactory(Camera2ControllerConfig camera2ControllerConfig) {
        this.module = camera2ControllerConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public StreamGraphImpl get() {
        return provideStreamGraph(this.module);
    }

    public static Camera2ControllerConfig_ProvideStreamGraphFactory create(Camera2ControllerConfig camera2ControllerConfig) {
        return new Camera2ControllerConfig_ProvideStreamGraphFactory(camera2ControllerConfig);
    }

    public static StreamGraphImpl provideStreamGraph(Camera2ControllerConfig camera2ControllerConfig) {
        return (StreamGraphImpl) Preconditions.checkNotNullFromProvides(camera2ControllerConfig.provideStreamGraph());
    }
}
