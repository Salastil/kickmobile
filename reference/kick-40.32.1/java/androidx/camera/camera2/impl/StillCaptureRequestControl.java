package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.media3.muxer.WebmConstants;
import com.google.common.util.concurrent.ListenableFuture;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: StillCaptureRequestControl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0002()B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J2\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00190\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020\u0016H\u0002J,\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00190\"2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010$J*\u0010%\u001a\u00020\u0016*\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00190\"2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/camera/camera2/impl/StillCaptureRequestControl;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "flashControl", "Landroidx/camera/camera2/impl/FlashControl;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "<init>", "(Landroidx/camera/camera2/impl/FlashControl;Landroidx/camera/camera2/impl/UseCaseThreads;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "_requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "value", "requestControl", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "setRequestControl", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "pendingRequests", "Ljava/util/LinkedList;", "Landroidx/camera/camera2/impl/StillCaptureRequestControl$CaptureRequest;", "reset", "", "issueCaptureRequests", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "Ljava/lang/Void;", "captureConfigs", "Landroidx/camera/core/impl/CaptureConfig;", "captureMode", "", "flashType", "trySubmitPendingRequests", "submitRequest", "Lkotlinx/coroutines/Deferred;", "request", "(Landroidx/camera/camera2/impl/StillCaptureRequestControl$CaptureRequest;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "propagateResultOrEnqueueRequest", "submittedRequest", "currentRequestControl", "CaptureRequest", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StillCaptureRequestControl implements UseCaseCameraControl {
    private UseCaseCameraRequestControl _requestControl;
    private final FlashControl flashControl;
    private final Mutex mutex;
    private final LinkedList<CaptureRequest> pendingRequests;
    private final UseCaseThreads threads;

    /* JADX INFO: compiled from: StillCaptureRequestControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/StillCaptureRequestControl$Bindings;", "", "<init>", "()V", "provideControls", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "control", "Landroidx/camera/camera2/impl/StillCaptureRequestControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @IntoSet
        public abstract UseCaseCameraControl provideControls(StillCaptureRequestControl control);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StillCaptureRequestControl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.StillCaptureRequestControl", f = "StillCaptureRequestControl.kt", i = {0, 0}, l = {144}, m = "submitRequest", n = {"request", "requestControl"}, s = {"L$0", "L$1"}, v = 1)
    static final class C01921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01921(Continuation<? super C01921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StillCaptureRequestControl.this.submitRequest(null, null, this);
        }
    }

    @Inject
    public StillCaptureRequestControl(FlashControl flashControl, UseCaseThreads threads) {
        Intrinsics.checkNotNullParameter(flashControl, "flashControl");
        Intrinsics.checkNotNullParameter(threads, "threads");
        this.flashControl = flashControl;
        this.threads = threads;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.pendingRequests = new LinkedList<>();
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    /* JADX INFO: renamed from: getRequestControl, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void setRequestControl(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        trySubmitPendingRequests();
    }

    /* JADX INFO: compiled from: StillCaptureRequestControl.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00030\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00030\tHÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00030\tHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/camera/camera2/impl/StillCaptureRequestControl$CaptureRequest;", "", "captureConfigs", "", "Landroidx/camera/core/impl/CaptureConfig;", "captureMode", "", "flashType", "result", "Lkotlinx/coroutines/CompletableDeferred;", "Ljava/lang/Void;", "<init>", "(Ljava/util/List;IILkotlinx/coroutines/CompletableDeferred;)V", "getCaptureConfigs", "()Ljava/util/List;", "getCaptureMode", "()I", "getFlashType", "getResult", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class CaptureRequest {
        private final List<CaptureConfig> captureConfigs;
        private final int captureMode;
        private final int flashType;
        private final CompletableDeferred<List<Void>> result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CaptureRequest copy$default(CaptureRequest captureRequest, List list, int i, int i2, CompletableDeferred completableDeferred, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = captureRequest.captureConfigs;
            }
            if ((i3 & 2) != 0) {
                i = captureRequest.captureMode;
            }
            if ((i3 & 4) != 0) {
                i2 = captureRequest.flashType;
            }
            if ((i3 & 8) != 0) {
                completableDeferred = captureRequest.result;
            }
            return captureRequest.copy(list, i, i2, completableDeferred);
        }

        public final List<CaptureConfig> component1() {
            return this.captureConfigs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCaptureMode() {
            return this.captureMode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFlashType() {
            return this.flashType;
        }

        public final CompletableDeferred<List<Void>> component4() {
            return this.result;
        }

        public final CaptureRequest copy(List<CaptureConfig> captureConfigs, int captureMode, int flashType, CompletableDeferred<List<Void>> result) {
            Intrinsics.checkNotNullParameter(captureConfigs, "captureConfigs");
            Intrinsics.checkNotNullParameter(result, "result");
            return new CaptureRequest(captureConfigs, captureMode, flashType, result);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CaptureRequest)) {
                return false;
            }
            CaptureRequest captureRequest = (CaptureRequest) other;
            return Intrinsics.areEqual(this.captureConfigs, captureRequest.captureConfigs) && this.captureMode == captureRequest.captureMode && this.flashType == captureRequest.flashType && Intrinsics.areEqual(this.result, captureRequest.result);
        }

        public int hashCode() {
            return (((((this.captureConfigs.hashCode() * 31) + Integer.hashCode(this.captureMode)) * 31) + Integer.hashCode(this.flashType)) * 31) + this.result.hashCode();
        }

        public String toString() {
            return "CaptureRequest(captureConfigs=" + this.captureConfigs + ", captureMode=" + this.captureMode + ", flashType=" + this.flashType + ", result=" + this.result + ')';
        }

        public CaptureRequest(List<CaptureConfig> captureConfigs, int i, int i2, CompletableDeferred<List<Void>> result) {
            Intrinsics.checkNotNullParameter(captureConfigs, "captureConfigs");
            Intrinsics.checkNotNullParameter(result, "result");
            this.captureConfigs = captureConfigs;
            this.captureMode = i;
            this.flashType = i2;
            this.result = result;
        }

        public final List<CaptureConfig> getCaptureConfigs() {
            return this.captureConfigs;
        }

        public final int getCaptureMode() {
            return this.captureMode;
        }

        public final int getFlashType() {
            return this.flashType;
        }

        public final CompletableDeferred<List<Void>> getResult() {
            return this.result;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.StillCaptureRequestControl$reset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StillCaptureRequestControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.StillCaptureRequestControl$reset$1", f = "StillCaptureRequestControl.kt", i = {0}, l = {222}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"}, v = 1)
    static final class C01911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C01911(Continuation<? super C01911> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StillCaptureRequestControl.this.new C01911(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            StillCaptureRequestControl stillCaptureRequestControl;
            CompletableDeferred<List<Void>> result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = StillCaptureRequestControl.this.mutex;
                StillCaptureRequestControl stillCaptureRequestControl2 = StillCaptureRequestControl.this;
                this.L$0 = mutex2;
                this.L$1 = stillCaptureRequestControl2;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                stillCaptureRequestControl = stillCaptureRequestControl2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                stillCaptureRequestControl = (StillCaptureRequestControl) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (!stillCaptureRequestControl.pendingRequests.isEmpty()) {
                try {
                    CaptureRequest captureRequest = (CaptureRequest) stillCaptureRequestControl.pendingRequests.poll();
                    if (captureRequest != null && (result = captureRequest.getResult()) != null) {
                        Boxing.boxBoolean(result.completeExceptionally(new ImageCaptureException(3, "Capture request is cancelled due to a reset", null)));
                    }
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void reset() {
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new C01911(null), 3, null);
    }

    public final ListenableFuture<List<Void>> issueCaptureRequests(List<CaptureConfig> captureConfigs, int captureMode, int flashType) {
        Intrinsics.checkNotNullParameter(captureConfigs, "captureConfigs");
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new AnonymousClass1(captureConfigs, captureMode, flashType, completableDeferredCompletableDeferred$default, this, null), 3, null);
        ListenableFuture<List<Void>> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(CoroutineAdaptersKt.asListenableFuture$default((Deferred) completableDeferredCompletableDeferred$default, (Object) null, 1, (Object) null));
        Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "nonCancellationPropagating(...)");
        return listenableFutureNonCancellationPropagating;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.StillCaptureRequestControl$issueCaptureRequests$1, reason: invalid class name */
    /* JADX INFO: compiled from: StillCaptureRequestControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.StillCaptureRequestControl$issueCaptureRequests$1", f = "StillCaptureRequestControl.kt", i = {0, 0, 1, 1, 2, 2}, l = {99, 100, 222}, m = "invokeSuspend", n = {"request", "requestControl", "request", "requestControl", "request", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<CaptureConfig> $captureConfigs;
        final /* synthetic */ int $captureMode;
        final /* synthetic */ int $flashType;
        final /* synthetic */ CompletableDeferred<List<Void>> $signal;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ StillCaptureRequestControl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<CaptureConfig> list, int i, int i2, CompletableDeferred<List<Void>> completableDeferred, StillCaptureRequestControl stillCaptureRequestControl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$captureConfigs = list;
            this.$captureMode = i;
            this.$flashType = i2;
            this.$signal = completableDeferred;
            this.this$0 = stillCaptureRequestControl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$captureConfigs, this.$captureMode, this.$flashType, this.$signal, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x009a  */
        /* JADX WARN: Code duplicated, block: B:28:0x009e  */
        /* JADX WARN: Code duplicated, block: B:32:0x00b2 A[PHI: r12
          0x00b2: PHI (r12v2 androidx.camera.camera2.impl.StillCaptureRequestControl$CaptureRequest) = 
          (r12v1 androidx.camera.camera2.impl.StillCaptureRequestControl$CaptureRequest)
          (r12v3 androidx.camera.camera2.impl.StillCaptureRequestControl$CaptureRequest)
         binds: [B:13:0x0062, B:18:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:39:0x00e2  */
        /* JADX WARN: Instruction removed from duplicated block: B:39:0x00e2, please report this as an issue */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CaptureRequest captureRequest;
            UseCaseCameraRequestControl useCaseCameraRequestControl;
            Object objAwaitSurfaceSetup;
            Mutex mutex;
            StillCaptureRequestControl stillCaptureRequestControl;
            CaptureRequest captureRequest2;
            StillCaptureRequestControl stillCaptureRequestControl2;
            CaptureRequest captureRequest3;
            StillCaptureRequestControl stillCaptureRequestControl3;
            Deferred deferred;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                captureRequest = new CaptureRequest(this.$captureConfigs, this.$captureMode, this.$flashType, this.$signal);
                useCaseCameraRequestControl = this.this$0.get_requestControl();
                if (useCaseCameraRequestControl == null) {
                    mutex = this.this$0.mutex;
                    stillCaptureRequestControl = this.this$0;
                    this.L$0 = captureRequest;
                    this.L$1 = mutex;
                    this.L$2 = stillCaptureRequestControl;
                    this.label = 3;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        captureRequest2 = captureRequest;
                        stillCaptureRequestControl2 = stillCaptureRequestControl;
                        stillCaptureRequestControl2.pendingRequests.add(captureRequest2);
                        mutex.unlock(null);
                        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                        if (Logger.isDebugEnabled(Log.TAG)) {
                            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "StillCaptureRequestControl: useCaseCamera is null, " + captureRequest2 + " will be retried with a future UseCaseCamera");
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    this.L$0 = captureRequest;
                    this.L$1 = useCaseCameraRequestControl;
                    this.label = 1;
                    objAwaitSurfaceSetup = useCaseCameraRequestControl.awaitSurfaceSetup(this);
                    if (objAwaitSurfaceSetup != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    stillCaptureRequestControl3 = (StillCaptureRequestControl) this.L$2;
                    useCaseCameraRequestControl = (UseCaseCameraRequestControl) this.L$1;
                    captureRequest3 = (CaptureRequest) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    deferred = (Deferred) obj;
                    if (useCaseCameraRequestControl != null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    stillCaptureRequestControl3.propagateResultOrEnqueueRequest(deferred, captureRequest3, useCaseCameraRequestControl);
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                stillCaptureRequestControl2 = (StillCaptureRequestControl) this.L$2;
                mutex = (Mutex) this.L$1;
                captureRequest2 = (CaptureRequest) this.L$0;
                ResultKt.throwOnFailure(obj);
                try {
                    stillCaptureRequestControl2.pendingRequests.add(captureRequest2);
                    mutex.unlock(null);
                    Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "StillCaptureRequestControl: useCaseCamera is null, " + captureRequest2 + " will be retried with a future UseCaseCamera");
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            }
            useCaseCameraRequestControl = (UseCaseCameraRequestControl) this.L$1;
            CaptureRequest captureRequest4 = (CaptureRequest) this.L$0;
            ResultKt.throwOnFailure(obj);
            objAwaitSurfaceSetup = obj;
            captureRequest = captureRequest4;
            if (!((Boolean) objAwaitSurfaceSetup).booleanValue()) {
                mutex = this.this$0.mutex;
                stillCaptureRequestControl = this.this$0;
                this.L$0 = captureRequest;
                this.L$1 = mutex;
                this.L$2 = stillCaptureRequestControl;
                this.label = 3;
                if (mutex.lock(null, this) != coroutine_suspended) {
                    captureRequest2 = captureRequest;
                    stillCaptureRequestControl2 = stillCaptureRequestControl;
                    stillCaptureRequestControl2.pendingRequests.add(captureRequest2);
                    mutex.unlock(null);
                    Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                    if (Logger.isDebugEnabled(Log.TAG)) {
                        android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "StillCaptureRequestControl: useCaseCamera is null, " + captureRequest2 + " will be retried with a future UseCaseCamera");
                    }
                    return Unit.INSTANCE;
                }
            } else {
                StillCaptureRequestControl stillCaptureRequestControl4 = this.this$0;
                if (useCaseCameraRequestControl != null) {
                    this.L$0 = captureRequest;
                    this.L$1 = useCaseCameraRequestControl;
                    this.L$2 = stillCaptureRequestControl4;
                    this.label = 2;
                    Object objSubmitRequest = stillCaptureRequestControl4.submitRequest(captureRequest, useCaseCameraRequestControl, this);
                    if (objSubmitRequest != coroutine_suspended) {
                        CaptureRequest captureRequest5 = captureRequest;
                        obj = objSubmitRequest;
                        captureRequest3 = captureRequest5;
                        stillCaptureRequestControl3 = stillCaptureRequestControl4;
                        deferred = (Deferred) obj;
                        if (useCaseCameraRequestControl != null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        stillCaptureRequestControl3.propagateResultOrEnqueueRequest(deferred, captureRequest3, useCaseCameraRequestControl);
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.StillCaptureRequestControl$trySubmitPendingRequests$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StillCaptureRequestControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.StillCaptureRequestControl$trySubmitPendingRequests$1", f = "StillCaptureRequestControl.kt", i = {0, 1, 1, 2, 2, 2, 2}, l = {118, 222, 123}, m = "invokeSuspend", n = {"requestControl", "requestControl", "$this$withLock_u24default$iv", "requestControl", "$this$withLock_u24default$iv", "request", "requestControl"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$3", "L$4"}, v = 1)
    static final class C01931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        C01931(Continuation<? super C01931> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StillCaptureRequestControl.this.new C01931(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00a2 A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:8:0x002a, B:39:0x00c6, B:31:0x0096, B:33:0x00a2, B:35:0x00af, B:40:0x00ce), top: B:46:0x002a }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:48:0x00ce A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c4 -> B:39:0x00c6). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 219
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.StillCaptureRequestControl.C01931.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void trySubmitPendingRequests() {
        BuildersKt__Builders_commonKt.launch$default(this.threads.getSequentialScope(), null, null, new C01931(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object submitRequest(CaptureRequest captureRequest, UseCaseCameraRequestControl useCaseCameraRequestControl, Continuation<? super Deferred<? extends List<Void>>> continuation) {
        C01921 c01921;
        if (continuation instanceof C01921) {
            c01921 = (C01921) continuation;
            if ((c01921.label & Integer.MIN_VALUE) != 0) {
                c01921.label -= Integer.MIN_VALUE;
            } else {
                c01921 = new C01921(continuation);
            }
        } else {
            c01921 = new C01921(continuation);
        }
        Object objAwaitFlashModeUpdate = c01921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01921.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitFlashModeUpdate);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "StillCaptureRequestControl: submitting " + captureRequest + " at " + useCaseCameraRequestControl);
            }
            FlashControl flashControl = this.flashControl;
            c01921.L$0 = captureRequest;
            c01921.L$1 = useCaseCameraRequestControl;
            c01921.label = 1;
            objAwaitFlashModeUpdate = flashControl.awaitFlashModeUpdate(c01921);
            if (objAwaitFlashModeUpdate == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            useCaseCameraRequestControl = (UseCaseCameraRequestControl) c01921.L$1;
            captureRequest = (CaptureRequest) c01921.L$0;
            ResultKt.throwOnFailure(objAwaitFlashModeUpdate);
        }
        int iIntValue = ((Number) objAwaitFlashModeUpdate).intValue();
        Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "StillCaptureRequestControl: Issuing single capture");
        }
        return BuildersKt__Builders_commonKt.async$default(this.threads.getSequentialScope(), null, null, new AnonymousClass4(useCaseCameraRequestControl.issueSingleCaptureAsync(captureRequest.getCaptureConfigs(), captureRequest.getCaptureMode(), captureRequest.getFlashType(), iIntValue), captureRequest, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$4, reason: invalid class name */
    /* JADX INFO: compiled from: StillCaptureRequestControl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Ljava/lang/Void;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$4", f = "StillCaptureRequestControl.kt", i = {}, l = {WebmConstants.MkvEbmlElement.BLOCK_GROUP}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Void>>, Object> {
        final /* synthetic */ List<Deferred<Void>> $deferredList;
        final /* synthetic */ CaptureRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(List<? extends Deferred<Void>> list, CaptureRequest captureRequest, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$deferredList = list;
            this.$request = captureRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$deferredList, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Void>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Void>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Void>> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                CaptureRequest captureRequest = this.$request;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "StillCaptureRequestControl: Waiting for deferred list from " + captureRequest);
                }
                this.label = 1;
                obj = AwaitKt.awaitAll(this.$deferredList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CaptureRequest captureRequest2 = this.$request;
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "StillCaptureRequestControl: Waiting for deferred list from " + captureRequest2 + " done");
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void propagateResultOrEnqueueRequest(final Deferred<? extends List<Void>> deferred, final CaptureRequest captureRequest, final UseCaseCameraRequestControl useCaseCameraRequestControl) {
        deferred.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.impl.StillCaptureRequestControl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StillCaptureRequestControl.propagateResultOrEnqueueRequest$lambda$0(this.f$0, deferred, captureRequest, useCaseCameraRequestControl, (Throwable) obj);
            }
        });
    }

    static final Unit propagateResultOrEnqueueRequest$lambda$0(StillCaptureRequestControl stillCaptureRequestControl, Deferred deferred, CaptureRequest captureRequest, UseCaseCameraRequestControl useCaseCameraRequestControl, Throwable th) {
        if ((th instanceof ImageCaptureException) && ((ImageCaptureException) th).getImageCaptureError() == 3) {
            BuildersKt__Builders_commonKt.launch$default(stillCaptureRequestControl.threads.getSequentialScope(), null, null, new StillCaptureRequestControl$propagateResultOrEnqueueRequest$1$1(stillCaptureRequestControl, useCaseCameraRequestControl, captureRequest, null), 3, null);
        } else {
            CoroutineAdaptersKt.propagateCompletion(deferred, captureRequest.getResult(), th);
        }
        return Unit.INSTANCE;
    }
}
