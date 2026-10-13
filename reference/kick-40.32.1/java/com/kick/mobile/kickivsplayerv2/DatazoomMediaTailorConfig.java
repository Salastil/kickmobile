package com.kick.mobile.kickivsplayerv2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatazoomAnalyticsManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/DatazoomMediaTailorConfig;", "", "contentUrl", "", "isLivestream", "", "palNonce", "trackingUrl", "userAgent", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContentUrl", "()Ljava/lang/String;", "()Z", "getPalNonce", "getTrackingUrl", "getUserAgent", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DatazoomMediaTailorConfig {
    private final String contentUrl;
    private final boolean isLivestream;
    private final String palNonce;
    private final String trackingUrl;
    private final String userAgent;

    public static /* synthetic */ DatazoomMediaTailorConfig copy$default(DatazoomMediaTailorConfig datazoomMediaTailorConfig, String str, boolean z, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = datazoomMediaTailorConfig.contentUrl;
        }
        if ((i & 2) != 0) {
            z = datazoomMediaTailorConfig.isLivestream;
        }
        if ((i & 4) != 0) {
            str2 = datazoomMediaTailorConfig.palNonce;
        }
        if ((i & 8) != 0) {
            str3 = datazoomMediaTailorConfig.trackingUrl;
        }
        if ((i & 16) != 0) {
            str4 = datazoomMediaTailorConfig.userAgent;
        }
        String str5 = str4;
        String str6 = str2;
        return datazoomMediaTailorConfig.copy(str, z, str6, str3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContentUrl() {
        return this.contentUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsLivestream() {
        return this.isLivestream;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPalNonce() {
        return this.palNonce;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTrackingUrl() {
        return this.trackingUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUserAgent() {
        return this.userAgent;
    }

    public final DatazoomMediaTailorConfig copy(String contentUrl, boolean isLivestream, String palNonce, String trackingUrl, String userAgent) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        return new DatazoomMediaTailorConfig(contentUrl, isLivestream, palNonce, trackingUrl, userAgent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DatazoomMediaTailorConfig)) {
            return false;
        }
        DatazoomMediaTailorConfig datazoomMediaTailorConfig = (DatazoomMediaTailorConfig) other;
        return Intrinsics.areEqual(this.contentUrl, datazoomMediaTailorConfig.contentUrl) && this.isLivestream == datazoomMediaTailorConfig.isLivestream && Intrinsics.areEqual(this.palNonce, datazoomMediaTailorConfig.palNonce) && Intrinsics.areEqual(this.trackingUrl, datazoomMediaTailorConfig.trackingUrl) && Intrinsics.areEqual(this.userAgent, datazoomMediaTailorConfig.userAgent);
    }

    public int hashCode() {
        int iHashCode = ((this.contentUrl.hashCode() * 31) + Boolean.hashCode(this.isLivestream)) * 31;
        String str = this.palNonce;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.trackingUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userAgent;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DatazoomMediaTailorConfig(contentUrl=" + this.contentUrl + ", isLivestream=" + this.isLivestream + ", palNonce=" + this.palNonce + ", trackingUrl=" + this.trackingUrl + ", userAgent=" + this.userAgent + ")";
    }

    public DatazoomMediaTailorConfig(String contentUrl, boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        this.contentUrl = contentUrl;
        this.isLivestream = z;
        this.palNonce = str;
        this.trackingUrl = str2;
        this.userAgent = str3;
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final boolean isLivestream() {
        return this.isLivestream;
    }

    public final String getPalNonce() {
        return this.palNonce;
    }

    public final String getTrackingUrl() {
        return this.trackingUrl;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }
}
