package com.facebook.fresco.vito.core.impl;

import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.fresco.vito.renderer.CircleShape;
import com.facebook.fresco.vito.renderer.PathShape;
import com.facebook.fresco.vito.renderer.RectShape;
import com.facebook.fresco.vito.renderer.RoundedRectShape;
import com.facebook.fresco.vito.renderer.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShapeCalculator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ShapeCalculator;", "", "<init>", "()V", "Companion", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShapeCalculator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ShapeCalculator.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ShapeCalculator$Companion;", "", "<init>", "()V", "getShape", "Lcom/facebook/fresco/vito/renderer/Shape;", "bounds", "Landroid/graphics/RectF;", "roundingOptions", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "cornerRadiusAdjustment", "", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Shape getShape$default(Companion companion, RectF rectF, RoundingOptions roundingOptions, float f, int i, Object obj) {
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            return companion.getShape(rectF, roundingOptions, f);
        }

        public final Shape getShape(RectF bounds, RoundingOptions roundingOptions, float cornerRadiusAdjustment) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            if (roundingOptions == null) {
                return new RectShape(bounds);
            }
            if (roundingOptions.isCircular()) {
                return new CircleShape(bounds.centerX(), bounds.centerY(), Math.min(bounds.width(), bounds.height()) / 2.0f, Boolean.valueOf(roundingOptions.isAntiAliased()));
            }
            if (!roundingOptions.hasRoundedCorners()) {
                return new RectShape(bounds);
            }
            if (roundingOptions.getCornerRadius() != 0.0f) {
                float cornerRadius = roundingOptions.getCornerRadius() + cornerRadiusAdjustment;
                return new RoundedRectShape(bounds, cornerRadius, cornerRadius);
            }
            float[] cornerRadii = roundingOptions.getCornerRadii();
            if (cornerRadii != null && cornerRadiusAdjustment != 0.0f) {
                float[] fArr = new float[8];
                int length = cornerRadii.length;
                for (int i = 0; i < length; i++) {
                    fArr[i] = cornerRadii[i] + cornerRadiusAdjustment;
                }
                cornerRadii = fArr;
            }
            if (cornerRadii == null) {
                throw new IllegalArgumentException("Malformed rounding options " + roundingOptions);
            }
            Path path = new Path();
            path.addRoundRect(bounds, cornerRadii, Path.Direction.CW);
            path.setFillType(Path.FillType.WINDING);
            return new PathShape(path);
        }
    }
}
