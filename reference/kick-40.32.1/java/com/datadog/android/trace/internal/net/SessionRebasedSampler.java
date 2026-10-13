package com.datadog.android.trace.internal.net;

import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.internal.sampling.DeterministicSampling;
import com.datadog.android.trace.DeterministicTraceSampler;
import com.datadog.android.trace.api.span.DatadogSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionRebasedSampler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0002J\r\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\fJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/trace/internal/net/SessionRebasedSampler;", "Lcom/datadog/android/core/sampling/Sampler;", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "Lcom/datadog/android/trace/internal/net/SpanAwareSampler;", "delegate", "Lcom/datadog/android/trace/DeterministicTraceSampler;", "(Lcom/datadog/android/trace/DeterministicTraceSampler;)V", "computeEffectiveRate", "", "item", "rawRate", "getSampleRate", "()Ljava/lang/Float;", "span", "(Lcom/datadog/android/trace/api/span/DatadogSpan;)Ljava/lang/Float;", "sample", "", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SessionRebasedSampler implements Sampler<DatadogSpan>, SpanAwareSampler {
    private final DeterministicTraceSampler delegate;

    public SessionRebasedSampler(DeterministicTraceSampler delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // com.datadog.android.core.sampling.Sampler
    public boolean sample(DatadogSpan item) {
        Intrinsics.checkNotNullParameter(item, "item");
        float fFloatValue = this.delegate.getSampleRate().floatValue();
        float fComputeEffectiveRate = computeEffectiveRate(item, fFloatValue);
        if (fComputeEffectiveRate == fFloatValue) {
            return this.delegate.sample(item);
        }
        return new DeterministicTraceSampler(fComputeEffectiveRate).sample(item);
    }

    @Override // com.datadog.android.core.sampling.Sampler
    public Float getSampleRate() {
        return this.delegate.getSampleRate();
    }

    @Override // com.datadog.android.trace.internal.net.SpanAwareSampler
    public Float getSampleRate(DatadogSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        return Float.valueOf(computeEffectiveRate(span, this.delegate.getSampleRate().floatValue()));
    }

    private final float computeEffectiveRate(DatadogSpan item, float rawRate) {
        Object obj = item.context().getTags().get("session_sample_rate");
        Number number = obj instanceof Number ? (Number) obj : null;
        Float fValueOf = number != null ? Float.valueOf(number.floatValue()) : null;
        return fValueOf != null ? DeterministicSampling.INSTANCE.combinedSampleRate(fValueOf.floatValue(), rawRate) : rawRate;
    }
}
