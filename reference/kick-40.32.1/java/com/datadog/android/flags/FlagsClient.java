package com.datadog.android.flags;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.Datadog;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import com.datadog.android.flags.internal.DatadogFlagsClient;
import com.datadog.android.flags.internal.DefaultRumEvaluationLogger;
import com.datadog.android.flags.internal.EvaluationsFeature;
import com.datadog.android.flags.internal.FlagsFeature;
import com.datadog.android.flags.internal.FlagsStateManager;
import com.datadog.android.flags.internal.NoOpFlagsClient;
import com.datadog.android.flags.internal.NoOpRumEvaluationLogger;
import com.datadog.android.flags.internal.RumEvaluationLogger;
import com.datadog.android.flags.internal.evaluation.EvaluationsManager;
import com.datadog.android.flags.internal.net.PrecomputedAssignmentsDownloader;
import com.datadog.android.flags.internal.repository.DefaultFlagsRepository;
import com.datadog.android.flags.internal.repository.FlagsRepository;
import com.datadog.android.flags.internal.repository.NoOpFlagsRepository;
import com.datadog.android.flags.internal.repository.net.PrecomputeMapper;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.flags.model.ResolutionDetails;
import com.datadog.android.internal.utils.DDCoreSubscription;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.hermes.intl.Constants;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: FlagsClient.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eJ-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u0002H\bH&¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J4\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015H&J\u0018\u0010\u0014\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0016H&J\u001c\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/flags/FlagsClient;", "", "state", "Lcom/datadog/android/flags/StateObservable;", "getState", "()Lcom/datadog/android/flags/StateObservable;", "resolve", "Lcom/datadog/android/flags/model/ResolutionDetails;", ExifInterface.GPS_DIRECTION_TRUE, "flagKey", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/datadog/android/flags/model/ResolutionDetails;", "resolveBooleanValue", "", "resolveDoubleValue", "", "resolveIntValue", "", "resolveStringValue", "resolveStructureValue", "", "Lorg/json/JSONObject;", "setEvaluationContext", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "callback", "Lcom/datadog/android/flags/EvaluationContextCallback;", "Builder", "Companion", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FlagsClient {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String FLAGS_NETWORK_EXECUTOR_NAME = "flags-network";

    @JvmStatic
    static FlagsClient get() {
        return INSTANCE.get();
    }

    @JvmStatic
    static FlagsClient get(String str) {
        return INSTANCE.get(str);
    }

    @JvmStatic
    static FlagsClient get(String str, SdkCore sdkCore) {
        return INSTANCE.get(str, sdkCore);
    }

    StateObservable getState();

    <T> ResolutionDetails<T> resolve(String flagKey, T defaultValue);

    boolean resolveBooleanValue(String flagKey, boolean defaultValue);

    double resolveDoubleValue(String flagKey, double defaultValue);

    int resolveIntValue(String flagKey, int defaultValue);

    String resolveStringValue(String flagKey, String defaultValue);

    Map<String, Object> resolveStructureValue(String flagKey, Map<String, ? extends Object> defaultValue);

    JSONObject resolveStructureValue(String flagKey, JSONObject defaultValue);

    void setEvaluationContext(EvaluationContext context, EvaluationContextCallback callback);

    /* JADX INFO: compiled from: FlagsClient.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void setEvaluationContext$default(FlagsClient flagsClient, EvaluationContext evaluationContext, EvaluationContextCallback evaluationContextCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEvaluationContext");
            }
            if ((i & 2) != 0) {
                evaluationContextCallback = null;
            }
            flagsClient.setEvaluationContext(evaluationContext, evaluationContextCallback);
        }
    }

    /* JADX INFO: compiled from: FlagsClient.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/datadog/android/flags/FlagsClient$Builder;", "", "name", "", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "(Ljava/lang/String;Lcom/datadog/android/api/SdkCore;)V", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "build", "Lcom/datadog/android/flags/FlagsClient;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final String name;
        private final FeatureSdkCore sdkCore;

        public Builder(String name, SdkCore sdkCore) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            String str = name;
            if (StringsKt.isBlank(str)) {
                FeatureScope feature = ((FeatureSdkCore) sdkCore).getFeature("flags");
                FlagsFeature flagsFeature = feature != null ? (FlagsFeature) feature.unwrap() : null;
                if (flagsFeature != null) {
                    flagsFeature.logErrorWithPolicy$dd_sdk_android_flags_release("FlagsClient name cannot be blank. Using default client name", InternalLogger.Level.ERROR, true);
                }
                str = Constants.COLLATION_DEFAULT;
            }
            this.name = str;
            this.sdkCore = (FeatureSdkCore) sdkCore;
        }

        public /* synthetic */ Builder(String str, SdkCore sdkCore, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Constants.COLLATION_DEFAULT : str, (i & 2) != 0 ? Datadog.getInstance$default(null, 1, null) : sdkCore);
        }

        public final FlagsClient build() {
            FeatureScope feature = this.sdkCore.getFeature("flags");
            final FlagsFeature flagsFeature = feature != null ? (FlagsFeature) feature.unwrap() : null;
            FeatureSdkCore featureSdkCore = this.sdkCore;
            if (flagsFeature == null) {
                final InternalLogger internalLogger = featureSdkCore.getInternalLogger();
                Function2<String, InternalLogger.Level, Unit> function2 = new Function2<String, InternalLogger.Level, Unit>() { // from class: com.datadog.android.flags.FlagsClient$Builder$build$logWithPolicy$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str, InternalLogger.Level level) {
                        invoke2(str, level);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final String message, InternalLogger.Level level) {
                        Intrinsics.checkNotNullParameter(message, "message");
                        Intrinsics.checkNotNullParameter(level, "level");
                        InternalLogger.DefaultImpls.log$default(internalLogger, level, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.FlagsClient$Builder$build$logWithPolicy$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return message;
                            }
                        }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    }
                };
                function2.invoke("Failed to create FlagsClient named '" + this.name + "': Flags feature must be enabled first. Call Flags.enable() before creating clients. Operating in no-op mode.", InternalLogger.Level.ERROR);
                return new NoOpFlagsClient(this.name, "Flags feature not enabled", function2);
            }
            FeatureScope feature2 = featureSdkCore.getFeature("flags-evaluations");
            final EvaluationsFeature evaluationsFeature = feature2 != null ? (EvaluationsFeature) feature2.unwrap() : null;
            return flagsFeature.getOrRegisterNewClient$dd_sdk_android_flags_release(this.name, new Function0<FlagsClient>() { // from class: com.datadog.android.flags.FlagsClient$Builder$build$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final FlagsClient invoke() {
                    return FlagsClient.INSTANCE.createInternal$dd_sdk_android_flags_release(flagsFeature.getFlagsConfiguration(), this.sdkCore, flagsFeature, evaluationsFeature, this.name);
                }
            });
        }
    }

    /* JADX INFO: compiled from: FlagsClient.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/datadog/android/flags/FlagsClient$Companion;", "", "()V", "DEFAULT_CLIENT_NAME", "", "FLAGS_NETWORK_EXECUTOR_NAME", "createInternal", "Lcom/datadog/android/flags/FlagsClient;", "configuration", "Lcom/datadog/android/flags/FlagsConfiguration;", "featureSdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "flagsFeature", "Lcom/datadog/android/flags/internal/FlagsFeature;", "evaluationsFeature", "Lcom/datadog/android/flags/internal/EvaluationsFeature;", "name", "createInternal$dd_sdk_android_flags_release", "createRumEvaluationLogger", "Lcom/datadog/android/flags/internal/RumEvaluationLogger;", "get", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "handleClientNotFound", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String DEFAULT_CLIENT_NAME = "default";
        public static final String FLAGS_NETWORK_EXECUTOR_NAME = "flags-network";

        @JvmStatic
        public final FlagsClient get() {
            return get$default(this, null, null, 3, null);
        }

        @JvmStatic
        public final FlagsClient get(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return get$default(this, name, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ FlagsClient get$default(Companion companion, String str, SdkCore sdkCore, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "default";
            }
            if ((i & 2) != 0) {
                sdkCore = Datadog.getInstance$default(null, 1, null);
            }
            return companion.get(str, sdkCore);
        }

        @JvmStatic
        public final FlagsClient get(String name, SdkCore sdkCore) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
            final InternalLogger internalLogger = featureSdkCore.getInternalLogger();
            FeatureScope feature = featureSdkCore.getFeature("flags");
            FlagsFeature flagsFeature = feature != null ? (FlagsFeature) feature.unwrap() : null;
            if (flagsFeature == null) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.FlagsClient$Companion$get$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Flags feature is not enabled. Returning NoOpFlagsClient.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
                return new NoOpFlagsClient(name, "Flags feature not enabled", new Function2<String, InternalLogger.Level, Unit>() { // from class: com.datadog.android.flags.FlagsClient$Companion$get$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str, InternalLogger.Level level) {
                        invoke2(str, level);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final String message, InternalLogger.Level level) {
                        Intrinsics.checkNotNullParameter(message, "message");
                        Intrinsics.checkNotNullParameter(level, "level");
                        InternalLogger.DefaultImpls.log$default(internalLogger, level, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.FlagsClient$Companion$get$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return message;
                            }
                        }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    }
                });
            }
            FlagsClient client$dd_sdk_android_flags_release = flagsFeature.getClient$dd_sdk_android_flags_release(name);
            return client$dd_sdk_android_flags_release == null ? handleClientNotFound(name, flagsFeature, featureSdkCore) : client$dd_sdk_android_flags_release;
        }

        private final FlagsClient handleClientNotFound(String name, final FlagsFeature flagsFeature, FeatureSdkCore sdkCore) {
            String str;
            if (Intrinsics.areEqual(name, "default")) {
                str = "FlagsClient.Builder().build()";
            } else {
                str = "FlagsClient.Builder(\"" + name + "\").build()";
            }
            flagsFeature.logErrorWithPolicy$dd_sdk_android_flags_release("No FlagsClient with name '" + name + "' exists for SDK instance '" + sdkCore.getName() + "'. Create a client first using: " + str + ". Operating in no-op mode.", InternalLogger.Level.ERROR, true);
            return new NoOpFlagsClient(name, "Client '" + name + "' not found - get() called before build()", new Function2<String, InternalLogger.Level, Unit>() { // from class: com.datadog.android.flags.FlagsClient$Companion$handleClientNotFound$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str2, InternalLogger.Level level) {
                    invoke2(str2, level);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String message, InternalLogger.Level level) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Intrinsics.checkNotNullParameter(level, "level");
                    flagsFeature.logErrorWithPolicy$dd_sdk_android_flags_release(message, level, false);
                }
            });
        }

        public final FlagsClient createInternal$dd_sdk_android_flags_release(FlagsConfiguration configuration, FeatureSdkCore featureSdkCore, FlagsFeature flagsFeature, EvaluationsFeature evaluationsFeature, String name) {
            NoOpFlagsRepository noOpFlagsRepository;
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(featureSdkCore, "featureSdkCore");
            Intrinsics.checkNotNullParameter(flagsFeature, "flagsFeature");
            Intrinsics.checkNotNullParameter(name, "name");
            ExecutorService executorServiceCreateSingleThreadExecutorService = featureSdkCore.createSingleThreadExecutorService("flags-network");
            FeatureScope feature = featureSdkCore.getFeature("flags");
            DataStoreHandler dataStore = feature != null ? feature.getDataStore() : null;
            if (dataStore != null) {
                noOpFlagsRepository = new DefaultFlagsRepository(featureSdkCore, name, dataStore, null, 0L, 24, null);
            } else {
                noOpFlagsRepository = new NoOpFlagsRepository();
            }
            FlagsRepository flagsRepository = noOpFlagsRepository;
            PrecomputedAssignmentsDownloader precomputedAssignmentsDownloader = new PrecomputedAssignmentsDownloader(FeatureSdkCore.DefaultImpls.createOkHttpCallFactory$default(featureSdkCore, null, 1, null), featureSdkCore.getInternalLogger(), flagsFeature.getPrecomputedRequestFactory());
            PrecomputeMapper precomputeMapper = new PrecomputeMapper(featureSdkCore.getInternalLogger());
            FlagsStateManager flagsStateManager = new FlagsStateManager(DDCoreSubscription.INSTANCE.create());
            return new DatadogFlagsClient(featureSdkCore, new EvaluationsManager(featureSdkCore, executorServiceCreateSingleThreadExecutorService, featureSdkCore.getInternalLogger(), flagsRepository, precomputedAssignmentsDownloader, precomputeMapper, flagsStateManager), flagsRepository, configuration, createRumEvaluationLogger(featureSdkCore), flagsFeature.getProcessor(), evaluationsFeature, flagsStateManager);
        }

        private final RumEvaluationLogger createRumEvaluationLogger(FeatureSdkCore featureSdkCore) {
            FeatureScope feature = featureSdkCore.getFeature("rum");
            if (feature != null) {
                return new DefaultRumEvaluationLogger(feature);
            }
            return new NoOpRumEvaluationLogger();
        }
    }
}
