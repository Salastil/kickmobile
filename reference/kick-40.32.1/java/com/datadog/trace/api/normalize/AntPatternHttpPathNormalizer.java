package com.datadog.trace.api.normalize;

import com.datadog.android.trace.internal.compat.function.Function;
import com.datadog.trace.api.cache.DDCache;
import com.datadog.trace.api.cache.DDCaches;
import com.datadog.trace.bootstrap.instrumentation.api.URIUtils;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
final class AntPatternHttpPathNormalizer extends HttpPathNormalizer {
    private static final String KEEP_AS_IS = "*";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) AntPatternHttpPathNormalizer.class);
    private final Map<String, String> resourceNameMatchers;
    private final AntPathMatcher matcher = new AntPathMatcher();
    private final DDCache<String, String> cache = DDCaches.newFixedSizeCache(512);
    private final Function<String, String> cacheLoader = new Function<String, String>() { // from class: com.datadog.trace.api.normalize.AntPatternHttpPathNormalizer.1
        @Override // com.datadog.android.trace.internal.compat.function.Function
        public String apply(String str) {
            for (Map.Entry entry : AntPatternHttpPathNormalizer.this.resourceNameMatchers.entrySet()) {
                if (AntPatternHttpPathNormalizer.this.matcher.match((String) entry.getKey(), str)) {
                    return "*".equals(entry.getValue()) ? str : (String) entry.getValue();
                }
            }
            return null;
        }
    };

    AntPatternHttpPathNormalizer(Map<String, String> map) {
        this.resourceNameMatchers = map;
        ArrayList<String> arrayList = new ArrayList(map.keySet().size());
        for (String str : map.keySet()) {
            if (!this.matcher.isPattern(str)) {
                arrayList.add(str);
            }
        }
        for (String str2 : arrayList) {
            log.warn("Invalid pattern {} removed from matchers", str2);
            this.resourceNameMatchers.remove(str2);
        }
    }

    @Override // com.datadog.trace.api.normalize.HttpPathNormalizer
    public String normalize(String str, boolean z) {
        if (z) {
            str = URIUtils.decode(str);
        }
        return this.cache.computeIfAbsent(str, this.cacheLoader);
    }
}
