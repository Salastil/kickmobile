package androidx.camera.camera2.pipe.graph;

import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.core.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicLong;

/* JADX INFO: compiled from: CaptureLimiter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Landroidx/camera/camera2/pipe/graph/CaptureLimiter;", "Landroidx/camera/camera2/pipe/Request$Listener;", "Landroidx/camera/camera2/pipe/graph/GraphLoop$Listener;", "requestsUntilActive", "", "<init>", "(J)V", "frameCount", "Lkotlinx/atomicfu/AtomicLong;", "_graphLoop", "Landroidx/camera/camera2/pipe/graph/GraphLoop;", "value", "graphLoop", "getGraphLoop", "()Landroidx/camera/camera2/pipe/graph/GraphLoop;", "setGraphLoop", "(Landroidx/camera/camera2/pipe/graph/GraphLoop;)V", "onComplete", "", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "result", "Landroidx/camera/camera2/pipe/FrameInfo;", "onComplete-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameInfo;)V", "onStopRepeating", "onGraphStopped", "onGraphShutdown", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureLimiter implements Request.Listener, GraphLoop.Listener {
    private GraphLoop _graphLoop;
    private final AtomicLong frameCount;
    private final long requestsUntilActive;

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.Listener
    public void onStopRepeating() {
    }

    public CaptureLimiter(long j) {
        this.requestsUntilActive = j;
        if (j <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.frameCount = AtomicFU.atomic(0L);
    }

    public final GraphLoop getGraphLoop() {
        GraphLoop graphLoop = this._graphLoop;
        Intrinsics.checkNotNull(graphLoop);
        return graphLoop;
    }

    public final void setGraphLoop(GraphLoop value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this._graphLoop != null) {
            throw new IllegalStateException("GraphLoop has already been set!".toString());
        }
        this._graphLoop = value;
        value.setCaptureProcessingEnabled(false);
        if (Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Capture processing has been disabled for " + value + " until " + this.requestsUntilActive + " frames have been completed.");
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onComplete-CcXjc1I */
    public void mo49onCompleteCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo result) {
        long value;
        long j;
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(result, "result");
        AtomicLong atomicLong = this.frameCount;
        do {
            value = atomicLong.getValue();
            j = value != -1 ? 1 + value : -1L;
        } while (!atomicLong.compareAndSet(value, j));
        if (j == this.requestsUntilActive) {
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Capture processing is now enabled for " + this._graphLoop + " after " + j + " frames.");
            }
            getGraphLoop().setCaptureProcessingEnabled(true);
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.Listener
    public void onGraphStopped() {
        long value;
        AtomicLong atomicLong = this.frameCount;
        do {
            value = atomicLong.getValue();
        } while (!atomicLong.compareAndSet(value, value != -1 ? 0L : -1L));
        getGraphLoop().setCaptureProcessingEnabled(false);
        if (Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Capture processing has been disabled for " + getGraphLoop() + " until " + this.requestsUntilActive + " frames have been completed.");
        }
    }

    @Override // androidx.camera.camera2.pipe.graph.GraphLoop.Listener
    public void onGraphShutdown() {
        this.frameCount.setValue(-1L);
        getGraphLoop().setCaptureProcessingEnabled(false);
    }
}
