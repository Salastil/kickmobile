package androidx.camera.camera2.impl;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class StillCaptureRequestControl_Factory implements Factory<StillCaptureRequestControl> {
    private final Provider<FlashControl> flashControlProvider;
    private final Provider<UseCaseThreads> threadsProvider;

    private StillCaptureRequestControl_Factory(Provider<FlashControl> provider, Provider<UseCaseThreads> provider2) {
        this.flashControlProvider = provider;
        this.threadsProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public StillCaptureRequestControl get() {
        return newInstance(this.flashControlProvider.get(), this.threadsProvider.get());
    }

    public static StillCaptureRequestControl_Factory create(Provider<FlashControl> provider, Provider<UseCaseThreads> provider2) {
        return new StillCaptureRequestControl_Factory(provider, provider2);
    }

    public static StillCaptureRequestControl newInstance(FlashControl flashControl, UseCaseThreads useCaseThreads) {
        return new StillCaptureRequestControl(flashControl, useCaseThreads);
    }
}
