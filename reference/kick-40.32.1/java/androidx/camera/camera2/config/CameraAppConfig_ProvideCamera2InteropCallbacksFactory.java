package androidx.camera.camera2.config;

import androidx.camera.camera2.impl.CameraInteropStateCallbackRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraAppConfig_ProvideCamera2InteropCallbacksFactory implements Factory<CameraInteropStateCallbackRepository> {
    private final CameraAppConfig module;

    private CameraAppConfig_ProvideCamera2InteropCallbacksFactory(CameraAppConfig cameraAppConfig) {
        this.module = cameraAppConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraInteropStateCallbackRepository get() {
        return provideCamera2InteropCallbacks(this.module);
    }

    public static CameraAppConfig_ProvideCamera2InteropCallbacksFactory create(CameraAppConfig cameraAppConfig) {
        return new CameraAppConfig_ProvideCamera2InteropCallbacksFactory(cameraAppConfig);
    }

    public static CameraInteropStateCallbackRepository provideCamera2InteropCallbacks(CameraAppConfig cameraAppConfig) {
        return (CameraInteropStateCallbackRepository) Preconditions.checkNotNullFromProvides(cameraAppConfig.getCamera2InteropCallbacks());
    }
}
