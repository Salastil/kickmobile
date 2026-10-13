package com.facebook.fresco.vito.listener;

import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseImageListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¨\u0006\u001e"}, d2 = {"Lcom/facebook/fresco/vito/listener/BaseImageListener;", "Lcom/facebook/fresco/vito/listener/ImageListener;", "<init>", "()V", "onSubmit", "", "id", "", "callerContext", "", "onPlaceholderSet", "placeholder", "Landroid/graphics/drawable/Drawable;", "onFinalImageSet", "imageOrigin", "", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "drawable", "onIntermediateImageSet", "onIntermediateImageFailed", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onFailure", "error", "onRelease", "onImageDrawn", "", "dimensionsInfo", "Lcom/facebook/fresco/ui/common/DimensionsInfo;", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class BaseImageListener implements ImageListener {
    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onFailure(long id, Drawable error, Throwable throwable) {
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onFinalImageSet(long id, int imageOrigin, ImageInfo imageInfo, Drawable drawable) {
    }

    @Override // com.facebook.fresco.ui.common.OnDrawControllerListener
    public void onImageDrawn(String id, ImageInfo imageInfo, DimensionsInfo dimensionsInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        Intrinsics.checkNotNullParameter(dimensionsInfo, "dimensionsInfo");
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onIntermediateImageFailed(long id, Throwable throwable) {
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onIntermediateImageSet(long id, ImageInfo imageInfo) {
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onPlaceholderSet(long id, Drawable placeholder) {
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onRelease(long id) {
    }

    @Override // com.facebook.fresco.vito.listener.ImageListener
    public void onSubmit(long id, Object callerContext) {
    }
}
