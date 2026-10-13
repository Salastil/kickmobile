package com.datadog.android.core.internal.utils;

import com.datadog.android.api.InternalLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MiscUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0007J.\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/core/internal/utils/JsonSerializer;", "", "()V", "ITEM_SERIALIZATION_ERROR", "", "toJsonElement", "Lcom/google/gson/JsonElement;", "item", "safeMapValuesToJson", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JsonSerializer {
    public static final JsonSerializer INSTANCE = new JsonSerializer();
    public static final String ITEM_SERIALIZATION_ERROR = "Error serializing value for key %s, value was dropped.";

    private JsonSerializer() {
    }

    public final JsonElement toJsonElement(Object item) {
        if (Intrinsics.areEqual(item, com.datadog.android.internal.utils.MapUtilsKt.getNULL_MAP_VALUE())) {
            JsonNull INSTANCE2 = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
            return INSTANCE2;
        }
        if (item == null) {
            JsonNull INSTANCE3 = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE3, "INSTANCE");
            return INSTANCE3;
        }
        if (Intrinsics.areEqual(item, JsonNull.INSTANCE)) {
            JsonNull INSTANCE4 = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE4, "INSTANCE");
            return INSTANCE4;
        }
        if (item instanceof Boolean) {
            return new JsonPrimitive((Boolean) item);
        }
        if (!(item instanceof Integer) && !(item instanceof Long) && !(item instanceof Float) && !(item instanceof Double)) {
            if (item instanceof String) {
                return new JsonPrimitive((String) item);
            }
            if (item instanceof Date) {
                return new JsonPrimitive(Long.valueOf(((Date) item).getTime()));
            }
            if (item instanceof JsonArray) {
                return (JsonElement) item;
            }
            if (item instanceof Iterable) {
                return MiscUtilsKt.toJsonArray((Iterable<?>) item);
            }
            if (item instanceof Map) {
                return MiscUtilsKt.toJsonObject((Map<?, ?>) item);
            }
            if (!(item instanceof JsonObject) && !(item instanceof JsonPrimitive)) {
                if (item instanceof JSONObject) {
                    return MiscUtilsKt.toJsonObject((JSONObject) item);
                }
                return item instanceof JSONArray ? MiscUtilsKt.toJsonArray((JSONArray) item) : new JsonPrimitive(item.toString());
            }
            return (JsonElement) item;
        }
        return new JsonPrimitive((Number) item);
    }

    public final Map<String, JsonElement> safeMapValuesToJson(Map<String, ? extends Object> map, InternalLogger internalLogger) {
        InternalLogger internalLogger2;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (final Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            try {
                Pair pair = TuplesKt.to(entry.getKey(), INSTANCE.toJsonElement(entry.getValue()));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                internalLogger2 = internalLogger;
            } catch (Exception e) {
                internalLogger2 = internalLogger;
                InternalLogger.DefaultImpls.log$default(internalLogger2, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.utils.JsonSerializer$safeMapValuesToJson$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, JsonSerializer.ITEM_SERIALIZATION_ERROR, Arrays.copyOf(new Object[]{entry.getKey()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
            internalLogger = internalLogger2;
        }
        return linkedHashMap;
    }
}
