package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimatedImageDecoder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/animated/factory/AnimatedImageDecoder;", "", "decodeFromNativeMemory", "Lcom/facebook/imagepipeline/animated/base/AnimatedImage;", "nativePtr", "", "sizeInBytes", "", "options", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "decodeFromByteBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "animated-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AnimatedImageDecoder {
    AnimatedImage decodeFromByteBuffer(ByteBuffer byteBuffer, ImageDecodeOptions options);

    AnimatedImage decodeFromNativeMemory(long nativePtr, int sizeInBytes, ImageDecodeOptions options);
}
