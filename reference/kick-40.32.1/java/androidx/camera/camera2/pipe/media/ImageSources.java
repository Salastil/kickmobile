package androidx.camera.camera2.pipe.media;

import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.ImageSourceConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ImageSources;", "", "createImageSource", "Landroidx/camera/camera2/pipe/media/ImageSource;", "cameraStream", "Landroidx/camera/camera2/pipe/CameraStream;", "imageSourceConfig", "Landroidx/camera/camera2/pipe/ImageSourceConfig;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageSources {
    ImageSource createImageSource(CameraStream cameraStream, ImageSourceConfig imageSourceConfig);
}
