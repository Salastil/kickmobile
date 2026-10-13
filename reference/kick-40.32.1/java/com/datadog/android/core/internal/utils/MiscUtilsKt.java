package com.datadog.android.core.internal.utils;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.thread.ThreadExtKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MiscUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0000\u001a\u001a\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b*\u00020\u000eH\u0000\u001a\u0010\u0010\u000f\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\rH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\u0012H\u0000\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0013H\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0011*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000bH\u0000\u001a\f\u0010\u0014\u001a\u00020\u0011*\u00020\u0015H\u0000¨\u0006\u0016"}, d2 = {"retryWithDelay", "", "times", "", "retryDelayNs", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "block", "Lkotlin/Function0;", "asDeepMap", "", "", "", "Lcom/google/gson/JsonObject;", "fromJsonElement", "toJsonArray", "Lcom/google/gson/JsonElement;", "", "Lorg/json/JSONArray;", "toJsonObject", "Lorg/json/JSONObject;", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MiscUtilsKt {
    public static final boolean retryWithDelay(int i, long j, InternalLogger internalLogger, Function0<Boolean> block) {
        InternalLogger internalLogger2 = internalLogger;
        Intrinsics.checkNotNullParameter(internalLogger2, "internalLogger");
        Intrinsics.checkNotNullParameter(block, "block");
        int i2 = 0;
        while (i2 < i) {
            if (i2 > 0) {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                if (ThreadExtKt.sleepSafe((j / 1000000) + 1, internalLogger2)) {
                    return false;
                }
            }
            try {
                if (block.invoke().booleanValue()) {
                    return true;
                }
                i2++;
                internalLogger2 = internalLogger;
            } catch (Exception e) {
                InternalLogger.DefaultImpls.log$default(internalLogger2, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.MiscUtilsKt$retryWithDelay$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Internal I/O operation failed";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
        }
        return false;
    }

    public static final Object fromJsonElement(Object obj) {
        if (obj instanceof JsonNull) {
            return null;
        }
        if (!(obj instanceof JsonPrimitive)) {
            return obj instanceof JsonObject ? asDeepMap((JsonObject) obj) : obj;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (jsonPrimitive.isBoolean()) {
            return Boolean.valueOf(jsonPrimitive.getAsBoolean());
        }
        if (jsonPrimitive.isNumber()) {
            return jsonPrimitive.getAsNumber();
        }
        return jsonPrimitive.isString() ? jsonPrimitive.getAsString() : obj;
    }

    public static final JsonElement toJsonArray(Iterable<?> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        JsonArray jsonArray = new JsonArray();
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            jsonArray.add(JsonSerializer.INSTANCE.toJsonElement(it.next()));
        }
        return jsonArray;
    }

    public static final JsonElement toJsonObject(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            jsonObject.add(String.valueOf(entry.getKey()), JsonSerializer.INSTANCE.toJsonElement(entry.getValue()));
        }
        return jsonObject;
    }

    public static final JsonElement toJsonObject(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JsonObject jsonObject = new JsonObject();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys()");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jsonObject.add(next, JsonSerializer.INSTANCE.toJsonElement(jSONObject.get(next)));
        }
        return jsonObject;
    }

    public static final JsonElement toJsonArray(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        JsonArray jsonArray = new JsonArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            jsonArray.add(JsonSerializer.INSTANCE.toJsonElement(jSONArray.get(i)));
        }
        return jsonArray;
    }

    public static final Map<String, Object> asDeepMap(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<Map.Entry<String, JsonElement>> setEntrySet = jsonObject.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "entrySet()");
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            linkedHashMap.put(key, fromJsonElement(entry.getValue()));
        }
        return linkedHashMap;
    }
}
