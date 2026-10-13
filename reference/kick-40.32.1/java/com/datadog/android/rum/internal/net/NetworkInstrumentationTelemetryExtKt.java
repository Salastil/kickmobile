package com.datadog.android.rum.internal.net;

import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.internal.monitor.AdvancedNetworkRumMonitor;
import com.datadog.android.rum.resource.ResourceHeadersExtractor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkInstrumentationTelemetryExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"reportNetworkInstrumentationConfigured", "", "Lcom/datadog/android/rum/internal/monitor/AdvancedNetworkRumMonitor;", "type", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "resourceHeadersExtractor", "Lcom/datadog/android/rum/resource/ResourceHeadersExtractor;", "toTrackingMode", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ResourceHeadersTrackingConfigured$Mode;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NetworkInstrumentationTelemetryExtKt {
    public static final void reportNetworkInstrumentationConfigured(AdvancedNetworkRumMonitor advancedNetworkRumMonitor, InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType type, ResourceHeadersExtractor resourceHeadersExtractor) {
        InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode trackingMode;
        Intrinsics.checkNotNullParameter(advancedNetworkRumMonitor, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        advancedNetworkRumMonitor.notifyInterceptorInstantiated();
        advancedNetworkRumMonitor.reportNetworkingLibraryType(type);
        if (resourceHeadersExtractor == null || (trackingMode = toTrackingMode(resourceHeadersExtractor)) == null) {
            return;
        }
        advancedNetworkRumMonitor.notifyResourceHeadersTrackingConfigured(trackingMode);
    }

    private static final InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode toTrackingMode(ResourceHeadersExtractor resourceHeadersExtractor) {
        if (Intrinsics.areEqual(resourceHeadersExtractor.getAllowedRequestHeaders$dd_sdk_android_rum_release(), ResourceHeadersExtractor.INSTANCE.getDEFAULT_REQUEST_HEADERS()) && Intrinsics.areEqual(resourceHeadersExtractor.getAllowedResponseHeaders$dd_sdk_android_rum_release(), ResourceHeadersExtractor.INSTANCE.getDEFAULT_RESPONSE_HEADERS())) {
            return InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode.DEFAULT_HEADERS;
        }
        return InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode.CUSTOM;
    }
}
