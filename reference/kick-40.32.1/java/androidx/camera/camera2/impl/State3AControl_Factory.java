package androidx.camera.camera2.impl;

import androidx.camera.camera2.compat.workaround.AutoFlashAEModeDisabler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class State3AControl_Factory implements Factory<State3AControl> {
    private final Provider<AutoFlashAEModeDisabler> aeModeDisablerProvider;
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<UseCaseThreads> threadsProvider;

    private State3AControl_Factory(Provider<CameraProperties> provider, Provider<AutoFlashAEModeDisabler> provider2, Provider<UseCaseThreads> provider3) {
        this.cameraPropertiesProvider = provider;
        this.aeModeDisablerProvider = provider2;
        this.threadsProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public State3AControl get() {
        return newInstance(this.cameraPropertiesProvider.get(), this.aeModeDisablerProvider.get(), this.threadsProvider.get());
    }

    public static State3AControl_Factory create(Provider<CameraProperties> provider, Provider<AutoFlashAEModeDisabler> provider2, Provider<UseCaseThreads> provider3) {
        return new State3AControl_Factory(provider, provider2, provider3);
    }

    public static State3AControl newInstance(CameraProperties cameraProperties, AutoFlashAEModeDisabler autoFlashAEModeDisabler, UseCaseThreads useCaseThreads) {
        return new State3AControl(cameraProperties, autoFlashAEModeDisabler, useCaseThreads);
    }
}
