package androidx.camera.camera2.pipe.framegraph;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.graph.Controller3A;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphImpl_Factory implements Factory<FrameGraphImpl> {
    private final Provider<CameraGraph> cameraGraphProvider;
    private final Provider<Controller3A> controller3AProvider;
    private final Provider<FrameDistributor> frameDistributorProvider;
    private final Provider<FrameGraphBuffers> frameGraphBuffersProvider;
    private final Provider<CoroutineScope> frameGraphCoroutineScopeProvider;

    private FrameGraphImpl_Factory(Provider<CameraGraph> provider, Provider<FrameDistributor> provider2, Provider<FrameGraphBuffers> provider3, Provider<CoroutineScope> provider4, Provider<Controller3A> provider5) {
        this.cameraGraphProvider = provider;
        this.frameDistributorProvider = provider2;
        this.frameGraphBuffersProvider = provider3;
        this.frameGraphCoroutineScopeProvider = provider4;
        this.controller3AProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FrameGraphImpl get() {
        return newInstance(this.cameraGraphProvider.get(), this.frameDistributorProvider.get(), this.frameGraphBuffersProvider.get(), this.frameGraphCoroutineScopeProvider.get(), this.controller3AProvider.get());
    }

    public static FrameGraphImpl_Factory create(Provider<CameraGraph> provider, Provider<FrameDistributor> provider2, Provider<FrameGraphBuffers> provider3, Provider<CoroutineScope> provider4, Provider<Controller3A> provider5) {
        return new FrameGraphImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FrameGraphImpl newInstance(CameraGraph cameraGraph, FrameDistributor frameDistributor, FrameGraphBuffers frameGraphBuffers, CoroutineScope coroutineScope, Controller3A controller3A) {
        return new FrameGraphImpl(cameraGraph, frameDistributor, frameGraphBuffers, coroutineScope, controller3A);
    }
}
