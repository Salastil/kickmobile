package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.view.Surface;
import androidx.camera.camera2.adapter.CaptureConfigAdapter;
import androidx.camera.camera2.adapter.CaptureResultAdapter;
import androidx.camera.camera2.compat.workaround.FlashAvailabilityCheckerKt;
import androidx.camera.camera2.compat.workaround.UseTorchAsFlash;
import androidx.camera.camera2.config.UseCaseCameraScope;
import androidx.camera.camera2.config.UseCaseGraphContext;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.RequestNumber;
import androidx.camera.camera2.pipe.RequestTemplate;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConvergenceUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.media3.muxer.WebmConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.cast.MediaError;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: CapturePipeline.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ß\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001i\b\u0007\u0018\u00002\u00020\u0001:\u0002vwB_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010,\u001a\u0004\u0018\u00010+H\u0082@¢\u0006\u0002\u0010-JL\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/2\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020%2\b\u00107\u001a\u0004\u0018\u000108H\u0082@¢\u0006\u0002\u00109JT\u0010:\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0/2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u00104\u001a\u00020%2\u0006\u00106\u001a\u00020%2\u0006\u00105\u001a\u00020%H\u0096@¢\u0006\u0004\bA\u0010BJ&\u0010C\u001a\u00020D2\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020%H\u0096@¢\u0006\u0002\u0010EJp\u0010F\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/*\b\u0012\u0004\u0012\u0002030/2\b\u00107\u001a\u0004\u0018\u0001082\u001e\b\u0004\u0010G\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I\u0012\u0006\u0012\u0004\u0018\u00010K0H2\u001e\b\u0004\u0010L\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I\u0012\u0006\u0012\u0004\u0018\u00010K0HH\u0082H¢\u0006\u0002\u0010MJD\u0010N\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010OJD\u0010P\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010OJ<\u0010Q\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010RJL\u0010S\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\u0006\u0010T\u001a\u00020U2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/2\u0006\u0010V\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010WJD\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010T\u001a\u00020U2\u0006\u00104\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010YJ<\u0010Z\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00104\u001a\u00020%2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030/H\u0082@¢\u0006\u0002\u0010RJ\u0016\u0010[\u001a\u00020J2\u0006\u00104\u001a\u00020%H\u0087@¢\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020J2\u0006\u00104\u001a\u00020%H\u0087@¢\u0006\u0002\u0010\\J\u001e\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020U2\u0006\u0010a\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010bJ+\u0010c\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001a0H2\u0006\u0010a\u001a\u00020\u001aH\u0002J\f\u0010f\u001a\u00020g*\u00020+H\u0002J\u0016\u0010k\u001a\u00020_2\u0006\u0010T\u001a\u00020UH\u0082@¢\u0006\u0002\u0010lJ\u001e\u0010m\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000/2\u0006\u0010n\u001a\u000208H\u0002J\u0016\u0010o\u001a\u00020\u001a2\u0006\u00105\u001a\u00020%H\u0082@¢\u0006\u0002\u0010\\J=\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020U2#\b\u0002\u0010s\u001a\u001d\u0012\u0013\u0012\u00110q¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(t\u0012\u0004\u0012\u00020\u001a0HH\u0082@¢\u0006\u0002\u0010uJ\u0016\u0010a\u001a\u00020\u001a2\u0006\u00106\u001a\u00020%H\u0082@¢\u0006\u0002\u0010\\R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001f\u001a\n  *\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0004\n\u0002\u0010j¨\u0006x"}, d2 = {"Landroidx/camera/camera2/impl/CapturePipelineImpl;", "Landroidx/camera/camera2/impl/CapturePipeline;", "configAdapter", "Landroidx/camera/camera2/adapter/CaptureConfigAdapter;", "flashControl", "Landroidx/camera/camera2/impl/FlashControl;", "torchControl", "Landroidx/camera/camera2/impl/TorchControl;", "videoUsageControl", "Landroidx/camera/camera2/impl/VideoUsageControl;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "requestListener", "Landroidx/camera/camera2/impl/ComboRequestListener;", "useTorchAsFlash", "Landroidx/camera/camera2/compat/workaround/UseTorchAsFlash;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "useCaseCameraStateProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseGraphContext", "Landroidx/camera/camera2/config/UseCaseGraphContext;", "<init>", "(Landroidx/camera/camera2/adapter/CaptureConfigAdapter;Landroidx/camera/camera2/impl/FlashControl;Landroidx/camera/camera2/impl/TorchControl;Landroidx/camera/camera2/impl/VideoUsageControl;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/impl/ComboRequestListener;Landroidx/camera/camera2/compat/workaround/UseTorchAsFlash;Landroidx/camera/camera2/impl/CameraProperties;Ljavax/inject/Provider;Landroidx/camera/camera2/config/UseCaseGraphContext;)V", "hasFlashUnit", "", "getHasFlashUnit", "()Z", "hasFlashUnit$delegate", "Lkotlin/Lazy;", "useCaseCameraState", "kotlin.jvm.PlatformType", "getUseCaseCameraState", "()Landroidx/camera/camera2/impl/UseCaseCameraState;", "useCaseCameraState$delegate", "template", "", "getTemplate", "()I", "setTemplate", "(I)V", "frameMetadata", "Landroidx/camera/camera2/pipe/FrameMetadata;", "getFrameMetadata", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeCaptureTasks", "", "Lkotlinx/coroutines/Deferred;", "Ljava/lang/Void;", "pipelineTasks", "Landroidx/camera/camera2/impl/CapturePipelineImpl$PipelineTask;", "captureMode", "flashMode", "flashType", "mainCaptureParams", "Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;", "(Ljava/util/List;IIILandroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitStillCaptures", "configs", "Landroidx/camera/core/impl/CaptureConfig;", "requestTemplate", "Landroidx/camera/camera2/pipe/RequestTemplate;", "sessionConfigOptions", "Landroidx/camera/core/impl/Config;", "submitStillCaptures-BvXKQx0", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCameraCapturePipeline", "Landroidx/camera/core/imagecapture/CameraCapturePipeline;", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "preCapture", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "postCapture", "(Ljava/util/List;Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "torchAsFlashCapture", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;IILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultCapture", "defaultNoFlashCapture", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "torchApplyCapture", "timeLimitNs", "", "triggerAePreCapture", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;IJLjava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aePreCaptureApplyCapture", "(Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;JILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "screenFlashCapture", "invokeScreenFlashPreCaptureTasks", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeScreenFlashPostCaptureTasks", "lockAf", "Landroidx/camera/camera2/pipe/Result3A;", "convergedTimeLimitNs", "isTorchAsFlash", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConvergeCondition", "Lkotlin/ParameterName;", "name", "toCameraCaptureResult", "Landroidx/camera/core/impl/CameraCaptureResult;", "emptyRequestMetadata", "androidx/camera/camera2/impl/CapturePipelineImpl$emptyRequestMetadata$1", "Landroidx/camera/camera2/impl/CapturePipelineImpl$emptyRequestMetadata$1;", "unlockAf", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitRequestInternal", "params", "isPhysicalFlashRequired", "waitForResult", "Landroidx/camera/camera2/pipe/FrameInfo;", "waitTimeoutNanos", "checker", "totalCaptureResult", "(JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PipelineTask", "MainCaptureParams", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseCaseCameraScope
public final class CapturePipelineImpl implements CapturePipeline {
    private final CaptureConfigAdapter configAdapter;
    private final CapturePipelineImpl$emptyRequestMetadata$1 emptyRequestMetadata;
    private final FlashControl flashControl;
    private FrameMetadata frameMetadata;

    /* JADX INFO: renamed from: hasFlashUnit$delegate, reason: from kotlin metadata */
    private final Lazy hasFlashUnit;
    private final ComboRequestListener requestListener;
    private int template;
    private final UseCaseThreads threads;
    private final TorchControl torchControl;

    /* JADX INFO: renamed from: useCaseCameraState$delegate, reason: from kotlin metadata */
    private final Lazy useCaseCameraState;
    private final Provider<UseCaseCameraState> useCaseCameraStateProvider;
    private final UseCaseGraphContext useCaseGraphContext;
    private final UseTorchAsFlash useTorchAsFlash;
    private final VideoUsageControl videoUsageControl;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/impl/CapturePipelineImpl$PipelineTask;", "", "<init>", "(Ljava/lang/String;I)V", "PRE_CAPTURE", "MAIN_CAPTURE", "POST_CAPTURE", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    enum PipelineTask {
        PRE_CAPTURE,
        MAIN_CAPTURE,
        POST_CAPTURE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<PipelineTask> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$aePreCaptureApplyCapture$1, reason: invalid class name */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {887, 494, 499}, m = "aePreCaptureApplyCapture", n = {"this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "timeLimitNs", "captureMode", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.aePreCaptureApplyCapture(null, 0L, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$defaultCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0}, l = {352, 357, 359, 362}, m = "defaultCapture", n = {"mainCaptureParams", "pipelineTasks", "captureMode"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C01711 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01711(Continuation<? super C01711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.defaultCapture(null, 0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$defaultNoFlashCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0, 0}, l = {378}, m = "defaultNoFlashCapture", n = {"this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "lock3ARequired"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C01721 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01721(Continuation<? super C01721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.defaultNoFlashCapture(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$getFrameMetadata$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {}, l = {WebmConstants.MkvEbmlElement.PIXEL_WIDTH}, m = "getFrameMetadata", n = {}, s = {}, v = 1)
    static final class C01731 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01731(Continuation<? super C01731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.getFrameMetadata(this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$invokeCaptureTasks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {1, 1, 1, 1}, l = {JfifUtil.MARKER_SOI, JfifUtil.MARKER_EOI, JfifUtil.MARKER_SOS, 220}, m = "invokeCaptureTasks", n = {"pipelineTasks", "mainCaptureParams", "captureMode", "flashMode"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C01741 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01741(Continuation<? super C01741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.invokeCaptureTasks(null, 0, 0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$invokeScreenFlashPostCaptureTasks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 1}, l = {563, 875, 570}, m = "invokeScreenFlashPostCaptureTasks", n = {"captureMode", "captureMode"}, s = {"I$0", "I$0"}, v = 1)
    static final class C01751 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01751(Continuation<? super C01751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.invokeScreenFlashPostCaptureTasks(0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$invokeScreenFlashPreCaptureTasks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 1}, l = {544, 871, 551, 556}, m = "invokeScreenFlashPreCaptureTasks", n = {"captureMode", "captureMode"}, s = {"I$0", "I$0"}, v = 1)
    static final class C01761 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01761(Continuation<? super C01761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.invokeScreenFlashPreCaptureTasks(0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$isPhysicalFlashRequired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {}, l = {772}, m = "isPhysicalFlashRequired", n = {}, s = {}, v = 1)
    static final class C01771 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C01771(Continuation<? super C01771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.isPhysicalFlashRequired(0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$lockAf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0}, l = {871, 585, 594}, m = "lockAf", n = {"convergedTimeLimitNs", "isTorchAsFlash"}, s = {"J$0", "Z$0"}, v = 1)
    static final class C01791 extends ContinuationImpl {
        long J$0;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C01791(Continuation<? super C01791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.lockAf(0L, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$screenFlashCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0, 0}, l = {528}, m = "screenFlashCapture", n = {"this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C01801 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01801(Continuation<? super C01801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.screenFlashCapture(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$torchApplyCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5}, l = {408, 895, 416, 421, 436, 440}, m = "torchApplyCapture", n = {"this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "timeLimitNs", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "timeLimitNs", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "triggerAePreCapture", "torchOnRequired", "lock3ARequired", "this_$iv", "$this$invoke$iv", "mainCaptureParams$iv", "captureMode", "triggerAePreCapture", "torchOnRequired", "lock3ARequired"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "J$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "Z$0", "I$1", "I$2"}, v = 1)
    static final class C01811 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C01811(Continuation<? super C01811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.torchApplyCapture(null, 0, 0L, null, false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$torchAsFlashCapture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0, 0, 0}, l = {330, MediaError.DetailedErrorCode.SMOOTH_NETWORK, 341}, m = "torchAsFlashCapture", n = {"mainCaptureParams", "pipelineTasks", "captureMode"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C01821 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01821(Continuation<? super C01821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.torchAsFlashCapture(null, 0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$unlockAf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0}, l = {871, 648, 649}, m = "unlockAf", n = {"timeLimitNs"}, s = {"J$0"}, v = 1)
    static final class C01831 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01831(Continuation<? super C01831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.unlockAf(0L, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", i = {0}, l = {793}, m = "waitForResult", n = {"resultListener"}, s = {"L$0"}, v = 1)
    static final class C01841 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01841(Continuation<? super C01841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CapturePipelineImpl.this.waitForResult(0L, null, this);
        }
    }

    static final boolean waitForResult$lambda$0(FrameInfo frameInfo) {
        Intrinsics.checkNotNullParameter(frameInfo, "<unused var>");
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.camera.camera2.impl.CapturePipelineImpl$emptyRequestMetadata$1] */
    @Inject
    public CapturePipelineImpl(CaptureConfigAdapter configAdapter, FlashControl flashControl, TorchControl torchControl, VideoUsageControl videoUsageControl, UseCaseThreads threads, ComboRequestListener requestListener, UseTorchAsFlash useTorchAsFlash, final CameraProperties cameraProperties, Provider<UseCaseCameraState> useCaseCameraStateProvider, UseCaseGraphContext useCaseGraphContext) {
        Intrinsics.checkNotNullParameter(configAdapter, "configAdapter");
        Intrinsics.checkNotNullParameter(flashControl, "flashControl");
        Intrinsics.checkNotNullParameter(torchControl, "torchControl");
        Intrinsics.checkNotNullParameter(videoUsageControl, "videoUsageControl");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(useTorchAsFlash, "useTorchAsFlash");
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(useCaseCameraStateProvider, "useCaseCameraStateProvider");
        Intrinsics.checkNotNullParameter(useCaseGraphContext, "useCaseGraphContext");
        this.configAdapter = configAdapter;
        this.flashControl = flashControl;
        this.torchControl = torchControl;
        this.videoUsageControl = videoUsageControl;
        this.threads = threads;
        this.requestListener = requestListener;
        this.useTorchAsFlash = useTorchAsFlash;
        this.useCaseCameraStateProvider = useCaseCameraStateProvider;
        this.useCaseGraphContext = useCaseGraphContext;
        this.hasFlashUnit = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(FlashAvailabilityCheckerKt.isFlashAvailable$default(cameraProperties, false, 1, null));
            }
        });
        this.useCaseCameraState = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.useCaseCameraStateProvider.get();
            }
        });
        this.template = 1;
        this.emptyRequestMetadata = new RequestMetadata() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$emptyRequestMetadata$1
            private final int template = RequestTemplate.m715constructorimpl(0);
            private final Map<StreamId, Surface> streams = MapsKt.emptyMap();
            private final boolean repeating = true;
            private final Request request = new Request(CollectionsKt.emptyList(), null, null, null, null, null, 62, null);
            private final long requestNumber = RequestNumber.m708constructorimpl(0);

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public <T> T get(CaptureRequest.Key<T> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return null;
            }

            @Override // androidx.camera.camera2.pipe.Metadata
            public <T> T get(androidx.camera.camera2.pipe.Metadata.Key<T> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return null;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public <T> T getOrDefault(CaptureRequest.Key<T> key, T t) {
                Intrinsics.checkNotNullParameter(key, "key");
                return t;
            }

            @Override // androidx.camera.camera2.pipe.Metadata
            public <T> T getOrDefault(androidx.camera.camera2.pipe.Metadata.Key<T> key, T t) {
                Intrinsics.checkNotNullParameter(key, "key");
                return t;
            }

            @Override // androidx.camera.camera2.pipe.UnsafeWrapper
            public <T> T unwrapAs(KClass<T> type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return null;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            /* JADX INFO: renamed from: getTemplate-fGx8uWA, reason: not valid java name and from getter */
            public int getTemplate() {
                return this.template;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public Map<StreamId, Surface> getStreams() {
                return this.streams;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public boolean getRepeating() {
                return this.repeating;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            public Request getRequest() {
                return this.request;
            }

            @Override // androidx.camera.camera2.pipe.RequestMetadata
            /* JADX INFO: renamed from: getRequestNumber-my6kx4g, reason: not valid java name and from getter */
            public long getRequestNumber() {
                return this.requestNumber;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000eJ\t\u0010\u0015\u001a\u00020\bHÆ\u0003J4\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;", "", "configs", "", "Landroidx/camera/core/impl/CaptureConfig;", "requestTemplate", "Landroidx/camera/camera2/pipe/RequestTemplate;", "sessionConfigOptions", "Landroidx/camera/core/impl/Config;", "<init>", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConfigs", "()Ljava/util/List;", "getRequestTemplate-fGx8uWA", "()I", "I", "getSessionConfigOptions", "()Landroidx/camera/core/impl/Config;", "component1", "component2", "component2-fGx8uWA", "component3", "copy", "copy-9al78dA", "(Ljava/util/List;ILandroidx/camera/core/impl/Config;)Landroidx/camera/camera2/impl/CapturePipelineImpl$MainCaptureParams;", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class MainCaptureParams {
        private final List<CaptureConfig> configs;
        private final int requestTemplate;
        private final Config sessionConfigOptions;

        public /* synthetic */ MainCaptureParams(List list, int i, Config config, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, i, config);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-9al78dA$default, reason: not valid java name */
        public static /* synthetic */ MainCaptureParams m101copy9al78dA$default(MainCaptureParams mainCaptureParams, List list, int i, Config config, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = mainCaptureParams.configs;
            }
            if ((i2 & 2) != 0) {
                i = mainCaptureParams.requestTemplate;
            }
            if ((i2 & 4) != 0) {
                config = mainCaptureParams.sessionConfigOptions;
            }
            return mainCaptureParams.m103copy9al78dA(list, i, config);
        }

        public final List<CaptureConfig> component1() {
            return this.configs;
        }

        /* JADX INFO: renamed from: component2-fGx8uWA, reason: not valid java name and from getter */
        public final int getRequestTemplate() {
            return this.requestTemplate;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Config getSessionConfigOptions() {
            return this.sessionConfigOptions;
        }

        /* JADX INFO: renamed from: copy-9al78dA, reason: not valid java name */
        public final MainCaptureParams m103copy9al78dA(List<CaptureConfig> configs, int requestTemplate, Config sessionConfigOptions) {
            Intrinsics.checkNotNullParameter(configs, "configs");
            Intrinsics.checkNotNullParameter(sessionConfigOptions, "sessionConfigOptions");
            return new MainCaptureParams(configs, requestTemplate, sessionConfigOptions, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MainCaptureParams)) {
                return false;
            }
            MainCaptureParams mainCaptureParams = (MainCaptureParams) other;
            return Intrinsics.areEqual(this.configs, mainCaptureParams.configs) && RequestTemplate.m717equalsimpl0(this.requestTemplate, mainCaptureParams.requestTemplate) && Intrinsics.areEqual(this.sessionConfigOptions, mainCaptureParams.sessionConfigOptions);
        }

        public int hashCode() {
            return (((this.configs.hashCode() * 31) + RequestTemplate.m719hashCodeimpl(this.requestTemplate)) * 31) + this.sessionConfigOptions.hashCode();
        }

        public String toString() {
            return "MainCaptureParams(configs=" + this.configs + ", requestTemplate=" + ((Object) RequestTemplate.m720toStringimpl(this.requestTemplate)) + ", sessionConfigOptions=" + this.sessionConfigOptions + ')';
        }

        private MainCaptureParams(List<CaptureConfig> configs, int i, Config sessionConfigOptions) {
            Intrinsics.checkNotNullParameter(configs, "configs");
            Intrinsics.checkNotNullParameter(sessionConfigOptions, "sessionConfigOptions");
            this.configs = configs;
            this.requestTemplate = i;
            this.sessionConfigOptions = sessionConfigOptions;
        }

        public final List<CaptureConfig> getConfigs() {
            return this.configs;
        }

        /* JADX INFO: renamed from: getRequestTemplate-fGx8uWA, reason: not valid java name */
        public final int m104getRequestTemplatefGx8uWA() {
            return this.requestTemplate;
        }

        public final Config getSessionConfigOptions() {
            return this.sessionConfigOptions;
        }
    }

    private final boolean getHasFlashUnit() {
        return ((Boolean) this.hasFlashUnit.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UseCaseCameraState getUseCaseCameraState() {
        return (UseCaseCameraState) this.useCaseCameraState.getValue();
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    public int getTemplate() {
        return this.template;
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    public void setTemplate(int i) {
        this.template = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x007d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x007d, please report this as an issue */
    public final Object getFrameMetadata(Continuation<? super FrameMetadata> continuation) {
        C01731 c01731;
        CapturePipelineImpl capturePipelineImpl;
        CapturePipelineImpl capturePipelineImpl2;
        if (continuation instanceof C01731) {
            c01731 = (C01731) continuation;
            if ((c01731.label & Integer.MIN_VALUE) != 0) {
                c01731.label -= Integer.MIN_VALUE;
            } else {
                c01731 = new C01731(continuation);
            }
        } else {
            c01731 = new C01731(continuation);
        }
        C01731 c01732 = c01731;
        Object objWaitForResult$default = c01732.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01732.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWaitForResult$default);
            if (this.frameMetadata == null) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "getFrameMetadata: waiting for result");
                }
                long j = CapturePipelineKt.CHECK_FLASH_REQUIRED_TIMEOUT_IN_NS;
                c01732.L$0 = this;
                c01732.label = 1;
                capturePipelineImpl = this;
                objWaitForResult$default = waitForResult$default(capturePipelineImpl, j, null, c01732, 2, null);
                if (objWaitForResult$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                capturePipelineImpl2 = capturePipelineImpl;
            } else {
                capturePipelineImpl = this;
            }
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "getFrameMetadata: frameMetadata = " + capturePipelineImpl.frameMetadata);
            }
            return capturePipelineImpl.frameMetadata;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        capturePipelineImpl2 = (CapturePipelineImpl) c01732.L$0;
        ResultKt.throwOnFailure(objWaitForResult$default);
        capturePipelineImpl = this;
        FrameInfo frameInfo = (FrameInfo) objWaitForResult$default;
        capturePipelineImpl2.frameMetadata = frameInfo != null ? frameInfo.getMetadata() : null;
        Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "getFrameMetadata: frameMetadata = " + capturePipelineImpl.frameMetadata);
        }
        return capturePipelineImpl.frameMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invokeCaptureTasks(List<? extends PipelineTask> list, int i, int i2, int i3, MainCaptureParams mainCaptureParams, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        C01741 c01741;
        if (continuation instanceof C01741) {
            c01741 = (C01741) continuation;
            if ((c01741.label & Integer.MIN_VALUE) != 0) {
                c01741.label -= Integer.MIN_VALUE;
            } else {
                c01741 = new C01741(continuation);
            }
        } else {
            c01741 = new C01741(continuation);
        }
        Object objIsTorchAsFlash = c01741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c01741.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(objIsTorchAsFlash);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#invokeCaptureTasks: tasks = " + list + ", captureMode = " + i + ", flashMode = " + i2 + ", flashType = " + i3);
            }
            this.frameMetadata = null;
            if (list.contains(PipelineTask.MAIN_CAPTURE) && mainCaptureParams == null) {
                throw new IllegalStateException("Must not be null for PipelineType.MAIN_CAPTURE".toString());
            }
            if (i2 == 3) {
                c01741.label = 1;
                Object objScreenFlashCapture = screenFlashCapture(mainCaptureParams, i, list, c01741);
                if (objScreenFlashCapture != coroutine_suspended) {
                    return objScreenFlashCapture;
                }
            } else {
                c01741.L$0 = list;
                c01741.L$1 = mainCaptureParams;
                c01741.I$0 = i;
                c01741.I$1 = i2;
                c01741.label = 2;
                objIsTorchAsFlash = isTorchAsFlash(i3, c01741);
                if (objIsTorchAsFlash != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            ResultKt.throwOnFailure(objIsTorchAsFlash);
            return objIsTorchAsFlash;
        }
        if (i4 != 2) {
            if (i4 == 3) {
                ResultKt.throwOnFailure(objIsTorchAsFlash);
                return objIsTorchAsFlash;
            }
            if (i4 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsTorchAsFlash);
            return objIsTorchAsFlash;
        }
        i2 = c01741.I$1;
        i = c01741.I$0;
        mainCaptureParams = (MainCaptureParams) c01741.L$1;
        list = (List) c01741.L$0;
        ResultKt.throwOnFailure(objIsTorchAsFlash);
        List<? extends PipelineTask> list2 = list;
        MainCaptureParams mainCaptureParams2 = mainCaptureParams;
        if (((Boolean) objIsTorchAsFlash).booleanValue()) {
            c01741.L$0 = null;
            c01741.L$1 = null;
            c01741.label = 3;
            Object obj = torchAsFlashCapture(mainCaptureParams2, i, i2, list2, c01741);
            if (obj != coroutine_suspended) {
                return obj;
            }
        } else {
            C01741 c01742 = c01741;
            c01742.L$0 = null;
            c01742.L$1 = null;
            c01742.label = 4;
            Object objDefaultCapture = defaultCapture(mainCaptureParams2, i, i2, list2, c01742);
            if (objDefaultCapture != coroutine_suspended) {
                return objDefaultCapture;
            }
        }
        return coroutine_suspended;
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    /* JADX INFO: renamed from: submitStillCaptures-BvXKQx0 */
    public Object mo75submitStillCapturesBvXKQx0(List<CaptureConfig> list, int i, Config config, int i2, int i3, int i4, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        return invokeCaptureTasks(CollectionsKt.listOf((Object[]) new PipelineTask[]{PipelineTask.PRE_CAPTURE, PipelineTask.MAIN_CAPTURE, PipelineTask.POST_CAPTURE}), i2, i4, i3, new MainCaptureParams(list, i, config, null), continuation);
    }

    @Override // androidx.camera.camera2.impl.CapturePipeline
    public Object getCameraCapturePipeline(final int i, final int i2, final int i3, Continuation<? super CameraCapturePipeline> continuation) {
        return new CameraCapturePipeline() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl.getCameraCapturePipeline.2
            @Override // androidx.camera.core.imagecapture.CameraCapturePipeline
            public ListenableFuture<Void> invokePreCapture() {
                final CoroutineScope scope = CapturePipelineImpl.this.threads.getScope();
                final CapturePipelineImpl capturePipelineImpl = CapturePipelineImpl.this;
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer<T> completer) {
                        Intrinsics.checkNotNullParameter(completer, "completer");
                        return BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(completer, null, capturePipelineImpl, i4, i5, i6), 3, null);
                    }

                    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: CoroutineAdapters.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/adapter/CoroutineAdaptersKt$future$resolver$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1$1", f = "CapturePipeline.kt", i = {}, l = {104, 111}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ int $captureMode$inlined;
                        final /* synthetic */ CallbackToFutureAdapter.Completer $completer;
                        final /* synthetic */ int $flashMode$inlined;
                        final /* synthetic */ int $flashType$inlined;
                        Object L$0;
                        int label;
                        final /* synthetic */ CapturePipelineImpl this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(CallbackToFutureAdapter.Completer completer, Continuation continuation, CapturePipelineImpl capturePipelineImpl, int i, int i2, int i3) {
                            super(2, continuation);
                            this.$completer = completer;
                            this.this$0 = capturePipelineImpl;
                            this.$captureMode$inlined = i;
                            this.$flashMode$inlined = i2;
                            this.$flashType$inlined = i3;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$completer, continuation, this.this$0, this.$captureMode$inlined, this.$flashMode$inlined, this.$flashType$inlined);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
                        
                            if (kotlinx.coroutines.AwaitKt.joinAll((java.util.Collection<? extends kotlinx.coroutines.Job>) r13, r10) == r0) goto L16;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                            /*
                                r12 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r12.label
                                r2 = 2
                                r3 = 1
                                if (r1 == 0) goto L28
                                if (r1 == r3) goto L1e
                                if (r1 != r2) goto L16
                                java.lang.Object r12 = r12.L$0
                                androidx.concurrent.futures.CallbackToFutureAdapter$Completer r12 = (androidx.concurrent.futures.CallbackToFutureAdapter.Completer) r12
                                kotlin.ResultKt.throwOnFailure(r13)
                                goto L5b
                            L16:
                                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                                r12.<init>(r13)
                                throw r12
                            L1e:
                                java.lang.Object r1 = r12.L$0
                                androidx.concurrent.futures.CallbackToFutureAdapter$Completer r1 = (androidx.concurrent.futures.CallbackToFutureAdapter.Completer) r1
                                kotlin.ResultKt.throwOnFailure(r13)
                                r10 = r12
                                r12 = r1
                                goto L4e
                            L28:
                                kotlin.ResultKt.throwOnFailure(r13)
                                androidx.concurrent.futures.CallbackToFutureAdapter$Completer r13 = r12.$completer
                                r1 = r12
                                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                androidx.camera.camera2.impl.CapturePipelineImpl r4 = r12.this$0
                                androidx.camera.camera2.impl.CapturePipelineImpl$PipelineTask r1 = androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask.PRE_CAPTURE
                                java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r1)
                                int r6 = r12.$captureMode$inlined
                                int r7 = r12.$flashMode$inlined
                                int r8 = r12.$flashType$inlined
                                r12.L$0 = r13
                                r12.label = r3
                                r9 = 0
                                r10 = r12
                                java.lang.Object r12 = androidx.camera.camera2.impl.CapturePipelineImpl.access$invokeCaptureTasks(r4, r5, r6, r7, r8, r9, r10)
                                if (r12 != r0) goto L4b
                                goto L5a
                            L4b:
                                r11 = r13
                                r13 = r12
                                r12 = r11
                            L4e:
                                java.util.Collection r13 = (java.util.Collection) r13
                                r10.L$0 = r12
                                r10.label = r2
                                java.lang.Object r13 = kotlinx.coroutines.AwaitKt.joinAll(r13, r10)
                                if (r13 != r0) goto L5b
                            L5a:
                                return r0
                            L5b:
                                r13 = 0
                                r12.set(r13)
                                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                                return r12
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePreCapture$$inlined$future$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }
                });
                Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
                return future;
            }

            @Override // androidx.camera.core.imagecapture.CameraCapturePipeline
            public ListenableFuture<Void> invokePostCapture() {
                final CoroutineScope scope = CapturePipelineImpl.this.threads.getScope();
                final CapturePipelineImpl capturePipelineImpl = CapturePipelineImpl.this;
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer<T> completer) {
                        Intrinsics.checkNotNullParameter(completer, "completer");
                        return BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(completer, null, capturePipelineImpl, i4, i5, i6), 3, null);
                    }

                    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: CoroutineAdapters.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/adapter/CoroutineAdaptersKt$future$resolver$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1$1", f = "CapturePipeline.kt", i = {}, l = {104, 111}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ int $captureMode$inlined;
                        final /* synthetic */ CallbackToFutureAdapter.Completer $completer;
                        final /* synthetic */ int $flashMode$inlined;
                        final /* synthetic */ int $flashType$inlined;
                        Object L$0;
                        int label;
                        final /* synthetic */ CapturePipelineImpl this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(CallbackToFutureAdapter.Completer completer, Continuation continuation, CapturePipelineImpl capturePipelineImpl, int i, int i2, int i3) {
                            super(2, continuation);
                            this.$completer = completer;
                            this.this$0 = capturePipelineImpl;
                            this.$captureMode$inlined = i;
                            this.$flashMode$inlined = i2;
                            this.$flashType$inlined = i3;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$completer, continuation, this.this$0, this.$captureMode$inlined, this.$flashMode$inlined, this.$flashType$inlined);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
                        
                            if (kotlinx.coroutines.AwaitKt.joinAll((java.util.Collection<? extends kotlinx.coroutines.Job>) r13, r10) == r0) goto L16;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                            /*
                                r12 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r12.label
                                r2 = 2
                                r3 = 1
                                if (r1 == 0) goto L28
                                if (r1 == r3) goto L1e
                                if (r1 != r2) goto L16
                                java.lang.Object r12 = r12.L$0
                                androidx.concurrent.futures.CallbackToFutureAdapter$Completer r12 = (androidx.concurrent.futures.CallbackToFutureAdapter.Completer) r12
                                kotlin.ResultKt.throwOnFailure(r13)
                                goto L5b
                            L16:
                                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                                r12.<init>(r13)
                                throw r12
                            L1e:
                                java.lang.Object r1 = r12.L$0
                                androidx.concurrent.futures.CallbackToFutureAdapter$Completer r1 = (androidx.concurrent.futures.CallbackToFutureAdapter.Completer) r1
                                kotlin.ResultKt.throwOnFailure(r13)
                                r10 = r12
                                r12 = r1
                                goto L4e
                            L28:
                                kotlin.ResultKt.throwOnFailure(r13)
                                androidx.concurrent.futures.CallbackToFutureAdapter$Completer r13 = r12.$completer
                                r1 = r12
                                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                androidx.camera.camera2.impl.CapturePipelineImpl r4 = r12.this$0
                                androidx.camera.camera2.impl.CapturePipelineImpl$PipelineTask r1 = androidx.camera.camera2.impl.CapturePipelineImpl.PipelineTask.POST_CAPTURE
                                java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r1)
                                int r6 = r12.$captureMode$inlined
                                int r7 = r12.$flashMode$inlined
                                int r8 = r12.$flashType$inlined
                                r12.L$0 = r13
                                r12.label = r3
                                r9 = 0
                                r10 = r12
                                java.lang.Object r12 = androidx.camera.camera2.impl.CapturePipelineImpl.access$invokeCaptureTasks(r4, r5, r6, r7, r8, r9, r10)
                                if (r12 != r0) goto L4b
                                goto L5a
                            L4b:
                                r11 = r13
                                r13 = r12
                                r12 = r11
                            L4e:
                                java.util.Collection r13 = (java.util.Collection) r13
                                r10.L$0 = r12
                                r10.label = r2
                                java.lang.Object r13 = kotlinx.coroutines.AwaitKt.joinAll(r13, r10)
                                if (r13 != r0) goto L5b
                            L5a:
                                return r0
                            L5b:
                                r13 = 0
                                r12.set(r13)
                                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                                return r12
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl$getCameraCapturePipeline$2$invokePostCapture$$inlined$future$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }
                });
                Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
                return future;
            }
        };
    }

    private final Object invoke(List<? extends PipelineTask> list, MainCaptureParams mainCaptureParams, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function1<? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        List<Deferred<Void>> listListOf;
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list);
        }
        if (list.contains(PipelineTask.PRE_CAPTURE)) {
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
            }
            function1.invoke(continuation);
            Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
            }
        }
        if (list.contains(PipelineTask.MAIN_CAPTURE)) {
            Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
            }
            if (mainCaptureParams == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            listListOf = submitRequestInternal(mainCaptureParams);
            Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
            }
            Unit unit = Unit.INSTANCE;
        } else {
            listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
        }
        if (list.contains(PipelineTask.POST_CAPTURE)) {
            BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new CapturePipelineImpl$invoke$7$1(listListOf, function2, null), 3, null);
        }
        Unit unit2 = Unit.INSTANCE;
        return listListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x00be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object torchAsFlashCapture(MainCaptureParams mainCaptureParams, int i, int i2, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        C01821 c01821;
        List<? extends PipelineTask> list2;
        Object objDefaultNoFlashCapture;
        if (continuation instanceof C01821) {
            c01821 = (C01821) continuation;
            if ((c01821.label & Integer.MIN_VALUE) != 0) {
                c01821.label -= Integer.MIN_VALUE;
            } else {
                c01821 = new C01821(continuation);
            }
        } else {
            c01821 = new C01821(continuation);
        }
        C01821 c01822 = c01821;
        Object objIsPhysicalFlashRequired = c01822.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c01822.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchAsFlashCapture");
            }
            if (getHasFlashUnit()) {
                c01822.L$0 = mainCaptureParams;
                c01822.L$1 = list;
                c01822.I$0 = i;
                c01822.label = 1;
                objIsPhysicalFlashRequired = isPhysicalFlashRequired(i2, c01822);
                if (objIsPhysicalFlashRequired != coroutine_suspended) {
                    list2 = list;
                }
            } else {
                c01822.L$0 = null;
                c01822.L$1 = null;
                c01822.label = 3;
                objDefaultNoFlashCapture = defaultNoFlashCapture(mainCaptureParams, i, list, c01822);
                if (objDefaultNoFlashCapture == coroutine_suspended) {
                    return objDefaultNoFlashCapture;
                }
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
                return objIsPhysicalFlashRequired;
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
            return objIsPhysicalFlashRequired;
        }
        int i4 = c01822.I$0;
        List<? extends PipelineTask> list3 = (List) c01822.L$1;
        MainCaptureParams mainCaptureParams2 = (MainCaptureParams) c01822.L$0;
        ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
        list2 = list3;
        i = i4;
        mainCaptureParams = mainCaptureParams2;
        if (((Boolean) objIsPhysicalFlashRequired).booleanValue()) {
            boolean z = true;
            long j = CapturePipelineKt.CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS;
            if (this.useTorchAsFlash.shouldDisableAePrecapture() || this.videoUsageControl.isInVideoUsage()) {
                z = false;
            }
            c01822.L$0 = null;
            c01822.L$1 = null;
            c01822.label = 2;
            Object obj = torchApplyCapture(mainCaptureParams, i, j, list2, z, c01822);
            if (obj != coroutine_suspended) {
                return obj;
            }
        } else {
            list = list2;
            c01822.L$0 = null;
            c01822.L$1 = null;
            c01822.label = 3;
            objDefaultNoFlashCapture = defaultNoFlashCapture(mainCaptureParams, i, list, c01822);
            if (objDefaultNoFlashCapture == coroutine_suspended) {
                return objDefaultNoFlashCapture;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object defaultCapture(MainCaptureParams mainCaptureParams, int i, int i2, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        C01711 c01711;
        if (continuation instanceof C01711) {
            c01711 = (C01711) continuation;
            if ((c01711.label & Integer.MIN_VALUE) != 0) {
                c01711.label -= Integer.MIN_VALUE;
            } else {
                c01711 = new C01711(continuation);
            }
        } else {
            c01711 = new C01711(continuation);
        }
        C01711 c01712 = c01711;
        Object objIsPhysicalFlashRequired = c01712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c01712.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
            if (getHasFlashUnit()) {
                c01712.L$0 = mainCaptureParams;
                c01712.L$1 = list;
                c01712.I$0 = i;
                c01712.label = 1;
                objIsPhysicalFlashRequired = isPhysicalFlashRequired(i2, c01712);
                if (objIsPhysicalFlashRequired != coroutine_suspended) {
                }
            } else {
                c01712.label = 4;
                Object objDefaultNoFlashCapture = defaultNoFlashCapture(mainCaptureParams, i, list, c01712);
                if (objDefaultNoFlashCapture != coroutine_suspended) {
                    return objDefaultNoFlashCapture;
                }
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
                return objIsPhysicalFlashRequired;
            }
            if (i3 == 3) {
                ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
                return objIsPhysicalFlashRequired;
            }
            if (i3 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
            return objIsPhysicalFlashRequired;
        }
        i = c01712.I$0;
        list = (List) c01712.L$1;
        mainCaptureParams = (MainCaptureParams) c01712.L$0;
        ResultKt.throwOnFailure(objIsPhysicalFlashRequired);
        MainCaptureParams mainCaptureParams2 = mainCaptureParams;
        int i4 = i;
        List<? extends PipelineTask> list2 = list;
        boolean zBooleanValue = ((Boolean) objIsPhysicalFlashRequired).booleanValue();
        long j = zBooleanValue ? CapturePipelineKt.CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS : CapturePipelineKt.CHECK_3A_TIMEOUT_IN_NS;
        if (zBooleanValue || i4 == 0) {
            c01712.L$0 = null;
            c01712.L$1 = null;
            c01712.label = 2;
            Object objAePreCaptureApplyCapture = aePreCaptureApplyCapture(mainCaptureParams2, j, i4, list2, c01712);
            if (objAePreCaptureApplyCapture != coroutine_suspended) {
                return objAePreCaptureApplyCapture;
            }
        } else {
            c01712.L$0 = null;
            c01712.L$1 = null;
            c01712.label = 3;
            Object objDefaultNoFlashCapture2 = defaultNoFlashCapture(mainCaptureParams2, i4, list2, c01712);
            if (objDefaultNoFlashCapture2 != coroutine_suspended) {
                return objDefaultNoFlashCapture2;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:49:0x0107  */
    /* JADX WARN: Code duplicated, block: B:51:0x0112  */
    /* JADX WARN: Code duplicated, block: B:53:0x011e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0128  */
    /* JADX WARN: Code duplicated, block: B:56:0x0134  */
    /* JADX WARN: Code duplicated, block: B:59:0x0144  */
    /* JADX WARN: Code duplicated, block: B:61:0x014e  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object defaultNoFlashCapture(MainCaptureParams mainCaptureParams, int i, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        C01721 c01721;
        int i2;
        CapturePipelineImpl capturePipelineImpl;
        MainCaptureParams mainCaptureParams2;
        List<Deferred<Void>> listListOf;
        List<? extends PipelineTask> list2 = list;
        if (continuation instanceof C01721) {
            c01721 = (C01721) continuation;
            if ((c01721.label & Integer.MIN_VALUE) != 0) {
                c01721.label -= Integer.MIN_VALUE;
            } else {
                c01721 = new C01721(continuation);
            }
        } else {
            c01721 = new C01721(continuation);
        }
        Object obj = c01721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c01721.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#defaultNoFlashCapture");
            }
            i2 = i == 0 ? 1 : 0;
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list2);
            }
            if (list2.contains(PipelineTask.PRE_CAPTURE)) {
                Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
                }
                if (i2 != 0) {
                    Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#defaultNoFlashCapture: Locking 3A");
                    }
                    long j = CapturePipelineKt.CHECK_3A_TIMEOUT_IN_NS;
                    c01721.L$0 = this;
                    c01721.L$1 = list2;
                    c01721.L$2 = mainCaptureParams;
                    c01721.I$0 = i2;
                    c01721.label = 1;
                    if (lockAf(j, false, c01721) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    capturePipelineImpl = this;
                    mainCaptureParams2 = mainCaptureParams;
                } else {
                    capturePipelineImpl = this;
                    mainCaptureParams2 = mainCaptureParams;
                }
                Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                }
            } else {
                capturePipelineImpl = this;
                mainCaptureParams2 = mainCaptureParams;
            }
            if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                }
                if (mainCaptureParams2 != null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                Camera2Logger camera2Logger7 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                }
            } else {
                listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
            }
            if (list2.contains(PipelineTask.POST_CAPTURE)) {
                BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$defaultNoFlashCapture$$inlined$invoke$1(listListOf, null, i2 != 0, this), 3, null);
            }
            return listListOf;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i4 = c01721.I$0;
        mainCaptureParams2 = (MainCaptureParams) c01721.L$2;
        List<? extends PipelineTask> list3 = (List) c01721.L$1;
        capturePipelineImpl = (CapturePipelineImpl) c01721.L$0;
        ResultKt.throwOnFailure(obj);
        i2 = i4;
        list2 = list3;
        Camera2Logger camera2Logger8 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#defaultNoFlashCapture: Locking 3A done");
        }
        Camera2Logger camera2Logger9 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
        }
        if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
            Camera2Logger camera2Logger10 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
            }
            if (mainCaptureParams2 != null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
            Camera2Logger camera2Logger11 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
            }
        } else {
            listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
        }
        if (list2.contains(PipelineTask.POST_CAPTURE)) {
            BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$defaultNoFlashCapture$$inlined$invoke$1(listListOf, null, i2 != 0, this), 3, null);
        }
        return listListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x02be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:104:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:108:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:111:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:113:0x0306  */
    /* JADX WARN: Code duplicated, block: B:115:0x030e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0336  */
    /* JADX WARN: Code duplicated, block: B:122:0x0345  */
    /* JADX WARN: Code duplicated, block: B:123:0x034f  */
    /* JADX WARN: Code duplicated, block: B:126:0x035c  */
    /* JADX WARN: Code duplicated, block: B:131:0x037a  */
    /* JADX WARN: Code duplicated, block: B:133:0x0382  */
    /* JADX WARN: Code duplicated, block: B:135:0x038d  */
    /* JADX WARN: Code duplicated, block: B:137:0x0399  */
    /* JADX WARN: Code duplicated, block: B:138:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:140:0x03af  */
    /* JADX WARN: Code duplicated, block: B:143:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:145:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:146:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:149:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:62:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x01db  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:71:0x020f  */
    /* JADX WARN: Code duplicated, block: B:75:0x021e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0221  */
    /* JADX WARN: Code duplicated, block: B:78:0x0225  */
    /* JADX WARN: Code duplicated, block: B:79:0x0228  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:83:0x025d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0286  */
    /* JADX WARN: Code duplicated, block: B:91:0x0299  */
    /* JADX WARN: Code duplicated, block: B:99:0x02bb  */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x0299, please report this as an issue */
    public final Object torchApplyCapture(MainCaptureParams mainCaptureParams, int i, long j, List<? extends PipelineTask> list, boolean z, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        C01811 c01811;
        int i2;
        MainCaptureParams mainCaptureParams2;
        boolean z2;
        int i3;
        List<? extends PipelineTask> list2;
        CapturePipelineImpl capturePipelineImpl;
        int i4;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        List<? extends PipelineTask> list3;
        int i7;
        long j2;
        long j3;
        boolean z5;
        int i8;
        Function1<FrameInfo, Boolean> function1;
        int i9;
        MainCaptureParams mainCaptureParams3;
        List<? extends PipelineTask> list4;
        CapturePipelineImpl capturePipelineImpl2;
        Object objAcquireSession;
        long j4;
        int i10;
        MainCaptureParams mainCaptureParams4;
        int i11;
        List<? extends PipelineTask> list5;
        CapturePipelineImpl capturePipelineImpl3;
        AutoCloseable autoCloseable;
        Throwable th;
        AutoCloseable autoCloseable2;
        boolean z6;
        boolean z7;
        boolean z8;
        MainCaptureParams mainCaptureParams5;
        Object objLock3AForCapture$default;
        AutoCloseable autoCloseable3;
        int i12;
        List<? extends PipelineTask> list6;
        CapturePipelineImpl capturePipelineImpl4;
        MainCaptureParams mainCaptureParams6;
        boolean z9;
        CapturePipelineImpl capturePipelineImpl5;
        Result3A result3A;
        List<Deferred<Void>> listListOf;
        int i13;
        boolean z10;
        if (continuation instanceof C01811) {
            c01811 = (C01811) continuation;
            if ((c01811.label & Integer.MIN_VALUE) != 0) {
                c01811.label -= Integer.MIN_VALUE;
            } else {
                c01811 = new C01811(continuation);
            }
        } else {
            c01811 = new C01811(continuation);
        }
        C01811 c01812 = c01811;
        Object objAwait = c01812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c01812.label) {
            case 0:
                ResultKt.throwOnFailure(objAwait);
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture");
                }
                Integer value = this.torchControl.getTorchStateLiveData().getValue();
                i2 = (value != null && value.intValue() == 0) ? 1 : 0;
                int i14 = (i2 != 0 || i == 0) ? 1 : 0;
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list);
                }
                if (list.contains(PipelineTask.PRE_CAPTURE)) {
                    Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
                    }
                    if (i2 != 0) {
                        Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Setting torch");
                        }
                        Deferred deferredM120setTorchAsyncOup_wC0$camera_camera2$default = TorchControl.m120setTorchAsyncOup_wC0$camera_camera2$default(this.torchControl, TorchControl.TorchMode.INSTANCE.m134getUSED_AS_FLASHIRs_R8(), false, false, 6, null);
                        c01812.L$0 = this;
                        c01812.L$1 = list;
                        mainCaptureParams2 = mainCaptureParams;
                        c01812.L$2 = mainCaptureParams2;
                        c01812.I$0 = i;
                        c01812.J$0 = j;
                        c01812.Z$0 = z;
                        c01812.I$1 = i2;
                        c01812.I$2 = i14;
                        c01812.label = 1;
                        if (deferredM120setTorchAsyncOup_wC0$camera_camera2$default.join(c01812) != coroutine_suspended) {
                            i5 = i2;
                            capturePipelineImpl = this;
                            i6 = i14;
                            z4 = z;
                            list3 = list;
                            j3 = j;
                            i7 = i;
                            j2 = j3;
                            Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Setting torch done");
                            }
                            if (!z4) {
                                Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture");
                                }
                                CameraGraph graph = this.useCaseGraphContext.getGraph();
                                c01812.L$0 = capturePipelineImpl;
                                c01812.L$1 = list3;
                                c01812.L$2 = mainCaptureParams2;
                                c01812.I$0 = i7;
                                c01812.J$0 = j2;
                                c01812.Z$0 = z4;
                                c01812.I$1 = i5;
                                c01812.I$2 = i6;
                                c01812.label = 2;
                                objAcquireSession = graph.acquireSession(c01812);
                                if (objAcquireSession != coroutine_suspended) {
                                    j4 = j2;
                                    i4 = i6;
                                    objAwait = objAcquireSession;
                                    i10 = i5;
                                    mainCaptureParams4 = mainCaptureParams2;
                                    i11 = i7;
                                    long j5 = j4;
                                    list5 = list3;
                                    capturePipelineImpl3 = capturePipelineImpl;
                                    autoCloseable = (AutoCloseable) objAwait;
                                    try {
                                        CameraGraph.Session session = (CameraGraph.Session) autoCloseable;
                                        if (i11 == 0) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        if (i11 == 0) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        c01812.L$0 = capturePipelineImpl3;
                                        c01812.L$1 = list5;
                                        c01812.L$2 = mainCaptureParams4;
                                        c01812.L$3 = autoCloseable;
                                        c01812.I$0 = i11;
                                        c01812.Z$0 = z4;
                                        c01812.I$1 = i10;
                                        c01812.I$2 = i4;
                                        c01812.label = 3;
                                        z8 = z4;
                                        mainCaptureParams5 = mainCaptureParams4;
                                        z2 = true;
                                        objLock3AForCapture$default = CameraGraph.Session.lock3AForCapture$default(session, z6, z7, 0, j5, c01812, 4, null);
                                        if (objLock3AForCapture$default != coroutine_suspended) {
                                            autoCloseable3 = autoCloseable;
                                            objAwait = objLock3AForCapture$default;
                                            i12 = i11;
                                            list6 = list5;
                                            capturePipelineImpl4 = capturePipelineImpl3;
                                            mainCaptureParams6 = mainCaptureParams5;
                                            z9 = z8;
                                            c01812.L$0 = capturePipelineImpl4;
                                            c01812.L$1 = list6;
                                            c01812.L$2 = mainCaptureParams6;
                                            c01812.L$3 = autoCloseable3;
                                            c01812.I$0 = i12;
                                            c01812.Z$0 = z9;
                                            c01812.I$1 = i10;
                                            c01812.I$2 = i4;
                                            c01812.label = 4;
                                            objAwait = ((Deferred) objAwait).await(c01812);
                                            if (objAwait != coroutine_suspended) {
                                                z5 = z9;
                                                i8 = i12;
                                                autoCloseable2 = autoCloseable3;
                                                mainCaptureParams2 = mainCaptureParams6;
                                                list2 = list6;
                                                capturePipelineImpl5 = capturePipelineImpl4;
                                                result3A = (Result3A) objAwait;
                                                AutoCloseableKt.closeFinally(autoCloseable2, null);
                                                Camera2Logger camera2Logger7 = Camera2Logger.INSTANCE;
                                                if (Logger.isDebugEnabled(Log.TAG)) {
                                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture done, result3A = " + result3A);
                                                }
                                                i2 = i10;
                                                capturePipelineImpl = capturePipelineImpl5;
                                                Camera2Logger camera2Logger8 = Camera2Logger.INSTANCE;
                                                if (Logger.isDebugEnabled(Log.TAG)) {
                                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                                                }
                                                i3 = i8;
                                                z3 = z5;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        autoCloseable2 = autoCloseable;
                                        try {
                                            throw th;
                                        } catch (Throwable th3) {
                                            AutoCloseableKt.closeFinally(autoCloseable2, th);
                                            throw th3;
                                        }
                                    }
                                }
                            } else {
                                z2 = true;
                                if (i6 == 0) {
                                    i4 = i6;
                                    z5 = z4;
                                    i2 = i5;
                                    i8 = i7;
                                    list2 = list3;
                                } else if (i7 == 0) {
                                    Camera2Logger camera2Logger9 = Camera2Logger.INSTANCE;
                                    if (Logger.isDebugEnabled(Log.TAG)) {
                                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A");
                                    }
                                    c01812.L$0 = capturePipelineImpl;
                                    c01812.L$1 = list3;
                                    c01812.L$2 = mainCaptureParams2;
                                    c01812.I$0 = i7;
                                    c01812.Z$0 = z4;
                                    c01812.I$1 = i5;
                                    c01812.I$2 = i6;
                                    c01812.label = 5;
                                    if (lockAf(j2, true, c01812) != coroutine_suspended) {
                                        i4 = i6;
                                        z5 = z4;
                                        i9 = i5;
                                        mainCaptureParams3 = mainCaptureParams2;
                                        i8 = i7;
                                        list4 = list3;
                                        capturePipelineImpl2 = capturePipelineImpl;
                                        Camera2Logger camera2Logger10 = Camera2Logger.INSTANCE;
                                        if (Logger.isDebugEnabled(Log.TAG)) {
                                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A done");
                                        }
                                        i2 = i9;
                                        capturePipelineImpl = capturePipelineImpl2;
                                        list2 = list4;
                                        mainCaptureParams2 = mainCaptureParams3;
                                    }
                                } else {
                                    Camera2Logger camera2Logger11 = Camera2Logger.INSTANCE;
                                    if (Logger.isDebugEnabled(Log.TAG)) {
                                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Awaiting 3A convergence");
                                    }
                                    function1 = new Function1<FrameInfo, Boolean>() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$torchApplyCapture$3$8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Boolean invoke(FrameInfo it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return Boolean.valueOf(ConvergenceUtils.is3AConverged(this.this$0.toCameraCaptureResult(it.getMetadata()), true));
                                        }
                                    };
                                    c01812.L$0 = capturePipelineImpl;
                                    c01812.L$1 = list3;
                                    c01812.L$2 = mainCaptureParams2;
                                    c01812.I$0 = i7;
                                    c01812.Z$0 = z4;
                                    c01812.I$1 = i5;
                                    c01812.I$2 = i6;
                                    c01812.label = 6;
                                    if (waitForResult(j2, function1, c01812) != coroutine_suspended) {
                                        i4 = i6;
                                        z5 = z4;
                                        i9 = i5;
                                        mainCaptureParams3 = mainCaptureParams2;
                                        i8 = i7;
                                        list4 = list3;
                                        capturePipelineImpl2 = capturePipelineImpl;
                                        Camera2Logger camera2Logger12 = Camera2Logger.INSTANCE;
                                        if (Logger.isDebugEnabled(Log.TAG)) {
                                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: 3A convergence waiting done");
                                        }
                                        i2 = i9;
                                        capturePipelineImpl = capturePipelineImpl2;
                                        list2 = list4;
                                        mainCaptureParams2 = mainCaptureParams3;
                                    }
                                }
                                Camera2Logger camera2Logger13 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                                }
                                i3 = i8;
                                z3 = z5;
                            }
                        }
                    } else {
                        mainCaptureParams2 = mainCaptureParams;
                        i5 = i2;
                        capturePipelineImpl = this;
                        i6 = i14;
                        z4 = z;
                        list3 = list;
                        i7 = i;
                        j2 = j;
                        if (!z4) {
                            Camera2Logger camera2Logger14 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture");
                            }
                            CameraGraph graph2 = this.useCaseGraphContext.getGraph();
                            c01812.L$0 = capturePipelineImpl;
                            c01812.L$1 = list3;
                            c01812.L$2 = mainCaptureParams2;
                            c01812.I$0 = i7;
                            c01812.J$0 = j2;
                            c01812.Z$0 = z4;
                            c01812.I$1 = i5;
                            c01812.I$2 = i6;
                            c01812.label = 2;
                            objAcquireSession = graph2.acquireSession(c01812);
                            if (objAcquireSession != coroutine_suspended) {
                                j4 = j2;
                                i4 = i6;
                                objAwait = objAcquireSession;
                                i10 = i5;
                                mainCaptureParams4 = mainCaptureParams2;
                                i11 = i7;
                                long j6 = j4;
                                list5 = list3;
                                capturePipelineImpl3 = capturePipelineImpl;
                                autoCloseable = (AutoCloseable) objAwait;
                                CameraGraph.Session session2 = (CameraGraph.Session) autoCloseable;
                                if (i11 == 0) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (i11 == 0) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                c01812.L$0 = capturePipelineImpl3;
                                c01812.L$1 = list5;
                                c01812.L$2 = mainCaptureParams4;
                                c01812.L$3 = autoCloseable;
                                c01812.I$0 = i11;
                                c01812.Z$0 = z4;
                                c01812.I$1 = i10;
                                c01812.I$2 = i4;
                                c01812.label = 3;
                                z8 = z4;
                                mainCaptureParams5 = mainCaptureParams4;
                                z2 = true;
                                objLock3AForCapture$default = CameraGraph.Session.lock3AForCapture$default(session2, z6, z7, 0, j6, c01812, 4, null);
                                if (objLock3AForCapture$default != coroutine_suspended) {
                                    autoCloseable3 = autoCloseable;
                                    objAwait = objLock3AForCapture$default;
                                    i12 = i11;
                                    list6 = list5;
                                    capturePipelineImpl4 = capturePipelineImpl3;
                                    mainCaptureParams6 = mainCaptureParams5;
                                    z9 = z8;
                                    c01812.L$0 = capturePipelineImpl4;
                                    c01812.L$1 = list6;
                                    c01812.L$2 = mainCaptureParams6;
                                    c01812.L$3 = autoCloseable3;
                                    c01812.I$0 = i12;
                                    c01812.Z$0 = z9;
                                    c01812.I$1 = i10;
                                    c01812.I$2 = i4;
                                    c01812.label = 4;
                                    objAwait = ((Deferred) objAwait).await(c01812);
                                    if (objAwait != coroutine_suspended) {
                                        z5 = z9;
                                        i8 = i12;
                                        autoCloseable2 = autoCloseable3;
                                        mainCaptureParams2 = mainCaptureParams6;
                                        list2 = list6;
                                        capturePipelineImpl5 = capturePipelineImpl4;
                                        result3A = (Result3A) objAwait;
                                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                                        Camera2Logger camera2Logger15 = Camera2Logger.INSTANCE;
                                        if (Logger.isDebugEnabled(Log.TAG)) {
                                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture done, result3A = " + result3A);
                                        }
                                        i2 = i10;
                                        capturePipelineImpl = capturePipelineImpl5;
                                        Camera2Logger camera2Logger16 = Camera2Logger.INSTANCE;
                                        if (Logger.isDebugEnabled(Log.TAG)) {
                                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                                        }
                                        i3 = i8;
                                        z3 = z5;
                                    }
                                }
                            }
                        } else {
                            z2 = true;
                            if (i6 == 0) {
                                i4 = i6;
                                z5 = z4;
                                i2 = i5;
                                i8 = i7;
                                list2 = list3;
                            } else if (i7 == 0) {
                                Camera2Logger camera2Logger17 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A");
                                }
                                c01812.L$0 = capturePipelineImpl;
                                c01812.L$1 = list3;
                                c01812.L$2 = mainCaptureParams2;
                                c01812.I$0 = i7;
                                c01812.Z$0 = z4;
                                c01812.I$1 = i5;
                                c01812.I$2 = i6;
                                c01812.label = 5;
                                if (lockAf(j2, true, c01812) != coroutine_suspended) {
                                    i4 = i6;
                                    z5 = z4;
                                    i9 = i5;
                                    mainCaptureParams3 = mainCaptureParams2;
                                    i8 = i7;
                                    list4 = list3;
                                    capturePipelineImpl2 = capturePipelineImpl;
                                    Camera2Logger camera2Logger18 = Camera2Logger.INSTANCE;
                                    if (Logger.isDebugEnabled(Log.TAG)) {
                                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A done");
                                    }
                                    i2 = i9;
                                    capturePipelineImpl = capturePipelineImpl2;
                                    list2 = list4;
                                    mainCaptureParams2 = mainCaptureParams3;
                                }
                            } else {
                                Camera2Logger camera2Logger19 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Awaiting 3A convergence");
                                }
                                function1 = new Function1<FrameInfo, Boolean>() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$torchApplyCapture$3$8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(FrameInfo it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return Boolean.valueOf(ConvergenceUtils.is3AConverged(this.this$0.toCameraCaptureResult(it.getMetadata()), true));
                                    }
                                };
                                c01812.L$0 = capturePipelineImpl;
                                c01812.L$1 = list3;
                                c01812.L$2 = mainCaptureParams2;
                                c01812.I$0 = i7;
                                c01812.Z$0 = z4;
                                c01812.I$1 = i5;
                                c01812.I$2 = i6;
                                c01812.label = 6;
                                if (waitForResult(j2, function1, c01812) != coroutine_suspended) {
                                    i4 = i6;
                                    z5 = z4;
                                    i9 = i5;
                                    mainCaptureParams3 = mainCaptureParams2;
                                    i8 = i7;
                                    list4 = list3;
                                    capturePipelineImpl2 = capturePipelineImpl;
                                    Camera2Logger camera2Logger110 = Camera2Logger.INSTANCE;
                                    if (Logger.isDebugEnabled(Log.TAG)) {
                                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: 3A convergence waiting done");
                                    }
                                    i2 = i9;
                                    capturePipelineImpl = capturePipelineImpl2;
                                    list2 = list4;
                                    mainCaptureParams2 = mainCaptureParams3;
                                }
                            }
                            Camera2Logger camera2Logger111 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                            }
                            i3 = i8;
                            z3 = z5;
                        }
                    }
                    return coroutine_suspended;
                }
                mainCaptureParams2 = mainCaptureParams;
                z2 = true;
                i3 = i;
                list2 = list;
                capturePipelineImpl = this;
                i4 = i14;
                z3 = z;
                if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                    Camera2Logger camera2Logger20 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                    }
                    if (mainCaptureParams2 != null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                    Camera2Logger camera2Logger21 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                    }
                } else {
                    listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                }
                if (list2.contains(PipelineTask.POST_CAPTURE)) {
                    CoroutineScope sequentialScope = capturePipelineImpl.threads.getSequentialScope();
                    i13 = i4;
                    if (i2 != 0) {
                        z10 = z2;
                    } else {
                        z10 = false;
                    }
                    if (i13 == 0) {
                        z2 = false;
                    }
                    BuildersKt__Builders_commonKt.launch$default(sequentialScope, null, null, new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(listListOf, null, z10, this, z3, z2, i3), 3, null);
                }
                return listListOf;
            case 1:
                int i15 = c01812.I$2;
                int i16 = c01812.I$1;
                z4 = c01812.Z$0;
                long j7 = c01812.J$0;
                i7 = c01812.I$0;
                MainCaptureParams mainCaptureParams7 = (MainCaptureParams) c01812.L$2;
                list3 = (List) c01812.L$1;
                capturePipelineImpl = (CapturePipelineImpl) c01812.L$0;
                ResultKt.throwOnFailure(objAwait);
                i6 = i15;
                j3 = j7;
                i5 = i16;
                mainCaptureParams2 = mainCaptureParams7;
                j2 = j3;
                Camera2Logger camera2Logger22 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Setting torch done");
                }
                if (!z4) {
                    z2 = true;
                    if (i6 == 0) {
                        i4 = i6;
                        z5 = z4;
                        i2 = i5;
                        i8 = i7;
                        list2 = list3;
                    } else if (i7 == 0) {
                        Camera2Logger camera2Logger112 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A");
                        }
                        c01812.L$0 = capturePipelineImpl;
                        c01812.L$1 = list3;
                        c01812.L$2 = mainCaptureParams2;
                        c01812.I$0 = i7;
                        c01812.Z$0 = z4;
                        c01812.I$1 = i5;
                        c01812.I$2 = i6;
                        c01812.label = 5;
                        if (lockAf(j2, true, c01812) != coroutine_suspended) {
                            i4 = i6;
                            z5 = z4;
                            i9 = i5;
                            mainCaptureParams3 = mainCaptureParams2;
                            i8 = i7;
                            list4 = list3;
                            capturePipelineImpl2 = capturePipelineImpl;
                            Camera2Logger camera2Logger113 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A done");
                            }
                            i2 = i9;
                            capturePipelineImpl = capturePipelineImpl2;
                            list2 = list4;
                            mainCaptureParams2 = mainCaptureParams3;
                        }
                    } else {
                        Camera2Logger camera2Logger114 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Awaiting 3A convergence");
                        }
                        function1 = new Function1<FrameInfo, Boolean>() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$torchApplyCapture$3$8
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(FrameInfo it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return Boolean.valueOf(ConvergenceUtils.is3AConverged(this.this$0.toCameraCaptureResult(it.getMetadata()), true));
                            }
                        };
                        c01812.L$0 = capturePipelineImpl;
                        c01812.L$1 = list3;
                        c01812.L$2 = mainCaptureParams2;
                        c01812.I$0 = i7;
                        c01812.Z$0 = z4;
                        c01812.I$1 = i5;
                        c01812.I$2 = i6;
                        c01812.label = 6;
                        if (waitForResult(j2, function1, c01812) != coroutine_suspended) {
                            i4 = i6;
                            z5 = z4;
                            i9 = i5;
                            mainCaptureParams3 = mainCaptureParams2;
                            i8 = i7;
                            list4 = list3;
                            capturePipelineImpl2 = capturePipelineImpl;
                            Camera2Logger camera2Logger115 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: 3A convergence waiting done");
                            }
                            i2 = i9;
                            capturePipelineImpl = capturePipelineImpl2;
                            list2 = list4;
                            mainCaptureParams2 = mainCaptureParams3;
                        }
                    }
                    Camera2Logger camera2Logger116 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                    }
                    i3 = i8;
                    z3 = z5;
                    if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                        Camera2Logger camera2Logger23 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                        }
                        if (mainCaptureParams2 != null) {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                        Camera2Logger camera2Logger24 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                        }
                    } else {
                        listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                    }
                    if (list2.contains(PipelineTask.POST_CAPTURE)) {
                        CoroutineScope sequentialScope2 = capturePipelineImpl.threads.getSequentialScope();
                        i13 = i4;
                        if (i2 != 0) {
                            z10 = z2;
                        } else {
                            z10 = false;
                        }
                        if (i13 == 0) {
                            z2 = false;
                        }
                        BuildersKt__Builders_commonKt.launch$default(sequentialScope2, null, null, new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(listListOf, null, z10, this, z3, z2, i3), 3, null);
                    }
                    return listListOf;
                }
                Camera2Logger camera2Logger117 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture");
                }
                CameraGraph graph3 = this.useCaseGraphContext.getGraph();
                c01812.L$0 = capturePipelineImpl;
                c01812.L$1 = list3;
                c01812.L$2 = mainCaptureParams2;
                c01812.I$0 = i7;
                c01812.J$0 = j2;
                c01812.Z$0 = z4;
                c01812.I$1 = i5;
                c01812.I$2 = i6;
                c01812.label = 2;
                objAcquireSession = graph3.acquireSession(c01812);
                if (objAcquireSession != coroutine_suspended) {
                    j4 = j2;
                    i4 = i6;
                    objAwait = objAcquireSession;
                    i10 = i5;
                    mainCaptureParams4 = mainCaptureParams2;
                    i11 = i7;
                    long j8 = j4;
                    list5 = list3;
                    capturePipelineImpl3 = capturePipelineImpl;
                    autoCloseable = (AutoCloseable) objAwait;
                    CameraGraph.Session session3 = (CameraGraph.Session) autoCloseable;
                    if (i11 == 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (i11 == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    c01812.L$0 = capturePipelineImpl3;
                    c01812.L$1 = list5;
                    c01812.L$2 = mainCaptureParams4;
                    c01812.L$3 = autoCloseable;
                    c01812.I$0 = i11;
                    c01812.Z$0 = z4;
                    c01812.I$1 = i10;
                    c01812.I$2 = i4;
                    c01812.label = 3;
                    z8 = z4;
                    mainCaptureParams5 = mainCaptureParams4;
                    z2 = true;
                    objLock3AForCapture$default = CameraGraph.Session.lock3AForCapture$default(session3, z6, z7, 0, j8, c01812, 4, null);
                    if (objLock3AForCapture$default != coroutine_suspended) {
                        autoCloseable3 = autoCloseable;
                        objAwait = objLock3AForCapture$default;
                        i12 = i11;
                        list6 = list5;
                        capturePipelineImpl4 = capturePipelineImpl3;
                        mainCaptureParams6 = mainCaptureParams5;
                        z9 = z8;
                        c01812.L$0 = capturePipelineImpl4;
                        c01812.L$1 = list6;
                        c01812.L$2 = mainCaptureParams6;
                        c01812.L$3 = autoCloseable3;
                        c01812.I$0 = i12;
                        c01812.Z$0 = z9;
                        c01812.I$1 = i10;
                        c01812.I$2 = i4;
                        c01812.label = 4;
                        objAwait = ((Deferred) objAwait).await(c01812);
                        if (objAwait != coroutine_suspended) {
                            z5 = z9;
                            i8 = i12;
                            autoCloseable2 = autoCloseable3;
                            mainCaptureParams2 = mainCaptureParams6;
                            list2 = list6;
                            capturePipelineImpl5 = capturePipelineImpl4;
                            result3A = (Result3A) objAwait;
                            AutoCloseableKt.closeFinally(autoCloseable2, null);
                            Camera2Logger camera2Logger118 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture done, result3A = " + result3A);
                            }
                            i2 = i10;
                            capturePipelineImpl = capturePipelineImpl5;
                            Camera2Logger camera2Logger119 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                            }
                            i3 = i8;
                            z3 = z5;
                            if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                                Camera2Logger camera2Logger25 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                                }
                                if (mainCaptureParams2 != null) {
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                                Camera2Logger camera2Logger26 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                                }
                            } else {
                                listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                            }
                            if (list2.contains(PipelineTask.POST_CAPTURE)) {
                                CoroutineScope sequentialScope3 = capturePipelineImpl.threads.getSequentialScope();
                                i13 = i4;
                                if (i2 != 0) {
                                    z10 = z2;
                                } else {
                                    z10 = false;
                                }
                                if (i13 == 0) {
                                    z2 = false;
                                }
                                BuildersKt__Builders_commonKt.launch$default(sequentialScope3, null, null, new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(listListOf, null, z10, this, z3, z2, i3), 3, null);
                            }
                            return listListOf;
                        }
                    }
                }
                return coroutine_suspended;
            case 2:
                i4 = c01812.I$2;
                i10 = c01812.I$1;
                z4 = c01812.Z$0;
                long j9 = c01812.J$0;
                i7 = c01812.I$0;
                MainCaptureParams mainCaptureParams8 = (MainCaptureParams) c01812.L$2;
                list3 = (List) c01812.L$1;
                capturePipelineImpl = (CapturePipelineImpl) c01812.L$0;
                ResultKt.throwOnFailure(objAwait);
                j4 = j9;
                mainCaptureParams4 = mainCaptureParams8;
                i11 = i7;
                long j10 = j4;
                list5 = list3;
                capturePipelineImpl3 = capturePipelineImpl;
                autoCloseable = (AutoCloseable) objAwait;
                CameraGraph.Session session4 = (CameraGraph.Session) autoCloseable;
                if (i11 == 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (i11 == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                c01812.L$0 = capturePipelineImpl3;
                c01812.L$1 = list5;
                c01812.L$2 = mainCaptureParams4;
                c01812.L$3 = autoCloseable;
                c01812.I$0 = i11;
                c01812.Z$0 = z4;
                c01812.I$1 = i10;
                c01812.I$2 = i4;
                c01812.label = 3;
                z8 = z4;
                mainCaptureParams5 = mainCaptureParams4;
                z2 = true;
                objLock3AForCapture$default = CameraGraph.Session.lock3AForCapture$default(session4, z6, z7, 0, j10, c01812, 4, null);
                if (objLock3AForCapture$default != coroutine_suspended) {
                    autoCloseable3 = autoCloseable;
                    objAwait = objLock3AForCapture$default;
                    i12 = i11;
                    list6 = list5;
                    capturePipelineImpl4 = capturePipelineImpl3;
                    mainCaptureParams6 = mainCaptureParams5;
                    z9 = z8;
                    c01812.L$0 = capturePipelineImpl4;
                    c01812.L$1 = list6;
                    c01812.L$2 = mainCaptureParams6;
                    c01812.L$3 = autoCloseable3;
                    c01812.I$0 = i12;
                    c01812.Z$0 = z9;
                    c01812.I$1 = i10;
                    c01812.I$2 = i4;
                    c01812.label = 4;
                    objAwait = ((Deferred) objAwait).await(c01812);
                    if (objAwait != coroutine_suspended) {
                        z5 = z9;
                        i8 = i12;
                        autoCloseable2 = autoCloseable3;
                        mainCaptureParams2 = mainCaptureParams6;
                        list2 = list6;
                        capturePipelineImpl5 = capturePipelineImpl4;
                        result3A = (Result3A) objAwait;
                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                        Camera2Logger camera2Logger1110 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture done, result3A = " + result3A);
                        }
                        i2 = i10;
                        capturePipelineImpl = capturePipelineImpl5;
                        Camera2Logger camera2Logger1111 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                        }
                        i3 = i8;
                        z3 = z5;
                        if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                            Camera2Logger camera2Logger27 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                            }
                            if (mainCaptureParams2 != null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                            Camera2Logger camera2Logger28 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                            }
                        } else {
                            listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                        }
                        if (list2.contains(PipelineTask.POST_CAPTURE)) {
                            CoroutineScope sequentialScope4 = capturePipelineImpl.threads.getSequentialScope();
                            i13 = i4;
                            if (i2 != 0) {
                                z10 = z2;
                            } else {
                                z10 = false;
                            }
                            if (i13 == 0) {
                                z2 = false;
                            }
                            BuildersKt__Builders_commonKt.launch$default(sequentialScope4, null, null, new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(listListOf, null, z10, this, z3, z2, i3), 3, null);
                        }
                        return listListOf;
                    }
                }
                return coroutine_suspended;
            case 3:
                i4 = c01812.I$2;
                i10 = c01812.I$1;
                z9 = c01812.Z$0;
                i12 = c01812.I$0;
                autoCloseable3 = (AutoCloseable) c01812.L$3;
                mainCaptureParams6 = (MainCaptureParams) c01812.L$2;
                list6 = (List) c01812.L$1;
                capturePipelineImpl4 = (CapturePipelineImpl) c01812.L$0;
                try {
                    ResultKt.throwOnFailure(objAwait);
                    z2 = true;
                    c01812.L$0 = capturePipelineImpl4;
                    c01812.L$1 = list6;
                    c01812.L$2 = mainCaptureParams6;
                    c01812.L$3 = autoCloseable3;
                    c01812.I$0 = i12;
                    c01812.Z$0 = z9;
                    c01812.I$1 = i10;
                    c01812.I$2 = i4;
                    c01812.label = 4;
                    objAwait = ((Deferred) objAwait).await(c01812);
                    if (objAwait != coroutine_suspended) {
                        z5 = z9;
                        i8 = i12;
                        autoCloseable2 = autoCloseable3;
                        mainCaptureParams2 = mainCaptureParams6;
                        list2 = list6;
                        capturePipelineImpl5 = capturePipelineImpl4;
                        result3A = (Result3A) objAwait;
                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                        Camera2Logger camera2Logger1112 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture done, result3A = " + result3A);
                        }
                        i2 = i10;
                        capturePipelineImpl = capturePipelineImpl5;
                        Camera2Logger camera2Logger1113 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                        }
                        i3 = i8;
                        z3 = z5;
                        if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                            Camera2Logger camera2Logger29 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                            }
                            if (mainCaptureParams2 != null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                            Camera2Logger camera2Logger210 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                            }
                        } else {
                            listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                        }
                        if (list2.contains(PipelineTask.POST_CAPTURE)) {
                            CoroutineScope sequentialScope5 = capturePipelineImpl.threads.getSequentialScope();
                            i13 = i4;
                            if (i2 != 0) {
                                z10 = z2;
                            } else {
                                z10 = false;
                            }
                            if (i13 == 0) {
                                z2 = false;
                            }
                            BuildersKt__Builders_commonKt.launch$default(sequentialScope5, null, null, new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(listListOf, null, z10, this, z3, z2, i3), 3, null);
                        }
                        return listListOf;
                    }
                    return coroutine_suspended;
                } catch (Throwable th4) {
                    th = th4;
                    autoCloseable2 = autoCloseable3;
                    throw th;
                }
            case 4:
                i4 = c01812.I$2;
                i10 = c01812.I$1;
                z5 = c01812.Z$0;
                i8 = c01812.I$0;
                autoCloseable2 = (AutoCloseable) c01812.L$3;
                mainCaptureParams2 = (MainCaptureParams) c01812.L$2;
                list2 = (List) c01812.L$1;
                capturePipelineImpl5 = (CapturePipelineImpl) c01812.L$0;
                try {
                    ResultKt.throwOnFailure(objAwait);
                    z2 = true;
                    result3A = (Result3A) objAwait;
                    AutoCloseableKt.closeFinally(autoCloseable2, null);
                    Camera2Logger camera2Logger1114 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A for capture done, result3A = " + result3A);
                    }
                    i2 = i10;
                    capturePipelineImpl = capturePipelineImpl5;
                    Camera2Logger camera2Logger1115 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                    }
                    i3 = i8;
                    z3 = z5;
                    if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                        Camera2Logger camera2Logger211 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                        }
                        if (mainCaptureParams2 != null) {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                        Camera2Logger camera2Logger212 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                        }
                    } else {
                        listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                    }
                    if (list2.contains(PipelineTask.POST_CAPTURE)) {
                        CoroutineScope sequentialScope6 = capturePipelineImpl.threads.getSequentialScope();
                        i13 = i4;
                        if (i2 != 0) {
                            z10 = z2;
                        } else {
                            z10 = false;
                        }
                        if (i13 == 0) {
                            z2 = false;
                        }
                        BuildersKt__Builders_commonKt.launch$default(sequentialScope6, null, null, new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(listListOf, null, z10, this, z3, z2, i3), 3, null);
                    }
                    return listListOf;
                } catch (Throwable th5) {
                    th = th5;
                    throw th;
                }
            case 5:
                i4 = c01812.I$2;
                i9 = c01812.I$1;
                z5 = c01812.Z$0;
                i8 = c01812.I$0;
                mainCaptureParams3 = (MainCaptureParams) c01812.L$2;
                list4 = (List) c01812.L$1;
                capturePipelineImpl2 = (CapturePipelineImpl) c01812.L$0;
                ResultKt.throwOnFailure(objAwait);
                z2 = true;
                Camera2Logger camera2Logger1116 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: Locking 3A done");
                }
                i2 = i9;
                capturePipelineImpl = capturePipelineImpl2;
                list2 = list4;
                mainCaptureParams2 = mainCaptureParams3;
                Camera2Logger camera2Logger1117 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                }
                i3 = i8;
                z3 = z5;
                if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                    Camera2Logger camera2Logger213 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                    }
                    if (mainCaptureParams2 != null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                    Camera2Logger camera2Logger214 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                    }
                } else {
                    listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                }
                if (list2.contains(PipelineTask.POST_CAPTURE)) {
                    CoroutineScope sequentialScope7 = capturePipelineImpl.threads.getSequentialScope();
                    i13 = i4;
                    if (i2 != 0) {
                        z10 = z2;
                    } else {
                        z10 = false;
                    }
                    if (i13 == 0) {
                        z2 = false;
                    }
                    BuildersKt__Builders_commonKt.launch$default(sequentialScope7, null, null, new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(listListOf, null, z10, this, z3, z2, i3), 3, null);
                }
                return listListOf;
            case 6:
                i4 = c01812.I$2;
                i9 = c01812.I$1;
                z5 = c01812.Z$0;
                i8 = c01812.I$0;
                mainCaptureParams3 = (MainCaptureParams) c01812.L$2;
                list4 = (List) c01812.L$1;
                capturePipelineImpl2 = (CapturePipelineImpl) c01812.L$0;
                ResultKt.throwOnFailure(objAwait);
                z2 = true;
                Camera2Logger camera2Logger1118 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#torchApplyCapture: 3A convergence waiting done");
                }
                i2 = i9;
                capturePipelineImpl = capturePipelineImpl2;
                list2 = list4;
                mainCaptureParams2 = mainCaptureParams3;
                Camera2Logger camera2Logger1119 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                }
                i3 = i8;
                z3 = z5;
                if (list2.contains(PipelineTask.MAIN_CAPTURE)) {
                    Camera2Logger camera2Logger215 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                    }
                    if (mainCaptureParams2 != null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                    Camera2Logger camera2Logger216 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                    }
                } else {
                    listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                }
                if (list2.contains(PipelineTask.POST_CAPTURE)) {
                    CoroutineScope sequentialScope8 = capturePipelineImpl.threads.getSequentialScope();
                    i13 = i4;
                    if (i2 != 0) {
                        z10 = z2;
                    } else {
                        z10 = false;
                    }
                    if (i13 == 0) {
                        z2 = false;
                    }
                    BuildersKt__Builders_commonKt.launch$default(sequentialScope8, null, null, new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(listListOf, null, z10, this, z3, z2, i3), 3, null);
                }
                return listListOf;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0210  */
    /* JADX WARN: Code duplicated, block: B:66:0x0180  */
    /* JADX WARN: Code duplicated, block: B:69:0x018c A[Catch: all -> 0x004c, TryCatch #4 {all -> 0x004c, blocks: (B:14:0x0047, B:67:0x0184, B:69:0x018c, B:70:0x0195), top: B:110:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:89:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:91:0x01db  */
    /* JADX WARN: Code duplicated, block: B:93:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:95:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ff  */
    public final Object aePreCaptureApplyCapture(MainCaptureParams mainCaptureParams, long j, int i, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        AnonymousClass1 anonymousClass1;
        MainCaptureParams mainCaptureParams2;
        int i2;
        CapturePipelineImpl capturePipelineImpl;
        List<? extends PipelineTask> list2;
        MainCaptureParams mainCaptureParams3;
        Object obj;
        int i3;
        long j2;
        CapturePipelineImpl capturePipelineImpl2;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2;
        CameraGraph.Session session;
        Throwable th;
        AutoCloseable autoCloseable3;
        boolean z;
        CapturePipelineImpl capturePipelineImpl3;
        List<? extends PipelineTask> list3;
        boolean z2;
        MainCaptureParams mainCaptureParams4;
        int i4;
        List<? extends PipelineTask> list4;
        List<? extends PipelineTask> list5;
        Continuation continuation2;
        List<Deferred<Void>> listListOf;
        List<? extends PipelineTask> list6 = list;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj2 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = anonymousClass2.label;
        try {
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture");
                    }
                    Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list6);
                    }
                    if (list6.contains(PipelineTask.PRE_CAPTURE)) {
                        Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
                        }
                        Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture: Acquiring session for locking 3A");
                        }
                        CameraGraph graph = this.useCaseGraphContext.getGraph();
                        anonymousClass2.L$0 = this;
                        anonymousClass2.L$1 = list6;
                        anonymousClass2.L$2 = mainCaptureParams;
                        anonymousClass2.J$0 = j;
                        anonymousClass2.I$0 = i;
                        anonymousClass2.label = 1;
                        Object objAcquireSession = graph.acquireSession(anonymousClass2);
                        if (objAcquireSession != coroutine_suspended) {
                            list2 = list6;
                            mainCaptureParams3 = mainCaptureParams;
                            obj = objAcquireSession;
                            i3 = i;
                            j2 = j;
                            capturePipelineImpl2 = this;
                        }
                        return coroutine_suspended;
                    }
                    mainCaptureParams2 = mainCaptureParams;
                    i2 = i;
                    capturePipelineImpl = this;
                    if (list6.contains(PipelineTask.MAIN_CAPTURE)) {
                        Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                        }
                        if (mainCaptureParams2 != null) {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                        List<Deferred<Void>> listSubmitRequestInternal = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                        Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                        }
                        listListOf = listSubmitRequestInternal;
                        continuation2 = null;
                    } else {
                        continuation2 = null;
                        listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                    }
                    if (list6.contains(PipelineTask.POST_CAPTURE)) {
                        BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1(listListOf, continuation2, this, i2), 3, null);
                    }
                    return listListOf;
                }
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i4 = anonymousClass2.I$0;
                        autoCloseable3 = (AutoCloseable) anonymousClass2.L$3;
                        mainCaptureParams2 = (MainCaptureParams) anonymousClass2.L$2;
                        list5 = (List) anonymousClass2.L$1;
                        capturePipelineImpl = (CapturePipelineImpl) anonymousClass2.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            Camera2Logger camera2Logger7 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture: Locking 3A for capture done");
                            }
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable3, null);
                            Camera2Logger camera2Logger8 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                            }
                            i2 = i4;
                            list6 = list5;
                            if (list6.contains(PipelineTask.MAIN_CAPTURE)) {
                                Camera2Logger camera2Logger9 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                                }
                                if (mainCaptureParams2 != null) {
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                List<Deferred<Void>> listSubmitRequestInternal2 = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                                Camera2Logger camera2Logger10 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                                }
                                listListOf = listSubmitRequestInternal2;
                                continuation2 = null;
                            } else {
                                continuation2 = null;
                                listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                            }
                            if (list6.contains(PipelineTask.POST_CAPTURE)) {
                                BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1(listListOf, continuation2, this, i2), 3, null);
                            }
                            return listListOf;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                AutoCloseableKt.closeFinally(autoCloseable3, th);
                                throw th3;
                            }
                        }
                    }
                    i4 = anonymousClass2.I$0;
                    AutoCloseable autoCloseable4 = (AutoCloseable) anonymousClass2.L$3;
                    mainCaptureParams4 = (MainCaptureParams) anonymousClass2.L$2;
                    List<? extends PipelineTask> list7 = (List) anonymousClass2.L$1;
                    CapturePipelineImpl capturePipelineImpl4 = (CapturePipelineImpl) anonymousClass2.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        autoCloseable2 = autoCloseable4;
                        list4 = list7;
                        capturePipelineImpl = capturePipelineImpl4;
                        anonymousClass2.L$0 = capturePipelineImpl;
                        anonymousClass2.L$1 = list4;
                        anonymousClass2.L$2 = mainCaptureParams4;
                        anonymousClass2.L$3 = autoCloseable2;
                        anonymousClass2.I$0 = i4;
                        anonymousClass2.label = 3;
                        if (((Deferred) obj2).join(anonymousClass2) != coroutine_suspended) {
                            MainCaptureParams mainCaptureParams5 = mainCaptureParams4;
                            list5 = list4;
                            mainCaptureParams2 = mainCaptureParams5;
                            autoCloseable3 = autoCloseable2;
                            Camera2Logger camera2Logger11 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture: Locking 3A for capture done");
                            }
                            Unit unit2 = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable3, null);
                            Camera2Logger camera2Logger12 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                            }
                            i2 = i4;
                            list6 = list5;
                            if (list6.contains(PipelineTask.MAIN_CAPTURE)) {
                                Camera2Logger camera2Logger13 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                                }
                                if (mainCaptureParams2 != null) {
                                    throw new IllegalStateException("Required value was null.".toString());
                                }
                                List<Deferred<Void>> listSubmitRequestInternal3 = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                                Camera2Logger camera2Logger14 = Camera2Logger.INSTANCE;
                                if (Logger.isDebugEnabled(Log.TAG)) {
                                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                                }
                                listListOf = listSubmitRequestInternal3;
                                continuation2 = null;
                            } else {
                                continuation2 = null;
                                listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                            }
                            if (list6.contains(PipelineTask.POST_CAPTURE)) {
                                BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1(listListOf, continuation2, this, i2), 3, null);
                            }
                            return listListOf;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th4) {
                        th = th4;
                        autoCloseable3 = autoCloseable4;
                        throw th;
                    }
                }
                int i6 = anonymousClass2.I$0;
                long j3 = anonymousClass2.J$0;
                MainCaptureParams mainCaptureParams6 = (MainCaptureParams) anonymousClass2.L$2;
                List<? extends PipelineTask> list8 = (List) anonymousClass2.L$1;
                capturePipelineImpl2 = (CapturePipelineImpl) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj2);
                i3 = i6;
                mainCaptureParams3 = mainCaptureParams6;
                list2 = list8;
                j2 = j3;
                obj = obj2;
                Object objLock3AForCapture$default = CameraGraph.Session.lock3AForCapture$default(session, z2, z, 0, j2, anonymousClass2, 4, null);
                if (objLock3AForCapture$default != coroutine_suspended) {
                    mainCaptureParams4 = mainCaptureParams3;
                    i4 = i3;
                    obj2 = objLock3AForCapture$default;
                    capturePipelineImpl = capturePipelineImpl3;
                    list4 = list3;
                    anonymousClass2.L$0 = capturePipelineImpl;
                    anonymousClass2.L$1 = list4;
                    anonymousClass2.L$2 = mainCaptureParams4;
                    anonymousClass2.L$3 = autoCloseable2;
                    anonymousClass2.I$0 = i4;
                    anonymousClass2.label = 3;
                    if (((Deferred) obj2).join(anonymousClass2) != coroutine_suspended) {
                        MainCaptureParams mainCaptureParams7 = mainCaptureParams4;
                        list5 = list4;
                        mainCaptureParams2 = mainCaptureParams7;
                        autoCloseable3 = autoCloseable2;
                        Camera2Logger camera2Logger15 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture: Locking 3A for capture done");
                        }
                        Unit unit3 = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(autoCloseable3, null);
                        Camera2Logger camera2Logger16 = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
                        }
                        i2 = i4;
                        list6 = list5;
                        if (list6.contains(PipelineTask.MAIN_CAPTURE)) {
                            Camera2Logger camera2Logger17 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                            }
                            if (mainCaptureParams2 != null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            List<Deferred<Void>> listSubmitRequestInternal4 = capturePipelineImpl.submitRequestInternal(mainCaptureParams2);
                            Camera2Logger camera2Logger18 = Camera2Logger.INSTANCE;
                            if (Logger.isDebugEnabled(Log.TAG)) {
                                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                            }
                            listListOf = listSubmitRequestInternal4;
                            continuation2 = null;
                        } else {
                            continuation2 = null;
                            listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
                        }
                        if (list6.contains(PipelineTask.POST_CAPTURE)) {
                            BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1(listListOf, continuation2, this, i2), 3, null);
                        }
                        return listListOf;
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th5) {
                th = th5;
                th = th;
                autoCloseable3 = autoCloseable2;
                throw th;
            }
            session = (CameraGraph.Session) autoCloseable;
            Camera2Logger camera2Logger19 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                try {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#aePreCaptureApplyCapture: Locking 3A for capture");
                } catch (Throwable th6) {
                    th = th6;
                    autoCloseable3 = autoCloseable;
                    throw th;
                }
            }
            boolean z3 = i3 == 0;
            z = i3 == 0;
            anonymousClass2.L$0 = capturePipelineImpl2;
            anonymousClass2.L$1 = list2;
            anonymousClass2.L$2 = mainCaptureParams3;
            anonymousClass2.L$3 = autoCloseable;
            anonymousClass2.I$0 = i3;
            anonymousClass2.label = 2;
            capturePipelineImpl3 = capturePipelineImpl2;
            list3 = list2;
            z2 = z3;
            autoCloseable2 = autoCloseable;
        } catch (Throwable th7) {
            th = th7;
            autoCloseable2 = autoCloseable;
            th = th;
            autoCloseable3 = autoCloseable2;
            throw th;
        }
        autoCloseable = (AutoCloseable) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:47:0x0102  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object screenFlashCapture(MainCaptureParams mainCaptureParams, int i, List<? extends PipelineTask> list, Continuation<? super List<? extends Deferred<Void>>> continuation) {
        C01801 c01801;
        CapturePipelineImpl capturePipelineImpl;
        List<Deferred<Void>> listListOf;
        if (continuation instanceof C01801) {
            c01801 = (C01801) continuation;
            if ((c01801.label & Integer.MIN_VALUE) != 0) {
                c01801.label -= Integer.MIN_VALUE;
            } else {
                c01801 = new C01801(continuation);
            }
        } else {
            c01801 = new C01801(continuation);
        }
        Object obj = c01801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01801.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#screenFlashCapture");
            }
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: tasks = " + list);
            }
            if (list.contains(PipelineTask.PRE_CAPTURE)) {
                Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting PRE_CAPTURE");
                }
                c01801.L$0 = this;
                c01801.L$1 = list;
                c01801.L$2 = mainCaptureParams;
                c01801.I$0 = i;
                c01801.label = 1;
                if (invokeScreenFlashPreCaptureTasks(i, c01801) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                capturePipelineImpl = this;
            } else {
                capturePipelineImpl = this;
            }
            if (list.contains(PipelineTask.MAIN_CAPTURE)) {
                Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
                }
                if (mainCaptureParams != null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams);
                Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
                }
            } else {
                listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
            }
            if (list.contains(PipelineTask.POST_CAPTURE)) {
                BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$screenFlashCapture$$inlined$invoke$1(listListOf, null, this, i), 3, null);
            }
            return listListOf;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = c01801.I$0;
        mainCaptureParams = (MainCaptureParams) c01801.L$2;
        list = (List) c01801.L$1;
        capturePipelineImpl = (CapturePipelineImpl) c01801.L$0;
        ResultKt.throwOnFailure(obj);
        Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: PRE_CAPTURE completed");
        }
        if (list.contains(PipelineTask.MAIN_CAPTURE)) {
            Camera2Logger camera2Logger7 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: starting MAIN_CAPTURE");
            }
            if (mainCaptureParams != null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            listListOf = capturePipelineImpl.submitRequestInternal(mainCaptureParams);
            Camera2Logger camera2Logger8 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#List<PipelineTask>.invoke: MAIN_CAPTURE completed");
            }
        } else {
            listListOf = CollectionsKt.listOf(CompletableDeferredKt.CompletableDeferred((Object) null));
        }
        if (list.contains(PipelineTask.POST_CAPTURE)) {
            BuildersKt__Builders_commonKt.launch$default(capturePipelineImpl.threads.getSequentialScope(), null, null, new CapturePipelineImpl$screenFlashCapture$$inlined$invoke$1(listListOf, null, this, i), 3, null);
        }
        return listListOf;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0092 A[Catch: all -> 0x00e7, TryCatch #1 {all -> 0x00e7, blocks: (B:34:0x0087, B:36:0x0092, B:37:0x009b, B:41:0x00a3), top: B:62:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00be, code lost:
    
        if (r0 == r2) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.camera.camera2.impl.CapturePipelineImpl] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeScreenFlashPreCaptureTasks(int r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl.invokeScreenFlashPreCaptureTasks(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x008f A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:33:0x0084, B:35:0x008f, B:39:0x009c), top: B:55:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009a  */
    /* JADX WARN: Code duplicated, block: B:38:0x009b  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b0 A[Catch: all -> 0x0037, TryCatch #2 {all -> 0x0037, blocks: (B:14:0x0032, B:43:0x00a8, B:45:0x00b0, B:46:0x00b9), top: B:59:0x0032 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invokeScreenFlashPostCaptureTasks(int i, Continuation<? super Unit> continuation) {
        C01751 c01751;
        int i2;
        AutoCloseable autoCloseable;
        Throwable th;
        AutoCloseable autoCloseable2;
        CameraGraph.Session session;
        if (continuation instanceof C01751) {
            c01751 = (C01751) continuation;
            if ((c01751.label & Integer.MIN_VALUE) != 0) {
                c01751.label -= Integer.MIN_VALUE;
            } else {
                c01751 = new C01751(continuation);
            }
        } else {
            c01751 = new C01751(continuation);
        }
        Object objAcquireSession = c01751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c01751.label;
        boolean z = true;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objAcquireSession);
            FlashControl flashControl = this.flashControl;
            c01751.I$0 = i;
            c01751.label = 1;
            if (flashControl.stopScreenFlashCaptureTasks(c01751) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                autoCloseable2 = (AutoCloseable) c01751.L$0;
                try {
                    ResultKt.throwOnFailure(objAcquireSession);
                    Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: Unlocking 3A done");
                    }
                    Unit unit = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(autoCloseable2, null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        AutoCloseableKt.closeFinally(autoCloseable2, th);
                        throw th3;
                    }
                }
            }
            i2 = c01751.I$0;
            ResultKt.throwOnFailure(objAcquireSession);
            autoCloseable = (AutoCloseable) objAcquireSession;
            try {
                session = (CameraGraph.Session) autoCloseable;
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: Unlocking 3A");
                }
                if (i2 == 0) {
                    z = false;
                }
                c01751.L$0 = autoCloseable;
                c01751.label = 3;
                if (session.unlock3APostCapture(z, c01751) != coroutine_suspended) {
                    autoCloseable2 = autoCloseable;
                    Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: Unlocking 3A done");
                    }
                    Unit unit2 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(autoCloseable2, null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th4) {
                th = th4;
                autoCloseable2 = autoCloseable;
                throw th;
            }
        }
        i = c01751.I$0;
        ResultKt.throwOnFailure(objAcquireSession);
        Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: Acquiring session for unlocking 3A");
        }
        CameraGraph graph = this.useCaseGraphContext.getGraph();
        c01751.I$0 = i;
        c01751.label = 2;
        objAcquireSession = graph.acquireSession(c01751);
        if (objAcquireSession != coroutine_suspended) {
            i2 = i;
            autoCloseable = (AutoCloseable) objAcquireSession;
            session = (CameraGraph.Session) autoCloseable;
            Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: Unlocking 3A");
            }
            if (i2 == 0) {
                z = false;
            }
            c01751.L$0 = autoCloseable;
            c01751.label = 3;
            if (session.unlock3APostCapture(z, c01751) != coroutine_suspended) {
                autoCloseable2 = autoCloseable;
                Camera2Logger camera2Logger6 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: Unlocking 3A done");
                }
                Unit unit3 = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(autoCloseable2, null);
                return Unit.INSTANCE;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x00d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object lockAf(long j, boolean z, Continuation<? super Result3A> continuation) {
        C01791 c01791;
        boolean z2;
        long j2;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2;
        int i;
        Object obj;
        C01791 c01792;
        AutoCloseable autoCloseable3;
        Throwable th;
        Object objAwait;
        if (continuation instanceof C01791) {
            c01791 = (C01791) continuation;
            if ((c01791.label & Integer.MIN_VALUE) != 0) {
                c01791.label -= Integer.MIN_VALUE;
            } else {
                c01791 = new C01791(continuation);
            }
        } else {
            c01791 = new C01791(continuation);
        }
        Object objAcquireSession = c01791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01791.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAcquireSession);
                CameraGraph graph = this.useCaseGraphContext.getGraph();
                c01791.J$0 = j;
                z2 = z;
                c01791.Z$0 = z2;
                c01791.label = 1;
                objAcquireSession = graph.acquireSession(c01791);
                if (objAcquireSession == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j2 = j;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(objAcquireSession);
                        return objAcquireSession;
                    }
                    autoCloseable2 = (AutoCloseable) c01791.L$0;
                    try {
                        ResultKt.throwOnFailure(objAcquireSession);
                        obj = coroutine_suspended;
                        autoCloseable3 = autoCloseable2;
                        c01792 = c01791;
                        i = 3;
                        try {
                            Deferred deferred = (Deferred) objAcquireSession;
                            AutoCloseableKt.closeFinally(autoCloseable3, null);
                            c01792.L$0 = null;
                            c01792.label = i;
                            objAwait = deferred.await(c01792);
                            if (objAwait == obj) {
                                return obj;
                            }
                            return objAwait;
                        } catch (Throwable th2) {
                            th = th2;
                            autoCloseable2 = autoCloseable3;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                AutoCloseableKt.closeFinally(autoCloseable2, th);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        throw th;
                    }
                }
                z2 = c01791.Z$0;
                long j3 = c01791.J$0;
                ResultKt.throwOnFailure(objAcquireSession);
                j2 = j3;
            }
            Lock3ABehavior lock3ABehaviorM558boximpl = Lock3ABehavior.m558boximpl(Lock3ABehavior.INSTANCE.m565getAFTER_CURRENT_SCANhRqSH3k());
            Function1<FrameMetadata, Boolean> convergeCondition = getConvergeCondition(z2);
            long j4 = CapturePipelineKt.CHECK_3A_TIMEOUT_IN_NS;
            c01791.L$0 = autoCloseable;
            c01791.label = 2;
            C01791 c01793 = c01791;
            i = 3;
            obj = coroutine_suspended;
            Object objM419lock3AtS25XM$default = CameraGraph.Session.m419lock3AtS25XM$default((CameraGraph.Session) autoCloseable, null, null, null, null, null, null, null, lock3ABehaviorM558boximpl, null, null, convergeCondition, null, 0, j2, j4, c01793, 6719, null);
            c01792 = c01793;
            if (objM419lock3AtS25XM$default == obj) {
                return obj;
            }
            autoCloseable3 = autoCloseable;
            objAcquireSession = objM419lock3AtS25XM$default;
            Deferred deferred2 = (Deferred) objAcquireSession;
            AutoCloseableKt.closeFinally(autoCloseable3, null);
            c01792.L$0 = null;
            c01792.label = i;
            objAwait = deferred2.await(c01792);
            if (objAwait == obj) {
                return obj;
            }
            return objAwait;
        } catch (Throwable th5) {
            th = th5;
            autoCloseable2 = autoCloseable;
            th = th;
            throw th;
        }
        autoCloseable = (AutoCloseable) objAcquireSession;
    }

    private final Function1<FrameMetadata, Boolean> getConvergeCondition(final boolean isTorchAsFlash) {
        return new Function1() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CapturePipelineImpl.getConvergeCondition$lambda$0(this.f$0, isTorchAsFlash, (FrameMetadata) obj));
            }
        };
    }

    static final boolean getConvergeCondition$lambda$0(CapturePipelineImpl capturePipelineImpl, boolean z, FrameMetadata frameMetadata) {
        Intrinsics.checkNotNullParameter(frameMetadata, "frameMetadata");
        return ConvergenceUtils.is3AConverged(capturePipelineImpl.toCameraCaptureResult(frameMetadata), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraCaptureResult toCameraCaptureResult(final FrameMetadata frameMetadata) {
        return new CaptureResultAdapter(this.emptyRequestMetadata, frameMetadata.mo530getFrameNumberUgla2oM(), new FrameInfo(frameMetadata, this) { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$toCameraCaptureResult$frameInfo$1
            private final String camera;
            private final FrameMetadata frameMetadata;
            private final long frameNumber;
            private final FrameMetadata metadata;
            private final RequestMetadata requestMetadata;

            @Override // androidx.camera.camera2.pipe.UnsafeWrapper
            public <T> T unwrapAs(KClass<T> type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return null;
            }

            {
                this.frameMetadata = frameMetadata;
                this.metadata = frameMetadata;
                this.camera = frameMetadata.getCamera();
                this.frameNumber = frameMetadata.mo530getFrameNumberUgla2oM();
                this.requestMetadata = this.emptyRequestMetadata;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            public FrameMetadata getMetadata() {
                return this.metadata;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            /* JADX INFO: renamed from: get-EfqyGwQ, reason: not valid java name */
            public FrameMetadata mo107getEfqyGwQ(String camera) {
                Intrinsics.checkNotNullParameter(camera, "camera");
                return this.frameMetadata;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: not valid java name and from getter */
            public String getCamera() {
                return this.camera;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            /* JADX INFO: renamed from: getFrameNumber-Ugla2oM, reason: not valid java name and from getter */
            public long getFrameNumber() {
                return this.frameNumber;
            }

            @Override // androidx.camera.camera2.pipe.FrameInfo
            public RequestMetadata getRequestMetadata() {
                return this.requestMetadata;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x008f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [androidx.camera.camera2.impl.CapturePipelineImpl] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.AutoCloseable] */
    public final Object unlockAf(long j, Continuation<? super Result3A> continuation) {
        C01831 c01831;
        long j2;
        Object objAwait;
        if (continuation instanceof C01831) {
            c01831 = (C01831) continuation;
            if ((c01831.label & Integer.MIN_VALUE) != 0) {
                c01831.label -= Integer.MIN_VALUE;
            } else {
                c01831 = new C01831(continuation);
            }
        } else {
            c01831 = new C01831(continuation);
        }
        C01831 c01832 = c01831;
        Object objAcquireSession = c01832.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01832.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    j2 = c01832.J$0;
                    ResultKt.throwOnFailure(objAcquireSession);
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(objAcquireSession);
                        return objAcquireSession;
                    }
                    AutoCloseable autoCloseable = (AutoCloseable) c01832.L$0;
                    ResultKt.throwOnFailure(objAcquireSession);
                    this = autoCloseable;
                }
                Deferred deferred = (Deferred) objAcquireSession;
                AutoCloseableKt.closeFinally(this, null);
                c01832.L$0 = null;
                c01832.label = 3;
                objAwait = deferred.await(c01832);
                if (objAwait != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objAwait;
            }
            ResultKt.throwOnFailure(objAcquireSession);
            CameraGraph graph = this.useCaseGraphContext.getGraph();
            j2 = j;
            c01832.J$0 = j2;
            c01832.label = 1;
            objAcquireSession = graph.acquireSession(c01832);
            if (objAcquireSession != coroutine_suspended) {
            }
            return coroutine_suspended;
            long j3 = j2;
            AutoCloseable autoCloseable2 = (AutoCloseable) objAcquireSession;
            Boolean boolBoxBoolean = Boxing.boxBoolean(true);
            c01832.L$0 = autoCloseable2;
            c01832.label = 2;
            objAcquireSession = CameraGraph.Session.unlock3A$default((CameraGraph.Session) autoCloseable2, null, boolBoxBoolean, null, null, 0, j3, c01832, 29, null);
            this = autoCloseable2;
            if (objAcquireSession != coroutine_suspended) {
                Deferred deferred2 = (Deferred) objAcquireSession;
                AutoCloseableKt.closeFinally(this, null);
                c01832.L$0 = null;
                c01832.label = 3;
                objAwait = deferred2.await(c01832);
                if (objAwait != coroutine_suspended) {
                    return objAwait;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(this, th);
                throw th2;
            }
        }
    }

    private final List<Deferred<Void>> submitRequestInternal(MainCaptureParams params) {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#submitRequestInternal; Submitting " + params.getConfigs() + " with CameraPipe");
        }
        ArrayList arrayList = new ArrayList();
        List<CaptureConfig> configs = params.getConfigs();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = configs.iterator();
        while (true) {
            Request requestM47mapToRequestnAberiA = null;
            if (!it.hasNext()) {
                break;
            }
            CaptureConfig captureConfig = (CaptureConfig) it.next();
            final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            arrayList.add(completableDeferredCompletableDeferred$default);
            try {
                requestM47mapToRequestnAberiA = this.configAdapter.m47mapToRequestnAberiA(captureConfig, params.m104getRequestTemplatefGx8uWA(), params.getSessionConfigOptions(), CollectionsKt.listOf(new Request.Listener() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$submitRequestInternal$requests$1$1
                    @Override // androidx.camera.camera2.pipe.Request.Listener
                    public void onAborted(Request request) {
                        Intrinsics.checkNotNullParameter(request, "request");
                        completableDeferredCompletableDeferred$default.completeExceptionally(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", null));
                    }

                    @Override // androidx.camera.camera2.pipe.Request.Listener
                    /* JADX INFO: renamed from: onTotalCaptureResult-CcXjc1I */
                    public void mo51onTotalCaptureResultCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo totalCaptureResult) {
                        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                        Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
                        completableDeferredCompletableDeferred$default.complete(null);
                    }

                    @Override // androidx.camera.camera2.pipe.Request.Listener
                    /* JADX INFO: renamed from: onFailed-CcXjc1I */
                    public void mo50onFailedCcXjc1I(RequestMetadata requestMetadata, long frameNumber, RequestFailure requestFailure) {
                        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                        Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
                        completableDeferredCompletableDeferred$default.completeExceptionally(new ImageCaptureException(2, "Capture request failed with reason " + requestFailure.getReason(), null));
                    }
                }));
            } catch (IllegalStateException e) {
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                IllegalStateException illegalStateException = e;
                if (Logger.isInfoEnabled(Log.TAG)) {
                    android.util.Log.i(Camera2Logger.TRUNCATED_TAG, "CapturePipeline#submitRequestInternal: configAdapter.mapToRequest failed!", illegalStateException);
                }
                completableDeferredCompletableDeferred$default.completeExceptionally(new ImageCaptureException(2, "Capture request failed with reason " + e.getMessage(), illegalStateException));
            }
            if (requestM47mapToRequestnAberiA != null) {
                arrayList2.add(requestM47mapToRequestnAberiA);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return arrayList;
        }
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1(null, this, arrayList, arrayList3), 3, null);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isPhysicalFlashRequired(int i, Continuation<? super Boolean> continuation) {
        C01771 c01771;
        if (continuation instanceof C01771) {
            c01771 = (C01771) continuation;
            if ((c01771.label & Integer.MIN_VALUE) != 0) {
                c01771.label -= Integer.MIN_VALUE;
            } else {
                c01771 = new C01771(continuation);
            }
        } else {
            c01771 = new C01771(continuation);
        }
        Object frameMetadata = c01771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c01771.label;
        boolean z = false;
        if (i2 == 0) {
            ResultKt.throwOnFailure(frameMetadata);
            if (i == 0) {
                c01771.label = 1;
                frameMetadata = getFrameMetadata(c01771);
                if (frameMetadata == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                z = true;
            } else if (i != 2 && i != 3) {
                throw new AssertionError(i);
            }
            return Boxing.boxBoolean(z);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(frameMetadata);
        FrameMetadata frameMetadata2 = (FrameMetadata) frameMetadata;
        if (frameMetadata2 != null) {
            CaptureResult.Key CONTROL_AE_STATE = CaptureResult.CONTROL_AE_STATE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_STATE, "CONTROL_AE_STATE");
            Integer num = (Integer) frameMetadata2.get(CONTROL_AE_STATE);
            if (num != null && num.intValue() == 4) {
                z = true;
            }
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object waitForResult(long j, Function1<? super FrameInfo, Boolean> function1, Continuation<? super FrameInfo> continuation) {
        C01841 c01841;
        ResultListener resultListener;
        if (continuation instanceof C01841) {
            c01841 = (C01841) continuation;
            if ((c01841.label & Integer.MIN_VALUE) != 0) {
                c01841.label -= Integer.MIN_VALUE;
            } else {
                c01841 = new C01841(continuation);
            }
        } else {
            c01841 = new C01841(continuation);
        }
        Object obj = c01841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01841.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ResultListener resultListener2 = new ResultListener(j, function1);
            this.requestListener.addListener(resultListener2, this.threads.getSequentialExecutor());
            BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new CapturePipelineImpl$waitForResult$resultListener$1$1(resultListener2, this, null), 3, null);
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(resultListener2, null);
            c01841.L$0 = resultListener2;
            c01841.label = 1;
            Object objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(j / 1000000, anonymousClass3, c01841);
            if (objWithTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objWithTimeoutOrNull;
            resultListener = resultListener2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            resultListener = (ResultListener) c01841.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((FrameInfo) obj) == null) {
            this.requestListener.removeListener(resultListener);
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object waitForResult$default(CapturePipelineImpl capturePipelineImpl, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: androidx.camera.camera2.impl.CapturePipelineImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(CapturePipelineImpl.waitForResult$lambda$0((FrameInfo) obj2));
                }
            };
        }
        return capturePipelineImpl.waitForResult(j, function1, continuation);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$3, reason: invalid class name */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/camera/camera2/pipe/FrameInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$3", f = "CapturePipeline.kt", i = {}, l = {796}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FrameInfo>, Object> {
        final /* synthetic */ ResultListener $resultListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ResultListener resultListener, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$resultListener = resultListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$resultListener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FrameInfo> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objAwait = this.$resultListener.getResult().await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object isTorchAsFlash(int i, Continuation<? super Boolean> continuation) {
        if (getTemplate() != 3 && i != 1) {
            return this.useTorchAsFlash.shouldUseTorchAsFlash(new C01782(null), continuation);
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.CapturePipelineImpl$isTorchAsFlash$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CapturePipeline.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/camera/camera2/pipe/FrameMetadata;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.CapturePipelineImpl$isTorchAsFlash$2", f = "CapturePipeline.kt", i = {}, l = {808}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C01782 extends SuspendLambda implements Function1<Continuation<? super FrameMetadata>, Object> {
        int label;

        C01782(Continuation<? super C01782> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CapturePipelineImpl.this.new C01782(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super FrameMetadata> continuation) {
            return ((C01782) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object frameMetadata = CapturePipelineImpl.this.getFrameMetadata(this);
            return frameMetadata == coroutine_suspended ? coroutine_suspended : frameMetadata;
        }
    }
}
