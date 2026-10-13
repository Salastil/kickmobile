package com.reactnative.googlecast.types;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.cast.MediaQueueItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCMediaQueueItem {
    public static MediaQueueItem fromJson(ReadableMap readableMap) {
        MediaQueueItem.Builder builder;
        if (readableMap.hasKey("mediaInfo")) {
            builder = new MediaQueueItem.Builder(RNGCMediaInfo.fromJson(readableMap.getMap("mediaInfo")));
        } else {
            try {
                builder = new MediaQueueItem.Builder(new JSONObject());
            } catch (JSONException unused) {
                builder = new MediaQueueItem.Builder(RNGCMediaInfo.fromJson(readableMap));
            }
        }
        if (readableMap.hasKey("activeTrackIds") && readableMap.getArray("activeTrackIds") != null) {
            ReadableArray array = readableMap.getArray("activeTrackIds");
            long[] jArr = new long[array.size()];
            for (int i = 0; i < array.size(); i++) {
                jArr[i] = array.getInt(i);
            }
            builder.setActiveTrackIds(jArr);
        }
        if (readableMap.hasKey("autoplay")) {
            builder.setAutoplay(readableMap.getBoolean("autoplay"));
        }
        if (readableMap.hasKey("customData")) {
            builder.setCustomData(RNGCJSONObject.fromJson(readableMap.getMap("customData")));
        }
        if (readableMap.hasKey("playbackDuration")) {
            builder.setPlaybackDuration(readableMap.getDouble("playbackDuration"));
        }
        if (readableMap.hasKey("preloadTime")) {
            builder.setPreloadTime(readableMap.getDouble("preloadTime"));
        }
        if (readableMap.hasKey("startTime")) {
            builder.setStartTime(readableMap.getDouble("startTime"));
        }
        return builder.build();
    }

    public static WritableMap toJson(MediaQueueItem mediaQueueItem) {
        if (mediaQueueItem == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (mediaQueueItem.getActiveTrackIds() != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (long j : mediaQueueItem.getActiveTrackIds()) {
                writableArrayCreateArray.pushInt((int) j);
            }
            writableNativeMap.putArray("activeTrackIds", writableArrayCreateArray);
        }
        writableNativeMap.putBoolean("autoplay", mediaQueueItem.getAutoplay());
        writableNativeMap.putMap("customData", RNGCJSONObject.toJson(mediaQueueItem.getCustomData()));
        if (mediaQueueItem.getItemId() != 0) {
            writableNativeMap.putInt("itemId", mediaQueueItem.getItemId());
        }
        writableNativeMap.putMap("mediaInfo", RNGCMediaInfo.toJson(mediaQueueItem.getMedia()));
        if (mediaQueueItem.getPlaybackDuration() != Double.POSITIVE_INFINITY) {
            writableNativeMap.putDouble("playbackDuration", mediaQueueItem.getPlaybackDuration());
        }
        writableNativeMap.putDouble("preloadTime", mediaQueueItem.getPreloadTime());
        if (!Double.isNaN(mediaQueueItem.getStartTime())) {
            writableNativeMap.putDouble("startTime", mediaQueueItem.getStartTime());
        }
        return writableNativeMap;
    }
}
