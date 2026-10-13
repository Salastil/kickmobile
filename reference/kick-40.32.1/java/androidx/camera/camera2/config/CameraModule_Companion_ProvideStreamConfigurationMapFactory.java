package androidx.camera.camera2.config;

import android.hardware.camera2.params.StreamConfigurationMap;
import androidx.camera.camera2.pipe.CameraMetadata;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraModule_Companion_ProvideStreamConfigurationMapFactory implements Factory<StreamConfigurationMap> {
    private final Provider<CameraMetadata> cameraMetadataProvider;

    private CameraModule_Companion_ProvideStreamConfigurationMapFactory(Provider<CameraMetadata> provider) {
        this.cameraMetadataProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public StreamConfigurationMap get() {
        return provideStreamConfigurationMap(this.cameraMetadataProvider.get());
    }

    public static CameraModule_Companion_ProvideStreamConfigurationMapFactory create(Provider<CameraMetadata> provider) {
        return new CameraModule_Companion_ProvideStreamConfigurationMapFactory(provider);
    }

    public static StreamConfigurationMap provideStreamConfigurationMap(CameraMetadata cameraMetadata) {
        return CameraModule.INSTANCE.provideStreamConfigurationMap(cameraMetadata);
    }
}
