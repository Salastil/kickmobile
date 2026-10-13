package androidx.camera.camera2.pipe;

import android.hardware.camera2.params.MeteringRectangle;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph.Session;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: CameraGraph.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00060\u0003j\u0002`\u0004J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J!\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H&¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\n2\u0006\u00102\u001a\u000203H&¢\u0006\u0004\b4\u00105Jë\u0001\u00106\u001a\b\u0012\u0004\u0012\u000208072\n\b\u0002\u00109\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010:2\u0016\b\u0002\u0010I\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020&\u0018\u00010J2\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020&\u0018\u00010J2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020PH&¢\u0006\u0002\bRJc\u0010S\u001a\b\u0012\u0004\u0012\u000208072\n\b\u0002\u0010T\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010&2\u0016\b\u0002\u0010W\u001a\u0010\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020&\u0018\u00010J2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010X\u001a\u00020PH&¢\u0006\u0002\u0010YJ\u000e\u0010Z\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010[J\u000f\u0010\\\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010]JC\u0010^\u001a\u0002H_\"\u0004\b\u0001\u0010_2-\u0010`\u001a)\b\u0001\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H_0c\u0012\u0006\u0012\u0004\u0018\u00010d0a¢\u0006\u0002\beH¦@¢\u0006\u0002\u0010fJP\u0010g\u001a\b\u0012\u0004\u0012\u0002H_07\"\u0004\b\u0001\u0010_2\u0006\u0010h\u001a\u00020b2-\u0010`\u001a)\b\u0001\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H_0c\u0012\u0006\u0012\u0004\u0018\u00010d0a¢\u0006\u0002\beH&¢\u0006\u0002\u0010iR\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010!R\u0018\u0010%\u001a\u00020&X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006jÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraphBase;", "TSession", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "id", "Landroidx/camera/camera2/pipe/CameraGraphId;", "getId", "()Landroidx/camera/camera2/pipe/CameraGraphId;", ViewProps.START, "", "stop", "parameters", "Landroidx/camera/camera2/pipe/Parameters;", "getParameters", "()Landroidx/camera/camera2/pipe/Parameters;", "listeners", "Landroidx/camera/camera2/pipe/RequestListeners;", "getListeners", "()Landroidx/camera/camera2/pipe/RequestListeners;", "streams", "Landroidx/camera/camera2/pipe/StreamGraph;", "getStreams", "()Landroidx/camera/camera2/pipe/StreamGraph;", "graphState", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/camera/camera2/pipe/GraphState;", "getGraphState", "()Lkotlinx/coroutines/flow/StateFlow;", "latestFrameNumber", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/camera/camera2/pipe/FrameNumber;", "getLatestFrameNumber", "()Lkotlinx/coroutines/flow/Flow;", "latestFrameInfo", "Landroidx/camera/camera2/pipe/FrameInfo;", "getLatestFrameInfo", "isForeground", "", "()Z", "setForeground", "(Z)V", "setSurface", "stream", "Landroidx/camera/camera2/pipe/StreamId;", "surface", "Landroid/view/Surface;", "setSurface-NYG5g8E", "(ILandroid/view/Surface;)V", "updateAudioRestrictionMode", "mode", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "updateAudioRestrictionMode-LwUUkyU", "(I)V", "lock3A", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "aeRegions", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "aeLockBehavior", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "convergedCondition", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "lockedCondition", "frameLimit", "", "convergedTimeLimitNs", "", "lockedTimeLimitNs", "lock3A-vIrNa9k", "unlock3A", "ae", "af", "awb", "unlockedCondition", "timeLimitNs", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;IJ)Lkotlinx/coroutines/Deferred;", "acquireSession", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSessionOrNull", "()Landroidx/camera/camera2/pipe/CameraGraph$Session;", "useSession", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useSessionIn", PermissionsResponse.SCOPE_KEY, "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/Deferred;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraGraphBase<TSession extends CameraGraph.Session> extends AutoCloseable {
    Object acquireSession(Continuation<? super TSession> continuation);

    TSession acquireSessionOrNull();

    StateFlow<GraphState> getGraphState();

    CameraGraphId getId();

    Flow<FrameInfo> getLatestFrameInfo();

    Flow<FrameNumber> getLatestFrameNumber();

    RequestListeners getListeners();

    Parameters getParameters();

    StreamGraph getStreams();

    /* JADX INFO: renamed from: isForeground */
    boolean getIsForeground();

    /* JADX INFO: renamed from: lock3A-vIrNa9k, reason: not valid java name */
    Deferred<Result3A> mo423lock3AvIrNa9k(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions, Lock3ABehavior aeLockBehavior, Lock3ABehavior afLockBehavior, Lock3ABehavior awbLockBehavior, AeMode afTriggerStartAeMode, Function1<? super FrameMetadata, Boolean> convergedCondition, Function1<? super FrameMetadata, Boolean> lockedCondition, int frameLimit, long convergedTimeLimitNs, long lockedTimeLimitNs);

    void setForeground(boolean z);

    /* JADX INFO: renamed from: setSurface-NYG5g8E, reason: not valid java name */
    void mo424setSurfaceNYG5g8E(int stream, Surface surface);

    void start();

    void stop();

    Deferred<Result3A> unlock3A(Boolean ae, Boolean af, Boolean awb, Function1<? super FrameMetadata, Boolean> unlockedCondition, int frameLimit, long timeLimitNs);

    /* JADX INFO: renamed from: updateAudioRestrictionMode-LwUUkyU, reason: not valid java name */
    void mo425updateAudioRestrictionModeLwUUkyU(int mode);

    <T> Object useSession(Function3<? super CoroutineScope, ? super TSession, ? super Continuation<? super T>, ? extends Object> function3, Continuation<? super T> continuation);

    <T> Deferred<T> useSessionIn(CoroutineScope scope, Function3<? super CoroutineScope, ? super TSession, ? super Continuation<? super T>, ? extends Object> action);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lock3A-vIrNa9k$default, reason: not valid java name */
    static /* synthetic */ Deferred m422lock3AvIrNa9k$default(CameraGraphBase cameraGraphBase, AeMode aeMode, AfMode afMode, AwbMode awbMode, List list, List list2, List list3, Lock3ABehavior lock3ABehavior, Lock3ABehavior lock3ABehavior2, Lock3ABehavior lock3ABehavior3, AeMode aeMode2, Function1 function1, Function1 function2, int i, long j, long j2, int i2, Object obj) {
        if (obj == null) {
            return cameraGraphBase.mo423lock3AvIrNa9k((i2 & 1) != 0 ? null : aeMode, (i2 & 2) != 0 ? null : afMode, (i2 & 4) != 0 ? null : awbMode, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : list2, (i2 & 32) != 0 ? null : list3, (i2 & 64) != 0 ? null : lock3ABehavior, (i2 & 128) != 0 ? null : lock3ABehavior2, (i2 & 256) != 0 ? null : lock3ABehavior3, (i2 & 512) != 0 ? null : aeMode2, (i2 & 1024) != 0 ? null : function1, (i2 & 2048) == 0 ? function2 : null, (i2 & 4096) != 0 ? 60 : i, (i2 & 8192) != 0 ? 3000000000L : j, (i2 & 16384) != 0 ? 3000000000L : j2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock3A-vIrNa9k");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Deferred unlock3A$default(CameraGraphBase cameraGraphBase, Boolean bool, Boolean bool2, Boolean bool3, Function1 function1, int i, long j, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock3A");
        }
        if ((i2 & 1) != 0) {
            bool = null;
        }
        if ((i2 & 2) != 0) {
            bool2 = null;
        }
        if ((i2 & 4) != 0) {
            bool3 = null;
        }
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        if ((i2 & 16) != 0) {
            i = 60;
        }
        if ((i2 & 32) != 0) {
            j = CameraGraph.Constants3A.DEFAULT_TIME_LIMIT_NS;
        }
        return cameraGraphBase.unlock3A(bool, bool2, bool3, function1, i, j);
    }
}
