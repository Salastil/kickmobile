package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.core.DurationNs;
import kotlin.Metadata;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: compiled from: RetryingCameraStateOpener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\n"}, d2 = {"defaultCameraRetryTimeoutNs", "Landroidx/camera/camera2/pipe/core/DurationNs;", "J", "activeResumeCameraRetryTimeoutNs", "defaultCameraRetryDelayMs", "", "activeResumeCameraRetryDelayBaseMs", "activeResumeCameraRetryThresholds", "", "[Landroidx/camera/camera2/pipe/core/DurationNs;", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RetryingCameraStateOpenerKt {
    private static final long activeResumeCameraRetryDelayBaseMs = 500;
    private static final long defaultCameraRetryDelayMs = 500;
    private static final long defaultCameraRetryTimeoutNs = DurationNs.m917constructorimpl(RealConnection.IDLE_CONNECTION_HEALTHY_NS);
    private static final long activeResumeCameraRetryTimeoutNs = DurationNs.m917constructorimpl(1800000000000L);
    private static final DurationNs[] activeResumeCameraRetryThresholds = {DurationNs.m915boximpl(DurationNs.m917constructorimpl(120000000000L)), DurationNs.m915boximpl(DurationNs.m917constructorimpl(300000000000L))};
}
