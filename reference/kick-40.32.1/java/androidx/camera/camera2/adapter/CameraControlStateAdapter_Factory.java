package androidx.camera.camera2.adapter;

import androidx.camera.camera2.impl.EvCompControl;
import androidx.camera.camera2.impl.LowLightBoostControl;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.impl.ZoomControl;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraControlStateAdapter_Factory implements Factory<CameraControlStateAdapter> {
    private final Provider<EvCompControl> evCompControlProvider;
    private final Provider<LowLightBoostControl> lowLightBoostControlProvider;
    private final Provider<TorchControl> torchControlProvider;
    private final Provider<ZoomControl> zoomControlProvider;

    private CameraControlStateAdapter_Factory(Provider<ZoomControl> provider, Provider<EvCompControl> provider2, Provider<TorchControl> provider3, Provider<LowLightBoostControl> provider4) {
        this.zoomControlProvider = provider;
        this.evCompControlProvider = provider2;
        this.torchControlProvider = provider3;
        this.lowLightBoostControlProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraControlStateAdapter get() {
        return newInstance(this.zoomControlProvider.get(), this.evCompControlProvider.get(), this.torchControlProvider.get(), this.lowLightBoostControlProvider.get());
    }

    public static CameraControlStateAdapter_Factory create(Provider<ZoomControl> provider, Provider<EvCompControl> provider2, Provider<TorchControl> provider3, Provider<LowLightBoostControl> provider4) {
        return new CameraControlStateAdapter_Factory(provider, provider2, provider3, provider4);
    }

    public static CameraControlStateAdapter newInstance(ZoomControl zoomControl, EvCompControl evCompControl, TorchControl torchControl, LowLightBoostControl lowLightBoostControl) {
        return new CameraControlStateAdapter(zoomControl, evCompControl, torchControl, lowLightBoostControl);
    }
}
