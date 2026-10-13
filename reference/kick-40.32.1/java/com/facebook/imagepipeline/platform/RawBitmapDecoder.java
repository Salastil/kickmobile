package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RawBitmapDecoder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J@\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016JX\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/platform/RawBitmapDecoder;", "", "decode", "Landroid/graphics/Bitmap;", "data", "", "offset", "", "length", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "sampleSize", "colorSpace", "Landroid/graphics/ColorSpace;", "stream", "Ljava/io/InputStream;", "inputStream", "options", "Landroid/graphics/BitmapFactory$Options;", "regionToDecode", "Landroid/graphics/Rect;", "decodeStream", "prePassStream", "handlesJpegEoiAppendNatively", "", "decodeJpeg", "jpegStream", "encodedImageSize", "isJpegComplete", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RawBitmapDecoder {
    Bitmap decode(byte[] data, int offset, int length, Bitmap.Config bitmapConfig, int sampleSize, ColorSpace colorSpace);

    default boolean handlesJpegEoiAppendNatively() {
        return false;
    }

    /* JADX INFO: compiled from: RawBitmapDecoder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Bitmap decode(RawBitmapDecoder rawBitmapDecoder, InputStream stream, Bitmap.Config bitmapConfig, int i, ColorSpace colorSpace) {
            Intrinsics.checkNotNullParameter(stream, "stream");
            Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
            return RawBitmapDecoder.super.decode(stream, bitmapConfig, i, colorSpace);
        }

        @Deprecated
        public static Bitmap decode(RawBitmapDecoder rawBitmapDecoder, InputStream inputStream, BitmapFactory.Options options, Rect rect, ColorSpace colorSpace) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Intrinsics.checkNotNullParameter(options, "options");
            return RawBitmapDecoder.super.decode(inputStream, options, rect, colorSpace);
        }

        @Deprecated
        public static Bitmap decode(RawBitmapDecoder rawBitmapDecoder, InputStream decodeStream, InputStream inputStream, int i, Bitmap.Config bitmapConfig, Rect rect, ColorSpace colorSpace) {
            Intrinsics.checkNotNullParameter(decodeStream, "decodeStream");
            Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
            return RawBitmapDecoder.super.decode(decodeStream, inputStream, i, bitmapConfig, rect, colorSpace);
        }

        @Deprecated
        public static boolean handlesJpegEoiAppendNatively(RawBitmapDecoder rawBitmapDecoder) {
            return RawBitmapDecoder.super.handlesJpegEoiAppendNatively();
        }

        @Deprecated
        public static Bitmap decodeJpeg(RawBitmapDecoder rawBitmapDecoder, InputStream jpegStream, InputStream inputStream, int i, Bitmap.Config bitmapConfig, Rect rect, ColorSpace colorSpace, int i2, int i3, boolean z) {
            Intrinsics.checkNotNullParameter(jpegStream, "jpegStream");
            Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
            return RawBitmapDecoder.super.decodeJpeg(jpegStream, inputStream, i, bitmapConfig, rect, colorSpace, i2, i3, z);
        }
    }

    static /* synthetic */ Bitmap decode$default(RawBitmapDecoder rawBitmapDecoder, byte[] bArr, int i, int i2, Bitmap.Config config, int i3, ColorSpace colorSpace, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i4 & 32) != 0) {
            colorSpace = null;
        }
        return rawBitmapDecoder.decode(bArr, i, i2, config, i3, colorSpace);
    }

    static /* synthetic */ Bitmap decode$default(RawBitmapDecoder rawBitmapDecoder, InputStream inputStream, Bitmap.Config config, int i, ColorSpace colorSpace, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i2 & 8) != 0) {
            colorSpace = null;
        }
        return rawBitmapDecoder.decode(inputStream, config, i, colorSpace);
    }

    default Bitmap decode(InputStream stream, Bitmap.Config bitmapConfig, int sampleSize, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sampleSize;
        options.inPreferredConfig = bitmapConfig;
        return decode(stream, options, (Rect) null, colorSpace);
    }

    default Bitmap decode(InputStream inputStream, BitmapFactory.Options options, Rect regionToDecode, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(options, "options");
        Bitmap.Config config = options.inPreferredConfig;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return decode(inputStream, config, options.inSampleSize, colorSpace);
    }

    default Bitmap decode(InputStream decodeStream, InputStream prePassStream, int sampleSize, Bitmap.Config bitmapConfig, Rect regionToDecode, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(decodeStream, "decodeStream");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        return decode(decodeStream, bitmapConfig, sampleSize, colorSpace);
    }

    default Bitmap decodeJpeg(InputStream jpegStream, InputStream prePassStream, int sampleSize, Bitmap.Config bitmapConfig, Rect regionToDecode, ColorSpace colorSpace, int encodedImageSize, int length, boolean isJpegComplete) {
        Intrinsics.checkNotNullParameter(jpegStream, "jpegStream");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        return decode(jpegStream, bitmapConfig, sampleSize, colorSpace);
    }
}
