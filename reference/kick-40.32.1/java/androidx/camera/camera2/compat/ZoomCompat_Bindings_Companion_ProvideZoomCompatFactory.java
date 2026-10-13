package androidx.camera.camera2.compat;

import androidx.camera.camera2.impl.CameraProperties;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ZoomCompat_Bindings_Companion_ProvideZoomCompatFactory implements Factory<ZoomCompat> {
    private final Provider<CameraProperties> cameraPropertiesProvider;

    private ZoomCompat_Bindings_Companion_ProvideZoomCompatFactory(Provider<CameraProperties> provider) {
        this.cameraPropertiesProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ZoomCompat get() {
        return provideZoomCompat(this.cameraPropertiesProvider.get());
    }

    public static ZoomCompat_Bindings_Companion_ProvideZoomCompatFactory create(Provider<CameraProperties> provider) {
        return new ZoomCompat_Bindings_Companion_ProvideZoomCompatFactory(provider);
    }

    public static ZoomCompat provideZoomCompat(CameraProperties cameraProperties) {
        return (ZoomCompat) Preconditions.checkNotNullFromProvides(ZoomCompat.Bindings.INSTANCE.provideZoomCompat(cameraProperties));
    }
}
