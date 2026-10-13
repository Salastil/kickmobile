package com.facebook.fresco.vito.core;

import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.VisibilityAware;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePerfLoggingListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J \u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "Lcom/facebook/fresco/ui/common/ControllerListener2;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "Lcom/facebook/fresco/ui/common/VisibilityAware;", "onImageSet", "", "image", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "viewportDimensions", "Landroid/graphics/Rect;", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ImagePerfLoggingListener extends ControllerListener2<ImageInfo>, VisibilityAware {
    default void onImageSet(CloseableReference<CloseableImage> image, Rect viewportDimensions) {
        Intrinsics.checkNotNullParameter(image, "image");
    }

    /* JADX INFO: compiled from: ImagePerfLoggingListener.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onImageSet(ImagePerfLoggingListener imagePerfLoggingListener, CloseableReference<CloseableImage> image, Rect rect) {
            Intrinsics.checkNotNullParameter(image, "image");
            ImagePerfLoggingListener.super.onImageSet(image, rect);
        }
    }
}
