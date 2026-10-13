package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraSurfaceManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideCameraSurfaceManagerFactory implements Factory<CameraSurfaceManager> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraSurfaceManager get() {
        return provideCameraSurfaceManager();
    }

    public static CameraPipeModule_Companion_ProvideCameraSurfaceManagerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CameraSurfaceManager provideCameraSurfaceManager() {
        return (CameraSurfaceManager) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideCameraSurfaceManager());
    }

    private static final class InstanceHolder {
        static final CameraPipeModule_Companion_ProvideCameraSurfaceManagerFactory INSTANCE = new CameraPipeModule_Companion_ProvideCameraSurfaceManagerFactory();

        private InstanceHolder() {
        }
    }
}
