package com.datadog.trace.common.sampling;

import com.datadog.trace.core.CoreSpan;

/* JADX INFO: loaded from: classes6.dex */
public class AllSampler implements Sampler {
    @Override // com.datadog.trace.common.sampling.Sampler
    public <T extends CoreSpan<T>> boolean sample(T t) {
        return true;
    }

    public String toString() {
        return "AllSampler { sample=true }";
    }
}
