package com.datadog.android.core.metrics;

import com.datadog.reactnative.DefaultConfiguration;
import kotlin.Metadata;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: compiled from: MethodCallSamplingRate.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/datadog/android/core/metrics/MethodCallSamplingRate;", "", "rate", "", "(Ljava/lang/String;IF)V", "getRate", "()F", Rule.ALL, "HIGH", DefaultConfiguration.batchSize, "LOW", "REDUCED", "RARE", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum MethodCallSamplingRate {
    ALL(100.0f),
    HIGH(10.0f),
    MEDIUM(1.0f),
    LOW(0.1f),
    REDUCED(0.01f),
    RARE(0.001f);

    private final float rate;

    MethodCallSamplingRate(float f) {
        this.rate = f;
    }

    public final float getRate() {
        return this.rate;
    }
}
