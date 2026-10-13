package com.datadog.reactnative;

import android.content.Context;
import com.datadog.android.Datadog;
import com.datadog.android.api.SdkCore;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.webview.WebViewTracking;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogSDKWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J:\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010#0\"H\u0016J\u001e\u0010$\u001a\u00020\u00122\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010#0\"H\u0016J\b\u0010%\u001a\u00020\u0012H\u0016J0\u0010&\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010#0\"H\u0016J\u001e\u0010'\u001a\u00020\u00122\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010#0\"H\u0016J\b\u0010(\u001a\u00020\u0012H\u0016J\u001a\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001eH\u0016J\u001e\u0010-\u001a\u00020\u00122\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010#0\"H\u0016J\u001b\u0010/\u001a\u00020\u00122\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001e01H\u0016¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u001eH\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u0012H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006;"}, d2 = {"Lcom/datadog/reactnative/DatadogSDKWrapper;", "Lcom/datadog/reactnative/DatadogWrapper;", "<init>", "()V", "bundleLogsWithRum", "", "getBundleLogsWithRum", "()Z", "setBundleLogsWithRum", "(Z)V", "bundleLogsWithTraces", "getBundleLogsWithTraces", "setBundleLogsWithTraces", "webViewProxy", "Lcom/datadog/android/webview/WebViewTracking$_InternalWebViewProxy;", "getWebViewProxy", "()Lcom/datadog/android/webview/WebViewTracking$_InternalWebViewProxy;", "setVerbosity", "", FirebaseAnalytics.Param.LEVEL, "", "initialize", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lcom/datadog/android/core/configuration/Configuration;", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "Lcom/datadog/android/privacy/TrackingConsent;", "setUserInfo", "id", "", "name", "email", "extraInfo", "", "", "addUserExtraInfo", "clearUserInfo", "setAccountInfo", "addAccountExtraInfo", "clearAccountInfo", "addRumGlobalAttribute", "key", "value", "removeRumGlobalAttribute", "addRumGlobalAttributes", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "removeRumGlobalAttributes", UserMetadata.KEYDATA_FILENAME, "", "([Ljava/lang/String;)V", "setTrackingConsent", "trackingConsent", "consumeWebviewEvent", "message", "isInitialized", "getRumMonitor", "Lcom/datadog/android/rum/RumMonitor;", "clearAllData", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DatadogSDKWrapper implements DatadogWrapper {
    private boolean bundleLogsWithRum = true;
    private boolean bundleLogsWithTraces = true;
    private WebViewTracking._InternalWebViewProxy webViewProxy;

    @Override // com.datadog.reactnative.DatadogWrapper
    public boolean getBundleLogsWithRum() {
        return this.bundleLogsWithRum;
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setBundleLogsWithRum(boolean z) {
        this.bundleLogsWithRum = z;
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public boolean getBundleLogsWithTraces() {
        return this.bundleLogsWithTraces;
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setBundleLogsWithTraces(boolean z) {
        this.bundleLogsWithTraces = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final WebViewTracking._InternalWebViewProxy getWebViewProxy() {
        if (this.webViewProxy == null && isInitialized()) {
            this.webViewProxy = new WebViewTracking._InternalWebViewProxy(Datadog.getInstance$default(null, 1, null), null, 2, 0 == true ? 1 : 0);
        }
        return this.webViewProxy;
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setVerbosity(int level) {
        Datadog.setVerbosity(level);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void initialize(Context context, Configuration configuration, TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(consent, "consent");
        SdkCore sdkCoreInitialize = Datadog.initialize(context, configuration, consent);
        DatadogSDKWrapperStorage datadogSDKWrapperStorage = DatadogSDKWrapperStorage.INSTANCE;
        Intrinsics.checkNotNull(sdkCoreInitialize, "null cannot be cast to non-null type com.datadog.android.core.InternalSdkCore");
        datadogSDKWrapperStorage.notifyOnInitializedListeners((InternalSdkCore) sdkCoreInitialize);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setUserInfo(String id, String name, String email, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Datadog.setUserInfo$default(id, name, email, extraInfo, null, 16, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void addUserExtraInfo(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Datadog.addUserProperties$default(extraInfo, null, 2, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void clearUserInfo() {
        Datadog.clearUserInfo$default(null, 1, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setAccountInfo(String id, String name, Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Datadog.setAccountInfo$default(id, name, extraInfo, null, 8, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void addAccountExtraInfo(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        Datadog.addAccountExtraInfo$default(extraInfo, null, 2, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void clearAccountInfo() {
        Datadog.clearAccountInfo$default(null, 1, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void addRumGlobalAttribute(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        getRumMonitor().addAttribute(key, value);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void removeRumGlobalAttribute(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        getRumMonitor().removeAttribute(key);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void addRumGlobalAttributes(Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        for (Map.Entry<String, ? extends Object> entry : attributes.entrySet()) {
            addRumGlobalAttribute(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void removeRumGlobalAttributes(String[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (String str : keys) {
            removeRumGlobalAttribute(str);
        }
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void setTrackingConsent(TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        Datadog.setTrackingConsent$default(trackingConsent, null, 2, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void consumeWebviewEvent(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        WebViewTracking._InternalWebViewProxy webViewProxy = getWebViewProxy();
        if (webViewProxy != null) {
            webViewProxy.consumeWebviewEvent(message);
        }
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public boolean isInitialized() {
        return Datadog.isInitialized$default(null, 1, null);
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public RumMonitor getRumMonitor() {
        return GlobalRumMonitor.get(Datadog.getInstance$default(null, 1, null));
    }

    @Override // com.datadog.reactnative.DatadogWrapper
    public void clearAllData() {
        Datadog.clearAllData(Datadog.getInstance$default(null, 1, null));
    }
}
