package com.facebook.fresco.vito.listener;

import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForwardingImageListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u001f\u0012\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J,\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010$\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006&"}, d2 = {"Lcom/facebook/fresco/vito/listener/ForwardingImageListener;", "Lcom/facebook/fresco/vito/listener/ImageListener;", "listeners", "", "<init>", "([Lcom/facebook/fresco/vito/listener/ImageListener;)V", "[Lcom/facebook/fresco/vito/listener/ImageListener;", "onSubmit", "", "id", "", "callerContext", "", "onPlaceholderSet", "placeholder", "Landroid/graphics/drawable/Drawable;", "onFinalImageSet", "imageOrigin", "", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "drawable", "onIntermediateImageSet", "onIntermediateImageFailed", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onFailure", "error", "onRelease", "onImageDrawn", "", "dimensionsInfo", "Lcom/facebook/fresco/ui/common/DimensionsInfo;", "equals", "", "other", "hashCode", "Companion", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForwardingImageListener implements ImageListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ImageListener[] listeners;

    @JvmStatic
    public static final ImageListener create(ImageListener imageListener, ImageListener imageListener2) {
        return INSTANCE.create(imageListener, imageListener2);
    }

    @JvmStatic
    public static final ImageListener create(ImageListener imageListener, ImageListener imageListener2, ImageListener imageListener3) {
        return INSTANCE.create(imageListener, imageListener2, imageListener3);
    }

    public ForwardingImageListener(ImageListener... listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.listeners = listeners;
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onSubmit(long id, Object callerContext) {
        for (ImageListener imageListener : this.listeners) {
            if (imageListener != null) {
                imageListener.onSubmit(id, callerContext);
            }
        }
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onPlaceholderSet(long id, Drawable placeholder) {
        for (ImageListener imageListener : this.listeners) {
            if (imageListener != null) {
                imageListener.onPlaceholderSet(id, placeholder);
            }
        }
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onFinalImageSet(long id, int imageOrigin, ImageInfo imageInfo, Drawable drawable) {
        ImageListener[] imageListenerArr = this.listeners;
        int length = imageListenerArr.length;
        int i = 0;
        while (i < length) {
            ImageListener imageListener = imageListenerArr[i];
            long j = id;
            int i2 = imageOrigin;
            ImageInfo imageInfo2 = imageInfo;
            Drawable drawable2 = drawable;
            if (imageListener != null) {
                imageListener.onFinalImageSet(j, i2, imageInfo2, drawable2);
            }
            i++;
            id = j;
            imageOrigin = i2;
            imageInfo = imageInfo2;
            drawable = drawable2;
        }
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onIntermediateImageSet(long id, ImageInfo imageInfo) {
        for (ImageListener imageListener : this.listeners) {
            if (imageListener != null) {
                imageListener.onIntermediateImageSet(id, imageInfo);
            }
        }
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onIntermediateImageFailed(long id, Throwable throwable) {
        for (ImageListener imageListener : this.listeners) {
            if (imageListener != null) {
                imageListener.onIntermediateImageFailed(id, throwable);
            }
        }
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onFailure(long id, Drawable error, Throwable throwable) {
        for (ImageListener imageListener : this.listeners) {
            if (imageListener != null) {
                imageListener.onFailure(id, error, throwable);
            }
        }
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onRelease(long id) {
        for (ImageListener imageListener : this.listeners) {
            if (imageListener != null) {
                imageListener.onRelease(id);
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.OnDrawControllerListener
    public void onImageDrawn(String id, ImageInfo imageInfo, DimensionsInfo dimensionsInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        Intrinsics.checkNotNullParameter(dimensionsInfo, "dimensionsInfo");
        for (ImageListener imageListener : this.listeners) {
            if (imageListener != null) {
                imageListener.onImageDrawn(id, imageInfo, dimensionsInfo);
            }
        }
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ForwardingImageListener)) {
            return false;
        }
        ImageListener[] imageListenerArr = ((ForwardingImageListener) other).listeners;
        ImageListener[] imageListenerArr2 = this.listeners;
        if (imageListenerArr2.length != imageListenerArr.length) {
            return false;
        }
        int length = imageListenerArr2.length;
        for (int i = 0; i < length; i++) {
            if (!Intrinsics.areEqual(this.listeners[i], imageListenerArr[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        ImageListener imageListener = this.listeners[0];
        int iHashCode = (imageListener == null || imageListener == null) ? 0 : imageListener.hashCode();
        int length = this.listeners.length;
        for (int i = 1; i < length; i++) {
            int i2 = iHashCode * 31;
            ImageListener imageListener2 = this.listeners[i];
            iHashCode = i2 + ((imageListener2 == null || imageListener2 == null) ? 0 : imageListener2.hashCode());
        }
        return iHashCode;
    }

    /* JADX INFO: compiled from: ForwardingImageListener.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/fresco/vito/listener/ForwardingImageListener$Companion;", "", "<init>", "()V", "create", "Lcom/facebook/fresco/vito/listener/ImageListener;", "a", "b", "c", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ImageListener create(ImageListener a2, ImageListener b) {
            if (a2 == null) {
                return b;
            }
            return b != null ? new ForwardingImageListener(a2, b) : a2;
        }

        @JvmStatic
        public final ImageListener create(ImageListener a2, ImageListener b, ImageListener c) {
            if (a2 == null) {
                return create(b, c);
            }
            if (b == null) {
                return create(a2, c);
            }
            return c != null ? new ForwardingImageListener(a2, b, c) : create(a2, b);
        }
    }
}
