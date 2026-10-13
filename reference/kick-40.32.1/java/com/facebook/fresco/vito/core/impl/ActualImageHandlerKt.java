package com.facebook.fresco.vito.core.impl;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.renderer.DrawableImageDataModel;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActualImageHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u001a\u001a\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e\u001a\u001a\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"setActualImage", "", "Lcom/facebook/fresco/vito/core/impl/ImageLayerDataModel;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "closeableImage", "Lcom/facebook/imagepipeline/image/CloseableImage;", "imageToDataModelMapper", "Lkotlin/Function3;", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "setActualImageDrawable", "actualImageDrawable", "Landroid/graphics/drawable/Drawable;", "setPlaceholder", "setOverlay", "setError", "core-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ActualImageHandlerKt {
    public static final void setActualImage(ImageLayerDataModel imageLayerDataModel, Resources resources, ImageOptions imageOptions, CloseableImage closeableImage, Function3<? super Resources, ? super CloseableImage, ? super ImageOptions, ? extends ImageDataModel> imageToDataModelMapper) {
        Intrinsics.checkNotNullParameter(imageLayerDataModel, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        Intrinsics.checkNotNullParameter(closeableImage, "closeableImage");
        Intrinsics.checkNotNullParameter(imageToDataModelMapper, "imageToDataModelMapper");
        ImageLayerDataModel.configure$default(imageLayerDataModel, imageToDataModelMapper.invoke(resources, closeableImage, imageOptions), imageOptions.getRoundingOptions(), imageOptions.getBorderOptions(), KImageOptionsKt.createActualImageCanvasTransformation(imageOptions), null, imageOptions.getActualImageColorFilter(), 16, null);
    }

    public static final void setActualImageDrawable(ImageLayerDataModel imageLayerDataModel, ImageOptions imageOptions, Drawable actualImageDrawable) {
        Intrinsics.checkNotNullParameter(imageLayerDataModel, "<this>");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        Intrinsics.checkNotNullParameter(actualImageDrawable, "actualImageDrawable");
        DrawableImageDataModel drawableImageDataModel = new DrawableImageDataModel(actualImageDrawable, false, 2, null);
        DrawableImageDataModel drawableImageDataModel2 = drawableImageDataModel;
        ImageLayerDataModel.configure$default(imageLayerDataModel, drawableImageDataModel2, imageOptions.getRoundingOptions(), imageOptions.getBorderOptions(), KImageOptionsKt.createActualImageCanvasTransformation(imageOptions), null, imageOptions.getActualImageColorFilter(), 16, null);
    }

    public static final void setPlaceholder(ImageLayerDataModel imageLayerDataModel, Resources resources, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageLayerDataModel, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        ImageDataModel imageDataModelCreatePlaceholderModel = KImageOptionsKt.createPlaceholderModel(imageOptions, resources);
        if (imageDataModelCreatePlaceholderModel == null) {
            ImageLayerDataModel.reset$default(imageLayerDataModel, false, 1, null);
        } else {
            ImageLayerDataModel.configure$default(imageLayerDataModel, imageDataModelCreatePlaceholderModel, imageOptions.getPlaceholderApplyRoundingOptions() ? imageOptions.getRoundingOptions() : null, imageOptions.getPlaceholderApplyRoundingOptions() ? imageOptions.getBorderOptions() : null, KImageOptionsKt.createPlaceholderCanvasTransformation(imageOptions), null, null, 48, null);
        }
    }

    public static final void setOverlay(ImageLayerDataModel imageLayerDataModel, Resources resources, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageLayerDataModel, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        ImageLayerDataModel.configure$default(imageLayerDataModel, KImageOptionsKt.createOverlayModel(imageOptions, resources), null, null, null, null, null, 62, null);
    }

    public static final void setError(ImageLayerDataModel imageLayerDataModel, Resources resources, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageLayerDataModel, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        ImageDataModel imageDataModelCreateErrorModel = KImageOptionsKt.createErrorModel(imageOptions, resources);
        if (imageDataModelCreateErrorModel == null) {
            ImageLayerDataModel.reset$default(imageLayerDataModel, false, 1, null);
        } else {
            ImageLayerDataModel.configure$default(imageLayerDataModel, imageDataModelCreateErrorModel, null, null, KImageOptionsKt.createErrorCanvasTransformation(imageOptions), null, null, 54, null);
        }
    }
}
