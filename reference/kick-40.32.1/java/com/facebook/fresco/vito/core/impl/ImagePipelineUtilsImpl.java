package com.facebook.fresco.vito.core.impl;

import android.net.Uri;
import com.facebook.fresco.vito.core.ImagePipelineUtils;
import com.facebook.fresco.vito.options.DecodedImageOptions;
import com.facebook.fresco.vito.options.EncodedImageOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.DownsampleMode;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePipelineUtilsImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0003\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000fH\u0004J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000fH\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl;", "Lcom/facebook/fresco/vito/core/ImagePipelineUtils;", "imageDecodeOptionsProvider", "Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl$ImageDecodeOptionsProvider;", "<init>", "(Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl$ImageDecodeOptionsProvider;)V", "buildImageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "uri", "Landroid/net/Uri;", "imageOptions", "Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "wrapDecodedImageRequest", "originalRequest", "buildEncodedImageRequest", "Lcom/facebook/fresco/vito/options/EncodedImageOptions;", "createDecodedImageRequestBuilder", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "imageRequestBuilder", "createEncodedImageRequestBuilder", "imageRequest", "CircularBitmapRounding", "ImageDecodeOptionsProvider", "Companion", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImagePipelineUtilsImpl implements ImagePipelineUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ImageDecodeOptionsProvider imageDecodeOptionsProvider;

    /* JADX INFO: compiled from: ImagePipelineUtilsImpl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl$CircularBitmapRounding;", "", "getDecodeOptions", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "antiAliased", "", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface CircularBitmapRounding {
        ImageDecodeOptions getDecodeOptions(boolean antiAliased);
    }

    /* JADX INFO: compiled from: ImagePipelineUtilsImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl$ImageDecodeOptionsProvider;", "", "create", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "imageRequestBuilder", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "imageOptions", "Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ImageDecodeOptionsProvider {
        ImageDecodeOptions create(ImageRequestBuilder imageRequestBuilder, DecodedImageOptions imageOptions);
    }

    public ImagePipelineUtilsImpl(ImageDecodeOptionsProvider imageDecodeOptionsProvider) {
        Intrinsics.checkNotNullParameter(imageDecodeOptionsProvider, "imageDecodeOptionsProvider");
        this.imageDecodeOptionsProvider = imageDecodeOptionsProvider;
    }

    @Override // com.facebook.fresco.vito.core.ImagePipelineUtils
    public ImageRequest buildImageRequest(Uri uri, DecodedImageOptions imageOptions) {
        ImageRequestBuilder imageRequestBuilderCreateDecodedImageRequestBuilder;
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (uri == null || (imageRequestBuilderCreateDecodedImageRequestBuilder = createDecodedImageRequestBuilder(createEncodedImageRequestBuilder(uri, imageOptions), imageOptions)) == null) {
            return null;
        }
        return imageRequestBuilderCreateDecodedImageRequestBuilder.build();
    }

    @Override // com.facebook.fresco.vito.core.ImagePipelineUtils
    public ImageRequest wrapDecodedImageRequest(ImageRequest originalRequest, DecodedImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        ImageRequestBuilder imageRequestBuilderCreateDecodedImageRequestBuilder = createDecodedImageRequestBuilder(createEncodedImageRequestBuilder(originalRequest, imageOptions), imageOptions);
        if (imageRequestBuilderCreateDecodedImageRequestBuilder != null) {
            return imageRequestBuilderCreateDecodedImageRequestBuilder.build();
        }
        return null;
    }

    @Override // com.facebook.fresco.vito.core.ImagePipelineUtils
    public ImageRequest buildEncodedImageRequest(Uri uri, EncodedImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        ImageRequestBuilder imageRequestBuilderCreateEncodedImageRequestBuilder = createEncodedImageRequestBuilder(uri, imageOptions);
        if (imageRequestBuilderCreateEncodedImageRequestBuilder != null) {
            return imageRequestBuilderCreateEncodedImageRequestBuilder.build();
        }
        return null;
    }

    protected final ImageRequestBuilder createDecodedImageRequestBuilder(ImageRequestBuilder imageRequestBuilder, DecodedImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (imageRequestBuilder == null) {
            return null;
        }
        ResizeOptions resizeOptions = imageOptions.getResizeOptions();
        if (resizeOptions != null) {
            imageRequestBuilder.setResizeOptions(resizeOptions);
        }
        DownsampleMode downsampleOverride = imageOptions.getDownsampleOverride();
        if (downsampleOverride != null) {
            imageRequestBuilder.setDownsampleOverride(downsampleOverride);
        }
        RotationOptions rotationOptions = imageOptions.getRotationOptions();
        if (rotationOptions != null) {
            imageRequestBuilder.setRotationOptions(rotationOptions);
        }
        ImageDecodeOptions imageDecodeOptionsCreate = this.imageDecodeOptionsProvider.create(imageRequestBuilder, imageOptions);
        if (imageDecodeOptionsCreate != null) {
            if (imageOptions.getIntermediateImageBitmapTransformation() != null) {
                imageDecodeOptionsCreate = ImageDecodeOptions.newBuilder().setFrom(imageDecodeOptionsCreate).setIntermediateImageBitmapTransformation(imageOptions.getIntermediateImageBitmapTransformation()).build();
            }
            imageRequestBuilder.setImageDecodeOptions(imageDecodeOptionsCreate);
        } else if (imageOptions.getIntermediateImageBitmapTransformation() != null) {
            imageRequestBuilder.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setIntermediateImageBitmapTransformation(imageOptions.getIntermediateImageBitmapTransformation()).build());
        }
        imageRequestBuilder.setLocalThumbnailPreviewsEnabled(imageOptions.getLocalThumbnailPreviewsEnabled());
        imageRequestBuilder.setLoadThumbnailOnly(imageOptions.getLoadThumbnailOnly());
        Postprocessor postprocessor = imageOptions.getPostprocessor();
        if (postprocessor != null) {
            imageRequestBuilder.setPostprocessor(postprocessor);
        }
        Boolean isProgressiveDecodingEnabled = imageOptions.getIsProgressiveDecodingEnabled();
        if (isProgressiveDecodingEnabled != null) {
            imageRequestBuilder.setProgressiveRenderingEnabled(isProgressiveDecodingEnabled.booleanValue());
        }
        imageRequestBuilder.setIsFirstFrameThumbnailEnabled(Boolean.valueOf(imageOptions.getIsFirstFrameThumbnailEnabled()));
        return imageRequestBuilder;
    }

    protected final ImageRequestBuilder createEncodedImageRequestBuilder(Uri uri, EncodedImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (uri == null) {
            return null;
        }
        ImageRequestBuilder imageRequestBuilderNewBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(uri);
        Companion companion = INSTANCE;
        Intrinsics.checkNotNull(imageRequestBuilderNewBuilderWithSource);
        companion.maybeSetRequestPriority(imageRequestBuilderNewBuilderWithSource, imageOptions.getPriority());
        if (imageOptions.getCacheChoice() != null) {
            imageRequestBuilderNewBuilderWithSource.setCacheChoice(imageOptions.getCacheChoice());
        }
        if (imageOptions.getDiskCacheId() != null) {
            imageRequestBuilderNewBuilderWithSource.setDiskCacheId(imageOptions.getDiskCacheId());
        }
        return imageRequestBuilderNewBuilderWithSource;
    }

    protected final ImageRequestBuilder createEncodedImageRequestBuilder(ImageRequest imageRequest, EncodedImageOptions imageOptions) {
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        if (imageRequest == null) {
            return null;
        }
        ImageRequestBuilder imageRequestBuilderFromRequest = ImageRequestBuilder.fromRequest(imageRequest);
        Companion companion = INSTANCE;
        Intrinsics.checkNotNull(imageRequestBuilderFromRequest);
        companion.maybeSetRequestPriority(imageRequestBuilderFromRequest, imageOptions.getPriority());
        return imageRequestBuilderFromRequest;
    }

    /* JADX INFO: compiled from: ImagePipelineUtilsImpl.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\n"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImagePipelineUtilsImpl$Companion;", "", "<init>", "()V", "maybeSetRequestPriority", "", "builder", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "priority", "Lcom/facebook/imagepipeline/common/Priority;", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void maybeSetRequestPriority(ImageRequestBuilder builder, Priority priority) {
            if (priority != null) {
                builder.setRequestPriority(priority);
            }
        }
    }
}
