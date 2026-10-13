package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.EvCompValue;
import androidx.camera.camera2.compat.EvCompCompat;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.core.CameraControl;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import expo.modules.notifications.service.NotificationsService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: EvCompControl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 2\n\u0010!\u001a\u00060\"j\u0002`#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Landroidx/camera/camera2/impl/EvCompControl;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "compat", "Landroidx/camera/camera2/compat/EvCompCompat;", "<init>", "(Landroidx/camera/camera2/compat/EvCompCompat;)V", "value", "", "evCompIndex", "setEvCompIndex", "(I)V", "exposureState", "Landroidx/camera/camera2/adapter/EvCompValue;", "getExposureState", "()Landroidx/camera/camera2/adapter/EvCompValue;", "setExposureState", "(Landroidx/camera/camera2/adapter/EvCompValue;)V", "_requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "setRequestControl", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "reset", "", "updateAsync", "Lkotlinx/coroutines/Deferred;", "exposureIndex", "cancelPreviousTask", "", "createFailureResult", "Lkotlinx/coroutines/CompletableDeferred;", NotificationsService.EXCEPTION_KEY, "Ljava/lang/Exception;", "Lkotlin/Exception;", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EvCompControl implements UseCaseCameraControl {
    private UseCaseCameraRequestControl _requestControl;
    private final EvCompCompat compat;
    private int evCompIndex;
    private EvCompValue exposureState;

    /* JADX INFO: compiled from: EvCompControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/EvCompControl$Bindings;", "", "<init>", "()V", "provideControls", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "evCompControl", "Landroidx/camera/camera2/impl/EvCompControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @IntoSet
        public abstract UseCaseCameraControl provideControls(EvCompControl evCompControl);
    }

    @Inject
    public EvCompControl(EvCompCompat compat) {
        Intrinsics.checkNotNullParameter(compat, "compat");
        this.compat = compat;
        this.exposureState = new EvCompValue(compat.getSupported(), this.evCompIndex, compat.getRange(), compat.getStep());
    }

    private final void setEvCompIndex(int i) {
        this.evCompIndex = i;
        this.exposureState = this.exposureState.updateIndex$camera_camera2(i);
    }

    public final EvCompValue getExposureState() {
        return this.exposureState;
    }

    public final void setExposureState(EvCompValue evCompValue) {
        Intrinsics.checkNotNullParameter(evCompValue, "<set-?>");
        this.exposureState = evCompValue;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    /* JADX INFO: renamed from: getRequestControl, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void setRequestControl(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        updateAsync(this.evCompIndex, false);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void reset() {
        setEvCompIndex(0);
        updateAsync$default(this, 0, false, 2, null);
    }

    public static /* synthetic */ Deferred updateAsync$default(EvCompControl evCompControl, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return evCompControl.updateAsync(i, z);
    }

    public final Deferred<Integer> updateAsync(int exposureIndex, boolean cancelPreviousTask) {
        if (!this.compat.getSupported()) {
            return createFailureResult(new IllegalArgumentException("ExposureCompensation is not supported"));
        }
        if (!this.compat.getRange().contains(Integer.valueOf(exposureIndex))) {
            return createFailureResult(new IllegalArgumentException("Requested ExposureCompensation " + exposureIndex + " is not within valid range [" + this.compat.getRange().getUpper() + " .. " + this.compat.getRange().getLower() + AbstractJsonLexerKt.END_LIST));
        }
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
        if (useCaseCameraRequestControl != null) {
            setEvCompIndex(exposureIndex);
            Deferred<Integer> deferredApplyAsync = this.compat.applyAsync(exposureIndex, useCaseCameraRequestControl, cancelPreviousTask);
            if (deferredApplyAsync != null) {
                return deferredApplyAsync;
            }
        }
        CameraControl.OperationCanceledException operationCanceledException = new CameraControl.OperationCanceledException("Camera is not active.");
        this.compat.stopRunningTask(operationCanceledException);
        return createFailureResult(operationCanceledException);
    }

    private final CompletableDeferred<Integer> createFailureResult(Exception exception) {
        CompletableDeferred<Integer> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        completableDeferredCompletableDeferred$default.completeExceptionally(exception);
        return completableDeferredCompletableDeferred$default;
    }
}
