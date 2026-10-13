package com.datadog.android.rum.internal.timeseries.provider;

import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.internal.vitals.VitalReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VitalReaderWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/provider/VitalReaderWrapper;", "Lcom/datadog/android/rum/internal/timeseries/provider/DataPointsReader;", "", "vitalReader", "Lcom/datadog/android/rum/internal/vitals/VitalReader;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "intervalMs", "", "(Lcom/datadog/android/rum/internal/vitals/VitalReader;Lcom/datadog/android/internal/time/TimeProvider;J)V", "getIntervalMs", "()J", "readValue", "()Ljava/lang/Double;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VitalReaderWrapper extends DataPointsReader<Double> {
    private final long intervalMs;
    private final VitalReader vitalReader;

    @Override // com.datadog.android.rum.internal.timeseries.provider.DataPointsReader
    public long getIntervalMs() {
        return this.intervalMs;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VitalReaderWrapper(VitalReader vitalReader, TimeProvider timeProvider, long j) {
        super(timeProvider);
        Intrinsics.checkNotNullParameter(vitalReader, "vitalReader");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.vitalReader = vitalReader;
        this.intervalMs = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.datadog.android.rum.internal.timeseries.provider.DataPointsReader
    public Double readValue() {
        return this.vitalReader.readVitalData();
    }
}
