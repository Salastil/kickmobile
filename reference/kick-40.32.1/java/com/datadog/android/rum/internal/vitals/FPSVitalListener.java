package com.datadog.android.rum.internal.vitals;

import androidx.metrics.performance.FrameData;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.internal.domain.FrameMetricsData;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FPSVitalListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/FPSVitalListener;", "Lcom/datadog/android/rum/internal/vitals/FrameStateListener;", "vitalObserver", "Lcom/datadog/android/rum/internal/vitals/VitalObserver;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "screenRefreshRate", "", "(Lcom/datadog/android/rum/internal/vitals/VitalObserver;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;D)V", "displayRefreshRate", "frameDeadline", "", "onFrame", "", "volatileFrameData", "Landroidx/metrics/performance/FrameData;", "onFrameMetricsData", "data", "Lcom/datadog/android/rum/internal/domain/FrameMetricsData;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FPSVitalListener implements FrameStateListener {
    private static final long EXPECTED_60_FPS_FRAME_DURATION_NS = 16666666;
    private static final double MAX_FPS = 60.0d;
    private static final double MIN_FPS = 1.0d;
    private static final double ONE_SECOND_NS;
    private static final double SIXTY_FPS = 60.0d;
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private double displayRefreshRate;
    private long frameDeadline;
    private double screenRefreshRate;
    private final VitalObserver vitalObserver;

    public FPSVitalListener(VitalObserver vitalObserver, BuildSdkVersionProvider buildSdkVersionProvider, double d) {
        Intrinsics.checkNotNullParameter(vitalObserver, "vitalObserver");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.vitalObserver = vitalObserver;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.screenRefreshRate = d;
        this.frameDeadline = EXPECTED_60_FPS_FRAME_DURATION_NS;
        this.displayRefreshRate = 60.0d;
    }

    public /* synthetic */ FPSVitalListener(VitalObserver vitalObserver, BuildSdkVersionProvider buildSdkVersionProvider, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vitalObserver, (i & 2) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider, (i & 4) != 0 ? 60.0d : d);
    }

    @Override // androidx.metrics.performance.JankStats.OnFrameListener
    public void onFrame(FrameData volatileFrameData) {
        Intrinsics.checkNotNullParameter(volatileFrameData, "volatileFrameData");
        double frameDurationUiNanos = volatileFrameData.getFrameDurationUiNanos();
        if (frameDurationUiNanos > 0.0d) {
            double d = ONE_SECOND_NS;
            double d2 = d / frameDurationUiNanos;
            if (this.buildSdkVersionProvider.getIsAtLeastS()) {
                this.screenRefreshRate = d / this.frameDeadline;
            } else if (this.buildSdkVersionProvider.getVersion() == 30) {
                this.screenRefreshRate = this.displayRefreshRate;
            }
            double dCoerceAtMost = RangesKt.coerceAtMost(d2 * (60.0d / this.screenRefreshRate), 60.0d);
            if (dCoerceAtMost > 1.0d) {
                this.vitalObserver.onNewSample(dCoerceAtMost);
            }
        }
    }

    @Override // com.datadog.android.rum.internal.vitals.FrameMetricsDataListener
    public void onFrameMetricsData(FrameMetricsData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.displayRefreshRate = data.getDisplayRefreshRate();
        if (this.buildSdkVersionProvider.getIsAtLeastS()) {
            this.frameDeadline = data.getDeadline();
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ONE_SECOND_NS = 1.0E9d;
    }
}
