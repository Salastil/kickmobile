package com.datadog.trace.api.time;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class SystemTimeSource implements TimeSource {
    public static final TimeSource INSTANCE = new SystemTimeSource();

    private SystemTimeSource() {
    }

    @Override // com.datadog.trace.api.time.TimeSource
    public long getNanoTicks() {
        return System.nanoTime();
    }

    @Override // com.datadog.trace.api.time.TimeSource
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.datadog.trace.api.time.TimeSource
    public long getCurrentTimeMicros() {
        return TimeUnit.MILLISECONDS.toMicros(getCurrentTimeMillis());
    }

    @Override // com.datadog.trace.api.time.TimeSource
    public long getCurrentTimeNanos() {
        return TimeUnit.MILLISECONDS.toNanos(getCurrentTimeMillis());
    }
}
