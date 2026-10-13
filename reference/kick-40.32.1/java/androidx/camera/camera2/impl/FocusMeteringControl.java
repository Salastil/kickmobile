package androidx.camera.camera2.impl;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.compat.ZoomCompat;
import androidx.camera.camera2.compat.workaround.MeteringRegionCorrection;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Lock3ABehavior;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.exifinterface.media.ExifInterface;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.google.common.util.concurrent.ListenableFuture;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: FocusMeteringControl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0002[\\B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002050<2\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020@J&\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020@2\f\u0010C\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u001e\u0010D\u001a\u00020\u00182\u0006\u0010B\u001a\u00020@2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020504H\u0002J(\u0010F\u001a\u00020\u0018*\b\u0012\u0004\u0012\u0002070G2\f\u0010H\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010I\u001a\u00020-H\u0002J\u000e\u0010J\u001a\u00020-2\u0006\u0010=\u001a\u00020>J\u0017\u0010K\u001a\u0002002\u0006\u0010L\u001a\u000200H\u0002¢\u0006\u0004\bM\u0010NJ\u000e\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070GJ&\u0010P\u001a\b\u0012\u0004\u0012\u0002070G2\u0006\u0010\u0012\u001a\u00020\u00102\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0002J \u0010R\u001a\u00020\u0018\"\u0004\b\u0000\u0010S*\b\u0012\u0004\u0012\u0002HS042\u0006\u0010T\u001a\u00020UH\u0002J\u0014\u0010V\u001a\u000205*\u0002072\u0006\u0010I\u001a\u00020-H\u0002J\u0017\u0010W\u001a\u00020-2\u0006\u0010X\u001a\u000202H\u0002¢\u0006\u0004\bY\u0010ZR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\n (*\u0004\u0018\u00010'0'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0018\u0010*\u001a\n (*\u0004\u0018\u00010'0'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0018\u0010+\u001a\n (*\u0004\u0018\u00010'0'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u00010/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u000107\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Landroidx/camera/camera2/impl/FocusMeteringControl;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "Landroidx/camera/camera2/impl/UseCaseManager$RunningUseCasesChangeListener;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "meteringRegionCorrection", "Landroidx/camera/camera2/compat/workaround/MeteringRegionCorrection;", "state3AControl", "Landroidx/camera/camera2/impl/State3AControl;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "zoomCompat", "Landroidx/camera/camera2/compat/ZoomCompat;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;Landroidx/camera/camera2/compat/workaround/MeteringRegionCorrection;Landroidx/camera/camera2/impl/State3AControl;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/compat/ZoomCompat;)V", "_requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "value", "requestControl", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "setRequestControl", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "onRunningUseCasesChanged", "", "runningUseCases", "", "Landroidx/camera/core/UseCase;", "reset", "previewAspectRatio", "Landroid/util/Rational;", "cropSensorRegion", "Landroid/graphics/Rect;", "getCropSensorRegion", "()Landroid/graphics/Rect;", "defaultAspectRatio", "getDefaultAspectRatio", "()Landroid/util/Rational;", "maxAfRegionCount", "", "kotlin.jvm.PlatformType", "Ljava/lang/Integer;", "maxAeRegionCount", "maxAwbRegionCount", "supportsAutoFocusTrigger", "", "availableAeModes", "", "Landroidx/camera/camera2/pipe/AeMode;", "availableAfModes", "Landroidx/camera/camera2/pipe/AfMode;", "updateSignal", "Lkotlinx/coroutines/CompletableDeferred;", "Landroidx/camera/core/FocusMeteringResult;", "cancelSignal", "Landroidx/camera/camera2/pipe/Result3A;", "focusTimeoutJob", "Lkotlinx/coroutines/Job;", "autoCancelJob", "startFocusAndMetering", "Lcom/google/common/util/concurrent/ListenableFuture;", "action", "Landroidx/camera/core/FocusMeteringAction;", "autoFocusTimeoutMs", "", "triggerAutoCancel", "delayMillis", "resultToCancel", "triggerFocusTimeout", "resultToComplete", "propagateToFocusMeteringResultDeferred", "Lkotlinx/coroutines/Deferred;", "resultDeferred", "shouldTriggerAf", "isFocusMeteringSupported", "getSupportedAeMode", "preferredMode", "getSupportedAeMode-rTgdhRc", "(I)I", "cancelFocusAndMeteringAsync", "cancelFocusAndMeteringNowAsync", "signalToCancel", "setCancelException", ExifInterface.GPS_DIRECTION_TRUE, "message", "", "toFocusMeteringResult", "isAfModeSupported", "afMode", "isAfModeSupported-wvCmZyc", "(I)Z", "Companion", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FocusMeteringControl implements UseCaseCameraControl, UseCaseManager.RunningUseCasesChangeListener {
    public static final long AUTO_FOCUS_TIMEOUT_DURATION = 5000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int METERING_WEIGHT_DEFAULT = 1000;
    private UseCaseCameraRequestControl _requestControl;
    private Job autoCancelJob;
    private final List<AeMode> availableAeModes;
    private final List<AfMode> availableAfModes;
    private final CameraProperties cameraProperties;
    private CompletableDeferred<Result3A> cancelSignal;
    private Job focusTimeoutJob;
    private final Integer maxAeRegionCount;
    private final Integer maxAfRegionCount;
    private final Integer maxAwbRegionCount;
    private final MeteringRegionCorrection meteringRegionCorrection;
    private Rational previewAspectRatio;
    private final State3AControl state3AControl;
    private final boolean supportsAutoFocusTrigger;
    private final UseCaseThreads threads;
    private CompletableDeferred<FocusMeteringResult> updateSignal;
    private final ZoomCompat zoomCompat;

    /* JADX INFO: compiled from: FocusMeteringControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/FocusMeteringControl$Bindings;", "", "<init>", "()V", "provideControls", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "focusMeteringControl", "Landroidx/camera/camera2/impl/FocusMeteringControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @IntoSet
        public abstract UseCaseCameraControl provideControls(FocusMeteringControl focusMeteringControl);
    }

    @Inject
    public FocusMeteringControl(CameraProperties cameraProperties, MeteringRegionCorrection meteringRegionCorrection, State3AControl state3AControl, UseCaseThreads threads, ZoomCompat zoomCompat) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(meteringRegionCorrection, "meteringRegionCorrection");
        Intrinsics.checkNotNullParameter(state3AControl, "state3AControl");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(zoomCompat, "zoomCompat");
        this.cameraProperties = cameraProperties;
        this.meteringRegionCorrection = meteringRegionCorrection;
        this.state3AControl = state3AControl;
        this.threads = threads;
        this.zoomCompat = zoomCompat;
        CameraMetadata metadata = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_MAX_REGIONS_AF = CameraCharacteristics.CONTROL_MAX_REGIONS_AF;
        Intrinsics.checkNotNullExpressionValue(CONTROL_MAX_REGIONS_AF, "CONTROL_MAX_REGIONS_AF");
        this.maxAfRegionCount = (Integer) metadata.getOrDefault((CameraCharacteristics.Key<int>) CONTROL_MAX_REGIONS_AF, 0);
        CameraMetadata metadata2 = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_MAX_REGIONS_AE = CameraCharacteristics.CONTROL_MAX_REGIONS_AE;
        Intrinsics.checkNotNullExpressionValue(CONTROL_MAX_REGIONS_AE, "CONTROL_MAX_REGIONS_AE");
        this.maxAeRegionCount = (Integer) metadata2.getOrDefault((CameraCharacteristics.Key<int>) CONTROL_MAX_REGIONS_AE, 0);
        CameraMetadata metadata3 = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_MAX_REGIONS_AWB = CameraCharacteristics.CONTROL_MAX_REGIONS_AWB;
        Intrinsics.checkNotNullExpressionValue(CONTROL_MAX_REGIONS_AWB, "CONTROL_MAX_REGIONS_AWB");
        this.maxAwbRegionCount = (Integer) metadata3.getOrDefault((CameraCharacteristics.Key<int>) CONTROL_MAX_REGIONS_AWB, 0);
        this.supportsAutoFocusTrigger = CameraMetadata.INSTANCE.getSupportsAutoFocusTrigger(cameraProperties.getMetadata());
        CameraMetadata metadata4 = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AE_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AE_AVAILABLE_MODES, "CONTROL_AE_AVAILABLE_MODES");
        int[] iArr = (int[]) metadata4.get(CONTROL_AE_AVAILABLE_MODES);
        ArrayList arrayList2 = null;
        if (iArr != null) {
            ArrayList arrayList3 = new ArrayList(iArr.length);
            for (int i : iArr) {
                arrayList3.add(AeMode.INSTANCE.m162fromIntOrNullkQd0u18(i));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        this.availableAeModes = arrayList;
        CameraMetadata metadata5 = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AF_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AF_AVAILABLE_MODES, "CONTROL_AF_AVAILABLE_MODES");
        int[] iArr2 = (int[]) metadata5.get(CONTROL_AF_AVAILABLE_MODES);
        if (iArr2 != null) {
            ArrayList arrayList4 = new ArrayList(iArr2.length);
            for (int i2 : iArr2) {
                arrayList4.add(AfMode.INSTANCE.m180fromIntOrNullMKXwA8g(i2));
            }
            arrayList2 = arrayList4;
        }
        this.availableAfModes = arrayList2;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    /* JADX INFO: renamed from: getRequestControl, reason: from getter */
    public UseCaseCameraRequestControl get_useCaseCameraRequestControl() {
        return this._requestControl;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void setRequestControl(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
    }

    @Override // androidx.camera.camera2.impl.UseCaseManager.RunningUseCasesChangeListener
    public void onRunningUseCasesChanged(Set<? extends UseCase> runningUseCases) {
        Size attachedSurfaceResolution;
        Intrinsics.checkNotNullParameter(runningUseCases, "runningUseCases");
        this.previewAspectRatio = null;
        for (UseCase useCase : runningUseCases) {
            if ((useCase instanceof Preview) && (attachedSurfaceResolution = ((Preview) useCase).getAttachedSurfaceResolution()) != null) {
                this.previewAspectRatio = new Rational(attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
            }
        }
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void reset() {
        this.previewAspectRatio = null;
        cancelFocusAndMeteringAsync();
    }

    private final Rect getCropSensorRegion() {
        return this.zoomCompat.getCropSensorRegion();
    }

    private final Rational getDefaultAspectRatio() {
        Rational rational = this.previewAspectRatio;
        return rational == null ? new Rational(getCropSensorRegion().width(), getCropSensorRegion().height()) : rational;
    }

    public static /* synthetic */ ListenableFuture startFocusAndMetering$default(FocusMeteringControl focusMeteringControl, FocusMeteringAction focusMeteringAction, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 5000;
        }
        return focusMeteringControl.startFocusAndMetering(focusMeteringAction, j);
    }

    public final ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction action, long autoFocusTimeoutMs) {
        List<MeteringRectangle> list;
        List<MeteringRectangle> list2;
        List<MeteringRectangle> list3;
        Deferred<Result3A> deferredUpdate3aRegions;
        Intrinsics.checkNotNullParameter(action, "action");
        CompletableDeferred<FocusMeteringResult> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_useCaseCameraRequestControl();
        if (useCaseCameraRequestControl != null) {
            Job job = this.focusTimeoutJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = this.autoCancelJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            CompletableDeferred<Result3A> completableDeferred = this.cancelSignal;
            if (completableDeferred != null) {
                setCancelException(completableDeferred, "Cancelled by another startFocusAndMetering()");
            }
            CompletableDeferred<FocusMeteringResult> completableDeferred2 = this.updateSignal;
            if (completableDeferred2 != null) {
                setCancelException(completableDeferred2, "Cancelled by another startFocusAndMetering()");
            }
            this.updateSignal = completableDeferredCompletableDeferred$default;
            Companion companion = INSTANCE;
            List<MeteringPoint> meteringPointsAe = action.getMeteringPointsAe();
            Intrinsics.checkNotNullExpressionValue(meteringPointsAe, "getMeteringPointsAe(...)");
            Integer maxAeRegionCount = this.maxAeRegionCount;
            Intrinsics.checkNotNullExpressionValue(maxAeRegionCount, "maxAeRegionCount");
            List<MeteringRectangle> listMeteringRegionsFromMeteringPoints = companion.meteringRegionsFromMeteringPoints(meteringPointsAe, maxAeRegionCount.intValue(), getCropSensorRegion(), getDefaultAspectRatio(), 2, this.meteringRegionCorrection);
            List<MeteringPoint> meteringPointsAf = action.getMeteringPointsAf();
            Intrinsics.checkNotNullExpressionValue(meteringPointsAf, "getMeteringPointsAf(...)");
            Integer maxAfRegionCount = this.maxAfRegionCount;
            Intrinsics.checkNotNullExpressionValue(maxAfRegionCount, "maxAfRegionCount");
            List<MeteringRectangle> listMeteringRegionsFromMeteringPoints2 = companion.meteringRegionsFromMeteringPoints(meteringPointsAf, maxAfRegionCount.intValue(), getCropSensorRegion(), getDefaultAspectRatio(), 1, this.meteringRegionCorrection);
            List<MeteringPoint> meteringPointsAwb = action.getMeteringPointsAwb();
            Intrinsics.checkNotNullExpressionValue(meteringPointsAwb, "getMeteringPointsAwb(...)");
            Integer maxAwbRegionCount = this.maxAwbRegionCount;
            Intrinsics.checkNotNullExpressionValue(maxAwbRegionCount, "maxAwbRegionCount");
            List<MeteringRectangle> listMeteringRegionsFromMeteringPoints3 = companion.meteringRegionsFromMeteringPoints(meteringPointsAwb, maxAwbRegionCount.intValue(), getCropSensorRegion(), getDefaultAspectRatio(), 4, this.meteringRegionCorrection);
            if (listMeteringRegionsFromMeteringPoints.isEmpty() && listMeteringRegionsFromMeteringPoints2.isEmpty() && listMeteringRegionsFromMeteringPoints3.isEmpty()) {
                completableDeferredCompletableDeferred$default.completeExceptionally(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
                return CoroutineAdaptersKt.asListenableFuture$default((Deferred) completableDeferredCompletableDeferred$default, (Object) null, 1, (Object) null);
            }
            List<MeteringRectangle> list4 = listMeteringRegionsFromMeteringPoints2;
            if (!list4.isEmpty()) {
                this.state3AControl.setPreferredFocusModeAsync(1);
            }
            if (this.maxAeRegionCount.intValue() > 0) {
                List<MeteringRectangle> list5 = listMeteringRegionsFromMeteringPoints;
                if (list5.isEmpty()) {
                    list5 = ArraysKt.toList(CameraGraph.Constants3A.INSTANCE.getMETERING_REGIONS_DEFAULT());
                }
                list = list5;
            } else {
                list = null;
            }
            if (this.maxAfRegionCount.intValue() > 0) {
                list2 = list4.isEmpty() ? ArraysKt.toList(CameraGraph.Constants3A.INSTANCE.getMETERING_REGIONS_DEFAULT()) : list4;
            } else {
                list2 = null;
            }
            if (this.maxAwbRegionCount.intValue() > 0) {
                List<MeteringRectangle> list6 = listMeteringRegionsFromMeteringPoints3;
                if (list6.isEmpty()) {
                    list6 = ArraysKt.toList(CameraGraph.Constants3A.INSTANCE.getMETERING_REGIONS_DEFAULT());
                }
                list3 = list6;
            } else {
                list3 = null;
            }
            if (listMeteringRegionsFromMeteringPoints2.isEmpty() || !this.supportsAutoFocusTrigger) {
                List<MeteringRectangle> list7 = list2;
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "startFocusAndMetering: updating 3A regions only");
                }
                deferredUpdate3aRegions = useCaseCameraRequestControl.update3aRegions(list, list7, list3);
            } else {
                long autoCancelDurationInMillis = (!action.isAutoCancelEnabled() || action.getAutoCancelDurationInMillis() >= autoFocusTimeoutMs) ? autoFocusTimeoutMs : action.getAutoCancelDurationInMillis();
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "startFocusAndMetering: updating 3A regions & triggering AF");
                }
                deferredUpdate3aRegions = UseCaseCameraRequestControl.m139startFocusAndMeteringAsyncNxRnBj4$default(useCaseCameraRequestControl, list, list2, list3, null, this.maxAfRegionCount.intValue() > 0 ? Lock3ABehavior.m558boximpl(Lock3ABehavior.INSTANCE.m567getIMMEDIATEhRqSH3k()) : null, null, AeMode.m151boximpl(m115getSupportedAeModerTgdhRc(AeMode.INSTANCE.m164getONbOjpiJc())), TimeUnit.NANOSECONDS.convert(autoCancelDurationInMillis, TimeUnit.MILLISECONDS), 40, null);
            }
            propagateToFocusMeteringResultDeferred(deferredUpdate3aRegions, completableDeferredCompletableDeferred$default, !list4.isEmpty());
            triggerFocusTimeout(autoFocusTimeoutMs, completableDeferredCompletableDeferred$default);
            if (action.isAutoCancelEnabled()) {
                triggerAutoCancel(action.getAutoCancelDurationInMillis(), completableDeferredCompletableDeferred$default, useCaseCameraRequestControl);
            }
        } else {
            completableDeferredCompletableDeferred$default.completeExceptionally(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return CoroutineAdaptersKt.asListenableFuture$default((Deferred) completableDeferredCompletableDeferred$default, (Object) null, 1, (Object) null);
    }

    private final void triggerAutoCancel(long delayMillis, CompletableDeferred<FocusMeteringResult> resultToCancel, UseCaseCameraRequestControl requestControl) {
        Job job = this.autoCancelJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.autoCancelJob = BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new AnonymousClass1(delayMillis, this, requestControl, resultToCancel, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FocusMeteringControl$triggerAutoCancel$1, reason: invalid class name */
    /* JADX INFO: compiled from: FocusMeteringControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FocusMeteringControl$triggerAutoCancel$1", f = "FocusMeteringControl.kt", i = {}, l = {GlobalMediaRouter.CallbackHandler.MSG_ROUTE_DISCONNECTED}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ UseCaseCameraRequestControl $requestControl;
        final /* synthetic */ CompletableDeferred<FocusMeteringResult> $resultToCancel;
        int label;
        final /* synthetic */ FocusMeteringControl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, FocusMeteringControl focusMeteringControl, UseCaseCameraRequestControl useCaseCameraRequestControl, CompletableDeferred<FocusMeteringResult> completableDeferred, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$delayMillis = j;
            this.this$0 = focusMeteringControl;
            this.$requestControl = useCaseCameraRequestControl;
            this.$resultToCancel = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$delayMillis, this.this$0, this.$requestControl, this.$resultToCancel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(this.$delayMillis, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            long j = this.$delayMillis;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "triggerAutoCancel: auto-canceling after " + j + " ms");
            }
            this.this$0.cancelFocusAndMeteringNowAsync(this.$requestControl, this.$resultToCancel);
            return Unit.INSTANCE;
        }
    }

    private final void triggerFocusTimeout(long delayMillis, CompletableDeferred<FocusMeteringResult> resultToComplete) {
        Job job = this.focusTimeoutJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.focusTimeoutJob = BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new C01891(delayMillis, resultToComplete, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FocusMeteringControl$triggerFocusTimeout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FocusMeteringControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FocusMeteringControl$triggerFocusTimeout$1", f = "FocusMeteringControl.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C01891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ CompletableDeferred<FocusMeteringResult> $resultToComplete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01891(long j, CompletableDeferred<FocusMeteringResult> completableDeferred, Continuation<? super C01891> continuation) {
            super(2, continuation);
            this.$delayMillis = j;
            this.$resultToComplete = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01891(this.$delayMillis, this.$resultToComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(this.$delayMillis, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            long j = this.$delayMillis;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "triggerFocusTimeout: completing with focus result unsuccessful after " + j + " ms");
            }
            CompletableDeferred<FocusMeteringResult> completableDeferred = this.$resultToComplete;
            FocusMeteringResult focusMeteringResultCreate = FocusMeteringResult.create(false);
            Intrinsics.checkNotNullExpressionValue(focusMeteringResultCreate, "create(...)");
            completableDeferred.complete(focusMeteringResultCreate);
            return Unit.INSTANCE;
        }
    }

    private final void propagateToFocusMeteringResultDeferred(final Deferred<Result3A> deferred, final CompletableDeferred<FocusMeteringResult> completableDeferred, final boolean z) {
        deferred.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.impl.FocusMeteringControl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FocusMeteringControl.propagateToFocusMeteringResultDeferred$lambda$0(completableDeferred, deferred, this, z, (Throwable) obj);
            }
        });
    }

    static final Unit propagateToFocusMeteringResultDeferred$lambda$0(CompletableDeferred completableDeferred, Deferred deferred, FocusMeteringControl focusMeteringControl, boolean z, Throwable th) {
        if (th != null) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isWarnEnabled(Log.TAG)) {
                android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "propagateToFocusMeteringResultDeferred: completed exceptionally!", th);
            }
            completableDeferred.completeExceptionally(th);
        } else {
            Result3A result3A = (Result3A) deferred.getCompleted();
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "propagateToFocusMeteringResultDeferred: result3A = " + result3A);
            }
            if (Result3A.Status.m729equalsimpl0(result3A.m725getStatusJvTi9ms(), Result3A.Status.INSTANCE.m736getSUBMIT_FAILEDJvTi9ms())) {
                completableDeferred.completeExceptionally(new CameraControl.OperationCanceledException("Camera is not active."));
            } else if (Result3A.Status.m729equalsimpl0(result3A.m725getStatusJvTi9ms(), Result3A.Status.INSTANCE.m737getTIME_LIMIT_REACHEDJvTi9ms())) {
                FocusMeteringResult focusMeteringResultCreate = FocusMeteringResult.create(false);
                Intrinsics.checkNotNullExpressionValue(focusMeteringResultCreate, "create(...)");
                completableDeferred.complete(focusMeteringResultCreate);
            } else {
                completableDeferred.complete(focusMeteringControl.toFocusMeteringResult(result3A, z));
            }
        }
        return Unit.INSTANCE;
    }

    public final boolean isFocusMeteringSupported(FocusMeteringAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Companion companion = INSTANCE;
        List<MeteringPoint> meteringPointsAe = action.getMeteringPointsAe();
        Intrinsics.checkNotNullExpressionValue(meteringPointsAe, "getMeteringPointsAe(...)");
        Integer maxAeRegionCount = this.maxAeRegionCount;
        Intrinsics.checkNotNullExpressionValue(maxAeRegionCount, "maxAeRegionCount");
        List<MeteringRectangle> listMeteringRegionsFromMeteringPoints = companion.meteringRegionsFromMeteringPoints(meteringPointsAe, maxAeRegionCount.intValue(), getCropSensorRegion(), getDefaultAspectRatio(), 2, this.meteringRegionCorrection);
        List<MeteringPoint> meteringPointsAf = action.getMeteringPointsAf();
        Intrinsics.checkNotNullExpressionValue(meteringPointsAf, "getMeteringPointsAf(...)");
        Integer maxAfRegionCount = this.maxAfRegionCount;
        Intrinsics.checkNotNullExpressionValue(maxAfRegionCount, "maxAfRegionCount");
        List<MeteringRectangle> listMeteringRegionsFromMeteringPoints2 = companion.meteringRegionsFromMeteringPoints(meteringPointsAf, maxAfRegionCount.intValue(), getCropSensorRegion(), getDefaultAspectRatio(), 1, this.meteringRegionCorrection);
        List<MeteringPoint> meteringPointsAwb = action.getMeteringPointsAwb();
        Intrinsics.checkNotNullExpressionValue(meteringPointsAwb, "getMeteringPointsAwb(...)");
        Integer maxAwbRegionCount = this.maxAwbRegionCount;
        Intrinsics.checkNotNullExpressionValue(maxAwbRegionCount, "maxAwbRegionCount");
        return (listMeteringRegionsFromMeteringPoints.isEmpty() && listMeteringRegionsFromMeteringPoints2.isEmpty() && companion.meteringRegionsFromMeteringPoints(meteringPointsAwb, maxAwbRegionCount.intValue(), getCropSensorRegion(), getDefaultAspectRatio(), 4, this.meteringRegionCorrection).isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: getSupportedAeMode-rTgdhRc, reason: not valid java name */
    private final int m115getSupportedAeModerTgdhRc(int preferredMode) {
        List<AeMode> list = this.availableAeModes;
        if (list == null) {
            return AeMode.INSTANCE.m163getOFFbOjpiJc();
        }
        if (list.contains(AeMode.m151boximpl(preferredMode))) {
            return preferredMode;
        }
        if (this.availableAeModes.contains(AeMode.m151boximpl(AeMode.INSTANCE.m164getONbOjpiJc()))) {
            return AeMode.INSTANCE.m164getONbOjpiJc();
        }
        return AeMode.INSTANCE.m163getOFFbOjpiJc();
    }

    public final Deferred<Result3A> cancelFocusAndMeteringAsync() {
        CompletableDeferred<Result3A> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_useCaseCameraRequestControl();
        if (useCaseCameraRequestControl != null) {
            Job job = this.focusTimeoutJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = this.autoCancelJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            CompletableDeferred<Result3A> completableDeferred = this.cancelSignal;
            if (completableDeferred != null) {
                setCancelException(completableDeferred, "Cancelled by another cancelFocusAndMetering()");
            }
            this.cancelSignal = completableDeferredCompletableDeferred$default;
            CoroutineAdaptersKt.propagateTo(cancelFocusAndMeteringNowAsync(useCaseCameraRequestControl, this.updateSignal), completableDeferredCompletableDeferred$default);
        } else {
            completableDeferredCompletableDeferred$default.completeExceptionally(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return completableDeferredCompletableDeferred$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<Result3A> cancelFocusAndMeteringNowAsync(UseCaseCameraRequestControl requestControl, CompletableDeferred<FocusMeteringResult> signalToCancel) {
        if (signalToCancel != null) {
            setCancelException(signalToCancel, "Cancelled by cancelFocusAndMetering()");
        }
        this.state3AControl.setPreferredFocusModeAsync(null);
        return requestControl.cancelFocusAndMeteringAsync();
    }

    private final <T> void setCancelException(CompletableDeferred<T> completableDeferred, String str) {
        completableDeferred.completeExceptionally(new CameraControl.OperationCanceledException(str));
    }

    private final FocusMeteringResult toFocusMeteringResult(Result3A result3A, boolean z) {
        Integer num;
        boolean z2 = false;
        if (!Result3A.Status.m729equalsimpl0(result3A.m725getStatusJvTi9ms(), Result3A.Status.INSTANCE.m734getOKJvTi9ms())) {
            FocusMeteringResult focusMeteringResultCreate = FocusMeteringResult.create(false);
            Intrinsics.checkNotNullExpressionValue(focusMeteringResultCreate, "create(...)");
            return focusMeteringResultCreate;
        }
        FrameMetadata frameMetadata = result3A.getFrameMetadata();
        if (frameMetadata != null) {
            CaptureResult.Key CONTROL_AF_STATE = CaptureResult.CONTROL_AF_STATE;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AF_STATE, "CONTROL_AF_STATE");
            num = (Integer) frameMetadata.get(CONTROL_AF_STATE);
        } else {
            num = null;
        }
        if (z && (!m116isAfModeSupportedwvCmZyc(AfMode.INSTANCE.m181getAUTOvHZNRtE()) || (result3A.getFrameMetadata() != null && (num == null || num.intValue() == 4)))) {
            z2 = true;
        }
        FocusMeteringResult focusMeteringResultCreate2 = FocusMeteringResult.create(z2);
        Intrinsics.checkNotNullExpressionValue(focusMeteringResultCreate2, "create(...)");
        return focusMeteringResultCreate2;
    }

    /* JADX INFO: renamed from: isAfModeSupported-wvCmZyc, reason: not valid java name */
    private final boolean m116isAfModeSupportedwvCmZyc(int afMode) {
        List<AfMode> list = this.availableAfModes;
        if (list == null) {
            return false;
        }
        return list.contains(AfMode.m170boximpl(afMode));
    }

    /* JADX INFO: compiled from: FocusMeteringControl.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/camera/camera2/impl/FocusMeteringControl$Companion;", "", "<init>", "()V", "METERING_WEIGHT_DEFAULT", "", "AUTO_FOCUS_TIMEOUT_DURATION", "", "meteringRegionsFromMeteringPoints", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "meteringPoints", "Landroidx/camera/core/MeteringPoint;", "maxRegionCount", "cropSensorRegion", "Landroid/graphics/Rect;", "defaultAspectRatio", "Landroid/util/Rational;", "meteringMode", "meteringRegionCorrection", "Landroidx/camera/camera2/compat/workaround/MeteringRegionCorrection;", "getFovAdjustedPoint", "Landroid/graphics/PointF;", "meteringPoint", "cropRegionAspectRatio", "getMeteringRect", "normalizedPointF", "normalizedSize", "", "cropRegion", "isValid", "", "pt", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<MeteringRectangle> meteringRegionsFromMeteringPoints(List<? extends MeteringPoint> meteringPoints, int maxRegionCount, Rect cropSensorRegion, Rational defaultAspectRatio, int meteringMode, MeteringRegionCorrection meteringRegionCorrection) {
            Intrinsics.checkNotNullParameter(meteringPoints, "meteringPoints");
            Intrinsics.checkNotNullParameter(cropSensorRegion, "cropSensorRegion");
            Intrinsics.checkNotNullParameter(defaultAspectRatio, "defaultAspectRatio");
            Intrinsics.checkNotNullParameter(meteringRegionCorrection, "meteringRegionCorrection");
            if (meteringPoints.isEmpty() || maxRegionCount == 0) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Rational rational = new Rational(cropSensorRegion.width(), cropSensorRegion.height());
            for (MeteringPoint meteringPoint : meteringPoints) {
                if (arrayList.size() >= maxRegionCount) {
                    break;
                }
                if (this.isValid(meteringPoint)) {
                    Companion companion = this;
                    Rational rational2 = defaultAspectRatio;
                    arrayList.add(companion.getMeteringRect(companion.getFovAdjustedPoint(meteringPoint, rational, rational2, meteringMode, meteringRegionCorrection), meteringPoint.getSize(), cropSensorRegion));
                    this = companion;
                    defaultAspectRatio = rational2;
                }
            }
            return arrayList;
        }

        private final PointF getFovAdjustedPoint(MeteringPoint meteringPoint, Rational cropRegionAspectRatio, Rational defaultAspectRatio, int meteringMode, MeteringRegionCorrection meteringRegionCorrection) {
            Rational surfaceAspectRatio = meteringPoint.getSurfaceAspectRatio();
            if (surfaceAspectRatio != null) {
                defaultAspectRatio = surfaceAspectRatio;
            }
            PointF correctedPoint = meteringRegionCorrection.getCorrectedPoint(meteringPoint, meteringMode);
            if (!Intrinsics.areEqual(defaultAspectRatio, cropRegionAspectRatio)) {
                if (defaultAspectRatio.compareTo(cropRegionAspectRatio) > 0) {
                    PointF pointF = new PointF(correctedPoint.x, correctedPoint.y);
                    float fDoubleValue = (float) (defaultAspectRatio.doubleValue() / cropRegionAspectRatio.doubleValue());
                    pointF.y = (((float) ((((double) fDoubleValue) - 1.0d) / 2.0d)) + pointF.y) * (1.0f / fDoubleValue);
                    return pointF;
                }
                PointF pointF2 = new PointF(correctedPoint.x, correctedPoint.y);
                float fDoubleValue2 = (float) (cropRegionAspectRatio.doubleValue() / defaultAspectRatio.doubleValue());
                pointF2.x = (((float) ((((double) fDoubleValue2) - 1.0d) / 2.0d)) + pointF2.x) * (1.0f / fDoubleValue2);
                return pointF2;
            }
            return new PointF(correctedPoint.x, correctedPoint.y);
        }

        private final MeteringRectangle getMeteringRect(PointF normalizedPointF, float normalizedSize, Rect cropRegion) {
            int iWidth = (int) (cropRegion.left + (normalizedPointF.x * cropRegion.width()));
            int iHeight = (int) (cropRegion.top + (normalizedPointF.y * cropRegion.height()));
            int iWidth2 = ((int) (cropRegion.width() * normalizedSize)) / 2;
            int iHeight2 = ((int) (normalizedSize * cropRegion.height())) / 2;
            Rect rect = new Rect(iWidth - iWidth2, iHeight - iHeight2, iWidth + iWidth2, iHeight + iHeight2);
            rect.left = RangesKt.coerceIn(rect.left, cropRegion.left, cropRegion.right);
            rect.right = RangesKt.coerceIn(rect.right, cropRegion.left, cropRegion.right);
            rect.top = RangesKt.coerceIn(rect.top, cropRegion.top, cropRegion.bottom);
            rect.bottom = RangesKt.coerceIn(rect.bottom, cropRegion.top, cropRegion.bottom);
            return new MeteringRectangle(rect, 1000);
        }

        private final boolean isValid(MeteringPoint pt) {
            return pt.getX() >= 0.0f && pt.getX() <= 1.0f && pt.getY() >= 0.0f && pt.getY() <= 1.0f;
        }
    }
}
