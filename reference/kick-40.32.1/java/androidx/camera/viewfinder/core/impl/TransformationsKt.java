package androidx.camera.viewfinder.core.impl;

import android.graphics.RectF;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Metadata;

/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u001b\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007\u001a\u001b\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0010H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"NORMALIZED_RECT", "Landroid/graphics/RectF;", "ScaleFactorF", "Landroidx/camera/viewfinder/core/impl/ScaleFactorF;", "scaleX", "", "scaleY", "(FF)J", "OffsetF", "Landroidx/camera/viewfinder/core/impl/OffsetF;", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "floatFromBits", "bits", "", "packFloats", "", "val1", "val2", "unpackFloat1", "value", "unpackFloat2", "viewfinder-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransformationsKt {
    private static final RectF NORMALIZED_RECT = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    public static final long ScaleFactorF(float f, float f2) {
        return ScaleFactorF.m1271constructorimpl(packFloats(f, f2));
    }

    public static final long OffsetF(float f, float f2) {
        return OffsetF.m1262constructorimpl(packFloats(f, f2));
    }

    private static final float floatFromBits(int i) {
        return Float.intBitsToFloat(i);
    }

    private static final long packFloats(float f, float f2) {
        return (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float unpackFloat1(long j) {
        return floatFromBits((int) (j >> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float unpackFloat2(long j) {
        return floatFromBits((int) (j & 4294967295L));
    }
}
