package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureResult;
import android.os.Build;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import expo.modules.notifications.service.NotificationsService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: LowLightBoostControl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001>B+\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010-\u001a\u00020\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/J\u0012\u00101\u001a\u000202*\b\u0012\u0004\u0012\u00020003H\u0002J\u001e\u00104\u001a\b\u0012\u0004\u0012\u00020\u00150&2\u0006\u00105\u001a\u00020\u00172\b\b\u0002\u00106\u001a\u00020\u0017J\b\u00107\u001a\u00020\u0015H\u0002J$\u00108\u001a\b\u0012\u0004\u0012\u00020\u00150$*\b\u0012\u0004\u0012\u00020\u00150$2\n\u00109\u001a\u00060:j\u0002`;H\u0002J\u001a\u0010<\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010=\u001a\u00020\u001bH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010&8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006?"}, d2 = {"Landroidx/camera/camera2/impl/LowLightBoostControl;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "state3AControl", "Landroidx/camera/camera2/impl/State3AControl;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "comboRequestListener", "Landroidx/camera/camera2/impl/ComboRequestListener;", "<init>", "(Landroidx/camera/camera2/pipe/CameraMetadata;Landroidx/camera/camera2/impl/State3AControl;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/impl/ComboRequestListener;)V", "_requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "value", "requestControl", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "setRequestControl", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "reset", "", "isLowLightBoostSupported", "", "isLowLightBoostOn", "_lowLightBoostState", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "lowLightBoostStateLiveData", "Landroidx/lifecycle/LiveData;", "getLowLightBoostStateLiveData", "()Landroidx/lifecycle/LiveData;", "lowLightBoostStateAtomic", "Ljava/util/concurrent/atomic/AtomicInteger;", "_updateSignal", "Lkotlinx/coroutines/CompletableDeferred;", "checkFrameRateJob", "Lkotlinx/coroutines/Deferred;", "getCheckFrameRateJob$camera_camera2$annotations", "()V", "getCheckFrameRateJob$camera_camera2", "()Lkotlinx/coroutines/Deferred;", "setCheckFrameRateJob$camera_camera2", "(Lkotlinx/coroutines/Deferred;)V", "onSessionConfigChanged", "useCases", "", "Landroidx/camera/core/UseCase;", "getSessionConfig", "Landroidx/camera/core/impl/SessionConfig;", "", "setLowLightBoostAsync", "lowLightBoost", "cancelPreviousTask", "stopRunningTaskInternal", "createFailureResult", NotificationsService.EXCEPTION_KEY, "Ljava/lang/Exception;", "Lkotlin/Exception;", "setLiveDataValue", "state", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LowLightBoostControl implements UseCaseCameraControl {
    private final MutableLiveData<Integer> _lowLightBoostState;
    private UseCaseCameraRequestControl _requestControl;
    private CompletableDeferred<Unit> _updateSignal;
    private final CameraMetadata cameraMetadata;
    private Deferred<Boolean> checkFrameRateJob;
    private final ComboRequestListener comboRequestListener;
    private boolean isLowLightBoostOn;
    private final boolean isLowLightBoostSupported;
    private final AtomicInteger lowLightBoostStateAtomic;
    private final State3AControl state3AControl;
    private final UseCaseThreads threads;

    /* JADX INFO: compiled from: LowLightBoostControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/LowLightBoostControl$Bindings;", "", "<init>", "()V", "provideControls", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "lowLightBoostControl", "Landroidx/camera/camera2/impl/LowLightBoostControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @IntoSet
        public abstract UseCaseCameraControl provideControls(LowLightBoostControl lowLightBoostControl);
    }

    public static /* synthetic */ void getCheckFrameRateJob$camera_camera2$annotations() {
    }

    @Inject
    public LowLightBoostControl(CameraMetadata cameraMetadata, State3AControl state3AControl, UseCaseThreads threads, ComboRequestListener comboRequestListener) {
        Intrinsics.checkNotNullParameter(state3AControl, "state3AControl");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(comboRequestListener, "comboRequestListener");
        this.cameraMetadata = cameraMetadata;
        this.state3AControl = state3AControl;
        this.threads = threads;
        this.comboRequestListener = comboRequestListener;
        boolean z = false;
        if (cameraMetadata != null && CameraMetadata.INSTANCE.getSupportsLowLightBoost(cameraMetadata)) {
            z = true;
        }
        this.isLowLightBoostSupported = z;
        this._lowLightBoostState = new MutableLiveData<>(-1);
        this.lowLightBoostStateAtomic = new AtomicInteger(-1);
        if (z) {
            comboRequestListener.addListener(new Request.Listener() { // from class: androidx.camera.camera2.impl.LowLightBoostControl.1
                @Override // androidx.camera.camera2.pipe.Request.Listener
                /* JADX INFO: renamed from: onTotalCaptureResult-CcXjc1I */
                public void mo51onTotalCaptureResultCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo totalCaptureResult) {
                    Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                    Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
                    if (Build.VERSION.SDK_INT < 35 || LowLightBoostControl.this._requestControl == null || !LowLightBoostControl.this.isLowLightBoostOn) {
                        return;
                    }
                    FrameMetadata metadata = totalCaptureResult.getMetadata();
                    CaptureResult.Key CONTROL_LOW_LIGHT_BOOST_STATE = CaptureResult.CONTROL_LOW_LIGHT_BOOST_STATE;
                    Intrinsics.checkNotNullExpressionValue(CONTROL_LOW_LIGHT_BOOST_STATE, "CONTROL_LOW_LIGHT_BOOST_STATE");
                    Integer num = (Integer) metadata.get(CONTROL_LOW_LIGHT_BOOST_STATE);
                    if (num != null) {
                        LowLightBoostControl lowLightBoostControl = LowLightBoostControl.this;
                        lowLightBoostControl.setLiveDataValue(lowLightBoostControl._lowLightBoostState, num.intValue() != 1 ? 0 : 1);
                    }
                }
            }, threads.getSequentialExecutor());
        }
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    /* JADX INFO: renamed from: getRequestControl, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void setRequestControl(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        if (this.isLowLightBoostOn) {
            if (useCaseCameraRequestControl != null) {
                setLowLightBoostAsync(true, false);
            } else {
                setLiveDataValue(this._lowLightBoostState, 0);
            }
        }
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void reset() {
        stopRunningTaskInternal();
        setLowLightBoostAsync$default(this, false, false, 2, null);
    }

    public final LiveData<Integer> getLowLightBoostStateLiveData() {
        return this._lowLightBoostState;
    }

    public final Deferred<Boolean> getCheckFrameRateJob$camera_camera2() {
        return this.checkFrameRateJob;
    }

    public final void setCheckFrameRateJob$camera_camera2(Deferred<Boolean> deferred) {
        this.checkFrameRateJob = deferred;
    }

    public final void onSessionConfigChanged(List<? extends UseCase> useCases) {
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        if (this.isLowLightBoostSupported) {
            if (useCases.isEmpty()) {
                this.checkFrameRateJob = CompletableDeferredKt.CompletableDeferred(false);
            } else {
                this.checkFrameRateJob = BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new C01901(useCases, null), 3, null);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.LowLightBoostControl$onSessionConfigChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LowLightBoostControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.LowLightBoostControl$onSessionConfigChanged$1", f = "LowLightBoostControl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C01901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ List<UseCase> $useCases;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01901(List<? extends UseCase> list, Continuation<? super C01901> continuation) {
            super(2, continuation);
            this.$useCases = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LowLightBoostControl.this.new C01901(this.$useCases, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C01901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((Number) LowLightBoostControl.this.getSessionConfig(this.$useCases).getExpectedFrameRateRange().getUpper()).intValue() > 30);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionConfig getSessionConfig(Collection<? extends UseCase> collection) {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            validatingBuilder.add(((UseCase) it.next()).getSessionConfig());
        }
        SessionConfig sessionConfigBuild = validatingBuilder.build();
        Intrinsics.checkNotNullExpressionValue(sessionConfigBuild, "build(...)");
        return sessionConfigBuild;
    }

    public static /* synthetic */ Deferred setLowLightBoostAsync$default(LowLightBoostControl lowLightBoostControl, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return lowLightBoostControl.setLowLightBoostAsync(z, z2);
    }

    public final Deferred<Unit> setLowLightBoostAsync(boolean lowLightBoost, boolean cancelPreviousTask) {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "LowLightBoostControl#setLowLightBoostAsync: lowLightBoost = " + lowLightBoost);
        }
        CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (this.isLowLightBoostSupported) {
            BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1(null, this, completableDeferredCompletableDeferred$default, lowLightBoost, cancelPreviousTask), 3, null);
            return completableDeferredCompletableDeferred$default;
        }
        return createFailureResult(completableDeferredCompletableDeferred$default, new IllegalStateException("Low Light Boost is not supported!"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopRunningTaskInternal() {
        CompletableDeferred<Unit> completableDeferred = this._updateSignal;
        if (completableDeferred != null) {
            createFailureResult(completableDeferred, new CameraControl.OperationCanceledException("There is a new enableLowLightBoost being set"));
        }
        this._updateSignal = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CompletableDeferred<Unit> createFailureResult(CompletableDeferred<Unit> completableDeferred, Exception exc) {
        completableDeferred.completeExceptionally(exc);
        return completableDeferred;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLiveDataValue(MutableLiveData<Integer> mutableLiveData, int i) {
        if (this.lowLightBoostStateAtomic.getAndSet(i) != i) {
            if (Threads.isMainThread()) {
                mutableLiveData.setValue(Integer.valueOf(i));
            } else {
                mutableLiveData.postValue(Integer.valueOf(i));
            }
        }
    }
}
