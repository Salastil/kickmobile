package com.facebook.fresco.vito.core;

import android.graphics.drawable.Drawable;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;

/* JADX INFO: compiled from: VitoImageRequestListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH&J>\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH&J\"\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J6\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\"\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/VitoImageRequestListener;", "", "onSubmit", "", "id", "", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "callerContext", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "onPlaceholderSet", "placeholder", "Landroid/graphics/drawable/Drawable;", "onFinalImageSet", "imageOrigin", "", "imageInfo", "Lcom/facebook/imagepipeline/image/ImageInfo;", "drawable", "onIntermediateImageSet", "onIntermediateImageFailed", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onFailure", "error", "onRelease", "onEmptyEvent", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface VitoImageRequestListener {
    void onEmptyEvent(Object callerContext);

    void onFailure(long id, VitoImageRequest imageRequest, Drawable error, Throwable throwable, ControllerListener2.Extras extras);

    void onFinalImageSet(long id, VitoImageRequest imageRequest, int imageOrigin, ImageInfo imageInfo, ControllerListener2.Extras extras, Drawable drawable);

    void onIntermediateImageFailed(long id, VitoImageRequest imageRequest, Throwable throwable);

    void onIntermediateImageSet(long id, VitoImageRequest imageRequest, ImageInfo imageInfo);

    void onPlaceholderSet(long id, VitoImageRequest imageRequest, Drawable placeholder);

    void onRelease(long id, VitoImageRequest imageRequest, ControllerListener2.Extras extras);

    void onSubmit(long id, VitoImageRequest imageRequest, Object callerContext, ControllerListener2.Extras extras);
}
