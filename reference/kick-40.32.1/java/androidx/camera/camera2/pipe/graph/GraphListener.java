package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.GraphState;
import kotlin.Metadata;

/* JADX INFO: compiled from: GraphListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphListener;", "", "onGraphStarting", "", "onGraphStarted", "requestProcessor", "Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;", "onGraphStopping", "onGraphStopped", "onGraphModified", "onGraphError", "graphStateError", "Landroidx/camera/camera2/pipe/GraphState$GraphStateError;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GraphListener {
    void onGraphError(GraphState.GraphStateError graphStateError);

    void onGraphModified(GraphRequestProcessor requestProcessor);

    void onGraphStarted(GraphRequestProcessor requestProcessor);

    default void onGraphStarting() {
    }

    void onGraphStopped(GraphRequestProcessor requestProcessor);

    default void onGraphStopping() {
    }

    /* JADX INFO: compiled from: GraphListener.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onGraphStarting(GraphListener graphListener) {
            GraphListener.super.onGraphStarting();
        }

        @Deprecated
        public static void onGraphStopping(GraphListener graphListener) {
            GraphListener.super.onGraphStopping();
        }
    }
}
