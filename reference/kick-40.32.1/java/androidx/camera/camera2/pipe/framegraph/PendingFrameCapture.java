package androidx.camera.camera2.pipe.framegraph;

import androidx.camera.camera2.pipe.Frame;
import androidx.camera.camera2.pipe.FrameCapture;
import androidx.camera.camera2.pipe.OutputStatus;
import androidx.camera.camera2.pipe.Request;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: PendingFrameCapture.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0006\u0010 \u001a\u00020\u0013J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Landroidx/camera/camera2/pipe/framegraph/PendingFrameCapture;", "Landroidx/camera/camera2/pipe/FrameCapture;", "request", "Landroidx/camera/camera2/pipe/Request;", "<init>", "(Landroidx/camera/camera2/pipe/Request;)V", "getRequest", "()Landroidx/camera/camera2/pipe/Request;", "lock", "", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "closed", "", "aborted", "pendingListeners", "", "Landroidx/camera/camera2/pipe/Frame$Listener;", "setFrameCapture", "", "frameCapture", "status", "Landroidx/camera/camera2/pipe/OutputStatus;", "getStatus-U7r42EA", "()I", "awaitFrame", "Landroidx/camera/camera2/pipe/Frame;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFrame", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "close", "abort", "terminate", "asClosed", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PendingFrameCapture implements FrameCapture {
    private boolean aborted;
    private boolean closed;
    private final CompletableDeferred<FrameCapture> deferred;
    private final Object lock;
    private List<Frame.Listener> pendingListeners;
    private final Request request;

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.framegraph.PendingFrameCapture$awaitFrame$1, reason: invalid class name */
    /* JADX INFO: compiled from: PendingFrameCapture.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.framegraph.PendingFrameCapture", f = "PendingFrameCapture.kt", i = {}, l = {83, 83}, m = "awaitFrame", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PendingFrameCapture.this.awaitFrame(this);
        }
    }

    public PendingFrameCapture(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        this.lock = new Object();
        this.deferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.pendingListeners = new ArrayList();
    }

    @Override // androidx.camera.camera2.pipe.FrameCapture
    public Request getRequest() {
        return this.request;
    }

    public final void setFrameCapture(FrameCapture frameCapture) {
        Intrinsics.checkNotNullParameter(frameCapture, "frameCapture");
        synchronized (this.lock) {
            if (!this.closed && !this.aborted) {
                if (!this.deferred.complete(frameCapture)) {
                    UByte$$ExternalSyntheticBackport0.m12761m((Object) frameCapture);
                    return;
                }
                List<Frame.Listener> list = this.pendingListeners;
                this.pendingListeners = null;
                Unit unit = Unit.INSTANCE;
                if (list != null) {
                    Iterator<Frame.Listener> it = list.iterator();
                    while (it.hasNext()) {
                        frameCapture.addListener(it.next());
                    }
                    return;
                }
                return;
            }
            UByte$$ExternalSyntheticBackport0.m12761m((Object) frameCapture);
        }
    }

    @Override // androidx.camera.camera2.pipe.FrameCapture
    /* JADX INFO: renamed from: getStatus-U7r42EA */
    public int mo518getStatusU7r42EA() {
        int iM591getUNAVAILABLEU7r42EA;
        FrameCapture completed;
        synchronized (this.lock) {
            if (this.deferred.isCompleted() && (completed = this.deferred.getCompleted()) != null) {
                return completed.mo518getStatusU7r42EA();
            }
            if (this.aborted) {
                iM591getUNAVAILABLEU7r42EA = OutputStatus.INSTANCE.m586getERROR_OUTPUT_ABORTEDU7r42EA();
            } else {
                iM591getUNAVAILABLEU7r42EA = this.closed ? OutputStatus.INSTANCE.m591getUNAVAILABLEU7r42EA() : OutputStatus.INSTANCE.m590getPENDINGU7r42EA();
            }
            return iM591getUNAVAILABLEU7r42EA;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.FrameCapture
    public Object awaitFrame(Continuation<? super Frame> continuation) {
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
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            CompletableDeferred<FrameCapture> completableDeferred = this.deferred;
            anonymousClass1.label = 1;
            objAwait = completableDeferred.await(anonymousClass1);
            if (objAwait != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
            return objAwait;
        }
        ResultKt.throwOnFailure(objAwait);
        FrameCapture frameCapture = (FrameCapture) objAwait;
        if (frameCapture == null) {
            return null;
        }
        anonymousClass1.label = 2;
        Object objAwaitFrame = frameCapture.awaitFrame(anonymousClass1);
        return objAwaitFrame == coroutine_suspended ? coroutine_suspended : objAwaitFrame;
    }

    @Override // androidx.camera.camera2.pipe.FrameCapture
    public Frame getFrame() {
        FrameCapture completed;
        if (!this.deferred.isCompleted() || (completed = this.deferred.getCompleted()) == null) {
            return null;
        }
        return completed.getFrame();
    }

    @Override // androidx.camera.camera2.pipe.FrameCapture
    public void addListener(Frame.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            if (!this.closed && !this.aborted) {
                if (!this.deferred.isCompleted()) {
                    List<Frame.Listener> list = this.pendingListeners;
                    if (list != null) {
                        list.add(listener);
                    }
                    return;
                } else {
                    FrameCapture completed = this.deferred.getCompleted();
                    Unit unit = Unit.INSTANCE;
                    FrameCapture frameCapture = completed;
                    if (frameCapture != null) {
                        frameCapture.addListener(listener);
                        return;
                    }
                    return;
                }
            }
            listener.onFrameComplete();
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        terminate(true);
    }

    public final void abort() throws Exception {
        terminate(false);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.util.List<androidx.camera.camera2.pipe.Frame$Listener>] */
    private final void terminate(boolean asClosed) throws Exception {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            if (!this.closed && !this.aborted) {
                if (asClosed) {
                    this.closed = true;
                } else {
                    this.aborted = true;
                }
                this.deferred.complete(null);
                ?? r4 = this.pendingListeners;
                this.pendingListeners = null;
                objectRef.element = r4;
                FrameCapture completed = this.deferred.getCompleted();
                Unit unit = Unit.INSTANCE;
                if (objectRef.element != 0) {
                    Iterator it = ((List) objectRef.element).iterator();
                    while (it.hasNext()) {
                        ((Frame.Listener) it.next()).onFrameComplete();
                    }
                }
                FrameCapture frameCapture = completed;
                if (frameCapture != null) {
                    UByte$$ExternalSyntheticBackport0.m12761m((Object) frameCapture);
                }
            }
        }
    }
}
