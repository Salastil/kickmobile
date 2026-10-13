package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
public final class AdCreative {
    private final String adBreakId;
    private final String assetId;
    private final long duration;
    private final AdCreativeMetadata metadata;
    private final int podIndex;
    private final long requiredViewTime;
    private final boolean skippable;
    private final long skippableDuration;

    AdCreative(String str, String str2, int i, long j, boolean z, long j2, long j3, AdCreativeMetadata adCreativeMetadata) {
        this.adBreakId = str;
        this.assetId = str2;
        this.podIndex = i;
        this.duration = j;
        this.skippable = z;
        this.requiredViewTime = j2;
        this.skippableDuration = j3;
        this.metadata = adCreativeMetadata;
    }

    public String getAdBreakId() {
        return this.adBreakId;
    }

    public String getAssetId() {
        return this.assetId;
    }

    public int getPodIndex() {
        return this.podIndex;
    }

    public long getDuration() {
        return this.duration;
    }

    public boolean isSkippable() {
        return this.skippable;
    }

    public long getRequiredViewTime() {
        return this.requiredViewTime;
    }

    public long getSkippableDuration() {
        return this.skippableDuration;
    }

    public AdCreativeMetadata getMetadata() {
        return this.metadata;
    }
}
