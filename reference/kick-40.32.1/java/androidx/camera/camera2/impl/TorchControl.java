package androidx.camera.camera2.impl;

import android.os.Build;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.compat.Api35Compat;
import androidx.camera.camera2.compat.workaround.FlashAvailabilityCheckerKt;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.Result3A;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.analytics.FirebaseAnalytics;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import expo.modules.notifications.service.NotificationsService;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: TorchControl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002IJB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J(\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0013002\u0006\u00101\u001a\u00020\u00152\b\b\u0002\u00102\u001a\u00020\u00152\b\b\u0002\u00103\u001a\u00020\u0015J1\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0013002\u0006\u00104\u001a\u00020\u00172\b\b\u0002\u00102\u001a\u00020\u00152\b\b\u0002\u00103\u001a\u00020\u0015H\u0000¢\u0006\u0004\b5\u00106J\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u0013002\u0006\u00108\u001a\u00020 J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u0013002\u0006\u00108\u001a\u00020 H\u0002J\b\u0010:\u001a\u00020\u0013H\u0002J\b\u0010;\u001a\u00020\u0013H\u0002J\b\u0010<\u001a\u00020\u0013H\u0002J$\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130-*\b\u0012\u0004\u0012\u00020\u00130-2\n\u0010>\u001a\u00060?j\u0002`@H\u0002J\u0017\u0010A\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0017H\u0002¢\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\f\u001a\u00020 H\u0002J\u0017\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u0017H\u0002¢\u0006\u0004\bG\u0010HR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020 0#8F¢\u0006\u0006\u001a\u0004\b+\u0010%R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Landroidx/camera/camera2/impl/TorchControl;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "state3AControl", "Landroidx/camera/camera2/impl/State3AControl;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;Landroidx/camera/camera2/impl/State3AControl;Landroidx/camera/camera2/impl/UseCaseThreads;)V", "_requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "value", "requestControl", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "setRequestControl", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "reset", "", "hasFlashUnit", "", "torchMode", "Landroidx/camera/camera2/impl/TorchControl$TorchMode;", "getTorchMode-MnUA4hI$camera_camera2$annotations", "()V", "getTorchMode-MnUA4hI$camera_camera2", "()Landroidx/camera/camera2/impl/TorchControl$TorchMode;", "setTorchMode-UuNXre8$camera_camera2", "(Landroidx/camera/camera2/impl/TorchControl$TorchMode;)V", "_torchState", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "torchStateLiveData", "Landroidx/lifecycle/LiveData;", "getTorchStateLiveData", "()Landroidx/lifecycle/LiveData;", "isTorchStrengthSupported", "defaultTorchStrength", "maxTorchStrength", "_torchStrength", "torchStrengthLiveData", "getTorchStrengthLiveData", "_updateTorchStateSignal", "Lkotlinx/coroutines/CompletableDeferred;", "_updateTorchStrengthSignal", "setTorchAsync", "Lkotlinx/coroutines/Deferred;", "torch", "cancelPreviousTask", "ignoreFlashUnitAvailability", "mode", "setTorchAsync-Oup_wC0$camera_camera2", "(IZZ)Lkotlinx/coroutines/Deferred;", "setTorchStrengthLevelAsync", FirebaseAnalytics.Param.LEVEL, "updateTorchStrengthLevelAsync", "stopRunningTaskInternal", "stopTorchStateTask", "stopTorchStrengthTask", "createFailureResult", NotificationsService.EXCEPTION_KEY, "Ljava/lang/Exception;", "Lkotlin/Exception;", "updateTorchState", "updateTorchState-RaJ5uN0", "(I)V", "setLiveDataValue", "isFlashUnitOn", "torchState", "isFlashUnitOn-RaJ5uN0", "(I)Z", "Bindings", "TorchMode", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TorchControl implements UseCaseCameraControl {
    private UseCaseCameraRequestControl _requestControl;
    private final MutableLiveData<Integer> _torchState;
    private final MutableLiveData<Integer> _torchStrength;
    private CompletableDeferred<Unit> _updateTorchStateSignal;
    private CompletableDeferred<Unit> _updateTorchStrengthSignal;
    private final int defaultTorchStrength;
    private final boolean hasFlashUnit;
    private final boolean isTorchStrengthSupported;
    private final int maxTorchStrength;
    private final State3AControl state3AControl;
    private final UseCaseThreads threads;
    private TorchMode torchMode;

    /* JADX INFO: compiled from: TorchControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/TorchControl$Bindings;", "", "<init>", "()V", "provideControls", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "torchControl", "Landroidx/camera/camera2/impl/TorchControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @IntoSet
        public abstract UseCaseCameraControl provideControls(TorchControl torchControl);
    }

    /* JADX INFO: renamed from: getTorchMode-MnUA4hI$camera_camera2$annotations, reason: not valid java name */
    public static /* synthetic */ void m118getTorchModeMnUA4hI$camera_camera2$annotations() {
    }

    @Inject
    public TorchControl(CameraProperties cameraProperties, State3AControl state3AControl, UseCaseThreads threads) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(state3AControl, "state3AControl");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.state3AControl = state3AControl;
        this.threads = threads;
        this.hasFlashUnit = FlashAvailabilityCheckerKt.isFlashAvailable$default(cameraProperties, false, 1, null);
        this._torchState = new MutableLiveData<>(0);
        this.isTorchStrengthSupported = CameraMetadata.INSTANCE.getSupportsTorchStrength(cameraProperties.getMetadata());
        int defaultTorchStrengthLevel = CameraMetadata.INSTANCE.getDefaultTorchStrengthLevel(cameraProperties.getMetadata());
        this.defaultTorchStrength = defaultTorchStrengthLevel;
        this.maxTorchStrength = CameraMetadata.INSTANCE.getMaxTorchStrengthLevel(cameraProperties.getMetadata());
        this._torchStrength = new MutableLiveData<>(Integer.valueOf(defaultTorchStrengthLevel));
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    /* JADX INFO: renamed from: getRequestControl, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001b  */
    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void setRequestControl(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        boolean z;
        this._requestControl = useCaseCameraRequestControl;
        if (this.torchMode != null) {
            Integer value = getTorchStateLiveData().getValue();
            if (value != null) {
                z = value.intValue() == 1;
            }
            setTorchAsync$default(this, z, false, false, 4, null);
        }
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void reset() {
        stopRunningTaskInternal();
        if (this.torchMode != null) {
            m121updateTorchStateRaJ5uN0(TorchMode.INSTANCE.m132getOFFIRs_R8());
            setTorchAsync$default(this, false, false, false, 6, null);
            this.torchMode = null;
        }
    }

    /* JADX INFO: renamed from: getTorchMode-MnUA4hI$camera_camera2, reason: not valid java name and from getter */
    public final TorchMode getTorchMode() {
        return this.torchMode;
    }

    /* JADX INFO: renamed from: setTorchMode-UuNXre8$camera_camera2, reason: not valid java name */
    public final void m124setTorchModeUuNXre8$camera_camera2(TorchMode torchMode) {
        this.torchMode = torchMode;
    }

    public final LiveData<Integer> getTorchStateLiveData() {
        return this._torchState;
    }

    public final LiveData<Integer> getTorchStrengthLiveData() {
        return this._torchStrength;
    }

    public static /* synthetic */ Deferred setTorchAsync$default(TorchControl torchControl, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return torchControl.setTorchAsync(z, z2, z3);
    }

    public final Deferred<Unit> setTorchAsync(boolean torch, boolean cancelPreviousTask, boolean ignoreFlashUnitAvailability) {
        return m123setTorchAsyncOup_wC0$camera_camera2(torch ? TorchMode.INSTANCE.m133getONIRs_R8() : TorchMode.INSTANCE.m132getOFFIRs_R8(), cancelPreviousTask, ignoreFlashUnitAvailability);
    }

    /* JADX INFO: renamed from: setTorchAsync-Oup_wC0$camera_camera2$default, reason: not valid java name */
    public static /* synthetic */ Deferred m120setTorchAsyncOup_wC0$camera_camera2$default(TorchControl torchControl, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return torchControl.m123setTorchAsyncOup_wC0$camera_camera2(i, z, z2);
    }

    /* JADX INFO: renamed from: setTorchAsync-Oup_wC0$camera_camera2, reason: not valid java name */
    public final Deferred<Unit> m123setTorchAsyncOup_wC0$camera_camera2(int mode, boolean cancelPreviousTask, boolean ignoreFlashUnitAvailability) {
        int iM164getONbOjpiJc;
        Deferred<Result3A> deferredMo111setTorchOffAsyncMtizInI;
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "TorchControl#setTorchAsync: torch mode = " + ((Object) TorchMode.m130toStringimpl(mode)));
        }
        CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (!ignoreFlashUnitAvailability && !this.hasFlashUnit) {
            return createFailureResult(completableDeferredCompletableDeferred$default, new IllegalStateException("No flash unit"));
        }
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
        if (useCaseCameraRequestControl != null) {
            m121updateTorchStateRaJ5uN0(mode);
            if (cancelPreviousTask) {
                stopTorchStateTask();
            } else {
                CompletableDeferred<Unit> completableDeferred = this._updateTorchStateSignal;
                if (completableDeferred != null) {
                    CoroutineAdaptersKt.propagateTo(completableDeferredCompletableDeferred$default, completableDeferred);
                }
            }
            this._updateTorchStateSignal = completableDeferredCompletableDeferred$default;
            this.state3AControl.setPreferredAeModeAsync(m119isFlashUnitOnRaJ5uN0(mode) ? 1 : null);
            AeMode aeModeM162fromIntOrNullkQd0u18 = AeMode.INSTANCE.m162fromIntOrNullkQd0u18(this.state3AControl.getFinalSupportedAeMode());
            if (aeModeM162fromIntOrNullkQd0u18 != null) {
                iM164getONbOjpiJc = aeModeM162fromIntOrNullkQd0u18.m160unboximpl();
            } else {
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "TorchControl#setTorchAsync: Failed to convert ae mode of value " + this.state3AControl.getFinalSupportedAeMode() + " with AeMode.fromIntOrNull, fallback to AeMode.ON");
                }
                iM164getONbOjpiJc = AeMode.INSTANCE.m164getONbOjpiJc();
            }
            if (m119isFlashUnitOnRaJ5uN0(mode)) {
                if (TorchMode.m128equalsimpl0(mode, TorchMode.INSTANCE.m133getONIRs_R8())) {
                    Integer value = getTorchStrengthLiveData().getValue();
                    if (value != null) {
                        updateTorchStrengthLevelAsync(value.intValue());
                    }
                } else {
                    updateTorchStrengthLevelAsync(this.defaultTorchStrength);
                }
                deferredMo111setTorchOffAsyncMtizInI = useCaseCameraRequestControl.setTorchOnAsync();
            } else {
                deferredMo111setTorchOffAsyncMtizInI = useCaseCameraRequestControl.mo111setTorchOffAsyncMtizInI(iM164getONbOjpiJc);
            }
            CoroutineAdaptersKt.propagateTo(deferredMo111setTorchOffAsyncMtizInI, completableDeferredCompletableDeferred$default, new Function1() { // from class: androidx.camera.camera2.impl.TorchControl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TorchControl.setTorchAsync_Oup_wC0$lambda$1$3((Result3A) obj);
                }
            });
        } else {
            createFailureResult(completableDeferredCompletableDeferred$default, new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return completableDeferredCompletableDeferred$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setTorchAsync_Oup_wC0$lambda$1$3(Result3A it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Deferred<Unit> setTorchStrengthLevelAsync(int level) {
        if (!this.isTorchStrengthSupported) {
            CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            createFailureResult(completableDeferredCompletableDeferred$default, new UnsupportedOperationException("Configuring torch strength is not supported on the device."));
            return completableDeferredCompletableDeferred$default;
        }
        if (1 > level || level > this.maxTorchStrength) {
            CompletableDeferred<Unit> completableDeferredCompletableDeferred$default2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            createFailureResult(completableDeferredCompletableDeferred$default2, new IllegalArgumentException("The given torch strength level is invalid."));
            return completableDeferredCompletableDeferred$default2;
        }
        setLiveDataValue(this._torchStrength, level);
        Integer value = getTorchStateLiveData().getValue();
        if (value != null && value.intValue() == 1) {
            return updateTorchStrengthLevelAsync(level);
        }
        return CompletableDeferredKt.CompletableDeferred(Unit.INSTANCE);
    }

    private final Deferred<Unit> updateTorchStrengthLevelAsync(int level) {
        Deferred parametersAsync$default;
        CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (Build.VERSION.SDK_INT >= 35 && this.isTorchStrengthSupported) {
            if (this._updateTorchStrengthSignal != null) {
                stopTorchStrengthTask();
            }
            this._updateTorchStrengthSignal = completableDeferredCompletableDeferred$default;
            completableDeferredCompletableDeferred$default.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.impl.TorchControl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TorchControl.updateTorchStrengthLevelAsync$lambda$0(this.f$0, (Throwable) obj);
                }
            });
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Api35Compat.setFlashStrengthLevel(linkedHashMap, level);
            UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
            if (useCaseCameraRequestControl == null || (parametersAsync$default = UseCaseCameraRequestControl.setParametersAsync$default(useCaseCameraRequestControl, linkedHashMap, null, null, 6, null)) == null) {
                createFailureResult(completableDeferredCompletableDeferred$default, new CameraControl.OperationCanceledException("Camera is not active."));
            } else {
                CoroutineAdaptersKt.propagateTo(parametersAsync$default, completableDeferredCompletableDeferred$default);
                Unit unit = Unit.INSTANCE;
            }
        } else {
            createFailureResult(completableDeferredCompletableDeferred$default, new UnsupportedOperationException("Configuring torch strength is not supported on the device."));
        }
        return completableDeferredCompletableDeferred$default;
    }

    static final Unit updateTorchStrengthLevelAsync$lambda$0(TorchControl torchControl, Throwable th) {
        torchControl._updateTorchStrengthSignal = null;
        return Unit.INSTANCE;
    }

    private final void stopRunningTaskInternal() {
        stopTorchStateTask();
        stopTorchStrengthTask();
    }

    private final void stopTorchStateTask() {
        CompletableDeferred<Unit> completableDeferred = this._updateTorchStateSignal;
        if (completableDeferred != null) {
            createFailureResult(completableDeferred, new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
        }
        this._updateTorchStateSignal = null;
    }

    private final void stopTorchStrengthTask() {
        CompletableDeferred<Unit> completableDeferred = this._updateTorchStrengthSignal;
        if (completableDeferred != null) {
            createFailureResult(completableDeferred, new CameraControl.OperationCanceledException("There is a new torch strength being set"));
        }
        this._updateTorchStrengthSignal = null;
    }

    private final CompletableDeferred<Unit> createFailureResult(CompletableDeferred<Unit> completableDeferred, Exception exc) {
        completableDeferred.completeExceptionally(exc);
        return completableDeferred;
    }

    /* JADX INFO: renamed from: updateTorchState-RaJ5uN0, reason: not valid java name */
    private final void m121updateTorchStateRaJ5uN0(int mode) {
        this.torchMode = TorchMode.m125boximpl(mode);
        setLiveDataValue(this._torchState, TorchMode.m128equalsimpl0(mode, TorchMode.INSTANCE.m133getONIRs_R8()) ? 1 : 0);
    }

    private final void setLiveDataValue(MutableLiveData<Integer> mutableLiveData, int i) {
        if (Threads.isMainThread()) {
            mutableLiveData.setValue(Integer.valueOf(i));
        } else {
            mutableLiveData.postValue(Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: isFlashUnitOn-RaJ5uN0, reason: not valid java name */
    private final boolean m119isFlashUnitOnRaJ5uN0(int torchState) {
        return !TorchMode.m128equalsimpl0(torchState, TorchMode.INSTANCE.m132getOFFIRs_R8());
    }

    /* JADX INFO: compiled from: TorchControl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/impl/TorchControl$TorchMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class TorchMode {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int OFF = m126constructorimpl(0);
        private static final int ON = m126constructorimpl(1);
        private static final int USED_AS_FLASH = m126constructorimpl(2);
        private final int value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ TorchMode m125boximpl(int i) {
            return new TorchMode(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m126constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m127equalsimpl(int i, Object obj) {
            return (obj instanceof TorchMode) && i == ((TorchMode) obj).m131unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m128equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m129hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m130toStringimpl(int i) {
            return "TorchMode(value=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m127equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m129hashCodeimpl(this.value);
        }

        public String toString() {
            return m130toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m131unboximpl() {
            return this.value;
        }

        /* JADX INFO: compiled from: TorchControl.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/impl/TorchControl$TorchMode$Companion;", "", "<init>", "()V", "OFF", "Landroidx/camera/camera2/impl/TorchControl$TorchMode;", "getOFF-IRs_-R8", "()I", "I", "ON", "getON-IRs_-R8", "USED_AS_FLASH", "getUSED_AS_FLASH-IRs_-R8", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getOFF-IRs_-R8, reason: not valid java name */
            public final int m132getOFFIRs_R8() {
                return TorchMode.OFF;
            }

            /* JADX INFO: renamed from: getON-IRs_-R8, reason: not valid java name */
            public final int m133getONIRs_R8() {
                return TorchMode.ON;
            }

            /* JADX INFO: renamed from: getUSED_AS_FLASH-IRs_-R8, reason: not valid java name */
            public final int m134getUSED_AS_FLASHIRs_R8() {
                return TorchMode.USED_AS_FLASH;
            }
        }

        private /* synthetic */ TorchMode(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }
}
