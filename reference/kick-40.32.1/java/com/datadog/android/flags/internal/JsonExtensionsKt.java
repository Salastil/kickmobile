package com.datadog.android.flags.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0006H\u0000\u001a\u001a\u0010\u0007\u001a\u00020\b*\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0000\u001a\u0014\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006*\u00020\u0005H\u0000\u001a\u001a\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t*\u00020\nH\u0000\u001a\u001a\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t*\u00020\bH\u0000¨\u0006\r"}, d2 = {"convertJsonValue", "", "value", "convertToJsonValue", "toJSONArray", "Lorg/json/JSONArray;", "", "toJSONObject", "Lorg/json/JSONObject;", "", "", "toList", "toMap", "dd-sdk-android-flags_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonExtensionsKt {
    public static final Map<String, Object> toMap(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toMap(new JSONObject(str));
    }

    public static final Map<String, Object> toMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            linkedHashMap.put(key, convertJsonValue(jSONObject.get(key)));
        }
        return linkedHashMap;
    }

    public static final List<Object> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(convertJsonValue(jSONArray.get(i)));
        }
        return arrayList;
    }

    public static final JSONObject toJSONObject(Map<String, ? extends Object> map) throws JSONException {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), convertToJsonValue(entry.getValue()));
        }
        return jSONObject;
    }

    public static final JSONArray toJSONArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(convertToJsonValue(it.next()));
        }
        return jSONArray;
    }

    private static final Object convertToJsonValue(Object obj) {
        if (obj == null) {
            Object NULL = JSONObject.NULL;
            Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
            return NULL;
        }
        if (!(obj instanceof Map)) {
            return obj instanceof List ? toJSONArray((List) obj) : obj;
        }
        Set<Map.Entry> setEntrySet = ((Map) obj).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Pair pair = TuplesKt.to(String.valueOf(entry.getKey()), entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return toJSONObject(linkedHashMap);
    }

    private static final Object convertJsonValue(Object obj) {
        if (Intrinsics.areEqual(obj, JSONObject.NULL)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return toMap((JSONObject) obj);
        }
        return obj instanceof JSONArray ? toList((JSONArray) obj) : obj;
    }
}
