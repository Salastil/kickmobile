package com.google.ads.interactivemedia.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzr {
    ERROR_CODE("errcode"),
    SIGNAL_SDK_ERROR_CODE("ssec"),
    LOGGING_DENOMINATOR("denom"),
    NONCE_LENGTH("length"),
    NONCE_LOADED_TIME("nonload"),
    NONCE_LOADER_INIT_TIME("loaderinit"),
    NONCE_REQUESTED_TIME("nonreq"),
    SERVICE_END_TIME("srvcend"),
    SERVICE_START_TIME("srvcstrt"),
    ANDROID_BUILD_VERSION("bv"),
    FORCE_LIMITED_ADS("forceltd"),
    CONSENT_TO_COOKIES("ctc"),
    IS_DIRECTED_FOR_CHILD("idc"),
    IS_TV("tv"),
    PLATFORM_SIGNAL_COLLECTOR_INCLUDED("psc"),
    TCF_GDPR_APPLIES("tcfga"),
    TCF_STORAGE_ALLOWED("tcfsa");

    private final String zzr;

    zzr(String str) {
        this.zzr = str;
    }

    public final String zza() {
        return this.zzr;
    }
}
