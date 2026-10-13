package androidx.camera.camera2.pipe.config;

import android.content.Context;
import android.content.pm.PackageManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvidePackageManagerFactory implements Factory<PackageManager> {
    private final Provider<Context> cameraPipeContextProvider;

    private CameraPipeModule_Companion_ProvidePackageManagerFactory(Provider<Context> provider) {
        this.cameraPipeContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PackageManager get() {
        return providePackageManager(this.cameraPipeContextProvider.get());
    }

    public static CameraPipeModule_Companion_ProvidePackageManagerFactory create(Provider<Context> provider) {
        return new CameraPipeModule_Companion_ProvidePackageManagerFactory(provider);
    }

    public static PackageManager providePackageManager(Context context) {
        return (PackageManager) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.providePackageManager(context));
    }
}
