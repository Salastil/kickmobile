package com.mux.stats.sdk.core.model;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ViewData extends BaseQueryData {
    public static final String VIEWER_TIME = "uti";
    public static final String VIEW_AD_BREAK_COUNT = "xadbrco";
    public static final String VIEW_AD_COMPLETE_COUNT = "xadcpco";
    public static final String VIEW_AD_ERROR_COUNT = "xaderco";
    public static final String VIEW_AD_PLAY_COUNT = "xadplco";
    public static final String VIEW_AD_REQUEST_COUNT = "xadrqco";
    public static final String VIEW_AD_REQUEST_TIME = "xadrqti";
    public static final String VIEW_AD_VIEW_COUNT = "xadvwco";
    public static final String VIEW_AD_WATCH_TIME = "xadvwwati";
    public static final String VIEW_AVERAGE_REQUEST_LATENCY = "xavrqlt";
    public static final String VIEW_AVERAGE_REQUEST_THROUGHPUT = "xavrqth";
    public static final String VIEW_CONTENT_PLAYBACK_TIME = "xctpbti";
    public static final String VIEW_DEVICE_ORIENTATION = "xdvor";
    public static final String VIEW_DRM_TYPE = "xdrty";
    public static final String VIEW_DROPPED_FRAMES = "xdrfrco";
    public static final String VIEW_END = "xen";
    public static final String VIEW_ID = "xid";
    public static final String VIEW_MAX_DOWNSCALE_PERCENTAGE = "xmadope";
    public static final String VIEW_MAX_PLAYHEAD_POSITION = "xmaphps";
    public static final String VIEW_MAX_REQUEST_LATENCY = "xmarqlt";
    public static final String VIEW_MAX_SEEK_TIME = "xmaskti";
    public static final String VIEW_MAX_UPSCALE_PERCENTAGE = "xmauppe";
    public static final String VIEW_MIDROLL_TIME_TO_FIRST_AD = "xmltitofiad";
    public static final String VIEW_MIN_REQUEST_THROUGHPUT = "xmmrqth";
    public static final String VIEW_PERCENTAGE_VIEWED = "xpevd";
    public static final String VIEW_PLAYING_TIME_MS_CUMULATIVE = "xpntimscv";
    public static final String VIEW_PREROLL_AD_ASSET_DOMAIN = "xpladasdm";
    public static final String VIEW_PREROLL_AD_ASSET_HOSTNAME = "xpladashn";
    public static final String VIEW_PREROLL_AD_ID = "xpladid";
    public static final String VIEW_PREROLL_AD_TAG_DOMAIN = "xpladtadm";
    public static final String VIEW_PREROLL_AD_TAG_HOSTNAME = "xpladtahn";
    public static final String VIEW_PREROLL_CREATIVE_ID = "xplcrid";
    public static final String VIEW_PREROLL_LOAD_TIME = "xplloti";
    public static final String VIEW_PREROLL_PLAYED = "xplpf";
    public static final String VIEW_PREROLL_REQUESTED = "xplrd";
    public static final String VIEW_PREROLL_REQUEST_COUNT = "xplrqco";
    public static final String VIEW_PREROLL_REQUEST_TIME = "xplrqti";
    public static final String VIEW_PROGRAM_CHANGED = "xpgch";
    public static final String VIEW_REBUFFER_COUNT = "xreco";
    public static final String VIEW_REBUFFER_DURATION = "xredu";
    public static final String VIEW_REBUFFER_FREQUENCY = "xrefq";
    public static final String VIEW_REBUFFER_PERCENTAGE = "xrepe";
    public static final String VIEW_REQUEST_CANCELED_COUNT = "xrqcbco";
    public static final String VIEW_REQUEST_COUNT = "xrqco";
    public static final String VIEW_REQUEST_FAILED_COUNT = "xrqfbco";
    public static final String VIEW_SEEK_COUNT = "xskco";
    public static final String VIEW_SEEK_DURATION = "xskdu";
    public static final String VIEW_SEQUENCE_NUMBER = "xsqno";
    public static final String VIEW_START = "xst";
    public static final String VIEW_STARTUP_PREROLL_LOAD_TIME = "xsuplloti";
    public static final String VIEW_STARTUP_PREROLL_REQUEST_TIME = "xsuplrqti";
    public static final String VIEW_TIME_TO_FIRST_FRAME = "xtitofifr";
    public static final String VIEW_TIME_TO_PREROLL = "xtitopl";
    public static final String VIEW_TOTAL_CONTENT_PLAYBACK_TIME = "xtlctpbti";
    public static final String VIEW_TOTAL_DOWNSCALING = "xtldg";
    public static final String VIEW_TOTAL_UPSCALING = "xtlug";
    public static final String VIEW_WAITING_REBUFFER_COUNT = "xwtreco";
    public static final String VIEW_WAITING_REBUFFER_DURATION = "xwtredu";
    public static final String VIEW_WATCH_TIME = "xwati";
    public static final ArrayList<String> keys;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add(VIEW_REQUEST_COUNT);
        arrayList.add(VIEW_REQUEST_FAILED_COUNT);
        arrayList.add(VIEW_REQUEST_CANCELED_COUNT);
        arrayList.add(VIEW_AD_BREAK_COUNT);
        arrayList.add(VIEW_AD_COMPLETE_COUNT);
        arrayList.add(VIEW_AD_ERROR_COUNT);
        arrayList.add(VIEW_AD_VIEW_COUNT);
        arrayList.add(VIEW_AD_PLAY_COUNT);
        arrayList.add(VIEW_AD_WATCH_TIME);
        arrayList.add(VIEW_AD_REQUEST_COUNT);
        arrayList.add(VIEW_AD_REQUEST_TIME);
        arrayList.add(VIEW_PREROLL_REQUEST_COUNT);
        arrayList.add(VIEW_PREROLL_AD_ID);
        arrayList.add(VIEW_PREROLL_CREATIVE_ID);
        arrayList.add(VIEW_PREROLL_REQUESTED);
        arrayList.add(VIEW_PREROLL_PLAYED);
        arrayList.add(VIEW_PREROLL_REQUEST_TIME);
        arrayList.add(VIEW_STARTUP_PREROLL_REQUEST_TIME);
        arrayList.add(VIEW_PREROLL_LOAD_TIME);
        arrayList.add(VIEW_STARTUP_PREROLL_LOAD_TIME);
        arrayList.add(VIEW_PREROLL_AD_TAG_HOSTNAME);
        arrayList.add(VIEW_PREROLL_AD_TAG_DOMAIN);
        arrayList.add(VIEW_PREROLL_AD_ASSET_HOSTNAME);
        arrayList.add(VIEW_PREROLL_AD_ASSET_DOMAIN);
        arrayList.add(VIEW_END);
        arrayList.add(VIEW_ID);
        arrayList.add(VIEW_MAX_DOWNSCALE_PERCENTAGE);
        arrayList.add(VIEW_MAX_SEEK_TIME);
        arrayList.add(VIEW_MAX_UPSCALE_PERCENTAGE);
        arrayList.add(VIEW_MIDROLL_TIME_TO_FIRST_AD);
        arrayList.add(VIEW_PERCENTAGE_VIEWED);
        arrayList.add(VIEW_REBUFFER_COUNT);
        arrayList.add(VIEW_REBUFFER_DURATION);
        arrayList.add(VIEW_REBUFFER_FREQUENCY);
        arrayList.add(VIEW_REBUFFER_PERCENTAGE);
        arrayList.add(VIEW_SEEK_COUNT);
        arrayList.add(VIEW_SEEK_DURATION);
        arrayList.add(VIEW_SEQUENCE_NUMBER);
        arrayList.add(VIEW_START);
        arrayList.add(VIEW_TIME_TO_FIRST_FRAME);
        arrayList.add(VIEW_TIME_TO_PREROLL);
        arrayList.add(VIEW_CONTENT_PLAYBACK_TIME);
        arrayList.add(VIEW_TOTAL_CONTENT_PLAYBACK_TIME);
        arrayList.add(VIEW_TOTAL_DOWNSCALING);
        arrayList.add(VIEW_TOTAL_UPSCALING);
        arrayList.add(VIEW_WAITING_REBUFFER_COUNT);
        arrayList.add(VIEW_WAITING_REBUFFER_DURATION);
        arrayList.add(VIEW_WATCH_TIME);
        arrayList.add("uti");
        arrayList.add(VIEW_MIN_REQUEST_THROUGHPUT);
        arrayList.add(VIEW_AVERAGE_REQUEST_THROUGHPUT);
        arrayList.add(VIEW_MAX_REQUEST_LATENCY);
        arrayList.add(VIEW_AVERAGE_REQUEST_LATENCY);
        arrayList.add(VIEW_DEVICE_ORIENTATION);
        arrayList.add(VIEW_DROPPED_FRAMES);
        arrayList.add(VIEW_PROGRAM_CHANGED);
        arrayList.add(VIEW_MAX_PLAYHEAD_POSITION);
        arrayList.add("xdrty");
        arrayList.add(VIEW_PLAYING_TIME_MS_CUMULATIVE);
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
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        String str52;
        String str53;
        StringBuilder sb = new StringBuilder("viewData: ");
        String str54 = "";
        if (getViewRequestCount() != null) {
            str = "\n    viewRequestCount: " + getViewRequestCount();
        } else {
            str = "";
        }
        sb.append(str);
        if (getViewAdBreakCount() != null) {
            str2 = "\n    viewAdBreakCount: " + getViewAdBreakCount();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (getViewAdCompleteCount() != null) {
            str3 = "\n    viewAdCompleteCount: " + getViewAdCompleteCount();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (getViewAdErrorCount() != null) {
            str4 = "\n    viewAdErrorCount: " + getViewAdErrorCount();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (getViewAdViewCount() != null) {
            str5 = "\n    viewAdViewCount: " + getViewAdViewCount();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (getViewAdPlayCount() != null) {
            str6 = "\n    viewAdPlayCount: " + getViewAdPlayCount();
        } else {
            str6 = "";
        }
        sb.append(str6);
        if (getViewAdWatchTime() != null) {
            str7 = "\n    viewAdWatchTime: " + getViewAdWatchTime();
        } else {
            str7 = "";
        }
        sb.append(str7);
        if (getViewAdRequestCount() != null) {
            str8 = "\n    viewAdRequestCount: " + getViewAdRequestCount();
        } else {
            str8 = "";
        }
        sb.append(str8);
        if (getViewAdRequestTime() != null) {
            str9 = "\n    viewAdRequestTime: " + getViewAdRequestTime();
        } else {
            str9 = "";
        }
        sb.append(str9);
        if (getViewPrerollRequestCount() != null) {
            str10 = "\n    viewPrerollRequestCount: " + getViewPrerollRequestCount();
        } else {
            str10 = "";
        }
        sb.append(str10);
        if (getViewEnd() != null) {
            str11 = "\n    viewEnd: " + getViewEnd();
        } else {
            str11 = "";
        }
        sb.append(str11);
        if (getViewId() != null) {
            str12 = "\n    viewId: " + getViewId();
        } else {
            str12 = "";
        }
        sb.append(str12);
        if (getViewMaxDownscalePercentage() != null) {
            str13 = "\n    viewMaxDownscalePercentage: " + getViewMaxDownscalePercentage();
        } else {
            str13 = "";
        }
        sb.append(str13);
        if (getViewMaxSeekTime() != null) {
            str14 = "\n    viewMaxSeekTime: " + getViewMaxSeekTime();
        } else {
            str14 = "";
        }
        sb.append(str14);
        if (getViewMaxUpscalePercentage() != null) {
            str15 = "\n    viewMaxUpscalePercentage: " + getViewMaxUpscalePercentage();
        } else {
            str15 = "";
        }
        sb.append(str15);
        if (getViewMidrollTimeToFirstAd() != null) {
            str16 = "\n    viewMidrollTimeToFirstAd: " + getViewMidrollTimeToFirstAd();
        } else {
            str16 = "";
        }
        sb.append(str16);
        if (getViewPercentageViewed() != null) {
            str17 = "\n    viewPercentageViewed: " + getViewPercentageViewed();
        } else {
            str17 = "";
        }
        sb.append(str17);
        if (getViewRebufferCount() != null) {
            str18 = "\n    viewRebufferCount: " + getViewRebufferCount();
        } else {
            str18 = "";
        }
        sb.append(str18);
        if (getViewRebufferDuration() != null) {
            str19 = "\n    viewRebufferDuration: " + getViewRebufferDuration();
        } else {
            str19 = "";
        }
        sb.append(str19);
        if (getViewRebufferFrequency() != null) {
            str20 = "\n    viewRebufferFrequency: " + getViewRebufferFrequency();
        } else {
            str20 = "";
        }
        sb.append(str20);
        if (getViewRebufferPercentage() != null) {
            str21 = "\n    viewRebufferPercentage: " + getViewRebufferPercentage();
        } else {
            str21 = "";
        }
        sb.append(str21);
        if (getViewSeekCount() != null) {
            str22 = "\n    viewSeekCount: " + getViewSeekCount();
        } else {
            str22 = "";
        }
        sb.append(str22);
        if (getViewSeekDuration() != null) {
            str23 = "\n    viewSeekDuration: " + getViewSeekDuration();
        } else {
            str23 = "";
        }
        sb.append(str23);
        if (getViewSequenceNumber() != null) {
            str24 = "\n    viewSequenceNumber: " + getViewSequenceNumber();
        } else {
            str24 = "";
        }
        sb.append(str24);
        if (getViewStart() != null) {
            str25 = "\n    viewStart: " + getViewStart();
        } else {
            str25 = "";
        }
        sb.append(str25);
        if (getViewTimeToFirstFrame() != null) {
            str26 = "\n    viewTimeToFirstFrame: " + getViewTimeToFirstFrame();
        } else {
            str26 = "";
        }
        sb.append(str26);
        if (getViewTimeToPreroll() != null) {
            str27 = "\n    viewTimeToPreroll: " + getViewTimeToPreroll();
        } else {
            str27 = "";
        }
        sb.append(str27);
        if (getViewTotalContentPlaybackTime() != null) {
            str28 = "\n    viewTotalContentPlaybackTime: " + getViewTotalContentPlaybackTime();
        } else {
            str28 = "";
        }
        sb.append(str28);
        if (getViewTotalDownscaling() != null) {
            str29 = "\n    viewTotalDownscaling: " + getViewTotalDownscaling();
        } else {
            str29 = "";
        }
        sb.append(str29);
        if (getViewTotalUpscaling() != null) {
            str30 = "\n    viewTotalUpscaling: " + getViewTotalUpscaling();
        } else {
            str30 = "";
        }
        sb.append(str30);
        if (getViewWaitingRebufferCount() != null) {
            str31 = "\n    viewWaitingRebufferCount: " + getViewWaitingRebufferCount();
        } else {
            str31 = "";
        }
        sb.append(str31);
        if (getViewWaitingRebufferDuration() != null) {
            str32 = "\n    viewWaitingRebufferDuration: " + getViewWaitingRebufferDuration();
        } else {
            str32 = "";
        }
        sb.append(str32);
        if (getViewWatchTime() != null) {
            str33 = "\n    viewWatchTime: " + getViewWatchTime();
        } else {
            str33 = "";
        }
        sb.append(str33);
        if (getViewerTime() != null) {
            str34 = "\n    viewerTime: " + getViewerTime();
        } else {
            str34 = "";
        }
        sb.append(str34);
        if (getViewMinRequestThroughput() != null) {
            str35 = "\n    viewMinRequestThroughput: " + getViewMinRequestThroughput();
        } else {
            str35 = "";
        }
        sb.append(str35);
        if (getViewAverageRequestThroughput() != null) {
            str36 = "\n    viewAverageRequestThroughput: " + getViewAverageRequestThroughput();
        } else {
            str36 = "";
        }
        sb.append(str36);
        if (getViewMaxRequestLatency() != null) {
            str37 = "\n    viewMaxRequestLatency: " + getViewMaxRequestLatency();
        } else {
            str37 = "";
        }
        sb.append(str37);
        if (getViewAverageRequestLatency() != null) {
            str38 = "\n    viewAverageRequestLatency: " + getViewAverageRequestLatency();
        } else {
            str38 = "";
        }
        sb.append(str38);
        if (getViewPrerollAdId() != null) {
            str39 = "\n    viewPrerollAdId: " + getViewPrerollAdId();
        } else {
            str39 = "";
        }
        sb.append(str39);
        if (getViewPrerollCreativeId() != null) {
            str40 = "\n    viewPrerollCreativeId: " + getViewPrerollCreativeId();
        } else {
            str40 = "";
        }
        sb.append(str40);
        if (getViewPrerollRequested() != null) {
            str41 = "\n    viewPrerollRequested: " + getViewPrerollRequested();
        } else {
            str41 = "";
        }
        sb.append(str41);
        if (getViewPrerollPlayed() != null) {
            str42 = "\n    viewPrerollPlayed: " + getViewPrerollPlayed();
        } else {
            str42 = "";
        }
        sb.append(str42);
        if (getViewPrerollRequestTime() != null) {
            str43 = "\n    viewPrerollRequestTime: " + getViewPrerollRequestTime();
        } else {
            str43 = "";
        }
        sb.append(str43);
        if (getViewStartupPrerollRequestTime() != null) {
            str44 = "\n    viewStartupPrerollRequestTime: " + getViewStartupPrerollRequestTime();
        } else {
            str44 = "";
        }
        sb.append(str44);
        if (getViewPrerollLoadTime() != null) {
            str45 = "\n    viewPrerollLoadTime: " + getViewPrerollLoadTime();
        } else {
            str45 = "";
        }
        sb.append(str45);
        if (getViewStartupPrerollLoadTime() != null) {
            str46 = "\n    viewStartupPrerollLoadTime: " + getViewStartupPrerollLoadTime();
        } else {
            str46 = "";
        }
        sb.append(str46);
        if (getPrerollAdTagHostname() != null) {
            str47 = "\n    prerollAdTagHostname: " + getPrerollAdTagHostname();
        } else {
            str47 = "";
        }
        sb.append(str47);
        if (getViewPrerollAdTagDomain() != null) {
            str48 = "\n    viewPrerollAdTagDomain: " + getViewPrerollAdTagDomain();
        } else {
            str48 = "";
        }
        sb.append(str48);
        if (getPrerollAdAssetHostname() != null) {
            str49 = "\n    prerollAdAssetHostname: " + getPrerollAdAssetHostname();
        } else {
            str49 = "";
        }
        sb.append(str49);
        if (getViewPrerollAdAssetDomain() != null) {
            str50 = "\n    viewPrerollAdAssetDomain: " + getViewPrerollAdAssetDomain();
        } else {
            str50 = "";
        }
        sb.append(str50);
        if (getViewMaxPlayheadPosition() != null) {
            str51 = "\n    viewMaxPlayheadPosition: " + getViewMaxPlayheadPosition();
        } else {
            str51 = "";
        }
        sb.append(str51);
        if (getViewDroppedFrames() != null) {
            str52 = "\n    viewDroppedFrames: " + getViewDroppedFrames();
        } else {
            str52 = "";
        }
        sb.append(str52);
        if (getViewOrientationData() == null) {
            str53 = "";
        } else {
            str53 = "\n    " + getViewOrientationData().getDebugString();
        }
        sb.append(str53);
        if (getViewProgramChanged() != null) {
            str54 = "\n    isProgramChange: " + getViewProgramChanged();
        }
        sb.append(str54);
        return sb.toString();
    }

    public String getPrerollAdAssetHostname() {
        return get(VIEW_PREROLL_AD_ASSET_HOSTNAME);
    }

    public String getPrerollAdTagHostname() {
        return get(VIEW_PREROLL_AD_TAG_HOSTNAME);
    }

    public Integer getViewAdBreakCount() throws JSONException {
        String str = get(VIEW_AD_BREAK_COUNT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Integer getViewAdCompleteCount() throws JSONException {
        String str = get(VIEW_AD_COMPLETE_COUNT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Integer getViewAdErrorCount() throws JSONException {
        String str = get(VIEW_AD_ERROR_COUNT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Integer getViewAdPlayCount() throws JSONException {
        String str = get(VIEW_AD_PLAY_COUNT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Long getViewAdRequestCount() throws JSONException {
        String str = get(VIEW_AD_REQUEST_COUNT);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewAdRequestTime() throws JSONException {
        String str = get(VIEW_AD_REQUEST_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Integer getViewAdViewCount() throws JSONException {
        String str = get(VIEW_AD_VIEW_COUNT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Long getViewAdWatchTime() throws JSONException {
        String str = get(VIEW_AD_WATCH_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Double getViewAverageRequestLatency() throws JSONException {
        String str = get(VIEW_AVERAGE_REQUEST_LATENCY);
        if (str == null) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public Long getViewAverageRequestThroughput() throws JSONException {
        String str = get(VIEW_AVERAGE_REQUEST_THROUGHPUT);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewContentPlaybackTime() throws JSONException {
        String str = get(VIEW_CONTENT_PLAYBACK_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getViewDrmType() {
        return get("xdrty");
    }

    public Long getViewDroppedFrames() throws JSONException {
        String str = get(VIEW_DROPPED_FRAMES);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewEnd() throws JSONException {
        String str = get(VIEW_END);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getViewId() {
        return get(VIEW_ID);
    }

    public Double getViewMaxDownscalePercentage() throws JSONException {
        String str = get(VIEW_MAX_DOWNSCALE_PERCENTAGE);
        if (str == null) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public Long getViewMaxPlayheadPosition() throws JSONException {
        String str = get(VIEW_MAX_PLAYHEAD_POSITION);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Double getViewMaxRequestLatency() throws JSONException {
        String str = get(VIEW_MAX_REQUEST_LATENCY);
        if (str == null) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public Long getViewMaxSeekTime() throws JSONException {
        String str = get(VIEW_MAX_SEEK_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Double getViewMaxUpscalePercentage() throws JSONException {
        String str = get(VIEW_MAX_UPSCALE_PERCENTAGE);
        if (str == null) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public Long getViewMidrollTimeToFirstAd() throws JSONException {
        String str = get(VIEW_MIDROLL_TIME_TO_FIRST_AD);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewMinRequestThroughput() throws JSONException {
        String str = get(VIEW_MIN_REQUEST_THROUGHPUT);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public ViewDeviceOrientationData getViewOrientationData() throws JSONException {
        String str = get(VIEW_DEVICE_ORIENTATION);
        if (str == null) {
            return null;
        }
        try {
            return new ViewDeviceOrientationData(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public Integer getViewPercentageViewed() throws JSONException {
        String str = get(VIEW_PERCENTAGE_VIEWED);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Long getViewPlayingTimeMsCumulative() throws JSONException {
        String str = get(VIEW_PLAYING_TIME_MS_CUMULATIVE);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getViewPrerollAdAssetDomain() {
        return get(VIEW_PREROLL_AD_ASSET_DOMAIN);
    }

    public String getViewPrerollAdId() {
        return get(VIEW_PREROLL_AD_ID);
    }

    public String getViewPrerollAdTagDomain() {
        return get(VIEW_PREROLL_AD_TAG_DOMAIN);
    }

    public String getViewPrerollCreativeId() {
        return get(VIEW_PREROLL_CREATIVE_ID);
    }

    public Long getViewPrerollLoadTime() throws JSONException {
        String str = get(VIEW_PREROLL_LOAD_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Boolean getViewPrerollPlayed() throws JSONException {
        String str = get(VIEW_PREROLL_PLAYED);
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public Long getViewPrerollRequestCount() throws JSONException {
        String str = get(VIEW_PREROLL_REQUEST_COUNT);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewPrerollRequestTime() throws JSONException {
        String str = get(VIEW_PREROLL_REQUEST_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Boolean getViewPrerollRequested() throws JSONException {
        String str = get(VIEW_PREROLL_REQUESTED);
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public Boolean getViewProgramChanged() throws JSONException {
        String str = get(VIEW_PROGRAM_CHANGED);
        return Boolean.valueOf(str != null && Boolean.parseBoolean(str));
    }

    public Integer getViewRebufferCount() throws JSONException {
        String str = get(VIEW_REBUFFER_COUNT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Long getViewRebufferDuration() throws JSONException {
        String str = get(VIEW_REBUFFER_DURATION);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Double getViewRebufferFrequency() throws JSONException {
        String str = get(VIEW_REBUFFER_FREQUENCY);
        if (str == null) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public Double getViewRebufferPercentage() throws JSONException {
        String str = get(VIEW_REBUFFER_PERCENTAGE);
        if (str == null) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public Long getViewRequestCanceledCount() throws JSONException {
        String str = get(VIEW_REQUEST_CANCELED_COUNT);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewRequestCount() throws JSONException {
        String str = get(VIEW_REQUEST_COUNT);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewRequestFailedCount() throws JSONException {
        String str = get(VIEW_REQUEST_FAILED_COUNT);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Integer getViewSeekCount() throws JSONException {
        String str = get(VIEW_SEEK_COUNT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Long getViewSeekDuration() throws JSONException {
        String str = get(VIEW_SEEK_DURATION);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Integer getViewSequenceNumber() throws JSONException {
        String str = get(VIEW_SEQUENCE_NUMBER);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Long getViewStart() throws JSONException {
        String str = get(VIEW_START);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewStartupPrerollLoadTime() throws JSONException {
        String str = get(VIEW_STARTUP_PREROLL_LOAD_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewStartupPrerollRequestTime() throws JSONException {
        String str = get(VIEW_STARTUP_PREROLL_REQUEST_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewTimeToFirstFrame() throws JSONException {
        String str = get(VIEW_TIME_TO_FIRST_FRAME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewTimeToPreroll() throws JSONException {
        String str = get(VIEW_TIME_TO_PREROLL);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewTotalContentPlaybackTime() throws JSONException {
        String str = get(VIEW_TOTAL_CONTENT_PLAYBACK_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Double getViewTotalDownscaling() throws JSONException {
        String str = get(VIEW_TOTAL_DOWNSCALING);
        if (str == null) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public Double getViewTotalUpscaling() throws JSONException {
        String str = get(VIEW_TOTAL_UPSCALING);
        if (str == null) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(str));
    }

    public Integer getViewWaitingRebufferCount() throws JSONException {
        String str = get(VIEW_WAITING_REBUFFER_COUNT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Long getViewWaitingRebufferDuration() throws JSONException {
        String str = get(VIEW_WAITING_REBUFFER_DURATION);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewWatchTime() throws JSONException {
        String str = get(VIEW_WATCH_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getViewerTime() throws JSONException {
        String str = get("uti");
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    @Deprecated
    public void setDrmType(String str) throws JSONException {
        if (str != null) {
            put("xdrty", str);
        }
    }

    public void setPrerollAdAssetHostname(String str) throws JSONException {
        if (str != null) {
            put(VIEW_PREROLL_AD_ASSET_HOSTNAME, str);
        }
    }

    public void setPrerollAdTagHostname(String str) throws JSONException {
        if (str != null) {
            put(VIEW_PREROLL_AD_TAG_HOSTNAME, str);
        }
    }

    public void setViewAdBreakCount(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_AD_BREAK_COUNT, num.toString());
        }
    }

    public void setViewAdCompleteCount(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_AD_COMPLETE_COUNT, num.toString());
        }
    }

    public void setViewAdErrorCount(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_AD_ERROR_COUNT, num.toString());
        }
    }

    public void setViewAdPlayCount(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_AD_PLAY_COUNT, num.toString());
        }
    }

    public void setViewAdRequestCount(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_AD_REQUEST_COUNT, l.toString());
        }
    }

    public void setViewAdRequestTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_AD_REQUEST_TIME, l.toString());
        }
    }

    public void setViewAdViewCount(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_AD_VIEW_COUNT, num.toString());
        }
    }

    public void setViewAdWatchTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_AD_WATCH_TIME, l.toString());
        }
    }

    public void setViewAverageRequestLatency(Double d) throws JSONException {
        if (d != null) {
            put(VIEW_AVERAGE_REQUEST_LATENCY, d.toString());
        }
    }

    public void setViewAverageRequestThroughput(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_AVERAGE_REQUEST_THROUGHPUT, l.toString());
        }
    }

    public void setViewContentPlaybackTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_CONTENT_PLAYBACK_TIME, l.toString());
        }
    }

    public void setViewDrmType(String str) throws JSONException {
        if (str != null) {
            put("xdrty", str);
        }
    }

    public void setViewDroppedFrames(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_DROPPED_FRAMES, l.toString());
        }
    }

    public void setViewEnd(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_END, l.toString());
        }
    }

    public void setViewId(String str) throws JSONException {
        if (str != null) {
            put(VIEW_ID, str);
        }
    }

    public void setViewMaxDownscalePercentage(Double d) throws JSONException {
        if (d != null) {
            put(VIEW_MAX_DOWNSCALE_PERCENTAGE, d.toString());
        }
    }

    public void setViewMaxPlayheadPosition(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_MAX_PLAYHEAD_POSITION, l.toString());
        }
    }

    public void setViewMaxRequestLatency(Double d) throws JSONException {
        if (d != null) {
            put(VIEW_MAX_REQUEST_LATENCY, d.toString());
        }
    }

    public void setViewMaxSeekTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_MAX_SEEK_TIME, l.toString());
        }
    }

    public void setViewMaxUpscalePercentage(Double d) throws JSONException {
        if (d != null) {
            put(VIEW_MAX_UPSCALE_PERCENTAGE, d.toString());
        }
    }

    public void setViewMidrollTimeToFirstAd(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_MIDROLL_TIME_TO_FIRST_AD, l.toString());
        }
    }

    public void setViewMinRequestThroughput(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_MIN_REQUEST_THROUGHPUT, l.toString());
        }
    }

    public void setViewOrientationData(ViewDeviceOrientationData viewDeviceOrientationData) throws JSONException {
        if (viewDeviceOrientationData != null) {
            put(VIEW_DEVICE_ORIENTATION, viewDeviceOrientationData.toJsonString());
        }
    }

    public void setViewPercentageViewed(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_PERCENTAGE_VIEWED, num.toString());
        }
    }

    public void setViewPlayingTimeMsCumulative(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_PLAYING_TIME_MS_CUMULATIVE, l.toString());
        }
    }

    public void setViewPrerollAdAssetDomain(String str) throws JSONException {
        if (str != null) {
            put(VIEW_PREROLL_AD_ASSET_DOMAIN, str);
        }
    }

    public void setViewPrerollAdId(String str) throws JSONException {
        if (str != null) {
            put(VIEW_PREROLL_AD_ID, str);
        }
    }

    public void setViewPrerollAdTagDomain(String str) throws JSONException {
        if (str != null) {
            put(VIEW_PREROLL_AD_TAG_DOMAIN, str);
        }
    }

    public void setViewPrerollCreativeId(String str) throws JSONException {
        if (str != null) {
            put(VIEW_PREROLL_CREATIVE_ID, str);
        }
    }

    public void setViewPrerollLoadTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_PREROLL_LOAD_TIME, l.toString());
        }
    }

    public void setViewPrerollPlayed(Boolean bool) throws JSONException {
        if (bool != null) {
            put(VIEW_PREROLL_PLAYED, bool.toString());
        }
    }

    public void setViewPrerollRequestCount(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_PREROLL_REQUEST_COUNT, l.toString());
        }
    }

    public void setViewPrerollRequestTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_PREROLL_REQUEST_TIME, l.toString());
        }
    }

    public void setViewPrerollRequested(Boolean bool) throws JSONException {
        if (bool != null) {
            put(VIEW_PREROLL_REQUESTED, bool.toString());
        }
    }

    public void setViewProgramChanged(Boolean bool) throws JSONException {
        if (bool != null) {
            put(VIEW_PROGRAM_CHANGED, bool.toString());
        }
    }

    public void setViewRebufferCount(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_REBUFFER_COUNT, num.toString());
        }
    }

    public void setViewRebufferDuration(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_REBUFFER_DURATION, l.toString());
        }
    }

    public void setViewRebufferFrequency(Double d) throws JSONException {
        if (d != null) {
            put(VIEW_REBUFFER_FREQUENCY, d.toString());
        }
    }

    public void setViewRebufferPercentage(Double d) throws JSONException {
        if (d != null) {
            put(VIEW_REBUFFER_PERCENTAGE, d.toString());
        }
    }

    public void setViewRequestCanceledCount(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_REQUEST_CANCELED_COUNT, l.toString());
        }
    }

    public void setViewRequestCount(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_REQUEST_COUNT, l.toString());
        }
    }

    public void setViewRequestFailedCount(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_REQUEST_FAILED_COUNT, l.toString());
        }
    }

    public void setViewSeekCount(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_SEEK_COUNT, num.toString());
        }
    }

    public void setViewSeekDuration(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_SEEK_DURATION, l.toString());
        }
    }

    public void setViewSequenceNumber(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_SEQUENCE_NUMBER, num.toString());
        }
    }

    public void setViewStart(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_START, l.toString());
        }
    }

    public void setViewStartupPrerollLoadTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_STARTUP_PREROLL_LOAD_TIME, l.toString());
        }
    }

    public void setViewStartupPrerollRequestTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_STARTUP_PREROLL_REQUEST_TIME, l.toString());
        }
    }

    public void setViewTimeToFirstFrame(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_TIME_TO_FIRST_FRAME, l.toString());
        }
    }

    public void setViewTimeToPreroll(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_TIME_TO_PREROLL, l.toString());
        }
    }

    public void setViewTotalContentPlaybackTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_TOTAL_CONTENT_PLAYBACK_TIME, l.toString());
        }
    }

    public void setViewTotalDownscaling(Double d) throws JSONException {
        if (d != null) {
            put(VIEW_TOTAL_DOWNSCALING, d.toString());
        }
    }

    public void setViewTotalUpscaling(Double d) throws JSONException {
        if (d != null) {
            put(VIEW_TOTAL_UPSCALING, d.toString());
        }
    }

    public void setViewWaitingRebufferCount(Integer num) throws JSONException {
        if (num != null) {
            put(VIEW_WAITING_REBUFFER_COUNT, num.toString());
        }
    }

    public void setViewWaitingRebufferDuration(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_WAITING_REBUFFER_DURATION, l.toString());
        }
    }

    public void setViewWatchTime(Long l) throws JSONException {
        if (l != null) {
            put(VIEW_WATCH_TIME, l.toString());
        }
    }

    @Deprecated
    public void setViewerOrientationData(ViewDeviceOrientationData viewDeviceOrientationData) throws JSONException {
        setViewOrientationData(viewDeviceOrientationData);
    }

    public void setViewerTime(Long l) throws JSONException {
        if (l != null) {
            put("uti", l.toString());
        }
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public void sync() {
    }
}
