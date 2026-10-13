package com.datadog.android.rum;

import com.datadog.android.event.EventMapper;
import com.datadog.android.event.NoOpEventMapper;
import com.datadog.android.rum.configuration.SlowFramesConfiguration;
import com.datadog.android.rum.configuration.VitalsUpdateFrequency;
import com.datadog.android.rum.event.ViewEventMapper;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.instrumentation.MainLooperLongTaskStrategy;
import com.datadog.android.rum.internal.instrumentation.insights.InsightsCollector;
import com.datadog.android.rum.internal.tracking.NoOpInteractionPredicate;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.model.VitalAppLaunchEvent;
import com.datadog.android.rum.model.VitalOperationStepEvent;
import com.datadog.android.rum.startup.AppStartupActivityPredicate;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.datadog.android.rum.tracking.ActionTrackingStrategy;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import com.datadog.android.rum.tracking.ViewTrackingStrategy;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumConfiguration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\u000e\u0010\r\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u000eJ\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/rum/RumConfiguration;", "", "applicationId", "", "featureConfiguration", "Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "(Ljava/lang/String;Lcom/datadog/android/rum/internal/RumFeature$Configuration;)V", "getApplicationId$dd_sdk_android_rum_release", "()Ljava/lang/String;", "getFeatureConfiguration$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "component1", "component1$dd_sdk_android_rum_release", "component2", "component2$dd_sdk_android_rum_release", "copy", "equals", "", "other", "hashCode", "", "toString", "Builder", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RumConfiguration {
    private final String applicationId;
    private final RumFeature.Configuration featureConfiguration;

    public static /* synthetic */ RumConfiguration copy$default(RumConfiguration rumConfiguration, String str, RumFeature.Configuration configuration, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rumConfiguration.applicationId;
        }
        if ((i & 2) != 0) {
            configuration = rumConfiguration.featureConfiguration;
        }
        return rumConfiguration.copy(str, configuration);
    }

    /* JADX INFO: renamed from: component1$dd_sdk_android_rum_release, reason: from getter */
    public final String getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component2$dd_sdk_android_rum_release, reason: from getter */
    public final RumFeature.Configuration getFeatureConfiguration() {
        return this.featureConfiguration;
    }

    public final RumConfiguration copy(String applicationId, RumFeature.Configuration featureConfiguration) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        return new RumConfiguration(applicationId, featureConfiguration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RumConfiguration)) {
            return false;
        }
        RumConfiguration rumConfiguration = (RumConfiguration) other;
        return Intrinsics.areEqual(this.applicationId, rumConfiguration.applicationId) && Intrinsics.areEqual(this.featureConfiguration, rumConfiguration.featureConfiguration);
    }

    public int hashCode() {
        return (this.applicationId.hashCode() * 31) + this.featureConfiguration.hashCode();
    }

    public String toString() {
        return "RumConfiguration(applicationId=" + this.applicationId + ", featureConfiguration=" + this.featureConfiguration + ")";
    }

    public RumConfiguration(String applicationId, RumFeature.Configuration featureConfiguration) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.applicationId = applicationId;
        this.featureConfiguration = featureConfiguration;
    }

    public final String getApplicationId$dd_sdk_android_rum_release() {
        return this.applicationId;
    }

    public final RumFeature.Configuration getFeatureConfiguration$dd_sdk_android_rum_release() {
        return this.featureConfiguration;
    }

    /* JADX INFO: compiled from: RumConfiguration.kt */
    @Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0000J\u0014\u0010\r\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ!\u0010\u0011\u001a\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013H\u0000¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u001eJ\u0014\u0010\u001f\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020 0\u000fJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b'J\u0010\u0010(\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010*J\u0014\u0010+\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020,0\u000fJ\u0014\u0010-\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020.0\u000fJ\u0015\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b2J\u000e\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u0010\u00106\u001a\u00020\u00002\b\b\u0001\u00107\u001a\u000208J\u0010\u00109\u001a\u00020\u00002\b\u0010:\u001a\u0004\u0018\u00010;J\u001b\u0010<\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020=0\u000fH\u0000¢\u0006\u0002\b>J\u0010\u0010?\u001a\u00020\u00002\b\b\u0001\u00107\u001a\u000208J\u0015\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0002\bCJ\u000e\u0010D\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020EJ\u0016\u0010F\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020G0\u000fH\u0007J(\u0010F\u001a\u00020\u00002\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u000f2\u000e\b\u0002\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u000fH\u0007J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010R\u001a\u00020SH\u0007J\u000e\u0010T\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ'\u0010U\u001a\u00020\u00002\u000e\b\u0002\u0010V\u001a\b\u0012\u0004\u0012\u00020X0W2\b\b\u0002\u0010Y\u001a\u00020ZH\u0007¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\u0003J\u0010\u0010^\u001a\u00020\u00002\b\u0010_\u001a\u0004\u0018\u00010`R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/datadog/android/rum/RumConfiguration$Builder;", "", "applicationId", "", "(Ljava/lang/String;)V", "rumConfig", "Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "build", "Lcom/datadog/android/rum/RumConfiguration;", "collectAccessibility", "enabled", "", "disableUserInteractionTracking", "setActionEventMapper", "eventMapper", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/rum/model/ActionEvent;", "setAdditionalConfiguration", "additionalConfig", "", "setAdditionalConfiguration$dd_sdk_android_rum_release", "setAppStartupActivityPredicate", "predicate", "Lcom/datadog/android/rum/startup/AppStartupActivityPredicate;", "setComposeActionTrackingStrategy", "composeActionTrackingStrategy", "Lcom/datadog/android/rum/tracking/ActionTrackingStrategy;", "setComposeActionTrackingStrategy$dd_sdk_android_rum_release", "setDisableJankStats", "disable", "setDisableJankStats$dd_sdk_android_rum_release", "setErrorEventMapper", "Lcom/datadog/android/rum/model/ErrorEvent;", "setInitialResourceIdentifier", "initialResourceIdentifier", "Lcom/datadog/android/rum/metric/networksettled/InitialResourceIdentifier;", "setInsightsCollector", "insightsCollector", "Lcom/datadog/android/rum/internal/instrumentation/insights/InsightsCollector;", "setInsightsCollector$dd_sdk_android_rum_release", "setLastInteractionIdentifier", "lastInteractionIdentifier", "Lcom/datadog/android/rum/metric/interactiontonextview/LastInteractionIdentifier;", "setLongTaskEventMapper", "Lcom/datadog/android/rum/model/LongTaskEvent;", "setResourceEventMapper", "Lcom/datadog/android/rum/model/ResourceEvent;", "setRumSessionTypeOverride", "rumSessionTypeOverride", "Lcom/datadog/android/rum/RumSessionType;", "setRumSessionTypeOverride$dd_sdk_android_rum_release", "setSessionListener", "sessionListener", "Lcom/datadog/android/rum/RumSessionListener;", "setSessionSampleRate", "sampleRate", "", "setSlowFramesConfiguration", "slowFramesConfiguration", "Lcom/datadog/android/rum/configuration/SlowFramesConfiguration;", "setTelemetryConfigurationEventMapper", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent;", "setTelemetryConfigurationEventMapper$dd_sdk_android_rum_release", "setTelemetrySampleRate", "setTimeseriesConfiguration", "configuration", "Lcom/datadog/android/rum/timeseries/TimeseriesConfiguration;", "setTimeseriesConfiguration$dd_sdk_android_rum_release", "setViewEventMapper", "Lcom/datadog/android/rum/event/ViewEventMapper;", "setVitalEventMapper", "Lcom/datadog/android/rum/model/VitalOperationStepEvent;", "vitalOperationStepEventMapper", "vitalAppLaunchEventMapper", "Lcom/datadog/android/rum/model/VitalAppLaunchEvent;", "setVitalsUpdateFrequency", "frequency", "Lcom/datadog/android/rum/configuration/VitalsUpdateFrequency;", "trackAnonymousUser", "trackBackgroundEvents", "trackFrustrations", "trackLongTasks", "longTaskThresholdMs", "", "trackNonFatalAnrs", "trackUserInteractions", "touchTargetExtraAttributesProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "([Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;)Lcom/datadog/android/rum/RumConfiguration$Builder;", "useCustomEndpoint", "endpoint", "useViewTrackingStrategy", "strategy", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final String applicationId;
        private RumFeature.Configuration rumConfig;

        public final Builder trackLongTasks() {
            return trackLongTasks$default(this, 0L, 1, null);
        }

        public final Builder trackUserInteractions() {
            return trackUserInteractions$default(this, null, null, 3, null);
        }

        public final Builder trackUserInteractions(ViewAttributesProvider[] touchTargetExtraAttributesProviders) {
            Intrinsics.checkNotNullParameter(touchTargetExtraAttributesProviders, "touchTargetExtraAttributesProviders");
            return trackUserInteractions$default(this, touchTargetExtraAttributesProviders, null, 2, null);
        }

        public Builder(String applicationId) {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            this.applicationId = applicationId;
            this.rumConfig = RumFeature.INSTANCE.getDEFAULT_RUM_CONFIG$dd_sdk_android_rum_release();
        }

        public final Builder setSessionSampleRate(float sampleRate) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, sampleRate, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -3, 3, null);
            return this;
        }

        public final Builder collectAccessibility(boolean enabled) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, enabled, false, null, null, null, -536870913, 3, null);
            return this;
        }

        public final Builder setTelemetrySampleRate(float sampleRate) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, sampleRate, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -5, 3, null);
            return this;
        }

        public static /* synthetic */ Builder trackUserInteractions$default(Builder builder, ViewAttributesProvider[] viewAttributesProviderArr, InteractionPredicate interactionPredicate, int i, Object obj) {
            if ((i & 1) != 0) {
                viewAttributesProviderArr = new ViewAttributesProvider[0];
            }
            if ((i & 2) != 0) {
                interactionPredicate = new NoOpInteractionPredicate();
            }
            return builder.trackUserInteractions(viewAttributesProviderArr, interactionPredicate);
        }

        public final Builder trackUserInteractions(ViewAttributesProvider[] touchTargetExtraAttributesProviders, InteractionPredicate interactionPredicate) {
            Intrinsics.checkNotNullParameter(touchTargetExtraAttributesProviders, "touchTargetExtraAttributesProviders");
            Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, ArraysKt.toList(touchTargetExtraAttributesProviders), interactionPredicate, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -97, 3, null);
            return this;
        }

        public final Builder disableUserInteractionTracking() {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -17, 3, null);
            return this;
        }

        public final Builder useViewTrackingStrategy(ViewTrackingStrategy strategy) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, strategy, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -129, 3, null);
            return this;
        }

        public static /* synthetic */ Builder trackLongTasks$default(Builder builder, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 100;
            }
            return builder.trackLongTasks(j);
        }

        public final Builder trackLongTasks(long longTaskThresholdMs) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, longTaskThresholdMs > 0 ? new MainLooperLongTaskStrategy(longTaskThresholdMs) : null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -257, 3, null);
            return this;
        }

        public final Builder trackNonFatalAnrs(boolean enabled) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, enabled, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -524289, 3, null);
            return this;
        }

        public final Builder setViewEventMapper(ViewEventMapper eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, eventMapper, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -513, 3, null);
            return this;
        }

        public final Builder setResourceEventMapper(EventMapper<ResourceEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, eventMapper, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -2049, 3, null);
            return this;
        }

        public final Builder setActionEventMapper(EventMapper<ActionEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, eventMapper, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -4097, 3, null);
            return this;
        }

        public final Builder setErrorEventMapper(EventMapper<ErrorEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, eventMapper, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -1025, 3, null);
            return this;
        }

        public final Builder setLongTaskEventMapper(EventMapper<LongTaskEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, eventMapper, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -8193, 3, null);
            return this;
        }

        @Deprecated(message = "Use setVitalEventMapper(vitalOperationStepEventMapper, vitalAppLaunchEventMapper) instead.", replaceWith = @ReplaceWith(expression = "setVitalEventMapper(eventMapper, NoOpEventMapper())", imports = {}))
        public final Builder setVitalEventMapper(EventMapper<VitalOperationStepEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            return setVitalEventMapper$default(this, eventMapper, null, 2, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setVitalEventMapper$default(Builder builder, EventMapper eventMapper, EventMapper eventMapper2, int i, Object obj) {
            if ((i & 1) != 0) {
                eventMapper = new NoOpEventMapper();
            }
            if ((i & 2) != 0) {
                eventMapper2 = new NoOpEventMapper();
            }
            return builder.setVitalEventMapper(eventMapper, eventMapper2);
        }

        public final Builder setVitalEventMapper(EventMapper<VitalOperationStepEvent> vitalOperationStepEventMapper, EventMapper<VitalAppLaunchEvent> vitalAppLaunchEventMapper) {
            Intrinsics.checkNotNullParameter(vitalOperationStepEventMapper, "vitalOperationStepEventMapper");
            Intrinsics.checkNotNullParameter(vitalAppLaunchEventMapper, "vitalAppLaunchEventMapper");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, vitalOperationStepEventMapper, vitalAppLaunchEventMapper, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -49153, 3, null);
            return this;
        }

        public final Builder trackBackgroundEvents(boolean enabled) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, enabled, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -131073, 3, null);
            return this;
        }

        public final Builder trackFrustrations(boolean enabled) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, enabled, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -262145, 3, null);
            return this;
        }

        public final Builder setVitalsUpdateFrequency(VitalsUpdateFrequency frequency) {
            Intrinsics.checkNotNullParameter(frequency, "frequency");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, frequency, null, null, null, null, null, null, false, null, false, false, null, null, null, -1048577, 3, null);
            return this;
        }

        public final Builder useCustomEndpoint(String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, endpoint, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -2, 3, null);
            return this;
        }

        public final Builder setSessionListener(RumSessionListener sessionListener) {
            Intrinsics.checkNotNullParameter(sessionListener, "sessionListener");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, sessionListener, null, null, null, null, null, false, null, false, false, null, null, null, -2097153, 3, null);
            return this;
        }

        public final Builder setInitialResourceIdentifier(InitialResourceIdentifier initialResourceIdentifier) {
            Intrinsics.checkNotNullParameter(initialResourceIdentifier, "initialResourceIdentifier");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, initialResourceIdentifier, null, null, null, null, false, null, false, false, null, null, null, -4194305, 3, null);
            return this;
        }

        public final Builder setLastInteractionIdentifier(LastInteractionIdentifier lastInteractionIdentifier) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, lastInteractionIdentifier, null, null, null, false, null, false, false, null, null, null, -8388609, 3, null);
            return this;
        }

        public final Builder setSlowFramesConfiguration(SlowFramesConfiguration slowFramesConfiguration) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, slowFramesConfiguration, null, null, false, null, false, false, null, null, null, -16777217, 3, null);
            return this;
        }

        public final Builder trackAnonymousUser(boolean enabled) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, enabled, null, false, false, null, null, null, -134217729, 3, null);
            return this;
        }

        public final Builder setAppStartupActivityPredicate(AppStartupActivityPredicate predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, predicate, null, -1, 2, null);
            return this;
        }

        public final Builder setTimeseriesConfiguration$dd_sdk_android_rum_release(TimeseriesConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, configuration, -1, 1, null);
            return this;
        }

        public final RumConfiguration build() {
            Object obj = this.rumConfig.getAdditionalConfig().get(RumFeature.DD_TELEMETRY_CONFIG_SAMPLE_RATE_TAG);
            Float fValueOf = null;
            if (obj != null && (obj instanceof Number)) {
                fValueOf = Float.valueOf(((Number) obj).floatValue());
            }
            String str = this.applicationId;
            RumFeature.Configuration configurationCopy$default = this.rumConfig;
            if (fValueOf != null) {
                configurationCopy$default = RumFeature.Configuration.copy$default(configurationCopy$default, null, 0.0f, 0.0f, fValueOf.floatValue(), false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -9, 3, null);
            }
            return new RumConfiguration(str, configurationCopy$default);
        }

        public final Builder setTelemetryConfigurationEventMapper$dd_sdk_android_rum_release(EventMapper<TelemetryConfigurationEvent> eventMapper) {
            Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, eventMapper, false, false, false, null, null, null, null, null, null, null, false, null, false, false, null, null, null, -65537, 3, null);
            return this;
        }

        public final Builder setAdditionalConfiguration$dd_sdk_android_rum_release(Map<String, ? extends Object> additionalConfig) {
            Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, additionalConfig, false, null, false, false, null, null, null, -67108865, 3, null);
            return this;
        }

        public final Builder setComposeActionTrackingStrategy$dd_sdk_android_rum_release(ActionTrackingStrategy composeActionTrackingStrategy) {
            Intrinsics.checkNotNullParameter(composeActionTrackingStrategy, "composeActionTrackingStrategy");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, composeActionTrackingStrategy, null, false, null, false, false, null, null, null, -33554433, 3, null);
            return this;
        }

        public final Builder setRumSessionTypeOverride$dd_sdk_android_rum_release(RumSessionType rumSessionTypeOverride) {
            Intrinsics.checkNotNullParameter(rumSessionTypeOverride, "rumSessionTypeOverride");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, rumSessionTypeOverride, false, false, null, null, null, -268435457, 3, null);
            return this;
        }

        public final Builder setDisableJankStats$dd_sdk_android_rum_release(boolean disable) {
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, disable, null, null, null, -1073741825, 3, null);
            return this;
        }

        public final Builder setInsightsCollector$dd_sdk_android_rum_release(InsightsCollector insightsCollector) {
            Intrinsics.checkNotNullParameter(insightsCollector, "insightsCollector");
            this.rumConfig = RumFeature.Configuration.copy$default(this.rumConfig, null, 0.0f, 0.0f, 0.0f, false, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, null, null, null, null, null, null, false, null, false, false, insightsCollector, null, null, Integer.MAX_VALUE, 3, null);
            return this;
        }
    }
}
