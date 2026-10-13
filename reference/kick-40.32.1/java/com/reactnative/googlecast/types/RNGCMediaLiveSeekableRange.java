package com.reactnative.googlecast.types;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.cast.MediaLiveSeekableRange;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCMediaLiveSeekableRange {
    public static WritableMap toJson(MediaLiveSeekableRange mediaLiveSeekableRange) {
        if (mediaLiveSeekableRange == null) {
            return null;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("endTime", mediaLiveSeekableRange.getEndTime() / 1000.0d);
        writableMapCreateMap.putDouble("startTime", mediaLiveSeekableRange.getStartTime() / 1000.0d);
        writableMapCreateMap.putBoolean("isLiveDone", mediaLiveSeekableRange.isLiveDone());
        writableMapCreateMap.putBoolean("isMovingWindow", mediaLiveSeekableRange.isMovingWindow());
        return writableMapCreateMap;
    }
}
