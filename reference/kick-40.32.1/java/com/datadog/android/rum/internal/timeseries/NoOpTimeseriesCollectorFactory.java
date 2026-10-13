package com.datadog.android.rum.internal.timeseries;

import com.datadog.android.rum.RumSessionType;
import com.datadog.android.rum.internal.domain.RumContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpTimeseriesCollectorFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/datadog/android/rum/internal/timeseries/NoOpTimeseriesCollectorFactory;", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector$Factory;", "()V", "create", "Lcom/datadog/android/rum/internal/timeseries/TimeseriesCollector;", "sessionType", "Lcom/datadog/android/rum/RumSessionType;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpTimeseriesCollectorFactory implements TimeseriesCollector.Factory {
    @Override // com.datadog.android.rum.internal.timeseries.TimeseriesCollector.Factory
    public TimeseriesCollector create(RumSessionType sessionType, RumContext rumContext) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        return new NoOpTimeseriesCollector();
    }
}
