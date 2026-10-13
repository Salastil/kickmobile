package com.google.ads.interactivemedia.pal;

import com.mux.stats.sdk.core.model.EnvironmentData;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
enum zzx {
    AD_SPAM_CAPABILITIES("aselc"),
    ADS_IDENTITY_TOKEN("adsid"),
    ADVERTISING_ID("rdid"),
    API_FRAMEWORKS("sdk_apis"),
    APP_NAME("an"),
    CTV("ctv"),
    DESCRIPTION_URL("video_url_to_fetch"),
    ESSENTIAL_ONLY_ID("eo_id"),
    ESSENTIAL_ONLY_ID_TIMESTAMP_SEC("eo_id_ts"),
    ID_TYPE("idtype"),
    LIMIT_AD_TRACKING("is_lat"),
    LTD("ltd"),
    MOBILE_SPAM("ms"),
    OMID_PARTNER("omid_p"),
    ORIENTATION("u_so"),
    PAGE_CORRELATOR("correlator"),
    PAL_VERSION("pal_v"),
    PER_VENDOR_ID("pvid"),
    PER_VENDOR_ID_SCOPE("pvid_s"),
    PLAYER_HEIGHT("vp_h"),
    PLAYER_TYPE("mpt"),
    PLAYER_VERSION("mpv"),
    PLAYER_WIDTH("vp_w"),
    PPID("ppid"),
    PLAY_ACTIVATION("vpa"),
    PLAY_MUTED("vpmute"),
    PUBLISHER_SUPPORTS_SKIP("pss"),
    CONTINUOUS_PLAYBACK("vconp"),
    SDK_VERSION("sdkv"),
    SESSION_ID(EnvironmentData.SESSION_ID),
    SODAR_CORRELATOR("sodar_correlator"),
    SPAM_CORRELATOR("asscs_correlator"),
    USER_AGENT("ua"),
    WTA_SUPPORTED("wta");

    private final String zzI;

    zzx(String str) {
        this.zzI = str;
    }

    public final String zza() {
        return this.zzI;
    }
}
