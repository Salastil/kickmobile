package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidMSessionFactory_Factory implements Factory<AndroidMSessionFactory> {
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<StreamGraphImpl> streamGraphProvider;
    private final Provider<Threads> threadsProvider;

    private AndroidMSessionFactory_Factory(Provider<Threads> provider, Provider<StreamGraphImpl> provider2, Provider<CameraGraph.Config> provider3) {
        this.threadsProvider = provider;
        this.streamGraphProvider = provider2;
        this.graphConfigProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AndroidMSessionFactory get() {
        return newInstance(this.threadsProvider.get(), this.streamGraphProvider.get(), this.graphConfigProvider.get());
    }

    public static AndroidMSessionFactory_Factory create(Provider<Threads> provider, Provider<StreamGraphImpl> provider2, Provider<CameraGraph.Config> provider3) {
        return new AndroidMSessionFactory_Factory(provider, provider2, provider3);
    }

    public static AndroidMSessionFactory newInstance(Threads threads, StreamGraphImpl streamGraphImpl, CameraGraph.Config config) {
        return new AndroidMSessionFactory(threads, streamGraphImpl, config);
    }
}
