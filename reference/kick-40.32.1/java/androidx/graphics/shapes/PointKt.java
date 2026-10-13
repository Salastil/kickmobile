package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Point.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\t\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\f\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\r\u0010\u0006\u001a\u0017\u0010\u000e\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a#\u0010\u0010\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\u0010\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00042\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0018\u001a\u00020\u0019*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u0004H\u0080\u0002¢\u0006\u0004\b \u0010\u001e\u001a(\u0010!\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0080\u0002¢\u0006\u0004\b\"\u0010#\u001a(\u0010$\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0080\u0002¢\u0006\u0004\b%\u0010#\u001a$\u0010&\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u0010'\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b(\u0010)\u001a$\u0010*\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u0010'\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b+\u0010)\u001a$\u0010,\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u0010'\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b-\u0010)\u001a3\u0010.\u001a\u00060\u0001j\u0002`\u00042\n\u0010/\u001a\u00060\u0001j\u0002`\u00042\n\u00100\u001a\u00060\u0001j\u0002`\u00042\u0006\u00101\u001a\u00020\u0003H\u0000¢\u0006\u0004\b2\u00103\u001a#\u00104\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0004\b7\u00108\"\u001c\u0010\u0002\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0007\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u00069"}, d2 = {"Point", "Landroidx/collection/FloatFloatPair;", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", "Landroidx/graphics/shapes/Point;", "getX-DnnuFBc", "(J)F", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "getY-DnnuFBc", "copy", "copy-5P9i7ZU", "(JFF)J", "getDistance", "getDistance-DnnuFBc", "getDistanceSquared", "getDistanceSquared-DnnuFBc", "dotProduct", "other", "dotProduct-ybeJwSQ", "(JJ)F", "otherX", "otherY", "dotProduct-5P9i7ZU", "(JFF)F", "clockwise", "", "clockwise-ybeJwSQ", "(JJ)Z", "getDirection", "getDirection-DnnuFBc", "(J)J", "unaryMinus", "unaryMinus-DnnuFBc", "minus", "minus-ybeJwSQ", "(JJ)J", "plus", "plus-ybeJwSQ", "times", "operand", "times-so9K2fw", "(JF)J", "div", "div-so9K2fw", "rem", "rem-so9K2fw", "interpolate", ViewProps.START, "stop", "fraction", "interpolate-dLqxh1s", "(JJF)J", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "transformed-so9K2fw", "(JLandroidx/graphics/shapes/PointTransformer;)J", "graphics-shapes"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PointKt {
    /* JADX INFO: renamed from: copy-5P9i7ZU, reason: not valid java name */
    public static final long m10616copy5P9i7ZU(long j, float f, float f2) {
        return FloatFloatPair.m1282constructorimpl(f, f2);
    }

    /* JADX INFO: renamed from: getDistance-DnnuFBc, reason: not valid java name */
    public static final float m10622getDistanceDnnuFBc(long j) {
        return (float) Math.sqrt((m10624getXDnnuFBc(j) * m10624getXDnnuFBc(j)) + (m10625getYDnnuFBc(j) * m10625getYDnnuFBc(j)));
    }

    /* JADX INFO: renamed from: getDistanceSquared-DnnuFBc, reason: not valid java name */
    public static final float m10623getDistanceSquaredDnnuFBc(long j) {
        return (m10624getXDnnuFBc(j) * m10624getXDnnuFBc(j)) + (m10625getYDnnuFBc(j) * m10625getYDnnuFBc(j));
    }

    /* JADX INFO: renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
    public static final float m10620dotProductybeJwSQ(long j, long j2) {
        return (m10624getXDnnuFBc(j) * m10624getXDnnuFBc(j2)) + (m10625getYDnnuFBc(j) * m10625getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: dotProduct-5P9i7ZU, reason: not valid java name */
    public static final float m10619dotProduct5P9i7ZU(long j, float f, float f2) {
        return (m10624getXDnnuFBc(j) * f) + (m10625getYDnnuFBc(j) * f2);
    }

    /* JADX INFO: renamed from: clockwise-ybeJwSQ, reason: not valid java name */
    public static final boolean m10615clockwiseybeJwSQ(long j, long j2) {
        return (m10624getXDnnuFBc(j) * m10625getYDnnuFBc(j2)) - (m10625getYDnnuFBc(j) * m10624getXDnnuFBc(j2)) > 0.0f;
    }

    /* JADX INFO: renamed from: getDirection-DnnuFBc, reason: not valid java name */
    public static final long m10621getDirectionDnnuFBc(long j) {
        float fM10622getDistanceDnnuFBc = m10622getDistanceDnnuFBc(j);
        if (fM10622getDistanceDnnuFBc <= 0.0f) {
            throw new IllegalArgumentException("Can't get the direction of a 0-length vector".toString());
        }
        return m10618divso9K2fw(j, fM10622getDistanceDnnuFBc);
    }

    /* JADX INFO: renamed from: unaryMinus-DnnuFBc, reason: not valid java name */
    public static final long m10632unaryMinusDnnuFBc(long j) {
        return FloatFloatPair.m1282constructorimpl(-m10624getXDnnuFBc(j), -m10625getYDnnuFBc(j));
    }

    /* JADX INFO: renamed from: minus-ybeJwSQ, reason: not valid java name */
    public static final long m10627minusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m1282constructorimpl(m10624getXDnnuFBc(j) - m10624getXDnnuFBc(j2), m10625getYDnnuFBc(j) - m10625getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: plus-ybeJwSQ, reason: not valid java name */
    public static final long m10628plusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m1282constructorimpl(m10624getXDnnuFBc(j) + m10624getXDnnuFBc(j2), m10625getYDnnuFBc(j) + m10625getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: times-so9K2fw, reason: not valid java name */
    public static final long m10630timesso9K2fw(long j, float f) {
        return FloatFloatPair.m1282constructorimpl(m10624getXDnnuFBc(j) * f, m10625getYDnnuFBc(j) * f);
    }

    /* JADX INFO: renamed from: div-so9K2fw, reason: not valid java name */
    public static final long m10618divso9K2fw(long j, float f) {
        return FloatFloatPair.m1282constructorimpl(m10624getXDnnuFBc(j) / f, m10625getYDnnuFBc(j) / f);
    }

    /* JADX INFO: renamed from: rem-so9K2fw, reason: not valid java name */
    public static final long m10629remso9K2fw(long j, float f) {
        return FloatFloatPair.m1282constructorimpl(m10624getXDnnuFBc(j) % f, m10625getYDnnuFBc(j) % f);
    }

    /* JADX INFO: renamed from: interpolate-dLqxh1s, reason: not valid java name */
    public static final long m10626interpolatedLqxh1s(long j, long j2, float f) {
        return FloatFloatPair.m1282constructorimpl(Utils.interpolate(m10624getXDnnuFBc(j), m10624getXDnnuFBc(j2), f), Utils.interpolate(m10625getYDnnuFBc(j), m10625getYDnnuFBc(j2), f));
    }

    /* JADX INFO: renamed from: transformed-so9K2fw, reason: not valid java name */
    public static final long m10631transformedso9K2fw(long j, PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        long jMo5415transformXgqJiTY = f.mo5415transformXgqJiTY(m10624getXDnnuFBc(j), m10625getYDnnuFBc(j));
        return FloatFloatPair.m1282constructorimpl(Float.intBitsToFloat((int) (jMo5415transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (jMo5415transformXgqJiTY & 4294967295L)));
    }

    /* JADX INFO: renamed from: getX-DnnuFBc, reason: not valid java name */
    public static final float m10624getXDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getY-DnnuFBc, reason: not valid java name */
    public static final float m10625getYDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: copy-5P9i7ZU$default, reason: not valid java name */
    public static /* synthetic */ long m10617copy5P9i7ZU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m10616copy5P9i7ZU(j, f, f2);
    }
}
