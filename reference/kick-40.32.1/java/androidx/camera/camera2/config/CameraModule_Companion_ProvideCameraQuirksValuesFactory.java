package androidx.camera.camera2.config;

import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.core.impl.Quirks;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraModule_Companion_ProvideCameraQuirksValuesFactory implements Factory<Quirks> {
    private final Provider<CameraQuirks> cameraQuirksProvider;

    private CameraModule_Companion_ProvideCameraQuirksValuesFactory(Provider<CameraQuirks> provider) {
        this.cameraQuirksProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Quirks get() {
        return provideCameraQuirksValues(this.cameraQuirksProvider.get());
    }

    public static CameraModule_Companion_ProvideCameraQuirksValuesFactory create(Provider<CameraQuirks> provider) {
        return new CameraModule_Companion_ProvideCameraQuirksValuesFactory(provider);
    }

    public static Quirks provideCameraQuirksValues(CameraQuirks cameraQuirks) {
        return (Quirks) Preconditions.checkNotNullFromProvides(CameraModule.INSTANCE.provideCameraQuirksValues(cameraQuirks));
    }
}
