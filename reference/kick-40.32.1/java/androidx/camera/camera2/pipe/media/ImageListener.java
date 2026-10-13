package androidx.camera.camera2.pipe.media;

import kotlin.Metadata;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageListener;", "", "onImage", "", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "outputTimestamp", "", "image", "Landroidx/camera/camera2/pipe/media/ImageWrapper;", "onImage-2cgRUCs", "(IIJLandroidx/camera/camera2/pipe/media/ImageWrapper;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageListener {
    /* JADX INFO: renamed from: onImage-2cgRUCs */
    void mo1009onImage2cgRUCs(int streamId, int outputId, long outputTimestamp, ImageWrapper image);
}
