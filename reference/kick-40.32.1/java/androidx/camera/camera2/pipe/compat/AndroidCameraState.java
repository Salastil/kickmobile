package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraDevice;
import android.os.Trace;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraInterop;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.SystemTimeSource;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.core.TimestampNs;
import androidx.camera.camera2.pipe.core.Timestamps;
import androidx.camera.camera2.pipe.internal.CameraErrorListener;
import com.datadog.android.rum.internal.RumFeature;
import expo.modules.notifications.service.NotificationsService;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: VirtualCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001XBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u000205H\u0086@¢\u0006\u0002\u00107J\u0015\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\b;J\u0010\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u0002052\u0006\u0010=\u001a\u00020>H\u0016J\u0018\u0010@\u001a\u0002052\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020\u0007H\u0016J\u0010\u0010B\u001a\u0002052\u0006\u0010=\u001a\u00020>H\u0016J\u0015\u0010C\u001a\u0002052\u0006\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u0002052\u0006\u0010F\u001a\u00020GH\u0000¢\u0006\u0002\bHJ\u001f\u0010E\u001a\u0002052\u0006\u0010F\u001a\u00020G2\u0006\u0010I\u001a\u00020JH\u0002¢\u0006\u0004\bK\u0010LJ\u001a\u0010E\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010M\u001a\u00020'H\u0002J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020'H\u0002J%\u0010Q\u001a\u00020%*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010JH\u0002¢\u0006\u0004\bR\u0010SJ%\u0010T\u001a\u00020%*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010JH\u0002¢\u0006\u0004\bU\u0010SJ\b\u0010V\u001a\u00020WH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020%8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020%8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010,\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020/018F¢\u0006\u0006\u001a\u0004\b2\u00103¨\u0006Y"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "metadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "attemptNumber", "", "attemptTimestampNanos", "Landroidx/camera/camera2/pipe/core/TimestampNs;", "timeSource", "Landroidx/camera/camera2/pipe/core/TimeSource;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/internal/CameraErrorListener;", "camera2DeviceCloser", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;", "camera2Quirks", "Landroidx/camera/camera2/pipe/compat/Camera2Quirks;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "audioRestrictionController", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;", "interopCameraDeviceStateCallback", "interopCaptureSessionListener", "Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;", "<init>", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/CameraMetadata;IJLandroidx/camera/camera2/pipe/core/TimeSource;Landroidx/camera/camera2/pipe/internal/CameraErrorListener;Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloser;Landroidx/camera/camera2/pipe/compat/Camera2Quirks;Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;Landroid/hardware/camera2/CameraDevice$StateCallback;Landroidx/camera/camera2/pipe/CameraInterop$CaptureSessionListener;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "getMetadata", "()Landroidx/camera/camera2/pipe/CameraMetadata;", "J", "debugId", "lock", "", "opening", "", "pendingClose", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState$ClosingInfo;", "shouldDelayFinalizing", "cameraDeviceClosed", "Ljava/util/concurrent/CountDownLatch;", "requestTimestampNanos", "openTimestampNanos", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/camera/camera2/pipe/compat/CameraState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "close", "", "awaitClosed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraDeviceClosed", "timeoutMillis", "", "awaitCameraDeviceClosed$camera_camera2_pipe", "onOpened", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "onDisconnected", "onError", "errorCode", "onClosed", "onFinalized", "onFinalized$camera_camera2_pipe", "closeWith", RumFeature.EVENT_THROWABLE_PROPERTY, "", "closeWith$camera_camera2_pipe", "cameraError", "Landroidx/camera/camera2/pipe/CameraError;", "closeWith-8PWMtlg", "(Ljava/lang/Throwable;I)V", "closeRequest", "computeClosedState", "Landroidx/camera/camera2/pipe/compat/CameraStateClosed;", "closingInfo", "shouldReopenCameraWhenClosing", "shouldReopenCameraWhenClosing-_z0IXec", "(Landroidx/camera/camera2/pipe/compat/Camera2Quirks;Ljava/lang/String;Landroidx/camera/camera2/pipe/CameraError;)Z", "shouldCreateEmptyCaptureSessionBeforeClosing", "shouldCreateEmptyCaptureSessionBeforeClosing-_z0IXec", "toString", "", "ClosingInfo", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidCameraState extends CameraDevice.StateCallback {
    private final MutableStateFlow<CameraState> _state;
    private final int attemptNumber;
    private final long attemptTimestampNanos;
    private final AudioRestrictionController audioRestrictionController;
    private final Camera2DeviceCloser camera2DeviceCloser;
    private final Camera2Quirks camera2Quirks;
    private final CountDownLatch cameraDeviceClosed;
    private final CameraErrorListener cameraErrorListener;
    private final String cameraId;
    private final int debugId;
    private final CameraDevice.StateCallback interopCameraDeviceStateCallback;
    private final CameraInterop.CaptureSessionListener interopCaptureSessionListener;
    private final Object lock;
    private final CameraMetadata metadata;
    private TimestampNs openTimestampNanos;
    private boolean opening;
    private ClosingInfo pendingClose;
    private final long requestTimestampNanos;
    private boolean shouldDelayFinalizing;
    private final Threads threads;
    private final TimeSource timeSource;

    public /* synthetic */ AndroidCameraState(String str, CameraMetadata cameraMetadata, int i, long j, TimeSource timeSource, CameraErrorListener cameraErrorListener, Camera2DeviceCloser camera2DeviceCloser, Camera2Quirks camera2Quirks, Threads threads, AudioRestrictionController audioRestrictionController, CameraDevice.StateCallback stateCallback, CameraInterop.CaptureSessionListener captureSessionListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, cameraMetadata, i, j, timeSource, cameraErrorListener, camera2DeviceCloser, camera2Quirks, threads, audioRestrictionController, stateCallback, captureSessionListener);
    }

    private AndroidCameraState(String cameraId, CameraMetadata metadata, int i, long j, TimeSource timeSource, CameraErrorListener cameraErrorListener, Camera2DeviceCloser camera2DeviceCloser, Camera2Quirks camera2Quirks, Threads threads, AudioRestrictionController audioRestrictionController, CameraDevice.StateCallback stateCallback, CameraInterop.CaptureSessionListener captureSessionListener) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(cameraErrorListener, "cameraErrorListener");
        Intrinsics.checkNotNullParameter(camera2DeviceCloser, "camera2DeviceCloser");
        Intrinsics.checkNotNullParameter(camera2Quirks, "camera2Quirks");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(audioRestrictionController, "audioRestrictionController");
        this.cameraId = cameraId;
        this.metadata = metadata;
        this.attemptNumber = i;
        this.attemptTimestampNanos = j;
        this.timeSource = timeSource;
        this.cameraErrorListener = cameraErrorListener;
        this.camera2DeviceCloser = camera2DeviceCloser;
        this.camera2Quirks = camera2Quirks;
        this.threads = threads;
        this.audioRestrictionController = audioRestrictionController;
        this.interopCameraDeviceStateCallback = stateCallback;
        this.interopCaptureSessionListener = captureSessionListener;
        this.debugId = VirtualCameraKt.getAndroidCameraDebugIds().incrementAndGet();
        this.lock = new Object();
        this.cameraDeviceClosed = new CountDownLatch(1);
        this._state = StateFlowKt.MutableStateFlow(CameraStateUnopened.INSTANCE);
        if (Log.INSTANCE.getINFO_LOGGABLE()) {
            android.util.Log.i(Log.TAG, "Opening " + ((Object) CameraId.m432toStringimpl(getCameraId())));
        }
        if (i != 1) {
            Timestamps timestamps = Timestamps.INSTANCE;
            j = timeSource.mo927nowvQl9yQU();
        }
        this.requestTimestampNanos = j;
    }

    public /* synthetic */ AndroidCameraState(String str, CameraMetadata cameraMetadata, int i, long j, TimeSource timeSource, CameraErrorListener cameraErrorListener, Camera2DeviceCloser camera2DeviceCloser, Camera2Quirks camera2Quirks, Threads threads, AudioRestrictionController audioRestrictionController, CameraDevice.StateCallback stateCallback, CameraInterop.CaptureSessionListener captureSessionListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, cameraMetadata, i, j, timeSource, cameraErrorListener, camera2DeviceCloser, camera2Quirks, threads, audioRestrictionController, (i2 & 1024) != 0 ? null : stateCallback, (i2 & 2048) != 0 ? null : captureSessionListener, null);
    }

    /* JADX INFO: renamed from: getCameraId-Dz_R5H8, reason: not valid java name and from getter */
    public final String getCameraId() {
        return this.cameraId;
    }

    public final CameraMetadata getMetadata() {
        return this.metadata;
    }

    public final StateFlow<CameraState> getState() {
        return this._state;
    }

    public final void close() {
        CameraState value = this._state.getValue();
        CameraDeviceWrapper cameraDevice = value instanceof CameraStateOpen ? ((CameraStateOpen) value).getCameraDevice() : null;
        closeWith(cameraDevice != null ? (CameraDevice) cameraDevice.unwrapAs(Reflection.getOrCreateKotlinClass(CameraDevice.class)) : null, new ClosingInfo(ClosedReason.APP_CLOSED, 0L, null, null, 14, null));
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.AndroidCameraState$awaitClosed$2, reason: invalid class name */
    /* JADX INFO: compiled from: VirtualCamera.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/camera/camera2/pipe/compat/CameraState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.AndroidCameraState$awaitClosed$2", f = "VirtualCamera.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CameraState, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CameraState cameraState, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(cameraState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((CameraState) this.L$0) instanceof CameraStateClosed);
        }
    }

    public final Object awaitClosed(Continuation<? super Unit> continuation) {
        Object objFirst = FlowKt.first(getState(), new AnonymousClass2(null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    public final boolean awaitCameraDeviceClosed$camera_camera2_pipe(long timeoutMillis) {
        return this.cameraDeviceClosed.await(timeoutMillis, TimeUnit.MILLISECONDS);
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onOpened(CameraDevice cameraDevice) {
        ClosingInfo closingInfo;
        ClosingInfo closingInfo2;
        String string;
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        if (!Intrinsics.areEqual(cameraDevice.getId(), this.cameraId)) {
            throw new IllegalStateException("Check failed.");
        }
        Timestamps timestamps = Timestamps.INSTANCE;
        long jMo927nowvQl9yQU = this.timeSource.mo927nowvQl9yQU();
        this.openTimestampNanos = TimestampNs.m928boximpl(jMo927nowvQl9yQU);
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(((Object) CameraId.m432toStringimpl(getCameraId())) + "#onOpened");
        if (Log.INSTANCE.getINFO_LOGGABLE()) {
            long jM917constructorimpl = DurationNs.m917constructorimpl(jMo927nowvQl9yQU - this.requestTimestampNanos);
            long jM917constructorimpl2 = DurationNs.m917constructorimpl(jMo927nowvQl9yQU - this.attemptTimestampNanos);
            if (this.attemptNumber == 1) {
                StringBuilder sb = new StringBuilder("Opened ");
                sb.append((Object) CameraId.m432toStringimpl(getCameraId()));
                sb.append(" in ");
                Timestamps timestamps2 = Timestamps.INSTANCE;
                String str = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                sb.append(str);
                string = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder("Opened ");
                sb2.append((Object) CameraId.m432toStringimpl(getCameraId()));
                sb2.append(" in ");
                Timestamps timestamps3 = Timestamps.INSTANCE;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                sb2.append(str2);
                sb2.append(" (");
                Timestamps timestamps4 = Timestamps.INSTANCE;
                String str3 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl2 / 1000000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                sb2.append(str3);
                sb2.append(" total) after ");
                sb2.append(this.attemptNumber);
                sb2.append(" attempts.");
                string = sb2.toString();
            }
            android.util.Log.i(Log.TAG, string);
        }
        synchronized (this.lock) {
            closingInfo = this.pendingClose;
            if (closingInfo == null) {
                this.opening = true;
            }
        }
        CameraDevice.StateCallback stateCallback = this.interopCameraDeviceStateCallback;
        if (stateCallback != null) {
            stateCallback.onOpened(cameraDevice);
        }
        if (closingInfo != null) {
            Camera2DeviceCloser.closeCamera$default(this.camera2DeviceCloser, null, cameraDevice, this, this.audioRestrictionController, m806shouldReopenCameraWhenClosing_z0IXec(this.camera2Quirks, this.cameraId, closingInfo.m813getErrorCodemVEW8x0()), m805shouldCreateEmptyCaptureSessionBeforeClosing_z0IXec(this.camera2Quirks, this.cameraId, closingInfo.m813getErrorCodemVEW8x0()), 1, null);
            return;
        }
        AndroidCameraDevice androidCameraDevice = new AndroidCameraDevice(this.metadata, cameraDevice, this.cameraId, this.cameraErrorListener, this.interopCaptureSessionListener, this.threads, null);
        this.audioRestrictionController.addListener(androidCameraDevice);
        AndroidCameraDevice androidCameraDevice2 = androidCameraDevice;
        this._state.setValue(new CameraStateOpen(androidCameraDevice2));
        synchronized (this.lock) {
            this.opening = false;
            closingInfo2 = this.pendingClose;
        }
        if (closingInfo2 != null) {
            this._state.setValue(new CameraStateClosing(closingInfo2.m813getErrorCodemVEW8x0(), null));
            this.camera2DeviceCloser.closeCamera(androidCameraDevice2, cameraDevice, this, this.audioRestrictionController, m806shouldReopenCameraWhenClosing_z0IXec(this.camera2Quirks, this.cameraId, closingInfo2.m813getErrorCodemVEW8x0()), m805shouldCreateEmptyCaptureSessionBeforeClosing_z0IXec(this.camera2Quirks, this.cameraId, closingInfo2.m813getErrorCodemVEW8x0()));
            this._state.setValue(computeClosedState(closingInfo2));
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onDisconnected(CameraDevice cameraDevice) {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        if (!Intrinsics.areEqual(cameraDevice.getId(), this.cameraId)) {
            throw new IllegalStateException("Check failed.");
        }
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(((Object) CameraId.m432toStringimpl(getCameraId())) + "#onDisconnected");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, ((Object) CameraId.m432toStringimpl(getCameraId())) + ": onDisconnected");
        }
        this.cameraDeviceClosed.countDown();
        closeWith(cameraDevice, new ClosingInfo(ClosedReason.CAMERA2_DISCONNECTED, 0L, CameraError.m351boximpl(CameraError.INSTANCE.m364getERROR_CAMERA_DISCONNECTEDv7Vf74A()), null, 10, null));
        CameraDevice.StateCallback stateCallback = this.interopCameraDeviceStateCallback;
        if (stateCallback != null) {
            stateCallback.onDisconnected(cameraDevice);
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onError(CameraDevice cameraDevice, int errorCode) {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        if (!Intrinsics.areEqual(cameraDevice.getId(), this.cameraId)) {
            throw new IllegalStateException("Check failed.");
        }
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(((Object) CameraId.m432toStringimpl(getCameraId())) + "#onError-" + errorCode);
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, ((Object) CameraId.m432toStringimpl(getCameraId())) + ": onError " + errorCode);
        }
        this.cameraDeviceClosed.countDown();
        closeWith(cameraDevice, new ClosingInfo(ClosedReason.CAMERA2_ERROR, 0L, CameraError.m351boximpl(CameraError.INSTANCE.m359fromPVuDhNw$camera_camera2_pipe(errorCode)), null, 10, null));
        CameraDevice.StateCallback stateCallback = this.interopCameraDeviceStateCallback;
        if (stateCallback != null) {
            stateCallback.onError(cameraDevice, errorCode);
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onClosed(CameraDevice cameraDevice) {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        if (!Intrinsics.areEqual(cameraDevice.getId(), this.cameraId)) {
            throw new IllegalStateException("Check failed.");
        }
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, ((Object) CameraId.m432toStringimpl(getCameraId())) + ": onClosed");
        }
        this.cameraDeviceClosed.countDown();
        synchronized (this.lock) {
            if (!this.shouldDelayFinalizing) {
                Unit unit = Unit.INSTANCE;
                onFinalized$camera_camera2_pipe(cameraDevice);
                return;
            }
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, this + "#onClosed: Delaying finalizing.");
            }
        }
    }

    public final void onFinalized$camera_camera2_pipe(CameraDevice cameraDevice) {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection(((Object) CameraId.m432toStringimpl(getCameraId())) + "#onFinalized");
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, this + ": onFinalized");
        }
        closeWith(cameraDevice, new ClosingInfo(ClosedReason.CAMERA2_CLOSED, 0L, null, null, 14, null));
        CameraDevice.StateCallback stateCallback = this.interopCameraDeviceStateCallback;
        if (stateCallback != null) {
            stateCallback.onClosed(cameraDevice);
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    public final void closeWith$camera_camera2_pipe(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        int iM361fromPVuDhNw$camera_camera2_pipe = CameraError.INSTANCE.m361fromPVuDhNw$camera_camera2_pipe(throwable);
        if (CameraError.m354equalsimpl0(iM361fromPVuDhNw$camera_camera2_pipe, CameraError.INSTANCE.m374getERROR_UNDETERMINEDv7Vf74A())) {
            return;
        }
        m804closeWith8PWMtlg(throwable, iM361fromPVuDhNw$camera_camera2_pipe);
    }

    /* JADX INFO: renamed from: closeWith-8PWMtlg, reason: not valid java name */
    private final void m804closeWith8PWMtlg(Throwable throwable, int cameraError) {
        closeWith(null, new ClosingInfo(ClosedReason.CAMERA2_EXCEPTION, 0L, CameraError.m351boximpl(cameraError), throwable, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0024  */
    private final void closeWith(CameraDevice cameraDevice, ClosingInfo closeRequest) {
        AndroidCameraState androidCameraState;
        CameraState value = this._state.getValue();
        CameraDeviceWrapper cameraDevice2 = value instanceof CameraStateOpen ? ((CameraStateOpen) value).getCameraDevice() : null;
        synchronized (this.lock) {
            if (this.pendingClose == null) {
                this.pendingClose = closeRequest;
                if (this.opening) {
                    closeRequest = null;
                }
            } else {
                closeRequest = null;
            }
        }
        if (closeRequest != null) {
            if (closeRequest.m813getErrorCodemVEW8x0() != null && closeRequest.getReason() != ClosedReason.CAMERA2_EXCEPTION) {
                this.cameraErrorListener.mo837onCameraError3M5Xam4(this.cameraId, closeRequest.m813getErrorCodemVEW8x0().m358unboximpl(), false);
            }
            this._state.setValue(new CameraStateClosing(closeRequest.m813getErrorCodemVEW8x0(), null));
            if (closeRequest.getReason() != ClosedReason.CAMERA2_CLOSED) {
                boolean zM806shouldReopenCameraWhenClosing_z0IXec = m806shouldReopenCameraWhenClosing_z0IXec(this.camera2Quirks, this.cameraId, closeRequest.m813getErrorCodemVEW8x0());
                if (zM806shouldReopenCameraWhenClosing_z0IXec) {
                    synchronized (this.lock) {
                        this.shouldDelayFinalizing = true;
                        Unit unit = Unit.INSTANCE;
                    }
                }
                androidCameraState = this;
                this.camera2DeviceCloser.closeCamera(cameraDevice2, cameraDevice, androidCameraState, this.audioRestrictionController, zM806shouldReopenCameraWhenClosing_z0IXec, m805shouldCreateEmptyCaptureSessionBeforeClosing_z0IXec(this.camera2Quirks, this.cameraId, closeRequest.m813getErrorCodemVEW8x0()));
            } else {
                androidCameraState = this;
            }
            androidCameraState._state.setValue(androidCameraState.computeClosedState(closeRequest));
        }
    }

    private final CameraStateClosed computeClosedState(ClosingInfo closingInfo) {
        Timestamps timestamps = Timestamps.INSTANCE;
        long jMo927nowvQl9yQU = this.timeSource.mo927nowvQl9yQU();
        TimestampNs timestampNs = this.openTimestampNanos;
        long jM812getClosingTimestampvQl9yQU = closingInfo.m812getClosingTimestampvQl9yQU();
        DurationNs durationNsM915boximpl = timestampNs != null ? DurationNs.m915boximpl(DurationNs.m917constructorimpl(timestampNs.m936unboximpl() - this.attemptTimestampNanos)) : null;
        DurationNs durationNsM915boximpl2 = timestampNs != null ? DurationNs.m915boximpl(DurationNs.m917constructorimpl(timestampNs.m936unboximpl() - this.requestTimestampNanos)) : null;
        DurationNs durationNsM915boximpl3 = timestampNs != null ? DurationNs.m915boximpl(DurationNs.m917constructorimpl(jM812getClosingTimestampvQl9yQU - timestampNs.m936unboximpl())) : null;
        long jM917constructorimpl = DurationNs.m917constructorimpl(jMo927nowvQl9yQU - jM812getClosingTimestampvQl9yQU);
        String str = this.cameraId;
        ClosedReason reason = closingInfo.getReason();
        int i = this.attemptNumber - 1;
        return new CameraStateClosed(str, reason, Integer.valueOf(i), durationNsM915boximpl, closingInfo.getException(), durationNsM915boximpl2, durationNsM915boximpl3, DurationNs.m915boximpl(jM917constructorimpl), closingInfo.m813getErrorCodemVEW8x0(), null);
    }

    /* JADX INFO: compiled from: VirtualCamera.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\b\u0019J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J<\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidCameraState$ClosingInfo;", "", "reason", "Landroidx/camera/camera2/pipe/compat/ClosedReason;", "closingTimestamp", "Landroidx/camera/camera2/pipe/core/TimestampNs;", "errorCode", "Landroidx/camera/camera2/pipe/CameraError;", NotificationsService.EXCEPTION_KEY, "", "<init>", "(Landroidx/camera/camera2/pipe/compat/ClosedReason;JLandroidx/camera/camera2/pipe/CameraError;Ljava/lang/Throwable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getReason", "()Landroidx/camera/camera2/pipe/compat/ClosedReason;", "getClosingTimestamp-vQl9yQU", "()J", "J", "getErrorCode-mVEW8x0", "()Landroidx/camera/camera2/pipe/CameraError;", "getException", "()Ljava/lang/Throwable;", "component1", "component2", "component2-vQl9yQU", "component3", "component3-mVEW8x0", "component4", "copy", "copy-fgCNvVg", "(Landroidx/camera/camera2/pipe/compat/ClosedReason;JLandroidx/camera/camera2/pipe/CameraError;Ljava/lang/Throwable;)Landroidx/camera/camera2/pipe/compat/AndroidCameraState$ClosingInfo;", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class ClosingInfo {
        private final long closingTimestamp;
        private final CameraError errorCode;
        private final Throwable exception;
        private final ClosedReason reason;

        public /* synthetic */ ClosingInfo(ClosedReason closedReason, long j, CameraError cameraError, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
            this(closedReason, j, cameraError, th);
        }

        /* JADX INFO: renamed from: copy-fgCNvVg$default, reason: not valid java name */
        public static /* synthetic */ ClosingInfo m808copyfgCNvVg$default(ClosingInfo closingInfo, ClosedReason closedReason, long j, CameraError cameraError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                closedReason = closingInfo.reason;
            }
            if ((i & 2) != 0) {
                j = closingInfo.closingTimestamp;
            }
            if ((i & 4) != 0) {
                cameraError = closingInfo.errorCode;
            }
            if ((i & 8) != 0) {
                th = closingInfo.exception;
            }
            return closingInfo.m811copyfgCNvVg(closedReason, j, cameraError, th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ClosedReason getReason() {
            return this.reason;
        }

        /* JADX INFO: renamed from: component2-vQl9yQU, reason: not valid java name and from getter */
        public final long getClosingTimestamp() {
            return this.closingTimestamp;
        }

        /* JADX INFO: renamed from: component3-mVEW8x0, reason: not valid java name and from getter */
        public final CameraError getErrorCode() {
            return this.errorCode;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Throwable getException() {
            return this.exception;
        }

        /* JADX INFO: renamed from: copy-fgCNvVg, reason: not valid java name */
        public final ClosingInfo m811copyfgCNvVg(ClosedReason reason, long closingTimestamp, CameraError errorCode, Throwable exception) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new ClosingInfo(reason, closingTimestamp, errorCode, exception, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClosingInfo)) {
                return false;
            }
            ClosingInfo closingInfo = (ClosingInfo) other;
            return this.reason == closingInfo.reason && TimestampNs.m931equalsimpl0(this.closingTimestamp, closingInfo.closingTimestamp) && Intrinsics.areEqual(this.errorCode, closingInfo.errorCode) && Intrinsics.areEqual(this.exception, closingInfo.exception);
        }

        public int hashCode() {
            int iHashCode = ((this.reason.hashCode() * 31) + TimestampNs.m932hashCodeimpl(this.closingTimestamp)) * 31;
            CameraError cameraError = this.errorCode;
            int iM355hashCodeimpl = (iHashCode + (cameraError == null ? 0 : CameraError.m355hashCodeimpl(cameraError.m358unboximpl()))) * 31;
            Throwable th = this.exception;
            return iM355hashCodeimpl + (th != null ? th.hashCode() : 0);
        }

        public String toString() {
            return "ClosingInfo(reason=" + this.reason + ", closingTimestamp=" + ((Object) TimestampNs.m935toStringimpl(this.closingTimestamp)) + ", errorCode=" + this.errorCode + ", exception=" + this.exception + ')';
        }

        private ClosingInfo(ClosedReason reason, long j, CameraError cameraError, Throwable th) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
            this.closingTimestamp = j;
            this.errorCode = cameraError;
            this.exception = th;
        }

        public final ClosedReason getReason() {
            return this.reason;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ ClosingInfo(ClosedReason closedReason, long j, CameraError cameraError, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 2) != 0) {
                Timestamps timestamps = Timestamps.INSTANCE;
                j = new SystemTimeSource().mo927nowvQl9yQU();
            }
            this(closedReason, j, (i & 4) != 0 ? null : cameraError, (i & 8) != 0 ? null : th, null);
        }

        /* JADX INFO: renamed from: getClosingTimestamp-vQl9yQU, reason: not valid java name */
        public final long m812getClosingTimestampvQl9yQU() {
            return this.closingTimestamp;
        }

        /* JADX INFO: renamed from: getErrorCode-mVEW8x0, reason: not valid java name */
        public final CameraError m813getErrorCodemVEW8x0() {
            return this.errorCode;
        }

        public final Throwable getException() {
            return this.exception;
        }
    }

    /* JADX INFO: renamed from: shouldReopenCameraWhenClosing-_z0IXec, reason: not valid java name */
    private final boolean m806shouldReopenCameraWhenClosing_z0IXec(Camera2Quirks camera2Quirks, String str, CameraError cameraError) {
        return m805shouldCreateEmptyCaptureSessionBeforeClosing_z0IXec(camera2Quirks, str, cameraError) && camera2Quirks.m850x552c1673(str);
    }

    /* JADX INFO: renamed from: shouldCreateEmptyCaptureSessionBeforeClosing-_z0IXec, reason: not valid java name */
    private final boolean m805shouldCreateEmptyCaptureSessionBeforeClosing_z0IXec(Camera2Quirks camera2Quirks, String str, CameraError cameraError) {
        return camera2Quirks.m851xfcf3eba9(str) && cameraError == null;
    }

    public String toString() {
        return "CameraState-" + this.debugId;
    }
}
