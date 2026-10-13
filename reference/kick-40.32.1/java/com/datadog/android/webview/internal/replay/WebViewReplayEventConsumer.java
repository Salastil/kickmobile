package com.datadog.android.webview.internal.replay;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.webview.internal.WebViewEventConsumer;
import com.datadog.android.webview.internal.rum.WebViewRumEventContextProvider;
import com.datadog.android.webview.internal.rum.domain.RumContext;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewReplayEventConsumer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/webview/internal/replay/WebViewReplayEventConsumer;", "Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "Lcom/google/gson/JsonObject;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "dataWriter", "Lcom/datadog/android/api/storage/DataWriter;", "contextProvider", "Lcom/datadog/android/webview/internal/rum/WebViewRumEventContextProvider;", "webViewReplayEventMapper", "Lcom/datadog/android/webview/internal/replay/WebViewReplayEventMapper;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/api/storage/DataWriter;Lcom/datadog/android/webview/internal/rum/WebViewRumEventContextProvider;Lcom/datadog/android/webview/internal/replay/WebViewReplayEventMapper;)V", "getDataWriter$dd_sdk_android_webview_release", "()Lcom/datadog/android/api/storage/DataWriter;", "getWebViewReplayEventMapper$dd_sdk_android_webview_release", "()Lcom/datadog/android/webview/internal/replay/WebViewReplayEventMapper;", "consume", "", "event", "map", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "rumContext", "Lcom/datadog/android/webview/internal/rum/domain/RumContext;", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewReplayEventConsumer implements WebViewEventConsumer<JsonObject> {
    public static final String JSON_PARSING_ERROR_MESSAGE = "The bundled web Replay event could not be deserialized";
    public static final String SESSION_REPLAY_ENABLED_KEY = "session_replay_is_enabled";
    public static final String SESSION_TRACKED_STATE = "TRACKED";
    private final WebViewRumEventContextProvider contextProvider;
    private final DataWriter<JsonObject> dataWriter;
    private final FeatureSdkCore sdkCore;
    private final WebViewReplayEventMapper webViewReplayEventMapper;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String RECORD_KEY = "record";
    private static final Set<String> REPLAY_EVENT_TYPES = SetsKt.setOf(RECORD_KEY);

    public WebViewReplayEventConsumer(FeatureSdkCore sdkCore, DataWriter<JsonObject> dataWriter, WebViewRumEventContextProvider contextProvider, WebViewReplayEventMapper webViewReplayEventMapper) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(webViewReplayEventMapper, "webViewReplayEventMapper");
        this.sdkCore = sdkCore;
        this.dataWriter = dataWriter;
        this.contextProvider = contextProvider;
        this.webViewReplayEventMapper = webViewReplayEventMapper;
    }

    public final DataWriter<JsonObject> getDataWriter$dd_sdk_android_webview_release() {
        return this.dataWriter;
    }

    /* JADX INFO: renamed from: getWebViewReplayEventMapper$dd_sdk_android_webview_release, reason: from getter */
    public final WebViewReplayEventMapper getWebViewReplayEventMapper() {
        return this.webViewReplayEventMapper;
    }

    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public void consume(final JsonObject event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FeatureScope feature = this.sdkCore.getFeature(WebViewReplayFeature.WEB_REPLAY_FEATURE_NAME);
        if (feature != null) {
            feature.withWriteContext(SetsKt.setOf((Object[]) new String[]{"rum", "session-replay"}), new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.consume.1
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
                    final RumContext rumContext = WebViewReplayEventConsumer.this.contextProvider.getRumContext(datadogContext);
                    Map<String, Object> map = datadogContext.getFeaturesContext().get("session-replay");
                    Object obj = map != null ? map.get(WebViewReplayEventConsumer.SESSION_REPLAY_ENABLED_KEY) : null;
                    Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                    boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                    if (rumContext != null && Intrinsics.areEqual(rumContext.getSessionState(), WebViewReplayEventConsumer.SESSION_TRACKED_STATE) && zBooleanValue) {
                        final WebViewReplayEventConsumer webViewReplayEventConsumer = WebViewReplayEventConsumer.this;
                        final JsonObject jsonObject = event;
                        writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.consume.1.1
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
                                JsonObject map2 = webViewReplayEventConsumer.map(jsonObject, datadogContext, rumContext);
                                if (map2 != null) {
                                    webViewReplayEventConsumer.getDataWriter$dd_sdk_android_webview_release().write(it, map2, EventType.DEFAULT);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonObject map(JsonObject event, DatadogContext datadogContext, RumContext rumContext) {
        try {
            return this.webViewReplayEventMapper.mapEvent(event, rumContext, datadogContext);
        } catch (ClassCastException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.map.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewReplayEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        } catch (IllegalStateException e2) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.map.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewReplayEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return null;
        } catch (NumberFormatException e3) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.map.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewReplayEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
            return null;
        } catch (UnsupportedOperationException e4) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer.map.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewReplayEventConsumer.JSON_PARSING_ERROR_MESSAGE;
                }
            }, (Throwable) e4, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    /* JADX INFO: compiled from: WebViewReplayEventConsumer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/datadog/android/webview/internal/replay/WebViewReplayEventConsumer$Companion;", "", "()V", "JSON_PARSING_ERROR_MESSAGE", "", "RECORD_KEY", "REPLAY_EVENT_TYPES", "", "getREPLAY_EVENT_TYPES", "()Ljava/util/Set;", "SESSION_REPLAY_ENABLED_KEY", "SESSION_TRACKED_STATE", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getREPLAY_EVENT_TYPES() {
            return WebViewReplayEventConsumer.REPLAY_EVENT_TYPES;
        }
    }
}
