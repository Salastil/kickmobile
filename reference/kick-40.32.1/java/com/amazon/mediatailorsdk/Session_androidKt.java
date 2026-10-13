package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Session.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¨\u0006\n"}, d2 = {"createSessionObject", "Lcom/amazon/mediatailorsdk/Session;", "playbackUrl", "", "trackingUrl", "palNonce", "palNonceManager", "Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;", "tracker", "Lcom/amazon/mediatailorsdk/SessionTracker;", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class Session_androidKt {
    public static final Session createSessionObject(String str, String str2, String str3, PalNonceManagerWrapper palNonceManagerWrapper, SessionTracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        return new Session(str, str2, str3, palNonceManagerWrapper, tracker);
    }
}
