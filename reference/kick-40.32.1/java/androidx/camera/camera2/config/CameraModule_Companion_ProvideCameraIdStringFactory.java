package androidx.camera.camera2.config;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraModule_Companion_ProvideCameraIdStringFactory implements Factory<String> {
    private final Provider<CameraConfig> configProvider;

    private CameraModule_Companion_ProvideCameraIdStringFactory(Provider<CameraConfig> provider) {
        this.configProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public String get() {
        return provideCameraIdString(this.configProvider.get());
    }

    public static CameraModule_Companion_ProvideCameraIdStringFactory create(Provider<CameraConfig> provider) {
        return new CameraModule_Companion_ProvideCameraIdStringFactory(provider);
    }

    public static String provideCameraIdString(CameraConfig cameraConfig) {
        return (String) Preconditions.checkNotNullFromProvides(CameraModule.INSTANCE.provideCameraIdString(cameraConfig));
    }
}
