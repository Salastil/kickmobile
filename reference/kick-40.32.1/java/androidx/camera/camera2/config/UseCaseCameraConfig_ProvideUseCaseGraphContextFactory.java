package androidx.camera.camera2.config;

import androidx.camera.camera2.adapter.CameraStateAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UseCaseCameraConfig_ProvideUseCaseGraphContextFactory implements Factory<UseCaseGraphContext> {
    private final Provider<CameraStateAdapter> cameraStateAdapterProvider;
    private final UseCaseCameraConfig module;

    private UseCaseCameraConfig_ProvideUseCaseGraphContextFactory(UseCaseCameraConfig useCaseCameraConfig, Provider<CameraStateAdapter> provider) {
        this.module = useCaseCameraConfig;
        this.cameraStateAdapterProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UseCaseGraphContext get() {
        return provideUseCaseGraphContext(this.module, this.cameraStateAdapterProvider.get());
    }

    public static UseCaseCameraConfig_ProvideUseCaseGraphContextFactory create(UseCaseCameraConfig useCaseCameraConfig, Provider<CameraStateAdapter> provider) {
        return new UseCaseCameraConfig_ProvideUseCaseGraphContextFactory(useCaseCameraConfig, provider);
    }

    public static UseCaseGraphContext provideUseCaseGraphContext(UseCaseCameraConfig useCaseCameraConfig, CameraStateAdapter cameraStateAdapter) {
        return (UseCaseGraphContext) Preconditions.checkNotNullFromProvides(useCaseCameraConfig.provideUseCaseGraphContext(cameraStateAdapter));
    }
}
