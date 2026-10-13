package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.CameraBackends;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraDevicesImpl_Factory implements Factory<CameraDevicesImpl> {
    private final Provider<CameraBackends> cameraBackendsProvider;

    private CameraDevicesImpl_Factory(Provider<CameraBackends> provider) {
        this.cameraBackendsProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraDevicesImpl get() {
        return newInstance(this.cameraBackendsProvider.get());
    }

    public static CameraDevicesImpl_Factory create(Provider<CameraBackends> provider) {
        return new CameraDevicesImpl_Factory(provider);
    }

    public static CameraDevicesImpl newInstance(CameraBackends cameraBackends) {
        return new CameraDevicesImpl(cameraBackends);
    }
}
