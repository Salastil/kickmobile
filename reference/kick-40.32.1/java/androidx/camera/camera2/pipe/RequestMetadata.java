package androidx.camera.camera2.pipe;

import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import java.util.Map;

/* JADX INFO: compiled from: Requests.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002J$\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H¦\u0002¢\u0006\u0002\u0010\u0007J)\u0010\b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\t\u001a\u0002H\u0004H&¢\u0006\u0002\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/RequestMetadata;", "Landroidx/camera/camera2/pipe/Metadata;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroid/hardware/camera2/CaptureRequest$Key;", "(Landroid/hardware/camera2/CaptureRequest$Key;)Ljava/lang/Object;", "getOrDefault", Constants.COLLATION_DEFAULT, "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)Ljava/lang/Object;", "template", "Landroidx/camera/camera2/pipe/RequestTemplate;", "getTemplate-fGx8uWA", "()I", "streams", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "getStreams", "()Ljava/util/Map;", "repeating", "", "getRepeating", "()Z", "request", "Landroidx/camera/camera2/pipe/Request;", "getRequest", "()Landroidx/camera/camera2/pipe/Request;", "requestNumber", "Landroidx/camera/camera2/pipe/RequestNumber;", "getRequestNumber-my6kx4g", "()J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RequestMetadata extends Metadata, UnsafeWrapper {
    <T> T get(CaptureRequest.Key<T> key);

    <T> T getOrDefault(CaptureRequest.Key<T> key, T t);

    boolean getRepeating();

    Request getRequest();

    /* JADX INFO: renamed from: getRequestNumber-my6kx4g */
    long mo105getRequestNumbermy6kx4g();

    Map<StreamId, Surface> getStreams();

    /* JADX INFO: renamed from: getTemplate-fGx8uWA */
    int mo106getTemplatefGx8uWA();
}
