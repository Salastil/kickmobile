package com.datadog.android.webview.internal.rum;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimestampOffsetProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/datadog/android/webview/internal/rum/TimestampOffsetProvider;", "", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "offsets", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "getOffsets$dd_sdk_android_webview_release", "()Ljava/util/LinkedHashMap;", "getOffset", RumEventMeta.VIEW_ID_KEY, "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "getOffset$dd_sdk_android_webview_release", "purgeOffsets", "", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimestampOffsetProvider {
    public static final int MAX_VIEW_TIME_OFFSETS_RETAIN = 3;
    private final InternalLogger internalLogger;
    private final LinkedHashMap<String, Long> offsets;

    public TimestampOffsetProvider(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.offsets = new LinkedHashMap<>();
    }

    public final LinkedHashMap<String, Long> getOffsets$dd_sdk_android_webview_release() {
        return this.offsets;
    }

    public final synchronized long getOffset$dd_sdk_android_webview_release(String viewId, DatadogContext datadogContext) {
        Long lValueOf;
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        lValueOf = this.offsets.get(viewId);
        if (lValueOf == null) {
            lValueOf = Long.valueOf(datadogContext.getTime().getServerTimeOffsetMs());
            this.offsets.put(viewId, lValueOf);
        }
        purgeOffsets();
        return lValueOf.longValue();
    }

    private final void purgeOffsets() {
        while (this.offsets.entrySet().size() > 3) {
            try {
                Set<Map.Entry<String, Long>> setEntrySet = this.offsets.entrySet();
                Intrinsics.checkNotNullExpressionValue(setEntrySet, "offsets.entries");
                Object objFirst = CollectionsKt.first(setEntrySet);
                Intrinsics.checkNotNullExpressionValue(objFirst, "offsets.entries.first()");
                this.offsets.remove(((Map.Entry) objFirst).getKey());
            } catch (NoSuchElementException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.rum.TimestampOffsetProvider.purgeOffsets.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Trying to remove offset from an empty map.";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                return;
            }
        }
    }
}
