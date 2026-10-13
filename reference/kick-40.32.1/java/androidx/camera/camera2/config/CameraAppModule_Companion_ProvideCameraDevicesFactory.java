package androidx.camera.camera2.config;

import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraPipe;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraAppModule_Companion_ProvideCameraDevicesFactory implements Factory<CameraDevices> {
    private final Provider<CameraPipe> cameraPipeProvider;

    private CameraAppModule_Companion_ProvideCameraDevicesFactory(Provider<CameraPipe> provider) {
        this.cameraPipeProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraDevices get() {
        return provideCameraDevices(this.cameraPipeProvider.get());
    }

    public static CameraAppModule_Companion_ProvideCameraDevicesFactory create(Provider<CameraPipe> provider) {
        return new CameraAppModule_Companion_ProvideCameraDevicesFactory(provider);
    }

    public static CameraDevices provideCameraDevices(CameraPipe cameraPipe) {
        return (CameraDevices) Preconditions.checkNotNullFromProvides(CameraAppModule.INSTANCE.provideCameraDevices(cameraPipe));
    }
}
