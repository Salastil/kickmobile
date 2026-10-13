package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.DummyBitmapPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DefaultDecoder implements PlatformDecoder {
    private boolean mAvoidPoolGet;
    private boolean mAvoidPoolRelease;
    private final BitmapPool mBitmapPool;
    private final RawBitmapDecoder mRawBitmapDecoder;

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

    public DefaultDecoder(BitmapPool bitmapPool, Pools.Pool<ByteBuffer> pool, PlatformDecoderOptions platformDecoderOptions, RawBitmapDecoder rawBitmapDecoder) {
        this.mBitmapPool = bitmapPool;
        this.mRawBitmapDecoder = rawBitmapDecoder;
        if (bitmapPool instanceof DummyBitmapPool) {
            this.mAvoidPoolGet = platformDecoderOptions.getAvoidPoolGet();
            this.mAvoidPoolRelease = platformDecoderOptions.getAvoidPoolRelease();
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @Nullable
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @Nullable
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @Nullable
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        Rect rect2;
        ColorSpace colorSpace2;
        boolean z = config != Bitmap.Config.ARGB_8888;
        try {
            rect2 = rect;
            colorSpace2 = colorSpace;
            try {
                return wrapBitmap(this.mRawBitmapDecoder.decode((InputStream) Preconditions.checkNotNull(encodedImage.getInputStream()), this.mAvoidPoolGet ? null : encodedImage.getInputStream(), encodedImage.getSampleSize(), config, rect2, colorSpace2));
            } catch (RuntimeException e) {
                e = e;
                RuntimeException runtimeException = e;
                if (z) {
                    return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect2, colorSpace2);
                }
                throw runtimeException;
            }
        } catch (RuntimeException e2) {
            e = e2;
            rect2 = rect;
            colorSpace2 = colorSpace;
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @Nullable
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace) {
        boolean zIsCompleteAt = encodedImage.isCompleteAt(i);
        boolean z = config != Bitmap.Config.ARGB_8888;
        InputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        try {
            return wrapBitmap(this.mRawBitmapDecoder.decodeJpeg(inputStream, this.mAvoidPoolGet ? null : encodedImage.getInputStream(), encodedImage.getSampleSize(), config, rect, colorSpace, encodedImage.getSize(), i, zIsCompleteAt));
        } catch (RuntimeException e) {
            if (z) {
                return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
            }
            throw e;
        }
    }

    @Nullable
    protected CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        return wrapBitmap(this.mRawBitmapDecoder.decode(inputStream, options, rect, (ColorSpace) null));
    }

    @Nullable
    private CloseableReference<Bitmap> wrapBitmap(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (this.mAvoidPoolRelease) {
            return CloseableReference.of(bitmap, NoOpResourceReleaser.INSTANCE);
        }
        return CloseableReference.of(bitmap, this.mBitmapPool);
    }

    private static final class NoOpResourceReleaser implements ResourceReleaser<Bitmap> {
        private static final NoOpResourceReleaser INSTANCE = new NoOpResourceReleaser();

        @Override // com.facebook.common.references.ResourceReleaser
        public void release(Bitmap bitmap) {
        }

        private NoOpResourceReleaser() {
        }
    }
}
