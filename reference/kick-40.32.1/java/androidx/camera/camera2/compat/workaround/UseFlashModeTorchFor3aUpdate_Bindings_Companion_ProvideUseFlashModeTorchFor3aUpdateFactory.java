package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.compat.quirk.CameraQuirks;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UseFlashModeTorchFor3aUpdate_Bindings_Companion_ProvideUseFlashModeTorchFor3aUpdateFactory implements Factory<UseFlashModeTorchFor3aUpdate> {
    private final Provider<CameraQuirks> cameraQuirksProvider;

    private UseFlashModeTorchFor3aUpdate_Bindings_Companion_ProvideUseFlashModeTorchFor3aUpdateFactory(Provider<CameraQuirks> provider) {
        this.cameraQuirksProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UseFlashModeTorchFor3aUpdate get() {
        return provideUseFlashModeTorchFor3aUpdate(this.cameraQuirksProvider.get());
    }

    public static UseFlashModeTorchFor3aUpdate_Bindings_Companion_ProvideUseFlashModeTorchFor3aUpdateFactory create(Provider<CameraQuirks> provider) {
        return new UseFlashModeTorchFor3aUpdate_Bindings_Companion_ProvideUseFlashModeTorchFor3aUpdateFactory(provider);
    }

    public static UseFlashModeTorchFor3aUpdate provideUseFlashModeTorchFor3aUpdate(CameraQuirks cameraQuirks) {
        return (UseFlashModeTorchFor3aUpdate) Preconditions.checkNotNullFromProvides(UseFlashModeTorchFor3aUpdate.Bindings.INSTANCE.provideUseFlashModeTorchFor3aUpdate(cameraQuirks));
    }
}
