package androidx.camera.camera2.pipe.graph;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.AwbMode;
import androidx.camera.camera2.pipe.FlashMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraphState3A.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¨\u0006\r"}, d2 = {"toCaptureRequestParameterMap", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "", "Landroidx/camera/camera2/pipe/graph/State3A;", "wasAeLocked", "", "current", "wasAeUnlocked", "wasAfLocked", "wasAfUnlocked", "wasAwbLocked", "wasAwbUnlocked", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class GraphState3AKt {
    public static final Map<CaptureRequest.Key<?>, Object> toCaptureRequestParameterMap(State3A state3A) {
        Intrinsics.checkNotNullParameter(state3A, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AeMode aeModeM981getAeModeO_cDUUs = state3A.m981getAeModeO_cDUUs();
        if (aeModeM981getAeModeO_cDUUs != null) {
            int iM160unboximpl = aeModeM981getAeModeO_cDUUs.m160unboximpl();
            CaptureRequest.Key CONTROL_AE_MODE = CaptureRequest.CONTROL_AE_MODE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_MODE, "CONTROL_AE_MODE");
            linkedHashMap.put(CONTROL_AE_MODE, Integer.valueOf(iM160unboximpl));
        }
        AfMode afModeM982getAfMode32_E3BI = state3A.m982getAfMode32_E3BI();
        if (afModeM982getAfMode32_E3BI != null) {
            int iM179unboximpl = afModeM982getAfMode32_E3BI.m179unboximpl();
            CaptureRequest.Key CONTROL_AF_MODE = CaptureRequest.CONTROL_AF_MODE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AF_MODE, "CONTROL_AF_MODE");
            linkedHashMap.put(CONTROL_AF_MODE, Integer.valueOf(iM179unboximpl));
        }
        AwbMode awbModeM983getAwbModeaLFtWSU = state3A.m983getAwbModeaLFtWSU();
        if (awbModeM983getAwbModeaLFtWSU != null) {
            int iM205unboximpl = awbModeM983getAwbModeaLFtWSU.m205unboximpl();
            CaptureRequest.Key CONTROL_AWB_MODE = CaptureRequest.CONTROL_AWB_MODE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
            linkedHashMap.put(CONTROL_AWB_MODE, Integer.valueOf(iM205unboximpl));
        }
        FlashMode flashModeM984getFlashModecL19HE = state3A.m984getFlashModecL19HE();
        if (flashModeM984getFlashModecL19HE != null) {
            int iM486unboximpl = flashModeM984getFlashModecL19HE.m486unboximpl();
            CaptureRequest.Key FLASH_MODE = CaptureRequest.FLASH_MODE;
            Intrinsics.checkNotNullExpressionValue(FLASH_MODE, "FLASH_MODE");
            linkedHashMap.put(FLASH_MODE, Integer.valueOf(iM486unboximpl));
        }
        List<MeteringRectangle> aeRegions = state3A.getAeRegions();
        if (aeRegions != null) {
            CaptureRequest.Key CONTROL_AE_REGIONS = CaptureRequest.CONTROL_AE_REGIONS;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_REGIONS, "CONTROL_AE_REGIONS");
            linkedHashMap.put(CONTROL_AE_REGIONS, aeRegions.toArray(new MeteringRectangle[0]));
        }
        List<MeteringRectangle> afRegions = state3A.getAfRegions();
        if (afRegions != null) {
            CaptureRequest.Key CONTROL_AF_REGIONS = CaptureRequest.CONTROL_AF_REGIONS;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AF_REGIONS, "CONTROL_AF_REGIONS");
            linkedHashMap.put(CONTROL_AF_REGIONS, afRegions.toArray(new MeteringRectangle[0]));
        }
        List<MeteringRectangle> awbRegions = state3A.getAwbRegions();
        if (awbRegions != null) {
            CaptureRequest.Key CONTROL_AWB_REGIONS = CaptureRequest.CONTROL_AWB_REGIONS;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_REGIONS, "CONTROL_AWB_REGIONS");
            linkedHashMap.put(CONTROL_AWB_REGIONS, awbRegions.toArray(new MeteringRectangle[0]));
        }
        Boolean aeLock = state3A.getAeLock();
        if (aeLock != null) {
            aeLock.booleanValue();
            CaptureRequest.Key CONTROL_AE_LOCK = CaptureRequest.CONTROL_AE_LOCK;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_LOCK, "CONTROL_AE_LOCK");
            linkedHashMap.put(CONTROL_AE_LOCK, aeLock);
        }
        Boolean awbLock = state3A.getAwbLock();
        if (awbLock != null) {
            awbLock.booleanValue();
            CaptureRequest.Key CONTROL_AWB_LOCK = CaptureRequest.CONTROL_AWB_LOCK;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_LOCK, "CONTROL_AWB_LOCK");
            linkedHashMap.put(CONTROL_AWB_LOCK, awbLock);
        }
        return linkedHashMap;
    }

    public static final boolean wasAeLocked(State3A state3A, State3A current) {
        Intrinsics.checkNotNullParameter(state3A, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        Boolean aeLock = state3A.getAeLock();
        if (!(aeLock != null ? aeLock.booleanValue() : false)) {
            Boolean aeLock2 = current.getAeLock();
            if (aeLock2 != null ? aeLock2.booleanValue() : false) {
                return true;
            }
        }
        return false;
    }

    public static final boolean wasAeUnlocked(State3A state3A, State3A current) {
        Intrinsics.checkNotNullParameter(state3A, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        Boolean aeLock = state3A.getAeLock();
        if (aeLock != null ? aeLock.booleanValue() : false) {
            Boolean aeLock2 = current.getAeLock();
            if (!(aeLock2 != null ? aeLock2.booleanValue() : false)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean wasAfLocked(State3A state3A, State3A current) {
        Intrinsics.checkNotNullParameter(state3A, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        Boolean afLock = state3A.getAfLock();
        if (!(afLock != null ? afLock.booleanValue() : false)) {
            Boolean afLock2 = current.getAfLock();
            if (afLock2 != null ? afLock2.booleanValue() : false) {
                return true;
            }
        }
        return false;
    }

    public static final boolean wasAfUnlocked(State3A state3A, State3A current) {
        Intrinsics.checkNotNullParameter(state3A, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        Boolean afLock = state3A.getAfLock();
        if (afLock != null ? afLock.booleanValue() : false) {
            Boolean afLock2 = current.getAfLock();
            if (!(afLock2 != null ? afLock2.booleanValue() : false)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean wasAwbLocked(State3A state3A, State3A current) {
        Intrinsics.checkNotNullParameter(state3A, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        Boolean awbLock = state3A.getAwbLock();
        if (!(awbLock != null ? awbLock.booleanValue() : false)) {
            Boolean awbLock2 = current.getAwbLock();
            if (awbLock2 != null ? awbLock2.booleanValue() : false) {
                return true;
            }
        }
        return false;
    }

    public static final boolean wasAwbUnlocked(State3A state3A, State3A current) {
        Intrinsics.checkNotNullParameter(state3A, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        Boolean awbLock = state3A.getAwbLock();
        if (awbLock != null ? awbLock.booleanValue() : false) {
            Boolean awbLock2 = current.getAwbLock();
            if (!(awbLock2 != null ? awbLock2.booleanValue() : false)) {
                return true;
            }
        }
        return false;
    }
}
