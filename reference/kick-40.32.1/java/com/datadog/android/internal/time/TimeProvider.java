package com.datadog.android.internal.time;

import kotlin.Metadata;

/* JADX INFO: compiled from: TimeProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/datadog/android/internal/time/TimeProvider;", "", "getDeviceElapsedRealtimeMillis", "", "getDeviceElapsedTimeNanos", "getDeviceTimestampMillis", "getDeviceUptimeMillis", "getServerOffsetMillis", "getServerOffsetNanos", "getServerTimestampMillis", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TimeProvider {
    long getDeviceElapsedRealtimeMillis();

    long getDeviceElapsedTimeNanos();

    long getDeviceTimestampMillis();

    long getDeviceUptimeMillis();

    long getServerOffsetMillis();

    long getServerOffsetNanos();

    long getServerTimestampMillis();
}
