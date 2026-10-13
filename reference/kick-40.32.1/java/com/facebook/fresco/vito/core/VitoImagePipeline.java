package com.facebook.fresco.vito.core;

import android.content.res.Resources;
import android.graphics.Rect;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.fresco.urimod.ClassicFetchStrategy;
import com.facebook.fresco.urimod.Dimensions;
import com.facebook.fresco.urimod.FetchStrategy;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.source.ImageSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VitoImagePipeline.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\\\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0003H&JD\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00182\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0003H&J'\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u001e\u0010%\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0010\u0010'\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J&\u0010(\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006*À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "", "createImageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_RESOURCES_KEY, "Landroid/content/res/Resources;", "imageSource", "Lcom/facebook/fresco/vito/source/ImageSource;", "options", "Lcom/facebook/fresco/vito/options/ImageOptions;", "logWithHighSamplingRate", "", "viewport", "Landroid/graphics/Rect;", "callerContext", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "fetchStrategy", "Lcom/facebook/fresco/urimod/FetchStrategy;", "getCachedImage", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "imageRequest", "fetchDecodedImage", "Lcom/facebook/datasource/DataSource;", "requestListener", "Lcom/facebook/imagepipeline/listener/RequestListener;", "uiComponentId", "", "Lcom/facebook/fresco/urimod/Dimensions;", "isInDiskCacheSync", InstrumentationTags.TIMEOUT, "unit", "Ljava/util/concurrent/TimeUnit;", "(Lcom/facebook/fresco/vito/core/VitoImageRequest;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Boolean;", "evictFromCaches", "", "returnImageToCache", "imageReference", "hintUnmodifiedUri", "determineFetchStrategy", "requestBeforeLayout", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface VitoImagePipeline {
    VitoImageRequest createImageRequest(Resources resources, ImageSource imageSource, ImageOptions options, boolean logWithHighSamplingRate, Rect viewport, Object callerContext, ContextChain contextChain, FetchStrategy fetchStrategy);

    DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(VitoImageRequest imageRequest, Object callerContext, RequestListener requestListener, long uiComponentId, Dimensions viewport);

    CloseableReference<CloseableImage> getCachedImage(VitoImageRequest imageRequest);

    default void hintUnmodifiedUri(VitoImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
    }

    boolean isInDiskCacheSync(VitoImageRequest imageRequest);

    default void returnImageToCache(VitoImageRequest imageRequest, CloseableReference<CloseableImage> imageReference) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(imageReference, "imageReference");
    }

    /* JADX INFO: compiled from: VitoImagePipeline.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Boolean isInDiskCacheSync(VitoImagePipeline vitoImagePipeline, VitoImageRequest imageRequest, long j, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
            Intrinsics.checkNotNullParameter(unit, "unit");
            return VitoImagePipeline.super.isInDiskCacheSync(imageRequest, j, unit);
        }

        @Deprecated
        public static void evictFromCaches(VitoImagePipeline vitoImagePipeline, VitoImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
            VitoImagePipeline.super.evictFromCaches(imageRequest);
        }

        @Deprecated
        public static void returnImageToCache(VitoImagePipeline vitoImagePipeline, VitoImageRequest imageRequest, CloseableReference<CloseableImage> imageReference) {
            Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
            Intrinsics.checkNotNullParameter(imageReference, "imageReference");
            VitoImagePipeline.super.returnImageToCache(imageRequest, imageReference);
        }

        @Deprecated
        public static void hintUnmodifiedUri(VitoImagePipeline vitoImagePipeline, VitoImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
            VitoImagePipeline.super.hintUnmodifiedUri(imageRequest);
        }

        @Deprecated
        public static FetchStrategy determineFetchStrategy(VitoImagePipeline vitoImagePipeline, VitoImageRequest vitoImageRequest, Object obj, ContextChain contextChain) {
            return VitoImagePipeline.super.determineFetchStrategy(vitoImageRequest, obj, contextChain);
        }
    }

    static /* synthetic */ VitoImageRequest createImageRequest$default(VitoImagePipeline vitoImagePipeline, Resources resources, ImageSource imageSource, ImageOptions imageOptions, boolean z, Rect rect, Object obj, ContextChain contextChain, FetchStrategy fetchStrategy, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createImageRequest");
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return vitoImagePipeline.createImageRequest(resources, imageSource, imageOptions, z, (i & 16) != 0 ? null : rect, (i & 32) != 0 ? null : obj, (i & 64) != 0 ? null : contextChain, (i & 128) != 0 ? null : fetchStrategy);
    }

    static /* synthetic */ DataSource fetchDecodedImage$default(VitoImagePipeline vitoImagePipeline, VitoImageRequest vitoImageRequest, Object obj, RequestListener requestListener, long j, Dimensions dimensions, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchDecodedImage");
        }
        if ((i & 16) != 0) {
            dimensions = null;
        }
        return vitoImagePipeline.fetchDecodedImage(vitoImageRequest, obj, requestListener, j, dimensions);
    }

    default Boolean isInDiskCacheSync(VitoImageRequest imageRequest, long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(unit, "unit");
        throw new UnsupportedOperationException("Not implemented yet");
    }

    default void evictFromCaches(VitoImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        throw new UnsupportedOperationException("Method not implemented: evictFromCaches");
    }

    default FetchStrategy determineFetchStrategy(VitoImageRequest requestBeforeLayout, Object callerContext, ContextChain contextChain) {
        return ClassicFetchStrategy.DEFAULT;
    }
}
