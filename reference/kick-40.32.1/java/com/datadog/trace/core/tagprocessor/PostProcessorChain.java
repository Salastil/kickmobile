package com.datadog.trace.core.tagprocessor;

import com.datadog.trace.core.DDSpanContext;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class PostProcessorChain implements TagsPostProcessor {
    private final TagsPostProcessor[] chain;

    public PostProcessorChain(TagsPostProcessor... tagsPostProcessorArr) {
        this.chain = (TagsPostProcessor[]) Objects.requireNonNull(tagsPostProcessorArr);
    }

    @Override // com.datadog.trace.core.tagprocessor.TagsPostProcessor
    public Map<String, Object> processTags(Map<String, Object> map) {
        return processTagsWithContext(map, null);
    }

    @Override // com.datadog.trace.core.tagprocessor.TagsPostProcessor
    public Map<String, Object> processTagsWithContext(Map<String, Object> map, DDSpanContext dDSpanContext) {
        for (TagsPostProcessor tagsPostProcessor : this.chain) {
            map = tagsPostProcessor.processTagsWithContext(map, dDSpanContext);
        }
        return map;
    }
}
