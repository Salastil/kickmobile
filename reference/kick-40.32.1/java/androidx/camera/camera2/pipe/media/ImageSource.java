package androidx.camera.camera2.pipe.media;

import android.view.Surface;
import androidx.camera.camera2.pipe.UnsafeWrapper;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageSource;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "imageListener", "Landroidx/camera/camera2/pipe/media/ImageListener;", "getImageListener", "()Landroidx/camera/camera2/pipe/media/ImageListener;", "setImageListener", "(Landroidx/camera/camera2/pipe/media/ImageListener;)V", "expectedOutputsListener", "Landroidx/camera/camera2/pipe/media/ExpectedOutputsListener;", "getExpectedOutputsListener", "()Landroidx/camera/camera2/pipe/media/ExpectedOutputsListener;", "setExpectedOutputsListener", "(Landroidx/camera/camera2/pipe/media/ExpectedOutputsListener;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageSource extends UnsafeWrapper, AutoCloseable {
    ExpectedOutputsListener getExpectedOutputsListener();

    ImageListener getImageListener();

    Surface getSurface();

    void setExpectedOutputsListener(ExpectedOutputsListener expectedOutputsListener);

    void setImageListener(ImageListener imageListener);
}
