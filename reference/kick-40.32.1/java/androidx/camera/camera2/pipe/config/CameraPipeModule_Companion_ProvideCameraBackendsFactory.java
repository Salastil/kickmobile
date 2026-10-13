package androidx.camera.camera2.pipe.config;

import android.content.Context;
import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraBackends;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideCameraBackendsFactory implements Factory<CameraBackends> {
    private final Provider<Context> cameraPipeContextProvider;
    private final Provider<CameraPipeLifetime> cameraPipeLifetimeProvider;
    private final Provider<CameraPipe.Config> configProvider;
    private final Provider<CameraBackend> defaultCameraBackendProvider;
    private final Provider<Threads> threadsProvider;

    private CameraPipeModule_Companion_ProvideCameraBackendsFactory(Provider<CameraPipe.Config> provider, Provider<CameraBackend> provider2, Provider<Context> provider3, Provider<Threads> provider4, Provider<CameraPipeLifetime> provider5) {
        this.configProvider = provider;
        this.defaultCameraBackendProvider = provider2;
        this.cameraPipeContextProvider = provider3;
        this.threadsProvider = provider4;
        this.cameraPipeLifetimeProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraBackends get() {
        return provideCameraBackends(this.configProvider.get(), this.defaultCameraBackendProvider, this.cameraPipeContextProvider.get(), this.threadsProvider.get(), this.cameraPipeLifetimeProvider.get());
    }

    public static CameraPipeModule_Companion_ProvideCameraBackendsFactory create(Provider<CameraPipe.Config> provider, Provider<CameraBackend> provider2, Provider<Context> provider3, Provider<Threads> provider4, Provider<CameraPipeLifetime> provider5) {
        return new CameraPipeModule_Companion_ProvideCameraBackendsFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static CameraBackends provideCameraBackends(CameraPipe.Config config, javax.inject.Provider<CameraBackend> provider, Context context, Threads threads, CameraPipeLifetime cameraPipeLifetime) {
        return (CameraBackends) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideCameraBackends(config, provider, context, threads, cameraPipeLifetime));
    }
}
