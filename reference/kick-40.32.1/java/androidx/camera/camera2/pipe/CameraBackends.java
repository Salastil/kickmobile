package androidx.camera.camera2.pipe;

import com.facebook.hermes.intl.Constants;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CameraBackend.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u000e\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\bH¦\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraBackends;", "", Constants.COLLATION_DEFAULT, "Landroidx/camera/camera2/pipe/CameraBackend;", "getDefault", "()Landroidx/camera/camera2/pipe/CameraBackend;", "allIds", "", "Landroidx/camera/camera2/pipe/CameraBackendId;", "getAllIds", "()Ljava/util/Set;", "activeIds", "getActiveIds", "shutdown", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "backendId", "get-SG3A4s8", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraBackend;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraBackends {
    /* JADX INFO: renamed from: get-SG3A4s8, reason: not valid java name */
    CameraBackend mo242getSG3A4s8(String backendId);

    Set<CameraBackendId> getActiveIds();

    Set<CameraBackendId> getAllIds();

    CameraBackend getDefault();

    Object shutdown(Continuation<? super Unit> continuation);
}
