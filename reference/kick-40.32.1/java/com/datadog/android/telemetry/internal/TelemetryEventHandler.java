package com.datadog.android.telemetry.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.sampling.RateBasedSampler;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.internal.attributes.LocalAttribute;
import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.internal.telemetry.TracingHeaderTypesSet;
import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.configuration.VitalsUpdateFrequency;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.internal.metric.SessionMetricDispatcher;
import com.datadog.android.rum.internal.utils.NumberExtKt;
import com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier;
import com.datadog.android.rum.metric.interactiontonextview.TimeBasedInteractionIdentifier;
import com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier;
import com.datadog.android.rum.metric.networksettled.TimeBasedInitialResourceIdentifier;
import com.datadog.android.rum.tracking.ActivityViewTrackingStrategy;
import com.datadog.android.rum.tracking.FragmentViewTrackingStrategy;
import com.datadog.android.rum.tracking.MixedViewTrackingStrategy;
import com.datadog.android.rum.tracking.NavigationViewTrackingStrategy;
import com.datadog.android.rum.tracking.TrackingStrategy;
import com.datadog.android.rum.tracking.ViewTrackingStrategy;
import com.datadog.android.telemetry.model.TelemetryConfigurationEvent;
import com.datadog.android.telemetry.model.TelemetryDebugEvent;
import com.datadog.android.telemetry.model.TelemetryErrorEvent;
import com.datadog.android.telemetry.model.TelemetryUsageEvent;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TelemetryEventHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 U2\u00020\u0001:\u0002UVB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J3\u0010 \u001a\u00020!2\u0018\b\u0002\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010'J(\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020.2\u0006\u0010/\u001a\u00020!H\u0002J(\u00100\u001a\u0002012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001f\u001a\u0002022\u0006\u0010/\u001a\u00020!H\u0002J@\u00103\u001a\u0002042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u00105\u001a\u00020$2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010#2\u0006\u0010/\u001a\u00020!H\u0002JT\u00107\u001a\u0002082\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u00105\u001a\u00020$2\b\u00109\u001a\u0004\u0018\u00010$2\b\u0010:\u001a\u0004\u0018\u00010$2\u0006\u0010/\u001a\u00020!2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010#H\u0002J\u001e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020%0@H\u0007J\b\u0010A\u001a\u00020\u001bH\u0002J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u001e\u0010C\u001a\u00020\u001b2\u0014\u0010D\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0#H\u0002J\u0018\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u00020\u001bH\u0016J*\u0010H\u001a\u0004\u0018\u00010$2\b\u0010I\u001a\u0004\u0018\u00010J2\u0014\u0010D\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0#H\u0002J \u0010K\u001a\u0004\u0018\u00010J2\u0014\u0010D\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0#H\u0002J(\u0010L\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0M*\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0MH\u0002J(\u0010N\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0M*\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0MH\u0002J)\u0010O\u001a\u0004\u0018\u00010!*\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0#2\u0006\u0010P\u001a\u00020QH\u0002¢\u0006\u0002\u0010RJ\f\u0010S\u001a\u00020T*\u00020+H\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/datadog/android/telemetry/internal/TelemetryEventHandler;", "Lcom/datadog/android/rum/RumSessionListener;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "eventSampler", "Lcom/datadog/android/core/sampling/Sampler;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent;", "configurationExtraSampler", "sessionEndedMetricDispatcher", "Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;", "maxEventCountPerSession", "", "(Lcom/datadog/android/core/InternalSdkCore;Lcom/datadog/android/core/sampling/Sampler;Lcom/datadog/android/core/sampling/Sampler;Lcom/datadog/android/rum/internal/metric/SessionMetricDispatcher;I)V", "getConfigurationExtraSampler$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/sampling/Sampler;", "eventIDsSeenInCurrentSession", "", "Lcom/datadog/android/telemetry/internal/TelemetryEventId;", "getEventSampler$dd_sdk_android_rum_release", "rumConfig", "Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "getRumConfig", "()Lcom/datadog/android/rum/internal/RumFeature$Configuration;", "getSdkCore$dd_sdk_android_rum_release", "()Lcom/datadog/android/core/InternalSdkCore;", "totalEventsSeenInCurrentSession", "trackNetworkRequests", "", "trackResourceHeaders", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent$TrackResourceHeaders;", "canWrite", "event", "computeEffectiveSampleRate", "", "properties", "", "", "", "eventSpecificSamplingRate", "(Ljava/util/Map;Ljava/lang/Float;)F", "createApiUsageEvent", "Lcom/datadog/android/telemetry/model/TelemetryUsageEvent;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "timestamp", "", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$ApiUsage;", "effectiveSampleRate", "createConfigurationEvent", "Lcom/datadog/android/telemetry/model/TelemetryConfigurationEvent;", "Lcom/datadog/android/internal/telemetry/InternalTelemetryEvent$Configuration;", "createDebugEvent", "Lcom/datadog/android/telemetry/model/TelemetryDebugEvent;", "message", "additionalProperties", "createErrorEvent", "Lcom/datadog/android/telemetry/model/TelemetryErrorEvent;", "stack", "kind", "handleEvent", "", "wrappedEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$TelemetryEventWrapper;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "isGlobalTracerRegistered", "isLog", "isOpenTelemetryRegistered", "traceContext", "onSessionStarted", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "isDiscarded", "resolveOpenTelemetryApiVersion", "tracerApi", "Lcom/datadog/android/telemetry/internal/TelemetryEventHandler$TracerApi;", "resolveTracerApi", "addDiagnosticsAttributes", "", "cleanUpInternalAttributes", "getFloat", "key", "Lcom/datadog/android/internal/attributes/LocalAttribute$Key;", "(Ljava/util/Map;Lcom/datadog/android/internal/attributes/LocalAttribute$Key;)Ljava/lang/Float;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "Companion", "TracerApi", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TelemetryEventHandler implements RumSessionListener {
    public static final String ALREADY_SEEN_EVENT_MESSAGE = "Already seen telemetry event with identity=%s, rejecting.";
    public static final float DEFAULT_CONFIGURATION_SAMPLE_RATE = 20.0f;
    public static final String DIAGNOSTICS_PROCESS_UPTIME = "process_uptime";
    public static final String IS_OPENTELEMETRY_ENABLED_CONTEXT_KEY = "is_opentelemetry_enabled";
    public static final int MAX_EVENTS_PER_SESSION = 100;
    public static final String MAX_EVENT_NUMBER_REACHED_MESSAGE = "Max number of telemetry events per session reached, rejecting.";
    public static final String OKHTTP_INTERCEPTOR_HEADER_TYPES = "okhttp_interceptor_header_types";
    public static final String OKHTTP_INTERCEPTOR_SAMPLE_RATE = "okhttp_interceptor_sample_rate";
    public static final String OPENTELEMETRY_API_VERSION_CONTEXT_KEY = "opentelemetry_api_version";
    public static final String SESSION_REPLAY_IMAGE_PRIVACY_KEY = "session_replay_image_privacy";
    public static final String SESSION_REPLAY_SAMPLE_RATE_KEY = "session_replay_sample_rate";
    public static final String SESSION_REPLAY_START_IMMEDIATE_RECORDING_KEY = "session_replay_start_immediate_recording";
    public static final String SESSION_REPLAY_TEXT_AND_INPUT_PRIVACY_KEY = "session_replay_text_and_input_privacy";
    public static final String SESSION_REPLAY_TOUCH_PRIVACY_KEY = "session_replay_touch_privacy";
    public static final String TELEMETRY_SERVICE_NAME = "dd-sdk-android";
    private final Sampler<InternalTelemetryEvent> configurationExtraSampler;
    private final Set<TelemetryEventId> eventIDsSeenInCurrentSession;
    private final Sampler<InternalTelemetryEvent> eventSampler;
    private final int maxEventCountPerSession;
    private final InternalSdkCore sdkCore;
    private final SessionMetricDispatcher sessionEndedMetricDispatcher;
    private int totalEventsSeenInCurrentSession;
    private boolean trackNetworkRequests;
    private TelemetryConfigurationEvent.TrackResourceHeaders trackResourceHeaders;

    /* JADX INFO: compiled from: TelemetryEventHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/telemetry/internal/TelemetryEventHandler$TracerApi;", "", "(Ljava/lang/String;I)V", "OpenTelemetry", "OpenTracing", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum TracerApi {
        OpenTelemetry,
        OpenTracing
    }

    /* JADX INFO: compiled from: TelemetryEventHandler.kt */
    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InternalTelemetryEvent.ApiUsage.AddOperationStepVital.ActionType.values().length];
            try {
                iArr[InternalTelemetryEvent.ApiUsage.AddOperationStepVital.ActionType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InternalTelemetryEvent.ApiUsage.AddOperationStepVital.ActionType.SUCCEED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InternalTelemetryEvent.ApiUsage.AddOperationStepVital.ActionType.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType.values().length];
            try {
                iArr2[InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType.CRONET.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType.OKHTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[InternalTelemetryEvent.ApiUsage.NetworkInstrumentation.LibraryType.LEGACY_OKHTTP.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public TelemetryEventHandler(InternalSdkCore sdkCore, Sampler<InternalTelemetryEvent> eventSampler, Sampler<InternalTelemetryEvent> configurationExtraSampler, SessionMetricDispatcher sessionEndedMetricDispatcher, int i) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(eventSampler, "eventSampler");
        Intrinsics.checkNotNullParameter(configurationExtraSampler, "configurationExtraSampler");
        Intrinsics.checkNotNullParameter(sessionEndedMetricDispatcher, "sessionEndedMetricDispatcher");
        this.sdkCore = sdkCore;
        this.eventSampler = eventSampler;
        this.configurationExtraSampler = configurationExtraSampler;
        this.sessionEndedMetricDispatcher = sessionEndedMetricDispatcher;
        this.maxEventCountPerSession = i;
        this.eventIDsSeenInCurrentSession = new LinkedHashSet();
    }

    /* JADX INFO: renamed from: getSdkCore$dd_sdk_android_rum_release, reason: from getter */
    public final InternalSdkCore getSdkCore() {
        return this.sdkCore;
    }

    public final Sampler<InternalTelemetryEvent> getEventSampler$dd_sdk_android_rum_release() {
        return this.eventSampler;
    }

    public final Sampler<InternalTelemetryEvent> getConfigurationExtraSampler$dd_sdk_android_rum_release() {
        return this.configurationExtraSampler;
    }

    public /* synthetic */ TelemetryEventHandler(InternalSdkCore internalSdkCore, Sampler sampler, RateBasedSampler rateBasedSampler, SessionMetricDispatcher sessionMetricDispatcher, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalSdkCore, sampler, (i2 & 4) != 0 ? new RateBasedSampler(20.0f) : rateBasedSampler, sessionMetricDispatcher, (i2 & 16) != 0 ? 100 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RumFeature.Configuration getRumConfig() {
        RumFeature rumFeature;
        FeatureScope feature = this.sdkCore.getFeature("rum");
        if (feature == null || (rumFeature = (RumFeature) feature.unwrap()) == null) {
            return null;
        }
        return rumFeature.getConfiguration();
    }

    public final void handleEvent(final RumRawEvent.TelemetryEventWrapper wrappedEvent, final DataWriter<Object> writer) {
        Intrinsics.checkNotNullParameter(wrappedEvent, "wrappedEvent");
        Intrinsics.checkNotNullParameter(writer, "writer");
        final InternalTelemetryEvent event = wrappedEvent.getEvent();
        if (canWrite(event)) {
            this.eventIDsSeenInCurrentSession.add(TelemetryEventIdKt.getIdentity(event));
            if (!(event instanceof InternalTelemetryEvent.Configuration)) {
                this.totalEventsSeenInCurrentSession++;
            }
            FeatureScope feature = this.sdkCore.getFeature("rum");
            if (feature != null) {
                feature.withWriteContext(SetsKt.setOf((Object[]) new String[]{"session-replay", "tracing", "rum"}), new Function2<DatadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit>, Unit>() { // from class: com.datadog.android.telemetry.internal.TelemetryEventHandler.handleEvent.1

                    /* JADX INFO: renamed from: com.datadog.android.telemetry.internal.TelemetryEventHandler$handleEvent$1$WhenMappings */
                    /* JADX INFO: compiled from: TelemetryEventHandler.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode.values().length];
                            try {
                                iArr[InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode.DEFAULT_HEADERS.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[InternalTelemetryEvent.ResourceHeadersTrackingConfigured.Mode.CUSTOM.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, ? extends Unit>, ? extends Unit> function1) {
                        invoke2(datadogContext, (Function1<? super Function1<? super EventBatchWriter, Unit>, Unit>) function1);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope) {
                        TelemetryConfigurationEvent.TrackResourceHeaders trackResourceHeaders;
                        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                        Intrinsics.checkNotNullParameter(writeScope, "writeScope");
                        long timestamp = wrappedEvent.getEventTime().getTimestamp() + datadogContext.getTime().getServerTimeOffsetMs();
                        InternalTelemetryEvent internalTelemetryEvent = event;
                        final Object objCreateApiUsageEvent = null;
                        if (internalTelemetryEvent instanceof InternalTelemetryEvent.Log.Debug) {
                            objCreateApiUsageEvent = this.createDebugEvent(datadogContext, timestamp, ((InternalTelemetryEvent.Log.Debug) internalTelemetryEvent).getMessage(), ((InternalTelemetryEvent.Log.Debug) event).getAdditionalProperties(), TelemetryEventHandler.computeEffectiveSampleRate$default(this, ((InternalTelemetryEvent.Log.Debug) event).getAdditionalProperties(), null, 2, null));
                        } else if (internalTelemetryEvent instanceof InternalTelemetryEvent.Metric) {
                            objCreateApiUsageEvent = this.createDebugEvent(datadogContext, timestamp, ((InternalTelemetryEvent.Metric) internalTelemetryEvent).getMessage(), ((InternalTelemetryEvent.Metric) event).getAdditionalProperties(), TelemetryEventHandler.computeEffectiveSampleRate$default(this, ((InternalTelemetryEvent.Metric) event).getAdditionalProperties(), null, 2, null));
                        } else if (internalTelemetryEvent instanceof InternalTelemetryEvent.Log.Error) {
                            this.sessionEndedMetricDispatcher.onSdkErrorTracked(this.rumContext(datadogContext).getSessionId(), ((InternalTelemetryEvent.Log.Error) event).getKind());
                            objCreateApiUsageEvent = this.createErrorEvent(datadogContext, timestamp, ((InternalTelemetryEvent.Log.Error) event).getMessage(), ((InternalTelemetryEvent.Log.Error) event).resolveStacktrace(), ((InternalTelemetryEvent.Log.Error) event).resolveKind(), TelemetryEventHandler.computeEffectiveSampleRate$default(this, ((InternalTelemetryEvent.Log.Error) event).getAdditionalProperties(), null, 2, null), ((InternalTelemetryEvent.Log.Error) event).getAdditionalProperties());
                        } else if (internalTelemetryEvent instanceof InternalTelemetryEvent.Configuration) {
                            TelemetryEventHandler telemetryEventHandler = this;
                            InternalTelemetryEvent.Configuration configuration = (InternalTelemetryEvent.Configuration) internalTelemetryEvent;
                            RumFeature.Configuration rumConfig = telemetryEventHandler.getRumConfig();
                            objCreateApiUsageEvent = telemetryEventHandler.createConfigurationEvent(datadogContext, timestamp, configuration, TelemetryEventHandler.computeEffectiveSampleRate$default(telemetryEventHandler, null, rumConfig != null ? Float.valueOf(rumConfig.getTelemetryConfigurationSampleRate()) : null, 1, null));
                        } else if (internalTelemetryEvent instanceof InternalTelemetryEvent.ApiUsage) {
                            TelemetryEventHandler telemetryEventHandler2 = this;
                            objCreateApiUsageEvent = telemetryEventHandler2.createApiUsageEvent(datadogContext, timestamp, (InternalTelemetryEvent.ApiUsage) internalTelemetryEvent, TelemetryEventHandler.computeEffectiveSampleRate$default(telemetryEventHandler2, ((InternalTelemetryEvent.ApiUsage) internalTelemetryEvent).getAdditionalProperties(), null, 2, null));
                        } else if (internalTelemetryEvent instanceof InternalTelemetryEvent.InterceptorInstantiated) {
                            this.trackNetworkRequests = true;
                        } else if (internalTelemetryEvent instanceof InternalTelemetryEvent.ResourceHeadersTrackingConfigured) {
                            TelemetryEventHandler telemetryEventHandler3 = this;
                            int i = WhenMappings.$EnumSwitchMapping$0[((InternalTelemetryEvent.ResourceHeadersTrackingConfigured) internalTelemetryEvent).getMode().ordinal()];
                            if (i == 1) {
                                trackResourceHeaders = TelemetryConfigurationEvent.TrackResourceHeaders.DEFAULT_HEADERS;
                            } else {
                                if (i != 2) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                trackResourceHeaders = TelemetryConfigurationEvent.TrackResourceHeaders.CUSTOM;
                            }
                            telemetryEventHandler3.trackResourceHeaders = trackResourceHeaders;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (objCreateApiUsageEvent != null) {
                            final DataWriter<Object> dataWriter = writer;
                            writeScope.invoke(new Function1<EventBatchWriter, Unit>() { // from class: com.datadog.android.telemetry.internal.TelemetryEventHandler.handleEvent.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(EventBatchWriter eventBatchWriter) {
                                    invoke2(eventBatchWriter);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(EventBatchWriter it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    dataWriter.write(it, objCreateApiUsageEvent, EventType.TELEMETRY);
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    @Override // com.datadog.android.rum.RumSessionListener
    public void onSessionStarted(String sessionId, boolean isDiscarded) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.eventIDsSeenInCurrentSession.clear();
        this.totalEventsSeenInCurrentSession = 0;
    }

    private final boolean canWrite(InternalTelemetryEvent event) {
        if (!this.eventSampler.sample(event)) {
            return false;
        }
        if (event instanceof InternalTelemetryEvent.Configuration) {
            return this.configurationExtraSampler.sample(event);
        }
        final TelemetryEventId identity = TelemetryEventIdKt.getIdentity(event);
        if (isLog(event) && this.eventIDsSeenInCurrentSession.contains(identity)) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.telemetry.internal.TelemetryEventHandler.canWrite.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, TelemetryEventHandler.ALREADY_SEEN_EVENT_MESSAGE, Arrays.copyOf(new Object[]{identity}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        if (this.totalEventsSeenInCurrentSession < this.maxEventCountPerSession) {
            return true;
        }
        InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.telemetry.internal.TelemetryEventHandler.canWrite.2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return TelemetryEventHandler.MAX_EVENT_NUMBER_REACHED_MESSAGE;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return false;
    }

    private final boolean isLog(InternalTelemetryEvent event) {
        return event instanceof InternalTelemetryEvent.Log;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TelemetryDebugEvent createDebugEvent(DatadogContext datadogContext, long timestamp, String message, Map<String, ? extends Object> additionalProperties, float effectiveSampleRate) {
        RumContext rumContext = rumContext(datadogContext);
        Map<String, Object> mapAddDiagnosticsAttributes = addDiagnosticsAttributes(cleanUpInternalAttributes(MapsKt.toMutableMap(additionalProperties == null ? MapsKt.emptyMap() : additionalProperties)));
        TelemetryDebugEvent.Dd dd = new TelemetryDebugEvent.Dd();
        TelemetryDebugEvent.Source sourceTryFromSource = TelemetryEventExtKt.tryFromSource(TelemetryDebugEvent.Source.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger());
        if (sourceTryFromSource == null) {
            sourceTryFromSource = TelemetryDebugEvent.Source.ANDROID;
        }
        TelemetryDebugEvent.Source source = sourceTryFromSource;
        String sdkVersion = datadogContext.getSdkVersion();
        TelemetryDebugEvent.Application application = new TelemetryDebugEvent.Application(rumContext.getApplicationId());
        TelemetryDebugEvent.Session session = new TelemetryDebugEvent.Session(rumContext.getSessionId());
        String viewId = rumContext.getViewId();
        TelemetryDebugEvent.View view = viewId != null ? new TelemetryDebugEvent.View(viewId) : null;
        String actionId = rumContext.getActionId();
        return new TelemetryDebugEvent(dd, timestamp, "dd-sdk-android", source, sdkVersion, application, session, view, actionId != null ? new TelemetryDebugEvent.Action(actionId) : null, Float.valueOf(effectiveSampleRate), null, new TelemetryDebugEvent.Telemetry(new TelemetryDebugEvent.Device(datadogContext.getDeviceInfo().getArchitecture(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getDeviceModel(), Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam()), new TelemetryDebugEvent.Os(datadogContext.getDeviceInfo().getDeviceBuildId(), datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion()), message, mapAddDiagnosticsAttributes), 1024, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TelemetryErrorEvent createErrorEvent(DatadogContext datadogContext, long timestamp, String message, String stack, String kind, float effectiveSampleRate, Map<String, ? extends Object> additionalProperties) {
        RumContext rumContext = rumContext(datadogContext);
        Map<String, Object> mapAddDiagnosticsAttributes = addDiagnosticsAttributes(cleanUpInternalAttributes(MapsKt.toMutableMap(additionalProperties == null ? MapsKt.emptyMap() : additionalProperties)));
        TelemetryErrorEvent.Dd dd = new TelemetryErrorEvent.Dd();
        TelemetryErrorEvent.Source sourceTryFromSource = TelemetryEventExtKt.tryFromSource(TelemetryErrorEvent.Source.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger());
        if (sourceTryFromSource == null) {
            sourceTryFromSource = TelemetryErrorEvent.Source.ANDROID;
        }
        TelemetryErrorEvent.Source source = sourceTryFromSource;
        String sdkVersion = datadogContext.getSdkVersion();
        TelemetryErrorEvent.Application application = new TelemetryErrorEvent.Application(rumContext.getApplicationId());
        TelemetryErrorEvent.Session session = new TelemetryErrorEvent.Session(rumContext.getSessionId());
        String viewId = rumContext.getViewId();
        TelemetryErrorEvent.View view = viewId != null ? new TelemetryErrorEvent.View(viewId) : null;
        String actionId = rumContext.getActionId();
        return new TelemetryErrorEvent(dd, timestamp, "dd-sdk-android", source, sdkVersion, application, session, view, actionId != null ? new TelemetryErrorEvent.Action(actionId) : null, Float.valueOf(effectiveSampleRate), null, new TelemetryErrorEvent.Telemetry(new TelemetryErrorEvent.Device(datadogContext.getDeviceInfo().getArchitecture(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getDeviceModel(), Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam()), new TelemetryErrorEvent.Os(datadogContext.getDeviceInfo().getDeviceBuildId(), datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion()), message, (stack == null && kind == null) ? null : new TelemetryErrorEvent.Error(stack, kind), mapAddDiagnosticsAttributes), 1024, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x0201  */
    /* JADX WARN: Code duplicated, block: B:103:0x020c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0218  */
    /* JADX WARN: Code duplicated, block: B:107:0x0223  */
    /* JADX WARN: Code duplicated, block: B:110:0x022b  */
    /* JADX WARN: Code duplicated, block: B:111:0x0234  */
    /* JADX WARN: Code duplicated, block: B:113:0x0238  */
    /* JADX WARN: Code duplicated, block: B:114:0x023b  */
    /* JADX WARN: Code duplicated, block: B:117:0x0247  */
    /* JADX WARN: Code duplicated, block: B:118:0x024c  */
    /* JADX WARN: Code duplicated, block: B:121:0x0251  */
    /* JADX WARN: Code duplicated, block: B:127:0x0271  */
    /* JADX WARN: Code duplicated, block: B:129:0x0275  */
    /* JADX WARN: Code duplicated, block: B:130:0x027c  */
    /* JADX WARN: Code duplicated, block: B:133:0x0299  */
    /* JADX WARN: Code duplicated, block: B:134:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:136:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:137:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:139:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:140:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:57:0x00da  */
    /* JADX WARN: Code duplicated, block: B:58:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:72:0x0107  */
    /* JADX WARN: Code duplicated, block: B:73:0x010c  */
    /* JADX WARN: Code duplicated, block: B:76:0x0111  */
    /* JADX WARN: Code duplicated, block: B:77:0x0114  */
    /* JADX WARN: Code duplicated, block: B:79:0x0117  */
    /* JADX WARN: Code duplicated, block: B:80:0x0122  */
    /* JADX WARN: Code duplicated, block: B:83:0x013b  */
    /* JADX WARN: Code duplicated, block: B:86:0x015b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0163  */
    /* JADX WARN: Code duplicated, block: B:90:0x016b  */
    /* JADX WARN: Code duplicated, block: B:91:0x0172  */
    /* JADX WARN: Code duplicated, block: B:94:0x01db  */
    /* JADX WARN: Code duplicated, block: B:95:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:98:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:99:0x01f6  */
    public final TelemetryConfigurationEvent createConfigurationEvent(DatadogContext datadogContext, long timestamp, InternalTelemetryEvent.Configuration event, float effectiveSampleRate) {
        TelemetryConfigurationEvent.ViewTrackingStrategy viewTrackingStrategy;
        TelemetryConfigurationEvent.ViewTrackingStrategy viewTrackingStrategy2;
        Map<String, Object> mapEmptyMap;
        TracerApi tracerApiResolveTracerApi;
        boolean z;
        Object obj;
        Float f;
        Object obj2;
        TracingHeaderTypesSet tracingHeaderTypesSet;
        RumFeature.Configuration rumConfig;
        LastInteractionIdentifier lastInteractionIdentifier;
        TimeBasedInteractionIdentifier timeBasedInteractionIdentifier;
        Long lValueOf;
        RumFeature.Configuration rumConfig2;
        InitialResourceIdentifier initialResourceIdentifier;
        TimeBasedInitialResourceIdentifier timeBasedInitialResourceIdentifier;
        Long lValueOf2;
        TelemetryConfigurationEvent.Source sourceTryFromSource;
        String viewId;
        TelemetryConfigurationEvent.View view;
        String actionId;
        TelemetryConfigurationEvent.Action action;
        RumFeature.Configuration rumConfig3;
        Long lValueOf3;
        RumFeature.Configuration rumConfig4;
        Long lValueOf4;
        RumFeature.Configuration rumConfig5;
        Boolean boolValueOf;
        RumFeature.Configuration rumConfig6;
        Boolean boolValueOf2;
        RumFeature.Configuration rumConfig7;
        Boolean boolValueOf3;
        boolean z2;
        RumFeature.Configuration rumConfig8;
        TrackingStrategy longTaskTrackingStrategy;
        RumFeature.Configuration rumConfig9;
        Long lValueOf5;
        String strName;
        Integer numberOfDisplays;
        Long lValueOf6;
        Long lValueOf7;
        List<TelemetryConfigurationEvent.SelectedTracingPropagator> selectedTracingPropagators;
        VitalsUpdateFrequency vitalsMonitorUpdateFrequency;
        FeatureScope feature = this.sdkCore.getFeature("tracing");
        Map<String, Object> mapEmptyMap2 = datadogContext.getFeaturesContext().get("session-replay");
        if (mapEmptyMap2 == null) {
            mapEmptyMap2 = MapsKt.emptyMap();
        }
        Object obj3 = mapEmptyMap2.get("session_replay_sample_rate");
        Long l = obj3 instanceof Long ? (Long) obj3 : null;
        Object obj4 = mapEmptyMap2.get(SESSION_REPLAY_START_IMMEDIATE_RECORDING_KEY);
        Boolean bool = obj4 instanceof Boolean ? (Boolean) obj4 : null;
        Object obj5 = mapEmptyMap2.get("session_replay_image_privacy");
        String str = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = mapEmptyMap2.get("session_replay_touch_privacy");
        String str2 = obj6 instanceof String ? (String) obj6 : null;
        Object obj7 = mapEmptyMap2.get("session_replay_text_and_input_privacy");
        String str3 = obj7 instanceof String ? (String) obj7 : null;
        RumFeature.Configuration rumConfig10 = getRumConfig();
        ViewTrackingStrategy viewTrackingStrategy3 = rumConfig10 != null ? rumConfig10.getViewTrackingStrategy() : null;
        if (viewTrackingStrategy3 instanceof ActivityViewTrackingStrategy) {
            viewTrackingStrategy2 = TelemetryConfigurationEvent.ViewTrackingStrategy.ACTIVITYVIEWTRACKINGSTRATEGY;
        } else if (viewTrackingStrategy3 instanceof FragmentViewTrackingStrategy) {
            viewTrackingStrategy2 = TelemetryConfigurationEvent.ViewTrackingStrategy.FRAGMENTVIEWTRACKINGSTRATEGY;
        } else {
            if (!(viewTrackingStrategy3 instanceof MixedViewTrackingStrategy)) {
                if (viewTrackingStrategy3 instanceof NavigationViewTrackingStrategy) {
                    viewTrackingStrategy2 = TelemetryConfigurationEvent.ViewTrackingStrategy.NAVIGATIONVIEWTRACKINGSTRATEGY;
                } else {
                    viewTrackingStrategy = null;
                }
                RumContext rumContext = rumContext(datadogContext);
                mapEmptyMap = datadogContext.getFeaturesContext().get("tracing");
                if (mapEmptyMap == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                tracerApiResolveTracerApi = resolveTracerApi(mapEmptyMap);
                String strResolveOpenTelemetryApiVersion = resolveOpenTelemetryApiVersion(tracerApiResolveTracerApi, mapEmptyMap);
                if (feature != null || tracerApiResolveTracerApi == null) {
                    z = false;
                } else {
                    z = true;
                }
                obj = mapEmptyMap.get("okhttp_interceptor_sample_rate");
                if (obj instanceof Float) {
                    f = (Float) obj;
                } else {
                    f = null;
                }
                obj2 = mapEmptyMap.get(OKHTTP_INTERCEPTOR_HEADER_TYPES);
                if (obj2 instanceof TracingHeaderTypesSet) {
                    tracingHeaderTypesSet = (TracingHeaderTypesSet) obj2;
                } else {
                    tracingHeaderTypesSet = null;
                }
                rumConfig = getRumConfig();
                if (rumConfig != null) {
                    lastInteractionIdentifier = rumConfig.getLastInteractionIdentifier();
                } else {
                    lastInteractionIdentifier = null;
                }
                if (lastInteractionIdentifier instanceof TimeBasedInteractionIdentifier) {
                    timeBasedInteractionIdentifier = (TimeBasedInteractionIdentifier) lastInteractionIdentifier;
                } else {
                    timeBasedInteractionIdentifier = null;
                }
                if (timeBasedInteractionIdentifier != null) {
                    lValueOf = Long.valueOf(timeBasedInteractionIdentifier.getTimeThresholdInMilliseconds());
                } else {
                    lValueOf = null;
                }
                rumConfig2 = getRumConfig();
                if (rumConfig2 != null) {
                    initialResourceIdentifier = rumConfig2.getInitialResourceIdentifier();
                } else {
                    initialResourceIdentifier = null;
                }
                if (initialResourceIdentifier instanceof TimeBasedInitialResourceIdentifier) {
                    timeBasedInitialResourceIdentifier = (TimeBasedInitialResourceIdentifier) initialResourceIdentifier;
                } else {
                    timeBasedInitialResourceIdentifier = null;
                }
                if (timeBasedInitialResourceIdentifier != null) {
                    lValueOf2 = Long.valueOf(timeBasedInitialResourceIdentifier.getTimeThresholdInMilliseconds());
                } else {
                    lValueOf2 = null;
                }
                TelemetryConfigurationEvent.Dd dd = new TelemetryConfigurationEvent.Dd();
                sourceTryFromSource = TelemetryEventExtKt.tryFromSource(TelemetryConfigurationEvent.Source.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger());
                if (sourceTryFromSource == null) {
                    sourceTryFromSource = TelemetryConfigurationEvent.Source.ANDROID;
                }
                TelemetryConfigurationEvent.Source source = sourceTryFromSource;
                String sdkVersion = datadogContext.getSdkVersion();
                TelemetryConfigurationEvent.Application application = new TelemetryConfigurationEvent.Application(rumContext.getApplicationId());
                TelemetryConfigurationEvent.Session session = new TelemetryConfigurationEvent.Session(rumContext.getSessionId());
                viewId = rumContext.getViewId();
                if (viewId != null) {
                    view = new TelemetryConfigurationEvent.View(viewId);
                } else {
                    view = null;
                }
                actionId = rumContext.getActionId();
                if (actionId != null) {
                    action = new TelemetryConfigurationEvent.Action(actionId);
                } else {
                    action = null;
                }
                TelemetryConfigurationEvent.Device device = new TelemetryConfigurationEvent.Device(datadogContext.getDeviceInfo().getArchitecture(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getDeviceModel(), Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam());
                TelemetryConfigurationEvent.Os os = new TelemetryConfigurationEvent.Os(datadogContext.getDeviceInfo().getDeviceBuildId(), datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion());
                rumConfig3 = getRumConfig();
                if (rumConfig3 != null) {
                    lValueOf3 = Long.valueOf((long) rumConfig3.getSampleRate());
                } else {
                    lValueOf3 = null;
                }
                rumConfig4 = getRumConfig();
                if (rumConfig4 != null) {
                    lValueOf4 = Long.valueOf((long) rumConfig4.getTelemetrySampleRate());
                } else {
                    lValueOf4 = null;
                }
                boolean useProxy = event.getUseProxy();
                rumConfig5 = getRumConfig();
                if (rumConfig5 != null) {
                    boolValueOf = Boolean.valueOf(rumConfig5.getTrackFrustrations());
                } else {
                    boolValueOf = null;
                }
                boolean useLocalEncryption = event.getUseLocalEncryption();
                rumConfig6 = getRumConfig();
                if (rumConfig6 != null) {
                    boolValueOf2 = Boolean.valueOf(rumConfig6.getBackgroundEventTracking());
                } else {
                    boolValueOf2 = null;
                }
                rumConfig7 = getRumConfig();
                if (rumConfig7 != null) {
                    boolValueOf3 = Boolean.valueOf(rumConfig7.getUserActionTracking());
                } else {
                    boolValueOf3 = null;
                }
                if (boolValueOf3 != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean trackErrors = event.getTrackErrors();
                rumConfig8 = getRumConfig();
                if (rumConfig8 != null) {
                    longTaskTrackingStrategy = rumConfig8.getLongTaskTrackingStrategy();
                } else {
                    longTaskTrackingStrategy = null;
                }
                boolean z3 = longTaskTrackingStrategy != null;
                long batchSize = event.getBatchSize();
                long batchUploadFrequency = event.getBatchUploadFrequency();
                rumConfig9 = getRumConfig();
                if (rumConfig9 != null || (vitalsMonitorUpdateFrequency = rumConfig9.getVitalsMonitorUpdateFrequency()) == null) {
                    lValueOf5 = null;
                } else {
                    lValueOf5 = Long.valueOf(vitalsMonitorUpdateFrequency.getPeriodInMs());
                }
                if (tracerApiResolveTracerApi != null) {
                    strName = tracerApiResolveTracerApi.name();
                } else {
                    strName = null;
                }
                boolean z4 = this.trackNetworkRequests;
                long batchProcessingLevel = event.getBatchProcessingLevel();
                boolean zIsMainProcess = datadogContext.getProcessInfo().isMainProcess();
                numberOfDisplays = datadogContext.getDeviceInfo().getNumberOfDisplays();
                boolean z5 = z;
                if (numberOfDisplays != null) {
                    lValueOf6 = Long.valueOf(numberOfDisplays.intValue());
                } else {
                    lValueOf6 = null;
                }
                if (f != null) {
                    lValueOf7 = Long.valueOf((long) f.floatValue());
                } else {
                    lValueOf7 = null;
                }
                if (tracingHeaderTypesSet != 0) {
                    selectedTracingPropagators = TracingHeaderTypesSetUtilsKt.toSelectedTracingPropagators(tracingHeaderTypesSet);
                } else {
                    selectedTracingPropagators = null;
                }
                return new TelemetryConfigurationEvent(dd, timestamp, "dd-sdk-android", source, sdkVersion, application, session, view, action, Float.valueOf(effectiveSampleRate), null, new TelemetryConfigurationEvent.Telemetry(device, os, new TelemetryConfigurationEvent.Configuration(lValueOf3, lValueOf4, null, null, lValueOf7, null, null, null, l, null, null, bool, Boolean.valueOf(useProxy), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, selectedTracingPropagators, null, str3, str, str2, null, null, null, null, boolValueOf, null, Boolean.valueOf(z2), null, null, lValueOf6, null, null, Boolean.valueOf(useLocalEncryption), viewTrackingStrategy, null, null, boolValueOf2, lValueOf5, Boolean.valueOf(trackErrors), Boolean.valueOf(z4), Boolean.valueOf(z5), null, null, Boolean.valueOf(z3), null, null, null, null, Long.valueOf(batchSize), Long.valueOf(batchUploadFrequency), Long.valueOf(batchProcessingLevel), null, null, null, null, null, null, null, null, strName, strResolveOpenTelemetryApiVersion, null, null, Boolean.valueOf(zIsMainProcess), lValueOf, lValueOf2, null, null, null, null, null, null, null, null, null, null, this.trackResourceHeaders, null, -6420, -667718715, -1074683933, null), null, 8, null));
            }
            viewTrackingStrategy2 = TelemetryConfigurationEvent.ViewTrackingStrategy.MIXEDVIEWTRACKINGSTRATEGY;
        }
        viewTrackingStrategy = viewTrackingStrategy2;
        RumContext rumContext2 = rumContext(datadogContext);
        mapEmptyMap = datadogContext.getFeaturesContext().get("tracing");
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        tracerApiResolveTracerApi = resolveTracerApi(mapEmptyMap);
        String strResolveOpenTelemetryApiVersion2 = resolveOpenTelemetryApiVersion(tracerApiResolveTracerApi, mapEmptyMap);
        if (feature != null) {
            z = false;
        } else {
            z = false;
        }
        obj = mapEmptyMap.get("okhttp_interceptor_sample_rate");
        if (obj instanceof Float) {
            f = (Float) obj;
        } else {
            f = null;
        }
        obj2 = mapEmptyMap.get(OKHTTP_INTERCEPTOR_HEADER_TYPES);
        if (obj2 instanceof TracingHeaderTypesSet) {
            tracingHeaderTypesSet = (TracingHeaderTypesSet) obj2;
        } else {
            tracingHeaderTypesSet = null;
        }
        rumConfig = getRumConfig();
        if (rumConfig != null) {
            lastInteractionIdentifier = rumConfig.getLastInteractionIdentifier();
        } else {
            lastInteractionIdentifier = null;
        }
        if (lastInteractionIdentifier instanceof TimeBasedInteractionIdentifier) {
            timeBasedInteractionIdentifier = (TimeBasedInteractionIdentifier) lastInteractionIdentifier;
        } else {
            timeBasedInteractionIdentifier = null;
        }
        if (timeBasedInteractionIdentifier != null) {
            lValueOf = Long.valueOf(timeBasedInteractionIdentifier.getTimeThresholdInMilliseconds());
        } else {
            lValueOf = null;
        }
        rumConfig2 = getRumConfig();
        if (rumConfig2 != null) {
            initialResourceIdentifier = rumConfig2.getInitialResourceIdentifier();
        } else {
            initialResourceIdentifier = null;
        }
        if (initialResourceIdentifier instanceof TimeBasedInitialResourceIdentifier) {
            timeBasedInitialResourceIdentifier = (TimeBasedInitialResourceIdentifier) initialResourceIdentifier;
        } else {
            timeBasedInitialResourceIdentifier = null;
        }
        if (timeBasedInitialResourceIdentifier != null) {
            lValueOf2 = Long.valueOf(timeBasedInitialResourceIdentifier.getTimeThresholdInMilliseconds());
        } else {
            lValueOf2 = null;
        }
        TelemetryConfigurationEvent.Dd dd2 = new TelemetryConfigurationEvent.Dd();
        sourceTryFromSource = TelemetryEventExtKt.tryFromSource(TelemetryConfigurationEvent.Source.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger());
        if (sourceTryFromSource == null) {
            sourceTryFromSource = TelemetryConfigurationEvent.Source.ANDROID;
        }
        TelemetryConfigurationEvent.Source source2 = sourceTryFromSource;
        String sdkVersion2 = datadogContext.getSdkVersion();
        TelemetryConfigurationEvent.Application application2 = new TelemetryConfigurationEvent.Application(rumContext2.getApplicationId());
        TelemetryConfigurationEvent.Session session2 = new TelemetryConfigurationEvent.Session(rumContext2.getSessionId());
        viewId = rumContext2.getViewId();
        if (viewId != null) {
            view = new TelemetryConfigurationEvent.View(viewId);
        } else {
            view = null;
        }
        actionId = rumContext2.getActionId();
        if (actionId != null) {
            action = new TelemetryConfigurationEvent.Action(actionId);
        } else {
            action = null;
        }
        TelemetryConfigurationEvent.Device device2 = new TelemetryConfigurationEvent.Device(datadogContext.getDeviceInfo().getArchitecture(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getDeviceModel(), Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam());
        TelemetryConfigurationEvent.Os os2 = new TelemetryConfigurationEvent.Os(datadogContext.getDeviceInfo().getDeviceBuildId(), datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion());
        rumConfig3 = getRumConfig();
        if (rumConfig3 != null) {
            lValueOf3 = Long.valueOf((long) rumConfig3.getSampleRate());
        } else {
            lValueOf3 = null;
        }
        rumConfig4 = getRumConfig();
        if (rumConfig4 != null) {
            lValueOf4 = Long.valueOf((long) rumConfig4.getTelemetrySampleRate());
        } else {
            lValueOf4 = null;
        }
        boolean useProxy2 = event.getUseProxy();
        rumConfig5 = getRumConfig();
        if (rumConfig5 != null) {
            boolValueOf = Boolean.valueOf(rumConfig5.getTrackFrustrations());
        } else {
            boolValueOf = null;
        }
        boolean useLocalEncryption2 = event.getUseLocalEncryption();
        rumConfig6 = getRumConfig();
        if (rumConfig6 != null) {
            boolValueOf2 = Boolean.valueOf(rumConfig6.getBackgroundEventTracking());
        } else {
            boolValueOf2 = null;
        }
        rumConfig7 = getRumConfig();
        if (rumConfig7 != null) {
            boolValueOf3 = Boolean.valueOf(rumConfig7.getUserActionTracking());
        } else {
            boolValueOf3 = null;
        }
        if (boolValueOf3 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean trackErrors2 = event.getTrackErrors();
        rumConfig8 = getRumConfig();
        if (rumConfig8 != null) {
            longTaskTrackingStrategy = rumConfig8.getLongTaskTrackingStrategy();
        } else {
            longTaskTrackingStrategy = null;
        }
        if (longTaskTrackingStrategy != null) {
        }
        long batchSize2 = event.getBatchSize();
        long batchUploadFrequency2 = event.getBatchUploadFrequency();
        rumConfig9 = getRumConfig();
        if (rumConfig9 != null) {
            lValueOf5 = null;
        } else {
            lValueOf5 = null;
        }
        if (tracerApiResolveTracerApi != null) {
            strName = tracerApiResolveTracerApi.name();
        } else {
            strName = null;
        }
        boolean z6 = this.trackNetworkRequests;
        long batchProcessingLevel2 = event.getBatchProcessingLevel();
        boolean zIsMainProcess2 = datadogContext.getProcessInfo().isMainProcess();
        numberOfDisplays = datadogContext.getDeviceInfo().getNumberOfDisplays();
        boolean z7 = z;
        if (numberOfDisplays != null) {
            lValueOf6 = Long.valueOf(numberOfDisplays.intValue());
        } else {
            lValueOf6 = null;
        }
        if (f != null) {
            lValueOf7 = Long.valueOf((long) f.floatValue());
        } else {
            lValueOf7 = null;
        }
        if (tracingHeaderTypesSet != 0) {
            selectedTracingPropagators = TracingHeaderTypesSetUtilsKt.toSelectedTracingPropagators(tracingHeaderTypesSet);
        } else {
            selectedTracingPropagators = null;
        }
        return new TelemetryConfigurationEvent(dd2, timestamp, "dd-sdk-android", source2, sdkVersion2, application2, session2, view, action, Float.valueOf(effectiveSampleRate), null, new TelemetryConfigurationEvent.Telemetry(device2, os2, new TelemetryConfigurationEvent.Configuration(lValueOf3, lValueOf4, null, null, lValueOf7, null, null, null, l, null, null, bool, Boolean.valueOf(useProxy2), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, selectedTracingPropagators, null, str3, str, str2, null, null, null, null, boolValueOf, null, Boolean.valueOf(z2), null, null, lValueOf6, null, null, Boolean.valueOf(useLocalEncryption2), viewTrackingStrategy, null, null, boolValueOf2, lValueOf5, Boolean.valueOf(trackErrors2), Boolean.valueOf(z6), Boolean.valueOf(z7), null, null, Boolean.valueOf(z3), null, null, null, null, Long.valueOf(batchSize2), Long.valueOf(batchUploadFrequency2), Long.valueOf(batchProcessingLevel2), null, null, null, null, null, null, null, null, strName, strResolveOpenTelemetryApiVersion2, null, null, Boolean.valueOf(zIsMainProcess2), lValueOf, lValueOf2, null, null, null, null, null, null, null, null, null, null, this.trackResourceHeaders, null, -6420, -667718715, -1074683933, null), null, 8, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TelemetryUsageEvent createApiUsageEvent(DatadogContext datadogContext, long timestamp, InternalTelemetryEvent.ApiUsage event, float effectiveSampleRate) {
        TelemetryUsageEvent.Type type;
        TelemetryUsageEvent.Usage.AndroidNetworkInstrumentation androidNetworkInstrumentation;
        TelemetryUsageEvent.ActionType actionType;
        RumContext rumContext = rumContext(datadogContext);
        Map<String, Object> mapCleanUpInternalAttributes = cleanUpInternalAttributes(event.getAdditionalProperties());
        if (event instanceof InternalTelemetryEvent.ApiUsage.AddOperationStepVital) {
            int i = WhenMappings.$EnumSwitchMapping$0[((InternalTelemetryEvent.ApiUsage.AddOperationStepVital) event).getActionType().ordinal()];
            if (i == 1) {
                actionType = TelemetryUsageEvent.ActionType.START;
            } else if (i == 2) {
                actionType = TelemetryUsageEvent.ActionType.SUCCEED;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                actionType = TelemetryUsageEvent.ActionType.FAIL;
            }
            androidNetworkInstrumentation = new TelemetryUsageEvent.Usage.AddOperationStepVital(actionType);
        } else if (event instanceof InternalTelemetryEvent.ApiUsage.AddViewLoadingTime) {
            InternalTelemetryEvent.ApiUsage.AddViewLoadingTime addViewLoadingTime = (InternalTelemetryEvent.ApiUsage.AddViewLoadingTime) event;
            androidNetworkInstrumentation = new TelemetryUsageEvent.Usage.AddViewLoadingTime(addViewLoadingTime.getNoView(), addViewLoadingTime.getNoActiveView(), addViewLoadingTime.getOverwrite());
        } else if (event instanceof InternalTelemetryEvent.ApiUsage.TrackWebView) {
            androidNetworkInstrumentation = new TelemetryUsageEvent.Usage.TrackWebView();
        } else if (event instanceof InternalTelemetryEvent.ApiUsage.Timeseries) {
            androidNetworkInstrumentation = new TelemetryUsageEvent.Usage.Timeseries();
        } else if (event instanceof InternalTelemetryEvent.ApiUsage.NetworkInstrumentation) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[((InternalTelemetryEvent.ApiUsage.NetworkInstrumentation) event).getType().ordinal()];
            if (i2 == 1) {
                type = TelemetryUsageEvent.Type.CRONET;
            } else if (i2 == 2) {
                type = TelemetryUsageEvent.Type.OKHTTP;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                type = TelemetryUsageEvent.Type.LEGACY_OKHTTP;
            }
            androidNetworkInstrumentation = new TelemetryUsageEvent.Usage.AndroidNetworkInstrumentation(type);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        TelemetryUsageEvent.Dd dd = new TelemetryUsageEvent.Dd();
        TelemetryUsageEvent.Source sourceTryFromSource = TelemetryEventExtKt.tryFromSource(TelemetryUsageEvent.Source.INSTANCE, datadogContext.getSource(), this.sdkCore.getInternalLogger());
        if (sourceTryFromSource == null) {
            sourceTryFromSource = TelemetryUsageEvent.Source.ANDROID;
        }
        TelemetryUsageEvent.Source source = sourceTryFromSource;
        String sdkVersion = datadogContext.getSdkVersion();
        TelemetryUsageEvent.Application application = new TelemetryUsageEvent.Application(rumContext.getApplicationId());
        TelemetryUsageEvent.Session session = new TelemetryUsageEvent.Session(rumContext.getSessionId());
        String viewId = rumContext.getViewId();
        TelemetryUsageEvent.View view = viewId != null ? new TelemetryUsageEvent.View(viewId) : null;
        String actionId = rumContext.getActionId();
        return new TelemetryUsageEvent(dd, timestamp, "dd-sdk-android", source, sdkVersion, application, session, view, actionId != null ? new TelemetryUsageEvent.Action(actionId) : null, Float.valueOf(effectiveSampleRate), null, new TelemetryUsageEvent.Telemetry(new TelemetryUsageEvent.Device(datadogContext.getDeviceInfo().getArchitecture(), datadogContext.getDeviceInfo().getDeviceBrand(), datadogContext.getDeviceInfo().getDeviceModel(), Integer.valueOf(datadogContext.getDeviceInfo().getLogicalCpuCount()), datadogContext.getDeviceInfo().getTotalRam(), datadogContext.getDeviceInfo().isLowRam()), new TelemetryUsageEvent.Os(datadogContext.getDeviceInfo().getDeviceBuildId(), datadogContext.getDeviceInfo().getOsName(), datadogContext.getDeviceInfo().getOsVersion()), androidNetworkInstrumentation, mapCleanUpInternalAttributes), 1024, null);
    }

    private final boolean isGlobalTracerRegistered() {
        try {
            Class<?> cls = Class.forName("com.datadog.android.trace.GlobalDatadogTracer");
            try {
                return cls.getDeclaredMethod("getOrNull", null).invoke(cls.getDeclaredField("INSTANCE").get(null), null) != null;
            } catch (Throwable th) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.telemetry.internal.TelemetryEventHandler.isGlobalTracerRegistered.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "GlobalDatadogTracer class exists in the runtime classpath, but there is an error invoking getOrNull method";
                    }
                }, th, false, (Map) null, 48, (Object) null);
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    private final boolean isOpenTelemetryRegistered(Map<String, ? extends Object> traceContext) {
        Object obj = traceContext.get(IS_OPENTELEMETRY_ENABLED_CONTEXT_KEY);
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final TracerApi resolveTracerApi(Map<String, ? extends Object> traceContext) {
        if (isOpenTelemetryRegistered(traceContext)) {
            return TracerApi.OpenTelemetry;
        }
        if (isGlobalTracerRegistered()) {
            return TracerApi.OpenTracing;
        }
        return null;
    }

    private final String resolveOpenTelemetryApiVersion(TracerApi tracerApi, Map<String, ? extends Object> traceContext) {
        if (tracerApi == TracerApi.OpenTelemetry) {
            Object obj = traceContext.get(OPENTELEMETRY_API_VERSION_CONTEXT_KEY);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RumContext rumContext(DatadogContext datadogContext) {
        Map<String, ? extends Object> mapEmptyMap = datadogContext.getFeaturesContext().get("rum");
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        return RumContext.INSTANCE.fromFeatureContext(mapEmptyMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ float computeEffectiveSampleRate$default(TelemetryEventHandler telemetryEventHandler, Map map, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        if ((i & 2) != 0) {
            f = null;
        }
        return telemetryEventHandler.computeEffectiveSampleRate(map, f);
    }

    private final float computeEffectiveSampleRate(Map<String, ? extends Object> properties, Float eventSpecificSamplingRate) {
        Float f;
        Float f2;
        RumFeature.Configuration rumConfig = getRumConfig();
        if (rumConfig == null) {
            return 0.0f;
        }
        double dPercent = NumberExtKt.percent(rumConfig.getTelemetrySampleRate());
        double dPercent2 = (properties == null || (f2 = getFloat(properties, LocalAttribute.Key.CREATION_SAMPLING_RATE)) == null) ? 1.0d : NumberExtKt.percent(f2.floatValue());
        return (float) (dPercent * dPercent2 * ((properties == null || (f = getFloat(properties, LocalAttribute.Key.REPORTING_SAMPLING_RATE)) == null) ? 1.0d : NumberExtKt.percent(f.floatValue())) * (eventSpecificSamplingRate != null ? NumberExtKt.percent(eventSpecificSamplingRate.floatValue()) : 1.0d) * 100.0d);
    }

    private final Float getFloat(Map<String, ? extends Object> map, LocalAttribute.Key key) {
        Object obj = map.get(key.getString());
        if (obj instanceof Float) {
            return (Float) obj;
        }
        return null;
    }

    private final Map<String, Object> cleanUpInternalAttributes(Map<String, Object> map) {
        Map<String, Object> mutableMap = MapsKt.toMutableMap(map);
        for (LocalAttribute.Key key : LocalAttribute.Key.values()) {
            mutableMap.remove(key.getString());
        }
        return mutableMap;
    }

    private final Map<String, Object> addDiagnosticsAttributes(Map<String, Object> map) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        map.put(DIAGNOSTICS_PROCESS_UPTIME, Long.valueOf(this.sdkCore.getAppUptimeNs() / 1000000));
        return map;
    }
}
