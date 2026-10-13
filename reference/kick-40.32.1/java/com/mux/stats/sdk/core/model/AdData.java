package com.mux.stats.sdk.core.model;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public final class AdData extends BaseQueryData {
    public static final String AD_ASSET_URL = "dasur";
    public static final String AD_CREATIVE_ID = "dcrid";
    public static final String AD_ID = "did";
    public static final String AD_PLAYING_TIME_MS_CUMULATIVE = "dpntimscv";
    public static final String AD_TAG_URL = "dtaur";
    public static final String AD_TYPE = "dty";
    public static final String AD_UNIVERSAL_ID = "dunid";
    public static final List<String> keys;

    static {
        LinkedList linkedList = new LinkedList();
        keys = linkedList;
        linkedList.add(AD_ASSET_URL);
        linkedList.add(AD_CREATIVE_ID);
        linkedList.add(AD_ID);
        linkedList.add(AD_TAG_URL);
        linkedList.add(AD_UNIVERSAL_ID);
        linkedList.add(AD_TYPE);
        linkedList.add(AD_PLAYING_TIME_MS_CUMULATIVE);
    }

    public AdData() {
    }

    public AdData(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, null);
    }

    public AdData(String str, String str2, String str3, String str4, String str5, AdType adType) throws JSONException {
        this();
        setAdAssetUrl(str);
        setAdTagUrl(str2);
        setAdCreativeId(str3);
        setAdId(str4);
        setAdUniversalId(str5);
        if (adType != null) {
            setAdType(adType);
        }
    }

    public final String getAdAssetUrl() {
        return get(AD_ASSET_URL);
    }

    public final String getAdCreativeId() {
        return get(AD_CREATIVE_ID);
    }

    public final String getAdId() {
        return get(AD_ID);
    }

    public final Long getAdPlayingTimeMsCumulative() throws JSONException {
        String str = get(AD_PLAYING_TIME_MS_CUMULATIVE);
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public final String getAdTagUrl() {
        return get(AD_TAG_URL);
    }

    public final AdType getAdType() {
        return AdType.fromTypeString(get(AD_TYPE));
    }

    public final String getAdUniversalId() {
        return get(AD_UNIVERSAL_ID);
    }

    public final void setAdAssetUrl(String str) throws JSONException {
        if (str != null) {
            put(AD_ASSET_URL, str);
        }
    }

    public final void setAdCreativeId(String str) throws JSONException {
        if (str != null) {
            put(AD_CREATIVE_ID, str);
        }
    }

    public final void setAdId(String str) throws JSONException {
        if (str != null) {
            put(AD_ID, str);
        }
    }

    public final void setAdPlayingTimeMsCumulative(Long l) throws JSONException {
        if (l != null) {
            put(AD_PLAYING_TIME_MS_CUMULATIVE, l.toString());
        }
    }

    public final void setAdTagUrl(String str) throws JSONException {
        if (str != null) {
            put(AD_TAG_URL, str);
        }
    }

    public final void setAdType(AdType adType) throws JSONException {
        if (adType != null) {
            put(AD_TYPE, adType.getTypeString());
        }
    }

    public final void setAdUniversalId(String str) throws JSONException {
        if (str != null) {
            put(AD_UNIVERSAL_ID, str);
        }
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public final void sync() {
    }
}
