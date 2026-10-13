package com.kick.mobile.kickivsplayerv2;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: MuxAnalyticsViewConfig.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR&\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsViewConfig;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "environmentKey", "", "getEnvironmentKey$annotations", "getEnvironmentKey", "()Ljava/lang/String;", "setEnvironmentKey", "(Ljava/lang/String;)V", "metadata", "getMetadata$annotations", "getMetadata", "setMetadata", "playbackMode", "getPlaybackMode$annotations", "getPlaybackMode", "setPlaybackMode", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MuxAnalyticsViewConfig implements Record {
    private String environmentKey;
    private String metadata;
    private String playbackMode;

    @Field
    public static /* synthetic */ void getEnvironmentKey$annotations() {
    }

    @Field
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @Field
    public static /* synthetic */ void getPlaybackMode$annotations() {
    }

    public final String getEnvironmentKey() {
        return this.environmentKey;
    }

    public final void setEnvironmentKey(String str) {
        this.environmentKey = str;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(String str) {
        this.metadata = str;
    }

    public final String getPlaybackMode() {
        return this.playbackMode;
    }

    public final void setPlaybackMode(String str) {
        this.playbackMode = str;
    }
}
