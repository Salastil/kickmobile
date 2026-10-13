package com.datadog.trace.common.sampling;

import com.datadog.trace.core.CoreSpan;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DeterministicSampler implements RateSampler {
    private static final long KNUTH_FACTOR = 1111111111111111111L;
    private static final double MAX = Math.pow(2.0d, 64.0d) - 1.0d;
    private final float rate;

    protected abstract <T extends CoreSpan<T>> long getSamplingId(T t);

    public static final class TraceSampler extends DeterministicSampler {
        public TraceSampler(double d) {
            super(d);
        }

        @Override // com.datadog.trace.common.sampling.DeterministicSampler
        protected <T extends CoreSpan<T>> long getSamplingId(T t) {
            return t.getTraceId().toLong();
        }
    }

    public static final class SpanSampler extends DeterministicSampler {
        public SpanSampler(double d) {
            super(d);
        }

        @Override // com.datadog.trace.common.sampling.DeterministicSampler
        protected <T extends CoreSpan<T>> long getSamplingId(T t) {
            return t.getSpanId();
        }
    }

    public DeterministicSampler(double d) {
        this.rate = (float) d;
    }

    @Override // com.datadog.trace.common.sampling.Sampler
    public <T extends CoreSpan<T>> boolean sample(T t) {
        return (getSamplingId(t) * 1111111111111111111L) + Long.MIN_VALUE < cutoff((double) this.rate);
    }

    @Override // com.datadog.trace.common.sampling.RateSampler
    public double getSampleRate() {
        return this.rate;
    }

    public static long cutoff(double d) {
        if (d < 0.5d) {
            return ((long) (d * MAX)) - Long.MIN_VALUE;
        }
        if (d < 1.0d) {
            return (long) ((d * MAX) - 9.223372036854776E18d);
        }
        return Long.MAX_VALUE;
    }
}
