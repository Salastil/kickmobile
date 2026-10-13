package androidx.camera.camera2.pipe.media;

import android.view.Surface;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.UnsafeWrapper;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageReaderWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0002\u001a\u001bJ\b\u0010\u0018\u001a\u00020\u0019H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u0004\u0018\u00010\rX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "capacity", "", "getCapacity", "()I", "onImageListener", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;", "getOnImageListener", "()Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;", "setOnImageListener", "(Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;)V", "onExpectedOutputsListener", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;", "getOnExpectedOutputsListener", "()Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;", "setOnExpectedOutputsListener", "(Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;)V", "flush", "", "OnImageListener", "OnExpectedOutputsListener", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageReaderWrapper extends UnsafeWrapper, AutoCloseable {

    /* JADX INFO: compiled from: ImageReaderWrapper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;", "", "onExpectedOutputs", "", "timestamp", "", "outputIds", "", "Landroidx/camera/camera2/pipe/OutputId;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnExpectedOutputsListener {
        void onExpectedOutputs(long timestamp, Set<OutputId> outputIds);
    }

    /* JADX INFO: compiled from: ImageReaderWrapper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;", "", "onImage", "", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "image", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "onImage-AQuxepk", "(IILandroidx/camera/camera2/pipe/media/ImageWrapper;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnImageListener {
        /* JADX INFO: renamed from: onImage-AQuxepk */
        void mo1057onImageAQuxepk(int streamId, int outputId, ImageWrapper image);
    }

    void flush();

    int getCapacity();

    OnExpectedOutputsListener getOnExpectedOutputsListener();

    OnImageListener getOnImageListener();

    Surface getSurface();

    void setOnExpectedOutputsListener(OnExpectedOutputsListener onExpectedOutputsListener);

    void setOnImageListener(OnImageListener onImageListener);
}
