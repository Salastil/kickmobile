package com.reactnative.googlecast.types;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCWebImage {
    public static WebImage fromJson(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        return new WebImage(new JSONObject(readableMap.toHashMap()));
    }

    public static WritableMap toJson(WebImage webImage) {
        if (webImage == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(ImagesContract.URL, webImage.getUrl().toString());
        writableNativeMap.putInt(ViewProps.HEIGHT, webImage.getHeight());
        writableNativeMap.putInt(ViewProps.WIDTH, webImage.getWidth());
        return writableNativeMap;
    }
}
