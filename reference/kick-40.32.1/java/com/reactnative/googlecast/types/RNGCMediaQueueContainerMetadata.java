package com.reactnative.googlecast.types;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueContainerMetadata;
import com.google.android.gms.common.images.WebImage;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCMediaQueueContainerMetadata {
    public static MediaQueueContainerMetadata fromJson(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        MediaQueueContainerMetadata.Builder builder = new MediaQueueContainerMetadata.Builder();
        if (readableMap.hasKey("containerDuration")) {
            builder.setContainerDuration(readableMap.getDouble("containerDuration"));
        }
        if (readableMap.hasKey("containerImages")) {
            ArrayList arrayList = new ArrayList();
            ReadableArray array = readableMap.getArray("containerImages");
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(RNGCWebImage.fromJson(array.getMap(i)));
            }
            builder.setContainerImages(arrayList);
        }
        if (readableMap.hasKey("containerType")) {
            builder.setContainerType(RNGCMediaQueueContainerType.fromJson(readableMap.getString("containerType")));
        }
        if (readableMap.hasKey("sections")) {
            ArrayList arrayList2 = new ArrayList();
            ReadableArray array2 = readableMap.getArray("sections");
            for (int i2 = 0; i2 < array2.size(); i2++) {
                arrayList2.add(RNGCMediaMetadata.fromJson(array2.getMap(i2)));
            }
            builder.setSections(arrayList2);
        }
        if (readableMap.hasKey("title")) {
            builder.setTitle(readableMap.getString("title"));
        }
        return builder.build();
    }

    public static WritableMap toJson(MediaQueueContainerMetadata mediaQueueContainerMetadata) {
        if (mediaQueueContainerMetadata == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("containerDuration", mediaQueueContainerMetadata.getContainerDuration());
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (mediaQueueContainerMetadata.getContainerImages() != null) {
            Iterator<WebImage> it = mediaQueueContainerMetadata.getContainerImages().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(RNGCWebImage.toJson(it.next()));
            }
        }
        writableNativeMap.putArray("containerImages", writableArrayCreateArray);
        writableNativeMap.putString("containerType", RNGCMediaQueueContainerType.toJson(mediaQueueContainerMetadata.getContainerType()));
        WritableArray writableArrayCreateArray2 = Arguments.createArray();
        if (mediaQueueContainerMetadata.getSections() != null) {
            Iterator<MediaMetadata> it2 = mediaQueueContainerMetadata.getSections().iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray2.pushMap(RNGCMediaMetadata.toJson(it2.next()));
            }
        }
        writableNativeMap.putArray("sections", writableArrayCreateArray2);
        writableNativeMap.putString("title", mediaQueueContainerMetadata.getTitle());
        return writableNativeMap;
    }
}
