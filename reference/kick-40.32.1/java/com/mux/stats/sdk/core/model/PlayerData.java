package com.mux.stats.sdk.core.model;

import com.mux.stats.sdk.core.util.MuxLogger;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class PlayerData extends BaseQueryData {
    public static final String PAGE_LOAD_TIME = "wloti";
    public static final String PAGE_URL = "wur";
    public static final String PLAYER_AUTOPLAY_ON = "pauon";
    public static final String PLAYER_ERROR_BUSINESS_EXCEPTION = "perbzez";
    public static final String PLAYER_ERROR_CODE = "percd";
    public static final String PLAYER_ERROR_CONTEXT = "percz";
    public static final String PLAYER_ERROR_MESSAGE = "perme";
    public static final String PLAYER_ERROR_SEVERITY = "persy";
    public static final String PLAYER_HEIGHT = "pht";
    public static final String PLAYER_INSTANCE_ID = "pinid";
    public static final String PLAYER_IS_FULLSCREEN = "pisfs";
    public static final String PLAYER_IS_PAUSED = "pispa";
    public static final String PLAYER_LANGUAGE_CODE = "placd";
    public static final String PLAYER_LOAD_TIME = "ploti";
    public static final String PLAYER_MANIFEST_NEWEST_PROGRAM_TIME = "pmfnepgti";
    public static final String PLAYER_MUX_PLUGIN_NAME = "pmxpinm";
    public static final String PLAYER_MUX_PLUGIN_VERSION = "pmxpive";
    public static final String PLAYER_PLAYBACK_MODE = "ppbmp";
    public static final String PLAYER_PLAYBACK_MODE_DATA = "ppbmpda";
    public static final String PLAYER_PLAYHEAD_TIME = "pphti";
    public static final String PLAYER_PRELOAD_ON = "ppron";
    public static final String PLAYER_PROGRAM_TIME = "ppgti";
    public static final String PLAYER_SEQUENCE_NUMBER = "psqno";
    public static final String PLAYER_SOFTWARE_NAME = "pswnm";
    public static final String PLAYER_SOFTWARE_VERSION = "pswve";
    public static final String PLAYER_STARTUP_TIME = "psuti";
    public static final String PLAYER_VIEW_COUNT = "pvwco";
    public static final String PLAYER_WIDTH = "pwd";
    public static final ArrayList<String> keys;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add(PAGE_LOAD_TIME);
        arrayList.add(PAGE_URL);
        arrayList.add("pauon");
        arrayList.add(PLAYER_ERROR_CODE);
        arrayList.add(PLAYER_ERROR_MESSAGE);
        arrayList.add(PLAYER_HEIGHT);
        arrayList.add(PLAYER_INSTANCE_ID);
        arrayList.add(PLAYER_IS_FULLSCREEN);
        arrayList.add(PLAYER_IS_PAUSED);
        arrayList.add(PLAYER_LANGUAGE_CODE);
        arrayList.add(PLAYER_LOAD_TIME);
        arrayList.add(PLAYER_MUX_PLUGIN_NAME);
        arrayList.add(PLAYER_MUX_PLUGIN_VERSION);
        arrayList.add(PLAYER_PLAYHEAD_TIME);
        arrayList.add(PLAYER_PRELOAD_ON);
        arrayList.add(PLAYER_SEQUENCE_NUMBER);
        arrayList.add(PLAYER_SOFTWARE_NAME);
        arrayList.add(PLAYER_SOFTWARE_VERSION);
        arrayList.add(PLAYER_STARTUP_TIME);
        arrayList.add(PLAYER_VIEW_COUNT);
        arrayList.add(PLAYER_WIDTH);
        arrayList.add(PLAYER_PROGRAM_TIME);
        arrayList.add(PLAYER_MANIFEST_NEWEST_PROGRAM_TIME);
        arrayList.add(PLAYER_ERROR_CONTEXT);
        arrayList.add(PLAYER_ERROR_SEVERITY);
        arrayList.add(PLAYER_ERROR_BUSINESS_EXCEPTION);
        arrayList.add(PLAYER_PLAYBACK_MODE);
        arrayList.add(PLAYER_PLAYBACK_MODE_DATA);
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
        StringBuilder sb = new StringBuilder("PlayerData: ");
        String str27 = "";
        if (getPageLoadTime() != null) {
            str = "\n    pageLoadTime: " + getPageLoadTime();
        } else {
            str = "";
        }
        sb.append(str);
        if (getPageUrl() != null) {
            str2 = "\n    pageUrl: " + getPageUrl();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (getPlayerAutoplayOn() != null) {
            str3 = "\n    getPlayerAutoplayOn: " + getPlayerAutoplayOn();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (getPlayerErrorCode() != null) {
            str4 = "\n    playerErrorCode: " + getPlayerErrorCode();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (getPlayerErrorMessage() != null) {
            str5 = "\n    playerErrorMessage: " + getPlayerErrorMessage();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (getPlayerHeight() != null) {
            str6 = "\n    playerHeight: " + getPlayerHeight();
        } else {
            str6 = "";
        }
        sb.append(str6);
        if (getPlayerInstanceId() != null) {
            str7 = "\n    playerInstanceId: " + getPlayerInstanceId();
        } else {
            str7 = "";
        }
        sb.append(str7);
        if (getPlayerIsFullscreen() != null) {
            str8 = "\n    playerFullScreen: " + getPlayerIsFullscreen();
        } else {
            str8 = "";
        }
        sb.append(str8);
        if (getPlayerIsPaused() != null) {
            str9 = "\n    playerIsPaused: " + getPlayerIsPaused();
        } else {
            str9 = "";
        }
        sb.append(str9);
        if (getPlayerLanguageCode() != null) {
            str10 = "\n    playerLayoutCode: " + getPlayerLanguageCode();
        } else {
            str10 = "";
        }
        sb.append(str10);
        if (getPlayerLoadTime() != null) {
            str11 = "\n    playerLoadTime: " + getPlayerLoadTime();
        } else {
            str11 = "";
        }
        sb.append(str11);
        if (getPlayerMuxPluginName() != null) {
            str12 = "\n    playerMuxPluginName: " + getPlayerMuxPluginName();
        } else {
            str12 = "";
        }
        sb.append(str12);
        if (getPlayerMuxPluginVersion() != null) {
            str13 = "\n    playerMuxPluginVersion: " + getPlayerMuxPluginVersion();
        } else {
            str13 = "";
        }
        sb.append(str13);
        if (getPlayerPlayheadTime() != null) {
            str14 = "\n    playerPlayheadTime: " + getPlayerPlayheadTime();
        } else {
            str14 = "";
        }
        sb.append(str14);
        if (getPlayerPreloadOn() != null) {
            str15 = "\n    playerPreloadOn: " + getPlayerPreloadOn();
        } else {
            str15 = "";
        }
        sb.append(str15);
        if (getPlayerSequenceNumber() != null) {
            str16 = "\n    playerSequenceNumber: " + getPlayerSequenceNumber();
        } else {
            str16 = "";
        }
        sb.append(str16);
        if (getPlayerSoftwareName() != null) {
            str17 = "\n    playerSoftwareName: " + getPlayerSoftwareName();
        } else {
            str17 = "";
        }
        sb.append(str17);
        if (getPlayerSoftwareVersion() != null) {
            str18 = "\n    playerSoftwareVersion: " + getPlayerSoftwareVersion();
        } else {
            str18 = "";
        }
        sb.append(str18);
        if (getPlayerStartupTime() != null) {
            str19 = "\n    playerStartupTime: " + getPlayerStartupTime();
        } else {
            str19 = "";
        }
        sb.append(str19);
        if (getPlayerViewCount() != null) {
            str20 = "\n    playerViewCount: " + getPlayerViewCount();
        } else {
            str20 = "";
        }
        sb.append(str20);
        if (getPlayerWidth() != null) {
            str21 = "\n    playerWidth: " + getPlayerWidth();
        } else {
            str21 = "";
        }
        sb.append(str21);
        if (getPlayerProgramTime() != null) {
            str22 = "\n    playerProgramTime: " + getPlayerProgramTime();
        } else {
            str22 = "";
        }
        sb.append(str22);
        if (getPlayerManifestNewestProgramTime() != null) {
            str23 = "\n    playerManifestNewestProgramTime: " + getPlayerManifestNewestProgramTime();
        } else {
            str23 = "";
        }
        sb.append(str23);
        if (getPlayerErrorSeverity() != null) {
            str24 = "\n    playerErrorSeverity: " + getPlayerErrorSeverity();
        } else {
            str24 = "";
        }
        sb.append(str24);
        if (getPlayerErrorContext() != null) {
            str25 = "\n    playerErrorContext: " + getPlayerErrorContext();
        } else {
            str25 = "";
        }
        sb.append(str25);
        if (getPlayerPlaybackMode() != null) {
            str26 = "\n    playerPlaybackMode: " + getPlayerPlaybackMode();
        } else {
            str26 = "";
        }
        sb.append(str26);
        if (getPlayerPlaybackModeData() != null) {
            str27 = "\n    playerPlaybackModeData: " + getPlayerPlaybackModeData();
        }
        sb.append(str27);
        return sb.toString();
    }

    public Long getPageLoadTime() throws JSONException {
        String str = get(PAGE_LOAD_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getPageUrl() {
        return get(PAGE_URL);
    }

    public String getPlayerAutoplayOn() {
        return get("pauon");
    }

    public String getPlayerErrorBusinessException() {
        return get(PLAYER_ERROR_BUSINESS_EXCEPTION);
    }

    public String getPlayerErrorCode() {
        return get(PLAYER_ERROR_CODE);
    }

    public String getPlayerErrorContext() {
        return get(PLAYER_ERROR_CONTEXT);
    }

    public String getPlayerErrorMessage() {
        return get(PLAYER_ERROR_MESSAGE);
    }

    public String getPlayerErrorSeverity() {
        return get(PLAYER_ERROR_SEVERITY);
    }

    public Integer getPlayerHeight() throws JSONException {
        String str = get(PLAYER_HEIGHT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public String getPlayerInstanceId() {
        return get(PLAYER_INSTANCE_ID);
    }

    public String getPlayerIsFullscreen() {
        return get(PLAYER_IS_FULLSCREEN);
    }

    public Boolean getPlayerIsPaused() throws JSONException {
        String str = get(PLAYER_IS_PAUSED);
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public String getPlayerLanguageCode() {
        return get(PLAYER_LANGUAGE_CODE);
    }

    public Long getPlayerLoadTime() throws JSONException {
        String str = get(PLAYER_LOAD_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getPlayerManifestNewestProgramTime() throws JSONException {
        String str = get(PLAYER_MANIFEST_NEWEST_PROGRAM_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getPlayerMuxPluginName() {
        return get(PLAYER_MUX_PLUGIN_NAME);
    }

    public String getPlayerMuxPluginVersion() {
        return get(PLAYER_MUX_PLUGIN_VERSION);
    }

    public String getPlayerPlaybackMode() {
        return get(PLAYER_PLAYBACK_MODE);
    }

    public String getPlayerPlaybackModeData() {
        return get(PLAYER_PLAYBACK_MODE_DATA);
    }

    public Long getPlayerPlayheadTime() throws JSONException {
        String str = get(PLAYER_PLAYHEAD_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getPlayerPreloadOn() {
        return get(PLAYER_PRELOAD_ON);
    }

    public Long getPlayerProgramTime() throws JSONException {
        String str = get(PLAYER_PROGRAM_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Integer getPlayerSequenceNumber() throws JSONException {
        String str = get(PLAYER_SEQUENCE_NUMBER);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public String getPlayerSoftwareName() {
        return get(PLAYER_SOFTWARE_NAME);
    }

    public String getPlayerSoftwareVersion() {
        return get(PLAYER_SOFTWARE_VERSION);
    }

    public Long getPlayerStartupTime() throws JSONException {
        String str = get(PLAYER_STARTUP_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Integer getPlayerViewCount() throws JSONException {
        String str = get(PLAYER_VIEW_COUNT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Integer getPlayerWidth() throws JSONException {
        String str = get(PLAYER_WIDTH);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public void setPageLoadTime(Long l) throws JSONException {
        if (l != null) {
            put(PAGE_LOAD_TIME, l.toString());
        }
    }

    public void setPageUrl(String str) throws JSONException {
        if (str != null) {
            put(PAGE_URL, str);
        }
    }

    public void setPlayerAutoplayOn(String str) throws JSONException {
        if (str != null) {
            put("pauon", str);
        }
    }

    public void setPlayerErrorBusinessException(String str) throws JSONException {
        if (str != null) {
            super.put(PLAYER_ERROR_BUSINESS_EXCEPTION, str);
        }
    }

    public void setPlayerErrorCode(String str) {
        put(PLAYER_ERROR_CODE, str);
    }

    public void setPlayerErrorContext(String str) {
        if (str != null) {
            super.put(PLAYER_ERROR_CONTEXT, str);
        }
    }

    public void setPlayerErrorMessage(String str) {
        put(PLAYER_ERROR_MESSAGE, str);
    }

    public void setPlayerErrorSeverity(String str) throws JSONException {
        if (str != null) {
            super.put(PLAYER_ERROR_SEVERITY, str);
        }
    }

    public void setPlayerHeight(Integer num) {
        if (num != null) {
            put(PLAYER_HEIGHT, num.toString());
        }
    }

    public void setPlayerInstanceId(String str) throws JSONException {
        if (str != null) {
            put(PLAYER_INSTANCE_ID, str);
        }
    }

    public void setPlayerIsFullscreen(String str) {
        if (str != null) {
            put(PLAYER_IS_FULLSCREEN, str);
        }
    }

    public void setPlayerIsPaused(Boolean bool) {
        if (bool != null) {
            put(PLAYER_IS_PAUSED, bool.toString());
        }
    }

    public void setPlayerLanguageCode(String str) throws JSONException {
        if (str != null) {
            put(PLAYER_LANGUAGE_CODE, str);
        }
    }

    public void setPlayerLoadTime(Long l) throws JSONException {
        if (l != null) {
            put(PLAYER_LOAD_TIME, l.toString());
        }
    }

    public void setPlayerManifestNewestProgramTime(Long l) {
        if (l != null) {
            put(PLAYER_MANIFEST_NEWEST_PROGRAM_TIME, l.toString());
        }
    }

    public void setPlayerMuxPluginName(String str) {
        if (str != null) {
            put(PLAYER_MUX_PLUGIN_NAME, str);
        }
    }

    public void setPlayerMuxPluginVersion(String str) {
        if (str != null) {
            put(PLAYER_MUX_PLUGIN_VERSION, str);
        }
    }

    public void setPlayerPlaybackMode(String str) {
        if (str != null) {
            put(PLAYER_PLAYBACK_MODE, str);
        }
    }

    public void setPlayerPlaybackModeData(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            new JSONObject(str);
            put(PLAYER_PLAYBACK_MODE_DATA, str);
        } catch (JSONException e) {
            MuxLogger.exception(e, "PlayerData", "Bad Playback Mode JSON, not added");
        }
    }

    public void setPlayerPlayheadTime(Long l) {
        if (l != null) {
            put(PLAYER_PLAYHEAD_TIME, l.toString());
        }
    }

    public void setPlayerPreloadOn(String str) throws JSONException {
        if (str != null) {
            put(PLAYER_PRELOAD_ON, str);
        }
    }

    public void setPlayerProgramTime(Long l) {
        if (l != null) {
            put(PLAYER_PROGRAM_TIME, l.toString());
        }
    }

    public void setPlayerSequenceNumber(Integer num) throws JSONException {
        if (num != null) {
            put(PLAYER_SEQUENCE_NUMBER, num.toString());
        }
    }

    public void setPlayerSoftwareName(String str) {
        if (str != null) {
            put(PLAYER_SOFTWARE_NAME, str);
        }
    }

    public void setPlayerSoftwareVersion(String str) {
        if (str != null) {
            put(PLAYER_SOFTWARE_VERSION, str);
        }
    }

    public void setPlayerStartupTime(Long l) throws JSONException {
        if (l != null) {
            put(PLAYER_STARTUP_TIME, l.toString());
        }
    }

    public void setPlayerViewCount(Integer num) throws JSONException {
        if (num != null) {
            put(PLAYER_VIEW_COUNT, num.toString());
        }
    }

    public void setPlayerWidth(Integer num) {
        if (num != null) {
            put(PLAYER_WIDTH, num.toString());
        }
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public void sync() {
    }
}
