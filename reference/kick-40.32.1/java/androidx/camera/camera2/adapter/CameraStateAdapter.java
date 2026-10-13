package androidx.camera.camera2.adapter;

import android.os.Looper;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.GraphState;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraState;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.core.util.Consumer;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraStateAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 02\u00020\u0001:\u0002/0B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0010J\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0003J\u001c\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0013H\u0002J\u001f\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b(J#\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00192\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0000¢\u0006\u0002\b,J\u001b\u0010-\u001a\u00020\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0000¢\u0006\u0002\b.R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/camera/camera2/adapter/CameraStateAdapter;", "", "<init>", "()V", "lock", "cameraInternalState", "Landroidx/camera/core/impl/LiveDataObservable;", "Landroidx/camera/core/impl/CameraInternal$State;", "getCameraInternalState$camera_camera2", "()Landroidx/camera/core/impl/LiveDataObservable;", "cameraState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/camera/core/CameraState;", "getCameraState$camera_camera2", "()Landroidx/lifecycle/MutableLiveData;", "currentGraph", "Landroidx/camera/camera2/pipe/CameraGraph;", "currentCameraInternalState", "currentCameraStateError", "Landroidx/camera/core/CameraState$StateError;", "isRemoved", "", "cameraStateListeners", "", "Landroidx/core/util/Consumer;", "Ljava/util/concurrent/Executor;", "onRemoved", "", "onGraphUpdated", "cameraGraph", "onGraphStateUpdated", "graphState", "Landroidx/camera/camera2/pipe/GraphState;", "handleStateTransition", "postCameraState", "internalState", "stateError", "calculateNextState", "Landroidx/camera/camera2/adapter/CameraStateAdapter$CombinedCameraState;", "currentState", "calculateNextState$camera_camera2", "addCameraStateListener", "executor", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addCameraStateListener$camera_camera2", "removeCameraStateListener", "removeCameraStateListener$camera_camera2", "CombinedCameraState", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraStateAdapter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CameraState.StateError currentCameraStateError;
    private CameraGraph currentGraph;
    private boolean isRemoved;
    private final Object lock = new Object();
    private final LiveDataObservable<CameraInternal.State> cameraInternalState = new LiveDataObservable<>();
    private final MutableLiveData<CameraState> cameraState = new MutableLiveData<>();
    private CameraInternal.State currentCameraInternalState = CameraInternal.State.CLOSED;
    private final Map<Consumer<CameraState>, Executor> cameraStateListeners = new LinkedHashMap();

    /* JADX INFO: compiled from: CameraStateAdapter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CameraInternal.State.values().length];
            try {
                iArr[CameraInternal.State.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CameraInternal.State.OPENING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CameraInternal.State.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CameraInternal.State.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CameraInternal.State.PENDING_OPEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public CameraStateAdapter() {
        postCameraState$default(this, CameraInternal.State.CLOSED, null, 2, null);
    }

    public final LiveDataObservable<CameraInternal.State> getCameraInternalState$camera_camera2() {
        return this.cameraInternalState;
    }

    public final MutableLiveData<CameraState> getCameraState$camera_camera2() {
        return this.cameraState;
    }

    public final void onRemoved() {
        CameraState.StateError stateErrorCreate = CameraState.StateError.create(8);
        Intrinsics.checkNotNullExpressionValue(stateErrorCreate, "create(...)");
        synchronized (this.lock) {
            if (this.isRemoved) {
                return;
            }
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Camera is removed, forcing state to CLOSED.");
            }
            this.isRemoved = true;
            CameraInternal.State state = CameraInternal.State.CLOSED;
            this.currentCameraInternalState = state;
            this.currentCameraStateError = stateErrorCreate;
            postCameraState(state, stateErrorCreate);
            this.currentGraph = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onGraphUpdated(CameraGraph cameraGraph) {
        Intrinsics.checkNotNullParameter(cameraGraph, "cameraGraph");
        synchronized (this.lock) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Camera graph updated from " + this.currentGraph + " to " + cameraGraph);
            }
            if (this.currentCameraInternalState != CameraInternal.State.CLOSED) {
                postCameraState$default(this, CameraInternal.State.CLOSING, null, 2, null);
                postCameraState$default(this, CameraInternal.State.CLOSED, null, 2, null);
            }
            this.currentGraph = cameraGraph;
            this.currentCameraInternalState = CameraInternal.State.CLOSED;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onGraphStateUpdated(CameraGraph cameraGraph, GraphState graphState) {
        Intrinsics.checkNotNullParameter(cameraGraph, "cameraGraph");
        Intrinsics.checkNotNullParameter(graphState, "graphState");
        synchronized (this.lock) {
            if (this.isRemoved) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Ignoring graph state update " + graphState + " on removed camera.");
                }
                return;
            }
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, cameraGraph + " state updated to " + graphState);
            }
            handleStateTransition(cameraGraph, graphState);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void handleStateTransition(CameraGraph cameraGraph, GraphState graphState) {
        if (!Intrinsics.areEqual(cameraGraph, this.currentGraph)) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Ignored stale transition " + graphState + " for " + cameraGraph);
                return;
            }
            return;
        }
        CombinedCameraState combinedCameraStateCalculateNextState$camera_camera2 = calculateNextState$camera_camera2(this.currentCameraInternalState, graphState);
        if (combinedCameraStateCalculateNextState$camera_camera2 == null) {
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isWarnEnabled(Log.TAG)) {
                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "Impermissible state transition: current camera internal state: " + this.currentCameraInternalState + ", received graph state: " + graphState);
                return;
            }
            return;
        }
        this.currentCameraInternalState = combinedCameraStateCalculateNextState$camera_camera2.getState();
        this.currentCameraStateError = combinedCameraStateCalculateNextState$camera_camera2.getError();
        Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Updated current camera internal state to " + combinedCameraStateCalculateNextState$camera_camera2);
        }
        postCameraState(this.currentCameraInternalState, this.currentCameraStateError);
    }

    static /* synthetic */ void postCameraState$default(CameraStateAdapter cameraStateAdapter, CameraInternal.State state, CameraState.StateError stateError, int i, Object obj) {
        if ((i & 2) != 0) {
            stateError = null;
        }
        cameraStateAdapter.postCameraState(state, stateError);
    }

    private final void postCameraState(CameraInternal.State internalState, CameraState.StateError stateError) {
        List<Map.Entry> list;
        this.cameraInternalState.postValue(internalState);
        Companion companion = INSTANCE;
        final CameraState cameraStateCreate = CameraState.create(companion.toCameraState$camera_camera2(internalState), stateError);
        Intrinsics.checkNotNullExpressionValue(cameraStateCreate, "create(...)");
        companion.setOrPostValue$camera_camera2(this.cameraState, cameraStateCreate);
        synchronized (this.lock) {
            list = CollectionsKt.toList(this.cameraStateListeners.entrySet());
        }
        for (Map.Entry entry : list) {
            final Consumer consumer = (Consumer) entry.getKey();
            ((Executor) entry.getValue()).execute(new Runnable() { // from class: androidx.camera.camera2.adapter.CameraStateAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(cameraStateCreate);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CombinedCameraState calculateNextState$camera_camera2(CameraInternal.State currentState, GraphState graphState) {
        Intrinsics.checkNotNullParameter(currentState, "currentState");
        Intrinsics.checkNotNullParameter(graphState, "graphState");
        int i = WhenMappings.$EnumSwitchMapping$0[currentState.ordinal()];
        int i2 = 2;
        CameraState.StateError stateError = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        Object[] objArr12 = 0;
        Object[] objArr13 = 0;
        Object[] objArr14 = 0;
        Object[] objArr15 = 0;
        Object[] objArr16 = 0;
        Object[] objArr17 = 0;
        Object[] objArr18 = 0;
        Object[] objArr19 = 0;
        Object[] objArr20 = 0;
        Object[] objArr21 = 0;
        if (i == 1) {
            if (Intrinsics.areEqual(graphState, GraphState.GraphStateStarting.INSTANCE)) {
                return new CombinedCameraState(CameraInternal.State.OPENING, objArr4 == true ? 1 : 0, i2, objArr3 == true ? 1 : 0);
            }
            if (Intrinsics.areEqual(graphState, GraphState.GraphStateStarted.INSTANCE)) {
                return new CombinedCameraState(CameraInternal.State.OPEN, objArr2 == true ? 1 : 0, i2, objArr == true ? 1 : 0);
            }
            return null;
        }
        if (i == 2) {
            if (Intrinsics.areEqual(graphState, GraphState.GraphStateStarted.INSTANCE)) {
                return new CombinedCameraState(CameraInternal.State.OPEN, objArr10 == true ? 1 : 0, i2, objArr9 == true ? 1 : 0);
            }
            if (graphState instanceof GraphState.GraphStateError) {
                GraphState.GraphStateError graphStateError = (GraphState.GraphStateError) graphState;
                if (graphStateError.getWillAttemptRetry()) {
                    return new CombinedCameraState(CameraInternal.State.OPENING, INSTANCE.m45toCameraStateError90vkdD0$camera_camera2(graphStateError.getCameraError()));
                }
                Companion companion = INSTANCE;
                if (companion.m44isRecoverableError90vkdD0$camera_camera2(graphStateError.getCameraError())) {
                    return new CombinedCameraState(CameraInternal.State.PENDING_OPEN, companion.m45toCameraStateError90vkdD0$camera_camera2(graphStateError.getCameraError()));
                }
                return new CombinedCameraState(CameraInternal.State.CLOSING, companion.m45toCameraStateError90vkdD0$camera_camera2(graphStateError.getCameraError()));
            }
            if (Intrinsics.areEqual(graphState, GraphState.GraphStateStopping.INSTANCE)) {
                return new CombinedCameraState(CameraInternal.State.CLOSING, objArr8 == true ? 1 : 0, i2, objArr7 == true ? 1 : 0);
            }
            if (Intrinsics.areEqual(graphState, GraphState.GraphStateStopped.INSTANCE)) {
                return new CombinedCameraState(CameraInternal.State.CLOSED, objArr6 == true ? 1 : 0, i2, objArr5 == true ? 1 : 0);
            }
            return null;
        }
        if (i == 3) {
            if (Intrinsics.areEqual(graphState, GraphState.GraphStateStopping.INSTANCE)) {
                return new CombinedCameraState(CameraInternal.State.CLOSING, objArr14 == true ? 1 : 0, i2, objArr13 == true ? 1 : 0);
            }
            if (Intrinsics.areEqual(graphState, GraphState.GraphStateStopped.INSTANCE)) {
                return new CombinedCameraState(CameraInternal.State.CLOSED, objArr12 == true ? 1 : 0, i2, objArr11 == true ? 1 : 0);
            }
            if (!(graphState instanceof GraphState.GraphStateError)) {
                return null;
            }
            Companion companion2 = INSTANCE;
            GraphState.GraphStateError graphStateError2 = (GraphState.GraphStateError) graphState;
            if (companion2.m44isRecoverableError90vkdD0$camera_camera2(graphStateError2.getCameraError())) {
                return new CombinedCameraState(CameraInternal.State.PENDING_OPEN, companion2.m45toCameraStateError90vkdD0$camera_camera2(graphStateError2.getCameraError()));
            }
            return new CombinedCameraState(CameraInternal.State.CLOSED, companion2.m45toCameraStateError90vkdD0$camera_camera2(graphStateError2.getCameraError()));
        }
        if (i == 4) {
            if (Intrinsics.areEqual(graphState, GraphState.GraphStateStopped.INSTANCE)) {
                return new CombinedCameraState(CameraInternal.State.CLOSED, objArr18 == true ? 1 : 0, i2, objArr17 == true ? 1 : 0);
            }
            if (Intrinsics.areEqual(graphState, GraphState.GraphStateStarting.INSTANCE)) {
                return new CombinedCameraState(CameraInternal.State.OPENING, objArr16 == true ? 1 : 0, i2, objArr15 == true ? 1 : 0);
            }
            if (graphState instanceof GraphState.GraphStateError) {
                return new CombinedCameraState(CameraInternal.State.CLOSING, INSTANCE.m45toCameraStateError90vkdD0$camera_camera2(((GraphState.GraphStateError) graphState).getCameraError()));
            }
            return null;
        }
        if (i != 5) {
            return null;
        }
        if (Intrinsics.areEqual(graphState, GraphState.GraphStateStarting.INSTANCE)) {
            return new CombinedCameraState(CameraInternal.State.OPENING, stateError, i2, objArr21 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(graphState, GraphState.GraphStateStarted.INSTANCE)) {
            return new CombinedCameraState(CameraInternal.State.OPEN, objArr20 == true ? 1 : 0, i2, objArr19 == true ? 1 : 0);
        }
        if (!(graphState instanceof GraphState.GraphStateError)) {
            return null;
        }
        Companion companion3 = INSTANCE;
        GraphState.GraphStateError graphStateError3 = (GraphState.GraphStateError) graphState;
        if (companion3.m44isRecoverableError90vkdD0$camera_camera2(graphStateError3.getCameraError())) {
            return new CombinedCameraState(CameraInternal.State.PENDING_OPEN, companion3.m45toCameraStateError90vkdD0$camera_camera2(graphStateError3.getCameraError()));
        }
        return new CombinedCameraState(CameraInternal.State.CLOSED, companion3.m45toCameraStateError90vkdD0$camera_camera2(graphStateError3.getCameraError()));
    }

    public final void addCameraStateListener$camera_camera2(Executor executor, Consumer<CameraState> listener) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            this.cameraStateListeners.put(listener, executor);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeCameraStateListener$camera_camera2(Consumer<CameraState> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            this.cameraStateListeners.remove(listener);
        }
    }

    /* JADX INFO: compiled from: CameraStateAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/adapter/CameraStateAdapter$CombinedCameraState;", "", "state", "Landroidx/camera/core/impl/CameraInternal$State;", "error", "Landroidx/camera/core/CameraState$StateError;", "<init>", "(Landroidx/camera/core/impl/CameraInternal$State;Landroidx/camera/core/CameraState$StateError;)V", "getState", "()Landroidx/camera/core/impl/CameraInternal$State;", "getError", "()Landroidx/camera/core/CameraState$StateError;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class CombinedCameraState {
        private final CameraState.StateError error;
        private final CameraInternal.State state;

        public static /* synthetic */ CombinedCameraState copy$default(CombinedCameraState combinedCameraState, CameraInternal.State state, CameraState.StateError stateError, int i, Object obj) {
            if ((i & 1) != 0) {
                state = combinedCameraState.state;
            }
            if ((i & 2) != 0) {
                stateError = combinedCameraState.error;
            }
            return combinedCameraState.copy(state, stateError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CameraInternal.State getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CameraState.StateError getError() {
            return this.error;
        }

        public final CombinedCameraState copy(CameraInternal.State state, CameraState.StateError error) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new CombinedCameraState(state, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CombinedCameraState)) {
                return false;
            }
            CombinedCameraState combinedCameraState = (CombinedCameraState) other;
            return this.state == combinedCameraState.state && Intrinsics.areEqual(this.error, combinedCameraState.error);
        }

        public int hashCode() {
            int iHashCode = this.state.hashCode() * 31;
            CameraState.StateError stateError = this.error;
            return iHashCode + (stateError == null ? 0 : stateError.hashCode());
        }

        public String toString() {
            return "CombinedCameraState(state=" + this.state + ", error=" + this.error + ')';
        }

        public CombinedCameraState(CameraInternal.State state, CameraState.StateError stateError) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.error = stateError;
        }

        public /* synthetic */ CombinedCameraState(CameraInternal.State state, CameraState.StateError stateError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(state, (i & 2) != 0 ? null : stateError);
        }

        public final CameraInternal.State getState() {
            return this.state;
        }

        public final CameraState.StateError getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: CameraStateAdapter.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u00020\n*\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u0017\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/adapter/CameraStateAdapter$Companion;", "", "<init>", "()V", "toCameraStateError", "Landroidx/camera/core/CameraState$StateError;", "Landroidx/camera/camera2/pipe/CameraError;", "toCameraStateError-90vkdD0$camera_camera2", "(I)Landroidx/camera/core/CameraState$StateError;", "toCameraState", "Landroidx/camera/core/CameraState$Type;", "Landroidx/camera/core/impl/CameraInternal$State;", "toCameraState$camera_camera2", "isRecoverableError", "", "cameraError", "isRecoverableError-90vkdD0$camera_camera2", "(I)Z", "setOrPostValue", "", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/camera/core/CameraState;", "cameraState", "setOrPostValue$camera_camera2", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: CameraStateAdapter.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CameraInternal.State.values().length];
                try {
                    iArr[CameraInternal.State.CLOSED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CameraInternal.State.OPENING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CameraInternal.State.OPEN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CameraInternal.State.CLOSING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CameraInternal.State.PENDING_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:7:0x001c  */
        /* JADX INFO: renamed from: toCameraStateError-90vkdD0$camera_camera2, reason: not valid java name */
        public final CameraState.StateError m45toCameraStateError90vkdD0$camera_camera2(int i) {
            int i2 = 6;
            if (!CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m374getERROR_UNDETERMINEDv7Vf74A())) {
                if (CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m365getERROR_CAMERA_IN_USEv7Vf74A())) {
                    i2 = 2;
                } else if (CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m366getERROR_CAMERA_LIMIT_EXCEEDEDv7Vf74A())) {
                    i2 = 1;
                } else if (CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m363getERROR_CAMERA_DISABLEDv7Vf74A())) {
                    i2 = 5;
                } else if (CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m362getERROR_CAMERA_DEVICEv7Vf74A())) {
                    i2 = 3;
                } else if (!CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m369getERROR_CAMERA_SERVICEv7Vf74A())) {
                    if (CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m364getERROR_CAMERA_DISCONNECTEDv7Vf74A())) {
                        i2 = 2;
                    } else if (!CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m372getERROR_ILLEGAL_ARGUMENT_EXCEPTIONv7Vf74A()) && !CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m373getERROR_SECURITY_EXCEPTIONv7Vf74A())) {
                        if (CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m371getERROR_GRAPH_CONFIGv7Vf74A())) {
                            i2 = 4;
                        } else if (CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m370getERROR_DO_NOT_DISTURB_ENABLEDv7Vf74A())) {
                            i2 = 7;
                        } else if (!CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m375getERROR_UNKNOWN_EXCEPTIONv7Vf74A()) && !CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m367getERROR_CAMERA_OPENERv7Vf74A()) && !CameraError.m354equalsimpl0(i, CameraError.INSTANCE.m368getERROR_CAMERA_OPEN_TIMEOUTv7Vf74A())) {
                            throw new IllegalArgumentException("Unexpected CameraError: " + ((Object) CameraError.m357toStringimpl(i)));
                        }
                    }
                }
            }
            CameraState.StateError stateErrorCreate = CameraState.StateError.create(i2);
            Intrinsics.checkNotNullExpressionValue(stateErrorCreate, "create(...)");
            return stateErrorCreate;
        }

        public final CameraState.Type toCameraState$camera_camera2(CameraInternal.State state) {
            Intrinsics.checkNotNullParameter(state, "<this>");
            int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i == 1) {
                return CameraState.Type.CLOSED;
            }
            if (i == 2) {
                return CameraState.Type.OPENING;
            }
            if (i == 3) {
                return CameraState.Type.OPEN;
            }
            if (i == 4) {
                return CameraState.Type.CLOSING;
            }
            if (i == 5) {
                return CameraState.Type.PENDING_OPEN;
            }
            throw new IllegalArgumentException("Unexpected CameraInternal state: " + state);
        }

        /* JADX INFO: renamed from: isRecoverableError-90vkdD0$camera_camera2, reason: not valid java name */
        public final boolean m44isRecoverableError90vkdD0$camera_camera2(int cameraError) {
            return CameraError.m354equalsimpl0(cameraError, CameraError.INSTANCE.m364getERROR_CAMERA_DISCONNECTEDv7Vf74A()) || CameraError.m354equalsimpl0(cameraError, CameraError.INSTANCE.m365getERROR_CAMERA_IN_USEv7Vf74A()) || CameraError.m354equalsimpl0(cameraError, CameraError.INSTANCE.m366getERROR_CAMERA_LIMIT_EXCEEDEDv7Vf74A()) || CameraError.m354equalsimpl0(cameraError, CameraError.INSTANCE.m362getERROR_CAMERA_DEVICEv7Vf74A());
        }

        public final void setOrPostValue$camera_camera2(MutableLiveData<CameraState> mutableLiveData, CameraState cameraState) {
            Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
            Intrinsics.checkNotNullParameter(cameraState, "cameraState");
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                mutableLiveData.setValue(cameraState);
            } else {
                mutableLiveData.postValue(cameraState);
            }
        }
    }
}
