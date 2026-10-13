package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import com.facebook.imagepipeline.transformation.CircularTransformation;
import com.facebook.imagepipeline.transformation.TransformationUtils;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultImageDecoder implements ImageDecoder {

    @Nullable
    private final Map<ImageFormat, ImageDecoder> mCustomDecoders;
    private final ImageDecoder mDefaultDecoder;

    @Nullable
    private final BitmapTransformation mDefaultIntermediateTransformation;
    private final Supplier<Boolean> mEnableEncodedImageColorSpaceUsage;
    private final PlatformDecoder mPlatformDecoder;

    @Nullable
    private final ImageDecoder mXmlDecoder;

    public DefaultImageDecoder(@Nullable ImageDecoder imageDecoder, PlatformDecoder platformDecoder) {
        this(imageDecoder, platformDecoder, null);
    }

    public DefaultImageDecoder(@Nullable ImageDecoder imageDecoder, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map) {
        this(imageDecoder, platformDecoder, map, Suppliers.BOOLEAN_FALSE);
    }

    public DefaultImageDecoder(@Nullable ImageDecoder imageDecoder, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map, @Nullable BitmapTransformation bitmapTransformation) {
        this(imageDecoder, platformDecoder, map, Suppliers.BOOLEAN_FALSE, bitmapTransformation);
    }

    public DefaultImageDecoder(@Nullable ImageDecoder imageDecoder, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map, Supplier<Boolean> supplier) {
        this(imageDecoder, platformDecoder, map, supplier, null);
    }

    public DefaultImageDecoder(@Nullable ImageDecoder imageDecoder, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map, Supplier<Boolean> supplier, @Nullable BitmapTransformation bitmapTransformation) {
        this.mDefaultDecoder = new ImageDecoder() { // from class: com.facebook.imagepipeline.decoder.DefaultImageDecoder.1
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            @Nullable
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                ImageFormat imageFormat = encodedImage.getImageFormat();
                ColorSpace colorSpace = (((Boolean) DefaultImageDecoder.this.mEnableEncodedImageColorSpaceUsage.get()).booleanValue() && imageDecodeOptions.colorSpace == null) ? encodedImage.getColorSpace() : imageDecodeOptions.colorSpace;
                if (imageFormat == DefaultImageFormats.JPEG) {
                    return DefaultImageDecoder.this.decodeJpeg(encodedImage, i, qualityInfo, imageDecodeOptions, colorSpace);
                }
                if (imageFormat == DefaultImageFormats.GIF || imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                    return DefaultImageDecoder.this.decodeAnimatedFormat(encodedImage, i, qualityInfo, imageDecodeOptions, imageFormat);
                }
                if (imageFormat == DefaultImageFormats.BINARY_XML) {
                    return DefaultImageDecoder.this.decodeXml(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == ImageFormat.UNKNOWN) {
                    throw new DecodeException("unknown image format", encodedImage);
                }
                return DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
            }
        };
        this.mXmlDecoder = imageDecoder;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
        this.mEnableEncodedImageColorSpaceUsage = supplier;
        this.mDefaultIntermediateTransformation = bitmapTransformation;
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    @Nullable
    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InputStream inputStream;
        ImageDecoder imageDecoder;
        if (imageDecodeOptions.customImageDecoder != null) {
            return imageDecodeOptions.customImageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        ImageFormat imageFormat = encodedImage.getImageFormat();
        if ((imageFormat == null || imageFormat == ImageFormat.UNKNOWN) && (inputStream = encodedImage.getInputStream()) != null) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(inputStream);
            encodedImage.setImageFormat(imageFormat);
        }
        Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
        if (map != null && (imageDecoder = map.get(imageFormat)) != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public CloseableImage decodeAnimatedFormat(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions, ImageFormat imageFormat) {
        if (encodedImage.getWidth() == -1 || encodedImage.getHeight() == -1) {
            throw new DecodeException(imageFormat.getName() + " image width or height is incorrect", encodedImage);
        }
        Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
        if (map != null) {
            ImageDecoder imageDecoder = map.get(imageFormat);
            if (!imageDecodeOptions.forceStaticImage && imageDecoder != null) {
                return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
        }
        return decodeStaticImage(encodedImage, imageDecodeOptions);
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> closeableReferenceDecodeFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, imageDecodeOptions.colorSpace);
        try {
            boolean zMaybeApplyTransformation = TransformationUtils.maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, closeableReferenceDecodeFromEncodedImageWithColorSpace);
            Preconditions.checkNotNull(closeableReferenceDecodeFromEncodedImageWithColorSpace);
            CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(closeableReferenceDecodeFromEncodedImageWithColorSpace, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            closeableStaticBitmapOf.putExtra("is_rounded", Boolean.valueOf(zMaybeApplyTransformation && (imageDecodeOptions.bitmapTransformation instanceof CircularTransformation)));
            return closeableStaticBitmapOf;
        } finally {
            CloseableReference.closeSafely(closeableReferenceDecodeFromEncodedImageWithColorSpace);
        }
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions, @Nullable ColorSpace colorSpace) {
        BitmapTransformation bitmapTransformation;
        CloseableReference<Bitmap> closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, i, colorSpace);
        try {
            boolean zMaybeApplyTransformation = TransformationUtils.maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
            if (!qualityInfo.isOfFullQuality()) {
                if (imageDecodeOptions.intermediateImageBitmapTransformation != null) {
                    bitmapTransformation = imageDecodeOptions.intermediateImageBitmapTransformation;
                } else {
                    bitmapTransformation = this.mDefaultIntermediateTransformation;
                }
                TransformationUtils.maybeApplyTransformation(bitmapTransformation, closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace, qualityInfo);
            }
            Preconditions.checkNotNull(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
            CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            closeableStaticBitmapOf.putExtra("is_rounded", Boolean.valueOf(zMaybeApplyTransformation && (imageDecodeOptions.bitmapTransformation instanceof CircularTransformation)));
            return closeableStaticBitmapOf;
        } finally {
            CloseableReference.closeSafely(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public CloseableImage decodeXml(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder = this.mXmlDecoder;
        if (imageDecoder != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return null;
    }
}
