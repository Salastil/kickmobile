package com.reactnative.googlecast.types;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.images.WebImage;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCDevice {
    @Nullable
    public static WritableMap toJson(@Nullable CastDevice castDevice) {
        if (castDevice == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (castDevice.hasCapability(8)) {
            writableNativeArray.pushString("AudioIn");
        }
        if (castDevice.hasCapability(4)) {
            writableNativeArray.pushString("AudioOut");
        }
        if (castDevice.hasCapability(2)) {
            writableNativeArray.pushString("VideoIn");
        }
        if (castDevice.hasCapability(1)) {
            writableNativeArray.pushString("VideoOut");
        }
        if (castDevice.hasCapability(32)) {
            writableNativeArray.pushString("MultizoneGroup");
        }
        writableNativeMap.putArray("capabilities", writableNativeArray);
        writableNativeMap.putString("deviceId", castDevice.getDeviceId());
        writableNativeMap.putString("deviceVersion", castDevice.getDeviceVersion());
        writableNativeMap.putString("friendlyName", castDevice.getFriendlyName());
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (castDevice.getIcons() != null) {
            Iterator<WebImage> it = castDevice.getIcons().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(RNGCWebImage.toJson(it.next()));
            }
        }
        writableNativeMap.putArray("icons", writableArrayCreateArray);
        writableNativeMap.putString("ipAddress", castDevice.getInetAddress().toString());
        writableNativeMap.putBoolean("isOnLocalNetwork", castDevice.isOnLocalNetwork());
        writableNativeMap.putString("modelName", castDevice.getModelName());
        return writableNativeMap;
    }
}
