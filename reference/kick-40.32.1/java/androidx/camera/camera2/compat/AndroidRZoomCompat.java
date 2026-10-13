package androidx.camera.camera2.compat;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.util.Range;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.pipe.CameraMetadata;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: ZoomCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/camera/camera2/compat/AndroidRZoomCompat;", "Landroidx/camera/camera2/compat/ZoomCompat;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "range", "Landroid/util/Range;", "", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;Landroid/util/Range;)V", "minZoomRatio", "getMinZoomRatio", "()F", "maxZoomRatio", "getMaxZoomRatio", "applyAsync", "Lkotlinx/coroutines/Deferred;", "", "zoomRatio", "requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "resetAsync", "getCropSensorRegion", "Landroid/graphics/Rect;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidRZoomCompat implements ZoomCompat {
    private final CameraProperties cameraProperties;
    private final Range<Float> range;

    public AndroidRZoomCompat(CameraProperties cameraProperties, Range<Float> range) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(range, "range");
        this.cameraProperties = cameraProperties;
        this.range = range;
    }

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public float getMinZoomRatio() {
        Object lower = this.range.getLower();
        Intrinsics.checkNotNullExpressionValue(lower, "getLower(...)");
        return ((Number) lower).floatValue();
    }

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public float getMaxZoomRatio() {
        Object upper = this.range.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper, "getUpper(...)");
        return ((Number) upper).floatValue();
    }

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public Deferred<Unit> applyAsync(float zoomRatio, UseCaseCameraRequestControl requestControl) {
        Intrinsics.checkNotNullParameter(requestControl, "requestControl");
        float minZoomRatio = getMinZoomRatio();
        if (zoomRatio > getMaxZoomRatio() || minZoomRatio > zoomRatio) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(zoomRatio)));
        if (Build.VERSION.SDK_INT >= 34 && CameraMetadata.INSTANCE.getSupportsZoomOverride(this.cameraProperties.getMetadata())) {
            Api34Compat.setSettingsOverrideZoom(mapMutableMapOf);
        }
        return UseCaseCameraRequestControl.setParametersAsync$default(requestControl, mapMutableMapOf, null, null, 6, null);
    }

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public Deferred<Unit> resetAsync(UseCaseCameraRequestControl requestControl) {
        Intrinsics.checkNotNullParameter(requestControl, "requestControl");
        CaptureRequest.Key CONTROL_ZOOM_RATIO = CaptureRequest.CONTROL_ZOOM_RATIO;
        Intrinsics.checkNotNullExpressionValue(CONTROL_ZOOM_RATIO, "CONTROL_ZOOM_RATIO");
        List listMutableListOf = CollectionsKt.mutableListOf(CONTROL_ZOOM_RATIO);
        if (Build.VERSION.SDK_INT >= 34) {
            CaptureRequest.Key CONTROL_SETTINGS_OVERRIDE = CaptureRequest.CONTROL_SETTINGS_OVERRIDE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_SETTINGS_OVERRIDE, "CONTROL_SETTINGS_OVERRIDE");
            listMutableListOf.add(CONTROL_SETTINGS_OVERRIDE);
        }
        return UseCaseCameraRequestControl.removeParametersAsync$default(requestControl, listMutableListOf, null, 2, null);
    }

    @Override // androidx.camera.camera2.compat.ZoomCompat
    public Rect getCropSensorRegion() {
        CameraMetadata metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_INFO_ACTIVE_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        Intrinsics.checkNotNullExpressionValue(SENSOR_INFO_ACTIVE_ARRAY_SIZE, "SENSOR_INFO_ACTIVE_ARRAY_SIZE");
        Object obj = metadata.get((CameraCharacteristics.Key<Object>) SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        Intrinsics.checkNotNull(obj);
        return (Rect) obj;
    }
}
