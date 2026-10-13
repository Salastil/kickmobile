package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.GraphState;
import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.camera.camera2.pipe.graph.GraphRequestProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Camera2DeviceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/compat/NoOpGraphListener;", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "<init>", "()V", "onGraphStarted", "", "requestProcessor", "Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;", "onGraphStopped", "onGraphModified", "onGraphError", "graphStateError", "Landroidx/camera/camera2/pipe/GraphState$GraphStateError;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoOpGraphListener implements GraphListener {
    public static final NoOpGraphListener INSTANCE = new NoOpGraphListener();

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphError(GraphState.GraphStateError graphStateError) {
        Intrinsics.checkNotNullParameter(graphStateError, "graphStateError");
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphModified(GraphRequestProcessor requestProcessor) {
        Intrinsics.checkNotNullParameter(requestProcessor, "requestProcessor");
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphStarted(GraphRequestProcessor requestProcessor) {
        Intrinsics.checkNotNullParameter(requestProcessor, "requestProcessor");
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphStopped(GraphRequestProcessor requestProcessor) {
    }

    private NoOpGraphListener() {
    }
}
