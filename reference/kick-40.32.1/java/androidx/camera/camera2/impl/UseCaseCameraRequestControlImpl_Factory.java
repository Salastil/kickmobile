package androidx.camera.camera2.impl;

import androidx.camera.camera2.config.UseCaseGraphContext;
import androidx.camera.core.CameraXConfig;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl_Factory implements Factory<UseCaseCameraRequestControlImpl> {
    private final Provider<CameraXConfig> cameraXConfigProvider;
    private final Provider<CapturePipeline> capturePipelineProvider;
    private final Provider<UseCaseThreads> threadsProvider;
    private final Provider<UseCaseCameraState> useCaseCameraStateProvider;
    private final Provider<UseCaseGraphContext> useCaseGraphContextProvider;
    private final Provider<UseCaseSurfaceManager> useCaseSurfaceManagerProvider;

    private UseCaseCameraRequestControlImpl_Factory(Provider<CapturePipeline> provider, Provider<UseCaseCameraState> provider2, Provider<UseCaseGraphContext> provider3, Provider<UseCaseSurfaceManager> provider4, Provider<UseCaseThreads> provider5, Provider<CameraXConfig> provider6) {
        this.capturePipelineProvider = provider;
        this.useCaseCameraStateProvider = provider2;
        this.useCaseGraphContextProvider = provider3;
        this.useCaseSurfaceManagerProvider = provider4;
        this.threadsProvider = provider5;
        this.cameraXConfigProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UseCaseCameraRequestControlImpl get() {
        return newInstance(this.capturePipelineProvider, this.useCaseCameraStateProvider, this.useCaseGraphContextProvider.get(), this.useCaseSurfaceManagerProvider, this.threadsProvider.get(), this.cameraXConfigProvider.get());
    }

    public static UseCaseCameraRequestControlImpl_Factory create(Provider<CapturePipeline> provider, Provider<UseCaseCameraState> provider2, Provider<UseCaseGraphContext> provider3, Provider<UseCaseSurfaceManager> provider4, Provider<UseCaseThreads> provider5, Provider<CameraXConfig> provider6) {
        return new UseCaseCameraRequestControlImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static UseCaseCameraRequestControlImpl newInstance(javax.inject.Provider<CapturePipeline> provider, javax.inject.Provider<UseCaseCameraState> provider2, UseCaseGraphContext useCaseGraphContext, javax.inject.Provider<UseCaseSurfaceManager> provider3, UseCaseThreads useCaseThreads, CameraXConfig cameraXConfig) {
        return new UseCaseCameraRequestControlImpl(provider, provider2, useCaseGraphContext, provider3, useCaseThreads, cameraXConfig);
    }
}
