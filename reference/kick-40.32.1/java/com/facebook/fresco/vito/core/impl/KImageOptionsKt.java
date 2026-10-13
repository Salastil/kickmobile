package com.facebook.fresco.vito.core.impl;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.renderer.CanvasTransformation;
import com.facebook.fresco.vito.renderer.ColorIntImageDataModel;
import com.facebook.fresco.vito.renderer.DrawableImageDataModel;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KImageOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\t\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\f\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0004\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\u0004\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u000e*\u00020\u0004\u001a\f\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0004\u001a$\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0002\u001a3\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0019\u001a\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0003*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0015H\u0002\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u000b*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u0016\u0010\u001c\u001a\u00020\u000e*\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"TAG", "", "createPlaceholderModel", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "Lcom/facebook/fresco/vito/options/ImageOptions;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "createOverlayModel", "createErrorModel", "createBackgroundModel", "createProgressDrawable", "Landroid/graphics/drawable/Drawable;", "createOverlayDrawable", "createPlaceholderCanvasTransformation", "Lcom/facebook/fresco/vito/renderer/CanvasTransformation;", "createActualImageCanvasTransformation", "createProgressCanvasTransformation", "createErrorCanvasTransformation", "create", "drawable", "drawableRes", "", "toModel", "colorOrDrawableRes", "colorInt", "(Landroid/content/res/Resources;Landroid/graphics/drawable/Drawable;ILjava/lang/Integer;)Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "getColorOrDrawableModel", "getNullableDrawable", "getCanvasTransformation", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "focusPoint", "Landroid/graphics/PointF;", "core-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KImageOptionsKt {
    private static final String TAG = "KImageOptions";

    public static final ImageDataModel createPlaceholderModel(ImageOptions imageOptions, Resources resources) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return toModel(resources, imageOptions.getPlaceholderDrawable(), imageOptions.getPlaceholderRes(), imageOptions.getPlaceholderColor());
    }

    public static final ImageDataModel createOverlayModel(ImageOptions imageOptions, Resources resources) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return toModel(createOverlayDrawable(imageOptions, resources));
    }

    public static final ImageDataModel createErrorModel(ImageOptions imageOptions, Resources resources) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return toModel(resources, imageOptions.getErrorDrawable(), imageOptions.getErrorRes(), imageOptions.getErrorColor());
    }

    public static final ImageDataModel createBackgroundModel(ImageOptions imageOptions, Resources resources) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return toModel(imageOptions.getBackgroundDrawable());
    }

    public static final Drawable createProgressDrawable(ImageOptions imageOptions, Resources resources) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return create(resources, imageOptions.getProgressDrawable(), imageOptions.getProgressRes());
    }

    public static final Drawable createOverlayDrawable(ImageOptions imageOptions, Resources resources) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return create(resources, imageOptions.getOverlayDrawable(), imageOptions.getOverlayRes());
    }

    public static final CanvasTransformation createPlaceholderCanvasTransformation(ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        ScalingUtils.ScaleType placeholderScaleType = imageOptions.getPlaceholderScaleType();
        if (placeholderScaleType != null) {
            return getCanvasTransformation(placeholderScaleType, imageOptions.getPlaceholderFocusPoint());
        }
        return null;
    }

    public static final CanvasTransformation createActualImageCanvasTransformation(ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        return getCanvasTransformation(imageOptions.getActualImageScaleType(), imageOptions.getActualImageFocusPoint());
    }

    public static final CanvasTransformation createProgressCanvasTransformation(ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        ScalingUtils.ScaleType progressScaleType = imageOptions.getProgressScaleType();
        if (progressScaleType != null) {
            return getCanvasTransformation$default(progressScaleType, null, 1, null);
        }
        return null;
    }

    public static final CanvasTransformation createErrorCanvasTransformation(ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageOptions, "<this>");
        ScalingUtils.ScaleType errorScaleType = imageOptions.getErrorScaleType();
        if (errorScaleType != null) {
            return getCanvasTransformation(errorScaleType, imageOptions.getErrorFocusPoint());
        }
        return null;
    }

    private static final Drawable create(Resources resources, Drawable drawable, int i) {
        if (drawable != null) {
            return drawable;
        }
        if (i != 0) {
            return getNullableDrawable(resources, i);
        }
        return null;
    }

    private static final ImageDataModel toModel(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return drawable instanceof ColorDrawable ? new ColorIntImageDataModel(((ColorDrawable) drawable).getColor()) : new DrawableImageDataModel(drawable, false, 2, null);
    }

    private static final ImageDataModel toModel(Resources resources, Drawable drawable, int i, Integer num) {
        if (drawable != null) {
            return toModel(drawable);
        }
        if (i != 0) {
            return getColorOrDrawableModel(resources, i);
        }
        if (num != null) {
            return new ColorIntImageDataModel(num.intValue());
        }
        return null;
    }

    private static final ImageDataModel getColorOrDrawableModel(Resources resources, int i) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type >= 28 && typedValue.type <= 31) {
            return new ColorIntImageDataModel(typedValue.data);
        }
        return toModel(getNullableDrawable(resources, i));
    }

    private static final Drawable getNullableDrawable(Resources resources, int i) {
        try {
            return resources.getDrawable(i);
        } catch (Resources.NotFoundException e) {
            FLog.e(TAG, "Drawable not found in Resources " + i, e);
            return null;
        }
    }

    public static /* synthetic */ CanvasTransformation getCanvasTransformation$default(ScalingUtils.ScaleType scaleType, PointF pointF, int i, Object obj) {
        if ((i & 1) != 0) {
            pointF = null;
        }
        return getCanvasTransformation(scaleType, pointF);
    }

    public static final CanvasTransformation getCanvasTransformation(final ScalingUtils.ScaleType scaleType, final PointF pointF) {
        Intrinsics.checkNotNullParameter(scaleType, "<this>");
        return new CanvasTransformation() { // from class: com.facebook.fresco.vito.core.impl.KImageOptionsKt.getCanvasTransformation.1
            @Override // com.facebook.fresco.vito.renderer.CanvasTransformation
            public Matrix calculateTransformation(Matrix outTransform, Rect parentBounds, int childWidth, int childHeight) {
                Intrinsics.checkNotNullParameter(outTransform, "outTransform");
                Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
                ScalingUtils.ScaleType scaleType2 = scaleType;
                PointF pointF2 = pointF;
                float f = pointF2 != null ? pointF2.x : 0.5f;
                PointF pointF3 = pointF;
                scaleType2.getTransform(outTransform, parentBounds, childWidth, childHeight, f, pointF3 != null ? pointF3.y : 0.5f);
                return outTransform;
            }
        };
    }
}
