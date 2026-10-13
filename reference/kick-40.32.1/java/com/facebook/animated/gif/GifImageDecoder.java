package com.facebook.animated.gif;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.ValidationResult;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoderBase;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GifImageDecoder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/facebook/animated/gif/GifImageDecoder;", "Lcom/facebook/imagepipeline/animated/factory/AnimatedImageDecoderBase;", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "isNewRenderImplementation", "", "downscaleFrameToDrawableDimensions", "treatAnimatedImagesAsStateful", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;ZZZ)V", "decode", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "length", "", "qualityInfo", "Lcom/facebook/imagepipeline/image/QualityInfo;", "options", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "Companion", "animated-gif_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GifImageDecoder extends AnimatedImageDecoderBase implements ImageDecoder {
    private static final String TAG = "GifImageDecoder";

    public /* synthetic */ GifImageDecoder(PlatformBitmapFactory platformBitmapFactory, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformBitmapFactory, z, z2, (i & 8) != 0 ? true : z3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifImageDecoder(PlatformBitmapFactory platformBitmapFactory, boolean z, boolean z2, boolean z3) {
        super(platformBitmapFactory, z2, z, z3);
        Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public CloseableImage decode(EncodedImage encodedImage, int length, QualityInfo qualityInfo, ImageDecodeOptions options) {
        GifImage gifImageCreateFromNativeMemory;
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(qualityInfo, "qualityInfo");
        Intrinsics.checkNotNullParameter(options, "options");
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Intrinsics.checkNotNullExpressionValue(byteBufferRef, "getByteBufferRef(...)");
        CloseableReference<PooledByteBuffer> closeableReference = byteBufferRef;
        try {
            ValidationResult validationResultValidateImage = AnimatedImageGifValidator.INSTANCE.validateImage(encodedImage);
            if (!validationResultValidateImage.getIsValid()) {
                FLog.w(TAG, "Image validation failed: " + validationResultValidateImage.getMessage());
                throw new UnsupportedOperationException("Invalid image: " + validationResultValidateImage.getMessage());
            }
            PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            Intrinsics.checkNotNullExpressionValue(pooledByteBuffer, "get(...)");
            PooledByteBuffer pooledByteBuffer2 = pooledByteBuffer;
            ByteBuffer byteBuffer = pooledByteBuffer2.getByteBuffer();
            if (byteBuffer == null || (gifImageCreateFromNativeMemory = GifImage.createFromByteBuffer(byteBuffer, options)) == null) {
                gifImageCreateFromNativeMemory = GifImage.createFromNativeMemory(pooledByteBuffer2.getNativePtr(), pooledByteBuffer2.size(), options);
                Intrinsics.checkNotNullExpressionValue(gifImageCreateFromNativeMemory, "createFromNativeMemory(...)");
            }
            String source = encodedImage.getSource();
            if (gifImageCreateFromNativeMemory == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Bitmap.Config animatedBitmapConfig = options.animatedBitmapConfig;
            Intrinsics.checkNotNullExpressionValue(animatedBitmapConfig, "animatedBitmapConfig");
            CloseableImage closeableImage = getCloseableImage(source, options, gifImageCreateFromNativeMemory, animatedBitmapConfig);
            CloseableKt.closeFinally(closeableReference, null);
            return closeableImage;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(closeableReference, th);
                throw th2;
            }
        }
    }
}
