package androidx.camera.camera2.adapter;

import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.EvCompControl;
import androidx.camera.camera2.impl.FlashControl;
import androidx.camera.camera2.impl.FocusMeteringControl;
import androidx.camera.camera2.impl.LowLightBoostControl;
import androidx.camera.camera2.impl.StillCaptureRequestControl;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.impl.UseCaseManager;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.camera2.impl.VideoUsageControl;
import androidx.camera.camera2.impl.ZoomControl;
import androidx.camera.camera2.interop.Camera2CameraControl;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CameraControlAdapter_Factory implements Factory<CameraControlAdapter> {
    private final Provider<Camera2CameraControl> camera2cameraControlProvider;
    private final Provider<CameraProperties> cameraPropertiesProvider;
    private final Provider<EvCompControl> evCompControlProvider;
    private final Provider<FlashControl> flashControlProvider;
    private final Provider<FocusMeteringControl> focusMeteringControlProvider;
    private final Provider<LowLightBoostControl> lowLightBoostControlProvider;
    private final Provider<StillCaptureRequestControl> stillCaptureRequestControlProvider;
    private final Provider<UseCaseThreads> threadsProvider;
    private final Provider<TorchControl> torchControlProvider;
    private final Provider<UseCaseManager> useCaseManagerProvider;
    private final Provider<VideoUsageControl> videoUsageControlProvider;
    private final Provider<ZoomControl> zoomControlProvider;
    private final Provider<ZslControl> zslControlProvider;

    private CameraControlAdapter_Factory(Provider<CameraProperties> provider, Provider<EvCompControl> provider2, Provider<FlashControl> provider3, Provider<FocusMeteringControl> provider4, Provider<StillCaptureRequestControl> provider5, Provider<TorchControl> provider6, Provider<LowLightBoostControl> provider7, Provider<ZoomControl> provider8, Provider<ZslControl> provider9, Provider<Camera2CameraControl> provider10, Provider<UseCaseManager> provider11, Provider<UseCaseThreads> provider12, Provider<VideoUsageControl> provider13) {
        this.cameraPropertiesProvider = provider;
        this.evCompControlProvider = provider2;
        this.flashControlProvider = provider3;
        this.focusMeteringControlProvider = provider4;
        this.stillCaptureRequestControlProvider = provider5;
        this.torchControlProvider = provider6;
        this.lowLightBoostControlProvider = provider7;
        this.zoomControlProvider = provider8;
        this.zslControlProvider = provider9;
        this.camera2cameraControlProvider = provider10;
        this.useCaseManagerProvider = provider11;
        this.threadsProvider = provider12;
        this.videoUsageControlProvider = provider13;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraControlAdapter get() {
        return newInstance(this.cameraPropertiesProvider.get(), this.evCompControlProvider.get(), this.flashControlProvider.get(), this.focusMeteringControlProvider.get(), this.stillCaptureRequestControlProvider.get(), this.torchControlProvider.get(), this.lowLightBoostControlProvider.get(), this.zoomControlProvider.get(), this.zslControlProvider.get(), this.camera2cameraControlProvider.get(), this.useCaseManagerProvider.get(), this.threadsProvider.get(), this.videoUsageControlProvider.get());
    }

    public static CameraControlAdapter_Factory create(Provider<CameraProperties> provider, Provider<EvCompControl> provider2, Provider<FlashControl> provider3, Provider<FocusMeteringControl> provider4, Provider<StillCaptureRequestControl> provider5, Provider<TorchControl> provider6, Provider<LowLightBoostControl> provider7, Provider<ZoomControl> provider8, Provider<ZslControl> provider9, Provider<Camera2CameraControl> provider10, Provider<UseCaseManager> provider11, Provider<UseCaseThreads> provider12, Provider<VideoUsageControl> provider13) {
        return new CameraControlAdapter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static CameraControlAdapter newInstance(CameraProperties cameraProperties, EvCompControl evCompControl, FlashControl flashControl, FocusMeteringControl focusMeteringControl, StillCaptureRequestControl stillCaptureRequestControl, TorchControl torchControl, LowLightBoostControl lowLightBoostControl, ZoomControl zoomControl, ZslControl zslControl, Camera2CameraControl camera2CameraControl, UseCaseManager useCaseManager, UseCaseThreads useCaseThreads, VideoUsageControl videoUsageControl) {
        return new CameraControlAdapter(cameraProperties, evCompControl, flashControl, focusMeteringControl, stillCaptureRequestControl, torchControl, lowLightBoostControl, zoomControl, zslControl, camera2CameraControl, useCaseManager, useCaseThreads, videoUsageControl);
    }
}
