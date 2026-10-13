package androidx.camera.camera2.config;

import androidx.camera.camera2.compat.Camera2CameraControlCompat;
import androidx.camera.camera2.impl.ComboRequestListener;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.camera2.interop.Camera2CameraControl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraModule_Companion_ProvideCamera2CameraControlFactory implements Factory<Camera2CameraControl> {
    private final Provider<Camera2CameraControlCompat> compatProvider;
    private final Provider<ComboRequestListener> requestListenerProvider;
    private final Provider<UseCaseThreads> threadsProvider;

    private CameraModule_Companion_ProvideCamera2CameraControlFactory(Provider<Camera2CameraControlCompat> provider, Provider<UseCaseThreads> provider2, Provider<ComboRequestListener> provider3) {
        this.compatProvider = provider;
        this.threadsProvider = provider2;
        this.requestListenerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Camera2CameraControl get() {
        return provideCamera2CameraControl(this.compatProvider.get(), this.threadsProvider.get(), this.requestListenerProvider.get());
    }

    public static CameraModule_Companion_ProvideCamera2CameraControlFactory create(Provider<Camera2CameraControlCompat> provider, Provider<UseCaseThreads> provider2, Provider<ComboRequestListener> provider3) {
        return new CameraModule_Companion_ProvideCamera2CameraControlFactory(provider, provider2, provider3);
    }

    public static Camera2CameraControl provideCamera2CameraControl(Camera2CameraControlCompat camera2CameraControlCompat, UseCaseThreads useCaseThreads, ComboRequestListener comboRequestListener) {
        return (Camera2CameraControl) Preconditions.checkNotNullFromProvides(CameraModule.INSTANCE.provideCamera2CameraControl(camera2CameraControlCompat, useCaseThreads, comboRequestListener));
    }
}
