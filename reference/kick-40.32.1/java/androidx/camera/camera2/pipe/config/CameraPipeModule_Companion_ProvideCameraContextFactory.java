package androidx.camera.camera2.pipe.config;

import android.content.Context;
import androidx.camera.camera2.pipe.CameraBackends;
import androidx.camera.camera2.pipe.CameraContext;
import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideCameraContextFactory implements Factory<CameraContext> {
    private final Provider<CameraBackends> cameraBackendsProvider;
    private final Provider<Context> cameraPipeContextProvider;
    private final Provider<Threads> threadsProvider;

    private CameraPipeModule_Companion_ProvideCameraContextFactory(Provider<Context> provider, Provider<Threads> provider2, Provider<CameraBackends> provider3) {
        this.cameraPipeContextProvider = provider;
        this.threadsProvider = provider2;
        this.cameraBackendsProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraContext get() {
        return provideCameraContext(this.cameraPipeContextProvider.get(), this.threadsProvider.get(), this.cameraBackendsProvider.get());
    }

    public static CameraPipeModule_Companion_ProvideCameraContextFactory create(Provider<Context> provider, Provider<Threads> provider2, Provider<CameraBackends> provider3) {
        return new CameraPipeModule_Companion_ProvideCameraContextFactory(provider, provider2, provider3);
    }

    public static CameraContext provideCameraContext(Context context, Threads threads, CameraBackends cameraBackends) {
        return (CameraContext) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideCameraContext(context, threads, cameraBackends));
    }
}
