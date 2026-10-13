package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.GraphState;
import androidx.camera.camera2.pipe.Request;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: GraphProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH&J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H&J\u001c\u0010\u0012\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H&J\u001c\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0013\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H&J\u001c\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u0013\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H&J\u0016\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011H&J\b\u0010\u001b\u001a\u00020\u0016H&J\b\u0010\u001c\u001a\u00020\u0016H&J\b\u0010\u001d\u001a\u00020\u0016H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "", "graphState", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/camera/camera2/pipe/GraphState;", "getGraphState", "()Lkotlinx/coroutines/flow/StateFlow;", "repeatingRequest", "Landroidx/camera/camera2/pipe/Request;", "getRepeatingRequest", "()Landroidx/camera/camera2/pipe/Request;", "setRepeatingRequest", "(Landroidx/camera/camera2/pipe/Request;)V", "submit", "", "request", "requests", "", "trigger", "parameters", "", "updateGraphParameters", "", "update3AParameters", "updateRequestListeners", "listeners", "Landroidx/camera/camera2/pipe/Request$Listener;", "invalidate", "abort", "close", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GraphProcessor {
    void abort();

    void close();

    StateFlow<GraphState> getGraphState();

    Request getRepeatingRequest();

    void invalidate();

    void setRepeatingRequest(Request request);

    boolean submit(Request request);

    boolean submit(List<Request> requests);

    boolean trigger(Map<?, ? extends Object> parameters);

    void update3AParameters(Map<?, ? extends Object> parameters);

    void updateGraphParameters(Map<?, ? extends Object> parameters);

    void updateRequestListeners(List<? extends Request.Listener> listeners);
}
