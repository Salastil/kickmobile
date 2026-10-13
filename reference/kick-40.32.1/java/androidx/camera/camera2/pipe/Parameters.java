package androidx.camera.camera2.pipe;

import android.hardware.camera2.CaptureRequest;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Parameters.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H¦\u0002¢\u0006\u0002\u0010\u0006J$\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H¦\u0002¢\u0006\u0002\u0010\bJ0\u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\b\u0010\u000b\u001a\u0004\u0018\u0001H\u0003H¦\u0002¢\u0006\u0002\u0010\fJ0\u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00072\b\u0010\u000b\u001a\u0004\u0018\u0001H\u0003H¦\u0002¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\nH&J\u001c\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&J\u001c\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&J\u0014\u0010\u0014\u001a\u00020\u00132\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/Parameters;", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroid/hardware/camera2/CaptureRequest$Key;", "(Landroid/hardware/camera2/CaptureRequest$Key;)Ljava/lang/Object;", "Landroidx/camera/camera2/pipe/Metadata$Key;", "(Landroidx/camera/camera2/pipe/Metadata$Key;)Ljava/lang/Object;", "set", "", "value", "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V", "(Landroidx/camera/camera2/pipe/Metadata$Key;Ljava/lang/Object;)V", "setAll", "newParameters", "", "clear", "remove", "", "removeAll", UserMetadata.KEYDATA_FILENAME, "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Parameters {
    void clear();

    <T> T get(CaptureRequest.Key<T> key);

    <T> T get(Metadata.Key<T> key);

    <T> boolean remove(CaptureRequest.Key<T> key);

    <T> boolean remove(Metadata.Key<T> key);

    boolean removeAll(Set<?> keys);

    <T> void set(CaptureRequest.Key<T> key, T value);

    <T> void set(Metadata.Key<T> key, T value);

    void setAll(Map<Object, ? extends Object> newParameters);
}
