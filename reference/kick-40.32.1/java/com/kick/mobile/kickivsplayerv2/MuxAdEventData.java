package com.kick.mobile.kickivsplayerv2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MuxAnalyticsListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010 \u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0000J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0084\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010-J\u0014\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u00020\fHÖ\u0081\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0018¨\u00063"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/MuxAdEventData;", "", "eventName", "", "adId", "creativeId", "universalId", "assetUrl", "durationSeconds", "", "elapsedSeconds", "adIndex", "", "adCount", "adStartSeconds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)V", "getEventName", "()Ljava/lang/String;", "getAdId", "getCreativeId", "getUniversalId", "getAssetUrl", "getDurationSeconds", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getElapsedSeconds", "getAdIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAdCount", "getAdStartSeconds", "fillingMissingFields", "fallback", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/kick/mobile/kickivsplayerv2/MuxAdEventData;", "equals", "", "other", "hashCode", "toString", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MuxAdEventData {
    private final Integer adCount;
    private final String adId;
    private final Integer adIndex;
    private final Double adStartSeconds;
    private final String assetUrl;
    private final String creativeId;
    private final Double durationSeconds;
    private final Double elapsedSeconds;
    private final String eventName;
    private final String universalId;

    public static /* synthetic */ MuxAdEventData copy$default(MuxAdEventData muxAdEventData, String str, String str2, String str3, String str4, String str5, Double d, Double d2, Integer num, Integer num2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = muxAdEventData.eventName;
        }
        if ((i & 2) != 0) {
            str2 = muxAdEventData.adId;
        }
        if ((i & 4) != 0) {
            str3 = muxAdEventData.creativeId;
        }
        if ((i & 8) != 0) {
            str4 = muxAdEventData.universalId;
        }
        if ((i & 16) != 0) {
            str5 = muxAdEventData.assetUrl;
        }
        if ((i & 32) != 0) {
            d = muxAdEventData.durationSeconds;
        }
        if ((i & 64) != 0) {
            d2 = muxAdEventData.elapsedSeconds;
        }
        if ((i & 128) != 0) {
            num = muxAdEventData.adIndex;
        }
        if ((i & 256) != 0) {
            num2 = muxAdEventData.adCount;
        }
        if ((i & 512) != 0) {
            d3 = muxAdEventData.adStartSeconds;
        }
        Integer num3 = num2;
        Double d4 = d3;
        Double d5 = d2;
        Integer num4 = num;
        String str6 = str5;
        Double d6 = d;
        return muxAdEventData.copy(str, str2, str3, str4, str6, d6, d5, num4, num3, d4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Double getAdStartSeconds() {
        return this.adStartSeconds;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreativeId() {
        return this.creativeId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUniversalId() {
        return this.universalId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAssetUrl() {
        return this.assetUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getDurationSeconds() {
        return this.durationSeconds;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getElapsedSeconds() {
        return this.elapsedSeconds;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getAdIndex() {
        return this.adIndex;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getAdCount() {
        return this.adCount;
    }

    public final MuxAdEventData copy(String eventName, String adId, String creativeId, String universalId, String assetUrl, Double durationSeconds, Double elapsedSeconds, Integer adIndex, Integer adCount, Double adStartSeconds) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new MuxAdEventData(eventName, adId, creativeId, universalId, assetUrl, durationSeconds, elapsedSeconds, adIndex, adCount, adStartSeconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MuxAdEventData)) {
            return false;
        }
        MuxAdEventData muxAdEventData = (MuxAdEventData) other;
        return Intrinsics.areEqual(this.eventName, muxAdEventData.eventName) && Intrinsics.areEqual(this.adId, muxAdEventData.adId) && Intrinsics.areEqual(this.creativeId, muxAdEventData.creativeId) && Intrinsics.areEqual(this.universalId, muxAdEventData.universalId) && Intrinsics.areEqual(this.assetUrl, muxAdEventData.assetUrl) && Intrinsics.areEqual((Object) this.durationSeconds, (Object) muxAdEventData.durationSeconds) && Intrinsics.areEqual((Object) this.elapsedSeconds, (Object) muxAdEventData.elapsedSeconds) && Intrinsics.areEqual(this.adIndex, muxAdEventData.adIndex) && Intrinsics.areEqual(this.adCount, muxAdEventData.adCount) && Intrinsics.areEqual((Object) this.adStartSeconds, (Object) muxAdEventData.adStartSeconds);
    }

    public int hashCode() {
        int iHashCode = this.eventName.hashCode() * 31;
        String str = this.adId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.creativeId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.universalId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.assetUrl;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d = this.durationSeconds;
        int iHashCode6 = (iHashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.elapsedSeconds;
        int iHashCode7 = (iHashCode6 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Integer num = this.adIndex;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.adCount;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d3 = this.adStartSeconds;
        return iHashCode9 + (d3 != null ? d3.hashCode() : 0);
    }

    public String toString() {
        return "MuxAdEventData(eventName=" + this.eventName + ", adId=" + this.adId + ", creativeId=" + this.creativeId + ", universalId=" + this.universalId + ", assetUrl=" + this.assetUrl + ", durationSeconds=" + this.durationSeconds + ", elapsedSeconds=" + this.elapsedSeconds + ", adIndex=" + this.adIndex + ", adCount=" + this.adCount + ", adStartSeconds=" + this.adStartSeconds + ")";
    }

    public MuxAdEventData(String eventName, String str, String str2, String str3, String str4, Double d, Double d2, Integer num, Integer num2, Double d3) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.adId = str;
        this.creativeId = str2;
        this.universalId = str3;
        this.assetUrl = str4;
        this.durationSeconds = d;
        this.elapsedSeconds = d2;
        this.adIndex = num;
        this.adCount = num2;
        this.adStartSeconds = d3;
    }

    public /* synthetic */ MuxAdEventData(String str, String str2, String str3, String str4, String str5, Double d, Double d2, Integer num, Integer num2, Double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : d, (i & 64) != 0 ? null : d2, (i & 128) != 0 ? null : num, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? null : d3);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getUniversalId() {
        return this.universalId;
    }

    public final String getAssetUrl() {
        return this.assetUrl;
    }

    public final Double getDurationSeconds() {
        return this.durationSeconds;
    }

    public final Double getElapsedSeconds() {
        return this.elapsedSeconds;
    }

    public final Integer getAdIndex() {
        return this.adIndex;
    }

    public final Integer getAdCount() {
        return this.adCount;
    }

    public final Double getAdStartSeconds() {
        return this.adStartSeconds;
    }

    public final MuxAdEventData fillingMissingFields(MuxAdEventData fallback) {
        if (fallback == null) {
            return this;
        }
        String str = this.adId;
        if (str == null) {
            str = fallback.adId;
        }
        String str2 = str;
        String str3 = this.creativeId;
        if (str3 == null) {
            str3 = fallback.creativeId;
        }
        String str4 = str3;
        String str5 = this.universalId;
        if (str5 == null) {
            str5 = fallback.universalId;
        }
        String str6 = str5;
        String str7 = this.assetUrl;
        if (str7 == null) {
            str7 = fallback.assetUrl;
        }
        String str8 = str7;
        Double d = this.durationSeconds;
        if (d == null) {
            d = fallback.durationSeconds;
        }
        Double d2 = d;
        Double d3 = this.elapsedSeconds;
        if (d3 == null) {
            d3 = fallback.elapsedSeconds;
        }
        Double d4 = d3;
        Integer num = this.adIndex;
        if (num == null) {
            num = fallback.adIndex;
        }
        Integer num2 = num;
        Integer num3 = this.adCount;
        if (num3 == null) {
            num3 = fallback.adCount;
        }
        Integer num4 = num3;
        Double d5 = this.adStartSeconds;
        if (d5 == null) {
            d5 = fallback.adStartSeconds;
        }
        return copy$default(this, null, str2, str4, str6, str8, d2, d4, num2, num4, d5, 1, null);
    }
}
