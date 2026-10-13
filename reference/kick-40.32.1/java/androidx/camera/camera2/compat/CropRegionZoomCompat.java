package androidx.camera.camera2.compat;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.internal.ZoomMath;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: ZoomCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/compat/CropRegionZoomCompat;", "Landroidx/camera/camera2/compat/ZoomCompat;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;)V", "minZoomRatio", "", "getMinZoomRatio", "()F", "maxZoomRatio", "getMaxZoomRatio", "currentCropRect", "Landroid/graphics/Rect;", "sensorRect", "applyAsync", "Lkotlinx/coroutines/Deferred;", "", "zoomRatio", "requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "resetAsync", "getCropSensorRegion", "computeCropRect", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CropRegionZoomCompat implements ZoomCompat {
    private final CameraProperties cameraProperties;
    private Rect currentCropRect;
    private final Rect sensorRect;

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public float getMinZoomRatio() {
        return 1.0f;
    }

    public CropRegionZoomCompat(CameraProperties cameraProperties) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        this.cameraProperties = cameraProperties;
        CameraMetadata metadata = cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_INFO_ACTIVE_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        Intrinsics.checkNotNullExpressionValue(SENSOR_INFO_ACTIVE_ARRAY_SIZE, "SENSOR_INFO_ACTIVE_ARRAY_SIZE");
        Object obj = metadata.get((CameraCharacteristics.Key<Object>) SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        Intrinsics.checkNotNull(obj);
        this.sensorRect = (Rect) obj;
    }

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public float getMaxZoomRatio() {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SCALER_AVAILABLE_MAX_DIGITAL_ZOOM = CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM;
        Intrinsics.checkNotNullExpressionValue(SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, "SCALER_AVAILABLE_MAX_DIGITAL_ZOOM");
        Float f = (Float) metadata.getOrDefault((CameraCharacteristics.Key<Float>) SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(getMinZoomRatio()));
        ZoomMath zoomMath = ZoomMath.INSTANCE;
        Intrinsics.checkNotNull(f);
        if (zoomMath.nearZero$camera_camera2(f.floatValue())) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (!Logger.isWarnEnabled(Log.TAG)) {
                return 1.0f;
            }
            android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Invalid max zoom ratio of " + f + " detected, defaulting to 1.0f");
            return 1.0f;
        }
        return f.floatValue();
    }

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public Deferred<Unit> applyAsync(float zoomRatio, UseCaseCameraRequestControl requestControl) {
        Intrinsics.checkNotNullParameter(requestControl, "requestControl");
        this.currentCropRect = computeCropRect(this.sensorRect, zoomRatio);
        CaptureRequest.Key key = CaptureRequest.SCALER_CROP_REGION;
        Rect rect = this.currentCropRect;
        Intrinsics.checkNotNull(rect, "null cannot be cast to non-null type kotlin.Any");
        return UseCaseCameraRequestControl.setParametersAsync$default(requestControl, MapsKt.mapOf(TuplesKt.to(key, rect)), null, null, 6, null);
    }

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public Deferred<Unit> resetAsync(UseCaseCameraRequestControl requestControl) {
        Intrinsics.checkNotNullParameter(requestControl, "requestControl");
        return UseCaseCameraRequestControl.removeParametersAsync$default(requestControl, CollectionsKt.listOf(CaptureRequest.SCALER_CROP_REGION), null, 2, null);
    }

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public Rect getCropSensorRegion() {
        Rect rect = this.currentCropRect;
        return rect == null ? this.sensorRect : rect;
    }

    private final Rect computeCropRect(Rect sensorRect, float zoomRatio) {
        if (ZoomMath.INSTANCE.nearZero$camera_camera2(zoomRatio)) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isWarnEnabled(Log.TAG)) {
                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "ZoomCompat: Invalid zoom ratio of 0.0f passed in, defaulting to 1.0f");
            }
            zoomRatio = 1.0f;
        }
        float fWidth = sensorRect.width() / zoomRatio;
        float fHeight = sensorRect.height() / zoomRatio;
        float fWidth2 = (sensorRect.width() - fWidth) / 2.0f;
        float fHeight2 = (sensorRect.height() - fHeight) / 2.0f;
        return new Rect((int) fWidth2, (int) fHeight2, (int) (fWidth2 + fWidth), (int) (fHeight2 + fHeight));
    }
}
