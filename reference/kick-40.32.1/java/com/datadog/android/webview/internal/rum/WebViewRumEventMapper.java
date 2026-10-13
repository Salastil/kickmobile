package com.datadog.android.webview.internal.rum;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.core.internal.utils.DdTagsUtils;
import com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewRumEventMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002JK\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/webview/internal/rum/WebViewRumEventMapper;", "", "nativeRumViewsCache", "Lcom/datadog/android/webview/internal/rum/domain/NativeRumViewsCache;", "(Lcom/datadog/android/webview/internal/rum/domain/NativeRumViewsCache;)V", "addAnonymousId", "", "event", "Lcom/google/gson/JsonObject;", "anonymousId", "", "mapEvent", "rumContext", "Lcom/datadog/android/webview/internal/rum/domain/RumContext;", "timeOffset", "", "sessionReplayEnabled", "", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "traceSampleRate", "", "(Lcom/google/gson/JsonObject;Lcom/datadog/android/webview/internal/rum/domain/RumContext;JZLjava/lang/String;Lcom/datadog/android/api/context/DatadogContext;Ljava/lang/Float;)Lcom/google/gson/JsonObject;", "mergeDDTags", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewRumEventMapper {
    public static final String ANONYMOUS_ID_KEY_NAME = "anonymous_id";
    public static final String APPLICATION_KEY_NAME = "application";
    public static final String CONTAINER_KEY_NAME = "container";
    public static final String DATE_KEY_NAME = "date";
    public static final String DDTAGS_KEY_NAME = "ddtags";
    public static final String DD_KEY_NAME = "_dd";
    public static final String DD_REPLAY_STATS = "replay_stats";
    public static final String DD_SESSION_KEY_NAME = "session";
    public static final String ID_KEY_NAME = "id";
    public static final String RULE_PSR_KEY_NAME = "rule_psr";
    private static final float SAMPLE_ALL_RATE = 100.0f;
    public static final String SESSION_HAS_REPLAY_NAME = "has_replay";
    public static final String SESSION_KEY_NAME = "session";
    public static final String SOURCE_KEY_NAME = "source";
    public static final String SOURCE_VALUE = "android";
    public static final String USR_KEY_NAME = "usr";
    public static final String VIEW_KEY_NAME = "view";
    private final NativeRumViewsCache nativeRumViewsCache;

    public WebViewRumEventMapper(NativeRumViewsCache nativeRumViewsCache) {
        Intrinsics.checkNotNullParameter(nativeRumViewsCache, "nativeRumViewsCache");
        this.nativeRumViewsCache = nativeRumViewsCache;
    }

    public final JsonObject mapEvent(JsonObject event, RumContext rumContext, long timeOffset, boolean sessionReplayEnabled, String anonymousId, DatadogContext datadogContext, Float traceSampleRate) throws IllegalStateException, NumberFormatException, ClassCastException {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("source", "android");
        JsonElement jsonElement = event.get("date");
        if (jsonElement != null) {
            long asLong = jsonElement.getAsLong();
            String strResolveLastParentIdForBrowserEvent = this.nativeRumViewsCache.resolveLastParentIdForBrowserEvent(asLong);
            if (strResolveLastParentIdForBrowserEvent != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("id", strResolveLastParentIdForBrowserEvent);
                Unit unit = Unit.INSTANCE;
                jsonObject.add("view", jsonObject2);
            }
            event.addProperty("date", Long.valueOf(asLong + timeOffset));
        }
        event.add(CONTAINER_KEY_NAME, jsonObject);
        JsonElement jsonElement2 = event.get(DD_KEY_NAME);
        JsonObject asJsonObject = jsonElement2 != null ? jsonElement2.getAsJsonObject() : null;
        if (asJsonObject != null) {
            JsonElement jsonElement3 = asJsonObject.get("session");
            JsonObject asJsonObject2 = jsonElement3 != null ? jsonElement3.getAsJsonObject() : null;
            if (asJsonObject2 == null) {
                asJsonObject2 = new JsonObject();
            }
            asJsonObject.add("session", asJsonObject2);
            if (!sessionReplayEnabled) {
                asJsonObject.remove(DD_REPLAY_STATS);
            }
            if (traceSampleRate != null && asJsonObject.has(RULE_PSR_KEY_NAME)) {
                asJsonObject.addProperty(RULE_PSR_KEY_NAME, Float.valueOf(traceSampleRate.floatValue() / 100.0f));
            }
        }
        if (rumContext != null) {
            JsonObject asJsonObject3 = event.getAsJsonObject("application");
            JsonObject asJsonObject4 = asJsonObject3 != null ? asJsonObject3.getAsJsonObject() : null;
            if (asJsonObject4 == null) {
                asJsonObject4 = new JsonObject();
            }
            JsonObject asJsonObject5 = event.getAsJsonObject("session");
            JsonObject asJsonObject6 = asJsonObject5 != null ? asJsonObject5.getAsJsonObject() : null;
            if (asJsonObject6 == null) {
                asJsonObject6 = new JsonObject();
            }
            asJsonObject4.addProperty("id", rumContext.getApplicationId());
            asJsonObject6.addProperty("id", rumContext.getSessionId());
            if (!sessionReplayEnabled) {
                asJsonObject6.remove("has_replay");
            }
            event.add("application", asJsonObject4);
            event.add("session", asJsonObject6);
        }
        addAnonymousId(event, anonymousId);
        mergeDDTags(event, datadogContext);
        return event;
    }

    private final void mergeDDTags(JsonObject event, DatadogContext datadogContext) {
        String asString;
        Map<String, String> ddTagsMap;
        Map<String, String> mutableMap = MapsKt.toMutableMap(DdTagsUtils.INSTANCE.toDdTagsMap(datadogContext));
        JsonElement jsonElement = event.get("ddtags");
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive != null && (asString = jsonPrimitive.getAsString()) != null && (ddTagsMap = DdTagsUtils.INSTANCE.toDdTagsMap(asString)) != null) {
            mutableMap.putAll(ddTagsMap);
        }
        event.addProperty("ddtags", DdTagsUtils.INSTANCE.toDdTagsString(mutableMap));
    }

    private final void addAnonymousId(JsonObject event, String anonymousId) {
        if (anonymousId == null) {
            return;
        }
        JsonObject asJsonObject = event.getAsJsonObject("usr");
        if (asJsonObject == null) {
            asJsonObject = new JsonObject();
        }
        asJsonObject.addProperty("anonymous_id", anonymousId);
        event.add("usr", asJsonObject);
    }
}
