package com.facebook.fresco.vito.core.impl;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.fresco.vito.options.BorderOptions;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import com.facebook.fresco.vito.renderer.ImageRenderer;
import com.facebook.fresco.vito.renderer.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageWithTransformationAndBorderRenderer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImageWithTransformationAndBorderRenderer;", "", "<init>", "()V", "Companion", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageWithTransformationAndBorderRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ImageWithTransformationAndBorderRenderer.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImageWithTransformationAndBorderRenderer$Companion;", "", "<init>", "()V", "createRenderCommand", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lcom/facebook/fresco/vito/renderer/RenderCommand;", "model", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "roundingOptions", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "borderOptions", "Lcom/facebook/fresco/vito/options/BorderOptions;", "canvasTransform", "Landroid/graphics/Matrix;", "bounds", "Landroid/graphics/Rect;", "paint", "Landroid/graphics/Paint;", "alpha", "", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<Canvas, Unit> createRenderCommand(ImageDataModel model, RoundingOptions roundingOptions, final BorderOptions borderOptions, Matrix canvasTransform, final Rect bounds, Paint paint, final int alpha) {
            Shape shape;
            Matrix matrix;
            final RectF rectF;
            RectF rectF2;
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            Intrinsics.checkNotNullParameter(paint, "paint");
            float f = borderOptions != null ? borderOptions.padding : 0.0f;
            float f2 = borderOptions != null ? borderOptions.width : 0.0f;
            boolean z = f2 > 0.0f;
            boolean z2 = borderOptions != null ? borderOptions.scaleDownInsideBorders : false;
            RectF rectF3 = new RectF(bounds);
            float f3 = f2 + f;
            if (z && (z2 || f != 0.0f)) {
                if (z2) {
                    rectF2 = new RectF(rectF3);
                    rectF2.inset(f3, f3);
                } else {
                    rectF2 = new RectF(rectF3);
                    rectF2.inset(f2, f2);
                }
                Matrix matrix2 = new Matrix();
                matrix2.setRectToRect(rectF3, rectF2, Matrix.ScaleToFit.FILL);
                matrix = new Matrix(canvasTransform);
                matrix.postConcat(matrix2);
                shape = ShapeCalculator.INSTANCE.getShape(rectF2, roundingOptions, -f3);
            } else {
                shape = ShapeCalculator.INSTANCE.getShape(rectF3, roundingOptions, -f3);
                matrix = canvasTransform;
            }
            final Function1<Canvas, Unit> function1CreateImageDataModelRenderCommand = ImageRenderer.INSTANCE.createImageDataModelRenderCommand(model, shape, paint, matrix);
            Shape shape2 = null;
            if (model.getWidth() <= 0 || model.getHeight() <= 0) {
                rectF = null;
            } else {
                RectF rectF4 = new RectF(0.0f, 0.0f, model.getWidth(), model.getHeight());
                if (matrix != null) {
                    matrix.mapRect(rectF4);
                }
                rectF = rectF4;
            }
            if (z) {
                float f4 = f2 / 2.0f;
                RectF rectF5 = new RectF(rectF3);
                rectF5.inset(f4, f4);
                shape2 = ShapeCalculator.INSTANCE.getShape(rectF5, roundingOptions, -f4);
            }
            final Shape shape3 = shape2;
            return new Function1() { // from class: com.facebook.fresco.vito.core.impl.ImageWithTransformationAndBorderRenderer$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ImageWithTransformationAndBorderRenderer.Companion.createRenderCommand$lambda$6(bounds, rectF, function1CreateImageDataModelRenderCommand, shape3, borderOptions, alpha, (Canvas) obj);
                }
            };
        }

        static final Unit createRenderCommand$lambda$6(Rect rect, RectF rectF, Function1 function1, Shape shape, BorderOptions borderOptions, int i, Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int iSave = canvas.save();
            canvas.clipRect(rect);
            if (rectF != null) {
                canvas.clipRect(rectF);
            }
            function1.invoke(canvas);
            canvas.restoreToCount(iSave);
            if (shape != null && borderOptions != null) {
                BorderRenderer.INSTANCE.renderBorder(canvas, borderOptions, shape, i);
            }
            return Unit.INSTANCE;
        }
    }
}
