package androidx.camera.camera2.pipe.media;

import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.os.Build;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.compat.Api28Compat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import io.ktor.util.date.GMTDateParser;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: AndroidImage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\"\u001a\u0004\u0018\u0001H#\"\b\b\u0000\u0010#*\u00020\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%H\u0016¢\u0006\u0002\u0010&J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u00060"}, d2 = {"Landroidx/camera/camera2/pipe/media/AndroidImage;", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "image", "Landroid/media/Image;", "<init>", "(Landroid/media/Image;)V", "lock", "", "_planes", "", "Landroidx/camera/camera2/pipe/media/ImagePlane;", "format", "", "getFormat", "()I", ViewProps.WIDTH, "getWidth", ViewProps.HEIGHT, "getHeight", "timestamp", "", "getTimestamp", "()J", "newRectValue", "Landroid/graphics/Rect;", "cropRect", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "planes", "getPlanes", "()Ljava/util/List;", "toString", "", "close", "", "readPlanes", "Plane", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidImage implements ImageWrapper {
    private volatile List<? extends ImagePlane> _planes;
    private final int format;
    private final int height;
    private final Image image;
    private final Object lock;
    private final long timestamp;
    private final int width;

    public AndroidImage(Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.image = image;
        this.lock = new Object();
        this.format = image.getFormat();
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.timestamp = image.getTimestamp();
    }

    /* JADX INFO: compiled from: AndroidImage.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014H\u0016¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/media/AndroidImage$Plane;", "Landroidx/camera/camera2/pipe/media/ImagePlane;", "imagePlane", "Landroid/media/Image$Plane;", "<init>", "(Landroid/media/Image$Plane;)V", "pixelStride", "", "getPixelStride", "()I", "rowStride", "getRowStride", "buffer", "Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/nio/ByteBuffer;", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Plane implements ImagePlane {
        private final ByteBuffer buffer;
        private final Image.Plane imagePlane;
        private final int pixelStride;
        private final int rowStride;

        public Plane(Image.Plane imagePlane) {
            Intrinsics.checkNotNullParameter(imagePlane, "imagePlane");
            this.imagePlane = imagePlane;
            this.pixelStride = imagePlane.getPixelStride();
            this.rowStride = imagePlane.getRowStride();
            ByteBuffer buffer = imagePlane.getBuffer();
            Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
            this.buffer = buffer;
        }

        @Override // androidx.camera.camera2.pipe.media.ImagePlane
        public int getPixelStride() {
            return this.pixelStride;
        }

        @Override // androidx.camera.camera2.pipe.media.ImagePlane
        public int getRowStride() {
            return this.rowStride;
        }

        @Override // androidx.camera.camera2.pipe.media.ImagePlane
        public ByteBuffer getBuffer() {
            return this.buffer;
        }

        @Override // androidx.camera.camera2.pipe.UnsafeWrapper
        public <T> T unwrapAs(KClass<T> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Image.Plane.class))) {
                return null;
            }
            Object obj = this.imagePlane;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.media.AndroidImage.Plane.unwrapAs");
            return (T) obj;
        }
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWrapper
    public int getFormat() {
        return this.format;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWrapper
    public int getWidth() {
        return this.width;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWrapper
    public int getHeight() {
        return this.height;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWrapper
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWrapper
    public Rect getCropRect() {
        Rect cropRect = this.image.getCropRect();
        Intrinsics.checkNotNullExpressionValue(cropRect, "getCropRect(...)");
        return cropRect;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWrapper
    public void setCropRect(Rect newRectValue) {
        Intrinsics.checkNotNullParameter(newRectValue, "newRectValue");
        this.image.setCropRect(newRectValue);
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWrapper
    public HardwareBuffer getHardwareBuffer() {
        if (Build.VERSION.SDK_INT > 27) {
            return Api28Compat.getHardwareBuffer(this.image);
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Image.class))) {
            Object obj = this.image;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.media.AndroidImage.unwrapAs");
            return (T) obj;
        }
        if (Build.VERSION.SDK_INT > 27) {
            return (T) Api28Compat.unwrapAsHardwareBuffer(this.image, type);
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageWrapper
    public List<ImagePlane> getPlanes() {
        return readPlanes();
    }

    public String toString() {
        return "Image-" + StreamFormat.m750getNameimpl(StreamFormat.m746constructorimpl(getFormat())) + "-w" + getWidth() + GMTDateParser.HOURS + getHeight() + "-t" + getTimestamp();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.image.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<ImagePlane> readPlanes() {
        List list;
        List listEmptyList;
        List list2 = this._planes;
        List list3 = list2;
        if (list2 == null) {
            synchronized (this.lock) {
                list = this._planes;
                if (list == null) {
                    Image.Plane[] planes = this.image.getPlanes();
                    if (planes == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    } else {
                        List arrayList = new ArrayList(planes.length);
                        for (Image.Plane plane : planes) {
                            Intrinsics.checkNotNull(plane);
                            arrayList.add(new Plane(plane));
                        }
                        listEmptyList = arrayList;
                    }
                    this._planes = listEmptyList;
                    list = listEmptyList;
                }
                Unit unit = Unit.INSTANCE;
            }
            list3 = list;
        }
        Intrinsics.checkNotNull(list3);
        return list3;
    }
}
