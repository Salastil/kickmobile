package com.facebook.fresco.vito.core.impl;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.vito.core.NopDrawable;
import com.facebook.fresco.vito.drawable.RoundingUtils;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: HierarcherImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/HierarcherImpl;", "Lcom/facebook/fresco/vito/core/impl/Hierarcher;", "drawableFactory", "Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "<init>", "(Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;)V", "TAG", "", "buildActualImageDrawable", "Landroid/graphics/drawable/Drawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "closeableImage", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "buildPlaceholderDrawable", "applyRoundingOptions", "drawable", "buildProgressDrawable", "buildErrorDrawable", "buildActualImageWrapper", "Lcom/facebook/drawee/drawable/ForwardingDrawable;", "callerContext", "", "setupActualImageWrapper", "", "actualImageWrapper", "Lcom/facebook/drawee/drawable/ScaleTypeDrawable;", "buildOverlayDrawable", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class HierarcherImpl implements Hierarcher {
    private final String TAG;
    private final ImageOptionsDrawableFactory drawableFactory;

    public HierarcherImpl(ImageOptionsDrawableFactory drawableFactory) {
        Intrinsics.checkNotNullParameter(drawableFactory, "drawableFactory");
        this.drawableFactory = drawableFactory;
        this.TAG = "HierarcherImpl";
    }

    @Override // com.facebook.fresco.vito.core.impl.Hierarcher
    public Drawable buildActualImageDrawable(Resources resources, ImageOptions imageOptions, CloseableReference<CloseableImage> closeableImage) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        Intrinsics.checkNotNullParameter(closeableImage, "closeableImage");
        ImageOptionsDrawableFactory customDrawableFactory = imageOptions.getCustomDrawableFactory();
        if (customDrawableFactory == null) {
            customDrawableFactory = this.drawableFactory;
        }
        CloseableImage closeableImage2 = closeableImage.get();
        Intrinsics.checkNotNullExpressionValue(closeableImage2, "get(...)");
        return customDrawableFactory.createDrawable(resources, closeableImage2, imageOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v14, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, android.graphics.drawable.Drawable] */
    @Override // com.facebook.fresco.vito.core.impl.Hierarcher
    public Drawable buildPlaceholderDrawable(Resources resources, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("HierarcherImpl#buildPlaceholderDrawable");
        }
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = imageOptions.getPlaceholderDrawable();
            if (objectRef.element == 0 && imageOptions.getPlaceholderRes() != 0) {
                try {
                    objectRef.element = resources.getDrawable(imageOptions.getPlaceholderRes());
                } catch (Resources.NotFoundException e) {
                    FLog.e(this.TAG, "Placeholder drawable not found in Resources", e);
                }
            }
            if (objectRef.element == 0) {
                Integer placeholderColor = imageOptions.getPlaceholderColor();
                objectRef.element = placeholderColor != null ? new ColorDrawable(placeholderColor.intValue()) : 0;
            }
            if (objectRef.element == 0) {
                NopDrawable nopDrawable = NopDrawable.INSTANCE;
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return nopDrawable;
            }
            if (imageOptions.getPlaceholderApplyRoundingOptions()) {
                objectRef.element = applyRoundingOptions(resources, (Drawable) objectRef.element, imageOptions);
            }
            ScalingUtils.ScaleType placeholderScaleType = imageOptions.getPlaceholderScaleType();
            ScaleTypeDrawable scaleTypeDrawable = placeholderScaleType != null ? new ScaleTypeDrawable((Drawable) objectRef.element, placeholderScaleType) : (Drawable) objectRef.element;
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return scaleTypeDrawable;
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    @Override // com.facebook.fresco.vito.core.impl.Hierarcher
    public Drawable applyRoundingOptions(Resources resources, Drawable drawable, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        RoundingOptions roundingOptions = imageOptions.getRoundingOptions();
        return RoundingUtils.INSTANCE.roundedDrawable(resources, drawable, imageOptions.getBorderOptions(), roundingOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, android.graphics.drawable.Drawable] */
    @Override // com.facebook.fresco.vito.core.impl.Hierarcher
    public Drawable buildProgressDrawable(Resources resources, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("HierarcherImpl#buildProgressDrawable");
        }
        try {
            if (imageOptions.getProgressRes() == 0 && imageOptions.getProgressDrawable() == null) {
                return null;
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = imageOptions.getProgressDrawable();
            if (objectRef.element == 0) {
                objectRef.element = resources.getDrawable(imageOptions.getProgressRes());
            }
            if (objectRef.element == 0) {
                return null;
            }
            ((Drawable) objectRef.element).setLevel(0);
            ScalingUtils.ScaleType progressScaleType = imageOptions.getProgressScaleType();
            return progressScaleType != null ? new ScaleTypeDrawable((Drawable) objectRef.element, progressScaleType) : (Drawable) objectRef.element;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v12, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, android.graphics.drawable.Drawable] */
    @Override // com.facebook.fresco.vito.core.impl.Hierarcher
    public Drawable buildErrorDrawable(Resources resources, ImageOptions imageOptions) {
        ScaleTypeDrawable scaleTypeDrawable;
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("HierarcherImpl#buildErrorDrawable");
        }
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = imageOptions.getErrorDrawable();
            if (objectRef.element == 0 && imageOptions.getErrorRes() != 0) {
                objectRef.element = resources.getDrawable(imageOptions.getErrorRes());
            } else if (objectRef.element == 0) {
                Integer errorColor = imageOptions.getErrorColor();
                objectRef.element = errorColor != null ? new ColorDrawable(errorColor.intValue()) : 0;
            }
            if (objectRef.element == 0) {
                return null;
            }
            if (imageOptions.getErrorApplyRoundingOptions()) {
                objectRef.element = applyRoundingOptions(resources, (Drawable) objectRef.element, imageOptions);
            }
            ScalingUtils.ScaleType errorScaleType = imageOptions.getErrorScaleType();
            if (errorScaleType != null) {
                scaleTypeDrawable = new ScaleTypeDrawable((Drawable) objectRef.element, errorScaleType, imageOptions.getErrorFocusPoint());
            } else {
                scaleTypeDrawable = (Drawable) objectRef.element;
            }
            return scaleTypeDrawable;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    @Override // com.facebook.fresco.vito.core.impl.Hierarcher
    public ForwardingDrawable buildActualImageWrapper(ImageOptions imageOptions, Object callerContext) {
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(NopDrawable.INSTANCE, imageOptions.getActualImageScaleType(), imageOptions.getActualImageFocusPoint());
        ColorFilter actualImageColorFilter = imageOptions.getActualImageColorFilter();
        if (actualImageColorFilter != null) {
            scaleTypeDrawable.setColorFilter(actualImageColorFilter);
        }
        return scaleTypeDrawable;
    }

    @Override // com.facebook.fresco.vito.core.impl.Hierarcher
    public void setupActualImageWrapper(ScaleTypeDrawable actualImageWrapper, ImageOptions imageOptions, Object callerContext) {
        Intrinsics.checkNotNullParameter(actualImageWrapper, "actualImageWrapper");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        actualImageWrapper.setScaleType(imageOptions.getActualImageScaleType());
        actualImageWrapper.setFocusPoint(imageOptions.getActualImageFocusPoint());
        actualImageWrapper.setColorFilter(imageOptions.getActualImageColorFilter());
    }

    @Override // com.facebook.fresco.vito.core.impl.Hierarcher
    public Drawable buildOverlayDrawable(Resources resources, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        Drawable overlayDrawable = imageOptions.getOverlayDrawable();
        if (overlayDrawable != null) {
            return overlayDrawable;
        }
        if (imageOptions.getOverlayRes() == 0) {
            return null;
        }
        return resources.getDrawable(imageOptions.getOverlayRes());
    }
}
