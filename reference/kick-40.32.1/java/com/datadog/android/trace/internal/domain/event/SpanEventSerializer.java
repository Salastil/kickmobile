package com.datadog.android.trace.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.core.constraints.DataConstraints;
import com.datadog.android.core.constraints.DatadogDataConstraints;
import com.datadog.android.internal.utils.MapUtilsKt;
import com.datadog.android.trace.internal.storage.ContextAwareSerializer;
import com.datadog.android.trace.model.SpanEvent;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpanEventSerializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0014*\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/trace/internal/domain/event/SpanEventSerializer;", "Lcom/datadog/android/trace/internal/storage/ContextAwareSerializer;", "Lcom/datadog/android/trace/model/SpanEvent;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "dataConstraints", "Lcom/datadog/android/core/constraints/DataConstraints;", "(Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/constraints/DataConstraints;)V", "sanitizeAccountAttributes", "Lcom/datadog/android/trace/model/SpanEvent$Account;", "account", "sanitizeKeys", "model", "sanitizeMetrics", "Lcom/datadog/android/trace/model/SpanEvent$Metrics;", SpanEventSerializer.METRICS_KEY_PREFIX, "sanitizeUserAttributes", "Lcom/datadog/android/trace/model/SpanEvent$Usr;", "usr", "serialize", "", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "toMetaString", "element", "", "valueToMetaStringOrNull", "", "Companion", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SpanEventSerializer implements ContextAwareSerializer<SpanEvent> {
    public static final String META_ACCOUNT_KEY_PREFIX = "meta.account";
    public static final String META_USR_KEY_PREFIX = "meta.usr";
    public static final String METRICS_KEY_PREFIX = "metrics";
    public static final String TAG_ENV = "env";
    public static final String TAG_SPANS = "spans";
    private final DataConstraints dataConstraints;
    private final InternalLogger internalLogger;

    public SpanEventSerializer(InternalLogger internalLogger, DataConstraints dataConstraints) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(dataConstraints, "dataConstraints");
        this.internalLogger = internalLogger;
        this.dataConstraints = dataConstraints;
    }

    public /* synthetic */ SpanEventSerializer(InternalLogger internalLogger, DatadogDataConstraints datadogDataConstraints, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, (i & 2) != 0 ? new DatadogDataConstraints(internalLogger) : datadogDataConstraints);
    }

    @Override // com.datadog.android.trace.internal.storage.ContextAwareSerializer
    public String serialize(DatadogContext datadogContext, SpanEvent model) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(model, "model");
        JsonElement json = sanitizeKeys(model).toJson();
        JsonArray jsonArray = new JsonArray(1);
        jsonArray.add(json);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(TAG_SPANS, jsonArray);
        jsonObject.addProperty("env", datadogContext.getEnv());
        String string = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
        return string;
    }

    private final SpanEvent sanitizeKeys(SpanEvent model) {
        SpanEvent.Usr usrSanitizeUserAttributes = sanitizeUserAttributes(model.getMeta().getUsr());
        SpanEvent.Account account = model.getMeta().getAccount();
        return model.copy((511 & 1) != 0 ? model.traceId : null, (511 & 2) != 0 ? model.spanId : null, (511 & 4) != 0 ? model.parentId : null, (511 & 8) != 0 ? model.resource : null, (511 & 16) != 0 ? model.name : null, (511 & 32) != 0 ? model.service : null, (511 & 64) != 0 ? model.duration : 0L, (511 & 128) != 0 ? model.start : 0L, (511 & 256) != 0 ? model.error : 0L, (511 & 512) != 0 ? model.metrics : sanitizeMetrics(model.getMetrics()), (511 & 1024) != 0 ? model.meta : SpanEvent.Meta.copy$default(model.getMeta(), null, null, null, null, usrSanitizeUserAttributes, account != null ? sanitizeAccountAttributes(account) : null, null, null, null, null, 975, null));
    }

    private final SpanEvent.Usr sanitizeUserAttributes(SpanEvent.Usr usr) {
        Map mapValidateAttributes$default = DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, usr.getAdditionalProperties(), META_USR_KEY_PREFIX, null, null, 12, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapValidateAttributes$default.size()));
        for (Map.Entry<String, ? extends Object> entry : mapValidateAttributes$default.entrySet()) {
            linkedHashMap.put(entry.getKey(), valueToMetaStringOrNull(entry));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((String) entry2.getValue()) != null) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return SpanEvent.Usr.copy$default(usr, null, null, null, MapsKt.toMutableMap(linkedHashMap2), 7, null);
    }

    private final SpanEvent.Account sanitizeAccountAttributes(SpanEvent.Account account) {
        Map mapValidateAttributes$default = DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, account.getAdditionalProperties(), META_ACCOUNT_KEY_PREFIX, null, null, 12, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapValidateAttributes$default.size()));
        for (Map.Entry<String, ? extends Object> entry : mapValidateAttributes$default.entrySet()) {
            linkedHashMap.put(entry.getKey(), valueToMetaStringOrNull(entry));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((String) entry2.getValue()) != null) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return SpanEvent.Account.copy$default(account, null, null, MapsKt.toMutableMap(linkedHashMap2), 3, null);
    }

    private final String valueToMetaStringOrNull(final Map.Entry<String, ? extends Object> entry) {
        try {
            return toMetaString(entry.getValue());
        } catch (Exception e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.trace.internal.domain.event.SpanEventSerializer.valueToMetaStringOrNull.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Error converting value for key " + ((Object) entry.getKey()) + " to meta string, it will be dropped.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    private final SpanEvent.Metrics sanitizeMetrics(SpanEvent.Metrics metrics) {
        return SpanEvent.Metrics.copy$default(metrics, null, DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, metrics.getAdditionalProperties(), METRICS_KEY_PREFIX, null, null, 12, null), 1, null);
    }

    private final String toMetaString(Object element) {
        if (Intrinsics.areEqual(element, MapUtilsKt.getNULL_MAP_VALUE()) || element == null) {
            return null;
        }
        if (element instanceof Date) {
            return String.valueOf(((Date) element).getTime());
        }
        return element instanceof JsonPrimitive ? ((JsonPrimitive) element).getAsString() : element.toString();
    }
}
