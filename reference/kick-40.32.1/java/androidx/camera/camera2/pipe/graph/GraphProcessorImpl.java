package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.GraphState;
import androidx.camera.camera2.pipe.GraphStateListener;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.compat.Camera2Quirks;
import androidx.camera.camera2.pipe.compat.CameraPipeKeys;
import androidx.camera.camera2.pipe.config.CameraGraphScope;
import androidx.camera.camera2.pipe.config.ForCameraGraph;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: GraphProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BF\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0013\b\u0001\u0010\u000b\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020&H\u0016J\u0012\u0010+\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010,\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001fH\u0016J\u0016\u00100\u001a\u0002012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001f0\fH\u0016J\u001c\u00104\u001a\u0002012\u0012\u00105\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010706H\u0016J\u001c\u00108\u001a\u00020&2\u0012\u00105\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010706H\u0016J\u001c\u00109\u001a\u00020&2\u0012\u00105\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010706H\u0016J\u0016\u0010:\u001a\u00020&2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010<\u001a\u00020&H\u0016J\b\u0010=\u001a\u00020&H\u0016J\b\u0010>\u001a\u00020&H\u0016J\b\u0010?\u001a\u00020@H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006A"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphProcessorImpl;", "Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "cameraGraphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "cameraGraphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "graphListener3A", "Landroidx/camera/camera2/pipe/graph/Listener3A;", "graphListeners", "", "Landroidx/camera/camera2/pipe/Request$Listener;", "Lkotlin/jvm/JvmSuppressWildcards;", "camera2Quirks", "Landroidx/camera/camera2/pipe/compat/Camera2Quirks;", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/CameraGraphId;Landroidx/camera/camera2/pipe/CameraGraph$Config;Landroidx/camera/camera2/pipe/graph/Listener3A;Ljava/util/List;Landroidx/camera/camera2/pipe/compat/Camera2Quirks;)V", "graphLoop", "Landroidx/camera/camera2/pipe/graph/GraphLoop;", "externalStateGraphListeners", "Landroidx/camera/camera2/pipe/GraphStateListener;", "_graphState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/camera/camera2/pipe/GraphState;", "graphState", "Lkotlinx/coroutines/flow/StateFlow;", "getGraphState", "()Lkotlinx/coroutines/flow/StateFlow;", "value", "Landroidx/camera/camera2/pipe/Request;", "repeatingRequest", "getRepeatingRequest", "()Landroidx/camera/camera2/pipe/Request;", "setRepeatingRequest", "(Landroidx/camera/camera2/pipe/Request;)V", "onGraphStarting", "", "onGraphStarted", "requestProcessor", "Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;", "onGraphStopping", "onGraphStopped", "onGraphModified", "onGraphError", "graphStateError", "Landroidx/camera/camera2/pipe/GraphState$GraphStateError;", "submit", "", "request", "requests", "trigger", "parameters", "", "", "updateGraphParameters", "update3AParameters", "updateRequestListeners", "listeners", "invalidate", "abort", "close", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GraphProcessorImpl implements GraphProcessor, GraphListener {
    private final MutableStateFlow<GraphState> _graphState;
    private final CameraGraph.Config cameraGraphConfig;
    private final CameraGraphId cameraGraphId;
    private final List<GraphStateListener> externalStateGraphListeners;
    private final GraphLoop graphLoop;

    @Inject
    public GraphProcessorImpl(Threads threads, CameraGraphId cameraGraphId, CameraGraph.Config cameraGraphConfig, Listener3A graphListener3A, @ForCameraGraph List<Request.Listener> graphListeners, Camera2Quirks camera2Quirks) {
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(cameraGraphId, "cameraGraphId");
        Intrinsics.checkNotNullParameter(cameraGraphConfig, "cameraGraphConfig");
        Intrinsics.checkNotNullParameter(graphListener3A, "graphListener3A");
        Intrinsics.checkNotNullParameter(graphListeners, "graphListeners");
        Intrinsics.checkNotNullParameter(camera2Quirks, "camera2Quirks");
        this.cameraGraphId = cameraGraphId;
        this.cameraGraphConfig = cameraGraphConfig;
        this.externalStateGraphListeners = cameraGraphConfig.getGraphStateListeners();
        Map<?, Object> defaultParameters = cameraGraphConfig.getDefaultParameters();
        Map<?, Object> requiredParameters = cameraGraphConfig.getRequiredParameters();
        if ((Intrinsics.areEqual(defaultParameters.get(CameraPipeKeys.INSTANCE.getIgnore3ARequiredParameters()), (Object) true) || Intrinsics.areEqual(requiredParameters.get(CameraPipeKeys.INSTANCE.getIgnore3ARequiredParameters()), (Object) true)) && Log.INSTANCE.getINFO_LOGGABLE()) {
            android.util.Log.i(Log.TAG, CameraPipeKeys.INSTANCE.getIgnore3ARequiredParameters() + " is set to true, ignoring GraphState3A parameters.");
        }
        int repeatingRequestFrameCountForCapture$camera_camera2_pipe = camera2Quirks.getRepeatingRequestFrameCountForCapture$camera_camera2_pipe(cameraGraphConfig.getFlags());
        CaptureLimiter captureLimiter = repeatingRequestFrameCountForCapture$camera_camera2_pipe != 0 ? new CaptureLimiter(repeatingRequestFrameCountForCapture$camera_camera2_pipe) : null;
        GraphLoop graphLoop = new GraphLoop(cameraGraphId, defaultParameters, requiredParameters, CollectionsKt.plus((Collection) graphListeners, (Iterable) CollectionsKt.listOfNotNull(captureLimiter)), CollectionsKt.listOfNotNull(graphListener3A, captureLimiter), threads.getCameraPipeScope(), threads.getLightweightDispatcher());
        this.graphLoop = graphLoop;
        if (captureLimiter != null) {
            captureLimiter.setGraphLoop(graphLoop);
        }
        this._graphState = StateFlowKt.MutableStateFlow(GraphState.GraphStateStopped.INSTANCE);
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public StateFlow<GraphState> getGraphState() {
        return this._graphState;
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public Request getRepeatingRequest() {
        return this.graphLoop.getRepeatingRequest();
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public void setRepeatingRequest(Request request) {
        this.graphLoop.setRepeatingRequest(request);
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphStarting() {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " onGraphStarting");
        }
        this._graphState.setValue(GraphState.GraphStateStarting.INSTANCE);
        Iterator<GraphStateListener> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().onGraphStarting();
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphStarted(GraphRequestProcessor requestProcessor) {
        Intrinsics.checkNotNullParameter(requestProcessor, "requestProcessor");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " onGraphStarted");
        }
        this._graphState.setValue(GraphState.GraphStateStarted.INSTANCE);
        this.graphLoop.setRequestProcessor(requestProcessor);
        Iterator<GraphStateListener> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().onGraphStarted();
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphStopping() {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " onGraphStopping");
        }
        this._graphState.setValue(GraphState.GraphStateStopping.INSTANCE);
        this.graphLoop.setRequestProcessor(null);
        Iterator<GraphStateListener> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().onGraphStopping();
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphStopped(GraphRequestProcessor requestProcessor) {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " onGraphStopped");
        }
        this._graphState.setValue(GraphState.GraphStateStopped.INSTANCE);
        this.graphLoop.setRequestProcessor(null);
        Iterator<GraphStateListener> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().onGraphStopped();
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphModified(GraphRequestProcessor requestProcessor) {
        Intrinsics.checkNotNullParameter(requestProcessor, "requestProcessor");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " onGraphModified");
        }
        this.graphLoop.invalidate();
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphListener
    public void onGraphError(GraphState.GraphStateError graphStateError) {
        GraphState value;
        GraphState.GraphStateStopped graphStateStopped;
        Intrinsics.checkNotNullParameter(graphStateError, "graphStateError");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " onGraphError(" + graphStateError + ')');
        }
        MutableStateFlow<GraphState> mutableStateFlow = this._graphState;
        do {
            value = mutableStateFlow.getValue();
            GraphState graphState = value;
            if ((graphState instanceof GraphState.GraphStateStopping) || (graphState instanceof GraphState.GraphStateStopped)) {
                graphStateStopped = GraphState.GraphStateStopped.INSTANCE;
            } else {
                graphStateStopped = graphStateError;
            }
        } while (!mutableStateFlow.compareAndSet(value, graphStateStopped));
        Iterator<GraphStateListener> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().onGraphError(graphStateError);
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public boolean submit(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return submit(CollectionsKt.listOf(request));
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public boolean submit(List<Request> requests) {
        Object next;
        Intrinsics.checkNotNullParameter(requests, "requests");
        Iterator<T> it = requests.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Request) next).getInputRequest() == null);
        Request request = (Request) next;
        if (request == null || this.cameraGraphConfig.getInput() != null) {
            return this.graphLoop.submit(requests);
        }
        throw new IllegalStateException(("Cannot submit " + request + " with input request " + request.getInputRequest() + " to " + this + " because CameraGraph was not configured to support reprocessing").toString());
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public boolean trigger(Map<?, ? extends Object> parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.graphLoop.trigger(parameters);
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public void updateGraphParameters(Map<?, ? extends Object> parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.graphLoop.setGraphParameters(parameters);
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public void update3AParameters(Map<?, ? extends Object> parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.graphLoop.setGraph3AParameters(parameters);
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public void updateRequestListeners(List<? extends Request.Listener> listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.graphLoop.setRequestListeners(listeners);
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public void invalidate() {
        this.graphLoop.invalidate();
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public void abort() {
        this.graphLoop.abort();
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphProcessor
    public void close() {
        this.graphLoop.close();
    }

    public String toString() {
        return "GraphProcessor(cameraGraph: " + this.cameraGraphId + ')';
    }
}
