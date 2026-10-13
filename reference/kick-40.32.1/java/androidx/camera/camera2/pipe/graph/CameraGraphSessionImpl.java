package androidx.camera.camera2.pipe.graph;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.AwbMode;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.FrameCapture;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.core.Token;
import androidx.camera.camera2.pipe.internal.CameraGraphParametersImpl;
import androidx.camera.camera2.pipe.internal.CameraGraphRequestListenersImpl;
import androidx.camera.camera2.pipe.internal.FrameCaptureQueue;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: CameraGraphSessionImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016Ja\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00172\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00172\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0017H\u0016¢\u0006\u0002\b+Ja\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00172\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00172\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0017H\u0016¢\u0006\u0002\b-J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\b0JÐ\u0001\u00101\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00172\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00172\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00172\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001032\b\u00105\u001a\u0004\u0018\u0001032\b\u00106\u001a\u0004\u0018\u00010\"2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:\u0018\u0001082\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:\u0018\u0001082\u0006\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0096@¢\u0006\u0004\b@\u0010AJX\u0010B\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010C\u001a\u0004\u0018\u00010:2\b\u0010D\u001a\u0004\u0018\u00010:2\b\u0010E\u001a\u0004\u0018\u00010:2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:\u0018\u0001082\u0006\u0010<\u001a\u00020\u00112\u0006\u0010G\u001a\u00020>H\u0096@¢\u0006\u0002\u0010HJ:\u0010I\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:\u0018\u0001082\u0006\u0010<\u001a\u00020\u00112\u0006\u0010G\u001a\u00020>H\u0096@¢\u0006\u0002\u0010JJ4\u0010I\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010K\u001a\u00020:2\u0006\u0010L\u001a\u00020:2\u0006\u0010<\u001a\u00020\u00112\u0006\u0010G\u001a\u00020>H\u0096@¢\u0006\u0002\u0010MJ\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010O\u001a\u00020:H\u0096@¢\u0006\u0002\u0010PJ\b\u0010Q\u001a\u00020RH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Landroidx/camera/camera2/pipe/graph/CameraGraphSessionImpl;", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "token", "Landroidx/camera/camera2/pipe/core/Token;", "graphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "controller3A", "Landroidx/camera/camera2/pipe/graph/Controller3A;", "frameCaptureQueue", "Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;", "parameters", "Landroidx/camera/camera2/pipe/internal/CameraGraphParametersImpl;", "listeners", "Landroidx/camera/camera2/pipe/internal/CameraGraphRequestListenersImpl;", "<init>", "(Landroidx/camera/camera2/pipe/core/Token;Landroidx/camera/camera2/pipe/graph/GraphProcessor;Landroidx/camera/camera2/pipe/graph/Controller3A;Landroidx/camera/camera2/pipe/internal/FrameCaptureQueue;Landroidx/camera/camera2/pipe/internal/CameraGraphParametersImpl;Landroidx/camera/camera2/pipe/internal/CameraGraphRequestListenersImpl;)V", "debugId", "", "submit", "", "request", "Landroidx/camera/camera2/pipe/Request;", "requests", "", "capture", "Landroidx/camera/camera2/pipe/FrameCapture;", "startRepeating", "abort", "stopRepeating", "close", "update3A", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "aeRegions", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "update3A-ydBZfZg", "submit3A", "submit3A-ydBZfZg", "setTorchOn", "setTorchOff", "setTorchOff-NqN7i0k", "lock3A", "aeLockBehavior", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "convergedCondition", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "", "lockedCondition", "frameLimit", "convergedTimeLimitNs", "", "lockedTimeLimitNs", "lock3A--tS25XM", "(Landroidx/camera/camera2/pipe/AeMode;Landroidx/camera/camera2/pipe/AfMode;Landroidx/camera/camera2/pipe/AwbMode;Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/AeMode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unlock3A", "ae", "af", "awb", "unlockedCondition", "timeLimitNs", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lock3AForCapture", "(Lkotlin/jvm/functions/Function1;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerAf", "waitForAwb", "(ZZIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unlock3APostCapture", "cancelAf", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraGraphSessionImpl implements CameraGraph.Session {
    private final Controller3A controller3A;
    private final int debugId;
    private final FrameCaptureQueue frameCaptureQueue;
    private final GraphProcessor graphProcessor;
    private final CameraGraphRequestListenersImpl listeners;
    private final CameraGraphParametersImpl parameters;
    private final Token token;

    public CameraGraphSessionImpl(Token token, GraphProcessor graphProcessor, Controller3A controller3A, FrameCaptureQueue frameCaptureQueue, CameraGraphParametersImpl parameters, CameraGraphRequestListenersImpl listeners) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(graphProcessor, "graphProcessor");
        Intrinsics.checkNotNullParameter(controller3A, "controller3A");
        Intrinsics.checkNotNullParameter(frameCaptureQueue, "frameCaptureQueue");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.token = token;
        this.graphProcessor = graphProcessor;
        this.controller3A = controller3A;
        this.frameCaptureQueue = frameCaptureQueue;
        this.parameters = parameters;
        this.listeners = listeners;
        this.debugId = CameraGraphSessionImplKt.getCameraGraphSessionIds().incrementAndGet();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void submit(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call submit on " + this + " after close.").toString());
        }
        this.graphProcessor.submit(request);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void submit(List<Request> requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call submit on " + this + " after close.").toString());
        }
        if (requests.isEmpty()) {
            throw new IllegalStateException("Cannot call submit with an empty list of Requests!".toString());
        }
        this.graphProcessor.submit(requests);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public FrameCapture capture(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        FrameCaptureQueue.FrameCaptureImpl frameCaptureImplEnqueue = this.frameCaptureQueue.enqueue(request);
        submit(request);
        return frameCaptureImplEnqueue;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public List<FrameCapture> capture(List<Request> requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        List<FrameCapture> listEnqueue = this.frameCaptureQueue.enqueue(requests);
        submit(requests);
        return listEnqueue;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void startRepeating(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call startRepeating on " + this + " after close.").toString());
        }
        this.graphProcessor.setRepeatingRequest(request);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void abort() {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call abort on " + this + " after close.").toString());
        }
        this.graphProcessor.abort();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void stopRepeating() {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call stopRepeating on " + this + " after close.").toString());
        }
        this.graphProcessor.setRepeatingRequest(null);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.parameters.flush();
        List<Request.Listener> listFetchUpdatedListeners$camera_camera2_pipe = this.listeners.fetchUpdatedListeners$camera_camera2_pipe();
        if (listFetchUpdatedListeners$camera_camera2_pipe != null) {
            this.graphProcessor.updateRequestListeners(listFetchUpdatedListeners$camera_camera2_pipe);
        }
        this.token.release();
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: update3A-ydBZfZg */
    public Deferred<Result3A> mo310update3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call update3A on " + this + " after close.").toString());
        }
        return Controller3A.m952update3A169HPGg$default(this.controller3A, aeMode, afMode, awbMode, null, aeRegions, afRegions, awbRegions, 8, null);
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: submit3A-ydBZfZg */
    public Deferred<Result3A> mo309submit3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call submit3A on " + this + " after close.").toString());
        }
        return this.controller3A.m955submit3AydBZfZg(aeMode, afMode, awbMode, aeRegions, afRegions, awbRegions);
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    public Deferred<Result3A> setTorchOn() {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call setTorchOn on " + this + " after close.").toString());
        }
        return this.controller3A.setTorchOn();
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: setTorchOff-NqN7i0k */
    public Deferred<Result3A> mo308setTorchOffNqN7i0k(AeMode aeMode) {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call setTorchOff on " + this + " after close.").toString());
        }
        return this.controller3A.m954setTorchOffNqN7i0k(aeMode);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    /* JADX INFO: renamed from: lock3A--tS25XM */
    public Object mo420lock3AtS25XM(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> list, List<MeteringRectangle> list2, List<MeteringRectangle> list3, Lock3ABehavior lock3ABehavior, Lock3ABehavior lock3ABehavior2, Lock3ABehavior lock3ABehavior3, AeMode aeMode2, Function1<? super FrameMetadata, Boolean> function1, Function1<? super FrameMetadata, Boolean> function2, int i, long j, long j2, Continuation<? super Deferred<Result3A>> continuation) {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call lock3A on " + this + " after close.").toString());
        }
        return this.controller3A.m953lock3AQz1gx5w(list, list2, list3, lock3ABehavior, lock3ABehavior2, lock3ABehavior3, aeMode2, function1, function2, i, Boxing.boxLong(j), Boxing.boxLong(j2), continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public Object unlock3A(Boolean bool, Boolean bool2, Boolean bool3, Function1<? super FrameMetadata, Boolean> function1, int i, long j, Continuation<? super Deferred<Result3A>> continuation) {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call unlock3A on " + this + " after close.").toString());
        }
        return this.controller3A.unlock3A(bool, bool2, bool3, function1, i, Boxing.boxLong(j));
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public Object lock3AForCapture(Function1<? super FrameMetadata, Boolean> function1, int i, long j, Continuation<? super Deferred<Result3A>> continuation) {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call lock3AForCapture on " + this + " after close.").toString());
        }
        return this.controller3A.lock3AForCapture(function1, i, j);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public Object lock3AForCapture(boolean z, boolean z2, int i, long j, Continuation<? super Deferred<Result3A>> continuation) {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call lock3AForCapture on " + this + " after close.").toString());
        }
        return this.controller3A.lock3AForCapture(z, z2, i, j);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public Object unlock3APostCapture(boolean z, Continuation<? super Deferred<Result3A>> continuation) {
        if (this.token.getReleased()) {
            throw new IllegalStateException(("Cannot call unlock3APostCapture on " + this + " after close.").toString());
        }
        return this.controller3A.unlock3APostCapture(z);
    }

    public String toString() {
        return "CameraGraph.Session-" + this.debugId;
    }
}
