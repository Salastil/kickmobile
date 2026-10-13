package androidx.camera.camera2.adapter;

import androidx.camera.camera2.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.config.UseCaseGraphContext;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.UseCaseThreads;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CaptureConfigAdapter_Factory implements Factory<CaptureConfigAdapter> {
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<TemplateParamsOverride> templateParamsOverrideProvider;
    private final Provider<UseCaseThreads> threadsProvider;
    private final Provider<UseCaseGraphContext> useCaseGraphContextProvider;
    private final Provider<ZslControl> zslControlProvider;

    private CaptureConfigAdapter_Factory(Provider<CameraProperties> provider, Provider<UseCaseGraphContext> provider2, Provider<ZslControl> provider3, Provider<UseCaseThreads> provider4, Provider<TemplateParamsOverride> provider5) {
        this.cameraPropertiesProvider = provider;
        this.useCaseGraphContextProvider = provider2;
        this.zslControlProvider = provider3;
        this.threadsProvider = provider4;
        this.templateParamsOverrideProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureConfigAdapter get() {
        return newInstance(this.cameraPropertiesProvider.get(), this.useCaseGraphContextProvider.get(), this.zslControlProvider.get(), this.threadsProvider.get(), this.templateParamsOverrideProvider.get());
    }

    public static CaptureConfigAdapter_Factory create(Provider<CameraProperties> provider, Provider<UseCaseGraphContext> provider2, Provider<ZslControl> provider3, Provider<UseCaseThreads> provider4, Provider<TemplateParamsOverride> provider5) {
        return new CaptureConfigAdapter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CaptureConfigAdapter newInstance(CameraProperties cameraProperties, UseCaseGraphContext useCaseGraphContext, ZslControl zslControl, UseCaseThreads useCaseThreads, TemplateParamsOverride templateParamsOverride) {
        return new CaptureConfigAdapter(cameraProperties, useCaseGraphContext, zslControl, useCaseThreads, templateParamsOverride);
    }
}
