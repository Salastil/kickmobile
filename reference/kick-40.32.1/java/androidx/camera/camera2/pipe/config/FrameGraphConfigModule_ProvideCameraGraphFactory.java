package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraGraph;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphConfigModule_ProvideCameraGraphFactory implements Factory<CameraGraph> {
    private final FrameGraphConfigModule module;

    private FrameGraphConfigModule_ProvideCameraGraphFactory(FrameGraphConfigModule frameGraphConfigModule) {
        this.module = frameGraphConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraGraph get() {
        return provideCameraGraph(this.module);
    }

    public static FrameGraphConfigModule_ProvideCameraGraphFactory create(FrameGraphConfigModule frameGraphConfigModule) {
        return new FrameGraphConfigModule_ProvideCameraGraphFactory(frameGraphConfigModule);
    }

    public static CameraGraph provideCameraGraph(FrameGraphConfigModule frameGraphConfigModule) {
        return (CameraGraph) Preconditions.checkNotNullFromProvides(frameGraphConfigModule.provideCameraGraph());
    }
}
