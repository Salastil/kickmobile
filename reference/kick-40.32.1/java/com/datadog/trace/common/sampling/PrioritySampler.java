package com.datadog.trace.common.sampling;

import com.datadog.trace.core.CoreSpan;

/* JADX INFO: loaded from: classes6.dex */
public interface PrioritySampler {
    <T extends CoreSpan<T>> void setSamplingPriority(T t);
}
