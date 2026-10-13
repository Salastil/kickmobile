package com.facebook.fresco.vito.draweesupport;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.fresco.vito.listener.ImageListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.infer.annotation.Assertions;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ControllerListenerWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "ControllerListenerWrapper is only supposed to be used for DraweeMigration.")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J,\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010#\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/facebook/fresco/vito/draweesupport/ControllerListenerWrapper;", "Lcom/facebook/fresco/vito/listener/ImageListener;", "controllerListener", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "<init>", "(Lcom/facebook/drawee/controller/ControllerListener;)V", "onSubmit", "", "id", "", "callerContext", "", "onPlaceholderSet", "placeholder", "Landroid/graphics/drawable/Drawable;", "onFinalImageSet", "imageOrigin", "", "imageInfo", "drawable", "onIntermediateImageSet", "onIntermediateImageFailed", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onFailure", "error", "onRelease", "onImageDrawn", "", "dimensionsInfo", "Lcom/facebook/fresco/ui/common/DimensionsInfo;", "equals", "", "other", "hashCode", "Companion", "drawee-support_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ControllerListenerWrapper implements ImageListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ControllerListener<ImageInfo> controllerListener;

    @JvmStatic
    public static final ControllerListenerWrapper create(ControllerListener<ImageInfo> controllerListener) {
        return INSTANCE.create(controllerListener);
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onPlaceholderSet(long id, Drawable placeholder) {
    }

    public ControllerListenerWrapper(ControllerListener<ImageInfo> controllerListener) {
        Intrinsics.checkNotNullParameter(controllerListener, "controllerListener");
        this.controllerListener = controllerListener;
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onSubmit(long id, Object callerContext) {
        this.controllerListener.onSubmit(INSTANCE.toStringId(id), Assertions.nullsafeFIXME(callerContext, "Legacy ControllerListener is not nullsafe"));
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onFinalImageSet(long id, int imageOrigin, ImageInfo imageInfo, Drawable drawable) {
        ControllerListener<ImageInfo> controllerListener = this.controllerListener;
        String stringId = INSTANCE.toStringId(id);
        boolean z = drawable instanceof Animatable;
        Object obj = drawable;
        if (!z) {
            obj = null;
        }
        controllerListener.onFinalImageSet(stringId, imageInfo, (Animatable) obj);
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onIntermediateImageSet(long id, ImageInfo imageInfo) {
        this.controllerListener.onIntermediateImageSet(INSTANCE.toStringId(id), imageInfo);
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onIntermediateImageFailed(long id, Throwable throwable) {
        this.controllerListener.onIntermediateImageFailed(INSTANCE.toStringId(id), (Throwable) Assertions.nullsafeFIXME(throwable, "Legacy ControllerListener is not nullsafe"));
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onFailure(long id, Drawable error, Throwable throwable) {
        this.controllerListener.onFailure(INSTANCE.toStringId(id), (Throwable) Assertions.nullsafeFIXME(throwable, "Legacy ControllerListener is not nullsafe"));
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onRelease(long id) {
        this.controllerListener.onRelease(INSTANCE.toStringId(id));
    }

    @Override // com.facebook.fresco.ui.common.OnDrawControllerListener
    public void onImageDrawn(String id, ImageInfo imageInfo, DimensionsInfo dimensionsInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        Intrinsics.checkNotNullParameter(dimensionsInfo, "dimensionsInfo");
        ControllerListener<ImageInfo> controllerListener = this.controllerListener;
        OnDrawControllerListener onDrawControllerListener = controllerListener instanceof OnDrawControllerListener ? (OnDrawControllerListener) controllerListener : null;
        if (onDrawControllerListener != null) {
            onDrawControllerListener.onImageDrawn(id, imageInfo, dimensionsInfo);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.facebook.fresco.vito.draweesupport.ControllerListenerWrapper");
        return Intrinsics.areEqual(this.controllerListener, ((ControllerListenerWrapper) other).controllerListener);
    }

    public int hashCode() {
        return this.controllerListener.hashCode();
    }

    /* JADX INFO: compiled from: ControllerListenerWrapper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/facebook/fresco/vito/draweesupport/ControllerListenerWrapper$Companion;", "", "<init>", "()V", "create", "Lcom/facebook/fresco/vito/draweesupport/ControllerListenerWrapper;", "controllerListener", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "toStringId", "", "id", "", "drawee-support_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ControllerListenerWrapper create(ControllerListener<ImageInfo> controllerListener) {
            if (controllerListener != null) {
                return new ControllerListenerWrapper(controllerListener);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String toStringId(long id) {
            return "v" + id;
        }
    }
}
