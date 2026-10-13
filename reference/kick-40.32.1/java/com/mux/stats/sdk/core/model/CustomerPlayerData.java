package com.mux.stats.sdk.core.model;

import java.util.ArrayList;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class CustomerPlayerData extends BaseQueryData {
    public static final String AD_CONFIG_VARIANT = "dcnva";
    public static final String AUTOPLAY_ON = "pauon";
    public static final String ENV_KEY = "ake";
    public static final String EXPERIMENT_NAME = "fnm";
    public static final String PAGE_TYPE = "wty";
    public static final String PLAYER_CAPTIONS_ENABLED = "pcseb";
    public static final String PLAYER_INIT_TIME = "piiti";
    public static final String PLAYER_NAME = "pnm";
    public static final String PLAYER_PIP_ENABLED = "pppeb";
    public static final String PLAYER_VERSION = "pve";
    public static final String SUB_PROPERTY_ID = "ypyid";
    public static final String VIEWER_USER_ID = "uusid";
    public static final ArrayList<String> keys;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add(AD_CONFIG_VARIANT);
        arrayList.add(EXPERIMENT_NAME);
        arrayList.add(PAGE_TYPE);
        arrayList.add(PLAYER_INIT_TIME);
        arrayList.add(PLAYER_NAME);
        arrayList.add(PLAYER_VERSION);
        arrayList.add(ENV_KEY);
        arrayList.add(SUB_PROPERTY_ID);
        arrayList.add(VIEWER_USER_ID);
        arrayList.add("pauon");
        arrayList.add(PLAYER_PIP_ENABLED);
        arrayList.add(PLAYER_CAPTIONS_ENABLED);
    }

    public String getAdConfigVariant() {
        return get(AD_CONFIG_VARIANT);
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
        StringBuilder sb = new StringBuilder("CustomerPlayerData: ");
        String str10 = "";
        if (getAdConfigVariant() != null) {
            str = "\n    adConfigVariant: " + getAdConfigVariant();
        } else {
            str = "";
        }
        sb.append(str);
        if (getExperimentName() != null) {
            str2 = "\n    experimentName: " + getExperimentName();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (getPageType() != null) {
            str3 = "\n    pageType: " + getPageType();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (getPlayerInitTime() != null) {
            str4 = "\n    playerInitTime: " + getPlayerInitTime();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (getPlayerName() != null) {
            str5 = "\n    playerName: " + getPlayerName();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (getPlayerVersion() != null) {
            str6 = "\n    playerVersion: " + getPlayerVersion();
        } else {
            str6 = "";
        }
        sb.append(str6);
        if (getEnvironmentKey() != null) {
            str7 = "\n    environmentKey: " + getEnvironmentKey();
        } else {
            str7 = "";
        }
        sb.append(str7);
        if (getPropertyKey() != null) {
            str8 = "\n    propertyKey: " + getPropertyKey();
        } else {
            str8 = "";
        }
        sb.append(str8);
        if (getSubPropertyId() != null) {
            str9 = "\n    subPropertyId: " + getSubPropertyId();
        } else {
            str9 = "";
        }
        sb.append(str9);
        if (getViewerUserId() != null) {
            str10 = "\n    viewerUserId: " + getViewerUserId();
        }
        sb.append(str10);
        return sb.toString();
    }

    public String getEnvironmentKey() {
        return get(ENV_KEY);
    }

    public String getExperimentName() {
        return get(EXPERIMENT_NAME);
    }

    public String getPageType() {
        return get(PAGE_TYPE);
    }

    public Boolean getPlayerCaptionsEnabled() throws JSONException {
        String str = get(PLAYER_CAPTIONS_ENABLED);
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public Long getPlayerInitTime() throws JSONException {
        String str = get(PLAYER_INIT_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getPlayerName() {
        return get(PLAYER_NAME);
    }

    public Boolean getPlayerPipEnabled() throws JSONException {
        String str = get(PLAYER_PIP_ENABLED);
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public String getPlayerVersion() {
        return get(PLAYER_VERSION);
    }

    @Deprecated
    public String getPropertyKey() {
        return get(ENV_KEY);
    }

    public String getSubPropertyId() {
        return get(SUB_PROPERTY_ID);
    }

    public String getViewerUserId() {
        return get(VIEWER_USER_ID);
    }

    public Boolean isAutoPlayOn() throws JSONException {
        String str = get("pauon");
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public void setAdConfigVariant(String str) throws JSONException {
        if (str != null) {
            put(AD_CONFIG_VARIANT, str);
        }
    }

    public void setAutoPlayOn(Boolean bool) throws JSONException {
        if (bool != null) {
            put("pauon", bool.toString());
        }
    }

    public void setEnvironmentKey(String str) throws JSONException {
        if (str != null) {
            put(ENV_KEY, str);
        }
    }

    public void setExperimentName(String str) throws JSONException {
        if (str != null) {
            put(EXPERIMENT_NAME, str);
        }
    }

    public void setPageType(String str) throws JSONException {
        if (str != null) {
            put(PAGE_TYPE, str);
        }
    }

    public void setPlayerCaptionsEnabled(Boolean bool) throws JSONException {
        if (bool != null) {
            put(PLAYER_CAPTIONS_ENABLED, bool.toString());
        }
    }

    public void setPlayerInitTime(Long l) throws JSONException {
        if (l != null) {
            put(PLAYER_INIT_TIME, l.toString());
        }
    }

    public void setPlayerName(String str) throws JSONException {
        if (str != null) {
            put(PLAYER_NAME, str);
        }
    }

    public void setPlayerPipEnabled(Boolean bool) throws JSONException {
        if (bool != null) {
            put(PLAYER_PIP_ENABLED, bool.toString());
        }
    }

    public void setPlayerVersion(String str) throws JSONException {
        if (str != null) {
            put(PLAYER_VERSION, str);
        }
    }

    @Deprecated
    public void setPropertyKey(String str) throws JSONException {
        if (str != null) {
            put(ENV_KEY, str);
        }
    }

    public void setSubPropertyId(String str) throws JSONException {
        if (str != null) {
            put(SUB_PROPERTY_ID, str);
        }
    }

    public void setViewerUserId(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_USER_ID, str);
        }
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public void sync() {
    }
}
