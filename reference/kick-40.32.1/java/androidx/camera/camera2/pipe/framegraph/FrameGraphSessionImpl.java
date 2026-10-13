package androidx.camera.camera2.pipe.framegraph;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.AwbMode;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.FrameCapture;
import androidx.camera.camera2.pipe.FrameGraph;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.config.FrameGraphScope;
import androidx.camera.camera2.pipe.graph.Controller3A;
import androidx.camera.camera2.pipe.graph.State3A;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: FrameGraphSessionImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@FrameGraphScope
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0013H\u0096\u0001JÐ\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00132\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00132\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010\u00192\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0096A¢\u0006\u0004\b1\u00102J:\u00103\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(2\u0006\u0010,\u001a\u00020-2\u0006\u00104\u001a\u00020/H\u0096A¢\u0006\u0002\u00105J4\u00103\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\u0006\u00104\u001a\u00020/H\u0096A¢\u0006\u0002\u00108J\u001e\u00109\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0001¢\u0006\u0002\b:J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0096\u0001J\u0011\u0010<\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010=\u001a\u00020\rH\u0096\u0001J\u0011\u0010>\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0017\u0010>\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0013H\u0096\u0001Jb\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00132\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00132\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0013H\u0096\u0001¢\u0006\u0002\b@JX\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010B\u001a\u0004\u0018\u00010*2\b\u0010C\u001a\u0004\u0018\u00010*2\b\u0010D\u001a\u0004\u0018\u00010*2\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(2\u0006\u0010,\u001a\u00020-2\u0006\u00104\u001a\u00020/H\u0096A¢\u0006\u0002\u0010FJ\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010H\u001a\u00020*H\u0096A¢\u0006\u0002\u0010IJb\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00132\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00132\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0013H\u0096\u0001¢\u0006\u0002\bKR\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Landroidx/camera/camera2/pipe/framegraph/FrameGraphSessionImpl;", "Landroidx/camera/camera2/pipe/FrameGraph$Session;", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "cameraGraphSession", "frameGraphBuffers", "Landroidx/camera/camera2/pipe/framegraph/FrameGraphBuffers;", "controller3A", "Landroidx/camera/camera2/pipe/graph/Controller3A;", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph$Session;Landroidx/camera/camera2/pipe/framegraph/FrameGraphBuffers;Landroidx/camera/camera2/pipe/graph/Controller3A;)V", "state3ASnapshot", "Landroidx/camera/camera2/pipe/graph/State3A;", "close", "", "abort", "capture", "Landroidx/camera/camera2/pipe/FrameCapture;", "request", "Landroidx/camera/camera2/pipe/Request;", "", "requests", "lock3A", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "aeRegions", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "aeLockBehavior", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "convergedCondition", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "", "lockedCondition", "frameLimit", "", "convergedTimeLimitNs", "", "lockedTimeLimitNs", "lock3A--tS25XM", "(Landroidx/camera/camera2/pipe/AeMode;Landroidx/camera/camera2/pipe/AfMode;Landroidx/camera/camera2/pipe/AwbMode;Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/AeMode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;IJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lock3AForCapture", "timeLimitNs", "(Lkotlin/jvm/functions/Function1;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerAf", "waitForAwb", "(ZZIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTorchOff", "setTorchOff-NqN7i0k", "setTorchOn", "startRepeating", "stopRepeating", "submit", "submit3A", "submit3A-ydBZfZg", "unlock3A", "ae", "af", "awb", "unlockedCondition", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unlock3APostCapture", "cancelAf", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update3A", "update3A-ydBZfZg", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameGraphSessionImpl implements FrameGraph.Session, CameraGraph.Session {
    private final CameraGraph.Session cameraGraphSession;
    private final Controller3A controller3A;
    private final FrameGraphBuffers frameGraphBuffers;
    private final State3A state3ASnapshot;

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void abort() {
        this.cameraGraphSession.abort();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public FrameCapture capture(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.cameraGraphSession.capture(request);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public List<FrameCapture> capture(List<Request> requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        return this.cameraGraphSession.capture(requests);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    /* JADX INFO: renamed from: lock3A--tS25XM */
    public Object mo420lock3AtS25XM(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> list, List<MeteringRectangle> list2, List<MeteringRectangle> list3, Lock3ABehavior lock3ABehavior, Lock3ABehavior lock3ABehavior2, Lock3ABehavior lock3ABehavior3, AeMode aeMode2, Function1<? super FrameMetadata, Boolean> function1, Function1<? super FrameMetadata, Boolean> function2, int i, long j, long j2, Continuation<? super Deferred<Result3A>> continuation) {
        return this.cameraGraphSession.mo420lock3AtS25XM(aeMode, afMode, awbMode, list, list2, list3, lock3ABehavior, lock3ABehavior2, lock3ABehavior3, aeMode2, function1, function2, i, j, j2, continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public Object lock3AForCapture(Function1<? super FrameMetadata, Boolean> function1, int i, long j, Continuation<? super Deferred<Result3A>> continuation) {
        return this.cameraGraphSession.lock3AForCapture(function1, i, j, continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public Object lock3AForCapture(boolean z, boolean z2, int i, long j, Continuation<? super Deferred<Result3A>> continuation) {
        return this.cameraGraphSession.lock3AForCapture(z, z2, i, j, continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: setTorchOff-NqN7i0k */
    public Deferred<Result3A> mo308setTorchOffNqN7i0k(AeMode aeMode) {
        return this.cameraGraphSession.mo308setTorchOffNqN7i0k(aeMode);
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    public Deferred<Result3A> setTorchOn() {
        return this.cameraGraphSession.setTorchOn();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void startRepeating(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.cameraGraphSession.startRepeating(request);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void stopRepeating() {
        this.cameraGraphSession.stopRepeating();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void submit(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.cameraGraphSession.submit(request);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public void submit(List<Request> requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        this.cameraGraphSession.submit(requests);
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: submit3A-ydBZfZg */
    public Deferred<Result3A> mo309submit3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        return this.cameraGraphSession.mo309submit3AydBZfZg(aeMode, afMode, awbMode, aeRegions, afRegions, awbRegions);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public Object unlock3A(Boolean bool, Boolean bool2, Boolean bool3, Function1<? super FrameMetadata, Boolean> function1, int i, long j, Continuation<? super Deferred<Result3A>> continuation) {
        return this.cameraGraphSession.unlock3A(bool, bool2, bool3, function1, i, j, continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.Session
    public Object unlock3APostCapture(boolean z, Continuation<? super Deferred<Result3A>> continuation) {
        return this.cameraGraphSession.unlock3APostCapture(z, continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraControls3A
    /* JADX INFO: renamed from: update3A-ydBZfZg */
    public Deferred<Result3A> mo310update3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        return this.cameraGraphSession.mo310update3AydBZfZg(aeMode, afMode, awbMode, aeRegions, afRegions, awbRegions);
    }

    public FrameGraphSessionImpl(CameraGraph.Session cameraGraphSession, FrameGraphBuffers frameGraphBuffers, Controller3A controller3A) {
        Intrinsics.checkNotNullParameter(cameraGraphSession, "cameraGraphSession");
        Intrinsics.checkNotNullParameter(frameGraphBuffers, "frameGraphBuffers");
        Intrinsics.checkNotNullParameter(controller3A, "controller3A");
        this.cameraGraphSession = cameraGraphSession;
        this.frameGraphBuffers = frameGraphBuffers;
        this.controller3A = controller3A;
        this.state3ASnapshot = controller3A.state3ASnapshot();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        this.controller3A.reset3A(this.state3ASnapshot);
        UByte$$ExternalSyntheticBackport0.m12761m((Object) this.cameraGraphSession);
        this.frameGraphBuffers.invalidate();
    }
}
