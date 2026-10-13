package com.datadog.reactnative;

import android.content.Context;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatadogWrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J:\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001cH&J\u001e\u0010\u001d\u001a\u00020\f2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001cH&J\b\u0010\u001e\u001a\u00020\fH&J0\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001cH&J\u001e\u0010 \u001a\u00020\f2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001cH&J\b\u0010!\u001a\u00020\fH&J\u001a\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010%\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0018H&J\u001e\u0010&\u001a\u00020\f2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001cH&J\u001b\u0010(\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180*H&¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0015H&J\u0010\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0018H&J\b\u00100\u001a\u00020\u0003H&J\b\u00101\u001a\u000202H&J\b\u00103\u001a\u00020\fH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u00064À\u0006\u0003"}, d2 = {"Lcom/datadog/reactnative/DatadogWrapper;", "", "bundleLogsWithRum", "", "getBundleLogsWithRum", "()Z", "setBundleLogsWithRum", "(Z)V", "bundleLogsWithTraces", "getBundleLogsWithTraces", "setBundleLogsWithTraces", "setVerbosity", "", FirebaseAnalytics.Param.LEVEL, "", "initialize", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "configuration", "Lcom/datadog/android/core/configuration/Configuration;", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "Lcom/datadog/android/privacy/TrackingConsent;", "setUserInfo", "id", "", "name", "email", "extraInfo", "", "addUserExtraInfo", "clearUserInfo", "setAccountInfo", "addAccountExtraInfo", "clearAccountInfo", "addRumGlobalAttribute", "key", "value", "removeRumGlobalAttribute", "addRumGlobalAttributes", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "removeRumGlobalAttributes", UserMetadata.KEYDATA_FILENAME, "", "([Ljava/lang/String;)V", "setTrackingConsent", "trackingConsent", "consumeWebviewEvent", "message", "isInitialized", "getRumMonitor", "Lcom/datadog/android/rum/RumMonitor;", "clearAllData", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface DatadogWrapper {
    void addAccountExtraInfo(Map<String, ? extends Object> extraInfo);

    void addRumGlobalAttribute(String key, Object value);

    void addRumGlobalAttributes(Map<String, ? extends Object> attributes);

    void addUserExtraInfo(Map<String, ? extends Object> extraInfo);

    void clearAccountInfo();

    void clearAllData();

    void clearUserInfo();

    void consumeWebviewEvent(String message);

    boolean getBundleLogsWithRum();

    boolean getBundleLogsWithTraces();

    RumMonitor getRumMonitor();

    void initialize(Context context, Configuration configuration, TrackingConsent consent);

    boolean isInitialized();

    void removeRumGlobalAttribute(String key);

    void removeRumGlobalAttributes(String[] keys);

    void setAccountInfo(String id, String name, Map<String, ? extends Object> extraInfo);

    void setBundleLogsWithRum(boolean z);

    void setBundleLogsWithTraces(boolean z);

    void setTrackingConsent(TrackingConsent trackingConsent);

    void setUserInfo(String id, String name, String email, Map<String, ? extends Object> extraInfo);

    void setVerbosity(int level);
}
