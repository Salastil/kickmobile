package androidx.camera.camera2.adapter;

import androidx.camera.camera2.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.config.CameraConfig;
import androidx.camera.camera2.impl.CameraCallbackMap;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.FocusMeteringControl;
import androidx.camera.camera2.internal.IntrinsicZoomCalculator;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.internal.StreamSpecsCalculator;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraInfoAdapter_Factory implements Factory<CameraInfoAdapter> {
    private final Provider<CameraCallbackMap> cameraCallbackMapProvider;
    private final Provider<CameraConfig> cameraConfigProvider;
    private final Provider<CameraControlStateAdapter> cameraControlStateAdapterProvider;
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<CameraQuirks> cameraQuirksProvider;
    private final Provider<CameraStateAdapter> cameraStateAdapterProvider;
    private final Provider<EncoderProfilesProvider> encoderProfilesProvider;
    private final Provider<FocusMeteringControl> focusMeteringControlProvider;
    private final Provider<IntrinsicZoomCalculator> intrinsicZoomCalculatorProvider;
    private final Provider<StreamConfigurationMapCompat> streamConfigurationMapCompatProvider;
    private final Provider<StreamSpecsCalculator> streamSpecsCalculatorProvider;

    private CameraInfoAdapter_Factory(Provider<CameraProperties> provider, Provider<CameraConfig> provider2, Provider<CameraStateAdapter> provider3, Provider<CameraControlStateAdapter> provider4, Provider<CameraCallbackMap> provider5, Provider<FocusMeteringControl> provider6, Provider<CameraQuirks> provider7, Provider<EncoderProfilesProvider> provider8, Provider<StreamConfigurationMapCompat> provider9, Provider<IntrinsicZoomCalculator> provider10, Provider<StreamSpecsCalculator> provider11) {
        this.cameraPropertiesProvider = provider;
        this.cameraConfigProvider = provider2;
        this.cameraStateAdapterProvider = provider3;
        this.cameraControlStateAdapterProvider = provider4;
        this.cameraCallbackMapProvider = provider5;
        this.focusMeteringControlProvider = provider6;
        this.cameraQuirksProvider = provider7;
        this.encoderProfilesProvider = provider8;
        this.streamConfigurationMapCompatProvider = provider9;
        this.intrinsicZoomCalculatorProvider = provider10;
        this.streamSpecsCalculatorProvider = provider11;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraInfoAdapter get() {
        return newInstance(this.cameraPropertiesProvider.get(), this.cameraConfigProvider.get(), this.cameraStateAdapterProvider.get(), this.cameraControlStateAdapterProvider.get(), this.cameraCallbackMapProvider.get(), this.focusMeteringControlProvider.get(), this.cameraQuirksProvider.get(), this.encoderProfilesProvider.get(), this.streamConfigurationMapCompatProvider.get(), this.intrinsicZoomCalculatorProvider.get(), this.streamSpecsCalculatorProvider.get());
    }

    public static CameraInfoAdapter_Factory create(Provider<CameraProperties> provider, Provider<CameraConfig> provider2, Provider<CameraStateAdapter> provider3, Provider<CameraControlStateAdapter> provider4, Provider<CameraCallbackMap> provider5, Provider<FocusMeteringControl> provider6, Provider<CameraQuirks> provider7, Provider<EncoderProfilesProvider> provider8, Provider<StreamConfigurationMapCompat> provider9, Provider<IntrinsicZoomCalculator> provider10, Provider<StreamSpecsCalculator> provider11) {
        return new CameraInfoAdapter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static CameraInfoAdapter newInstance(CameraProperties cameraProperties, CameraConfig cameraConfig, CameraStateAdapter cameraStateAdapter, CameraControlStateAdapter cameraControlStateAdapter, CameraCallbackMap cameraCallbackMap, FocusMeteringControl focusMeteringControl, CameraQuirks cameraQuirks, EncoderProfilesProvider encoderProfilesProvider, StreamConfigurationMapCompat streamConfigurationMapCompat, IntrinsicZoomCalculator intrinsicZoomCalculator, StreamSpecsCalculator streamSpecsCalculator) {
        return new CameraInfoAdapter(cameraProperties, cameraConfig, cameraStateAdapter, cameraControlStateAdapter, cameraCallbackMap, focusMeteringControl, cameraQuirks, encoderProfilesProvider, streamConfigurationMapCompat, intrinsicZoomCalculator, streamSpecsCalculator);
    }
}
