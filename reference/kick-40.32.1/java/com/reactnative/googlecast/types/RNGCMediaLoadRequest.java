package com.reactnative.googlecast.types;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.cast.MediaLoadRequestData;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCMediaLoadRequest {
    public static MediaLoadRequestData fromJson(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
        if (readableMap.hasKey("autoplay")) {
            builder.setAutoplay(Boolean.valueOf(readableMap.getBoolean("autoplay")));
        }
        if (readableMap.hasKey("credentials")) {
            builder.setCredentials(readableMap.getString("credentials"));
        }
        if (readableMap.hasKey("credentialsType")) {
            builder.setCredentialsType(readableMap.getString("credentialsType"));
        }
        if (readableMap.hasKey("customData") && !readableMap.isNull("customData")) {
            builder.setCustomData(RNGCJSONObject.fromJson(readableMap.getMap("customData")));
        }
        if (readableMap.hasKey("mediaInfo")) {
            builder.setMediaInfo(RNGCMediaInfo.fromJson(readableMap.getMap("mediaInfo")));
        }
        if (readableMap.hasKey("playbackRate")) {
            builder.setPlaybackRate(readableMap.getDouble("playbackRate"));
        }
        if (readableMap.hasKey("queueData")) {
            builder.setQueueData(RNGCMediaQueueData.fromJson(readableMap.getMap("queueData")));
        }
        if (readableMap.hasKey("startTime")) {
            builder.setCurrentTime(Math.round(readableMap.getDouble("startTime") * 1000.0d));
        }
        return builder.build();
    }
}
