package com.datadog.android.webview.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer;
import com.datadog.android.webview.internal.rum.WebViewRumEventConsumer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MixedWebViewEventConsumer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012BC\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00070\u0001\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00070\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/datadog/android/webview/internal/MixedWebViewEventConsumer;", "Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "", "rumEventConsumer", "Lcom/google/gson/JsonObject;", "replayEventConsumer", "logsEventConsumer", "Lkotlin/Pair;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/webview/internal/WebViewEventConsumer;Lcom/datadog/android/webview/internal/WebViewEventConsumer;Lcom/datadog/android/webview/internal/WebViewEventConsumer;Lcom/datadog/android/api/InternalLogger;)V", "getLogsEventConsumer$dd_sdk_android_webview_release", "()Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "getReplayEventConsumer$dd_sdk_android_webview_release", "getRumEventConsumer$dd_sdk_android_webview_release", "consume", "", "event", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MixedWebViewEventConsumer implements WebViewEventConsumer<String> {
    public static final String EVENT_KEY = "event";
    public static final String EVENT_TYPE_KEY = "eventType";
    public static final String LOG_EVENT_TYPE = "log";
    public static final String WEB_EVENT_MISSING_TYPE_ERROR_MESSAGE = "The web event is missing the event type. Received keys: %s.";
    public static final String WEB_EVENT_MISSING_WRAPPED_EVENT = "The web event is missing the wrapped event object. Received keys: %s.";
    public static final String WEB_EVENT_PARSING_ERROR_MESSAGE = "We could not deserialize the delegated browser event (size: %d chars).";
    public static final String WRONG_EVENT_TYPE_ERROR_MESSAGE = "The event type %s for the bundled web event is unknown.";
    private final InternalLogger internalLogger;
    private final WebViewEventConsumer<Pair<JsonObject, String>> logsEventConsumer;
    private final WebViewEventConsumer<JsonObject> replayEventConsumer;
    private final WebViewEventConsumer<JsonObject> rumEventConsumer;

    public MixedWebViewEventConsumer(WebViewEventConsumer<JsonObject> rumEventConsumer, WebViewEventConsumer<JsonObject> replayEventConsumer, WebViewEventConsumer<Pair<JsonObject, String>> logsEventConsumer, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(rumEventConsumer, "rumEventConsumer");
        Intrinsics.checkNotNullParameter(replayEventConsumer, "replayEventConsumer");
        Intrinsics.checkNotNullParameter(logsEventConsumer, "logsEventConsumer");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.rumEventConsumer = rumEventConsumer;
        this.replayEventConsumer = replayEventConsumer;
        this.logsEventConsumer = logsEventConsumer;
        this.internalLogger = internalLogger;
    }

    public final WebViewEventConsumer<JsonObject> getRumEventConsumer$dd_sdk_android_webview_release() {
        return this.rumEventConsumer;
    }

    public final WebViewEventConsumer<JsonObject> getReplayEventConsumer$dd_sdk_android_webview_release() {
        return this.replayEventConsumer;
    }

    public final WebViewEventConsumer<Pair<JsonObject, String>> getLogsEventConsumer$dd_sdk_android_webview_release() {
        return this.logsEventConsumer;
    }

    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public void consume(final String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            final JsonObject webEvent = JsonParser.parseString(event).getAsJsonObject();
            if (!webEvent.has(EVENT_TYPE_KEY)) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.MixedWebViewEventConsumer.consume.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, MixedWebViewEventConsumer.WEB_EVENT_MISSING_TYPE_ERROR_MESSAGE, Arrays.copyOf(new Object[]{webEvent.keySet()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return;
            }
            if (!webEvent.has("event")) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.MixedWebViewEventConsumer.consume.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, MixedWebViewEventConsumer.WEB_EVENT_MISSING_WRAPPED_EVENT, Arrays.copyOf(new Object[]{webEvent.keySet()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return;
            }
            final String asString = webEvent.get(EVENT_TYPE_KEY).getAsString();
            JsonObject wrappedEvent = webEvent.get("event").getAsJsonObject();
            if (WebViewLogEventConsumer.INSTANCE.getLOG_EVENT_TYPES().contains(asString)) {
                this.logsEventConsumer.consume(TuplesKt.to(wrappedEvent, asString));
                return;
            }
            if (WebViewRumEventConsumer.INSTANCE.getRUM_EVENT_TYPES().contains(asString)) {
                WebViewEventConsumer<JsonObject> webViewEventConsumer = this.rumEventConsumer;
                Intrinsics.checkNotNullExpressionValue(wrappedEvent, "wrappedEvent");
                webViewEventConsumer.consume(wrappedEvent);
            } else {
                if (WebViewReplayEventConsumer.INSTANCE.getREPLAY_EVENT_TYPES().contains(asString)) {
                    WebViewEventConsumer<JsonObject> webViewEventConsumer2 = this.replayEventConsumer;
                    Intrinsics.checkNotNullExpressionValue(webEvent, "webEvent");
                    webViewEventConsumer2.consume(webEvent);
                    return;
                }
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.MixedWebViewEventConsumer.consume.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, MixedWebViewEventConsumer.WRONG_EVENT_TYPE_ERROR_MESSAGE, Arrays.copyOf(new Object[]{asString}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        } catch (JsonParseException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.webview.internal.MixedWebViewEventConsumer.consume.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, MixedWebViewEventConsumer.WEB_EVENT_PARSING_ERROR_MESSAGE, Arrays.copyOf(new Object[]{Integer.valueOf(event.length())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }
}
