package androidx.camera.camera2.pipe.config;

import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.StrictMode;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideStrictModeFactory implements Factory<StrictMode> {
    private final Provider<CameraPipe.Flags> flagsProvider;

    private CameraPipeModule_Companion_ProvideStrictModeFactory(Provider<CameraPipe.Flags> provider) {
        this.flagsProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public StrictMode get() {
        return provideStrictMode(this.flagsProvider.get());
    }

    public static CameraPipeModule_Companion_ProvideStrictModeFactory create(Provider<CameraPipe.Flags> provider) {
        return new CameraPipeModule_Companion_ProvideStrictModeFactory(provider);
    }

    public static StrictMode provideStrictMode(CameraPipe.Flags flags) {
        return (StrictMode) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideStrictMode(flags));
    }
}
