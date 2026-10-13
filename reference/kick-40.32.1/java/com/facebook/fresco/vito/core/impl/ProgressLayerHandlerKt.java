package com.facebook.fresco.vito.core.impl;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.renderer.DrawableImageDataModel;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ProgressLayerHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"setupProgressLayer", "", "Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "hideProgressLayer", "updateProgress", "dataSource", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "setProgress", "Landroid/graphics/drawable/Drawable;", "progress", "", "core-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ProgressLayerHandlerKt {
    public static final void setupProgressLayer(KFrescoVitoDrawable kFrescoVitoDrawable, Resources resources, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(kFrescoVitoDrawable, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        Drawable drawableCreateProgressDrawable = KImageOptionsKt.createProgressDrawable(imageOptions, resources);
        if (drawableCreateProgressDrawable == null) {
            ImageLayerDataModel progressLayer = kFrescoVitoDrawable.getProgressLayer();
            if (progressLayer != null) {
                ImageLayerDataModel.reset$default(progressLayer, false, 1, null);
            }
            kFrescoVitoDrawable.setProgressLayer(null);
            return;
        }
        ImageLayerDataModel progressLayer2 = kFrescoVitoDrawable.getProgressLayer();
        if (progressLayer2 == null) {
            progressLayer2 = kFrescoVitoDrawable.createLayer$core_impl_release();
            kFrescoVitoDrawable.setProgressLayer(progressLayer2);
        }
        setProgress(drawableCreateProgressDrawable, 0.0f);
        ImageLayerDataModel.configure$default(progressLayer2, new DrawableImageDataModel(drawableCreateProgressDrawable, false, 2, null), null, null, KImageOptionsKt.createProgressCanvasTransformation(imageOptions), null, null, 54, null);
    }

    public static final void hideProgressLayer(KFrescoVitoDrawable kFrescoVitoDrawable) {
        Intrinsics.checkNotNullParameter(kFrescoVitoDrawable, "<this>");
        ImageLayerDataModel progressLayer = kFrescoVitoDrawable.getProgressLayer();
        if (progressLayer != null) {
            ImageLayerDataModel.reset$default(progressLayer, false, 1, null);
        }
    }

    public static final void updateProgress(KFrescoVitoDrawable kFrescoVitoDrawable, DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(kFrescoVitoDrawable, "<this>");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        ImageLayerDataModel progressLayer = kFrescoVitoDrawable.getProgressLayer();
        Drawable drawableMaybeGetDrawable = ImageLayerDataModelExtensionsKt.maybeGetDrawable(progressLayer != null ? progressLayer.getDataModel() : null);
        if (drawableMaybeGetDrawable == null || dataSource.isFinished()) {
            return;
        }
        setProgress(drawableMaybeGetDrawable, dataSource.getProgress());
    }

    public static final void setProgress(Drawable drawable, float f) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        drawable.setLevel(MathKt.roundToInt(f * 10000.0f));
        DrawableExtensionsKt.toggleAnimation(drawable, drawable.getLevel() <= 9990);
    }
}
