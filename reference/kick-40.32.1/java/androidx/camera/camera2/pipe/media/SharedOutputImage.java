package androidx.camera.camera2.pipe.media;

import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.media.Image;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* JADX INFO: compiled from: SharedOutputImage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0000H&J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0000H&J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/SharedOutputImage;", "Landroidx/camera/camera2/pipe/media/OutputImage;", "acquire", "acquireOrNull", "setFinalizer", "", "finalizer", "Landroidx/camera/camera2/pipe/media/Finalizer;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SharedOutputImage extends OutputImage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    SharedOutputImage acquire();

    SharedOutputImage acquireOrNull();

    void setFinalizer(Finalizer<? super OutputImage> finalizer);

    /* JADX INFO: compiled from: SharedOutputImage.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/media/SharedOutputImage$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Landroidx/camera/camera2/pipe/media/SharedOutputImage;", "image", "Landroidx/camera/camera2/pipe/media/OutputImage;", "SharedOutputImageImpl", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SharedOutputImage from(OutputImage image) {
            Intrinsics.checkNotNullParameter(image, "image");
            if (image instanceof SharedOutputImage) {
                return ((SharedOutputImage) image).acquire();
            }
            SharedOutputImage sharedOutputImage = (SharedOutputImage) image.unwrapAs(Reflection.getOrCreateKotlinClass(SharedOutputImage.class));
            if (sharedOutputImage != null) {
                return sharedOutputImage.acquire();
            }
            return new SharedOutputImageImpl(image, new SharedReference(image, ClosingFinalizer.INSTANCE));
        }

        /* JADX INFO: compiled from: SharedOutputImage.kt */
        @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u0002H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0016J'\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\u00020\u001aX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020 X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0012\u0010'\u001a\u00020 X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u0012\u0010)\u001a\u00020*X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010\"R\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0012\u00101\u001a\u000202X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u0010\"R\u0012\u00104\u001a\u000205X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107R\u0012\u00108\u001a\u00020 X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010\"¨\u0006:"}, d2 = {"Landroidx/camera/camera2/pipe/media/SharedOutputImage$Companion$SharedOutputImageImpl;", "Landroidx/camera/camera2/pipe/media/OutputImage;", "Landroidx/camera/camera2/pipe/media/SharedOutputImage;", "outputImage", "sharedReference", "Landroidx/camera/camera2/pipe/media/SharedReference;", "<init>", "(Landroidx/camera/camera2/pipe/media/OutputImage;Landroidx/camera/camera2/pipe/media/SharedReference;)V", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "acquire", "acquireOrNull", "setFinalizer", "", "finalizer", "Landroidx/camera/camera2/pipe/media/Finalizer;", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "close", "toString", "", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "format", "", "getFormat", "()I", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", ViewProps.HEIGHT, "getHeight", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "getOutputId-4LaLFng", "planes", "", "Landroidx/camera/camera2/pipe/media/ImagePlane;", "getPlanes", "()Ljava/util/List;", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "getStreamId-ptHMqGs", "timestamp", "", "getTimestamp", "()J", ViewProps.WIDTH, "getWidth", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        private static final class SharedOutputImageImpl implements OutputImage, SharedOutputImage {
            private final AtomicBoolean closed;
            private final OutputImage outputImage;
            private final SharedReference<OutputImage> sharedReference;

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public Rect getCropRect() {
                return this.outputImage.getCropRect();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public int getFormat() {
                return this.outputImage.getFormat();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public HardwareBuffer getHardwareBuffer() {
                return this.outputImage.getHardwareBuffer();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public int getHeight() {
                return this.outputImage.getHeight();
            }

            @Override // androidx.camera.camera2.pipe.media.OutputImage
            /* JADX INFO: renamed from: getOutputId-4LaLFng */
            public int getOutputId() {
                return this.outputImage.getOutputId();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public List<ImagePlane> getPlanes() {
                return this.outputImage.getPlanes();
            }

            @Override // androidx.camera.camera2.pipe.media.OutputImage
            /* JADX INFO: renamed from: getStreamId-ptHMqGs */
            public int getStreamId() {
                return this.outputImage.getStreamId();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public long getTimestamp() {
                return this.outputImage.getTimestamp();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public int getWidth() {
                return this.outputImage.getWidth();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public void setCropRect(Rect rect) {
                Intrinsics.checkNotNullParameter(rect, "<set-?>");
                this.outputImage.setCropRect(rect);
            }

            public SharedOutputImageImpl(OutputImage outputImage, SharedReference<OutputImage> sharedReference) {
                Intrinsics.checkNotNullParameter(outputImage, "outputImage");
                Intrinsics.checkNotNullParameter(sharedReference, "sharedReference");
                this.outputImage = outputImage;
                this.sharedReference = sharedReference;
                this.closed = AtomicFU.atomic(false);
            }

            @Override // androidx.camera.camera2.pipe.media.SharedOutputImage
            public SharedOutputImage acquire() {
                SharedOutputImage sharedOutputImageAcquireOrNull = acquireOrNull();
                if (sharedOutputImageAcquireOrNull != null) {
                    return sharedOutputImageAcquireOrNull;
                }
                throw new IllegalStateException("Required value was null.".toString());
            }

            @Override // androidx.camera.camera2.pipe.media.SharedOutputImage
            public SharedOutputImage acquireOrNull() {
                if (this.closed.getValue()) {
                    return null;
                }
                return this.sharedReference.acquireOrNull() != null ? new SharedOutputImageImpl(this.outputImage, this.sharedReference) : null;
            }

            @Override // androidx.camera.camera2.pipe.media.SharedOutputImage
            public void setFinalizer(Finalizer<? super OutputImage> finalizer) {
                Intrinsics.checkNotNullParameter(finalizer, "finalizer");
                if (this.closed.getValue()) {
                    finalizer.finalize(null);
                } else {
                    this.sharedReference.setFinalizer(finalizer);
                }
            }

            @Override // androidx.camera.camera2.pipe.UnsafeWrapper
            public <T> T unwrapAs(KClass<T> type) {
                Intrinsics.checkNotNullParameter(type, "type");
                if (this.closed.getValue()) {
                    return null;
                }
                if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(SharedOutputImage.class)) && !Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(OutputImage.class)) && !Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ImageWrapper.class))) {
                    if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(Image.class))) {
                        throw new UnsupportedOperationException("Cannot unwrap " + this + " as android.media.Image. Use setFinalizerinstead and close all outstanding references.");
                    }
                    return (T) this.outputImage.unwrapAs(type);
                }
                return (T) this;
            }

            @Override // java.lang.AutoCloseable
            public void close() {
                if (this.closed.compareAndSet(false, true)) {
                    this.sharedReference.decrement();
                }
            }

            public String toString() {
                return this.outputImage.toString();
            }
        }
    }
}
