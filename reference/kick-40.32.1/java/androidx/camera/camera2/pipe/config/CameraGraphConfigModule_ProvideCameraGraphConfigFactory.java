package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraGraph;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraGraphConfigModule_ProvideCameraGraphConfigFactory implements Factory<CameraGraph.Config> {
    private final CameraGraphConfigModule module;

    private CameraGraphConfigModule_ProvideCameraGraphConfigFactory(CameraGraphConfigModule cameraGraphConfigModule) {
        this.module = cameraGraphConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraGraph.Config get() {
        return provideCameraGraphConfig(this.module);
    }

    public static CameraGraphConfigModule_ProvideCameraGraphConfigFactory create(CameraGraphConfigModule cameraGraphConfigModule) {
        return new CameraGraphConfigModule_ProvideCameraGraphConfigFactory(cameraGraphConfigModule);
    }

    public static CameraGraph.Config provideCameraGraphConfig(CameraGraphConfigModule cameraGraphConfigModule) {
        return (CameraGraph.Config) Preconditions.checkNotNullFromProvides(cameraGraphConfigModule.getConfig());
    }
}
