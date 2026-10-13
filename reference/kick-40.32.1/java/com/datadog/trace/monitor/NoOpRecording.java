package com.datadog.trace.monitor;

/* JADX INFO: loaded from: classes6.dex */
public class NoOpRecording extends Recording {
    public static final Recording NO_OP = new NoOpRecording();

    @Override // com.datadog.trace.monitor.Recording
    public void flush() {
    }

    @Override // com.datadog.trace.monitor.Recording
    public void reset() {
    }

    @Override // com.datadog.trace.monitor.Recording
    public Recording start() {
        return this;
    }

    @Override // com.datadog.trace.monitor.Recording
    public void stop() {
    }
}
