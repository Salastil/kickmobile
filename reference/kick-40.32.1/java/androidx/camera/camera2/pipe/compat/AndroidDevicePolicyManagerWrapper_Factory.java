package androidx.camera.camera2.pipe.compat;

import android.app.admin.DevicePolicyManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidDevicePolicyManagerWrapper_Factory implements Factory<AndroidDevicePolicyManagerWrapper> {
    private final Provider<DevicePolicyManager> devicePolicyManagerProvider;

    private AndroidDevicePolicyManagerWrapper_Factory(Provider<DevicePolicyManager> provider) {
        this.devicePolicyManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AndroidDevicePolicyManagerWrapper get() {
        return newInstance(this.devicePolicyManagerProvider.get());
    }

    public static AndroidDevicePolicyManagerWrapper_Factory create(Provider<DevicePolicyManager> provider) {
        return new AndroidDevicePolicyManagerWrapper_Factory(provider);
    }

    public static AndroidDevicePolicyManagerWrapper newInstance(DevicePolicyManager devicePolicyManager) {
        return new AndroidDevicePolicyManagerWrapper(devicePolicyManager);
    }
}
