package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraGraph;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class Camera2CaptureSessionsModule_ProvideSessionFactoryFactory implements Factory<CaptureSessionFactory> {
    private final Provider<AndroidExtensionSessionFactory> androidExtensionProvider;
    private final Provider<AndroidMHighSpeedSessionFactory> androidMHighSpeedProvider;
    private final Provider<AndroidMSessionFactory> androidMProvider;
    private final Provider<AndroidNSessionFactory> androidNProvider;
    private final Provider<AndroidPSessionFactory> androidPProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;

    private Camera2CaptureSessionsModule_ProvideSessionFactoryFactory(Provider<AndroidMSessionFactory> provider, Provider<AndroidMHighSpeedSessionFactory> provider2, Provider<AndroidNSessionFactory> provider3, Provider<AndroidPSessionFactory> provider4, Provider<AndroidExtensionSessionFactory> provider5, Provider<CameraGraph.Config> provider6) {
        this.androidMProvider = provider;
        this.androidMHighSpeedProvider = provider2;
        this.androidNProvider = provider3;
        this.androidPProvider = provider4;
        this.androidExtensionProvider = provider5;
        this.graphConfigProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureSessionFactory get() {
        return provideSessionFactory(this.androidMProvider, this.androidMHighSpeedProvider, this.androidNProvider, this.androidPProvider, this.androidExtensionProvider, this.graphConfigProvider.get());
    }

    public static Camera2CaptureSessionsModule_ProvideSessionFactoryFactory create(Provider<AndroidMSessionFactory> provider, Provider<AndroidMHighSpeedSessionFactory> provider2, Provider<AndroidNSessionFactory> provider3, Provider<AndroidPSessionFactory> provider4, Provider<AndroidExtensionSessionFactory> provider5, Provider<CameraGraph.Config> provider6) {
        return new Camera2CaptureSessionsModule_ProvideSessionFactoryFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CaptureSessionFactory provideSessionFactory(javax.inject.Provider<AndroidMSessionFactory> provider, javax.inject.Provider<AndroidMHighSpeedSessionFactory> provider2, javax.inject.Provider<AndroidNSessionFactory> provider3, javax.inject.Provider<AndroidPSessionFactory> provider4, javax.inject.Provider<AndroidExtensionSessionFactory> provider5, CameraGraph.Config config) {
        return (CaptureSessionFactory) Preconditions.checkNotNullFromProvides(Camera2CaptureSessionsModule.INSTANCE.provideSessionFactory(provider, provider2, provider3, provider4, provider5, config));
    }
}
