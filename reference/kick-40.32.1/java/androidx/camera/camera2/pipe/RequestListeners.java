package androidx.camera.camera2.pipe;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;

/* JADX INFO: compiled from: RequestListeners.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/RequestListeners;", "", "add", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/camera2/pipe/Request$Listener;", "addAll", "listeners", "", "remove", "removeAll", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RequestListeners {
    void add(Request.Listener listener);

    void addAll(List<? extends Request.Listener> listeners);

    void remove(Request.Listener listener);

    void removeAll(List<? extends Request.Listener> listeners);
}
