package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.compat.Camera2Quirks;
import androidx.camera.camera2.pipe.core.Threads;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GraphProcessorImpl_Factory implements Factory<GraphProcessorImpl> {
    private final Provider<Camera2Quirks> camera2QuirksProvider;
    private final Provider<CameraGraph.Config> cameraGraphConfigProvider;
    private final Provider<CameraGraphId> cameraGraphIdProvider;
    private final Provider<Listener3A> graphListener3AProvider;
    private final Provider<List<Request.Listener>> graphListenersProvider;
    private final Provider<Threads> threadsProvider;

    private GraphProcessorImpl_Factory(Provider<Threads> provider, Provider<CameraGraphId> provider2, Provider<CameraGraph.Config> provider3, Provider<Listener3A> provider4, Provider<List<Request.Listener>> provider5, Provider<Camera2Quirks> provider6) {
        this.threadsProvider = provider;
        this.cameraGraphIdProvider = provider2;
        this.cameraGraphConfigProvider = provider3;
        this.graphListener3AProvider = provider4;
        this.graphListenersProvider = provider5;
        this.camera2QuirksProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GraphProcessorImpl get() {
        return newInstance(this.threadsProvider.get(), this.cameraGraphIdProvider.get(), this.cameraGraphConfigProvider.get(), this.graphListener3AProvider.get(), this.graphListenersProvider.get(), this.camera2QuirksProvider.get());
    }

    public static GraphProcessorImpl_Factory create(Provider<Threads> provider, Provider<CameraGraphId> provider2, Provider<CameraGraph.Config> provider3, Provider<Listener3A> provider4, Provider<List<Request.Listener>> provider5, Provider<Camera2Quirks> provider6) {
        return new GraphProcessorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static GraphProcessorImpl newInstance(Threads threads, CameraGraphId cameraGraphId, CameraGraph.Config config, Listener3A listener3A, List<Request.Listener> list, Camera2Quirks camera2Quirks) {
        return new GraphProcessorImpl(threads, cameraGraphId, config, listener3A, list, camera2Quirks);
    }
}
