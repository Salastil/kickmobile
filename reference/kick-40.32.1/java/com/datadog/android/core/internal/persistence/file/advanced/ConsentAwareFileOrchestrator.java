package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.NoOpFileOrchestrator;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentAwareFileOrchestrator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0017J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0017J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0017J\u0018\u0010!\u001a\u0004\u0018\u00010\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0#H\u0017J\n\u0010$\u001a\u0004\u0018\u00010\u001dH\u0017J\u0012\u0010%\u001a\u0004\u0018\u00010\u001d2\u0006\u0010&\u001a\u00020'H\u0017J\u001a\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\tH\u0003J\u0018\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0016J\u0012\u0010-\u001a\u00020\u00012\b\u0010.\u001a\u0004\u0018\u00010\tH\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u00060"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ConsentAwareFileOrchestrator;", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "Lcom/datadog/android/privacy/TrackingConsentProviderCallback;", "consentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "pendingOrchestrator", "grantedOrchestrator", "dataMigrator", "Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;", "Lcom/datadog/android/privacy/TrackingConsent;", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/api/InternalLogger;)V", "getDataMigrator$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;", "delegateOrchestrator", "getExecutorService$dd_sdk_android_core_release", "()Ljava/util/concurrent/ExecutorService;", "getGrantedOrchestrator$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getInternalLogger$dd_sdk_android_core_release", "()Lcom/datadog/android/api/InternalLogger;", "getPendingOrchestrator$dd_sdk_android_core_release", "decrementAndGetPendingFilesCount", "", "getAllFiles", "", "Ljava/io/File;", "getFlushableFiles", "getMetadataFile", "file", "getReadableFile", "excludeFiles", "", "getRootDir", "getWritableFile", "eventSize", "", "handleConsentChange", "", "previousConsent", "newConsent", "onConsentUpdated", "resolveDelegateOrchestrator", BatchMetricsDispatcher.TRACKING_CONSENT_KEY, "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ConsentAwareFileOrchestrator implements FileOrchestrator, TrackingConsentProviderCallback {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FileOrchestrator NO_OP_ORCHESTRATOR = new NoOpFileOrchestrator();
    private final DataMigrator<TrackingConsent> dataMigrator;
    private volatile FileOrchestrator delegateOrchestrator;
    private final ExecutorService executorService;
    private final FileOrchestrator grantedOrchestrator;
    private final InternalLogger internalLogger;
    private final FileOrchestrator pendingOrchestrator;

    /* JADX INFO: compiled from: ConsentAwareFileOrchestrator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TrackingConsent.values().length];
            try {
                iArr[TrackingConsent.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrackingConsent.GRANTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TrackingConsent.NOT_GRANTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getRootDir() {
        return null;
    }

    public ConsentAwareFileOrchestrator(ConsentProvider consentProvider, FileOrchestrator pendingOrchestrator, FileOrchestrator grantedOrchestrator, DataMigrator<TrackingConsent> dataMigrator, ExecutorService executorService, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(pendingOrchestrator, "pendingOrchestrator");
        Intrinsics.checkNotNullParameter(grantedOrchestrator, "grantedOrchestrator");
        Intrinsics.checkNotNullParameter(dataMigrator, "dataMigrator");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.pendingOrchestrator = pendingOrchestrator;
        this.grantedOrchestrator = grantedOrchestrator;
        this.dataMigrator = dataMigrator;
        this.executorService = executorService;
        this.internalLogger = internalLogger;
        handleConsentChange(null, consentProvider.getConsent());
        consentProvider.registerCallback(this);
    }

    /* JADX INFO: renamed from: getPendingOrchestrator$dd_sdk_android_core_release, reason: from getter */
    public final FileOrchestrator getPendingOrchestrator() {
        return this.pendingOrchestrator;
    }

    /* JADX INFO: renamed from: getGrantedOrchestrator$dd_sdk_android_core_release, reason: from getter */
    public final FileOrchestrator getGrantedOrchestrator() {
        return this.grantedOrchestrator;
    }

    public final DataMigrator<TrackingConsent> getDataMigrator$dd_sdk_android_core_release() {
        return this.dataMigrator;
    }

    /* JADX INFO: renamed from: getExecutorService$dd_sdk_android_core_release, reason: from getter */
    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    /* JADX INFO: renamed from: getInternalLogger$dd_sdk_android_core_release, reason: from getter */
    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getWritableFile(long eventSize) {
        FileOrchestrator fileOrchestrator = this.delegateOrchestrator;
        if (fileOrchestrator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegateOrchestrator");
            fileOrchestrator = null;
        }
        return fileOrchestrator.getWritableFile(eventSize);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getReadableFile(Set<? extends File> excludeFiles) {
        Intrinsics.checkNotNullParameter(excludeFiles, "excludeFiles");
        return this.grantedOrchestrator.getReadableFile(excludeFiles);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List<File> getAllFiles() {
        return CollectionsKt.plus((Collection) this.pendingOrchestrator.getAllFiles(), (Iterable) this.grantedOrchestrator.getAllFiles());
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public List<File> getFlushableFiles() {
        return this.grantedOrchestrator.getFlushableFiles();
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public File getMetadataFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        FileOrchestrator fileOrchestrator = this.delegateOrchestrator;
        if (fileOrchestrator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegateOrchestrator");
            fileOrchestrator = null;
        }
        return fileOrchestrator.getMetadataFile(file);
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileOrchestrator
    public int decrementAndGetPendingFilesCount() {
        FileOrchestrator fileOrchestrator = this.delegateOrchestrator;
        if (fileOrchestrator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegateOrchestrator");
            fileOrchestrator = null;
        }
        return fileOrchestrator.decrementAndGetPendingFilesCount();
    }

    @Override // com.datadog.android.privacy.TrackingConsentProviderCallback
    public void onConsentUpdated(TrackingConsent previousConsent, TrackingConsent newConsent) {
        Intrinsics.checkNotNullParameter(previousConsent, "previousConsent");
        Intrinsics.checkNotNullParameter(newConsent, "newConsent");
        handleConsentChange(previousConsent, newConsent);
    }

    private final void handleConsentChange(final TrackingConsent previousConsent, final TrackingConsent newConsent) {
        final FileOrchestrator fileOrchestratorResolveDelegateOrchestrator = resolveDelegateOrchestrator(previousConsent);
        final FileOrchestrator fileOrchestratorResolveDelegateOrchestrator2 = resolveDelegateOrchestrator(newConsent);
        ConcurrencyExtKt.executeSafe(this.executorService, "Data migration", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileOrchestrator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConsentAwareFileOrchestrator.handleConsentChange$lambda$0(this.f$0, previousConsent, fileOrchestratorResolveDelegateOrchestrator, newConsent, fileOrchestratorResolveDelegateOrchestrator2);
            }
        });
    }

    static final void handleConsentChange$lambda$0(ConsentAwareFileOrchestrator consentAwareFileOrchestrator, TrackingConsent trackingConsent, FileOrchestrator fileOrchestrator, TrackingConsent trackingConsent2, FileOrchestrator fileOrchestrator2) {
        consentAwareFileOrchestrator.dataMigrator.migrateData(trackingConsent, fileOrchestrator, trackingConsent2, fileOrchestrator2);
        consentAwareFileOrchestrator.delegateOrchestrator = fileOrchestrator2;
    }

    private final FileOrchestrator resolveDelegateOrchestrator(TrackingConsent consent) {
        int i = consent == null ? -1 : WhenMappings.$EnumSwitchMapping$0[consent.ordinal()];
        if (i == -1 || i == 1) {
            return this.pendingOrchestrator;
        }
        if (i == 2) {
            return this.grantedOrchestrator;
        }
        if (i == 3) {
            return NO_OP_ORCHESTRATOR;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: ConsentAwareFileOrchestrator.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ConsentAwareFileOrchestrator$Companion;", "", "()V", "NO_OP_ORCHESTRATOR", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getNO_OP_ORCHESTRATOR$dd_sdk_android_core_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FileOrchestrator getNO_OP_ORCHESTRATOR$dd_sdk_android_core_release() {
            return ConsentAwareFileOrchestrator.NO_OP_ORCHESTRATOR;
        }
    }
}
