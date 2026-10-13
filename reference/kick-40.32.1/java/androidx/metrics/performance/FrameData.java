package androidx.metrics.performance;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameData.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0000H\u0016J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012¨\u0006\u001d"}, d2 = {"Landroidx/metrics/performance/FrameData;", "", "frameStartNanos", "", "frameDurationUiNanos", "isJank", "", "states", "", "Landroidx/metrics/performance/StateInfo;", "<init>", "(JJZLjava/util/List;)V", "getStates", "()Ljava/util/List;", "value", "getFrameStartNanos", "()J", "getFrameDurationUiNanos", "()Z", "copy", "update", "", "update$metrics_performance_release", "equals", "other", "hashCode", "", "toString", "", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class FrameData {
    private long frameDurationUiNanos;
    private long frameStartNanos;
    private boolean isJank;
    private final List<StateInfo> states;

    public FrameData(long j, long j2, boolean z, List<StateInfo> states) {
        Intrinsics.checkNotNullParameter(states, "states");
        this.states = states;
        this.frameStartNanos = j;
        this.frameDurationUiNanos = j2;
        this.isJank = z;
    }

    public final List<StateInfo> getStates() {
        return this.states;
    }

    public final long getFrameStartNanos() {
        return this.frameStartNanos;
    }

    public final long getFrameDurationUiNanos() {
        return this.frameDurationUiNanos;
    }

    /* JADX INFO: renamed from: isJank, reason: from getter */
    public final boolean getIsJank() {
        return this.isJank;
    }

    public FrameData copy() {
        return new FrameData(this.frameStartNanos, this.frameDurationUiNanos, this.isJank, new ArrayList(this.states));
    }

    public final void update$metrics_performance_release(long frameStartNanos, long frameDurationUiNanos, boolean isJank) {
        this.frameStartNanos = frameStartNanos;
        this.frameDurationUiNanos = frameDurationUiNanos;
        this.isJank = isJank;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.metrics.performance.FrameData");
        FrameData frameData = (FrameData) other;
        return this.frameStartNanos == frameData.frameStartNanos && this.frameDurationUiNanos == frameData.frameDurationUiNanos && this.isJank == frameData.isJank && Intrinsics.areEqual(this.states, frameData.states);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.frameStartNanos) * 31) + Long.hashCode(this.frameDurationUiNanos)) * 31) + Boolean.hashCode(this.isJank)) * 31) + this.states.hashCode();
    }

    public String toString() {
        return "FrameData(frameStartNanos=" + this.frameStartNanos + ", frameDurationUiNanos=" + this.frameDurationUiNanos + ", isJank=" + this.isJank + ", states=" + this.states + ')';
    }
}
