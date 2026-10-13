package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.BitmapUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: DalvikPurgeableDecoder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J2\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J4\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J<\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001e\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\u0006\u0010\u0019\u001a\u00020\u001aH$J&\u0010\u001b\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH$J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001d\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/imagepipeline/nativecode/DalvikPurgeableDecoder;", "Lcom/facebook/imagepipeline/platform/PlatformDecoder;", "<init>", "()V", "unpooledBitmapsCounter", "Lcom/facebook/imagepipeline/memory/BitmapCounter;", "decodeFromEncodedImage", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "regionToDecode", "Landroid/graphics/Rect;", "decodeJPEGFromEncodedImage", "length", "", "decodeFromEncodedImageWithColorSpace", "colorSpace", "Landroid/graphics/ColorSpace;", "decodeJPEGFromEncodedImageWithColorSpace", "decodeByteArrayAsPurgeable", "bytesRef", "Lcom/facebook/common/memory/PooledByteBuffer;", "options", "Landroid/graphics/BitmapFactory$Options;", "decodeJPEGByteArrayAsPurgeable", "pinBitmap", "bitmap", "OreoUtils", "Companion", "imagepipeline-native_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DalvikPurgeableDecoder implements PlatformDecoder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    protected static final byte[] EOI;
    private final BitmapCounter unpooledBitmapsCounter = BitmapCounterProvider.get();

    @JvmStatic
    public static final boolean endsWithEOI(CloseableReference<PooledByteBuffer> closeableReference, int i) {
        return INSTANCE.endsWithEOI(closeableReference, i);
    }

    @JvmStatic
    public static final BitmapFactory.Options getBitmapFactoryOptions(int i, Bitmap.Config config) {
        return INSTANCE.getBitmapFactoryOptions(i, config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativePinBitmap(Bitmap bitmap);

    protected abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> bytesRef, BitmapFactory.Options options);

    protected abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> bytesRef, int length, BitmapFactory.Options options);

    protected DalvikPurgeableDecoder() {
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
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        BitmapFactory.Options bitmapFactoryOptions = INSTANCE.getBitmapFactoryOptions(encodedImage.getSampleSize(), bitmapConfig);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Intrinsics.checkNotNullExpressionValue(byteBufferRef, "getByteBufferRef(...)");
        try {
            return pinBitmap(decodeByteArrayAsPurgeable(byteBufferRef, bitmapFactoryOptions));
        } finally {
            CloseableReference.closeSafely(byteBufferRef);
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config bitmapConfig, Rect regionToDecode, int length, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        BitmapFactory.Options bitmapFactoryOptions = INSTANCE.getBitmapFactoryOptions(encodedImage.getSampleSize(), bitmapConfig);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Intrinsics.checkNotNullExpressionValue(byteBufferRef, "getByteBufferRef(...)");
        try {
            return pinBitmap(decodeJPEGByteArrayAsPurgeable(byteBufferRef, length, bitmapFactoryOptions));
        } finally {
            CloseableReference.closeSafely(byteBufferRef);
        }
    }

    /* JADX INFO: compiled from: DalvikPurgeableDecoder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/DalvikPurgeableDecoder$OreoUtils;", "", "<init>", "()V", "setColorSpace", "", "options", "Landroid/graphics/BitmapFactory$Options;", "colorSpace", "Landroid/graphics/ColorSpace;", "imagepipeline-native_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class OreoUtils {
        public static final OreoUtils INSTANCE = new OreoUtils();

        private OreoUtils() {
        }

        @JvmStatic
        public static final void setColorSpace(BitmapFactory.Options options, ColorSpace colorSpace) {
            Intrinsics.checkNotNullParameter(options, "options");
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                Intrinsics.checkNotNullExpressionValue(colorSpace, "get(...)");
            }
            options.inPreferredColorSpace = colorSpace;
        }
    }

    public final CloseableReference<Bitmap> pinBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        try {
            INSTANCE.nativePinBitmap(bitmap);
            if (!this.unpooledBitmapsCounter.increase(bitmap)) {
                int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
                bitmap.recycle();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Arrays.copyOf(new Object[]{Integer.valueOf(sizeInBytes), Integer.valueOf(this.unpooledBitmapsCounter.getCount()), Long.valueOf(this.unpooledBitmapsCounter.getSize()), Integer.valueOf(this.unpooledBitmapsCounter.getMaxCount()), Integer.valueOf(this.unpooledBitmapsCounter.getMaxSize())}, 5));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                throw new TooManyBitmapsException(str);
            }
            CloseableReference<Bitmap> closeableReferenceOf = CloseableReference.of(bitmap, this.unpooledBitmapsCounter.getReleaser());
            Intrinsics.checkNotNullExpressionValue(closeableReferenceOf, "of(...)");
            return closeableReferenceOf;
        } catch (Exception e) {
            bitmap.recycle();
            throw Throwables.propagate(e);
        }
    }

    /* JADX INFO: compiled from: DalvikPurgeableDecoder.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0007J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0083 R\u0010\u0010\u0004\u001a\u00020\u00058\u0004X\u0085\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/DalvikPurgeableDecoder$Companion;", "", "<init>", "()V", "EOI", "", "getBitmapFactoryOptions", "Landroid/graphics/BitmapFactory$Options;", "sampleSize", "", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "endsWithEOI", "", "bytesRef", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/common/memory/PooledByteBuffer;", "length", "nativePinBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "imagepipeline-native_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativePinBitmap(Bitmap bitmap) {
            DalvikPurgeableDecoder.nativePinBitmap(bitmap);
        }

        private Companion() {
        }

        @JvmStatic
        public final BitmapFactory.Options getBitmapFactoryOptions(int sampleSize, Bitmap.Config bitmapConfig) {
            Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = true;
            options.inPreferredConfig = bitmapConfig;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inSampleSize = sampleSize;
            options.inMutable = true;
            return options;
        }

        @JvmStatic
        public final boolean endsWithEOI(CloseableReference<PooledByteBuffer> bytesRef, int length) {
            Intrinsics.checkNotNullParameter(bytesRef, "bytesRef");
            PooledByteBuffer pooledByteBuffer = bytesRef.get();
            Intrinsics.checkNotNullExpressionValue(pooledByteBuffer, "get(...)");
            PooledByteBuffer pooledByteBuffer2 = pooledByteBuffer;
            return length >= 2 && pooledByteBuffer2.read(length + (-2)) == -1 && pooledByteBuffer2.read(length - 1) == -39;
        }
    }

    static {
        ImagePipelineNativeLoader.load();
        EOI = new byte[]{-1, -39};
    }
}
