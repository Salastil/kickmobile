package androidx.camera.camera2.internal;

import androidx.core.math.MathUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: ZoomMath.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/internal/ZoomMath;", "", "<init>", "()V", "getLinearZoomFromZoomRatio", "", "zoomRatio", "minZoomRatio", "maxZoomRatio", "getZoomRatioFromLinearZoom", "linearZoom", "areFloatsEqual", "", "num1", "num2", "nearZero", "num", "nearZero$camera_camera2", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZoomMath {
    public static final ZoomMath INSTANCE = new ZoomMath();

    private ZoomMath() {
    }

    public final float getLinearZoomFromZoomRatio(float zoomRatio, float minZoomRatio, float maxZoomRatio) {
        if (areFloatsEqual(minZoomRatio, maxZoomRatio) || nearZero$camera_camera2(zoomRatio)) {
            return 0.0f;
        }
        if (areFloatsEqual(zoomRatio, maxZoomRatio)) {
            return 1.0f;
        }
        if (areFloatsEqual(zoomRatio, minZoomRatio)) {
            return 0.0f;
        }
        float f = 1.0f / minZoomRatio;
        return MathUtils.clamp((f - (1.0f / zoomRatio)) / (f - (1.0f / maxZoomRatio)), 0.0f, 1.0f);
    }

    public final float getZoomRatioFromLinearZoom(float linearZoom, float minZoomRatio, float maxZoomRatio) {
        if (areFloatsEqual(linearZoom, 1.0f)) {
            return maxZoomRatio;
        }
        if (areFloatsEqual(linearZoom, 0.0f)) {
            return minZoomRatio;
        }
        float f = 1.0f / minZoomRatio;
        return MathUtils.clamp(1.0f / (f - ((f - (1.0f / maxZoomRatio)) * linearZoom)), minZoomRatio, maxZoomRatio);
    }

    private final boolean areFloatsEqual(float num1, float num2) {
        return nearZero$camera_camera2(num1 - num2);
    }

    public final boolean nearZero$camera_camera2(float num) {
        return ((double) Math.abs(num)) < ((double) Math.ulp(Math.abs(num))) * 2.0d;
    }
}
