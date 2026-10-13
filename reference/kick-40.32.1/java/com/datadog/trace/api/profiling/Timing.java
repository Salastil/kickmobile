package com.datadog.trace.api.profiling;

/* JADX INFO: loaded from: classes6.dex */
public interface Timing extends AutoCloseable {

    public static class NoOp implements Timing, QueueTiming {
        public static final Timing INSTANCE = new NoOp();

        @Override // com.datadog.trace.api.profiling.Timing, java.lang.AutoCloseable
        public void close() {
        }

        @Override // com.datadog.trace.api.profiling.QueueTiming
        public void setScheduler(Class<?> cls) {
        }

        @Override // com.datadog.trace.api.profiling.QueueTiming
        public void setTask(Object obj) {
        }
    }

    @Override // java.lang.AutoCloseable
    void close();
}
