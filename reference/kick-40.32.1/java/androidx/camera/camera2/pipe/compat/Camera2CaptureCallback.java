package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import kotlin.Metadata;

/* JADX INFO: compiled from: Camera2CaptureCallback.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J'\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001f\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0015H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CaptureCallback;", "", "onCaptureStarted", "", "captureRequest", "Landroid/hardware/camera2/CaptureRequest;", "captureFrameNumber", "", "captureTimestamp", "onCaptureProgressed", "partialCaptureResult", "Landroid/hardware/camera2/CaptureResult;", "onCaptureCompleted", "captureResult", "Landroid/hardware/camera2/TotalCaptureResult;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "onCaptureCompleted-rmrZIYk", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/TotalCaptureResult;J)V", "onCaptureProcessProgressed", "progress", "", "onCaptureFailed", "onCaptureFailed-RuT0dZU", "(Landroid/hardware/camera2/CaptureRequest;J)V", "onCaptureSequenceCompleted", "captureSequenceId", "onCaptureSequenceAborted", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Camera2CaptureCallback {
    /* JADX INFO: renamed from: onCaptureCompleted-rmrZIYk, reason: not valid java name */
    void mo827onCaptureCompletedrmrZIYk(CaptureRequest captureRequest, TotalCaptureResult captureResult, long frameNumber);

    /* JADX INFO: renamed from: onCaptureFailed-RuT0dZU, reason: not valid java name */
    void mo828onCaptureFailedRuT0dZU(CaptureRequest captureRequest, long frameNumber);

    void onCaptureProcessProgressed(CaptureRequest captureRequest, int progress);

    void onCaptureProgressed(CaptureRequest captureRequest, CaptureResult partialCaptureResult);

    void onCaptureSequenceAborted(int captureSequenceId);

    void onCaptureSequenceCompleted(int captureSequenceId, long captureFrameNumber);

    void onCaptureStarted(CaptureRequest captureRequest, long captureFrameNumber, long captureTimestamp);
}
