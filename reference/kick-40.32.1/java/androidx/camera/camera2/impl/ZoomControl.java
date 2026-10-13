package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.adapter.ZoomValue;
import androidx.camera.camera2.compat.ZoomCompat;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.internal.ZoomMath;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ZoomControl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u00017B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010$\u001a\u00020\u0014H\u0002J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u0010!\u001a\u00020\u0007J\u0014\u00102\u001a\b\u0012\u0004\u0012\u000201002\u0006\u0010\u001f\u001a\u00020\u0007J(\u00103\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00104\u001a\u00020\u00142\b\b\u0002\u00105\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010%\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/camera/camera2/impl/ZoomControl;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "zoomCompat", "Landroidx/camera/camera2/compat/ZoomCompat;", "<init>", "(Landroidx/camera/camera2/compat/ZoomCompat;)V", "minZoomRatio", "", "getMinZoomRatio", "()F", "maxZoomRatio", "getMaxZoomRatio", "defaultZoomState", "Landroidx/camera/camera2/adapter/ZoomValue;", "getDefaultZoomState", "()Landroidx/camera/camera2/adapter/ZoomValue;", "defaultZoomState$delegate", "Lkotlin/Lazy;", "_zoomState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/camera/core/ZoomState;", "get_zoomState", "()Landroidx/lifecycle/MutableLiveData;", "_zoomState$delegate", "zoomStateLiveData", "Landroidx/lifecycle/LiveData;", "getZoomStateLiveData", "()Landroidx/lifecycle/LiveData;", "isInitialized", "", "toLinearZoom", "zoomRatio", "toZoomRatio", "linearZoom", "_requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "value", "requestControl", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "setRequestControl", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "updateSignal", "Lkotlinx/coroutines/CompletableDeferred;", "", "reset", "setZoomState", "setLinearZoom", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "setZoomRatio", "applyZoomState", "zoomState", "cancelPreviousTask", "shouldUpdateParameters", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZoomControl implements UseCaseCameraControl {
    private UseCaseCameraRequestControl _requestControl;

    /* JADX INFO: renamed from: _zoomState$delegate, reason: from kotlin metadata */
    private final Lazy _zoomState;

    /* JADX INFO: renamed from: defaultZoomState$delegate, reason: from kotlin metadata */
    private final Lazy defaultZoomState;
    private boolean isInitialized;
    private final float maxZoomRatio;
    private final float minZoomRatio;
    private CompletableDeferred<Unit> updateSignal;
    private final ZoomCompat zoomCompat;

    /* JADX INFO: compiled from: ZoomControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/ZoomControl$Bindings;", "", "<init>", "()V", "provideControls", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "zoomControl", "Landroidx/camera/camera2/impl/ZoomControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @IntoSet
        public abstract UseCaseCameraControl provideControls(ZoomControl zoomControl);
    }

    @Inject
    public ZoomControl(ZoomCompat zoomCompat) {
        Intrinsics.checkNotNullParameter(zoomCompat, "zoomCompat");
        this.zoomCompat = zoomCompat;
        this.minZoomRatio = zoomCompat.getMinZoomRatio();
        this.maxZoomRatio = zoomCompat.getMaxZoomRatio();
        this.defaultZoomState = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.ZoomControl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ZoomControl.defaultZoomState_delegate$lambda$0(this.f$0);
            }
        });
        this._zoomState = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.ZoomControl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ZoomControl._zoomState_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final float getMinZoomRatio() {
        return this.minZoomRatio;
    }

    public final float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    public final ZoomValue getDefaultZoomState() {
        return (ZoomValue) this.defaultZoomState.getValue();
    }

    static final ZoomValue defaultZoomState_delegate$lambda$0(ZoomControl zoomControl) {
        return new ZoomValue(1.0f, zoomControl.minZoomRatio, zoomControl.maxZoomRatio);
    }

    static final MutableLiveData _zoomState_delegate$lambda$0(ZoomControl zoomControl) {
        return new MutableLiveData(zoomControl.getDefaultZoomState());
    }

    private final MutableLiveData<ZoomState> get_zoomState() {
        return (MutableLiveData) this._zoomState.getValue();
    }

    public final LiveData<ZoomState> getZoomStateLiveData() {
        return get_zoomState();
    }

    public final float toLinearZoom(float zoomRatio) {
        return ZoomMath.INSTANCE.getLinearZoomFromZoomRatio(zoomRatio, this.minZoomRatio, this.maxZoomRatio);
    }

    private final float toZoomRatio(float linearZoom) {
        return ZoomMath.INSTANCE.getZoomRatioFromLinearZoom(linearZoom, this.minZoomRatio, this.maxZoomRatio);
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    /* JADX INFO: renamed from: getRequestControl, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void setRequestControl(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        ZoomValue value = get_zoomState().getValue();
        if (value == null) {
            value = getDefaultZoomState();
        }
        applyZoomState(value, false, this.isInitialized || value.getZoomRatio() != 1.0f);
        this.isInitialized = true;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void reset() {
        applyZoomState$default(this, getDefaultZoomState(), false, false, 6, null);
    }

    private final void setZoomState(ZoomState value) {
        if (Threads.isMainThread()) {
            get_zoomState().setValue(value);
        } else {
            get_zoomState().postValue(value);
        }
    }

    public final ListenableFuture<Void> setLinearZoom(float linearZoom) {
        if (linearZoom > 1.0f || linearZoom < 0.0f) {
            ListenableFuture<Void> listenableFutureImmediateFailedFuture = Futures.immediateFailedFuture(new IllegalArgumentException("Requested linearZoom " + linearZoom + " is not within valid range [0, 1]"));
            Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFailedFuture, "immediateFailedFuture(...)");
            return listenableFutureImmediateFailedFuture;
        }
        return applyZoomState$default(this, new ZoomValue(new ZoomValue.LinearZoom(linearZoom), this.minZoomRatio, this.maxZoomRatio), false, false, 6, null);
    }

    public final ListenableFuture<Void> setZoomRatio(float zoomRatio) {
        if (zoomRatio <= this.maxZoomRatio && zoomRatio >= this.minZoomRatio) {
            return applyZoomState$default(this, new ZoomValue(zoomRatio, this.minZoomRatio, this.maxZoomRatio), false, false, 6, null);
        }
        ListenableFuture<Void> listenableFutureImmediateFailedFuture = Futures.immediateFailedFuture(new IllegalArgumentException("Requested zoomRatio " + zoomRatio + " is not within valid range [" + this.minZoomRatio + ", " + this.maxZoomRatio + AbstractJsonLexerKt.END_LIST));
        Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFailedFuture, "immediateFailedFuture(...)");
        return listenableFutureImmediateFailedFuture;
    }

    public static /* synthetic */ ListenableFuture applyZoomState$default(ZoomControl zoomControl, ZoomState zoomState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return zoomControl.applyZoomState(zoomState, z, z2);
    }

    public final ListenableFuture<Void> applyZoomState(ZoomState zoomState, boolean cancelPreviousTask, boolean shouldUpdateParameters) {
        Deferred<Unit> deferredResetAsync;
        Intrinsics.checkNotNullParameter(zoomState, "zoomState");
        CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        CompletableDeferred<Unit> completableDeferred = this.updateSignal;
        if (completableDeferred != null) {
            if (cancelPreviousTask) {
                completableDeferred.completeExceptionally(new CameraControl.OperationCanceledException("Cancelled due to another zoom value being set."));
            } else {
                CoroutineAdaptersKt.propagateTo(completableDeferredCompletableDeferred$default, completableDeferred);
            }
        }
        this.updateSignal = completableDeferredCompletableDeferred$default;
        setZoomState(zoomState);
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
        if (useCaseCameraRequestControl != null) {
            float zoomRatio = zoomState.getZoomRatio();
            ZoomCompat zoomCompat = this.zoomCompat;
            if (shouldUpdateParameters) {
                deferredResetAsync = zoomCompat.applyAsync(zoomRatio, useCaseCameraRequestControl);
            } else {
                deferredResetAsync = zoomCompat.resetAsync(useCaseCameraRequestControl);
            }
            CoroutineAdaptersKt.propagateTo(deferredResetAsync, completableDeferredCompletableDeferred$default);
        } else {
            completableDeferredCompletableDeferred$default.completeExceptionally(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        Intrinsics.checkNotNull(completableDeferredCompletableDeferred$default, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        ListenableFuture<Void> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(CoroutineAdaptersKt.asListenableFuture$default((Job) completableDeferredCompletableDeferred$default, (Object) null, 1, (Object) null));
        Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
        return listenableFutureNonCancellationPropagating;
    }
}
