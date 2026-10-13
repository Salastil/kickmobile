package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import android.util.SizeF;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.core.util.Preconditions;
import com.canhub.cropper.CropImageOptionsKt;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntrinsicZoomCalculator.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\f\u0010\u000b\u001a\u00020\u0007*\u00020\tH\u0002J\f\u0010\f\u001a\u00020\u0007*\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0003J\f\u0010\u0011\u001a\u00020\u000e*\u00020\tH\u0002J\f\u0010\u0012\u001a\u00020\u000e*\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/internal/IntrinsicZoomCalculatorImpl;", "Landroidx/camera/camera2/internal/IntrinsicZoomCalculator;", "cameraDevices", "Landroidx/camera/camera2/pipe/CameraDevices;", "<init>", "(Landroidx/camera/camera2/pipe/CameraDevices;)V", "calculateIntrinsicZoomRatio", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "(Landroidx/camera/camera2/pipe/CameraMetadata;)Ljava/lang/Float;", "getDefaultFocalLength", "getSensorHorizontalLength", "focalLengthToViewAngleDegrees", "", "focalLength", "sensorLength", "getDefaultViewAngleDegrees", "getDefaultCameraDefaultViewAngleDegrees", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IntrinsicZoomCalculatorImpl implements IntrinsicZoomCalculator {
    private final CameraDevices cameraDevices;

    @Inject
    public IntrinsicZoomCalculatorImpl(CameraDevices cameraDevices) {
        Intrinsics.checkNotNullParameter(cameraDevices, "cameraDevices");
        this.cameraDevices = cameraDevices;
    }

    @Override // androidx.camera.camera2.internal.IntrinsicZoomCalculator
    public Float calculateIntrinsicZoomRatio(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        try {
            return Float.valueOf(getDefaultCameraDefaultViewAngleDegrees(cameraMetadata) / getDefaultViewAngleDegrees(cameraMetadata));
        } catch (Exception e) {
            Exception exc = e;
            if (!Log.INSTANCE.getERROR_LOGGABLE()) {
                return null;
            }
            android.util.Log.e(Log.TAG, "Failed to get the intrinsic zoom ratio", exc);
            return null;
        }
    }

    private final float getDefaultFocalLength(CameraMetadata cameraMetadata) {
        CameraCharacteristics.Key LENS_INFO_AVAILABLE_FOCAL_LENGTHS = CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS;
        Intrinsics.checkNotNullExpressionValue(LENS_INFO_AVAILABLE_FOCAL_LENGTHS, "LENS_INFO_AVAILABLE_FOCAL_LENGTHS");
        Object objCheckNotNull = Preconditions.checkNotNull(cameraMetadata.get(LENS_INFO_AVAILABLE_FOCAL_LENGTHS), "The focal lengths can not be empty.");
        Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(...)");
        float[] fArr = (float[]) objCheckNotNull;
        Preconditions.checkState(!(fArr.length == 0), "The focal lengths can not be empty.");
        return fArr[0];
    }

    private final float getSensorHorizontalLength(CameraMetadata cameraMetadata) {
        CameraCharacteristics.Key SENSOR_INFO_PHYSICAL_SIZE = CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE;
        Intrinsics.checkNotNullExpressionValue(SENSOR_INFO_PHYSICAL_SIZE, "SENSOR_INFO_PHYSICAL_SIZE");
        Object objCheckNotNull = Preconditions.checkNotNull(cameraMetadata.get(SENSOR_INFO_PHYSICAL_SIZE), "The sensor size can't be null.");
        Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(...)");
        SizeF sizeFReverseSizeF = (SizeF) objCheckNotNull;
        CameraCharacteristics.Key SENSOR_INFO_ACTIVE_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        Intrinsics.checkNotNullExpressionValue(SENSOR_INFO_ACTIVE_ARRAY_SIZE, "SENSOR_INFO_ACTIVE_ARRAY_SIZE");
        Object objCheckNotNull2 = Preconditions.checkNotNull(cameraMetadata.get(SENSOR_INFO_ACTIVE_ARRAY_SIZE), "The sensor orientation can't be null.");
        Intrinsics.checkNotNullExpressionValue(objCheckNotNull2, "checkNotNull(...)");
        CameraCharacteristics.Key SENSOR_INFO_PIXEL_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE;
        Intrinsics.checkNotNullExpressionValue(SENSOR_INFO_PIXEL_ARRAY_SIZE, "SENSOR_INFO_PIXEL_ARRAY_SIZE");
        Object objCheckNotNull3 = Preconditions.checkNotNull(cameraMetadata.get(SENSOR_INFO_PIXEL_ARRAY_SIZE), "The active array size can't be null.");
        Intrinsics.checkNotNullExpressionValue(objCheckNotNull3, "checkNotNull(...)");
        Size sizeReverseSize = (Size) objCheckNotNull3;
        CameraCharacteristics.Key SENSOR_ORIENTATION = CameraCharacteristics.SENSOR_ORIENTATION;
        Intrinsics.checkNotNullExpressionValue(SENSOR_ORIENTATION, "SENSOR_ORIENTATION");
        Object objCheckNotNull4 = Preconditions.checkNotNull(cameraMetadata.get(SENSOR_ORIENTATION), "The pixel array size can't be null.");
        Intrinsics.checkNotNullExpressionValue(objCheckNotNull4, "checkNotNull(...)");
        int iIntValue = ((Number) objCheckNotNull4).intValue();
        Size sizeRectToSize = TransformUtils.rectToSize((Rect) objCheckNotNull2);
        Intrinsics.checkNotNullExpressionValue(sizeRectToSize, "rectToSize(...)");
        if (TransformUtils.is90or270(iIntValue)) {
            sizeFReverseSizeF = TransformUtils.reverseSizeF(sizeFReverseSizeF);
            Intrinsics.checkNotNullExpressionValue(sizeFReverseSizeF, "reverseSizeF(...)");
            sizeRectToSize = TransformUtils.reverseSize(sizeRectToSize);
            Intrinsics.checkNotNullExpressionValue(sizeRectToSize, "reverseSize(...)");
            sizeReverseSize = TransformUtils.reverseSize(sizeReverseSize);
            Intrinsics.checkNotNullExpressionValue(sizeReverseSize, "reverseSize(...)");
        }
        return (sizeFReverseSizeF.getWidth() * sizeRectToSize.getWidth()) / sizeReverseSize.getWidth();
    }

    private final int focalLengthToViewAngleDegrees(float focalLength, float sensorLength) {
        Preconditions.checkArgument(focalLength > 0.0f, "Focal length should be positive.");
        Preconditions.checkArgument(sensorLength > 0.0f, "Sensor length should be positive.");
        int degrees = (int) Math.toDegrees(2.0d * Math.atan(sensorLength / (2.0f * focalLength)));
        Preconditions.checkArgumentInRange(degrees, 0, CropImageOptionsKt.DEGREES_360, "The provided focal length and sensor length result in an invalid view angle degrees.");
        return degrees;
    }

    private final int getDefaultViewAngleDegrees(CameraMetadata cameraMetadata) throws IllegalStateException {
        try {
            return focalLengthToViewAngleDegrees(getDefaultFocalLength(cameraMetadata), getSensorHorizontalLength(cameraMetadata));
        } catch (Exception e) {
            throw new IllegalStateException("Failed to get a valid view angle", e);
        }
    }

    private final int getDefaultCameraDefaultViewAngleDegrees(CameraMetadata cameraMetadata) throws IllegalStateException {
        try {
            Object objCheckNotNull = Preconditions.checkNotNull(CameraDevices.m311awaitCameraIdsSeavPBo$default(this.cameraDevices, null, 1, null), "Failed to get available camera IDs");
            Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(...)");
            Iterator it = ((List) objCheckNotNull).iterator();
            while (it.hasNext()) {
                String strM433unboximpl = ((CameraId) it.next()).m433unboximpl();
                Object objCheckNotNull2 = Preconditions.checkNotNull(CameraDevices.m312awaitCameraMetadataFpsL5FU$default(this.cameraDevices, strM433unboximpl, null, 2, null), "Failed to get CameraMetadata for " + ((Object) CameraId.m432toStringimpl(strM433unboximpl)));
                Intrinsics.checkNotNullExpressionValue(objCheckNotNull2, "checkNotNull(...)");
                CameraMetadata cameraMetadata2 = (CameraMetadata) objCheckNotNull2;
                CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
                Intrinsics.checkNotNullExpressionValue(LENS_FACING, "LENS_FACING");
                Object objCheckNotNull3 = Preconditions.checkNotNull(cameraMetadata2.get((CameraCharacteristics.Key<Object>) LENS_FACING), "Failed to get CameraCharacteristics.LENS_FACING for " + ((Object) CameraId.m432toStringimpl(strM433unboximpl)));
                Intrinsics.checkNotNullExpressionValue(objCheckNotNull3, "checkNotNull(...)");
                int iIntValue = ((Number) objCheckNotNull3).intValue();
                CameraCharacteristics.Key LENS_FACING2 = CameraCharacteristics.LENS_FACING;
                Intrinsics.checkNotNullExpressionValue(LENS_FACING2, "LENS_FACING");
                Object objCheckNotNull4 = Preconditions.checkNotNull(cameraMetadata.get((CameraCharacteristics.Key<Object>) LENS_FACING2), "Failed to get the required LENS_FACING for " + ((Object) CameraId.m432toStringimpl(cameraMetadata.mo445getCameraDz_R5H8())));
                Intrinsics.checkNotNullExpressionValue(objCheckNotNull4, "checkNotNull(...)");
                if (iIntValue == ((Number) objCheckNotNull4).intValue()) {
                    return focalLengthToViewAngleDegrees(getDefaultFocalLength(cameraMetadata2), getSensorHorizontalLength(cameraMetadata2));
                }
            }
            throw new IllegalStateException("Could not find the default camera for " + ((Object) CameraId.m432toStringimpl(cameraMetadata.mo445getCameraDz_R5H8())));
        } catch (Exception e) {
            throw new IllegalStateException("Failed to get a valid view angle", e);
        }
    }
}
