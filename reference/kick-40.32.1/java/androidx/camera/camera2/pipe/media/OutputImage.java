package androidx.camera.camera2.pipe.media;

import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: OutputImage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/OutputImage;", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "getStreamId-ptHMqGs", "()I", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "getOutputId-4LaLFng", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OutputImage extends ImageWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: getOutputId-4LaLFng */
    int getOutputId();

    /* JADX INFO: renamed from: getStreamId-ptHMqGs */
    int getStreamId();

    /* JADX INFO: compiled from: OutputImage.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u0005H\u0080\b¢\u0006\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/media/OutputImage$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Landroidx/camera/camera2/pipe/media/OutputImage;", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "image", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "from-AQuxepk", "(IILandroidx/camera/camera2/pipe/media/ImageWrapper;)Landroidx/camera/camera2/pipe/media/OutputImage;", "toLogString", "", "toLogString$camera_camera2_pipe", "OutputImageImpl", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX INFO: renamed from: from-AQuxepk, reason: not valid java name */
        public final OutputImage m1061fromAQuxepk(int streamId, int outputId, ImageWrapper image) {
            Intrinsics.checkNotNullParameter(image, "image");
            return image instanceof OutputImage ? (OutputImage) image : new _o(streamId, outputId, image, null);
        }

        /* JADX INFO: renamed from: androidx.camera.camera2.pipe.media.OutputImage$Companion$OutputImageImpl, reason: from toString */
        /* JADX INFO: compiled from: OutputImage.kt */
        @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0001R\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u00020\u0019X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u000bR\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\u000bR\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u00020-X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0012\u00100\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u0010\u000b¨\u00062"}, d2 = {"Landroidx/camera/camera2/pipe/media/OutputImage$Companion$OutputImageImpl;", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "Landroidx/camera/camera2/pipe/media/OutputImage;", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "image", "<init>", "(IILandroidx/camera/camera2/pipe/media/ImageWrapper;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStreamId-ptHMqGs", "()I", "I", "getOutputId-4LaLFng", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "close", "", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "format", "", "getFormat", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", ViewProps.HEIGHT, "getHeight", "planes", "", "Landroidx/camera/camera2/pipe/media/ImagePlane;", "getPlanes", "()Ljava/util/List;", "timestamp", "", "getTimestamp", "()J", ViewProps.WIDTH, "getWidth", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        private static final class _o implements ImageWrapper, OutputImage {
            private final ImageWrapper image;
            private final int outputId;
            private final int streamId;

            public /* synthetic */ _o(int i, int i2, ImageWrapper imageWrapper, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, i2, imageWrapper);
            }

            @Override // java.lang.AutoCloseable
            public void close() throws Exception {
                UByte$$ExternalSyntheticBackport0.m12761m((Object) this.image);
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public Rect getCropRect() {
                return this.image.getCropRect();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public int getFormat() {
                return this.image.getFormat();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public HardwareBuffer getHardwareBuffer() {
                return this.image.getHardwareBuffer();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public int getHeight() {
                return this.image.getHeight();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public List<ImagePlane> getPlanes() {
                return this.image.getPlanes();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public long getTimestamp() {
                return this.image.getTimestamp();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public int getWidth() {
                return this.image.getWidth();
            }

            @Override // androidx.camera.camera2.pipe.media.ImageWrapper
            public void setCropRect(Rect rect) {
                Intrinsics.checkNotNullParameter(rect, "<set-?>");
                this.image.setCropRect(rect);
            }

            private _o(int i, int i2, ImageWrapper image) {
                Intrinsics.checkNotNullParameter(image, "image");
                this.streamId = i;
                this.outputId = i2;
                this.image = image;
            }

            @Override // androidx.camera.camera2.pipe.media.OutputImage
            /* JADX INFO: renamed from: getStreamId-ptHMqGs, reason: from getter */
            public int getStreamId() {
                return this.streamId;
            }

            @Override // androidx.camera.camera2.pipe.media.OutputImage
            /* JADX INFO: renamed from: getOutputId-4LaLFng, reason: from getter */
            public int getOutputId() {
                return this.outputId;
            }

            @Override // androidx.camera.camera2.pipe.UnsafeWrapper
            public <T> T unwrapAs(KClass<T> type) {
                Intrinsics.checkNotNullParameter(type, "type");
                if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(OutputImage.class)) && !Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(ImageWrapper.class))) {
                    return (T) this.image.unwrapAs(type);
                }
                return (T) this;
            }

            public String toString() {
                Companion companion = Companion.$$INSTANCE;
                _o _oVar = this;
                return "OutputImage-s" + _oVar.getStreamId() + "_o" + _oVar.getOutputId() + "-t" + _oVar.getTimestamp();
            }
        }

        public final String toLogString$camera_camera2_pipe(OutputImage outputImage) {
            Intrinsics.checkNotNullParameter(outputImage, "<this>");
            return "OutputImage-s" + outputImage.getStreamId() + "_o" + outputImage.getOutputId() + "-t" + outputImage.getTimestamp();
        }
    }
}
