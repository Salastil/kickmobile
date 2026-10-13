package androidx.camera.camera2.pipe.config;

import android.content.Context;
import androidx.camera.camera2.pipe.compat.DevicePolicyManagerWrapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraPipeModule_Companion_ProvideDevicePolicyManagerWrapperFactory implements Factory<DevicePolicyManagerWrapper> {
    private final Provider<Context> cameraPipeContextProvider;

    private CameraPipeModule_Companion_ProvideDevicePolicyManagerWrapperFactory(Provider<Context> provider) {
        this.cameraPipeContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DevicePolicyManagerWrapper get() {
        return provideDevicePolicyManagerWrapper(this.cameraPipeContextProvider.get());
    }

    public static CameraPipeModule_Companion_ProvideDevicePolicyManagerWrapperFactory create(Provider<Context> provider) {
        return new CameraPipeModule_Companion_ProvideDevicePolicyManagerWrapperFactory(provider);
    }

    public static DevicePolicyManagerWrapper provideDevicePolicyManagerWrapper(Context context) {
        return (DevicePolicyManagerWrapper) Preconditions.checkNotNullFromProvides(CameraPipeModule.INSTANCE.provideDevicePolicyManagerWrapper(context));
    }
}
