package com.mux.stats.sdk.core.model;

import java.util.ArrayList;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class ViewerData extends BaseQueryData {
    public static final String VIEWER_APPLICATION_ENGINE = "ualeg";
    public static final String VIEWER_APPLICATION_NAME = "ualnm";
    public static final String VIEWER_APPLICATION_VERSION = "ualve";
    public static final String VIEWER_CONNECTION_LOW_DATA_MODE = "ucxlwdamp";
    public static final String VIEWER_CONNECTION_TYPE = "ucxty";
    public static final String VIEWER_DEVICE_CATEGORY = "udvcg";
    public static final String VIEWER_DEVICE_MANUFACTURER = "udvmn";
    public static final String VIEWER_DEVICE_MODEL = "udvmo";
    public static final String VIEWER_DEVICE_NAME = "udvnm";
    public static final String VIEWER_OS_ARCHITECTURE = "uosar";
    public static final String VIEWER_OS_FAMILY = "uosfm";
    public static final String VIEWER_OS_VERSION = "uosve";
    public static final String VIEWER_TIME = "uti";
    public static final ArrayList<String> keys;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add(VIEWER_APPLICATION_ENGINE);
        arrayList.add(VIEWER_APPLICATION_NAME);
        arrayList.add(VIEWER_APPLICATION_VERSION);
        arrayList.add(VIEWER_DEVICE_CATEGORY);
        arrayList.add(VIEWER_DEVICE_NAME);
        arrayList.add(VIEWER_DEVICE_MANUFACTURER);
        arrayList.add(VIEWER_DEVICE_MODEL);
        arrayList.add(VIEWER_OS_ARCHITECTURE);
        arrayList.add(VIEWER_OS_FAMILY);
        arrayList.add(VIEWER_OS_VERSION);
        arrayList.add(VIEWER_CONNECTION_TYPE);
        arrayList.add(VIEWER_CONNECTION_LOW_DATA_MODE);
        arrayList.add("uti");
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
        StringBuilder sb = new StringBuilder("ViewerData: ");
        String str12 = "";
        if (getViewerApplicationEngine() != null) {
            str = "\n    viewerApplicationEngine: " + getViewerApplicationEngine();
        } else {
            str = "";
        }
        sb.append(str);
        if (getViewerApplicationName() != null) {
            str2 = "\n    viewerApplicationName: " + getViewerApplicationName();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (getViewerApplicationVersion() != null) {
            str3 = "\n    viewerApplicationVersion: " + getViewerApplicationVersion();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (getViewerDeviceCategory() != null) {
            str4 = "\n    viewerDeviceCategory: " + getViewerDeviceCategory();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (getViewerDeviceManufacturer() != null) {
            str5 = "\n    viewerDeviceManufacturer: " + getViewerDeviceManufacturer();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (getViewerDeviceModel() != null) {
            str6 = "\n    viewerDeviceModel: " + getViewerDeviceModel();
        } else {
            str6 = "";
        }
        sb.append(str6);
        if (getViewerOsArchitecture() != null) {
            str7 = "\n    viewerOsArchitecture: " + getViewerOsArchitecture();
        } else {
            str7 = "";
        }
        sb.append(str7);
        if (getViewerOsFamily() != null) {
            str8 = "\n    viewerOsFamily: " + getViewerOsFamily();
        } else {
            str8 = "";
        }
        sb.append(str8);
        if (getViewerOsVersion() != null) {
            str9 = "\n    viewerOsVersion: " + getViewerOsVersion();
        } else {
            str9 = "";
        }
        sb.append(str9);
        if (getViewerConnectionType() != null) {
            str10 = "\n    viewerConnectionType: " + getViewerConnectionType();
        } else {
            str10 = "";
        }
        sb.append(str10);
        if (getViewerConnectionLowDataMode() != null) {
            str11 = "\n    viewerConnectionLowDataMode: " + getViewerConnectionLowDataMode();
        } else {
            str11 = "";
        }
        sb.append(str11);
        if (getViewerTime() != null) {
            str12 = "\n    viewerTime: " + getViewerTime();
        }
        sb.append(str12);
        return sb.toString();
    }

    public String getViewerApplicationEngine() {
        return get(VIEWER_APPLICATION_ENGINE);
    }

    public String getViewerApplicationName() {
        return get(VIEWER_APPLICATION_NAME);
    }

    public String getViewerApplicationVersion() {
        return get(VIEWER_APPLICATION_VERSION);
    }

    public Boolean getViewerConnectionLowDataMode() throws JSONException {
        String str = get(VIEWER_CONNECTION_LOW_DATA_MODE);
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    public String getViewerConnectionType() {
        return get(VIEWER_CONNECTION_TYPE);
    }

    public String getViewerDeviceCategory() {
        return get(VIEWER_DEVICE_CATEGORY);
    }

    public String getViewerDeviceManufacturer() {
        return get(VIEWER_DEVICE_MANUFACTURER);
    }

    public String getViewerDeviceModel() {
        return get(VIEWER_DEVICE_MODEL);
    }

    public String getViewerDeviceName() {
        return get(VIEWER_DEVICE_NAME);
    }

    public String getViewerOsArchitecture() {
        return get(VIEWER_OS_ARCHITECTURE);
    }

    public String getViewerOsFamily() {
        return get(VIEWER_OS_FAMILY);
    }

    public String getViewerOsVersion() {
        return get(VIEWER_OS_VERSION);
    }

    public Long getViewerTime() throws JSONException {
        String str = get("uti");
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public void setViewerApplicationEngine(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_APPLICATION_ENGINE, str);
        }
    }

    public void setViewerApplicationName(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_APPLICATION_NAME, str);
        }
    }

    public void setViewerApplicationVersion(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_APPLICATION_VERSION, str);
        }
    }

    public void setViewerConnectionLowDataMode(Boolean bool) throws JSONException {
        if (bool != null) {
            put(VIEWER_CONNECTION_LOW_DATA_MODE, bool.toString());
        }
    }

    public void setViewerConnectionType(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_CONNECTION_TYPE, str);
        }
    }

    public void setViewerDeviceCategory(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_DEVICE_CATEGORY, str);
        }
    }

    public void setViewerDeviceManufacturer(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_DEVICE_MANUFACTURER, str);
        }
    }

    public void setViewerDeviceModel(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_DEVICE_MODEL, str);
        }
    }

    public void setViewerDeviceName(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_DEVICE_NAME, str);
        }
    }

    public void setViewerOsArchitecture(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_OS_ARCHITECTURE, str);
        }
    }

    public void setViewerOsFamily(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_OS_FAMILY, str);
        }
    }

    public void setViewerOsVersion(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_OS_VERSION, str);
        }
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
