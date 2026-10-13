package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultDrawableFactory implements DrawableFactory {

    @Nullable
    private final DrawableFactory mAnimatedDrawableFactory;
    private final Resources mResources;

    @Nullable
    private final DrawableFactory mXmlDrawableFactory;

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage closeableImage) {
        return true;
    }

    public DefaultDrawableFactory(Resources resources, @Nullable DrawableFactory drawableFactory, @Nullable DrawableFactory drawableFactory2) {
        this.mResources = resources;
        this.mAnimatedDrawableFactory = drawableFactory;
        this.mXmlDrawableFactory = drawableFactory2;
    }

    public DefaultDrawableFactory(Resources resources, @Nullable DrawableFactory drawableFactory) {
        this(resources, drawableFactory, null);
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    @Nullable
    public Drawable createDrawable(CloseableImage closeableImage) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DefaultDrawableFactory#createDrawable");
            }
            if (closeableImage instanceof CloseableStaticBitmap) {
                CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
                Bitmap underlyingBitmap = closeableStaticBitmap.getUnderlyingBitmap();
                if (underlyingBitmap == null || underlyingBitmap.isRecycled()) {
                    return null;
                }
                try {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, underlyingBitmap);
                    return (hasTransformableRotationAngle(closeableStaticBitmap) || hasTransformableExifOrientation(closeableStaticBitmap)) ? new OrientedDrawable(bitmapDrawable, closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation()) : bitmapDrawable;
                } catch (IllegalStateException unused) {
                    return null;
                }
            }
            DrawableFactory drawableFactory = this.mAnimatedDrawableFactory;
            if (drawableFactory != null && drawableFactory.supportsImageType(closeableImage)) {
                return this.mAnimatedDrawableFactory.createDrawable(closeableImage);
            }
            DrawableFactory drawableFactory2 = this.mXmlDrawableFactory;
            if (drawableFactory2 == null || !drawableFactory2.supportsImageType(closeableImage)) {
                return null;
            }
            return this.mXmlDrawableFactory.createDrawable(closeableImage);
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private static boolean hasTransformableRotationAngle(CloseableStaticBitmap closeableStaticBitmap) {
        return (closeableStaticBitmap.getRotationAngle() == 0 || closeableStaticBitmap.getRotationAngle() == -1) ? false : true;
    }

    private static boolean hasTransformableExifOrientation(CloseableStaticBitmap closeableStaticBitmap) {
        return (closeableStaticBitmap.getExifOrientation() == 1 || closeableStaticBitmap.getExifOrientation() == 0) ? false : true;
    }
}
