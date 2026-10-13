package androidx.camera.camera2.config;

import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.core.impl.EncoderProfilesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraModule_Companion_ProvideEncoderProfilesProviderFactory implements Factory<EncoderProfilesProvider> {
    private final Provider<String> cameraIdStringProvider;
    private final Provider<CameraQuirks> cameraQuirksProvider;

    private CameraModule_Companion_ProvideEncoderProfilesProviderFactory(Provider<String> provider, Provider<CameraQuirks> provider2) {
        this.cameraIdStringProvider = provider;
        this.cameraQuirksProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public EncoderProfilesProvider get() {
        return provideEncoderProfilesProvider(this.cameraIdStringProvider.get(), this.cameraQuirksProvider.get());
    }

    public static CameraModule_Companion_ProvideEncoderProfilesProviderFactory create(Provider<String> provider, Provider<CameraQuirks> provider2) {
        return new CameraModule_Companion_ProvideEncoderProfilesProviderFactory(provider, provider2);
    }

    public static EncoderProfilesProvider provideEncoderProfilesProvider(String str, CameraQuirks cameraQuirks) {
        return (EncoderProfilesProvider) Preconditions.checkNotNullFromProvides(CameraModule.INSTANCE.provideEncoderProfilesProvider(str, cameraQuirks));
    }
}
