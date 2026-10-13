package androidx.camera.camera2.impl;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class TorchControl_Factory implements Factory<TorchControl> {
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<State3AControl> state3AControlProvider;
    private final Provider<UseCaseThreads> threadsProvider;

    private TorchControl_Factory(Provider<CameraProperties> provider, Provider<State3AControl> provider2, Provider<UseCaseThreads> provider3) {
        this.cameraPropertiesProvider = provider;
        this.state3AControlProvider = provider2;
        this.threadsProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TorchControl get() {
        return newInstance(this.cameraPropertiesProvider.get(), this.state3AControlProvider.get(), this.threadsProvider.get());
    }

    public static TorchControl_Factory create(Provider<CameraProperties> provider, Provider<State3AControl> provider2, Provider<UseCaseThreads> provider3) {
        return new TorchControl_Factory(provider, provider2, provider3);
    }

    public static TorchControl newInstance(CameraProperties cameraProperties, State3AControl state3AControl, UseCaseThreads useCaseThreads) {
        return new TorchControl(cameraProperties, state3AControl, useCaseThreads);
    }
}
