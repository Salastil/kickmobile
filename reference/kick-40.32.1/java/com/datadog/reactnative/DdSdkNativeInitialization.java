package com.datadog.reactnative;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.datadog.android.Datadog;
import com.datadog.android._InternalProxy;
import com.datadog.android.core.configuration.BatchProcessingLevel;
import com.datadog.android.core.configuration.BatchSize;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.configuration.UploadFrequency;
import com.datadog.android.event.EventMapper;
import com.datadog.android.log.Logs;
import com.datadog.android.ndk.NdkCrashReports;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.Rum;
import com.datadog.android.rum._RumInternalProxy;
import com.datadog.android.rum.configuration.VitalsUpdateFrequency;
import com.datadog.android.rum.metric.networksettled.TimeBasedInitialResourceIdentifier;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.ResourceEvent;
import com.datadog.android.rum.tracking.ActivityViewTrackingStrategy;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import com.datadog.android.trace.Trace;
import com.datadog.android.trace.TracingHeaderType;
import com.datadog.trace.api.config.GeneralConfig;
import com.google.gson.Gson;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.net.Proxy;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DdSdkNativeInitialization.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0017H\u0002J\r\u00102\u001a\u00020\u000fH\u0000¢\u0006\u0002\b3R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/datadog/reactnative/DdSdkNativeInitialization;", "", "appContext", "Landroid/content/Context;", "datadog", "Lcom/datadog/reactnative/DatadogWrapper;", "ddTelemetry", "Lcom/datadog/reactnative/DdTelemetry;", "jsonFileReader", "Lcom/datadog/reactnative/JSONFileReader;", "<init>", "(Landroid/content/Context;Lcom/datadog/reactnative/DatadogWrapper;Lcom/datadog/reactnative/DdTelemetry;Lcom/datadog/reactnative/JSONFileReader;)V", "initialize", "", "ddSdkConfiguration", "Lcom/datadog/reactnative/DdSdkConfiguration;", "isCalledFromJs", "", "initialize$datadog_mobile_react_native_release", "configureRumAndTracesForLogs", "configuration", "configureSdkVerbosity", "getDefaultAppVersion", "", "buildRumConfiguration", "Lcom/datadog/android/rum/RumConfiguration;", "buildLogsConfiguration", "Lcom/datadog/android/log/LogsConfiguration;", "buildTraceConfiguration", "Lcom/datadog/android/trace/TraceConfiguration;", "buildSdkConfiguration", "Lcom/datadog/android/core/configuration/Configuration;", "buildTrackingConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "trackingConsent", "buildSite", "Lcom/datadog/android/DatadogSite;", GeneralConfig.SITE, "buildVitalUpdateFrequency", "Lcom/datadog/android/rum/configuration/VitalsUpdateFrequency;", "vitalsUpdateFrequency", "buildUploadFrequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "uploadFrequency", "buildBatchSize", "Lcom/datadog/android/core/configuration/BatchSize;", "batchSize", "buildBatchProcessingLevel", "Lcom/datadog/android/core/configuration/BatchProcessingLevel;", "batchProcessingLevel", "getConfigurationFromJSONFile", "getConfigurationFromJSONFile$datadog_mobile_react_native_release", "Companion", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DdSdkNativeInitialization {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MILLISECONDS_IN_SECOND = 1000;
    private final Context appContext;
    private final DatadogWrapper datadog;
    private final DdTelemetry ddTelemetry;
    private final JSONFileReader jsonFileReader;

    @JvmStatic
    public static final void initFromNative(Context context) {
        INSTANCE.initFromNative(context);
    }

    public DdSdkNativeInitialization(Context appContext, DatadogWrapper datadog, DdTelemetry ddTelemetry, JSONFileReader jsonFileReader) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(datadog, "datadog");
        Intrinsics.checkNotNullParameter(ddTelemetry, "ddTelemetry");
        Intrinsics.checkNotNullParameter(jsonFileReader, "jsonFileReader");
        this.appContext = appContext;
        this.datadog = datadog;
        this.ddTelemetry = ddTelemetry;
        this.jsonFileReader = jsonFileReader;
    }

    public /* synthetic */ DdSdkNativeInitialization(Context context, DatadogSDKWrapper datadogSDKWrapper, DdTelemetry ddTelemetry, JSONFileReader jSONFileReader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new DatadogSDKWrapper() : datadogSDKWrapper, (i & 4) != 0 ? new DdTelemetry() : ddTelemetry, (i & 8) != 0 ? new JSONFileReader() : jSONFileReader);
    }

    public static /* synthetic */ void initialize$datadog_mobile_react_native_release$default(DdSdkNativeInitialization ddSdkNativeInitialization, DdSdkConfiguration ddSdkConfiguration, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ddSdkNativeInitialization.initialize$datadog_mobile_react_native_release(ddSdkConfiguration, z);
    }

    public final void initialize$datadog_mobile_react_native_release(DdSdkConfiguration ddSdkConfiguration, boolean isCalledFromJs) {
        Boolean nativeCrashReportEnabled;
        Intrinsics.checkNotNullParameter(ddSdkConfiguration, "ddSdkConfiguration");
        Configuration configurationBuildSdkConfiguration = buildSdkConfiguration(ddSdkConfiguration);
        TrackingConsent trackingConsentBuildTrackingConsent = buildTrackingConsent(ddSdkConfiguration.getTrackingConsent());
        RumConfiguration rumConfiguration = ddSdkConfiguration.getRumConfiguration();
        boolean zBooleanValue = (rumConfiguration == null || (nativeCrashReportEnabled = rumConfiguration.getNativeCrashReportEnabled()) == null) ? false : nativeCrashReportEnabled.booleanValue();
        com.datadog.android.rum.RumConfiguration rumConfigurationBuildRumConfiguration = ddSdkConfiguration.getRumConfiguration() != null ? buildRumConfiguration(ddSdkConfiguration) : null;
        com.datadog.android.log.LogsConfiguration logsConfigurationBuildLogsConfiguration = ddSdkConfiguration.getLogsConfiguration() != null ? buildLogsConfiguration(ddSdkConfiguration) : null;
        com.datadog.android.trace.TraceConfiguration traceConfigurationBuildTraceConfiguration = ddSdkConfiguration.getTraceConfiguration() != null ? buildTraceConfiguration(ddSdkConfiguration) : null;
        configureSdkVerbosity(ddSdkConfiguration);
        configureRumAndTracesForLogs(ddSdkConfiguration);
        if (isCalledFromJs) {
            DdSdkSessionStartedListener.INSTANCE.getInstance().onRnSdkInitialized();
            if (this.datadog.isInitialized()) {
                this.datadog.getRumMonitor().getCurrentSessionId(new Function1() { // from class: com.datadog.reactnative.DdSdkNativeInitialization$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DdSdkNativeInitialization.initialize$lambda$0((String) obj);
                    }
                });
            }
        }
        this.datadog.initialize(this.appContext, configurationBuildSdkConfiguration, trackingConsentBuildTrackingConsent);
        if (rumConfigurationBuildRumConfiguration != null) {
            Rum.enable(rumConfigurationBuildRumConfiguration, Datadog.getInstance$default(null, 1, null));
        }
        if (logsConfigurationBuildLogsConfiguration != null) {
            Logs.enable(logsConfigurationBuildLogsConfiguration, Datadog.getInstance$default(null, 1, null));
        }
        if (traceConfigurationBuildTraceConfiguration != null) {
            Trace.enable(traceConfigurationBuildTraceConfiguration, Datadog.getInstance$default(null, 1, null));
        }
        if (zBooleanValue) {
            NdkCrashReports.enable$default(null, 1, null);
        }
    }

    static final Unit initialize$lambda$0(String str) {
        if (str != null) {
            DdSdkSessionStartedListener.INSTANCE.getInstance().onSessionStarted(str, false);
        }
        return Unit.INSTANCE;
    }

    private final void configureRumAndTracesForLogs(DdSdkConfiguration configuration) {
        LogsConfiguration logsConfiguration = configuration.getLogsConfiguration();
        if (logsConfiguration != null) {
            this.datadog.setBundleLogsWithRum(logsConfiguration.getBundleLogsWithRum());
        }
        LogsConfiguration logsConfiguration2 = configuration.getLogsConfiguration();
        if (logsConfiguration2 != null) {
            this.datadog.setBundleLogsWithTraces(logsConfiguration2.getBundleLogsWithTraces());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void configureSdkVerbosity(DdSdkConfiguration configuration) {
        String lowerCase;
        String verbosity = configuration.getVerbosity();
        Integer num = null;
        if (verbosity != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = verbosity.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case 3237038:
                    if (lowerCase.equals("info")) {
                        num = 4;
                    }
                    break;
                case 3641990:
                    if (lowerCase.equals("warn")) {
                        num = 5;
                    }
                    break;
                case 95458899:
                    if (lowerCase.equals("debug")) {
                        num = 3;
                    }
                    break;
                case 96784904:
                    if (lowerCase.equals("error")) {
                        num = 6;
                    }
                    break;
            }
        }
        if (num != null) {
            this.datadog.setVerbosity(num.intValue());
        }
    }

    private final String getDefaultAppVersion() {
        try {
            PackageInfo packageInfo = this.appContext.getPackageManager().getPackageInfo(this.appContext.getPackageName(), 0);
            if (packageInfo != null) {
                String strValueOf = packageInfo.versionName;
                if (strValueOf == null) {
                    strValueOf = String.valueOf(packageInfo.versionCode);
                }
                if (strValueOf != null) {
                    return strValueOf;
                }
            }
            return "?";
        } catch (PackageManager.NameNotFoundException e) {
            DdTelemetry ddTelemetry = this.ddTelemetry;
            String message = e.getMessage();
            if (message == null) {
                message = DdSdkImplementation.PACKAGE_INFO_NOT_FOUND_ERROR_MESSAGE;
            }
            ddTelemetry.telemetryError(message, e);
            return "?";
        }
    }

    private final com.datadog.android.rum.RumConfiguration buildRumConfiguration(final DdSdkConfiguration configuration) {
        String applicationId;
        Double initialResourceThreshold;
        Boolean trackNonFatalAnrs;
        String customEndpoint;
        Boolean trackBackgroundEvents;
        Boolean trackFrustrations;
        RumConfiguration rumConfiguration = configuration.getRumConfiguration();
        if (rumConfiguration == null || (applicationId = rumConfiguration.getApplicationId()) == null) {
            applicationId = "";
        }
        com.datadog.android.rum.RumConfiguration.Builder builder = new com.datadog.android.rum.RumConfiguration.Builder(applicationId);
        RumConfiguration rumConfiguration2 = configuration.getRumConfiguration();
        if ((rumConfiguration2 != null ? rumConfiguration2.getSessionSampleRate() : null) != null) {
            builder.setSessionSampleRate((float) configuration.getRumConfiguration().getSessionSampleRate().doubleValue());
        }
        RumConfiguration rumConfiguration3 = configuration.getRumConfiguration();
        builder.trackFrustrations((rumConfiguration3 == null || (trackFrustrations = rumConfiguration3.getTrackFrustrations()) == null) ? true : trackFrustrations.booleanValue());
        RumConfiguration rumConfiguration4 = configuration.getRumConfiguration();
        builder.trackBackgroundEvents((rumConfiguration4 == null || (trackBackgroundEvents = rumConfiguration4.getTrackBackgroundEvents()) == null) ? false : trackBackgroundEvents.booleanValue());
        RumConfiguration rumConfiguration5 = configuration.getRumConfiguration();
        builder.setVitalsUpdateFrequency(buildVitalUpdateFrequency(rumConfiguration5 != null ? rumConfiguration5.getVitalsUpdateFrequency() : null));
        RumConfiguration rumConfiguration6 = configuration.getRumConfiguration();
        Double telemetrySampleRate = rumConfiguration6 != null ? rumConfiguration6.getTelemetrySampleRate() : null;
        Double d = telemetrySampleRate instanceof Number ? telemetrySampleRate : null;
        Float fValueOf = d != null ? Float.valueOf(d.floatValue()) : null;
        if (fValueOf != null) {
            builder.setTelemetrySampleRate(fValueOf.floatValue());
        }
        RumConfiguration rumConfiguration7 = configuration.getRumConfiguration();
        Double nativeLongTaskThresholdMs = rumConfiguration7 != null ? rumConfiguration7.getNativeLongTaskThresholdMs() : null;
        Double d2 = nativeLongTaskThresholdMs instanceof Number ? nativeLongTaskThresholdMs : null;
        Long lValueOf = d2 != null ? Long.valueOf(d2.longValue()) : null;
        if (lValueOf != null) {
            builder.trackLongTasks(lValueOf.longValue());
        }
        RumConfiguration rumConfiguration8 = configuration.getRumConfiguration();
        if (rumConfiguration8 != null ? Intrinsics.areEqual((Object) rumConfiguration8.getNativeViewTracking(), (Object) true) : false) {
            builder.useViewTrackingStrategy(new ActivityViewTrackingStrategy(false, null, 2, null));
        } else {
            builder.useViewTrackingStrategy(NoOpViewTrackingStrategy.INSTANCE);
        }
        RumConfiguration rumConfiguration9 = configuration.getRumConfiguration();
        if (rumConfiguration9 != null ? Intrinsics.areEqual((Object) rumConfiguration9.getNativeInteractionTracking(), (Object) false) : false) {
            builder.disableUserInteractionTracking();
        }
        builder.setResourceEventMapper(new EventMapper<ResourceEvent>() { // from class: com.datadog.reactnative.DdSdkNativeInitialization.buildRumConfiguration.2
            @Override // com.datadog.android.event.EventMapper
            public ResourceEvent map(ResourceEvent event) {
                Map<String, Object> additionalProperties;
                Intrinsics.checkNotNullParameter(event, "event");
                ResourceEvent.Context context = event.getContext();
                if (context == null || (additionalProperties = context.getAdditionalProperties()) == null || !additionalProperties.containsKey(DdSdkImplementation.DD_DROP_RESOURCE)) {
                    return event;
                }
                return null;
            }
        });
        builder.setActionEventMapper(new EventMapper<ActionEvent>() { // from class: com.datadog.reactnative.DdSdkNativeInitialization.buildRumConfiguration.3
            @Override // com.datadog.android.event.EventMapper
            public ActionEvent map(ActionEvent event) {
                Map<String, Object> additionalProperties;
                Intrinsics.checkNotNullParameter(event, "event");
                ActionEvent.Context context = event.getContext();
                if (context == null || (additionalProperties = context.getAdditionalProperties()) == null || !additionalProperties.containsKey(DdSdkImplementation.DD_DROP_ACTION)) {
                    return event;
                }
                return null;
            }
        });
        _RumInternalProxy.INSTANCE.setTelemetryConfigurationEventMapper(builder, new EventMapper<TelemetryConfigurationEvent>() { // from class: com.datadog.reactnative.DdSdkNativeInitialization.buildRumConfiguration.4
            @Override // com.datadog.android.event.EventMapper
            public TelemetryConfigurationEvent map(TelemetryConfigurationEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                TelemetryConfigurationEvent.Configuration configuration2 = event.getTelemetry().getConfiguration();
                RumConfiguration rumConfiguration10 = configuration.getRumConfiguration();
                configuration2.setTrackNativeErrors(rumConfiguration10 != null ? rumConfiguration10.getNativeCrashReportEnabled() : null);
                TelemetryConfigurationEvent.Configuration configuration3 = event.getTelemetry().getConfiguration();
                RumConfiguration rumConfiguration11 = configuration.getRumConfiguration();
                configuration3.setTrackCrossPlatformLongTasks(Boolean.valueOf(!Intrinsics.areEqual(rumConfiguration11 != null ? rumConfiguration11.getLongTaskThresholdMs() : null, 0.0d)));
                TelemetryConfigurationEvent.Configuration configuration4 = event.getTelemetry().getConfiguration();
                RumConfiguration rumConfiguration12 = configuration.getRumConfiguration();
                configuration4.setTrackLongTask(Boolean.valueOf(!Intrinsics.areEqual(rumConfiguration12 != null ? rumConfiguration12.getLongTaskThresholdMs() : null, 0.0d)));
                TelemetryConfigurationEvent.Configuration configuration5 = event.getTelemetry().getConfiguration();
                RumConfiguration rumConfiguration13 = configuration.getRumConfiguration();
                configuration5.setTrackNativeLongTasks(Boolean.valueOf(!Intrinsics.areEqual(rumConfiguration13 != null ? rumConfiguration13.getNativeLongTaskThresholdMs() : null, 0.0d)));
                TelemetryConfigurationEvent.Configuration configuration6 = event.getTelemetry().getConfiguration();
                ConfigurationForTelemetry configurationForTelemetry = configuration.getConfigurationForTelemetry();
                configuration6.setInitializationType(configurationForTelemetry != null ? configurationForTelemetry.getInitializationType() : null);
                TelemetryConfigurationEvent.Configuration configuration7 = event.getTelemetry().getConfiguration();
                ConfigurationForTelemetry configurationForTelemetry2 = configuration.getConfigurationForTelemetry();
                configuration7.setTrackInteractions(configurationForTelemetry2 != null ? configurationForTelemetry2.getTrackInteractions() : null);
                TelemetryConfigurationEvent.Configuration configuration8 = event.getTelemetry().getConfiguration();
                ConfigurationForTelemetry configurationForTelemetry3 = configuration.getConfigurationForTelemetry();
                configuration8.setTrackErrors(configurationForTelemetry3 != null ? configurationForTelemetry3.getTrackErrors() : null);
                TelemetryConfigurationEvent.Configuration configuration9 = event.getTelemetry().getConfiguration();
                ConfigurationForTelemetry configurationForTelemetry4 = configuration.getConfigurationForTelemetry();
                configuration9.setTrackResources(configurationForTelemetry4 != null ? configurationForTelemetry4.getTrackNetworkRequests() : null);
                TelemetryConfigurationEvent.Configuration configuration10 = event.getTelemetry().getConfiguration();
                ConfigurationForTelemetry configurationForTelemetry5 = configuration.getConfigurationForTelemetry();
                configuration10.setTrackNetworkRequests(configurationForTelemetry5 != null ? configurationForTelemetry5.getTrackNetworkRequests() : null);
                TelemetryConfigurationEvent.Configuration configuration11 = event.getTelemetry().getConfiguration();
                ConfigurationForTelemetry configurationForTelemetry6 = configuration.getConfigurationForTelemetry();
                configuration11.setReactVersion(configurationForTelemetry6 != null ? configurationForTelemetry6.getReactVersion() : null);
                TelemetryConfigurationEvent.Configuration configuration12 = event.getTelemetry().getConfiguration();
                ConfigurationForTelemetry configurationForTelemetry7 = configuration.getConfigurationForTelemetry();
                configuration12.setReactNativeVersion(configurationForTelemetry7 != null ? configurationForTelemetry7.getReactNativeVersion() : null);
                return event;
            }
        });
        RumConfiguration rumConfiguration10 = configuration.getRumConfiguration();
        if (rumConfiguration10 != null && (customEndpoint = rumConfiguration10.getCustomEndpoint()) != null) {
            builder.useCustomEndpoint(customEndpoint);
        }
        RumConfiguration rumConfiguration11 = configuration.getRumConfiguration();
        if (rumConfiguration11 != null && (trackNonFatalAnrs = rumConfiguration11.getTrackNonFatalAnrs()) != null) {
            builder.trackNonFatalAnrs(trackNonFatalAnrs.booleanValue());
        }
        RumConfiguration rumConfiguration12 = configuration.getRumConfiguration();
        if (rumConfiguration12 != null && (initialResourceThreshold = rumConfiguration12.getInitialResourceThreshold()) != null) {
            builder.setInitialResourceIdentifier(new TimeBasedInitialResourceIdentifier((long) (initialResourceThreshold.doubleValue() * 1000.0d)));
        }
        builder.setSessionListener(DdSdkSessionStartedListener.INSTANCE.getInstance());
        return builder.build();
    }

    private final com.datadog.android.log.LogsConfiguration buildLogsConfiguration(DdSdkConfiguration configuration) {
        String customEndpoint;
        com.datadog.android.log.LogsConfiguration.Builder builder = new com.datadog.android.log.LogsConfiguration.Builder();
        LogsConfiguration logsConfiguration = configuration.getLogsConfiguration();
        if (logsConfiguration != null && (customEndpoint = logsConfiguration.getCustomEndpoint()) != null) {
            builder.useCustomEndpoint(customEndpoint);
        }
        return builder.build();
    }

    private final com.datadog.android.trace.TraceConfiguration buildTraceConfiguration(DdSdkConfiguration configuration) {
        String customEndpoint;
        com.datadog.android.trace.TraceConfiguration.Builder builder = new com.datadog.android.trace.TraceConfiguration.Builder();
        TraceConfiguration traceConfiguration = configuration.getTraceConfiguration();
        if (traceConfiguration != null && (customEndpoint = traceConfiguration.getCustomEndpoint()) != null) {
            builder.useCustomEndpoint(customEndpoint);
        }
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final Configuration buildSdkConfiguration(DdSdkConfiguration configuration) {
        LinkedHashMap linkedHashMapEmptyMap;
        Boolean nativeCrashReportEnabled;
        Configuration.Builder builder = new Configuration.Builder(configuration.getClientToken(), configuration.getEnv(), "", configuration.getService());
        Map<String, Object> additionalConfiguration = configuration.getAdditionalConfiguration();
        Map mutableMap = additionalConfiguration != null ? MapsKt.toMutableMap(additionalConfiguration) : null;
        Map<String, Object> additionalConfiguration2 = configuration.getAdditionalConfiguration();
        Object obj = additionalConfiguration2 != null ? additionalConfiguration2.get(DdSdkImplementation.DD_VERSION_SUFFIX) : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str != null && mutableMap != null) {
            mutableMap.put("_dd.version", getDefaultAppVersion() + str);
        }
        if (mutableMap != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mutableMap.entrySet()) {
                if (entry.getValue() != null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            linkedHashMapEmptyMap = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                linkedHashMapEmptyMap.put(entry2.getKey(), entry2.getValue());
            }
        } else {
            linkedHashMapEmptyMap = null;
        }
        if (linkedHashMapEmptyMap == null) {
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        }
        builder.setAdditionalConfiguration(linkedHashMapEmptyMap);
        RumConfiguration rumConfiguration = configuration.getRumConfiguration();
        builder.setCrashReportsEnabled((rumConfiguration == null || (nativeCrashReportEnabled = rumConfiguration.getNativeCrashReportEnabled()) == null) ? false : nativeCrashReportEnabled.booleanValue());
        builder.useSite(buildSite(configuration.getSite()));
        builder.setUploadFrequency(buildUploadFrequency(configuration.getUploadFrequency()));
        builder.setBatchSize(buildBatchSize(configuration.getBatchSize()));
        Pair<Proxy, ProxyAuthenticator> proxyConfiguration = configuration.getProxyConfiguration();
        if (proxyConfiguration != null) {
            builder.setProxy(proxyConfiguration.component1(), proxyConfiguration.component2());
        }
        RumConfiguration rumConfiguration2 = configuration.getRumConfiguration();
        Map<String, Set<TracingHeaderType>> firstPartyHosts = rumConfiguration2 != null ? rumConfiguration2.getFirstPartyHosts() : null;
        if (firstPartyHosts != null) {
            builder.setFirstPartyHostsWithHeaderType(firstPartyHosts);
        }
        builder.setBatchProcessingLevel(buildBatchProcessingLevel(configuration.getBatchProcessingLevel()));
        if (mutableMap != null ? Intrinsics.areEqual(mutableMap.get(DdSdkImplementation.DD_NEEDS_CLEAR_TEXT_HTTP), (Object) true) : false) {
            _InternalProxy.INSTANCE.allowClearTextHttp(builder);
        }
        return builder.build();
    }

    private final TrackingConsent buildTrackingConsent(String trackingConsent) {
        String lowerCase;
        if (trackingConsent != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = trackingConsent.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1302084273) {
                if (iHashCode != -682587753) {
                    if (iHashCode == 280295099 && lowerCase.equals(PermissionsResponse.GRANTED_KEY)) {
                        return TrackingConsent.GRANTED;
                    }
                } else if (lowerCase.equals("pending")) {
                    return TrackingConsent.PENDING;
                }
            } else if (lowerCase.equals("not_granted")) {
                return TrackingConsent.NOT_GRANTED;
            }
        }
        Log.w(DdSdk.class.getCanonicalName(), "Unknown consent given: " + trackingConsent + ", using " + TrackingConsent.PENDING + " as default");
        return TrackingConsent.PENDING;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r1.equals("us1") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        if (r1.equals("gov") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
    
        if (r1.equals("eu1") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        if (r1.equals("us") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0077, code lost:
    
        return com.datadog.android.DatadogSite.US1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007e, code lost:
    
        if (r1.equals("eu") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        return com.datadog.android.DatadogSite.EU1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0096, code lost:
    
        if (r1.equals("us1_fed") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009b, code lost:
    
        return com.datadog.android.DatadogSite.US1_FED;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.datadog.android.DatadogSite buildSite(java.lang.String r2) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.reactnative.DdSdkNativeInitialization.buildSite(java.lang.String):com.datadog.android.DatadogSite");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final VitalsUpdateFrequency buildVitalUpdateFrequency(String vitalsUpdateFrequency) {
        String lowerCase;
        if (vitalsUpdateFrequency != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = vitalsUpdateFrequency.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case -1526279474:
                    if (lowerCase.equals("frequent")) {
                        return VitalsUpdateFrequency.FREQUENT;
                    }
                    break;
                case -631448035:
                    if (lowerCase.equals("average")) {
                        return VitalsUpdateFrequency.AVERAGE;
                    }
                    break;
                case 3493026:
                    if (lowerCase.equals("rare")) {
                        return VitalsUpdateFrequency.RARE;
                    }
                    break;
                case 104712844:
                    if (lowerCase.equals("never")) {
                        return VitalsUpdateFrequency.NEVER;
                    }
                    break;
            }
        }
        return VitalsUpdateFrequency.AVERAGE;
    }

    private final UploadFrequency buildUploadFrequency(String uploadFrequency) {
        String lowerCase;
        if (uploadFrequency != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = uploadFrequency.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1526279474) {
                if (iHashCode != -631448035) {
                    if (iHashCode == 3493026 && lowerCase.equals("rare")) {
                        return UploadFrequency.RARE;
                    }
                } else if (lowerCase.equals("average")) {
                    return UploadFrequency.AVERAGE;
                }
            } else if (lowerCase.equals("frequent")) {
                return UploadFrequency.FREQUENT;
            }
        }
        return UploadFrequency.AVERAGE;
    }

    private final BatchSize buildBatchSize(String batchSize) {
        String lowerCase;
        if (batchSize != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = batchSize.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1078030475) {
                if (iHashCode != 102742843) {
                    if (iHashCode == 109548807 && lowerCase.equals("small")) {
                        return BatchSize.SMALL;
                    }
                } else if (lowerCase.equals("large")) {
                    return BatchSize.LARGE;
                }
            } else if (lowerCase.equals("medium")) {
                return BatchSize.MEDIUM;
            }
        }
        return BatchSize.MEDIUM;
    }

    private final BatchProcessingLevel buildBatchProcessingLevel(String batchProcessingLevel) {
        String lowerCase;
        if (batchProcessingLevel != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            lowerCase = batchProcessingLevel.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1078030475) {
                if (iHashCode != 107348) {
                    if (iHashCode == 3202466 && lowerCase.equals("high")) {
                        return BatchProcessingLevel.HIGH;
                    }
                } else if (lowerCase.equals("low")) {
                    return BatchProcessingLevel.LOW;
                }
            } else if (lowerCase.equals("medium")) {
                return BatchProcessingLevel.MEDIUM;
            }
        }
        return BatchProcessingLevel.MEDIUM;
    }

    public final DdSdkConfiguration getConfigurationFromJSONFile$datadog_mobile_react_native_release() {
        try {
            return DdSdkConfigurationExtKt.asDdSdkConfiguration(((JSONConfigurationFile) new Gson().fromJson(this.jsonFileReader.parseAssetsJSONFile$datadog_mobile_react_native_release(this.appContext, "datadog-configuration.json"), JSONConfigurationFile.class)).getConfiguration());
        } catch (Exception e) {
            throw new BadConfigurationException(e);
        }
    }

    /* JADX INFO: compiled from: DdSdkNativeInitialization.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/datadog/reactnative/DdSdkNativeInitialization$Companion;", "", "<init>", "()V", "MILLISECONDS_IN_SECOND", "", "initFromNative", "", "appContext", "Landroid/content/Context;", "datadog_mobile-react-native_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void initFromNative(Context appContext) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Context applicationContext = appContext.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            DdSdkNativeInitialization ddSdkNativeInitialization = new DdSdkNativeInitialization(applicationContext, null, null, null, 14, null);
            try {
                ddSdkNativeInitialization.initialize$datadog_mobile_react_native_release(ddSdkNativeInitialization.getConfigurationFromJSONFile$datadog_mobile_react_native_release(), false);
            } catch (Exception e) {
                Log.w(DdSdkNativeInitialization.class.getCanonicalName(), "Failed to initialize the Datadog SDK: " + e);
            }
        }
    }
}
