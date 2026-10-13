package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes9.dex */
public final class AdBreakMetadata {
    private final String sessionId;
    private final String trackingData;

    AdBreakMetadata(String str, String str2) {
        this.sessionId = str;
        this.trackingData = str2;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTrackingData() {
        return this.trackingData;
    }
}
