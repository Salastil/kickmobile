package com.facebook.fresco.vito.core.impl;

import android.net.Uri;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.fresco.vito.core.FrescoVitoPrefetcher;
import com.facebook.fresco.vito.core.ImagePipelineUtils;
import com.facebook.fresco.vito.core.PrefetchTarget;
import com.facebook.fresco.vito.core.VitoImageRequest;
import com.facebook.fresco.vito.options.DecodedImageOptions;
import com.facebook.fresco.vito.options.EncodedImageOptions;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.source.DrawableResImageSource;
import com.facebook.fresco.vito.source.ImageSource;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import io.ktor.http.LinkHeader;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrescoVitoPrefetcherImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ<\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J:\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016JF\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J4\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J>\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J4\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J>\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J4\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J>\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J<\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016JF\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016JL\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/FrescoVitoPrefetcherImpl;", "Lcom/facebook/fresco/vito/core/FrescoVitoPrefetcher;", "imagePipeline", "Lcom/facebook/imagepipeline/core/ImagePipeline;", "imagePipelineUtils", "Lcom/facebook/fresco/vito/core/ImagePipelineUtils;", "callerContextVerifier", "Lcom/facebook/callercontext/CallerContextVerifier;", "<init>", "(Lcom/facebook/imagepipeline/core/ImagePipeline;Lcom/facebook/fresco/vito/core/ImagePipelineUtils;Lcom/facebook/callercontext/CallerContextVerifier;)V", LinkHeader.Rel.Prefetch, "Lcom/facebook/datasource/DataSource;", "Ljava/lang/Void;", "prefetchTarget", "Lcom/facebook/fresco/vito/core/PrefetchTarget;", "uri", "Landroid/net/Uri;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "callerContext", "", "callsite", "", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "prefetchToBitmapCache", "Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "prefetchToEncodedCache", "Lcom/facebook/fresco/vito/options/EncodedImageOptions;", "prefetchToDiskCache", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "requestListener", "Lcom/facebook/imagepipeline/listener/RequestListener;", "extras", "", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrescoVitoPrefetcherImpl implements FrescoVitoPrefetcher {
    private static final Throwable NULL_IMAGE_MESSAGE = new NullPointerException("No image to prefetch.");
    private final CallerContextVerifier callerContextVerifier;
    private final ImagePipeline imagePipeline;
    private final ImagePipelineUtils imagePipelineUtils;

    /* JADX INFO: compiled from: FrescoVitoPrefetcherImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrefetchTarget.values().length];
            try {
                iArr[PrefetchTarget.MEMORY_DECODED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrefetchTarget.MEMORY_ENCODED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrefetchTarget.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FrescoVitoPrefetcherImpl(ImagePipeline imagePipeline, ImagePipelineUtils imagePipelineUtils, CallerContextVerifier callerContextVerifier) {
        Intrinsics.checkNotNullParameter(imagePipeline, "imagePipeline");
        Intrinsics.checkNotNullParameter(imagePipelineUtils, "imagePipelineUtils");
        this.imagePipeline = imagePipeline;
        this.imagePipelineUtils = imagePipelineUtils;
        this.callerContextVerifier = callerContextVerifier;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetch(PrefetchTarget prefetchTarget, Uri uri, ImageOptions imageOptions, Object callerContext, String callsite) {
        Intrinsics.checkNotNullParameter(prefetchTarget, "prefetchTarget");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        int i = WhenMappings.$EnumSwitchMapping$0[prefetchTarget.ordinal()];
        if (i == 1) {
            return prefetchToBitmapCache(uri, imageOptions, callerContext, callsite);
        }
        if (i == 2) {
            return prefetchToEncodedCache(uri, imageOptions, callerContext, callsite);
        }
        if (i == 3) {
            return prefetchToDiskCache(uri, imageOptions, callerContext, callsite);
        }
        DataSource<Void> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new CancellationException("Prefetching is not enabled"));
        Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
        return dataSourceImmediateFailedDataSource;
    }

    public final DataSource<Void> prefetch(PrefetchTarget prefetchTarget, ImageRequest imageRequest, ImageOptions imageOptions, Object callerContext, String callsite) {
        Intrinsics.checkNotNullParameter(prefetchTarget, "prefetchTarget");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        int i = WhenMappings.$EnumSwitchMapping$0[prefetchTarget.ordinal()];
        if (i == 1) {
            return prefetch(PrefetchTarget.MEMORY_DECODED, imageRequest, (Map<String, ? extends Object>) null, callerContext, (RequestListener) null);
        }
        if (i == 2) {
            return prefetch(PrefetchTarget.MEMORY_ENCODED, imageRequest, (Map<String, ? extends Object>) null, callerContext, (RequestListener) null);
        }
        if (i == 3) {
            return prefetch(PrefetchTarget.DISK, imageRequest, (Map<String, ? extends Object>) null, callerContext, (RequestListener) null);
        }
        DataSource<Void> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new CancellationException("Prefetching is not enabled"));
        Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
        return dataSourceImmediateFailedDataSource;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetch(PrefetchTarget prefetchTarget, Uri uri, ImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite) {
        Intrinsics.checkNotNullParameter(prefetchTarget, "prefetchTarget");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return prefetch(prefetchTarget, uri, imageOptions, callerContext, callsite);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToBitmapCache(Uri uri, DecodedImageOptions imageOptions, Object callerContext, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        ImagePipelineUtils imagePipelineUtils = this.imagePipelineUtils;
        if (imageOptions == null) {
            imageOptions = ImageOptions.INSTANCE.defaults();
        }
        return prefetch(PrefetchTarget.MEMORY_DECODED, imagePipelineUtils.buildImageRequest(uri, imageOptions), (Map<String, ? extends Object>) null, callerContext, (RequestListener) null);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToBitmapCache(Uri uri, DecodedImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return prefetchToBitmapCache(uri, imageOptions, callerContext, callsite);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToEncodedCache(Uri uri, EncodedImageOptions imageOptions, Object callerContext, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        ImagePipelineUtils imagePipelineUtils = this.imagePipelineUtils;
        if (imageOptions == null) {
            imageOptions = ImageOptions.INSTANCE.defaults();
        }
        return prefetch(PrefetchTarget.MEMORY_ENCODED, imagePipelineUtils.buildEncodedImageRequest(uri, imageOptions), (Map<String, ? extends Object>) null, callerContext, (RequestListener) null);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToEncodedCache(Uri uri, EncodedImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return prefetchToEncodedCache(uri, imageOptions, callerContext, callsite);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToDiskCache(Uri uri, ImageOptions imageOptions, Object callerContext, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        ImagePipelineUtils imagePipelineUtils = this.imagePipelineUtils;
        if (imageOptions == null) {
            imageOptions = ImageOptions.INSTANCE.defaults();
        }
        return prefetch(PrefetchTarget.DISK, imagePipelineUtils.buildEncodedImageRequest(uri, imageOptions), (Map<String, ? extends Object>) null, callerContext, (RequestListener) null);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetchToDiskCache(Uri uri, ImageOptions imageOptions, Object callerContext, ContextChain contextChain, String callsite) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return prefetchToDiskCache(uri, imageOptions, callerContext, callsite);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetch(PrefetchTarget prefetchTarget, VitoImageRequest imageRequest, Object callerContext, RequestListener requestListener, String callsite) {
        Intrinsics.checkNotNullParameter(prefetchTarget, "prefetchTarget");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        if (imageRequest.imageSource instanceof DrawableResImageSource) {
            ImageSource imageSource = imageRequest.imageSource;
            Intrinsics.checkNotNull(imageSource, "null cannot be cast to non-null type com.facebook.fresco.vito.source.DrawableResImageSource");
            ((DrawableResImageSource) imageSource).prefetch(imageRequest.resources);
            DataSource<Void> dataSourceImmediateSuccessfulDataSource = DataSources.immediateSuccessfulDataSource();
            Intrinsics.checkNotNull(dataSourceImmediateSuccessfulDataSource);
            return dataSourceImmediateSuccessfulDataSource;
        }
        return prefetch(prefetchTarget, imageRequest.finalImageRequest, imageRequest.extras, callerContext, requestListener);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoPrefetcher
    public DataSource<Void> prefetch(PrefetchTarget prefetchTarget, VitoImageRequest imageRequest, Object callerContext, ContextChain contextChain, RequestListener requestListener, String callsite) {
        Intrinsics.checkNotNullParameter(prefetchTarget, "prefetchTarget");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(callsite, "callsite");
        return prefetch(prefetchTarget, imageRequest, callerContext, requestListener, callsite);
    }

    private final DataSource<Void> prefetch(PrefetchTarget prefetchTarget, ImageRequest imageRequest, Map<String, ? extends Object> extras, Object callerContext, RequestListener requestListener) {
        CallerContextVerifier callerContextVerifier = this.callerContextVerifier;
        if (callerContextVerifier != null) {
            callerContextVerifier.verifyCallerContext(callerContext, false);
        }
        if (imageRequest == null) {
            DataSource<Void> dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(NULL_IMAGE_MESSAGE);
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource);
            return dataSourceImmediateFailedDataSource;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[prefetchTarget.ordinal()];
        if (i == 1) {
            return ImagePipeline.prefetchToBitmapCache$default(this.imagePipeline, imageRequest, callerContext, requestListener, extras, null, 16, null);
        }
        if (i == 2) {
            return ImagePipeline.prefetchToEncodedCache$default(this.imagePipeline, imageRequest, callerContext, null, requestListener, extras, 4, null);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return this.imagePipeline.prefetchToDiskCache(imageRequest, callerContext, Priority.MEDIUM, requestListener, extras);
    }
}
