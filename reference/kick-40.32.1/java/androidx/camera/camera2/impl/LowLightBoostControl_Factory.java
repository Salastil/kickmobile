package androidx.camera.camera2.impl;

import androidx.camera.camera2.pipe.CameraMetadata;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class LowLightBoostControl_Factory implements Factory<LowLightBoostControl> {
    private final Provider<CameraMetadata> cameraMetadataProvider;
    private final Provider<ComboRequestListener> comboRequestListenerProvider;
    private final Provider<State3AControl> state3AControlProvider;
    private final Provider<UseCaseThreads> threadsProvider;

    private LowLightBoostControl_Factory(Provider<CameraMetadata> provider, Provider<State3AControl> provider2, Provider<UseCaseThreads> provider3, Provider<ComboRequestListener> provider4) {
        this.cameraMetadataProvider = provider;
        this.state3AControlProvider = provider2;
        this.threadsProvider = provider3;
        this.comboRequestListenerProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LowLightBoostControl get() {
        return newInstance(this.cameraMetadataProvider.get(), this.state3AControlProvider.get(), this.threadsProvider.get(), this.comboRequestListenerProvider.get());
    }

    public static LowLightBoostControl_Factory create(Provider<CameraMetadata> provider, Provider<State3AControl> provider2, Provider<UseCaseThreads> provider3, Provider<ComboRequestListener> provider4) {
        return new LowLightBoostControl_Factory(provider, provider2, provider3, provider4);
    }

    public static LowLightBoostControl newInstance(CameraMetadata cameraMetadata, State3AControl state3AControl, UseCaseThreads useCaseThreads, ComboRequestListener comboRequestListener) {
        return new LowLightBoostControl(cameraMetadata, state3AControl, useCaseThreads, comboRequestListener);
    }
}
