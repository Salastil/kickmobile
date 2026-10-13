package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.privacy.TrackingConsent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentAwareFileMigrator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J*\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0017J*\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ConsentAwareFileMigrator;", "Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;", "Lcom/datadog/android/privacy/TrackingConsent;", "fileMover", "Lcom/datadog/android/core/internal/persistence/file/FileMover;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/core/internal/persistence/file/FileMover;Lcom/datadog/android/api/InternalLogger;)V", "migrateData", "", "previousState", "previousFileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "newState", "newFileOrchestrator", "resolveMigrationOperation", "Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrationOperation;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsentAwareFileMigrator implements DataMigrator<TrackingConsent> {
    private final FileMover fileMover;
    private final InternalLogger internalLogger;

    public ConsentAwareFileMigrator(FileMover fileMover, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(fileMover, "fileMover");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.fileMover = fileMover;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.advanced.DataMigrator
    public void migrateData(TrackingConsent previousState, FileOrchestrator previousFileOrchestrator, TrackingConsent newState, FileOrchestrator newFileOrchestrator) {
        Intrinsics.checkNotNullParameter(previousFileOrchestrator, "previousFileOrchestrator");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(newFileOrchestrator, "newFileOrchestrator");
        resolveMigrationOperation(previousState, newState, previousFileOrchestrator, newFileOrchestrator).run();
    }

    private final DataMigrationOperation resolveMigrationOperation(final TrackingConsent previousState, final TrackingConsent newState, FileOrchestrator previousFileOrchestrator, FileOrchestrator newFileOrchestrator) {
        Pair pair = TuplesKt.to(previousState, newState);
        if (Intrinsics.areEqual(pair, TuplesKt.to(null, TrackingConsent.PENDING)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(null, TrackingConsent.GRANTED)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(null, TrackingConsent.NOT_GRANTED)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.PENDING, TrackingConsent.NOT_GRANTED))) {
            return new WipeDataMigrationOperation(previousFileOrchestrator.getRootDir(), this.fileMover, this.internalLogger);
        }
        if (Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.GRANTED, TrackingConsent.PENDING)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.NOT_GRANTED, TrackingConsent.PENDING))) {
            return new WipeDataMigrationOperation(newFileOrchestrator.getRootDir(), this.fileMover, this.internalLogger);
        }
        if (Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.PENDING, TrackingConsent.GRANTED))) {
            return new MoveDataMigrationOperation(previousFileOrchestrator.getRootDir(), newFileOrchestrator.getRootDir(), this.fileMover, this.internalLogger);
        }
        if (Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.PENDING, TrackingConsent.PENDING)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.GRANTED, TrackingConsent.GRANTED)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.GRANTED, TrackingConsent.NOT_GRANTED)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.NOT_GRANTED, TrackingConsent.NOT_GRANTED)) ? true : Intrinsics.areEqual(pair, TuplesKt.to(TrackingConsent.NOT_GRANTED, TrackingConsent.GRANTED))) {
            return new NoOpDataMigrationOperation();
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileMigrator.resolveMigrationOperation.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Unexpected consent migration from " + previousState + " to " + newState;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return new NoOpDataMigrationOperation();
    }
}
