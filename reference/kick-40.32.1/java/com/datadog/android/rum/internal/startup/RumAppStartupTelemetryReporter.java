package com.datadog.android.rum.internal.startup;

import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.rum.DdRumContentProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumAppStartupTelemetryReporter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumAppStartupTelemetryReporter;", "", "reportTTID", "", "info", "Lcom/datadog/android/rum/internal/startup/RumTTIDInfo;", "indexInSession", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RumAppStartupTelemetryReporter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void reportTTID(RumTTIDInfo info, int indexInSession);

    /* JADX INFO: compiled from: RumAppStartupTelemetryReporter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumAppStartupTelemetryReporter$Companion;", "", "()V", "create", "Lcom/datadog/android/rum/internal/startup/RumAppStartupTelemetryReporter;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final RumAppStartupTelemetryReporter create(InternalSdkCore sdkCore) {
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            return new RumAppStartupTelemetryReporterImpl(sdkCore.getInternalLogger(), sdkCore.getAppStartTimeNs(), DdRumContentProvider.INSTANCE.getCreateTimeNs(), DdRumContentProvider.INSTANCE.getProcessImportance());
        }
    }
}
