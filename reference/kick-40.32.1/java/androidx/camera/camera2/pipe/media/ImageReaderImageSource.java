package androidx.camera.camera2.pipe.media;

import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.atomicfu.AtomicRef;

/* JADX INFO: compiled from: ImageReaderImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\u00020\u0001:\u0003789B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010!\u001a\u0004\u0018\u0001H\"\"\b\b\u0000\u0010\"*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0%H\u0016¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J'\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b5J\b\u00106\u001a\u00020(H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0019\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006:"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageReaderImageSource;", "Landroidx/camera/camera2/pipe/media/ImageSource;", "imageReader", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", "maxImages", "", "<init>", "(Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;I)V", "state", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/media/ImageReaderImageSource$State;", "imageCount", "Lkotlinx/atomicfu/AtomicInt;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "<set-?>", "Landroidx/camera/camera2/pipe/media/ImageListener;", "imageListener", "getImageListener", "()Landroidx/camera/camera2/pipe/media/ImageListener;", "setImageListener", "(Landroidx/camera/camera2/pipe/media/ImageListener;)V", "imageListener$delegate", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/media/ExpectedOutputsListener;", "expectedOutputsListener", "getExpectedOutputsListener", "()Landroidx/camera/camera2/pipe/media/ExpectedOutputsListener;", "setExpectedOutputsListener", "(Landroidx/camera/camera2/pipe/media/ExpectedOutputsListener;)V", "expectedOutputsListener$delegate", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "close", "", "toString", "", "onImage", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "image", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "onImage-AQuxepk", "(IILandroidx/camera/camera2/pipe/media/ImageWrapper;)V", "closeAndDecrementImageCount", "closeAndDecrementImageCount$camera_camera2_pipe", "flushOrCloseIfEmpty", "Companion", "TrackedOutputImage", "State", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageReaderImageSource implements ImageSource {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int IMAGE_SOURCE_CAPACITY = 52;
    public static final int IMAGE_SOURCE_CAPACITY_MARGIN = 2;

    /* JADX INFO: renamed from: expectedOutputsListener$delegate, reason: from kotlin metadata */
    private final AtomicRef expectedOutputsListener;
    private final AtomicInt imageCount;

    /* JADX INFO: renamed from: imageListener$delegate, reason: from kotlin metadata */
    private final AtomicRef imageListener;
    private final ImageReaderWrapper imageReader;
    private final int maxImages;
    private final AtomicRef<State> state;
    private final Surface surface;

    /* JADX INFO: compiled from: ImageReaderImageSource.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageReaderImageSource$State;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "CLOSING", "CLOSED", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private enum State {
        ACTIVE,
        CLOSING,
        CLOSED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    public ImageReaderImageSource(ImageReaderWrapper imageReader, int i) {
        Intrinsics.checkNotNullParameter(imageReader, "imageReader");
        this.imageReader = imageReader;
        this.maxImages = i;
        this.state = AtomicFU.atomic(State.ACTIVE);
        this.imageCount = AtomicFU.atomic(0);
        this.surface = imageReader.getSurface();
        this.imageListener = AtomicFU.atomic((Object) null);
        this.expectedOutputsListener = AtomicFU.atomic((Object) null);
        imageReader.setOnImageListener(new ImageReaderWrapper.OnImageListener() { // from class: androidx.camera.camera2.pipe.media.ImageReaderImageSource.1
            @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper.OnImageListener
            /* JADX INFO: renamed from: onImage-AQuxepk, reason: not valid java name */
            public final void mo1057onImageAQuxepk(int i2, int i3, ImageWrapper image) throws Exception {
                Intrinsics.checkNotNullParameter(image, "image");
                ImageReaderImageSource.this.m1056onImageAQuxepk(i2, i3, image);
            }
        });
        imageReader.setOnExpectedOutputsListener(new ImageReaderWrapper.OnExpectedOutputsListener() { // from class: androidx.camera.camera2.pipe.media.ImageReaderImageSource$$ExternalSyntheticLambda0
            @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper.OnExpectedOutputsListener
            public final void onExpectedOutputs(long j, Set set) {
                ImageReaderImageSource._init_$lambda$0(this.f$0, j, set);
            }
        });
    }

    /* JADX INFO: compiled from: ImageReaderImageSource.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageReaderImageSource$Companion;", "", "<init>", "()V", "IMAGE_SOURCE_CAPACITY_MARGIN", "", "IMAGE_SOURCE_CAPACITY", "create", "Landroidx/camera/camera2/pipe/media/ImageSource;", "imageReader", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageSource create(ImageReaderWrapper imageReader) {
            Intrinsics.checkNotNullParameter(imageReader, "imageReader");
            return new ImageReaderImageSource(imageReader, imageReader.getCapacity() - 2);
        }
    }

    @Override // androidx.camera.camera2.pipe.media.ImageSource
    public Surface getSurface() {
        return this.surface;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageSource
    public ImageListener getImageListener() {
        return (ImageListener) this.imageListener.getValue();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageSource
    public void setImageListener(ImageListener imageListener) {
        this.imageListener.setValue(imageListener);
    }

    @Override // androidx.camera.camera2.pipe.media.ImageSource
    public ExpectedOutputsListener getExpectedOutputsListener() {
        return (ExpectedOutputsListener) this.expectedOutputsListener.getValue();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageSource
    public void setExpectedOutputsListener(ExpectedOutputsListener expectedOutputsListener) {
        this.expectedOutputsListener.setValue(expectedOutputsListener);
    }

    static final void _init_$lambda$0(ImageReaderImageSource imageReaderImageSource, long j, Set outputIds) {
        Intrinsics.checkNotNullParameter(outputIds, "outputIds");
        ExpectedOutputsListener expectedOutputsListener = imageReaderImageSource.getExpectedOutputsListener();
        if (expectedOutputsListener != null) {
            expectedOutputsListener.onExpectedOutputs(j, outputIds);
        }
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return (T) this.imageReader.unwrapAs(type);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        if (this.state.compareAndSet(State.ACTIVE, State.CLOSING)) {
            flushOrCloseIfEmpty();
        }
    }

    public String toString() {
        return "ImageSource(" + this.imageReader + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onImage-AQuxepk, reason: not valid java name */
    public final void m1056onImageAQuxepk(int streamId, int outputId, ImageWrapper image) throws Exception {
        int iIncrementAndGet = this.imageCount.incrementAndGet();
        ImageListener imageListener = getImageListener();
        if (imageListener == null) {
            closeAndDecrementImageCount$camera_camera2_pipe(image);
            return;
        }
        if (iIncrementAndGet > this.maxImages || this.state.getValue() != State.ACTIVE) {
            long timestamp = image.getTimestamp();
            closeAndDecrementImageCount$camera_camera2_pipe(image);
            imageListener.mo1009onImage2cgRUCs(streamId, outputId, timestamp, null);
            return;
        }
        imageListener.mo1009onImage2cgRUCs(streamId, outputId, image.getTimestamp(), new _o(this, image, streamId, outputId, null));
    }

    public final void closeAndDecrementImageCount$camera_camera2_pipe(ImageWrapper image) throws Exception {
        Intrinsics.checkNotNullParameter(image, "image");
        UByte$$ExternalSyntheticBackport0.m12761m((Object) image);
        this.imageCount.decrementAndGet();
        if (this.state.getValue() != State.ACTIVE) {
            flushOrCloseIfEmpty();
        }
    }

    private final void flushOrCloseIfEmpty() throws Exception {
        if (this.state.getValue() == State.CLOSED) {
            return;
        }
        if (this.imageCount.getValue() == 0) {
            if (this.state.compareAndSet(State.CLOSING, State.CLOSED)) {
                UByte$$ExternalSyntheticBackport0.m12761m((Object) this.imageReader);
                return;
            }
            return;
        }
        this.imageReader.flush();
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.media.ImageReaderImageSource$TrackedOutputImage, reason: from toString */
    /* JADX INFO: compiled from: ImageReaderImageSource.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019H\u0096\u0001¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\u00020\u001cX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u000bR\u0016\u0010$\u001a\u0004\u0018\u00010%8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0012\u0010(\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010\u000bR\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u000200X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u0010\u000b¨\u00065"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageReaderImageSource$TrackedOutputImage;", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "Landroidx/camera/camera2/pipe/media/OutputImage;", "image", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "<init>", "(Landroidx/camera/camera2/pipe/media/ImageReaderImageSource;Landroidx/camera/camera2/pipe/media/ImageWrapper;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStreamId-ptHMqGs", "()I", "I", "getOutputId-4LaLFng", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "close", "", "finalize", "toString", "", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "format", "", "getFormat", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", ViewProps.HEIGHT, "getHeight", "planes", "", "Landroidx/camera/camera2/pipe/media/ImagePlane;", "getPlanes", "()Ljava/util/List;", "timestamp", "", "getTimestamp", "()J", ViewProps.WIDTH, "getWidth", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class _o implements ImageWrapper, OutputImage {
        private final AtomicBoolean closed;
        private final ImageWrapper image;
        private final int outputId;
        private final int streamId;
        final /* synthetic */ ImageReaderImageSource this$0;

        public /* synthetic */ _o(ImageReaderImageSource imageReaderImageSource, ImageWrapper imageWrapper, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageReaderImageSource, imageWrapper, i, i2);
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

        @Override // androidx.camera.camera2.pipe.UnsafeWrapper
        public <T> T unwrapAs(KClass<T> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return (T) this.image.unwrapAs(type);
        }

        private _o(ImageReaderImageSource imageReaderImageSource, ImageWrapper image, int i, int i2) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.this$0 = imageReaderImageSource;
            this.image = image;
            this.streamId = i;
            this.outputId = i2;
            this.closed = AtomicFU.atomic(false);
        }

        @Override // androidx.camera.camera2.pipe.media.OutputImage
        /* JADX INFO: renamed from: getStreamId-ptHMqGs, reason: not valid java name and from getter */
        public int getStreamId() {
            return this.streamId;
        }

        @Override // androidx.camera.camera2.pipe.media.OutputImage
        /* JADX INFO: renamed from: getOutputId-4LaLFng, reason: not valid java name and from getter */
        public int getOutputId() {
            return this.outputId;
        }

        @Override // java.lang.AutoCloseable
        public void close() throws Exception {
            if (this.closed.compareAndSet(false, true)) {
                this.this$0.closeAndDecrementImageCount$camera_camera2_pipe(this.image);
            }
        }

        protected final void finalize() throws Exception {
            close();
        }

        public String toString() {
            OutputImage.Companion companion = OutputImage.INSTANCE;
            _o _oVar = this;
            return "OutputImage-s" + _oVar.getStreamId() + "_o" + _oVar.getOutputId() + "-t" + _oVar.getTimestamp();
        }
    }
}
