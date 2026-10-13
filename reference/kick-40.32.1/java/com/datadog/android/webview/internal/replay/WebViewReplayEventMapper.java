package com.datadog.android.webview.internal.replay;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.webview.internal.rum.TimestampOffsetProvider;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewReplayEventMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/webview/internal/replay/WebViewReplayEventMapper;", "", "webViewId", "", "offsetProvider", "Lcom/datadog/android/webview/internal/rum/TimestampOffsetProvider;", "(Ljava/lang/String;Lcom/datadog/android/webview/internal/rum/TimestampOffsetProvider;)V", "getOffsetProvider$dd_sdk_android_webview_release", "()Lcom/datadog/android/webview/internal/rum/TimestampOffsetProvider;", "bundleIntoEnrichedRecord", "Lcom/google/gson/JsonObject;", "record", "browserViewId", "rumContext", "Lcom/datadog/android/webview/internal/rum/domain/RumContext;", "mapEvent", "event", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewReplayEventMapper {
    public static final String BROWSER_EVENT_MISSING_RECORD_ERROR_MESSAGE = "The bundled web Replay event does not contain the record data";
    public static final String BROWSER_EVENT_MISSING_VIEW_DATA_ERROR_MESSAGE = "The bundled web Replay event does not contain the mandatory view data";
    public static final String ENRICHED_RECORD_APPLICATION_ID_KEY = "application_id";
    public static final String ENRICHED_RECORD_SESSION_ID_KEY = "session_id";
    public static final String ENRICHED_RECORD_VIEW_ID_KEY = "view_id";
    public static final String EVENT_KEY = "event";
    public static final String RECORDS_KEY = "records";
    public static final String SLOT_ID_KEY = "slotId";
    public static final String TIMESTAMP_KEY = "timestamp";
    public static final String VIEW_ID_KEY = "id";
    public static final String VIEW_OBJECT_KEY = "view";
    private final TimestampOffsetProvider offsetProvider;
    private final String webViewId;

    public WebViewReplayEventMapper(String webViewId, TimestampOffsetProvider offsetProvider) {
        Intrinsics.checkNotNullParameter(webViewId, "webViewId");
        Intrinsics.checkNotNullParameter(offsetProvider, "offsetProvider");
        this.webViewId = webViewId;
        this.offsetProvider = offsetProvider;
    }

    /* JADX INFO: renamed from: getOffsetProvider$dd_sdk_android_webview_release, reason: from getter */
    public final TimestampOffsetProvider getOffsetProvider() {
        return this.offsetProvider;
    }

    public final JsonObject mapEvent(JsonObject event, RumContext rumContext, DatadogContext datadogContext) throws IllegalStateException, NumberFormatException, ClassCastException {
        JsonObject asJsonObject;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(rumContext, "rumContext");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        JsonElement jsonElement2 = event.get("view");
        String asString = null;
        JsonObject asJsonObject2 = jsonElement2 != null ? jsonElement2.getAsJsonObject() : null;
        if (asJsonObject2 != null && (jsonElement = asJsonObject2.get("id")) != null) {
            asString = jsonElement.getAsString();
        }
        if (asString == null) {
            throw new IllegalStateException(BROWSER_EVENT_MISSING_VIEW_DATA_ERROR_MESSAGE.toString());
        }
        JsonElement jsonElement3 = event.get("event");
        if (jsonElement3 != null && (asJsonObject = jsonElement3.getAsJsonObject()) != null) {
            long offset$dd_sdk_android_webview_release = this.offsetProvider.getOffset$dd_sdk_android_webview_release(asString, datadogContext);
            JsonElement jsonElement4 = asJsonObject.get("timestamp");
            if (jsonElement4 != null) {
                Intrinsics.checkNotNullExpressionValue(jsonElement4, "get(TIMESTAMP_KEY)");
                asJsonObject.addProperty("timestamp", Long.valueOf(jsonElement4.getAsLong() + offset$dd_sdk_android_webview_release));
            }
            asJsonObject.addProperty(SLOT_ID_KEY, this.webViewId);
            return bundleIntoEnrichedRecord(asJsonObject, asString, rumContext);
        }
        throw new IllegalStateException(BROWSER_EVENT_MISSING_RECORD_ERROR_MESSAGE.toString());
    }

    private final JsonObject bundleIntoEnrichedRecord(JsonObject record, String browserViewId, RumContext rumContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("application_id", rumContext.getApplicationId());
        jsonObject.addProperty("session_id", rumContext.getSessionId());
        jsonObject.addProperty("view_id", browserViewId);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(record);
        Unit unit = Unit.INSTANCE;
        jsonObject.add(RECORDS_KEY, jsonArray);
        return jsonObject;
    }
}
