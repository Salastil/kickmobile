package androidx.camera.viewfinder.core.camera2;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import androidx.camera.viewfinder.core.TransformationInfo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2TransformationInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0007J@\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0007JB\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0003¨\u0006\u0011"}, d2 = {"Landroidx/camera/viewfinder/core/camera2/Camera2TransformationInfo;", "", "<init>", "()V", "createFromCharacteristics", "Landroidx/camera/viewfinder/core/TransformationInfo;", "cameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "cropRectLeft", "", "cropRectTop", "cropRectRight", "cropRectBottom", "mirrorMode", "", "createFromCharacteristicsInternal", "OutputConfigurationMirrorMode", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Camera2TransformationInfo {
    public static final Camera2TransformationInfo INSTANCE = new Camera2TransformationInfo();

    /* JADX INFO: compiled from: Camera2TransformationInfo.kt */
    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/camera/viewfinder/core/camera2/Camera2TransformationInfo$OutputConfigurationMirrorMode;", "", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface OutputConfigurationMirrorMode {
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristics$default(cameraCharacteristics, 0.0f, 0.0f, 0.0f, 0.0f, 30, null);
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics, float f) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristics$default(cameraCharacteristics, f, 0.0f, 0.0f, 0.0f, 28, null);
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics, float f, float f2) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristics$default(cameraCharacteristics, f, f2, 0.0f, 0.0f, 24, null);
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristics$default(cameraCharacteristics, f, f2, f3, 0.0f, 16, null);
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics, int i) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristics$default(cameraCharacteristics, i, 0.0f, 0.0f, 0.0f, 0.0f, 60, null);
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics, int i, float f) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristics$default(cameraCharacteristics, i, f, 0.0f, 0.0f, 0.0f, 56, null);
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics, int i, float f, float f2) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristics$default(cameraCharacteristics, i, f, f2, 0.0f, 0.0f, 48, null);
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics, int i, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristics$default(cameraCharacteristics, i, f, f2, f3, 0.0f, 32, null);
    }

    private Camera2TransformationInfo() {
    }

    public static /* synthetic */ TransformationInfo createFromCharacteristics$default(CameraCharacteristics cameraCharacteristics, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Float.NaN;
        }
        if ((i & 4) != 0) {
            f2 = Float.NaN;
        }
        if ((i & 8) != 0) {
            f3 = Float.NaN;
        }
        if ((i & 16) != 0) {
            f4 = Float.NaN;
        }
        return createFromCharacteristics(cameraCharacteristics, f, f2, f3, f4);
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics, float cropRectLeft, float cropRectTop, float cropRectRight, float cropRectBottom) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristicsInternal$default(cameraCharacteristics, 0, cropRectLeft, cropRectTop, cropRectRight, cropRectBottom, 2, null);
    }

    public static /* synthetic */ TransformationInfo createFromCharacteristics$default(CameraCharacteristics cameraCharacteristics, int i, float f, float f2, float f3, float f4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = Float.NaN;
        }
        if ((i2 & 8) != 0) {
            f2 = Float.NaN;
        }
        if ((i2 & 16) != 0) {
            f3 = Float.NaN;
        }
        if ((i2 & 32) != 0) {
            f4 = Float.NaN;
        }
        return createFromCharacteristics(cameraCharacteristics, i, f, f2, f3, f4);
    }

    @JvmStatic
    public static final TransformationInfo createFromCharacteristics(CameraCharacteristics cameraCharacteristics, int mirrorMode, float cropRectLeft, float cropRectTop, float cropRectRight, float cropRectBottom) {
        Intrinsics.checkNotNullParameter(cameraCharacteristics, "cameraCharacteristics");
        return createFromCharacteristicsInternal(cameraCharacteristics, mirrorMode, cropRectLeft, cropRectTop, cropRectRight, cropRectBottom);
    }

    static /* synthetic */ TransformationInfo createFromCharacteristicsInternal$default(CameraCharacteristics cameraCharacteristics, int i, float f, float f2, float f3, float f4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            f = Float.NaN;
        }
        if ((i2 & 8) != 0) {
            f2 = Float.NaN;
        }
        if ((i2 & 16) != 0) {
            f3 = Float.NaN;
        }
        return createFromCharacteristicsInternal(cameraCharacteristics, i, f, f2, f3, (i2 & 32) != 0 ? Float.NaN : f4);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0023  */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    /* JADX WARN: Code duplicated, block: B:25:0x0049  */
    @JvmStatic
    private static final TransformationInfo createFromCharacteristicsInternal(CameraCharacteristics cameraCharacteristics, int mirrorMode, float cropRectLeft, float cropRectTop, float cropRectRight, float cropRectBottom) {
        int iIntValue;
        int iIntValue2;
        boolean z;
        boolean z2;
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Log.e("C2TransformationInfo", "Unable to retrieve sensor rotation. Assuming rotation of 0");
            iIntValue = 0;
        }
        if (mirrorMode == 0) {
            Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (num2 != null) {
                iIntValue2 = num2.intValue();
            } else {
                Log.e("C2TransformationInfo", "Unable to retrieve lens facing. Assuming BACK camera.");
                iIntValue2 = 1;
            }
            if (iIntValue2 != 0) {
                z = false;
                z2 = false;
            } else if (iIntValue == 90 || iIntValue == 270) {
                z2 = true;
                z = false;
            } else {
                z = true;
                z2 = false;
            }
        } else if (mirrorMode == 2) {
            z = true;
            z2 = false;
        } else if (mirrorMode != 3) {
            z = false;
            z2 = false;
        } else {
            z2 = true;
            z = false;
        }
        return new TransformationInfo(iIntValue, z, z2, cropRectLeft, cropRectTop, cropRectRight, cropRectBottom);
    }
}
