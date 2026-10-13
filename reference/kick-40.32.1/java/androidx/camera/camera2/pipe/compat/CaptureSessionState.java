package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraExtensionSession;
import android.os.Build;
import android.os.Trace;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.CameraSurfaceManager;
import androidx.camera.camera2.pipe.CaptureSequenceProcessor;
import androidx.camera.camera2.pipe.GraphState;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.core.TimestampNs;
import androidx.camera.camera2.pipe.core.Timestamps;
import androidx.camera.camera2.pipe.graph.GraphListener;
import androidx.camera.camera2.pipe.graph.GraphRequestProcessor;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CaptureSessionState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 e2\u00020\u0001:\u0003cdeBa\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010D\u001a\u00020E2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020%0&J\b\u0010G\u001a\u0004\u0018\u00010HJ\u0010\u0010I\u001a\u00020E2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020E2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010M\u001a\u00020E2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010N\u001a\u00020E2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010O\u001a\u00020E2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010P\u001a\u00020E2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010Q\u001a\u00020EH\u0016J\b\u0010R\u001a\u00020EH\u0016J\u0012\u0010S\u001a\u00020E2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u0006\u0010T\u001a\u00020EJ\u0006\u0010U\u001a\u00020EJ\u0017\u0010V\u001a\u00020E2\b\b\u0002\u0010W\u001a\u00020XH\u0000¢\u0006\u0002\bYJ\u0012\u0010Z\u001a\u00020E2\b\b\u0002\u0010[\u001a\u00020 H\u0002J\u000e\u0010\\\u001a\u00020EH\u0082@¢\u0006\u0002\u0010]J0\u0010^\u001a\u00020E2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020%0&2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020%0&H\u0003J\b\u0010a\u001a\u00020bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010!\u001aB\u0012\f\u0012\n $*\u0004\u0018\u00010#0#\u0012\f\u0012\n $*\u0004\u0018\u00010%0% $* \u0012\f\u0012\n $*\u0004\u0018\u00010#0#\u0012\f\u0012\n $*\u0004\u0018\u00010%0%\u0018\u00010&0\"X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010'\u001aB\u0012\f\u0012\n $*\u0004\u0018\u00010(0(\u0012\f\u0012\n $*\u0004\u0018\u00010%0% $* \u0012\f\u0012\n $*\u0004\u0018\u00010(0(\u0012\f\u0012\n $*\u0004\u0018\u00010%0%\u0018\u00010&0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R(\u00100\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00105\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u00107\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000208\u0018\u00010&8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u00109\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020%\u0018\u00010&8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010@\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020%\u0018\u00010&8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010A\u001a\u0012\u0012\u0004\u0012\u00020%\u0012\b\u0012\u00060Bj\u0002`C0\"8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper$StateCallback;", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", "captureSessionFactory", "Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory;", "captureSequenceProcessorFactory", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessorFactory;", "cameraSurfaceManager", "Landroidx/camera/camera2/pipe/CameraSurfaceManager;", "timeSource", "Landroidx/camera/camera2/pipe/core/TimeSource;", "cameraGraphFlags", "Landroidx/camera/camera2/pipe/CameraGraph$Flags;", "concurrentSessionSequencer", "Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencer;", "streamGraph", "Landroidx/camera/camera2/pipe/StreamGraph;", "strictMode", "Landroidx/camera/camera2/pipe/StrictMode;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/camera/camera2/pipe/graph/GraphListener;Landroidx/camera/camera2/pipe/compat/CaptureSessionFactory;Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessorFactory;Landroidx/camera/camera2/pipe/CameraSurfaceManager;Landroidx/camera/camera2/pipe/core/TimeSource;Landroidx/camera/camera2/pipe/CameraGraph$Flags;Landroidx/camera/camera2/pipe/compat/ConcurrentSessionSequencer;Landroidx/camera/camera2/pipe/StreamGraph;Landroidx/camera/camera2/pipe/StrictMode;Landroidx/camera/camera2/pipe/core/Threads;Lkotlinx/coroutines/CoroutineScope;)V", "debugId", "", "lock", "", "finalized", "Lkotlinx/atomicfu/AtomicRef;", "", "activeStreamSurfaceMap", "", "Landroidx/camera/camera2/pipe/StreamId;", "kotlin.jvm.PlatformType", "Landroid/view/Surface;", "", "activeOutputSurfaceMap", "Landroidx/camera/camera2/pipe/OutputId;", "sessionCreatingTimestamp", "Landroidx/camera/camera2/pipe/core/TimestampNs;", "sessionSequencer", "Landroidx/camera/camera2/pipe/compat/SessionSequencer;", "_cameraDevice", "Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "value", "cameraDevice", "getCameraDevice", "()Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;", "setCameraDevice", "(Landroidx/camera/camera2/pipe/compat/CameraDeviceWrapper;)V", "cameraCaptureSession", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState$ConfiguredCameraCaptureSession;", "pendingOutputMap", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "pendingSurfaceMap", "state", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState$State;", "sessionDisconnected", "Ljava/util/concurrent/CountDownLatch;", "hasAttemptedCaptureSession", "captureSessionAttemptCompleted", "_surfaceMap", "_surfaceTokenMap", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "configureSurfaceMap", "", "surfaces", "getRealtimeCaptureLatency", "Landroid/hardware/camera2/CameraExtensionSession$StillCaptureLatency;", "onActive", "session", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;", "onClosed", "onConfigureFailed", "onConfigured", "onReady", "onCaptureQueueEmpty", "onSessionDisconnected", "onSessionFinalized", "configure", "disconnect", "shutdown", "finalizeSession", "delayMs", "", "finalizeSession$camera_camera2_pipe", "finalizeOutputsIfAvailable", "retryAllowed", "tryCreateCaptureSession", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrackedSurfaces", "oldSurfaceMap", "newSurfaceMap", "toString", "", "State", "ConfiguredCameraCaptureSession", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureSessionState implements CameraCaptureSessionWrapper.StateCallback {

    @Deprecated
    public static final long ABORT_CAPTURES_TIMEOUT_MS = 2000;

    @Deprecated
    public static final long CAPTURE_SESSION_TIMEOUT_MS = 3000;

    @Deprecated
    public static final long CLOSE_SESSION_TIMEOUT_MS = 3000;
    private static final Companion Companion = new Companion(null);
    private CameraDeviceWrapper _cameraDevice;
    private Map<StreamId, ? extends Surface> _surfaceMap;
    private final Map<Surface, AutoCloseable> _surfaceTokenMap;
    private final Map<OutputId, Surface> activeOutputSurfaceMap;
    private final Map<StreamId, Surface> activeStreamSurfaceMap;
    private ConfiguredCameraCaptureSession cameraCaptureSession;
    private final CameraGraph.Flags cameraGraphFlags;
    private final CameraSurfaceManager cameraSurfaceManager;
    private final Camera2CaptureSequenceProcessorFactory captureSequenceProcessorFactory;
    private final CountDownLatch captureSessionAttemptCompleted;
    private final CaptureSessionFactory captureSessionFactory;
    private final ConcurrentSessionSequencer concurrentSessionSequencer;
    private final int debugId;
    private final AtomicRef<Boolean> finalized;
    private final GraphListener graphListener;
    private boolean hasAttemptedCaptureSession;
    private final Object lock;
    private Map<StreamId, ? extends OutputConfigurationWrapper> pendingOutputMap;
    private Map<StreamId, ? extends Surface> pendingSurfaceMap;
    private final CoroutineScope scope;
    private TimestampNs sessionCreatingTimestamp;
    private final CountDownLatch sessionDisconnected;
    private final SessionSequencer sessionSequencer;
    private State state;
    private final StreamGraph streamGraph;
    private final StrictMode strictMode;
    private final Threads threads;
    private final TimeSource timeSource;

    /* JADX INFO: compiled from: CaptureSessionState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionState$State;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "CREATING", DebugCoroutineInfoImplKt.CREATED, "CLOSING", "CLOSED", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private enum State {
        PENDING,
        CREATING,
        CREATED,
        CLOSING,
        CLOSED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.CaptureSessionState$tryCreateCaptureSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSessionState.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.CaptureSessionState", f = "CaptureSessionState.kt", i = {0, 0}, l = {567}, m = "tryCreateCaptureSession", n = {"surfaces", "device"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureSessionState.this.tryCreateCaptureSession(this);
        }
    }

    public CaptureSessionState(GraphListener graphListener, CaptureSessionFactory captureSessionFactory, Camera2CaptureSequenceProcessorFactory captureSequenceProcessorFactory, CameraSurfaceManager cameraSurfaceManager, TimeSource timeSource, CameraGraph.Flags cameraGraphFlags, ConcurrentSessionSequencer concurrentSessionSequencer, StreamGraph streamGraph, StrictMode strictMode, Threads threads, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(captureSessionFactory, "captureSessionFactory");
        Intrinsics.checkNotNullParameter(captureSequenceProcessorFactory, "captureSequenceProcessorFactory");
        Intrinsics.checkNotNullParameter(cameraSurfaceManager, "cameraSurfaceManager");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(cameraGraphFlags, "cameraGraphFlags");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        Intrinsics.checkNotNullParameter(strictMode, "strictMode");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.graphListener = graphListener;
        this.captureSessionFactory = captureSessionFactory;
        this.captureSequenceProcessorFactory = captureSequenceProcessorFactory;
        this.cameraSurfaceManager = cameraSurfaceManager;
        this.timeSource = timeSource;
        this.cameraGraphFlags = cameraGraphFlags;
        this.concurrentSessionSequencer = concurrentSessionSequencer;
        this.streamGraph = streamGraph;
        this.strictMode = strictMode;
        this.threads = threads;
        this.scope = scope;
        this.debugId = CaptureSessionStateKt.getCaptureSessionDebugIds().incrementAndGet();
        this.lock = new Object();
        this.finalized = AtomicFU.atomic(false);
        this.activeStreamSurfaceMap = Collections.synchronizedMap(new HashMap());
        this.activeOutputSurfaceMap = Collections.synchronizedMap(new HashMap());
        this.sessionSequencer = concurrentSessionSequencer != null ? new SessionSequencer(concurrentSessionSequencer) : null;
        this.state = State.PENDING;
        this.sessionDisconnected = new CountDownLatch(1);
        this.captureSessionAttemptCompleted = new CountDownLatch(1);
        this._surfaceTokenMap = new LinkedHashMap();
    }

    public final CameraDeviceWrapper getCameraDevice() {
        CameraDeviceWrapper cameraDeviceWrapper;
        synchronized (this.lock) {
            cameraDeviceWrapper = this._cameraDevice;
        }
        return cameraDeviceWrapper;
    }

    public final void setCameraDevice(CameraDeviceWrapper cameraDeviceWrapper) {
        synchronized (this.lock) {
            if (this.state != State.CLOSING && this.state != State.CLOSED) {
                this._cameraDevice = cameraDeviceWrapper;
                if (cameraDeviceWrapper != null) {
                    BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CaptureSessionState$cameraDevice$2$1(this, null), 3, null);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void configureSurfaceMap(Map<StreamId, ? extends Surface> surfaces) {
        Intrinsics.checkNotNullParameter(surfaces, "surfaces");
        synchronized (this.lock) {
            if (this.state != State.CLOSING && this.state != State.CLOSED) {
                Map<StreamId, ? extends Surface> mapEmptyMap = this._surfaceMap;
                if (mapEmptyMap == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                updateTrackedSurfaces(mapEmptyMap, surfaces);
                this._surfaceMap = surfaces;
                Map<StreamId, ? extends OutputConfigurationWrapper> map = this.pendingOutputMap;
                if (map != null && this.pendingSurfaceMap == null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<StreamId, ? extends Surface> entry : surfaces.entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    if (linkedHashMap.size() == map.size()) {
                        this.pendingSurfaceMap = linkedHashMap;
                        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CaptureSessionState$configureSurfaceMap$1$1(this, null), 3, null);
                    }
                }
                BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CaptureSessionState$configureSurfaceMap$1$2(this, null), 3, null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final CameraExtensionSession.StillCaptureLatency getRealtimeCaptureLatency() {
        if (Build.VERSION.SDK_INT >= 31) {
            ConfiguredCameraCaptureSession configuredCameraCaptureSession = this.cameraCaptureSession;
            CameraCaptureSessionWrapper session = configuredCameraCaptureSession != null ? configuredCameraCaptureSession.getSession() : null;
            AndroidCameraExtensionSession androidCameraExtensionSession = session instanceof AndroidCameraExtensionSession ? (AndroidCameraExtensionSession) session : null;
            if (androidCameraExtensionSession != null) {
                return androidCameraExtensionSession.getRealTimeCaptureLatency();
            }
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
    public void onActive(CameraCaptureSessionWrapper session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " Active");
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
    public void onClosed(CameraCaptureSessionWrapper session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " Closed");
        }
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(this + "#onClosed");
        shutdown();
        this.captureSessionAttemptCompleted.countDown();
        SessionSequencer sessionSequencer = this.sessionSequencer;
        if (sessionSequencer != null) {
            sessionSequencer.release();
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
    public void onConfigureFailed(CameraCaptureSessionWrapper session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, this + " Configuration Failed");
        }
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(this + "#onConfigureFailed");
        this.graphListener.onGraphError(new GraphState.GraphStateError(CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A(), false, null));
        shutdown();
        this.captureSessionAttemptCompleted.countDown();
        SessionSequencer sessionSequencer = this.sessionSequencer;
        if (sessionSequencer != null) {
            sessionSequencer.release();
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
    public void onConfigured(CameraCaptureSessionWrapper session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " Configured");
        }
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(this + "#configure");
        configure(session);
        this.captureSessionAttemptCompleted.countDown();
        SessionSequencer sessionSequencer = this.sessionSequencer;
        if (sessionSequencer != null) {
            sessionSequencer.release();
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
    public void onReady(CameraCaptureSessionWrapper session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " Ready");
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.CameraCaptureSessionWrapper.StateCallback
    public void onCaptureQueueEmpty(CameraCaptureSessionWrapper session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " CaptureQueueEmpty");
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.SessionStateCallback
    public void onSessionDisconnected() {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + " session disconnecting");
        }
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(this + "#onSessionDisconnected");
        disconnect();
        Debug debug2 = Debug.INSTANCE;
        try {
            Trace.beginSection(this + "#onSessionDisconnected Await");
            this.sessionDisconnected.await();
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Debug debug3 = Debug.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.SessionStateCallback
    public void onSessionFinalized() {
        if (this.finalized.compareAndSet(false, true)) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, this + " session finalizing");
            }
            Debug debug = Debug.INSTANCE;
            Trace.beginSection(this + "#onSessionFinalized");
            shutdown();
            finalizeSession$camera_camera2_pipe(0L);
            Debug debug2 = Debug.INSTANCE;
            Trace.endSection();
        }
    }

    private final void configure(CameraCaptureSessionWrapper session) {
        ConfiguredCameraCaptureSession configuredCameraCaptureSession;
        synchronized (this.lock) {
            ConfiguredCameraCaptureSession configuredCameraCaptureSession2 = this.cameraCaptureSession;
            if (configuredCameraCaptureSession2 == null && session != null) {
                Camera2CaptureSequenceProcessorFactory camera2CaptureSequenceProcessorFactory = this.captureSequenceProcessorFactory;
                Map<StreamId, Surface> activeStreamSurfaceMap = this.activeStreamSurfaceMap;
                Intrinsics.checkNotNullExpressionValue(activeStreamSurfaceMap, "activeStreamSurfaceMap");
                Map<OutputId, Surface> activeOutputSurfaceMap = this.activeOutputSurfaceMap;
                Intrinsics.checkNotNullExpressionValue(activeOutputSurfaceMap, "activeOutputSurfaceMap");
                CaptureSequenceProcessor<?, ?> captureSequenceProcessorCreate = camera2CaptureSequenceProcessorFactory.create(session, activeStreamSurfaceMap, activeOutputSurfaceMap);
                if (captureSequenceProcessorCreate instanceof Camera2CaptureSequenceProcessor) {
                    configuredCameraCaptureSession = new ConfiguredCameraCaptureSession(session, GraphRequestProcessor.INSTANCE.from(captureSequenceProcessorCreate), (Camera2CaptureSequenceProcessor) captureSequenceProcessorCreate);
                } else {
                    configuredCameraCaptureSession = new ConfiguredCameraCaptureSession(session, GraphRequestProcessor.INSTANCE.from(captureSequenceProcessorCreate), null);
                }
                configuredCameraCaptureSession2 = configuredCameraCaptureSession;
                this.cameraCaptureSession = configuredCameraCaptureSession2;
            }
            if (this.state == State.CREATED && configuredCameraCaptureSession2 != null) {
                boolean z = (this.pendingOutputMap == null || this.pendingSurfaceMap == null) ? false : true;
                Unit unit = Unit.INSTANCE;
                if (z) {
                    finalizeOutputsIfAvailable(false);
                }
                synchronized (this.lock) {
                    if (Log.INSTANCE.getINFO_LOGGABLE()) {
                        Timestamps timestamps = Timestamps.INSTANCE;
                        long jMo927nowvQl9yQU = this.timeSource.mo927nowvQl9yQU();
                        TimestampNs timestampNs = this.sessionCreatingTimestamp;
                        Intrinsics.checkNotNull(timestampNs);
                        long jM917constructorimpl = DurationNs.m917constructorimpl(jMo927nowvQl9yQU - timestampNs.m936unboximpl());
                        StringBuilder sb = new StringBuilder("Configured ");
                        sb.append(this);
                        sb.append(" in ");
                        Timestamps timestamps2 = Timestamps.INSTANCE;
                        String str = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        sb.append(str);
                        android.util.Log.i(Log.TAG, sb.toString());
                    }
                    this.graphListener.onGraphStarted(configuredCameraCaptureSession2.getProcessor());
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    public final void disconnect() {
        synchronized (this.lock) {
            if (this.state != State.CLOSING && this.state != State.CLOSED) {
                this.state = State.CLOSING;
                ConfiguredCameraCaptureSession configuredCameraCaptureSession = this.cameraCaptureSession;
                boolean z = false;
                if (configuredCameraCaptureSession != null) {
                    this.cameraCaptureSession = null;
                } else {
                    if (this.cameraGraphFlags.getCloseCaptureSessionOnDisconnect() && this.hasAttemptedCaptureSession) {
                        z = true;
                    }
                    configuredCameraCaptureSession = null;
                }
                Unit unit = Unit.INSTANCE;
                SessionSequencer sessionSequencer = this.sessionSequencer;
                if (sessionSequencer != null) {
                    sessionSequencer.release();
                }
                if (z) {
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "Waiting for CameraCaptureSession configuration");
                    }
                    if (((Unit) this.threads.runBlockingCheckedOrNull(3000L, new AnonymousClass3(null))) == null && Log.INSTANCE.getERROR_LOGGABLE()) {
                        android.util.Log.e(Log.TAG, "Waiting for CameraCaptureSession configuration timed out");
                    }
                    synchronized (this.lock) {
                        configuredCameraCaptureSession = this.cameraCaptureSession;
                        this.cameraCaptureSession = null;
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                Debug debug = Debug.INSTANCE;
                Trace.beginSection(this.graphListener + "#onGraphStopping");
                this.graphListener.onGraphStopping();
                Debug debug2 = Debug.INSTANCE;
                Trace.endSection();
                if (configuredCameraCaptureSession != null) {
                    GraphRequestProcessor processor = configuredCameraCaptureSession.getProcessor();
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, this + " Shutdown");
                    }
                    Debug debug3 = Debug.INSTANCE;
                    Trace.beginSection(this + "#shutdown");
                    if (this.cameraGraphFlags.getAbortCapturesOnStop() && ((Unit) this.threads.runBlockingCheckedOrNull(2000L, new AnonymousClass9(processor, null))) == null && Log.INSTANCE.getERROR_LOGGABLE()) {
                        android.util.Log.e(Log.TAG, "Failed to abort captures in 2000ms");
                    }
                    Debug debug4 = Debug.INSTANCE;
                    Trace.beginSection(this + "#disconnect");
                    Camera2CaptureSequenceProcessor captureSequenceProcessor = configuredCameraCaptureSession.getCaptureSequenceProcessor();
                    if (captureSequenceProcessor != null) {
                        captureSequenceProcessor.disconnect$camera_camera2_pipe();
                    }
                    Debug debug5 = Debug.INSTANCE;
                    Trace.endSection();
                    if (this.cameraGraphFlags.getCloseCaptureSessionOnDisconnect() && ((Unit) this.threads.runBlockingCheckedOrNull(3000L, new AnonymousClass12(configuredCameraCaptureSession, null))) == null && Log.INSTANCE.getERROR_LOGGABLE()) {
                        android.util.Log.e(Log.TAG, "Failed to close the capture session in 3000ms");
                    }
                    Debug debug6 = Debug.INSTANCE;
                    Trace.beginSection(this.graphListener + "#onGraphStopped");
                    this.graphListener.onGraphStopped(processor);
                    Debug debug7 = Debug.INSTANCE;
                    Trace.endSection();
                    Debug debug8 = Debug.INSTANCE;
                    Trace.endSection();
                } else {
                    Debug debug9 = Debug.INSTANCE;
                    Trace.beginSection(this.graphListener + "#onGraphStopped");
                    this.graphListener.onGraphStopped(null);
                    Debug debug10 = Debug.INSTANCE;
                    Trace.endSection();
                }
                this.sessionDisconnected.countDown();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.CaptureSessionState$disconnect$3, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSessionState.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.CaptureSessionState$disconnect$3", f = "CaptureSessionState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureSessionState.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws InterruptedException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CaptureSessionState.this.captureSessionAttemptCompleted.await();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.CaptureSessionState$disconnect$9, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSessionState.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.CaptureSessionState$disconnect$9", f = "CaptureSessionState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphRequestProcessor $graphProcessor;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(GraphRequestProcessor graphRequestProcessor, Continuation<? super AnonymousClass9> continuation) {
            super(1, continuation);
            this.$graphProcessor = graphRequestProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureSessionState.this.new AnonymousClass9(this.$graphProcessor, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Debug debug = Debug.INSTANCE;
            String str = CaptureSessionState.this + " stopRepeating";
            GraphRequestProcessor graphRequestProcessor = this.$graphProcessor;
            try {
                Trace.beginSection(str);
                graphRequestProcessor.stopRepeating$camera_camera2_pipe();
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                Debug debug2 = Debug.INSTANCE;
                String str2 = CaptureSessionState.this + " abortCaptures";
                GraphRequestProcessor graphRequestProcessor2 = this.$graphProcessor;
                try {
                    Trace.beginSection(str2);
                    graphRequestProcessor2.abortCaptures$camera_camera2_pipe();
                    Unit unit2 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.CaptureSessionState$disconnect$12, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSessionState.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.CaptureSessionState$disconnect$12", f = "CaptureSessionState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass12 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ConfiguredCameraCaptureSession $captureSession;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass12(ConfiguredCameraCaptureSession configuredCameraCaptureSession, Continuation<? super AnonymousClass12> continuation) {
            super(1, continuation);
            this.$captureSession = configuredCameraCaptureSession;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureSessionState.this.new AnonymousClass12(this.$captureSession, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass12) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Debug debug = Debug.INSTANCE;
            String str = CaptureSessionState.this + " CameraCaptureSessionWrapper#close";
            ConfiguredCameraCaptureSession configuredCameraCaptureSession = this.$captureSession;
            CaptureSessionState captureSessionState = CaptureSessionState.this;
            try {
                Trace.beginSection(str);
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Closing capture session for " + captureSessionState);
                }
                UByte$$ExternalSyntheticBackport0.m12761m((Object) configuredCameraCaptureSession.getSession());
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                Trace.endSection();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003a  */
    public final void shutdown() {
        long j;
        boolean z;
        disconnect();
        synchronized (this.lock) {
            j = 0;
            if (this.state != State.CLOSED) {
                z = true;
                if (this._cameraDevice != null && this.hasAttemptedCaptureSession) {
                    int iM395getFinalizeSessionOnCloseBehaviorBm6Tfm4 = this.cameraGraphFlags.m395getFinalizeSessionOnCloseBehaviorBm6Tfm4();
                    if (!CameraGraph.Flags.FinalizeSessionOnCloseBehavior.m399equalsimpl0(iM395getFinalizeSessionOnCloseBehaviorBm6Tfm4, CameraGraph.Flags.FinalizeSessionOnCloseBehavior.INSTANCE.m403getIMMEDIATEBm6Tfm4())) {
                        if (CameraGraph.Flags.FinalizeSessionOnCloseBehavior.m399equalsimpl0(iM395getFinalizeSessionOnCloseBehaviorBm6Tfm4, CameraGraph.Flags.FinalizeSessionOnCloseBehavior.INSTANCE.m405getTIMEOUTBm6Tfm4())) {
                            j = 2000;
                        } else {
                            z = false;
                        }
                    }
                }
            } else {
                z = false;
            }
            this._cameraDevice = null;
            this.state = State.CLOSED;
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            finalizeSession$camera_camera2_pipe(j);
        }
    }

    public static /* synthetic */ void finalizeSession$camera_camera2_pipe$default(CaptureSessionState captureSessionState, long j, int i, Object obj) throws Exception {
        if ((i & 1) != 0) {
            j = 0;
        }
        captureSessionState.finalizeSession$camera_camera2_pipe(j);
    }

    public final void finalizeSession$camera_camera2_pipe(long delayMs) throws Exception {
        List list;
        if (delayMs != 0) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CaptureSessionState$finalizeSession$1(delayMs, this, null), 3, null);
            return;
        }
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "Finalizing " + this);
        }
        synchronized (this.lock) {
            list = CollectionsKt.toList(this._surfaceTokenMap.values());
            this._surfaceTokenMap.clear();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UByte$$ExternalSyntheticBackport0.m12761m(it.next());
        }
    }

    static /* synthetic */ void finalizeOutputsIfAvailable$default(CaptureSessionState captureSessionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        captureSessionState.finalizeOutputsIfAvailable(z);
    }

    private final void finalizeOutputsIfAvailable(boolean retryAllowed) {
        ConfiguredCameraCaptureSession configuredCameraCaptureSession;
        Map<StreamId, ? extends OutputConfigurationWrapper> map;
        Map<StreamId, ? extends Surface> map2;
        boolean z;
        synchronized (this.lock) {
            configuredCameraCaptureSession = this.cameraCaptureSession;
            map = this.pendingOutputMap;
            map2 = this.pendingSurfaceMap;
            Unit unit = Unit.INSTANCE;
        }
        if (configuredCameraCaptureSession == null || map == null || map2 == null) {
            return;
        }
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(this + "#finalizeOutputConfigurations");
        Timestamps timestamps = Timestamps.INSTANCE;
        long jMo927nowvQl9yQU = this.timeSource.mo927nowvQl9yQU();
        for (Map.Entry<StreamId, ? extends OutputConfigurationWrapper> entry : map.entrySet()) {
            int iM797unboximpl = entry.getKey().m797unboximpl();
            OutputConfigurationWrapper value = entry.getValue();
            Surface surface = map2.get(StreamId.m791boximpl(iM797unboximpl));
            if (surface == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            value.addSurface(surface);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Map.Entry<StreamId, ? extends OutputConfigurationWrapper>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next().getValue());
        }
        configuredCameraCaptureSession.getSession().finalizeOutputConfigurations(CollectionsKt.toList(linkedHashSet));
        synchronized (this.lock) {
            if (this.state == State.CREATED) {
                this.activeStreamSurfaceMap.putAll(map2);
                Iterator<Map.Entry<StreamId, ? extends Surface>> it2 = map2.entrySet().iterator();
                while (true) {
                    z = true;
                    if (!it2.hasNext()) {
                        if (!Log.INSTANCE.getINFO_LOGGABLE()) {
                            break;
                        }
                        Timestamps timestamps2 = Timestamps.INSTANCE;
                        long jM917constructorimpl = DurationNs.m917constructorimpl(this.timeSource.mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Finalized ");
                        ArrayList arrayList = new ArrayList(map.size());
                        Iterator<Map.Entry<StreamId, ? extends OutputConfigurationWrapper>> it3 = map.entrySet().iterator();
                        while (it3.hasNext()) {
                            arrayList.add(StreamId.m791boximpl(it3.next().getKey().m797unboximpl()));
                        }
                        sb.append(arrayList);
                        sb.append(" for ");
                        sb.append(this);
                        sb.append(" in ");
                        Timestamps timestamps3 = Timestamps.INSTANCE;
                        String str = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        sb.append(str);
                        android.util.Log.i(Log.TAG, sb.toString());
                        break;
                    }
                    Map.Entry<StreamId, ? extends Surface> next = it2.next();
                    int iM797unboximpl2 = next.getKey().m797unboximpl();
                    Surface value2 = next.getValue();
                    CameraStream cameraStreamM784getaKI5c8E = this.streamGraph.m784getaKI5c8E(iM797unboximpl2);
                    if (cameraStreamM784getaKI5c8E == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    if (cameraStreamM784getaKI5c8E.getOutputs().size() != 1) {
                        throw new IllegalStateException("Cannot finalize a multi-output stream!".toString());
                    }
                    Map<OutputId, Surface> activeOutputSurfaceMap = this.activeOutputSurfaceMap;
                    Intrinsics.checkNotNullExpressionValue(activeOutputSurfaceMap, "activeOutputSurfaceMap");
                    activeOutputSurfaceMap.put(OutputId.m571boximpl(((OutputStream) CollectionsKt.single((List) cameraStreamM784getaKI5c8E.getOutputs())).getId()), value2);
                }
            } else {
                z = false;
            }
            Unit unit2 = Unit.INSTANCE;
        }
        if (z && retryAllowed) {
            this.graphListener.onGraphModified(configuredCameraCaptureSession.getProcessor());
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:112:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x01f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x01e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:56:0x012b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0133  */
    /* JADX WARN: Code duplicated, block: B:61:0x014e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0165 A[Catch: all -> 0x0263, TryCatch #0 {, blocks: (B:63:0x0151, B:65:0x0157, B:68:0x015f, B:70:0x0165, B:72:0x018d, B:74:0x0195, B:75:0x01ce, B:77:0x01d4, B:78:0x01e3, B:80:0x01e9, B:82:0x01f9, B:85:0x0208, B:87:0x0212, B:88:0x0214, B:92:0x021d, B:93:0x0234, B:94:0x0235, B:96:0x023d, B:97:0x025f), top: B:112:0x0151 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x018d A[Catch: all -> 0x0263, TryCatch #0 {, blocks: (B:63:0x0151, B:65:0x0157, B:68:0x015f, B:70:0x0165, B:72:0x018d, B:74:0x0195, B:75:0x01ce, B:77:0x01d4, B:78:0x01e3, B:80:0x01e9, B:82:0x01f9, B:85:0x0208, B:87:0x0212, B:88:0x0214, B:92:0x021d, B:93:0x0234, B:94:0x0235, B:96:0x023d, B:97:0x025f), top: B:112:0x0151 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0195 A[Catch: all -> 0x0263, TryCatch #0 {, blocks: (B:63:0x0151, B:65:0x0157, B:68:0x015f, B:70:0x0165, B:72:0x018d, B:74:0x0195, B:75:0x01ce, B:77:0x01d4, B:78:0x01e3, B:80:0x01e9, B:82:0x01f9, B:85:0x0208, B:87:0x0212, B:88:0x0214, B:92:0x021d, B:93:0x0234, B:94:0x0235, B:96:0x023d, B:97:0x025f), top: B:112:0x0151 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01d4 A[Catch: all -> 0x0263, TryCatch #0 {, blocks: (B:63:0x0151, B:65:0x0157, B:68:0x015f, B:70:0x0165, B:72:0x018d, B:74:0x0195, B:75:0x01ce, B:77:0x01d4, B:78:0x01e3, B:80:0x01e9, B:82:0x01f9, B:85:0x0208, B:87:0x0212, B:88:0x0214, B:92:0x021d, B:93:0x0234, B:94:0x0235, B:96:0x023d, B:97:0x025f), top: B:112:0x0151 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e9 A[Catch: all -> 0x0263, TryCatch #0 {, blocks: (B:63:0x0151, B:65:0x0157, B:68:0x015f, B:70:0x0165, B:72:0x018d, B:74:0x0195, B:75:0x01ce, B:77:0x01d4, B:78:0x01e3, B:80:0x01e9, B:82:0x01f9, B:85:0x0208, B:87:0x0212, B:88:0x0214, B:92:0x021d, B:93:0x0234, B:94:0x0235, B:96:0x023d, B:97:0x025f), top: B:112:0x0151 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0205  */
    /* JADX WARN: Code duplicated, block: B:92:0x021d A[Catch: all -> 0x0263, TRY_ENTER, TryCatch #0 {, blocks: (B:63:0x0151, B:65:0x0157, B:68:0x015f, B:70:0x0165, B:72:0x018d, B:74:0x0195, B:75:0x01ce, B:77:0x01d4, B:78:0x01e3, B:80:0x01e9, B:82:0x01f9, B:85:0x0208, B:87:0x0212, B:88:0x0214, B:92:0x021d, B:93:0x0234, B:94:0x0235, B:96:0x023d, B:97:0x025f), top: B:112:0x0151 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x023d A[Catch: all -> 0x0263, TryCatch #0 {, blocks: (B:63:0x0151, B:65:0x0157, B:68:0x015f, B:70:0x0165, B:72:0x018d, B:74:0x0195, B:75:0x01ce, B:77:0x01d4, B:78:0x01e3, B:80:0x01e9, B:82:0x01f9, B:85:0x0208, B:87:0x0212, B:88:0x0214, B:92:0x021d, B:93:0x0234, B:94:0x0235, B:96:0x023d, B:97:0x025f), top: B:112:0x0151 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x0133, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:74:0x0195, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:92:0x021d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:96:0x023d, please report this as an issue */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, java.util.Map<androidx.camera.camera2.pipe.StreamId, ? extends android.view.Surface>] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, androidx.camera.camera2.pipe.compat.CameraDeviceWrapper] */
    public final Object tryCreateCaptureSession(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        CameraDeviceWrapper cameraDeviceWrapper;
        String strMo802getCameraIdDz_R5H8;
        CaptureSessionFactory.Result resultCreate;
        Map<StreamId, OutputConfigurationWrapper> deferred;
        Map<StreamId, ? extends Surface> map;
        LinkedHashMap linkedHashMap;
        CameraDeviceWrapper cameraDeviceWrapper2;
        String strMo802getCameraIdDz_R5H9;
        String strM432toStringimpl;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef2 = new Ref.ObjectRef();
                synchronized (this.lock) {
                    if (this.state != State.PENDING) {
                        return Unit.INSTANCE;
                    }
                    objectRef.element = this._surfaceMap;
                    objectRef2.element = this._cameraDevice;
                    if (objectRef.element != 0 && objectRef2.element != 0) {
                        this.state = State.CREATING;
                        this.hasAttemptedCaptureSession = true;
                        Timestamps timestamps = Timestamps.INSTANCE;
                        this.sessionCreatingTimestamp = TimestampNs.m928boximpl(this.timeSource.mo927nowvQl9yQU());
                        Unit unit = Unit.INSTANCE;
                        SessionSequencer sessionSequencer = this.sessionSequencer;
                        if (sessionSequencer != null) {
                            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                android.util.Log.d(Log.TAG, "Awaiting session lock");
                            }
                            anonymousClass1.L$0 = objectRef;
                            anonymousClass1.L$1 = objectRef2;
                            anonymousClass1.label = 1;
                            if (sessionSequencer.awaitSessionLock(anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef3 = objectRef;
                            objectRef4 = objectRef2;
                        }
                        if (Log.INSTANCE.getINFO_LOGGABLE()) {
                            StringBuilder sb = new StringBuilder("Creating CameraCaptureSession from ");
                            cameraDeviceWrapper2 = (CameraDeviceWrapper) objectRef2.element;
                            if (cameraDeviceWrapper2 != null) {
                                strMo802getCameraIdDz_R5H9 = cameraDeviceWrapper2.mo802getCameraIdDz_R5H8();
                            } else {
                                strMo802getCameraIdDz_R5H9 = null;
                            }
                            if (strMo802getCameraIdDz_R5H9 == null) {
                                strM432toStringimpl = AbstractJsonLexerKt.NULL;
                            } else {
                                strM432toStringimpl = CameraId.m432toStringimpl(strMo802getCameraIdDz_R5H9);
                            }
                            sb.append((Object) strM432toStringimpl);
                            sb.append(" using ");
                            sb.append(this);
                            sb.append(" with ");
                            sb.append(objectRef.element);
                            android.util.Log.i(Log.TAG, sb.toString());
                        }
                        Debug debug = Debug.INSTANCE;
                        StringBuilder sb2 = new StringBuilder("CameraDevice-");
                        cameraDeviceWrapper = (CameraDeviceWrapper) objectRef2.element;
                        if (cameraDeviceWrapper != null) {
                            strMo802getCameraIdDz_R5H8 = cameraDeviceWrapper.mo802getCameraIdDz_R5H8();
                        } else {
                            strMo802getCameraIdDz_R5H8 = null;
                        }
                        sb2.append(strMo802getCameraIdDz_R5H8);
                        sb2.append("#createCaptureSession");
                        Trace.beginSection(sb2.toString());
                        CaptureSessionFactory captureSessionFactory = this.captureSessionFactory;
                        T t = objectRef2.element;
                        Intrinsics.checkNotNull(t);
                        T t2 = objectRef.element;
                        Intrinsics.checkNotNull(t2);
                        resultCreate = captureSessionFactory.create((CameraDeviceWrapper) t, (Map) t2, this);
                        Trace.endSection();
                        if (!(resultCreate instanceof CaptureSessionFactory.Result.Success)) {
                            if (Log.INSTANCE.getERROR_LOGGABLE()) {
                                android.util.Log.e(Log.TAG, "Failed to create capture session for " + this + '!');
                            }
                            return Unit.INSTANCE;
                        }
                        synchronized (this.lock) {
                            if (this.state != State.CLOSING && this.state != State.CLOSED) {
                                if (this.state == State.CREATING) {
                                    throw new IllegalStateException(("Unexpected state: " + this.state).toString());
                                }
                                this.state = State.CREATED;
                                Map<StreamId, Surface> map2 = this.activeStreamSurfaceMap;
                                T t3 = objectRef.element;
                                Intrinsics.checkNotNull(t3);
                                map2.putAll((Map) t3);
                                this.activeOutputSurfaceMap.putAll(((CaptureSessionFactory.Result.Success) resultCreate).getOutputSurfaceMap());
                                deferred = ((CaptureSessionFactory.Result.Success) resultCreate).getDeferred();
                                if (!deferred.isEmpty()) {
                                    if (Log.INSTANCE.getINFO_LOGGABLE()) {
                                        android.util.Log.i(Log.TAG, "Created " + this + " with " + CollectionsKt.toList(((Map) objectRef.element).keySet()) + ". Waiting to finalize " + CollectionsKt.toList(deferred.keySet()));
                                    }
                                    this.pendingOutputMap = deferred;
                                    map = this._surfaceMap;
                                    if (map != null) {
                                        linkedHashMap = new LinkedHashMap();
                                        for (Map.Entry<StreamId, ? extends Surface> entry : map.entrySet()) {
                                            if (deferred.containsKey(entry.getKey())) {
                                                linkedHashMap.put(entry.getKey(), entry.getValue());
                                            }
                                        }
                                    } else {
                                        linkedHashMap = null;
                                    }
                                    if (linkedHashMap != null && linkedHashMap.size() == deferred.size()) {
                                        this.pendingSurfaceMap = linkedHashMap;
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                                configure(null);
                                return Unit.INSTANCE;
                            }
                            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                                android.util.Log.i(Log.TAG, "Warning: " + this + " was " + this.state + " while configuration was in progress.");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef4 = (Ref.ObjectRef) anonymousClass1.L$1;
            objectRef3 = (Ref.ObjectRef) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            Trace.beginSection(sb2.toString());
            CaptureSessionFactory captureSessionFactory2 = this.captureSessionFactory;
            T t4 = objectRef2.element;
            Intrinsics.checkNotNull(t4);
            T t5 = objectRef.element;
            Intrinsics.checkNotNull(t5);
            resultCreate = captureSessionFactory2.create((CameraDeviceWrapper) t4, (Map) t5, this);
            Trace.endSection();
            if (!(resultCreate instanceof CaptureSessionFactory.Result.Success)) {
                if (Log.INSTANCE.getERROR_LOGGABLE()) {
                    android.util.Log.e(Log.TAG, "Failed to create capture session for " + this + '!');
                }
                return Unit.INSTANCE;
            }
            synchronized (this.lock) {
                if (this.state != State.CLOSING) {
                    if (this.state == State.CREATING) {
                        throw new IllegalStateException(("Unexpected state: " + this.state).toString());
                    }
                    this.state = State.CREATED;
                    Map<StreamId, Surface> map3 = this.activeStreamSurfaceMap;
                    T t6 = objectRef.element;
                    Intrinsics.checkNotNull(t6);
                    map3.putAll((Map) t6);
                    this.activeOutputSurfaceMap.putAll(((CaptureSessionFactory.Result.Success) resultCreate).getOutputSurfaceMap());
                    deferred = ((CaptureSessionFactory.Result.Success) resultCreate).getDeferred();
                    if (!deferred.isEmpty()) {
                        if (Log.INSTANCE.getINFO_LOGGABLE()) {
                            android.util.Log.i(Log.TAG, "Created " + this + " with " + CollectionsKt.toList(((Map) objectRef.element).keySet()) + ". Waiting to finalize " + CollectionsKt.toList(deferred.keySet()));
                        }
                        this.pendingOutputMap = deferred;
                        map = this._surfaceMap;
                        if (map != null) {
                            linkedHashMap = new LinkedHashMap();
                            while (r11.hasNext()) {
                                if (deferred.containsKey(entry.getKey())) {
                                    linkedHashMap.put(entry.getKey(), entry.getValue());
                                }
                            }
                        } else {
                            linkedHashMap = null;
                        }
                        if (linkedHashMap != null) {
                            this.pendingSurfaceMap = linkedHashMap;
                        }
                    }
                    Unit unit3 = Unit.INSTANCE;
                    configure(null);
                    return Unit.INSTANCE;
                }
                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                    android.util.Log.i(Log.TAG, "Warning: " + this + " was " + this.state + " while configuration was in progress.");
                }
                return Unit.INSTANCE;
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
        objectRef = objectRef3;
        objectRef2 = objectRef4;
        if (Log.INSTANCE.getINFO_LOGGABLE()) {
            StringBuilder sb3 = new StringBuilder("Creating CameraCaptureSession from ");
            cameraDeviceWrapper2 = (CameraDeviceWrapper) objectRef2.element;
            if (cameraDeviceWrapper2 != null) {
                strMo802getCameraIdDz_R5H9 = cameraDeviceWrapper2.mo802getCameraIdDz_R5H8();
            } else {
                strMo802getCameraIdDz_R5H9 = null;
            }
            if (strMo802getCameraIdDz_R5H9 == null) {
                strM432toStringimpl = AbstractJsonLexerKt.NULL;
            } else {
                strM432toStringimpl = CameraId.m432toStringimpl(strMo802getCameraIdDz_R5H9);
            }
            sb3.append((Object) strM432toStringimpl);
            sb3.append(" using ");
            sb3.append(this);
            sb3.append(" with ");
            sb3.append(objectRef.element);
            android.util.Log.i(Log.TAG, sb3.toString());
        }
        Debug debug2 = Debug.INSTANCE;
        StringBuilder sb4 = new StringBuilder("CameraDevice-");
        cameraDeviceWrapper = (CameraDeviceWrapper) objectRef2.element;
        if (cameraDeviceWrapper != null) {
            strMo802getCameraIdDz_R5H8 = cameraDeviceWrapper.mo802getCameraIdDz_R5H8();
        } else {
            strMo802getCameraIdDz_R5H8 = null;
        }
        sb4.append(strMo802getCameraIdDz_R5H8);
        sb4.append("#createCaptureSession");
    }

    private final void updateTrackedSurfaces(Map<StreamId, ? extends Surface> oldSurfaceMap, Map<StreamId, ? extends Surface> newSurfaceMap) throws Exception {
        Set set = CollectionsKt.toSet(oldSurfaceMap.values());
        Set set2 = CollectionsKt.toSet(newSurfaceMap.values());
        for (Surface surface : SetsKt.minus(set, (Iterable) set2)) {
            AutoCloseable autoCloseableRemove = this._surfaceTokenMap.remove(surface);
            if (autoCloseableRemove != null) {
                UByte$$ExternalSyntheticBackport0.m12761m((Object) autoCloseableRemove);
            } else {
                autoCloseableRemove = null;
            }
            if (autoCloseableRemove == null) {
                throw new IllegalStateException(("Surface " + surface + " doesn't have a matching surface token!").toString());
            }
        }
        for (Surface surface2 : SetsKt.minus(set2, (Iterable) set)) {
            this._surfaceTokenMap.put(surface2, this.cameraSurfaceManager.registerSurface$camera_camera2_pipe(surface2));
        }
    }

    public String toString() {
        return "CaptureSessionState-" + this.debugId;
    }

    /* JADX INFO: compiled from: CaptureSessionState.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionState$ConfiguredCameraCaptureSession;", "", "session", "Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;", "processor", "Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;", "captureSequenceProcessor", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessor;", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessor;)V", "getSession", "()Landroidx/camera/camera2/pipe/compat/CameraCaptureSessionWrapper;", "getProcessor", "()Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;", "getCaptureSequenceProcessor", "()Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequenceProcessor;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class ConfiguredCameraCaptureSession {
        private final Camera2CaptureSequenceProcessor captureSequenceProcessor;
        private final GraphRequestProcessor processor;
        private final CameraCaptureSessionWrapper session;

        public static /* synthetic */ ConfiguredCameraCaptureSession copy$default(ConfiguredCameraCaptureSession configuredCameraCaptureSession, CameraCaptureSessionWrapper cameraCaptureSessionWrapper, GraphRequestProcessor graphRequestProcessor, Camera2CaptureSequenceProcessor camera2CaptureSequenceProcessor, int i, Object obj) {
            if ((i & 1) != 0) {
                cameraCaptureSessionWrapper = configuredCameraCaptureSession.session;
            }
            if ((i & 2) != 0) {
                graphRequestProcessor = configuredCameraCaptureSession.processor;
            }
            if ((i & 4) != 0) {
                camera2CaptureSequenceProcessor = configuredCameraCaptureSession.captureSequenceProcessor;
            }
            return configuredCameraCaptureSession.copy(cameraCaptureSessionWrapper, graphRequestProcessor, camera2CaptureSequenceProcessor);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CameraCaptureSessionWrapper getSession() {
            return this.session;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final GraphRequestProcessor getProcessor() {
            return this.processor;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Camera2CaptureSequenceProcessor getCaptureSequenceProcessor() {
            return this.captureSequenceProcessor;
        }

        public final ConfiguredCameraCaptureSession copy(CameraCaptureSessionWrapper session, GraphRequestProcessor processor, Camera2CaptureSequenceProcessor captureSequenceProcessor) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(processor, "processor");
            return new ConfiguredCameraCaptureSession(session, processor, captureSequenceProcessor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfiguredCameraCaptureSession)) {
                return false;
            }
            ConfiguredCameraCaptureSession configuredCameraCaptureSession = (ConfiguredCameraCaptureSession) other;
            return Intrinsics.areEqual(this.session, configuredCameraCaptureSession.session) && Intrinsics.areEqual(this.processor, configuredCameraCaptureSession.processor) && Intrinsics.areEqual(this.captureSequenceProcessor, configuredCameraCaptureSession.captureSequenceProcessor);
        }

        public int hashCode() {
            int iHashCode = ((this.session.hashCode() * 31) + this.processor.hashCode()) * 31;
            Camera2CaptureSequenceProcessor camera2CaptureSequenceProcessor = this.captureSequenceProcessor;
            return iHashCode + (camera2CaptureSequenceProcessor == null ? 0 : camera2CaptureSequenceProcessor.hashCode());
        }

        public String toString() {
            return "ConfiguredCameraCaptureSession(session=" + this.session + ", processor=" + this.processor + ", captureSequenceProcessor=" + this.captureSequenceProcessor + ')';
        }

        public ConfiguredCameraCaptureSession(CameraCaptureSessionWrapper session, GraphRequestProcessor processor, Camera2CaptureSequenceProcessor camera2CaptureSequenceProcessor) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(processor, "processor");
            this.session = session;
            this.processor = processor;
            this.captureSequenceProcessor = camera2CaptureSequenceProcessor;
        }

        public final CameraCaptureSessionWrapper getSession() {
            return this.session;
        }

        public final GraphRequestProcessor getProcessor() {
            return this.processor;
        }

        public final Camera2CaptureSequenceProcessor getCaptureSequenceProcessor() {
            return this.captureSequenceProcessor;
        }
    }

    /* JADX INFO: compiled from: CaptureSessionState.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/pipe/compat/CaptureSessionState$Companion;", "", "<init>", "()V", "CAPTURE_SESSION_TIMEOUT_MS", "", "ABORT_CAPTURES_TIMEOUT_MS", "CLOSE_SESSION_TIMEOUT_MS", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
