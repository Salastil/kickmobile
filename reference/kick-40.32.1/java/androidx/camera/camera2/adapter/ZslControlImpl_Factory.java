package androidx.camera.camera2.adapter;

import androidx.camera.camera2.impl.CameraProperties;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ZslControlImpl_Factory implements Factory<ZslControlImpl> {
    private final Provider<CameraProperties> cameraPropertiesProvider;

    private ZslControlImpl_Factory(Provider<CameraProperties> provider) {
        this.cameraPropertiesProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ZslControlImpl get() {
        return newInstance(this.cameraPropertiesProvider.get());
    }

    public static ZslControlImpl_Factory create(Provider<CameraProperties> provider) {
        return new ZslControlImpl_Factory(provider);
    }

    public static ZslControlImpl newInstance(CameraProperties cameraProperties) {
        return new ZslControlImpl(cameraProperties);
    }
}
