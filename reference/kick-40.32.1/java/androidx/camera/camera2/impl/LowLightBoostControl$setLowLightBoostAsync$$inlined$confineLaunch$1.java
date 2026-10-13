package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.core.CameraControl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: UseCaseThreads.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/impl/UseCaseThreads$confineLaunch$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.impl.LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1", f = "LowLightBoostControl.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $cancelPreviousTask$inlined;
    final /* synthetic */ boolean $lowLightBoost$inlined;
    final /* synthetic */ CompletableDeferred $signal$inlined;
    int label;
    final /* synthetic */ LowLightBoostControl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1(Continuation continuation, LowLightBoostControl lowLightBoostControl, CompletableDeferred completableDeferred, boolean z, boolean z2) {
        super(2, continuation);
        this.this$0 = lowLightBoostControl;
        this.$signal$inlined = completableDeferred;
        this.$lowLightBoost$inlined = z;
        this.$cancelPreviousTask$inlined = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1(continuation, this.this$0, this.$signal$inlined, this.$lowLightBoost$inlined, this.$cancelPreviousTask$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0055  */
    /* JADX WARN: Code duplicated, block: B:20:0x005e  */
    /* JADX WARN: Code duplicated, block: B:23:0x006f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0073  */
    /* JADX WARN: Code duplicated, block: B:28:0x0082  */
    /* JADX WARN: Code duplicated, block: B:29:0x0086  */
    /* JADX WARN: Code duplicated, block: B:31:0x008c  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean zBooleanValue;
        LowLightBoostControl lowLightBoostControl;
        boolean z;
        LowLightBoostControl lowLightBoostControl2;
        CompletableDeferred completableDeferred;
        Integer numBoxInt;
        CompletableDeferred completableDeferred2;
        final CompletableDeferred completableDeferred3;
        final LowLightBoostControl lowLightBoostControl3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred<Boolean> checkFrameRateJob$camera_camera2 = this.this$0.getCheckFrameRateJob$camera_camera2();
            if (checkFrameRateJob$camera_camera2 != null) {
                this.label = 1;
                obj = checkFrameRateJob$camera_camera2.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                zBooleanValue = false;
            }
            lowLightBoostControl = this.this$0;
            if (zBooleanValue) {
                lowLightBoostControl.setLiveDataValue(lowLightBoostControl._lowLightBoostState, -1);
                this.this$0.createFailureResult(this.$signal$inlined, new IllegalStateException("Low Light Boost is disabled when expected frame rate range exceeds 30."));
            } else {
                lowLightBoostControl.isLowLightBoostOn = this.$lowLightBoost$inlined;
                if (!this.$lowLightBoost$inlined) {
                    LowLightBoostControl lowLightBoostControl4 = this.this$0;
                    lowLightBoostControl4.setLiveDataValue(lowLightBoostControl4._lowLightBoostState, -1);
                }
                if (this.this$0.get_requestControl() == null) {
                    this.this$0.createFailureResult(this.$signal$inlined, new CameraControl.OperationCanceledException("Camera is not active."));
                    Unit unit = Unit.INSTANCE;
                } else {
                    if (this.$lowLightBoost$inlined) {
                        LowLightBoostControl lowLightBoostControl5 = this.this$0;
                        lowLightBoostControl5.setLiveDataValue(lowLightBoostControl5._lowLightBoostState, 0);
                    }
                    z = this.$cancelPreviousTask$inlined;
                    lowLightBoostControl2 = this.this$0;
                    if (z) {
                        lowLightBoostControl2.stopRunningTaskInternal();
                    } else {
                        completableDeferred = lowLightBoostControl2._updateSignal;
                        if (completableDeferred != null) {
                            CoroutineAdaptersKt.propagateTo(this.$signal$inlined, completableDeferred);
                        }
                    }
                    this.this$0._updateSignal = this.$signal$inlined;
                    State3AControl state3AControl = this.this$0.state3AControl;
                    if (this.$lowLightBoost$inlined) {
                        numBoxInt = Boxing.boxInt(6);
                    } else {
                        numBoxInt = null;
                    }
                    CoroutineAdaptersKt.propagateTo(state3AControl.setPreferredAeModeAsync(numBoxInt), this.$signal$inlined);
                    completableDeferred2 = this.$signal$inlined;
                    completableDeferred3 = this.$signal$inlined;
                    lowLightBoostControl3 = this.this$0;
                    if (completableDeferred2.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.camera.camera2.impl.LowLightBoostControl$setLowLightBoostAsync$2$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            if (Intrinsics.areEqual(completableDeferred3, lowLightBoostControl3._updateSignal)) {
                                lowLightBoostControl3._updateSignal = null;
                            }
                        }
                    }) == null) {
                        this.this$0.createFailureResult(this.$signal$inlined, new CameraControl.OperationCanceledException("Camera is not active."));
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        zBooleanValue = ((Boolean) obj).booleanValue();
        lowLightBoostControl = this.this$0;
        if (zBooleanValue) {
            lowLightBoostControl.setLiveDataValue(lowLightBoostControl._lowLightBoostState, -1);
            this.this$0.createFailureResult(this.$signal$inlined, new IllegalStateException("Low Light Boost is disabled when expected frame rate range exceeds 30."));
        } else {
            lowLightBoostControl.isLowLightBoostOn = this.$lowLightBoost$inlined;
            if (!this.$lowLightBoost$inlined) {
                LowLightBoostControl lowLightBoostControl6 = this.this$0;
                lowLightBoostControl6.setLiveDataValue(lowLightBoostControl6._lowLightBoostState, -1);
            }
            if (this.this$0.get_requestControl() == null) {
                this.this$0.createFailureResult(this.$signal$inlined, new CameraControl.OperationCanceledException("Camera is not active."));
                Unit unit3 = Unit.INSTANCE;
            } else {
                if (this.$lowLightBoost$inlined) {
                    LowLightBoostControl lowLightBoostControl7 = this.this$0;
                    lowLightBoostControl7.setLiveDataValue(lowLightBoostControl7._lowLightBoostState, 0);
                }
                z = this.$cancelPreviousTask$inlined;
                lowLightBoostControl2 = this.this$0;
                if (z) {
                    lowLightBoostControl2.stopRunningTaskInternal();
                } else {
                    completableDeferred = lowLightBoostControl2._updateSignal;
                    if (completableDeferred != null) {
                        CoroutineAdaptersKt.propagateTo(this.$signal$inlined, completableDeferred);
                    }
                }
                this.this$0._updateSignal = this.$signal$inlined;
                State3AControl state3AControl2 = this.this$0.state3AControl;
                if (this.$lowLightBoost$inlined) {
                    numBoxInt = Boxing.boxInt(6);
                } else {
                    numBoxInt = null;
                }
                CoroutineAdaptersKt.propagateTo(state3AControl2.setPreferredAeModeAsync(numBoxInt), this.$signal$inlined);
                completableDeferred2 = this.$signal$inlined;
                completableDeferred3 = this.$signal$inlined;
                lowLightBoostControl3 = this.this$0;
                if (completableDeferred2.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.camera.camera2.impl.LowLightBoostControl$setLowLightBoostAsync$2$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        if (Intrinsics.areEqual(completableDeferred3, lowLightBoostControl3._updateSignal)) {
                            lowLightBoostControl3._updateSignal = null;
                        }
                    }
                }) == null) {
                    this.this$0.createFailureResult(this.$signal$inlined, new CameraControl.OperationCanceledException("Camera is not active."));
                    Unit unit4 = Unit.INSTANCE;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
