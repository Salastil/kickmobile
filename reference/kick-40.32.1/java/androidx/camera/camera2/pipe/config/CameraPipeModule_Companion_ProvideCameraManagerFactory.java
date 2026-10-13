package androidx.camera.camera2.pipe.config;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideCameraManagerFactory implements Factory<CameraManager> {
    private final Provider<Context> cameraPipeContextProvider;

    private CameraPipeModule_Companion_ProvideCameraManagerFactory(Provider<Context> provider) {
        this.cameraPipeContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraManager get() {
        return provideCameraManager(this.cameraPipeContextProvider.get());
    }

    public static CameraPipeModule_Companion_ProvideCameraManagerFactory create(Provider<Context> provider) {
        return new CameraPipeModule_Companion_ProvideCameraManagerFactory(provider);
    }

    public static CameraManager provideCameraManager(Context context) {
        return (CameraManager) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideCameraManager(context));
    }
}
