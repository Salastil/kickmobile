package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.DecodeBufferHelper;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: DefaultRawBitmapDecoder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,BM\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\"\b\u0002\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ<\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J<\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J,\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J@\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J.\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010%\u001a\u00020&H\u0016JX\u0010'\u001a\u0004\u0018\u00010\u00122\u0006\u0010(\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020&H\u0016J\"\u0010+\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/facebook/imagepipeline/platform/DefaultRawBitmapDecoder;", "Lcom/facebook/imagepipeline/platform/RawBitmapDecoder;", "decodeBuffers", "Landroidx/core/util/Pools$Pool;", "Ljava/nio/ByteBuffer;", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "bitmapPool", "Lcom/facebook/imagepipeline/memory/BitmapPool;", "bitmapSizeCalculator", "Lkotlin/Function3;", "", "Landroid/graphics/BitmapFactory$Options;", "<init>", "(Landroidx/core/util/Pools$Pool;Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;Lcom/facebook/imagepipeline/memory/BitmapPool;Lkotlin/jvm/functions/Function3;)V", "preverificationHelper", "Lcom/facebook/imagepipeline/platform/PreverificationHelper;", "decode", "Landroid/graphics/Bitmap;", "data", "", "offset", "length", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "sampleSize", "colorSpace", "Landroid/graphics/ColorSpace;", "decodeByteArray", "stream", "Ljava/io/InputStream;", "decodeStream", "prePassStream", "regionToDecode", "Landroid/graphics/Rect;", "inputStream", "options", "handlesJpegEoiAppendNatively", "", "decodeJpeg", "jpegStream", "encodedImageSize", "isJpegComplete", "buildDecodeOptions", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultRawBitmapDecoder implements RawBitmapDecoder {
    private static final byte[] EOI_TAIL = {-1, -39};
    private static final int MAX_DECODE_DIMENSION = 32768;
    private static final String TAG = "DefaultRawBitmapDecoder";
    private final BitmapPool bitmapPool;
    private final Function3<Integer, Integer, BitmapFactory.Options, Integer> bitmapSizeCalculator;
    private final Pools.Pool<ByteBuffer> decodeBuffers;
    private final PlatformDecoderOptions platformDecoderOptions;
    private final PreverificationHelper preverificationHelper;

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public boolean handlesJpegEoiAppendNatively() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultRawBitmapDecoder(Pools.Pool<ByteBuffer> decodeBuffers, PlatformDecoderOptions platformDecoderOptions, BitmapPool bitmapPool, Function3<? super Integer, ? super Integer, ? super BitmapFactory.Options, Integer> function3) {
        Intrinsics.checkNotNullParameter(decodeBuffers, "decodeBuffers");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        this.decodeBuffers = decodeBuffers;
        this.platformDecoderOptions = platformDecoderOptions;
        this.bitmapPool = bitmapPool;
        this.bitmapSizeCalculator = function3;
        this.preverificationHelper = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
    }

    public /* synthetic */ DefaultRawBitmapDecoder(Pools.Pool pool, PlatformDecoderOptions platformDecoderOptions, BitmapPool bitmapPool, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pool, platformDecoderOptions, (i & 4) != 0 ? null : bitmapPool, (i & 8) != 0 ? null : function3);
    }

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decode(byte[] data, int offset, int length, Bitmap.Config bitmapConfig, int sampleSize, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        if (this.platformDecoderOptions.getPreferByteArrayDecode() && this.bitmapPool == null) {
            return decodeByteArray(data, offset, length, bitmapConfig, sampleSize, colorSpace);
        }
        return decode(new ByteArrayInputStream(data, offset, length), bitmapConfig, sampleSize, colorSpace);
    }

    private final Bitmap decodeByteArray(byte[] data, int offset, int length, Bitmap.Config bitmapConfig, int sampleSize, ColorSpace colorSpace) {
        Bitmap bitmap = null;
        BitmapFactory.Options optionsBuildDecodeOptions = buildDecodeOptions(sampleSize, null, bitmapConfig);
        if (Build.VERSION.SDK_INT >= 26 && (this.platformDecoderOptions.getForceSrgbColorSpace() || colorSpace != null)) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                Intrinsics.checkNotNullExpressionValue(colorSpace, "get(...)");
            }
            optionsBuildDecodeOptions.inPreferredColorSpace = colorSpace;
        }
        if (this.platformDecoderOptions.getEnableDecodeDimensionValidation()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(data, offset, length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (i <= 0 || i2 <= 0 || i > 32768 || i2 > 32768) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.ROOT, "Rejecting decode with invalid dimensions: %dx%d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FLog.e(TAG, str);
                PlatformDecoderOptions.DecoderErrorReporter errorReporter = this.platformDecoderOptions.getErrorReporter();
                if (errorReporter != null) {
                    errorReporter.reportError("DECODE_DIMENSION_VALIDATION", str, null);
                }
                return null;
            }
        }
        ByteBuffer byteBufferAcquire = this.decodeBuffers.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
        }
        try {
            try {
                try {
                    optionsBuildDecodeOptions.inTempStorage = byteBufferAcquire.array();
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(data, offset, length, optionsBuildDecodeOptions);
                    Pools.Pool<ByteBuffer> pool = this.decodeBuffers;
                    Intrinsics.checkNotNull(byteBufferAcquire);
                    pool.release(byteBufferAcquire);
                    return bitmapDecodeByteArray;
                } catch (Error e) {
                    if (this.platformDecoderOptions.getCatchNativeDecoderErrors()) {
                        FLog.e(TAG, "Native decoder error", e);
                        PlatformDecoderOptions.DecoderErrorReporter errorReporter2 = this.platformDecoderOptions.getErrorReporter();
                        if (errorReporter2 != null) {
                            errorReporter2.reportError("NATIVE_DECODER_ERROR", "Native decoder error", e);
                        }
                        Pools.Pool<ByteBuffer> pool2 = this.decodeBuffers;
                        Intrinsics.checkNotNull(byteBufferAcquire);
                        pool2.release(byteBufferAcquire);
                        return bitmap;
                    }
                    throw e;
                }
            } catch (IllegalArgumentException e2) {
                Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(data, offset, length);
                if (bitmapDecodeByteArray2 != null) {
                    bitmap = bitmapDecodeByteArray2;
                } else if (this.platformDecoderOptions.getCatchNativeDecoderErrors()) {
                    FLog.e(TAG, "Native decoder error", e2);
                    PlatformDecoderOptions.DecoderErrorReporter errorReporter3 = this.platformDecoderOptions.getErrorReporter();
                    if (errorReporter3 != null) {
                        errorReporter3.reportError("NATIVE_DECODER_ERROR", "Native decoder error", e2);
                    }
                } else {
                    throw e2;
                }
                Pools.Pool<ByteBuffer> pool3 = this.decodeBuffers;
                Intrinsics.checkNotNull(byteBufferAcquire);
                pool3.release(byteBufferAcquire);
                return bitmap;
            } catch (RuntimeException e3) {
                if (this.platformDecoderOptions.getCatchNativeDecoderErrors()) {
                    FLog.e(TAG, "Native decoder error", e3);
                    PlatformDecoderOptions.DecoderErrorReporter errorReporter4 = this.platformDecoderOptions.getErrorReporter();
                    if (errorReporter4 != null) {
                        errorReporter4.reportError("NATIVE_DECODER_ERROR", "Native decoder error", e3);
                    }
                    Pools.Pool<ByteBuffer> pool4 = this.decodeBuffers;
                    Intrinsics.checkNotNull(byteBufferAcquire);
                    pool4.release(byteBufferAcquire);
                    return bitmap;
                }
                throw e3;
            }
        } catch (Throwable th) {
            Pools.Pool<ByteBuffer> pool5 = this.decodeBuffers;
            Intrinsics.checkNotNull(byteBufferAcquire);
            pool5.release(byteBufferAcquire);
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decode(InputStream stream, Bitmap.Config bitmapConfig, int sampleSize, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        try {
            return decode(stream, buildDecodeOptions(sampleSize, null, bitmapConfig), (Rect) null, colorSpace);
        } catch (Error e) {
            if (this.platformDecoderOptions.getCatchNativeDecoderErrors()) {
                Error error = e;
                FLog.e(TAG, "Native decoder error", error);
                PlatformDecoderOptions.DecoderErrorReporter errorReporter = this.platformDecoderOptions.getErrorReporter();
                if (errorReporter != null) {
                    errorReporter.reportError("NATIVE_DECODER_ERROR", "Native decoder error", error);
                }
                return null;
            }
            throw e;
        }
    }

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decode(InputStream decodeStream, InputStream prePassStream, int sampleSize, Bitmap.Config bitmapConfig, Rect regionToDecode, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(decodeStream, "decodeStream");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        return decode(decodeStream, buildDecodeOptions(sampleSize, prePassStream, bitmapConfig), regionToDecode, colorSpace);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:81:0x0147  */
    /* JADX WARN: Code duplicated, block: B:83:0x014a A[Catch: Error -> 0x017a, RuntimeException -> 0x01a2, IllegalArgumentException -> 0x01ad, TryCatch #8 {Error -> 0x017a, IllegalArgumentException -> 0x01ad, RuntimeException -> 0x01a2, blocks: (B:51:0x00e7, B:53:0x00eb, B:55:0x00f5, B:72:0x012d, B:83:0x014a, B:85:0x0154, B:87:0x0166, B:89:0x0171, B:90:0x0179, B:79:0x013e, B:80:0x0146), top: B:139:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0154 A[Catch: Error -> 0x017a, RuntimeException -> 0x01a2, IllegalArgumentException -> 0x01ad, TRY_LEAVE, TryCatch #8 {Error -> 0x017a, IllegalArgumentException -> 0x01ad, RuntimeException -> 0x01a2, blocks: (B:51:0x00e7, B:53:0x00eb, B:55:0x00f5, B:72:0x012d, B:83:0x014a, B:85:0x0154, B:87:0x0166, B:89:0x0171, B:90:0x0179, B:79:0x013e, B:80:0x0146), top: B:139:0x00e7 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decode(InputStream inputStream, BitmapFactory.Options options, Rect regionToDecode, ColorSpace colorSpace) {
        Function3<Integer, Integer, BitmapFactory.Options, Integer> function3;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmapDecodeRegion;
        ByteBuffer byteBufferAcquire;
        BitmapPool bitmapPool;
        BitmapPool bitmapPool2;
        BitmapPool bitmapPool3;
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        PreverificationHelper preverificationHelper;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(options, "options");
        BitmapRegionDecoder bitmapRegionDecoderWidth = options.outWidth;
        int iHeight = options.outHeight;
        if (this.platformDecoderOptions.getEnableDecodeDimensionValidation() && (bitmapRegionDecoderWidth <= 0 || iHeight <= 0 || bitmapRegionDecoderWidth > 32768 || iHeight > 32768)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ROOT, "Rejecting decode with invalid dimensions: %dx%d", Arrays.copyOf(new Object[]{Integer.valueOf(bitmapRegionDecoderWidth), Integer.valueOf(iHeight)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FLog.e(TAG, str);
            PlatformDecoderOptions.DecoderErrorReporter errorReporter = this.platformDecoderOptions.getErrorReporter();
            if (errorReporter != null) {
                errorReporter.reportError("DECODE_DIMENSION_VALIDATION", str, null);
            }
            return null;
        }
        if (regionToDecode != null) {
            bitmapRegionDecoderWidth = regionToDecode.width() / options.inSampleSize;
            iHeight = regionToDecode.height() / options.inSampleSize;
        }
        boolean z = Build.VERSION.SDK_INT >= 26 && (preverificationHelper = this.preverificationHelper) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
        if (regionToDecode == null && z) {
            options.inMutable = false;
        } else {
            if (regionToDecode != null && z) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            if (!this.platformDecoderOptions.getAvoidPoolGet() && this.bitmapPool != null && (function3 = this.bitmapSizeCalculator) != null) {
                bitmap = this.bitmapPool.get(function3.invoke(Integer.valueOf((int) bitmapRegionDecoderWidth), Integer.valueOf(iHeight), options).intValue());
                if (bitmap == null) {
                    bitmap2 = bitmap;
                    throw new NullPointerException("BitmapPool.get returned null");
                }
            }
            bitmap2 = bitmap;
            options.inBitmap = bitmap2;
            if (Build.VERSION.SDK_INT >= 26 && (this.platformDecoderOptions.getForceSrgbColorSpace() || colorSpace != null)) {
                if (colorSpace == null) {
                    colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                    Intrinsics.checkNotNullExpressionValue(colorSpace, "get(...)");
                }
                options.inPreferredColorSpace = colorSpace;
            }
            if (regionToDecode != null || bitmap2 == 0) {
                bitmapDecodeRegion = null;
            } else {
                try {
                    if (options.inPreferredConfig != null) {
                        ByteBuffer byteBufferAcquire2 = this.decodeBuffers.acquire();
                        if (byteBufferAcquire2 == null) {
                            byteBufferAcquire2 = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
                        }
                        try {
                            try {
                                options.inTempStorage = byteBufferAcquire2.array();
                                try {
                                    bitmap2.reconfigure(bitmapRegionDecoderWidth, iHeight, options.inPreferredConfig);
                                    bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStream, true);
                                    if (bitmapRegionDecoderNewInstance != null) {
                                        try {
                                            bitmapDecodeRegion = bitmapRegionDecoderNewInstance.decodeRegion(regionToDecode, options);
                                        } catch (IOException unused) {
                                            FLog.e(TAG, "Could not decode region %s, decoding full bitmap instead.", regionToDecode);
                                            if (bitmapRegionDecoderNewInstance != null) {
                                                bitmapRegionDecoderNewInstance.recycle();
                                            }
                                            bitmapDecodeRegion = null;
                                        }
                                    } else {
                                        bitmapDecodeRegion = null;
                                    }
                                    if (bitmapRegionDecoderNewInstance != null) {
                                        bitmapRegionDecoderNewInstance.recycle();
                                    }
                                } catch (IOException unused2) {
                                    bitmapRegionDecoderNewInstance = null;
                                } catch (Throwable th) {
                                    th = th;
                                    bitmapRegionDecoderWidth = 0;
                                    if (bitmapRegionDecoderWidth != 0) {
                                        bitmapRegionDecoderWidth.recycle();
                                    }
                                    throw th;
                                }
                                Pools.Pool<ByteBuffer> pool = this.decodeBuffers;
                                Intrinsics.checkNotNull(byteBufferAcquire2);
                                pool.release(byteBufferAcquire2);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            Pools.Pool<ByteBuffer> pool2 = this.decodeBuffers;
                            Intrinsics.checkNotNull(byteBufferAcquire2);
                            pool2.release(byteBufferAcquire2);
                            throw th3;
                        }
                    } else {
                        bitmapDecodeRegion = null;
                    }
                } catch (Error e) {
                    if (bitmap2 != 0 && (bitmapPool3 = this.bitmapPool) != null) {
                        bitmapPool3.release(bitmap2);
                    }
                    if (this.platformDecoderOptions.getCatchNativeDecoderErrors()) {
                        Error error = e;
                        FLog.e(TAG, "Native decoder error", error);
                        PlatformDecoderOptions.DecoderErrorReporter errorReporter2 = this.platformDecoderOptions.getErrorReporter();
                        if (errorReporter2 != null) {
                            errorReporter2.reportError("NATIVE_DECODER_ERROR", "Native decoder error", error);
                        }
                        return null;
                    }
                    throw e;
                } catch (IllegalArgumentException e2) {
                    if (bitmap2 != 0 && (bitmapPool2 = this.bitmapPool) != null) {
                        bitmapPool2.release(bitmap2);
                    }
                    try {
                        inputStream.reset();
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                        if (bitmapDecodeStream != null) {
                            return bitmapDecodeStream;
                        }
                        throw e2;
                    } catch (IOException unused3) {
                        throw e2;
                    }
                } catch (RuntimeException e3) {
                    if (bitmap2 != 0 && (bitmapPool = this.bitmapPool) != null) {
                        bitmapPool.release(bitmap2);
                    }
                    throw e3;
                }
            }
            if (bitmapDecodeRegion == null) {
                byteBufferAcquire = this.decodeBuffers.acquire();
                if (byteBufferAcquire == null) {
                    byteBufferAcquire = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
                }
                try {
                    options.inTempStorage = byteBufferAcquire.array();
                    Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStream, null, options);
                    Pools.Pool<ByteBuffer> pool3 = this.decodeBuffers;
                    Intrinsics.checkNotNull(byteBufferAcquire);
                    pool3.release(byteBufferAcquire);
                    bitmapDecodeRegion = bitmapDecodeStream2;
                } catch (Throwable th4) {
                    Pools.Pool<ByteBuffer> pool4 = this.decodeBuffers;
                    Intrinsics.checkNotNull(byteBufferAcquire);
                    pool4.release(byteBufferAcquire);
                    throw th4;
                }
            }
            if (bitmap2 != 0 || bitmap2 == bitmapDecodeRegion) {
                return bitmapDecodeRegion;
            }
            BitmapPool bitmapPool4 = this.bitmapPool;
            if (bitmapPool4 != null) {
                bitmapPool4.release(bitmap2);
            }
            if (bitmapDecodeRegion != null) {
                bitmapDecodeRegion.recycle();
            }
            throw new IllegalStateException();
        }
        bitmap2 = 0;
        bitmap2 = bitmap;
        options.inBitmap = bitmap2;
        if (Build.VERSION.SDK_INT >= 26) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                Intrinsics.checkNotNullExpressionValue(colorSpace, "get(...)");
            }
            options.inPreferredColorSpace = colorSpace;
        }
        if (regionToDecode != null) {
            bitmapDecodeRegion = null;
        } else {
            bitmapDecodeRegion = null;
        }
        if (bitmapDecodeRegion == null) {
            byteBufferAcquire = this.decodeBuffers.acquire();
            if (byteBufferAcquire == null) {
                byteBufferAcquire = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
            }
            options.inTempStorage = byteBufferAcquire.array();
            Bitmap bitmapDecodeStream3 = BitmapFactory.decodeStream(inputStream, null, options);
            Pools.Pool<ByteBuffer> pool5 = this.decodeBuffers;
            Intrinsics.checkNotNull(byteBufferAcquire);
            pool5.release(byteBufferAcquire);
            bitmapDecodeRegion = bitmapDecodeStream3;
        }
        if (bitmap2 != 0) {
        }
        return bitmapDecodeRegion;
    }

    @Override // com.facebook.imagepipeline.platform.RawBitmapDecoder
    public Bitmap decodeJpeg(InputStream jpegStream, InputStream prePassStream, int sampleSize, Bitmap.Config bitmapConfig, Rect regionToDecode, ColorSpace colorSpace, int encodedImageSize, int length, boolean isJpegComplete) {
        Intrinsics.checkNotNullParameter(jpegStream, "jpegStream");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        BitmapFactory.Options optionsBuildDecodeOptions = buildDecodeOptions(sampleSize, prePassStream, bitmapConfig);
        if (encodedImageSize > length) {
            jpegStream = new LimitedInputStream(jpegStream, length);
        }
        if (!isJpegComplete) {
            jpegStream = new TailAppendingInputStream(jpegStream, EOI_TAIL);
        }
        try {
            Bitmap bitmapDecode = decode(jpegStream, optionsBuildDecodeOptions, regionToDecode, colorSpace);
            try {
                return bitmapDecode;
            } catch (IOException e) {
                return bitmapDecode;
            }
        } finally {
            try {
                jpegStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private final BitmapFactory.Options buildDecodeOptions(int sampleSize, InputStream prePassStream, Bitmap.Config bitmapConfig) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sampleSize;
        boolean z = true;
        options.inJustDecodeBounds = true;
        options.inDither = this.platformDecoderOptions.getEnableDither();
        boolean z2 = Build.VERSION.SDK_INT >= 26 && bitmapConfig == Bitmap.Config.HARDWARE;
        if (!z2) {
            options.inPreferredConfig = bitmapConfig;
        }
        if (this.platformDecoderOptions.getDecodeImmutableBitmaps() && this.bitmapPool == null) {
            z = false;
        }
        options.inMutable = z;
        if (z2) {
            options.inMutable = false;
        }
        if (prePassStream != null) {
            BitmapFactory.decodeStream(prePassStream, null, options);
            if (options.outWidth == -1 || options.outHeight == -1) {
                throw new IllegalArgumentException();
            }
        }
        if (z2) {
            options.inPreferredConfig = bitmapConfig;
        }
        options.inJustDecodeBounds = false;
        return options;
    }
}
