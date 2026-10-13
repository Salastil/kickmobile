package com.datadog.android.core.internal.privacy;

import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConsentProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "", "getConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "registerCallback", "", "callback", "Lcom/datadog/android/privacy/TrackingConsentProviderCallback;", "setConsent", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "unregisterAllCallbacks", "unregisterCallback", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ConsentProvider {
    TrackingConsent getConsent();

    void registerCallback(TrackingConsentProviderCallback callback);

    void setConsent(TrackingConsent consent);

    void unregisterAllCallbacks();

    void unregisterCallback(TrackingConsentProviderCallback callback);
}
