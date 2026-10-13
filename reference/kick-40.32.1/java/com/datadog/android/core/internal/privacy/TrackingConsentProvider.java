package com.datadog.android.core.internal.privacy;

import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrackingConsentProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/core/internal/privacy/TrackingConsentProvider;", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "Lcom/datadog/android/privacy/TrackingConsent;", "(Lcom/datadog/android/privacy/TrackingConsent;)V", "callbacks", "Ljava/util/LinkedList;", "Lcom/datadog/android/privacy/TrackingConsentProviderCallback;", "getConsent", "notifyCallbacks", "", "previous", "new", "registerCallback", "callback", "setConsent", "unregisterAllCallbacks", "unregisterCallback", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrackingConsentProvider implements ConsentProvider {
    private final LinkedList<TrackingConsentProviderCallback> callbacks;
    private volatile TrackingConsent consent;

    public TrackingConsentProvider(TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        this.callbacks = new LinkedList<>();
        this.consent = consent;
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public TrackingConsent getConsent() {
        return this.consent;
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public synchronized void setConsent(TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        if (consent == this.consent) {
            return;
        }
        TrackingConsent trackingConsent = this.consent;
        this.consent = consent;
        notifyCallbacks(trackingConsent, consent);
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public synchronized void registerCallback(TrackingConsentProviderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.add(callback);
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public synchronized void unregisterCallback(TrackingConsentProviderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.remove(callback);
    }

    @Override // com.datadog.android.core.internal.privacy.ConsentProvider
    public synchronized void unregisterAllCallbacks() {
        this.callbacks.clear();
    }

    private final void notifyCallbacks(TrackingConsent previous, TrackingConsent trackingConsent) {
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((TrackingConsentProviderCallback) it.next()).onConsentUpdated(previous, trackingConsent);
        }
    }
}
