package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraPipe;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeConfigModule_ProvideCameraInteropConfigFactory implements Factory<CameraPipe.CameraInteropConfig> {
    private final Provider<CameraPipe.Config> cameraPipeConfigProvider;
    private final CameraPipeConfigModule module;

    private CameraPipeConfigModule_ProvideCameraInteropConfigFactory(CameraPipeConfigModule cameraPipeConfigModule, Provider<CameraPipe.Config> provider) {
        this.module = cameraPipeConfigModule;
        this.cameraPipeConfigProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraPipe.CameraInteropConfig get() {
        return provideCameraInteropConfig(this.module, this.cameraPipeConfigProvider.get());
    }

    public static CameraPipeConfigModule_ProvideCameraInteropConfigFactory create(CameraPipeConfigModule cameraPipeConfigModule, Provider<CameraPipe.Config> provider) {
        return new CameraPipeConfigModule_ProvideCameraInteropConfigFactory(cameraPipeConfigModule, provider);
    }

    public static CameraPipe.CameraInteropConfig provideCameraInteropConfig(CameraPipeConfigModule cameraPipeConfigModule, CameraPipe.Config config) {
        return (CameraPipe.CameraInteropConfig) Preconditions.checkNotNullFromProvides(cameraPipeConfigModule.provideCameraInteropConfig(config));
    }
}
