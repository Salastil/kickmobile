package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.graph.Listener3A;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SharedCameraGraphModules_Companion_ProvideRequestListenersFactory implements Factory<List<Request.Listener>> {
    private final Provider<FrameDistributor> frameDistributorProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<Listener3A> listener3AProvider;

    private SharedCameraGraphModules_Companion_ProvideRequestListenersFactory(Provider<CameraGraph.Config> provider, Provider<Listener3A> provider2, Provider<FrameDistributor> provider3) {
        this.graphConfigProvider = provider;
        this.listener3AProvider = provider2;
        this.frameDistributorProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public List<Request.Listener> get() {
        return provideRequestListeners(this.graphConfigProvider.get(), this.listener3AProvider.get(), this.frameDistributorProvider.get());
    }

    public static SharedCameraGraphModules_Companion_ProvideRequestListenersFactory create(Provider<CameraGraph.Config> provider, Provider<Listener3A> provider2, Provider<FrameDistributor> provider3) {
        return new SharedCameraGraphModules_Companion_ProvideRequestListenersFactory(provider, provider2, provider3);
    }

    public static List<Request.Listener> provideRequestListeners(CameraGraph.Config config, Listener3A listener3A, FrameDistributor frameDistributor) {
        return (List) Preconditions.checkNotNullFromProvides(SharedCameraGraphModules.INSTANCE.provideRequestListeners(config, listener3A, frameDistributor));
    }
}
