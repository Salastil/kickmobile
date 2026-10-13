package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class StandardCamera2CaptureSequenceProcessorFactory_Factory implements Factory<StandardCamera2CaptureSequenceProcessorFactory> {
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<Camera2Quirks> quirksProvider;
    private final Provider<StreamGraphImpl> streamGraphProvider;
    private final Provider<StrictMode> strictModeProvider;
    private final Provider<Threads> threadsProvider;

    private StandardCamera2CaptureSequenceProcessorFactory_Factory(Provider<Threads> provider, Provider<CameraGraph.Config> provider2, Provider<StreamGraphImpl> provider3, Provider<Camera2Quirks> provider4, Provider<StrictMode> provider5) {
        this.threadsProvider = provider;
        this.graphConfigProvider = provider2;
        this.streamGraphProvider = provider3;
        this.quirksProvider = provider4;
        this.strictModeProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public StandardCamera2CaptureSequenceProcessorFactory get() {
        return newInstance(this.threadsProvider.get(), this.graphConfigProvider.get(), this.streamGraphProvider.get(), this.quirksProvider.get(), this.strictModeProvider.get());
    }

    public static StandardCamera2CaptureSequenceProcessorFactory_Factory create(Provider<Threads> provider, Provider<CameraGraph.Config> provider2, Provider<StreamGraphImpl> provider3, Provider<Camera2Quirks> provider4, Provider<StrictMode> provider5) {
        return new StandardCamera2CaptureSequenceProcessorFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static StandardCamera2CaptureSequenceProcessorFactory newInstance(Threads threads, CameraGraph.Config config, StreamGraphImpl streamGraphImpl, Camera2Quirks camera2Quirks, StrictMode strictMode) {
        return new StandardCamera2CaptureSequenceProcessorFactory(threads, config, streamGraphImpl, camera2Quirks, strictMode);
    }
}
