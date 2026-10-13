package androidx.camera.camera2.adapter;

import androidx.camera.camera2.internal.ZoomMath;
import androidx.camera.core.ZoomState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ZoomValue.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/adapter/ZoomValue;", "Landroidx/camera/core/ZoomState;", "zoomRatio", "", "minZoomRatio", "maxZoomRatio", "<init>", "(FFF)V", "linearZoom", "Landroidx/camera/camera2/adapter/ZoomValue$LinearZoom;", "(Landroidx/camera/camera2/adapter/ZoomValue$LinearZoom;FF)V", "Ljava/lang/Float;", "getZoomRatio", "getMaxZoomRatio", "getMinZoomRatio", "getLinearZoom", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "LinearZoom", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ZoomValue implements ZoomState {
    private Float linearZoom;
    private final float maxZoomRatio;
    private final float minZoomRatio;
    private final float zoomRatio;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final float getZoomRatio() {
        return this.zoomRatio;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final float getMinZoomRatio() {
        return this.minZoomRatio;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    public static /* synthetic */ ZoomValue copy$default(ZoomValue zoomValue, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = zoomValue.zoomRatio;
        }
        if ((i & 2) != 0) {
            f2 = zoomValue.minZoomRatio;
        }
        if ((i & 4) != 0) {
            f3 = zoomValue.maxZoomRatio;
        }
        return zoomValue.copy(f, f2, f3);
    }

    public final ZoomValue copy(float zoomRatio, float minZoomRatio, float maxZoomRatio) {
        return new ZoomValue(zoomRatio, minZoomRatio, maxZoomRatio);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZoomValue)) {
            return false;
        }
        ZoomValue zoomValue = (ZoomValue) other;
        return Float.compare(this.zoomRatio, zoomValue.zoomRatio) == 0 && Float.compare(this.minZoomRatio, zoomValue.minZoomRatio) == 0 && Float.compare(this.maxZoomRatio, zoomValue.maxZoomRatio) == 0;
    }

    public int hashCode() {
        return (((Float.hashCode(this.zoomRatio) * 31) + Float.hashCode(this.minZoomRatio)) * 31) + Float.hashCode(this.maxZoomRatio);
    }

    public String toString() {
        return "ZoomValue(zoomRatio=" + this.zoomRatio + ", minZoomRatio=" + this.minZoomRatio + ", maxZoomRatio=" + this.maxZoomRatio + ')';
    }

    public ZoomValue(float f, float f2, float f3) {
        this.zoomRatio = f;
        this.minZoomRatio = f2;
        this.maxZoomRatio = f3;
    }

    /* JADX INFO: compiled from: ZoomValue.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/adapter/ZoomValue$LinearZoom;", "", "value", "", "<init>", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class LinearZoom {
        private final float value;

        public static /* synthetic */ LinearZoom copy$default(LinearZoom linearZoom, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = linearZoom.value;
            }
            return linearZoom.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getValue() {
            return this.value;
        }

        public final LinearZoom copy(float value) {
            return new LinearZoom(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LinearZoom) && Float.compare(this.value, ((LinearZoom) other).value) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.value);
        }

        public String toString() {
            return "LinearZoom(value=" + this.value + ')';
        }

        public LinearZoom(float f) {
            this.value = f;
        }

        public final float getValue() {
            return this.value;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZoomValue(LinearZoom linearZoom, float f, float f2) {
        this(ZoomMath.INSTANCE.getZoomRatioFromLinearZoom(linearZoom.getValue(), f, f2), f, f2);
        Intrinsics.checkNotNullParameter(linearZoom, "linearZoom");
        this.linearZoom = Float.valueOf(linearZoom.getValue());
    }

    @Override // androidx.camera.core.ZoomState
    public float getZoomRatio() {
        return this.zoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMinZoomRatio() {
        return this.minZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getLinearZoom() {
        Float f = this.linearZoom;
        return f != null ? f.floatValue() : ZoomMath.INSTANCE.getLinearZoomFromZoomRatio(this.zoomRatio, this.minZoomRatio, this.maxZoomRatio);
    }
}
