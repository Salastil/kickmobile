package com.kick.mobile.kickivsplayerv2;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: PalNonceRequestConfig.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR&\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR&\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR&\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR&\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR(\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010&\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010&\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010#\"\u0004\b*\u0010%R(\u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u00102\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/PalNonceRequestConfig;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "streamKey", "", "getStreamKey$annotations", "getStreamKey", "()Ljava/lang/String;", "setStreamKey", "(Ljava/lang/String;)V", "descriptionUrl", "getDescriptionUrl$annotations", "getDescriptionUrl", "setDescriptionUrl", "playerType", "getPlayerType$annotations", "getPlayerType", "setPlayerType", "playerVersion", "getPlayerVersion$annotations", "getPlayerVersion", "setPlayerVersion", "ppid", "getPpid$annotations", "getPpid", "setPpid", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "getSessionId$annotations", "getSessionId", "setSessionId", "videoPlayerHeight", "", "getVideoPlayerHeight$annotations", "getVideoPlayerHeight", "()Ljava/lang/Integer;", "setVideoPlayerHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "videoPlayerWidth", "getVideoPlayerWidth$annotations", "getVideoPlayerWidth", "setVideoPlayerWidth", "willAdPlayMuted", "", "getWillAdPlayMuted$annotations", "getWillAdPlayMuted", "()Ljava/lang/Boolean;", "setWillAdPlayMuted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PalNonceRequestConfig implements Record {
    private String descriptionUrl;
    private String playerType;
    private String playerVersion;
    private String ppid;
    private String sessionId;
    private String streamKey;
    private Integer videoPlayerHeight;
    private Integer videoPlayerWidth;
    private Boolean willAdPlayMuted;

    @Field
    public static /* synthetic */ void getDescriptionUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void getPlayerType$annotations() {
    }

    @Field
    public static /* synthetic */ void getPlayerVersion$annotations() {
    }

    @Field
    public static /* synthetic */ void getPpid$annotations() {
    }

    @Field
    public static /* synthetic */ void getSessionId$annotations() {
    }

    @Field
    public static /* synthetic */ void getStreamKey$annotations() {
    }

    @Field
    public static /* synthetic */ void getVideoPlayerHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getVideoPlayerWidth$annotations() {
    }

    @Field
    public static /* synthetic */ void getWillAdPlayMuted$annotations() {
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final void setStreamKey(String str) {
        this.streamKey = str;
    }

    public final String getDescriptionUrl() {
        return this.descriptionUrl;
    }

    public final void setDescriptionUrl(String str) {
        this.descriptionUrl = str;
    }

    public final String getPlayerType() {
        return this.playerType;
    }

    public final void setPlayerType(String str) {
        this.playerType = str;
    }

    public final String getPlayerVersion() {
        return this.playerVersion;
    }

    public final void setPlayerVersion(String str) {
        this.playerVersion = str;
    }

    public final String getPpid() {
        return this.ppid;
    }

    public final void setPpid(String str) {
        this.ppid = str;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final Integer getVideoPlayerHeight() {
        return this.videoPlayerHeight;
    }

    public final void setVideoPlayerHeight(Integer num) {
        this.videoPlayerHeight = num;
    }

    public final Integer getVideoPlayerWidth() {
        return this.videoPlayerWidth;
    }

    public final void setVideoPlayerWidth(Integer num) {
        this.videoPlayerWidth = num;
    }

    public final Boolean getWillAdPlayMuted() {
        return this.willAdPlayMuted;
    }

    public final void setWillAdPlayMuted(Boolean bool) {
        this.willAdPlayMuted = bool;
    }
}
