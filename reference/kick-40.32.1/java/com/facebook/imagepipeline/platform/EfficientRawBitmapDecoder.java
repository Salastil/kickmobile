package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.DecodeBufferHelper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EfficientRawBitmapDecoder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ<\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J<\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/imagepipeline/platform/EfficientRawBitmapDecoder;", "Lcom/facebook/imagepipeline/platform/RawBitmapDecoder;", "decodeBuffers", "Landroidx/core/util/Pools$Pool;", "Ljava/nio/ByteBuffer;", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "<init>", "(Landroidx/core/util/Pools$Pool;Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;)V", "decode", "Landroid/graphics/Bitmap;", "data", "", "offset", "", "length", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "sampleSize", "colorSpace", "Landroid/graphics/ColorSpace;", "decodeInternal", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EfficientRawBitmapDecoder implements RawBitmapDecoder {
    private static final String TAG = "EfficientRawBitmapDecoder";
    private final Pools.Pool<ByteBuffer> decodeBuffers;
    private final PlatformDecoderOptions platformDecoderOptions;

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decode(InputStream inputStream, Bitmap.Config config, int i, ColorSpace colorSpace) {
        return super.decode(inputStream, config, i, colorSpace);
    }

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decode(InputStream inputStream, BitmapFactory.Options options, Rect rect, ColorSpace colorSpace) {
        return super.decode(inputStream, options, rect, colorSpace);
    }

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decode(InputStream inputStream, InputStream inputStream2, int i, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        return super.decode(inputStream, inputStream2, i, config, rect, colorSpace);
    }

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decodeJpeg(InputStream inputStream, InputStream inputStream2, int i, Bitmap.Config config, Rect rect, ColorSpace colorSpace, int i2, int i3, boolean z) {
        return super.decodeJpeg(inputStream, inputStream2, i, config, rect, colorSpace, i2, i3, z);
    }

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public boolean handlesJpegEoiAppendNatively() {
        return super.handlesJpegEoiAppendNatively();
    }

    public EfficientRawBitmapDecoder(Pools.Pool<ByteBuffer> decodeBuffers, PlatformDecoderOptions platformDecoderOptions) {
        Intrinsics.checkNotNullParameter(decodeBuffers, "decodeBuffers");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        this.decodeBuffers = decodeBuffers;
        this.platformDecoderOptions = platformDecoderOptions;
    }

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decode(byte[] data, int offset, int length, Bitmap.Config bitmapConfig, int sampleSize, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        if (!DecodeValidationUtils.INSTANCE.validateInput(data, offset, length) || !DecodeValidationUtils.INSTANCE.isValidImageHeader(data, offset, length)) {
            return null;
        }
        boolean z = bitmapConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeInternal(data, offset, length, bitmapConfig, sampleSize, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeInternal(data, offset, length, Bitmap.Config.ARGB_8888, sampleSize, colorSpace);
            }
            throw e;
        }
    }

    private final Bitmap decodeInternal(byte[] data, int offset, int length, Bitmap.Config bitmapConfig, final int sampleSize, final ColorSpace colorSpace) {
        if (!this.platformDecoderOptions.getUseBitmapFactoryDecoder() && Build.VERSION.SDK_INT >= 28 && (Build.VERSION.SDK_INT >= 33 || colorSpace == null)) {
            try {
                return ImageDecoder.decodeBitmap(ImageDecoder.createSource(ByteBuffer.wrap(data, offset, length)), new ImageDecoder$OnHeaderDecodedListener() { // from class: com.facebook.imagepipeline.platform.EfficientRawBitmapDecoder$$ExternalSyntheticLambda2
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        EfficientRawBitmapDecoder.decodeInternal$lambda$0(this.f$0, sampleSize, colorSpace, imageDecoder, imageInfo, source);
                    }
                });
            } catch (IOException unused) {
                return null;
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sampleSize;
        options.inPreferredConfig = bitmapConfig;
        if (!this.platformDecoderOptions.getDecodeImmutableBitmaps()) {
            options.inMutable = true;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                Intrinsics.checkNotNullExpressionValue(colorSpace, "get(...)");
            }
            options.inPreferredColorSpace = colorSpace;
        }
        ByteBuffer byteBufferAcquire = this.decodeBuffers.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
        }
        try {
            try {
                options.inTempStorage = byteBufferAcquire.array();
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(data, offset, length, options);
                Pools.Pool<ByteBuffer> pool = this.decodeBuffers;
                Intrinsics.checkNotNull(byteBufferAcquire);
                pool.release(byteBufferAcquire);
                return bitmapDecodeByteArray;
            } catch (Error e) {
                if (this.platformDecoderOptions.getCatchNativeDecoderErrors()) {
                    FLog.e(TAG, "Native decoder error", e);
                    PlatformDecoderOptions.DecoderErrorReporter errorReporter = this.platformDecoderOptions.getErrorReporter();
                    if (errorReporter != null) {
                        errorReporter.reportError("NATIVE_DECODER_ERROR", "Native decoder error", e);
                    }
                    Pools.Pool<ByteBuffer> pool2 = this.decodeBuffers;
                    Intrinsics.checkNotNull(byteBufferAcquire);
                    pool2.release(byteBufferAcquire);
                    return null;
                }
                throw e;
            }
        } catch (Throwable th) {
            Pools.Pool<ByteBuffer> pool3 = this.decodeBuffers;
            Intrinsics.checkNotNull(byteBufferAcquire);
            pool3.release(byteBufferAcquire);
            throw th;
        }
    }

    static final void decodeInternal$lambda$0(EfficientRawBitmapDecoder efficientRawBitmapDecoder, int i, ColorSpace colorSpace, ImageDecoder decoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(imageInfo, "<unused var>");
        Intrinsics.checkNotNullParameter(source, "<unused var>");
        decoder.setAllocator(1);
        decoder.setMutableRequired(!efficientRawBitmapDecoder.platformDecoderOptions.getDecodeImmutableBitmaps());
        decoder.setTargetSampleSize(i);
        if (Build.VERSION.SDK_INT < 33 || colorSpace == null) {
            return;
        }
        decoder.setTargetColorSpace(colorSpace);
    }
}
