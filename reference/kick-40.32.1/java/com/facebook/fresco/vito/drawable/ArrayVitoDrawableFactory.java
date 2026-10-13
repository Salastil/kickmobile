package com.facebook.fresco.vito.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrayVitoDrawableFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/facebook/fresco/vito/drawable/ArrayVitoDrawableFactory;", "Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "drawableFactories", "", "<init>", "([Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;)V", "[Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "createDrawable", "Landroid/graphics/drawable/Drawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "closeableImage", "Lcom/facebook/imagepipeline/image/CloseableImage;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ArrayVitoDrawableFactory implements ImageOptionsDrawableFactory {
    private final ImageOptionsDrawableFactory[] drawableFactories;

    public ArrayVitoDrawableFactory(ImageOptionsDrawableFactory... drawableFactories) {
        Intrinsics.checkNotNullParameter(drawableFactories, "drawableFactories");
        this.drawableFactories = drawableFactories;
    }

    @Override // com.facebook.fresco.vito.options.ImageOptionsDrawableFactory
    public Drawable createDrawable(Resources resources, CloseableImage closeableImage, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(closeableImage, "closeableImage");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        for (ImageOptionsDrawableFactory imageOptionsDrawableFactory : this.drawableFactories) {
            Drawable drawableCreateDrawable = imageOptionsDrawableFactory.createDrawable(resources, closeableImage, imageOptions);
            if (drawableCreateDrawable != null) {
                return drawableCreateDrawable;
            }
        }
        return null;
    }
}
