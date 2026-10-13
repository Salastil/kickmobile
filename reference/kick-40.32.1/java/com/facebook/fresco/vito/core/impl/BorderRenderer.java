package com.facebook.fresco.vito.core.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.fresco.vito.options.BorderOptions;
import com.facebook.fresco.vito.renderer.Shape;
import com.facebook.fresco.vito.renderer.util.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BorderRenderer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/BorderRenderer;", "", "<init>", "()V", "Companion", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BorderRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: BorderRenderer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u0010"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/BorderRenderer$Companion;", "", "<init>", "()V", "renderBorder", "", "canvas", "Landroid/graphics/Canvas;", "borderOptions", "Lcom/facebook/fresco/vito/options/BorderOptions;", "shape", "Lcom/facebook/fresco/vito/renderer/Shape;", "alpha", "", "createPaint", "Landroid/graphics/Paint;", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void renderBorder$default(Companion companion, Canvas canvas, BorderOptions borderOptions, Shape shape, int i, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                i = 255;
            }
            companion.renderBorder(canvas, borderOptions, shape, i);
        }

        public final void renderBorder(Canvas canvas, BorderOptions borderOptions, Shape shape, int alpha) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(borderOptions, "borderOptions");
            Intrinsics.checkNotNullParameter(shape, "shape");
            shape.draw(canvas, createPaint(borderOptions, alpha));
        }

        public static /* synthetic */ Paint createPaint$default(Companion companion, BorderOptions borderOptions, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 255;
            }
            return companion.createPaint(borderOptions, i);
        }

        public final Paint createPaint(BorderOptions borderOptions, int alpha) {
            Intrinsics.checkNotNullParameter(borderOptions, "borderOptions");
            Paint paint = new Paint(1);
            paint.setColor(ColorUtils.INSTANCE.multiplyColorAlpha(borderOptions.color, alpha));
            paint.setStrokeWidth(borderOptions.width);
            paint.setStyle(Paint.Style.STROKE);
            return paint;
        }
    }
}
