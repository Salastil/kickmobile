package androidx.graphics.shapes;

import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SvgPathParser.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/graphics/shapes/ArcConverter;", "", "<init>", "()V", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ArcConverter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: SvgPathParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010JV\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"Landroidx/graphics/shapes/ArcConverter$Companion;", "", "<init>", "()V", "arcToCubics", "", "Landroidx/graphics/shapes/Cubic;", "x0", "", "y0", "x1", "y1", "a", "b", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcToBezier", "cx", "cy", "rx", "ry", "e1x", "e1y", ViewProps.START, "sweep", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Cubic> arcToCubics(float x0, float y0, float x1, float y1, float a2, float b, float theta, boolean isMoreThanHalf, boolean isPositiveArc) {
            double d;
            double d2;
            double d3 = (((double) theta) / 180.0d) * 3.141592653589793d;
            double dCos = Math.cos(d3);
            double dSin = Math.sin(d3);
            double d4 = y0;
            double d5 = a2;
            double d6 = ((((double) x0) * dCos) + (d4 * dSin)) / d5;
            double d7 = (((double) (-x0)) * dSin) + (d4 * dCos);
            double d8 = b;
            double d9 = d7 / d8;
            double d10 = y1;
            double d11 = ((((double) x1) * dCos) + (d10 * dSin)) / d5;
            double d12 = ((((double) (-x1)) * dSin) + (d10 * dCos)) / d8;
            double d13 = d6 - d11;
            double d14 = d9 - d12;
            double d15 = (d6 + d11) / 2.0d;
            double d16 = (d9 + d12) / 2.0d;
            double d17 = (d13 * d13) + (d14 * d14);
            if (d17 == 0.0d) {
                return CollectionsKt.emptyList();
            }
            double d18 = (1.0d / d17) - 0.25d;
            if (d18 < 0.0d) {
                float fSqrt = (float) (Math.sqrt(d17) / 1.99999d);
                return arcToCubics(x0, y0, x1, y1, a2 * fSqrt, b * fSqrt, theta, isMoreThanHalf, isPositiveArc);
            }
            double dSqrt = Math.sqrt(d18);
            double d19 = d13 * dSqrt;
            double d20 = dSqrt * d14;
            if (isMoreThanHalf == isPositiveArc) {
                d = d15 - d20;
                d2 = d16 + d19;
            } else {
                d = d15 + d20;
                d2 = d16 - d19;
            }
            double dAtan2 = Math.atan2(d9 - d2, d6 - d);
            double dAtan3 = Math.atan2(d12 - d2, d11 - d) - dAtan2;
            if (isPositiveArc != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d21 = d * d5;
            double d22 = d2 * d8;
            return arcToBezier((float) ((d21 * dCos) - (d22 * dSin)), (float) ((d21 * dSin) + (d22 * dCos)), a2, b, x0, y0, (float) d3, (float) dAtan2, (float) dAtan3);
        }

        private final List<Cubic> arcToBezier(float cx, float cy, float rx, float ry, float e1x, float e1y, float theta, float start, float sweep) {
            ArrayList arrayList = new ArrayList();
            float f = 4.0f;
            int iCeil = (int) Math.ceil(Math.abs(((double) (sweep * 4.0f)) / 3.141592653589793d));
            double d = theta;
            float fCos = (float) Math.cos(d);
            float fSin = (float) Math.sin(d);
            float f2 = start;
            double d2 = f2;
            float fCos2 = (float) Math.cos(d2);
            float fSin2 = (float) Math.sin(d2);
            float f3 = -rx;
            float f4 = f3 * fCos;
            float f5 = ry * fSin;
            float f6 = (f4 * fSin2) - (f5 * fCos2);
            float f7 = f3 * fSin;
            float f8 = ry * fCos;
            float f9 = (fSin2 * f7) + (fCos2 * f8);
            float f10 = sweep / iCeil;
            int i = 0;
            float f11 = e1x;
            float f12 = e1y;
            while (i < iCeil) {
                float f13 = f;
                float f14 = f2 + f10;
                int i2 = iCeil;
                float f15 = fSin;
                double d3 = f14;
                float fSin3 = (float) Math.sin(d3);
                float fCos3 = (float) Math.cos(d3);
                float f16 = (cx + ((rx * fCos) * fCos3)) - (f5 * fSin3);
                float f17 = cy + (rx * f15 * fCos3) + (f8 * fSin3);
                float f18 = (f4 * fSin3) - (f5 * fCos3);
                float f19 = (fSin3 * f7) + (fCos3 * f8);
                float f20 = f14 - f2;
                float fTan = (float) Math.tan(f20 / 2.0f);
                float fSin4 = (((float) Math.sin(f20)) * (((float) Math.sqrt(f13 + ((3.0f * fTan) * fTan))) - 1.0f)) / 3.0f;
                arrayList.add(CubicKt.Cubic(f11, f12, f11 + (f6 * fSin4), f12 + (f9 * fSin4), f16 - (fSin4 * f18), f17 - (fSin4 * f19), f16, f17));
                i++;
                f = f13;
                f2 = f14;
                f6 = f18;
                f9 = f19;
                fSin = f15;
                f11 = f16;
                f12 = f17;
                iCeil = i2;
            }
            return arrayList;
        }
    }
}
