package com.datadog.android.rum.internal.timeseries.provider;

import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.internal.vitals.CpuStatReader;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CpuDatapointReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0015¢\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/provider/CpuDatapointReader;", "Lcom/datadog/android/rum/internal/timeseries/provider/DataPointsReader;", "", "cpuStatReader", "Lcom/datadog/android/rum/internal/vitals/CpuStatReader;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "intervalMs", "", "availableProcessors", "", "(Lcom/datadog/android/rum/internal/vitals/CpuStatReader;Lcom/datadog/android/internal/time/TimeProvider;JI)V", "getIntervalMs", "()J", "lastNs", "Ljava/lang/Long;", "lastUtime", "Ljava/lang/Double;", "readValue", "()Ljava/lang/Double;", "updateValues", "Lkotlin/Pair;", "cpuTicks", "nowNs", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CpuDatapointReader extends DataPointsReader<Double> {
    private static final double MAX_CPU_PERCENT = 100.0d;
    public static final int MAX_GAP_FACTOR = 2;
    private static final double MS_PER_SECOND = 1000.0d;
    private static final long NS_PER_MS = 1000000;
    private final int availableProcessors;
    private final CpuStatReader cpuStatReader;
    private final long intervalMs;
    private Long lastNs;
    private Double lastUtime;
    private final TimeProvider timeProvider;

    @Override // com.datadog.android.rum.internal.timeseries.provider.DataPointsReader
    public long getIntervalMs() {
        return this.intervalMs;
    }

    public /* synthetic */ CpuDatapointReader(CpuStatReader cpuStatReader, TimeProvider timeProvider, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(cpuStatReader, timeProvider, j, (i2 & 8) != 0 ? Runtime.getRuntime().availableProcessors() : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuDatapointReader(CpuStatReader cpuStatReader, TimeProvider timeProvider, long j, int i) {
        super(timeProvider);
        Intrinsics.checkNotNullParameter(cpuStatReader, "cpuStatReader");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.cpuStatReader = cpuStatReader;
        this.timeProvider = timeProvider;
        this.intervalMs = j;
        this.availableProcessors = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.datadog.android.rum.internal.timeseries.provider.DataPointsReader
    public Double readValue() {
        Double activeTime = this.cpuStatReader.readActiveTime();
        if (activeTime != null) {
            double dDoubleValue = activeTime.doubleValue();
            long deviceElapsedTimeNanos = this.timeProvider.getDeviceElapsedTimeNanos();
            Pair<Double, Long> pairUpdateValues = updateValues(dDoubleValue, deviceElapsedTimeNanos);
            Double dComponent1 = pairUpdateValues.component1();
            Long lComponent2 = pairUpdateValues.component2();
            if (dComponent1 != null && lComponent2 != null) {
                long jCoerceAtLeast = RangesKt.coerceAtLeast((deviceElapsedTimeNanos - lComponent2.longValue()) / 1000000, 1L);
                if (jCoerceAtLeast > getIntervalMs() * 2) {
                    return null;
                }
                return Double.valueOf(RangesKt.coerceIn((((dDoubleValue - dComponent1.doubleValue()) * 1000.0d) / jCoerceAtLeast) / ((double) RangesKt.coerceAtLeast(this.availableProcessors, 1)), 0.0d, 100.0d));
            }
        }
        return null;
    }

    private final Pair<Double, Long> updateValues(double cpuTicks, long nowNs) {
        Double d = this.lastUtime;
        Long l = this.lastNs;
        this.lastUtime = Double.valueOf(cpuTicks);
        this.lastNs = Long.valueOf(nowNs);
        return TuplesKt.to(d, l);
    }
}
