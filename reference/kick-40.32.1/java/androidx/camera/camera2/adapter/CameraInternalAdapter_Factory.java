package androidx.camera.camera2.adapter;

import androidx.camera.camera2.config.CameraConfig;
import androidx.camera.camera2.impl.UseCaseManager;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraInternalAdapter_Factory implements Factory<CameraInternalAdapter> {
    private final Provider<CameraControlInternal> cameraControllerProvider;
    private final Provider<CameraInfoInternal> cameraInfoProvider;
    private final Provider<CameraStateAdapter> cameraStateAdapterProvider;
    private final Provider<CameraConfig> configProvider;
    private final Provider<UseCaseThreads> threadsProvider;
    private final Provider<UseCaseManager> useCaseManagerProvider;

    private CameraInternalAdapter_Factory(Provider<CameraConfig> provider, Provider<UseCaseManager> provider2, Provider<CameraInfoInternal> provider3, Provider<CameraControlInternal> provider4, Provider<UseCaseThreads> provider5, Provider<CameraStateAdapter> provider6) {
        this.configProvider = provider;
        this.useCaseManagerProvider = provider2;
        this.cameraInfoProvider = provider3;
        this.cameraControllerProvider = provider4;
        this.threadsProvider = provider5;
        this.cameraStateAdapterProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraInternalAdapter get() {
        return newInstance(this.configProvider.get(), this.useCaseManagerProvider.get(), this.cameraInfoProvider.get(), this.cameraControllerProvider.get(), this.threadsProvider.get(), this.cameraStateAdapterProvider.get());
    }

    public static CameraInternalAdapter_Factory create(Provider<CameraConfig> provider, Provider<UseCaseManager> provider2, Provider<CameraInfoInternal> provider3, Provider<CameraControlInternal> provider4, Provider<UseCaseThreads> provider5, Provider<CameraStateAdapter> provider6) {
        return new CameraInternalAdapter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CameraInternalAdapter newInstance(CameraConfig cameraConfig, UseCaseManager useCaseManager, CameraInfoInternal cameraInfoInternal, CameraControlInternal cameraControlInternal, UseCaseThreads useCaseThreads, CameraStateAdapter cameraStateAdapter) {
        return new CameraInternalAdapter(cameraConfig, useCaseManager, cameraInfoInternal, cameraControlInternal, useCaseThreads, cameraStateAdapter);
    }
}
