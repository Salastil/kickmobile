package com.datadog.trace.api.time;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class ControllableTimeSource implements TimeSource {
    private long currentTime = 0;

    public void advance(long j) {
        this.currentTime += j;
    }

    public void set(long j) {
        this.currentTime = j;
    }

    @Override // com.datadog.trace.api.time.TimeSource
    public long getNanoTicks() {
        return this.currentTime;
    }

    @Override // com.datadog.trace.api.time.TimeSource
    public long getCurrentTimeMillis() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return this.currentTime / 1000000;
    }

    @Override // com.datadog.trace.api.time.TimeSource
    public long getCurrentTimeMicros() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return this.currentTime / 1000;
    }

    @Override // com.datadog.trace.api.time.TimeSource
    public long getCurrentTimeNanos() {
        return this.currentTime;
    }
}
