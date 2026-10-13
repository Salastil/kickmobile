package com.swmansion.reanimated.css;

import android.animation.TimeInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CSSEasing.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/swmansion/reanimated/css/CSSEasing;", "", "<init>", "()V", "CUBIC_BEZIER", "", "STEPS", "LINEAR_STOPS", "interpolator", "Landroid/animation/TimeInterpolator;", "type", "pointsX", "", "pointsY", "firstSmallerOrEqual", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", "StepsInterpolator", "LinearStopsInterpolator", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CSSEasing {
    private static final int CUBIC_BEZIER = 1;
    public static final CSSEasing INSTANCE = new CSSEasing();
    private static final int LINEAR_STOPS = 3;
    private static final int STEPS = 2;

    private CSSEasing() {
    }

    public final TimeInterpolator interpolator(int type, float[] pointsX, float[] pointsY) {
        Intrinsics.checkNotNullParameter(pointsX, "pointsX");
        Intrinsics.checkNotNullParameter(pointsY, "pointsY");
        if (type == 1) {
            return new PathInterpolator(pointsX[0], pointsY[0], pointsX[1], pointsY[1]);
        }
        if (type == 2) {
            return new StepsInterpolator(pointsX, pointsY);
        }
        if (type == 3) {
            return new LinearStopsInterpolator(pointsX, pointsY);
        }
        return new LinearInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int firstSmallerOrEqual(float x, float[] pointsX) {
        int length = pointsX.length;
        int i = 0;
        while (i < length) {
            int i2 = (i + length) >>> 1;
            if (pointsX[i2] <= x) {
                i = i2 + 1;
            } else {
                length = i2;
            }
        }
        if (i == 0) {
            return 0;
        }
        return i - 1;
    }

    /* JADX INFO: compiled from: CSSEasing.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/swmansion/reanimated/css/CSSEasing$StepsInterpolator;", "Landroid/animation/TimeInterpolator;", "pointsX", "", "pointsY", "<init>", "([F[F)V", "getInterpolation", "", "input", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class StepsInterpolator implements TimeInterpolator {
        private final float[] pointsX;
        private final float[] pointsY;

        public StepsInterpolator(float[] pointsX, float[] pointsY) {
            Intrinsics.checkNotNullParameter(pointsX, "pointsX");
            Intrinsics.checkNotNullParameter(pointsY, "pointsY");
            this.pointsX = pointsX;
            this.pointsY = pointsY;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return this.pointsY[CSSEasing.INSTANCE.firstSmallerOrEqual(input, this.pointsX)];
        }
    }

    /* JADX INFO: compiled from: CSSEasing.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/swmansion/reanimated/css/CSSEasing$LinearStopsInterpolator;", "Landroid/animation/TimeInterpolator;", "pointsX", "", "pointsY", "<init>", "([F[F)V", "getInterpolation", "", "input", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class LinearStopsInterpolator implements TimeInterpolator {
        private final float[] pointsX;
        private final float[] pointsY;

        public LinearStopsInterpolator(float[] pointsX, float[] pointsY) {
            Intrinsics.checkNotNullParameter(pointsX, "pointsX");
            Intrinsics.checkNotNullParameter(pointsY, "pointsY");
            this.pointsX = pointsX;
            this.pointsY = pointsY;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            int iFirstSmallerOrEqual = CSSEasing.INSTANCE.firstSmallerOrEqual(input, this.pointsX);
            float[] fArr = this.pointsX;
            int length = fArr.length - 1;
            float[] fArr2 = this.pointsY;
            if (iFirstSmallerOrEqual == length) {
                return fArr2[iFirstSmallerOrEqual];
            }
            int i = iFirstSmallerOrEqual + 1;
            float f = fArr2[i];
            float f2 = fArr2[iFirstSmallerOrEqual];
            float f3 = fArr[i];
            float f4 = fArr[iFirstSmallerOrEqual];
            return f2 + (((f - f2) / (f3 - f4)) * (input - f4));
        }
    }
}
