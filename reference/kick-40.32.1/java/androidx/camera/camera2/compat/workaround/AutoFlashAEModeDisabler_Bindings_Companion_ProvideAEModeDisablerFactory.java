package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.compat.quirk.CameraQuirks;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AutoFlashAEModeDisabler_Bindings_Companion_ProvideAEModeDisablerFactory implements Factory<AutoFlashAEModeDisabler> {
    private final Provider<CameraQuirks> cameraQuirksProvider;

    private AutoFlashAEModeDisabler_Bindings_Companion_ProvideAEModeDisablerFactory(Provider<CameraQuirks> provider) {
        this.cameraQuirksProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AutoFlashAEModeDisabler get() {
        return provideAEModeDisabler(this.cameraQuirksProvider.get());
    }

    public static AutoFlashAEModeDisabler_Bindings_Companion_ProvideAEModeDisablerFactory create(Provider<CameraQuirks> provider) {
        return new AutoFlashAEModeDisabler_Bindings_Companion_ProvideAEModeDisablerFactory(provider);
    }

    public static AutoFlashAEModeDisabler provideAEModeDisabler(CameraQuirks cameraQuirks) {
        return (AutoFlashAEModeDisabler) Preconditions.checkNotNullFromProvides(AutoFlashAEModeDisabler.Bindings.INSTANCE.provideAEModeDisabler(cameraQuirks));
    }
}
