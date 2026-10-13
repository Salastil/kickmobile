package androidx.camera.camera2.pipe.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;

/* JADX INFO: compiled from: OutputMatcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputMatcher;", "", "initialOffset", "", "errorDelta", "<init>", "(JJ)V", "currentOffset", "Lkotlinx/atomicfu/AtomicRef;", "fuzzyEqual", "", "cameraOutputNumber", "outputNumber", "fuzzyLessThan", "fuzzyLessThanOrEqual", "fuzzyGreaterThanOrEqual", "sensorTimestampNs", "imageTimestampNs", "fuzzyGreaterThan", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OutputMatcher {
    private static final long DEFAULT_ERROR_NS = 8333333;
    private static final long ERROR_DETECTION_FPS = 60;
    private static final long NS_PER_SECOND = 1000000000;
    private final AtomicRef<Long> currentOffset;
    private final long errorDelta;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final OutputMatcher EXACT = new OutputMatcher(0, 0);

    public OutputMatcher(long j, long j2) {
        this.errorDelta = j2;
        this.currentOffset = AtomicFU.atomic(Long.valueOf(j));
    }

    public /* synthetic */ OutputMatcher(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, j2);
    }

    public final boolean fuzzyEqual(long cameraOutputNumber, long outputNumber) {
        long jLongValue = this.currentOffset.getValue().longValue();
        long j = (cameraOutputNumber - outputNumber) + jLongValue;
        if (j == 0) {
            return true;
        }
        long j2 = this.errorDelta;
        if (j2 == 0 || j >= j2 || j <= (-j2)) {
            return false;
        }
        this.currentOffset.compareAndSet(Long.valueOf(jLongValue), Long.valueOf(jLongValue - j));
        return true;
    }

    public final boolean fuzzyLessThan(long cameraOutputNumber, long outputNumber) {
        return ((outputNumber - cameraOutputNumber) - this.currentOffset.getValue().longValue()) + this.errorDelta < 0;
    }

    public final boolean fuzzyLessThanOrEqual(long cameraOutputNumber, long outputNumber) {
        return ((outputNumber - cameraOutputNumber) - this.currentOffset.getValue().longValue()) - this.errorDelta <= 0;
    }

    public final boolean fuzzyGreaterThanOrEqual(long sensorTimestampNs, long imageTimestampNs) {
        return !fuzzyLessThan(sensorTimestampNs, imageTimestampNs);
    }

    public final boolean fuzzyGreaterThan(long sensorTimestampNs, long imageTimestampNs) {
        return !fuzzyLessThanOrEqual(sensorTimestampNs, imageTimestampNs);
    }

    /* JADX INFO: compiled from: OutputMatcher.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/pipe/internal/OutputMatcher$Companion;", "", "<init>", "()V", "EXACT", "Landroidx/camera/camera2/pipe/internal/OutputMatcher;", "getEXACT", "()Landroidx/camera/camera2/pipe/internal/OutputMatcher;", "forTimestampsWithOffset", "initialOffset", "", "errorDelta", "NS_PER_SECOND", "ERROR_DETECTION_FPS", "DEFAULT_ERROR_NS", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OutputMatcher getEXACT() {
            return OutputMatcher.EXACT;
        }

        public static /* synthetic */ OutputMatcher forTimestampsWithOffset$default(Companion companion, long j, long j2, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = OutputMatcher.DEFAULT_ERROR_NS;
            }
            return companion.forTimestampsWithOffset(j, j2);
        }

        public final OutputMatcher forTimestampsWithOffset(long initialOffset, long errorDelta) {
            return new OutputMatcher(initialOffset, errorDelta);
        }
    }
}
