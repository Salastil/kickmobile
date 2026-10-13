package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestListeners;
import androidx.camera.camera2.pipe.config.CameraGraphScope;
import androidx.camera.camera2.pipe.config.ForCameraGraph;
import androidx.camera.camera2.pipe.core.Token;
import androidx.camera.camera2.pipe.graph.GraphProcessor;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CameraGraphRequestListenersImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B#\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0016\u0010\u0014\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0016\u0010\u0017\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016J\u0015\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraGraphRequestListenersImpl;", "Landroidx/camera/camera2/pipe/RequestListeners;", "sessionLock", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "graphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "graphScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/camera/camera2/pipe/internal/GraphSessionLock;Landroidx/camera/camera2/pipe/graph/GraphProcessor;Lkotlinx/coroutines/CoroutineScope;)V", "lock", "", "listeners", "", "Landroidx/camera/camera2/pipe/Request$Listener;", "dirty", "", "add", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addAll", "", "remove", "removeAll", "fetchUpdatedListeners", "fetchUpdatedListeners$camera_camera2_pipe", "applyUpdate", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraGraphRequestListenersImpl implements RequestListeners {
    private boolean dirty;
    private final GraphProcessor graphProcessor;
    private final CoroutineScope graphScope;
    private final Set<Request.Listener> listeners;
    private final Object lock;
    private final GraphSessionLock sessionLock;

    @Inject
    public CameraGraphRequestListenersImpl(GraphSessionLock sessionLock, GraphProcessor graphProcessor, @ForCameraGraph CoroutineScope graphScope) {
        Intrinsics.checkNotNullParameter(sessionLock, "sessionLock");
        Intrinsics.checkNotNullParameter(graphProcessor, "graphProcessor");
        Intrinsics.checkNotNullParameter(graphScope, "graphScope");
        this.sessionLock = sessionLock;
        this.graphProcessor = graphProcessor;
        this.graphScope = graphScope;
        this.lock = new Object();
        this.listeners = new LinkedHashSet();
    }

    @Override // androidx.camera.camera2.pipe.RequestListeners
    public void add(Request.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        addAll(CollectionsKt.listOf(listener));
    }

    @Override // androidx.camera.camera2.pipe.RequestListeners
    public void addAll(List<? extends Request.Listener> listeners) {
        boolean z;
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        synchronized (this.lock) {
            if (!this.listeners.addAll(listeners) || this.dirty) {
                z = false;
            } else {
                z = true;
                this.dirty = true;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            applyUpdate();
        }
    }

    @Override // androidx.camera.camera2.pipe.RequestListeners
    public void remove(Request.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        removeAll(CollectionsKt.listOf(listener));
    }

    @Override // androidx.camera.camera2.pipe.RequestListeners
    public void removeAll(List<? extends Request.Listener> listeners) {
        boolean z;
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        synchronized (this.lock) {
            if (!this.listeners.removeAll(listeners) || this.dirty) {
                z = false;
            } else {
                z = true;
                this.dirty = true;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            applyUpdate();
        }
    }

    public final List<Request.Listener> fetchUpdatedListeners$camera_camera2_pipe() {
        synchronized (this.lock) {
            if (!this.dirty) {
                return null;
            }
            this.dirty = false;
            return CollectionsKt.toList(this.listeners);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.internal.CameraGraphRequestListenersImpl$applyUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: CameraGraphRequestListenersImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/camera/camera2/pipe/core/Token;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.internal.CameraGraphRequestListenersImpl$applyUpdate$1", f = "CameraGraphRequestListenersImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Token, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Request.Listener> $unappliedListeners;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends Request.Listener> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$unappliedListeners = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraGraphRequestListenersImpl.this.new AnonymousClass1(this.$unappliedListeners, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Token token, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(token, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CameraGraphRequestListenersImpl.this.graphProcessor.updateRequestListeners(this.$unappliedListeners);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void applyUpdate() {
        List<Request.Listener> listFetchUpdatedListeners$camera_camera2_pipe = fetchUpdatedListeners$camera_camera2_pipe();
        if (listFetchUpdatedListeners$camera_camera2_pipe == null) {
            return;
        }
        this.sessionLock.withTokenIn$camera_camera2_pipe(this.graphScope, new AnonymousClass1(listFetchUpdatedListeners$camera_camera2_pipe, null));
    }
}
