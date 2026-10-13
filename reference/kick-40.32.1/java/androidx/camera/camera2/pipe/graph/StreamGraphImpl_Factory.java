package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.media.ImageSources;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class StreamGraphImpl_Factory implements Factory<StreamGraphImpl> {
    private final Provider<CameraController> cameraControllerProvider;
    private final Provider<CameraMetadata> cameraMetadataProvider;
    private final Provider<CameraGraph.Config> graphConfigProvider;
    private final Provider<ImageSources> imageSourcesProvider;

    private StreamGraphImpl_Factory(Provider<CameraMetadata> provider, Provider<CameraGraph.Config> provider2, Provider<ImageSources> provider3, Provider<CameraController> provider4) {
        this.cameraMetadataProvider = provider;
        this.graphConfigProvider = provider2;
        this.imageSourcesProvider = provider3;
        this.cameraControllerProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public StreamGraphImpl get() {
        return newInstance(this.cameraMetadataProvider.get(), this.graphConfigProvider.get(), this.imageSourcesProvider.get(), this.cameraControllerProvider);
    }

    public static StreamGraphImpl_Factory create(Provider<CameraMetadata> provider, Provider<CameraGraph.Config> provider2, Provider<ImageSources> provider3, Provider<CameraController> provider4) {
        return new StreamGraphImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static StreamGraphImpl newInstance(CameraMetadata cameraMetadata, CameraGraph.Config config, ImageSources imageSources, javax.inject.Provider<CameraController> provider) {
        return new StreamGraphImpl(cameraMetadata, config, imageSources, provider);
    }
}
