package com.facebook.fresco.vito.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.fresco.vito.options.BorderOptions;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.fresco.vito.options.RoundingOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapDrawableFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0014"}, d2 = {"Lcom/facebook/fresco/vito/drawable/BitmapDrawableFactory;", "Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "<init>", "()V", "createDrawable", "Landroid/graphics/drawable/Drawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "closeableImage", "Lcom/facebook/imagepipeline/image/CloseableImage;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "handleCloseableStaticBitmap", "closeableStaticBitmap", "Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;", "rotatedDrawable", "drawable", "hasTransformableRotationAngle", "", "hasTransformableExifOrientation", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BitmapDrawableFactory implements ImageOptionsDrawableFactory {
    @Override // com.facebook.fresco.vito.options.ImageOptionsDrawableFactory
    public Drawable createDrawable(Resources resources, CloseableImage closeableImage, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(closeableImage, "closeableImage");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            if (closeableImage instanceof CloseableStaticBitmap) {
                return handleCloseableStaticBitmap(resources, (CloseableStaticBitmap) closeableImage, imageOptions);
            }
            return null;
        }
        FrescoSystrace.beginSection("BitmapDrawableFactory#createDrawable");
        try {
            return closeableImage instanceof CloseableStaticBitmap ? handleCloseableStaticBitmap(resources, (CloseableStaticBitmap) closeableImage, imageOptions) : null;
        } finally {
            FrescoSystrace.endSection();
        }
    }

    protected final Drawable handleCloseableStaticBitmap(Resources resources, CloseableStaticBitmap closeableStaticBitmap, ImageOptions imageOptions) {
        BitmapDrawable bitmapDrawableRoundedDrawable;
        CircularBorderBitmapDrawable bitmapDrawable;
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(closeableStaticBitmap, "closeableStaticBitmap");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        Bitmap underlyingBitmap = closeableStaticBitmap.getUnderlyingBitmap();
        if (underlyingBitmap == null) {
            return null;
        }
        RoundingOptions roundingOptions = imageOptions.getRoundingOptions();
        BorderOptions borderOptions = imageOptions.getBorderOptions();
        if (Intrinsics.areEqual((Object) true, closeableStaticBitmap.getExtras().get("is_rounded")) && roundingOptions != null && roundingOptions.isCircular()) {
            if (borderOptions != null && borderOptions.width > 0.0f) {
                bitmapDrawable = new CircularBorderBitmapDrawable(resources, underlyingBitmap, borderOptions);
            } else {
                bitmapDrawable = new BitmapDrawable(resources, underlyingBitmap);
            }
            bitmapDrawableRoundedDrawable = bitmapDrawable;
        } else {
            bitmapDrawableRoundedDrawable = RoundingUtils.INSTANCE.roundedDrawable(resources, underlyingBitmap, borderOptions, roundingOptions);
        }
        return rotatedDrawable(closeableStaticBitmap, bitmapDrawableRoundedDrawable);
    }

    protected final Drawable rotatedDrawable(CloseableStaticBitmap closeableStaticBitmap, Drawable drawable) {
        Intrinsics.checkNotNullParameter(closeableStaticBitmap, "closeableStaticBitmap");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return (hasTransformableRotationAngle(closeableStaticBitmap) || hasTransformableExifOrientation(closeableStaticBitmap)) ? new OrientedDrawable(drawable, closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation()) : drawable;
    }

    private final boolean hasTransformableRotationAngle(CloseableStaticBitmap closeableStaticBitmap) {
        return (closeableStaticBitmap.getRotationAngle() == 0 || closeableStaticBitmap.getRotationAngle() == -1) ? false : true;
    }

    private final boolean hasTransformableExifOrientation(CloseableStaticBitmap closeableStaticBitmap) {
        return (closeableStaticBitmap.getExifOrientation() == 1 || closeableStaticBitmap.getExifOrientation() == 0) ? false : true;
    }
}
