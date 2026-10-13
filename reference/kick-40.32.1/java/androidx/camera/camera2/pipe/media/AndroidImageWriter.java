package androidx.camera.camera2.pipe.media;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.pipe.InputStreamId;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.compat.Api29Compat;
import androidx.camera.camera2.pipe.core.Log;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;

/* JADX INFO: compiled from: AndroidImageWriter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\fH\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J'\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0!H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006&"}, d2 = {"Landroidx/camera/camera2/pipe/media/AndroidImageWriter;", "Landroidx/camera/camera2/pipe/media/ImageWriterWrapper;", "Landroid/media/ImageWriter$OnImageReleasedListener;", "imageWriter", "Landroid/media/ImageWriter;", "inputStreamId", "Landroidx/camera/camera2/pipe/InputStreamId;", "<init>", "(Landroid/media/ImageWriter;I)V", "I", "onImageReleasedListener", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/media/ImageWriterWrapper$OnImageReleasedListener;", "maxImages", "", "getMaxImages", "()I", "format", "getFormat", "queueInputImage", "", "image", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "dequeueInputImage", "setOnImageReleasedListener", "", "onImageReleased", "writer", "close", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidImageWriter implements ImageWriterWrapper, ImageWriter.OnImageReleasedListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int format;
    private final ImageWriter imageWriter;
    private final int inputStreamId;
    private final int maxImages;
    private final AtomicRef<ImageWriterWrapper.OnImageReleasedListener> onImageReleasedListener;

    public /* synthetic */ AndroidImageWriter(ImageWriter imageWriter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageWriter, i);
    }

    private AndroidImageWriter(ImageWriter imageWriter, int i) {
        this.imageWriter = imageWriter;
        this.inputStreamId = i;
        this.onImageReleasedListener = AtomicFU.atomic((Object) null);
        this.maxImages = imageWriter.getMaxImages();
        this.format = imageWriter.getFormat();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWriterWrapper
    public int getMaxImages() {
        return this.maxImages;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWriterWrapper
    public int getFormat() {
        return this.format;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWriterWrapper
    public boolean queueInputImage(ImageWrapper image) throws Exception {
        Intrinsics.checkNotNullParameter(image, "image");
        try {
            Image image2 = (Image) image.unwrapAs(Reflection.getOrCreateKotlinClass(Image.class));
            if (image2 != null) {
                this.imageWriter.queueInputImage(image2);
                return true;
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to unwrap image wrapper " + image);
            }
            return false;
        } catch (Throwable th) {
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to queue image to " + this + " due to error " + th.getMessage() + ". Ignoring failure and closing " + image);
            }
            UByte$$ExternalSyntheticBackport0.m12761m((Object) image);
            return false;
        }
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWriterWrapper
    public ImageWrapper dequeueInputImage() {
        Image imageDequeueInputImage = this.imageWriter.dequeueInputImage();
        Intrinsics.checkNotNull(imageDequeueInputImage);
        return new AndroidImage(imageDequeueInputImage);
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWriterWrapper
    public void setOnImageReleasedListener(ImageWriterWrapper.OnImageReleasedListener onImageReleasedListener) {
        Intrinsics.checkNotNullParameter(onImageReleasedListener, "onImageReleasedListener");
        this.onImageReleasedListener.setValue(onImageReleasedListener);
    }

    @Override // android.media.ImageWriter.OnImageReleasedListener
    public void onImageReleased(ImageWriter writer) {
        ImageWriterWrapper.OnImageReleasedListener value = this.onImageReleasedListener.getValue();
        if (value != null) {
            value.m1060onImageReleasedI45lehc(this.inputStreamId);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.imageWriter.close();
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ImageWriter.class))) {
            return (T) this.imageWriter;
        }
        return null;
    }

    public String toString() {
        return "ImageWriter-" + StreamFormat.m750getNameimpl(StreamFormat.m746constructorimpl(this.imageWriter.getFormat())) + '-' + ((Object) InputStreamId.m556toStringimpl(this.inputStreamId));
    }

    /* JADX INFO: compiled from: AndroidImageWriter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/media/AndroidImageWriter$Companion;", "", "<init>", "()V", "create", "Landroidx/camera/camera2/pipe/media/ImageWriterWrapper;", "surface", "Landroid/view/Surface;", "inputStreamId", "Landroidx/camera/camera2/pipe/InputStreamId;", "maxImages", "", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "handler", "Landroid/os/Handler;", "create-U86x6Zg", "(Landroid/view/Surface;IILandroidx/camera/camera2/pipe/StreamFormat;Landroid/os/Handler;)Landroidx/camera/camera2/pipe/media/ImageWriterWrapper;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: create-U86x6Zg, reason: not valid java name */
        public final ImageWriterWrapper m1053createU86x6Zg(Surface surface, int inputStreamId, int maxImages, StreamFormat format, Handler handler) {
            ImageWriter imageWriterNewInstance;
            Intrinsics.checkNotNullParameter(surface, "surface");
            Intrinsics.checkNotNullParameter(handler, "handler");
            if (maxImages <= 0) {
                throw new IllegalArgumentException(("Max images (" + maxImages + ") must be > 0").toString());
            }
            if (maxImages > 54) {
                throw new IllegalArgumentException("Max images for ImageWriters is restricted to 54 to prevent overloading downstream consumer components.".toString());
            }
            if (Build.VERSION.SDK_INT >= 29 && format != null) {
                imageWriterNewInstance = Api29Compat.imageWriterNewInstance(surface, maxImages, format.m753unboximpl());
            } else {
                if (format != null && Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Ignoring format (" + ((Object) StreamFormat.m752toStringimpl(format.m753unboximpl())) + ") for " + ((Object) InputStreamId.m556toStringimpl(inputStreamId)) + ". Android " + Build.VERSION.SDK_INT + " does not support creating ImageWriters with formats. This may lead to unexpected behaviors.");
                }
                imageWriterNewInstance = ImageWriter.newInstance(surface, maxImages);
                Intrinsics.checkNotNull(imageWriterNewInstance);
            }
            AndroidImageWriter androidImageWriter = new AndroidImageWriter(imageWriterNewInstance, inputStreamId, null);
            imageWriterNewInstance.setOnImageReleasedListener(androidImageWriter, handler);
            return androidImageWriter;
        }
    }
}
