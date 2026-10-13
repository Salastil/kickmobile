package com.datadog.android.rum.internal;

import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CombinedRumSessionListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/CombinedRumSessionListener;", "Lcom/datadog/android/rum/RumSessionListener;", "listeners", "", "([Lcom/datadog/android/rum/RumSessionListener;)V", "[Lcom/datadog/android/rum/RumSessionListener;", "onSessionStarted", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "", "isDiscarded", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CombinedRumSessionListener implements RumSessionListener {
    private final RumSessionListener[] listeners;

    public CombinedRumSessionListener(RumSessionListener... listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.listeners = listeners;
    }

    @Override // com.datadog.android.rum.RumSessionListener
    public void onSessionStarted(String sessionId, boolean isDiscarded) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        for (RumSessionListener rumSessionListener : this.listeners) {
            rumSessionListener.onSessionStarted(sessionId, isDiscarded);
        }
    }
}
