package com.facebook.fresco.vito.draweesupport;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DrawableFactoryWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/fresco/vito/draweesupport/DrawableFactoryWrapper;", "Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "drawableFactory", "Lcom/facebook/imagepipeline/drawable/DrawableFactory;", "<init>", "(Lcom/facebook/imagepipeline/drawable/DrawableFactory;)V", "createDrawable", "Landroid/graphics/drawable/Drawable;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "closeableImage", "Lcom/facebook/imagepipeline/image/CloseableImage;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "Companion", "drawee-support_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DrawableFactoryWrapper implements ImageOptionsDrawableFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DrawableFactory drawableFactory;

    public /* synthetic */ DrawableFactoryWrapper(DrawableFactory drawableFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawableFactory);
    }

    @JvmStatic
    public static final ImageOptionsDrawableFactory wrap(DrawableFactory drawableFactory) {
        return INSTANCE.wrap(drawableFactory);
    }

    private DrawableFactoryWrapper(DrawableFactory drawableFactory) {
        this.drawableFactory = drawableFactory;
    }

    @Override // com.facebook.fresco.vito.options.ImageOptionsDrawableFactory
    public Drawable createDrawable(Resources resources, CloseableImage closeableImage, ImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(closeableImage, "closeableImage");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (!this.drawableFactory.supportsImageType(closeableImage)) {
            return null;
        }
        DrawableFactory drawableFactory = this.drawableFactory;
        if (drawableFactory instanceof ImageOptionsDrawableFactory) {
            return ((ImageOptionsDrawableFactory) drawableFactory).createDrawable(resources, closeableImage, imageOptions);
        }
        return drawableFactory.createDrawable(closeableImage);
    }

    /* JADX INFO: compiled from: DrawableFactoryWrapper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/fresco/vito/draweesupport/DrawableFactoryWrapper$Companion;", "", "<init>", "()V", "wrap", "Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "drawableFactory", "Lcom/facebook/imagepipeline/drawable/DrawableFactory;", "drawee-support_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ImageOptionsDrawableFactory wrap(DrawableFactory drawableFactory) {
            Intrinsics.checkNotNullParameter(drawableFactory, "drawableFactory");
            if (drawableFactory instanceof ImageOptionsDrawableFactory) {
                return (ImageOptionsDrawableFactory) drawableFactory;
            }
            return new DrawableFactoryWrapper(drawableFactory, null);
        }
    }
}
