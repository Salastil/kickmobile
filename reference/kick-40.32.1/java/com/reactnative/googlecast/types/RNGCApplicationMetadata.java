package com.reactnative.googlecast.types;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.images.WebImage;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCApplicationMetadata {
    public static WritableMap toJson(ApplicationMetadata applicationMetadata) {
        if (applicationMetadata == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("applicationId", applicationMetadata.getApplicationId());
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (applicationMetadata.getImages() != null) {
            Iterator<WebImage> it = applicationMetadata.getImages().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(RNGCWebImage.toJson(it.next()));
            }
        }
        writableNativeMap.putArray("images", writableArrayCreateArray);
        writableNativeMap.putString("name", applicationMetadata.getName());
        WritableArray writableArrayCreateArray2 = Arguments.createArray();
        if (applicationMetadata.getSupportedNamespaces() != null) {
            Iterator<String> it2 = applicationMetadata.getSupportedNamespaces().iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray2.pushString(it2.next());
            }
        }
        writableNativeMap.putArray("namespaces", writableArrayCreateArray2);
        return writableNativeMap;
    }
}
