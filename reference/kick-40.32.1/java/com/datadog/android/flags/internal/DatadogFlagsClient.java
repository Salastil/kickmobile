package com.datadog.android.flags.internal;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.flags.EvaluationContextCallback;
import com.datadog.android.flags.FlagsClient;
import com.datadog.android.flags.FlagsConfiguration;
import com.datadog.android.flags.StateObservable;
import com.datadog.android.flags.internal.evaluation.EvaluationsManager;
import com.datadog.android.flags.internal.model.PrecomputedFlag;
import com.datadog.android.flags.internal.repository.FlagsRepository;
import com.datadog.android.flags.model.ErrorCode;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.flags.model.ResolutionDetails;
import com.datadog.android.flags.model.ResolutionReason;
import com.datadog.android.flags.model.UnparsedFlag;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: DatadogFlagsClient.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001YBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J/\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u001e\"\b\b\u0000\u0010\u001f*\u00020\u001a2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u0010\"J=\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u001f0$\"\b\b\u0000\u0010\u001f*\u00020\u001a2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u0002H\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010(J-\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u001f0$\"\b\b\u0000\u0010\u001f*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010*\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u0010+J\u0019\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020-0\u0018H\u0000¢\u0006\u0002\b.J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0019H\u0002J-\u00105\u001a\b\u0012\u0004\u0012\u0002H\u001f06\"\b\b\u0000\u0010\u001f*\u00020\u001a2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u00107J-\u00108\u001a\b\u0012\u0004\u0012\u0002H\u001f0$\"\b\b\u0000\u0010\u001f*\u00020\u001a2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u0002H\u001fH\u0016¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u00020;2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020;H\u0016J\u0018\u0010<\u001a\u00020=2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020=H\u0016J\u0018\u0010>\u001a\u00020?2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020?H\u0016J\u0018\u0010@\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0019H\u0016J4\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00182\u0006\u0010 \u001a\u00020\u00192\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018H\u0016J\u0018\u0010A\u001a\u00020B2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020BH\u0016J%\u0010C\u001a\u0002H\u001f\"\b\b\u0000\u0010\u001f*\u00020\u001a2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002H\u001f06H\u0002¢\u0006\u0002\u0010EJ'\u0010F\u001a\u0002H\u001f\"\b\b\u0000\u0010\u001f*\u00020\u001a2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u0002H\u001fH\u0002¢\u0006\u0002\u0010GJ\u001a\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J \u0010M\u001a\u000200\"\b\b\u0000\u0010\u001f*\u00020\u001a2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001eH\u0002J%\u0010N\u001a\u0002002\u0006\u0010 \u001a\u00020\u00192\u0006\u0010O\u001a\u00020-2\u0006\u0010I\u001a\u00020JH\u0000¢\u0006\u0002\bPJ \u0010Q\u001a\u000200\"\b\b\u0000\u0010\u001f*\u00020\u001a2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002H\u001f0RH\u0002J \u0010Q\u001a\u0002002\u0006\u0010 \u001a\u00020\u00192\u0006\u0010O\u001a\u00020-2\u0006\u0010I\u001a\u00020JH\u0002J@\u0010S\u001a\u0002002\u0006\u0010 \u001a\u00020\u00192\u0006\u0010I\u001a\u00020J2\b\u0010T\u001a\u0004\u0018\u00010\u00192\b\u0010U\u001a\u0004\u0018\u00010\u00192\b\u0010%\u001a\u0004\u0018\u00010\u00192\b\u0010'\u001a\u0004\u0018\u00010\u0019H\u0002J \u0010V\u001a\u0002002\u0006\u0010W\u001a\u00020\u00192\u0006\u0010X\u001a\u00020-2\u0006\u0010I\u001a\u00020JH\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006Z"}, d2 = {"Lcom/datadog/android/flags/internal/DatadogFlagsClient;", "Lcom/datadog/android/flags/FlagsClient;", "featureSdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "evaluationsManager", "Lcom/datadog/android/flags/internal/evaluation/EvaluationsManager;", "flagsRepository", "Lcom/datadog/android/flags/internal/repository/FlagsRepository;", "flagsConfiguration", "Lcom/datadog/android/flags/FlagsConfiguration;", "rumEvaluationLogger", "Lcom/datadog/android/flags/internal/RumEvaluationLogger;", "exposureProcessor", "Lcom/datadog/android/flags/internal/EventsProcessor;", "evaluationsFeature", "Lcom/datadog/android/flags/internal/EvaluationsFeature;", "flagStateManager", "Lcom/datadog/android/flags/internal/FlagsStateManager;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/flags/internal/evaluation/EvaluationsManager;Lcom/datadog/android/flags/internal/repository/FlagsRepository;Lcom/datadog/android/flags/FlagsConfiguration;Lcom/datadog/android/flags/internal/RumEvaluationLogger;Lcom/datadog/android/flags/internal/EventsProcessor;Lcom/datadog/android/flags/internal/EvaluationsFeature;Lcom/datadog/android/flags/internal/FlagsStateManager;)V", "state", "Lcom/datadog/android/flags/StateObservable;", "getState", "()Lcom/datadog/android/flags/StateObservable;", "buildMetadata", "", "", "", "precomputedFlag", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "checkProviderReady", "Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution$Error;", ExifInterface.GPS_DIRECTION_TRUE, "flagKey", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution$Error;", "createErrorResolution", "Lcom/datadog/android/flags/model/ResolutionDetails;", "errorCode", "Lcom/datadog/android/flags/model/ErrorCode;", "errorMessage", "(Ljava/lang/String;Ljava/lang/Object;Lcom/datadog/android/flags/model/ErrorCode;Ljava/lang/String;)Lcom/datadog/android/flags/model/ResolutionDetails;", "createSuccessResolution", "value", "(Lcom/datadog/android/flags/internal/model/PrecomputedFlag;Ljava/lang/Object;)Lcom/datadog/android/flags/model/ResolutionDetails;", "getFlagAssignmentsSnapshot", "Lcom/datadog/android/flags/model/UnparsedFlag;", "getFlagAssignmentsSnapshot$dd_sdk_android_flags_release", "logEvaluation", "", "key", "parseReason", "Lcom/datadog/android/flags/model/ResolutionReason;", "reasonString", "readAndParseAssignment", "Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution;", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution;", "resolve", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/datadog/android/flags/model/ResolutionDetails;", "resolveBooleanValue", "", "resolveDoubleValue", "", "resolveIntValue", "", "resolveStringValue", "resolveStructureValue", "Lorg/json/JSONObject;", "resolveTracked", "resolution", "(Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution;)Ljava/lang/Object;", "resolveValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "setEvaluationContext", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "callback", "Lcom/datadog/android/flags/EvaluationContextCallback;", "trackErrorResolution", "trackFlagSnapshotEvaluation", "flag", "trackFlagSnapshotEvaluation$dd_sdk_android_flags_release", "trackResolution", "Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution$Success;", "writeEvaluationEvent", "variantKey", "allocationKey", "writeExposureEvent", "name", "data", "InternalResolution", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogFlagsClient implements FlagsClient {
    private final EvaluationsFeature evaluationsFeature;
    private final EvaluationsManager evaluationsManager;
    private final EventsProcessor exposureProcessor;
    private final FeatureSdkCore featureSdkCore;
    private final FlagsStateManager flagStateManager;
    private final FlagsConfiguration flagsConfiguration;
    private final FlagsRepository flagsRepository;
    private final RumEvaluationLogger rumEvaluationLogger;
    private final StateObservable state;

    public DatadogFlagsClient(FeatureSdkCore featureSdkCore, EvaluationsManager evaluationsManager, FlagsRepository flagsRepository, FlagsConfiguration flagsConfiguration, RumEvaluationLogger rumEvaluationLogger, EventsProcessor exposureProcessor, EvaluationsFeature evaluationsFeature, FlagsStateManager flagStateManager) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "featureSdkCore");
        Intrinsics.checkNotNullParameter(evaluationsManager, "evaluationsManager");
        Intrinsics.checkNotNullParameter(flagsRepository, "flagsRepository");
        Intrinsics.checkNotNullParameter(flagsConfiguration, "flagsConfiguration");
        Intrinsics.checkNotNullParameter(rumEvaluationLogger, "rumEvaluationLogger");
        Intrinsics.checkNotNullParameter(exposureProcessor, "exposureProcessor");
        Intrinsics.checkNotNullParameter(flagStateManager, "flagStateManager");
        this.featureSdkCore = featureSdkCore;
        this.evaluationsManager = evaluationsManager;
        this.flagsRepository = flagsRepository;
        this.flagsConfiguration = flagsConfiguration;
        this.rumEvaluationLogger = rumEvaluationLogger;
        this.exposureProcessor = exposureProcessor;
        this.evaluationsFeature = evaluationsFeature;
        this.flagStateManager = flagStateManager;
        this.state = flagStateManager;
    }

    @Override // com.datadog.android.flags.FlagsClient
    public StateObservable getState() {
        return this.state;
    }

    @Override // com.datadog.android.flags.FlagsClient
    public void setEvaluationContext(EvaluationContext context, EvaluationContextCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.evaluationsManager.updateEvaluationsForContext(context, callback);
    }

    @Override // com.datadog.android.flags.FlagsClient
    public boolean resolveBooleanValue(String flagKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        return ((Boolean) resolveValue(flagKey, Boolean.valueOf(defaultValue))).booleanValue();
    }

    @Override // com.datadog.android.flags.FlagsClient
    public String resolveStringValue(String flagKey, String defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (String) resolveValue(flagKey, defaultValue);
    }

    @Override // com.datadog.android.flags.FlagsClient
    public int resolveIntValue(String flagKey, int defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        return ((Number) resolveValue(flagKey, Integer.valueOf(defaultValue))).intValue();
    }

    @Override // com.datadog.android.flags.FlagsClient
    public double resolveDoubleValue(String flagKey, double defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        return ((Number) resolveValue(flagKey, Double.valueOf(defaultValue))).doubleValue();
    }

    @Override // com.datadog.android.flags.FlagsClient
    public JSONObject resolveStructureValue(String flagKey, JSONObject defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (JSONObject) resolveValue(flagKey, defaultValue);
    }

    @Override // com.datadog.android.flags.FlagsClient
    public Map<String, Object> resolveStructureValue(String flagKey, Map<String, ? extends Object> defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (Map) resolveValue(flagKey, defaultValue);
    }

    @Override // com.datadog.android.flags.FlagsClient
    public <T> ResolutionDetails<T> resolve(String flagKey, T defaultValue) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        InternalResolution<T> andParseAssignment = readAndParseAssignment(flagKey, defaultValue);
        if (andParseAssignment instanceof InternalResolution.Success) {
            InternalResolution.Success<T> success = (InternalResolution.Success) andParseAssignment;
            trackResolution(success);
            return createSuccessResolution(success.getFlag(), success.getValue());
        }
        if (!(andParseAssignment instanceof InternalResolution.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        InternalResolution.Error<T> error = (InternalResolution.Error) andParseAssignment;
        trackErrorResolution(error);
        return createErrorResolution(flagKey, error.getDefaultValue(), error.getErrorCode(), error.getErrorMessage());
    }

    private final <T> T resolveValue(String flagKey, T defaultValue) {
        return (T) resolveTracked(readAndParseAssignment(flagKey, defaultValue));
    }

    private final void writeExposureEvent(String name, UnparsedFlag data, EvaluationContext context) {
        this.exposureProcessor.processEvent(name, context, data);
    }

    private final void writeEvaluationEvent(String flagKey, EvaluationContext context, String variantKey, String allocationKey, String errorCode, String errorMessage) {
        EvaluationsFeature evaluationsFeature = this.evaluationsFeature;
        if (evaluationsFeature != null) {
            evaluationsFeature.processEvaluation$dd_sdk_android_flags_release(flagKey, context, variantKey, allocationKey, errorCode, errorMessage);
        }
    }

    private final void logEvaluation(String key, Object value) {
        this.rumEvaluationLogger.logEvaluation(key, value);
    }

    /* JADX INFO: compiled from: DatadogFlagsClient.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "flagKey", "", "getFlagKey", "()Ljava/lang/String;", "Error", "Success", "Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution$Error;", "Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution$Success;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static abstract class InternalResolution<T> {
        public /* synthetic */ InternalResolution(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract String getFlagKey();

        private InternalResolution() {
        }

        /* JADX INFO: compiled from: DatadogFlagsClient.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u0016\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J<\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution$Success;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution;", "flagKey", "", "value", "flag", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/datadog/android/flags/internal/model/PrecomputedFlag;Lcom/datadog/android/flags/model/EvaluationContext;)V", "getContext", "()Lcom/datadog/android/flags/model/EvaluationContext;", "getFlag", "()Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "getFlagKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Object;Lcom/datadog/android/flags/internal/model/PrecomputedFlag;Lcom/datadog/android/flags/model/EvaluationContext;)Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution$Success;", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Success<T> extends InternalResolution<T> {
            private final EvaluationContext context;
            private final PrecomputedFlag flag;
            private final String flagKey;
            private final T value;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Success copy$default(Success success, String str, Object obj, PrecomputedFlag precomputedFlag, EvaluationContext evaluationContext, int i, Object obj2) {
                if ((i & 1) != 0) {
                    str = success.flagKey;
                }
                if ((i & 2) != 0) {
                    obj = success.value;
                }
                if ((i & 4) != 0) {
                    precomputedFlag = success.flag;
                }
                if ((i & 8) != 0) {
                    evaluationContext = success.context;
                }
                return success.copy(str, obj, precomputedFlag, evaluationContext);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getFlagKey() {
                return this.flagKey;
            }

            public final T component2() {
                return this.value;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final PrecomputedFlag getFlag() {
                return this.flag;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final EvaluationContext getContext() {
                return this.context;
            }

            public final Success<T> copy(String flagKey, T value, PrecomputedFlag flag, EvaluationContext context) {
                Intrinsics.checkNotNullParameter(flagKey, "flagKey");
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(flag, "flag");
                Intrinsics.checkNotNullParameter(context, "context");
                return new Success<>(flagKey, value, flag, context);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.flagKey, success.flagKey) && Intrinsics.areEqual(this.value, success.value) && Intrinsics.areEqual(this.flag, success.flag) && Intrinsics.areEqual(this.context, success.context);
            }

            public int hashCode() {
                return (((((this.flagKey.hashCode() * 31) + this.value.hashCode()) * 31) + this.flag.hashCode()) * 31) + this.context.hashCode();
            }

            public String toString() {
                return "Success(flagKey=" + this.flagKey + ", value=" + this.value + ", flag=" + this.flag + ", context=" + this.context + ")";
            }

            @Override // com.datadog.android.flags.internal.DatadogFlagsClient.InternalResolution
            public String getFlagKey() {
                return this.flagKey;
            }

            public final T getValue() {
                return this.value;
            }

            public final PrecomputedFlag getFlag() {
                return this.flag;
            }

            public final EvaluationContext getContext() {
                return this.context;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(String flagKey, T value, PrecomputedFlag flag, EvaluationContext context) {
                super(null);
                Intrinsics.checkNotNullParameter(flagKey, "flagKey");
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(flag, "flag");
                Intrinsics.checkNotNullParameter(context, "context");
                this.flagKey = flagKey;
                this.value = value;
                this.flag = flag;
                this.context = context;
            }
        }

        /* JADX INFO: compiled from: DatadogFlagsClient.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u0014\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J<\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution$Error;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution;", "flagKey", "", "defaultValue", "errorCode", "Lcom/datadog/android/flags/model/ErrorCode;", "errorMessage", "(Ljava/lang/String;Ljava/lang/Object;Lcom/datadog/android/flags/model/ErrorCode;Ljava/lang/String;)V", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getErrorCode", "()Lcom/datadog/android/flags/model/ErrorCode;", "getErrorMessage", "()Ljava/lang/String;", "getFlagKey", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Object;Lcom/datadog/android/flags/model/ErrorCode;Ljava/lang/String;)Lcom/datadog/android/flags/internal/DatadogFlagsClient$InternalResolution$Error;", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Error<T> extends InternalResolution<T> {
            private final T defaultValue;
            private final ErrorCode errorCode;
            private final String errorMessage;
            private final String flagKey;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Error copy$default(Error error, String str, Object obj, ErrorCode errorCode, String str2, int i, Object obj2) {
                if ((i & 1) != 0) {
                    str = error.flagKey;
                }
                if ((i & 2) != 0) {
                    obj = error.defaultValue;
                }
                if ((i & 4) != 0) {
                    errorCode = error.errorCode;
                }
                if ((i & 8) != 0) {
                    str2 = error.errorMessage;
                }
                return error.copy(str, obj, errorCode, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getFlagKey() {
                return this.flagKey;
            }

            public final T component2() {
                return this.defaultValue;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final ErrorCode getErrorCode() {
                return this.errorCode;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public final Error<T> copy(String flagKey, T defaultValue, ErrorCode errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(flagKey, "flagKey");
                Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                return new Error<>(flagKey, defaultValue, errorCode, errorMessage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.flagKey, error.flagKey) && Intrinsics.areEqual(this.defaultValue, error.defaultValue) && this.errorCode == error.errorCode && Intrinsics.areEqual(this.errorMessage, error.errorMessage);
            }

            public int hashCode() {
                return (((((this.flagKey.hashCode() * 31) + this.defaultValue.hashCode()) * 31) + this.errorCode.hashCode()) * 31) + this.errorMessage.hashCode();
            }

            public String toString() {
                return "Error(flagKey=" + this.flagKey + ", defaultValue=" + this.defaultValue + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
            }

            @Override // com.datadog.android.flags.internal.DatadogFlagsClient.InternalResolution
            public String getFlagKey() {
                return this.flagKey;
            }

            public final T getDefaultValue() {
                return this.defaultValue;
            }

            public final ErrorCode getErrorCode() {
                return this.errorCode;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String flagKey, T defaultValue, ErrorCode errorCode, String errorMessage) {
                super(null);
                Intrinsics.checkNotNullParameter(flagKey, "flagKey");
                Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                this.flagKey = flagKey;
                this.defaultValue = defaultValue;
                this.errorCode = errorCode;
                this.errorMessage = errorMessage;
            }
        }
    }

    private final <T> InternalResolution.Error<T> checkProviderReady(String flagKey, T defaultValue) {
        if (this.flagsRepository.getEvaluationContext() == null) {
            return new InternalResolution.Error<>(flagKey, defaultValue, ErrorCode.PROVIDER_NOT_READY, "Provider not ready - call setEvaluationContext() before resolving flags");
        }
        return null;
    }

    private final <T> InternalResolution<T> readAndParseAssignment(final String flagKey, T defaultValue) {
        ErrorCode errorCode;
        String message;
        InternalResolution.Error<T> errorCheckProviderReady = checkProviderReady(flagKey, defaultValue);
        if (errorCheckProviderReady != null) {
            return errorCheckProviderReady;
        }
        Pair<PrecomputedFlag, EvaluationContext> precomputedFlagWithContext = this.flagsRepository.getPrecomputedFlagWithContext(flagKey);
        if (precomputedFlagWithContext == null) {
            return new InternalResolution.Error(flagKey, defaultValue, ErrorCode.FLAG_NOT_FOUND, "Flag not found");
        }
        PrecomputedFlag precomputedFlagComponent1 = precomputedFlagWithContext.component1();
        EvaluationContext evaluationContextComponent2 = precomputedFlagWithContext.component2();
        Object objM11150convert0E7RQCE = FlagValueConverter.INSTANCE.m11150convert0E7RQCE(precomputedFlagComponent1.getVariationValue(), precomputedFlagComponent1.getVariationType(), Reflection.getOrCreateKotlinClass(defaultValue.getClass()));
        final Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM11150convert0E7RQCE);
        if (thM12687exceptionOrNullimpl == null) {
            return new InternalResolution.Success(flagKey, objM11150convert0E7RQCE, precomputedFlagComponent1, evaluationContextComponent2);
        }
        if (thM12687exceptionOrNullimpl instanceof TypeMismatchException) {
            errorCode = ErrorCode.TYPE_MISMATCH;
            message = thM12687exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "Type mismatch";
            }
        } else {
            ErrorCode errorCode2 = ErrorCode.PARSE_ERROR;
            String typeName = FlagValueConverter.INSTANCE.getTypeName(Reflection.getOrCreateKotlinClass(defaultValue.getClass()));
            final String str = "Failed to parse value '" + precomputedFlagComponent1.getVariationValue() + "' as " + typeName;
            InternalLogger.DefaultImpls.log$default(this.featureSdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.DatadogFlagsClient$readAndParseAssignment$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Flag '" + flagKey + "': " + str + " - " + thM12687exceptionOrNullimpl.getMessage();
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            errorCode = errorCode2;
            message = str;
        }
        return new InternalResolution.Error(flagKey, defaultValue, errorCode, message);
    }

    private final <T> T resolveTracked(final InternalResolution<T> resolution) {
        if (resolution instanceof InternalResolution.Success) {
            InternalResolution.Success<T> success = (InternalResolution.Success) resolution;
            trackResolution(success);
            return success.getValue();
        }
        if (!(resolution instanceof InternalResolution.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        InternalResolution.Error<T> error = (InternalResolution.Error) resolution;
        if (error.getErrorCode() == ErrorCode.TYPE_MISMATCH) {
            InternalLogger.DefaultImpls.log$default(this.featureSdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.DatadogFlagsClient.resolveTracked.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Flag '" + resolution.getFlagKey() + "': " + ((InternalResolution.Error) resolution).getErrorMessage();
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        trackErrorResolution(error);
        return error.getDefaultValue();
    }

    private final <T> ResolutionDetails<T> createSuccessResolution(PrecomputedFlag precomputedFlag, T value) {
        String variationKey = precomputedFlag.getVariationKey();
        if (StringsKt.isBlank(variationKey)) {
            variationKey = null;
        }
        return new ResolutionDetails<>(value, variationKey, parseReason(precomputedFlag.getReason()), null, null, buildMetadata(precomputedFlag));
    }

    private final Map<String, Object> buildMetadata(PrecomputedFlag precomputedFlag) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = precomputedFlag.getExtraLogging().keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "precomputedFlag.extraLogging.keys()");
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Object value = precomputedFlag.getExtraLogging().opt(key);
            if (value instanceof String ? true : value instanceof Number ? true : value instanceof Boolean) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                linkedHashMap.put(key, value);
            }
        }
        if (!StringsKt.isBlank(precomputedFlag.getAllocationKey())) {
            linkedHashMap.put("allocationKey", precomputedFlag.getAllocationKey());
        }
        return linkedHashMap;
    }

    private final <T> ResolutionDetails<T> createErrorResolution(String flagKey, T defaultValue, ErrorCode errorCode, String errorMessage) {
        return new ResolutionDetails<>(defaultValue, null, ResolutionReason.ERROR, errorCode, "Flag '" + flagKey + "': " + errorMessage, null, 32, null);
    }

    private final ResolutionReason parseReason(final String reasonString) {
        if (StringsKt.isBlank(reasonString)) {
            return null;
        }
        try {
            return ResolutionReason.valueOf(reasonString);
        } catch (IllegalArgumentException e) {
            InternalLogger.DefaultImpls.log$default(this.featureSdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.TELEMETRY, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.DatadogFlagsClient.parseReason.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unknown resolution reason: " + reasonString + " - " + e.getMessage();
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
    }

    private final <T> void trackResolution(InternalResolution.Success<T> resolution) {
        trackResolution(resolution.getFlagKey(), resolution.getFlag(), resolution.getContext());
    }

    private final void trackResolution(String flagKey, UnparsedFlag flag, EvaluationContext context) {
        if (flag.getDoLog() && this.flagsConfiguration.getTrackExposures$dd_sdk_android_flags_release()) {
            writeExposureEvent(flagKey, flag, context);
        }
        if (this.flagsConfiguration.getRumIntegrationEnabled$dd_sdk_android_flags_release() && !StringsKt.isBlank(flag.getVariationKey())) {
            logEvaluation(flagKey, flag.getVariationKey());
        }
        if (this.flagsConfiguration.getTrackEvaluations$dd_sdk_android_flags_release()) {
            writeEvaluationEvent(flagKey, context, flag.getVariationKey(), flag.getAllocationKey(), null, null);
        }
    }

    private final <T> void trackErrorResolution(InternalResolution.Error<T> resolution) {
        if (this.flagsConfiguration.getTrackEvaluations$dd_sdk_android_flags_release()) {
            EvaluationContext evaluationContext = this.flagsRepository.getEvaluationContext();
            if (evaluationContext == null) {
                evaluationContext = EvaluationContext.INSTANCE.getEMPTY();
            }
            writeEvaluationEvent(resolution.getFlagKey(), evaluationContext, null, null, resolution.getErrorCode().name(), resolution.getErrorMessage());
        }
    }

    public final Map<String, UnparsedFlag> getFlagAssignmentsSnapshot$dd_sdk_android_flags_release() {
        return this.flagsRepository.getFlagsSnapshot();
    }

    public final void trackFlagSnapshotEvaluation$dd_sdk_android_flags_release(String flagKey, UnparsedFlag flag, EvaluationContext context) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(flag, "flag");
        Intrinsics.checkNotNullParameter(context, "context");
        trackResolution(flagKey, flag, context);
    }
}
