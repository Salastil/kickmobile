package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.compat.quirk.CameraQuirks;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class TemplateParamsOverride_Bindings_Companion_ProvideTemplateParamsOverrideFactory implements Factory<TemplateParamsOverride> {
    private final Provider<CameraQuirks> cameraQuirksProvider;

    private TemplateParamsOverride_Bindings_Companion_ProvideTemplateParamsOverrideFactory(Provider<CameraQuirks> provider) {
        this.cameraQuirksProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TemplateParamsOverride get() {
        return provideTemplateParamsOverride(this.cameraQuirksProvider.get());
    }

    public static TemplateParamsOverride_Bindings_Companion_ProvideTemplateParamsOverrideFactory create(Provider<CameraQuirks> provider) {
        return new TemplateParamsOverride_Bindings_Companion_ProvideTemplateParamsOverrideFactory(provider);
    }

    public static TemplateParamsOverride provideTemplateParamsOverride(CameraQuirks cameraQuirks) {
        return (TemplateParamsOverride) Preconditions.checkNotNullFromProvides(TemplateParamsOverride.Bindings.INSTANCE.provideTemplateParamsOverride(cameraQuirks));
    }
}
