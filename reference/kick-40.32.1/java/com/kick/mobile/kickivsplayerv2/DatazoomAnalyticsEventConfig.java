package com.kick.mobile.kickivsplayerv2;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatazoomAnalyticsViewConfig.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsEventConfig;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "eventName", "", "getEventName$annotations", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "isFullscreen", "", "isFullscreen$annotations", "()Ljava/lang/Boolean;", "setFullscreen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatazoomAnalyticsEventConfig implements Record {
    private String eventName;
    private Boolean isFullscreen;

    @Field
    public static /* synthetic */ void getEventName$annotations() {
    }

    @Field
    public static /* synthetic */ void isFullscreen$annotations() {
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final void setEventName(String str) {
        this.eventName = str;
    }

    /* JADX INFO: renamed from: isFullscreen, reason: from getter */
    public final Boolean getIsFullscreen() {
        return this.isFullscreen;
    }

    public final void setFullscreen(Boolean bool) {
        this.isFullscreen = bool;
    }
}
