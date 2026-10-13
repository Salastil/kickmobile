package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraPipe;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeConfigModule_ProvideCameraPipeConfigFactory implements Factory<CameraPipe.Config> {
    private final CameraPipeConfigModule module;

    private CameraPipeConfigModule_ProvideCameraPipeConfigFactory(CameraPipeConfigModule cameraPipeConfigModule) {
        this.module = cameraPipeConfigModule;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraPipe.Config get() {
        return provideCameraPipeConfig(this.module);
    }

    public static CameraPipeConfigModule_ProvideCameraPipeConfigFactory create(CameraPipeConfigModule cameraPipeConfigModule) {
        return new CameraPipeConfigModule_ProvideCameraPipeConfigFactory(cameraPipeConfigModule);
    }

    public static CameraPipe.Config provideCameraPipeConfig(CameraPipeConfigModule cameraPipeConfigModule) {
        return (CameraPipe.Config) Preconditions.checkNotNullFromProvides(cameraPipeConfigModule.getConfig());
    }
}
