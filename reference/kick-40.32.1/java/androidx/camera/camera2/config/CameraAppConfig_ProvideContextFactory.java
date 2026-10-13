package androidx.camera.camera2.config;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class CameraAppConfig_ProvideContextFactory implements Factory<Context> {
    private final CameraAppConfig module;

    private CameraAppConfig_ProvideContextFactory(CameraAppConfig cameraAppConfig) {
        this.module = cameraAppConfig;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Context get() {
        return provideContext(this.module);
    }

    public static CameraAppConfig_ProvideContextFactory create(CameraAppConfig cameraAppConfig) {
        return new CameraAppConfig_ProvideContextFactory(cameraAppConfig);
    }

    public static Context provideContext(CameraAppConfig cameraAppConfig) {
        return (Context) Preconditions.checkNotNullFromProvides(cameraAppConfig.getContext());
    }
}
