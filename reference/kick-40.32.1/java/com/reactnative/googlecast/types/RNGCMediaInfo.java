package com.reactnative.googlecast.types;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaInfo {
    public static MediaInfo fromJson(ReadableMap readableMap) {
        String string;
        if (readableMap == null) {
            return null;
        }
        if (readableMap.hasKey("contentId")) {
            string = readableMap.getString("contentId");
        } else {
            string = readableMap.getString("contentUrl");
        }
        MediaInfo.Builder builder = new MediaInfo.Builder(string);
        if (readableMap.hasKey("contentType")) {
            builder.setContentType(readableMap.getString("contentType"));
        }
        if (readableMap.hasKey("contentUrl")) {
            builder.setContentUrl(readableMap.getString("contentUrl"));
        }
        if (readableMap.hasKey("customData")) {
            builder.setCustomData(RNGCJSONObject.fromJson(readableMap.getMap("customData")));
        }
        if (readableMap.hasKey("hlsSegmentFormat")) {
            builder.setHlsSegmentFormat(RNGCHlsSegmentFormat.fromJson(readableMap.getString("hlsSegmentFormat")));
        }
        if (readableMap.hasKey("hlsVideoSegmentFormat")) {
            builder.setHlsVideoSegmentFormat(RNGCHlsVideoSegmentFormat.fromJson(readableMap.getString("hlsVideoSegmentFormat")));
        }
        if (readableMap.hasKey("entity")) {
            builder.setEntity(readableMap.getString("entity"));
        }
        if (readableMap.hasKey("mediaTracks")) {
            ArrayList arrayList = new ArrayList();
            ReadableArray array = readableMap.getArray("mediaTracks");
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(RNGCMediaTrack.fromJson(array.getMap(i)));
            }
            builder.setMediaTracks(arrayList);
        }
        if (readableMap.hasKey("metadata")) {
            builder.setMetadata(RNGCMediaMetadata.fromJson(readableMap.getMap("metadata")));
        }
        if (readableMap.hasKey("streamDuration")) {
            builder.setStreamDuration(Math.round(readableMap.getDouble("streamDuration") * 1000.0d));
        }
        if (readableMap.hasKey("streamType")) {
            builder.setStreamType(RNGCMediaStreamType.fromJson(readableMap.getString("streamType")));
        }
        if (readableMap.hasKey("textTrackStyle")) {
            builder.setTextTrackStyle(RNGCTextTrackStyle.fromJson(readableMap.getMap("textTrackStyle")));
        }
        return builder.build();
    }

    public static WritableMap toJson(MediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("contentId", mediaInfo.getContentId());
        writableNativeMap.putString("contentType", mediaInfo.getContentType());
        writableNativeMap.putString("contentUrl", mediaInfo.getContentUrl());
        writableNativeMap.putMap("customData", RNGCJSONObject.toJson(mediaInfo.getCustomData()));
        writableNativeMap.putString("hlsSegmentFormat", RNGCHlsSegmentFormat.toJson(mediaInfo.getHlsSegmentFormat()));
        writableNativeMap.putString("hlsVideoSegmentFormat", RNGCHlsVideoSegmentFormat.toJson(mediaInfo.getHlsVideoSegmentFormat()));
        writableNativeMap.putString("entity", mediaInfo.getEntity());
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (mediaInfo.getMediaTracks() != null) {
            Iterator<MediaTrack> it = mediaInfo.getMediaTracks().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(RNGCMediaTrack.toJson(it.next()));
            }
        }
        writableNativeMap.putArray("mediaTracks", writableArrayCreateArray);
        writableNativeMap.putMap("metadata", RNGCMediaMetadata.toJson(mediaInfo.getMetadata()));
        if (mediaInfo.getStreamDuration() != -1) {
            writableNativeMap.putDouble("streamDuration", mediaInfo.getStreamDuration() / 1000.0d);
        }
        writableNativeMap.putString("streamType", RNGCMediaStreamType.toJson(mediaInfo.getStreamType()));
        writableNativeMap.putMap("textTrackStyle", RNGCTextTrackStyle.toJson(mediaInfo.getTextTrackStyle()));
        return writableNativeMap;
    }
}
