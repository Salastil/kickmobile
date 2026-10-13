package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.ZslControl;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.config.CameraConfig;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.core.CameraXConfig;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraGraphConfigProvider_Factory implements Factory<CameraGraphConfigProvider> {
    private final Provider<CameraCallbackMap> callbackMapProvider;
    private final Provider<CameraConfig> cameraConfigProvider;
    private final Provider<CameraInteropStateCallbackRepository> cameraInteropStateCallbackRepositoryProvider;
    private final Provider<CameraMetadata> cameraMetadataProvider;
    private final Provider<CameraQuirks> cameraQuirksProvider;
    private final Provider<CameraXConfig> cameraXConfigProvider;
    private final Provider<ComboRequestListener> requestListenerProvider;
    private final Provider<TemplateParamsOverride> templateParamsOverrideProvider;
    private final Provider<ZslControl> zslControlProvider;

    private CameraGraphConfigProvider_Factory(Provider<CameraCallbackMap> provider, Provider<ComboRequestListener> provider2, Provider<CameraConfig> provider3, Provider<CameraQuirks> provider4, Provider<ZslControl> provider5, Provider<TemplateParamsOverride> provider6, Provider<CameraMetadata> provider7, Provider<CameraXConfig> provider8, Provider<CameraInteropStateCallbackRepository> provider9) {
        this.callbackMapProvider = provider;
        this.requestListenerProvider = provider2;
        this.cameraConfigProvider = provider3;
        this.cameraQuirksProvider = provider4;
        this.zslControlProvider = provider5;
        this.templateParamsOverrideProvider = provider6;
        this.cameraMetadataProvider = provider7;
        this.cameraXConfigProvider = provider8;
        this.cameraInteropStateCallbackRepositoryProvider = provider9;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraGraphConfigProvider get() {
        return newInstance(this.callbackMapProvider.get(), this.requestListenerProvider.get(), this.cameraConfigProvider.get(), this.cameraQuirksProvider.get(), this.zslControlProvider.get(), this.templateParamsOverrideProvider.get(), this.cameraMetadataProvider.get(), this.cameraXConfigProvider.get(), this.cameraInteropStateCallbackRepositoryProvider.get());
    }

    public static CameraGraphConfigProvider_Factory create(Provider<CameraCallbackMap> provider, Provider<ComboRequestListener> provider2, Provider<CameraConfig> provider3, Provider<CameraQuirks> provider4, Provider<ZslControl> provider5, Provider<TemplateParamsOverride> provider6, Provider<CameraMetadata> provider7, Provider<CameraXConfig> provider8, Provider<CameraInteropStateCallbackRepository> provider9) {
        return new CameraGraphConfigProvider_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static CameraGraphConfigProvider newInstance(CameraCallbackMap cameraCallbackMap, ComboRequestListener comboRequestListener, CameraConfig cameraConfig, CameraQuirks cameraQuirks, ZslControl zslControl, TemplateParamsOverride templateParamsOverride, CameraMetadata cameraMetadata, CameraXConfig cameraXConfig, CameraInteropStateCallbackRepository cameraInteropStateCallbackRepository) {
        return new CameraGraphConfigProvider(cameraCallbackMap, comboRequestListener, cameraConfig, cameraQuirks, zslControl, templateParamsOverride, cameraMetadata, cameraXConfig, cameraInteropStateCallbackRepository);
    }
}
