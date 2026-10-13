package io.datazoom.sdk.model;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import com.datadog.trace.api.DDTags;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.cast.MediaError;
import com.mux.stats.sdk.core.events.playback.EndedEvent;
import com.mux.stats.sdk.core.events.playback.SeekingEvent;
import com.mux.stats.sdk.core.model.EnvironmentData;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetaData.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lio/datazoom/sdk/model/MetaData;", "", "type", "Lio/datazoom/sdk/model/MetaData$Type;", "data", "<init>", "(Lio/datazoom/sdk/model/MetaData$Type;Ljava/lang/Object;)V", "getType", "()Lio/datazoom/sdk/model/MetaData$Type;", "getData", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Type", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MetaData {
    private final Object data;
    private final Type type;

    public static /* synthetic */ MetaData copy$default(MetaData metaData, Type type, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            type = metaData.type;
        }
        if ((i & 2) != 0) {
            obj = metaData.data;
        }
        return metaData.copy(type, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public final MetaData copy(Type type, Object data) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        return new MetaData(type, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaData)) {
            return false;
        }
        MetaData metaData = (MetaData) other;
        return this.type == metaData.type && Intrinsics.areEqual(this.data, metaData.data);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "MetaData(type=" + this.type + ", data=" + this.data + ")";
    }

    public MetaData(Type type, Object data) {
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

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FULLSCREEN' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: MetaData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b}\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bwj\u0002\bxj\u0002\byj\u0002\bzj\u0002\b{j\u0002\b|j\u0002\b}j\u0002\b~j\u0002\b\u007fj\u0003\b\u0080\u0001j\u0003\b\u0081\u0001¨\u0006\u0082\u0001"}, d2 = {"Lio/datazoom/sdk/model/MetaData$Type;", "", "value", "", "isAttribute", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getValue", "()Ljava/lang/String;", ViewUtilsKt.UNKNOWN_DESTINATION_URL, "AUTO_START", "CONTROLS", "IS_LIMITED_AD_TRACKING_ENABLED", "USER_AGENT", "DURATION", MediaError.ERROR_TYPE_ERROR, "FULLSCREEN", "CLIENT_IP", "LATITUDE", "LONGITUDE", "OS", "OS_VERSION", "OS_NAME", "PAUSED", "PLAYER_NAME", "CUSTOM_EVENTS_ALL", "CUSTOM_METADATA_ALL", "PLAYER_VERSION", "SOURCE", "TITLE", "VOLUME_LEVEL", "ENDED", "STARTUP_DURATION_TOTAL_MS", "STARTUP_DURATION_CONTENT_MS", "LOOP", "READY_STATE", "STREAMING_PROTOCOL", "SEEKING", "STREAMING_TYPE", "ASN", "ASN_ORGANIZATION", "CDN", "CITY", "COUNTRY_CODE", "REGION_CODE", "ISP", "ABS_SHIFT", "AUDIO_TRACKS", "DEFAULT_MUTED", "MUTED", "LANGUAGE", "IS_MUTED", "CONTENT_ID", "DESCRIPTION", "COUNTRY", "REGION", "POSTAL_CODE", "ORIENTATION", "CONNECTION_TYPE", "ADVERTISING_ID", "AD_TRACKING_OPT_OUT", "DEVICE_ID", "DEVICE_NAME", "DEVICE_TYPE", "SESSION_START_TIMESTAMP", "DISTRICT", "CONTINENT", "CONTINENT_CODE", "PLAYBACK_RATE_DEFAULT", "ADVERTISER_NAME", "DZ_SDK_VERSION", "MILESTONE_PERCENT", "FROM_MILLIS", "TO_MILLIS", "ERROR_CODE", "ERROR_MSG", "SESSION_ID", "SUBTITLES", "SID", "PLAYER_HEIGHT", "PLAYER_WIDTH", "SEEK_END_POINT", "SEEK_START_POINT", "VIEW_ID", "ASSET_ID", "HEARTBEAT_COUNT", "EVENT_COUNT", "FRAME_RATE", "CONTENT_STARTUP_DURATION", "WRAPPER_SYSTEMS", "WRAPPER_CREATIVE_IDS", "WRAPPER_ID", "TOTAL_STARTUP_DURATION", "DEVICE_MFG", "SERVER_TS_MILLIS_OFFSET", "TIMESTAMP", CredentialProviderBaseController.TYPE_TAG, "PAGE_TITLE", "PAGE_URL", "REFFER_URL", "AUTOSTART", "PRELOAD", "CONFIGURATION_ID", "EVENT_ID", "APP_SESSION_ID", "APP_SESSION_START_TS_MS", "CONTENT_SESSION_ID", "MEDIA_TYPE", "CUSTOMER_CODE", "SITE_DOMAIN", "AD_ID", "AD_POSITION", "AD_TIME_OFFSET", "AD_SYSTEM", "AD_CLICK_URL", "AD_DURATION_SEC", "AD_BREAK_ID", "AD_SESSION_ID", "AD_BLOCKER", "AD_CREATIVE_ID", "AD_PARTNER", "AD_SKIPPED", "REQUEST_ID", "CASTING", "TIMEZONE_OFFSET", "TIMEZONE_NAME", "MOBILE_CONNECTION", "DOWNLOADED", "QUALIFIED_VIEW_SEC", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type AD_SESSION_ID;
        public static final Type ASSET_ID;
        public static final Type CDN;
        public static final Type COUNTRY;
        public static final Type DEVICE_MFG;
        public static final Type DEVICE_NAME;
        public static final Type DZ_SDK_VERSION;
        public static final Type ENDED;
        public static final Type FRAME_RATE;
        public static final Type FULLSCREEN;
        public static final Type ISP;
        public static final Type LANGUAGE;
        public static final Type PLAYER_NAME;
        public static final Type PLAYER_WIDTH;
        public static final Type PRELOAD;
        public static final Type READY_STATE;
        public static final Type SITE_DOMAIN;
        public static final Type STREAMING_PROTOCOL;
        public static final Type SUBTITLES;
        public static final Type TIMEZONE_NAME;
        public static final Type TO_MILLIS;
        public static final Type WRAPPER_CREATIVE_IDS;
        private final String value;
        public static final Type Unknown = new Type(ViewUtilsKt.UNKNOWN_DESTINATION_URL, 0, "UNKNOWN", false, 2, null);
        public static final Type AUTO_START = new Type("AUTO_START", 1, "autoStart", false, 2, null);
        public static final Type CONTROLS = new Type("CONTROLS", 2, "controls", false, 2, null);
        public static final Type IS_LIMITED_AD_TRACKING_ENABLED = new Type("IS_LIMITED_AD_TRACKING_ENABLED", 3, "is_limited_adtracking_enabled", false, 2, null);
        public static final Type USER_AGENT = new Type("USER_AGENT", 4, "user_agent", false, 2, null);
        public static final Type DURATION = new Type("DURATION", 5, "duration_sec", false, 2, null);
        public static final Type ERROR = new Type(MediaError.ERROR_TYPE_ERROR, 6, "error", false, 2, null);
        public static final Type CLIENT_IP = new Type("CLIENT_IP", 8, "client_ip", false, 2, null);
        public static final Type LATITUDE = new Type("LATITUDE", 9, "latitude", false, 2, null);
        public static final Type LONGITUDE = new Type("LONGITUDE", 10, "longitude", false, 2, null);
        public static final Type OS = new Type("OS", 11, "os", false, 2, null);
        public static final Type OS_VERSION = new Type("OS_VERSION", 12, "os_version", false, 2, null);
        public static final Type OS_NAME = new Type("OS_NAME", 13, "os_name", false, 2, null);
        public static final Type PAUSED = new Type("PAUSED", 14, "paused", false, 2, null);
        public static final Type CUSTOM_EVENTS_ALL = new Type("CUSTOM_EVENTS_ALL", 16, "custom_events_all", false, 2, null);
        public static final Type CUSTOM_METADATA_ALL = new Type("CUSTOM_METADATA_ALL", 17, "custom_metadata_all", false, 2, null);
        public static final Type PLAYER_VERSION = new Type("PLAYER_VERSION", 18, "player_version", false, 2, null);
        public static final Type SOURCE = new Type("SOURCE", 19, "source", false, 2, null);
        public static final Type TITLE = new Type("TITLE", 20, "title", false, 2, null);
        public static final Type VOLUME_LEVEL = new Type("VOLUME_LEVEL", 21, "volumeLevel", false, 2, null);
        public static final Type STARTUP_DURATION_TOTAL_MS = new Type("STARTUP_DURATION_TOTAL_MS", 23, "startup_duration_total_ms", true);
        public static final Type STARTUP_DURATION_CONTENT_MS = new Type("STARTUP_DURATION_CONTENT_MS", 24, "startup_duration_content_ms", true);
        public static final Type LOOP = new Type("LOOP", 25, "loop", false, 2, null);
        public static final Type SEEKING = new Type("SEEKING", 28, SeekingEvent.TYPE, false, 2, null);
        public static final Type STREAMING_TYPE = new Type("STREAMING_TYPE", 29, "streaming_type", false, 2, null);
        public static final Type ASN = new Type("ASN", 30, "asn", false, 2, null);
        public static final Type ASN_ORGANIZATION = new Type("ASN_ORGANIZATION", 31, "asn_org", false, 2, null);
        public static final Type CITY = new Type("CITY", 33, "city", false, 2, null);
        public static final Type COUNTRY_CODE = new Type("COUNTRY_CODE", 34, "country_code", false, 2, null);
        public static final Type REGION_CODE = new Type("REGION_CODE", 35, "region_code", false, 2, null);
        public static final Type ABS_SHIFT = new Type("ABS_SHIFT", 37, "abs_shift", true);
        public static final Type AUDIO_TRACKS = new Type("AUDIO_TRACKS", 38, "audioTracks", false, 2, null);
        public static final Type DEFAULT_MUTED = new Type("DEFAULT_MUTED", 39, "default_muted", false, 2, null);
        public static final Type MUTED = new Type("MUTED", 40, "muted", false, 2, null);
        public static final Type IS_MUTED = new Type("IS_MUTED", 42, "isMuted", false, 2, null);
        public static final Type CONTENT_ID = new Type("CONTENT_ID", 43, "contentId", false, 2, null);
        public static final Type DESCRIPTION = new Type("DESCRIPTION", 44, "description", false, 2, null);
        public static final Type REGION = new Type("REGION", 46, "region", false, 2, null);
        public static final Type POSTAL_CODE = new Type("POSTAL_CODE", 47, "postal_code", false, 2, null);
        public static final Type ORIENTATION = new Type("ORIENTATION", 48, "orientation", false, 2, null);
        public static final Type CONNECTION_TYPE = new Type("CONNECTION_TYPE", 49, "connectionType", false, 2, null);
        public static final Type ADVERTISING_ID = new Type("ADVERTISING_ID", 50, "advertising_id", false, 2, null);
        public static final Type AD_TRACKING_OPT_OUT = new Type("AD_TRACKING_OPT_OUT", 51, "ad_tracking_opt_out", false, 2, null);
        public static final Type DEVICE_ID = new Type("DEVICE_ID", 52, "device_id", false, 2, null);
        public static final Type DEVICE_TYPE = new Type("DEVICE_TYPE", 54, "device_type", false, 2, null);
        public static final Type SESSION_START_TIMESTAMP = new Type("SESSION_START_TIMESTAMP", 55, "sessionStartTimestamp", false, 2, null);
        public static final Type DISTRICT = new Type("DISTRICT", 56, "district", false, 2, null);
        public static final Type CONTINENT = new Type("CONTINENT", 57, "continent", false, 2, null);
        public static final Type CONTINENT_CODE = new Type("CONTINENT_CODE", 58, "continent_code", false, 2, null);
        public static final Type PLAYBACK_RATE_DEFAULT = new Type("PLAYBACK_RATE_DEFAULT", 59, "default_playback_rate", false, 2, null);
        public static final Type ADVERTISER_NAME = new Type("ADVERTISER_NAME", 60, "advertiser_name", false, 2, null);
        public static final Type MILESTONE_PERCENT = new Type("MILESTONE_PERCENT", 62, "milestone_percent", true);
        public static final Type FROM_MILLIS = new Type("FROM_MILLIS", 63, "from_millis", false, 2, null);
        public static final Type ERROR_CODE = new Type("ERROR_CODE", 65, "error_code", true);
        public static final Type ERROR_MSG = new Type("ERROR_MSG", 66, "error_msg", true);
        public static final Type SESSION_ID = new Type("SESSION_ID", 67, "session_id", false, 2, null);
        public static final Type SID = new Type("SID", 69, EnvironmentData.SESSION_ID, false, 2, null);
        public static final Type PLAYER_HEIGHT = new Type("PLAYER_HEIGHT", 70, "player_height", false, 2, null);
        public static final Type SEEK_END_POINT = new Type("SEEK_END_POINT", 72, "seek_end_point_ms", true);
        public static final Type SEEK_START_POINT = new Type("SEEK_START_POINT", 73, "seek_start_point_ms", true);
        public static final Type VIEW_ID = new Type("VIEW_ID", 74, RumEventMeta.VIEW_ID_KEY, false, 2, null);
        public static final Type HEARTBEAT_COUNT = new Type("HEARTBEAT_COUNT", 76, "heartbeat_count", true);
        public static final Type EVENT_COUNT = new Type("EVENT_COUNT", 77, "event_count", false, 2, null);
        public static final Type CONTENT_STARTUP_DURATION = new Type("CONTENT_STARTUP_DURATION", 79, "contentStartupDuration", false, 2, null);
        public static final Type WRAPPER_SYSTEMS = new Type("WRAPPER_SYSTEMS", 80, "wrapper_systems", false, 2, null);
        public static final Type WRAPPER_ID = new Type("WRAPPER_ID", 82, "wrapper_id", false, 2, null);
        public static final Type TOTAL_STARTUP_DURATION = new Type("TOTAL_STARTUP_DURATION", 83, "totalStartupDuration", false, 2, null);
        public static final Type SERVER_TS_MILLIS_OFFSET = new Type("SERVER_TS_MILLIS_OFFSET", 85, "server_ts_offset_ms", false, 2, null);
        public static final Type TIMESTAMP = new Type("TIMESTAMP", 86, "timestamp", false, 2, null);
        public static final Type TYPE = new Type(CredentialProviderBaseController.TYPE_TAG, 87, "type", false, 2, null);
        public static final Type PAGE_TITLE = new Type("PAGE_TITLE", 88, "page_title", false, 2, null);
        public static final Type PAGE_URL = new Type("PAGE_URL", 89, "page_url", false, 2, null);
        public static final Type REFFER_URL = new Type("REFFER_URL", 90, "referrer_url", false, 2, null);
        public static final Type AUTOSTART = new Type("AUTOSTART", 91, "autostart", false, 2, null);
        public static final Type CONFIGURATION_ID = new Type("CONFIGURATION_ID", 93, "configuration_id", false, 2, null);
        public static final Type EVENT_ID = new Type("EVENT_ID", 94, "event_id", false, 2, null);
        public static final Type APP_SESSION_ID = new Type("APP_SESSION_ID", 95, "app_session_id", false, 2, null);
        public static final Type APP_SESSION_START_TS_MS = new Type("APP_SESSION_START_TS_MS", 96, "app_session_start_ts_ms", false, 2, null);
        public static final Type CONTENT_SESSION_ID = new Type("CONTENT_SESSION_ID", 97, "content_session_id", false, 2, null);
        public static final Type MEDIA_TYPE = new Type("MEDIA_TYPE", 98, "media_type", false, 2, null);
        public static final Type CUSTOMER_CODE = new Type("CUSTOMER_CODE", 99, "customer_code", false, 2, null);
        public static final Type AD_ID = new Type("AD_ID", 101, "ad_id", false, 2, null);
        public static final Type AD_POSITION = new Type("AD_POSITION", 102, "ad_position", false, 2, null);
        public static final Type AD_TIME_OFFSET = new Type("AD_TIME_OFFSET", 103, "ad_time_offset_sec", false, 2, null);
        public static final Type AD_SYSTEM = new Type("AD_SYSTEM", 104, "ad_system", false, 2, null);
        public static final Type AD_CLICK_URL = new Type("AD_CLICK_URL", 105, "adClickUrl", false, 2, null);
        public static final Type AD_DURATION_SEC = new Type("AD_DURATION_SEC", 106, "ad_duration_sec", false, 2, null);
        public static final Type AD_BREAK_ID = new Type("AD_BREAK_ID", 107, "ad_break_id", false, 2, null);
        public static final Type AD_BLOCKER = new Type("AD_BLOCKER", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, "ad_blocker", false, 2, null);
        public static final Type AD_CREATIVE_ID = new Type("AD_CREATIVE_ID", MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE, "ad_creative_id", false, 2, null);
        public static final Type AD_PARTNER = new Type("AD_PARTNER", 111, "ad_partner", false, 2, null);
        public static final Type AD_SKIPPED = new Type("AD_SKIPPED", 112, "ad_skipped", false, 2, null);
        public static final Type REQUEST_ID = new Type("REQUEST_ID", 113, "rid", false, 2, null);
        public static final Type CASTING = new Type("CASTING", 114, "casting", false, 2, null);
        public static final Type TIMEZONE_OFFSET = new Type("TIMEZONE_OFFSET", 115, "timezone_offset", false, 2, null);
        public static final Type MOBILE_CONNECTION = new Type("MOBILE_CONNECTION", 117, "mobile_connection", false, 2, null);
        public static final Type DOWNLOADED = new Type("DOWNLOADED", 118, "downloaded", false, 2, null);
        public static final Type QUALIFIED_VIEW_SEC = new Type("QUALIFIED_VIEW_SEC", 119, "qualified_view_sec", true);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{Unknown, AUTO_START, CONTROLS, IS_LIMITED_AD_TRACKING_ENABLED, USER_AGENT, DURATION, ERROR, FULLSCREEN, CLIENT_IP, LATITUDE, LONGITUDE, OS, OS_VERSION, OS_NAME, PAUSED, PLAYER_NAME, CUSTOM_EVENTS_ALL, CUSTOM_METADATA_ALL, PLAYER_VERSION, SOURCE, TITLE, VOLUME_LEVEL, ENDED, STARTUP_DURATION_TOTAL_MS, STARTUP_DURATION_CONTENT_MS, LOOP, READY_STATE, STREAMING_PROTOCOL, SEEKING, STREAMING_TYPE, ASN, ASN_ORGANIZATION, CDN, CITY, COUNTRY_CODE, REGION_CODE, ISP, ABS_SHIFT, AUDIO_TRACKS, DEFAULT_MUTED, MUTED, LANGUAGE, IS_MUTED, CONTENT_ID, DESCRIPTION, COUNTRY, REGION, POSTAL_CODE, ORIENTATION, CONNECTION_TYPE, ADVERTISING_ID, AD_TRACKING_OPT_OUT, DEVICE_ID, DEVICE_NAME, DEVICE_TYPE, SESSION_START_TIMESTAMP, DISTRICT, CONTINENT, CONTINENT_CODE, PLAYBACK_RATE_DEFAULT, ADVERTISER_NAME, DZ_SDK_VERSION, MILESTONE_PERCENT, FROM_MILLIS, TO_MILLIS, ERROR_CODE, ERROR_MSG, SESSION_ID, SUBTITLES, SID, PLAYER_HEIGHT, PLAYER_WIDTH, SEEK_END_POINT, SEEK_START_POINT, VIEW_ID, ASSET_ID, HEARTBEAT_COUNT, EVENT_COUNT, FRAME_RATE, CONTENT_STARTUP_DURATION, WRAPPER_SYSTEMS, WRAPPER_CREATIVE_IDS, WRAPPER_ID, TOTAL_STARTUP_DURATION, DEVICE_MFG, SERVER_TS_MILLIS_OFFSET, TIMESTAMP, TYPE, PAGE_TITLE, PAGE_URL, REFFER_URL, AUTOSTART, PRELOAD, CONFIGURATION_ID, EVENT_ID, APP_SESSION_ID, APP_SESSION_START_TS_MS, CONTENT_SESSION_ID, MEDIA_TYPE, CUSTOMER_CODE, SITE_DOMAIN, AD_ID, AD_POSITION, AD_TIME_OFFSET, AD_SYSTEM, AD_CLICK_URL, AD_DURATION_SEC, AD_BREAK_ID, AD_SESSION_ID, AD_BLOCKER, AD_CREATIVE_ID, AD_PARTNER, AD_SKIPPED, REQUEST_ID, CASTING, TIMEZONE_OFFSET, TIMEZONE_NAME, MOBILE_CONNECTION, DOWNLOADED, QUALIFIED_VIEW_SEC};
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String str, int i, String str2, boolean z) {
            super(str, i);
            this.value = str2;
        }

        /* synthetic */ Type(String str, int i, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, (i2 & 2) != 0 ? false : z);
        }

        public final String getValue() {
            return this.value;
        }

        static {
            DefaultConstructorMarker defaultConstructorMarker = null;
            FULLSCREEN = new Type("FULLSCREEN", 7, "fullscreen", false, 2, defaultConstructorMarker);
            PLAYER_NAME = new Type("PLAYER_NAME", 15, "player_name", false, 2, defaultConstructorMarker);
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            ENDED = new Type("ENDED", 22, EndedEvent.TYPE, false, 2, defaultConstructorMarker2);
            READY_STATE = new Type("READY_STATE", 26, "ready_state", false, 2, defaultConstructorMarker2);
            STREAMING_PROTOCOL = new Type("STREAMING_PROTOCOL", 27, "streaming_protocol", false, 2, defaultConstructorMarker);
            DefaultConstructorMarker defaultConstructorMarker3 = null;
            CDN = new Type("CDN", 32, "cdn", false, 2, defaultConstructorMarker3);
            DefaultConstructorMarker defaultConstructorMarker4 = null;
            ISP = new Type("ISP", 36, "isp", false, 2, defaultConstructorMarker4);
            LANGUAGE = new Type("LANGUAGE", 41, DDTags.LANGUAGE_TAG_KEY, false, 2, defaultConstructorMarker4);
            COUNTRY = new Type("COUNTRY", 45, "country", false, 2, defaultConstructorMarker3);
            DEVICE_NAME = new Type("DEVICE_NAME", 53, "device_name", false, 2, defaultConstructorMarker3);
            DZ_SDK_VERSION = new Type("DZ_SDK_VERSION", 61, "dz_sdk_version", false, 2, defaultConstructorMarker3);
            DefaultConstructorMarker defaultConstructorMarker5 = null;
            TO_MILLIS = new Type("TO_MILLIS", 64, "to_millis", false, 2, defaultConstructorMarker5);
            SUBTITLES = new Type("SUBTITLES", 68, "subtitles", false, 2, defaultConstructorMarker5);
            DefaultConstructorMarker defaultConstructorMarker6 = null;
            PLAYER_WIDTH = new Type("PLAYER_WIDTH", 71, "player_width", false, 2, defaultConstructorMarker6);
            DefaultConstructorMarker defaultConstructorMarker7 = null;
            ASSET_ID = new Type("ASSET_ID", 75, "asset_id", false, 2, defaultConstructorMarker7);
            FRAME_RATE = new Type("FRAME_RATE", 78, "frameRate", false, 2, defaultConstructorMarker7);
            WRAPPER_CREATIVE_IDS = new Type("WRAPPER_CREATIVE_IDS", 81, "wrapperCreativeIds", false, 2, defaultConstructorMarker6);
            DEVICE_MFG = new Type("DEVICE_MFG", 84, "device_mfg", false, 2, defaultConstructorMarker3);
            PRELOAD = new Type("PRELOAD", 92, LinkHeader.Rel.PreLoad, false, 2, defaultConstructorMarker3);
            SITE_DOMAIN = new Type("SITE_DOMAIN", 100, "site_domain", false, 2, defaultConstructorMarker3);
            AD_SESSION_ID = new Type("AD_SESSION_ID", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, "ad_session_id", false, 2, defaultConstructorMarker3);
            TIMEZONE_NAME = new Type("TIMEZONE_NAME", 116, "timezone_name", false, 2, defaultConstructorMarker3);
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }
    }
}
