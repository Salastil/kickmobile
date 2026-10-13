package androidx.camera.camera2.compat.workaround;

import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.internal.IntrinsicZoomCalculator;
import androidx.camera.camera2.pipe.CameraDevices;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UseTorchAsFlash_Bindings_Companion_ProvideUseTorchAsFlashFactory implements Factory<UseTorchAsFlash> {
    private final Provider<CameraDevices> cameraDevicesProvider;
    private final Provider<CameraQuirks> cameraQuirksProvider;
    private final Provider<IntrinsicZoomCalculator> intrinsicZoomCalculatorProvider;

    private UseTorchAsFlash_Bindings_Companion_ProvideUseTorchAsFlashFactory(Provider<CameraQuirks> provider, Provider<CameraDevices> provider2, Provider<IntrinsicZoomCalculator> provider3) {
        this.cameraQuirksProvider = provider;
        this.cameraDevicesProvider = provider2;
        this.intrinsicZoomCalculatorProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UseTorchAsFlash get() {
        return provideUseTorchAsFlash(this.cameraQuirksProvider.get(), this.cameraDevicesProvider.get(), this.intrinsicZoomCalculatorProvider.get());
    }

    public static UseTorchAsFlash_Bindings_Companion_ProvideUseTorchAsFlashFactory create(Provider<CameraQuirks> provider, Provider<CameraDevices> provider2, Provider<IntrinsicZoomCalculator> provider3) {
        return new UseTorchAsFlash_Bindings_Companion_ProvideUseTorchAsFlashFactory(provider, provider2, provider3);
    }

    public static UseTorchAsFlash provideUseTorchAsFlash(CameraQuirks cameraQuirks, CameraDevices cameraDevices, IntrinsicZoomCalculator intrinsicZoomCalculator) {
        return (UseTorchAsFlash) Preconditions.checkNotNullFromProvides(UseTorchAsFlash.Bindings.INSTANCE.provideUseTorchAsFlash(cameraQuirks, cameraDevices, intrinsicZoomCalculator));
    }
}
