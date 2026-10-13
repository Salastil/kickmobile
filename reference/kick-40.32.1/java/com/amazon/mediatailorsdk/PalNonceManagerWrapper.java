package com.amazon.mediatailorsdk;

import kotlin.Metadata;

/* JADX INFO: compiled from: PAL.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/amazon/mediatailorsdk/PalNonceManagerWrapper;", "", "getNonce", "", "sendPlaybackStart", "", "sendPlaybackEnd", "sendAdClick", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface PalNonceManagerWrapper {
    String getNonce();

    void sendAdClick();

    void sendPlaybackEnd();

    void sendPlaybackStart();
}
