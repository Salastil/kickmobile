package com.facebook.fresco.vito.options;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageOptionsDrawableFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "", "createDrawable", "Landroid/graphics/drawable/Drawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "closeableImage", "Lcom/facebook/imagepipeline/image/CloseableImage;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "options_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ImageOptionsDrawableFactory {
    Drawable createDrawable(Resources resources, CloseableImage closeableImage, ImageOptions imageOptions);
}
