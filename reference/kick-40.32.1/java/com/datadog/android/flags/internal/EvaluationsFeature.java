package com.datadog.android.flags.internal;

import android.content.Context;
import com.datadog.android.api.feature.FeatureContextUpdateReceiver;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.flags.FlagsConfiguration;
import com.datadog.android.flags.internal.aggregation.EvaluationAggregator;
import com.datadog.android.flags.internal.net.EvaluationsRequestFactory;
import com.datadog.android.flags.internal.storage.EvaluationEventRecordWriter;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationsFeature.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 22\u00020\u00012\u00020\u0002:\u000223B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00112\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020!H\u0016JE\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010#\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u00112\b\u0010.\u001a\u0004\u0018\u00010\u00112\b\u0010/\u001a\u0004\u0018\u00010\u00112\b\u00100\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b1R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00064"}, d2 = {"Lcom/datadog/android/flags/internal/EvaluationsFeature;", "Lcom/datadog/android/api/feature/StorageBackedFeature;", "Lcom/datadog/android/api/feature/FeatureContextUpdateReceiver;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "flagsConfiguration", "Lcom/datadog/android/flags/FlagsConfiguration;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/flags/FlagsConfiguration;)V", "evaluationProcessor", "Lcom/datadog/android/flags/internal/EvaluationEventsProcessor;", "getFlagsConfiguration$dd_sdk_android_flags_release", "()Lcom/datadog/android/flags/FlagsConfiguration;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_flags_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "name", "", "getName", "()Ljava/lang/String;", "requestFactory", "Lcom/datadog/android/api/net/RequestFactory;", "getRequestFactory", "()Lcom/datadog/android/api/net/RequestFactory;", "rumContext", "Lcom/datadog/android/flags/internal/EvaluationsFeature$RumContext;", "scheduledExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "storageConfiguration", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "getStorageConfiguration", "()Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "onContextUpdate", "", "featureName", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "", "", "onInitialize", "appContext", "Landroid/content/Context;", "onStop", "processEvaluation", "flagKey", "Lcom/datadog/android/flags/model/EvaluationContext;", "variantKey", "allocationKey", "errorCode", "errorMessage", "processEvaluation$dd_sdk_android_flags_release", "Companion", "RumContext", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationsFeature implements StorageBackedFeature, FeatureContextUpdateReceiver {
    public static final int DEFAULT_MAX_AGGREGATIONS = 1000;
    private static final String EXECUTOR_NAME = "flags-evaluation";
    private static final String RUM_APPLICATION_ID = "application_id";
    private static final String RUM_VIEW_NAME = "view_name";
    private volatile EvaluationEventsProcessor evaluationProcessor;
    private final FlagsConfiguration flagsConfiguration;
    private final AtomicBoolean initialized;
    private final String name;
    private final RequestFactory requestFactory;
    private volatile RumContext rumContext;
    private ScheduledExecutorService scheduledExecutor;
    private final FeatureSdkCore sdkCore;
    private final FeatureStorageConfiguration storageConfiguration;

    public EvaluationsFeature(FeatureSdkCore sdkCore, FlagsConfiguration flagsConfiguration) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(flagsConfiguration, "flagsConfiguration");
        this.sdkCore = sdkCore;
        this.flagsConfiguration = flagsConfiguration;
        this.initialized = new AtomicBoolean(false);
        this.name = "flags-evaluations";
        this.storageConfiguration = FeatureStorageConfiguration.INSTANCE.getDEFAULT();
        this.requestFactory = new EvaluationsRequestFactory(sdkCore.getInternalLogger(), flagsConfiguration.getCustomEvaluationEndpoint$dd_sdk_android_flags_release());
    }

    /* JADX INFO: renamed from: getFlagsConfiguration$dd_sdk_android_flags_release, reason: from getter */
    public final FlagsConfiguration getFlagsConfiguration() {
        return this.flagsConfiguration;
    }

    /* JADX INFO: compiled from: EvaluationsFeature.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/flags/internal/EvaluationsFeature$RumContext;", "", "rumApplicationId", "", "rumViewName", "(Ljava/lang/String;Ljava/lang/String;)V", "getRumApplicationId", "()Ljava/lang/String;", "getRumViewName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class RumContext {
        private final String rumApplicationId;
        private final String rumViewName;

        public static /* synthetic */ RumContext copy$default(RumContext rumContext, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rumContext.rumApplicationId;
            }
            if ((i & 2) != 0) {
                str2 = rumContext.rumViewName;
            }
            return rumContext.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRumApplicationId() {
            return this.rumApplicationId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRumViewName() {
            return this.rumViewName;
        }

        public final RumContext copy(String rumApplicationId, String rumViewName) {
            return new RumContext(rumApplicationId, rumViewName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RumContext)) {
                return false;
            }
            RumContext rumContext = (RumContext) other;
            return Intrinsics.areEqual(this.rumApplicationId, rumContext.rumApplicationId) && Intrinsics.areEqual(this.rumViewName, rumContext.rumViewName);
        }

        public int hashCode() {
            String str = this.rumApplicationId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.rumViewName;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "RumContext(rumApplicationId=" + this.rumApplicationId + ", rumViewName=" + this.rumViewName + ")";
        }

        public RumContext(String str, String str2) {
            this.rumApplicationId = str;
            this.rumViewName = str2;
        }

        public final String getRumApplicationId() {
            return this.rumApplicationId;
        }

        public final String getRumViewName() {
            return this.rumViewName;
        }
    }

    /* JADX INFO: renamed from: getInitialized$dd_sdk_android_flags_release, reason: from getter */
    public final AtomicBoolean getInitialized() {
        return this.initialized;
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        if (this.initialized.get()) {
            return;
        }
        this.sdkCore.setContextUpdateReceiver(this);
        ScheduledExecutorService scheduledExecutorServiceCreateScheduledExecutorService = this.sdkCore.createScheduledExecutorService(EXECUTOR_NAME);
        this.scheduledExecutor = scheduledExecutorServiceCreateScheduledExecutorService;
        this.evaluationProcessor = new EvaluationEventsProcessor(new EvaluationEventRecordWriter(this.sdkCore), this.sdkCore.getTimeProvider(), scheduledExecutorServiceCreateScheduledExecutorService, this.sdkCore.getInternalLogger(), this.flagsConfiguration.getEvaluationFlushIntervalMs$dd_sdk_android_flags_release(), new EvaluationAggregator(1000), false, 64, null);
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.sdkCore.removeContextUpdateReceiver(this);
        EvaluationEventsProcessor evaluationEventsProcessor = this.evaluationProcessor;
        if (evaluationEventsProcessor != null) {
            evaluationEventsProcessor.stop();
        }
        this.evaluationProcessor = null;
        ScheduledExecutorService scheduledExecutorService = this.scheduledExecutor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
        this.scheduledExecutor = null;
        this.rumContext = null;
        this.initialized.set(false);
    }

    @Override // com.datadog.android.api.feature.FeatureContextUpdateReceiver
    public void onContextUpdate(String featureName, Map<String, ? extends Object> context) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(featureName, "rum")) {
            Object obj = context.get("application_id");
            String str = obj instanceof String ? (String) obj : null;
            Object obj2 = context.get("view_name");
            this.rumContext = new RumContext(str, obj2 instanceof String ? (String) obj2 : null);
        }
    }

    public final void processEvaluation$dd_sdk_android_flags_release(String flagKey, EvaluationContext context, String variantKey, String allocationKey, String errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(flagKey, "flagKey");
        Intrinsics.checkNotNullParameter(context, "context");
        EvaluationEventsProcessor evaluationEventsProcessor = this.evaluationProcessor;
        if (evaluationEventsProcessor == null) {
            return;
        }
        RumContext rumContext = this.rumContext;
        evaluationEventsProcessor.processEvaluation(flagKey, context, rumContext != null ? rumContext.getRumApplicationId() : null, rumContext != null ? rumContext.getRumViewName() : null, variantKey, allocationKey, errorCode, errorMessage);
    }
}
