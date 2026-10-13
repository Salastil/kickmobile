package com.datadog.trace.bootstrap.config.provider;

import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.datadog.trace.api.ConfigCollector;
import com.datadog.trace.api.ConfigOrigin;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import io.ktor.sse.ServerSentEventKt;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public final class ConfigProvider {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) ConfigProvider.class);
    private final boolean collectConfig;
    private final Source[] sources;

    private static final class Singleton {
        private static final ConfigProvider INSTANCE = ConfigProvider.createDefault();

        private Singleton() {
        }
    }

    private ConfigProvider(Source... sourceArr) {
        this(true, sourceArr);
    }

    private ConfigProvider(boolean z, Source... sourceArr) {
        this.collectConfig = z;
        this.sources = sourceArr;
    }

    public String getConfigFileStatus() {
        String configFileStatus;
        for (Source source : this.sources) {
            if ((source instanceof PropertiesConfigSource) && (configFileStatus = ((PropertiesConfigSource) source).getConfigFileStatus()) != null) {
                return configFileStatus;
            }
        }
        return "no config file present";
    }

    public String getString(String str) {
        return getString(str, null, new String[0]);
    }

    public <T extends Enum<T>> T getEnum(String str, Class<T> cls, T t) {
        String string = getString(str);
        if (string != null) {
            try {
                return (T) Enum.valueOf(cls, string);
            } catch (Exception unused) {
                log.debug("failed to parse {} for {}, defaulting to {}", string, str, t);
            }
        }
        if (this.collectConfig) {
            ConfigCollector.get().put(str, String.valueOf(t), ConfigOrigin.DEFAULT);
        }
        return t;
    }

    public String getString(String str, String str2, String... strArr) {
        for (Source source : this.sources) {
            String str3 = source.get(str, strArr);
            if (str3 != null) {
                if (this.collectConfig) {
                    ConfigCollector.get().put(str, str3, source.origin());
                }
                return str3;
            }
        }
        if (this.collectConfig && str2 != null) {
            ConfigCollector.get().put(str, str2, ConfigOrigin.DEFAULT);
        }
        return str2;
    }

    public String getStringNotEmpty(String str, String str2, String... strArr) {
        for (Source source : this.sources) {
            String str3 = source.get(str, strArr);
            if (str3 != null && !str3.trim().isEmpty()) {
                if (this.collectConfig) {
                    ConfigCollector.get().put(str, str3, source.origin());
                }
                return str3;
            }
        }
        if (this.collectConfig && str2 != null) {
            ConfigCollector.get().put(str, str2, ConfigOrigin.DEFAULT);
        }
        return str2;
    }

    public String getStringExcludingSource(String str, String str2, Class<? extends Source> cls, String... strArr) {
        String str3;
        for (Source source : this.sources) {
            if (!cls.isAssignableFrom(source.getClass()) && (str3 = source.get(str, strArr)) != null) {
                if (this.collectConfig) {
                    ConfigCollector.get().put(str, str3, source.origin());
                }
                return str3;
            }
        }
        if (this.collectConfig && str2 != null) {
            ConfigCollector.get().put(str, str2, ConfigOrigin.DEFAULT);
        }
        return str2;
    }

    public boolean isSet(String str) {
        String string = getString(str);
        return (string == null || string.isEmpty()) ? false : true;
    }

    public Boolean getBoolean(String str) {
        return (Boolean) get(str, null, Boolean.class, new String[0]);
    }

    public Boolean getBoolean(String str, String... strArr) {
        return (Boolean) get(str, null, Boolean.class, strArr);
    }

    public boolean getBoolean(String str, boolean z, String... strArr) {
        return ((Boolean) get(str, Boolean.valueOf(z), Boolean.class, strArr)).booleanValue();
    }

    public Integer getInteger(String str) {
        return (Integer) get(str, null, Integer.class, new String[0]);
    }

    public Integer getInteger(String str, String... strArr) {
        return (Integer) get(str, null, Integer.class, strArr);
    }

    public int getInteger(String str, int i, String... strArr) {
        return ((Integer) get(str, Integer.valueOf(i), Integer.class, strArr)).intValue();
    }

    public Long getLong(String str) {
        return (Long) get(str, null, Long.class, new String[0]);
    }

    public Long getLong(String str, String... strArr) {
        return (Long) get(str, null, Long.class, strArr);
    }

    public long getLong(String str, long j, String... strArr) {
        return ((Long) get(str, Long.valueOf(j), Long.class, strArr)).longValue();
    }

    public Float getFloat(String str, String... strArr) {
        return (Float) get(str, null, Float.class, strArr);
    }

    public float getFloat(String str, float f) {
        return ((Float) get(str, Float.valueOf(f), Float.class, new String[0])).floatValue();
    }

    public Double getDouble(String str) {
        return (Double) get(str, null, Double.class, new String[0]);
    }

    public double getDouble(String str, double d) {
        return ((Double) get(str, Double.valueOf(d), Double.class, new String[0])).doubleValue();
    }

    private <T> T get(String str, T t, Class<T> cls, String... strArr) {
        for (Source source : this.sources) {
            try {
                String str2 = source.get(str, strArr);
                T t2 = (T) ConfigConverter.valueOf(str2, cls);
                if (t2 != null) {
                    if (this.collectConfig) {
                        ConfigCollector.get().put(str, str2, source.origin());
                    }
                    return t2;
                }
                continue;
            } catch (NumberFormatException unused) {
            }
        }
        if (this.collectConfig && t != null) {
            ConfigCollector.get().put(str, t, ConfigOrigin.DEFAULT);
        }
        return t;
    }

    public List<String> getList(String str) {
        return ConfigConverter.parseList(getString(str));
    }

    public List<String> getList(String str, List<String> list) {
        if (getString(str) == null) {
            if (this.collectConfig && list != null) {
                ConfigCollector.get().put(str, UByte$$ExternalSyntheticBackport0.m((CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, (Iterable) list), ConfigOrigin.DEFAULT);
            }
            return list;
        }
        return ConfigConverter.parseList(getString(str));
    }

    public Set<String> getSet(String str, Set<String> set) {
        if (getString(str) == null) {
            if (this.collectConfig && set != null) {
                ConfigCollector.get().put(str, UByte$$ExternalSyntheticBackport0.m((CharSequence) WebViewLogEventConsumer.DDTAGS_SEPARATOR, (Iterable) set), ConfigOrigin.DEFAULT);
            }
            return set;
        }
        return new HashSet(ConfigConverter.parseList(getString(str)));
    }

    public List<String> getSpacedList(String str) {
        return ConfigConverter.parseList(getString(str), ServerSentEventKt.SPACE);
    }

    public Map<String, String> getMergedMap(String str) {
        HashMap map = new HashMap();
        ConfigOrigin configOriginOrigin = ConfigOrigin.DEFAULT;
        for (int length = this.sources.length - 1; length >= 0; length--) {
            Map<String, String> map2 = ConfigConverter.parseMap(this.sources[length].get(str), str);
            if (!map2.isEmpty()) {
                configOriginOrigin = this.sources[length].origin();
            }
            map.putAll(map2);
        }
        collectMapSetting(str, map, configOriginOrigin);
        return map;
    }

    public Map<String, String> getOrderedMap(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ConfigOrigin configOriginOrigin = ConfigOrigin.DEFAULT;
        for (int length = this.sources.length - 1; length >= 0; length--) {
            Map<String, String> orderedMap = ConfigConverter.parseOrderedMap(this.sources[length].get(str), str);
            if (!orderedMap.isEmpty()) {
                configOriginOrigin = this.sources[length].origin();
            }
            linkedHashMap.putAll(orderedMap);
        }
        collectMapSetting(str, linkedHashMap, configOriginOrigin);
        return linkedHashMap;
    }

    public Map<String, String> getMergedMapWithOptionalMappings(String str, boolean z, String... strArr) {
        HashMap map = new HashMap();
        ConfigOrigin configOriginOrigin = ConfigOrigin.DEFAULT;
        for (String str2 : strArr) {
            for (int length = this.sources.length - 1; length >= 0; length--) {
                Map<String, String> mapWithOptionalMappings = ConfigConverter.parseMapWithOptionalMappings(this.sources[length].get(str2), str2, str, z);
                if (!mapWithOptionalMappings.isEmpty()) {
                    configOriginOrigin = this.sources[length].origin();
                }
                map.putAll(mapWithOptionalMappings);
            }
            collectMapSetting(str2, map, configOriginOrigin);
        }
        return map;
    }

    public BitSet getIntegerRange(String str, BitSet bitSet) {
        String string = getString(str);
        if (string != null) {
            try {
                return ConfigConverter.parseIntegerRangeSet(string, str);
            } catch (NumberFormatException e) {
                log.warn("Invalid configuration for {}", str, e);
            }
        }
        if (this.collectConfig) {
            ConfigCollector.get().put(str, ConfigConverter.renderIntegerRange(bitSet), ConfigOrigin.DEFAULT);
        }
        return bitSet;
    }

    public boolean isEnabled(Iterable<String> iterable, String str, String str2, boolean z) {
        String str3;
        Iterator<String> it = iterable.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            String str4 = str + it.next() + str2;
            if (str4.startsWith("trace.")) {
                str3 = str4;
            } else {
                str3 = "trace." + str4;
            }
            boolean z3 = getBoolean(str3, z, str4);
            z2 = z ? z2 & z3 : z2 | z3;
        }
        return z2;
    }

    public static ConfigProvider getInstance() {
        return Singleton.INSTANCE;
    }

    public static ConfigProvider createDefault() {
        return new ConfigProvider(new Source[0]);
    }

    public static ConfigProvider withPropertiesOverride(Properties properties) {
        return new ConfigProvider(new PropertiesConfigSource(properties, false));
    }

    private void collectMapSetting(String str, Map<String, String> map, ConfigOrigin configOrigin) {
        if (!this.collectConfig || map.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(entry.getKey());
            sb.append(AbstractJsonLexerKt.COLON);
            sb.append(entry.getValue());
        }
        ConfigCollector.get().put(str, sb.toString(), configOrigin);
    }

    public static abstract class Source {
        protected abstract String get(String str);

        public abstract ConfigOrigin origin();

        public final String get(String str, String... strArr) {
            String str2 = get(str);
            if (str2 != null) {
                return str2;
            }
            for (String str3 : strArr) {
                String str4 = get(str3);
                if (str4 != null) {
                    return str4;
                }
            }
            return null;
        }
    }
}
