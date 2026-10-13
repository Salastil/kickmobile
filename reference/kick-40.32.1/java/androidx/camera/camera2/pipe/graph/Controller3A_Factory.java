package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.CameraMetadata;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class Controller3A_Factory implements Factory<Controller3A> {
    private final Provider<Listener3A> graphListener3AProvider;
    private final Provider<GraphProcessor> graphProcessorProvider;
    private final Provider<GraphState3A> graphState3AProvider;
    private final Provider<CameraMetadata> metadataProvider;

    private Controller3A_Factory(Provider<GraphProcessor> provider, Provider<CameraMetadata> provider2, Provider<GraphState3A> provider3, Provider<Listener3A> provider4) {
        this.graphProcessorProvider = provider;
        this.metadataProvider = provider2;
        this.graphState3AProvider = provider3;
        this.graphListener3AProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Controller3A get() {
        return newInstance(this.graphProcessorProvider.get(), this.metadataProvider.get(), this.graphState3AProvider.get(), this.graphListener3AProvider.get());
    }

    public static Controller3A_Factory create(Provider<GraphProcessor> provider, Provider<CameraMetadata> provider2, Provider<GraphState3A> provider3, Provider<Listener3A> provider4) {
        return new Controller3A_Factory(provider, provider2, provider3, provider4);
    }

    public static Controller3A newInstance(GraphProcessor graphProcessor, CameraMetadata cameraMetadata, GraphState3A graphState3A, Listener3A listener3A) {
        return new Controller3A(graphProcessor, cameraMetadata, graphState3A, listener3A);
    }
}
