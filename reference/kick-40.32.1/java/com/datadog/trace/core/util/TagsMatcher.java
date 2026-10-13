package com.datadog.trace.core.util;

import com.datadog.trace.core.CoreSpan;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class TagsMatcher {
    private final Map<String, Matcher> matchers;

    public static TagsMatcher create(Map<String, String> map) {
        Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : setEntrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (Matchers.isExact(value)) {
                map2.put(key, new Matchers.ExactMatcher(value));
            } else {
                map2.put(key, new Matchers.PatternMatcher(GlobPattern.globToRegexPattern(value)));
            }
        }
        return new TagsMatcher(map2);
    }

    public TagsMatcher(Map<String, Matcher> map) {
        this.matchers = map;
    }

    public <T extends CoreSpan<T>> boolean matches(T t) {
        for (Map.Entry entry : new HashSet(this.matchers.entrySet())) {
            String str = (String) t.getTag((CharSequence) entry.getKey());
            if (str == null || !((Matcher) entry.getValue()).matches(str)) {
                return false;
            }
        }
        return true;
    }
}
