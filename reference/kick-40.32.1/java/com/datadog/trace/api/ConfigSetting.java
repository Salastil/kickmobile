package com.datadog.trace.api;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public final class ConfigSetting {
    private static final Set<String> CONFIG_FILTER_LIST = new HashSet(Arrays.asList("DD_API_KEY", "dd.api-key", "dd.profiling.api-key", "dd.profiling.apikey"));
    public final String key;
    public final ConfigOrigin origin;
    public final Object value;

    private static Object filterConfigEntry(String str, Object obj) {
        return CONFIG_FILTER_LIST.contains(str) ? "<hidden>" : obj;
    }

    public ConfigSetting(String str, Object obj, ConfigOrigin configOrigin) {
        this.key = str;
        this.value = filterConfigEntry(str, obj);
        this.origin = configOrigin;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ConfigSetting configSetting = (ConfigSetting) obj;
            if (this.key.equals(configSetting.key) && Objects.equals(this.value, configSetting.value) && this.origin == configSetting.origin) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.key, this.value, this.origin);
    }

    public String toString() {
        return "ConfigSetting{key='" + this.key + "', value=" + this.value + ", origin=" + this.origin + AbstractJsonLexerKt.END_OBJ;
    }
}
