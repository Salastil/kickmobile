package com.facebook.animated.gif;

import com.facebook.animated.giflite.decoder.GifMetadataDecoder;
import com.facebook.imagepipeline.animated.base.AnimatedImageValidator;
import com.facebook.imagepipeline.animated.base.ValidationResult;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedImageGifValidator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/facebook/animated/gif/AnimatedImageGifValidator;", "Lcom/facebook/imagepipeline/animated/base/AnimatedImageValidator;", "<init>", "()V", "validateImage", "Lcom/facebook/imagepipeline/animated/base/ValidationResult;", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "animated-gif_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnimatedImageGifValidator implements AnimatedImageValidator {
    public static final AnimatedImageGifValidator INSTANCE = new AnimatedImageGifValidator();

    private AnimatedImageGifValidator() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImageValidator
    public ValidationResult validateImage(EncodedImage encodedImage) {
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        InputStream inputStream = encodedImage.getInputStream();
        if (inputStream == null) {
            return new ValidationResult.Failure("No input stream available");
        }
        try {
            InputStream inputStream2 = inputStream;
            try {
                GifMetadataDecoder gifMetadataDecoderCreate = GifMetadataDecoder.create(inputStream2, null);
                Intrinsics.checkNotNullExpressionValue(gifMetadataDecoderCreate, "create(...)");
                int screenWidth = gifMetadataDecoderCreate.getScreenWidth();
                int screenHeight = gifMetadataDecoderCreate.getScreenHeight();
                if (screenWidth <= 0 || screenHeight <= 0) {
                    ValidationResult.Failure failure = new ValidationResult.Failure("GIF invalid logical screen size: " + screenWidth + " x " + screenHeight);
                    CloseableKt.closeFinally(inputStream2, null);
                    return failure;
                }
                int frameCount = screenWidth * screenHeight * gifMetadataDecoderCreate.getFrameCount();
                if (frameCount > 100000000) {
                    ValidationResult.Failure failure2 = new ValidationResult.Failure("GIF too large: " + screenWidth + " x " + screenHeight + " x " + gifMetadataDecoderCreate.getFrameCount() + " frames = " + frameCount + " pixels");
                    CloseableKt.closeFinally(inputStream2, null);
                    return failure2;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStream2, null);
                return ValidationResult.Success.INSTANCE;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream2, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            return new ValidationResult.Failure("Error parsing GIF: " + e.getMessage());
        }
    }
}
