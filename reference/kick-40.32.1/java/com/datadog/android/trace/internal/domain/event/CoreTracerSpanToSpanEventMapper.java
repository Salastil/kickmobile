package com.datadog.android.trace.internal.domain.event;

import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.trace.model.SpanEvent;
import com.datadog.trace.api.DDSpanId;
import com.datadog.trace.api.internal.util.LongStringUtils;
import com.datadog.trace.bootstrap.instrumentation.api.AgentSpanLink;
import com.datadog.trace.core.DDSpan;
import com.datadog.trace.core.DDSpanContext;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoreTracerSpanToSpanEventMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u001c\u0010\u001e\u001a\u00020\u001a2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001fH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"Lcom/datadog/android/trace/internal/domain/event/CoreTracerSpanToSpanEventMapper;", "Lcom/datadog/android/trace/internal/domain/event/BaseSpanEventMapper;", "Lcom/datadog/trace/core/DDSpan;", "networkInfoEnabled", "", "(Z)V", "getNetworkInfoEnabled$dd_sdk_android_trace_release", "()Z", "map", "Lcom/datadog/android/trace/model/SpanEvent;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "model", "resolveMeta", "Lcom/datadog/android/trace/model/SpanEvent$Meta;", "event", "resolveMetrics", "Lcom/datadog/android/trace/model/SpanEvent$Metrics;", "resolveMetricsFromSpanContext", "", "", "", "span", "resolveParentId", "resolveSpanId", "resolveSpanLink", "Lcom/google/gson/JsonObject;", "link", "Lcom/datadog/trace/bootstrap/instrumentation/api/AgentSpanLink;", "resolveSpanLinks", "toJson", "", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoreTracerSpanToSpanEventMapper extends BaseSpanEventMapper<DDSpan> {
    private static final String ATTRIBUTES_KEY = "attributes";
    private static final String FLAGS_KEY = "flags";
    private static final String SPAN_ID_KEY = "span_id";
    public static final String SPAN_LINKS_KEY = "_dd.span_links";
    private static final int TRACE_ID_HEXA_SIZE = 16;
    private static final String TRACE_ID_KEY = "trace_id";
    private static final String TRACE_STATE_KEY = "tracestate";
    private final boolean networkInfoEnabled;

    /* JADX INFO: renamed from: getNetworkInfoEnabled$dd_sdk_android_trace_release, reason: from getter */
    public final boolean getNetworkInfoEnabled() {
        return this.networkInfoEnabled;
    }

    public CoreTracerSpanToSpanEventMapper(boolean z) {
        this.networkInfoEnabled = z;
    }

    @Override // com.datadog.android.trace.internal.domain.event.ContextAwareMapper
    public SpanEvent map(DatadogContext datadogContext, DDSpan model) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(model, "model");
        long serverTimeOffsetNs = datadogContext.getTime().getServerTimeOffsetNs();
        SpanEvent.Metrics metricsResolveMetrics = resolveMetrics(model);
        SpanEvent.Meta metaResolveMeta = resolveMeta(datadogContext, model);
        String lessSignificantTraceId = LongStringUtils.toHexStringPadded(model.getTraceId().toLong(), 16);
        String strResolveSpanId = resolveSpanId(model);
        String strResolveParentId = resolveParentId(model);
        String string = model.getResourceName().toString();
        String string2 = model.getOperationName().toString();
        String serviceName = model.getServiceName();
        long durationNano = model.getDurationNano();
        long startTime = model.getStartTime() + serverTimeOffsetNs;
        long error = model.getError();
        Intrinsics.checkNotNullExpressionValue(lessSignificantTraceId, "lessSignificantTraceId");
        Intrinsics.checkNotNullExpressionValue(serviceName, "serviceName");
        return new SpanEvent(lessSignificantTraceId, strResolveSpanId, strResolveParentId, string, string2, serviceName, durationNano, startTime, error, metricsResolveMetrics, metaResolveMeta);
    }

    private final String resolveSpanId(DDSpan model) {
        String hexStringPadded = DDSpanId.toHexStringPadded(model.getSpanId());
        Intrinsics.checkNotNullExpressionValue(hexStringPadded, "toHexStringPadded(model.spanId)");
        return hexStringPadded;
    }

    private final String resolveParentId(DDSpan model) {
        String hexStringPadded = DDSpanId.toHexStringPadded(model.getParentId());
        Intrinsics.checkNotNullExpressionValue(hexStringPadded, "toHexStringPadded(model.parentId)");
        return hexStringPadded;
    }

    private final SpanEvent.Metrics resolveMetrics(DDSpan event) {
        Map<String, Number> mapResolveMetricsFromSpanContext = resolveMetricsFromSpanContext(event);
        int spanSamplingPriority = event.getSpanSamplingPriority();
        if (spanSamplingPriority != -128) {
            mapResolveMetricsFromSpanContext.put(DDSpanContext.PRIORITY_SAMPLING_KEY, Integer.valueOf(spanSamplingPriority));
        }
        return new SpanEvent.Metrics(event.getParentId() == 0 ? 1L : null, mapResolveMetricsFromSpanContext);
    }

    private final SpanEvent.Meta resolveMeta(DatadogContext datadogContext, DDSpan event) {
        SpanEvent.Application application;
        SpanEvent.Session session;
        SpanEvent.Device deviceResolveDeviceInfo = resolveDeviceInfo(datadogContext.getDeviceInfo());
        SpanEvent.Os osResolveOsInfo = resolveOsInfo(datadogContext.getDeviceInfo());
        SpanEvent.View view = null;
        SpanEvent.Network networkResolveNetworkInfo = this.networkInfoEnabled ? resolveNetworkInfo(datadogContext.getNetworkInfo()) : null;
        UserInfo userInfo = datadogContext.getUserInfo();
        AccountInfo accountInfo = datadogContext.getAccountInfo();
        SpanEvent.Usr usr = new SpanEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), MapsKt.toMutableMap(userInfo.getAdditionalProperties()));
        SpanEvent.Account accountResolveAccountInfo = accountInfo != null ? resolveAccountInfo(accountInfo) : null;
        String source = datadogContext.getSource();
        Object obj = event.getTags().get("application_id");
        if (obj != null) {
            application = new SpanEvent.Application(obj instanceof String ? (String) obj : null);
        } else {
            application = null;
        }
        Object obj2 = event.getTags().get("session_id");
        if (obj2 != null) {
            session = new SpanEvent.Session(obj2 instanceof String ? (String) obj2 : null);
        } else {
            session = null;
        }
        Object obj3 = event.getTags().get(LogAttributes.RUM_VIEW_ID);
        if (obj3 != null) {
            view = new SpanEvent.View(obj3 instanceof String ? (String) obj3 : null);
        }
        SpanEvent.Dd dd = new SpanEvent.Dd(source, application, session, view);
        String mostSignificantTraceId = LongStringUtils.toHexStringPadded(event.getTraceId().toHighOrderLong(), 16);
        Map<String, Object> tags = event.getTags();
        Intrinsics.checkNotNullExpressionValue(tags, "event.tags");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(tags.size()));
        Iterator<T> it = tags.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Map<String, String> baggage = event.getBaggage();
        Intrinsics.checkNotNullExpressionValue(baggage, "event.baggage");
        linkedHashMap2.putAll(baggage);
        linkedHashMap2.putAll(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mostSignificantTraceId, "mostSignificantTraceId");
        linkedHashMap2.put(MetaKeysKt.TRACE_ID_META_KEY, mostSignificantTraceId);
        linkedHashMap2.put("variant", datadogContext.getVariant());
        String strResolveSpanLinks = resolveSpanLinks(event);
        if (strResolveSpanLinks != null) {
            linkedHashMap2.put("_dd.span_links", strResolveSpanLinks);
        }
        return new SpanEvent.Meta(datadogContext.getVersion(), dd, new SpanEvent.Span(), new SpanEvent.Tracer(datadogContext.getSdkVersion()), usr, accountResolveAccountInfo, networkResolveNetworkInfo, deviceResolveDeviceInfo, osResolveOsInfo, linkedHashMap2);
    }

    private final String resolveSpanLinks(DDSpan model) {
        if (model.getLinks().isEmpty()) {
            return null;
        }
        List<AgentSpanLink> links = model.getLinks();
        Intrinsics.checkNotNullExpressionValue(links, "model.links");
        List<AgentSpanLink> list = links;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (AgentSpanLink it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(resolveSpanLink(it));
        }
        JsonArray jsonArray = new JsonArray();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            jsonArray.add((JsonObject) it2.next());
        }
        return jsonArray.toString();
    }

    private final JsonObject resolveSpanLink(AgentSpanLink link) {
        String hexString = link.traceId().toHexString();
        String hexStringPadded = DDSpanId.toHexStringPadded(link.spanId());
        Map<String, String> mapAsMap = link.attributes().asMap();
        Intrinsics.checkNotNullExpressionValue(mapAsMap, "link.attributes().asMap()");
        JsonObject json = toJson(mapAsMap);
        byte bTraceFlags = link.traceFlags();
        String traceState = link.traceState();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(TRACE_ID_KEY, hexString);
        jsonObject.addProperty(SPAN_ID_KEY, hexStringPadded);
        jsonObject.add("attributes", json);
        if (bTraceFlags != 0) {
            jsonObject.addProperty("flags", Byte.valueOf(bTraceFlags));
        }
        Intrinsics.checkNotNullExpressionValue(traceState, "traceState");
        if (traceState.length() > 0) {
            jsonObject.addProperty("tracestate", traceState);
        }
        return jsonObject;
    }

    private final Map<String, Number> resolveMetricsFromSpanContext(DDSpan span) {
        Map<String, Object> tags = span.getTags();
        Intrinsics.checkNotNullExpressionValue(tags, "span.tags");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : tags.entrySet()) {
            if (entry.getValue() instanceof Number) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Number");
            linkedHashMap3.put(key, (Number) value);
        }
        return MapsKt.toMutableMap(linkedHashMap3);
    }

    private final JsonObject toJson(Map<String, String> map) {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jsonObject.addProperty(entry.getKey(), entry.getValue());
        }
        return jsonObject;
    }
}
