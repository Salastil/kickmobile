package com.mux.stats.sdk.core.model;

import java.util.ArrayList;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class CustomerVideoData extends BaseQueryData {
    public static final String VIDEO_AFFILIATE = "vaf";
    public static final String VIDEO_AUDIO_CODEC = "vaocc";
    public static final String VIDEO_BRAND = "vbn";
    public static final String VIDEO_CDN = "vdn";
    public static final String VIDEO_CODEC = "vcc";
    public static final String VIDEO_CONTENT_TYPE = "vctty";
    public static final String VIDEO_CREATOR_ID = "vcqid";
    public static final String VIDEO_DURATION = "vdu";
    public static final String VIDEO_DYNAMIC_RANGE_TYPE = "vdyrgty";
    public static final String VIDEO_ENCODING_VARIANT = "vecva";
    public static final String VIDEO_EXPERIMENTS = "viep";
    public static final String VIDEO_ID = "vid";
    public static final String VIDEO_IS_LIVE = "visli";
    public static final String VIDEO_LANGUAGE_CODE = "vlacd";
    public static final String VIDEO_PRODUCER = "vpd";
    public static final String VIDEO_SERIES = "vsr";
    public static final String VIDEO_SOURCE_URL = "vsour";
    public static final String VIDEO_STREAM_TYPE = "vsmty";
    public static final String VIDEO_TITLE = "vtt";
    public static final String VIDEO_VARIANT_ID = "vvaid";
    public static final String VIDEO_VARIANT_NAME = "vvanm";
    public static final ArrayList<String> keys;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add("vdn");
        arrayList.add(VIDEO_CONTENT_TYPE);
        arrayList.add(VIDEO_DURATION);
        arrayList.add(VIDEO_ENCODING_VARIANT);
        arrayList.add(VIDEO_ID);
        arrayList.add(VIDEO_IS_LIVE);
        arrayList.add(VIDEO_LANGUAGE_CODE);
        arrayList.add(VIDEO_PRODUCER);
        arrayList.add(VIDEO_SERIES);
        arrayList.add(VIDEO_STREAM_TYPE);
        arrayList.add("vtt");
        arrayList.add(VIDEO_VARIANT_ID);
        arrayList.add(VIDEO_VARIANT_NAME);
        arrayList.add("vsour");
        arrayList.add(VIDEO_EXPERIMENTS);
        arrayList.add(VIDEO_AFFILIATE);
        arrayList.add(VIDEO_DYNAMIC_RANGE_TYPE);
        arrayList.add(VIDEO_CODEC);
        arrayList.add(VIDEO_AUDIO_CODEC);
        arrayList.add(VIDEO_BRAND);
        arrayList.add(VIDEO_CREATOR_ID);
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public String getDebugString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        StringBuilder sb = new StringBuilder("CustomerVideoData: ");
        String str20 = "";
        if (getVideoCdn() != null) {
            str = "\n    videoCdn: " + getVideoCdn();
        } else {
            str = "";
        }
        sb.append(str);
        if (getVideoContentType() != null) {
            str2 = "\n    videoContentType: " + getVideoContentType();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (getVideoDuration() != null) {
            str3 = "\n    videoDuration: " + getVideoDuration();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (getVideoEncodingVariant() != null) {
            str4 = "\n    videoEncodingVariant: " + getVideoEncodingVariant();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (getVideoIsLive() != null) {
            str5 = "\n    videoIsLive: " + getVideoIsLive();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (getVideoLanguageCode() != null) {
            str6 = "\n    videoLanguageCode: " + getVideoLanguageCode();
        } else {
            str6 = "";
        }
        sb.append(str6);
        if (getVideoProducer() != null) {
            str7 = "\n    videoProducer: " + getVideoProducer();
        } else {
            str7 = "";
        }
        sb.append(str7);
        if (getVideoSeries() != null) {
            str8 = "\n    videoSeries: " + getVideoSeries();
        } else {
            str8 = "";
        }
        sb.append(str8);
        if (getVideoStreamType() != null) {
            str9 = "\n    videoStreamType: " + getVideoStreamType();
        } else {
            str9 = "";
        }
        sb.append(str9);
        if (getVideoTitle() != null) {
            str10 = "\n    videoTitle: " + getVideoTitle();
        } else {
            str10 = "";
        }
        sb.append(str10);
        if (getVideoVariantId() != null) {
            str11 = "\n    videoVariantId: " + getVideoVariantId();
        } else {
            str11 = "";
        }
        sb.append(str11);
        if (getVideoVariantName() != null) {
            str12 = "\n    videoVariantName: " + getVideoVariantName();
        } else {
            str12 = "";
        }
        sb.append(str12);
        if (getVideoSourceUrl() != null) {
            str13 = "\n    videoSourceUrl: " + getVideoSourceUrl();
        } else {
            str13 = "";
        }
        sb.append(str13);
        if (getVideoExperiments() != null) {
            str14 = "\n    videoExperiments: " + getVideoExperiments();
        } else {
            str14 = "";
        }
        sb.append(str14);
        if (getVideoAffiliate() != null) {
            str15 = "\n    videoAffiliate: " + getVideoAffiliate();
        } else {
            str15 = "";
        }
        sb.append(str15);
        if (getVideoDynamicRangeType() != null) {
            str16 = "\n    videoDynamicRangeType: " + getVideoDynamicRangeType();
        } else {
            str16 = "";
        }
        sb.append(str16);
        if (getVideoCodec() != null) {
            str17 = "\n    videoCodec: " + getVideoCodec();
        } else {
            str17 = "";
        }
        sb.append(str17);
        if (getVideoAudioCodec() != null) {
            str18 = "\n    videoAudioCodec: " + getVideoAudioCodec();
        } else {
            str18 = "";
        }
        sb.append(str18);
        if (getVideoBrand() != null) {
            str19 = "\n    videoBrand: " + getVideoBrand();
        } else {
            str19 = "";
        }
        sb.append(str19);
        if (getVideoCreatorId() != null) {
            str20 = "\n    videoCreatorId: " + getVideoCreatorId();
        }
        sb.append(str20);
        return sb.toString();
    }

    public String getVideoAffiliate() {
        return get(VIDEO_AFFILIATE);
    }

    public String getVideoAudioCodec() {
        return get(VIDEO_AUDIO_CODEC);
    }

    public String getVideoBrand() {
        return get(VIDEO_BRAND);
    }

    public String getVideoCdn() {
        return get("vdn");
    }

    public String getVideoCodec() {
        return get(VIDEO_CODEC);
    }

    public String getVideoContentType() {
        return get(VIDEO_CONTENT_TYPE);
    }

    public String getVideoCreatorId() {
        return get(VIDEO_CREATOR_ID);
    }

    public Long getVideoDuration() throws JSONException {
        String str = get(VIDEO_DURATION);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getVideoDynamicRangeType() {
        return get(VIDEO_DYNAMIC_RANGE_TYPE);
    }

    public String getVideoEncodingVariant() {
        return get(VIDEO_ENCODING_VARIANT);
    }

    public String getVideoExperiments() {
        return get(VIDEO_EXPERIMENTS);
    }

    public String getVideoId() {
        return get(VIDEO_ID);
    }

    public Boolean getVideoIsLive() throws JSONException {
        String str = get(VIDEO_IS_LIVE);
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public String getVideoLanguageCode() {
        return get(VIDEO_LANGUAGE_CODE);
    }

    public String getVideoProducer() {
        return get(VIDEO_PRODUCER);
    }

    public String getVideoSeries() {
        return get(VIDEO_SERIES);
    }

    public String getVideoSourceUrl() {
        return get("vsour");
    }

    public String getVideoStreamType() {
        return get(VIDEO_STREAM_TYPE);
    }

    public String getVideoTitle() {
        return get("vtt");
    }

    public String getVideoVariantId() {
        return get(VIDEO_VARIANT_ID);
    }

    public String getVideoVariantName() {
        return get(VIDEO_VARIANT_NAME);
    }

    public void setVideoAffiliate(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_AFFILIATE, str);
        }
    }

    public void setVideoAudioCodec(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_AUDIO_CODEC, str);
        }
    }

    public void setVideoBrand(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_BRAND, str);
        }
    }

    public void setVideoCdn(String str) throws JSONException {
        if (str != null) {
            put("vdn", str);
        }
    }

    public void setVideoCodec(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_CODEC, str);
        }
    }

    public void setVideoContentType(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_CONTENT_TYPE, str);
        }
    }

    public void setVideoCreatorId(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_CREATOR_ID, str);
        }
    }

    public void setVideoDuration(Long l) throws JSONException {
        if (l != null) {
            put(VIDEO_DURATION, l.toString());
        }
    }

    public void setVideoDynamicRangeType(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_DYNAMIC_RANGE_TYPE, str);
        }
    }

    public void setVideoEncodingVariant(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_ENCODING_VARIANT, str);
        }
    }

    public void setVideoExperiments(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_EXPERIMENTS, str);
        }
    }

    public void setVideoId(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_ID, str);
        }
    }

    public void setVideoIsLive(Boolean bool) throws JSONException {
        if (bool != null) {
            put(VIDEO_IS_LIVE, bool.toString());
        }
    }

    public void setVideoLanguageCode(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_LANGUAGE_CODE, str);
        }
    }

    public void setVideoProducer(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_PRODUCER, str);
        }
    }

    public void setVideoSeries(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_SERIES, str);
        }
    }

    public void setVideoSourceUrl(String str) throws JSONException {
        if (str != null) {
            put("vsour", str);
        }
    }

    public void setVideoStreamType(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_STREAM_TYPE, str);
        }
    }

    public void setVideoTitle(String str) throws JSONException {
        if (str != null) {
            put("vtt", str);
        }
    }

    public void setVideoVariantId(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_VARIANT_ID, str);
        }
    }

    public void setVideoVariantName(String str) throws JSONException {
        if (str != null) {
            put(VIDEO_VARIANT_NAME, str);
        }
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public void sync() {
    }
}
