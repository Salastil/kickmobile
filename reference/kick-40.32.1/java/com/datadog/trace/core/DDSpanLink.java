package com.datadog.trace.core;

import com.datadog.android.rum.internal.RumFeature;
import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.DDTraceId;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink;
import com.datadog.trace.bootstrap.instrumentation.api.SpanLink;
import com.datadog.trace.bootstrap.instrumentation.api.SpanLinkAttributes;
import com.datadog.trace.core.propagation.ExtractedContext;
import com.datadog.trace.core.propagation.PropagationTags;
import com.datadog.trace.core.propagation.W3CHttpCodec;
import com.datadog.trace.core.util.MapUtils;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;
import com.google.gson.JsonObject;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public class DDSpanLink extends SpanLink {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) DDSpanLink.class);
    private static final int TAG_MAX_LENGTH = 25000;

    protected DDSpanLink(DDTraceId dDTraceId, long j, byte b, String str, AgentSpanLink.Attributes attributes) {
        super(dDTraceId, j, b, str, attributes);
    }

    public static SpanLink from(ExtractedContext extractedContext) {
        return from(extractedContext, SpanLinkAttributes.EMPTY);
    }

    public static SpanLink from(ExtractedContext extractedContext, AgentSpanLink.Attributes attributes) {
        String strHeaderValue;
        byte b = extractedContext.getTraceSamplingPriority() > 0 ? (byte) 1 : (byte) 0;
        if (extractedContext.getPropagationTags() == null) {
            strHeaderValue = "";
        } else {
            strHeaderValue = extractedContext.getPropagationTags().headerValue(PropagationTags.HeaderType.W3C);
        }
        return new DDSpanLink(extractedContext.getTraceId(), extractedContext.getSpanId(), b, strHeaderValue, attributes);
    }

    public static String toTag(List<AgentSpanLink> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        while (i < list.size()) {
            String strAsJsonString = asJsonString(list.get(i));
            if (strAsJsonString.length() + sb.length() + (i == 0 ? 1 : 2) >= TAG_MAX_LENGTH) {
                break;
            }
            if (i > 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(strAsJsonString);
            i++;
        }
        while (i < list.size()) {
            LOGGER.debug("Span tag full. Dropping span links {}", list.get(i));
            i++;
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    private static String asJsonString(AgentSpanLink agentSpanLink) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("trace_id", agentSpanLink.traceId().toHexString());
        jsonObject.addProperty("span_id", DDSpanId.toHexString(agentSpanLink.spanId()));
        jsonObject.addProperty("flags", agentSpanLink.traceFlags() == 0 ? null : Byte.valueOf(agentSpanLink.traceFlags()));
        jsonObject.addProperty(W3CHttpCodec.TRACE_STATE_KEY, agentSpanLink.traceState().isEmpty() ? null : agentSpanLink.traceState());
        if (!agentSpanLink.attributes().isEmpty()) {
            jsonObject.addProperty(RumFeature.EVENT_ATTRIBUTES_PROPERTY, MapUtils.getAsJsonObject(agentSpanLink.attributes().asMap()).toString());
        }
        return jsonObject.toString();
    }
}
