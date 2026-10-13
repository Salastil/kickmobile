package com.kick.mobile.kickivsplayerv2;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: MuxAnalyticsListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\bI\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 b2\u00020\u0001:\u0001bB¿\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\b\u0010@\u001a\u0004\u0018\u00010\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÆ\u0002\u0010[\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\\J\u0014\u0010]\u001a\u00020\u00162\b\u0010^\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010_\u001a\u00020`HÖ\u0081\u0004J\n\u0010a\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001a\u0004\b.\u0010(R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\"R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\"R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\"¨\u0006c"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsMetadata;", "", "playerName", "", "playerVersion", "viewerUserId", "subPropertyId", "pageType", "playerInitTime", "", "videoId", "videoTitle", "videoCdn", "videoContentType", "videoDuration", "videoEncodingVariant", "videoAffiliate", "videoLanguageCode", "videoSeries", "videoCreatorId", "videoStreamType", "videoIsLive", "", "viewSessionId", "viewDrmType", "viewCdnOrigin", "viewerPlan", "viewerPlanCategory", "playerDeviceId", "renditionModified", "streamUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPlayerName", "()Ljava/lang/String;", "getPlayerVersion", "getViewerUserId", "getSubPropertyId", "getPageType", "getPlayerInitTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVideoId", "getVideoTitle", "getVideoCdn", "getVideoContentType", "getVideoDuration", "getVideoEncodingVariant", "getVideoAffiliate", "getVideoLanguageCode", "getVideoSeries", "getVideoCreatorId", "getVideoStreamType", "getVideoIsLive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getViewSessionId", "getViewDrmType", "getViewCdnOrigin", "getViewerPlan", "getViewerPlanCategory", "getPlayerDeviceId", "getRenditionModified", "getStreamUrl", "playbackIdentity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsMetadata;", "equals", "other", "hashCode", "", "toString", "Companion", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MuxAnalyticsMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String pageType;
    private final String playerDeviceId;
    private final Long playerInitTime;
    private final String playerName;
    private final String playerVersion;
    private final String renditionModified;
    private final String streamUrl;
    private final String subPropertyId;
    private final String videoAffiliate;
    private final String videoCdn;
    private final String videoContentType;
    private final String videoCreatorId;
    private final Long videoDuration;
    private final String videoEncodingVariant;
    private final String videoId;
    private final Boolean videoIsLive;
    private final String videoLanguageCode;
    private final String videoSeries;
    private final String videoStreamType;
    private final String videoTitle;
    private final String viewCdnOrigin;
    private final String viewDrmType;
    private final String viewSessionId;
    private final String viewerPlan;
    private final String viewerPlanCategory;
    private final String viewerUserId;

    public MuxAnalyticsMetadata() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
    }

    public static /* synthetic */ MuxAnalyticsMetadata copy$default(MuxAnalyticsMetadata muxAnalyticsMetadata, String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7, String str8, String str9, Long l2, String str10, String str11, String str12, String str13, String str14, String str15, Boolean bool, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i, Object obj) {
        String str24;
        String str25;
        String str26 = (i & 1) != 0 ? muxAnalyticsMetadata.playerName : str;
        String str27 = (i & 2) != 0 ? muxAnalyticsMetadata.playerVersion : str2;
        String str28 = (i & 4) != 0 ? muxAnalyticsMetadata.viewerUserId : str3;
        String str29 = (i & 8) != 0 ? muxAnalyticsMetadata.subPropertyId : str4;
        String str30 = (i & 16) != 0 ? muxAnalyticsMetadata.pageType : str5;
        Long l3 = (i & 32) != 0 ? muxAnalyticsMetadata.playerInitTime : l;
        String str31 = (i & 64) != 0 ? muxAnalyticsMetadata.videoId : str6;
        String str32 = (i & 128) != 0 ? muxAnalyticsMetadata.videoTitle : str7;
        String str33 = (i & 256) != 0 ? muxAnalyticsMetadata.videoCdn : str8;
        String str34 = (i & 512) != 0 ? muxAnalyticsMetadata.videoContentType : str9;
        Long l4 = (i & 1024) != 0 ? muxAnalyticsMetadata.videoDuration : l2;
        String str35 = (i & 2048) != 0 ? muxAnalyticsMetadata.videoEncodingVariant : str10;
        String str36 = (i & 4096) != 0 ? muxAnalyticsMetadata.videoAffiliate : str11;
        String str37 = (i & 8192) != 0 ? muxAnalyticsMetadata.videoLanguageCode : str12;
        String str38 = str26;
        String str39 = (i & 16384) != 0 ? muxAnalyticsMetadata.videoSeries : str13;
        String str40 = (i & 32768) != 0 ? muxAnalyticsMetadata.videoCreatorId : str14;
        String str41 = (i & 65536) != 0 ? muxAnalyticsMetadata.videoStreamType : str15;
        Boolean bool2 = (i & 131072) != 0 ? muxAnalyticsMetadata.videoIsLive : bool;
        String str42 = (i & 262144) != 0 ? muxAnalyticsMetadata.viewSessionId : str16;
        String str43 = (i & 524288) != 0 ? muxAnalyticsMetadata.viewDrmType : str17;
        String str44 = (i & 1048576) != 0 ? muxAnalyticsMetadata.viewCdnOrigin : str18;
        String str45 = (i & 2097152) != 0 ? muxAnalyticsMetadata.viewerPlan : str19;
        String str46 = (i & 4194304) != 0 ? muxAnalyticsMetadata.viewerPlanCategory : str20;
        String str47 = (i & 8388608) != 0 ? muxAnalyticsMetadata.playerDeviceId : str21;
        String str48 = (i & 16777216) != 0 ? muxAnalyticsMetadata.renditionModified : str22;
        if ((i & GroupFlagsKt.HasAuxSlotFlag) != 0) {
            str25 = str48;
            str24 = muxAnalyticsMetadata.streamUrl;
        } else {
            str24 = str23;
            str25 = str48;
        }
        return muxAnalyticsMetadata.copy(str38, str27, str28, str29, str30, l3, str31, str32, str33, str34, l4, str35, str36, str37, str39, str40, str41, bool2, str42, str43, str44, str45, str46, str47, str25, str24);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPlayerName() {
        return this.playerName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVideoContentType() {
        return this.videoContentType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Long getVideoDuration() {
        return this.videoDuration;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getVideoEncodingVariant() {
        return this.videoEncodingVariant;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getVideoAffiliate() {
        return this.videoAffiliate;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getVideoLanguageCode() {
        return this.videoLanguageCode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getVideoSeries() {
        return this.videoSeries;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getVideoCreatorId() {
        return this.videoCreatorId;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getVideoStreamType() {
        return this.videoStreamType;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Boolean getVideoIsLive() {
        return this.videoIsLive;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getViewSessionId() {
        return this.viewSessionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPlayerVersion() {
        return this.playerVersion;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getViewDrmType() {
        return this.viewDrmType;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getViewCdnOrigin() {
        return this.viewCdnOrigin;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getViewerPlan() {
        return this.viewerPlan;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getViewerPlanCategory() {
        return this.viewerPlanCategory;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getPlayerDeviceId() {
        return this.playerDeviceId;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getRenditionModified() {
        return this.renditionModified;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getStreamUrl() {
        return this.streamUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getViewerUserId() {
        return this.viewerUserId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubPropertyId() {
        return this.subPropertyId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPageType() {
        return this.pageType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getPlayerInitTime() {
        return this.playerInitTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getVideoTitle() {
        return this.videoTitle;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getVideoCdn() {
        return this.videoCdn;
    }

    public final MuxAnalyticsMetadata copy(String playerName, String playerVersion, String viewerUserId, String subPropertyId, String pageType, Long playerInitTime, String videoId, String videoTitle, String videoCdn, String videoContentType, Long videoDuration, String videoEncodingVariant, String videoAffiliate, String videoLanguageCode, String videoSeries, String videoCreatorId, String videoStreamType, Boolean videoIsLive, String viewSessionId, String viewDrmType, String viewCdnOrigin, String viewerPlan, String viewerPlanCategory, String playerDeviceId, String renditionModified, String streamUrl) {
        return new MuxAnalyticsMetadata(playerName, playerVersion, viewerUserId, subPropertyId, pageType, playerInitTime, videoId, videoTitle, videoCdn, videoContentType, videoDuration, videoEncodingVariant, videoAffiliate, videoLanguageCode, videoSeries, videoCreatorId, videoStreamType, videoIsLive, viewSessionId, viewDrmType, viewCdnOrigin, viewerPlan, viewerPlanCategory, playerDeviceId, renditionModified, streamUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MuxAnalyticsMetadata)) {
            return false;
        }
        MuxAnalyticsMetadata muxAnalyticsMetadata = (MuxAnalyticsMetadata) other;
        return Intrinsics.areEqual(this.playerName, muxAnalyticsMetadata.playerName) && Intrinsics.areEqual(this.playerVersion, muxAnalyticsMetadata.playerVersion) && Intrinsics.areEqual(this.viewerUserId, muxAnalyticsMetadata.viewerUserId) && Intrinsics.areEqual(this.subPropertyId, muxAnalyticsMetadata.subPropertyId) && Intrinsics.areEqual(this.pageType, muxAnalyticsMetadata.pageType) && Intrinsics.areEqual(this.playerInitTime, muxAnalyticsMetadata.playerInitTime) && Intrinsics.areEqual(this.videoId, muxAnalyticsMetadata.videoId) && Intrinsics.areEqual(this.videoTitle, muxAnalyticsMetadata.videoTitle) && Intrinsics.areEqual(this.videoCdn, muxAnalyticsMetadata.videoCdn) && Intrinsics.areEqual(this.videoContentType, muxAnalyticsMetadata.videoContentType) && Intrinsics.areEqual(this.videoDuration, muxAnalyticsMetadata.videoDuration) && Intrinsics.areEqual(this.videoEncodingVariant, muxAnalyticsMetadata.videoEncodingVariant) && Intrinsics.areEqual(this.videoAffiliate, muxAnalyticsMetadata.videoAffiliate) && Intrinsics.areEqual(this.videoLanguageCode, muxAnalyticsMetadata.videoLanguageCode) && Intrinsics.areEqual(this.videoSeries, muxAnalyticsMetadata.videoSeries) && Intrinsics.areEqual(this.videoCreatorId, muxAnalyticsMetadata.videoCreatorId) && Intrinsics.areEqual(this.videoStreamType, muxAnalyticsMetadata.videoStreamType) && Intrinsics.areEqual(this.videoIsLive, muxAnalyticsMetadata.videoIsLive) && Intrinsics.areEqual(this.viewSessionId, muxAnalyticsMetadata.viewSessionId) && Intrinsics.areEqual(this.viewDrmType, muxAnalyticsMetadata.viewDrmType) && Intrinsics.areEqual(this.viewCdnOrigin, muxAnalyticsMetadata.viewCdnOrigin) && Intrinsics.areEqual(this.viewerPlan, muxAnalyticsMetadata.viewerPlan) && Intrinsics.areEqual(this.viewerPlanCategory, muxAnalyticsMetadata.viewerPlanCategory) && Intrinsics.areEqual(this.playerDeviceId, muxAnalyticsMetadata.playerDeviceId) && Intrinsics.areEqual(this.renditionModified, muxAnalyticsMetadata.renditionModified) && Intrinsics.areEqual(this.streamUrl, muxAnalyticsMetadata.streamUrl);
    }

    public int hashCode() {
        String str = this.playerName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.playerVersion;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.viewerUserId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.subPropertyId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.pageType;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l = this.playerInitTime;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        String str6 = this.videoId;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.videoTitle;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.videoCdn;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.videoContentType;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l2 = this.videoDuration;
        int iHashCode11 = (iHashCode10 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str10 = this.videoEncodingVariant;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.videoAffiliate;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.videoLanguageCode;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.videoSeries;
        int iHashCode15 = (iHashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.videoCreatorId;
        int iHashCode16 = (iHashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.videoStreamType;
        int iHashCode17 = (iHashCode16 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Boolean bool = this.videoIsLive;
        int iHashCode18 = (iHashCode17 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str16 = this.viewSessionId;
        int iHashCode19 = (iHashCode18 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.viewDrmType;
        int iHashCode20 = (iHashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.viewCdnOrigin;
        int iHashCode21 = (iHashCode20 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.viewerPlan;
        int iHashCode22 = (iHashCode21 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.viewerPlanCategory;
        int iHashCode23 = (iHashCode22 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.playerDeviceId;
        int iHashCode24 = (iHashCode23 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.renditionModified;
        int iHashCode25 = (iHashCode24 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.streamUrl;
        return iHashCode25 + (str23 != null ? str23.hashCode() : 0);
    }

    public String toString() {
        return "MuxAnalyticsMetadata(playerName=" + this.playerName + ", playerVersion=" + this.playerVersion + ", viewerUserId=" + this.viewerUserId + ", subPropertyId=" + this.subPropertyId + ", pageType=" + this.pageType + ", playerInitTime=" + this.playerInitTime + ", videoId=" + this.videoId + ", videoTitle=" + this.videoTitle + ", videoCdn=" + this.videoCdn + ", videoContentType=" + this.videoContentType + ", videoDuration=" + this.videoDuration + ", videoEncodingVariant=" + this.videoEncodingVariant + ", videoAffiliate=" + this.videoAffiliate + ", videoLanguageCode=" + this.videoLanguageCode + ", videoSeries=" + this.videoSeries + ", videoCreatorId=" + this.videoCreatorId + ", videoStreamType=" + this.videoStreamType + ", videoIsLive=" + this.videoIsLive + ", viewSessionId=" + this.viewSessionId + ", viewDrmType=" + this.viewDrmType + ", viewCdnOrigin=" + this.viewCdnOrigin + ", viewerPlan=" + this.viewerPlan + ", viewerPlanCategory=" + this.viewerPlanCategory + ", playerDeviceId=" + this.playerDeviceId + ", renditionModified=" + this.renditionModified + ", streamUrl=" + this.streamUrl + ")";
    }

    public MuxAnalyticsMetadata(String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7, String str8, String str9, Long l2, String str10, String str11, String str12, String str13, String str14, String str15, Boolean bool, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23) {
        this.playerName = str;
        this.playerVersion = str2;
        this.viewerUserId = str3;
        this.subPropertyId = str4;
        this.pageType = str5;
        this.playerInitTime = l;
        this.videoId = str6;
        this.videoTitle = str7;
        this.videoCdn = str8;
        this.videoContentType = str9;
        this.videoDuration = l2;
        this.videoEncodingVariant = str10;
        this.videoAffiliate = str11;
        this.videoLanguageCode = str12;
        this.videoSeries = str13;
        this.videoCreatorId = str14;
        this.videoStreamType = str15;
        this.videoIsLive = bool;
        this.viewSessionId = str16;
        this.viewDrmType = str17;
        this.viewCdnOrigin = str18;
        this.viewerPlan = str19;
        this.viewerPlanCategory = str20;
        this.playerDeviceId = str21;
        this.renditionModified = str22;
        this.streamUrl = str23;
    }

    public /* synthetic */ MuxAnalyticsMetadata(String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7, String str8, String str9, Long l2, String str10, String str11, String str12, String str13, String str14, String str15, Boolean bool, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : l2, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (i & 32768) != 0 ? null : str14, (i & 65536) != 0 ? null : str15, (i & 131072) != 0 ? null : bool, (i & 262144) != 0 ? null : str16, (i & 524288) != 0 ? null : str17, (i & 1048576) != 0 ? null : str18, (i & 2097152) != 0 ? null : str19, (i & 4194304) != 0 ? null : str20, (i & 8388608) != 0 ? null : str21, (i & 16777216) != 0 ? null : str22, (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? null : str23);
    }

    public final String getPlayerName() {
        return this.playerName;
    }

    public final String getPlayerVersion() {
        return this.playerVersion;
    }

    public final String getViewerUserId() {
        return this.viewerUserId;
    }

    public final String getSubPropertyId() {
        return this.subPropertyId;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final Long getPlayerInitTime() {
        return this.playerInitTime;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getVideoTitle() {
        return this.videoTitle;
    }

    public final String getVideoCdn() {
        return this.videoCdn;
    }

    public final String getVideoContentType() {
        return this.videoContentType;
    }

    public final Long getVideoDuration() {
        return this.videoDuration;
    }

    public final String getVideoEncodingVariant() {
        return this.videoEncodingVariant;
    }

    public final String getVideoAffiliate() {
        return this.videoAffiliate;
    }

    public final String getVideoLanguageCode() {
        return this.videoLanguageCode;
    }

    public final String getVideoSeries() {
        return this.videoSeries;
    }

    public final String getVideoCreatorId() {
        return this.videoCreatorId;
    }

    public final String getVideoStreamType() {
        return this.videoStreamType;
    }

    public final Boolean getVideoIsLive() {
        return this.videoIsLive;
    }

    public final String getViewSessionId() {
        return this.viewSessionId;
    }

    public final String getViewDrmType() {
        return this.viewDrmType;
    }

    public final String getViewCdnOrigin() {
        return this.viewCdnOrigin;
    }

    public final String getViewerPlan() {
        return this.viewerPlan;
    }

    public final String getViewerPlanCategory() {
        return this.viewerPlanCategory;
    }

    public final String getPlayerDeviceId() {
        return this.playerDeviceId;
    }

    public final String getRenditionModified() {
        return this.renditionModified;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final String playbackIdentity() {
        String str = this.videoId;
        if (str == null && (str = this.viewSessionId) == null) {
            return null;
        }
        String str2 = this.videoStreamType;
        if (str2 != null) {
            String str3 = str + ServerSentEventKt.COLON + str2;
            if (str3 != null) {
                return str3;
            }
        }
        return str;
    }

    /* JADX INFO: compiled from: MuxAnalyticsListener.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsMetadata$Companion;", "", "<init>", "()V", "fromJson", "Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsMetadata;", "json", "", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MuxAnalyticsMetadata fromJson(String json) {
            Object objM12684constructorimpl;
            String str = json;
            if (str == null || StringsKt.isBlank(str)) {
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                JSONObject jSONObject = new JSONObject(json);
                objM12684constructorimpl = Result.m12684constructorimpl(new MuxAnalyticsMetadata(MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "player_name"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "player_version"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "viewer_user_id"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "sub_property_id"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "page_type"), MuxAnalyticsListenerKt.optLongOrNull(jSONObject, "player_init_time"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_id"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_title"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_cdn"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_content_type"), MuxAnalyticsListenerKt.optLongOrNull(jSONObject, "video_duration"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_encoding_variant"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_affiliate"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_language_code"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_series"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_creator_id"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "video_stream_type"), MuxAnalyticsListenerKt.optBooleanOrNull(jSONObject, "video_is_live"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "view_session_id"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "view_drm_type"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "view_cdn_origin"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "viewer_plan"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "viewer_plan_category"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "player_device_id"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "rendition_modified"), MuxAnalyticsListenerKt.optStringOrNull(jSONObject, "stream_url")));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            return (MuxAnalyticsMetadata) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
        }
    }
}
