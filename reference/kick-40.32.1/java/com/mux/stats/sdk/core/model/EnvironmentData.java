package com.mux.stats.sdk.core.model;

import java.util.ArrayList;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class EnvironmentData extends BaseQueryData {
    public static final String DEBUG = "debug";
    public static final String MUX_API_VERSION = "mapve";
    public static final String MUX_EMBED = "mem";
    public static final String MUX_EMBED_VERSION = "memve";
    public static final String MUX_VIEWER_ID = "mvrid";
    public static final String SESSION_EXPIRES = "sex";
    public static final String SESSION_ID = "sid";
    public static final String SESSION_START = "sst";
    public static final ArrayList<String> keys;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add("debug");
        arrayList.add(MUX_API_VERSION);
        arrayList.add(MUX_EMBED_VERSION);
        arrayList.add(MUX_EMBED);
        arrayList.add(MUX_VIEWER_ID);
        arrayList.add(SESSION_EXPIRES);
        arrayList.add(SESSION_ID);
        arrayList.add(SESSION_START);
    }

    public String getDebug() {
        return get("debug");
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
        StringBuilder sb = new StringBuilder("EnvironmentData: ");
        String str8 = "";
        if (getDebug() != null) {
            str = "\n    debug: " + getDebug();
        } else {
            str = "";
        }
        sb.append(str);
        if (getMuxApiVersion() != null) {
            str2 = "\n    muxApiVersion: " + getMuxApiVersion();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (getMuxEmbed() != null) {
            str3 = "\n    muxEmbed: " + getMuxEmbed();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (getMuxEmbedVersion() != null) {
            str4 = "\n    muxEmbedVersion: " + getMuxEmbedVersion();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (getMuxViewerId() != null) {
            str5 = "\n    getMuxViewerId: " + getMuxViewerId();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (getSessionExpires() != null) {
            str6 = "\n    sessionExpires: " + getSessionExpires();
        } else {
            str6 = "";
        }
        sb.append(str6);
        if (getSessionId() != null) {
            str7 = "\n    sessionId: " + getSessionId();
        } else {
            str7 = "";
        }
        sb.append(str7);
        if (getSessionStart() != null) {
            str8 = "\n    sessionStart: " + getSessionStart();
        }
        sb.append(str8);
        return sb.toString();
    }

    public String getMuxApiVersion() {
        return get(MUX_API_VERSION);
    }

    public String getMuxEmbed() {
        return get(MUX_EMBED);
    }

    public String getMuxEmbedVersion() {
        return get(MUX_EMBED_VERSION);
    }

    public String getMuxViewerId() {
        return get(MUX_VIEWER_ID);
    }

    public Long getSessionExpires() throws JSONException {
        String str = get(SESSION_EXPIRES);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getSessionId() {
        return get(SESSION_ID);
    }

    public Long getSessionStart() throws JSONException {
        String str = get(SESSION_START);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public void setDebug(String str) throws JSONException {
        if (str != null) {
            put("debug", str);
        }
    }

    public void setMuxApiVersion(String str) throws JSONException {
        if (str != null) {
            put(MUX_API_VERSION, str);
        }
    }

    public void setMuxEmbed(String str) throws JSONException {
        if (str != null) {
            put(MUX_EMBED, str);
        }
    }

    public void setMuxEmbedVersion(String str) throws JSONException {
        if (str != null) {
            put(MUX_EMBED_VERSION, str);
        }
    }

    public void setMuxViewerId(String str) throws JSONException {
        if (str != null) {
            put(MUX_VIEWER_ID, str);
        }
    }

    public void setSessionExpires(Long l) throws JSONException {
        if (l != null) {
            put(SESSION_EXPIRES, l.toString());
        }
    }

    public void setSessionId(String str) throws JSONException {
        if (str != null) {
            put(SESSION_ID, str);
        }
    }

    public void setSessionStart(Long l) throws JSONException {
        if (l != null) {
            put(SESSION_START, l.toString());
        }
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public void sync() {
    }
}
