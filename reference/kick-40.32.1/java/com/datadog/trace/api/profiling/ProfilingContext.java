package com.datadog.trace.api.profiling;

/* JADX INFO: loaded from: classes6.dex */
public interface ProfilingContext {
    default void clearContextValue(ProfilingContextAttribute profilingContextAttribute) {
    }

    default void clearContextValue(String str) {
    }

    default void setContextValue(ProfilingContextAttribute profilingContextAttribute, String str) {
    }

    default void setContextValue(String str, String str2) {
    }
}
