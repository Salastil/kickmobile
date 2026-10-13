package com.reactnative.googlecast.types;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCMediaStatus {
    public static WritableMap toJson(MediaStatus mediaStatus) {
        if (mediaStatus == null) {
            return null;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (mediaStatus.getActiveTrackIds() != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (long j : mediaStatus.getActiveTrackIds()) {
                writableArrayCreateArray.pushInt((int) j);
            }
            writableMapCreateMap.putArray("activeTrackIds", writableArrayCreateArray);
        }
        writableMapCreateMap.putInt("currentItemId", mediaStatus.getCurrentItemId());
        writableMapCreateMap.putMap("currentQueueItem", RNGCMediaQueueItem.toJson(mediaStatus.getQueueItemById(mediaStatus.getCurrentItemId())));
        writableMapCreateMap.putMap("customData", RNGCJSONObject.toJson(mediaStatus.getCustomData()));
        writableMapCreateMap.putString("idleReason", RNGCMediaPlayerIdleReason.toJson(mediaStatus.getIdleReason()));
        writableMapCreateMap.putBoolean("isMuted", mediaStatus.isMute());
        if (mediaStatus.getLiveSeekableRange() != null) {
            writableMapCreateMap.putMap("liveSeekableRange", RNGCMediaLiveSeekableRange.toJson(mediaStatus.getLiveSeekableRange()));
        }
        if (mediaStatus.getLoadingItemId() != 0) {
            writableMapCreateMap.putInt("loadingItemId", mediaStatus.getLoadingItemId());
        }
        writableMapCreateMap.putMap("mediaInfo", RNGCMediaInfo.toJson(mediaStatus.getMediaInfo()));
        writableMapCreateMap.putDouble("playbackRate", mediaStatus.getPlaybackRate());
        writableMapCreateMap.putString("playerState", RNGCPlayerState.toJson(mediaStatus.getPlayerState()));
        if (mediaStatus.getPreloadedItemId() != 0) {
            writableMapCreateMap.putInt("preloadedItemId", mediaStatus.getPreloadedItemId());
        }
        WritableArray writableArrayCreateArray2 = Arguments.createArray();
        if (mediaStatus.getQueueItems() != null) {
            Iterator<MediaQueueItem> it = mediaStatus.getQueueItems().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray2.pushMap(RNGCMediaQueueItem.toJson(it.next()));
            }
        }
        writableMapCreateMap.putArray("queueItems", writableArrayCreateArray2);
        writableMapCreateMap.putString("queueRepeatMode", RNGCMediaRepeatMode.toJson(mediaStatus.getQueueRepeatMode()));
        writableMapCreateMap.putDouble("streamPosition", mediaStatus.getStreamPosition() / 1000.0d);
        writableMapCreateMap.putMap("videoInfo", RNGCVideoInfo.toJson(mediaStatus.getVideoInfo()));
        writableMapCreateMap.putDouble(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, mediaStatus.getStreamVolume());
        return writableMapCreateMap;
    }
}
