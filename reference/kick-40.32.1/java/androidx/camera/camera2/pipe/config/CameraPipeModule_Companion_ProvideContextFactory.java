package androidx.camera.camera2.pipe.config;

import android.content.Context;
import androidx.camera.camera2.pipe.CameraPipe;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideContextFactory implements Factory<Context> {
    private final Provider<CameraPipe.Config> configProvider;

    private CameraPipeModule_Companion_ProvideContextFactory(Provider<CameraPipe.Config> provider) {
        this.configProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Context get() {
        return provideContext(this.configProvider.get());
    }

    public static CameraPipeModule_Companion_ProvideContextFactory create(Provider<CameraPipe.Config> provider) {
        return new CameraPipeModule_Companion_ProvideContextFactory(provider);
    }

    public static Context provideContext(CameraPipe.Config config) {
        return (Context) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideContext(config));
    }
}
