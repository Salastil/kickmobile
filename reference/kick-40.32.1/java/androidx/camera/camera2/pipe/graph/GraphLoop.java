package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestsKt;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.ProcessingQueue;
import androidx.exifinterface.media.ExifInterface;
import androidx.window.core.layout.WindowSizeClass;
import java.io.Closeable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: GraphLoop.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 r2\u00020\u0001:\u0002qrBc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u001dJ\u0014\u0010@\u001a\u00020\u00192\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001d0\tJ\u001a\u0010C\u001a\u00020\u00192\u0012\u0010D\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020FJ\b\u0010H\u001a\u00020FH\u0016J\u001c\u0010O\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160QH\u0082@¢\u0006\u0002\u0010RJ\u0016\u0010S\u001a\u00020T2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160QH\u0002J0\u0010U\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160Q2\u0006\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020\u0019H\u0002J&\u0010Z\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160Q2\u0006\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020[H\u0002J(\u0010\\\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160Q2\u0006\u0010V\u001a\u00020T2\b\b\u0002\u0010]\u001a\u00020\u0019H\u0002J&\u0010^\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160Q2\u0006\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020_H\u0002J&\u0010`\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160Q2\u0006\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020aH\u0002J,\u0010b\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160Q2\u0006\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020cH\u0082@¢\u0006\u0002\u0010dJ\u001e\u0010e\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160Q2\u0006\u0010V\u001a\u00020TH\u0002J\u001e\u0010f\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160Q2\u0006\u0010V\u001a\u00020TH\u0002J\u001c\u0010g\u001a\u00020F2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160QH\u0082@¢\u0006\u0002\u0010RJ\b\u0010h\u001a\u00020\u0019H\u0002J\u0016\u0010i\u001a\u00020F2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001d0\tH\u0002J\u0016\u0010j\u001a\u00020F2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00160\tH\u0002J4\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00192\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001d0\t2\u0014\b\u0002\u0010n\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002J\b\u0010o\u001a\u00020pH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R(\u0010\"\u001a\u0004\u0018\u00010\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010'\u001a\u0004\u0018\u00010\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R<\u0010,\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010!\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R<\u00101\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010!\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R0\u00104\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010;\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0010\u0010I\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphLoop;", "Ljava/io/Closeable;", "cameraGraphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "defaultParameters", "", "", "requiredParameters", "requiredListeners", "", "Landroidx/camera/camera2/pipe/Request$Listener;", "listeners", "Landroidx/camera/camera2/pipe/graph/GraphLoop$Listener;", "shutdownScope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraphId;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "graphLoopScope", "processingQueue", "Landroidx/camera/camera2/pipe/core/ProcessingQueue;", "Landroidx/camera/camera2/pipe/graph/GraphCommand;", "lock", "closed", "", "_requestProcessor", "Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;", "_repeatingRequest", "Landroidx/camera/camera2/pipe/Request;", "_graphParameters", "_graph3AParameters", "_requestListeners", "value", "requestProcessor", "getRequestProcessor", "()Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;", "setRequestProcessor", "(Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;)V", "repeatingRequest", "getRepeatingRequest", "()Landroidx/camera/camera2/pipe/Request;", "setRepeatingRequest", "(Landroidx/camera/camera2/pipe/Request;)V", "graphParameters", "getGraphParameters", "()Ljava/util/Map;", "setGraphParameters", "(Ljava/util/Map;)V", "graph3AParameters", "getGraph3AParameters", "setGraph3AParameters", "requestListeners", "getRequestListeners", "()Ljava/util/List;", "setRequestListeners", "(Ljava/util/List;)V", "_captureProcessingEnabled", "Lkotlinx/atomicfu/AtomicBoolean;", "captureProcessingEnabled", "getCaptureProcessingEnabled", "()Z", "setCaptureProcessingEnabled", "(Z)V", "submit", "request", "requests", "trigger", "parameters", "abort", "", "invalidate", "close", "currentRepeatingRequest", "currentGraphParameters", "currentGraph3AParameters", "currentRequiredParameters", "currentRequestListeners", "currentRequestProcessor", "process", "commands", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectGraphCommand", "", "processCapture", "idx", "command", "Landroidx/camera/camera2/pipe/graph/GraphCommand$Capture;", "repeatAllowed", "processTrigger", "Landroidx/camera/camera2/pipe/graph/GraphCommand$Trigger;", "processRepeat", "captureAllowed", "processParameters", "Landroidx/camera/camera2/pipe/graph/GraphCommand$Parameters;", "processListeners", "Landroidx/camera/camera2/pipe/graph/GraphCommand$Listeners;", "processRequestProcessor", "Landroidx/camera/camera2/pipe/graph/GraphCommand$RequestProcessor;", "(Ljava/util/List;ILandroidx/camera/camera2/pipe/graph/GraphCommand$RequestProcessor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processStop", "processAbort", "processShutdown", "reissueRepeatingRequest", "abortRequests", "finalizeUnprocessedCommands", "unprocessedCommands", "buildAndSubmit", "isRepeating", "oneTimeRequiredParameters", "toString", "", "Listener", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GraphLoop implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AtomicBoolean _captureProcessingEnabled;
    private Map<?, ? extends Object> _graph3AParameters;
    private Map<?, ? extends Object> _graphParameters;
    private Request _repeatingRequest;
    private List<? extends Request.Listener> _requestListeners;
    private GraphRequestProcessor _requestProcessor;
    private final CameraGraphId cameraGraphId;
    private volatile boolean closed;
    private Map<?, ? extends Object> currentGraph3AParameters;
    private Map<?, ? extends Object> currentGraphParameters;
    private Request currentRepeatingRequest;
    private List<? extends Request.Listener> currentRequestListeners;
    private GraphRequestProcessor currentRequestProcessor;
    private Map<?, ? extends Object> currentRequiredParameters;
    private final Map<?, Object> defaultParameters;
    private final CoroutineScope graphLoopScope;
    private final List<Listener> listeners;
    private final Object lock;
    private final ProcessingQueue<GraphCommand> processingQueue;
    private final List<Request.Listener> requiredListeners;
    private final Map<?, Object> requiredParameters;
    private final CoroutineScope shutdownScope;

    /* JADX INFO: compiled from: GraphLoop.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphLoop$Listener;", "", "onStopRepeating", "", "onGraphStopped", "onGraphShutdown", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Listener {
        void onGraphShutdown();

        void onGraphStopped();

        void onStopRepeating();
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.GraphLoop$processRequestProcessor$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GraphLoop.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.GraphLoop", f = "GraphLoop.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2}, l = {479, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, 488}, m = "processRequestProcessor", n = {"commands", "command", "commandsRemoved", "$this$removeUpTo$iv", "it", "a$iv", "b$iv", "commands", "command", "commandsRemoved", "$this$removeUpTo$iv", "a$iv", "b$iv", "commands", "command", "commandsRemoved"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C02201 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C02201(Continuation<? super C02201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GraphLoop.this.processRequestProcessor(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.GraphLoop$processShutdown$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GraphLoop.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.GraphLoop", f = "GraphLoop.kt", i = {0, 1, 1, 1, 2, 2}, l = {566, 572, 573}, m = "processShutdown", n = {"commands", "commands", "command", "idx", "commands", "idx"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "I$0"}, v = 1)
    static final class C02211 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02211(Continuation<? super C02211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GraphLoop.this.processShutdown(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GraphLoop(CameraGraphId cameraGraphId, Map<?, ? extends Object> defaultParameters, Map<?, ? extends Object> requiredParameters, List<? extends Request.Listener> requiredListeners, List<? extends Listener> listeners, CoroutineScope shutdownScope, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(cameraGraphId, "cameraGraphId");
        Intrinsics.checkNotNullParameter(defaultParameters, "defaultParameters");
        Intrinsics.checkNotNullParameter(requiredParameters, "requiredParameters");
        Intrinsics.checkNotNullParameter(requiredListeners, "requiredListeners");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        Intrinsics.checkNotNullParameter(shutdownScope, "shutdownScope");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.cameraGraphId = cameraGraphId;
        this.defaultParameters = defaultParameters;
        this.requiredParameters = requiredParameters;
        this.requiredListeners = requiredListeners;
        this.listeners = listeners;
        this.shutdownScope = shutdownScope;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(new CoroutineName("CXCP-GraphLoop")));
        this.graphLoopScope = CoroutineScope;
        this.processingQueue = ProcessingQueue.INSTANCE.processIn(new ProcessingQueue(0, new GraphLoop$processingQueue$1(this), new GraphLoop$processingQueue$2(this), 1, null), CoroutineScope);
        this.lock = new Object();
        this._graphParameters = MapsKt.emptyMap();
        this._graph3AParameters = MapsKt.emptyMap();
        this._requestListeners = CollectionsKt.emptyList();
        this._captureProcessingEnabled = AtomicFU.atomic(true);
        this.currentGraphParameters = MapsKt.emptyMap();
        this.currentGraph3AParameters = MapsKt.emptyMap();
        this.currentRequiredParameters = requiredParameters;
        this.currentRequestListeners = requiredListeners;
    }

    public final GraphRequestProcessor getRequestProcessor() {
        GraphRequestProcessor graphRequestProcessor;
        synchronized (this.lock) {
            graphRequestProcessor = this._requestProcessor;
        }
        return graphRequestProcessor;
    }

    public final void setRequestProcessor(GraphRequestProcessor graphRequestProcessor) {
        synchronized (this.lock) {
            GraphRequestProcessor graphRequestProcessor2 = this._requestProcessor;
            this._requestProcessor = graphRequestProcessor;
            if (this.closed) {
                this._requestProcessor = null;
                if (graphRequestProcessor != null) {
                    BuildersKt__Builders_commonKt.launch$default(this.shutdownScope, null, null, new GraphLoop$requestProcessor$2$1(graphRequestProcessor, null), 3, null);
                }
                return;
            }
            if (graphRequestProcessor2 != graphRequestProcessor) {
                this.processingQueue.tryEmit(new GraphCommand.RequestProcessor(graphRequestProcessor2, graphRequestProcessor));
            }
            Unit unit = Unit.INSTANCE;
            if (graphRequestProcessor == null) {
                int size = this.listeners.size();
                for (int i = 0; i < size; i++) {
                    this.listeners.get(i).onGraphStopped();
                }
            }
        }
    }

    public final Request getRepeatingRequest() {
        Request request;
        synchronized (this.lock) {
            request = this._repeatingRequest;
        }
        return request;
    }

    public final void setRepeatingRequest(Request request) {
        synchronized (this.lock) {
            Request request2 = this._repeatingRequest;
            this._repeatingRequest = request;
            if (request2 != null || request != null) {
                ProcessingQueue<GraphCommand> processingQueue = this.processingQueue;
                if (request != null) {
                    processingQueue.tryEmit(new GraphCommand.Repeat(request));
                } else {
                    processingQueue.tryEmit(GraphCommand.Stop.INSTANCE);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (request == null) {
            int size = this.listeners.size();
            for (int i = 0; i < size; i++) {
                this.listeners.get(i).onStopRepeating();
            }
        }
    }

    public final Map<?, Object> getGraphParameters() {
        Map<?, ? extends Object> map;
        synchronized (this.lock) {
            map = this._graphParameters;
        }
        return map;
    }

    public final void setGraphParameters(Map<?, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            this._graphParameters = value;
            this.processingQueue.tryEmit(new GraphCommand.Parameters(value, this._graph3AParameters));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Map<?, Object> getGraph3AParameters() {
        Map<?, ? extends Object> map;
        synchronized (this.lock) {
            map = this._graph3AParameters;
        }
        return map;
    }

    public final void setGraph3AParameters(Map<?, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            this._graph3AParameters = value;
            this.processingQueue.tryEmit(new GraphCommand.Parameters(this._graphParameters, value));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final List<Request.Listener> getRequestListeners() {
        List list;
        synchronized (this.lock) {
            list = this._requestListeners;
        }
        return list;
    }

    public final void setRequestListeners(List<? extends Request.Listener> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            this._requestListeners = value;
            this.processingQueue.tryEmit(new GraphCommand.Listeners(this._requestListeners));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean getCaptureProcessingEnabled() {
        return this._captureProcessingEnabled.getValue();
    }

    public final void setCaptureProcessingEnabled(boolean z) {
        this._captureProcessingEnabled.setValue(z);
        if (z) {
            invalidate();
        }
    }

    public final boolean submit(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return submit(CollectionsKt.listOf(request));
    }

    public final boolean submit(List<Request> requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        if (this.processingQueue.tryEmit(new GraphCommand.Capture(requests))) {
            return true;
        }
        abortRequests(requests);
        return false;
    }

    public final boolean trigger(Map<?, ? extends Object> parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        if (getRepeatingRequest() == null) {
            throw new IllegalStateException("Cannot submit parameters without an active repeating request!".toString());
        }
        return this.processingQueue.tryEmit(new GraphCommand.Trigger(parameters));
    }

    public final void abort() {
        this.processingQueue.tryEmit(GraphCommand.Abort.INSTANCE);
    }

    public final void invalidate() {
        this.processingQueue.tryEmit(GraphCommand.Invalidate.INSTANCE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            GraphRequestProcessor graphRequestProcessor = this._requestProcessor;
            if (graphRequestProcessor != null) {
                BuildersKt__Builders_commonKt.launch$default(this.shutdownScope, null, null, new GraphLoop$close$1$1$1(graphRequestProcessor, null), 3, null);
            }
            this._requestProcessor = null;
            this.processingQueue.tryEmit(GraphCommand.Shutdown.INSTANCE);
            int size = this.listeners.size();
            for (int i = 0; i < size; i++) {
                this.listeners.get(i).onGraphShutdown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object process(List<GraphCommand> list, Continuation<? super Unit> continuation) {
        int iSelectGraphCommand = selectGraphCommand(list);
        GraphCommand graphCommand = list.get(iSelectGraphCommand);
        if (Intrinsics.areEqual(graphCommand, GraphCommand.Invalidate.INSTANCE)) {
            list.remove(iSelectGraphCommand);
        } else {
            if (Intrinsics.areEqual(graphCommand, GraphCommand.Shutdown.INSTANCE)) {
                Object objProcessShutdown = processShutdown(list, continuation);
                return objProcessShutdown == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessShutdown : Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(graphCommand, GraphCommand.Abort.INSTANCE)) {
                processAbort(list, iSelectGraphCommand);
            } else if (Intrinsics.areEqual(graphCommand, GraphCommand.Stop.INSTANCE)) {
                processStop(list, iSelectGraphCommand);
            } else {
                if (graphCommand instanceof GraphCommand.RequestProcessor) {
                    Object objProcessRequestProcessor = processRequestProcessor(list, iSelectGraphCommand, (GraphCommand.RequestProcessor) graphCommand, continuation);
                    return objProcessRequestProcessor == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessRequestProcessor : Unit.INSTANCE;
                }
                if (graphCommand instanceof GraphCommand.Capture) {
                    processCapture$default(this, list, iSelectGraphCommand, (GraphCommand.Capture) graphCommand, false, 8, null);
                } else if (graphCommand instanceof GraphCommand.Trigger) {
                    processTrigger(list, iSelectGraphCommand, (GraphCommand.Trigger) graphCommand);
                } else if (graphCommand instanceof GraphCommand.Parameters) {
                    processParameters(list, iSelectGraphCommand, (GraphCommand.Parameters) graphCommand);
                } else if (graphCommand instanceof GraphCommand.Listeners) {
                    processListeners(list, iSelectGraphCommand, (GraphCommand.Listeners) graphCommand);
                } else {
                    if (!(graphCommand instanceof GraphCommand.Repeat)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    processRepeat$default(this, list, iSelectGraphCommand, false, 4, null);
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final int selectGraphCommand(List<GraphCommand> commands) {
        if (commands.size() == 1) {
            return 0;
        }
        List<GraphCommand> list = commands;
        int size = list.size() - 1;
        int i = -1;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                GraphCommand graphCommand = commands.get(size);
                if (Intrinsics.areEqual(graphCommand, GraphCommand.Abort.INSTANCE) || Intrinsics.areEqual(graphCommand, GraphCommand.Invalidate.INSTANCE) || Intrinsics.areEqual(graphCommand, GraphCommand.Stop.INSTANCE) || Intrinsics.areEqual(graphCommand, GraphCommand.Shutdown.INSTANCE)) {
                    return size;
                }
                if ((graphCommand instanceof GraphCommand.RequestProcessor) && i < 0) {
                    i = size;
                }
                if (i2 < 0) {
                    break;
                }
                size = i2;
            }
        }
        if (i >= 0) {
            return i;
        }
        int size2 = list.size();
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < size2; i5++) {
            GraphCommand graphCommand2 = commands.get(i5);
            if (!(graphCommand2 instanceof GraphCommand.Parameters)) {
                if (!(graphCommand2 instanceof GraphCommand.Listeners)) {
                    if (!(graphCommand2 instanceof GraphCommand.Repeat)) {
                        break;
                    }
                } else {
                    i4 = i5;
                }
            } else {
                i3 = i5;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        if (i4 >= 0) {
            return i4;
        }
        if (this.currentRepeatingRequest != null && getCaptureProcessingEnabled()) {
            int size3 = list.size();
            for (int i6 = 0; i6 < size3; i6++) {
                GraphCommand graphCommand3 = commands.get(i6);
                if ((graphCommand3 instanceof GraphCommand.Capture) || (graphCommand3 instanceof GraphCommand.Trigger)) {
                    return i6;
                }
            }
        }
        int size4 = list.size();
        int i7 = -1;
        int i8 = 0;
        while (i8 < size4 && (commands.get(i8) instanceof GraphCommand.Repeat)) {
            int i9 = i8;
            i8++;
            i7 = i9;
        }
        if (i7 >= 0) {
            return i7;
        }
        return 0;
    }

    static /* synthetic */ void processCapture$default(GraphLoop graphLoop, List list, int i, GraphCommand.Capture capture, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        graphLoop.processCapture(list, i, capture, z);
    }

    private final void processCapture(List<GraphCommand> commands, int idx, GraphCommand.Capture command, boolean repeatAllowed) {
        GraphLoop graphLoop;
        if (getCaptureProcessingEnabled()) {
            graphLoop = this;
            if (buildAndSubmit$default(graphLoop, false, command.getRequests(), null, 4, null)) {
                commands.remove(idx);
                return;
            }
        } else {
            graphLoop = this;
        }
        if (!repeatAllowed || idx <= 0) {
            return;
        }
        int i = idx - 1;
        if (!(commands.get(i) instanceof GraphCommand.Repeat)) {
            throw new IllegalStateException("Check failed.");
        }
        graphLoop.processRepeat(commands, i, false);
    }

    private final void processTrigger(List<GraphCommand> commands, int idx, GraphCommand.Trigger command) {
        Request request = this.currentRepeatingRequest;
        if (request == null && idx == 0) {
            commands.remove(idx);
            return;
        }
        if (getCaptureProcessingEnabled() && request != null && buildAndSubmit(false, CollectionsKt.listOf(request), command.getTriggerParameters())) {
            commands.remove(idx);
        } else if (idx > 0) {
            int i = idx - 1;
            if (!(commands.get(i) instanceof GraphCommand.Repeat)) {
                throw new IllegalStateException("Check failed.");
            }
            processRepeat(commands, i, false);
        }
    }

    static /* synthetic */ void processRepeat$default(GraphLoop graphLoop, List list, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        graphLoop.processRepeat(list, i, z);
    }

    private final void processRepeat(List<GraphCommand> commands, int idx, boolean captureAllowed) {
        int i;
        GraphLoop graphLoop;
        int i2 = idx;
        while (true) {
            int i3 = 0;
            if (-1 < i2) {
                GraphCommand graphCommand = commands.get(i2);
                if (graphCommand instanceof GraphCommand.Repeat) {
                    GraphCommand.Repeat repeat = (GraphCommand.Repeat) graphCommand;
                    graphLoop = this;
                    if (buildAndSubmit$default(graphLoop, true, CollectionsKt.listOf(repeat.getRequest()), null, 4, null)) {
                        graphLoop.currentRepeatingRequest = repeat.getRequest();
                        commands.remove(i2);
                        while (i3 < i2) {
                            if (commands.get(i3) instanceof GraphCommand.Repeat) {
                                commands.remove(i3);
                                i2--;
                            } else {
                                i3++;
                            }
                        }
                        return;
                    }
                } else {
                    graphLoop = this;
                }
                i2--;
                this = graphLoop;
            } else {
                GraphLoop graphLoop2 = this;
                if (!captureAllowed || (i = idx + 1) >= commands.size()) {
                    return;
                }
                GraphCommand graphCommand2 = commands.get(i);
                if (graphCommand2 instanceof GraphCommand.Capture) {
                    graphLoop2.processCapture(commands, i, (GraphCommand.Capture) graphCommand2, false);
                    return;
                } else {
                    if (graphCommand2 instanceof GraphCommand.Trigger) {
                        graphLoop2.processTrigger(commands, i, (GraphCommand.Trigger) graphCommand2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private final void processParameters(List<GraphCommand> commands, int idx, GraphCommand.Parameters command) {
        Map<?, ? extends Object> mapBuild;
        this.currentGraphParameters = command.getGraphParameters();
        this.currentGraph3AParameters = command.getGraph3AParameters();
        if (command.getGraph3AParameters().isEmpty()) {
            mapBuild = this.requiredParameters;
        } else {
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            RequestsKt.putAllMetadata(mapCreateMapBuilder, command.getGraph3AParameters());
            RequestsKt.putAllMetadata(mapCreateMapBuilder, this.requiredParameters);
            mapBuild = MapsKt.build(mapCreateMapBuilder);
        }
        this.currentRequiredParameters = mapBuild;
        commands.remove(idx);
        int i = 0;
        while (i < idx) {
            if (commands.get(i) instanceof GraphCommand.Parameters) {
                commands.remove(i);
                idx--;
            } else {
                i++;
            }
        }
        reissueRepeatingRequest();
    }

    private final void processListeners(List<GraphCommand> commands, int idx, GraphCommand.Listeners command) {
        this.currentRequestListeners = CollectionsKt.distinct(CollectionsKt.plus((Collection) command.getListeners(), (Iterable) this.requiredListeners));
        commands.remove(idx);
        int i = 0;
        while (i < idx) {
            if (commands.get(i) instanceof GraphCommand.Listeners) {
                commands.remove(i);
                idx--;
            } else {
                i++;
            }
        }
        reissueRepeatingRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0099  */
    /* JADX WARN: Code duplicated, block: B:38:0x0107  */
    /* JADX WARN: Code duplicated, block: B:40:0x010a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0110  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00df -> B:37:0x00fa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00f8 -> B:36:0x00f9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0107 -> B:39:0x0108). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object processRequestProcessor(java.util.List<androidx.camera.camera2.pipe.graph.GraphCommand> r18, int r19, androidx.camera.camera2.pipe.graph.GraphCommand.RequestProcessor r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.GraphLoop.processRequestProcessor(java.util.List, int, androidx.camera.camera2.pipe.graph.GraphCommand$RequestProcessor, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void processStop(List<GraphCommand> commands, int idx) {
        GraphRequestProcessor graphRequestProcessor = this.currentRequestProcessor;
        if (graphRequestProcessor != null) {
            graphRequestProcessor.stopRepeating$camera_camera2_pipe();
        }
        this.currentRepeatingRequest = null;
        commands.remove(idx);
        int i = 0;
        while (i < idx) {
            GraphCommand graphCommand = commands.get(i);
            if (Intrinsics.areEqual(graphCommand, GraphCommand.Stop.INSTANCE) || (graphCommand instanceof GraphCommand.Repeat)) {
                commands.remove(i);
                idx--;
            } else {
                i++;
            }
        }
    }

    private final void processAbort(List<GraphCommand> commands, int idx) {
        GraphRequestProcessor graphRequestProcessor = this.currentRequestProcessor;
        if (graphRequestProcessor != null) {
            graphRequestProcessor.abortCaptures$camera_camera2_pipe();
        }
        this.currentRepeatingRequest = null;
        commands.remove(idx);
        int i = 0;
        while (i < idx) {
            GraphCommand graphCommand = commands.get(i);
            if (!Intrinsics.areEqual(graphCommand, GraphCommand.Stop.INSTANCE) && !Intrinsics.areEqual(graphCommand, GraphCommand.Abort.INSTANCE) && !(graphCommand instanceof GraphCommand.Repeat) && !(graphCommand instanceof GraphCommand.Trigger)) {
                if (graphCommand instanceof GraphCommand.Capture) {
                    abortRequests(((GraphCommand.Capture) graphCommand).getRequests());
                } else {
                    i++;
                }
            }
            commands.remove(i);
            idx--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ef A[PHI: r3 r8 r11
      0x00ef: PHI (r3v5 int) = (r3v3 int), (r3v8 int) binds: [B:32:0x00b1, B:47:0x00ed] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r8v8 java.util.List<androidx.camera.camera2.pipe.graph.GraphCommand>) = 
      (r8v7 java.util.List<androidx.camera.camera2.pipe.graph.GraphCommand>)
      (r8v9 java.util.List<androidx.camera.camera2.pipe.graph.GraphCommand>)
     binds: [B:32:0x00b1, B:47:0x00ed] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r11v6 int) = (r11v5 int), (r11v7 int) binds: [B:32:0x00b1, B:47:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b1 -> B:48:0x00ef). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00da -> B:47:0x00ed). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00ea -> B:47:0x00ed). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object processShutdown(java.util.List<androidx.camera.camera2.pipe.graph.GraphCommand> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.GraphLoop.processShutdown(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean reissueRepeatingRequest() {
        GraphRequestProcessor graphRequestProcessor = this.currentRequestProcessor;
        if (graphRequestProcessor == null) {
            return false;
        }
        Request request = this.currentRepeatingRequest;
        return Intrinsics.areEqual((Object) (request != null ? Boolean.valueOf(graphRequestProcessor.submit$camera_camera2_pipe(true, CollectionsKt.listOf(request), this.defaultParameters, this.currentGraphParameters, this.currentRequiredParameters, this.currentRequestListeners)) : null), (Object) true);
    }

    private final void abortRequests(List<Request> requests) {
        List<Request> list = requests;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Request request = requests.get(i);
            int size2 = this.currentRequestListeners.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.currentRequestListeners.get(i2).onAborted(request);
            }
        }
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Request request2 = requests.get(i3);
            int size4 = request2.getListeners().size();
            for (int i4 = 0; i4 < size4; i4++) {
                request2.getListeners().get(i4).onAborted(request2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finalizeUnprocessedCommands(List<? extends GraphCommand> unprocessedCommands) {
        for (GraphCommand graphCommand : unprocessedCommands) {
            if (graphCommand instanceof GraphCommand.Capture) {
                abortRequests(((GraphCommand.Capture) graphCommand).getRequests());
            } else if (graphCommand instanceof GraphCommand.RequestProcessor) {
                BuildersKt__Builders_commonKt.launch$default(this.shutdownScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(graphCommand, null), 1, null);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.graph.GraphLoop$finalizeUnprocessedCommands$1, reason: invalid class name */
    /* JADX INFO: compiled from: GraphLoop.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.graph.GraphLoop$finalizeUnprocessedCommands$1", f = "GraphLoop.kt", i = {}, l = {630, 631}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphCommand $command;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GraphCommand graphCommand, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$command = graphCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$command, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
        
            if (r5.shutdown$camera_camera2_pipe(r4) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L4d
            L12:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L37
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                androidx.camera.camera2.pipe.graph.GraphCommand r5 = r4.$command
                androidx.camera.camera2.pipe.graph.GraphCommand$RequestProcessor r5 = (androidx.camera.camera2.pipe.graph.GraphCommand.RequestProcessor) r5
                androidx.camera.camera2.pipe.graph.GraphRequestProcessor r5 = r5.getOld()
                if (r5 == 0) goto L37
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = r5.shutdown$camera_camera2_pipe(r1)
                if (r5 != r0) goto L37
                goto L4c
            L37:
                androidx.camera.camera2.pipe.graph.GraphCommand r5 = r4.$command
                androidx.camera.camera2.pipe.graph.GraphCommand$RequestProcessor r5 = (androidx.camera.camera2.pipe.graph.GraphCommand.RequestProcessor) r5
                androidx.camera.camera2.pipe.graph.GraphRequestProcessor r5 = r5.getNew()
                if (r5 == 0) goto L4d
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r2
                java.lang.Object r4 = r5.shutdown$camera_camera2_pipe(r1)
                if (r4 != r0) goto L4d
            L4c:
                return r0
            L4d:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.GraphLoop.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean buildAndSubmit$default(GraphLoop graphLoop, boolean z, List list, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return graphLoop.buildAndSubmit(z, list, map);
    }

    private final boolean buildAndSubmit(boolean isRepeating, List<Request> requests, Map<?, ? extends Object> oneTimeRequiredParameters) {
        Map<?, ? extends Object> mapBuild;
        GraphRequestProcessor graphRequestProcessor = this.currentRequestProcessor;
        if (graphRequestProcessor == null) {
            return false;
        }
        Map<?, ? extends Object> map = this.defaultParameters;
        Map<?, ? extends Object> map2 = this.currentGraphParameters;
        if (oneTimeRequiredParameters.isEmpty()) {
            mapBuild = this.currentRequiredParameters;
        } else {
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            RequestsKt.putAllMetadata(mapCreateMapBuilder, this.currentGraph3AParameters);
            RequestsKt.putAllMetadata(mapCreateMapBuilder, oneTimeRequiredParameters);
            RequestsKt.putAllMetadata(mapCreateMapBuilder, this.requiredParameters);
            Unit unit = Unit.INSTANCE;
            mapBuild = MapsKt.build(mapCreateMapBuilder);
        }
        boolean zSubmit$camera_camera2_pipe = graphRequestProcessor.submit$camera_camera2_pipe(isRepeating, requests, map, map2, mapBuild, this.currentRequestListeners);
        if (!zSubmit$camera_camera2_pipe) {
            if (!isRepeating) {
                if (oneTimeRequiredParameters.isEmpty()) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to submit capture with " + requests);
                        return zSubmit$camera_camera2_pipe;
                    }
                } else if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to trigger with " + CollectionsKt.single((List) requests) + " and " + oneTimeRequiredParameters);
                }
            } else if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to repeat with " + CollectionsKt.single((List) requests));
                return zSubmit$camera_camera2_pipe;
            }
        }
        return zSubmit$camera_camera2_pipe;
    }

    public String toString() {
        return "GraphLoop(" + this.cameraGraphId + ')';
    }

    /* JADX INFO: compiled from: GraphLoop.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000bH\u0082\b¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphLoop$Companion;", "", "<init>", "()V", "removeUpTo", "", ExifInterface.GPS_DIRECTION_TRUE, "", "idx", "", "predicate", "Lkotlin/Function1;", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final <T> void removeUpTo(List<T> list, int i, Function1<? super T, Boolean> function1) {
            int i2 = 0;
            while (i2 < i) {
                if (function1.invoke(list.get(i2)).booleanValue()) {
                    list.remove(i2);
                    i--;
                } else {
                    i2++;
                }
            }
        }
    }
}
