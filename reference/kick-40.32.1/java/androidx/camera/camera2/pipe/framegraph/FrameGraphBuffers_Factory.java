package androidx.camera.camera2.pipe.framegraph;

import androidx.camera.camera2.pipe.CameraGraph;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class FrameGraphBuffers_Factory implements Factory<FrameGraphBuffers> {
    private final Provider<CameraGraph> cameraGraphProvider;
    private final Provider<CoroutineScope> frameGraphCoroutineScopeProvider;

    private FrameGraphBuffers_Factory(Provider<CameraGraph> provider, Provider<CoroutineScope> provider2) {
        this.cameraGraphProvider = provider;
        this.frameGraphCoroutineScopeProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FrameGraphBuffers get() {
        return newInstance(this.cameraGraphProvider.get(), this.frameGraphCoroutineScopeProvider.get());
    }

    public static FrameGraphBuffers_Factory create(Provider<CameraGraph> provider, Provider<CoroutineScope> provider2) {
        return new FrameGraphBuffers_Factory(provider, provider2);
    }

    public static FrameGraphBuffers newInstance(CameraGraph cameraGraph, CoroutineScope coroutineScope) {
        return new FrameGraphBuffers(cameraGraph, coroutineScope);
    }
}
