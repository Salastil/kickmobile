package androidx.camera.camera2.adapter;

import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.EvCompControl;
import androidx.camera.camera2.impl.FlashControl;
import androidx.camera.camera2.impl.FocusMeteringControl;
import androidx.camera.camera2.impl.LowLightBoostControl;
import androidx.camera.camera2.impl.StillCaptureRequestControl;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.impl.UseCaseCamera;
import androidx.camera.camera2.impl.UseCaseManager;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.camera2.impl.VideoUsageControl;
import androidx.camera.camera2.impl.ZoomControl;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: CameraControlAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001Bq\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*H\u0016J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010,\u001a\u00020-H\u0016J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010/\u001a\u00020*H\u0016J\u0016\u00100\u001a\b\u0012\u0004\u0012\u0002010'2\u0006\u00102\u001a\u000203H\u0016J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u00106\u001a\u000207H\u0016J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u00109\u001a\u000207H\u0016J\b\u0010:\u001a\u00020-H\u0016J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020-H\u0016J\u0012\u0010=\u001a\u00020!2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020-0'2\u0006\u0010A\u001a\u00020-H\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020*H\u0016J\b\u0010D\u001a\u00020*H\u0016J\u0010\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020!H\u0016J4\u0010I\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010(0J0'2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0J2\u0006\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020-H\u0016J\u001e\u0010O\u001a\b\u0012\u0004\u0012\u00020P0'2\u0006\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020-H\u0016J\b\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020!H\u0016J\b\u0010T\u001a\u00020!H\u0016J\b\u0010U\u001a\u00020*H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Landroidx/camera/camera2/adapter/CameraControlAdapter;", "Landroidx/camera/core/impl/CameraControlInternal;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "evCompControl", "Landroidx/camera/camera2/impl/EvCompControl;", "flashControl", "Landroidx/camera/camera2/impl/FlashControl;", "focusMeteringControl", "Landroidx/camera/camera2/impl/FocusMeteringControl;", "stillCaptureRequestControl", "Landroidx/camera/camera2/impl/StillCaptureRequestControl;", "torchControl", "Landroidx/camera/camera2/impl/TorchControl;", "lowLightBoostControl", "Landroidx/camera/camera2/impl/LowLightBoostControl;", "zoomControl", "Landroidx/camera/camera2/impl/ZoomControl;", "zslControl", "Landroidx/camera/camera2/adapter/ZslControl;", "camera2cameraControl", "Landroidx/camera/camera2/interop/Camera2CameraControl;", "useCaseManager", "Landroidx/camera/camera2/impl/UseCaseManager;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "videoUsageControl", "Landroidx/camera/camera2/impl/VideoUsageControl;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;Landroidx/camera/camera2/impl/EvCompControl;Landroidx/camera/camera2/impl/FlashControl;Landroidx/camera/camera2/impl/FocusMeteringControl;Landroidx/camera/camera2/impl/StillCaptureRequestControl;Landroidx/camera/camera2/impl/TorchControl;Landroidx/camera/camera2/impl/LowLightBoostControl;Landroidx/camera/camera2/impl/ZoomControl;Landroidx/camera/camera2/adapter/ZslControl;Landroidx/camera/camera2/interop/Camera2CameraControl;Landroidx/camera/camera2/impl/UseCaseManager;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/impl/VideoUsageControl;)V", "getCamera2cameraControl", "()Landroidx/camera/camera2/interop/Camera2CameraControl;", "addInteropConfig", "", "config", "Landroidx/camera/core/impl/Config;", "clearInteropConfig", "getInteropConfig", "enableTorch", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "torch", "", "setTorchStrengthLevel", "torchStrengthLevel", "", "enableLowLightBoostAsync", "lowLightBoost", "startFocusAndMetering", "Landroidx/camera/core/FocusMeteringResult;", "action", "Landroidx/camera/core/FocusMeteringAction;", "cancelFocusAndMetering", "setZoomRatio", "ratio", "", "setLinearZoom", "linearZoom", "getFlashMode", "setFlashMode", "flashMode", "setScreenFlash", "screenFlash", "Landroidx/camera/core/ImageCapture$ScreenFlash;", "setExposureCompensationIndex", "exposure", "setZslDisabledByUserCaseConfig", "disabled", "isZslDisabledByByUserCaseConfig", "addZslConfig", "sessionConfigBuilder", "Landroidx/camera/core/impl/SessionConfig$Builder;", "clearZslConfig", "submitStillCaptureRequests", "", "captureConfigs", "Landroidx/camera/core/impl/CaptureConfig;", "captureMode", "flashType", "getCameraCapturePipelineAsync", "Landroidx/camera/core/imagecapture/CameraCapturePipeline;", "getSessionConfig", "Landroidx/camera/core/impl/SessionConfig;", "incrementVideoUsage", "decrementVideoUsage", "isInVideoUsage", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraControlAdapter implements CameraControlInternal {
    private final Camera2CameraControl camera2cameraControl;
    private final CameraProperties cameraProperties;
    private final EvCompControl evCompControl;
    private final FlashControl flashControl;
    private final FocusMeteringControl focusMeteringControl;
    private final LowLightBoostControl lowLightBoostControl;
    private final StillCaptureRequestControl stillCaptureRequestControl;
    private final UseCaseThreads threads;
    private final TorchControl torchControl;
    private final UseCaseManager useCaseManager;
    private final VideoUsageControl videoUsageControl;
    private final ZoomControl zoomControl;
    private final ZslControl zslControl;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void cancelFocusAndMetering$lambda$0$0(Result3A result3A) {
        return null;
    }

    @Inject
    public CameraControlAdapter(CameraProperties cameraProperties, EvCompControl evCompControl, FlashControl flashControl, FocusMeteringControl focusMeteringControl, StillCaptureRequestControl stillCaptureRequestControl, TorchControl torchControl, LowLightBoostControl lowLightBoostControl, ZoomControl zoomControl, ZslControl zslControl, Camera2CameraControl camera2cameraControl, UseCaseManager useCaseManager, UseCaseThreads threads, VideoUsageControl videoUsageControl) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(evCompControl, "evCompControl");
        Intrinsics.checkNotNullParameter(flashControl, "flashControl");
        Intrinsics.checkNotNullParameter(focusMeteringControl, "focusMeteringControl");
        Intrinsics.checkNotNullParameter(stillCaptureRequestControl, "stillCaptureRequestControl");
        Intrinsics.checkNotNullParameter(torchControl, "torchControl");
        Intrinsics.checkNotNullParameter(lowLightBoostControl, "lowLightBoostControl");
        Intrinsics.checkNotNullParameter(zoomControl, "zoomControl");
        Intrinsics.checkNotNullParameter(zslControl, "zslControl");
        Intrinsics.checkNotNullParameter(camera2cameraControl, "camera2cameraControl");
        Intrinsics.checkNotNullParameter(useCaseManager, "useCaseManager");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(videoUsageControl, "videoUsageControl");
        this.cameraProperties = cameraProperties;
        this.evCompControl = evCompControl;
        this.flashControl = flashControl;
        this.focusMeteringControl = focusMeteringControl;
        this.stillCaptureRequestControl = stillCaptureRequestControl;
        this.torchControl = torchControl;
        this.lowLightBoostControl = lowLightBoostControl;
        this.zoomControl = zoomControl;
        this.zslControl = zslControl;
        this.camera2cameraControl = camera2cameraControl;
        this.useCaseManager = useCaseManager;
        this.threads = threads;
        this.videoUsageControl = videoUsageControl;
    }

    public final Camera2CameraControl getCamera2cameraControl() {
        return this.camera2cameraControl;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addInteropConfig(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.camera2cameraControl.addCaptureRequestOptions(CaptureRequestOptions.Builder.INSTANCE.from(config).build());
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearInteropConfig() {
        this.camera2cameraControl.clearCaptureRequestOptions();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Config getInteropConfig() {
        return this.camera2cameraControl.getCaptureRequestOptions();
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> enableTorch(boolean torch) {
        Integer value;
        if (CameraMetadata.INSTANCE.getSupportsLowLightBoost(this.cameraProperties.getMetadata()) && ((value = this.lowLightBoostControl.getLowLightBoostStateLiveData().getValue()) == null || value.intValue() != -1)) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Unable to enable/disable torch when low-light boost is on.");
            }
            ListenableFuture<Void> listenableFutureImmediateFailedFuture = Futures.immediateFailedFuture(new IllegalStateException("Torch can not be enabled/disable when low-light boost is on!"));
            Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFailedFuture, "immediateFailedFuture(...)");
            return listenableFutureImmediateFailedFuture;
        }
        ListenableFuture<Void> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(CoroutineAdaptersKt.asVoidListenableFuture(TorchControl.setTorchAsync$default(this.torchControl, torch, false, false, 6, null)));
        Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
        return listenableFutureNonCancellationPropagating;
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> setTorchStrengthLevel(int torchStrengthLevel) {
        ListenableFuture<Void> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(CoroutineAdaptersKt.asVoidListenableFuture(this.torchControl.setTorchStrengthLevelAsync(torchStrengthLevel)));
        Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
        return listenableFutureNonCancellationPropagating;
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> enableLowLightBoostAsync(final boolean lowLightBoost) {
        ListenableFuture<Void> listenableFutureAsVoidListenableFuture;
        if (!CameraMetadata.INSTANCE.getSupportsLowLightBoost(this.cameraProperties.getMetadata())) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Unable to enable/disable low-light boost due to it is not supported.");
            }
            ListenableFuture<Void> listenableFutureImmediateFailedFuture = Futures.immediateFailedFuture(new IllegalStateException("Low-light boost is not supported!"));
            Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFailedFuture, "immediateFailedFuture(...)");
            return listenableFutureImmediateFailedFuture;
        }
        Integer value = this.torchControl.getTorchStateLiveData().getValue();
        if (value != null && value.intValue() == 1) {
            listenableFutureAsVoidListenableFuture = CoroutineAdaptersKt.asVoidListenableFuture(TorchControl.setTorchAsync$default(this.torchControl, false, false, false, 6, null));
        } else {
            CompletableDeferred CompletableDeferred = CompletableDeferredKt.CompletableDeferred(Unit.INSTANCE);
            CompletableDeferred.complete(Unit.INSTANCE);
            listenableFutureAsVoidListenableFuture = CoroutineAdaptersKt.asVoidListenableFuture(CompletableDeferred);
        }
        final Function1 function1 = new Function1() { // from class: androidx.camera.camera2.adapter.CameraControlAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoroutineAdaptersKt.asVoidListenableFuture(LowLightBoostControl.setLowLightBoostAsync$default(this.f$0.lowLightBoostControl, lowLightBoost, false, 2, null));
            }
        };
        ListenableFuture<Void> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(Futures.transformAsync(listenableFutureAsVoidListenableFuture, new AsyncFunction() { // from class: androidx.camera.camera2.adapter.CameraControlAdapter$$ExternalSyntheticLambda1
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return CameraControlAdapter.enableLowLightBoostAsync$lambda$3(function1, obj);
            }
        }, CameraXExecutors.directExecutor()));
        Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
        return listenableFutureNonCancellationPropagating;
    }

    static final ListenableFuture enableLowLightBoostAsync$lambda$3(Function1 function1, Object obj) {
        return (ListenableFuture) function1.invoke(obj);
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ListenableFuture<FocusMeteringResult> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(FocusMeteringControl.startFocusAndMetering$default(this.focusMeteringControl, action, 0L, 2, null));
        Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
        return listenableFutureNonCancellationPropagating;
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> cancelFocusAndMetering() {
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        CoroutineAdaptersKt.propagateTo(this.focusMeteringControl.cancelFocusAndMeteringAsync(), completableDeferredCompletableDeferred$default, new Function1() { // from class: androidx.camera.camera2.adapter.CameraControlAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CameraControlAdapter.cancelFocusAndMetering$lambda$0$0((Result3A) obj);
            }
        });
        ListenableFuture<Void> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(CoroutineAdaptersKt.asListenableFuture$default((Deferred) completableDeferredCompletableDeferred$default, (Object) null, 1, (Object) null));
        Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
        return listenableFutureNonCancellationPropagating;
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> setZoomRatio(float ratio) {
        return this.zoomControl.setZoomRatio(ratio);
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> setLinearZoom(float linearZoom) {
        return this.zoomControl.setLinearZoom(linearZoom);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public int getFlashMode() {
        return this.flashControl.get_flashMode();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setFlashMode(int flashMode) {
        FlashControl.setFlashAsync$default(this.flashControl, flashMode, false, 2, null);
        this.zslControl.setZslDisabledByFlashMode(flashMode == 1 || flashMode == 0);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setScreenFlash(ImageCapture.ScreenFlash screenFlash) {
        this.flashControl.setScreenFlash(screenFlash);
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Integer> setExposureCompensationIndex(int exposure) {
        ListenableFuture<Integer> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(CoroutineAdaptersKt.asListenableFuture$default(EvCompControl.updateAsync$default(this.evCompControl, exposure, false, 2, null), (Object) null, 1, (Object) null));
        Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
        return listenableFutureNonCancellationPropagating;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setZslDisabledByUserCaseConfig(boolean disabled) {
        this.zslControl.setZslDisabledByUserCaseConfig(disabled);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public boolean isZslDisabledByByUserCaseConfig() {
        return this.zslControl.getIsZslDisabledByUseCaseConfig();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addZslConfig(SessionConfig.Builder sessionConfigBuilder) {
        Intrinsics.checkNotNullParameter(sessionConfigBuilder, "sessionConfigBuilder");
        this.zslControl.addZslConfig(sessionConfigBuilder);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearZslConfig() {
        this.zslControl.clearZslConfig();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public ListenableFuture<List<Void>> submitStillCaptureRequests(List<CaptureConfig> captureConfigs, int captureMode, int flashType) {
        Intrinsics.checkNotNullParameter(captureConfigs, "captureConfigs");
        return this.stillCaptureRequestControl.issueCaptureRequests(captureConfigs, captureMode, flashType);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public ListenableFuture<CameraCapturePipeline> getCameraCapturePipelineAsync(final int captureMode, final int flashType) {
        final UseCaseCamera camera = this.useCaseManager.getCamera();
        if (camera == null) {
            ListenableFuture<CameraCapturePipeline> listenableFutureImmediateFailedFuture = Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
            Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFailedFuture, "immediateFailedFuture(...)");
            return listenableFutureImmediateFailedFuture;
        }
        final CoroutineScope sequentialScope = this.threads.getSequentialScope();
        ListenableFuture<CameraCapturePipeline> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.adapter.CameraControlAdapter$getCameraCapturePipelineAsync$$inlined$future$1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer<T> completer) {
                Intrinsics.checkNotNullParameter(completer, "completer");
                return BuildersKt__Builders_commonKt.launch$default(sequentialScope, null, null, new AnonymousClass1(completer, null, camera, captureMode, this, flashType), 3, null);
            }

            /* JADX INFO: renamed from: androidx.camera.camera2.adapter.CameraControlAdapter$getCameraCapturePipelineAsync$$inlined$future$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: CoroutineAdapters.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/adapter/CoroutineAdaptersKt$future$resolver$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.camera.camera2.adapter.CameraControlAdapter$getCameraCapturePipelineAsync$$inlined$future$1$1", f = "CameraControlAdapter.kt", i = {}, l = {106, 104}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ UseCaseCamera $camera$inlined;
                final /* synthetic */ int $captureMode$inlined;
                final /* synthetic */ CallbackToFutureAdapter.Completer $completer;
                final /* synthetic */ int $flashType$inlined;
                int I$0;
                Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ CameraControlAdapter this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(CallbackToFutureAdapter.Completer completer, Continuation continuation, UseCaseCamera useCaseCamera, int i, CameraControlAdapter cameraControlAdapter, int i2) {
                    super(2, continuation);
                    this.$completer = completer;
                    this.$camera$inlined = useCaseCamera;
                    this.$captureMode$inlined = i;
                    this.this$0 = cameraControlAdapter;
                    this.$flashType$inlined = i2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$completer, continuation, this.$camera$inlined, this.$captureMode$inlined, this.this$0, this.$flashType$inlined);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CallbackToFutureAdapter.Completer completer;
                    Object objAwaitFlashModeUpdate;
                    UseCaseCamera useCaseCamera;
                    int i;
                    CallbackToFutureAdapter.Completer completer2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            i = this.I$0;
                            UseCaseCamera useCaseCamera2 = (UseCaseCamera) this.L$1;
                            CallbackToFutureAdapter.Completer completer3 = (CallbackToFutureAdapter.Completer) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            objAwaitFlashModeUpdate = obj;
                            completer = completer3;
                            useCaseCamera = useCaseCamera2;
                        } else {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            CallbackToFutureAdapter.Completer completer4 = (CallbackToFutureAdapter.Completer) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            completer2 = completer4;
                        }
                        completer2.set(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    completer = this.$completer;
                    UseCaseCamera useCaseCamera3 = this.$camera$inlined;
                    int i3 = this.$captureMode$inlined;
                    FlashControl flashControl = this.this$0.flashControl;
                    this.L$0 = completer;
                    this.L$1 = useCaseCamera3;
                    this.I$0 = i3;
                    this.label = 1;
                    objAwaitFlashModeUpdate = flashControl.awaitFlashModeUpdate(this);
                    if (objAwaitFlashModeUpdate != coroutine_suspended) {
                        useCaseCamera = useCaseCamera3;
                        i = i3;
                    }
                    return coroutine_suspended;
                    int iIntValue = ((Number) objAwaitFlashModeUpdate).intValue();
                    int i4 = this.$flashType$inlined;
                    this.L$0 = completer;
                    this.L$1 = null;
                    this.label = 2;
                    Object cameraCapturePipeline = useCaseCamera.getCameraCapturePipeline(i, iIntValue, i4, this);
                    if (cameraCapturePipeline != coroutine_suspended) {
                        CallbackToFutureAdapter.Completer completer5 = completer;
                        obj = cameraCapturePipeline;
                        completer2 = completer5;
                        completer2.set(obj);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public SessionConfig getSessionConfig() {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isWarnEnabled(Log.TAG)) {
            android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "TODO: getSessionConfig is not yet supported");
        }
        SessionConfig sessionConfigDefaultEmptySessionConfig = SessionConfig.defaultEmptySessionConfig();
        Intrinsics.checkNotNullExpressionValue(sessionConfigDefaultEmptySessionConfig, "defaultEmptySessionConfig(...)");
        return sessionConfigDefaultEmptySessionConfig;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void incrementVideoUsage() {
        this.videoUsageControl.incrementUsage();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void decrementVideoUsage() {
        this.videoUsageControl.decrementUsage();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public boolean isInVideoUsage() {
        return this.videoUsageControl.isInVideoUsage();
    }
}
