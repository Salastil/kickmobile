package androidx.camera.camera2.compat;

import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.ComboRequestListener;
import androidx.camera.camera2.impl.UseCaseThreads;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class EvCompImpl_Factory implements Factory<EvCompImpl> {
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<ComboRequestListener> comboRequestListenerProvider;
    private final Provider<UseCaseThreads> threadsProvider;

    private EvCompImpl_Factory(Provider<CameraProperties> provider, Provider<UseCaseThreads> provider2, Provider<ComboRequestListener> provider3) {
        this.cameraPropertiesProvider = provider;
        this.threadsProvider = provider2;
        this.comboRequestListenerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public EvCompImpl get() {
        return newInstance(this.cameraPropertiesProvider.get(), this.threadsProvider.get(), this.comboRequestListenerProvider.get());
    }

    public static EvCompImpl_Factory create(Provider<CameraProperties> provider, Provider<UseCaseThreads> provider2, Provider<ComboRequestListener> provider3) {
        return new EvCompImpl_Factory(provider, provider2, provider3);
    }

    public static EvCompImpl newInstance(CameraProperties cameraProperties, UseCaseThreads useCaseThreads, ComboRequestListener comboRequestListener) {
        return new EvCompImpl(cameraProperties, useCaseThreads, comboRequestListener);
    }
}
