package com.datadog.trace.core.tagprocessor;

import com.datadog.trace.api.DDTags;
import com.datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;
import com.datadog.trace.core.DDSpanContext;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class BaseServiceAdder implements TagsPostProcessor {
    private final UTF8BytesString ddService;

    @Override // com.datadog.trace.core.tagprocessor.TagsPostProcessor
    public Map<String, Object> processTags(Map<String, Object> map) {
        return map;
    }

    public BaseServiceAdder(String str) {
        this.ddService = str != null ? UTF8BytesString.create(str) : null;
    }

    @Override // com.datadog.trace.core.tagprocessor.TagsPostProcessor
    public Map<String, Object> processTagsWithContext(Map<String, Object> map, DDSpanContext dDSpanContext) {
        UTF8BytesString uTF8BytesString = this.ddService;
        if (uTF8BytesString != null && !uTF8BytesString.toString().equalsIgnoreCase(dDSpanContext.getServiceName())) {
            map.put(DDTags.BASE_SERVICE, this.ddService);
        }
        return map;
    }
}
