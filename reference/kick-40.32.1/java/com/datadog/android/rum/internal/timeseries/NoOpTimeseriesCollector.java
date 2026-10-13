package com.datadog.android.rum.internal.timeseries;

import com.datadog.android.rum.internal.domain.RumContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpTimeseriesCollector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/NoOpTimeseriesCollector;", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector;", "()V", "onRumContextUpdate", "", "newRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "onSessionStart", "onSessionStop", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpTimeseriesCollector implements TimeseriesCollector {
    @Override // com.datadog.android.rum.internal.timeseries.TimeseriesCollector
    public void onRumContextUpdate(RumContext newRumContext) {
        Intrinsics.checkNotNullParameter(newRumContext, "newRumContext");
    }

    @Override // com.datadog.android.rum.internal.timeseries.TimeseriesCollector
    public void onSessionStart() {
    }

    @Override // com.datadog.android.rum.internal.timeseries.TimeseriesCollector
    public void onSessionStop() {
    }
}
