package com.facebook.imagepipeline.filter;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: NTSCDampeningFilterUtil.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/filter/NTSCDampeningFilterUtil;", "", "<init>", "()V", "process", "", "color", "reductionFactor", "", "DEFAULT_NTSC_REDUCTION_FACTOR", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NTSCDampeningFilterUtil {
    private static final float DEFAULT_NTSC_REDUCTION_FACTOR = 0.4f;
    public static final NTSCDampeningFilterUtil INSTANCE = new NTSCDampeningFilterUtil();

    private NTSCDampeningFilterUtil() {
    }

    public static /* synthetic */ int process$default(int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.4f;
        }
        return process(i, f);
    }

    @JvmStatic
    public static final int process(int color, float reductionFactor) {
        double dRed = ((double) Color.red(color)) / 255.0d;
        double dGreen = ((double) Color.green(color)) / 255.0d;
        double dBlue = ((double) Color.blue(color)) / 255.0d;
        double d = (0.299d * dRed) + (0.587d * dGreen) + (0.114d * dBlue);
        double dMax = Math.max(dRed, Math.max(dGreen, dBlue));
        if (d <= 0.6d && dMax <= 0.5d) {
            return color;
        }
        float[] fArr = new float[3];
        Color.colorToHSV(color, fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        double dCoerceIn = RangesKt.coerceIn(Math.max((d - 0.6d) / 0.4d, (dMax - 0.5d) / 0.5d), 0.0d, 1.0d);
        float f4 = f3 * ((float) (1.0d - (((double) reductionFactor) * dCoerceIn)));
        if (f2 > 0.7d) {
            f2 *= (float) (1.0d - (dCoerceIn * 0.2d));
        }
        if (f4 >= 0.8d || dMax >= 0.9d) {
            f4 *= 0.95f;
        }
        return Color.HSVToColor(new float[]{f, f2, f4});
    }
}
