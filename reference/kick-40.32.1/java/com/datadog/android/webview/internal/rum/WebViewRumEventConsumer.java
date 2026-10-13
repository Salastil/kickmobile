package com.datadog.android.webview.internal.rum;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.webview.internal.WebViewEventConsumer;
import com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
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

/* JADX INFO: compiled from: WebViewRumEventConsumer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0017J*\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/webview/internal/rum/WebViewRumEventConsumer;", "Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "Lcom/google/gson/JsonObject;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "dataWriter", "Lcom/datadog/android/api/storage/DataWriter;", "offsetProvider", "Lcom/datadog/android/webview/internal/rum/TimestampOffsetProvider;", "webViewRumEventMapper", "Lcom/datadog/android/webview/internal/rum/WebViewRumEventMapper;", "contextProvider", "Lcom/datadog/android/webview/internal/rum/WebViewRumEventContextProvider;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/api/storage/DataWriter;Lcom/datadog/android/webview/internal/rum/TimestampOffsetProvider;Lcom/datadog/android/webview/internal/rum/WebViewRumEventMapper;Lcom/datadog/android/webview/internal/rum/WebViewRumEventContextProvider;)V", "getDataWriter$dd_sdk_android_webview_release", "()Lcom/datadog/android/api/storage/DataWriter;", "getOffsetProvider$dd_sdk_android_webview_release", "()Lcom/datadog/android/webview/internal/rum/TimestampOffsetProvider;", "consume", "", "event", "map", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "rumContext", "Lcom/datadog/android/webview/internal/rum/domain/RumContext;", "sessionReplayEnabled", "", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewRumEventConsumer implements WebViewEventConsumer<JsonObject> {
    public static final String ACTION_EVENT_TYPE = "action";
    public static final String ERROR_EVENT_TYPE = "error";
    public static final String JSON_PARSING_ERROR_MESSAGE = "The bundled web RUM event could not be deserialized";
    public static final String LONG_TASK_EVENT_TYPE = "long_task";
    public static final String RESOURCE_EVENT_TYPE = "resource";
    public static final String RUM_EVENT_TYPE = "rum";
    public static final String TRACE_SAMPLE_RATE_KEY = "okhttp_interceptor_sample_rate";
    public static final String VIEW_EVENT_TYPE = "view";
    public static final String VIEW_ID_KEY_NAME = "id";
    public static final String VIEW_KEY_NAME = "view";
    private final WebViewRumEventContextProvider contextProvider;
    private final DataWriter<JsonObject> dataWriter;
    private final TimestampOffsetProvider offsetProvider;
    private final FeatureSdkCore sdkCore;
    private final WebViewRumEventMapper webViewRumEventMapper;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> RUM_EVENT_TYPES = SetsKt.setOf((Object[]) new String[]{"view", "action", "resource", "long_task", "error", "rum"});

    public WebViewRumEventConsumer(FeatureSdkCore sdkCore, DataWriter<JsonObject> dataWriter, TimestampOffsetProvider offsetProvider, WebViewRumEventMapper webViewRumEventMapper, WebViewRumEventContextProvider contextProvider) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        Intrinsics.checkNotNullParameter(offsetProvider, "offsetProvider");
        Intrinsics.checkNotNullParameter(webViewRumEventMapper, "webViewRumEventMapper");
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        this.sdkCore = sdkCore;
        this.dataWriter = dataWriter;
        this.offsetProvider = offsetProvider;
        this.webViewRumEventMapper = webViewRumEventMapper;
        this.contextProvider = contextProvider;
    }

    public final DataWriter<JsonObject> getDataWriter$dd_sdk_android_webview_release() {
        return this.dataWriter;
    }

    /* JADX INFO: renamed from: getOffsetProvider$dd_sdk_android_webview_release, reason: from getter */
    public final TimestampOffsetProvider getOffsetProvider() {
        return this.offsetProvider;
    }

    public /* synthetic */ WebViewRumEventConsumer(FeatureSdkCore featureSdkCore, DataWriter dataWriter, TimestampOffsetProvider timestampOffsetProvider, WebViewRumEventMapper webViewRumEventMapper, WebViewRumEventContextProvider webViewRumEventContextProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, dataWriter, timestampOffsetProvider, webViewRumEventMapper, (i & 16) != 0 ? new WebViewRumEventContextProvider(featureSdkCore.getInternalLogger()) : webViewRumEventContextProvider);
    }

    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public void consume(final JsonObject event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FeatureScope feature = this.sdkCore.getFeature("rum");
        if (feature != null) {
            feature.sendEvent(MapsKt.mapOf(TuplesKt.to("type", RumFeature.WEB_VIEW_INGESTED_NOTIFICATION_MESSAGE_TYPE)));
        }
        FeatureScope feature2 = this.sdkCore.getFeature(WebViewRumFeature.WEB_RUM_FEATURE_NAME);
        if (feature2 != null) {
            feature2.withWriteContext(SetsKt.setOf((Object[]) new String[]{"rum", "session-replay", "tracing"}), new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.consume.1
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
                    final RumContext rumContext = WebViewRumEventConsumer.this.contextProvider.getRumContext(datadogContext);
                    if (rumContext == null || !Intrinsics.areEqual(rumContext.getSessionState(), WebViewReplayEventConsumer.SESSION_TRACKED_STATE)) {
                        return;
                    }
                    Map<String, Object> map = datadogContext.getFeaturesContext().get("session-replay");
                    Object obj = map != null ? map.get(WebViewReplayEventConsumer.SESSION_REPLAY_ENABLED_KEY) : null;
                    Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                    final boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                    final WebViewRumEventConsumer webViewRumEventConsumer = WebViewRumEventConsumer.this;
                    final JsonObject jsonObject = event;
                    writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.consume.1.1
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
                            webViewRumEventConsumer.getDataWriter$dd_sdk_android_webview_release().write(it, webViewRumEventConsumer.map(jsonObject, datadogContext, rumContext, zBooleanValue), EventType.DEFAULT);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject map(JsonObject event, DatadogContext datadogContext, RumContext rumContext, boolean sessionReplayEnabled) {
        DatadogContext datadogContext2;
        long offset$dd_sdk_android_webview_release;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String asString;
        try {
            JsonElement jsonElement2 = event.get("view");
            if (jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("id")) == null || (asString = jsonElement.getAsString()) == null) {
                datadogContext2 = datadogContext;
                offset$dd_sdk_android_webview_release = 0;
            } else {
                datadogContext2 = datadogContext;
                offset$dd_sdk_android_webview_release = this.offsetProvider.getOffset$dd_sdk_android_webview_release(asString, datadogContext2);
            }
            long j = offset$dd_sdk_android_webview_release;
            Map<String, Object> map = datadogContext2.getFeaturesContext().get("tracing");
            Object obj = map != null ? map.get("okhttp_interceptor_sample_rate") : null;
            Number number = obj instanceof Number ? (Number) obj : null;
            return this.webViewRumEventMapper.mapEvent(event, rumContext, j, sessionReplayEnabled, datadogContext2.getUserInfo().getAnonymousId(), datadogContext2, number != null ? Float.valueOf(number.floatValue()) : null);
        } catch (ClassCastException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.map.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewRumEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return event;
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.map.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewRumEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return event;
        } catch (NumberFormatException e3) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.map.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewRumEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
            return event;
        } catch (UnsupportedOperationException e4) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.rum.WebViewRumEventConsumer.map.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewRumEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e4, false, (Map) null, 48, (Object) null);
            return event;
        }
    }

    /* JADX INFO: compiled from: WebViewRumEventConsumer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/webview/internal/rum/WebViewRumEventConsumer$Companion;", "", "()V", "ACTION_EVENT_TYPE", "", "ERROR_EVENT_TYPE", "JSON_PARSING_ERROR_MESSAGE", "LONG_TASK_EVENT_TYPE", "RESOURCE_EVENT_TYPE", "RUM_EVENT_TYPE", "RUM_EVENT_TYPES", "", "getRUM_EVENT_TYPES", "()Ljava/util/Set;", "TRACE_SAMPLE_RATE_KEY", "VIEW_EVENT_TYPE", "VIEW_ID_KEY_NAME", "VIEW_KEY_NAME", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getRUM_EVENT_TYPES() {
            return WebViewRumEventConsumer.RUM_EVENT_TYPES;
        }
    }
}
