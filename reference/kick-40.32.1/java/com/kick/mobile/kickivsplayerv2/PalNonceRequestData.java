package com.kick.mobile.kickivsplayerv2;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PALSDKManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0014\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\nHÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/PalNonceRequestData;", "", "streamKey", "", "descriptionUrl", "playerType", "playerVersion", "ppid", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "videoPlayerHeight", "", "videoPlayerWidth", "willAdPlayMuted", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V", "getStreamKey", "()Ljava/lang/String;", "getDescriptionUrl", "getPlayerType", "getPlayerVersion", "getPpid", "getSessionId", "getVideoPlayerHeight", "()I", "getVideoPlayerWidth", "getWillAdPlayMuted", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PalNonceRequestData {
    private final String descriptionUrl;
    private final String playerType;
    private final String playerVersion;
    private final String ppid;
    private final String sessionId;
    private final String streamKey;
    private final int videoPlayerHeight;
    private final int videoPlayerWidth;
    private final boolean willAdPlayMuted;

    public static /* synthetic */ PalNonceRequestData copy$default(PalNonceRequestData palNonceRequestData, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = palNonceRequestData.streamKey;
        }
        if ((i3 & 2) != 0) {
            str2 = palNonceRequestData.descriptionUrl;
        }
        if ((i3 & 4) != 0) {
            str3 = palNonceRequestData.playerType;
        }
        if ((i3 & 8) != 0) {
            str4 = palNonceRequestData.playerVersion;
        }
        if ((i3 & 16) != 0) {
            str5 = palNonceRequestData.ppid;
        }
        if ((i3 & 32) != 0) {
            str6 = palNonceRequestData.sessionId;
        }
        if ((i3 & 64) != 0) {
            i = palNonceRequestData.videoPlayerHeight;
        }
        if ((i3 & 128) != 0) {
            i2 = palNonceRequestData.videoPlayerWidth;
        }
        if ((i3 & 256) != 0) {
            z = palNonceRequestData.willAdPlayMuted;
        }
        int i4 = i2;
        boolean z2 = z;
        String str7 = str6;
        int i5 = i;
        String str8 = str5;
        String str9 = str3;
        return palNonceRequestData.copy(str, str2, str9, str4, str8, str7, i5, i4, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescriptionUrl() {
        return this.descriptionUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPlayerType() {
        return this.playerType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPlayerVersion() {
        return this.playerVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPpid() {
        return this.ppid;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getVideoPlayerHeight() {
        return this.videoPlayerHeight;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getVideoPlayerWidth() {
        return this.videoPlayerWidth;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getWillAdPlayMuted() {
        return this.willAdPlayMuted;
    }

    public final PalNonceRequestData copy(String streamKey, String descriptionUrl, String playerType, String playerVersion, String ppid, String sessionId, int videoPlayerHeight, int videoPlayerWidth, boolean willAdPlayMuted) {
        Intrinsics.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics.checkNotNullParameter(descriptionUrl, "descriptionUrl");
        Intrinsics.checkNotNullParameter(playerType, "playerType");
        Intrinsics.checkNotNullParameter(playerVersion, "playerVersion");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new PalNonceRequestData(streamKey, descriptionUrl, playerType, playerVersion, ppid, sessionId, videoPlayerHeight, videoPlayerWidth, willAdPlayMuted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PalNonceRequestData)) {
            return false;
        }
        PalNonceRequestData palNonceRequestData = (PalNonceRequestData) other;
        return Intrinsics.areEqual(this.streamKey, palNonceRequestData.streamKey) && Intrinsics.areEqual(this.descriptionUrl, palNonceRequestData.descriptionUrl) && Intrinsics.areEqual(this.playerType, palNonceRequestData.playerType) && Intrinsics.areEqual(this.playerVersion, palNonceRequestData.playerVersion) && Intrinsics.areEqual(this.ppid, palNonceRequestData.ppid) && Intrinsics.areEqual(this.sessionId, palNonceRequestData.sessionId) && this.videoPlayerHeight == palNonceRequestData.videoPlayerHeight && this.videoPlayerWidth == palNonceRequestData.videoPlayerWidth && this.willAdPlayMuted == palNonceRequestData.willAdPlayMuted;
    }

    public int hashCode() {
        int iHashCode = ((((((this.streamKey.hashCode() * 31) + this.descriptionUrl.hashCode()) * 31) + this.playerType.hashCode()) * 31) + this.playerVersion.hashCode()) * 31;
        String str = this.ppid;
        return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.sessionId.hashCode()) * 31) + Integer.hashCode(this.videoPlayerHeight)) * 31) + Integer.hashCode(this.videoPlayerWidth)) * 31) + Boolean.hashCode(this.willAdPlayMuted);
    }

    public String toString() {
        return "PalNonceRequestData(streamKey=" + this.streamKey + ", descriptionUrl=" + this.descriptionUrl + ", playerType=" + this.playerType + ", playerVersion=" + this.playerVersion + ", ppid=" + this.ppid + ", sessionId=" + this.sessionId + ", videoPlayerHeight=" + this.videoPlayerHeight + ", videoPlayerWidth=" + this.videoPlayerWidth + ", willAdPlayMuted=" + this.willAdPlayMuted + ")";
    }

    public PalNonceRequestData(String streamKey, String descriptionUrl, String playerType, String playerVersion, String str, String sessionId, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics.checkNotNullParameter(descriptionUrl, "descriptionUrl");
        Intrinsics.checkNotNullParameter(playerType, "playerType");
        Intrinsics.checkNotNullParameter(playerVersion, "playerVersion");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.streamKey = streamKey;
        this.descriptionUrl = descriptionUrl;
        this.playerType = playerType;
        this.playerVersion = playerVersion;
        this.ppid = str;
        this.sessionId = sessionId;
        this.videoPlayerHeight = i;
        this.videoPlayerWidth = i2;
        this.willAdPlayMuted = z;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final String getDescriptionUrl() {
        return this.descriptionUrl;
    }

    public final String getPlayerType() {
        return this.playerType;
    }

    public final String getPlayerVersion() {
        return this.playerVersion;
    }

    public final String getPpid() {
        return this.ppid;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getVideoPlayerHeight() {
        return this.videoPlayerHeight;
    }

    public final int getVideoPlayerWidth() {
        return this.videoPlayerWidth;
    }

    public final boolean getWillAdPlayMuted() {
        return this.willAdPlayMuted;
    }
}
