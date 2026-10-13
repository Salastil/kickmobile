package androidx.camera.camera2.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.util.Range;
import android.util.Rational;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.impl.CameraProperties;
import androidx.camera.camera2.impl.ComboRequestListener;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.impl.UseCaseThreads;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.core.CameraControl;
import com.datadog.android.rum.internal.RumFeature;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: EvCompCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/camera/camera2/compat/EvCompImpl;", "Landroidx/camera/camera2/compat/EvCompCompat;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "comboRequestListener", "Landroidx/camera/camera2/impl/ComboRequestListener;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/impl/ComboRequestListener;)V", "range", "Landroid/util/Range;", "", "getRange", "()Landroid/util/Range;", "supported", "", "getSupported", "()Z", "step", "Landroid/util/Rational;", "getStep", "()Landroid/util/Rational;", "updateSignal", "Lkotlinx/coroutines/CompletableDeferred;", "updateListener", "Landroidx/camera/camera2/pipe/Request$Listener;", "stopRunningTask", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "applyAsync", "Lkotlinx/coroutines/Deferred;", "evCompIndex", "requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "cancelPreviousTask", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EvCompImpl implements EvCompCompat {
    private final CameraProperties cameraProperties;
    private final ComboRequestListener comboRequestListener;
    private final Range<Integer> range;
    private final Rational step;
    private final boolean supported;
    private final UseCaseThreads threads;
    private Request.Listener updateListener;
    private CompletableDeferred<Integer> updateSignal;

    @Inject
    public EvCompImpl(CameraProperties cameraProperties, UseCaseThreads threads, ComboRequestListener comboRequestListener) {
        Integer num;
        Rational rational;
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(comboRequestListener, "comboRequestListener");
        this.cameraProperties = cameraProperties;
        this.threads = threads;
        this.comboRequestListener = comboRequestListener;
        CameraMetadata metadata = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AE_COMPENSATION_RANGE = CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AE_COMPENSATION_RANGE, "CONTROL_AE_COMPENSATION_RANGE");
        Object orDefault = metadata.getOrDefault((CameraCharacteristics.Key<Range<Integer>>) CONTROL_AE_COMPENSATION_RANGE, EvCompCompatKt.getEMPTY_RANGE());
        Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
        this.range = (Range) orDefault;
        Integer num2 = (Integer) getRange().getUpper();
        this.supported = (num2 == null || num2.intValue() != 0) && ((num = (Integer) getRange().getLower()) == null || num.intValue() != 0);
        if (!getSupported()) {
            rational = Rational.ZERO;
            Intrinsics.checkNotNull(rational);
        } else {
            CameraMetadata metadata2 = cameraProperties.getMetadata();
            CameraCharacteristics.Key CONTROL_AE_COMPENSATION_STEP = CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP;
            Intrinsics.checkNotNullExpressionValue(CONTROL_AE_COMPENSATION_STEP, "CONTROL_AE_COMPENSATION_STEP");
            Object obj = metadata2.get((CameraCharacteristics.Key<Object>) CONTROL_AE_COMPENSATION_STEP);
            Intrinsics.checkNotNull(obj);
            rational = (Rational) obj;
        }
        this.step = rational;
    }

    @Override // androidx.camera.camera2.compat.EvCompCompat
    public Range<Integer> getRange() {
        return this.range;
    }

    @Override // androidx.camera.camera2.compat.EvCompCompat
    public boolean getSupported() {
        return this.supported;
    }

    @Override // androidx.camera.camera2.compat.EvCompCompat
    public Rational getStep() {
        return this.step;
    }

    @Override // androidx.camera.camera2.compat.EvCompCompat
    public void stopRunningTask(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        CompletableDeferred<Integer> completableDeferred = this.updateSignal;
        if (completableDeferred != null) {
            completableDeferred.completeExceptionally(throwable);
        }
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.camera.camera2.compat.EvCompImpl$applyAsync$3] */
    @Override // androidx.camera.camera2.compat.EvCompCompat
    public Deferred<Integer> applyAsync(final int evCompIndex, UseCaseCameraRequestControl requestControl, boolean cancelPreviousTask) {
        Intrinsics.checkNotNullParameter(requestControl, "requestControl");
        final CompletableDeferred<Integer> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        CompletableDeferred<Integer> completableDeferred = this.updateSignal;
        if (completableDeferred != null) {
            if (cancelPreviousTask) {
                completableDeferred.completeExceptionally(new CameraControl.OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
            } else {
                CoroutineAdaptersKt.propagateTo(completableDeferredCompletableDeferred$default, completableDeferred);
            }
        }
        this.updateSignal = completableDeferredCompletableDeferred$default;
        Request.Listener listener = this.updateListener;
        if (listener != null) {
            this.comboRequestListener.removeListener(listener);
            this.updateListener = null;
        }
        UseCaseCameraRequestControl.setParametersAsync$default(requestControl, MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(evCompIndex))), null, null, 6, null);
        final ?? r9 = new Request.Listener() { // from class: androidx.camera.camera2.compat.EvCompImpl.applyAsync.3
            @Override // androidx.camera.camera2.pipe.Request.Listener
            /* JADX INFO: renamed from: onComplete-CcXjc1I */
            public void mo49onCompleteCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo result) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Intrinsics.checkNotNullParameter(result, "result");
                FrameMetadata metadata = result.getMetadata();
                CaptureResult.Key CONTROL_AE_STATE = CaptureResult.CONTROL_AE_STATE;
                Intrinsics.checkNotNullExpressionValue(CONTROL_AE_STATE, "CONTROL_AE_STATE");
                Integer num = (Integer) metadata.get(CONTROL_AE_STATE);
                FrameMetadata metadata2 = result.getMetadata();
                CaptureResult.Key CONTROL_AE_EXPOSURE_COMPENSATION = CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION;
                Intrinsics.checkNotNullExpressionValue(CONTROL_AE_EXPOSURE_COMPENSATION, "CONTROL_AE_EXPOSURE_COMPENSATION");
                Integer num2 = (Integer) metadata2.get(CONTROL_AE_EXPOSURE_COMPENSATION);
                if (num == null || num2 == null) {
                    if (num2 != null) {
                        if (num2.intValue() == evCompIndex) {
                            completableDeferredCompletableDeferred$default.complete(Integer.valueOf(evCompIndex));
                            return;
                        }
                        return;
                    }
                    return;
                }
                int iIntValue = num.intValue();
                if (iIntValue == 2 || iIntValue == 3 || iIntValue == 4) {
                    if (num2.intValue() == evCompIndex) {
                        completableDeferredCompletableDeferred$default.complete(Integer.valueOf(evCompIndex));
                    }
                }
            }
        };
        Request.Listener listener2 = (Request.Listener) r9;
        this.comboRequestListener.addListener(listener2, this.threads.getSequentialExecutor());
        completableDeferredCompletableDeferred$default.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.compat.EvCompImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EvCompImpl.applyAsync$lambda$2$0(this.f$0, r9, (Throwable) obj);
            }
        });
        this.updateListener = listener2;
        return completableDeferredCompletableDeferred$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyAsync$lambda$2$0(EvCompImpl evCompImpl, AnonymousClass3 anonymousClass3, Throwable th) {
        evCompImpl.comboRequestListener.removeListener(anonymousClass3);
        return Unit.INSTANCE;
    }
}
