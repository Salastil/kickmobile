package androidx.camera.camera2.impl;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class DeferredUseCaseCameraRequestControl_Factory implements Factory<DeferredUseCaseCameraRequestControl> {
    private final Provider<UseCaseCameraRequestControlImpl> implProvider;
    private final Provider<UseCaseThreads> threadsProvider;

    private DeferredUseCaseCameraRequestControl_Factory(Provider<UseCaseCameraRequestControlImpl> provider, Provider<UseCaseThreads> provider2) {
        this.implProvider = provider;
        this.threadsProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeferredUseCaseCameraRequestControl get() {
        return newInstance(this.implProvider, this.threadsProvider.get());
    }

    public static DeferredUseCaseCameraRequestControl_Factory create(Provider<UseCaseCameraRequestControlImpl> provider, Provider<UseCaseThreads> provider2) {
        return new DeferredUseCaseCameraRequestControl_Factory(provider, provider2);
    }

    public static DeferredUseCaseCameraRequestControl newInstance(javax.inject.Provider<UseCaseCameraRequestControlImpl> provider, UseCaseThreads useCaseThreads) {
        return new DeferredUseCaseCameraRequestControl(provider, useCaseThreads);
    }
}
