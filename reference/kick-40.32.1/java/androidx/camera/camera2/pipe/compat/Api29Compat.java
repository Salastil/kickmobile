package androidx.camera.camera2.pipe.compat;

import android.media.ImageReader;
import android.media.ImageWriter;
import android.view.Surface;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Api29Compat;", "", "<init>", "()V", "imageReaderNewInstance", "Landroid/media/ImageReader;", ViewProps.WIDTH, "", ViewProps.HEIGHT, "format", "capacity", "usage", "", "imageWriterNewInstance", "Landroid/media/ImageWriter;", "surface", "Landroid/view/Surface;", "maxImages", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Api29Compat {
    public static final Api29Compat INSTANCE = new Api29Compat();

    private Api29Compat() {
    }

    @JvmStatic
    public static final ImageReader imageReaderNewInstance(int width, int height, int format, int capacity, long usage) {
        ImageReader imageReaderNewInstance = ImageReader.newInstance(width, height, format, capacity, usage);
        Intrinsics.checkNotNullExpressionValue(imageReaderNewInstance, "newInstance(...)");
        return imageReaderNewInstance;
    }

    @JvmStatic
    public static final ImageWriter imageWriterNewInstance(Surface surface, int maxImages, int format) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        ImageWriter imageWriterNewInstance = ImageWriter.newInstance(surface, maxImages, format);
        Intrinsics.checkNotNullExpressionValue(imageWriterNewInstance, "newInstance(...)");
        return imageWriterNewInstance;
    }
}
