package com.mux.stats.sdk.core.model;

import java.util.ArrayList;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class CustomerViewData extends BaseQueryData {
    public static final String INTERNAL_VIDEO_EXPERIMENTS = "iviep";
    public static final String INTERNAL_VIEW_SESSION_ID = "ivwseid";
    public static final String VIEW_CDN_EDGE_POP = "xdnedpx";
    public static final String VIEW_CDN_ORIGIN = "xdnor";
    public static final String VIEW_CLIENT_APPLICATION_NAME = "xcialnm";
    public static final String VIEW_CLIENT_APPLICATION_VERSION = "xcialve";
    public static final String VIEW_DRM_LEVEL = "xdrle";
    public static final String VIEW_DRM_TYPE = "xdrty";
    public static final String VIEW_SESSION_ID = "xseid";
    public static final String VIEW_TIME_SHIFT_ENABLED = "xtisheb";
    public static final ArrayList<String> keys;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add(VIEW_SESSION_ID);
        arrayList.add(INTERNAL_VIEW_SESSION_ID);
        arrayList.add(INTERNAL_VIDEO_EXPERIMENTS);
        arrayList.add("xdrty");
        arrayList.add(VIEW_CLIENT_APPLICATION_NAME);
        arrayList.add(VIEW_CLIENT_APPLICATION_VERSION);
        arrayList.add(VIEW_DRM_LEVEL);
        arrayList.add(VIEW_TIME_SHIFT_ENABLED);
        arrayList.add(VIEW_CDN_ORIGIN);
        arrayList.add(VIEW_CDN_EDGE_POP);
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public String getDebugString() {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder("CustomerViewData: ");
        String str4 = "";
        if (getViewDrmType() != null) {
            str = "\n    viewDrmType: " + getViewDrmType();
        } else {
            str = "";
        }
        sb.append(str);
        if (getViewSessionId() != null) {
            str2 = "\n    viewSessionId: " + getViewSessionId();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (getInternalViewSessionId() != null) {
            str3 = "\n    internalViewSessionId: " + getInternalViewSessionId();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (getInternalVideoExperiments() != null) {
            str4 = "\n    getInternalVideoExperiments: " + getInternalVideoExperiments();
        }
        sb.append(str4);
        return sb.toString();
    }

    public String getInternalVideoExperiments() {
        return get(INTERNAL_VIDEO_EXPERIMENTS);
    }

    public String getInternalViewSessionId() {
        return get(INTERNAL_VIEW_SESSION_ID);
    }

    public String getViewCdnEdgePop() {
        return get(VIEW_CDN_EDGE_POP);
    }

    public String getViewCdnOrigin() {
        return get(VIEW_CDN_ORIGIN);
    }

    public String getViewClientApplicationName() {
        return get(VIEW_CLIENT_APPLICATION_NAME);
    }

    public String getViewClientApplicationVersion() {
        return get(VIEW_CLIENT_APPLICATION_VERSION);
    }

    public String getViewDrmLevel() {
        return get(VIEW_DRM_LEVEL);
    }

    public String getViewDrmType() {
        return get("xdrty");
    }

    public String getViewSessionId() {
        return get(VIEW_SESSION_ID);
    }

    public Boolean getViewTimeShiftEnabled() throws JSONException {
        String str = get(VIEW_TIME_SHIFT_ENABLED);
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public void setInternalVideoExperiments(String str) throws JSONException {
        if (str != null) {
            put(INTERNAL_VIDEO_EXPERIMENTS, str);
        }
    }

    public void setInternalViewSessionId(String str) throws JSONException {
        if (str != null) {
            put(INTERNAL_VIEW_SESSION_ID, str);
        }
    }

    public void setViewCdnEdgePop(String str) throws JSONException {
        if (str != null) {
            put(VIEW_CDN_EDGE_POP, str);
        }
    }

    public void setViewCdnOrigin(String str) throws JSONException {
        if (str != null) {
            put(VIEW_CDN_ORIGIN, str);
        }
    }

    public void setViewClientApplicationName(String str) throws JSONException {
        if (str != null) {
            put(VIEW_CLIENT_APPLICATION_NAME, str);
        }
    }

    public void setViewClientApplicationVersion(String str) throws JSONException {
        if (str != null) {
            put(VIEW_CLIENT_APPLICATION_VERSION, str);
        }
    }

    public void setViewDrmLevel(String str) throws JSONException {
        if (str != null) {
            put(VIEW_DRM_LEVEL, str);
        }
    }

    public void setViewDrmType(String str) throws JSONException {
        if (str != null) {
            put("xdrty", str);
        }
    }

    public void setViewSessionId(String str) throws JSONException {
        if (str != null) {
            put(VIEW_SESSION_ID, str);
        }
    }

    public void setViewTimeShiftEnabled(Boolean bool) throws JSONException {
        if (bool != null) {
            put(VIEW_TIME_SHIFT_ENABLED, bool.toString());
        }
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public void sync() {
    }
}
