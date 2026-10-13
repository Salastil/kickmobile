package com.datadog.android.core.internal.privacy;

import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpConsentProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lcom/datadog/android/core/internal/privacy/NoOpConsentProvider;", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "()V", "getConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "registerCallback", "", "callback", "Lcom/datadog/android/privacy/TrackingConsentProviderCallback;", "setConsent", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "unregisterAllCallbacks", "unregisterCallback", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpConsentProvider implements ConsentProvider {
    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public void registerCallback(TrackingConsentProviderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public void setConsent(TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public void unregisterAllCallbacks() {
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public void unregisterCallback(TrackingConsentProviderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public TrackingConsent getConsent() {
        return TrackingConsent.GRANTED;
    }
}
