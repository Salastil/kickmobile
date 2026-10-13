package com.datadog.android.webview;

import android.webkit.WebView;
import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.webview.internal.DatadogEventBridge;
import com.datadog.android.webview.internal.MixedWebViewEventConsumer;
import com.datadog.android.webview.internal.NoOpWebViewEventConsumer;
import com.datadog.android.webview.internal.WebViewEventConsumer;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.datadog.android.webview.internal.log.WebViewLogsFeature;
import com.datadog.android.webview.internal.replay.WebViewReplayEventConsumer;
import com.datadog.android.webview.internal.replay.WebViewReplayEventMapper;
import com.datadog.android.webview.internal.replay.WebViewReplayFeature;
import com.datadog.android.webview.internal.rum.TimestampOffsetProvider;
import com.datadog.android.webview.internal.rum.WebViewRumEventConsumer;
import com.datadog.android.webview.internal.rum.WebViewRumEventContextProvider;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.datadog.android.webview.internal.rum.WebViewRumFeature;
import com.datadog.android.webview.internal.rum.domain.NoOpNativeRumViewsCache;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewTracking.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J2\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\"2\b\b\u0003\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0018\u001a\u00020#H\u0007J \u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0002J \u0010)\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010,\u001a\u00020\u00042\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010.H\u0002J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/datadog/android/webview/WebViewTracking;", "", "()V", "DATADOG_EVENT_BRIDGE_NAME", "", "JAVA_SCRIPT_NOT_ENABLED_WARNING_MESSAGE", "LOGS_FEATURE_MISSING_INFO", "RUM_FEATURE_MISSING_INFO", "SESSION_REPLAY_FEATURE_MISSING_INFO", "SESSION_REPLAY_IMAGE_PRIVACY_KEY", "SESSION_REPLAY_MASK_ALL_IMAGE_PRIVACY", "SESSION_REPLAY_MASK_ALL_PRIVACY", "SESSION_REPLAY_MASK_ALL_TEXT_PRIVACY", "SESSION_REPLAY_MASK_ALL_TOUCH_PRIVACY", "SESSION_REPLAY_MASK_INPUTS_PRIVACY", "SESSION_REPLAY_MASK_INPUTS_TEXT_PRIVACY", "SESSION_REPLAY_MASK_NONE_IMAGE_PRIVACY", "SESSION_REPLAY_MASK_NONE_PRIVACY", "SESSION_REPLAY_MASK_NONE_TEXT_PRIVACY", "SESSION_REPLAY_MASK_NONE_TOUCH_PRIVACY", "SESSION_REPLAY_TEXT_AND_INPUT_PRIVACY_KEY", "SESSION_REPLAY_TOUCH_PRIVACY_KEY", "buildWebViewEventConsumer", "Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "logsSampleRate", "", "webViewId", "enable", "", "webView", "Landroid/webkit/WebView;", "allowedHosts", "", "Lcom/datadog/android/api/SdkCore;", "isMaskInputs", "", "imagePrivacy", "touchPrivacy", "textAndInputPrivacy", "isMaskNone", "resolveLogsFeature", "Lcom/datadog/android/webview/internal/log/WebViewLogsFeature;", "resolvePrivacy", "featureContext", "", "resolveReplayFeature", "Lcom/datadog/android/webview/internal/replay/WebViewReplayFeature;", "resolveRumFeature", "Lcom/datadog/android/webview/internal/rum/WebViewRumFeature;", "_InternalWebViewProxy", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewTracking {
    public static final String DATADOG_EVENT_BRIDGE_NAME = "DatadogEventBridge";
    public static final WebViewTracking INSTANCE = new WebViewTracking();
    public static final String JAVA_SCRIPT_NOT_ENABLED_WARNING_MESSAGE = "You are trying to enable the WebView tracking but the java script capability was not enabled for the given WebView.";
    public static final String LOGS_FEATURE_MISSING_INFO = "Logs feature is not registered, will ignore Log events from WebView.";
    public static final String RUM_FEATURE_MISSING_INFO = "RUM feature is not registered, will ignore RUM events from WebView.";
    public static final String SESSION_REPLAY_FEATURE_MISSING_INFO = "Session replay feature is not registered, will ignore replay records from WebView.";
    public static final String SESSION_REPLAY_IMAGE_PRIVACY_KEY = "session_replay_image_privacy";
    public static final String SESSION_REPLAY_MASK_ALL_IMAGE_PRIVACY = "mask_all";
    public static final String SESSION_REPLAY_MASK_ALL_PRIVACY = "mask";
    public static final String SESSION_REPLAY_MASK_ALL_TEXT_PRIVACY = "mask_all";
    public static final String SESSION_REPLAY_MASK_ALL_TOUCH_PRIVACY = "hide";
    public static final String SESSION_REPLAY_MASK_INPUTS_PRIVACY = "mask_user_input";
    public static final String SESSION_REPLAY_MASK_INPUTS_TEXT_PRIVACY = "mask_all_inputs";
    public static final String SESSION_REPLAY_MASK_NONE_IMAGE_PRIVACY = "mask_none";
    public static final String SESSION_REPLAY_MASK_NONE_PRIVACY = "allow";
    public static final String SESSION_REPLAY_MASK_NONE_TEXT_PRIVACY = "mask_sensitive_inputs";
    public static final String SESSION_REPLAY_MASK_NONE_TOUCH_PRIVACY = "show";
    public static final String SESSION_REPLAY_TEXT_AND_INPUT_PRIVACY_KEY = "session_replay_text_and_input_privacy";
    public static final String SESSION_REPLAY_TOUCH_PRIVACY_KEY = "session_replay_touch_privacy";

    @JvmStatic
    public static final void enable(WebView webView, List<String> allowedHosts) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(allowedHosts, "allowedHosts");
        enable$default(webView, allowedHosts, 0.0f, null, 12, null);
    }

    @JvmStatic
    public static final void enable(WebView webView, List<String> allowedHosts, float f) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(allowedHosts, "allowedHosts");
        enable$default(webView, allowedHosts, f, null, 8, null);
    }

    private WebViewTracking() {
    }

    public static /* synthetic */ void enable$default(WebView webView, List list, float f, SdkCore sdkCore, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 100.0f;
        }
        if ((i & 8) != 0) {
            sdkCore = Datadog.getInstance$default(null, 1, null);
        }
        enable(webView, list, f, sdkCore);
    }

    @JvmStatic
    public static final void enable(WebView webView, List<String> allowedHosts, float logsSampleRate, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(allowedHosts, "allowedHosts");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
        if (!webView.getSettings().getJavaScriptEnabled()) {
            InternalLogger.DefaultImpls.log$default(featureSdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.webview.WebViewTracking.enable.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return WebViewTracking.JAVA_SCRIPT_NOT_ENABLED_WARNING_MESSAGE;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        Map<String, ? extends Object> featureContext = featureSdkCore.getFeatureContext("session-replay", false);
        WebViewTracking webViewTracking = INSTANCE;
        String strResolvePrivacy = webViewTracking.resolvePrivacy(featureContext);
        WebViewEventConsumer<String> webViewEventConsumerBuildWebViewEventConsumer = webViewTracking.buildWebViewEventConsumer(featureSdkCore, logsSampleRate, String.valueOf(System.identityHashCode(webView)));
        FeatureScope feature = featureSdkCore.getFeature(WebViewRumFeature.WEB_RUM_FEATURE_NAME);
        StorageBackedFeature storageBackedFeature = feature != null ? (StorageBackedFeature) feature.unwrap() : null;
        webView.addJavascriptInterface(new DatadogEventBridge(webViewEventConsumerBuildWebViewEventConsumer, allowedHosts, strResolvePrivacy, storageBackedFeature instanceof WebViewRumFeature ? (WebViewRumFeature) storageBackedFeature : null, featureSdkCore.getInternalLogger()), DATADOG_EVENT_BRIDGE_NAME);
        InternalLogger.DefaultImpls.logApiUsage$default(featureSdkCore.getInternalLogger(), 0.0f, new Function0<InternalTelemetryEvent.ApiUsage>() { // from class: com.datadog.android.webview.WebViewTracking.enable.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InternalTelemetryEvent.ApiUsage invoke() {
                return new InternalTelemetryEvent.ApiUsage.TrackWebView(null, 1, null);
            }
        }, 1, null);
    }

    private final String resolvePrivacy(Map<String, ? extends Object> featureContext) {
        Object obj = featureContext.get("session_replay_image_privacy");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "mask_all";
        }
        Object obj2 = featureContext.get("session_replay_touch_privacy");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null) {
            str2 = SESSION_REPLAY_MASK_ALL_TOUCH_PRIVACY;
        }
        Object obj3 = featureContext.get("session_replay_text_and_input_privacy");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        String str4 = str3 != null ? str3 : "mask_all";
        if (isMaskNone(str, str2, str4)) {
            return SESSION_REPLAY_MASK_NONE_PRIVACY;
        }
        if (isMaskInputs(str, str2, str4)) {
            return SESSION_REPLAY_MASK_INPUTS_PRIVACY;
        }
        return SESSION_REPLAY_MASK_ALL_PRIVACY;
    }

    private final boolean isMaskNone(String imagePrivacy, String touchPrivacy, String textAndInputPrivacy) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = touchPrivacy.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!Intrinsics.areEqual(lowerCase, SESSION_REPLAY_MASK_NONE_TOUCH_PRIVACY)) {
            return false;
        }
        Locale US2 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US2, "US");
        String lowerCase2 = imagePrivacy.toLowerCase(US2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (!Intrinsics.areEqual(lowerCase2, SESSION_REPLAY_MASK_NONE_IMAGE_PRIVACY)) {
            return false;
        }
        Locale US3 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US3, "US");
        String lowerCase3 = textAndInputPrivacy.toLowerCase(US3);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase3, SESSION_REPLAY_MASK_NONE_TEXT_PRIVACY);
    }

    private final boolean isMaskInputs(String imagePrivacy, String touchPrivacy, String textAndInputPrivacy) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = touchPrivacy.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!Intrinsics.areEqual(lowerCase, SESSION_REPLAY_MASK_NONE_TOUCH_PRIVACY)) {
            return false;
        }
        Locale US2 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US2, "US");
        String lowerCase2 = imagePrivacy.toLowerCase(US2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (!Intrinsics.areEqual(lowerCase2, SESSION_REPLAY_MASK_NONE_IMAGE_PRIVACY)) {
            return false;
        }
        Locale US3 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US3, "US");
        String lowerCase3 = textAndInputPrivacy.toLowerCase(US3);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase3, SESSION_REPLAY_MASK_INPUTS_TEXT_PRIVACY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WebViewEventConsumer<String> buildWebViewEventConsumer(FeatureSdkCore sdkCore, float logsSampleRate, String webViewId) {
        NoOpNativeRumViewsCache noOpNativeRumViewsCache;
        NoOpDataWriter noOpDataWriter;
        NoOpWebViewEventConsumer noOpWebViewEventConsumer;
        NoOpDataWriter noOpDataWriter2;
        NoOpDataWriter noOpDataWriter3;
        WebViewRumFeature webViewRumFeatureResolveRumFeature = resolveRumFeature(sdkCore);
        WebViewLogsFeature webViewLogsFeatureResolveLogsFeature = resolveLogsFeature(sdkCore);
        WebViewReplayFeature webViewReplayFeatureResolveReplayFeature = resolveReplayFeature(sdkCore);
        if (webViewLogsFeatureResolveLogsFeature == null && webViewRumFeatureResolveRumFeature == null) {
            return new NoOpWebViewEventConsumer();
        }
        TimestampOffsetProvider timestampOffsetProvider = new TimestampOffsetProvider(sdkCore.getInternalLogger());
        WebViewRumEventContextProvider webViewRumEventContextProvider = new WebViewRumEventContextProvider(sdkCore.getInternalLogger());
        if (webViewRumFeatureResolveRumFeature == null || (noOpNativeRumViewsCache = webViewRumFeatureResolveRumFeature.getNativeRumViewsCache()) == null) {
            noOpNativeRumViewsCache = new NoOpNativeRumViewsCache();
        }
        if (webViewRumFeatureResolveRumFeature == null || (noOpDataWriter = webViewRumFeatureResolveRumFeature.getDataWriter$dd_sdk_android_webview_release()) == null) {
            noOpDataWriter = new NoOpDataWriter();
        }
        WebViewRumEventConsumer webViewRumEventConsumer = new WebViewRumEventConsumer(sdkCore, noOpDataWriter, timestampOffsetProvider, new WebViewRumEventMapper(noOpNativeRumViewsCache), webViewRumEventContextProvider);
        if (webViewId != null) {
            if (webViewReplayFeatureResolveReplayFeature == null || (noOpDataWriter3 = webViewReplayFeatureResolveReplayFeature.getDataWriter$dd_sdk_android_webview_release()) == null) {
                noOpDataWriter3 = new NoOpDataWriter();
            }
            noOpWebViewEventConsumer = new WebViewReplayEventConsumer(sdkCore, noOpDataWriter3, webViewRumEventContextProvider, new WebViewReplayEventMapper(webViewId, timestampOffsetProvider));
        } else {
            noOpWebViewEventConsumer = new NoOpWebViewEventConsumer();
        }
        if (webViewLogsFeatureResolveLogsFeature == null || (noOpDataWriter2 = webViewLogsFeatureResolveLogsFeature.getDataWriter$dd_sdk_android_webview_release()) == null) {
            noOpDataWriter2 = new NoOpDataWriter();
        }
        return new MixedWebViewEventConsumer(webViewRumEventConsumer, noOpWebViewEventConsumer, new WebViewLogEventConsumer(sdkCore, noOpDataWriter2, webViewRumEventContextProvider, logsSampleRate), sdkCore.getInternalLogger());
    }

    private final WebViewRumFeature resolveRumFeature(FeatureSdkCore sdkCore) {
        FeatureScope feature = sdkCore.getFeature(WebViewRumFeature.WEB_RUM_FEATURE_NAME);
        StorageBackedFeature storageBackedFeature = feature != null ? (StorageBackedFeature) feature.unwrap() : null;
        WebViewRumFeature webViewRumFeature = storageBackedFeature instanceof WebViewRumFeature ? (WebViewRumFeature) storageBackedFeature : null;
        if (webViewRumFeature != null) {
            return webViewRumFeature;
        }
        FeatureScope feature2 = sdkCore.getFeature("rum");
        StorageBackedFeature storageBackedFeature2 = feature2 != null ? (StorageBackedFeature) feature2.unwrap() : null;
        if (storageBackedFeature2 != null) {
            WebViewRumFeature webViewRumFeature2 = new WebViewRumFeature(sdkCore, storageBackedFeature2.getRequestFactory(), null, 4, null);
            sdkCore.registerFeature(webViewRumFeature2);
            return webViewRumFeature2;
        }
        InternalLogger.DefaultImpls.log$default(sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.webview.WebViewTracking.resolveRumFeature.3
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return WebViewTracking.RUM_FEATURE_MISSING_INFO;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    private final WebViewReplayFeature resolveReplayFeature(FeatureSdkCore sdkCore) {
        FeatureScope feature = sdkCore.getFeature(WebViewReplayFeature.WEB_REPLAY_FEATURE_NAME);
        StorageBackedFeature storageBackedFeature = feature != null ? (StorageBackedFeature) feature.unwrap() : null;
        WebViewReplayFeature webViewReplayFeature = storageBackedFeature instanceof WebViewReplayFeature ? (WebViewReplayFeature) storageBackedFeature : null;
        if (webViewReplayFeature != null) {
            return webViewReplayFeature;
        }
        FeatureScope feature2 = sdkCore.getFeature("session-replay");
        StorageBackedFeature storageBackedFeature2 = feature2 != null ? (StorageBackedFeature) feature2.unwrap() : null;
        if (storageBackedFeature2 != null) {
            WebViewReplayFeature webViewReplayFeature2 = new WebViewReplayFeature(sdkCore, storageBackedFeature2.getRequestFactory());
            sdkCore.registerFeature(webViewReplayFeature2);
            return webViewReplayFeature2;
        }
        InternalLogger.DefaultImpls.log$default(sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.webview.WebViewTracking.resolveReplayFeature.3
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return WebViewTracking.SESSION_REPLAY_FEATURE_MISSING_INFO;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    private final WebViewLogsFeature resolveLogsFeature(FeatureSdkCore sdkCore) {
        FeatureScope feature = sdkCore.getFeature(WebViewLogsFeature.WEB_LOGS_FEATURE_NAME);
        StorageBackedFeature storageBackedFeature = feature != null ? (StorageBackedFeature) feature.unwrap() : null;
        WebViewLogsFeature webViewLogsFeature = storageBackedFeature instanceof WebViewLogsFeature ? (WebViewLogsFeature) storageBackedFeature : null;
        if (webViewLogsFeature != null) {
            return webViewLogsFeature;
        }
        FeatureScope feature2 = sdkCore.getFeature("logs");
        StorageBackedFeature storageBackedFeature2 = feature2 != null ? (StorageBackedFeature) feature2.unwrap() : null;
        if (storageBackedFeature2 != null) {
            WebViewLogsFeature webViewLogsFeature2 = new WebViewLogsFeature(sdkCore, storageBackedFeature2.getRequestFactory());
            sdkCore.registerFeature(webViewLogsFeature2);
            return webViewLogsFeature2;
        }
        InternalLogger.DefaultImpls.log$default(sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.webview.WebViewTracking.resolveLogsFeature.3
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return WebViewTracking.LOGS_FEATURE_MISSING_INFO;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    /* JADX INFO: compiled from: WebViewTracking.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/webview/WebViewTracking$_InternalWebViewProxy;", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "webViewId", "", "(Lcom/datadog/android/api/SdkCore;Ljava/lang/String;)V", "consumer", "Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "getConsumer$dd_sdk_android_webview_release", "()Lcom/datadog/android/webview/internal/WebViewEventConsumer;", "consumeWebviewEvent", "", "event", "dd-sdk-android-webview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class _InternalWebViewProxy {
        private final WebViewEventConsumer<String> consumer;

        public _InternalWebViewProxy(SdkCore sdkCore, String str) {
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            this.consumer = WebViewTracking.INSTANCE.buildWebViewEventConsumer((FeatureSdkCore) sdkCore, 100.0f, str);
        }

        public /* synthetic */ _InternalWebViewProxy(SdkCore sdkCore, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(sdkCore, (i & 2) != 0 ? null : str);
        }

        public final WebViewEventConsumer<String> getConsumer$dd_sdk_android_webview_release() {
            return this.consumer;
        }

        public final void consumeWebviewEvent(String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.consumer.consume(event);
        }
    }
}
