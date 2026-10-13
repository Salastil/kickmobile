package com.mux.stats.sdk.core.model;

import java.util.ArrayList;
import org.json.JSONException;

/* JADX INFO: loaded from: classes8.dex */
public class CustomerViewerData extends BaseQueryData {
    public static final String MUX_VIEWER_DEVICE_CATEGORY = "mvrdvcg";
    public static final String MUX_VIEWER_DEVICE_MANUFACTURER = "mvrdvmn";
    public static final String MUX_VIEWER_DEVICE_MODEL = "mvrdvmo";
    public static final String MUX_VIEWER_DEVICE_NAME = "mvrdvnm";
    public static final String MUX_VIEWER_OS_FAMILY = "mvrosfm";
    public static final String MUX_VIEWER_OS_VERSION = "mvrosve";
    public static final String VIEWER_PLAN = "upz";
    public static final String VIEWER_PLAN_CATEGORY = "upzcg";
    public static final String VIEWER_PLAN_STATUS = "upzss";
    public static final ArrayList<String> keys;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add(MUX_VIEWER_DEVICE_CATEGORY);
        arrayList.add(MUX_VIEWER_DEVICE_MANUFACTURER);
        arrayList.add(MUX_VIEWER_DEVICE_NAME);
        arrayList.add(MUX_VIEWER_OS_FAMILY);
        arrayList.add(MUX_VIEWER_OS_VERSION);
        arrayList.add(MUX_VIEWER_DEVICE_MODEL);
        arrayList.add(VIEWER_PLAN);
        arrayList.add(VIEWER_PLAN_STATUS);
        arrayList.add(VIEWER_PLAN_CATEGORY);
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public String getDebugString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        StringBuilder sb = new StringBuilder("CustomerViewerData: ");
        String str6 = "";
        if (getMuxViewerDeviceCategory() != null) {
            str = "\n    muxViewerDeviceCategory: " + getMuxViewerDeviceCategory();
        } else {
            str = "";
        }
        sb.append(str);
        if (getMuxViewerDeviceManufacturer() != null) {
            str2 = "\n    muxViewerDeviceManufacturer: " + getMuxViewerDeviceManufacturer();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (getMuxViewerDeviceName() != null) {
            str3 = "\n    muxViewerDeviceName: " + getMuxViewerDeviceName();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (getMuxViewerOsFamily() != null) {
            str4 = "\n    muxViewerOsFamily: " + getMuxViewerOsFamily();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (getMuxViewerOsVersion() != null) {
            str5 = "\n    muxViewerOsVersion: " + getMuxViewerOsVersion();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (getMuxViewerDeviceModel() != null) {
            str6 = "\n    muxViewerDeviceModel: " + getMuxViewerDeviceModel();
        }
        sb.append(str6);
        return sb.toString();
    }

    public String getMuxViewerDeviceCategory() {
        return get(MUX_VIEWER_DEVICE_CATEGORY);
    }

    public String getMuxViewerDeviceManufacturer() {
        return get(MUX_VIEWER_DEVICE_MANUFACTURER);
    }

    public String getMuxViewerDeviceModel() {
        return get(MUX_VIEWER_DEVICE_MODEL);
    }

    public String getMuxViewerDeviceName() {
        return get(MUX_VIEWER_DEVICE_NAME);
    }

    public String getMuxViewerOsFamily() {
        return get(MUX_VIEWER_OS_FAMILY);
    }

    public String getMuxViewerOsVersion() {
        return get(MUX_VIEWER_OS_VERSION);
    }

    public String getViewerPlan() {
        return get(VIEWER_PLAN);
    }

    public String getViewerPlanCategory() {
        return get(VIEWER_PLAN_CATEGORY);
    }

    public String getViewerPlanStatus() {
        return get(VIEWER_PLAN_STATUS);
    }

    public void setMuxViewerDeviceCategory(String str) throws JSONException {
        if (str != null) {
            put(MUX_VIEWER_DEVICE_CATEGORY, str);
        }
    }

    public void setMuxViewerDeviceManufacturer(String str) throws JSONException {
        if (str != null) {
            put(MUX_VIEWER_DEVICE_MANUFACTURER, str);
        }
    }

    public void setMuxViewerDeviceModel(String str) throws JSONException {
        if (str != null) {
            put(MUX_VIEWER_DEVICE_MODEL, str);
        }
    }

    public void setMuxViewerDeviceName(String str) throws JSONException {
        if (str != null) {
            put(MUX_VIEWER_DEVICE_NAME, str);
        }
    }

    public void setMuxViewerOsFamily(String str) throws JSONException {
        if (str != null) {
            put(MUX_VIEWER_OS_FAMILY, str);
        }
    }

    public void setMuxViewerOsVersion(String str) throws JSONException {
        if (str != null) {
            put(MUX_VIEWER_OS_VERSION, str);
        }
    }

    public void setViewerPlan(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_PLAN, str);
        }
    }

    public void setViewerPlanCategory(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_PLAN_CATEGORY, str);
        }
    }

    public void setViewerPlanStatus(String str) throws JSONException {
        if (str != null) {
            put(VIEWER_PLAN_STATUS, str);
        }
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public void sync() {
    }
}
