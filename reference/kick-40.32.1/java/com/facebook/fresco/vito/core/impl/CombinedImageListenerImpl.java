package com.facebook.fresco.vito.core.impl;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.ui.common.BaseControllerListener2;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ImagePerfNotifier;
import com.facebook.fresco.ui.common.ImagePerfNotifierHolder;
import com.facebook.fresco.ui.common.VitoUtils;
import com.facebook.fresco.vito.core.CombinedImageListener;
import com.facebook.fresco.vito.core.ImagePerfLoggingListener;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.core.VitoImageRequestListener;
import com.facebook.fresco.vito.listener.ImageListener;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CombinedImageListenerImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0002J,\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\"\u0010&\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J>\u0010)\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010-\u001a\u0004\u0018\u00010(H\u0016J\"\u0010.\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u00100\u001a\u0004\u0018\u000101H\u0016J6\u00102\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010(2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\"\u00104\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u00105\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J(\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u000208H\u0016J \u0010<\u001a\u00020\u00152\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/CombinedImageListenerImpl;", "Lcom/facebook/fresco/vito/core/CombinedImageListener;", "<init>", "()V", "localVitoImageRequestListener", "Lcom/facebook/fresco/vito/core/VitoImageRequestListener;", "vitoImageRequestListener", "imageListener", "Lcom/facebook/fresco/vito/listener/ImageListener;", "getImageListener", "()Lcom/facebook/fresco/vito/listener/ImageListener;", "setImageListener", "(Lcom/facebook/fresco/vito/listener/ImageListener;)V", "controllerListener2", "Lcom/facebook/fresco/ui/common/ControllerListener2;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "imagePerfLoggingListener", "Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "localImagePerfStateListener", "Lcom/facebook/fresco/ui/common/ImagePerfNotifier;", "setVitoImageRequestListener", "", "setLocalVitoImageRequestListener", "setControllerListener2", "setImagePerfLoggingListener", "getImagePerfLoggingListener", "setLocalImagePerfStateListener", "imagePerfNotifier", "checkAndSetLocalImagePerfStateListener", "onSubmit", "id", "", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "callerContext", "", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "onPlaceholderSet", "placeholder", "Landroid/graphics/drawable/Drawable;", "onFinalImageSet", "imageOrigin", "", "imageInfo", "drawable", "onIntermediateImageSet", "onIntermediateImageFailed", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onFailure", "error", "onRelease", "onEmptyEvent", "onReset", "resetVitoImageRequestListener", "", "resetLocalVitoImageRequestListener", "resetLocalImagePerfStateListener", "resetControllerListener2", "onImageSet", "image", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "viewportDimensions", "Landroid/graphics/Rect;", "core-common-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CombinedImageListenerImpl implements CombinedImageListener {
    private ControllerListener2<ImageInfo> controllerListener2 = BaseControllerListener2.INSTANCE.getNoOpListener();
    private ImageListener imageListener;
    private ImagePerfLoggingListener imagePerfLoggingListener;
    private ImagePerfNotifier localImagePerfStateListener;
    private VitoImageRequestListener localVitoImageRequestListener;
    private VitoImageRequestListener vitoImageRequestListener;

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public ImageListener getImageListener() {
        return this.imageListener;
    }

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public void setImageListener(ImageListener imageListener) {
        this.imageListener = imageListener;
    }

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public void setVitoImageRequestListener(VitoImageRequestListener vitoImageRequestListener) {
        this.vitoImageRequestListener = vitoImageRequestListener;
    }

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public void setLocalVitoImageRequestListener(VitoImageRequestListener vitoImageRequestListener) {
        this.localVitoImageRequestListener = vitoImageRequestListener;
    }

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public void setControllerListener2(ControllerListener2<ImageInfo> controllerListener2) {
        this.controllerListener2 = controllerListener2;
    }

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public void setImagePerfLoggingListener(ImagePerfLoggingListener imagePerfLoggingListener) {
        this.imagePerfLoggingListener = imagePerfLoggingListener;
        checkAndSetLocalImagePerfStateListener();
    }

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public ImagePerfLoggingListener getImagePerfLoggingListener() {
        return this.imagePerfLoggingListener;
    }

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public void setLocalImagePerfStateListener(ImagePerfNotifier imagePerfNotifier) {
        this.localImagePerfStateListener = imagePerfNotifier;
        checkAndSetLocalImagePerfStateListener();
    }

    private final void checkAndSetLocalImagePerfStateListener() {
        ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
        ImagePerfNotifierHolder imagePerfNotifierHolder = imagePerfLoggingListener instanceof ImagePerfNotifierHolder ? (ImagePerfNotifierHolder) imagePerfLoggingListener : null;
        ImagePerfNotifier imagePerfNotifier = this.localImagePerfStateListener;
        if (imagePerfNotifier != null && imagePerfNotifierHolder == null) {
            throw new NullPointerException("trying to set localImagePerfStateListener without a localPerfStatePublisher");
        }
        if (imagePerfNotifierHolder != null) {
            imagePerfNotifierHolder.setImagePerfNotifier(imagePerfNotifier);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onSubmit(long id, VitoImageRequest imageRequest, Object callerContext, ControllerListener2.Extras extras) {
        long j;
        VitoImageRequest vitoImageRequest;
        Object obj;
        ControllerListener2.Extras extras2;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        VitoImageRequestListener vitoImageRequestListener = this.vitoImageRequestListener;
        if (vitoImageRequestListener != null) {
            vitoImageRequestListener.onSubmit(id, imageRequest, callerContext, extras);
            extras2 = extras;
            obj = callerContext;
            vitoImageRequest = imageRequest;
            j = id;
        } else {
            j = id;
            vitoImageRequest = imageRequest;
            obj = callerContext;
            extras2 = extras;
        }
        VitoImageRequestListener vitoImageRequestListener2 = this.localVitoImageRequestListener;
        if (vitoImageRequestListener2 != null) {
            vitoImageRequestListener2.onSubmit(j, vitoImageRequest, obj, extras2);
        }
        long j2 = j;
        Object obj2 = obj;
        ControllerListener2.Extras extras3 = extras2;
        ImageListener imageListener = getImageListener();
        if (imageListener != null) {
            imageListener.onSubmit(j2, obj2);
        }
        String stringId = VitoUtils.getStringId(j2);
        ControllerListener2<ImageInfo> controllerListener2 = this.controllerListener2;
        if (controllerListener2 != null) {
            controllerListener2.onSubmit(stringId, obj2, extras3);
        }
        ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.onSubmit(stringId, obj2, extras3);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onPlaceholderSet(long id, VitoImageRequest imageRequest, Drawable placeholder) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        VitoImageRequestListener vitoImageRequestListener = this.vitoImageRequestListener;
        if (vitoImageRequestListener != null) {
            vitoImageRequestListener.onPlaceholderSet(id, imageRequest, placeholder);
        }
        VitoImageRequestListener vitoImageRequestListener2 = this.localVitoImageRequestListener;
        if (vitoImageRequestListener2 != null) {
            vitoImageRequestListener2.onPlaceholderSet(id, imageRequest, placeholder);
        }
        ImageListener imageListener = getImageListener();
        if (imageListener != null) {
            imageListener.onPlaceholderSet(id, placeholder);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onFinalImageSet(long id, VitoImageRequest imageRequest, int imageOrigin, ImageInfo imageInfo, ControllerListener2.Extras extras, Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        VitoImageRequestListener vitoImageRequestListener = this.vitoImageRequestListener;
        if (vitoImageRequestListener != null) {
            vitoImageRequestListener.onFinalImageSet(id, imageRequest, imageOrigin, imageInfo, extras, drawable);
        }
        VitoImageRequestListener vitoImageRequestListener2 = this.localVitoImageRequestListener;
        if (vitoImageRequestListener2 != null) {
            vitoImageRequestListener2.onFinalImageSet(id, imageRequest, imageOrigin, imageInfo, extras, drawable);
        }
        ImageListener imageListener = getImageListener();
        if (imageListener != null) {
            imageListener.onFinalImageSet(id, imageOrigin, imageInfo, drawable);
        }
        String stringId = VitoUtils.getStringId(id);
        ControllerListener2<ImageInfo> controllerListener2 = this.controllerListener2;
        if (controllerListener2 != null) {
            controllerListener2.onFinalImageSet(stringId, imageInfo, extras);
        }
        ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.onFinalImageSet(stringId, imageInfo, extras);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onIntermediateImageSet(long id, VitoImageRequest imageRequest, ImageInfo imageInfo) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        VitoImageRequestListener vitoImageRequestListener = this.vitoImageRequestListener;
        if (vitoImageRequestListener != null) {
            vitoImageRequestListener.onIntermediateImageSet(id, imageRequest, imageInfo);
        }
        VitoImageRequestListener vitoImageRequestListener2 = this.localVitoImageRequestListener;
        if (vitoImageRequestListener2 != null) {
            vitoImageRequestListener2.onIntermediateImageSet(id, imageRequest, imageInfo);
        }
        ImageListener imageListener = getImageListener();
        if (imageListener != null) {
            imageListener.onIntermediateImageSet(id, imageInfo);
        }
        String stringId = VitoUtils.getStringId(id);
        ControllerListener2<ImageInfo> controllerListener2 = this.controllerListener2;
        if (controllerListener2 != null) {
            controllerListener2.onIntermediateImageSet(stringId, imageInfo);
        }
        ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.onIntermediateImageSet(stringId, imageInfo);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onIntermediateImageFailed(long id, VitoImageRequest imageRequest, Throwable throwable) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        VitoImageRequestListener vitoImageRequestListener = this.vitoImageRequestListener;
        if (vitoImageRequestListener != null) {
            vitoImageRequestListener.onIntermediateImageFailed(id, imageRequest, throwable);
        }
        VitoImageRequestListener vitoImageRequestListener2 = this.localVitoImageRequestListener;
        if (vitoImageRequestListener2 != null) {
            vitoImageRequestListener2.onIntermediateImageFailed(id, imageRequest, throwable);
        }
        ImageListener imageListener = getImageListener();
        if (imageListener != null) {
            imageListener.onIntermediateImageFailed(id, throwable);
        }
        String stringId = VitoUtils.getStringId(id);
        ControllerListener2<ImageInfo> controllerListener2 = this.controllerListener2;
        if (controllerListener2 != null) {
            controllerListener2.onIntermediateImageFailed(stringId);
        }
        ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.onIntermediateImageFailed(stringId);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onFailure(long id, VitoImageRequest imageRequest, Drawable error, Throwable throwable, ControllerListener2.Extras extras) {
        long j;
        VitoImageRequest vitoImageRequest;
        Drawable drawable;
        Throwable th;
        ControllerListener2.Extras extras2;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        VitoImageRequestListener vitoImageRequestListener = this.vitoImageRequestListener;
        if (vitoImageRequestListener != null) {
            vitoImageRequestListener.onFailure(id, imageRequest, error, throwable, extras);
            extras2 = extras;
            th = throwable;
            drawable = error;
            vitoImageRequest = imageRequest;
            j = id;
        } else {
            j = id;
            vitoImageRequest = imageRequest;
            drawable = error;
            th = throwable;
            extras2 = extras;
        }
        VitoImageRequestListener vitoImageRequestListener2 = this.localVitoImageRequestListener;
        if (vitoImageRequestListener2 != null) {
            vitoImageRequestListener2.onFailure(j, vitoImageRequest, drawable, th, extras2);
        }
        long j2 = j;
        Drawable drawable2 = drawable;
        Throwable th2 = th;
        ControllerListener2.Extras extras3 = extras2;
        ImageListener imageListener = getImageListener();
        if (imageListener != null) {
            imageListener.onFailure(j2, drawable2, th2);
        }
        String stringId = VitoUtils.getStringId(j2);
        ControllerListener2<ImageInfo> controllerListener2 = this.controllerListener2;
        if (controllerListener2 != null) {
            controllerListener2.onFailure(stringId, th2, extras3);
        }
        ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.onFailure(stringId, th2, extras3);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onRelease(long id, VitoImageRequest imageRequest, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        VitoImageRequestListener vitoImageRequestListener = this.vitoImageRequestListener;
        if (vitoImageRequestListener != null) {
            vitoImageRequestListener.onRelease(id, imageRequest, extras);
        }
        VitoImageRequestListener vitoImageRequestListener2 = this.localVitoImageRequestListener;
        if (vitoImageRequestListener2 != null) {
            vitoImageRequestListener2.onRelease(id, imageRequest, extras);
        }
        ImageListener imageListener = getImageListener();
        if (imageListener != null) {
            imageListener.onRelease(id);
        }
        String stringId = VitoUtils.getStringId(id);
        ControllerListener2<ImageInfo> controllerListener2 = this.controllerListener2;
        if (controllerListener2 != null) {
            controllerListener2.onRelease(stringId, extras);
        }
        ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.onRelease(stringId, extras);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onEmptyEvent(Object callerContext) {
        VitoImageRequestListener vitoImageRequestListener = this.vitoImageRequestListener;
        if (vitoImageRequestListener != null) {
            vitoImageRequestListener.onEmptyEvent(callerContext);
        }
        VitoImageRequestListener vitoImageRequestListener2 = this.localVitoImageRequestListener;
        if (vitoImageRequestListener2 != null) {
            vitoImageRequestListener2.onEmptyEvent(callerContext);
        }
        ControllerListener2<ImageInfo> controllerListener2 = this.controllerListener2;
        if (controllerListener2 != null) {
            controllerListener2.onEmptyEvent(callerContext);
        }
        ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.onEmptyEvent(callerContext);
        }
    }

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public void onReset(boolean resetVitoImageRequestListener, boolean resetLocalVitoImageRequestListener, boolean resetLocalImagePerfStateListener, boolean resetControllerListener2) {
        try {
            setImageListener(null);
            ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
            Closeable closeable = imagePerfLoggingListener instanceof Closeable ? (Closeable) imagePerfLoggingListener : null;
            if (closeable != null) {
                closeable.close();
            }
            if (resetVitoImageRequestListener) {
                this.vitoImageRequestListener = null;
            }
            if (resetLocalVitoImageRequestListener) {
                this.localVitoImageRequestListener = null;
            }
            if (resetLocalImagePerfStateListener) {
                this.localImagePerfStateListener = null;
            }
            if (resetControllerListener2) {
                this.controllerListener2 = null;
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.facebook.fresco.vito.core.CombinedImageListener
    public void onImageSet(CloseableReference<CloseableImage> image, Rect viewportDimensions) {
        Intrinsics.checkNotNullParameter(image, "image");
        ImagePerfLoggingListener imagePerfLoggingListener = this.imagePerfLoggingListener;
        if (imagePerfLoggingListener != null) {
            imagePerfLoggingListener.onImageSet(image, viewportDimensions);
        }
    }
}
