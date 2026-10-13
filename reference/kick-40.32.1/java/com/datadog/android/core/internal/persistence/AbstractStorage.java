package com.datadog.android.core.internal.persistence;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.metrics.RemovalReason;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.core.persistence.NoOpPersistenceStrategy;
import com.datadog.android.core.persistence.PersistenceStrategy;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractStorage.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0017J\b\u0010+\u001a\u00020$H\u0017J,\u0010,\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020$0-\u0012\u0004\u0012\u00020$0-j\u0002`/2\u0006\u00100\u001a\u000201H\u0017J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0017J\u0010\u00108\u001a\u00020\u00122\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0019\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/datadog/android/core/internal/persistence/AbstractStorage;", "Lcom/datadog/android/core/internal/persistence/Storage;", "Lcom/datadog/android/privacy/TrackingConsentProviderCallback;", "sdkCoreId", "", "featureName", "persistenceStrategyFactory", "Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "storageConfiguration", "Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "consentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/api/storage/FeatureStorageConfiguration;Lcom/datadog/android/core/internal/privacy/ConsentProvider;)V", "grantedPersistenceStrategy", "Lcom/datadog/android/core/persistence/PersistenceStrategy;", "getGrantedPersistenceStrategy", "()Lcom/datadog/android/core/persistence/PersistenceStrategy;", "grantedPersistenceStrategy$delegate", "Lkotlin/Lazy;", "notGrantedPersistenceStrategy", "pendingPersistenceStrategy", "getPendingPersistenceStrategy", "pendingPersistenceStrategy$delegate", "getPersistenceStrategyFactory$dd_sdk_android_core_release", "()Lcom/datadog/android/core/persistence/PersistenceStrategy$Factory;", "getSdkCoreId$dd_sdk_android_core_release", "()Ljava/lang/String;", "getStorageConfiguration$dd_sdk_android_core_release", "()Lcom/datadog/android/api/storage/FeatureStorageConfiguration;", "writeLock", "", "confirmBatchRead", "", "batchId", "Lcom/datadog/android/core/internal/persistence/BatchId;", "removalReason", "Lcom/datadog/android/core/internal/metrics/RemovalReason;", "deleteBatch", "", "dropAll", "getEventWriteScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "onConsentUpdated", "previousConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "newConsent", "readNextBatch", "Lcom/datadog/android/core/internal/persistence/BatchData;", "resolvePersistenceStrategy", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AbstractStorage implements Storage, TrackingConsentProviderCallback {
    private final ExecutorService executorService;
    private final String featureName;

    /* JADX INFO: renamed from: grantedPersistenceStrategy$delegate, reason: from kotlin metadata */
    private final Lazy grantedPersistenceStrategy;
    private final InternalLogger internalLogger;
    private final PersistenceStrategy notGrantedPersistenceStrategy;

    /* JADX INFO: renamed from: pendingPersistenceStrategy$delegate, reason: from kotlin metadata */
    private final Lazy pendingPersistenceStrategy;
    private final PersistenceStrategy.Factory persistenceStrategyFactory;
    private final String sdkCoreId;
    private final FeatureStorageConfiguration storageConfiguration;
    private final Object writeLock;

    /* JADX INFO: compiled from: AbstractStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TrackingConsent.values().length];
            try {
                iArr[TrackingConsent.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrackingConsent.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TrackingConsent.NOT_GRANTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractStorage(String str, String featureName, PersistenceStrategy.Factory persistenceStrategyFactory, ExecutorService executorService, InternalLogger internalLogger, FeatureStorageConfiguration storageConfiguration, ConsentProvider consentProvider) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(persistenceStrategyFactory, "persistenceStrategyFactory");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(storageConfiguration, "storageConfiguration");
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        this.sdkCoreId = str;
        this.featureName = featureName;
        this.persistenceStrategyFactory = persistenceStrategyFactory;
        this.executorService = executorService;
        this.internalLogger = internalLogger;
        this.storageConfiguration = storageConfiguration;
        this.grantedPersistenceStrategy = LazyKt.lazy(new Function0<PersistenceStrategy>() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$grantedPersistenceStrategy$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PersistenceStrategy invoke() {
                return this.this$0.getPersistenceStrategyFactory().create(this.this$0.getSdkCoreId() + DomExceptionUtils.SEPARATOR + this.this$0.featureName + DomExceptionUtils.SEPARATOR + TrackingConsent.GRANTED, this.this$0.getStorageConfiguration().getMaxItemsPerBatch(), this.this$0.getStorageConfiguration().getMaxBatchSize());
            }
        });
        this.pendingPersistenceStrategy = LazyKt.lazy(new Function0<PersistenceStrategy>() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$pendingPersistenceStrategy$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PersistenceStrategy invoke() {
                return this.this$0.getPersistenceStrategyFactory().create(this.this$0.getSdkCoreId() + DomExceptionUtils.SEPARATOR + this.this$0.featureName + DomExceptionUtils.SEPARATOR + TrackingConsent.PENDING, this.this$0.getStorageConfiguration().getMaxItemsPerBatch(), this.this$0.getStorageConfiguration().getMaxBatchSize());
            }
        });
        this.writeLock = new Object();
        this.notGrantedPersistenceStrategy = new NoOpPersistenceStrategy();
        consentProvider.registerCallback(this);
    }

    /* JADX INFO: renamed from: getSdkCoreId$dd_sdk_android_core_release, reason: from getter */
    public final String getSdkCoreId() {
        return this.sdkCoreId;
    }

    /* JADX INFO: renamed from: getPersistenceStrategyFactory$dd_sdk_android_core_release, reason: from getter */
    public final PersistenceStrategy.Factory getPersistenceStrategyFactory() {
        return this.persistenceStrategyFactory;
    }

    /* JADX INFO: renamed from: getStorageConfiguration$dd_sdk_android_core_release, reason: from getter */
    public final FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    private final PersistenceStrategy getGrantedPersistenceStrategy() {
        return (PersistenceStrategy) this.grantedPersistenceStrategy.getValue();
    }

    private final PersistenceStrategy getPendingPersistenceStrategy() {
        return (PersistenceStrategy) this.pendingPersistenceStrategy.getValue();
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public Function1<Function1<? super EventBatchWriter, Unit>, Unit> getEventWriteScope(DatadogContext datadogContext) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        final PersistenceStrategy persistenceStrategyResolvePersistenceStrategy = resolvePersistenceStrategy(datadogContext);
        return new AsyncEventWriteScope(this.executorService, new EventBatchWriter() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$getEventWriteScope$writer$1
            @Override // com.datadog.android.api.storage.EventBatchWriter
            public boolean write(RawBatchEvent event, byte[] batchMetadata, EventType eventType) {
                Intrinsics.checkNotNullParameter(event, "event");
                Intrinsics.checkNotNullParameter(eventType, "eventType");
                return persistenceStrategyResolvePersistenceStrategy.write(event, batchMetadata, eventType);
            }
        }, this.writeLock, this.featureName, this.internalLogger);
    }

    private final PersistenceStrategy resolvePersistenceStrategy(DatadogContext datadogContext) {
        int i = WhenMappings.$EnumSwitchMapping$0[datadogContext.getTrackingConsent().ordinal()];
        if (i == 1) {
            return getGrantedPersistenceStrategy();
        }
        if (i == 2) {
            return getPendingPersistenceStrategy();
        }
        if (i == 3) {
            return this.notGrantedPersistenceStrategy;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public BatchData readNextBatch() {
        PersistenceStrategy.Batch batchLockAndReadNext = getGrantedPersistenceStrategy().lockAndReadNext();
        if (batchLockAndReadNext != null) {
            return new BatchData(new BatchId(batchLockAndReadNext.getBatchId()), batchLockAndReadNext.getEvents(), batchLockAndReadNext.getMetadata());
        }
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void confirmBatchRead(BatchId batchId, RemovalReason removalReason, boolean deleteBatch) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(removalReason, "removalReason");
        if (deleteBatch) {
            getGrantedPersistenceStrategy().unlockAndDelete(batchId.getId());
        } else {
            getGrantedPersistenceStrategy().unlockAndKeep(batchId.getId());
        }
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void dropAll() {
        ConcurrencyExtKt.executeSafe(this.executorService, "Data drop", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AbstractStorage.dropAll$lambda$1(this.f$0);
            }
        });
    }

    static final void dropAll$lambda$1(AbstractStorage abstractStorage) {
        abstractStorage.getGrantedPersistenceStrategy().dropAll();
        abstractStorage.getPendingPersistenceStrategy().dropAll();
    }

    @Override // com.datadog.android.privacy.TrackingConsentProviderCallback
    public void onConsentUpdated(final TrackingConsent previousConsent, final TrackingConsent newConsent) {
        Intrinsics.checkNotNullParameter(previousConsent, "previousConsent");
        Intrinsics.checkNotNullParameter(newConsent, "newConsent");
        ConcurrencyExtKt.executeSafe(this.executorService, "Data migration", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.AbstractStorage$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractStorage.onConsentUpdated$lambda$2(previousConsent, newConsent, this);
            }
        });
    }

    static final void onConsentUpdated$lambda$2(TrackingConsent trackingConsent, TrackingConsent trackingConsent2, AbstractStorage abstractStorage) {
        if (trackingConsent == TrackingConsent.PENDING) {
            int i = WhenMappings.$EnumSwitchMapping$0[trackingConsent2.ordinal()];
            if (i == 1) {
                abstractStorage.getPendingPersistenceStrategy().migrateData(abstractStorage.getGrantedPersistenceStrategy());
            } else {
                if (i != 3) {
                    return;
                }
                abstractStorage.getPendingPersistenceStrategy().dropAll();
            }
        }
    }
}
