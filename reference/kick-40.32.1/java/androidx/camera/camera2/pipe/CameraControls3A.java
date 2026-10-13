package androidx.camera.camera2.pipe;

import android.hardware.camera2.params.MeteringRectangle;
import java.util.List;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: CameraControls3A.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001Jm\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&¢\u0006\u0002\b\u0010Jm\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\b\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraControls3A;", "", "update3A", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "aeRegions", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "update3A-ydBZfZg", "submit3A", "submit3A-ydBZfZg", "setTorchOn", "setTorchOff", "setTorchOff-NqN7i0k", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraControls3A {
    /* JADX INFO: renamed from: setTorchOff-NqN7i0k, reason: not valid java name */
    Deferred<Result3A> mo308setTorchOffNqN7i0k(AeMode aeMode);

    Deferred<Result3A> setTorchOn();

    /* JADX INFO: renamed from: submit3A-ydBZfZg, reason: not valid java name */
    Deferred<Result3A> mo309submit3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions);

    /* JADX INFO: renamed from: update3A-ydBZfZg, reason: not valid java name */
    Deferred<Result3A> mo310update3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: update3A-ydBZfZg$default, reason: not valid java name */
    static /* synthetic */ Deferred m307update3AydBZfZg$default(CameraControls3A cameraControls3A, AeMode aeMode, AfMode afMode, AwbMode awbMode, List list, List list2, List list3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update3A-ydBZfZg");
        }
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
            list = null;
        }
        if ((i & 16) != 0) {
            list2 = null;
        }
        if ((i & 32) != 0) {
            list3 = null;
        }
        return cameraControls3A.mo310update3AydBZfZg(aeMode, afMode, awbMode, list, list2, list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: submit3A-ydBZfZg$default, reason: not valid java name */
    static /* synthetic */ Deferred m306submit3AydBZfZg$default(CameraControls3A cameraControls3A, AeMode aeMode, AfMode afMode, AwbMode awbMode, List list, List list2, List list3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submit3A-ydBZfZg");
        }
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
            list = null;
        }
        if ((i & 16) != 0) {
            list2 = null;
        }
        if ((i & 32) != 0) {
            list3 = null;
        }
        return cameraControls3A.mo309submit3AydBZfZg(aeMode, afMode, awbMode, list, list2, list3);
    }

    /* JADX INFO: renamed from: setTorchOff-NqN7i0k$default, reason: not valid java name */
    static /* synthetic */ Deferred m305setTorchOffNqN7i0k$default(CameraControls3A cameraControls3A, AeMode aeMode, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTorchOff-NqN7i0k");
        }
        if ((i & 1) != 0) {
            aeMode = null;
        }
        return cameraControls3A.mo308setTorchOffNqN7i0k(aeMode);
    }
}
