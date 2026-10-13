package androidx.camera.camera2.compat.workaround;

import android.hardware.camera2.params.StreamConfigurationMap;
import androidx.camera.camera2.pipe.CameraMetadata;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class OutputSizesCorrector_Factory implements Factory<OutputSizesCorrector> {
    private final Provider<CameraMetadata> cameraMetadataProvider;
    private final Provider<StreamConfigurationMap> streamConfigurationMapProvider;

    private OutputSizesCorrector_Factory(Provider<CameraMetadata> provider, Provider<StreamConfigurationMap> provider2) {
        this.cameraMetadataProvider = provider;
        this.streamConfigurationMapProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OutputSizesCorrector get() {
        return newInstance(this.cameraMetadataProvider.get(), this.streamConfigurationMapProvider.get());
    }

    public static OutputSizesCorrector_Factory create(Provider<CameraMetadata> provider, Provider<StreamConfigurationMap> provider2) {
        return new OutputSizesCorrector_Factory(provider, provider2);
    }

    public static OutputSizesCorrector newInstance(CameraMetadata cameraMetadata, StreamConfigurationMap streamConfigurationMap) {
        return new OutputSizesCorrector(cameraMetadata, streamConfigurationMap);
    }
}
