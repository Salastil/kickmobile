package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EfficientPlatformDecoder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J2\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J4\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J<\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J<\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/imagepipeline/platform/EfficientPlatformDecoder;", "Lcom/facebook/imagepipeline/platform/PlatformDecoder;", "rawBitmapDecoder", "Lcom/facebook/imagepipeline/platform/RawBitmapDecoder;", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "<init>", "(Lcom/facebook/imagepipeline/platform/RawBitmapDecoder;Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;)V", "decodeFromEncodedImage", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "regionToDecode", "Landroid/graphics/Rect;", "decodeJPEGFromEncodedImage", "length", "", "decodeFromEncodedImageWithColorSpace", "colorSpace", "Landroid/graphics/ColorSpace;", "decodeJPEGFromEncodedImageWithColorSpace", "decodeWithRetry", "bytes", "", "offset", "sampleSize", "extractBytes", "NoOpResourceReleaser", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EfficientPlatformDecoder implements PlatformDecoder {
    private static final byte[] EOI_TAIL = {-1, -39};
    private final PlatformDecoderOptions platformDecoderOptions;
    private final RawBitmapDecoder rawBitmapDecoder;

    public EfficientPlatformDecoder(RawBitmapDecoder rawBitmapDecoder, PlatformDecoderOptions platformDecoderOptions) {
        Intrinsics.checkNotNullParameter(rawBitmapDecoder, "rawBitmapDecoder");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        this.rawBitmapDecoder = rawBitmapDecoder;
        this.platformDecoderOptions = platformDecoderOptions;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config bitmapConfig, Rect regionToDecode) {
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        return decodeFromEncodedImageWithColorSpace(encodedImage, bitmapConfig, regionToDecode, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config bitmapConfig, Rect regionToDecode, int length) {
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, bitmapConfig, regionToDecode, length, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config bitmapConfig, Rect regionToDecode, ColorSpace colorSpace) {
        byte[] bArrExtractBytes;
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        if (!DecodeValidationUtils.INSTANCE.validateDimensions(encodedImage, this.platformDecoderOptions)) {
            return null;
        }
        int sampleSize = encodedImage.getSampleSize();
        synchronized (encodedImage) {
            bArrExtractBytes = extractBytes(encodedImage);
            Unit unit = Unit.INSTANCE;
        }
        Bitmap bitmapDecodeWithRetry = decodeWithRetry(bArrExtractBytes, 0, bArrExtractBytes.length, bitmapConfig, sampleSize, colorSpace);
        if (bitmapDecodeWithRetry == null) {
            return null;
        }
        return CloseableReference.of(bitmapDecodeWithRetry, NoOpResourceReleaser.INSTANCE);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config bitmapConfig, Rect regionToDecode, int length, ColorSpace colorSpace) {
        boolean zIsCompleteAt;
        int iMin;
        byte[] bArr;
        int i;
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        if (!DecodeValidationUtils.INSTANCE.validateDimensions(encodedImage, this.platformDecoderOptions)) {
            return null;
        }
        int sampleSize = encodedImage.getSampleSize();
        synchronized (encodedImage) {
            zIsCompleteAt = encodedImage.isCompleteAt(length);
            iMin = Math.min(encodedImage.getSize(), length);
            Unit unit = Unit.INSTANCE;
        }
        if (iMin <= 0) {
            return null;
        }
        if (!zIsCompleteAt) {
            int length2 = EOI_TAIL.length + iMin;
            bArr = new byte[length2];
            i = length2;
        } else {
            bArr = new byte[iMin];
            i = iMin;
        }
        synchronized (encodedImage) {
            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
            Intrinsics.checkNotNullExpressionValue(byteBufferRef, "getByteBufferRef(...)");
            if (byteBufferRef != null) {
                try {
                    int i2 = byteBufferRef.get().read(0, bArr, 0, iMin);
                    byteBufferRef.close();
                    Integer.valueOf(i2);
                } catch (Throwable th) {
                    byteBufferRef.close();
                    throw th;
                }
            } else {
                InputStream inputStream = encodedImage.getInputStream();
                if (inputStream == null) {
                    return null;
                }
                int i3 = 0;
                while (i3 < iMin) {
                    int i4 = inputStream.read(bArr, i3, iMin - i3);
                    if (i4 <= 0) {
                        break;
                    }
                    i3 += i4;
                }
                Unit unit2 = Unit.INSTANCE;
            }
            if (!zIsCompleteAt) {
                byte[] bArr2 = EOI_TAIL;
                System.arraycopy(bArr2, 0, bArr, iMin, bArr2.length);
            }
            Bitmap bitmapDecodeWithRetry = decodeWithRetry(bArr, 0, i, bitmapConfig, sampleSize, colorSpace);
            if (bitmapDecodeWithRetry == null) {
                return null;
            }
            return CloseableReference.of(bitmapDecodeWithRetry, NoOpResourceReleaser.INSTANCE);
        }
    }

    private final Bitmap decodeWithRetry(byte[] bytes, int offset, int length, Bitmap.Config bitmapConfig, int sampleSize, ColorSpace colorSpace) {
        byte[] bArr;
        int i;
        int i2;
        int i3;
        ColorSpace colorSpace2;
        try {
            bArr = bytes;
            i2 = length;
            i3 = sampleSize;
            try {
                return this.rawBitmapDecoder.decode(bArr, offset, i2, bitmapConfig, i3, colorSpace);
            } catch (RuntimeException e) {
                e = e;
                i = offset;
                colorSpace2 = colorSpace;
                RuntimeException runtimeException = e;
                if (bitmapConfig != Bitmap.Config.ARGB_8888) {
                    return this.rawBitmapDecoder.decode(bArr, i, i2, Bitmap.Config.ARGB_8888, i3, colorSpace2);
                }
                throw runtimeException;
            }
        } catch (RuntimeException e2) {
            e = e2;
            bArr = bytes;
            i = offset;
            i2 = length;
            i3 = sampleSize;
            colorSpace2 = colorSpace;
        }
    }

    private final byte[] extractBytes(EncodedImage encodedImage) {
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Intrinsics.checkNotNullExpressionValue(byteBufferRef, "getByteBufferRef(...)");
        try {
            PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            Intrinsics.checkNotNullExpressionValue(pooledByteBuffer, "get(...)");
            PooledByteBuffer pooledByteBuffer2 = pooledByteBuffer;
            byte[] bArr = new byte[pooledByteBuffer2.size()];
            pooledByteBuffer2.read(0, bArr, 0, pooledByteBuffer2.size());
            return bArr;
        } finally {
            byteBufferRef.close();
        }
    }

    /* JADX INFO: compiled from: EfficientPlatformDecoder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/platform/EfficientPlatformDecoder$NoOpResourceReleaser;", "Lcom/facebook/common/references/ResourceReleaser;", "Landroid/graphics/Bitmap;", "<init>", "()V", "release", "", "value", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class NoOpResourceReleaser implements ResourceReleaser<Bitmap> {
        public static final NoOpResourceReleaser INSTANCE = new NoOpResourceReleaser();

        @Override // com.facebook.common.references.ResourceReleaser
        public void release(Bitmap value) {
            Intrinsics.checkNotNullParameter(value, "value");
        }

        private NoOpResourceReleaser() {
        }
    }
}
