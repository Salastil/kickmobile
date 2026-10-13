package com.reactnative.googlecast.types;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.VideoInfo;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCVideoInfo {
    public static WritableMap toJson(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("hdrType", RNGCVideoInfoHDRType.toJson(videoInfo.getHdrType()));
        writableNativeMap.putInt(ViewProps.HEIGHT, videoInfo.getHeight());
        writableNativeMap.putInt(ViewProps.WIDTH, videoInfo.getWidth());
        return writableNativeMap;
    }
}
