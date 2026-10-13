package androidx.camera.camera2.pipe.graph;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.AwbMode;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.FlashMode;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.FrameNumber;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.config.CameraGraphScope;
import androidx.camera.camera2.pipe.core.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: Controller3A.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \\2\u00020\u0001:\u0001\\B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rJw\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b¢\u0006\u0002\b\u001fJk\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b¢\u0006\u0002\b!JÎ\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0018\u00010)2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0018\u00010)2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u000100H\u0086@¢\u0006\u0004\b2\u00103Jc\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u00105\u001a\u0004\u0018\u00010+2\n\b\u0002\u00106\u001a\u0004\u0018\u00010+2\n\b\u0002\u00107\u001a\u0004\u0018\u00010+2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0018\u00010)2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u00109\u001a\u0004\u0018\u000100¢\u0006\u0002\u0010:J8\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0018\u00010)2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u00109\u001a\u000200J4\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010<\u001a\u00020+2\b\b\u0002\u0010=\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u00109\u001a\u000200JV\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u001a\b\u0002\u0010>\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030@\u0012\u0004\u0012\u00020\u0001\u0018\u00010?2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0018\u00010)2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u00109\u001a\u000200H\u0002J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010B\u001a\u00020+J\u0018\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010B\u001a\u00020+H\u0002J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\bFJi\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00132\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0018\u00010)2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u00109\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\bH\u0010IJ6\u0010J\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030K\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b0?2\u0006\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020+2\u0006\u0010N\u001a\u00020+H\u0002J6\u0010O\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030K\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b0?2\u0006\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020+H\u0002J$\u0010S\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0006\u0010T\u001a\u00020+2\u0006\u0010=\u001a\u00020+H\u0002J6\u0010U\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030K\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b0?2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020+H\u0002J=\u0010V\u001a\u00020W2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\bXJ\u000e\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Landroidx/camera/camera2/pipe/graph/Controller3A;", "", "graphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "metadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "graphState3A", "Landroidx/camera/camera2/pipe/graph/GraphState3A;", "graphListener3A", "Landroidx/camera/camera2/pipe/graph/Listener3A;", "<init>", "(Landroidx/camera/camera2/pipe/graph/GraphProcessor;Landroidx/camera/camera2/pipe/CameraMetadata;Landroidx/camera/camera2/pipe/graph/GraphState3A;Landroidx/camera/camera2/pipe/graph/Listener3A;)V", "state3ASnapshot", "Landroidx/camera/camera2/pipe/graph/State3A;", "lastUpdate3AResult", "Lkotlinx/coroutines/Deferred;", "Landroidx/camera/camera2/pipe/Result3A;", "update3A", "aeMode", "Landroidx/camera/camera2/pipe/AeMode;", "afMode", "Landroidx/camera/camera2/pipe/AfMode;", "awbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "flashMode", "Landroidx/camera/camera2/pipe/FlashMode;", "aeRegions", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "afRegions", "awbRegions", "update3A-169HPGg", "submit3A", "submit3A-ydBZfZg", "lock3A", "aeLockBehavior", "Landroidx/camera/camera2/pipe/Lock3ABehavior;", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "convergedCondition", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "", "lockedCondition", "frameLimit", "", "convergedTimeLimitNs", "", "lockedTimeLimitNs", "lock3A-Qz1gx5w", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/AeMode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILjava/lang/Long;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unlock3A", "ae", "af", "awb", "unlockedCondition", "timeLimitNs", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;ILjava/lang/Long;)Lkotlinx/coroutines/Deferred;", "lock3AForCapture", "triggerAf", "waitForAwb", "triggerCondition", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "unlock3APostCapture", "cancelAf", "unlock3APostCaptureAndroidMAndAbove", "setTorchOn", "setTorchOff", "setTorchOff-NqN7i0k", "lock3ANow", "lock3ANow-R6AlCjU", "(Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/Lock3ABehavior;Landroidx/camera/camera2/pipe/AeMode;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Ljava/lang/Long;)Lkotlinx/coroutines/Deferred;", "createConverged3AExitConditions", "Landroid/hardware/camera2/CaptureResult$Key;", "waitForAeToConverge", "waitForAfToConverge", "waitForAwbToConverge", "createLocked3AExitConditions", "waitForAeToLock", "waitForAfToLock", "waitForAwbToLock", "createLock3AForCaptureExitConditions", "isAfTriggered", "createUnLocked3AExitConditions", "createListenerFor3AParams", "Landroidx/camera/camera2/pipe/graph/Result3AStateListenerImpl;", "createListenerFor3AParams-0dPwJB0", "reset3A", "", "initialState3A", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Controller3A {
    private static final Map<CaptureRequest.Key<?>, Object> aePrecaptureAndAfCancelParams;
    private static final Map<CaptureRequest.Key<?>, Object> aePrecaptureCancelParams;
    private static final List<Integer> afUnlockedStateList;
    private static final List<Integer> awbUnlockedStateList;
    private static final Function1<FrameMetadata, Boolean> unlock3APostCaptureAfUnlockedCondition;
    private static final Map<? extends CaptureRequest.Key<? extends Object>, Object> unlock3APostCaptureLockAeAndCancelAfParams;
    private static final Map<CaptureRequest.Key<Boolean>, Boolean> unlock3APostCaptureLockAeParams;
    private static final Map<CaptureRequest.Key<?>, Object> unlock3APostCaptureUnlockAeParams;
    private final Listener3A graphListener3A;
    private final GraphProcessor graphProcessor;
    private final GraphState3A graphState3A;
    private Deferred<Result3A> lastUpdate3AResult;
    private final CameraMetadata metadata;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Integer> aeConvergedStateList = CollectionsKt.listOf((Object[]) new Integer[]{2, 4, 3});
    private static final List<Integer> awbConvergedStateList = CollectionsKt.listOf((Object[]) new Integer[]{2, 3});
    private static final List<Integer> afConvergedStateList = CollectionsKt.listOf((Object[]) new Integer[]{2, 6, 4, 5});
    private static final List<Integer> aeLockedStateList = CollectionsKt.listOf(3);
    private static final List<Integer> awbLockedStateList = CollectionsKt.listOf(3);
    private static final List<Integer> afLockedStateList = CollectionsKt.listOf((Object[]) new Integer[]{4, 5});
    private static final List<Integer> aePostPrecaptureStateList = CollectionsKt.listOf((Object[]) new Integer[]{2, 4, 3});
    private static final List<Integer> awbPostPrecaptureStateList = CollectionsKt.listOf((Object[]) new Integer[]{2, 3});
    private static final Map<CaptureRequest.Key<?>, Object> parameterForAfTriggerStart = MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AF_TRIGGER, 1));
    private static final Map<CaptureRequest.Key<?>, Object> parameterForAfTriggerCancel = MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AF_TRIGGER, 2));
    private static final Map<CaptureRequest.Key<?>, Object> parametersForAePrecapture = MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1));
    private static final Map<CaptureRequest.Key<?>, Object> parametersForAePrecaptureAndAfTrigger = MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AF_TRIGGER, 1), TuplesKt.to(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1));
    private static final CompletableDeferred<Result3A> deferredResult3ASubmitFailed = CompletableDeferredKt.CompletableDeferred(new Result3A(Result3A.Status.INSTANCE.m736getSUBMIT_FAILEDJvTi9ms(), null == true ? 1 : 0, 2, null == true ? 1 : 0));
    private static final List<Integer> aeUnlockedStateList = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2, 4});

    @Inject
    public Controller3A(GraphProcessor graphProcessor, CameraMetadata metadata, GraphState3A graphState3A, Listener3A graphListener3A) {
        Intrinsics.checkNotNullParameter(graphProcessor, "graphProcessor");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(graphState3A, "graphState3A");
        Intrinsics.checkNotNullParameter(graphListener3A, "graphListener3A");
        this.graphProcessor = graphProcessor;
        this.metadata = metadata;
        this.graphState3A = graphState3A;
        this.graphListener3A = graphListener3A;
    }

    /* JADX INFO: compiled from: Controller3A.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u001d\u001a!\u0012\u0017\u0012\u0015\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e0\u0010¢\u0006\u0002\b \u0012\u0004\u0012\u00020\u001e0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010!\u001a \u0012\u0016\b\u0001\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u001f*\u0004\u0018\u00010\u00010\u00010\u0010\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001e0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/camera/camera2/pipe/graph/Controller3A$Companion;", "", "<init>", "()V", "aeConvergedStateList", "", "", "awbConvergedStateList", "afConvergedStateList", "aeLockedStateList", "awbLockedStateList", "afLockedStateList", "aePostPrecaptureStateList", "awbPostPrecaptureStateList", "parameterForAfTriggerStart", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "getParameterForAfTriggerStart", "()Ljava/util/Map;", "parameterForAfTriggerCancel", "getParameterForAfTriggerCancel", "parametersForAePrecapture", "parametersForAePrecaptureAndAfTrigger", "deferredResult3ASubmitFailed", "Lkotlinx/coroutines/CompletableDeferred;", "Landroidx/camera/camera2/pipe/Result3A;", "aeUnlockedStateList", "afUnlockedStateList", "awbUnlockedStateList", "unlock3APostCaptureLockAeParams", "", "kotlin.jvm.PlatformType", "Lkotlin/jvm/internal/EnhancedNullability;", "unlock3APostCaptureLockAeAndCancelAfParams", "unlock3APostCaptureUnlockAeParams", "aePrecaptureCancelParams", "aePrecaptureAndAfCancelParams", "unlock3APostCaptureAfUnlockedCondition", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<CaptureRequest.Key<?>, Object> getParameterForAfTriggerStart() {
            return Controller3A.parameterForAfTriggerStart;
        }

        public final Map<CaptureRequest.Key<?>, Object> getParameterForAfTriggerCancel() {
            return Controller3A.parameterForAfTriggerCancel;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{0, 3, 1, 2, 6});
        afUnlockedStateList = listListOf;
        awbUnlockedStateList = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2});
        unlock3APostCaptureLockAeParams = MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AE_LOCK, true));
        unlock3APostCaptureLockAeAndCancelAfParams = MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AF_TRIGGER, 2), TuplesKt.to(CaptureRequest.CONTROL_AE_LOCK, true));
        unlock3APostCaptureUnlockAeParams = MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AE_LOCK, false));
        aePrecaptureCancelParams = MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2));
        aePrecaptureAndAfCancelParams = MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AF_TRIGGER, 2), TuplesKt.to(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2));
        unlock3APostCaptureAfUnlockedCondition = Result3AStateListenerKt.toConditionChecker(MapsKt.mapOf(TuplesKt.to(CaptureResult.CONTROL_AF_STATE, listListOf)));
    }

    public final State3A state3ASnapshot() {
        return this.graphState3A.getCurrent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: update3A-169HPGg$default, reason: not valid java name */
    public static /* synthetic */ Deferred m952update3A169HPGg$default(Controller3A controller3A, AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            aeMode = null;
        }
        if ((i & 2) != 0) {
            afMode = null;
        }
        if ((i & 4) != 0) {
            awbMode = null;
        }
        if ((i & 8) != 0) {
            flashMode = null;
        }
        if ((i & 16) != 0) {
            list = null;
        }
        if ((i & 32) != 0) {
            list2 = null;
        }
        if ((i & 64) != 0) {
            list3 = null;
        }
        return controller3A.m956update3A169HPGg(aeMode, afMode, awbMode, flashMode, list, list2, list3);
    }

    /* JADX INFO: renamed from: update3A-169HPGg, reason: not valid java name */
    public final Deferred<Result3A> m956update3A169HPGg(AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        if (this.graphProcessor.getRepeatingRequest() == null) {
            GraphState3A.m963update7jOEVJU$default(this.graphState3A, aeMode, afMode, awbMode, flashMode, aeRegions, afRegions, awbRegions, null, null, null, 896, null);
            this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
            return deferredResult3ASubmitFailed;
        }
        Result3AStateListenerImpl result3AStateListenerImplM945createListenerFor3AParams0dPwJB0 = m945createListenerFor3AParams0dPwJB0(aeMode, afMode, awbMode, flashMode);
        this.graphListener3A.addListener(result3AStateListenerImplM945createListenerFor3AParams0dPwJB0);
        GraphState3A.m963update7jOEVJU$default(this.graphState3A, aeMode, afMode, awbMode, flashMode, aeRegions, afRegions, awbRegions, null, null, null, 896, null);
        this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
        Deferred<Result3A> result = result3AStateListenerImplM945createListenerFor3AParams0dPwJB0.getResult();
        synchronized (this) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Controller3A#update3A: cancelling previous request " + this.lastUpdate3AResult);
            }
            Deferred<Result3A> deferred = this.lastUpdate3AResult;
            if (deferred != null) {
                JobKt__JobKt.cancel$default(deferred, "A newer call for 3A state update initiated.", null, 2, null);
            }
            this.lastUpdate3AResult = result;
            Unit unit = Unit.INSTANCE;
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: submit3A-ydBZfZg$default, reason: not valid java name */
    public static /* synthetic */ Deferred m951submit3AydBZfZg$default(Controller3A controller3A, AeMode aeMode, AfMode afMode, AwbMode awbMode, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            aeMode = null;
        }
        if ((i & 2) != 0) {
            afMode = null;
        }
        if ((i & 4) != 0) {
            awbMode = null;
        }
        if ((i & 8) != 0) {
            list = null;
        }
        if ((i & 16) != 0) {
            list2 = null;
        }
        if ((i & 32) != 0) {
            list3 = null;
        }
        return controller3A.m955submit3AydBZfZg(aeMode, afMode, awbMode, list, list2, list3);
    }

    /* JADX INFO: renamed from: submit3A-ydBZfZg, reason: not valid java name */
    public final Deferred<Result3A> m955submit3AydBZfZg(AeMode aeMode, AfMode afMode, AwbMode awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        if (this.graphProcessor.getRepeatingRequest() == null) {
            return deferredResult3ASubmitFailed;
        }
        Result3AStateListenerImpl result3AStateListenerImplM946createListenerFor3AParams0dPwJB0$default = m946createListenerFor3AParams0dPwJB0$default(this, aeMode, afMode, awbMode, null, 8, null);
        Result3AStateListenerImpl result3AStateListenerImpl = result3AStateListenerImplM946createListenerFor3AParams0dPwJB0$default;
        this.graphListener3A.addListener(result3AStateListenerImpl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (aeMode != null) {
            int iM160unboximpl = aeMode.m160unboximpl();
            CaptureRequest.Key CONTROL_AE_MODE = CaptureRequest.CONTROL_AE_MODE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_MODE, "CONTROL_AE_MODE");
            linkedHashMap.put(CONTROL_AE_MODE, Integer.valueOf(iM160unboximpl));
        }
        if (afMode != null) {
            int iM179unboximpl = afMode.m179unboximpl();
            CaptureRequest.Key CONTROL_AF_MODE = CaptureRequest.CONTROL_AF_MODE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AF_MODE, "CONTROL_AF_MODE");
            linkedHashMap.put(CONTROL_AF_MODE, Integer.valueOf(iM179unboximpl));
        }
        if (awbMode != null) {
            int iM205unboximpl = awbMode.m205unboximpl();
            CaptureRequest.Key CONTROL_AWB_MODE = CaptureRequest.CONTROL_AWB_MODE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
            linkedHashMap.put(CONTROL_AWB_MODE, Integer.valueOf(iM205unboximpl));
        }
        if (aeRegions != null) {
            CaptureRequest.Key CONTROL_AE_REGIONS = CaptureRequest.CONTROL_AE_REGIONS;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_REGIONS, "CONTROL_AE_REGIONS");
            linkedHashMap.put(CONTROL_AE_REGIONS, aeRegions.toArray(new MeteringRectangle[0]));
        }
        if (afRegions != null) {
            CaptureRequest.Key CONTROL_AF_REGIONS = CaptureRequest.CONTROL_AF_REGIONS;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AF_REGIONS, "CONTROL_AF_REGIONS");
            linkedHashMap.put(CONTROL_AF_REGIONS, afRegions.toArray(new MeteringRectangle[0]));
        }
        if (awbRegions != null) {
            CaptureRequest.Key CONTROL_AWB_REGIONS = CaptureRequest.CONTROL_AWB_REGIONS;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_REGIONS, "CONTROL_AWB_REGIONS");
            linkedHashMap.put(CONTROL_AWB_REGIONS, awbRegions.toArray(new MeteringRectangle[0]));
        }
        if (!this.graphProcessor.trigger(linkedHashMap)) {
            this.graphListener3A.removeListener(result3AStateListenerImpl);
            return deferredResult3ASubmitFailed;
        }
        return result3AStateListenerImplM946createListenerFor3AParams0dPwJB0$default.getResult();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lock3A-Qz1gx5w, reason: not valid java name */
    public final Object m953lock3AQz1gx5w(List<MeteringRectangle> list, List<MeteringRectangle> list2, List<MeteringRectangle> list3, Lock3ABehavior lock3ABehavior, Lock3ABehavior lock3ABehavior2, Lock3ABehavior lock3ABehavior3, AeMode aeMode, Function1<? super FrameMetadata, Boolean> function1, Function1<? super FrameMetadata, Boolean> function2, int i, Long l, Long l2, Continuation<? super Deferred<Result3A>> continuation) {
        Controller3A$lock3A$1 controller3A$lock3A$1;
        Ref.ObjectRef objectRef;
        int i2;
        Ref.ObjectRef objectRef2;
        Function1<? super FrameMetadata, Boolean> function3;
        Long l3;
        Lock3ABehavior lock3ABehavior4;
        Result3AStateListenerImpl result3AStateListenerImpl;
        AeMode aeMode2;
        Lock3ABehavior lock3ABehavior5 = lock3ABehavior3;
        if (continuation instanceof Controller3A$lock3A$1) {
            controller3A$lock3A$1 = (Controller3A$lock3A$1) continuation;
            if ((controller3A$lock3A$1.label & Integer.MIN_VALUE) != 0) {
                controller3A$lock3A$1.label -= Integer.MIN_VALUE;
            } else {
                controller3A$lock3A$1 = new Controller3A$lock3A$1(this, continuation);
            }
        } else {
            controller3A$lock3A$1 = new Controller3A$lock3A$1(this, continuation);
        }
        Object obj = controller3A$lock3A$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = controller3A$lock3A$1.label;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            objectRef = new Ref.ObjectRef();
            objectRef.element = lock3ABehavior2;
            if (!CameraMetadata.INSTANCE.getSupportsAutoFocusTrigger(this.metadata)) {
                objectRef.element = null;
            }
            if (lock3ABehavior == null && objectRef.element == 0 && lock3ABehavior5 == null) {
                return CompletableDeferredKt.CompletableDeferred(new Result3A(Result3A.Status.INSTANCE.m734getOKJvTi9ms(), objArr2 == true ? 1 : 0, objArr == true ? 1 : 0));
            }
            GraphState3A.m963update7jOEVJU$default(this.graphState3A, null, null, null, null, list, list2, list3, null, null, null, 911, null);
            this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
            if (this.graphProcessor.getRepeatingRequest() == null) {
                return deferredResult3ASubmitFailed;
            }
            if (Controller3AKt.m958shouldUnlockAft6FjEyI((Lock3ABehavior) objectRef.element)) {
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "lock3A - sending a request to unlock af first.");
                }
                if (!this.graphProcessor.trigger(parameterForAfTriggerCancel)) {
                    return deferredResult3ASubmitFailed;
                }
            }
            if (Controller3AKt.m960shouldWaitForAeToConverget6FjEyI(lock3ABehavior) || Controller3AKt.m961shouldWaitForAfToConverget6FjEyI((Lock3ABehavior) objectRef.element) || Controller3AKt.m962shouldWaitForAwbToConverget6FjEyI(lock3ABehavior5)) {
                Result3AStateListenerImpl result3AStateListenerImpl2 = new Result3AStateListenerImpl(function1 == null ? Result3AStateListenerKt.toConditionChecker(createConverged3AExitConditions(Controller3AKt.m960shouldWaitForAeToConverget6FjEyI(lock3ABehavior), Controller3AKt.m961shouldWaitForAfToConverget6FjEyI((Lock3ABehavior) objectRef.element), Controller3AKt.m962shouldWaitForAwbToConverget6FjEyI(lock3ABehavior5))) : function1, Boxing.boxInt(i), l);
                this.graphListener3A.addListener(result3AStateListenerImpl2);
                Boolean boolBoxBoolean = Controller3AKt.m957shouldUnlockAet6FjEyI(lock3ABehavior) ? Boxing.boxBoolean(false) : null;
                Boolean boolBoxBoolean2 = Controller3AKt.m959shouldUnlockAwbt6FjEyI(lock3ABehavior5) ? Boxing.boxBoolean(false) : null;
                if (boolBoxBoolean != null || boolBoxBoolean2 != null) {
                    if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                        android.util.Log.d(Log.TAG, "lock3A - setting aeLock=" + boolBoxBoolean + ", awbLock=" + boolBoxBoolean2);
                    }
                    GraphState3A.m963update7jOEVJU$default(this.graphState3A, null, null, null, null, null, null, null, boolBoxBoolean, null, boolBoxBoolean2, 383, null);
                }
                this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    StringBuilder sb = new StringBuilder("lock3A - waiting for");
                    sb.append(Controller3AKt.m960shouldWaitForAeToConverget6FjEyI(lock3ABehavior) ? " ae" : "");
                    sb.append(Controller3AKt.m961shouldWaitForAfToConverget6FjEyI((Lock3ABehavior) objectRef.element) ? " af" : "");
                    sb.append(Controller3AKt.m962shouldWaitForAwbToConverget6FjEyI(lock3ABehavior5) ? " awb" : "");
                    sb.append(" to converge before locking them.");
                    android.util.Log.d(Log.TAG, sb.toString());
                }
                Deferred<Result3A> result = result3AStateListenerImpl2.getResult();
                controller3A$lock3A$1.L$0 = lock3ABehavior;
                controller3A$lock3A$1.L$1 = lock3ABehavior5;
                controller3A$lock3A$1.L$2 = aeMode;
                controller3A$lock3A$1.L$3 = function2;
                controller3A$lock3A$1.L$4 = l2;
                controller3A$lock3A$1.L$5 = objectRef;
                controller3A$lock3A$1.L$6 = result3AStateListenerImpl2;
                i2 = i;
                controller3A$lock3A$1.I$0 = i2;
                controller3A$lock3A$1.label = 1;
                Object objAwait = result.await(controller3A$lock3A$1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef2 = objectRef;
                obj = objAwait;
                function3 = function2;
                l3 = l2;
                lock3ABehavior4 = lock3ABehavior;
                result3AStateListenerImpl = result3AStateListenerImpl2;
                aeMode2 = aeMode;
            } else {
                aeMode2 = aeMode;
                function3 = function2;
                i2 = i;
                l3 = l2;
                lock3ABehavior4 = lock3ABehavior;
            }
            return m948lock3ANowR6AlCjU(lock3ABehavior4, (Lock3ABehavior) objectRef.element, lock3ABehavior5, aeMode2, function3, Boxing.boxInt(i2), l3);
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i4 = controller3A$lock3A$1.I$0;
        Result3AStateListenerImpl result3AStateListenerImpl3 = (Result3AStateListenerImpl) controller3A$lock3A$1.L$6;
        objectRef2 = (Ref.ObjectRef) controller3A$lock3A$1.L$5;
        l3 = (Long) controller3A$lock3A$1.L$4;
        function3 = (Function1) controller3A$lock3A$1.L$3;
        aeMode2 = (AeMode) controller3A$lock3A$1.L$2;
        Lock3ABehavior lock3ABehavior6 = (Lock3ABehavior) controller3A$lock3A$1.L$1;
        lock3ABehavior4 = (Lock3ABehavior) controller3A$lock3A$1.L$0;
        ResultKt.throwOnFailure(obj);
        i2 = i4;
        result3AStateListenerImpl = result3AStateListenerImpl3;
        lock3ABehavior5 = lock3ABehavior6;
        Result3A result3A = (Result3A) obj;
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            StringBuilder sb2 = new StringBuilder("lock3A - converged at frame number=");
            FrameMetadata frameMetadata = result3A.getFrameMetadata();
            sb2.append(frameMetadata != null ? Boxing.boxLong(frameMetadata.mo530getFrameNumberUgla2oM()) : null);
            sb2.append(", status=");
            sb2.append((Object) Result3A.Status.m731toStringimpl(result3A.m725getStatusJvTi9ms()));
            android.util.Log.d(Log.TAG, sb2.toString());
        }
        if (!Result3A.Status.m729equalsimpl0(result3A.m725getStatusJvTi9ms(), Result3A.Status.INSTANCE.m734getOKJvTi9ms())) {
            return result3AStateListenerImpl.getResult();
        }
        objectRef = objectRef2;
        return m948lock3ANowR6AlCjU(lock3ABehavior4, (Lock3ABehavior) objectRef.element, lock3ABehavior5, aeMode2, function3, Boxing.boxInt(i2), l3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Deferred unlock3A$default(Controller3A controller3A, Boolean bool, Boolean bool2, Boolean bool3, Function1 function1, int i, Long l, int i2, Object obj) {
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
            l = Long.valueOf(CameraGraph.Constants3A.DEFAULT_TIME_LIMIT_NS);
        }
        return controller3A.unlock3A(bool, bool2, bool3, function1, i, l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Deferred<Result3A> unlock3A(Boolean ae, Boolean af, Boolean awb, Function1<? super FrameMetadata, Boolean> unlockedCondition, int frameLimit, Long timeLimitNs) {
        Boolean bool = !CameraMetadata.INSTANCE.getSupportsAutoFocusTrigger(this.metadata) ? null : af;
        if (!Intrinsics.areEqual((Object) ae, (Object) true) && !Intrinsics.areEqual((Object) bool, (Object) true) && !Intrinsics.areEqual((Object) awb, (Object) true)) {
            return CompletableDeferredKt.CompletableDeferred(new Result3A(Result3A.Status.INSTANCE.m734getOKJvTi9ms(), null == true ? 1 : 0, null == true ? 1 : 0));
        }
        if (this.graphProcessor.getRepeatingRequest() == null) {
            return deferredResult3ASubmitFailed;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "unlock3A - sending a request to unlock af first.");
            }
            if (this.graphProcessor.trigger(parameterForAfTriggerCancel)) {
                GraphState3A.m963update7jOEVJU$default(this.graphState3A, null, null, null, null, null, null, null, null, false, null, 767, null);
            } else {
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "unlock3A - failed to send a request to unlock af first.");
                }
                return deferredResult3ASubmitFailed;
            }
        }
        Result3AStateListenerImpl result3AStateListenerImpl = new Result3AStateListenerImpl(unlockedCondition == null ? Result3AStateListenerKt.toConditionChecker(createUnLocked3AExitConditions(Intrinsics.areEqual((Object) ae, (Object) true), Intrinsics.areEqual((Object) bool, (Object) true), Intrinsics.areEqual((Object) awb, (Object) true))) : unlockedCondition, Integer.valueOf(frameLimit), timeLimitNs);
        this.graphListener3A.addListener(result3AStateListenerImpl);
        Boolean bool2 = Intrinsics.areEqual((Object) ae, (Object) true) ? false : null;
        Boolean bool3 = Intrinsics.areEqual((Object) awb, (Object) true) ? false : null;
        if (bool2 != null || bool3 != null) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "unlock3A - updating graph state, aeLock=" + bool2 + ", awbLock=" + bool3);
            }
            GraphState3A.m963update7jOEVJU$default(this.graphState3A, null, null, null, null, null, null, null, bool2, null, bool3, 383, null);
        }
        this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
        return result3AStateListenerImpl.getResult();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Deferred lock3AForCapture$default(Controller3A controller3A, Function1 function1, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = null;
        }
        if ((i2 & 2) != 0) {
            i = 60;
        }
        if ((i2 & 4) != 0) {
            j = CameraGraph.Constants3A.DEFAULT_TIME_LIMIT_NS;
        }
        return controller3A.lock3AForCapture(function1, i, j);
    }

    public final Deferred<Result3A> lock3AForCapture(Function1<? super FrameMetadata, Boolean> lockedCondition, int frameLimit, long timeLimitNs) {
        return lock3AForCapture((Map<CaptureRequest.Key<?>, ? extends Object>) null, lockedCondition, frameLimit, timeLimitNs);
    }

    public static /* synthetic */ Deferred lock3AForCapture$default(Controller3A controller3A, boolean z, boolean z2, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            i = 60;
        }
        if ((i2 & 8) != 0) {
            j = CameraGraph.Constants3A.DEFAULT_TIME_LIMIT_NS;
        }
        int i3 = i;
        return controller3A.lock3AForCapture(z, z2, i3, j);
    }

    public final Deferred<Result3A> lock3AForCapture(boolean triggerAf, boolean waitForAwb, int frameLimit, long timeLimitNs) {
        Map<CaptureRequest.Key<?>, ? extends Object> map;
        if (triggerAf) {
            map = parametersForAePrecaptureAndAfTrigger;
        } else {
            map = parametersForAePrecapture;
        }
        return lock3AForCapture(map, createLock3AForCaptureExitConditions(triggerAf, waitForAwb), frameLimit, timeLimitNs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Deferred lock3AForCapture$default(Controller3A controller3A, Map map, Function1 function1, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = null;
        }
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        if ((i2 & 4) != 0) {
            i = 60;
        }
        if ((i2 & 8) != 0) {
            j = CameraGraph.Constants3A.DEFAULT_TIME_LIMIT_NS;
        }
        return controller3A.lock3AForCapture((Map<CaptureRequest.Key<?>, ? extends Object>) map, (Function1<? super FrameMetadata, Boolean>) function1, i, j);
    }

    private final Deferred<Result3A> lock3AForCapture(Map<CaptureRequest.Key<?>, ? extends Object> triggerCondition, Function1<? super FrameMetadata, Boolean> lockedCondition, int frameLimit, long timeLimitNs) {
        if (this.graphProcessor.getRepeatingRequest() == null) {
            return deferredResult3ASubmitFailed;
        }
        if (triggerCondition == null) {
            triggerCondition = parametersForAePrecaptureAndAfTrigger;
        }
        Iterator<Map.Entry<CaptureRequest.Key<?>, ? extends Object>> it = triggerCondition.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getValue(), (Object) 1)) {
                z = true;
            }
        }
        if (lockedCondition == null) {
            lockedCondition = createLock3AForCaptureExitConditions(z, false);
        }
        Result3AStateListenerImpl result3AStateListenerImpl = new Result3AStateListenerImpl(lockedCondition, Integer.valueOf(frameLimit), Long.valueOf(timeLimitNs));
        Result3AStateListenerImpl result3AStateListenerImpl2 = result3AStateListenerImpl;
        this.graphListener3A.addListener(result3AStateListenerImpl2);
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "lock3AForCapture - sending a request to trigger ae precapture metering and af.");
        }
        if (!this.graphProcessor.trigger(triggerCondition)) {
            this.graphListener3A.removeListener(result3AStateListenerImpl2);
            return deferredResult3ASubmitFailed;
        }
        this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
        return result3AStateListenerImpl.getResult();
    }

    public static /* synthetic */ Deferred unlock3APostCapture$default(Controller3A controller3A, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return controller3A.unlock3APostCapture(z);
    }

    public final Deferred<Result3A> unlock3APostCapture(boolean cancelAf) {
        if (this.graphProcessor.getRepeatingRequest() == null) {
            return deferredResult3ASubmitFailed;
        }
        return unlock3APostCaptureAndroidMAndAbove(cancelAf);
    }

    static /* synthetic */ Deferred unlock3APostCaptureAndroidMAndAbove$default(Controller3A controller3A, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return controller3A.unlock3APostCaptureAndroidMAndAbove(z);
    }

    private final Deferred<Result3A> unlock3APostCaptureAndroidMAndAbove(boolean cancelAf) {
        Result3AStateListenerImpl result3AStateListenerImpl;
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "unlock3APostCapture - sending a request to reset af and ae precapture metering.");
        }
        if (!this.graphProcessor.trigger(cancelAf ? aePrecaptureAndAfCancelParams : aePrecaptureCancelParams)) {
            return deferredResult3ASubmitFailed;
        }
        if (cancelAf) {
            result3AStateListenerImpl = new Result3AStateListenerImpl(unlock3APostCaptureAfUnlockedCondition, (Integer) null, (Long) null, 6, (DefaultConstructorMarker) null);
        } else {
            result3AStateListenerImpl = new Result3AStateListenerImpl(MapsKt.emptyMap(), (Integer) null, (Long) null, 6, (DefaultConstructorMarker) null);
        }
        this.graphListener3A.addListener(result3AStateListenerImpl);
        this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
        return result3AStateListenerImpl.getResult();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    public final Deferred<Result3A> setTorchOn() {
        AeMode aeModeM151boximpl;
        AeMode aeModeM981getAeModeO_cDUUs = this.graphState3A.getCurrent().m981getAeModeO_cDUUs();
        if (aeModeM981getAeModeO_cDUUs == null ? false : AeMode.m154equalsimpl0(aeModeM981getAeModeO_cDUUs.m160unboximpl(), AeMode.INSTANCE.m164getONbOjpiJc())) {
            aeModeM151boximpl = null;
        } else {
            if (aeModeM981getAeModeO_cDUUs != null ? AeMode.m154equalsimpl0(aeModeM981getAeModeO_cDUUs.m160unboximpl(), AeMode.INSTANCE.m163getOFFbOjpiJc()) : false) {
                aeModeM151boximpl = null;
            } else {
                aeModeM151boximpl = AeMode.m151boximpl(AeMode.INSTANCE.m164getONbOjpiJc());
            }
        }
        return m952update3A169HPGg$default(this, aeModeM151boximpl, null, null, FlashMode.m479boximpl(FlashMode.INSTANCE.m490getTORCHLe5xUZU()), null, null, null, 118, null);
    }

    /* JADX INFO: renamed from: setTorchOff-NqN7i0k$default, reason: not valid java name */
    public static /* synthetic */ Deferred m950setTorchOffNqN7i0k$default(Controller3A controller3A, AeMode aeMode, int i, Object obj) {
        if ((i & 1) != 0) {
            aeMode = null;
        }
        return controller3A.m954setTorchOffNqN7i0k(aeMode);
    }

    /* JADX INFO: renamed from: setTorchOff-NqN7i0k, reason: not valid java name */
    public final Deferred<Result3A> m954setTorchOffNqN7i0k(AeMode aeMode) {
        return m952update3A169HPGg$default(this, aeMode, null, null, FlashMode.m479boximpl(FlashMode.INSTANCE.m488getOFFLe5xUZU()), null, null, null, 118, null);
    }

    /* JADX INFO: renamed from: lock3ANow-R6AlCjU$default, reason: not valid java name */
    static /* synthetic */ Deferred m949lock3ANowR6AlCjU$default(Controller3A controller3A, Lock3ABehavior lock3ABehavior, Lock3ABehavior lock3ABehavior2, Lock3ABehavior lock3ABehavior3, AeMode aeMode, Function1 function1, Integer num, Long l, int i, Object obj) {
        if ((i & 8) != 0) {
            aeMode = null;
        }
        return controller3A.m948lock3ANowR6AlCjU(lock3ABehavior, lock3ABehavior2, lock3ABehavior3, aeMode, function1, num, l);
    }

    /* JADX INFO: renamed from: lock3ANow-R6AlCjU, reason: not valid java name */
    private final Deferred<Result3A> m948lock3ANowR6AlCjU(Lock3ABehavior aeLockBehavior, Lock3ABehavior afLockBehavior, Lock3ABehavior awbLockBehavior, AeMode afTriggerStartAeMode, Function1<? super FrameMetadata, Boolean> lockedCondition, Integer frameLimit, Long timeLimitNs) {
        Deferred<Result3A> result;
        AeMode aeMode = null;
        Boolean bool = aeLockBehavior == null ? null : true;
        Boolean bool2 = awbLockBehavior == null ? null : true;
        Map<CaptureResult.Key<?>, List<Object>> mapCreateLocked3AExitConditions = createLocked3AExitConditions(bool != null, afLockBehavior != null, bool2 != null);
        if (lockedCondition == null && mapCreateLocked3AExitConditions.isEmpty()) {
            result = null;
        } else {
            Result3AStateListenerImpl result3AStateListenerImpl = new Result3AStateListenerImpl(lockedCondition == null ? Result3AStateListenerKt.toConditionChecker(mapCreateLocked3AExitConditions) : lockedCondition, frameLimit, timeLimitNs);
            this.graphListener3A.addListener(result3AStateListenerImpl);
            GraphState3A.m963update7jOEVJU$default(this.graphState3A, null, null, null, null, null, null, null, bool, null, bool2, 383, null);
            Boolean bool3 = bool;
            Boolean bool4 = bool2;
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "lock3A - submitting request with aeLock=" + bool3 + " , awbLock=" + bool4);
            }
            this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
            result = result3AStateListenerImpl.getResult();
        }
        if (afLockBehavior == null) {
            Intrinsics.checkNotNull(result);
            return result;
        }
        if (afTriggerStartAeMode != null) {
            int iM160unboximpl = afTriggerStartAeMode.m160unboximpl();
            AeMode aeModeM981getAeModeO_cDUUs = this.graphState3A.getCurrent().m981getAeModeO_cDUUs();
            GraphState3A.m963update7jOEVJU$default(this.graphState3A, AeMode.m151boximpl(iM160unboximpl), null, null, null, null, null, null, null, null, null, 1022, null);
            this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
            aeMode = aeModeM981getAeModeO_cDUUs;
        }
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "lock3A - submitting a request to lock af.");
        }
        if (this.graphProcessor.trigger(parameterForAfTriggerStart)) {
            GraphState3A.m963update7jOEVJU$default(this.graphState3A, null, null, null, null, null, null, null, null, true, null, 767, null);
            if (aeMode != null) {
                GraphState3A.m963update7jOEVJU$default(this.graphState3A, AeMode.m151boximpl(aeMode.m160unboximpl()), null, null, null, null, null, null, null, null, null, 1022, null);
                this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
            }
            Intrinsics.checkNotNull(result);
            return result;
        }
        return deferredResult3ASubmitFailed;
    }

    private final Map<CaptureResult.Key<?>, List<Object>> createConverged3AExitConditions(boolean waitForAeToConverge, boolean waitForAfToConverge, boolean waitForAwbToConverge) {
        if (!waitForAeToConverge && !waitForAfToConverge && !waitForAwbToConverge) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (waitForAeToConverge) {
            linkedHashMap.put(CaptureResult.CONTROL_AE_STATE, aeConvergedStateList);
        }
        if (waitForAwbToConverge) {
            linkedHashMap.put(CaptureResult.CONTROL_AWB_STATE, awbConvergedStateList);
        }
        if (waitForAfToConverge) {
            linkedHashMap.put(CaptureResult.CONTROL_AF_STATE, afConvergedStateList);
        }
        return linkedHashMap;
    }

    private final Map<CaptureResult.Key<?>, List<Object>> createLocked3AExitConditions(boolean waitForAeToLock, boolean waitForAfToLock, boolean waitForAwbToLock) {
        if (!waitForAeToLock && !waitForAfToLock && !waitForAwbToLock) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (waitForAeToLock) {
            linkedHashMap.put(CaptureResult.CONTROL_AE_STATE, aeLockedStateList);
        }
        if (waitForAfToLock) {
            linkedHashMap.put(CaptureResult.CONTROL_AF_STATE, afLockedStateList);
        }
        if (waitForAwbToLock) {
            linkedHashMap.put(CaptureResult.CONTROL_AWB_STATE, awbLockedStateList);
        }
        return linkedHashMap;
    }

    private final Function1<FrameMetadata, Boolean> createLock3AForCaptureExitConditions(final boolean isAfTriggered, final boolean waitForAwb) {
        return new Function1() { // from class: androidx.camera.camera2.pipe.graph.Controller3A$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(Controller3A.createLock3AForCaptureExitConditions$lambda$0(waitForAwb, isAfTriggered, (FrameMetadata) obj));
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008d  */
    /* JADX WARN: Code duplicated, block: B:6:0x0026  */
    static final boolean createLock3AForCaptureExitConditions$lambda$0(boolean z, boolean z2, FrameMetadata frameMetadata) {
        boolean zContains;
        boolean z3;
        boolean zIsNullOrIn;
        Intrinsics.checkNotNullParameter(frameMetadata, "frameMetadata");
        CaptureResult.Key CONTROL_AF_MODE = CaptureResult.CONTROL_AF_MODE;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AF_MODE, "CONTROL_AF_MODE");
        Integer num = (Integer) frameMetadata.get(CONTROL_AF_MODE);
        if (num != null) {
            int iM171constructorimpl = AfMode.m171constructorimpl(num.intValue());
            if (!AfMode.m177isOnimpl(iM171constructorimpl)) {
                zContains = true;
            } else if (z2) {
                CaptureResult.Key CONTROL_AF_STATE = CaptureResult.CONTROL_AF_STATE;
                Intrinsics.checkNotNullExpressionValue(CONTROL_AF_STATE, "CONTROL_AF_STATE");
                zContains = Controller3AKt.isNullOrIn(frameMetadata.get(CONTROL_AF_STATE), afLockedStateList);
            } else if (AfMode.m176isContinuousimpl(iM171constructorimpl)) {
                List<Integer> list = afConvergedStateList;
                CaptureResult.Key CONTROL_AF_STATE2 = CaptureResult.CONTROL_AF_STATE;
                Intrinsics.checkNotNullExpressionValue(CONTROL_AF_STATE2, "CONTROL_AF_STATE");
                zContains = CollectionsKt.contains(list, frameMetadata.get(CONTROL_AF_STATE2));
            } else {
                zContains = true;
            }
        } else {
            zContains = false;
        }
        CaptureResult.Key CONTROL_AE_MODE = CaptureResult.CONTROL_AE_MODE;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AE_MODE, "CONTROL_AE_MODE");
        Integer num2 = (Integer) frameMetadata.get(CONTROL_AE_MODE);
        if (num2 == null) {
            z3 = false;
        } else {
            if (AeMode.m158isOnimpl(AeMode.m152constructorimpl(num2.intValue()))) {
                CaptureResult.Key CONTROL_AE_STATE = CaptureResult.CONTROL_AE_STATE;
                Intrinsics.checkNotNullExpressionValue(CONTROL_AE_STATE, "CONTROL_AE_STATE");
                if (!Controller3AKt.isNullOrIn(frameMetadata.get(CONTROL_AE_STATE), aePostPrecaptureStateList)) {
                    z3 = false;
                }
            }
            z3 = true;
        }
        CaptureResult.Key CONTROL_AWB_MODE = CaptureResult.CONTROL_AWB_MODE;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
        Integer num3 = (Integer) frameMetadata.get(CONTROL_AWB_MODE);
        int iM198constructorimpl = AwbMode.m198constructorimpl(num3 != null ? num3.intValue() : 0);
        if (z && num3 == null) {
            zIsNullOrIn = false;
        } else if (z && AwbMode.m203isOnimpl(iM198constructorimpl)) {
            CaptureResult.Key CONTROL_AWB_STATE = CaptureResult.CONTROL_AWB_STATE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_STATE, "CONTROL_AWB_STATE");
            zIsNullOrIn = Controller3AKt.isNullOrIn(frameMetadata.get(CONTROL_AWB_STATE), awbPostPrecaptureStateList);
        } else {
            zIsNullOrIn = true;
        }
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "lock3AForCapture state " + ((Object) FrameNumber.m536toStringimpl(frameMetadata.mo530getFrameNumberUgla2oM())) + ": meetsAeCondition = " + z3 + ", meetsAfCondition = " + zContains + ", meetsAwbCondition = " + zIsNullOrIn);
        }
        return z3 && zContains && zIsNullOrIn;
    }

    private final Map<CaptureResult.Key<?>, List<Object>> createUnLocked3AExitConditions(boolean ae, boolean af, boolean awb) {
        if (!ae && !af && !awb) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (ae) {
            linkedHashMap.put(CaptureResult.CONTROL_AE_STATE, aeUnlockedStateList);
        }
        if (af) {
            linkedHashMap.put(CaptureResult.CONTROL_AF_STATE, afUnlockedStateList);
        }
        if (awb) {
            linkedHashMap.put(CaptureResult.CONTROL_AWB_STATE, awbUnlockedStateList);
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: createListenerFor3AParams-0dPwJB0$default, reason: not valid java name */
    static /* synthetic */ Result3AStateListenerImpl m946createListenerFor3AParams0dPwJB0$default(Controller3A controller3A, AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode, int i, Object obj) {
        if ((i & 1) != 0) {
            aeMode = null;
        }
        if ((i & 2) != 0) {
            afMode = null;
        }
        if ((i & 4) != 0) {
            awbMode = null;
        }
        if ((i & 8) != 0) {
            flashMode = null;
        }
        return controller3A.m945createListenerFor3AParams0dPwJB0(aeMode, afMode, awbMode, flashMode);
    }

    /* JADX INFO: renamed from: createListenerFor3AParams-0dPwJB0, reason: not valid java name */
    private final Result3AStateListenerImpl m945createListenerFor3AParams0dPwJB0(AeMode aeMode, AfMode afMode, AwbMode awbMode, FlashMode flashMode) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (aeMode != null) {
            int iM160unboximpl = aeMode.m160unboximpl();
            CaptureResult.Key CONTROL_AE_MODE = CaptureResult.CONTROL_AE_MODE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_MODE, "CONTROL_AE_MODE");
        }
        if (afMode != null) {
            int iM179unboximpl = afMode.m179unboximpl();
            CaptureResult.Key CONTROL_AF_MODE = CaptureResult.CONTROL_AF_MODE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AF_MODE, "CONTROL_AF_MODE");
        }
        if (awbMode != null) {
            int iM205unboximpl = awbMode.m205unboximpl();
            CaptureResult.Key CONTROL_AWB_MODE = CaptureResult.CONTROL_AWB_MODE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
        }
        if (flashMode != null) {
            int iM486unboximpl = flashMode.m486unboximpl();
            CaptureResult.Key FLASH_MODE = CaptureResult.FLASH_MODE;
            Intrinsics.checkNotNullExpressionValue(FLASH_MODE, "FLASH_MODE");
        }
        return new Result3AStateListenerImpl(MapsKt.toMap(linkedHashMap), (Integer) null, (Long) null, 6, (DefaultConstructorMarker) null);
    }

    public final void reset3A(State3A initialState3A) {
        Controller3A controller3A;
        Intrinsics.checkNotNullParameter(initialState3A, "initialState3A");
        State3A state3AState3ASnapshot = state3ASnapshot();
        if (Intrinsics.areEqual(state3AState3ASnapshot, initialState3A)) {
            return;
        }
        this.graphState3A.setCurrent(initialState3A);
        this.graphProcessor.update3AParameters(this.graphState3A.toCaptureRequestParametersMap());
        if (GraphState3AKt.wasAfLocked(initialState3A, state3AState3ASnapshot)) {
            controller3A = this;
            unlock3A$default(controller3A, null, true, null, null, 0, null, 61, null);
        } else {
            controller3A = this;
        }
        if (GraphState3AKt.wasAfUnlocked(initialState3A, state3AState3ASnapshot)) {
            controller3A.graphProcessor.trigger(parameterForAfTriggerStart);
        }
    }
}
