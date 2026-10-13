package androidx.metrics.performance;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameDataApi31.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J=\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Landroidx/metrics/performance/FrameDataApi31;", "Landroidx/metrics/performance/FrameDataApi24;", "frameStartNanos", "", "frameDurationUiNanos", "frameDurationCpuNanos", "frameDurationTotalNanos", "frameOverrunNanos", "isJank", "", "states", "", "Landroidx/metrics/performance/StateInfo;", "<init>", "(JJJJJZLjava/util/List;)V", "value", "getFrameDurationTotalNanos", "()J", "getFrameOverrunNanos", "copy", "Landroidx/metrics/performance/FrameData;", "update", "", "update$metrics_performance_release", "equals", "other", "", "hashCode", "", "toString", "", "metrics-performance_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrameDataApi31 extends FrameDataApi24 {
    private long frameDurationTotalNanos;
    private long frameOverrunNanos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameDataApi31(long j, long j2, long j3, long j4, long j5, boolean z, List<StateInfo> states) {
        super(j, j2, j3, z, states);
        Intrinsics.checkNotNullParameter(states, "states");
        this.frameDurationTotalNanos = j4;
        this.frameOverrunNanos = j5;
    }

    public final long getFrameDurationTotalNanos() {
        return this.frameDurationTotalNanos;
    }

    public final long getFrameOverrunNanos() {
        return this.frameOverrunNanos;
    }

    @Override // androidx.metrics.performance.FrameDataApi24, androidx.metrics.performance.FrameData
    public FrameData copy() {
        return new FrameDataApi31(getFrameStartNanos(), getFrameDurationUiNanos(), getFrameDurationCpuNanos(), this.frameDurationTotalNanos, this.frameOverrunNanos, getIsJank(), new ArrayList(getStates()));
    }

    public final void update$metrics_performance_release(long frameStartNanos, long frameDurationUiNanos, long frameDurationCpuNanos, long frameDurationTotalNanos, long frameOverrunNanos, boolean isJank) {
        super.update$metrics_performance_release(frameStartNanos, frameDurationUiNanos, frameDurationCpuNanos, isJank);
        this.frameDurationTotalNanos = frameDurationTotalNanos;
        this.frameOverrunNanos = frameOverrunNanos;
    }

    @Override // androidx.metrics.performance.FrameDataApi24, androidx.metrics.performance.FrameData
    public boolean equals(Object other) {
        if (!(other instanceof FrameDataApi31) || !super.equals(other)) {
            return false;
        }
        FrameDataApi31 frameDataApi31 = (FrameDataApi31) other;
        return this.frameDurationTotalNanos == frameDataApi31.frameDurationTotalNanos && this.frameOverrunNanos == frameDataApi31.frameOverrunNanos;
    }

    @Override // androidx.metrics.performance.FrameDataApi24, androidx.metrics.performance.FrameData
    public int hashCode() {
        return (super.hashCode() * 31) + (Long.hashCode(this.frameDurationTotalNanos) * 31) + Long.hashCode(this.frameOverrunNanos);
    }

    @Override // androidx.metrics.performance.FrameDataApi24, androidx.metrics.performance.FrameData
    public String toString() {
        return "FrameData(frameStartNanos=" + getFrameStartNanos() + ", frameDurationUiNanos=" + getFrameDurationUiNanos() + ", frameDurationCpuNanos=" + getFrameDurationCpuNanos() + ", frameDurationTotalNanos=" + this.frameDurationTotalNanos + ", frameOverrunNanos=" + this.frameOverrunNanos + ", isJank=" + getIsJank() + ", states=" + getStates() + ')';
    }
}
