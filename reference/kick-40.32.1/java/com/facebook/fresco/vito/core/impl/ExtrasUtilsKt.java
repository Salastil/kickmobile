package com.facebook.fresco.vito.core.impl;

import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.middleware.MiddlewareUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtrasUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"COMPONENT_EXTRAS", "", "", "", "SHORTCUT_EXTRAS", "obtainExtras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", "dataSource", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "image", "imageExtras", "core-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ExtrasUtilsKt {
    private static final Map<String, Object> COMPONENT_EXTRAS = MapsKt.mapOf(TuplesKt.to("component_tag", "vito2"));
    private static final Map<String, Object> SHORTCUT_EXTRAS = MapsKt.mapOf(TuplesKt.to("origin", "memory_bitmap"), TuplesKt.to("origin_sub", "shortcut"));

    public static /* synthetic */ ControllerListener2.Extras obtainExtras$default(KFrescoVitoDrawable kFrescoVitoDrawable, DataSource dataSource, CloseableReference closeableReference, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            dataSource = null;
        }
        if ((i & 2) != 0) {
            closeableReference = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        return obtainExtras(kFrescoVitoDrawable, dataSource, closeableReference, map);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ControllerListener2.Extras obtainExtras(KFrescoVitoDrawable kFrescoVitoDrawable, DataSource<CloseableReference<CloseableImage>> dataSource, CloseableReference<CloseableImage> closeableReference, Map<String, ? extends Object> map) {
        ImageRequest imageRequest;
        Map<String, ? extends Object> extras;
        ImageOptions imageOptions;
        ImageOptions imageOptions2;
        Intrinsics.checkNotNullParameter(kFrescoVitoDrawable, "<this>");
        Map<String, Object> map2 = COMPONENT_EXTRAS;
        Map<String, Object> map3 = SHORTCUT_EXTRAS;
        Uri sourceUri = null;
        Map<String, Object> extras2 = dataSource != null ? dataSource.getExtras() : null;
        Rect viewportDimensions = kFrescoVitoDrawable.getViewportDimensions();
        VitoImageRequest imageRequest2 = kFrescoVitoDrawable.getImageRequest();
        ScalingUtils.ScaleType actualImageScaleType = (imageRequest2 == null || (imageOptions2 = imageRequest2.imageOptions) == null) ? null : imageOptions2.getActualImageScaleType();
        VitoImageRequest imageRequest3 = kFrescoVitoDrawable.getImageRequest();
        PointF actualImageFocusPoint = (imageRequest3 == null || (imageOptions = imageRequest3.imageOptions) == null) ? null : imageOptions.getActualImageFocusPoint();
        if (map == null) {
            if (closeableReference != null) {
                try {
                    CloseableImage closeableImage = closeableReference.get();
                    if (closeableImage != 0) {
                        extras = closeableImage.getExtras();
                    } else {
                        extras = null;
                    }
                } catch (IllegalStateException unused) {
                    map = null;
                }
            } else {
                extras = null;
            }
            map = extras;
        }
        Map<String, ? extends Object> map4 = map;
        Object callerContext = kFrescoVitoDrawable.getCallerContext();
        VitoImageRequest imageRequest4 = kFrescoVitoDrawable.getImageRequest();
        boolean z = imageRequest4 != null ? imageRequest4.logWithHighSamplingRate : false;
        VitoImageRequest imageRequest5 = kFrescoVitoDrawable.getImageRequest();
        if (imageRequest5 != null && (imageRequest = imageRequest5.finalImageRequest) != null) {
            sourceUri = imageRequest.getSourceUri();
        }
        return MiddlewareUtils.obtainExtras(map2, map3, extras2, null, viewportDimensions, actualImageScaleType, actualImageFocusPoint, map4, callerContext, z, sourceUri);
    }
}
