package com.datadog.reactnative;

import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DdSdkBridgeExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0005*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\bH\u0000\u001a0\u0010\u0007\u001a\u00020\u0005*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000\u001a\u0018\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b*\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0002*\u00020\u000eH\u0000\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\f2\u0006\u0010\u0011\u001a\u00020\nH\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\f2\u0006\u0010\u0011\u001a\u00020\nH\u0000¢\u0006\u0002\u0010\u0015\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0016H\u0000\u001a\u001a\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b*\u00020\u0016H\u0000\u001a\u0014\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0002*\u00020\u0017H\u0000\u001a\f\u0010\u0018\u001a\u00020\u0016*\u00020\fH\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0016*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bH\u0000\u001a\u0010\u0010\u0019\u001a\u00020\u0017*\u0006\u0012\u0002\b\u00030\u0002H\u0000¨\u0006\u001a"}, d2 = {"toWritableArray", "Lcom/facebook/react/bridge/WritableArray;", "", "createWritableMap", "Lkotlin/Function0;", "Lcom/facebook/react/bridge/WritableMap;", "createWritableArray", "toWritableMap", "", "toMap", "", "", "Lcom/facebook/react/bridge/ReadableMap;", "toList", "Lcom/facebook/react/bridge/ReadableArray;", "getBooleanOrNull", "", "key", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)Ljava/lang/Boolean;", "getDoubleOrNull", "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)Ljava/lang/Double;", "Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "toJSONObject", "toJSONArray", "datadog_mobile-react-native_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DdSdkBridgeExtKt {

    /* JADX INFO: compiled from: DdSdkBridgeExt.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Map.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Null.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final WritableArray toWritableArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return toWritableArray(list, new Function0() { // from class: com.datadog.reactnative.DdSdkBridgeExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DdSdkBridgeExtKt.toWritableArray$lambda$0();
            }
        }, new Function0() { // from class: com.datadog.reactnative.DdSdkBridgeExtKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DdSdkBridgeExtKt.toWritableArray$lambda$1();
            }
        });
    }

    static final WritableMap toWritableArray$lambda$0() {
        return new WritableNativeMap();
    }

    static final WritableArray toWritableArray$lambda$1() {
        return new WritableNativeArray();
    }

    public static final WritableArray toWritableArray(List<?> list, Function0<? extends WritableMap> createWritableMap, Function0<? extends WritableArray> createWritableArray) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(createWritableMap, "createWritableMap");
        Intrinsics.checkNotNullParameter(createWritableArray, "createWritableArray");
        WritableArray writableArrayInvoke = createWritableArray.invoke();
        for (Object obj : list) {
            if (obj == null) {
                writableArrayInvoke.pushNull();
            } else if (obj instanceof Integer) {
                writableArrayInvoke.pushInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                writableArrayInvoke.pushDouble(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                writableArrayInvoke.pushDouble(((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                writableArrayInvoke.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                writableArrayInvoke.pushString((String) obj);
            } else if (obj instanceof Boolean) {
                writableArrayInvoke.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof List) {
                writableArrayInvoke.pushArray(toWritableArray((List) obj, createWritableMap, createWritableArray));
            } else if (obj instanceof Map) {
                writableArrayInvoke.pushMap(toWritableMap((Map) obj, createWritableMap, createWritableArray));
            } else {
                Log.e(list.getClass().getSimpleName(), "toWritableArray(): Unhandled type " + obj.getClass().getSimpleName() + " has been ignored");
            }
        }
        return writableArrayInvoke;
    }

    public static final WritableMap toWritableMap(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return toWritableMap(map, new Function0() { // from class: com.datadog.reactnative.DdSdkBridgeExtKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DdSdkBridgeExtKt.toWritableMap$lambda$0();
            }
        }, new Function0() { // from class: com.datadog.reactnative.DdSdkBridgeExtKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DdSdkBridgeExtKt.toWritableMap$lambda$1();
            }
        });
    }

    static final WritableMap toWritableMap$lambda$0() {
        return new WritableNativeMap();
    }

    static final WritableArray toWritableMap$lambda$1() {
        return new WritableNativeArray();
    }

    public static final WritableMap toWritableMap(Map<?, ?> map, Function0<? extends WritableMap> createWritableMap, Function0<? extends WritableArray> createWritableArray) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(createWritableMap, "createWritableMap");
        Intrinsics.checkNotNullParameter(createWritableArray, "createWritableArray");
        WritableMap writableMapInvoke = createWritableMap.invoke();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            String strValueOf = key instanceof String ? (String) key : null;
            if (strValueOf == null) {
                strValueOf = String.valueOf(key);
            }
            if (value == null) {
                writableMapInvoke.putNull(strValueOf);
            } else if (value instanceof Integer) {
                writableMapInvoke.putInt(strValueOf, ((Number) value).intValue());
            } else if (value instanceof Long) {
                writableMapInvoke.putDouble(strValueOf, ((Number) value).longValue());
            } else if (value instanceof Float) {
                writableMapInvoke.putDouble(strValueOf, ((Number) value).floatValue());
            } else if (value instanceof Double) {
                writableMapInvoke.putDouble(strValueOf, ((Number) value).doubleValue());
            } else if (value instanceof String) {
                writableMapInvoke.putString(strValueOf, (String) value);
            } else if (value instanceof Boolean) {
                writableMapInvoke.putBoolean(strValueOf, ((Boolean) value).booleanValue());
            } else if (value instanceof List) {
                writableMapInvoke.putArray(strValueOf, toWritableArray((List) value, createWritableMap, createWritableArray));
            } else if (value instanceof Map) {
                writableMapInvoke.putMap(strValueOf, toWritableMap((Map) value, createWritableMap, createWritableArray));
            } else {
                Log.e(map.getClass().getSimpleName(), "toWritableMap(): Unhandled type " + value.getClass().getSimpleName() + " has been ignored");
            }
        }
        return writableMapInvoke;
    }

    public static final Map<String, Object> toMap(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        HashMap<String, Object> hashMap = readableMap.toHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            Intrinsics.checkNotNull(value);
            linkedHashMap3.put(key, value);
        }
        HashMap map = (HashMap) MapsKt.toMap(linkedHashMap3, new HashMap());
        for (Object obj : map.keySet()) {
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            String str = (String) obj;
            try {
                ReadableType type = readableMap.getType(str);
                switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        ReadableMap map2 = readableMap.getMap(str);
                        toMap$updateMap(map, readableMap, str, map2 != null ? toMap(map2) : null);
                        break;
                    case 2:
                        ReadableArray array = readableMap.getArray(str);
                        toMap$updateMap(map, readableMap, str, array != null ? toList(array) : null);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        break;
                    default:
                        map.remove(str);
                        Log.e(readableMap.getClass().getSimpleName(), "toMap(): Skipping unhandled type [" + type.name() + "] for key: " + str);
                        break;
                }
            } catch (IllegalArgumentException e) {
                map.remove(str);
                Log.e(readableMap.getClass().getSimpleName(), "toMap(): Could not convert object for key: " + str, e);
            }
        }
        return map;
    }

    private static final void toMap$updateMap(HashMap<String, Object> map, ReadableMap readableMap, String str, Object obj) {
        if (obj != null) {
            map.put(str, obj);
            return;
        }
        map.remove(str);
        Log.e(readableMap.getClass().getSimpleName(), "toMap(): Cannot convert nested object for key: " + str);
    }

    public static final List<?> toList(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            try {
                ReadableType type = readableArray.getType(i);
                switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        WritableMap map = readableArray.getMap(i);
                        if (map == null) {
                            map = Arguments.createMap();
                        }
                        arrayList.add(toMap(map));
                        break;
                    case 2:
                        WritableArray array = readableArray.getArray(i);
                        if (array == null) {
                            array = Arguments.createArray();
                        }
                        arrayList.add(toList(array));
                        break;
                    case 3:
                        arrayList.add(null);
                        break;
                    case 4:
                        arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
                        break;
                    case 5:
                        arrayList.add(Double.valueOf(readableArray.getDouble(i)));
                        break;
                    case 6:
                        arrayList.add(readableArray.getString(i));
                        break;
                    default:
                        Log.e(readableArray.getClass().getSimpleName(), "toList(): Unhandled ReadableType: " + type.name() + ".");
                        break;
                }
            } catch (NullPointerException e) {
                Log.e(readableArray.getClass().getSimpleName(), "toList(): Could not convert object at index: " + i + ".", e);
            }
        }
        return arrayList;
    }

    public static final Boolean getBooleanOrNull(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (readableMap.hasKey(key)) {
            return Boolean.valueOf(readableMap.getBoolean(key));
        }
        return null;
    }

    public static final Double getDoubleOrNull(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (readableMap.hasKey(key)) {
            return Double.valueOf(readableMap.getDouble(key));
        }
        return null;
    }

    public static final WritableMap toWritableMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return toWritableMap(toMap(jSONObject));
    }

    public static final Map<String, Object> toMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt == null || Intrinsics.areEqual(objOpt, JSONObject.NULL)) {
                objOpt = null;
            } else if (objOpt instanceof JSONObject) {
                objOpt = toMap((JSONObject) objOpt);
            } else if (objOpt instanceof JSONArray) {
                objOpt = toList((JSONArray) objOpt);
            }
            linkedHashMap.put(next, objOpt);
        }
        return linkedHashMap;
    }

    public static final List<Object> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object objOpt = jSONArray.opt(i);
            if (objOpt == null || Intrinsics.areEqual(objOpt, JSONObject.NULL)) {
                objOpt = null;
            } else if (objOpt instanceof JSONObject) {
                objOpt = toMap((JSONObject) objOpt);
            } else if (objOpt instanceof JSONArray) {
                objOpt = toList((JSONArray) objOpt);
            }
            arrayList.add(objOpt);
        }
        return arrayList;
    }

    public static final JSONObject toJSONObject(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "<this>");
        return toJSONObject((Map<String, ? extends Object>) toMap(readableMap));
    }

    public static final JSONObject toJSONObject(Map<String, ? extends Object> map) throws JSONException {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                value = toJSONObject((Map<String, ? extends Object>) value);
            } else if (value instanceof List) {
                value = toJSONArray((List) value);
            }
            jSONObject.put(key, value);
        }
        return jSONObject;
    }

    public static final JSONArray toJSONArray(List<?> list) throws JSONException {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (Object jSONArray2 : list) {
            if (jSONArray2 instanceof Map) {
                Intrinsics.checkNotNull(jSONArray2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                jSONArray2 = toJSONObject((Map<String, ? extends Object>) jSONArray2);
            } else if (jSONArray2 instanceof List) {
                jSONArray2 = toJSONArray((List) jSONArray2);
            }
            jSONArray.put(jSONArray2);
        }
        return jSONArray;
    }
}
