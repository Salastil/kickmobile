package androidx.camera.camera2.pipe.media;

import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.compat.Api28Compat;
import androidx.camera.camera2.pipe.compat.Api29Compat;
import androidx.camera.camera2.pipe.compat.Api33Compat;
import androidx.camera.camera2.pipe.core.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import io.ktor.util.date.GMTDateParser;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;

/* JADX INFO: compiled from: AndroidImageReaders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010)\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020'H\u0016J'\u0010+\u001a\u0004\u0018\u0001H,\"\b\b\u0000\u0010,*\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0/H\u0016¢\u0006\u0002\u00100J\b\u00101\u001a\u000202H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R/\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u001e\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00064"}, d2 = {"Landroidx/camera/camera2/pipe/media/AndroidImageReader;", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", "Landroid/media/ImageReader$OnImageAvailableListener;", "imageReader", "Landroid/media/ImageReader;", "capacity", "", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "<init>", "(Landroid/media/ImageReader;III)V", "getCapacity", "()I", "I", "outputIdSet", "", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "<set-?>", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;", "onImageListener", "getOnImageListener", "()Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;", "setOnImageListener", "(Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;)V", "onImageListener$delegate", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;", "onExpectedOutputsListener", "getOnExpectedOutputsListener", "()Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;", "setOnExpectedOutputsListener", "(Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;)V", "onExpectedOutputsListener$delegate", "onImageAvailable", "", "reader", "close", "flush", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidImageReader implements ImageReaderWrapper, ImageReader.OnImageAvailableListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int IMAGEREADER_MAX_CAPACITY = 54;
    private final int capacity;
    private final ImageReader imageReader;

    /* JADX INFO: renamed from: onExpectedOutputsListener$delegate, reason: from kotlin metadata */
    private final AtomicRef onExpectedOutputsListener;

    /* JADX INFO: renamed from: onImageListener$delegate, reason: from kotlin metadata */
    private final AtomicRef onImageListener;
    private final int outputId;
    private final Set<OutputId> outputIdSet;
    private final int streamId;
    private final Surface surface;

    public /* synthetic */ AndroidImageReader(ImageReader imageReader, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageReader, i, i2, i3);
    }

    private AndroidImageReader(ImageReader imageReader, int i, int i2, int i3) {
        this.imageReader = imageReader;
        this.capacity = i;
        this.streamId = i2;
        this.outputId = i3;
        this.outputIdSet = SetsKt.setOf(OutputId.m571boximpl(i3));
        Surface surface = imageReader.getSurface();
        Intrinsics.checkNotNullExpressionValue(surface, "getSurface(...)");
        this.surface = surface;
        this.onImageListener = AtomicFU.atomic((Object) null);
        this.onExpectedOutputsListener = AtomicFU.atomic((Object) null);
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public Surface getSurface() {
        return this.surface;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public ImageReaderWrapper.OnImageListener getOnImageListener() {
        return (ImageReaderWrapper.OnImageListener) this.onImageListener.getValue();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public void setOnImageListener(ImageReaderWrapper.OnImageListener onImageListener) {
        this.onImageListener.setValue(onImageListener);
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public ImageReaderWrapper.OnExpectedOutputsListener getOnExpectedOutputsListener() {
        return (ImageReaderWrapper.OnExpectedOutputsListener) this.onExpectedOutputsListener.getValue();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public void setOnExpectedOutputsListener(ImageReaderWrapper.OnExpectedOutputsListener onExpectedOutputsListener) {
        this.onExpectedOutputsListener.setValue(onExpectedOutputsListener);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader reader) {
        Image imageAcquireNextImage = reader != null ? reader.acquireNextImage() : null;
        if (imageAcquireNextImage != null) {
            ImageReaderWrapper.OnImageListener onImageListener = getOnImageListener();
            if (onImageListener == null) {
                imageAcquireNextImage.close();
                return;
            }
            ImageReaderWrapper.OnExpectedOutputsListener onExpectedOutputsListener = getOnExpectedOutputsListener();
            if (onExpectedOutputsListener != null) {
                onExpectedOutputsListener.onExpectedOutputs(imageAcquireNextImage.getTimestamp(), this.outputIdSet);
            }
            onImageListener.mo1057onImageAQuxepk(this.streamId, this.outputId, new AndroidImage(imageAcquireNextImage));
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.imageReader.close();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public void flush() {
        Image imageAcquireLatestImage = this.imageReader.acquireLatestImage();
        if (imageAcquireLatestImage != null) {
            imageAcquireLatestImage.close();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Compat.discardFreeBuffers(this.imageReader);
        }
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ImageReader.class))) {
            return (T) this.imageReader;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImageReader@");
        String string = Integer.toString(super.hashCode(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        sb.append('-');
        sb.append(StreamFormat.m750getNameimpl(StreamFormat.m746constructorimpl(this.imageReader.getImageFormat())));
        sb.append("-w");
        sb.append(this.imageReader.getWidth());
        sb.append(GMTDateParser.HOURS);
        sb.append(this.imageReader.getHeight());
        return sb.toString();
    }

    /* JADX INFO: compiled from: AndroidImageReaders.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jc\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/media/AndroidImageReader$Companion;", "", "<init>", "()V", "IMAGEREADER_MAX_CAPACITY", "", "create", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", ViewProps.WIDTH, ViewProps.HEIGHT, "format", "capacity", "usageFlags", "", "defaultDataSpace", "defaultHardwareBufferFormat", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "handler", "Landroid/os/Handler;", "create-fE-0t4g", "(IIIILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;IILandroid/os/Handler;)Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: create-fE-0t4g, reason: not valid java name */
        public final ImageReaderWrapper m1052createfE0t4g(int width, int height, int format, int capacity, Long usageFlags, Integer defaultDataSpace, Integer defaultHardwareBufferFormat, int streamId, int outputId, Handler handler) {
            ImageReader imageReaderNewInstance;
            Intrinsics.checkNotNullParameter(handler, "handler");
            if (width <= 0) {
                throw new IllegalArgumentException(("Width (" + width + ") must be > 0").toString());
            }
            if (height <= 0) {
                throw new IllegalArgumentException(("Height (" + height + ") must be > 0").toString());
            }
            if (capacity <= 0) {
                throw new IllegalArgumentException(("Capacity (" + capacity + ") must be > 0").toString());
            }
            if (capacity > 54) {
                throw new IllegalArgumentException("Capacity for creating new ImageSources is restricted to 54. Android has undocumented internal limits that are different depending on which device the ImageReader is created on.".toString());
            }
            if (usageFlags != null && Build.VERSION.SDK_INT < 29 && Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Ignoring ImageReader usage (" + usageFlags.longValue() + ") for " + ((Object) OutputId.m576toStringimpl(outputId)) + ". Android " + Build.VERSION.SDK_INT + " does not support creating ImageReaders with usage flags. This may lead to unexpected behaviors.");
            }
            if (defaultDataSpace != null && Build.VERSION.SDK_INT < 33 && Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Ignoring defaultDataSpace (" + defaultDataSpace.intValue() + ") for " + ((Object) OutputId.m576toStringimpl(outputId)) + ". Android " + Build.VERSION.SDK_INT + " does not support creating ImageReaders with defaultDataSpace. This may lead to unexpected behaviors.");
            }
            if (defaultHardwareBufferFormat != null && Build.VERSION.SDK_INT < 33 && Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Ignoring defaultHardwareBufferFormat (" + defaultHardwareBufferFormat.intValue() + ") for " + ((Object) OutputId.m576toStringimpl(outputId)) + ". Android " + Build.VERSION.SDK_INT + " does not support creating ImageReaders with defaultHardwareBufferFormat. This may lead to unexpected behaviors.");
            }
            if (Build.VERSION.SDK_INT >= 33) {
                imageReaderNewInstance = Api33Compat.newImageReaderFromImageReaderBuilder(width, height, Integer.valueOf(format), Integer.valueOf(capacity), usageFlags, defaultDataSpace, defaultHardwareBufferFormat);
            } else if (Build.VERSION.SDK_INT < 29) {
                imageReaderNewInstance = ImageReader.newInstance(width, height, format, capacity);
                Intrinsics.checkNotNull(imageReaderNewInstance);
            } else if (usageFlags != null) {
                imageReaderNewInstance = Api29Compat.imageReaderNewInstance(width, height, format, capacity, usageFlags.longValue());
            } else {
                imageReaderNewInstance = ImageReader.newInstance(width, height, format, capacity);
                Intrinsics.checkNotNull(imageReaderNewInstance);
            }
            ImageReader imageReader = imageReaderNewInstance;
            AndroidImageReader androidImageReader = new AndroidImageReader(imageReader, capacity, streamId, outputId, null);
            imageReader.setOnImageAvailableListener(androidImageReader, handler);
            return androidImageReader;
        }
    }
}
