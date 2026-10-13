package com.facebook.fresco.vito.core;

import android.net.Uri;
import com.facebook.fresco.vito.options.DecodedImageOptions;
import com.facebook.fresco.vito.options.EncodedImageOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImagePipelineUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/ImagePipelineUtils;", "", "buildImageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "uri", "Landroid/net/Uri;", "imageOptions", "Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "wrapDecodedImageRequest", "originalRequest", "buildEncodedImageRequest", "Lcom/facebook/fresco/vito/options/EncodedImageOptions;", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ImagePipelineUtils {
    ImageRequest buildEncodedImageRequest(Uri uri, EncodedImageOptions imageOptions);

    ImageRequest buildImageRequest(Uri uri, DecodedImageOptions imageOptions);

    ImageRequest wrapDecodedImageRequest(ImageRequest originalRequest, DecodedImageOptions imageOptions);
}
