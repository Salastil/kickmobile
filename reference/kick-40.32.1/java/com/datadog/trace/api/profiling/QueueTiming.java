package com.datadog.trace.api.profiling;

/* JADX INFO: loaded from: classes6.dex */
public interface QueueTiming extends Timing {
    void setScheduler(Class<?> cls);

    void setTask(Object obj);
}
