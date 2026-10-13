package com.datadog.android.flags.internal.evaluation;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.flags.EvaluationContextCallback;
import com.datadog.android.flags.internal.FlagsStateManager;
import com.datadog.android.flags.internal.model.PrecomputedFlag;
import com.datadog.android.flags.internal.net.NetworkRequestFailedException;
import com.datadog.android.flags.internal.net.PrecomputedAssignmentsReader;
import com.datadog.android.flags.internal.repository.FlagsRepository;
import com.datadog.android.flags.internal.repository.net.PrecomputeMapper;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.flags.model.FlagsClientState;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: EvaluationsManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/flags/internal/evaluation/EvaluationsManager;", "", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "flagsRepository", "Lcom/datadog/android/flags/internal/repository/FlagsRepository;", "assignmentsReader", "Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsReader;", "precomputeMapper", "Lcom/datadog/android/flags/internal/repository/net/PrecomputeMapper;", "flagStateManager", "Lcom/datadog/android/flags/internal/FlagsStateManager;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/flags/internal/repository/FlagsRepository;Lcom/datadog/android/flags/internal/net/PrecomputedAssignmentsReader;Lcom/datadog/android/flags/internal/repository/net/PrecomputeMapper;Lcom/datadog/android/flags/internal/FlagsStateManager;)V", "updateEvaluationsForContext", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "callback", "Lcom/datadog/android/flags/EvaluationContextCallback;", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EvaluationsManager {
    private static final String FETCH_AND_STORE_OPERATION_NAME = "Fetch and store flags for evaluation context";
    private static final String NETWORK_REQUEST_FAILED_MESSAGE = "Unable to fetch feature flags. Please check your network connection.";
    private final PrecomputedAssignmentsReader assignmentsReader;
    private final ExecutorService executorService;
    private final FlagsStateManager flagStateManager;
    private final FlagsRepository flagsRepository;
    private final InternalLogger internalLogger;
    private final PrecomputeMapper precomputeMapper;
    private final FeatureSdkCore sdkCore;

    public EvaluationsManager(FeatureSdkCore sdkCore, ExecutorService executorService, InternalLogger internalLogger, FlagsRepository flagsRepository, PrecomputedAssignmentsReader assignmentsReader, PrecomputeMapper precomputeMapper, FlagsStateManager flagStateManager) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(flagsRepository, "flagsRepository");
        Intrinsics.checkNotNullParameter(assignmentsReader, "assignmentsReader");
        Intrinsics.checkNotNullParameter(precomputeMapper, "precomputeMapper");
        Intrinsics.checkNotNullParameter(flagStateManager, "flagStateManager");
        this.sdkCore = sdkCore;
        this.executorService = executorService;
        this.internalLogger = internalLogger;
        this.flagsRepository = flagsRepository;
        this.assignmentsReader = assignmentsReader;
        this.precomputeMapper = precomputeMapper;
        this.flagStateManager = flagStateManager;
    }

    public static /* synthetic */ void updateEvaluationsForContext$default(EvaluationsManager evaluationsManager, EvaluationContext evaluationContext, EvaluationContextCallback evaluationContextCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            evaluationContextCallback = null;
        }
        evaluationsManager.updateEvaluationsForContext(evaluationContext, evaluationContextCallback);
    }

    public final void updateEvaluationsForContext(EvaluationContext context, EvaluationContextCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.flagStateManager.updateState$dd_sdk_android_flags_release(FlagsClientState.Reconciling.INSTANCE);
        FeatureScope feature = this.sdkCore.getFeature("flags");
        if (feature != null) {
            feature.withContext(SetsKt.setOf("rum"), new AnonymousClass1(context, callback));
        }
    }

    /* JADX INFO: renamed from: com.datadog.android.flags.internal.evaluation.EvaluationsManager$updateEvaluationsForContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: EvaluationsManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<DatadogContext, Unit> {
        final /* synthetic */ EvaluationContextCallback $callback;
        final /* synthetic */ EvaluationContext $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EvaluationContext evaluationContext, EvaluationContextCallback evaluationContextCallback) {
            super(1);
            this.$context = evaluationContext;
            this.$callback = evaluationContextCallback;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DatadogContext datadogContext) {
            invoke2(datadogContext);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final DatadogContext datadogContext) {
            Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
            ExecutorService executorService = EvaluationsManager.this.executorService;
            InternalLogger internalLogger = EvaluationsManager.this.internalLogger;
            final EvaluationsManager evaluationsManager = EvaluationsManager.this;
            final EvaluationContext evaluationContext = this.$context;
            final EvaluationContextCallback evaluationContextCallback = this.$callback;
            ConcurrencyExtKt.executeSafe(executorService, EvaluationsManager.FETCH_AND_STORE_OPERATION_NAME, internalLogger, new Runnable() { // from class: com.datadog.android.flags.internal.evaluation.EvaluationsManager$updateEvaluationsForContext$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    EvaluationsManager.AnonymousClass1.invoke$lambda$0(evaluationsManager, evaluationContext, datadogContext, evaluationContextCallback);
                }
            });
        }

        static final void invoke$lambda$0(EvaluationsManager evaluationsManager, final EvaluationContext evaluationContext, DatadogContext datadogContext, EvaluationContextCallback evaluationContextCallback) {
            InternalLogger.DefaultImpls.log$default(evaluationsManager.internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.evaluation.EvaluationsManager$updateEvaluationsForContext$1$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Processing evaluation context: " + evaluationContext.getTargetingKey();
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            boolean zHasFlags = evaluationsManager.flagsRepository.hasFlags();
            String precomputedFlags = evaluationsManager.assignmentsReader.readPrecomputedFlags(evaluationContext, datadogContext);
            if (precomputedFlags != null) {
                final Map<String, PrecomputedFlag> mapMap$dd_sdk_android_flags_release = evaluationsManager.precomputeMapper.map$dd_sdk_android_flags_release(precomputedFlags);
                evaluationsManager.flagsRepository.setFlagsAndContext(evaluationContext, mapMap$dd_sdk_android_flags_release);
                InternalLogger.DefaultImpls.log$default(evaluationsManager.internalLogger, InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.evaluation.EvaluationsManager$updateEvaluationsForContext$1$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Successfully processed context " + evaluationContext.getTargetingKey() + " with " + mapMap$dd_sdk_android_flags_release.size() + " flags";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                evaluationsManager.flagStateManager.updateState$dd_sdk_android_flags_release(FlagsClientState.Ready.INSTANCE);
                if (evaluationContextCallback != null) {
                    evaluationContextCallback.onSuccess();
                    return;
                }
                return;
            }
            InternalLogger.DefaultImpls.log$default(evaluationsManager.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.evaluation.EvaluationsManager$updateEvaluationsForContext$1$1$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to fetch feature flags. Please check your network connection.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            NetworkRequestFailedException networkRequestFailedException = new NetworkRequestFailedException(EvaluationsManager.NETWORK_REQUEST_FAILED_MESSAGE);
            boolean zAreEqual = Intrinsics.areEqual(evaluationsManager.flagsRepository.getEvaluationContext(), evaluationContext);
            if (!zHasFlags || !zAreEqual) {
                evaluationsManager.flagStateManager.updateState$dd_sdk_android_flags_release(new FlagsClientState.Error(networkRequestFailedException));
            } else {
                evaluationsManager.flagStateManager.updateState$dd_sdk_android_flags_release(FlagsClientState.Stale.INSTANCE);
            }
            if (evaluationContextCallback != null) {
                evaluationContextCallback.onFailure(networkRequestFailedException);
            }
        }
    }
}
