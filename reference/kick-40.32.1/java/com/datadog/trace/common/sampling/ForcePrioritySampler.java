package com.datadog.trace.common.sampling;

import com.datadog.trace.core.CoreSpan;

/* JADX INFO: loaded from: classes6.dex */
public class ForcePrioritySampler implements Sampler, PrioritySampler {
    final int prioritySampling;
    final int samplingMechanism;

    @Override // com.datadog.trace.common.sampling.Sampler
    public <T extends CoreSpan<T>> boolean sample(T t) {
        return true;
    }

    public ForcePrioritySampler(int i, int i2) {
        this.prioritySampling = i;
        this.samplingMechanism = i2;
    }

    @Override // com.datadog.trace.common.sampling.PrioritySampler
    public <T extends CoreSpan<T>> void setSamplingPriority(T t) {
        t.mo11187setSamplingPriority(this.prioritySampling, this.samplingMechanism);
    }
}
