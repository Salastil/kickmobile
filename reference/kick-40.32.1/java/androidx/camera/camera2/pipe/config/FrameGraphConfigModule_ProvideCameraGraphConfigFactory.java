package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.FrameGraph;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphConfigModule_ProvideCameraGraphConfigFactory implements Factory<FrameGraph.Config> {
    private final FrameGraphConfigModule module;

    private FrameGraphConfigModule_ProvideCameraGraphConfigFactory(FrameGraphConfigModule frameGraphConfigModule) {
        this.module = frameGraphConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FrameGraph.Config get() {
        return provideCameraGraphConfig(this.module);
    }

    public static FrameGraphConfigModule_ProvideCameraGraphConfigFactory create(FrameGraphConfigModule frameGraphConfigModule) {
        return new FrameGraphConfigModule_ProvideCameraGraphConfigFactory(frameGraphConfigModule);
    }

    public static FrameGraph.Config provideCameraGraphConfig(FrameGraphConfigModule frameGraphConfigModule) {
        return (FrameGraph.Config) Preconditions.checkNotNullFromProvides(frameGraphConfigModule.getConfig());
    }
}
