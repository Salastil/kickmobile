package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Token;
import androidx.camera.camera2.pipe.graph.GraphListener;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: VirtualCamera.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010)\u001a\u00020*2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0080@¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0002\b0J\u0010\u00101\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u001bH\u0003J\b\u00102\u001a\u000203H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", "Landroidx/camera/camera2/pipe/compat/VirtualCamera;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "graphListener", "Landroidx/camera/camera2/pipe/graph/GraphListener;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljava/lang/String;Landroidx/camera/camera2/pipe/graph/GraphListener;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "getGraphListener", "()Landroidx/camera/camera2/pipe/graph/GraphListener;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "debugId", "", "lock", "", "closed", "", "currentVirtualAndroidCamera", "Landroidx/camera/camera2/pipe/compat/VirtualAndroidCameraDevice;", "_stateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/camera/camera2/pipe/compat/CameraState;", "_states", "Lkotlinx/coroutines/flow/Flow;", "_lastState", "state", "getState", "()Lkotlinx/coroutines/flow/Flow;", "value", "getValue", "()Landroidx/camera/camera2/pipe/compat/CameraState;", "job", "Lkotlinx/coroutines/Job;", "wakelockToken", "Landroidx/camera/camera2/pipe/core/Token;", "connect", "", "connect$camera_camera2_pipe", "(Lkotlinx/coroutines/flow/Flow;Landroidx/camera/camera2/pipe/core/Token;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "lastCameraError", "Landroidx/camera/camera2/pipe/CameraError;", "disconnect-TPqeGZw", "emitState", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VirtualCameraState implements VirtualCamera {
    private CameraState _lastState;
    private final MutableSharedFlow<CameraState> _stateFlow;
    private final Flow<CameraState> _states;
    private final String cameraId;
    private boolean closed;
    private VirtualAndroidCameraDevice currentVirtualAndroidCamera;
    private final int debugId;
    private final GraphListener graphListener;
    private Job job;
    private final Object lock;
    private final CoroutineScope scope;
    private Token wakelockToken;

    public /* synthetic */ VirtualCameraState(String str, GraphListener graphListener, CoroutineScope coroutineScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, graphListener, coroutineScope);
    }

    private VirtualCameraState(String cameraId, GraphListener graphListener, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(graphListener, "graphListener");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.cameraId = cameraId;
        this.graphListener = graphListener;
        this.scope = scope;
        this.debugId = VirtualCameraKt.getVirtualCameraDebugIds().incrementAndGet();
        this.lock = new Object();
        MutableSharedFlow<CameraState> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 3, null, 4, null);
        this._stateFlow = mutableSharedFlowMutableSharedFlow$default;
        this._states = FlowKt.distinctUntilChanged(mutableSharedFlowMutableSharedFlow$default);
        CameraStateUnopened cameraStateUnopened = CameraStateUnopened.INSTANCE;
        this._lastState = cameraStateUnopened;
        if (!mutableSharedFlowMutableSharedFlow$default.tryEmit(cameraStateUnopened)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX INFO: renamed from: getCameraId-Dz_R5H8, reason: not valid java name and from getter */
    public final String getCameraId() {
        return this.cameraId;
    }

    public final GraphListener getGraphListener() {
        return this.graphListener;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // androidx.camera.camera2.pipe.compat.VirtualCamera
    public Flow<CameraState> getState() {
        return this._states;
    }

    @Override // androidx.camera.camera2.pipe.compat.VirtualCamera
    public CameraState getValue() {
        CameraState cameraState;
        synchronized (this.lock) {
            cameraState = this._lastState;
        }
        return cameraState;
    }

    public final Object connect$camera_camera2_pipe(Flow<? extends CameraState> flow, Token token, Continuation<? super Unit> continuation) {
        synchronized (this.lock) {
            if (this.closed) {
                if (token != null) {
                    Boxing.boxBoolean(token.release());
                }
                return Unit.INSTANCE;
            }
            this.job = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new VirtualCameraState$connect$2$1(flow, this, null), 3, null);
            this.wakelockToken = token;
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.camera2.pipe.compat.VirtualCamera
    /* JADX INFO: renamed from: disconnect-TPqeGZw */
    public void mo909disconnectTPqeGZw(CameraError lastCameraError) {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            int i = 1;
            this.closed = true;
            if (Log.INSTANCE.getINFO_LOGGABLE()) {
                android.util.Log.i(Log.TAG, "Disconnecting " + this);
            }
            VirtualAndroidCameraDevice virtualAndroidCameraDevice = this.currentVirtualAndroidCamera;
            if (virtualAndroidCameraDevice != null) {
                virtualAndroidCameraDevice.disconnect$camera_camera2_pipe();
            }
            Job job = this.job;
            CameraError cameraError = null;
            Object[] objArr = 0;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Token token = this.wakelockToken;
            if (token != null) {
                token.release();
            }
            if (!(getValue() instanceof CameraStateClosed)) {
                if (!(this._lastState instanceof CameraStateClosing)) {
                    emitState(new CameraStateClosing(cameraError, i, objArr == true ? 1 : 0));
                }
                emitState(new CameraStateClosed(this.cameraId, ClosedReason.APP_DISCONNECTED, null, null, null, null, null, null, lastCameraError, 252, null));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitState(CameraState state) {
        this._lastState = state;
        if (this._stateFlow.tryEmit(state)) {
            return;
        }
        throw new IllegalStateException(("Failed to emit " + state + " in " + this).toString());
    }

    public String toString() {
        return "VirtualCamera-" + this.debugId;
    }
}
