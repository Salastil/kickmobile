package com.datadog.android.rum.internal;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeaturesContextResolver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/FeaturesContextResolver;", "", "()V", "resolveViewHasReplay", "", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", RumEventMeta.VIEW_ID_KEY, "", "resolveViewRecordsCount", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FeaturesContextResolver {
    public static final String HAS_REPLAY_KEY = "has_replay";
    public static final String VIEW_RECORDS_COUNT_KEY = "records_count";

    public final boolean resolveViewHasReplay(DatadogContext datadogContext, String viewId) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Map<String, Object> map = datadogContext.getFeaturesContext().get("session-replay");
        if (map == null) {
            return false;
        }
        Object obj = map.get(viewId);
        Map map2 = obj instanceof Map ? (Map) obj : null;
        Object obj2 = map2 != null ? map2.get("has_replay") : null;
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final long resolveViewRecordsCount(DatadogContext datadogContext, String viewId) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Map<String, Object> map = datadogContext.getFeaturesContext().get("session-replay");
        if (map == null) {
            return 0L;
        }
        Object obj = map.get(viewId);
        Map map2 = obj instanceof Map ? (Map) obj : null;
        Object obj2 = map2 != null ? map2.get(VIEW_RECORDS_COUNT_KEY) : null;
        Long l = obj2 instanceof Long ? (Long) obj2 : null;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }
}
