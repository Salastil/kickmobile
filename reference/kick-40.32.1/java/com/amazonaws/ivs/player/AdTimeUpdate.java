package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
public final class AdTimeUpdate {
    private final String adBreakId;
    private final String assetId;
    private final long breakDuration;
    private final long breakElapsed;
    private final long creativeDuration;
    private final long creativeElapsed;
    private final int podIndex;
    private final int podLength;

    AdTimeUpdate(String str, String str2, long j, long j2, long j3, long j4, int i, int i2) {
        this.adBreakId = str;
        this.assetId = str2;
        this.breakElapsed = j;
        this.breakDuration = j2;
        this.creativeElapsed = j3;
        this.creativeDuration = j4;
        this.podIndex = i;
        this.podLength = i2;
    }

    public String getAdBreakId() {
        return this.adBreakId;
    }

    public String getAssetId() {
        return this.assetId;
    }

    public long getBreakElapsed() {
        return this.breakElapsed;
    }

    public long getBreakDuration() {
        return this.breakDuration;
    }

    public long getCreativeElapsed() {
        return this.creativeElapsed;
    }

    public long getCreativeDuration() {
        return this.creativeDuration;
    }

    public int getPodIndex() {
        return this.podIndex;
    }

    public int getPodLength() {
        return this.podLength;
    }
}
