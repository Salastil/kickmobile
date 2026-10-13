package androidx.camera.camera2.compat.workaround;

import android.hardware.camera2.CaptureResult;
import android.os.Build;
import androidx.camera.camera2.compat.quirk.CameraQuirks;
import androidx.camera.camera2.compat.quirk.UltraWideFlashCaptureUnderexposureQuirk;
import androidx.camera.camera2.internal.IntrinsicZoomCalculator;
import androidx.camera.camera2.pipe.CameraDevices;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.core.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UseTorchAsFlash.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ.\u0010\u0010\u001a\u00020\u000b2\u001e\u0010\u0011\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0012H\u0096@¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000b*\u00020\u0014H\u0003¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/compat/workaround/UseTorchAsFlashImpl;", "Landroidx/camera/camera2/compat/workaround/UseTorchAsFlash;", "cameraQuirks", "Landroidx/camera/camera2/compat/quirk/CameraQuirks;", "cameraDevices", "Landroidx/camera/camera2/pipe/CameraDevices;", "intrinsicZoomCalculator", "Landroidx/camera/camera2/internal/IntrinsicZoomCalculator;", "<init>", "(Landroidx/camera/camera2/compat/quirk/CameraQuirks;Landroidx/camera/camera2/pipe/CameraDevices;Landroidx/camera/camera2/internal/IntrinsicZoomCalculator;)V", "hasUwCameraUnderexposedFlashCaptureQuirk", "", "getHasUwCameraUnderexposedFlashCaptureQuirk", "()Z", "hasUwCameraUnderexposedFlashCaptureQuirk$delegate", "Lkotlin/Lazy;", "shouldUseTorchAsFlash", "frameMetadata", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Landroidx/camera/camera2/pipe/FrameMetadata;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUltraWideCamera", "(Landroidx/camera/camera2/pipe/FrameMetadata;)Ljava/lang/Boolean;", "shouldDisableAePrecapture", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UseTorchAsFlashImpl implements UseTorchAsFlash {
    private final CameraDevices cameraDevices;
    private final CameraQuirks cameraQuirks;

    /* JADX INFO: renamed from: hasUwCameraUnderexposedFlashCaptureQuirk$delegate, reason: from kotlin metadata */
    private final Lazy hasUwCameraUnderexposedFlashCaptureQuirk;
    private final IntrinsicZoomCalculator intrinsicZoomCalculator;

    /* JADX INFO: renamed from: androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl$shouldUseTorchAsFlash$1, reason: invalid class name */
    /* JADX INFO: compiled from: UseTorchAsFlash.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl", f = "UseTorchAsFlash.kt", i = {}, l = {113}, m = "shouldUseTorchAsFlash", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UseTorchAsFlashImpl.this.shouldUseTorchAsFlash(null, this);
        }
    }

    public UseTorchAsFlashImpl(CameraQuirks cameraQuirks, CameraDevices cameraDevices, IntrinsicZoomCalculator intrinsicZoomCalculator) {
        Intrinsics.checkNotNullParameter(cameraQuirks, "cameraQuirks");
        Intrinsics.checkNotNullParameter(cameraDevices, "cameraDevices");
        Intrinsics.checkNotNullParameter(intrinsicZoomCalculator, "intrinsicZoomCalculator");
        this.cameraQuirks = cameraQuirks;
        this.cameraDevices = cameraDevices;
        this.intrinsicZoomCalculator = intrinsicZoomCalculator;
        this.hasUwCameraUnderexposedFlashCaptureQuirk = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(this.f$0.cameraQuirks.getQuirks().contains(UltraWideFlashCaptureUnderexposureQuirk.class));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasUwCameraUnderexposedFlashCaptureQuirk() {
        return ((Boolean) this.hasUwCameraUnderexposedFlashCaptureQuirk.getValue()).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.compat.workaround.UseTorchAsFlash
    public Object shouldUseTorchAsFlash(Function1<? super Continuation<? super FrameMetadata>, ? extends Object> function1, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objInvoke = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "shouldUseTorchAsFlash: hasUwCameraUnderexposedFlashCaptureQuirk = " + getHasUwCameraUnderexposedFlashCaptureQuirk());
            }
            if (!getHasUwCameraUnderexposedFlashCaptureQuirk()) {
                return Boxing.boxBoolean(true);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                anonymousClass1.label = 1;
                objInvoke = function1.invoke(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "shouldUseTorchAsFlash: API level is too low to know if it's ultra wide camera, defaulting to workaround for safety.");
                }
                return Boxing.boxBoolean(true);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objInvoke);
        }
        FrameMetadata frameMetadata = (FrameMetadata) objInvoke;
        if (frameMetadata != null) {
            Boolean boolIsUltraWideCamera = isUltraWideCamera(frameMetadata);
            return Boxing.boxBoolean(boolIsUltraWideCamera != null ? boolIsUltraWideCamera.booleanValue() : true);
        }
        if (Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "shouldUseTorchAsFlash: frameMetadata is null, defaulting to workaround for safety.");
        }
        return Boxing.boxBoolean(true);
    }

    private final Boolean isUltraWideCamera(FrameMetadata frameMetadata) {
        CaptureResult.Key LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID = CaptureResult.LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID;
        Intrinsics.checkNotNullExpressionValue(LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID, "LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID");
        String str = (String) frameMetadata.get(LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID);
        if (str != null) {
            CameraMetadata cameraMetadataM312awaitCameraMetadataFpsL5FU$default = CameraDevices.m312awaitCameraMetadataFpsL5FU$default(this.cameraDevices, CameraId.m427constructorimpl(str), null, 2, null);
            if (cameraMetadataM312awaitCameraMetadataFpsL5FU$default != null) {
                Float fCalculateIntrinsicZoomRatio = this.intrinsicZoomCalculator.calculateIntrinsicZoomRatio(cameraMetadataM312awaitCameraMetadataFpsL5FU$default);
                if (fCalculateIntrinsicZoomRatio == null) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "isUltraWideCamera: could not calculate intrinsic zoom ratio.");
                    }
                    return null;
                }
                float fFloatValue = fCalculateIntrinsicZoomRatio.floatValue();
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "isUltraWideCamera: cameraId = " + str + ", intrinsicZoomRatio = " + fFloatValue);
                }
                return Boolean.valueOf(fFloatValue < 1.0f);
            }
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "isUltraWideCamera: failed to get CameraMetadata for " + str);
            }
            return null;
        }
        if (Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "isUltraWideCamera: could not get active physical camera ID to identify if it's ultra wide camera.");
        }
        return null;
    }

    @Override // androidx.camera.camera2.compat.workaround.UseTorchAsFlash
    public boolean shouldDisableAePrecapture() {
        return !getHasUwCameraUnderexposedFlashCaptureQuirk();
    }
}
