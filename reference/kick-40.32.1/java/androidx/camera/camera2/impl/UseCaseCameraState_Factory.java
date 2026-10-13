package androidx.camera.camera2.impl;

import androidx.camera.camera2.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.config.UseCaseGraphContext;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UseCaseCameraState_Factory implements Factory<UseCaseCameraState> {
    private final Provider<TemplateParamsOverride> templateParamsOverrideProvider;
    private final Provider<UseCaseGraphContext> useCaseGraphContextProvider;

    private UseCaseCameraState_Factory(Provider<UseCaseGraphContext> provider, Provider<TemplateParamsOverride> provider2) {
        this.useCaseGraphContextProvider = provider;
        this.templateParamsOverrideProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UseCaseCameraState get() {
        return newInstance(this.useCaseGraphContextProvider.get(), this.templateParamsOverrideProvider.get());
    }

    public static UseCaseCameraState_Factory create(Provider<UseCaseGraphContext> provider, Provider<TemplateParamsOverride> provider2) {
        return new UseCaseCameraState_Factory(provider, provider2);
    }

    public static UseCaseCameraState newInstance(UseCaseGraphContext useCaseGraphContext, TemplateParamsOverride templateParamsOverride) {
        return new UseCaseCameraState(useCaseGraphContext, templateParamsOverride);
    }
}
