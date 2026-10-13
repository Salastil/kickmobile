package androidx.camera.camera2.config;

import android.content.Context;
import androidx.camera.camera2.impl.DisplayInfoManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraAppConfig_ProvideDisplayInfoManagerFactory implements Factory<DisplayInfoManager> {
    private final Provider<Context> contextProvider;
    private final CameraAppConfig module;

    private CameraAppConfig_ProvideDisplayInfoManagerFactory(CameraAppConfig cameraAppConfig, Provider<Context> provider) {
        this.module = cameraAppConfig;
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DisplayInfoManager get() {
        return provideDisplayInfoManager(this.module, this.contextProvider.get());
    }

    public static CameraAppConfig_ProvideDisplayInfoManagerFactory create(CameraAppConfig cameraAppConfig, Provider<Context> provider) {
        return new CameraAppConfig_ProvideDisplayInfoManagerFactory(cameraAppConfig, provider);
    }

    public static DisplayInfoManager provideDisplayInfoManager(CameraAppConfig cameraAppConfig, Context context) {
        return (DisplayInfoManager) Preconditions.checkNotNullFromProvides(cameraAppConfig.provideDisplayInfoManager(context));
    }
}
