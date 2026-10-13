package androidx.camera.camera2.impl;

import androidx.camera.camera2.compat.workaround.UseFlashModeTorchFor3aUpdate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FlashControl_Factory implements Factory<FlashControl> {
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<State3AControl> state3AControlProvider;
    private final Provider<UseCaseThreads> threadsProvider;
    private final Provider<TorchControl> torchControlProvider;
    private final Provider<UseFlashModeTorchFor3aUpdate> useFlashModeTorchFor3aUpdateProvider;

    private FlashControl_Factory(Provider<CameraProperties> provider, Provider<State3AControl> provider2, Provider<UseCaseThreads> provider3, Provider<TorchControl> provider4, Provider<UseFlashModeTorchFor3aUpdate> provider5) {
        this.cameraPropertiesProvider = provider;
        this.state3AControlProvider = provider2;
        this.threadsProvider = provider3;
        this.torchControlProvider = provider4;
        this.useFlashModeTorchFor3aUpdateProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FlashControl get() {
        return newInstance(this.cameraPropertiesProvider.get(), this.state3AControlProvider.get(), this.threadsProvider.get(), this.torchControlProvider.get(), this.useFlashModeTorchFor3aUpdateProvider.get());
    }

    public static FlashControl_Factory create(Provider<CameraProperties> provider, Provider<State3AControl> provider2, Provider<UseCaseThreads> provider3, Provider<TorchControl> provider4, Provider<UseFlashModeTorchFor3aUpdate> provider5) {
        return new FlashControl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FlashControl newInstance(CameraProperties cameraProperties, State3AControl state3AControl, UseCaseThreads useCaseThreads, TorchControl torchControl, UseFlashModeTorchFor3aUpdate useFlashModeTorchFor3aUpdate) {
        return new FlashControl(cameraProperties, state3AControl, useCaseThreads, torchControl, useFlashModeTorchFor3aUpdate);
    }
}
