package androidx.camera.camera2.compat.workaround;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Range;
import androidx.camera.camera2.compat.quirk.ControlZoomRatioRangeAssertionErrorQuirk;
import androidx.camera.camera2.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.internal.ZoomMath;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraMetadataSafeGetter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007*\u00020\u0002H\u0007\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0002¨\u0006\u000b"}, d2 = {"getSafely", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/camera2/pipe/CameraMetadata;", "key", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "(Landroidx/camera/camera2/pipe/CameraMetadata;Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;", "getControlZoomRatioRangeSafely", "Landroid/util/Range;", "", "getActiveArraySizeSafely", "Landroid/graphics/Rect;", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CameraMetadataSafeGetterKt {
    public static final <T> T getSafely(CameraMetadata cameraMetadata, CameraCharacteristics.Key<T> key) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 30 && Intrinsics.areEqual(key, CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE)) {
            return (T) getControlZoomRatioRangeSafely(cameraMetadata);
        }
        if (Intrinsics.areEqual(key, CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)) {
            return (T) getActiveArraySizeSafely(cameraMetadata);
        }
        return (T) cameraMetadata.get(key);
    }

    public static final Range<Float> getControlZoomRatioRangeSafely(CameraMetadata cameraMetadata) {
        Float fValueOf;
        Float fValueOf2;
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        try {
            CameraCharacteristics.Key CONTROL_ZOOM_RATIO_RANGE = CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_ZOOM_RATIO_RANGE, "CONTROL_ZOOM_RATIO_RANGE");
            Range range = (Range) cameraMetadata.get(CONTROL_ZOOM_RATIO_RANGE);
            if (range == null) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Failed to read CONTROL_ZOOM_RATIO_RANGE for " + ((Object) CameraId.m432toStringimpl(cameraMetadata.mo445getCameraDz_R5H8())) + '!');
                }
                return new Range<>(Float.valueOf(1.0f), Float.valueOf(1.0f));
            }
            ZoomMath zoomMath = ZoomMath.INSTANCE;
            Object lower = range.getLower();
            Intrinsics.checkNotNullExpressionValue(lower, "getLower(...)");
            if (zoomMath.nearZero$camera_camera2(((Number) lower).floatValue()) || ((Number) range.getLower()).floatValue() < 0.0f) {
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Invalid lower zoom range detected: " + range.getLower());
                }
                fValueOf = Float.valueOf(1.0f);
            } else {
                fValueOf = (Float) range.getLower();
            }
            ZoomMath zoomMath2 = ZoomMath.INSTANCE;
            Object upper = range.getUpper();
            Intrinsics.checkNotNullExpressionValue(upper, "getUpper(...)");
            if (zoomMath2.nearZero$camera_camera2(((Number) upper).floatValue()) || ((Number) range.getUpper()).floatValue() < 0.0f) {
                Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Invalid upper zoom range detected: " + range.getUpper());
                }
                fValueOf2 = Float.valueOf(1.0f);
            } else {
                fValueOf2 = (Float) range.getUpper();
            }
            return new Range<>(fValueOf, fValueOf2);
        } catch (AssertionError e) {
            if (DeviceQuirks.INSTANCE.get(ControlZoomRatioRangeAssertionErrorQuirk.class) != null) {
                Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Device is known to throw an exception while retrieving the value for CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE. CONTROL_ZOOM_RATIO_RANGE is not supported. [Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", API Level: " + Build.VERSION.SDK_INT + "].");
                }
            } else {
                Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
                AssertionError assertionError = e;
                if (Logger.isErrorEnabled(Log.TAG)) {
                    android.util.Log.e(Camera2Logger.TRUNCATED_TAG, "Exception thrown while retrieving the value for CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE on devices not known to throw exceptions during this operation. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", API Level: " + Build.VERSION.SDK_INT + "]. CONTROL_ZOOM_RATIO_RANGE is not available.", assertionError);
                }
            }
            Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
            AssertionError assertionError2 = e;
            if (!Logger.isWarnEnabled(Log.TAG)) {
                return null;
            }
            android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "AssertionError: failed to get CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE", assertionError2);
            return null;
        }
    }

    public static final Rect getActiveArraySizeSafely(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "<this>");
        CameraCharacteristics.Key SENSOR_INFO_ACTIVE_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        Intrinsics.checkNotNullExpressionValue(SENSOR_INFO_ACTIVE_ARRAY_SIZE, "SENSOR_INFO_ACTIVE_ARRAY_SIZE");
        Rect rect = (Rect) cameraMetadata.get(SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect != null) {
            return rect;
        }
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isWarnEnabled(Log.TAG)) {
            android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Failed to read SENSOR_INFO_ACTIVE_ARRAY_SIZE for " + ((Object) CameraId.m432toStringimpl(cameraMetadata.mo445getCameraDz_R5H8())) + '!');
        }
        return new Rect(0, 0, 4000, 3000);
    }
}
