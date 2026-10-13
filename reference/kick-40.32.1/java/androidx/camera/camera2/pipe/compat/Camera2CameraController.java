package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraExtensionSession;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraGraphId;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.ConcurrentCameraGraphs;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.SurfaceTracker;
import androidx.camera.camera2.pipe.config.Camera2ControllerScope;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.core.TimestampNs;
import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.camera.camera2.pipe.graph.StreamGraphImpl;
import androidx.camera.camera2.pipe.internal.CameraStatusMonitor;
import androidx.media3.muxer.WebmConstants;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: Camera2CameraController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 p2\u00020\u0001:\u0002opB\u0091\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b$\u0010%J\b\u0010U\u001a\u00020IH\u0016J\b\u0010V\u001a\u00020IH\u0016J\b\u0010W\u001a\u00020IH\u0003J\b\u0010X\u001a\u00020IH\u0003J\b\u0010Y\u001a\u00020IH\u0003J\u0010\u0010Z\u001a\u00020I2\u0006\u0010[\u001a\u00020>H\u0002J\b\u0010\\\u001a\u00020IH\u0016J\u000e\u0010]\u001a\u00020/H\u0096@¢\u0006\u0002\u0010^J\u001c\u0010_\u001a\u00020I2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q0OH\u0016J\u0019\u0010a\u001a\u0004\u0018\u00010b2\b\u0010c\u001a\u0004\u0018\u00010PH\u0016¢\u0006\u0002\bdJ\b\u0010e\u001a\u00020fH\u0016J\u000e\u0010g\u001a\u00020IH\u0082@¢\u0006\u0002\u0010^J\u0010\u0010h\u001a\u00020I2\u0006\u0010i\u001a\u00020jH\u0002J\u001c\u0010k\u001a\u00020I2\b\u0010l\u001a\u0004\u0018\u00010M2\b\u0010m\u001a\u0004\u0018\u00010KH\u0003J\b\u0010n\u001a\u00020/H\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R$\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0012\u00104\u001a\u00020/8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R$\u00105\u001a\u0002068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0012\u0010=\u001a\u00020>8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0010\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraController;", "Landroidx/camera/camera2/pipe/CameraController;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "strictMode", "Landroidx/camera/camera2/pipe/StrictMode;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "surfaceTracker", "Landroidx/camera/camera2/pipe/SurfaceTracker;", "cameraStatusMonitor", "Landroidx/camera/camera2/pipe/internal/CameraStatusMonitor;", "captureSessionFactory", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory;", "captureSequenceProcessorFactory", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessorFactory;", "camera2DeviceManager", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceManager;", "cameraSurfaceManager", "Landroidx/camera/camera2/pipe/CameraSurfaceManager;", "camera2Quirks", "Landroidx/camera/camera2/pipe/compat/Camera2Quirks;", "timeSource", "Landroidx/camera/camera2/pipe/core/TimeSource;", "cameraGraphId", "Landroidx/camera/camera2/pipe/CameraGraphId;", "shutdownListener", "Landroidx/camera/camera2/pipe/compat/Camera2CameraController$ShutdownListener;", "streamGraph", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "concurrentSessionSequencers", "Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencers;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/StrictMode;Landroidx/camera/camera2/pipe/CameraGraph$Config;Landroidx/camera/camera2/pipe/graph/GraphListener;Landroidx/camera/camera2/pipe/SurfaceTracker;Landroidx/camera/camera2/pipe/internal/CameraStatusMonitor;Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory;Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessorFactory;Landroidx/camera/camera2/pipe/compat/Camera2DeviceManager;Landroidx/camera/camera2/pipe/CameraSurfaceManager;Landroidx/camera/camera2/pipe/compat/Camera2Quirks;Landroidx/camera/camera2/pipe/core/TimeSource;Landroidx/camera/camera2/pipe/CameraGraphId;Landroidx/camera/camera2/pipe/compat/Camera2CameraController$ShutdownListener;Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencers;)V", "getCameraGraphId", "()Landroidx/camera/camera2/pipe/CameraGraphId;", "lock", "", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "value", "", "isForeground", "()Z", "setForeground", "(Z)V", "_isForeground", "controllerState", "Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "getControllerState$camera_camera2_pipe$annotations", "()V", "getControllerState$camera_camera2_pipe", "()Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "setControllerState$camera_camera2_pipe", "(Landroidx/camera/camera2/pipe/CameraController$ControllerState;)V", "cameraAvailability", "Landroidx/camera/camera2/pipe/internal/CameraStatusMonitor$CameraStatus;", "lastCameraError", "Landroidx/camera/camera2/pipe/CameraError;", "lastCameraPrioritiesChangedTs", "Landroidx/camera/camera2/pipe/core/TimestampNs;", "restartJob", "Lkotlinx/coroutines/Job;", "concurrentSessionSequencer", "Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencer;", "closedDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "currentCamera", "Landroidx/camera/camera2/pipe/compat/VirtualCamera;", "currentSession", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "currentSurfaceMap", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "currentCameraStateJob", "cameraAvailabilityJob", "cameraPrioritiesJob", ViewProps.START, "stop", "tryRestart", "startLocked", "stopLocked", "onCameraStatusChanged", "cameraStatus", "close", "awaitClosed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSurfaceMap", "surfaceMap", "getOutputLatency", "Landroidx/camera/camera2/pipe/StreamGraph$OutputLatency;", "streamId", "getOutputLatency-n5Pu2dI", "toString", "", "bindSessionToCamera", "onStateClosed", "cameraState", "Landroidx/camera/camera2/pipe/compat/CameraStateClosed;", "detachSessionAndCamera", "session", "camera", "isClosed", "ShutdownListener", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Camera2ControllerScope
public final class Camera2CameraController implements CameraController {
    private static final int MS_TO_NS = 1000000;
    private static final long RESTART_TIMEOUT_WHEN_ENABLED_MS = 700;
    private boolean _isForeground;
    private final Camera2DeviceManager camera2DeviceManager;
    private final Camera2Quirks camera2Quirks;
    private CameraStatusMonitor.CameraStatus cameraAvailability;
    private Job cameraAvailabilityJob;
    private final CameraGraphId cameraGraphId;
    private Job cameraPrioritiesJob;
    private final CameraStatusMonitor cameraStatusMonitor;
    private final CameraSurfaceManager cameraSurfaceManager;
    private final Camera2CaptureSequenceProcessorFactory captureSequenceProcessorFactory;
    private final CaptureSessionFactory captureSessionFactory;
    private final CompletableDeferred<Unit> closedDeferred;
    private final ConcurrentSessionSequencer concurrentSessionSequencer;
    private CameraController.ControllerState controllerState;
    private VirtualCamera currentCamera;
    private Job currentCameraStateJob;
    private CaptureSessionState currentSession;
    private Map<StreamId, ? extends Surface> currentSurfaceMap;
    private final CameraGraph.Config graphConfig;
    private final GraphListener graphListener;
    private CameraError lastCameraError;
    private TimestampNs lastCameraPrioritiesChangedTs;
    private final Object lock;
    private Job restartJob;
    private final CoroutineScope scope;
    private final ShutdownListener shutdownListener;
    private final StreamGraphImpl streamGraph;
    private final StrictMode strictMode;
    private final SurfaceTracker surfaceTracker;
    private final Threads threads;
    private final TimeSource timeSource;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long PRIORITIES_CHANGED_THRESHOLD_NS = DurationNs.m917constructorimpl(200000000);

