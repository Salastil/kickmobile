package androidx.camera.camera2.compat;

import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.RequestMetadata;
import dagger.Binds;
import dagger.Module;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: Camera2CameraControlCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0010J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J$\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/compat/Camera2CameraControlCompat;", "Landroidx/camera/camera2/pipe/Request$Listener;", "addRequestOption", "", "bundle", "Landroidx/camera/camera2/interop/CaptureRequestOptions;", "getRequestOption", "clearRequestOption", "cancelCurrentTask", "applyAsync", "Lkotlinx/coroutines/Deferred;", "Ljava/lang/Void;", "requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "cancelPreviousTask", "", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Camera2CameraControlCompat extends Request.Listener {

    /* JADX INFO: compiled from: Camera2CameraControlCompat.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/compat/Camera2CameraControlCompat$Bindings;", "", "<init>", "()V", "bindCamera2CameraControlCompImpl", "Landroidx/camera/camera2/compat/Camera2CameraControlCompat;", "impl", "Landroidx/camera/camera2/compat/Camera2CameraControlCompatImpl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        public abstract Camera2CameraControlCompat bindCamera2CameraControlCompImpl(Camera2CameraControlCompatImpl impl);
    }

    void addRequestOption(CaptureRequestOptions bundle);

    Deferred<Void> applyAsync(UseCaseCameraRequestControl requestControl, boolean cancelPreviousTask);

    void cancelCurrentTask();

    void clearRequestOption();

    CaptureRequestOptions getRequestOption();

    /* JADX INFO: compiled from: Camera2CameraControlCompat.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onAborted(Camera2CameraControlCompat camera2CameraControlCompat, Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Camera2CameraControlCompat.super.onAborted(request);
        }

        @Deprecated(message = "Use the onBufferLost with OutputId.")
        @Deprecated
        /* JADX INFO: renamed from: onBufferLost-DlC0U5Y, reason: not valid java name */
        public static void m63onBufferLostDlC0U5Y(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, long j, int i) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Camera2CameraControlCompat.super.m696onBufferLostDlC0U5Y(requestMetadata, j, i);
        }

        @Deprecated
        /* JADX INFO: renamed from: onBufferLost-iiEMlm4, reason: not valid java name */
        public static void m64onBufferLostiiEMlm4(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, long j, int i, int i2) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Camera2CameraControlCompat.super.mo83onBufferLostiiEMlm4(requestMetadata, j, i, i2);
        }

        @Deprecated
        public static void onCaptureProgress(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, int i) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Camera2CameraControlCompat.super.onCaptureProgress(requestMetadata, i);
        }

        @Deprecated
        /* JADX INFO: renamed from: onComplete-CcXjc1I, reason: not valid java name */
        public static void m65onCompleteCcXjc1I(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, long j, FrameInfo result) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(result, "result");
            Camera2CameraControlCompat.super.mo49onCompleteCcXjc1I(requestMetadata, j, result);
        }

        @Deprecated
        /* JADX INFO: renamed from: onFailed-CcXjc1I, reason: not valid java name */
        public static void m66onFailedCcXjc1I(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, long j, RequestFailure requestFailure) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
            Camera2CameraControlCompat.super.mo50onFailedCcXjc1I(requestMetadata, j, requestFailure);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPartialCaptureResult-CcXjc1I, reason: not valid java name */
        public static void m67onPartialCaptureResultCcXjc1I(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, long j, FrameMetadata captureResult) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(captureResult, "captureResult");
            Camera2CameraControlCompat.super.mo84onPartialCaptureResultCcXjc1I(requestMetadata, j, captureResult);
        }

        @Deprecated
        /* JADX INFO: renamed from: onReadoutStarted-mP9r-9w, reason: not valid java name */
        public static void m68onReadoutStartedmP9r9w(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, long j, long j2) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Camera2CameraControlCompat.super.mo85onReadoutStartedmP9r9w(requestMetadata, j, j2);
        }

        @Deprecated
        public static void onRequestSequenceAborted(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Camera2CameraControlCompat.super.onRequestSequenceAborted(requestMetadata);
        }

        @Deprecated
        /* JADX INFO: renamed from: onRequestSequenceCompleted-RuT0dZU, reason: not valid java name */
        public static void m69onRequestSequenceCompletedRuT0dZU(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, long j) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Camera2CameraControlCompat.super.mo86onRequestSequenceCompletedRuT0dZU(requestMetadata, j);
        }

        @Deprecated
        public static void onRequestSequenceCreated(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Camera2CameraControlCompat.super.onRequestSequenceCreated(requestMetadata);
        }

        @Deprecated
        public static void onRequestSequenceSubmitted(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Camera2CameraControlCompat.super.onRequestSequenceSubmitted(requestMetadata);
        }

        @Deprecated
        /* JADX INFO: renamed from: onStarted-uGKBvU4, reason: not valid java name */
        public static void m70onStarteduGKBvU4(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, long j, long j2) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Camera2CameraControlCompat.super.mo87onStarteduGKBvU4(requestMetadata, j, j2);
        }

        @Deprecated
        /* JADX INFO: renamed from: onTotalCaptureResult-CcXjc1I, reason: not valid java name */
        public static void m71onTotalCaptureResultCcXjc1I(Camera2CameraControlCompat camera2CameraControlCompat, RequestMetadata requestMetadata, long j, FrameInfo totalCaptureResult) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
            Camera2CameraControlCompat.super.mo51onTotalCaptureResultCcXjc1I(requestMetadata, j, totalCaptureResult);
        }
    }

    static /* synthetic */ Deferred applyAsync$default(Camera2CameraControlCompat camera2CameraControlCompat, UseCaseCameraRequestControl useCaseCameraRequestControl, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyAsync");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return camera2CameraControlCompat.applyAsync(useCaseCameraRequestControl, z);
    }
}
