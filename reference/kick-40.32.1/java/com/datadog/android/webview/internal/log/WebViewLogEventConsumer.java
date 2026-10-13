package com.datadog.android.webview.internal.log;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.core.sampling.RateBasedSampler;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.webview.internal.WebViewEventConsumer;
import com.datadog.android.webview.internal.rum.WebViewRumEventContextProvider;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WebViewLogEventConsumer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0001\u001dB+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0018\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/webview/internal/log/WebViewLogEventConsumer;", "Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "Lkotlin/Pair;", "Lcom/google/gson/JsonObject;", "", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "userLogsWriter", "Lcom/datadog/android/api/storage/DataWriter;", "rumContextProvider", "Lcom/datadog/android/webview/internal/rum/WebViewRumEventContextProvider;", "sampleRate", "", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/api/storage/DataWriter;Lcom/datadog/android/webview/internal/rum/WebViewRumEventContextProvider;F)V", "sampler", "Lcom/datadog/android/core/sampling/Sampler;", "", "getUserLogsWriter$dd_sdk_android_webview_release", "()Lcom/datadog/android/api/storage/DataWriter;", "addAnonymousId", "event", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "addDdTags", "consume", "correctDate", "map", "rumContext", "Lcom/datadog/android/webview/internal/rum/domain/RumContext;", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewLogEventConsumer implements WebViewEventConsumer<Pair<? extends JsonObject, ? extends String>> {
    public static final String ANONYMOUS_ID_KEY_NAME = "anonymous_id";
    public static final String DATE_KEY_NAME = "date";
    public static final String DDTAGS_KEY_NAME = "ddtags";
    public static final String DDTAGS_SEPARATOR = ",";
    public static final float DEFAULT_SAMPLE_RATE = 100.0f;
    public static final String INTERNAL_LOG_EVENT_TYPE = "internal_log";
    public static final String JSON_PARSING_ERROR_MESSAGE = "The bundled web log event could not be deserialized";
    public static final String USER_LOG_EVENT_TYPE = "log";
    public static final String USR_KEY_NAME = "usr";
    private final WebViewRumEventContextProvider rumContextProvider;
    private final Sampler<Unit> sampler;
    private final FeatureSdkCore sdkCore;
    private final DataWriter<JsonObject> userLogsWriter;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> LOG_EVENT_TYPES = SetsKt.setOf("log");

    public WebViewLogEventConsumer(FeatureSdkCore sdkCore, DataWriter<JsonObject> userLogsWriter, WebViewRumEventContextProvider rumContextProvider, float f) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(userLogsWriter, "userLogsWriter");
        Intrinsics.checkNotNullParameter(rumContextProvider, "rumContextProvider");
        this.sdkCore = sdkCore;
        this.userLogsWriter = userLogsWriter;
        this.rumContextProvider = rumContextProvider;
        this.sampler = new RateBasedSampler(f);
    }

    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public /* bridge */ /* synthetic */ void consume(Pair<? extends JsonObject, ? extends String> pair) {
        consume2((Pair<JsonObject, String>) pair);
    }

    public final DataWriter<JsonObject> getUserLogsWriter$dd_sdk_android_webview_release() {
        return this.userLogsWriter;
    }

    /* JADX INFO: renamed from: consume, reason: avoid collision after fix types in other method */
    public void consume2(final Pair<JsonObject, String> event) {
        FeatureScope feature;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getSecond(), "log") && this.sampler.sample(Unit.INSTANCE) && (feature = this.sdkCore.getFeature(WebViewLogsFeature.WEB_LOGS_FEATURE_NAME)) != null) {
            feature.withWriteContext(SetsKt.setOf("rum"), new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.consume.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
                    invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
                    Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                    Intrinsics.checkNotNullParameter(writeScope, "writeScope");
                    final RumContext rumContext = WebViewLogEventConsumer.this.rumContextProvider.getRumContext(datadogContext);
                    final WebViewLogEventConsumer webViewLogEventConsumer = WebViewLogEventConsumer.this;
                    final Pair<JsonObject, String> pair = event;
                    writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.consume.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                            invoke2(eventBatchWriter);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(EventBatchWriter it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            webViewLogEventConsumer.getUserLogsWriter$dd_sdk_android_webview_release().write(it, webViewLogEventConsumer.map(pair.getFirst(), datadogContext, rumContext), EventType.DEFAULT);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject map(JsonObject event, DatadogContext datadogContext, RumContext rumContext) {
        addDdTags(event, datadogContext);
        correctDate(event, datadogContext);
        addAnonymousId(event, datadogContext);
        if (rumContext != null) {
            event.addProperty("application_id", rumContext.getApplicationId());
            event.addProperty("session_id", rumContext.getSessionId());
        }
        return event;
    }

    private final void addAnonymousId(JsonObject event, DatadogContext datadogContext) {
        String anonymousId = datadogContext.getUserInfo().getAnonymousId();
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

    private final void correctDate(JsonObject event, DatadogContext datadogContext) {
        try {
            JsonElement jsonElement = event.get("date");
            if (jsonElement != null) {
                event.addProperty("date", Long.valueOf(jsonElement.getAsLong() + datadogContext.getTime().getServerTimeOffsetMs()));
            }
        } catch (ClassCastException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.correctDate.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewLogEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.correctDate.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewLogEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
        } catch (NumberFormatException e3) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.correctDate.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewLogEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
        } catch (UnsupportedOperationException e4) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer.correctDate.5
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewLogEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e4, false, (Map) null, 48, (Object) null);
        }
    }

    private final void addDdTags(JsonObject event, DatadogContext datadogContext) {
        LinkedHashMap linkedHashMapEmptyMap;
        String asString;
        Pair pair;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("version", datadogContext.getVersion()), TuplesKt.to("env", datadogContext.getEnv()), TuplesKt.to("variant", datadogContext.getVariant()), TuplesKt.to("service", datadogContext.getService()));
        try {
            JsonElement jsonElement = event.get("ddtags");
            linkedHashMapEmptyMap = null;
            if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
                List<String> listSplit$default = StringsKt.split$default((CharSequence) asString, new String[]{DDTAGS_SEPARATOR}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList();
                for (String str : listSplit$default) {
                    int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, ServerSentEventKt.COLON, 0, false, 6, (Object) null);
                    if (iIndexOf$default == -1 || iIndexOf$default == StringsKt.getLastIndex(str)) {
                        pair = null;
                    } else {
                        String strSubstring = str.substring(0, iIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        String strSubstring2 = str.substring(iIndexOf$default + 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        pair = TuplesKt.to(strSubstring, strSubstring2);
                    }
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                }
                ArrayList<Pair> arrayList2 = arrayList;
                linkedHashMapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
                for (Pair pair2 : arrayList2) {
                    linkedHashMapEmptyMap.put(pair2.getFirst(), pair2.getSecond());
                }
            }
            if (linkedHashMapEmptyMap == null) {
                linkedHashMapEmptyMap = MapsKt.emptyMap();
            }
        } catch (ClassCastException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer$addDdTags$eventDdTags$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewLogEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer$addDdTags$eventDdTags$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewLogEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        } catch (UnsupportedOperationException e3) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.log.WebViewLogEventConsumer$addDdTags$eventDdTags$4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewLogEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        }
        Map mapPlus = MapsKt.plus(linkedHashMapEmptyMap, mapMapOf);
        ArrayList arrayList3 = new ArrayList(mapPlus.size());
        for (Map.Entry entry : mapPlus.entrySet()) {
            arrayList3.add(entry.getKey() + ServerSentEventKt.COLON + entry.getValue());
        }
        event.addProperty("ddtags", CollectionsKt.joinToString$default(arrayList3, DDTAGS_SEPARATOR, null, null, 0, null, null, 62, null));
    }

    /* JADX INFO: compiled from: WebViewLogEventConsumer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/webview/internal/log/WebViewLogEventConsumer$Companion;", "", "()V", "ANONYMOUS_ID_KEY_NAME", "", "DATE_KEY_NAME", "DDTAGS_KEY_NAME", "DDTAGS_SEPARATOR", "DEFAULT_SAMPLE_RATE", "", "INTERNAL_LOG_EVENT_TYPE", "JSON_PARSING_ERROR_MESSAGE", "LOG_EVENT_TYPES", "", "getLOG_EVENT_TYPES", "()Ljava/util/Set;", "USER_LOG_EVENT_TYPE", "USR_KEY_NAME", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getLOG_EVENT_TYPES() {
            return WebViewLogEventConsumer.LOG_EVENT_TYPES;
        }
    }
}
