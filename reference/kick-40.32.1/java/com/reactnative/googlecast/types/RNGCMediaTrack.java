package com.reactnative.googlecast.types;

import com.datadog.trace.api.DDTags;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.cast.MediaTrack;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCMediaTrack {
    public static MediaTrack fromJson(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        MediaTrack.Builder builder = new MediaTrack.Builder(readableMap.getInt("id"), RNGCMediaTrackType.fromJson(readableMap.getString("type")));
        if (readableMap.hasKey("contentId")) {
            builder.setContentId(readableMap.getString("contentId"));
        }
        if (readableMap.hasKey("contentType")) {
            builder.setContentType(readableMap.getString("contentType"));
        }
        if (readableMap.hasKey("customData")) {
            builder.setCustomData(new JSONObject(readableMap.getMap("customData").toHashMap()));
        }
        if (readableMap.hasKey(DDTags.LANGUAGE_TAG_KEY)) {
            builder.setLanguage(readableMap.getString(DDTags.LANGUAGE_TAG_KEY));
        }
        if (readableMap.hasKey("name")) {
            builder.setName(readableMap.getString("name"));
        }
        if (readableMap.hasKey("subtype")) {
            builder.setSubtype(RNGCMediaTextTrackSubtype.fromJson(readableMap.getString("subtype")));
        }
        return builder.build();
    }

    public static WritableMap toJson(MediaTrack mediaTrack) {
        if (mediaTrack == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("id", (int) mediaTrack.getId());
        writableNativeMap.putString("contentId", mediaTrack.getContentId());
        writableNativeMap.putString("contentType", mediaTrack.getContentType());
        writableNativeMap.putMap("customData", RNGCJSONObject.toJson(mediaTrack.getCustomData()));
        writableNativeMap.putString(DDTags.LANGUAGE_TAG_KEY, mediaTrack.getLanguage());
        writableNativeMap.putString("name", mediaTrack.getName());
        writableNativeMap.putString("type", RNGCMediaTrackType.toJson(mediaTrack.getType()));
        writableNativeMap.putString("subtype", RNGCMediaTextTrackSubtype.toJson(mediaTrack.getSubtype()));
        return writableNativeMap;
    }
}
