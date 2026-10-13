package com.datadog.android.internal.sampling;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DeterministicSampling.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/datadog/android/internal/sampling/DeterministicSampling;", "", "()V", "SAMPLE_ALL_RATE", "", "combinedSampleRate", "rumSessionSampleRate", "featureSampleRate", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeterministicSampling {
    public static final DeterministicSampling INSTANCE = new DeterministicSampling();
    private static final float SAMPLE_ALL_RATE = 100.0f;

    private DeterministicSampling() {
    }

    public final float combinedSampleRate(float rumSessionSampleRate, float featureSampleRate) {
        return RangesKt.coerceIn((rumSessionSampleRate * featureSampleRate) / 100.0f, 0.0f, 100.0f);
    }
}
