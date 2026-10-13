package androidx.camera.camera2.compat.quirk;

import androidx.camera.camera2.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.pipe.CameraMetadata;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraQuirks_Factory implements Factory<CameraQuirks> {
    private final Provider<CameraMetadata> cameraMetadataProvider;
    private final Provider<StreamConfigurationMapCompat> streamConfigurationMapCompatProvider;

    private CameraQuirks_Factory(Provider<CameraMetadata> provider, Provider<StreamConfigurationMapCompat> provider2) {
        this.cameraMetadataProvider = provider;
        this.streamConfigurationMapCompatProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraQuirks get() {
        return newInstance(this.cameraMetadataProvider.get(), this.streamConfigurationMapCompatProvider.get());
    }

    public static CameraQuirks_Factory create(Provider<CameraMetadata> provider, Provider<StreamConfigurationMapCompat> provider2) {
        return new CameraQuirks_Factory(provider, provider2);
    }

    public static CameraQuirks newInstance(CameraMetadata cameraMetadata, StreamConfigurationMapCompat streamConfigurationMapCompat) {
        return new CameraQuirks(cameraMetadata, streamConfigurationMapCompat);
    }
}
