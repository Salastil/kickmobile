package androidx.camera.viewfinder.core;

import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: TransformationInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBO\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u001c"}, d2 = {"Landroidx/camera/viewfinder/core/TransformationInfo;", "", "sourceRotation", "", "isSourceMirroredHorizontally", "", "isSourceMirroredVertically", "cropRectLeft", "", "cropRectTop", "cropRectRight", "cropRectBottom", "<init>", "(IZZFFFF)V", "getSourceRotation", "()I", "()Z", "getCropRectLeft", "()F", "getCropRectTop", "getCropRectRight", "getCropRectBottom", "equals", "other", "hashCode", "toString", "", "Companion", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TransformationInfo {
    public static final float CROP_NONE = Float.NaN;
    public static final TransformationInfo DEFAULT = new TransformationInfo(0, false, false, 0.0f, 0.0f, 0.0f, 0.0f, 127, null);
    private final float cropRectBottom;
    private final float cropRectLeft;
    private final float cropRectRight;
    private final float cropRectTop;
    private final boolean isSourceMirroredHorizontally;
    private final boolean isSourceMirroredVertically;
    private final int sourceRotation;

    public TransformationInfo() {
        this(0, false, false, 0.0f, 0.0f, 0.0f, 0.0f, 127, null);
    }

    public TransformationInfo(int i) {
        this(i, false, false, 0.0f, 0.0f, 0.0f, 0.0f, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    public TransformationInfo(int i, boolean z) {
        this(i, z, false, 0.0f, 0.0f, 0.0f, 0.0f, 124, null);
    }

    public TransformationInfo(int i, boolean z, boolean z2) {
        this(i, z, z2, 0.0f, 0.0f, 0.0f, 0.0f, TimeseriesConfiguration.DEFAULT_BUFFER_SIZE, null);
    }

    public TransformationInfo(int i, boolean z, boolean z2, float f) {
        this(i, z, z2, f, 0.0f, 0.0f, 0.0f, 112, null);
    }

    public TransformationInfo(int i, boolean z, boolean z2, float f, float f2) {
        this(i, z, z2, f, f2, 0.0f, 0.0f, 96, null);
    }

    public TransformationInfo(int i, boolean z, boolean z2, float f, float f2, float f3) {
        this(i, z, z2, f, f2, f3, 0.0f, 64, null);
    }

    public TransformationInfo(int i, boolean z, boolean z2, float f, float f2, float f3, float f4) {
        this.sourceRotation = i;
        this.isSourceMirroredHorizontally = z;
        this.isSourceMirroredVertically = z2;
        this.cropRectLeft = f;
        this.cropRectTop = f2;
        this.cropRectRight = f3;
        this.cropRectBottom = f4;
    }

    public /* synthetic */ TransformationInfo(int i, boolean z, boolean z2, float f, float f2, float f3, float f4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? Float.NaN : f, (i2 & 16) != 0 ? Float.NaN : f2, (i2 & 32) != 0 ? Float.NaN : f3, (i2 & 64) != 0 ? Float.NaN : f4);
    }

    public final int getSourceRotation() {
        return this.sourceRotation;
    }

    /* JADX INFO: renamed from: isSourceMirroredHorizontally, reason: from getter */
    public final boolean getIsSourceMirroredHorizontally() {
        return this.isSourceMirroredHorizontally;
    }

    /* JADX INFO: renamed from: isSourceMirroredVertically, reason: from getter */
    public final boolean getIsSourceMirroredVertically() {
        return this.isSourceMirroredVertically;
    }

    public final float getCropRectLeft() {
        return this.cropRectLeft;
    }

    public final float getCropRectTop() {
        return this.cropRectTop;
    }

    public final float getCropRectRight() {
        return this.cropRectRight;
    }

    public final float getCropRectBottom() {
        return this.cropRectBottom;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransformationInfo)) {
            return false;
        }
        TransformationInfo transformationInfo = (TransformationInfo) other;
        return this.sourceRotation == transformationInfo.sourceRotation && this.isSourceMirroredHorizontally == transformationInfo.isSourceMirroredHorizontally && this.isSourceMirroredVertically == transformationInfo.isSourceMirroredVertically && this.cropRectLeft == transformationInfo.cropRectLeft && this.cropRectTop == transformationInfo.cropRectTop && this.cropRectRight == transformationInfo.cropRectRight && this.cropRectBottom == transformationInfo.cropRectBottom;
    }

    public int hashCode() {
        return (((((((((((this.sourceRotation * 31) + Boolean.hashCode(this.isSourceMirroredHorizontally)) * 31) + Boolean.hashCode(this.isSourceMirroredVertically)) * 31) + Float.hashCode(this.cropRectLeft)) * 31) + Float.hashCode(this.cropRectTop)) * 31) + Float.hashCode(this.cropRectRight)) * 31) + Float.hashCode(this.cropRectBottom);
    }

    public String toString() {
        return "TransformationInfo(sourceRotation=" + this.sourceRotation + ", isSourceMirroredHorizontally=" + this.isSourceMirroredHorizontally + ", isSourceMirroredVertically=" + this.isSourceMirroredVertically + ", cropRectLeft=" + this.cropRectLeft + ", cropRectTop=" + this.cropRectTop + ", cropRectRight=" + this.cropRectRight + ", cropRectBottom=" + this.cropRectBottom + ')';
    }
}
