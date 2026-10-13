package com.datadog.android.core.internal.time;

import com.datadog.android.api.context.TimeInfo;
import com.datadog.android.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeProviderExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"composeTimeInfo", "Lcom/datadog/android/api/context/TimeInfo;", "Lcom/datadog/android/internal/time/TimeProvider;", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TimeProviderExtKt {
    public static final TimeInfo composeTimeInfo(TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(timeProvider, "<this>");
        long deviceTimestampMillis = timeProvider.getDeviceTimestampMillis();
        long serverTimestampMillis = timeProvider.getServerTimestampMillis();
        long j = serverTimestampMillis - deviceTimestampMillis;
        return new TimeInfo(TimeUnit.MILLISECONDS.toNanos(deviceTimestampMillis), TimeUnit.MILLISECONDS.toNanos(serverTimestampMillis), TimeUnit.MILLISECONDS.toNanos(j), j);
    }
}
