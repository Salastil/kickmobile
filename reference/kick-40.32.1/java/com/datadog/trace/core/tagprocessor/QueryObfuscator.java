package com.datadog.trace.core.tagprocessor;

import com.datadog.trace.api.DDTags;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.datadog.trace.util.Strings;
import com.google.re2j.Matcher;
import com.google.re2j.Pattern;
import com.google.re2j.PatternSyntaxException;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class QueryObfuscator implements TagsPostProcessor {
    private static final String DEFAULT_OBFUSCATION_PATTERN = "(?i)(?:(?:\"|%22)?)(?:(?:old[-_]?|new[-_]?)?p(?:ass)?w(?:or)?d(?:1|2)?|pass(?:[-_]?phrase)?|secret|(?:api[-_]?|private[-_]?|public[-_]?|access[-_]?|secret[-_]?|app(?:lication)?[-_]?)key(?:[-_]?id)?|token|consumer[-_]?(?:id|key|secret)|sign(?:ed|ature)?|auth(?:entication|orization)?)(?:(?:\\s|%20)*(?:=|%3D)[^&]+|(?:\"|%22)(?:\\s|%20)*(?::|%3A)(?:\\s|%20)*(?:\"|%22)(?:%2[^2]|%[^2]|[^\"%])+(?:\"|%22))|(?:bearer(?:\\s|%20)+[a-z0-9._\\-]+|token(?::|%3A)[a-z0-9]{13}|gh[opsu]_[0-9a-zA-Z]{36}|ey[I-L](?:[\\w=-]|%3D)+\\.ey[I-L](?:[\\w=-]|%3D)+(?:\\.(?:[\\w.+/=-]|%3D|%2F|%2B)+)?|-{5}BEGIN(?:[a-z\\s]|%20)+PRIVATE(?:\\s|%20)KEY-{5}[^\\-]+-{5}END(?:[a-z\\s]|%20)+PRIVATE(?:\\s|%20)KEY(?:-{5})?(?:\\n|%0A)?|(?:ssh-(?:rsa|dss)|ecdsa-[a-z0-9]+-[a-z0-9]+)(?:\\s|%20|%09)+(?:[a-z0-9/.+]|%2F|%5C|%2B){100,}(?:=|%3D)*(?:(?:\\s|%20|%09)+[a-z0-9._-]+)?)";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) QueryObfuscator.class);
    private final Pattern pattern;

    public QueryObfuscator(String str) {
        Pattern patternCompile = null;
        if ("".equals(str)) {
            this.pattern = null;
            return;
        }
        str = str == null ? DEFAULT_OBFUSCATION_PATTERN : str;
        try {
            patternCompile = Pattern.compile(str);
        } catch (PatternSyntaxException e) {
            log.error("Could not compile given query obfuscation regex: {}", str, e);
        }
        this.pattern = patternCompile;
    }

    private String obfuscate(String str) {
        Pattern pattern = this.pattern;
        if (pattern != null) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                str = Strings.replace(str, matcher.group(), "<redacted>");
            }
        }
        return str;
    }

    @Override // com.datadog.trace.core.tagprocessor.TagsPostProcessor
    public Map<String, Object> processTags(Map<String, Object> map) {
        Object obj = map.get(DDTags.HTTP_QUERY);
        if (obj instanceof CharSequence) {
            String strObfuscate = obfuscate(obj.toString());
            map.put(DDTags.HTTP_QUERY, strObfuscate);
            Object obj2 = map.get("http.url");
            if (obj2 instanceof CharSequence) {
                map.put("http.url", obj2 + "?" + ((Object) strObfuscate));
            }
        }
        return map;
    }
}
