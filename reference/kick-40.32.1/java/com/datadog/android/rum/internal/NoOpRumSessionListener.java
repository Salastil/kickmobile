package com.datadog.android.rum.internal;

import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpRumSessionListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/rum/internal/NoOpRumSessionListener;", "Lcom/datadog/android/rum/RumSessionListener;", "()V", "equals", "", "other", "", "hashCode", "", "onSessionStarted", "", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "", "isDiscarded", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpRumSessionListener implements RumSessionListener {
    public int hashCode() {
        return 0;
    }

    @Override // com.datadog.android.rum.RumSessionListener
    public void onSessionStarted(String sessionId, boolean isDiscarded) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    public boolean equals(Object other) {
        return other != null && (other instanceof NoOpRumSessionListener);
    }
}
