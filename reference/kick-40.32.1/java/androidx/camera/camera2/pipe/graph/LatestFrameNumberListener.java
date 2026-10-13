package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.FrameNumber;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LatestFrameListeners.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/graph/LatestFrameNumberListener;", "Landroidx/camera/camera2/pipe/Request$Listener;", "onNextFrameNumber", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameNumber;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "latestFrameNumber", "", "onStarted", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "timestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "onStarted-uGKBvU4", "(Landroidx/camera/camera2/pipe/RequestMetadata;JJ)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LatestFrameNumberListener implements Request.Listener {
    private long latestFrameNumber;
    private final Function1<FrameNumber, Unit> onNextFrameNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public LatestFrameNumberListener(Function1<? super FrameNumber, Unit> onNextFrameNumber) {
        Intrinsics.checkNotNullParameter(onNextFrameNumber, "onNextFrameNumber");
        this.onNextFrameNumber = onNextFrameNumber;
        this.latestFrameNumber = Long.MIN_VALUE;
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onStarted-uGKBvU4 */
    public void mo87onStarteduGKBvU4(RequestMetadata requestMetadata, long frameNumber, long timestamp) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        if (requestMetadata.getRequest().getInputRequest() != null) {
            return;
        }
        synchronized (this) {
            if (frameNumber > this.latestFrameNumber) {
                this.latestFrameNumber = frameNumber;
                this.onNextFrameNumber.invoke(FrameNumber.m531boximpl(frameNumber));
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
