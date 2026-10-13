package com.kick.mobile.kickivsplayerv2;

import android.content.Context;
import com.amazonaws.ivs.player.PlayerException;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.events.EventBus;
import com.mux.stats.sdk.core.events.playback.AdBreakEndEvent;
import com.mux.stats.sdk.core.events.playback.AdBreakStartEvent;
import com.mux.stats.sdk.core.events.playback.AdEndedEvent;
import com.mux.stats.sdk.core.events.playback.AdEvent;
import com.mux.stats.sdk.core.events.playback.AdFirstQuartileEvent;
import com.mux.stats.sdk.core.events.playback.AdMidpointEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayEvent;
import com.mux.stats.sdk.core.events.playback.AdPlayingEvent;
import com.mux.stats.sdk.core.events.playback.AdThirdQuartileEvent;
import com.mux.stats.sdk.core.events.playback.EndedEvent;
import com.mux.stats.sdk.core.events.playback.ErrorEvent;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import com.mux.stats.sdk.core.events.playback.PlayEvent;
import com.mux.stats.sdk.core.events.playback.PlayerReadyEvent;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import com.mux.stats.sdk.core.events.playback.RebufferEndEvent;
import com.mux.stats.sdk.core.events.playback.RebufferStartEvent;
import com.mux.stats.sdk.core.events.playback.RenditionChangeEvent;
import com.mux.stats.sdk.core.events.playback.SeekedEvent;
import com.mux.stats.sdk.core.events.playback.SeekingEvent;
import com.mux.stats.sdk.core.events.playback.TimeUpdateEvent;
import com.mux.stats.sdk.core.events.playback.ViewEndEvent;
import com.mux.stats.sdk.core.events.playback.ViewStartEvent;
import com.mux.stats.sdk.core.model.AdData;
import com.mux.stats.sdk.core.model.AdType;
import com.mux.stats.sdk.core.model.CustomData;
import com.mux.stats.sdk.core.model.CustomerData;
import com.mux.stats.sdk.core.model.CustomerPlayerData;
import com.mux.stats.sdk.core.model.CustomerVideoData;
import com.mux.stats.sdk.core.model.CustomerViewData;
import com.mux.stats.sdk.core.model.CustomerViewerData;
import com.mux.stats.sdk.core.model.PlaybackMode;
import com.mux.stats.sdk.core.model.PlayerData;
import com.mux.stats.sdk.core.model.VideoData;
import com.mux.stats.sdk.muxstats.IPlayerListener;
import com.mux.stats.sdk.muxstats.MuxStats;
import io.ktor.sse.ServerSentEventKt;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MuxAnalyticsListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0010J\u0016\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0012J)\u00103\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010\u00122\b\u00105\u001a\u0004\u0018\u00010\u00172\b\u00106\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u00107J\u0015\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020\u0006J\u000e\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\tJ\u0016\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dJ\u0016\u0010B\u001a\u00020-2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0012J\u000e\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020-J\u0006\u0010G\u001a\u00020-J\u0006\u0010H\u001a\u00020-J\u0006\u0010I\u001a\u00020-J\u0006\u0010J\u001a\u00020-J\u0006\u0010K\u001a\u00020-J\u0006\u0010L\u001a\u00020-J\u000e\u0010M\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0010J\u0006\u0010N\u001a\u00020-J\u0006\u0010O\u001a\u00020-J\u0006\u0010P\u001a\u00020-J\u000e\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020SJ\u000e\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020'J\u0018\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020X2\u0006\u0010U\u001a\u00020'H\u0002J\u001a\u0010Y\u001a\u00020-2\u0006\u0010U\u001a\u00020'2\b\b\u0002\u0010Z\u001a\u00020\u001dH\u0002J\u0010\u0010[\u001a\u00020\\2\u0006\u0010U\u001a\u00020'H\u0002J\u0010\u0010]\u001a\u00020^2\u0006\u0010U\u001a\u00020'H\u0002J\u0010\u0010_\u001a\u00020\u00062\u0006\u0010U\u001a\u00020'H\u0002J\b\u0010`\u001a\u00020aH\u0002J\b\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020\u0010H\u0016J\b\u0010e\u001a\u00020\u0006H\u0016J\u000f\u0010f\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010gJ\u000f\u0010h\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010gJ\u000f\u0010i\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010gJ\u000f\u0010j\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010kJ\n\u0010l\u001a\u0004\u0018\u00010\u0006H\u0016J\u000f\u0010m\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010nJ\b\u0010@\u001a\u00020\u001dH\u0016J\b\u0010A\u001a\u00020\u001dH\u0016J\b\u0010o\u001a\u00020\u0012H\u0016J\b\u0010p\u001a\u00020\u0012H\u0016J\u000f\u0010q\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010nJ\u000f\u0010r\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010nJ\u000f\u0010s\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010nJ\u000f\u0010t\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010nJ\u000f\u0010u\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010nJ\u000f\u0010v\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120+0*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsListener;", "Lcom/mux/stats/sdk/core/events/EventBus;", "Lcom/mux/stats/sdk/muxstats/IPlayerListener;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "playerName", "", "environmentKey", "initialMetadata", "Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsMetadata;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/kick/mobile/kickivsplayerv2/MuxAnalyticsMetadata;)V", "muxStats", "Lcom/mux/stats/sdk/muxstats/MuxStats;", "appVersion", "currentPositionMs", "", "sourceWidth", "", "Ljava/lang/Integer;", "sourceHeight", "sourceAdvertisedBitrate", "sourceAdvertisedFramerate", "", "Ljava/lang/Float;", "sourceCodec", "sourceDurationMs", "Ljava/lang/Long;", "paused", "", "buffering", "playerViewWidth", "playerViewHeight", "playDispatched", "viewStarted", "viewEnded", "rebuffering", "activeAdKey", "activeAdEvent", "Lcom/kick/mobile/kickivsplayerv2/MuxAdEventData;", "renditionModified", "quartilesDispatchedByAdKey", "", "", "release", "", "updateCurrentPosition", "positionMs", "updateSourceSize", ViewProps.WIDTH, ViewProps.HEIGHT, "updateSourceQuality", "bitrate", "framerate", "codec", "(Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;)V", "updateSourceDuration", "durationMs", "(Ljava/lang/Long;)V", "updateSourceUrl", "sourceUrl", "updateCustomerData", "metadata", "updatePlaybackState", "isPaused", "isBuffering", "updatePlayerViewSize", "updatePlaybackMode", "playbackMode", "Lcom/mux/stats/sdk/core/model/PlaybackMode;", "dispatchPlayerReady", "dispatchPlay", "dispatchPlaying", "dispatchPause", "dispatchRebufferStart", "dispatchRebufferEnd", "dispatchSeeking", "dispatchSeeked", "dispatchTimeUpdate", "dispatchEnded", "dispatchViewEnd", "dispatchError", "error", "Lcom/amazonaws/ivs/player/PlayerException;", "dispatchAdEvent", "event", "dispatchAdPlaybackEvent", "muxEvent", "Lcom/mux/stats/sdk/core/events/playback/AdEvent;", "dispatchAdQuartilesIfNeeded", "includeAllElapsedQuartiles", "createAdData", "Lcom/mux/stats/sdk/core/model/AdData;", "adTypeFor", "Lcom/mux/stats/sdk/core/model/AdType;", "keyFor", "createPlayerData", "Lcom/mux/stats/sdk/core/model/PlayerData;", "createVideoData", "Lcom/mux/stats/sdk/core/model/VideoData;", "getCurrentPosition", "getMimeType", "getSourceWidth", "()Ljava/lang/Integer;", "getSourceHeight", "getSourceAdvertisedBitrate", "getSourceAdvertisedFramerate", "()Ljava/lang/Float;", "getSourceCodec", "getSourceDuration", "()Ljava/lang/Long;", "getPlayerViewWidth", "getPlayerViewHeight", "getPlayerProgramTime", "getPlayerManifestNewestTime", "getVideoHoldback", "getVideoPartHoldback", "getVideoPartTargetDuration", "getVideoTargetDuration", "kick-ivs-player-v2_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MuxAnalyticsListener extends EventBus implements IPlayerListener {
    private MuxAdEventData activeAdEvent;
    private String activeAdKey;
    private final String appVersion;
    private boolean buffering;
    private final Context context;
    private long currentPositionMs;
    private final MuxStats muxStats;
    private boolean paused;
    private boolean playDispatched;
    private final String playerName;
    private int playerViewHeight;
    private int playerViewWidth;
    private final Map<String, Set<Integer>> quartilesDispatchedByAdKey;
    private boolean rebuffering;
    private String renditionModified;
    private Integer sourceAdvertisedBitrate;
    private Float sourceAdvertisedFramerate;
    private String sourceCodec;
    private Long sourceDurationMs;
    private Integer sourceHeight;
    private Integer sourceWidth;
    private boolean viewEnded;
    private boolean viewStarted;

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Long getPlayerManifestNewestTime() {
        return null;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Long getPlayerProgramTime() {
        return null;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Long getVideoHoldback() {
        return null;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Long getVideoPartHoldback() {
        return null;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Long getVideoPartTargetDuration() {
        return null;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Long getVideoTargetDuration() {
        return null;
    }

    public MuxAnalyticsListener(Context context, String playerName, String environmentKey, MuxAnalyticsMetadata initialMetadata) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        Intrinsics.checkNotNullParameter(environmentKey, "environmentKey");
        Intrinsics.checkNotNullParameter(initialMetadata, "initialMetadata");
        this.context = context;
        this.playerName = playerName;
        String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        str = str == null ? "" : str;
        this.appVersion = str;
        this.paused = true;
        this.renditionModified = initialMetadata.getRenditionModified();
        this.quartilesDispatchedByAdKey = new LinkedHashMap();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        MuxStats.setHostDevice(new MuxAnalyticsDevice(applicationContext));
        MuxStats.setHostNetworkApi(new MuxAnalyticsNetworkRequest());
        CustomerPlayerData customerPlayerData = new CustomerPlayerData();
        customerPlayerData.setEnvironmentKey(environmentKey);
        String playerName2 = initialMetadata.getPlayerName();
        customerPlayerData.setPlayerName(playerName2 == null ? customerPlayerData.getPlayerName() : playerName2);
        String playerVersion = initialMetadata.getPlayerVersion();
        customerPlayerData.setPlayerVersion(playerVersion == null ? str : playerVersion);
        CustomerVideoData customerVideoData = new CustomerVideoData();
        CustomerViewData customerViewData = new CustomerViewData();
        customerViewData.setViewClientApplicationName("KICK Live Streaming");
        customerViewData.setViewClientApplicationVersion(str);
        CustomerViewerData customerViewerData = new CustomerViewerData();
        CustomData customData = new CustomData();
        String playerDeviceId = initialMetadata.getPlayerDeviceId();
        if (playerDeviceId != null) {
            customData.setCustomData1(playerDeviceId);
        }
        String renditionModified = initialMetadata.getRenditionModified();
        if (renditionModified != null) {
            customData.setCustomData6(renditionModified);
        }
        MuxStats muxStats = new MuxStats(this, playerName, new CustomerData(customerPlayerData, customerVideoData, customerViewData, customerViewerData, customData));
        this.muxStats = muxStats;
        addListener(muxStats);
    }

    public final void release() {
        dispatchViewEnd();
        this.muxStats.release();
        removeListener(this.muxStats);
    }

    public final void updateCurrentPosition(long positionMs) {
        this.currentPositionMs = positionMs;
    }

    public final void updateSourceSize(int width, int height) {
        this.sourceWidth = Integer.valueOf(width);
        this.sourceHeight = Integer.valueOf(height);
    }

    public final void updateSourceQuality(Integer bitrate, Float framerate, String codec) {
        this.sourceAdvertisedBitrate = bitrate;
        this.sourceAdvertisedFramerate = framerate;
        this.sourceCodec = codec;
    }

    public final void updateSourceDuration(Long durationMs) {
        this.sourceDurationMs = durationMs;
    }

    public final void updateSourceUrl(String sourceUrl) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        this.muxStats.getCustomerVideoData().setVideoSourceUrl(sourceUrl);
    }

    public final void updateCustomerData(MuxAnalyticsMetadata metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        String str = this.renditionModified;
        String renditionModified = metadata.getRenditionModified();
        String playerName = metadata.getPlayerName();
        if (playerName != null) {
            this.muxStats.getCustomerPlayerData().setPlayerName(playerName);
        }
        String playerVersion = metadata.getPlayerVersion();
        if (playerVersion != null) {
            this.muxStats.getCustomerPlayerData().setPlayerVersion(playerVersion);
        }
        String viewerUserId = metadata.getViewerUserId();
        if (viewerUserId != null) {
            this.muxStats.getCustomerPlayerData().setViewerUserId(viewerUserId);
        }
        String subPropertyId = metadata.getSubPropertyId();
        if (subPropertyId != null) {
            this.muxStats.getCustomerPlayerData().setSubPropertyId(subPropertyId);
        }
        String pageType = metadata.getPageType();
        if (pageType != null) {
            this.muxStats.getCustomerPlayerData().setPageType(pageType);
        }
        Long playerInitTime = metadata.getPlayerInitTime();
        if (playerInitTime != null) {
            this.muxStats.getCustomerPlayerData().setPlayerInitTime(Long.valueOf(playerInitTime.longValue()));
        }
        CustomerVideoData customerVideoData = this.muxStats.getCustomerVideoData();
        String videoId = metadata.getVideoId();
        if (videoId != null) {
            customerVideoData.setVideoId(videoId);
        }
        String videoTitle = metadata.getVideoTitle();
        if (videoTitle != null) {
            customerVideoData.setVideoTitle(videoTitle);
        }
        String videoCdn = metadata.getVideoCdn();
        if (videoCdn != null) {
            customerVideoData.setVideoCdn(videoCdn);
        }
        String videoContentType = metadata.getVideoContentType();
        if (videoContentType != null) {
            customerVideoData.setVideoContentType(videoContentType);
        }
        Long videoDuration = metadata.getVideoDuration();
        if (videoDuration != null) {
            customerVideoData.setVideoDuration(Long.valueOf(videoDuration.longValue()));
        }
        String videoEncodingVariant = metadata.getVideoEncodingVariant();
        if (videoEncodingVariant != null) {
            customerVideoData.setVideoEncodingVariant(videoEncodingVariant);
        }
        String videoAffiliate = metadata.getVideoAffiliate();
        if (videoAffiliate != null) {
            customerVideoData.setVideoAffiliate(videoAffiliate);
        }
        String videoLanguageCode = metadata.getVideoLanguageCode();
        if (videoLanguageCode != null) {
            customerVideoData.setVideoLanguageCode(videoLanguageCode);
        }
        String videoSeries = metadata.getVideoSeries();
        if (videoSeries != null) {
            customerVideoData.setVideoSeries(videoSeries);
        }
        String videoCreatorId = metadata.getVideoCreatorId();
        if (videoCreatorId != null) {
            customerVideoData.setVideoCreatorId(videoCreatorId);
        }
        String videoStreamType = metadata.getVideoStreamType();
        if (videoStreamType != null) {
            customerVideoData.setVideoStreamType(videoStreamType);
        }
        Boolean videoIsLive = metadata.getVideoIsLive();
        if (videoIsLive != null) {
            videoIsLive.booleanValue();
            customerVideoData.setVideoIsLive(videoIsLive);
        }
        CustomerViewData customerViewData = this.muxStats.getCustomerViewData();
        customerViewData.setViewClientApplicationName("KICK Live Streaming");
        customerViewData.setViewClientApplicationVersion(this.appVersion);
        String viewSessionId = metadata.getViewSessionId();
        if (viewSessionId != null) {
            customerViewData.setViewSessionId(viewSessionId);
        }
        String viewDrmType = metadata.getViewDrmType();
        if (viewDrmType != null) {
            customerViewData.setViewDrmType(viewDrmType);
        }
        String viewCdnOrigin = metadata.getViewCdnOrigin();
        if (viewCdnOrigin != null) {
            customerViewData.setViewCdnOrigin(viewCdnOrigin);
        }
        CustomerViewerData customerViewerData = new CustomerViewerData();
        String viewerPlan = metadata.getViewerPlan();
        if (viewerPlan != null) {
            customerViewerData.setViewerPlan(viewerPlan);
        }
        String viewerPlanCategory = metadata.getViewerPlanCategory();
        if (viewerPlanCategory != null) {
            customerViewerData.setViewerPlanCategory(viewerPlanCategory);
        }
        CustomData customData = new CustomData();
        String playerDeviceId = metadata.getPlayerDeviceId();
        if (playerDeviceId != null) {
            customData.setCustomData1(playerDeviceId);
        }
        if (renditionModified != null) {
            customData.setCustomData6(renditionModified);
        }
        this.muxStats.setCustomerData(new CustomerData(this.muxStats.getCustomerPlayerData(), customerVideoData, customerViewData, customerViewerData, customData));
        this.renditionModified = renditionModified;
        if (str == null || renditionModified == null || Intrinsics.areEqual(str, renditionModified)) {
            return;
        }
        dispatch(new RenditionChangeEvent(createPlayerData()));
    }

    public final void updatePlaybackState(boolean isPaused, boolean isBuffering) {
        this.paused = isPaused;
        this.buffering = isBuffering;
    }

    public final void updatePlayerViewSize(int width, int height) {
        this.playerViewWidth = width;
        this.playerViewHeight = height;
        this.muxStats.setPlayerSize(width, height);
    }

    public final void updatePlaybackMode(PlaybackMode playbackMode) {
        Intrinsics.checkNotNullParameter(playbackMode, "playbackMode");
        this.muxStats.playbackModeChange(playbackMode, (String) null);
    }

    public final void dispatchPlayerReady() {
        dispatch(new PlayerReadyEvent(createPlayerData()));
    }

    public final void dispatchPlay() {
        if (this.playDispatched) {
            return;
        }
        this.playDispatched = true;
        dispatch(new PlayEvent(createPlayerData()));
    }

    public final void dispatchPlaying() {
        if (!this.viewStarted) {
            this.viewStarted = true;
            dispatch(new ViewStartEvent(createPlayerData()));
        }
        dispatch(new PlayingEvent(createPlayerData()));
    }

    public final void dispatchPause() {
        dispatch(new PauseEvent(createPlayerData()));
    }

    public final void dispatchRebufferStart() {
        if (this.rebuffering) {
            return;
        }
        this.rebuffering = true;
        dispatch(new RebufferStartEvent(createPlayerData()));
    }

    public final void dispatchRebufferEnd() {
        if (this.rebuffering) {
            this.rebuffering = false;
            dispatch(new RebufferEndEvent(createPlayerData()));
        }
    }

    public final void dispatchSeeking() {
        dispatch(new SeekingEvent(createPlayerData()));
    }

    public final void dispatchSeeked(long positionMs) {
        this.currentPositionMs = positionMs;
        dispatch(new SeekedEvent(createPlayerData()));
    }

    public final void dispatchTimeUpdate() {
        dispatch(new TimeUpdateEvent(createPlayerData()));
    }

    public final void dispatchEnded() {
        dispatch(new EndedEvent(createPlayerData()));
        dispatchViewEnd();
    }

    public final void dispatchViewEnd() {
        if (!this.viewStarted || this.viewEnded) {
            return;
        }
        this.viewEnded = true;
        dispatch(new ViewEndEvent(createPlayerData()));
    }

    public final void dispatchError(PlayerException error) throws JSONException {
        Intrinsics.checkNotNullParameter(error, "error");
        String errorMessage = error.getErrorMessage();
        Intrinsics.checkNotNull(errorMessage);
        if (StringsKt.isBlank(errorMessage)) {
            errorMessage = null;
        }
        if (errorMessage == null && (errorMessage = error.getMessage()) == null) {
            errorMessage = "Unknown IVS player error";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("source", error.getSource());
        jSONObject.put("error_type", error.getErrorType().name());
        jSONObject.put("error_type_code", error.getErrorType().getErrorCode());
        jSONObject.put("code", error.getCode());
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        PlayerData playerDataCreatePlayerData = createPlayerData();
        playerDataCreatePlayerData.setPlayerErrorCode(error.getErrorType().name() + ServerSentEventKt.COLON + error.getCode());
        playerDataCreatePlayerData.setPlayerErrorMessage(errorMessage);
        playerDataCreatePlayerData.setPlayerErrorContext(string);
        dispatch(new ErrorEvent(playerDataCreatePlayerData, string, ErrorEvent.ErrorSeverity.FATAL));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void dispatchAdEvent(MuxAdEventData event) {
        Integer adIndex;
        Intrinsics.checkNotNullParameter(event, "event");
        String eventName = event.getEventName();
        switch (eventName.hashCode()) {
            case -1163336193:
                if (eventName.equals("adStart")) {
                    MuxAdEventData muxAdEventDataFillingMissingFields = event.fillingMissingFields(this.activeAdEvent);
                    String strKeyFor = keyFor(muxAdEventDataFillingMissingFields);
                    this.activeAdKey = strKeyFor;
                    this.activeAdEvent = muxAdEventDataFillingMissingFields;
                    this.quartilesDispatchedByAdKey.put(strKeyFor, new LinkedHashSet());
                    if (muxAdEventDataFillingMissingFields.getAdIndex() == null || ((adIndex = muxAdEventDataFillingMissingFields.getAdIndex()) != null && adIndex.intValue() == 1)) {
                        dispatchAdPlaybackEvent(new AdBreakStartEvent(createPlayerData()), muxAdEventDataFillingMissingFields);
                    }
                    dispatchAdPlaybackEvent(new AdPlayEvent(createPlayerData()), muxAdEventDataFillingMissingFields);
                    dispatchAdPlaybackEvent(new AdPlayingEvent(createPlayerData()), muxAdEventDataFillingMissingFields);
                    return;
                }
                return;
            case 92630456:
                if (!eventName.equals("adEnd")) {
                    return;
                }
                break;
            case 1119772528:
                if (eventName.equals("adProgress")) {
                    MuxAdEventData muxAdEventDataFillingMissingFields2 = event.fillingMissingFields(this.activeAdEvent);
                    this.activeAdEvent = muxAdEventDataFillingMissingFields2;
                    dispatchAdQuartilesIfNeeded$default(this, muxAdEventDataFillingMissingFields2, false, 2, null);
                    return;
                }
                return;
            case 1272062118:
                if (!eventName.equals("nonlinearAdEnd")) {
                    return;
                }
                break;
            default:
                return;
        }
        MuxAdEventData muxAdEventDataFillingMissingFields3 = event.fillingMissingFields(this.activeAdEvent);
        dispatchAdQuartilesIfNeeded(muxAdEventDataFillingMissingFields3, true);
        dispatchAdPlaybackEvent(new AdEndedEvent(createPlayerData()), muxAdEventDataFillingMissingFields3);
        if (muxAdEventDataFillingMissingFields3.getAdIndex() == null || muxAdEventDataFillingMissingFields3.getAdCount() == null || Intrinsics.areEqual(muxAdEventDataFillingMissingFields3.getAdIndex(), muxAdEventDataFillingMissingFields3.getAdCount())) {
            dispatchAdPlaybackEvent(new AdBreakEndEvent(createPlayerData()), muxAdEventDataFillingMissingFields3);
            dispatchPlaying();
        }
        this.quartilesDispatchedByAdKey.remove(keyFor(muxAdEventDataFillingMissingFields3));
        this.activeAdKey = null;
        this.activeAdEvent = null;
    }

    private final void dispatchAdPlaybackEvent(AdEvent muxEvent, MuxAdEventData event) {
        muxEvent.setAdData(createAdData(event));
        muxEvent.setVideoData(createVideoData());
        dispatch(muxEvent);
    }

    static /* synthetic */ void dispatchAdQuartilesIfNeeded$default(MuxAnalyticsListener muxAnalyticsListener, MuxAdEventData muxAdEventData, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        muxAnalyticsListener.dispatchAdQuartilesIfNeeded(muxAdEventData, z);
    }

    private final void dispatchAdQuartilesIfNeeded(MuxAdEventData event, boolean includeAllElapsedQuartiles) {
        Double durationSeconds = event.getDurationSeconds();
        if (durationSeconds != null) {
            if (durationSeconds.doubleValue() <= 0.0d) {
                durationSeconds = null;
            }
            if (durationSeconds != null) {
                double dDoubleValue = durationSeconds.doubleValue();
                Double elapsedSeconds = event.getElapsedSeconds();
                if (elapsedSeconds != null) {
                    double dDoubleValue2 = elapsedSeconds.doubleValue();
                    double dCoerceIn = RangesKt.coerceIn(dDoubleValue2 / dDoubleValue, 0.0d, 1.0d);
                    String strKeyFor = keyFor(event);
                    Map<String, Set<Integer>> map = this.quartilesDispatchedByAdKey;
                    LinkedHashSet linkedHashSet = map.get(strKeyFor);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                        map.put(strKeyFor, linkedHashSet);
                    }
                    Set<Integer> set = linkedHashSet;
                    for (MuxAdQuartile muxAdQuartile : CollectionsKt.listOf((Object[]) new MuxAdQuartile[]{new MuxAdQuartile(0.25d, 25, new AdFirstQuartileEvent(createPlayerData())), new MuxAdQuartile(0.5d, 50, new AdMidpointEvent(createPlayerData())), new MuxAdQuartile(0.75d, 75, new AdThirdQuartileEvent(createPlayerData()))})) {
                        if (!set.contains(Integer.valueOf(muxAdQuartile.getMarker())) && (dCoerceIn >= muxAdQuartile.getThreshold() || (includeAllElapsedQuartiles && dDoubleValue2 >= muxAdQuartile.getThreshold() * dDoubleValue))) {
                            set.add(Integer.valueOf(muxAdQuartile.getMarker()));
                            dispatchAdPlaybackEvent(muxAdQuartile.getEvent(), event);
                        }
                    }
                }
            }
        }
    }

    private final AdData createAdData(MuxAdEventData event) throws JSONException {
        AdData adData = new AdData();
        adData.setAdId(event.getAdId());
        adData.setAdCreativeId(event.getCreativeId());
        adData.setAdUniversalId(event.getUniversalId());
        adData.setAdAssetUrl(event.getAssetUrl());
        adData.setAdType(adTypeFor(event));
        return adData;
    }

    private final AdType adTypeFor(MuxAdEventData event) {
        Double adStartSeconds = event.getAdStartSeconds();
        if (adStartSeconds != null) {
            return adStartSeconds.doubleValue() <= 0.0d ? AdType.PRE_ROLL : AdType.MID_ROLL;
        }
        return AdType.MID_ROLL;
    }

    private final String keyFor(MuxAdEventData event) {
        String adId = event.getAdId();
        String str = null;
        if (adId != null) {
            if (StringsKt.isBlank(adId)) {
                adId = null;
            }
            if (adId != null) {
                return adId;
            }
        }
        String creativeId = event.getCreativeId();
        if (creativeId != null && !StringsKt.isBlank(creativeId)) {
            str = creativeId;
        }
        if (str != null) {
            return str;
        }
        String str2 = this.activeAdKey;
        return str2 == null ? "unknown-ad" : str2;
    }

    private final PlayerData createPlayerData() {
        PlayerData playerData = new PlayerData();
        playerData.setPlayerPlayheadTime(Long.valueOf(this.currentPositionMs));
        playerData.setPlayerIsPaused(Boolean.valueOf(this.paused));
        playerData.setPlayerWidth(Integer.valueOf(this.playerViewWidth));
        playerData.setPlayerHeight(Integer.valueOf(this.playerViewHeight));
        playerData.setPlayerSoftwareName("Amazon IVS Player");
        playerData.setPlayerSoftwareVersion(BuildConfig.IVS_PLAYER_VERSION);
        return playerData;
    }

    private final VideoData createVideoData() throws JSONException {
        VideoData videoData = new VideoData();
        videoData.setVideoSourceMimeType("application/x-mpegURL");
        videoData.setVideoSourceWidth(this.sourceWidth);
        videoData.setVideoSourceHeight(this.sourceHeight);
        videoData.setVideoSourceDuration(this.sourceDurationMs);
        videoData.setVideoSourceAdvertisedBitrate(this.sourceAdvertisedBitrate);
        videoData.setVideoSourceAdvertisedFramerate(this.sourceAdvertisedFramerate);
        return videoData;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    /* JADX INFO: renamed from: getCurrentPosition, reason: from getter */
    public long getCurrentPositionMs() {
        return this.currentPositionMs;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public String getMimeType() {
        return "application/x-mpegURL";
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Integer getSourceWidth() {
        return this.sourceWidth;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Integer getSourceHeight() {
        return this.sourceHeight;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Integer getSourceAdvertisedBitrate() {
        return this.sourceAdvertisedBitrate;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public Float getSourceAdvertisedFramerate() {
        return this.sourceAdvertisedFramerate;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public String getSourceCodec() {
        return this.sourceCodec;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    /* JADX INFO: renamed from: getSourceDuration, reason: from getter */
    public Long getSourceDurationMs() {
        return this.sourceDurationMs;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    /* JADX INFO: renamed from: isPaused, reason: from getter */
    public boolean getPaused() {
        return this.paused;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    /* JADX INFO: renamed from: isBuffering, reason: from getter */
    public boolean getBuffering() {
        return this.buffering;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public int getPlayerViewWidth() {
        return this.playerViewWidth;
    }

    @Override // com.mux.stats.sdk.muxstats.IPlayerListener
    public int getPlayerViewHeight() {
        return this.playerViewHeight;
    }
}
