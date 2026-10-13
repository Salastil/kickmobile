package com.facebook.fresco.vito.listener;

import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/listener/ImageListener;", "Lcom/facebook/fresco/ui/common/OnDrawControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onSubmit", "", "id", "", "callerContext", "", "onPlaceholderSet", "placeholder", "Landroid/graphics/drawable/Drawable;", "onFinalImageSet", "imageOrigin", "", "imageInfo", "drawable", "onIntermediateImageSet", "onIntermediateImageFailed", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onFailure", "error", "onRelease", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ImageListener extends OnDrawControllerListener<ImageInfo> {
    default void onFailure(long id, Drawable error, Throwable throwable) {
    }

    default void onFinalImageSet(long id, int imageOrigin, ImageInfo imageInfo, Drawable drawable) {
    }

    default void onIntermediateImageFailed(long id, Throwable throwable) {
    }

    default void onIntermediateImageSet(long id, ImageInfo imageInfo) {
    }

    default void onPlaceholderSet(long id, Drawable placeholder) {
    }

    default void onRelease(long id) {
    }

    default void onSubmit(long id, Object callerContext) {
    }

    /* JADX INFO: compiled from: ImageListener.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onSubmit(ImageListener imageListener, long j, Object obj) {
            ImageListener.super.onSubmit(j, obj);
        }

        @Deprecated
        public static void onPlaceholderSet(ImageListener imageListener, long j, Drawable drawable) {
            ImageListener.super.onPlaceholderSet(j, drawable);
        }

        @Deprecated
        public static void onFinalImageSet(ImageListener imageListener, long j, int i, ImageInfo imageInfo, Drawable drawable) {
            ImageListener.super.onFinalImageSet(j, i, imageInfo, drawable);
        }

        @Deprecated
        public static void onIntermediateImageSet(ImageListener imageListener, long j, ImageInfo imageInfo) {
            ImageListener.super.onIntermediateImageSet(j, imageInfo);
        }

        @Deprecated
        public static void onIntermediateImageFailed(ImageListener imageListener, long j, Throwable th) {
            ImageListener.super.onIntermediateImageFailed(j, th);
        }

        @Deprecated
        public static void onFailure(ImageListener imageListener, long j, Drawable drawable, Throwable th) {
            ImageListener.super.onFailure(j, drawable, th);
        }

        @Deprecated
        public static void onRelease(ImageListener imageListener, long j) {
            ImageListener.super.onRelease(j);
        }
    }
}
