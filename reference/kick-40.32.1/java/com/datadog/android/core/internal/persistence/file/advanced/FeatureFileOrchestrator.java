package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.metrics.MetricsDispatcher;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.privacy.TrackingConsent;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: FeatureFileOrchestrator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/FeatureFileOrchestrator;", "Lcom/datadog/android/core/internal/persistence/file/advanced/ConsentAwareFileOrchestrator;", "consentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "storageDir", "Ljava/io/File;", "featureName", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "filePersistenceConfig", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "metricsDispatcher", "Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;Ljava/io/File;Ljava/lang/String;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/internal/metrics/MetricsDispatcher;Lcom/datadog/android/internal/time/TimeProvider;)V", "pendingOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "grantedOrchestrator", "dataMigrator", "Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;", "Lcom/datadog/android/privacy/TrackingConsent;", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/api/InternalLogger;)V", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FeatureFileOrchestrator extends ConsentAwareFileOrchestrator {
    private static final String BASE_DIR_NAME_REG_EX = "([a-z]+-)+";
    public static final String GRANTED_DIR = "%s-v2";
    public static final String PENDING_DIR = "%s-pending-v2";
    public static final int VERSION = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex IS_GRANTED_DIR_REG_EX = new Regex("([a-z]+-)+v[0-9]+");
    private static final Regex IS_PENDING_DIR_REG_EX = new Regex("([a-z]+-)+pending-v[0-9]+");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureFileOrchestrator(ConsentProvider consentProvider, FileOrchestrator pendingOrchestrator, FileOrchestrator grantedOrchestrator, DataMigrator<TrackingConsent> dataMigrator, ExecutorService executorService, InternalLogger internalLogger) {
        super(consentProvider, pendingOrchestrator, grantedOrchestrator, dataMigrator, executorService, internalLogger);
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(pendingOrchestrator, "pendingOrchestrator");
        Intrinsics.checkNotNullParameter(grantedOrchestrator, "grantedOrchestrator");
        Intrinsics.checkNotNullParameter(dataMigrator, "dataMigrator");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
    }

    public FeatureFileOrchestrator(ConsentProvider consentProvider, File storageDir, String featureName, ExecutorService executorService, FilePersistenceConfig filePersistenceConfig, InternalLogger internalLogger, MetricsDispatcher metricsDispatcher, TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(metricsDispatcher, "metricsDispatcher");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        String str = String.format(Locale.US, PENDING_DIR, Arrays.copyOf(new Object[]{featureName}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        BatchFileOrchestrator batchFileOrchestrator = new BatchFileOrchestrator(new File(storageDir, str), filePersistenceConfig, internalLogger, metricsDispatcher, timeProvider, null, 32, null);
        String str2 = String.format(Locale.US, GRANTED_DIR, Arrays.copyOf(new Object[]{featureName}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        this(consentProvider, batchFileOrchestrator, new BatchFileOrchestrator(new File(storageDir, str2), filePersistenceConfig, internalLogger, metricsDispatcher, timeProvider, null, 32, null), new ConsentAwareFileMigrator(new FileMover(internalLogger), internalLogger), executorService, internalLogger);
    }

    /* JADX INFO: compiled from: FeatureFileOrchestrator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/FeatureFileOrchestrator$Companion;", "", "()V", "BASE_DIR_NAME_REG_EX", "", "GRANTED_DIR", "IS_GRANTED_DIR_REG_EX", "Lkotlin/text/Regex;", "getIS_GRANTED_DIR_REG_EX$dd_sdk_android_core_release", "()Lkotlin/text/Regex;", "IS_PENDING_DIR_REG_EX", "getIS_PENDING_DIR_REG_EX$dd_sdk_android_core_release", "PENDING_DIR", "VERSION", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getIS_GRANTED_DIR_REG_EX$dd_sdk_android_core_release() {
            return FeatureFileOrchestrator.IS_GRANTED_DIR_REG_EX;
        }

        public final Regex getIS_PENDING_DIR_REG_EX$dd_sdk_android_core_release() {
            return FeatureFileOrchestrator.IS_PENDING_DIR_REG_EX;
        }
    }
}
