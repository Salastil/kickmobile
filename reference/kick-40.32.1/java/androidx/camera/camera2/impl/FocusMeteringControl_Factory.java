package androidx.camera.camera2.impl;

import androidx.camera.camera2.compat.ZoomCompat;
import androidx.camera.camera2.compat.workaround.MeteringRegionCorrection;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FocusMeteringControl_Factory implements Factory<FocusMeteringControl> {
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<MeteringRegionCorrection> meteringRegionCorrectionProvider;
    private final Provider<State3AControl> state3AControlProvider;
    private final Provider<UseCaseThreads> threadsProvider;
    private final Provider<ZoomCompat> zoomCompatProvider;

    private FocusMeteringControl_Factory(Provider<CameraProperties> provider, Provider<MeteringRegionCorrection> provider2, Provider<State3AControl> provider3, Provider<UseCaseThreads> provider4, Provider<ZoomCompat> provider5) {
        this.cameraPropertiesProvider = provider;
        this.meteringRegionCorrectionProvider = provider2;
        this.state3AControlProvider = provider3;
        this.threadsProvider = provider4;
        this.zoomCompatProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FocusMeteringControl get() {
        return newInstance(this.cameraPropertiesProvider.get(), this.meteringRegionCorrectionProvider.get(), this.state3AControlProvider.get(), this.threadsProvider.get(), this.zoomCompatProvider.get());
    }

    public static FocusMeteringControl_Factory create(Provider<CameraProperties> provider, Provider<MeteringRegionCorrection> provider2, Provider<State3AControl> provider3, Provider<UseCaseThreads> provider4, Provider<ZoomCompat> provider5) {
        return new FocusMeteringControl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FocusMeteringControl newInstance(CameraProperties cameraProperties, MeteringRegionCorrection meteringRegionCorrection, State3AControl state3AControl, UseCaseThreads useCaseThreads, ZoomCompat zoomCompat) {
        return new FocusMeteringControl(cameraProperties, meteringRegionCorrection, state3AControl, useCaseThreads, zoomCompat);
    }
}
