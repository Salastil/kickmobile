package com.facebook.fresco.vito.core;

import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ImagePerfNotifier;
import com.facebook.fresco.vito.listener.ImageListener;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;

/* JADX INFO: compiled from: CombinedImageListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J(\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H&J \u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H&R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006#À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/CombinedImageListener;", "Lcom/facebook/fresco/vito/core/VitoImageRequestListener;", "setVitoImageRequestListener", "", "vitoImageRequestListener", "setLocalVitoImageRequestListener", "setControllerListener2", "controllerListener2", "Lcom/facebook/fresco/ui/common/ControllerListener2;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "imageListener", "Lcom/facebook/fresco/vito/listener/ImageListener;", "getImageListener", "()Lcom/facebook/fresco/vito/listener/ImageListener;", "setImageListener", "(Lcom/facebook/fresco/vito/listener/ImageListener;)V", "setImagePerfLoggingListener", "imagePerfLoggingListener", "Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "getImagePerfLoggingListener", "setLocalImagePerfStateListener", "imagePerfNotifier", "Lcom/facebook/fresco/ui/common/ImagePerfNotifier;", "onReset", "resetVitoImageRequestListener", "", "resetLocalVitoImageRequestListener", "resetLocalImagePerfStateListener", "resetControllerListener2", "onImageSet", "image", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "viewportDimensions", "Landroid/graphics/Rect;", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CombinedImageListener extends VitoImageRequestListener {
    ImageListener getImageListener();

    ImagePerfLoggingListener getImagePerfLoggingListener();

    void onImageSet(CloseableReference<CloseableImage> image, Rect viewportDimensions);

    void onReset(boolean resetVitoImageRequestListener, boolean resetLocalVitoImageRequestListener, boolean resetLocalImagePerfStateListener, boolean resetControllerListener2);

    void setControllerListener2(ControllerListener2<ImageInfo> controllerListener2);

    void setImageListener(ImageListener imageListener);

    void setImagePerfLoggingListener(ImagePerfLoggingListener imagePerfLoggingListener);

    void setLocalImagePerfStateListener(ImagePerfNotifier imagePerfNotifier);

    void setLocalVitoImageRequestListener(VitoImageRequestListener vitoImageRequestListener);

    void setVitoImageRequestListener(VitoImageRequestListener vitoImageRequestListener);
}
