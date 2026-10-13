package androidx.camera.camera2.config;

import androidx.camera.camera2.adapter.ZslControl;
import androidx.camera.camera2.impl.CameraProperties;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraModule_Companion_ProvideZslControlFactory implements Factory<ZslControl> {
    private final Provider<CameraProperties> cameraPropertiesProvider;

    private CameraModule_Companion_ProvideZslControlFactory(Provider<CameraProperties> provider) {
        this.cameraPropertiesProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ZslControl get() {
        return provideZslControl(this.cameraPropertiesProvider.get());
    }

    public static CameraModule_Companion_ProvideZslControlFactory create(Provider<CameraProperties> provider) {
        return new CameraModule_Companion_ProvideZslControlFactory(provider);
    }

    public static ZslControl provideZslControl(CameraProperties cameraProperties) {
        return (ZslControl) Preconditions.checkNotNullFromProvides(CameraModule.INSTANCE.provideZslControl(cameraProperties));
    }
}
