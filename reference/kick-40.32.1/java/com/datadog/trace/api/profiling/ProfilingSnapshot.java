package com.datadog.trace.api.profiling;

/* JADX INFO: loaded from: classes6.dex */
public interface ProfilingSnapshot extends ObservableType {

    public enum Kind {
        PERIODIC,
        ON_SHUTDOWN
    }
}
