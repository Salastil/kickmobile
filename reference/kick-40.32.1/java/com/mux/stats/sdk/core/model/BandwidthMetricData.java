package com.mux.stats.sdk.core.model;

import com.facebook.react.uimanager.ViewProps;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class BandwidthMetricData extends BaseQueryData {
    public static final String REQUEST_BYTES_LOADED = "qbyld";
    public static final String REQUEST_CANCEL = "qcb";
    public static final String REQUEST_CURRENT_LEVEL = "qcule";
    public static final String REQUEST_ERROR = "qer";
    public static final String REQUEST_ERROR_CODE = "qercd";
    public static final String REQUEST_ERROR_TEXT = "qerte";
    public static final String REQUEST_EVENT_TYPE = "qeety";
    public static final String REQUEST_HOSTNAME = "qhn";
    public static final String REQUEST_ID = "qid";
    public static final String REQUEST_LABELED_BITRATE = "qlbbi";
    public static final String REQUEST_LATENCY = "qlt";
    public static final String REQUEST_MEDIA_DURATION = "qmddu";
    public static final String REQUEST_MEDIA_START_TIME = "qmdstti";
    public static final String REQUEST_RENDITION_LISTS = "qrfls";
    public static final String REQUEST_RESPONSE_END = "qrpen";
    public static final String REQUEST_RESPONSE_HEADERS = "qrphe";
    public static final String REQUEST_RESPONSE_START = "qrpst";
    public static final String REQUEST_START = "qst";
    public static final String REQUEST_THROUGHPUT = "qth";
    public static final String REQUEST_TYPE = "qty";
    public static final String REQUEST_URL = "qur";
    public static final String REQUEST_VIDEO_HEIGHT = "qviht";
    public static final String REQUEST_VIDEO_WIDTH = "qviwd";
    public static final ArrayList<String> keys;

    public static class Rendition {
        public String attrs;
        public long bitrate;
        public String codec;
        public float fps;
        public int height;
        public String name;
        public int width;
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add(REQUEST_EVENT_TYPE);
        arrayList.add(REQUEST_START);
        arrayList.add(REQUEST_RESPONSE_START);
        arrayList.add(REQUEST_RESPONSE_END);
        arrayList.add(REQUEST_LATENCY);
        arrayList.add(REQUEST_THROUGHPUT);
        arrayList.add(REQUEST_BYTES_LOADED);
        arrayList.add(REQUEST_TYPE);
        arrayList.add(REQUEST_RESPONSE_HEADERS);
        arrayList.add(REQUEST_HOSTNAME);
        arrayList.add(REQUEST_MEDIA_DURATION);
        arrayList.add(REQUEST_CURRENT_LEVEL);
        arrayList.add(REQUEST_MEDIA_START_TIME);
        arrayList.add(REQUEST_VIDEO_WIDTH);
        arrayList.add(REQUEST_VIDEO_HEIGHT);
        arrayList.add(REQUEST_ERROR);
        arrayList.add(REQUEST_URL);
        arrayList.add(REQUEST_ERROR_TEXT);
        arrayList.add(REQUEST_ERROR_CODE);
        arrayList.add(REQUEST_LABELED_BITRATE);
        arrayList.add(REQUEST_RENDITION_LISTS);
        arrayList.add(REQUEST_CANCEL);
        arrayList.add(REQUEST_ID);
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
        StringBuilder sb = new StringBuilder("BandwidthMetricData: ");
        String str21 = "";
        if (getRequestEventType() != null) {
            str = "\n    requestEventType: " + getRequestEventType();
        } else {
            str = "";
        }
        sb.append(str);
        if (getRequestStart() != null) {
            str2 = "\n    requestStart: " + getRequestStart();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (getRequestResponseStart() != null) {
            str3 = "\n    requestResponseStart: " + getRequestResponseStart();
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (getRequestResponseEnd() != null) {
            str4 = "\n    requestResponseEnd: " + getRequestResponseEnd();
        } else {
            str4 = "";
        }
        sb.append(str4);
        if (getRequestLatency() != null) {
            str5 = "\n    requestResponseLatency: " + getRequestLatency();
        } else {
            str5 = "";
        }
        sb.append(str5);
        if (getRequestThroughput() != null) {
            str6 = "\n    requestResponseThroughput: " + getRequestThroughput();
        } else {
            str6 = "";
        }
        sb.append(str6);
        if (getRequestBytesLoaded() != null) {
            str7 = "\n    requestBytesLoaded: " + getRequestBytesLoaded();
        } else {
            str7 = "";
        }
        sb.append(str7);
        if (getRequestType() != null) {
            str8 = "\n    requestType: " + getRequestType();
        } else {
            str8 = "";
        }
        sb.append(str8);
        if (getRequestResponseHeaders().keySet().size() > 0) {
            str9 = "\n    requestResponseHeaders: " + getRequestResponseHeaders().keySet();
        } else {
            str9 = "";
        }
        sb.append(str9);
        if (getRequestHostName() != null) {
            str10 = "\n    requestHostName: " + getRequestHostName();
        } else {
            str10 = "";
        }
        sb.append(str10);
        if (getRequestMediaDuration() != null) {
            str11 = "\n    requestMediaDuration: " + getRequestMediaDuration();
        } else {
            str11 = "";
        }
        sb.append(str11);
        if (getRequestCurrentLevel() != null) {
            str12 = "\n    requestCurrentLevel: " + getRequestCurrentLevel();
        } else {
            str12 = "";
        }
        sb.append(str12);
        if (getRequestMediaStartTime() != null) {
            str13 = "\n    requestMediaStartTime: " + getRequestMediaStartTime();
        } else {
            str13 = "";
        }
        sb.append(str13);
        if (getRequestVideoWidth() != null) {
            str14 = "\n    requestVideoWidth: " + getRequestVideoWidth();
        } else {
            str14 = "";
        }
        sb.append(str14);
        if (getRequestVideoHeight() != null) {
            str15 = "\n    requestVideoHeight: " + getRequestVideoHeight();
        } else {
            str15 = "";
        }
        sb.append(str15);
        if (getRequestError() != null) {
            str16 = "\n    requestError: " + getRequestError();
        } else {
            str16 = "";
        }
        sb.append(str16);
        if (getRequestErrorText() != null) {
            str17 = "\n    requestErrorText: " + getRequestErrorText();
        } else {
            str17 = "";
        }
        sb.append(str17);
        if (getRequestErrorCode() != null) {
            str18 = "\n    requestErrorCode: " + getRequestErrorCode();
        } else {
            str18 = "";
        }
        sb.append(str18);
        if (getRequestLabeledBitrate() != null) {
            str19 = "\n    requestLabeledBitrate: " + getRequestLabeledBitrate();
        } else {
            str19 = "";
        }
        sb.append(str19);
        if (getRequestRenditionLists() != null) {
            str20 = "\n    requestRenditionLists: " + getRequestRenditionLists();
        } else {
            str20 = "";
        }
        sb.append(str20);
        if (getRequestCancel() != null) {
            str21 = "\n    requestCancel: " + getRequestCancel();
        }
        sb.append(str21);
        return sb.toString();
    }

    public Long getRequestBytesLoaded() throws JSONException {
        String str = get(REQUEST_BYTES_LOADED);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getRequestCancel() {
        return get(REQUEST_CANCEL);
    }

    public Integer getRequestCurrentLevel() throws JSONException {
        String str = get(REQUEST_CURRENT_LEVEL);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public String getRequestError() {
        return get(REQUEST_ERROR);
    }

    public Integer getRequestErrorCode() throws JSONException {
        String str = get(REQUEST_ERROR_CODE);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public String getRequestErrorText() {
        return get(REQUEST_ERROR_TEXT);
    }

    public String getRequestEventType() {
        return get(REQUEST_EVENT_TYPE);
    }

    public String getRequestHostName() {
        return get(REQUEST_HOSTNAME);
    }

    public String getRequestId() {
        return get(REQUEST_ID);
    }

    public Integer getRequestLabeledBitrate() throws JSONException {
        String str = get(REQUEST_LABELED_BITRATE);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Long getRequestLatency() throws JSONException {
        String str = get(REQUEST_LATENCY);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getRequestMediaDuration() throws JSONException {
        String str = get(REQUEST_MEDIA_DURATION);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getRequestMediaStartTime() throws JSONException {
        String str = get(REQUEST_MEDIA_START_TIME);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public List<Rendition> getRequestRenditionLists() throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (this.query.has(REQUEST_RENDITION_LISTS)) {
            JSONObject jSONObject = new JSONObject(this.query.getJSONObject(REQUEST_RENDITION_LISTS).toString());
            if (jSONObject.has(LinkHeader.Parameters.Media)) {
                JSONArray jSONArray = jSONObject.getJSONArray(LinkHeader.Parameters.Media);
                for (int i = 0; jSONArray != null && i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    Rendition rendition = new Rendition();
                    rendition.width = jSONObject2.optInt(ViewProps.WIDTH);
                    rendition.height = jSONObject2.optInt(ViewProps.HEIGHT);
                    rendition.bitrate = jSONObject2.optLong("bitrate");
                    rendition.attrs = jSONObject2.optString("attrs");
                    arrayList.add(rendition);
                }
            }
        }
        return arrayList;
    }

    public Long getRequestResponseEnd() throws JSONException {
        String str = get(REQUEST_RESPONSE_END);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Hashtable<String, String> getRequestResponseHeaders() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        JSONObject jSONObjectOptJSONObject = this.query.optJSONObject(REQUEST_RESPONSE_HEADERS);
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayNames = jSONObjectOptJSONObject.names();
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                String str = (String) jSONArrayNames.get(i);
                hashtable.put(str, jSONObjectOptJSONObject.optString(str));
            }
        }
        return hashtable;
    }

    public Long getRequestResponseStart() throws JSONException {
        String str = get(REQUEST_RESPONSE_START);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getRequestStart() throws JSONException {
        String str = get(REQUEST_START);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public Long getRequestThroughput() throws JSONException {
        String str = get(REQUEST_THROUGHPUT);
        if (str == null) {
            return null;
        }
        return Long.valueOf(Long.parseLong(str));
    }

    public String getRequestType() {
        return get(REQUEST_TYPE);
    }

    public String getRequestUrl() {
        return get(REQUEST_URL);
    }

    public Integer getRequestVideoHeight() throws JSONException {
        String str = get(REQUEST_VIDEO_HEIGHT);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Integer getRequestVideoWidth() throws JSONException {
        String str = get(REQUEST_VIDEO_WIDTH);
        if (str == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public void setRequestBytesLoaded(Long l) throws JSONException {
        if (l != null) {
            put(REQUEST_BYTES_LOADED, l.toString());
        }
    }

    public void setRequestCancel(String str) throws JSONException {
        if (str != null) {
            put(REQUEST_CANCEL, str);
        }
    }

    public void setRequestCurrentLevel(Integer num) throws JSONException {
        if (num != null) {
            put(REQUEST_CURRENT_LEVEL, num.toString());
        }
    }

    public void setRequestError(String str) throws JSONException {
        if (str != null) {
            put(REQUEST_ERROR, str);
        }
    }

    public void setRequestErrorCode(Integer num) throws JSONException {
        if (num != null) {
            put(REQUEST_ERROR_CODE, num.toString());
        }
    }

    public void setRequestErrorText(String str) throws JSONException {
        if (str != null) {
            put(REQUEST_ERROR_TEXT, str);
        }
    }

    public void setRequestEventType(String str) throws JSONException {
        if (str != null) {
            put(REQUEST_EVENT_TYPE, str);
        }
    }

    public void setRequestHostName(String str) throws JSONException {
        if (str != null) {
            put(REQUEST_HOSTNAME, str);
        }
    }

    public void setRequestId(String str) throws JSONException {
        if (str != null) {
            put(REQUEST_ID, str);
        }
    }

    public void setRequestLabeledBitrate(Integer num) throws JSONException {
        if (num != null) {
            put(REQUEST_LABELED_BITRATE, num.toString());
        }
    }

    public void setRequestLatency(Long l) throws JSONException {
        if (l != null) {
            put(REQUEST_LATENCY, l.toString());
        }
    }

    public void setRequestMediaDuration(Long l) throws JSONException {
        if (l != null) {
            put(REQUEST_MEDIA_DURATION, l.toString());
        }
    }

    public void setRequestMediaStartTime(Long l) throws JSONException {
        if (l != null) {
            put(REQUEST_MEDIA_START_TIME, l.toString());
        }
    }

    public void setRequestRenditionLists(List<Rendition> list) throws JSONException {
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            for (Rendition rendition : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ViewProps.WIDTH, rendition.width);
                jSONObject2.put(ViewProps.HEIGHT, rendition.height);
                jSONObject2.put("bitrate", rendition.bitrate);
                jSONObject2.put("attrs", rendition.attrs);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put(LinkHeader.Parameters.Media, jSONArray);
            this.query.put(REQUEST_RENDITION_LISTS, jSONObject);
        }
    }

    public void setRequestResponseEnd(Long l) throws JSONException {
        if (l != null) {
            put(REQUEST_RESPONSE_END, l.toString());
        }
    }

    public void setRequestResponseHeaders(Hashtable<String, String> hashtable) throws JSONException {
        if (hashtable != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : hashtable.keySet()) {
                jSONObject.put(str.toLowerCase(Locale.ROOT), hashtable.get(str));
            }
            this.query.put(REQUEST_RESPONSE_HEADERS, jSONObject);
        }
    }

    public void setRequestResponseStart(Long l) throws JSONException {
        if (l != null) {
            put(REQUEST_RESPONSE_START, l.toString());
        }
    }

    public void setRequestStart(Long l) throws JSONException {
        if (l != null) {
            put(REQUEST_START, l.toString());
        }
    }

    public void setRequestThroughput(Long l) throws JSONException {
        if (l != null) {
            put(REQUEST_THROUGHPUT, l.toString());
        }
    }

    public void setRequestType(String str) throws JSONException {
        if (str != null) {
            put(REQUEST_TYPE, str);
        }
    }

    public void setRequestUrl(String str) throws JSONException {
        if (str != null) {
            put(REQUEST_URL, str);
        }
    }

    public void setRequestVideoHeight(Integer num) throws JSONException {
        if (num != null) {
            put(REQUEST_VIDEO_HEIGHT, num.toString());
        }
    }

    public void setRequestVideoWidth(Integer num) throws JSONException {
        if (num != null) {
            put(REQUEST_VIDEO_WIDTH, num.toString());
        }
    }

    @Override // com.mux.stats.sdk.core.model.BaseQueryData
    public void sync() {
    }
}