    /* JADX INFO: compiled from: Camera2CameraController.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraController$ShutdownListener;", "", "onControllerClosed", "", "cameraController", "Landroidx/camera/camera2/pipe/CameraController;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ShutdownListener {
        void onControllerClosed(CameraController cameraController);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$awaitClosed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2CameraController.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2CameraController", f = "Camera2CameraController.kt", i = {}, l = {340}, m = "awaitClosed", n = {}, s = {}, v = 1)
    static final class C02001 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C02001(Continuation<? super C02001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Camera2CameraController.this.awaitClosed(this);
        }
    }

    public static /* synthetic */ void getControllerState$camera_camera2_pipe$annotations() {
    }

    @Inject
    public Camera2CameraController(CoroutineScope scope, Threads threads, StrictMode strictMode, CameraGraph.Config graphConfig, GraphListener graphListener, SurfaceTracker surfaceTracker, CameraStatusMonitor cameraStatusMonitor, CaptureSessionFactory captureSessionFactory, Camera2CaptureSequenceProcessorFactory captureSequenceProcessorFactory, Camera2DeviceManager camera2DeviceManager, CameraSurfaceManager cameraSurfaceManager, Camera2Quirks camera2Quirks, TimeSource timeSource, CameraGraphId cameraGraphId, ShutdownListener shutdownListener, StreamGraphImpl streamGraph, ConcurrentSessionSequencers concurrentSessionSequencers) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(strictMode, "strictMode");
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(surfaceTracker, "surfaceTracker");
        Intrinsics.checkNotNullParameter(cameraStatusMonitor, "cameraStatusMonitor");
        Intrinsics.checkNotNullParameter(captureSessionFactory, "captureSessionFactory");
        Intrinsics.checkNotNullParameter(captureSequenceProcessorFactory, "captureSequenceProcessorFactory");
        Intrinsics.checkNotNullParameter(camera2DeviceManager, "camera2DeviceManager");
        Intrinsics.checkNotNullParameter(cameraSurfaceManager, "cameraSurfaceManager");
        Intrinsics.checkNotNullParameter(camera2Quirks, "camera2Quirks");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(cameraGraphId, "cameraGraphId");
        Intrinsics.checkNotNullParameter(shutdownListener, "shutdownListener");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        Intrinsics.checkNotNullParameter(concurrentSessionSequencers, "concurrentSessionSequencers");
        this.scope = scope;
        this.threads = threads;
        this.strictMode = strictMode;
        this.graphConfig = graphConfig;
        this.graphListener = graphListener;
        this.surfaceTracker = surfaceTracker;
        this.cameraStatusMonitor = cameraStatusMonitor;
        this.captureSessionFactory = captureSessionFactory;
        this.captureSequenceProcessorFactory = captureSequenceProcessorFactory;
        this.camera2DeviceManager = camera2DeviceManager;
        this.cameraSurfaceManager = cameraSurfaceManager;
        this.camera2Quirks = camera2Quirks;
        this.timeSource = timeSource;
        this.cameraGraphId = cameraGraphId;
        this.shutdownListener = shutdownListener;
        this.streamGraph = streamGraph;
        this.lock = new Object();
        this._isForeground = true;
        this.controllerState = CameraController.ControllerState.STOPPED.INSTANCE;
        this.cameraAvailability = new CameraStatusMonitor.CameraStatus.CameraUnavailable(mo303getCameraIdDz_R5H8(), null);
        ConcurrentCameraGraphs concurrentCameraGraphs = graphConfig.getConcurrentCameraGraphs();
        this.concurrentSessionSequencer = concurrentCameraGraphs != null ? concurrentSessionSequencers.getSequencer(getCameraGraphId(), concurrentCameraGraphs) : null;
        this.closedDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.cameraAvailabilityJob = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
        this.cameraPrioritiesJob = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass2(null), 3, null);
    }

    @Override // androidx.camera.camera2.pipe.CameraController
    public CameraGraphId getCameraGraphId() {
        return this.cameraGraphId;
    }

    @Override // androidx.camera.camera2.pipe.CameraController
    /* JADX INFO: renamed from: getCameraId-Dz_R5H8 */
    public String mo303getCameraIdDz_R5H8() {
        return this.graphConfig.m385getCameraDz_R5H8();
    }

    @Override // androidx.camera.camera2.pipe.CameraController
    public boolean isForeground() {
        boolean z;
        synchronized (this.lock) {
            z = this._isForeground;
        }
        return z;
    }

    @Override // androidx.camera.camera2.pipe.CameraController
    public void setForeground(boolean z) {
        synchronized (this.lock) {
            this._isForeground = z;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getControllerState$camera_camera2_pipe, reason: from getter */
    public final CameraController.ControllerState getControllerState() {
        return this.controllerState;
    }

    public final void setControllerState$camera_camera2_pipe(CameraController.ControllerState controllerState) {
        Intrinsics.checkNotNullParameter(controllerState, "<set-?>");
        this.controllerState = controllerState;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$1, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2CameraController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2CameraController$1", f = "Camera2CameraController.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Camera2CameraController.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<CameraStatusMonitor.CameraStatus> cameraAvailability = Camera2CameraController.this.cameraStatusMonitor.getCameraAvailability();
                final Camera2CameraController camera2CameraController = Camera2CameraController.this;
                this.label = 1;
                if (cameraAvailability.collect(new FlowCollector() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraController.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((CameraStatusMonitor.CameraStatus) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(CameraStatusMonitor.CameraStatus cameraStatus, Continuation<? super Unit> continuation) {
                        if (cameraStatus instanceof CameraStatusMonitor.CameraStatus.CameraAvailable) {
                            if (CameraId.m429equalsimpl0(((CameraStatusMonitor.CameraStatus.CameraAvailable) cameraStatus).getCameraId(), camera2CameraController.mo303getCameraIdDz_R5H8())) {
                                camera2CameraController.onCameraStatusChanged(cameraStatus);
                            } else {
                                throw new IllegalStateException("Check failed.");
                            }
                        } else if (cameraStatus instanceof CameraStatusMonitor.CameraStatus.CameraUnavailable) {
                            if (CameraId.m429equalsimpl0(((CameraStatusMonitor.CameraStatus.CameraUnavailable) cameraStatus).getCameraId(), camera2CameraController.mo303getCameraIdDz_R5H8())) {
                                camera2CameraController.onCameraStatusChanged(cameraStatus);
                            } else {
                                throw new IllegalStateException("Check failed.");
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$2, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2CameraController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2CameraController$2", f = "Camera2CameraController.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Camera2CameraController.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<Unit> cameraPriorities = Camera2CameraController.this.cameraStatusMonitor.getCameraPriorities();
                final Camera2CameraController camera2CameraController = Camera2CameraController.this;
                this.label = 1;
                if (cameraPriorities.collect(new FlowCollector() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraController.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Unit) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                        camera2CameraController.onCameraStatusChanged(CameraStatusMonitor.CameraStatus.CameraPrioritiesChanged.INSTANCE);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraController
    public void start() {
        synchronized (this.lock) {
            startLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraController
    public void stop() {
        synchronized (this.lock) {
            stopLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void tryRestart() {
        long jMo927nowvQl9yQU = this.timeSource.mo927nowvQl9yQU();
        if (INSTANCE.m825shouldRestartX9Wt83s$camera_camera2_pipe(this.controllerState, this.lastCameraError, this.cameraAvailability, this.lastCameraPrioritiesChangedTs, jMo927nowvQl9yQU)) {
            long j = this.graphConfig.getFlags().getEnableRestartDelays() ? 700L : 0L;
            Job job = this.restartJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.restartJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C02012(j, this, null), 3, null);
            return;
        }
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + ": Not restarting. Controller state = " + getControllerState() + ", last camera error = " + this.lastCameraError + ", camera availability = " + this.cameraAvailability + ", last camera priorities changed = " + this.lastCameraPrioritiesChangedTs + ", current timestamp = " + ((Object) TimestampNs.m935toStringimpl(jMo927nowvQl9yQU)) + FilenameUtils.EXTENSION_SEPARATOR);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$tryRestart$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Camera2CameraController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2CameraController$tryRestart$2", f = "Camera2CameraController.kt", i = {}, l = {WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMs;
        int label;
        final /* synthetic */ Camera2CameraController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02012(long j, Camera2CameraController camera2CameraController, Continuation<? super C02012> continuation) {
            super(2, continuation);
            this.$delayMs = j;
            this.this$0 = camera2CameraController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02012(this.$delayMs, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02012) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(this.$delayMs, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Object obj2 = this.this$0.lock;
            Camera2CameraController camera2CameraController = this.this$0;
            synchronized (obj2) {
                if (!camera2CameraController.isClosed() && !Intrinsics.areEqual(camera2CameraController.getControllerState(), CameraController.ControllerState.STOPPING.INSTANCE) && !Intrinsics.areEqual(camera2CameraController.getControllerState(), CameraController.ControllerState.STOPPED.INSTANCE)) {
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Restarting " + camera2CameraController + "...");
                    }
                    camera2CameraController.surfaceTracker.registerAllSurfaces();
                    camera2CameraController.stopLocked();
                    camera2CameraController.startLocked();
                }
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startLocked() {
        Set<CameraId> of;
        if (!isClosed()) {
            if (!Intrinsics.areEqual(this.controllerState, CameraController.ControllerState.STARTED.INSTANCE)) {
                this.lastCameraError = null;
                String strM385getCameraDz_R5H8 = this.graphConfig.m385getCameraDz_R5H8();
                ConcurrentCameraGraphs concurrentCameraGraphs = this.graphConfig.getConcurrentCameraGraphs();
                if (concurrentCameraGraphs == null || (of = concurrentCameraGraphs.getCameraIds()) == null) {
                    of = SetsKt.setOf(CameraId.m426boximpl(strM385getCameraDz_R5H8));
                }
                VirtualCamera virtualCameraMo835openzDSwpeU = this.camera2DeviceManager.mo835openzDSwpeU(strM385getCameraDz_R5H8, CollectionsKt.toList(SetsKt.minus(of, CameraId.m426boximpl(strM385getCameraDz_R5H8))), this.graphListener, false, new Function1() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraController$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(Camera2CameraController.startLocked$lambda$2(this.f$0, (Unit) obj));
                    }
                });
                if (virtualCameraMo835openzDSwpeU != null) {
                    if (this.currentCamera != null) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (this.currentSession != null) {
                        throw new IllegalStateException("Check failed.");
                    }
                    this.currentCamera = virtualCameraMo835openzDSwpeU;
                    CaptureSessionState captureSessionState = new CaptureSessionState(this.graphListener, this.captureSessionFactory, this.captureSequenceProcessorFactory, this.cameraSurfaceManager, this.timeSource, this.graphConfig.getFlags(), this.concurrentSessionSequencer, this.streamGraph, this.strictMode, this.threads, this.scope);
                    this.currentSession = captureSessionState;
                    Map<StreamId, ? extends Surface> map = this.currentSurfaceMap;
                    if (map != null) {
                        captureSessionState.configureSurfaceMap(map);
                    }
                    this.controllerState = CameraController.ControllerState.STARTED.INSTANCE;
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Started " + this);
                    }
                    Job job = this.currentCameraStateJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    this.currentCameraStateJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass5(null), 3, null);
                    return;
                }
                if (Log.INSTANCE.getERROR_LOGGABLE()) {
                    android.util.Log.e(Log.TAG, "Failed to start " + this + ": Open request submission failed");
                    return;
                }
                return;
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Ignoring start(): " + this + " is already started");
                return;
            }
            return;
        }
        if (Log.INSTANCE.getINFO_LOGGABLE()) {
            android.util.Log.i(Log.TAG, "Ignoring start(): " + this + " is already closed");
        }
    }

    static final boolean startLocked$lambda$2(Camera2CameraController camera2CameraController, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<unused var>");
        return camera2CameraController.isForeground();
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraController$startLocked$5, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2CameraController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2CameraController$startLocked$5", f = "Camera2CameraController.kt", i = {}, l = {WebmConstants.MkvEbmlElement.REFERENCE_BLOCK}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Camera2CameraController.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Camera2CameraController.this.bindSessionToCamera(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopLocked() {
        if (!isClosed()) {
            if (!Intrinsics.areEqual(this.controllerState, CameraController.ControllerState.STOPPING.INSTANCE) && !Intrinsics.areEqual(this.controllerState, CameraController.ControllerState.STOPPED.INSTANCE)) {
                VirtualCamera virtualCamera = this.currentCamera;
                CaptureSessionState captureSessionState = this.currentSession;
                this.currentCamera = null;
                this.currentSession = null;
                this.controllerState = CameraController.ControllerState.STOPPING.INSTANCE;
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Stopping " + this);
                }
                detachSessionAndCamera(captureSessionState, virtualCamera);
                return;
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Ignoring stop(): " + this + " already stopping or stopped");
                return;
            }
            return;
        }
        if (Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Ignoring stop(): " + this + " is already closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCameraStatusChanged(CameraStatusMonitor.CameraStatus cameraStatus) {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " (" + ((Object) CameraId.m432toStringimpl(mo303getCameraIdDz_R5H8())) + ") camera status changed: " + cameraStatus);
        }
        synchronized (this.lock) {
            if (isClosed()) {
                return;
            }
            if ((cameraStatus instanceof CameraStatusMonitor.CameraStatus.CameraAvailable) || (cameraStatus instanceof CameraStatusMonitor.CameraStatus.CameraUnavailable)) {
                this.cameraAvailability = cameraStatus;
            } else if (cameraStatus instanceof CameraStatusMonitor.CameraStatus.CameraPrioritiesChanged) {
                this.lastCameraPrioritiesChangedTs = TimestampNs.m928boximpl(this.timeSource.mo927nowvQl9yQU());
            }
            tryRestart();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraController
    public void close() {
        synchronized (this.lock) {
            if (isClosed()) {
                return;
            }
            this.controllerState = CameraController.ControllerState.CLOSING.INSTANCE;
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Closed " + this);
            }
            VirtualCamera virtualCamera = this.currentCamera;
            CaptureSessionState captureSessionState = this.currentSession;
            this.currentCamera = null;
            this.currentSession = null;
            Job job = this.restartJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = this.currentCameraStateJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.currentCameraStateJob = null;
            Job job3 = this.cameraAvailabilityJob;
            if (job3 != null) {
                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            this.cameraAvailabilityJob = null;
            Job job4 = this.cameraPrioritiesJob;
            if (job4 != null) {
                Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
            }
            this.cameraPrioritiesJob = null;
            UByte$$ExternalSyntheticBackport0.m12761m((Object) this.cameraStatusMonitor);
            detachSessionAndCamera(captureSessionState, virtualCamera);
            if (this.graphConfig.getFlags().getCloseCameraDeviceOnClose() || this.camera2Quirks.m850x552c1673(mo303getCameraIdDz_R5H8())) {
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Quirk: Closing " + ((Object) CameraId.m432toStringimpl(mo303getCameraIdDz_R5H8())) + " during " + this + "#close");
                }
                this.camera2DeviceManager.mo834closeEfqyGwQ(mo303getCameraIdDz_R5H8());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.CameraController
    public Object awaitClosed(Continuation<? super Boolean> continuation) {
        C02001 c02001;
        if (continuation instanceof C02001) {
            c02001 = (C02001) continuation;
            if ((c02001.label & Integer.MIN_VALUE) != 0) {
                c02001.label -= Integer.MIN_VALUE;
            } else {
                c02001 = new C02001(continuation);
            }
        } else {
            c02001 = new C02001(continuation);
        }
        Object obj = c02001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02001.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, this + "#awaitClosed");
            }
            synchronized (this.lock) {
                if (Intrinsics.areEqual(this.controllerState, CameraController.ControllerState.CLOSED.INSTANCE)) {
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, this + "#awaitClosed: Controller is already closed.");
                    }
                    return Boxing.boxBoolean(true);
                }
                if (!Intrinsics.areEqual(this.controllerState, CameraController.ControllerState.CLOSING.INSTANCE)) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, this + "#awaitClosed: Controller isn't closing!");
                    }
                    return Boxing.boxBoolean(false);
                }
                Unit unit = Unit.INSTANCE;
                CompletableDeferred<Unit> completableDeferred = this.closedDeferred;
                c02001.label = 1;
                if (completableDeferred.await(c02001) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(true);
    }

    @Override // androidx.camera.camera2.pipe.CameraController
    public void updateSurfaceMap(Map<StreamId, ? extends Surface> surfaceMap) {
        Intrinsics.checkNotNullParameter(surfaceMap, "surfaceMap");
        synchronized (this.lock) {
            if (isClosed()) {
                return;
            }
            this.currentSurfaceMap = surfaceMap;
            CaptureSessionState captureSessionState = this.currentSession;
            if (captureSessionState != null) {
                captureSessionState.configureSurfaceMap(surfaceMap);
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraController
    /* JADX INFO: renamed from: getOutputLatency-n5Pu2dI */
    public StreamGraph.OutputLatency mo304getOutputLatencyn5Pu2dI(StreamId streamId) {
        CaptureSessionState captureSessionState;
        CameraExtensionSession.StillCaptureLatency realtimeCaptureLatency;
        if (Build.VERSION.SDK_INT < 34 || (captureSessionState = this.currentSession) == null || (realtimeCaptureLatency = captureSessionState.getRealtimeCaptureLatency()) == null) {
            return null;
        }
        return new StreamGraph.OutputLatency(realtimeCaptureLatency.getCaptureLatency() * 1000000, realtimeCaptureLatency.getProcessingLatency() * 1000000);
    }

    public String toString() {
        return "Camera2CameraController(" + getCameraGraphId() + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, androidx.camera.camera2.pipe.compat.CaptureSessionState] */
    public final Object bindSessionToCamera(Continuation<? super Unit> continuation) {
        VirtualCamera virtualCamera;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            virtualCamera = this.currentCamera;
            objectRef.element = this.currentSession;
            Unit unit = Unit.INSTANCE;
        }
        if (virtualCamera != null && objectRef.element != 0) {
            Object objCollect = virtualCamera.getState().collect(new FlowCollector() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraController.bindSessionToCamera.3
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                    return emit((CameraState) obj, (Continuation<? super Unit>) continuation2);
                }

                public final Object emit(CameraState cameraState, Continuation<? super Unit> continuation2) {
                    if (cameraState instanceof CameraStateOpen) {
                        objectRef.element.setCameraDevice(((CameraStateOpen) cameraState).getCameraDevice());
                    } else if (cameraState instanceof CameraStateClosing) {
                        objectRef.element.shutdown();
                    } else if (cameraState instanceof CameraStateClosed) {
                        objectRef.element.shutdown();
                        this.onStateClosed((CameraStateClosed) cameraState);
                    }
                    return Unit.INSTANCE;
                }
            }, continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStateClosed(CameraStateClosed cameraState) {
        synchronized (this.lock) {
            if (isClosed()) {
                return;
            }
            if (cameraState.m863getCameraErrorCodemVEW8x0() != null) {
                this.lastCameraError = cameraState.m863getCameraErrorCodemVEW8x0();
                if (CameraError.m356isDisconnectedimpl(cameraState.m863getCameraErrorCodemVEW8x0().m358unboximpl())) {
                    this.controllerState = CameraController.ControllerState.DISCONNECTED.INSTANCE;
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, this + " is disconnected");
                    }
                } else {
                    this.controllerState = CameraController.ControllerState.ERROR.INSTANCE;
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, this + " encountered error: " + ((Object) CameraError.m357toStringimpl(cameraState.m863getCameraErrorCodemVEW8x0().m358unboximpl())));
                    }
                }
            } else {
                this.controllerState = CameraController.ControllerState.STOPPED.INSTANCE;
            }
            this.surfaceTracker.unregisterAllSurfaces();
            tryRestart();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void detachSessionAndCamera(CaptureSessionState session, VirtualCamera camera) {
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new Camera2CameraController$detachSessionAndCamera$job$1(session, camera, null), 3, null);
        if (Intrinsics.areEqual(this.controllerState, CameraController.ControllerState.CLOSING.INSTANCE)) {
            jobLaunch$default.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraController$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Camera2CameraController.detachSessionAndCamera$lambda$0(this.f$0, (Throwable) obj);
                }
            });
        }
    }

    static final Unit detachSessionAndCamera$lambda$0(Camera2CameraController camera2CameraController, Throwable th) {
        synchronized (camera2CameraController.lock) {
            camera2CameraController.controllerState = CameraController.ControllerState.CLOSED.INSTANCE;
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, camera2CameraController + " is closed");
            }
            Unit unit = Unit.INSTANCE;
        }
        camera2CameraController.shutdownListener.onControllerClosed(camera2CameraController);
        camera2CameraController.closedDeferred.complete(Unit.INSTANCE);
        CoroutineScopeKt.cancel$default(camera2CameraController.scope, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isClosed() {
        return Intrinsics.areEqual(this.controllerState, CameraController.ControllerState.CLOSING.INSTANCE) || Intrinsics.areEqual(this.controllerState, CameraController.ControllerState.CLOSED.INSTANCE);
    }

    /* JADX INFO: compiled from: Camera2CameraController.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraController$Companion;", "", "<init>", "()V", "RESTART_TIMEOUT_WHEN_ENABLED_MS", "", "MS_TO_NS", "", "PRIORITIES_CHANGED_THRESHOLD_NS", "Landroidx/camera/camera2/pipe/core/DurationNs;", "J", "shouldRestart", "", "controllerState", "Landroidx/camera/camera2/pipe/CameraController$ControllerState;", "lastCameraError", "Landroidx/camera/camera2/pipe/CameraError;", "cameraAvailability", "Landroidx/camera/camera2/pipe/internal/CameraStatusMonitor$CameraStatus;", "lastCameraPrioritiesChangedTs", "Landroidx/camera/camera2/pipe/core/TimestampNs;", "currentTs", "shouldRestart-X9Wt83s$camera_camera2_pipe", "(Landroidx/camera/camera2/pipe/CameraController$ControllerState;Landroidx/camera/camera2/pipe/CameraError;Landroidx/camera/camera2/pipe/internal/CameraStatusMonitor$CameraStatus;Landroidx/camera/camera2/pipe/core/TimestampNs;J)Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0026  */
        /* JADX INFO: renamed from: shouldRestart-X9Wt83s$camera_camera2_pipe, reason: not valid java name */
        public final boolean m825shouldRestartX9Wt83s$camera_camera2_pipe(CameraController.ControllerState controllerState, CameraError lastCameraError, CameraStatusMonitor.CameraStatus cameraAvailability, TimestampNs lastCameraPrioritiesChangedTs, long currentTs) {
            boolean z;
            Intrinsics.checkNotNullParameter(controllerState, "controllerState");
            Intrinsics.checkNotNullParameter(cameraAvailability, "cameraAvailability");
            if (cameraAvailability instanceof CameraStatusMonitor.CameraStatus.CameraAvailable) {
                if (lastCameraError == null ? false : CameraError.m354equalsimpl0(lastCameraError.m358unboximpl(), CameraError.INSTANCE.m363getERROR_CAMERA_DISABLEDv7Vf74A())) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            boolean z2 = lastCameraPrioritiesChangedTs != null && DurationNs.m916compareTozYRVrok(DurationNs.m917constructorimpl(currentTs - lastCameraPrioritiesChangedTs.m936unboximpl()), Camera2CameraController.PRIORITIES_CHANGED_THRESHOLD_NS) <= 0;
            if (Intrinsics.areEqual(controllerState, CameraController.ControllerState.DISCONNECTED.INSTANCE)) {
                if (!z && !z2) {
                    int i = Build.VERSION.SDK_INT;
                    if (29 <= i && i < 33) {
                        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                            android.util.Log.d(Log.TAG, "Quirk for multi-resume activated: Kicking off restart.");
                        }
                    }
                }
                return true;
            }
            if (Intrinsics.areEqual(controllerState, CameraController.ControllerState.ERROR.INSTANCE) && z) {
                if (!(lastCameraError == null ? false : CameraError.m354equalsimpl0(lastCameraError.m358unboximpl(), CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A()))) {
                    if (!(lastCameraError == null ? false : CameraError.m354equalsimpl0(lastCameraError.m358unboximpl(), CameraError.INSTANCE.m373getERROR_SECURITY_EXCEPTIONv7Vf74A()))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
