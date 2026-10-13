package androidx.camera.viewfinder.core.impl;

import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/camera/viewfinder/core/impl/OffsetF;", "", "packedOffsets", "", "constructor-impl", "(J)J", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", "getX-impl", "(J)F", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "getY-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class OffsetF {
    private final long packedOffsets;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OffsetF m1261boximpl(long j) {
        return new OffsetF(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1262constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1263equalsimpl(long j, Object obj) {
        return (obj instanceof OffsetF) && j == ((OffsetF) obj).getPackedOffsets();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1264equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1267hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1268toStringimpl(long j) {
        return "OffsetF(packedOffsets=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m1263equalsimpl(this.packedOffsets, obj);
    }

    public int hashCode() {
        return m1267hashCodeimpl(this.packedOffsets);
    }

    public String toString() {
        return m1268toStringimpl(this.packedOffsets);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedOffsets() {
        return this.packedOffsets;
    }

    private /* synthetic */ OffsetF(long j) {
        this.packedOffsets = j;
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m1265getXimpl(long j) {
        return TransformationsKt.unpackFloat1(j);
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m1266getYimpl(long j) {
        return TransformationsKt.unpackFloat2(j);
    }
}
