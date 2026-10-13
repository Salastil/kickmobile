package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraMetadataIntegration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\n\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002\u001a\u0012\u0010\f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0002\u001a\n\u0010\u0010\u001a\u00020\u000e*\u00020\u0003\u001a\u0012\u0010\u0011\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002\u001a-\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u0016\u001a\u0002H\u0013¢\u0006\u0002\u0010\u0017\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u0018"}, d2 = {"availableAfModes", "", "", "Landroidx/camera/camera2/pipe/CameraMetadata;", "getAvailableAfModes", "(Landroidx/camera/camera2/pipe/CameraMetadata;)Ljava/util/List;", "availableAeModes", "getAvailableAeModes", "availableAwbModes", "getAvailableAwbModes", "getSupportedAfMode", "preferredMode", "getSupportedAeMode", "isAeModeSupported", "", "aeMode", "isExternalFlashAeModeSupported", "getSupportedAwbMode", "getOrDefault", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroid/hardware/camera2/CameraCharacteristics$Key;", Constants.COLLATION_DEFAULT, "(Landroidx/camera/camera2/pipe/CameraMetadata;Landroid/hardware/camera2/CameraCharacteristics$Key;Ljava/lang/Object;)Ljava/lang/Object;", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CameraMetadataIntegrationKt {
    public static final List<Integer> getAvailableAfModes(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        CameraCharacteristics.Key CONTROL_AF_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AF_AVAILABLE_MODES, "CONTROL_AF_AVAILABLE_MODES");
        Object orDefault = cameraMetadata.getOrDefault((CameraCharacteristics.Key<int[]>) CONTROL_AF_AVAILABLE_MODES, new int[]{0});
        Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
        return ArraysKt.asList((int[]) orDefault);
    }

    public static final List<Integer> getAvailableAeModes(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        CameraCharacteristics.Key CONTROL_AE_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AE_AVAILABLE_MODES, "CONTROL_AE_AVAILABLE_MODES");
        Object orDefault = cameraMetadata.getOrDefault((CameraCharacteristics.Key<int[]>) CONTROL_AE_AVAILABLE_MODES, new int[]{0});
        Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
        return ArraysKt.asList((int[]) orDefault);
    }

    public static final List<Integer> getAvailableAwbModes(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        CameraCharacteristics.Key CONTROL_AWB_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_AVAILABLE_MODES, "CONTROL_AWB_AVAILABLE_MODES");
        Object orDefault = cameraMetadata.getOrDefault((CameraCharacteristics.Key<int[]>) CONTROL_AWB_AVAILABLE_MODES, new int[]{0});
        Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
        return ArraysKt.asList((int[]) orDefault);
    }

    public static final int getSupportedAfMode(CameraMetadata cameraMetadata, int i) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        if (getAvailableAfModes(cameraMetadata).contains(Integer.valueOf(i))) {
            return i;
        }
        if (getAvailableAfModes(cameraMetadata).contains(4)) {
            return 4;
        }
        return getAvailableAfModes(cameraMetadata).contains(1) ? 1 : 0;
    }

    public static final int getSupportedAeMode(CameraMetadata cameraMetadata, int i) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        if (getAvailableAeModes(cameraMetadata).contains(Integer.valueOf(i))) {
            return i;
        }
        return getAvailableAeModes(cameraMetadata).contains(1) ? 1 : 0;
    }

    private static final boolean isAeModeSupported(CameraMetadata cameraMetadata, int i) {
        return getSupportedAeMode(cameraMetadata, i) == i;
    }

    public static final boolean isExternalFlashAeModeSupported(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        return Build.VERSION.SDK_INT >= 28 && isAeModeSupported(cameraMetadata, 5);
    }

    public static final int getSupportedAwbMode(CameraMetadata cameraMetadata, int i) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        if (getAvailableAwbModes(cameraMetadata).contains(Integer.valueOf(i))) {
            return i;
        }
        return getAvailableAwbModes(cameraMetadata).contains(1) ? 1 : 0;
    }

    public static final <T> T getOrDefault(CameraMetadata cameraMetadata, CameraCharacteristics.Key<T> key, T t) {
        T t2;
        Intrinsics.checkNotNullParameter(key, "key");
        return (cameraMetadata == null || (t2 = (T) cameraMetadata.getOrDefault(key, t)) == null) ? t : t2;
    }
}
