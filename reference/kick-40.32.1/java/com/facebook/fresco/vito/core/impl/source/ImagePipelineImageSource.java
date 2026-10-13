package com.facebook.fresco.vito.core.impl.source;

import com.facebook.fresco.vito.core.ImagePipelineUtils;
import com.facebook.fresco.vito.options.ImageOptions;
import com.facebook.fresco.vito.source.UriImageSource;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImagePipelineImageSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/source/ImagePipelineImageSource;", "Lcom/facebook/fresco/vito/source/UriImageSource;", "maybeExtractFinalImageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "imagePipelineUtils", "Lcom/facebook/fresco/vito/core/ImagePipelineUtils;", "imageOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "getRequestLevelForFetch", "Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;", "getClassNameString", "", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ImagePipelineImageSource extends UriImageSource {
    ImageRequest maybeExtractFinalImageRequest(ImagePipelineUtils imagePipelineUtils, ImageOptions imageOptions);

    /* JADX INFO: compiled from: ImagePipelineImageSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static ImageRequest.RequestLevel getRequestLevelForFetch(ImagePipelineImageSource imagePipelineImageSource) {
            return ImagePipelineImageSource.super.getRequestLevelForFetch();
        }

        @Deprecated
        public static String getClassNameString(ImagePipelineImageSource imagePipelineImageSource) {
            return ImagePipelineImageSource.super.getClassNameString();
        }
    }

    default ImageRequest.RequestLevel getRequestLevelForFetch() {
        return ImageRequest.RequestLevel.FULL_FETCH;
    }

    @Override // com.facebook.fresco.vito.source.UriImageSource, com.facebook.fresco.vito.source.ImageSource
    default String getClassNameString() {
        return "ImagePipelineImageSource";
    }
}
