package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraPipe;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideCameraMetadataConfigFactory implements Factory<CameraPipe.CameraMetadataConfig> {
    private final Provider<CameraPipe.Config> configProvider;

    private CameraPipeModule_Companion_ProvideCameraMetadataConfigFactory(Provider<CameraPipe.Config> provider) {
        this.configProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraPipe.CameraMetadataConfig get() {
        return provideCameraMetadataConfig(this.configProvider.get());
    }

    public static CameraPipeModule_Companion_ProvideCameraMetadataConfigFactory create(Provider<CameraPipe.Config> provider) {
        return new CameraPipeModule_Companion_ProvideCameraMetadataConfigFactory(provider);
    }

    public static CameraPipe.CameraMetadataConfig provideCameraMetadataConfig(CameraPipe.Config config) {
        return (CameraPipe.CameraMetadataConfig) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideCameraMetadataConfig(config));
    }
}
