package com.datadog.android.flags.internal.repository;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import com.datadog.android.api.storage.datastore.DataStoreWriteCallback;
import com.datadog.android.flags.internal.model.FlagsStateEntry;
import com.datadog.android.flags.internal.model.PrecomputedFlag;
import com.datadog.android.flags.internal.persistence.FlagsPersistenceManager;
import com.datadog.android.flags.model.EvaluationContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultFlagsRepository.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 &2\u00020\u0001:\u0002&'B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u001e\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010%\u001a\u00020\"H\u0002R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/datadog/android/flags/internal/repository/DefaultFlagsRepository;", "Lcom/datadog/android/flags/internal/repository/FlagsRepository;", "featureSdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "instanceName", "", "dataStore", "Lcom/datadog/android/api/storage/datastore/DataStoreHandler;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "persistenceLoadTimeoutMs", "", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Ljava/lang/String;Lcom/datadog/android/api/storage/datastore/DataStoreHandler;Lcom/datadog/android/api/InternalLogger;J)V", "atomicState", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/datadog/android/flags/internal/repository/DefaultFlagsRepository$FlagsState;", "persistenceLoadedLatch", "Ljava/util/concurrent/CountDownLatch;", "getPersistenceLoadedLatch$annotations", "()V", "persistenceManager", "Lcom/datadog/android/flags/internal/persistence/FlagsPersistenceManager;", "getEvaluationContext", "Lcom/datadog/android/flags/model/EvaluationContext;", "getFlagsSnapshot", "", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "getPrecomputedFlag", "key", "getPrecomputedFlagWithContext", "Lkotlin/Pair;", "hasFlags", "", "setFlagsAndContext", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "flags", "waitForPersistenceLoad", "Companion", "FlagsState", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultFlagsRepository implements FlagsRepository {
    public static final String ERROR_SAVING_FLAGS_STATE = "Failed to save flags state to persistent storage";
    private static final long PERSISTENCE_LOAD_TIMEOUT_MS = 100;
    public static final String WARN_CONTEXT_NOT_SET = "You must call FlagsClientManager.get().setEvaluationContext in order to have flags available";
    private final AtomicReference<FlagsState> atomicState;
    private final DataStoreHandler dataStore;
    private final FeatureSdkCore featureSdkCore;
    private final String instanceName;
    private final InternalLogger internalLogger;
    private final long persistenceLoadTimeoutMs;
    private final CountDownLatch persistenceLoadedLatch;
    private final FlagsPersistenceManager persistenceManager;

    private static /* synthetic */ void getPersistenceLoadedLatch$annotations() {
    }

    public DefaultFlagsRepository(FeatureSdkCore featureSdkCore, String instanceName, DataStoreHandler dataStore, InternalLogger internalLogger, long j) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "featureSdkCore");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.featureSdkCore = featureSdkCore;
        this.instanceName = instanceName;
        this.dataStore = dataStore;
        this.internalLogger = internalLogger;
        this.persistenceLoadTimeoutMs = j;
        this.atomicState = new AtomicReference<>(null);
        this.persistenceLoadedLatch = new CountDownLatch(1);
        this.persistenceManager = new FlagsPersistenceManager(dataStore, instanceName, internalLogger, new Function1<FlagsStateEntry, Unit>() { // from class: com.datadog.android.flags.internal.repository.DefaultFlagsRepository$persistenceManager$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FlagsStateEntry flagsStateEntry) {
                invoke2(flagsStateEntry);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FlagsStateEntry flagsStateEntry) {
                if (flagsStateEntry != null) {
                    try {
                        DefaultFlagsRepository defaultFlagsRepository = this.this$0;
                        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(defaultFlagsRepository.atomicState, null, new DefaultFlagsRepository.FlagsState(flagsStateEntry.getEvaluationContext(), flagsStateEntry.getFlags()));
                    } finally {
                        this.this$0.persistenceLoadedLatch.countDown();
                    }
                }
            }
        });
    }

    public /* synthetic */ DefaultFlagsRepository(FeatureSdkCore featureSdkCore, String str, DataStoreHandler dataStoreHandler, InternalLogger internalLogger, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, str, dataStoreHandler, (i & 8) != 0 ? featureSdkCore.getInternalLogger() : internalLogger, (i & 16) != 0 ? 100L : j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DefaultFlagsRepository.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/flags/internal/repository/DefaultFlagsRepository$FlagsState;", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/flags/model/EvaluationContext;", "flags", "", "", "Lcom/datadog/android/flags/internal/model/PrecomputedFlag;", "(Lcom/datadog/android/flags/model/EvaluationContext;Ljava/util/Map;)V", "getContext", "()Lcom/datadog/android/flags/model/EvaluationContext;", "getFlags", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final /* data */ class FlagsState {
        private final EvaluationContext context;
        private final Map<String, PrecomputedFlag> flags;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FlagsState copy$default(FlagsState flagsState, EvaluationContext evaluationContext, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                evaluationContext = flagsState.context;
            }
            if ((i & 2) != 0) {
                map = flagsState.flags;
            }
            return flagsState.copy(evaluationContext, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final EvaluationContext getContext() {
            return this.context;
        }

        public final Map<String, PrecomputedFlag> component2() {
            return this.flags;
        }

        public final FlagsState copy(EvaluationContext context, Map<String, PrecomputedFlag> flags) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(flags, "flags");
            return new FlagsState(context, flags);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FlagsState)) {
                return false;
            }
            FlagsState flagsState = (FlagsState) other;
            return Intrinsics.areEqual(this.context, flagsState.context) && Intrinsics.areEqual(this.flags, flagsState.flags);
        }

        public int hashCode() {
            return (this.context.hashCode() * 31) + this.flags.hashCode();
        }

        public String toString() {
            return "FlagsState(context=" + this.context + ", flags=" + this.flags + ")";
        }

        public FlagsState(EvaluationContext context, Map<String, PrecomputedFlag> flags) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(flags, "flags");
            this.context = context;
            this.flags = flags;
        }

        public final EvaluationContext getContext() {
            return this.context;
        }

        public final Map<String, PrecomputedFlag> getFlags() {
            return this.flags;
        }
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public void setFlagsAndContext(EvaluationContext context, Map<String, PrecomputedFlag> flags) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(flags, "flags");
        this.atomicState.set(new FlagsState(context, flags));
        this.persistenceLoadedLatch.countDown();
        this.persistenceManager.saveFlagsState$dd_sdk_android_flags_release(context, flags, this.featureSdkCore.getTimeProvider().getDeviceTimestampMillis(), new DataStoreWriteCallback() { // from class: com.datadog.android.flags.internal.repository.DefaultFlagsRepository.setFlagsAndContext.1
            @Override // com.datadog.android.api.storage.datastore.DataStoreWriteCallback
            public void onSuccess() {
            }

            @Override // com.datadog.android.api.storage.datastore.DataStoreWriteCallback
            public void onFailure() {
                InternalLogger.DefaultImpls.log$default(DefaultFlagsRepository.this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.repository.DefaultFlagsRepository$setFlagsAndContext$1$onFailure$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return DefaultFlagsRepository.ERROR_SAVING_FLAGS_STATE;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        });
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public PrecomputedFlag getPrecomputedFlag(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        waitForPersistenceLoad();
        FlagsState flagsState = this.atomicState.get();
        if (flagsState != null) {
            return flagsState.getFlags().get(key);
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.repository.DefaultFlagsRepository.getPrecomputedFlag.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return DefaultFlagsRepository.WARN_CONTEXT_NOT_SET;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public Map<String, PrecomputedFlag> getFlagsSnapshot() {
        waitForPersistenceLoad();
        FlagsState flagsState = this.atomicState.get();
        if (flagsState != null) {
            return flagsState.getFlags();
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.flags.internal.repository.DefaultFlagsRepository.getFlagsSnapshot.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return DefaultFlagsRepository.WARN_CONTEXT_NOT_SET;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return MapsKt.emptyMap();
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public EvaluationContext getEvaluationContext() {
        waitForPersistenceLoad();
        FlagsState flagsState = this.atomicState.get();
        if (flagsState != null) {
            return flagsState.getContext();
        }
        return null;
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public boolean hasFlags() {
        Map<String, PrecomputedFlag> flags;
        waitForPersistenceLoad();
        FlagsState flagsState = this.atomicState.get();
        if (flagsState == null || (flags = flagsState.getFlags()) == null) {
            return false;
        }
        return !flags.isEmpty();
    }

    @Override // com.datadog.android.flags.internal.repository.FlagsRepository
    public Pair<PrecomputedFlag, EvaluationContext> getPrecomputedFlagWithContext(String key) {
        PrecomputedFlag precomputedFlag;
        Intrinsics.checkNotNullParameter(key, "key");
        waitForPersistenceLoad();
        FlagsState flagsState = this.atomicState.get();
        if (flagsState == null || (precomputedFlag = flagsState.getFlags().get(key)) == null) {
            return null;
        }
        return TuplesKt.to(precomputedFlag, flagsState.getContext());
    }

    private final void waitForPersistenceLoad() {
        try {
            this.persistenceLoadedLatch.await(this.persistenceLoadTimeoutMs, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
