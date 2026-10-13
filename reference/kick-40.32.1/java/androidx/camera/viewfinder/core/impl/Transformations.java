package androidx.camera.viewfinder.core.impl;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Size;
import android.util.SizeF;
import androidx.camera.viewfinder.core.ScaleType;
import androidx.camera.viewfinder.core.TransformationInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J0\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J8\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J0\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u001fJ \u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0007H\u0002J4\u0010%\u001a\u00020&*\u00020\u00052\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u001eH\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001aH\u0002J\f\u0010/\u001a\u00020\u001c*\u00020\u000eH\u0002J\u0014\u00100\u001a\u00020\u001a*\u00020\u00112\u0006\u00101\u001a\u00020\u000eH\u0002J\u0014\u00102\u001a\u00020\u001c*\u00020\u00112\u0006\u00101\u001a\u00020\u000eH\u0002¨\u00063"}, d2 = {"Landroidx/camera/viewfinder/core/impl/Transformations;", "", "<init>", "()V", "getTextureViewCorrectionMatrix", "Landroid/graphics/Matrix;", "displayRotationDegrees", "", ViewProps.WIDTH, ViewProps.HEIGHT, "surfaceRotationToRotationDegrees", "rotationValue", "getSurfaceToViewfinderMatrix", "viewfinderSize", "Landroid/util/Size;", "surfaceResolution", "transformationInfo", "Landroidx/camera/viewfinder/core/TransformationInfo;", ViewProps.LAYOUT_DIRECTION, "scaleType", "Landroidx/camera/viewfinder/core/ScaleType;", "contentScale", "Landroidx/camera/viewfinder/core/impl/ContentScale;", "alignment", "Landroidx/camera/viewfinder/core/impl/Alignment;", "getViewfinderViewportRectForMismatchedAspectRatios", "Landroid/graphics/RectF;", "rotatedViewportSize", "Landroid/util/SizeF;", "isViewportAspectRatioMatchViewfinder", "", "isViewportAspectRatioMatchViewfinder$viewfinder_core_release", "getRectToRect", "source", TypedValues.Attributes.S_TARGET, "rotationDegrees", "is90or270", "setTransform", "", FirebaseAnalytics.Param.DESTINATION, "isAspectRatioMatchingWithRoundingError", "size1", "isAccurate1", "size2", "isAccurate2", "getNormalizedToBuffer", "viewPortRect", "toSizeF", "cropRectFor", "resolution", "rotatedViewportFor", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Transformations {
    public static final Transformations INSTANCE = new Transformations();

    private Transformations() {
    }

    @JvmStatic
    public static final Matrix getTextureViewCorrectionMatrix(int displayRotationDegrees, int width, int height) {
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        return INSTANCE.getRectToRect(rectF, rectF, -displayRotationDegrees);
    }

    @JvmStatic
    public static final int surfaceRotationToRotationDegrees(int rotationValue) {
        if (rotationValue == 0) {
            return 0;
        }
        if (rotationValue == 1) {
            return 90;
        }
        if (rotationValue == 2) {
            return RotationOptions.ROTATE_180;
        }
        if (rotationValue == 3) {
            return RotationOptions.ROTATE_270;
        }
        throw new UnsupportedOperationException("Unsupported surface rotation: " + rotationValue);
    }

    @JvmStatic
    public static final Matrix getSurfaceToViewfinderMatrix(Size viewfinderSize, Size surfaceResolution, TransformationInfo transformationInfo, int layoutDirection, ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(viewfinderSize, "viewfinderSize");
        Intrinsics.checkNotNullParameter(surfaceResolution, "surfaceResolution");
        Intrinsics.checkNotNullParameter(transformationInfo, "transformationInfo");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        return getSurfaceToViewfinderMatrix(viewfinderSize, surfaceResolution, transformationInfo, layoutDirection, scaleType.getContentScale(), scaleType.getAlignment());
    }

    @JvmStatic
    public static final Matrix getSurfaceToViewfinderMatrix(Size viewfinderSize, Size surfaceResolution, TransformationInfo transformationInfo, int layoutDirection, ContentScale contentScale, Alignment alignment) {
        RectF viewfinderViewportRectForMismatchedAspectRatios;
        Intrinsics.checkNotNullParameter(viewfinderSize, "viewfinderSize");
        Intrinsics.checkNotNullParameter(surfaceResolution, "surfaceResolution");
        Intrinsics.checkNotNullParameter(transformationInfo, "transformationInfo");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Transformations transformations = INSTANCE;
        SizeF sizeFRotatedViewportFor = transformations.rotatedViewportFor(transformationInfo, surfaceResolution);
        if (transformations.isViewportAspectRatioMatchViewfinder$viewfinder_core_release(sizeFRotatedViewportFor, viewfinderSize)) {
            viewfinderViewportRectForMismatchedAspectRatios = new RectF(0.0f, 0.0f, viewfinderSize.getWidth(), viewfinderSize.getHeight());
        } else {
            viewfinderViewportRectForMismatchedAspectRatios = transformations.getViewfinderViewportRectForMismatchedAspectRatios(sizeFRotatedViewportFor, viewfinderSize, layoutDirection, contentScale, alignment);
        }
        RectF rectFCropRectFor = transformations.cropRectFor(transformationInfo, surfaceResolution);
        Matrix rectToRect = transformations.getRectToRect(rectFCropRectFor, viewfinderViewportRectForMismatchedAspectRatios, transformationInfo.getSourceRotation());
        if (transformationInfo.getIsSourceMirroredHorizontally()) {
            rectToRect.preScale(-1.0f, 1.0f, rectFCropRectFor.centerX(), rectFCropRectFor.centerY());
        }
        if (transformationInfo.getIsSourceMirroredVertically()) {
            rectToRect.preScale(1.0f, -1.0f, rectFCropRectFor.centerX(), rectFCropRectFor.centerY());
        }
        return rectToRect;
    }

    private final RectF getViewfinderViewportRectForMismatchedAspectRatios(SizeF rotatedViewportSize, Size viewfinderSize, int layoutDirection, ContentScale contentScale, Alignment alignment) {
        Matrix matrix = new Matrix();
        INSTANCE.setTransform(matrix, rotatedViewportSize, viewfinderSize, layoutDirection, contentScale, alignment);
        RectF rectF = new RectF(0.0f, 0.0f, rotatedViewportSize.getWidth(), rotatedViewportSize.getHeight());
        matrix.mapRect(rectF);
        return rectF;
    }

    public final boolean isViewportAspectRatioMatchViewfinder$viewfinder_core_release(SizeF rotatedViewportSize, Size viewfinderSize) {
        Intrinsics.checkNotNullParameter(rotatedViewportSize, "rotatedViewportSize");
        Intrinsics.checkNotNullParameter(viewfinderSize, "viewfinderSize");
        return isAspectRatioMatchingWithRoundingError(rotatedViewportSize, false, viewfinderSize, true);
    }

    private final Matrix getRectToRect(RectF source, RectF target, int rotationDegrees) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(source, TransformationsKt.NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        matrix.postRotate(rotationDegrees);
        matrix.postConcat(INSTANCE.getNormalizedToBuffer(target));
        return matrix;
    }

    private final boolean is90or270(int rotationDegrees) {
        if (rotationDegrees == 0) {
            return false;
        }
        if (rotationDegrees == 90) {
            return true;
        }
        if (rotationDegrees == 180) {
            return false;
        }
        if (rotationDegrees == 270) {
            return true;
        }
        throw new IllegalArgumentException("Invalid rotation degrees: " + rotationDegrees);
    }

    private final void setTransform(Matrix matrix, SizeF sizeF, Size size, int i, ContentScale contentScale, Alignment alignment) {
        long jMo1260computeScaleFactorho9e9VQ = contentScale.mo1260computeScaleFactorho9e9VQ(sizeF, toSizeF(size));
        matrix.setScale(ScaleFactorF.m1274getScaleXimpl(jMo1260computeScaleFactorho9e9VQ), ScaleFactorF.m1275getScaleYimpl(jMo1260computeScaleFactorho9e9VQ));
        long jMo1259align41g9ag8 = alignment.mo1259align41g9ag8(new SizeF(sizeF.getWidth() * ScaleFactorF.m1274getScaleXimpl(jMo1260computeScaleFactorho9e9VQ), sizeF.getHeight() * ScaleFactorF.m1275getScaleYimpl(jMo1260computeScaleFactorho9e9VQ)), INSTANCE.toSizeF(size), i);
        matrix.postTranslate(OffsetF.m1265getXimpl(jMo1259align41g9ag8), OffsetF.m1266getYimpl(jMo1259align41g9ag8));
    }

    private final boolean isAspectRatioMatchingWithRoundingError(SizeF size1, boolean isAccurate1, Size size2, boolean isAccurate2) {
        float width;
        float width2;
        float width3;
        float width4;
        if (isAccurate1) {
            width = size1.getWidth() / size1.getHeight();
            width2 = width;
        } else {
            width = (size1.getWidth() + 1.0f) / (size1.getHeight() - 1.0f);
            width2 = (size1.getWidth() - 1.0f) / (size1.getHeight() + 1.0f);
        }
        if (isAccurate2) {
            width4 = size2.getWidth() / size2.getHeight();
            width3 = width4;
        } else {
            width3 = (size2.getWidth() + 1.0f) / (size2.getHeight() - 1.0f);
            width4 = (size2.getWidth() - 1.0f) / (size2.getHeight() + 1.0f);
        }
        return width >= width4 && width3 >= width2;
    }

    private final Matrix getNormalizedToBuffer(RectF viewPortRect) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(TransformationsKt.NORMALIZED_RECT, viewPortRect, Matrix.ScaleToFit.FILL);
        return matrix;
    }

    private final SizeF toSizeF(Size size) {
        return new SizeF(size.getWidth(), size.getHeight());
    }

    private final RectF cropRectFor(TransformationInfo transformationInfo, Size size) {
        float cropRectLeft = transformationInfo.getCropRectLeft();
        if (Float.isNaN(cropRectLeft)) {
            cropRectLeft = 0.0f;
        }
        float cropRectTop = transformationInfo.getCropRectTop();
        float f = Float.isNaN(cropRectTop) ? 0.0f : cropRectTop;
        float cropRectRight = transformationInfo.getCropRectRight();
        if (Float.isNaN(cropRectRight)) {
            cropRectRight = size.getWidth();
        }
        float cropRectBottom = transformationInfo.getCropRectBottom();
        if (Float.isNaN(cropRectBottom)) {
            cropRectBottom = size.getHeight();
        }
        return new RectF(cropRectLeft, f, cropRectRight, cropRectBottom);
    }

    private final SizeF rotatedViewportFor(TransformationInfo transformationInfo, Size size) {
        RectF rectFCropRectFor = cropRectFor(transformationInfo, size);
        if (INSTANCE.is90or270(transformationInfo.getSourceRotation())) {
            return new SizeF(rectFCropRectFor.height(), rectFCropRectFor.width());
        }
        return new SizeF(rectFCropRectFor.width(), rectFCropRectFor.height());
    }
}
