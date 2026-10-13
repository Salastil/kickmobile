package com.datadog.trace.api.profiling;

/* JADX INFO: loaded from: classes6.dex */
public interface ProfilingScope extends AutoCloseable, ProfilingContext {
    public static final ProfilingScope NO_OP = new ProfilingScope() { // from class: com.datadog.trace.api.profiling.ProfilingScope$$ExternalSyntheticLambda0
        @Override // com.datadog.trace.api.profiling.ProfilingScope, java.lang.AutoCloseable
        public final void close() {
            ProfilingScope.lambda$static$0();
        }
    };

    static /* synthetic */ void lambda$static$0() {
    }

    @Override // java.lang.AutoCloseable
    void close();
}
