package androidx.camera.camera2.adapter;

import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.impl.EvCompControl;
import androidx.camera.camera2.impl.LowLightBoostControl;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.impl.ZoomControl;
import androidx.camera.core.ExposureState;
import androidx.camera.core.ZoomState;
import androidx.lifecycle.LiveData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraControlStateAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010¨\u0006\u001c"}, d2 = {"Landroidx/camera/camera2/adapter/CameraControlStateAdapter;", "", "zoomControl", "Landroidx/camera/camera2/impl/ZoomControl;", "evCompControl", "Landroidx/camera/camera2/impl/EvCompControl;", "torchControl", "Landroidx/camera/camera2/impl/TorchControl;", "lowLightBoostControl", "Landroidx/camera/camera2/impl/LowLightBoostControl;", "<init>", "(Landroidx/camera/camera2/impl/ZoomControl;Landroidx/camera/camera2/impl/EvCompControl;Landroidx/camera/camera2/impl/TorchControl;Landroidx/camera/camera2/impl/LowLightBoostControl;)V", "torchStateLiveData", "Landroidx/lifecycle/LiveData;", "", "getTorchStateLiveData", "()Landroidx/lifecycle/LiveData;", "torchStrengthLiveData", "getTorchStrengthLiveData", "zoomStateLiveData", "Landroidx/camera/core/ZoomState;", "getZoomStateLiveData", "exposureState", "Landroidx/camera/core/ExposureState;", "getExposureState", "()Landroidx/camera/core/ExposureState;", "lowLightBoostState", "getLowLightBoostState", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraControlStateAdapter {
    private final EvCompControl evCompControl;
    private final LowLightBoostControl lowLightBoostControl;
    private final TorchControl torchControl;
    private final ZoomControl zoomControl;

    @Inject
    public CameraControlStateAdapter(ZoomControl zoomControl, EvCompControl evCompControl, TorchControl torchControl, LowLightBoostControl lowLightBoostControl) {
        Intrinsics.checkNotNullParameter(zoomControl, "zoomControl");
        Intrinsics.checkNotNullParameter(evCompControl, "evCompControl");
        Intrinsics.checkNotNullParameter(torchControl, "torchControl");
        Intrinsics.checkNotNullParameter(lowLightBoostControl, "lowLightBoostControl");
        this.zoomControl = zoomControl;
        this.evCompControl = evCompControl;
        this.torchControl = torchControl;
        this.lowLightBoostControl = lowLightBoostControl;
    }

    public final LiveData<Integer> getTorchStateLiveData() {
        return this.torchControl.getTorchStateLiveData();
    }

    public final LiveData<Integer> getTorchStrengthLiveData() {
        return this.torchControl.getTorchStrengthLiveData();
    }

    public final LiveData<ZoomState> getZoomStateLiveData() {
        return this.zoomControl.getZoomStateLiveData();
    }

    public final ExposureState getExposureState() {
        return this.evCompControl.getExposureState();
    }

    public final LiveData<Integer> getLowLightBoostState() {
        return this.lowLightBoostControl.getLowLightBoostStateLiveData();
    }
}
