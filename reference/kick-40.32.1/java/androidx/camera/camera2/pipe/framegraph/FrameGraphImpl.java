package androidx.camera.camera2.pipe.framegraph;

import android.hardware.camera2.params.MeteringRectangle;
import android.view.Surface;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.AwbMode;
import androidx.camera.camera2.pipe.CameraControls3A;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.FrameBuffer;
import androidx.camera.camera2.pipe.FrameGraph;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.FrameNumber;
import androidx.camera.camera2.pipe.GraphState;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.Parameters;
import androidx.camera.camera2.pipe.RequestListeners;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.config.FrameGraphCoroutineScope;
import androidx.camera.camera2.pipe.config.FrameGraphScope;
import androidx.camera.camera2.pipe.graph.Controller3A;
import androidx.camera.camera2.pipe.internal.FrameDistributor;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: FrameGraphImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@FrameGraphScope
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B3\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ!\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101JÍ\u0001\u00102\u001a\b\u0012\u0004\u0012\u000204032\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010A2\b\u0010C\u001a\u0004\u0018\u00010A2\b\u0010D\u001a\u0004\u0018\u0001062\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020!\u0018\u00010F2\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020!\u0018\u00010F2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0002\bNJW\u0010O\u001a\b\u0012\u0004\u0012\u000204032\b\u0010P\u001a\u0004\u0018\u00010!2\b\u0010Q\u001a\u0004\u0018\u00010!2\b\u0010R\u001a\u0004\u0018\u00010!2\u0014\u0010S\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020!\u0018\u00010F2\u0006\u0010I\u001a\u00020J2\u0006\u0010T\u001a\u00020LH\u0016¢\u0006\u0002\u0010UJ\b\u0010b\u001a\u00020&H\u0016J\b\u0010c\u001a\u00020&H\u0016J4\u0010d\u001a\u00020e2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020(0g2\u0014\u0010V\u001a\u0010\u0012\u0004\u0012\u00020i\u0012\u0006\u0012\u0004\u0018\u00010i0h2\u0006\u0010j\u001a\u00020JH\u0016J\u000e\u0010k\u001a\u00020lH\u0096@¢\u0006\u0002\u0010mJ\n\u0010n\u001a\u0004\u0018\u00010lH\u0016JC\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2-\u0010q\u001a)\b\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020l\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hp0s\u0012\u0006\u0012\u0004\u0018\u00010i0r¢\u0006\u0002\btH\u0096@¢\u0006\u0002\u0010uJP\u0010v\u001a\b\u0012\u0004\u0012\u0002Hp03\"\u0004\b\u0000\u0010p2\u0006\u0010w\u001a\u00020\n2-\u0010q\u001a)\b\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020l\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hp0s\u0012\u0006\u0012\u0004\u0018\u00010i0r¢\u0006\u0002\btH\u0016¢\u0006\u0002\u0010xJ'\u0010y\u001a\u0004\u0018\u0001Hp\"\b\b\u0000\u0010p*\u00020i2\f\u0010z\u001a\b\u0012\u0004\u0012\u0002Hp0{H\u0016¢\u0006\u0002\u0010|J\b\u0010}\u001a\u00020&H\u0016J\u0011\u0010~\u001a\u00020l2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J \u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u000204032\b\u00105\u001a\u0004\u0018\u000106H\u0096\u0001¢\u0006\u0003\b\u0082\u0001J\u0010\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020403H\u0096\u0001Jd\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u000204032\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0096\u0001¢\u0006\u0003\b\u0085\u0001Jd\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u000204032\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0096\u0001¢\u0006\u0003\b\u0087\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u0014\u0010V\u001a\u00020W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020[8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020_8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010a¨\u0006\u0088\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/framegraph/FrameGraphImpl;", "Landroidx/camera/camera2/pipe/FrameGraph;", "Landroidx/camera/camera2/pipe/CameraControls3A;", "cameraGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "frameDistributor", "Landroidx/camera/camera2/pipe/internal/FrameDistributor;", "frameGraphBuffers", "Landroidx/camera/camera2/pipe/framegraph/FrameGraphBuffers;", "frameGraphCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "controller3A", "Landroidx/camera/camera2/pipe/graph/Controller3A;", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph;Landroidx/camera/camera2/pipe/internal/FrameDistributor;Landroidx/camera/camera2/pipe/framegraph/FrameGraphBuffers;Lkotlinx/coroutines/CoroutineScope;Landroidx/camera/camera2/pipe/graph/Controller3A;)V", "streams", "Landroidx/camera/camera2/pipe/StreamGraph;", "getStreams", "()Landroidx/camera/camera2/pipe/StreamGraph;", "graphState", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/camera/camera2/pipe/GraphState;", "getGraphState", "()Lkotlinx/coroutines/flow/StateFlow;", "latestFrameNumber", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/camera/camera2/pipe/FrameNumber;", "getLatestFrameNumber", "()Lkotlinx/coroutines/flow/Flow;", "latestFrameInfo", "Landroidx/camera/camera2/pipe/FrameInfo;", "getLatestFrameInfo", "isForeground", "", "()Z", "setForeground", "(Z)V", "setSurface", "", "stream", "Landroidx/camera/camera2/pipe/StreamId;", "surface", "Landroid/view/Surface;", "setSurface-NYG5g8E", "(ILandroid/view/Surface;)V", "updateAudioRestrictionMode", "mode", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "updateAudioRestrictionMode-LwUUkyU", "(I)V", "lock3A", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "aeRegions", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "aeLockBehavior", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "convergedCondition", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "lockedCondition", "frameLimit", "", "convergedTimeLimitNs", "", "lockedTimeLimitNs", "lock3A-vIrNa9k", "unlock3A", "ae", "af", "awb", "unlockedCondition", "timeLimitNs", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;IJ)Lkotlinx/coroutines/Deferred;", "parameters", "Landroidx/camera/camera2/pipe/Parameters;", "getParameters", "()Landroidx/camera/camera2/pipe/Parameters;", "listeners", "Landroidx/camera/camera2/pipe/RequestListeners;", "getListeners", "()Landroidx/camera/camera2/pipe/RequestListeners;", "id", "Landroidx/camera/camera2/pipe/CameraGraphId;", "getId", "()Landroidx/camera/camera2/pipe/CameraGraphId;", ViewProps.START, "stop", "captureWith", "Landroidx/camera/camera2/pipe/FrameBuffer;", "streamIds", "", "", "", "capacity", "acquireSession", "Landroidx/camera/camera2/pipe/FrameGraph$Session;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSessionOrNull", "useSession", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useSessionIn", PermissionsResponse.SCOPE_KEY, "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/Deferred;", "unwrapAs", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "close", "createSession", "cameraGraphSession", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "setTorchOff", "setTorchOff-NqN7i0k", "setTorchOn", "submit3A", "submit3A-ydBZfZg", "update3A", "update3A-ydBZfZg", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameGraphImpl implements FrameGraph, CameraControls3A {
    private final CameraGraph cameraGraph;
    private final Controller3A controller3A;
    private final FrameDistributor frameDistributor;
    private final FrameGraphBuffers frameGraphBuffers;
    private final CoroutineScope frameGraphCoroutineScope;
    private final StateFlow<GraphState> graphState;
    private boolean isForeground;
    private final Flow<FrameInfo> latestFrameInfo;
    private final Flow<FrameNumber> latestFrameNumber;
    private final StreamGraph streams;

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.framegraph.FrameGraphImpl$acquireSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: FrameGraphImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.framegraph.FrameGraphImpl", f = "FrameGraphImpl.kt", i = {}, l = {153}, m = "acquireSession", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FrameGraphImpl.this.acquireSession(this);
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: setTorchOff-NqN7i0k */
    public Deferred<Result3A> mo308setTorchOffNqN7i0k(AeMode aeMode) {
        return this.cameraGraph.mo308setTorchOffNqN7i0k(aeMode);
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    public Deferred<Result3A> setTorchOn() {
        return this.cameraGraph.setTorchOn();
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: submit3A-ydBZfZg */
    public Deferred<Result3A> mo309submit3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        return this.cameraGraph.mo309submit3AydBZfZg(aeMode, afMode, awbMode, aeRegions, afRegions, awbRegions);
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: update3A-ydBZfZg */
    public Deferred<Result3A> mo310update3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        return this.cameraGraph.mo310update3AydBZfZg(aeMode, afMode, awbMode, aeRegions, afRegions, awbRegions);
    }

    @Inject
    public FrameGraphImpl(CameraGraph cameraGraph, FrameDistributor frameDistributor, FrameGraphBuffers frameGraphBuffers, @FrameGraphCoroutineScope CoroutineScope frameGraphCoroutineScope, Controller3A controller3A) {
        Intrinsics.checkNotNullParameter(cameraGraph, "cameraGraph");
        Intrinsics.checkNotNullParameter(frameDistributor, "frameDistributor");
        Intrinsics.checkNotNullParameter(frameGraphBuffers, "frameGraphBuffers");
        Intrinsics.checkNotNullParameter(frameGraphCoroutineScope, "frameGraphCoroutineScope");
        Intrinsics.checkNotNullParameter(controller3A, "controller3A");
        this.cameraGraph = cameraGraph;
        this.frameDistributor = frameDistributor;
        this.frameGraphBuffers = frameGraphBuffers;
        this.frameGraphCoroutineScope = frameGraphCoroutineScope;
        this.controller3A = controller3A;
        frameDistributor.setFrameStartedListener(frameGraphBuffers);
        this.streams = cameraGraph.getStreams();
        this.graphState = cameraGraph.getGraphState();
        this.latestFrameNumber = cameraGraph.getLatestFrameNumber();
        this.latestFrameInfo = cameraGraph.getLatestFrameInfo();
        this.isForeground = cameraGraph.getIsForeground();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public StreamGraph getStreams() {
        return this.streams;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public StateFlow<GraphState> getGraphState() {
        return this.graphState;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public Flow<FrameNumber> getLatestFrameNumber() {
        return this.latestFrameNumber;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public Flow<FrameInfo> getLatestFrameInfo() {
        return this.latestFrameInfo;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /* JADX INFO: renamed from: isForeground, reason: from getter */
    public boolean getIsForeground() {
        return this.isForeground;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public void setForeground(boolean z) {
        this.isForeground = z;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /* JADX INFO: renamed from: setSurface-NYG5g8E */
    public void mo424setSurfaceNYG5g8E(int stream, Surface surface) {
        this.cameraGraph.mo424setSurfaceNYG5g8E(stream, surface);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /* JADX INFO: renamed from: updateAudioRestrictionMode-LwUUkyU */
    public void mo425updateAudioRestrictionModeLwUUkyU(int mode) {
        this.cameraGraph.mo425updateAudioRestrictionModeLwUUkyU(mode);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    /* JADX INFO: renamed from: lock3A-vIrNa9k */
    public Deferred<Result3A> mo423lock3AvIrNa9k(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions, Lock3ABehavior aeLockBehavior, Lock3ABehavior afLockBehavior, Lock3ABehavior awbLockBehavior, AeMode afTriggerStartAeMode, Function1<? super FrameMetadata, Boolean> convergedCondition, Function1<? super FrameMetadata, Boolean> lockedCondition, int frameLimit, long convergedTimeLimitNs, long lockedTimeLimitNs) {
        return this.cameraGraph.mo423lock3AvIrNa9k(aeMode, afMode, awbMode, aeRegions, afRegions, awbRegions, aeLockBehavior, afLockBehavior, awbLockBehavior, afTriggerStartAeMode, convergedCondition, lockedCondition, frameLimit, convergedTimeLimitNs, lockedTimeLimitNs);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public Deferred<Result3A> unlock3A(Boolean ae, Boolean af, Boolean awb, Function1<? super FrameMetadata, Boolean> unlockedCondition, int frameLimit, long timeLimitNs) {
        return this.cameraGraph.unlock3A(ae, af, awb, unlockedCondition, frameLimit, timeLimitNs);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public Parameters getParameters() {
        return this.cameraGraph.getParameters();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public RequestListeners getListeners() {
        return this.cameraGraph.getListeners();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public CameraGraphId getId() {
        return this.cameraGraph.getId();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public void start() {
        this.cameraGraph.start();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public void stop() {
        this.cameraGraph.stop();
    }

    @Override // androidx.camera.camera2.pipe.FrameGraph
    public FrameBuffer captureWith(Set<StreamId> streamIds, Map<Object, ? extends Object> parameters, int capacity) {
        Intrinsics.checkNotNullParameter(streamIds, "streamIds");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.frameGraphBuffers.attach$camera_camera2_pipe(streamIds, parameters, capacity);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public Object acquireSession(Continuation<? super FrameGraph.Session> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAcquireSession = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAcquireSession);
            CameraGraph cameraGraph = this.cameraGraph;
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objAcquireSession = cameraGraph.acquireSession(anonymousClass1);
            if (objAcquireSession == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (FrameGraphImpl) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAcquireSession);
        }
        return this.createSession((CameraGraph.Session) objAcquireSession);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public FrameGraph.Session acquireSessionOrNull() {
        CameraGraph.Session sessionAcquireSessionOrNull = this.cameraGraph.acquireSessionOrNull();
        if (sessionAcquireSessionOrNull != null) {
            return createSession(sessionAcquireSessionOrNull);
        }
        return null;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.framegraph.FrameGraphImpl$useSession$2, reason: invalid class name */
    /* JADX INFO: compiled from: FrameGraphImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "cameraGraphSession", "Landroidx/camera/camera2/pipe/CameraGraph$Session;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.framegraph.FrameGraphImpl$useSession$2", f = "FrameGraphImpl.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2<T> extends SuspendLambda implements Function3<CoroutineScope, CameraGraph.Session, Continuation<? super T>, Object> {
        final /* synthetic */ Function3<CoroutineScope, FrameGraph.Session, Continuation<? super T>, Object> $action;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function3<? super CoroutineScope, ? super FrameGraph.Session, ? super Continuation<? super T>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$action = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, CameraGraph.Session session, Continuation<? super T> continuation) {
            AnonymousClass2 anonymousClass2 = FrameGraphImpl.this.new AnonymousClass2(this.$action, continuation);
            anonymousClass2.L$0 = coroutineScope;
            anonymousClass2.L$1 = session;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AutoCloseable autoCloseable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                autoCloseable = (AutoCloseable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    AutoCloseableKt.closeFinally(autoCloseable, null);
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(autoCloseable, th);
                        throw th2;
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            FrameGraph.Session sessionCreateSession = FrameGraphImpl.this.createSession((CameraGraph.Session) this.L$1);
            Function3<CoroutineScope, FrameGraph.Session, Continuation<? super T>, Object> function3 = this.$action;
            try {
                this.L$0 = sessionCreateSession;
                this.label = 1;
                obj = function3.invoke(coroutineScope, sessionCreateSession, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                autoCloseable = sessionCreateSession;
                AutoCloseableKt.closeFinally(autoCloseable, null);
                return obj;
            } catch (Throwable th3) {
                th = th3;
                autoCloseable = sessionCreateSession;
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public <T> Object useSession(Function3<? super CoroutineScope, ? super FrameGraph.Session, ? super Continuation<? super T>, ? extends Object> function3, Continuation<? super T> continuation) {
        return this.cameraGraph.useSession(new AnonymousClass2(function3, null), continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.framegraph.FrameGraphImpl$useSessionIn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FrameGraphImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "cameraGraphSession", "Landroidx/camera/camera2/pipe/CameraGraph$Session;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.framegraph.FrameGraphImpl$useSessionIn$1", f = "FrameGraphImpl.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02141<T> extends SuspendLambda implements Function3<CoroutineScope, CameraGraph.Session, Continuation<? super T>, Object> {
        final /* synthetic */ Function3<CoroutineScope, FrameGraph.Session, Continuation<? super T>, Object> $action;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02141(Function3<? super CoroutineScope, ? super FrameGraph.Session, ? super Continuation<? super T>, ? extends Object> function3, Continuation<? super C02141> continuation) {
            super(3, continuation);
            this.$action = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, CameraGraph.Session session, Continuation<? super T> continuation) {
            C02141 c02141 = FrameGraphImpl.this.new C02141(this.$action, continuation);
            c02141.L$0 = coroutineScope;
            c02141.L$1 = session;
            return c02141.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AutoCloseable autoCloseable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                autoCloseable = (AutoCloseable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    AutoCloseableKt.closeFinally(autoCloseable, null);
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(autoCloseable, th);
                        throw th2;
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            FrameGraph.Session sessionCreateSession = FrameGraphImpl.this.createSession((CameraGraph.Session) this.L$1);
            Function3<CoroutineScope, FrameGraph.Session, Continuation<? super T>, Object> function3 = this.$action;
            try {
                this.L$0 = sessionCreateSession;
                this.label = 1;
                obj = function3.invoke(coroutineScope, sessionCreateSession, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                autoCloseable = sessionCreateSession;
                AutoCloseableKt.closeFinally(autoCloseable, null);
                return obj;
            } catch (Throwable th3) {
                th = th3;
                autoCloseable = sessionCreateSession;
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraGraphBase
    public <T> Deferred<T> useSessionIn(CoroutineScope scope, Function3<? super CoroutineScope, ? super FrameGraph.Session, ? super Continuation<? super T>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(action, "action");
        return this.cameraGraph.useSessionIn(scope, new C02141(action, null));
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraGraph.class))) {
            return (T) this.cameraGraph;
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        UByte$$ExternalSyntheticBackport0.m12761m((Object) this.cameraGraph);
        CoroutineScopeKt.cancel$default(this.frameGraphCoroutineScope, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameGraph.Session createSession(CameraGraph.Session cameraGraphSession) {
        return new FrameGraphSessionImpl(cameraGraphSession, this.frameGraphBuffers, this.controller3A);
    }
}
