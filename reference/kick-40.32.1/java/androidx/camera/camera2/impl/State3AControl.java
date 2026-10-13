package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.compat.workaround.AutoFlashAEModeDisabler;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: State3AControl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002KLB!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a032\u0006\u0010\u0011\u001a\u00020\u001eJ\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a032\u0006\u0010\u0011\u001a\u00020\u001eJ\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u001a032\u0006\u0010\u0011\u001a\u00020!J\u001b\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a032\b\u0010\u0011\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u00107J\u001b\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a032\b\u0010\u0011\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u00107J\b\u00109\u001a\u00020\u001aH\u0016J\u0016\u0010:\u001a\u00020\u001a2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<H\u0016J\u0016\u0010>\u001a\u00020\u001e2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020=0<H\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001a03H\u0002J\u0010\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u001cH\u0002J\u0014\u0010C\u001a\u00020\u001a2\n\u0010D\u001a\u00060Ej\u0002`FH\u0002J\u0006\u0010G\u001a\u00020\u001eJ'\u0010H\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001eH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00188\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001c8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020!8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010#R\u0011\u0010%\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0011\u0010*\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b1\u0010/¨\u0006M"}, d2 = {"Landroidx/camera/camera2/impl/State3AControl;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "Landroidx/camera/camera2/impl/UseCaseManager$RunningUseCasesChangeListener;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "aeModeDisabler", "Landroidx/camera/camera2/compat/workaround/AutoFlashAEModeDisabler;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;Landroidx/camera/camera2/compat/workaround/AutoFlashAEModeDisabler;Landroidx/camera/camera2/impl/UseCaseThreads;)V", "getCameraProperties", "()Landroidx/camera/camera2/impl/CameraProperties;", "lock", "", "_requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "value", "requestControl", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "setRequestControl", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "pendingSignals", "", "Lkotlinx/coroutines/CompletableDeferred;", "", "currentRevision", "", "_flashMode", "", "_template", "_tryExternalFlashAeMode", "", "_preferredAeMode", "Ljava/lang/Integer;", "_preferredFocusMode", "flashMode", "getFlashMode", "()I", "template", "getTemplate", "tryExternalFlashAeMode", "getTryExternalFlashAeMode", "()Z", "preferredAeMode", "getPreferredAeMode", "()Ljava/lang/Integer;", "preferredFocusMode", "getPreferredFocusMode", "setFlashModeAsync", "Lkotlinx/coroutines/Deferred;", "setTemplateAsync", "setTryExternalFlashAeModeAsync", "setPreferredAeModeAsync", "(Ljava/lang/Integer;)Lkotlinx/coroutines/Deferred;", "setPreferredFocusModeAsync", "reset", "onRunningUseCasesChanged", "runningUseCases", "", "Landroidx/camera/core/UseCase;", "calculateTemplateFromUseCases", "useCases", "update", "applyUpdate", "myRevision", "failAllPendingSignals", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getFinalSupportedAeMode", "getFinalPreferredAeMode", "(IZLjava/lang/Integer;)I", "getDefaultAfMode", "StateSnapshot", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class State3AControl implements UseCaseCameraControl, UseCaseManager.RunningUseCasesChangeListener {
    private int _flashMode;
    private Integer _preferredAeMode;
    private Integer _preferredFocusMode;
    private UseCaseCameraRequestControl _requestControl;
    private int _template;
    private boolean _tryExternalFlashAeMode;
    private final AutoFlashAEModeDisabler aeModeDisabler;
    private final CameraProperties cameraProperties;
    private long currentRevision;
    private final Object lock;
    private final List<CompletableDeferred<Unit>> pendingSignals;
    private final UseCaseThreads threads;

    /* JADX INFO: compiled from: State3AControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/State3AControl$Bindings;", "", "<init>", "()V", "provideControls", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "state3AControl", "Landroidx/camera/camera2/impl/State3AControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @IntoSet
        public abstract UseCaseCameraControl provideControls(State3AControl state3AControl);
    }

    private final int getDefaultAfMode(int template) {
        return (template == 1 || template != 3) ? 4 : 3;
    }

    @Inject
    public State3AControl(CameraProperties cameraProperties, AutoFlashAEModeDisabler aeModeDisabler, UseCaseThreads threads) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(aeModeDisabler, "aeModeDisabler");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.cameraProperties = cameraProperties;
        this.aeModeDisabler = aeModeDisabler;
        this.threads = threads;
        this.lock = new Object();
        this.pendingSignals = new ArrayList();
        this._flashMode = 2;
        this._template = 1;
    }

    public final CameraProperties getCameraProperties() {
        return this.cameraProperties;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    /* JADX INFO: renamed from: getRequestControl, reason: from getter */
    public UseCaseCameraRequestControl get_useCaseCameraRequestControl() {
        return this._requestControl;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void setRequestControl(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        update();
    }

    public final int getFlashMode() {
        int i;
        synchronized (this.lock) {
            i = this._flashMode;
        }
        return i;
    }

    public final int getTemplate() {
        int i;
        synchronized (this.lock) {
            i = this._template;
        }
        return i;
    }

    public final boolean getTryExternalFlashAeMode() {
        boolean z;
        synchronized (this.lock) {
            z = this._tryExternalFlashAeMode;
        }
        return z;
    }

    public final Integer getPreferredAeMode() {
        Integer num;
        synchronized (this.lock) {
            num = this._preferredAeMode;
        }
        return num;
    }

    public final Integer getPreferredFocusMode() {
        Integer num;
        synchronized (this.lock) {
            num = this._preferredFocusMode;
        }
        return num;
    }

    public final Deferred<Unit> setFlashModeAsync(int value) {
        synchronized (this.lock) {
            this._flashMode = value;
            Unit unit = Unit.INSTANCE;
        }
        return update();
    }

    public final Deferred<Unit> setTemplateAsync(int value) {
        synchronized (this.lock) {
            this._template = value;
            Unit unit = Unit.INSTANCE;
        }
        return update();
    }

    public final Deferred<Unit> setTryExternalFlashAeModeAsync(boolean value) {
        synchronized (this.lock) {
            this._tryExternalFlashAeMode = value;
            Unit unit = Unit.INSTANCE;
        }
        return update();
    }

    public final Deferred<Unit> setPreferredAeModeAsync(Integer value) {
        synchronized (this.lock) {
            this._preferredAeMode = value;
            Unit unit = Unit.INSTANCE;
        }
        return update();
    }

    public final Deferred<Unit> setPreferredFocusModeAsync(Integer value) {
        synchronized (this.lock) {
            this._preferredFocusMode = value;
            Unit unit = Unit.INSTANCE;
        }
        return update();
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void reset() {
        synchronized (this.lock) {
            this._tryExternalFlashAeMode = false;
            this._preferredAeMode = null;
            this._preferredFocusMode = null;
            this._flashMode = 2;
            this._template = 1;
            Unit unit = Unit.INSTANCE;
        }
        update();
    }

    @Override // androidx.camera.camera2.impl.UseCaseManager.RunningUseCasesChangeListener
    public void onRunningUseCasesChanged(Set<? extends UseCase> runningUseCases) {
        Intrinsics.checkNotNullParameter(runningUseCases, "runningUseCases");
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new State3AControl$onRunningUseCasesChanged$$inlined$confineLaunch$1(null, CollectionsKt.toSet(runningUseCases), this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int calculateTemplateFromUseCases(Set<? extends UseCase> useCases) {
        CaptureConfig repeatingCaptureConfig;
        SessionConfig validSessionConfigOrNull = new SessionConfigAdapter(useCases, false, 2, 0 == true ? 1 : 0).getValidSessionConfigOrNull();
        if (validSessionConfigOrNull == null || (repeatingCaptureConfig = validSessionConfigOrNull.getRepeatingCaptureConfig()) == null) {
            return 1;
        }
        Integer numValueOf = Integer.valueOf(repeatingCaptureConfig.getTemplateType());
        Integer num = numValueOf.intValue() != -1 ? numValueOf : null;
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<Unit> update() {
        CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Ref.LongRef longRef = new Ref.LongRef();
        synchronized (this.lock) {
            this.pendingSignals.add(completableDeferredCompletableDeferred$default);
            long j = this.currentRevision + 1;
            this.currentRevision = j;
            longRef.element = j;
            Unit unit = Unit.INSTANCE;
        }
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new State3AControl$update$$inlined$confineLaunch$1(null, this, longRef), 3, null);
        return completableDeferredCompletableDeferred$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyUpdate(long myRevision) {
        boolean z;
        StateSnapshot stateSnapshot;
        final List list;
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_useCaseCameraRequestControl();
        if (useCaseCameraRequestControl == null) {
            failAllPendingSignals(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        synchronized (this.lock) {
            z = myRevision == this.currentRevision;
        }
        if (z) {
            synchronized (this.lock) {
                stateSnapshot = new StateSnapshot(this._flashMode, this._template, this._tryExternalFlashAeMode, this._preferredAeMode, this._preferredFocusMode);
            }
            int finalPreferredAeMode = getFinalPreferredAeMode(stateSnapshot.getFlashMode(), stateSnapshot.getTryExternalFlashAeMode(), stateSnapshot.getPreferredAeMode());
            Integer preferredFocusMode = stateSnapshot.getPreferredFocusMode();
            try {
                Deferred deferredSubmitParameters$default = UseCaseCameraRequestControl.submitParameters$default(useCaseCameraRequestControl, MapsKt.mapOf(TuplesKt.to(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(CameraMetadataIntegrationKt.getSupportedAeMode(this.cameraProperties.getMetadata(), finalPreferredAeMode))), TuplesKt.to(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(CameraMetadataIntegrationKt.getSupportedAfMode(this.cameraProperties.getMetadata(), preferredFocusMode != null ? preferredFocusMode.intValue() : getDefaultAfMode(stateSnapshot.getTemplate())))), TuplesKt.to(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(CameraMetadataIntegrationKt.getSupportedAwbMode(this.cameraProperties.getMetadata(), 1)))), null, null, 6, null);
                synchronized (this.lock) {
                    list = CollectionsKt.toList(this.pendingSignals);
                }
                deferredSubmitParameters$default.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.impl.State3AControl$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return State3AControl.applyUpdate$lambda$3(list, this, (Throwable) obj);
                    }
                });
            } catch (Exception e) {
                failAllPendingSignals(e);
            }
        }
    }

    static final Unit applyUpdate$lambda$3(List list, State3AControl state3AControl, Throwable th) {
        if (th != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((CompletableDeferred) it.next()).completeExceptionally(th);
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((CompletableDeferred) it2.next()).complete(Unit.INSTANCE);
            }
        }
        synchronized (state3AControl.lock) {
            state3AControl.pendingSignals.removeAll(list);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void failAllPendingSignals(Exception e) {
        List list;
        synchronized (this.lock) {
            list = CollectionsKt.toList(this.pendingSignals);
            this.pendingSignals.clear();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((CompletableDeferred) it.next()).completeExceptionally(e);
        }
    }

    public final int getFinalSupportedAeMode() {
        int supportedAeMode;
        synchronized (this.lock) {
            supportedAeMode = CameraMetadataIntegrationKt.getSupportedAeMode(this.cameraProperties.getMetadata(), getFinalPreferredAeMode(this._flashMode, this._tryExternalFlashAeMode, this._preferredAeMode));
        }
        return supportedAeMode;
    }

    private final int getFinalPreferredAeMode(int flashMode, boolean tryExternalFlashAeMode, Integer preferredAeMode) {
        int correctedAeMode;
        if (preferredAeMode != null) {
            correctedAeMode = preferredAeMode.intValue();
        } else if (flashMode != 0) {
            correctedAeMode = flashMode != 1 ? 1 : 3;
        } else {
            correctedAeMode = this.aeModeDisabler.getCorrectedAeMode(2);
        }
        if (tryExternalFlashAeMode && CameraMetadataIntegrationKt.isExternalFlashAeModeSupported(this.cameraProperties.getMetadata())) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "State3AControl.invalidate: trying external flash AE mode.");
            }
            correctedAeMode = 5;
        }
        Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "State3AControl.getFinalPreferredAeMode: preferAeMode = " + correctedAeMode);
        }
        return correctedAeMode;
    }

    /* JADX INFO: compiled from: State3AControl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011JD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Landroidx/camera/camera2/impl/State3AControl$StateSnapshot;", "", "flashMode", "", "template", "tryExternalFlashAeMode", "", "preferredAeMode", "preferredFocusMode", "<init>", "(IIZLjava/lang/Integer;Ljava/lang/Integer;)V", "getFlashMode", "()I", "getTemplate", "getTryExternalFlashAeMode", "()Z", "getPreferredAeMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreferredFocusMode", "component1", "component2", "component3", "component4", "component5", "copy", "(IIZLjava/lang/Integer;Ljava/lang/Integer;)Landroidx/camera/camera2/impl/State3AControl$StateSnapshot;", "equals", "other", "hashCode", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class StateSnapshot {
        private final int flashMode;
        private final Integer preferredAeMode;
        private final Integer preferredFocusMode;
        private final int template;
        private final boolean tryExternalFlashAeMode;

        public static /* synthetic */ StateSnapshot copy$default(StateSnapshot stateSnapshot, int i, int i2, boolean z, Integer num, Integer num2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = stateSnapshot.flashMode;
            }
            if ((i3 & 2) != 0) {
                i2 = stateSnapshot.template;
            }
            if ((i3 & 4) != 0) {
                z = stateSnapshot.tryExternalFlashAeMode;
            }
            if ((i3 & 8) != 0) {
                num = stateSnapshot.preferredAeMode;
            }
            if ((i3 & 16) != 0) {
                num2 = stateSnapshot.preferredFocusMode;
            }
            Integer num3 = num2;
            boolean z2 = z;
            return stateSnapshot.copy(i, i2, z2, num, num3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getFlashMode() {
            return this.flashMode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTemplate() {
            return this.template;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getTryExternalFlashAeMode() {
            return this.tryExternalFlashAeMode;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getPreferredAeMode() {
            return this.preferredAeMode;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getPreferredFocusMode() {
            return this.preferredFocusMode;
        }

        public final StateSnapshot copy(int flashMode, int template, boolean tryExternalFlashAeMode, Integer preferredAeMode, Integer preferredFocusMode) {
            return new StateSnapshot(flashMode, template, tryExternalFlashAeMode, preferredAeMode, preferredFocusMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateSnapshot)) {
                return false;
            }
            StateSnapshot stateSnapshot = (StateSnapshot) other;
            return this.flashMode == stateSnapshot.flashMode && this.template == stateSnapshot.template && this.tryExternalFlashAeMode == stateSnapshot.tryExternalFlashAeMode && Intrinsics.areEqual(this.preferredAeMode, stateSnapshot.preferredAeMode) && Intrinsics.areEqual(this.preferredFocusMode, stateSnapshot.preferredFocusMode);
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.flashMode) * 31) + Integer.hashCode(this.template)) * 31) + Boolean.hashCode(this.tryExternalFlashAeMode)) * 31;
            Integer num = this.preferredAeMode;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.preferredFocusMode;
            return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "StateSnapshot(flashMode=" + this.flashMode + ", template=" + this.template + ", tryExternalFlashAeMode=" + this.tryExternalFlashAeMode + ", preferredAeMode=" + this.preferredAeMode + ", preferredFocusMode=" + this.preferredFocusMode + ')';
        }

        public StateSnapshot(int i, int i2, boolean z, Integer num, Integer num2) {
            this.flashMode = i;
            this.template = i2;
            this.tryExternalFlashAeMode = z;
            this.preferredAeMode = num;
            this.preferredFocusMode = num2;
        }

        public final int getFlashMode() {
            return this.flashMode;
        }

        public final int getTemplate() {
            return this.template;
        }

        public final boolean getTryExternalFlashAeMode() {
            return this.tryExternalFlashAeMode;
        }

        public final Integer getPreferredAeMode() {
            return this.preferredAeMode;
        }

        public final Integer getPreferredFocusMode() {
            return this.preferredFocusMode;
        }
    }
}
