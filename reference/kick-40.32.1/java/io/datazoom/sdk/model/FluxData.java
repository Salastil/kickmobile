package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import com.mux.stats.sdk.core.events.playback.RequestBandwidthEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FluxData.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lio/datazoom/sdk/model/FluxData;", "", "type", "Lio/datazoom/sdk/model/FluxData$Type;", "data", "<init>", "(Lio/datazoom/sdk/model/FluxData$Type;Ljava/lang/Object;)V", "getType", "()Lio/datazoom/sdk/model/FluxData$Type;", "getData", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Type", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FluxData {
    private final Object data;
    private final Type type;

    public static /* synthetic */ FluxData copy$default(FluxData fluxData, Type type, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            type = fluxData.type;
        }
        if ((i & 2) != 0) {
            obj = fluxData.data;
        }
        return fluxData.copy(type, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public final FluxData copy(Type type, Object data) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        return new FluxData(type, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FluxData)) {
            return false;
        }
        FluxData fluxData = (FluxData) other;
        return this.type == fluxData.type && Intrinsics.areEqual(this.data, fluxData.data);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "FluxData(type=" + this.type + ", data=" + this.data + ")";
    }

    public FluxData(Type type, Object data) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        this.type = type;
        this.data = data;
    }

    public final Type getType() {
        return this.type;
    }

    public final Object getData() {
        return this.data;
    }

    /* JADX INFO: compiled from: FluxData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\bT\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bV¨\u0006W"}, d2 = {"Lio/datazoom/sdk/model/FluxData$Type;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "Bandwidth", "Bandwidth_KBPS", "BITRATE", "VOLUME_LEVEL", "PLAY_HEAD_POSITION", "BUFFER_FILL", "PLAYBACK_RATE", "PLAYER_STATE", "NUMBER_OF_VIDEOS", "RENDITION_HEIGHT", "RENDITION_NAME", "RENDITION_AUDIO_BITRATE", "RENDITION_AUDIO_BITRATE_KBPS", "CURRENT_AUDIO_TRACK", "RENDITION_WIDTH", "CURRENT_CAPTIONS", "TIME_SINCE_LAST_RENDITION_CHANGE", "TIME_SINCE_PAUSED", "TIME_SINCE_REQUESTED", "TIME_SINCE_STARTED", "NUMBER_OF_ERRORS_CONTENT", "NUMBER_OF_ERRORS", "NUMBER_OF_VIDEOS_PLAYED", "NUMBER_OF_ADS_REQUESTED", "TOTAL_BUFFER_TIME", "TIME_SINCE_AD_REQUESTED", "TIME_SINCE_AD_STARTED", "TIME_SINCE_LAST_AD_REQUESTED", "TIME_SINCE_AD_PAUSED", "TIME_SINCE_AD_BREAK_START", "TIME_SINCE_LAST_AD_BREAK_START", "TIME_SINCE_LAST_AD", "NUMBER_OF_ADS", "NUMBER_OF_ADS_PLAYED", "NUMBER_OF_ADS_BREAK_PLAYED", "TIME_SINCE_LAST_MILESTONE", "TIME_SINCE_LAST_AD_MILESTONE", "TIME_SINCE_LAST_HEARTBEAT", "VIEW_START_TIMESTAMP", "TIME_SINCE_BUFFER_START", "TIME_SINCE_SEEK_START", "TIME_SINCE_STALL_START", "TIME_SINCE_LAST_STALL_START_CONTENT_MS", "PLAYBACK_DURATION", "PLAYBACK_DURATION_ADS", "PAUSE_DURATION_CONTENT_MS", "PAUSE_DURATION_ADS_MS", "STARTUP_DURATION_TOTAL_MS", "ENGAGEMENT_DURATION", "RENDITION_VIDEO_BITRATE", "PLAYER_VIEWABLE", "PLAYBACK_STALL_DURATION", "PLAYBACK_STALL_COUNT", "PLAYBACK_STALL_DURATION_ADS", "PLAYBACK_STALL_DURATION_CONTENT", "PLAYBACK_STALL_COUNT_ADS", "PLAYBACK_STALL_COUNT_CONTENT", "CONTENT_SESSION_START_TS_MS", "CURRENT_SUBTITLES", "NUM_REQUESTS_CONTENT", "PLAYBACK_DURATION_CONTENT_MS", "RENDITION_VIDEO_BITRATE_KBPS", "STALL_COUNT_ADS", "STALL_COUNT_CONTENT", "STALL_DURATION_MS", "STALL_DURATION_CONTENT_MS", "STALL_DURATION_ADS_MS", "TIME_SINCE_BUFFER_START_MS", "TIME_SINCE_LAST_AD_COMPLETED_MS", "EVENT_COUNT", "NUMBER_OF_ERRORS_AD", "BUFFER_DURATION_CONTENT_MS", "BUFFER_DURATION_ADS_MS", "BUFFER_LENGTH_MS", "BUFFER_DURATION_MS", "PAUSE_DURATION_MS", "TIME_SINCE_LAST_BUFFER_START_CONTENT_MS", "PLAYER_VIEWABLE_PERCENT", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Type {
        UNKNOWN("UNKNOWN"),
        Bandwidth(RequestBandwidthEvent.TYPE),
        Bandwidth_KBPS("bandwidth_kbps"),
        BITRATE("bitrate"),
        VOLUME_LEVEL("volume_level_percent"),
        PLAY_HEAD_POSITION("playhead_position_sec"),
        BUFFER_FILL("bufferFill"),
        PLAYBACK_RATE("playback_rate"),
        PLAYER_STATE("player_state"),
        NUMBER_OF_VIDEOS("numberOfVideos"),
        RENDITION_HEIGHT("rendition_height"),
        RENDITION_NAME("rendition_name"),
        RENDITION_AUDIO_BITRATE("renditionAudioBitrate"),
        RENDITION_AUDIO_BITRATE_KBPS("rendition_audio_bitrate_kbps"),
        CURRENT_AUDIO_TRACK("current_audio_track"),
        RENDITION_WIDTH("rendition_width"),
        CURRENT_CAPTIONS("currentCaptions"),
        TIME_SINCE_LAST_RENDITION_CHANGE("time_since_last_rendition_change_ms"),
        TIME_SINCE_PAUSED("time_since_last_pause_ms"),
        TIME_SINCE_REQUESTED("time_since_request_content_ms"),
        TIME_SINCE_STARTED("time_since_started_content_ms"),
        NUMBER_OF_ERRORS_CONTENT("num_errors_content"),
        NUMBER_OF_ERRORS("num_errors"),
        NUMBER_OF_VIDEOS_PLAYED("num_content_plays"),
        NUMBER_OF_ADS_REQUESTED("numberOfAdsRequested"),
        TOTAL_BUFFER_TIME("totalBufferTime"),
        TIME_SINCE_AD_REQUESTED("time_since_request_ad_ms"),
        TIME_SINCE_AD_STARTED("time_since_last_started_ad_ms"),
        TIME_SINCE_LAST_AD_REQUESTED("time_since_last_request_ad_ms"),
        TIME_SINCE_AD_PAUSED("timeSinceAdPaused"),
        TIME_SINCE_AD_BREAK_START("time_since_ad_break_start_ms"),
        TIME_SINCE_LAST_AD_BREAK_START("time_since_last_ad_break_start_ms"),
        TIME_SINCE_LAST_AD("timeSinceLastAd"),
        NUMBER_OF_ADS("numberOfAds"),
        NUMBER_OF_ADS_PLAYED("num_ad_plays"),
        NUMBER_OF_ADS_BREAK_PLAYED("num_ad_break_plays"),
        TIME_SINCE_LAST_MILESTONE("time_since_last_milestone_content_ms"),
        TIME_SINCE_LAST_AD_MILESTONE("time_since_last_milestone_ad_ms"),
        TIME_SINCE_LAST_HEARTBEAT("time_since_last_heartbeat_ms"),
        VIEW_START_TIMESTAMP("viewStartTimestamp"),
        TIME_SINCE_BUFFER_START("timeSinceBufferStart"),
        TIME_SINCE_SEEK_START("time_since_last_seek_start_ms"),
        TIME_SINCE_STALL_START("time_since_last_stall_start_ms"),
        TIME_SINCE_LAST_STALL_START_CONTENT_MS("time_since_last_stall_start_content_ms"),
        PLAYBACK_DURATION("playback_duration_ms"),
        PLAYBACK_DURATION_ADS("playback_duration_ads_ms"),
        PAUSE_DURATION_CONTENT_MS("pause_duration_content_ms"),
        PAUSE_DURATION_ADS_MS("pause_duration_ads_ms"),
        STARTUP_DURATION_TOTAL_MS("startup_duration_total_ms"),
        ENGAGEMENT_DURATION("engagement_duration_ms"),
        RENDITION_VIDEO_BITRATE("renditionVideoBitrate"),
        PLAYER_VIEWABLE("player_viewable"),
        PLAYBACK_STALL_DURATION("playbackStallDuration"),
        PLAYBACK_STALL_COUNT("stall_count"),
        PLAYBACK_STALL_DURATION_ADS("playbackStallDurationAds"),
        PLAYBACK_STALL_DURATION_CONTENT("playbackStallDurationContent"),
        PLAYBACK_STALL_COUNT_ADS("playbackStallCountAds"),
        PLAYBACK_STALL_COUNT_CONTENT("playbackStallCountContent"),
        CONTENT_SESSION_START_TS_MS("content_session_start_ts_ms"),
        CURRENT_SUBTITLES("current_subtitles"),
        NUM_REQUESTS_CONTENT("num_requests_content"),
        PLAYBACK_DURATION_CONTENT_MS("playback_duration_content_ms"),
        RENDITION_VIDEO_BITRATE_KBPS("rendition_video_bitrate_kbps"),
        STALL_COUNT_ADS("stall_count_ads"),
        STALL_COUNT_CONTENT("stall_count_content"),
        STALL_DURATION_MS("stall_duration_ms"),
        STALL_DURATION_CONTENT_MS("stall_duration_content_ms"),
        STALL_DURATION_ADS_MS("stall_duration_ads_ms"),
        TIME_SINCE_BUFFER_START_MS("time_since_buffer_start_ms"),
        TIME_SINCE_LAST_AD_COMPLETED_MS("time_since_last_ad_completed_ms"),
        EVENT_COUNT("event_count"),
        NUMBER_OF_ERRORS_AD("num_errors_ads"),
        BUFFER_DURATION_CONTENT_MS("buffer_duration_content_ms"),
        BUFFER_DURATION_ADS_MS("buffer_duration_ads_ms"),
        BUFFER_LENGTH_MS("buffer_length_ms"),
        BUFFER_DURATION_MS("buffer_duration_ms"),
        PAUSE_DURATION_MS("pause_duration_ms"),
        TIME_SINCE_LAST_BUFFER_START_CONTENT_MS("time_since_last_buffer_start_content_ms"),
        PLAYER_VIEWABLE_PERCENT("player_viewable_percent");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        Type(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
