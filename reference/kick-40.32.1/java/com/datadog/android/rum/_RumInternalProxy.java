package com.datadog.android.rum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.event.EventMapper;
import com.datadog.android.heatmaps.CrossPlatformHeatmapActionData;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.configuration.RumNetworkInstrumentationConfiguration;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.net.RumNetworkInstrumentation;
import com.datadog.android.rum.resource.ResourceHeadersExtractor;
import com.datadog.android.rum.tracking.ActionTrackingStrategy;
import com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: _RumInternalProxy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/datadog/android/rum/_RumInternalProxy;", "", "rumMonitor", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "(Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;)V", "handledSyntheticsAttribute", "", "addActionWithHeatmap", "", "type", "Lcom/datadog/android/rum/RumActionType;", "name", "", "crossPlatformHeatmapActionData", "Lcom/datadog/android/heatmaps/CrossPlatformHeatmapActionData;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "addLongTask", "durationNs", "", TypedValues.Attributes.S_TARGET, "enableJankStatsTracking", "activity", "Landroid/app/Activity;", "getCurrentViewUrl", "setInternalViewAttribute", "key", "value", "setSyntheticsAttribute", "testId", "resultId", "setSyntheticsAttributeFromIntent", "intent", "Landroid/content/Intent;", "updateExternalRefreshRate", "frameTimeSeconds", "", "updatePerformanceMetric", "metric", "Lcom/datadog/android/rum/RumPerformanceMetric;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class _RumInternalProxy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private volatile boolean handledSyntheticsAttribute;
    private final AdvancedRumMonitor rumMonitor;

    public _RumInternalProxy(AdvancedRumMonitor rumMonitor) {
        Intrinsics.checkNotNullParameter(rumMonitor, "rumMonitor");
        this.rumMonitor = rumMonitor;
    }

    public final void addActionWithHeatmap(RumActionType type, String name, CrossPlatformHeatmapActionData crossPlatformHeatmapActionData, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(crossPlatformHeatmapActionData, "crossPlatformHeatmapActionData");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.rumMonitor.addActionWithHeatmapAttributes(type, name, crossPlatformHeatmapActionData, attributes);
    }

    public final String getCurrentViewUrl() {
        return this.rumMonitor.getCurrentViewUrl();
    }

    public final void addLongTask(long durationNs, String target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.rumMonitor.addLongTask(durationNs, target);
    }

    public final void updatePerformanceMetric(RumPerformanceMetric metric, double value) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        this.rumMonitor.updatePerformanceMetric(metric, value);
    }

    public final void updateExternalRefreshRate(double frameTimeSeconds) {
        this.rumMonitor.updateExternalRefreshRate(frameTimeSeconds);
    }

    public final void setInternalViewAttribute(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.rumMonitor.setInternalViewAttribute(key, value);
    }

    public final void setSyntheticsAttribute(String testId, String resultId) {
        String str;
        if (this.handledSyntheticsAttribute) {
            return;
        }
        this.handledSyntheticsAttribute = true;
        String str2 = testId;
        if (str2 == null || StringsKt.isBlank(str2) || (str = resultId) == null || StringsKt.isBlank(str)) {
            return;
        }
        this.rumMonitor.setSyntheticsAttribute(testId, resultId);
    }

    public final void enableJankStatsTracking(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.rumMonitor.enableJankStatsTracking(activity);
    }

    public final void setSyntheticsAttributeFromIntent(Intent intent) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            extras = intent.getExtras();
        } catch (Exception unused) {
            extras = null;
        }
        setSyntheticsAttribute(extras != null ? extras.getString(ActivityLifecycleTrackingStrategy.EXTRA_SYNTHETICS_TEST_ID) : null, extras != null ? extras.getString(ActivityLifecycleTrackingStrategy.EXTRA_SYNTHETICS_RESULT_ID) : null);
    }

    /* JADX INFO: compiled from: _RumInternalProxy.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u001c\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJV\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010!\u001a\u00020\"2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060$0\u000f2\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060$0\u000f2\u0006\u0010&\u001a\u00020'¨\u0006("}, d2 = {"Lcom/datadog/android/rum/_RumInternalProxy$Companion;", "", "()V", "createRumNetworkInstrumentation", "Lcom/datadog/android/rum/internal/net/RumNetworkInstrumentation;", "name", "", "libraryType", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage$NetworkInstrumentation$LibraryType;", "configuration", "Lcom/datadog/android/rum/configuration/RumNetworkInstrumentationConfiguration;", "setAdditionalConfiguration", "Lcom/datadog/android/rum/RumConfiguration$Builder;", "builder", "additionalConfig", "", "setComposeActionTrackingStrategy", "composeActionTrackingStrategy", "Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;", "setDisableJankStats", "disable", "", "setInsightsCollector", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "setRumSessionTypeOverride", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "setTelemetryConfigurationEventMapper", "eventMapper", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent;", "toResourceAttributes", "extractor", "Lcom/datadog/android/rum/resource/ResourceHeadersExtractor;", "rawRequestHeaders", "", "rawResponseHeaders", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumConfiguration.Builder setTelemetryConfigurationEventMapper(RumConfiguration.Builder builder, EventMapper<TelemetryConfigurationEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            return builder.setTelemetryConfigurationEventMapper$dd_sdk_android_rum_release(eventMapper);
        }

        public final RumConfiguration.Builder setAdditionalConfiguration(RumConfiguration.Builder builder, Map<String, ? extends Object> additionalConfig) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
            return builder.setAdditionalConfiguration$dd_sdk_android_rum_release(additionalConfig);
        }

        public final RumConfiguration.Builder setComposeActionTrackingStrategy(RumConfiguration.Builder builder, ActionTrackingStrategy composeActionTrackingStrategy) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(composeActionTrackingStrategy, "composeActionTrackingStrategy");
            return builder.setComposeActionTrackingStrategy$dd_sdk_android_rum_release(composeActionTrackingStrategy);
        }

        public final RumConfiguration.Builder setRumSessionTypeOverride(RumConfiguration.Builder builder, RumSessionType rumSessionTypeOverride) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(rumSessionTypeOverride, "rumSessionTypeOverride");
            return builder.setRumSessionTypeOverride$dd_sdk_android_rum_release(rumSessionTypeOverride);
        }

        public final RumConfiguration.Builder setDisableJankStats(RumConfiguration.Builder builder, boolean disable) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return builder.setDisableJankStats$dd_sdk_android_rum_release(disable);
        }

        public final RumConfiguration.Builder setInsightsCollector(RumConfiguration.Builder builder, InsightsCollector insightsCollector) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
            return builder.setInsightsCollector$dd_sdk_android_rum_release(insightsCollector);
        }

        public final RumNetworkInstrumentation createRumNetworkInstrumentation(String name, InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType libraryType, RumNetworkInstrumentationConfiguration configuration) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(libraryType, "libraryType");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return configuration.createInstrumentation$dd_sdk_android_rum_release(name, libraryType);
        }

        public final Map<String, Object> toResourceAttributes(ResourceHeadersExtractor extractor, Map<String, ? extends List<String>> rawRequestHeaders, Map<String, ? extends List<String>> rawResponseHeaders, InternalLogger internalLogger) {
            Intrinsics.checkNotNullParameter(extractor, "extractor");
            Intrinsics.checkNotNullParameter(rawRequestHeaders, "rawRequestHeaders");
            Intrinsics.checkNotNullParameter(rawResponseHeaders, "rawResponseHeaders");
            Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
            return extractor.toResourceAttributes$dd_sdk_android_rum_release(rawRequestHeaders, rawResponseHeaders, internalLogger);
        }
    }
}
