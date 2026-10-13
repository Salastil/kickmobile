package com.facebook.fresco.vito.core;

import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseVitoImageRequestListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J>\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J6\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u001f"}, d2 = {"Lcom/facebook/fresco/vito/core/BaseVitoImageRequestListener;", "Lcom/facebook/fresco/vito/core/VitoImageRequestListener;", "<init>", "()V", "onSubmit", "", "id", "", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "callerContext", "", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "onPlaceholderSet", "placeholder", "Landroid/graphics/drawable/Drawable;", "onFinalImageSet", "imageOrigin", "", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "drawable", "onIntermediateImageSet", "onIntermediateImageFailed", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onFailure", "error", "onRelease", "onEmptyEvent", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class BaseVitoImageRequestListener implements VitoImageRequestListener {
    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onEmptyEvent(Object callerContext) {
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onFailure(long id, VitoImageRequest imageRequest, Drawable error, Throwable throwable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onFinalImageSet(long id, VitoImageRequest imageRequest, int imageOrigin, ImageInfo imageInfo, ControllerListener2.Extras extras, Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onIntermediateImageFailed(long id, VitoImageRequest imageRequest, Throwable throwable) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onIntermediateImageSet(long id, VitoImageRequest imageRequest, ImageInfo imageInfo) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onPlaceholderSet(long id, VitoImageRequest imageRequest, Drawable placeholder) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onRelease(long id, VitoImageRequest imageRequest, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
    }

    @Override // com.facebook.fresco.vito.core.VitoImageRequestListener
    public void onSubmit(long id, VitoImageRequest imageRequest, Object callerContext, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
    }
}
