package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.Frame;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* JADX INFO: compiled from: ListenerState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/camera/camera2/pipe/internal/ListenerState;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/camera2/pipe/Frame$Listener;", "<init>", "(Landroidx/camera/camera2/pipe/Frame$Listener;)V", "getListener", "()Landroidx/camera/camera2/pipe/Frame$Listener;", "isStarted", "Lkotlinx/atomicfu/AtomicBoolean;", "isImagesInvoked", "isFrameInfoInvoked", "isCompletedInvoked", "invokeOnStarted", "", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "frameTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "invokeOnStarted-cfZT-5Y", "(JJ)V", "invokeOnImagesAvailable", "invokeOnImagesAvailable-cfZT-5Y", "invokeOnFrameInfoAvailable", "invokeOnFrameInfoAvailable-cfZT-5Y", "invokeOnFrameComplete", "invokeOnFrameComplete-cfZT-5Y", "invokeOnImageAvailable", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "invokeOnImageAvailable-aKI5c8E", "(I)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListenerState {
    private final AtomicBoolean isCompletedInvoked;
    private final AtomicBoolean isFrameInfoInvoked;
    private final AtomicBoolean isImagesInvoked;
    private final AtomicBoolean isStarted;
    private final Frame.Listener listener;

    public ListenerState(Frame.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.isStarted = AtomicFU.atomic(false);
        this.isImagesInvoked = AtomicFU.atomic(false);
        this.isFrameInfoInvoked = AtomicFU.atomic(false);
        this.isCompletedInvoked = AtomicFU.atomic(false);
    }

    public final Frame.Listener getListener() {
        return this.listener;
    }

    /* JADX INFO: renamed from: invokeOnStarted-cfZT-5Y, reason: not valid java name */
    public final void m1024invokeOnStartedcfZT5Y(long frameNumber, long frameTimestamp) {
        if (this.isStarted.compareAndSet(false, true)) {
            this.listener.m516onFrameStartedcfZT5Y(frameNumber, frameTimestamp);
        }
    }

    /* JADX INFO: renamed from: invokeOnImagesAvailable-cfZT-5Y, reason: not valid java name */
    public final void m1023invokeOnImagesAvailablecfZT5Y(long frameNumber, long frameTimestamp) {
        m1024invokeOnStartedcfZT5Y(frameNumber, frameTimestamp);
        if (this.isImagesInvoked.compareAndSet(false, true)) {
            this.listener.onImagesAvailable();
        }
    }

    /* JADX INFO: renamed from: invokeOnFrameInfoAvailable-cfZT-5Y, reason: not valid java name */
    public final void m1021invokeOnFrameInfoAvailablecfZT5Y(long frameNumber, long frameTimestamp) {
        m1024invokeOnStartedcfZT5Y(frameNumber, frameTimestamp);
        if (this.isFrameInfoInvoked.compareAndSet(false, true)) {
            this.listener.onFrameInfoAvailable();
        }
    }

    /* JADX INFO: renamed from: invokeOnFrameComplete-cfZT-5Y, reason: not valid java name */
    public final void m1020invokeOnFrameCompletecfZT5Y(long frameNumber, long frameTimestamp) {
        m1023invokeOnImagesAvailablecfZT5Y(frameNumber, frameTimestamp);
        m1021invokeOnFrameInfoAvailablecfZT5Y(frameNumber, frameTimestamp);
        if (this.isCompletedInvoked.compareAndSet(false, true)) {
            this.listener.onFrameComplete();
        }
    }

    /* JADX INFO: renamed from: invokeOnImageAvailable-aKI5c8E, reason: not valid java name */
    public final void m1022invokeOnImageAvailableaKI5c8E(int streamId) {
        this.listener.m517onImageAvailableaKI5c8E(streamId);
    }
}
