package com.datadog.trace.core.tagprocessor;

import com.datadog.trace.core.DDSpanContext;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface TagsPostProcessor {
    Map<String, Object> processTags(Map<String, Object> map);

    default Map<String, Object> processTagsWithContext(Map<String, Object> map, DDSpanContext dDSpanContext) {
        return processTags(map);
    }
}
