package com.datadog.android.webview.internal;

import android.webkit.JavascriptInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.HostsSanitizer;
import com.datadog.android.core.sampling.DeterministicSampler;
import com.datadog.android.internal.sampling.DeterministicSampling;
import com.datadog.android.internal.sampling.SessionSamplingIdProvider;
import com.datadog.android.webview.internal.replay.WebViewReplayEventMapper;
import com.datadog.android.webview.internal.rum.WebViewRumFeature;
import com.google.gson.JsonArray;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogEventBridge.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/webview/internal/DatadogEventBridge;", "", "webViewEventConsumer", "Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "", "allowedHosts", "", "privacyLevel", "webViewRumFeature", "Lcom/datadog/android/webview/internal/rum/WebViewRumFeature;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/webview/internal/WebViewEventConsumer;Ljava/util/List;Ljava/lang/String;Lcom/datadog/android/webview/internal/rum/WebViewRumFeature;Lcom/datadog/android/api/InternalLogger;)V", "hostsSanitizer", "Lcom/datadog/android/core/configuration/HostsSanitizer;", "getWebViewEventConsumer$dd_sdk_android_webview_release", "()Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "getAllowedWebViewHosts", "getCapabilities", "getIsTraceSampled", "getPrivacyLevel", "send", "", "event", "Companion", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogEventBridge {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FALSE_STRING = "false";
    private static final String NULL_STRING = "null";
    private static final String SESSION_ID_KEY = "session_id";
    private static final String SESSION_SAMPLE_RATE_KEY = "session_sample_rate";
    private static final String SESSION_STATE_KEY = "session_state";
    private static final String TRACE_SAMPLE_RATE_KEY = "okhttp_interceptor_sample_rate";
    private static final String TRACKED_STATE = "TRACKED";
    private static final String TRUE_STRING = "true";
    public static final String WEB_VIEW_TRACKING_FEATURE_NAME = "WebView";
    private static final JsonArray capabilities;
    private final List<String> allowedHosts;
    private final HostsSanitizer hostsSanitizer;
    private final String privacyLevel;
    private final WebViewEventConsumer<String> webViewEventConsumer;
    private final WebViewRumFeature webViewRumFeature;

    public DatadogEventBridge(WebViewEventConsumer<String> webViewEventConsumer, List<String> allowedHosts, String privacyLevel, WebViewRumFeature webViewRumFeature, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(webViewEventConsumer, "webViewEventConsumer");
        Intrinsics.checkNotNullParameter(allowedHosts, "allowedHosts");
        Intrinsics.checkNotNullParameter(privacyLevel, "privacyLevel");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.webViewEventConsumer = webViewEventConsumer;
        this.allowedHosts = allowedHosts;
        this.privacyLevel = privacyLevel;
        this.webViewRumFeature = webViewRumFeature;
        this.hostsSanitizer = new HostsSanitizer(internalLogger);
    }

    public final WebViewEventConsumer<String> getWebViewEventConsumer$dd_sdk_android_webview_release() {
        return this.webViewEventConsumer;
    }

    @JavascriptInterface
    public final void send(String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.webViewEventConsumer.consume(event);
    }

    @JavascriptInterface
    public final String getAllowedWebViewHosts() {
        JsonArray jsonArray = new JsonArray();
        Iterator<T> it = this.hostsSanitizer.sanitizeHosts(this.allowedHosts, WEB_VIEW_TRACKING_FEATURE_NAME).iterator();
        while (it.hasNext()) {
            jsonArray.add((String) it.next());
        }
        String string = jsonArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "origins.toString()");
        return string;
    }

    @JavascriptInterface
    public final String getPrivacyLevel() {
        return this.privacyLevel;
    }

    @JavascriptInterface
    public final String getCapabilities() {
        String string = capabilities.toString();
        Intrinsics.checkNotNullExpressionValue(string, "capabilities.toString()");
        return string;
    }

    @JavascriptInterface
    public final String getIsTraceSampled() {
        WebViewRumFeature webViewRumFeature = this.webViewRumFeature;
        Map<String, Object> cachedRumContext$dd_sdk_android_webview_release = webViewRumFeature != null ? webViewRumFeature.getCachedRumContext$dd_sdk_android_webview_release() : null;
        if (cachedRumContext$dd_sdk_android_webview_release == null) {
            cachedRumContext$dd_sdk_android_webview_release = MapsKt.emptyMap();
        }
        WebViewRumFeature webViewRumFeature2 = this.webViewRumFeature;
        Map<String, Object> cachedTracingContext$dd_sdk_android_webview_release = webViewRumFeature2 != null ? webViewRumFeature2.getCachedTracingContext$dd_sdk_android_webview_release() : null;
        if (cachedTracingContext$dd_sdk_android_webview_release == null) {
            cachedTracingContext$dd_sdk_android_webview_release = MapsKt.emptyMap();
        }
        Object obj = cachedRumContext$dd_sdk_android_webview_release.get("session_id");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null || !Intrinsics.areEqual(cachedRumContext$dd_sdk_android_webview_release.get("session_state"), "TRACKED")) {
            str = null;
        }
        Object obj2 = cachedRumContext$dd_sdk_android_webview_release.get("session_sample_rate");
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        Float fValueOf = number != null ? Float.valueOf(number.floatValue()) : null;
        Object obj3 = cachedTracingContext$dd_sdk_android_webview_release.get("okhttp_interceptor_sample_rate");
        Number number2 = obj3 instanceof Number ? (Number) obj3 : null;
        Float fValueOf2 = number2 != null ? Float.valueOf(number2.floatValue()) : null;
        if (str == null || fValueOf == null || fValueOf2 == null) {
            return "null";
        }
        return new DeterministicSampler((Function1) new DatadogEventBridge$getIsTraceSampled$sampler$1(SessionSamplingIdProvider.INSTANCE), DeterministicSampling.INSTANCE.combinedSampleRate(fValueOf.floatValue(), fValueOf2.floatValue())).sample(str) ? TRUE_STRING : "false";
    }

    /* JADX INFO: compiled from: DatadogEventBridge.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/webview/internal/DatadogEventBridge$Companion;", "", "()V", "FALSE_STRING", "", "NULL_STRING", "SESSION_ID_KEY", "SESSION_SAMPLE_RATE_KEY", "SESSION_STATE_KEY", "TRACE_SAMPLE_RATE_KEY", "TRACKED_STATE", "TRUE_STRING", "WEB_VIEW_TRACKING_FEATURE_NAME", "capabilities", "Lcom/google/gson/JsonArray;", "getCapabilities$dd_sdk_android_webview_release", "()Lcom/google/gson/JsonArray;", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JsonArray getCapabilities$dd_sdk_android_webview_release() {
            return DatadogEventBridge.capabilities;
        }
    }

    static {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(WebViewReplayEventMapper.RECORDS_KEY);
        capabilities = jsonArray;
    }
}
