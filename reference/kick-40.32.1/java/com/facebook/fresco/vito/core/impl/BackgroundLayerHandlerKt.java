package com.facebook.fresco.vito.core.impl;

import android.content.res.Resources;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundLayerHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"setupBackgroundLayer", "", "Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "core-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BackgroundLayerHandlerKt {
    public static final void setupBackgroundLayer(KFrescoVitoDrawable kFrescoVitoDrawable, Resources resources, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(kFrescoVitoDrawable, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        ImageDataModel imageDataModelCreateBackgroundModel = KImageOptionsKt.createBackgroundModel(imageOptions, resources);
        if (imageDataModelCreateBackgroundModel == null) {
            ImageLayerDataModel backgroundLayer = kFrescoVitoDrawable.getBackgroundLayer();
            if (backgroundLayer != null) {
                ImageLayerDataModel.reset$default(backgroundLayer, false, 1, null);
            }
            kFrescoVitoDrawable.setBackgroundLayer(null);
            return;
        }
        ImageLayerDataModel backgroundLayer2 = kFrescoVitoDrawable.getBackgroundLayer();
        if (backgroundLayer2 == null) {
            backgroundLayer2 = kFrescoVitoDrawable.createLayer$core_impl_release();
            kFrescoVitoDrawable.setBackgroundLayer(backgroundLayer2);
        }
        ImageLayerDataModel.configure$default(backgroundLayer2, imageDataModelCreateBackgroundModel, imageOptions.getRoundingOptions(), null, KImageOptionsKt.createActualImageCanvasTransformation(imageOptions), null, null, 52, null);
    }
}
