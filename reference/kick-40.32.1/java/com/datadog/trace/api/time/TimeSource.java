package com.datadog.trace.api.time;

/* JADX INFO: loaded from: classes6.dex */
public interface TimeSource {
    long getCurrentTimeMicros();

    long getCurrentTimeMillis();

    long getCurrentTimeNanos();

    long getNanoTicks();
}
