package androidx.camera.camera2.internal;

import androidx.camera.camera2.pipe.CameraDevices;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class IntrinsicZoomCalculatorImpl_Factory implements Factory<IntrinsicZoomCalculatorImpl> {
    private final Provider<CameraDevices> cameraDevicesProvider;

    private IntrinsicZoomCalculatorImpl_Factory(Provider<CameraDevices> provider) {
        this.cameraDevicesProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IntrinsicZoomCalculatorImpl get() {
        return newInstance(this.cameraDevicesProvider.get());
    }

    public static IntrinsicZoomCalculatorImpl_Factory create(Provider<CameraDevices> provider) {
        return new IntrinsicZoomCalculatorImpl_Factory(provider);
    }

    public static IntrinsicZoomCalculatorImpl newInstance(CameraDevices cameraDevices) {
        return new IntrinsicZoomCalculatorImpl(cameraDevices);
    }
}
