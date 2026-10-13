package androidx.camera.camera2.config;

import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.core.impl.CameraThreadConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraModule_Companion_ProvideUseCaseThreadsFactory implements Factory<UseCaseThreads> {
    private final Provider<CameraConfig> cameraConfigProvider;
    private final Provider<CameraThreadConfig> cameraThreadConfigProvider;

    private CameraModule_Companion_ProvideUseCaseThreadsFactory(Provider<CameraConfig> provider, Provider<CameraThreadConfig> provider2) {
        this.cameraConfigProvider = provider;
        this.cameraThreadConfigProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UseCaseThreads get() {
        return provideUseCaseThreads(this.cameraConfigProvider.get(), this.cameraThreadConfigProvider.get());
    }

    public static CameraModule_Companion_ProvideUseCaseThreadsFactory create(Provider<CameraConfig> provider, Provider<CameraThreadConfig> provider2) {
        return new CameraModule_Companion_ProvideUseCaseThreadsFactory(provider, provider2);
    }

    public static UseCaseThreads provideUseCaseThreads(CameraConfig cameraConfig, CameraThreadConfig cameraThreadConfig) {
        return (UseCaseThreads) Preconditions.checkNotNullFromProvides(CameraModule.INSTANCE.provideUseCaseThreads(cameraConfig, cameraThreadConfig));
    }
}
