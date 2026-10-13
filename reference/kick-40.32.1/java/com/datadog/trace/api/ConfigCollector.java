package com.datadog.trace.api;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes6.dex */
public class ConfigCollector {
    private volatile Map<String, ConfigSetting> collected = new ConcurrentHashMap();
    private static final ConfigCollector INSTANCE = new ConfigCollector();
    private static final AtomicReferenceFieldUpdater<ConfigCollector, Map> COLLECTED_UPDATER = AtomicReferenceFieldUpdater.newUpdater(ConfigCollector.class, Map.class, "collected");

    public static ConfigCollector get() {
        return INSTANCE;
    }

    public void put(String str, Object obj, ConfigOrigin configOrigin) {
        this.collected.put(str, new ConfigSetting(str, obj, configOrigin));
    }

    public void putAll(Map<String, Object> map, ConfigOrigin configOrigin) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(map.size() + this.collected.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            concurrentHashMap.put(entry.getKey(), new ConfigSetting(entry.getKey(), entry.getValue(), configOrigin));
        }
        while (true) {
            Map<String, ConfigSetting> map2 = this.collected;
            for (Map.Entry<String, ConfigSetting> entry2 : map2.entrySet()) {
                if (!map.containsKey(entry2.getKey())) {
                    concurrentHashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(COLLECTED_UPDATER, this, map2, concurrentHashMap)) {
                return;
            } else {
                concurrentHashMap.keySet().retainAll(map.keySet());
            }
        }
    }
}
