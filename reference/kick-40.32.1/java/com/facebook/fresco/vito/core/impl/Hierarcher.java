package com.facebook.fresco.vito.core.impl;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;

/* JADX INFO: compiled from: Hierarcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H'J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/Hierarcher;", "", "buildActualImageDrawable", "Landroid/graphics/drawable/Drawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "closeableImage", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "buildPlaceholderDrawable", "buildProgressDrawable", "buildErrorDrawable", "buildActualImageWrapper", "Lcom/facebook/drawee/drawable/ForwardingDrawable;", "callerContext", "buildOverlayDrawable", "setupActualImageWrapper", "", "actualImageWrapper", "Lcom/facebook/drawee/drawable/ScaleTypeDrawable;", "applyRoundingOptions", "drawable", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Hierarcher {
    Drawable applyRoundingOptions(Resources resources, Drawable drawable, ImageOptions imageOptions);

    Drawable buildActualImageDrawable(Resources resources, ImageOptions imageOptions, CloseableReference<CloseableImage> closeableImage);

    ForwardingDrawable buildActualImageWrapper(ImageOptions imageOptions, Object callerContext);

    Drawable buildErrorDrawable(Resources resources, ImageOptions imageOptions);

    Drawable buildOverlayDrawable(Resources resources, ImageOptions imageOptions);

    Drawable buildPlaceholderDrawable(Resources resources, ImageOptions imageOptions);

    Drawable buildProgressDrawable(Resources resources, ImageOptions imageOptions);

    void setupActualImageWrapper(ScaleTypeDrawable actualImageWrapper, ImageOptions imageOptions, Object callerContext);
}
