package com.datadog.trace.core.util;

import com.datadog.android.trace.internal.compat.function.Function;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class MapUtils {
    public static <V, K> V computeIfAbsent(K k, Map<K, V> map, Function<? super K, ? extends V> function) {
        V vApply;
        Objects.requireNonNull(function);
        V v = map.get(k);
        if (v != null || (vApply = function.apply(k)) == null) {
            return v;
        }
        map.put(k, vApply);
        return vApply;
    }

    public static JsonObject getAsJsonObject(Map<String, String> map) {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jsonObject.addProperty(entry.getKey(), entry.getValue());
        }
        return jsonObject;
    }
}
