package com.reactnative.googlecast.types;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.TextTrackStyle;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCTextTrackStyle {
    public static TextTrackStyle fromJson(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (readableMap.hasKey(ViewProps.BACKGROUND_COLOR)) {
            textTrackStyle.setBackgroundColor(RNGCColor.fromJson(readableMap.getString(ViewProps.BACKGROUND_COLOR)));
        }
        if (readableMap.hasKey("customData")) {
            textTrackStyle.setCustomData(RNGCJSONObject.fromJson(readableMap.getMap("customData")));
        }
        if (readableMap.hasKey("edgeColor")) {
            textTrackStyle.setEdgeColor(RNGCColor.fromJson(readableMap.getString("edgeColor")));
        }
        if (readableMap.hasKey("edgeType")) {
            textTrackStyle.setEdgeType(RNGCTextTrackStyleEdgeType.fromJson(readableMap.getString("edgeType")));
        }
        if (readableMap.hasKey(ViewProps.FONT_FAMILY)) {
            textTrackStyle.setFontFamily(readableMap.getString(ViewProps.FONT_FAMILY));
        }
        if (readableMap.hasKey("fontGenericFamily")) {
            textTrackStyle.setFontGenericFamily(RNGCTextTrackStyleFontGenericFamily.fromJson(readableMap.getString("fontGenericFamily")));
        }
        if (readableMap.hasKey("fontScale")) {
            textTrackStyle.setFontScale((float) readableMap.getDouble("fontScale"));
        }
        if (readableMap.hasKey(ViewProps.FOREGROUND_COLOR)) {
            textTrackStyle.setForegroundColor(RNGCColor.fromJson(readableMap.getString(ViewProps.FOREGROUND_COLOR)));
        }
        if (readableMap.hasKey("windowColor")) {
            textTrackStyle.setWindowColor(RNGCColor.fromJson(readableMap.getString("windowColor")));
        }
        if (readableMap.hasKey("windowCornerRadius")) {
            textTrackStyle.setWindowCornerRadius(readableMap.getInt("windowCornerRadius"));
        }
        if (readableMap.hasKey("windowType")) {
            textTrackStyle.setWindowType(RNGCTextTrackStyleWindowType.fromJson(readableMap.getString("windowType")));
        }
        return textTrackStyle;
    }

    public static WritableMap toJson(TextTrackStyle textTrackStyle) {
        if (textTrackStyle == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(ViewProps.BACKGROUND_COLOR, RNGCColor.toJson(textTrackStyle.getBackgroundColor()));
        writableNativeMap.putMap("customData", RNGCJSONObject.toJson(textTrackStyle.getCustomData()));
        writableNativeMap.putString("edgeColor", RNGCColor.toJson(textTrackStyle.getEdgeColor()));
        writableNativeMap.putString("edgeType", RNGCTextTrackStyleEdgeType.toJson(textTrackStyle.getEdgeType()));
        writableNativeMap.putString(ViewProps.FONT_FAMILY, textTrackStyle.getFontFamily());
        writableNativeMap.putString("fontGenericFamily", RNGCTextTrackStyleFontGenericFamily.toJson(textTrackStyle.getFontGenericFamily()));
        writableNativeMap.putDouble("fontScale", textTrackStyle.getFontScale());
        writableNativeMap.putString(ViewProps.FOREGROUND_COLOR, RNGCColor.toJson(textTrackStyle.getForegroundColor()));
        writableNativeMap.putString("windowColor", RNGCColor.toJson(textTrackStyle.getWindowColor()));
        writableNativeMap.putInt("windowCornerRadius", textTrackStyle.getWindowCornerRadius());
        writableNativeMap.putString("windowType", RNGCTextTrackStyleWindowType.toJson(textTrackStyle.getWindowType()));
        return writableNativeMap;
    }
}
