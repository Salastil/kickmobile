package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidPSessionFactory_Factory implements Factory<AndroidPSessionFactory> {
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<StreamGraphImpl> streamGraphProvider;
    private final Provider<Threads> threadsProvider;

    private AndroidPSessionFactory_Factory(Provider<Threads> provider, Provider<CameraGraph.Config> provider2, Provider<StreamGraphImpl> provider3) {
        this.threadsProvider = provider;
        this.graphConfigProvider = provider2;
        this.streamGraphProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AndroidPSessionFactory get() {
        return newInstance(this.threadsProvider.get(), this.graphConfigProvider.get(), this.streamGraphProvider.get());
    }

    public static AndroidPSessionFactory_Factory create(Provider<Threads> provider, Provider<CameraGraph.Config> provider2, Provider<StreamGraphImpl> provider3) {
        return new AndroidPSessionFactory_Factory(provider, provider2, provider3);
    }

    public static AndroidPSessionFactory newInstance(Threads threads, CameraGraph.Config config, StreamGraphImpl streamGraphImpl) {
        return new AndroidPSessionFactory(threads, config, streamGraphImpl);
    }
}
