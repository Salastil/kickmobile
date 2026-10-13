package com.kick.mobile.kickivsplayerv2;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatazoomAnalyticsViewConfig.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR(\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR(\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R&\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR&\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR&\u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\n¨\u0006*"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/DatazoomAnalyticsViewConfig;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "configurationId", "", "getConfigurationId$annotations", "getConfigurationId", "()Ljava/lang/String;", "setConfigurationId", "(Ljava/lang/String;)V", "metadata", "getMetadata$annotations", "getMetadata", "setMetadata", "isProduction", "", "isProduction$annotations", "()Ljava/lang/Boolean;", "setProduction", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mediaTailorContentUrl", "getMediaTailorContentUrl$annotations", "getMediaTailorContentUrl", "setMediaTailorContentUrl", "mediaTailorIsLivestream", "getMediaTailorIsLivestream$annotations", "getMediaTailorIsLivestream", "setMediaTailorIsLivestream", "mediaTailorPalNonce", "getMediaTailorPalNonce$annotations", "getMediaTailorPalNonce", "setMediaTailorPalNonce", "mediaTailorTrackingUrl", "getMediaTailorTrackingUrl$annotations", "getMediaTailorTrackingUrl", "setMediaTailorTrackingUrl", "mediaTailorUserAgent", "getMediaTailorUserAgent$annotations", "getMediaTailorUserAgent", "setMediaTailorUserAgent", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatazoomAnalyticsViewConfig implements Record {
    private String configurationId;
    private Boolean isProduction;
    private String mediaTailorContentUrl;
    private Boolean mediaTailorIsLivestream;
    private String mediaTailorPalNonce;
    private String mediaTailorTrackingUrl;
    private String mediaTailorUserAgent;
    private String metadata;

    @Field
    public static /* synthetic */ void getConfigurationId$annotations() {
    }

    @Field
    public static /* synthetic */ void getMediaTailorContentUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void getMediaTailorIsLivestream$annotations() {
    }

    @Field
    public static /* synthetic */ void getMediaTailorPalNonce$annotations() {
    }

    @Field
    public static /* synthetic */ void getMediaTailorTrackingUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void getMediaTailorUserAgent$annotations() {
    }

    @Field
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @Field
    public static /* synthetic */ void isProduction$annotations() {
    }

    public final String getConfigurationId() {
        return this.configurationId;
    }

    public final void setConfigurationId(String str) {
        this.configurationId = str;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(String str) {
        this.metadata = str;
    }

    /* JADX INFO: renamed from: isProduction, reason: from getter */
    public final Boolean getIsProduction() {
        return this.isProduction;
    }

    public final void setProduction(Boolean bool) {
        this.isProduction = bool;
    }

    public final String getMediaTailorContentUrl() {
        return this.mediaTailorContentUrl;
    }

    public final void setMediaTailorContentUrl(String str) {
        this.mediaTailorContentUrl = str;
    }

    public final Boolean getMediaTailorIsLivestream() {
        return this.mediaTailorIsLivestream;
    }

    public final void setMediaTailorIsLivestream(Boolean bool) {
        this.mediaTailorIsLivestream = bool;
    }

    public final String getMediaTailorPalNonce() {
        return this.mediaTailorPalNonce;
    }

    public final void setMediaTailorPalNonce(String str) {
        this.mediaTailorPalNonce = str;
    }

    public final String getMediaTailorTrackingUrl() {
        return this.mediaTailorTrackingUrl;
    }

    public final void setMediaTailorTrackingUrl(String str) {
        this.mediaTailorTrackingUrl = str;
    }

    public final String getMediaTailorUserAgent() {
        return this.mediaTailorUserAgent;
    }

    public final void setMediaTailorUserAgent(String str) {
        this.mediaTailorUserAgent = str;
    }
}
