package com.datadog.android.internal.time;

import android.os.SystemClock;
import kotlin.Metadata;

/* JADX INFO: compiled from: TimeProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/datadog/android/internal/time/BaseTimeProvider;", "Lcom/datadog/android/internal/time/TimeProvider;", "()V", "getDeviceElapsedRealtimeMillis", "", "getDeviceElapsedTimeNanos", "getDeviceTimestampMillis", "getDeviceUptimeMillis", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseTimeProvider implements TimeProvider {
    @Override // com.datadog.android.internal.time.TimeProvider
    public final long getDeviceTimestampMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.datadog.android.internal.time.TimeProvider
    public final long getDeviceElapsedTimeNanos() {
        return System.nanoTime();
    }

    @Override // com.datadog.android.internal.time.TimeProvider
    public final long getDeviceElapsedRealtimeMillis() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.datadog.android.internal.time.TimeProvider
    public final long getDeviceUptimeMillis() {
        return SystemClock.uptimeMillis();
    }
}
