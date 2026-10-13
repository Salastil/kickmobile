package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidExtensionSessionFactory_Factory implements Factory<AndroidExtensionSessionFactory> {
    private final Provider<Camera2MetadataProvider> camera2MetadataProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<StreamGraphImpl> streamGraphProvider;
    private final Provider<StrictMode> strictModeProvider;
    private final Provider<Threads> threadsProvider;

    private AndroidExtensionSessionFactory_Factory(Provider<Threads> provider, Provider<CameraGraph.Config> provider2, Provider<StreamGraphImpl> provider3, Provider<Camera2MetadataProvider> provider4, Provider<StrictMode> provider5) {
        this.threadsProvider = provider;
        this.graphConfigProvider = provider2;
        this.streamGraphProvider = provider3;
        this.camera2MetadataProvider = provider4;
        this.strictModeProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AndroidExtensionSessionFactory get() {
        return newInstance(this.threadsProvider.get(), this.graphConfigProvider.get(), this.streamGraphProvider.get(), this.camera2MetadataProvider.get(), this.strictModeProvider.get());
    }

    public static AndroidExtensionSessionFactory_Factory create(Provider<Threads> provider, Provider<CameraGraph.Config> provider2, Provider<StreamGraphImpl> provider3, Provider<Camera2MetadataProvider> provider4, Provider<StrictMode> provider5) {
        return new AndroidExtensionSessionFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AndroidExtensionSessionFactory newInstance(Threads threads, CameraGraph.Config config, StreamGraphImpl streamGraphImpl, Camera2MetadataProvider camera2MetadataProvider, StrictMode strictMode) {
        return new AndroidExtensionSessionFactory(threads, config, streamGraphImpl, camera2MetadataProvider, strictMode);
    }
}
