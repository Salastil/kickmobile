package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.compat.quirk.CameraQuirks;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class MeteringRegionCorrection_Bindings_Companion_ProvideMeteringRegionCorrectionFactory implements Factory<MeteringRegionCorrection> {
    private final Provider<CameraQuirks> cameraQuirksProvider;

    private MeteringRegionCorrection_Bindings_Companion_ProvideMeteringRegionCorrectionFactory(Provider<CameraQuirks> provider) {
        this.cameraQuirksProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MeteringRegionCorrection get() {
        return provideMeteringRegionCorrection(this.cameraQuirksProvider.get());
    }

    public static MeteringRegionCorrection_Bindings_Companion_ProvideMeteringRegionCorrectionFactory create(Provider<CameraQuirks> provider) {
        return new MeteringRegionCorrection_Bindings_Companion_ProvideMeteringRegionCorrectionFactory(provider);
    }

    public static MeteringRegionCorrection provideMeteringRegionCorrection(CameraQuirks cameraQuirks) {
        return (MeteringRegionCorrection) Preconditions.checkNotNullFromProvides(MeteringRegionCorrection.Bindings.INSTANCE.provideMeteringRegionCorrection(cameraQuirks));
    }
}
