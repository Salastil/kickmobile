package androidx.camera.camera2.pipe.media;

import androidx.camera.camera2.pipe.UnsafeWrapper;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageWriterWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0002\u0013\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageWriterWrapper;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "format", "", "getFormat", "()I", "maxImages", "getMaxImages", "queueInputImage", "", "image", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "dequeueInputImage", "setOnImageReleasedListener", "", "onImageReleasedListener", "Landroidx/camera/camera2/pipe/media/ImageWriterWrapper$OnImageReleasedListener;", "OnImageReleasedListener", "Builder", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageWriterWrapper extends UnsafeWrapper, AutoCloseable {

    /* JADX INFO: compiled from: ImageWriterWrapper.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageWriterWrapper$Builder;", "", "build", "Landroidx/camera/camera2/pipe/media/ImageWriterWrapper;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Builder {
        ImageWriterWrapper build();
    }

    /* JADX INFO: compiled from: ImageWriterWrapper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageWriterWrapper$OnImageReleasedListener;", "", "onImageReleased", "", "inputStreamId", "Landroidx/camera/camera2/pipe/InputStreamId;", "onImageReleased-I45lehc", "(I)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnImageReleasedListener {
        /* JADX INFO: renamed from: onImageReleased-I45lehc, reason: not valid java name */
        void m1060onImageReleasedI45lehc(int inputStreamId);
    }

    ImageWrapper dequeueInputImage();

    int getFormat();

    int getMaxImages();

    boolean queueInputImage(ImageWrapper image);

    void setOnImageReleasedListener(OnImageReleasedListener onImageReleasedListener);
}
