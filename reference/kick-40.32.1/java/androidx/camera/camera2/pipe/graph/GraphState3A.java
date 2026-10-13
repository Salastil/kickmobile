package androidx.camera.camera2.pipe.graph;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.AwbMode;
import androidx.camera.camera2.pipe.FlashMode;
import androidx.camera.camera2.pipe.config.CameraGraphScope;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;

/* JADX INFO: compiled from: GraphState3A.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0097\u0001\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030$\u0012\u0004\u0012\u00020\u00010#R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006%"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphState3A;", "", "<init>", "()V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/graph/State3A;", "value", "current", "getCurrent", "()Landroidx/camera/camera2/pipe/graph/State3A;", "setCurrent", "(Landroidx/camera/camera2/pipe/graph/State3A;)V", "update", "", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "flashMode", "Landroidx/camera/camera2/pipe/FlashMode;", "aeRegions", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "aeLock", "", "afLock", "awbLock", "update-7jOEVJU", "(Landroidx/camera/camera2/pipe/AeMode;Landroidx/camera/camera2/pipe/AfMode;Landroidx/camera/camera2/pipe/AwbMode;Landroidx/camera/camera2/pipe/FlashMode;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "toCaptureRequestParametersMap", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GraphState3A {
    private final AtomicRef<State3A> _state = AtomicFU.atomic(new State3A(null, null, null, null, null, null, null, null, null, null, 1023, null));

    @Inject
    public GraphState3A() {
    }

    public final State3A getCurrent() {
        return this._state.getValue();
    }

    public final void setCurrent(State3A value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._state.setValue(value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: update-7jOEVJU$default, reason: not valid java name */
    public static /* synthetic */ void m963update7jOEVJU$default(GraphState3A graphState3A, AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, List list, List list2, List list3, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            aeMode = null;
        }
        if ((i & 2) != 0) {
            afMode = null;
        }
        if ((i & 4) != 0) {
            awbMode = null;
        }
        if ((i & 8) != 0) {
            flashMode = null;
        }
        if ((i & 16) != 0) {
            list = null;
        }
        if ((i & 32) != 0) {
            list2 = null;
        }
        if ((i & 64) != 0) {
            list3 = null;
        }
        if ((i & 128) != 0) {
            bool = null;
        }
        if ((i & 256) != 0) {
            bool2 = null;
        }
        if ((i & 512) != 0) {
            bool3 = null;
        }
        graphState3A.m964update7jOEVJU(aeMode, afMode, awbMode, flashMode, list, list2, list3, bool, bool2, bool3);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0052  */
    /* JADX WARN: Code duplicated, block: B:38:0x0068  */
    /* JADX INFO: renamed from: update-7jOEVJU, reason: not valid java name */
    public final void m964update7jOEVJU(AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions, Boolean aeLock, Boolean afLock, Boolean awbLock) {
        State3A value;
        State3A state3A;
        AeMode aeModeM981getAeModeO_cDUUs;
        AfMode afModeM982getAfMode32_E3BI;
        AwbMode awbModeM983getAwbModeaLFtWSU;
        FlashMode flashModeM984getFlashModecL19HE;
        List<MeteringRectangle> aeRegions2;
        List<MeteringRectangle> afRegions2;
        List<MeteringRectangle> awbRegions2;
        Boolean aeLock2;
        Boolean afLock2;
        List<MeteringRectangle> list;
        Boolean awbLock2;
        AtomicRef<State3A> atomicRef = this._state;
        do {
            value = atomicRef.getValue();
            state3A = value;
            aeModeM981getAeModeO_cDUUs = aeMode == null ? state3A.m981getAeModeO_cDUUs() : aeMode;
            afModeM982getAfMode32_E3BI = afMode == null ? state3A.m982getAfMode32_E3BI() : afMode;
            awbModeM983getAwbModeaLFtWSU = awbMode == null ? state3A.m983getAwbModeaLFtWSU() : awbMode;
            flashModeM984getFlashModecL19HE = flashMode == null ? state3A.m984getFlashModecL19HE() : flashMode;
            if (aeRegions != null) {
                List<MeteringRectangle> list2 = aeRegions;
                if (list2.isEmpty()) {
                    list2 = null;
                }
                aeRegions2 = list2;
                if (aeRegions2 == null) {
                    aeRegions2 = state3A.getAeRegions();
                }
            } else {
                aeRegions2 = state3A.getAeRegions();
            }
            if (afRegions != null) {
                List<MeteringRectangle> list3 = afRegions;
                if (list3.isEmpty()) {
                    list3 = null;
                }
                afRegions2 = list3;
                if (afRegions2 == null) {
                    afRegions2 = state3A.getAfRegions();
                }
            } else {
                afRegions2 = state3A.getAfRegions();
            }
            if (awbRegions != null) {
                List<MeteringRectangle> list4 = awbRegions;
                awbRegions2 = list4.isEmpty() ? null : list4;
                if (awbRegions2 == null) {
                    awbRegions2 = state3A.getAwbRegions();
                }
            } else {
                awbRegions2 = state3A.getAwbRegions();
            }
            aeLock2 = aeLock == null ? state3A.getAeLock() : aeLock;
            afLock2 = afLock == null ? state3A.getAfLock() : afLock;
            if (awbLock == null) {
                awbLock2 = state3A.getAwbLock();
                list = afRegions2;
            } else {
                list = afRegions2;
                awbLock2 = awbLock;
            }
        } while (!atomicRef.compareAndSet(value, state3A.m980copy7jOEVJU(aeModeM981getAeModeO_cDUUs, afModeM982getAfMode32_E3BI, awbModeM983getAwbModeaLFtWSU, flashModeM984getFlashModecL19HE, aeRegions2, list, awbRegions2, aeLock2, afLock2, awbLock2)));
    }

    public final Map<CaptureRequest.Key<?>, Object> toCaptureRequestParametersMap() {
        return GraphState3AKt.toCaptureRequestParameterMap(getCurrent());
    }
}
