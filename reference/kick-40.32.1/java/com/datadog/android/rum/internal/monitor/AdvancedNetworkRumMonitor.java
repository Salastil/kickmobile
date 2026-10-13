package com.datadog.android.rum.internal.monitor;

import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.resource.ResourceId;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: AdvancedNetworkRumMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\b\u0010\b\u001a\u00020\u0003H'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH'J8\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0016H'JI\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0016H'¢\u0006\u0002\u0010\u001eJY\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0016H'¢\u0006\u0002\u0010%JO\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0016H'¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006*"}, d2 = {"Lcom/datadog/android/rum/internal/monitor/AdvancedNetworkRumMonitor;", "Lcom/datadog/android/rum/RumMonitor;", "addResourceTiming", "", "key", "", "timing", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "notifyInterceptorInstantiated", "notifyResourceHeadersTrackingConfigured", "mode", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured$Mode;", "reportNetworkingLibraryType", "type", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "startResource", "Lcom/datadog/android/rum/resource/ResourceId;", FirebaseAnalytics.Param.METHOD, "Lcom/datadog/android/rum/RumResourceMethod;", ImagesContract.URL, "", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "stopResource", "statusCode", "", ContentDisposition.Parameters.Size, "", "kind", "Lcom/datadog/android/rum/RumResourceKind;", "(Lcom/datadog/android/rum/resource/ResourceId;Ljava/lang/Integer;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;)V", "stopResourceWithError", "message", "source", "Lcom/datadog/android/rum/RumErrorSource;", "stackTrace", "errorType", "(Lcom/datadog/android/rum/resource/ResourceId;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", RumFeature.EVENT_THROWABLE_PROPERTY, "", "(Lcom/datadog/android/rum/resource/ResourceId;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;)V", "waitForResourceTiming", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AdvancedNetworkRumMonitor extends RumMonitor {
    void addResourceTiming(Object key, ResourceTiming timing);

    void notifyInterceptorInstantiated();

    void notifyResourceHeadersTrackingConfigured(InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode mode);

    void reportNetworkingLibraryType(InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType type);

    void startResource(ResourceId key, RumResourceMethod method, String url, Map<String, ? extends Object> attributes);

    void stopResource(ResourceId key, Integer statusCode, Long size, RumResourceKind kind, Map<String, ? extends Object> attributes);

    void stopResourceWithError(ResourceId key, Integer statusCode, String message, RumErrorSource source, String stackTrace, String errorType, Map<String, ? extends Object> attributes);

    void stopResourceWithError(ResourceId key, Integer statusCode, String message, RumErrorSource source, Throwable throwable, Map<String, ? extends Object> attributes);

    void waitForResourceTiming(Object key);

    /* JADX INFO: compiled from: AdvancedNetworkRumMonitor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startResource$default(AdvancedNetworkRumMonitor advancedNetworkRumMonitor, ResourceId resourceId, RumResourceMethod rumResourceMethod, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startResource");
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            advancedNetworkRumMonitor.startResource(resourceId, rumResourceMethod, str, (Map<String, ? extends Object>) map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopResource$default(AdvancedNetworkRumMonitor advancedNetworkRumMonitor, ResourceId resourceId, Integer num, Long l, RumResourceKind rumResourceKind, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopResource");
            }
            if ((i & 16) != 0) {
                map = MapsKt.emptyMap();
            }
            advancedNetworkRumMonitor.stopResource(resourceId, num, l, rumResourceKind, (Map<String, ? extends Object>) map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopResourceWithError$default(AdvancedNetworkRumMonitor advancedNetworkRumMonitor, ResourceId resourceId, Integer num, String str, RumErrorSource rumErrorSource, Throwable th, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopResourceWithError");
            }
            if ((i & 32) != 0) {
                map = MapsKt.emptyMap();
            }
            advancedNetworkRumMonitor.stopResourceWithError(resourceId, num, str, rumErrorSource, th, (Map<String, ? extends Object>) map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stopResourceWithError$default(AdvancedNetworkRumMonitor advancedNetworkRumMonitor, ResourceId resourceId, Integer num, String str, RumErrorSource rumErrorSource, String str2, String str3, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopResourceWithError");
            }
            advancedNetworkRumMonitor.stopResourceWithError(resourceId, num, str, rumErrorSource, str2, str3, (Map<String, ? extends Object>) ((i & 64) != 0 ? MapsKt.emptyMap() : map));
        }
    }
}
