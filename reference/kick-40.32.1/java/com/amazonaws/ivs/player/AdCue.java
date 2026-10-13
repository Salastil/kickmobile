package com.amazonaws.ivs.player;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class AdCue extends Cue {
    public final String adUrl;
    public final String advertiserId;
    public final String clickTrackingUrl;
    public final String creativeId;
    public final long duration;
    public final String lineItemId;
    public final String orderId;
    public final int podCount;
    public final int podPosition;
    public final RollType rollType;
    public final String trackingUrlComplete;
    public final String trackingUrlStart;

    enum RollType {
        PRE,
        MID,
        POST
    }

    public AdCue(long j, long j2, RollType rollType, long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2) {
        super(j, j2);
        this.rollType = rollType;
        this.duration = j3;
        this.adUrl = str;
        this.advertiserId = str2;
        this.creativeId = str3;
        this.lineItemId = str4;
        this.orderId = str5;
        this.clickTrackingUrl = str6;
        this.trackingUrlStart = str7;
        this.trackingUrlComplete = str8;
        this.podPosition = i;
        this.podCount = i2;
    }

    @Override // com.amazonaws.ivs.player.Cue
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdCue) || !super.equals(obj)) {
            return false;
        }
        AdCue adCue = (AdCue) obj;
        return this.rollType == adCue.rollType && this.duration == adCue.duration && Objects.equals(this.adUrl, adCue.adUrl) && Objects.equals(this.advertiserId, adCue.advertiserId) && Objects.equals(this.creativeId, adCue.creativeId) && Objects.equals(this.lineItemId, adCue.lineItemId) && Objects.equals(this.orderId, adCue.orderId) && Objects.equals(this.clickTrackingUrl, adCue.clickTrackingUrl) && Objects.equals(this.trackingUrlStart, adCue.trackingUrlStart) && Objects.equals(this.trackingUrlComplete, adCue.trackingUrlComplete) && this.podPosition == adCue.podPosition && this.podCount == adCue.podCount;
    }

    @Override // com.amazonaws.ivs.player.Cue
    public int hashCode() {
        return Objects.hash(Long.valueOf(this.startTime), Long.valueOf(this.endTime), this.rollType, Long.valueOf(this.duration), this.adUrl, this.advertiserId, this.creativeId, this.lineItemId, this.orderId, this.clickTrackingUrl, this.trackingUrlStart, this.trackingUrlComplete, Integer.valueOf(this.podPosition), Integer.valueOf(this.podCount));
    }
}
