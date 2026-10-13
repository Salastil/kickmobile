package com.reactnative.googlecast.types;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.cast.MediaQueueData;
import com.google.android.gms.cast.MediaQueueItem;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaQueueData {
    public static MediaQueueData fromJson(ReadableMap readableMap) {
        MediaQueueData.Builder builder = new MediaQueueData.Builder();
        if (readableMap.hasKey("containerMetadata")) {
            builder.setContainerMetadata(RNGCMediaQueueContainerMetadata.fromJson(readableMap.getMap("containerMetadata")));
        }
        if (readableMap.hasKey("entity")) {
            builder.setEntity(readableMap.getString("entity"));
        }
        if (readableMap.hasKey("id")) {
            builder.setQueueId(readableMap.getString("id"));
        }
        if (readableMap.hasKey("items")) {
            ArrayList arrayList = new ArrayList();
            ReadableArray array = readableMap.getArray("items");
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(RNGCMediaQueueItem.fromJson(array.getMap(i)));
            }
            builder.setItems(arrayList);
        }
        if (readableMap.hasKey("name")) {
            builder.setName(readableMap.getString("name"));
        }
        if (readableMap.hasKey("repeatMode")) {
            builder.setRepeatMode(RNGCMediaRepeatMode.fromJson(readableMap.getString("repeatMode")));
        }
        if (readableMap.hasKey("startIndex")) {
            builder.setStartIndex(readableMap.getInt("startIndex"));
        }
        if (readableMap.hasKey("startTime")) {
            builder.setStartTime(Math.round(readableMap.getDouble("startTime") * 1000.0d));
        }
        if (readableMap.hasKey("type")) {
            builder.setQueueType(RNGCMediaQueueType.fromJson(readableMap.getString("type")));
        }
        return builder.build();
    }

    public static WritableMap toJson(MediaQueueData mediaQueueData) {
        if (mediaQueueData == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("containerMetadata", RNGCMediaQueueContainerMetadata.toJson(mediaQueueData.getContainerMetadata()));
        writableNativeMap.putString("entity", mediaQueueData.getEntity());
        writableNativeMap.putString("id", mediaQueueData.getQueueId());
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (mediaQueueData.getItems() != null) {
            Iterator<MediaQueueItem> it = mediaQueueData.getItems().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(RNGCMediaQueueItem.toJson(it.next()));
            }
        }
        writableNativeMap.putArray("items", writableArrayCreateArray);
        writableNativeMap.putString("name", mediaQueueData.getName());
        writableNativeMap.putString("repeatMode", RNGCMediaRepeatMode.toJson(mediaQueueData.getRepeatMode()));
        writableNativeMap.putString("type", RNGCMediaQueueType.toJson(mediaQueueData.getQueueType()));
        return writableNativeMap;
    }
}
