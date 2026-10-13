package androidx.camera.camera2.pipe;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.util.Size;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Set;

/* JADX INFO: compiled from: CameraExtensionMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002J$\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H¦\u0002¢\u0006\u0002\u0010\u0007J)\u0010\b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\t\u001a\u0002H\u0004H&¢\u0006\u0002\u0010\nJ\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00192\u0006\u0010$\u001a\u00020\u0010H&J\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00192\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&H&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\u00192\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0010H&R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0012\u0010\u0017\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraExtensionMetadata;", "Landroidx/camera/camera2/pipe/Metadata;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;", "getOrDefault", Constants.COLLATION_DEFAULT, "(Landroid/hardware/camera2/CameraCharacteristics$Key;Ljava/lang/Object;)Ljava/lang/Object;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "cameraExtension", "", "getCameraExtension", "()I", "isRedacted", "", "()Z", "isPostviewSupported", "isCaptureProgressSupported", UserMetadata.KEYDATA_FILENAME, "", "getKeys", "()Ljava/util/Set;", "requestKeys", "Landroid/hardware/camera2/CaptureRequest$Key;", "getRequestKeys", "resultKeys", "Landroid/hardware/camera2/CaptureResult$Key;", "getResultKeys", "getOutputSizes", "Landroid/util/Size;", "imageFormat", "klass", "Ljava/lang/Class;", "getPostviewSizes", "captureSize", "format", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraExtensionMetadata extends Metadata, UnsafeWrapper {
    <T> T get(CameraCharacteristics.Key<T> key);

    /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: not valid java name */
    String mo376getCameraDz_R5H8();

    int getCameraExtension();

    Set<CameraCharacteristics.Key<?>> getKeys();

    <T> T getOrDefault(CameraCharacteristics.Key<T> key, T t);

    Set<Size> getOutputSizes(int imageFormat);

    Set<Size> getOutputSizes(Class<?> klass);

    Set<Size> getPostviewSizes(Size captureSize, int format);

    Set<CaptureRequest.Key<?>> getRequestKeys();

    Set<CaptureResult.Key<?>> getResultKeys();

    boolean isCaptureProgressSupported();

    boolean isPostviewSupported();

    boolean isRedacted();
}
