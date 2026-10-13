package androidx.camera.camera2.pipe;

import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Frames.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0018B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Landroidx/camera/camera2/pipe/MetadataTransform;", "", "past", "", "future", "transformFn", "Landroidx/camera/camera2/pipe/MetadataTransform$TransformFn;", "<init>", "(IILandroidx/camera/camera2/pipe/MetadataTransform$TransformFn;)V", "getPast", "()I", "getFuture", "getTransformFn", "()Landroidx/camera/camera2/pipe/MetadataTransform$TransformFn;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "TransformFn", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MetadataTransform {
    private final int future;
    private final int past;
    private final TransformFn transformFn;

    public MetadataTransform() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ MetadataTransform copy$default(MetadataTransform metadataTransform, int i, int i2, TransformFn transformFn, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = metadataTransform.past;
        }
        if ((i3 & 2) != 0) {
            i2 = metadataTransform.future;
        }
        if ((i3 & 4) != 0) {
            transformFn = metadataTransform.transformFn;
        }
        return metadataTransform.copy(i, i2, transformFn);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPast() {
        return this.past;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFuture() {
        return this.future;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TransformFn getTransformFn() {
        return this.transformFn;
    }

    public final MetadataTransform copy(int past, int future, TransformFn transformFn) {
        Intrinsics.checkNotNullParameter(transformFn, "transformFn");
        return new MetadataTransform(past, future, transformFn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetadataTransform)) {
            return false;
        }
        MetadataTransform metadataTransform = (MetadataTransform) other;
        return this.past == metadataTransform.past && this.future == metadataTransform.future && Intrinsics.areEqual(this.transformFn, metadataTransform.transformFn);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.past) * 31) + Integer.hashCode(this.future)) * 31) + this.transformFn.hashCode();
    }

    public String toString() {
        return "MetadataTransform(past=" + this.past + ", future=" + this.future + ", transformFn=" + this.transformFn + ')';
    }

    public MetadataTransform(int i, int i2, TransformFn transformFn) {
        Intrinsics.checkNotNullParameter(transformFn, "transformFn");
        this.past = i;
        this.future = i2;
        this.transformFn = transformFn;
        if (i < 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (i2 < 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int getPast() {
        return this.past;
    }

    public final int getFuture() {
        return this.future;
    }

    public /* synthetic */ MetadataTransform(int i, int i2, TransformFn transformFn, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? new TransformFn() { // from class: androidx.camera.camera2.pipe.MetadataTransform.1
        } : transformFn);
    }

    public final TransformFn getTransformFn() {
        return this.transformFn;
    }

    /* JADX INFO: compiled from: Frames.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0016¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/MetadataTransform$TransformFn;", "", "computeOverridesFor", "", "result", "Landroidx/camera/camera2/pipe/FrameInfo;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "related", "", "computeOverridesFor-F8oR-dw", "(Landroidx/camera/camera2/pipe/FrameInfo;Ljava/lang/String;Ljava/util/List;)Ljava/util/Map;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface TransformFn {

        /* JADX INFO: compiled from: Frames.kt */
        @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            /* JADX INFO: renamed from: computeOverridesFor-F8oR-dw, reason: not valid java name */
            public static Map<?, Object> m570computeOverridesForF8oRdw(TransformFn transformFn, FrameInfo result, String camera, List<? extends FrameInfo> related) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(camera, "camera");
                Intrinsics.checkNotNullParameter(related, "related");
                return TransformFn.super.m569computeOverridesForF8oRdw(result, camera, related);
            }
        }

        /* JADX INFO: renamed from: computeOverridesFor-F8oR-dw, reason: not valid java name */
        default Map<?, Object> m569computeOverridesForF8oRdw(FrameInfo result, String camera, List<? extends FrameInfo> related) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(camera, "camera");
            Intrinsics.checkNotNullParameter(related, "related");
            return MapsKt.emptyMap();
        }
    }
}
