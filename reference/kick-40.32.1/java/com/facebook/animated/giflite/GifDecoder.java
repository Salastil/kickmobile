package com.facebook.animated.giflite;

import android.graphics.Movie;
import com.facebook.animated.giflite.decoder.GifMetadataDecoder;
import com.facebook.animated.giflite.draw.MovieAnimatedImage;
import com.facebook.animated.giflite.draw.MovieDrawer;
import com.facebook.animated.giflite.draw.MovieFrame;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class GifDecoder implements ImageDecoder {
    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InputStream inputStream = encodedImage.getInputStream();
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GifMetadataDecoder gifMetadataDecoderCreate = GifMetadataDecoder.create(inputStream, byteArrayOutputStream);
                if (byteArrayOutputStream.size() > 0) {
                    ((InputStream) Preconditions.checkNotNull(inputStream, "InputStream cannot be null")).close();
                    inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
                ((InputStream) Preconditions.checkNotNull(inputStream, "InputStream cannot be null")).reset();
                Movie movieDecodeStream = Movie.decodeStream(inputStream);
                MovieDrawer movieDrawer = new MovieDrawer(movieDecodeStream);
                int frameCount = gifMetadataDecoderCreate.getFrameCount();
                MovieFrame[] movieFrameArr = new MovieFrame[frameCount];
                int i2 = 0;
                int i3 = 0;
                while (i3 < frameCount) {
                    int frameDurationMs = gifMetadataDecoderCreate.getFrameDurationMs(i3);
                    int i4 = i2 + frameDurationMs;
                    movieFrameArr[i3] = new MovieFrame(movieDrawer, i4, frameDurationMs, movieDecodeStream.width(), movieDecodeStream.height(), translateFrameDisposal(gifMetadataDecoderCreate.getFrameDisposal(i3)));
                    i3++;
                    i2 = i4;
                }
                CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(AnimatedImageResult.forAnimatedImage(new MovieAnimatedImage(movieFrameArr, encodedImage.getSize(), movieDecodeStream.duration(), gifMetadataDecoderCreate.getLoopCount(), imageDecodeOptions.animatedBitmapConfig)), false);
                try {
                    ((InputStream) Preconditions.checkNotNull(inputStream, "InputStream cannot be null")).close();
                } catch (IOException unused) {
                }
                return closeableAnimatedImage;
            } catch (Throwable th) {
                try {
                    ((InputStream) Preconditions.checkNotNull(inputStream, "InputStream cannot be null")).close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while decoding gif", e);
        }
    }

    private static AnimatedDrawableFrameInfo.DisposalMethod translateFrameDisposal(int i) {
        if (i == 2) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
        }
        if (i == 3) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }
}
