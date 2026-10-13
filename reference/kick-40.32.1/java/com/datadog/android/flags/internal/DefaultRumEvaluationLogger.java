package com.datadog.android.flags.internal;

import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.internal.flags.RumFlagEvaluationMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumEvaluationLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/flags/internal/DefaultRumEvaluationLogger;", "Lcom/datadog/android/flags/internal/RumEvaluationLogger;", "featureScope", "Lcom/datadog/android/api/feature/FeatureScope;", "(Lcom/datadog/android/api/feature/FeatureScope;)V", "logEvaluation", "", "flagKey", "", "value", "", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultRumEvaluationLogger implements RumEvaluationLogger {
    private final FeatureScope featureScope;

    public DefaultRumEvaluationLogger(FeatureScope featureScope) {
        Intrinsics.checkNotNullParameter(featureScope, "featureScope");
        this.featureScope = featureScope;
    }

    @Override // com.datadog.android.flags.internal.RumEvaluationLogger
    public void logEvaluation(String flagKey, Object value) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(value, "value");
        this.featureScope.sendEvent(new RumFlagEvaluationMessage(flagKey, value));
    }
}
