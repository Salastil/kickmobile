package com.datadog.android.rum.internal.startup;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.internal.domain.scope.RumVitalAppLaunchEventHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumSessionScopeStartupManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&Jh\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00030\u000bj\u0002`\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H&Jp\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00030\u000bj\u0002`\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H&¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumSessionScopeStartupManager;", "", "onAppStartEvent", "", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartEvent;", "onTTFDEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartTTFDEvent;", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "writeScope", "Lkotlin/Function1;", "Lcom/datadog/android/api/storage/EventBatchWriter;", "Lcom/datadog/android/api/feature/EventWriteScope;", "writer", "Lcom/datadog/android/api/storage/DataWriter;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "customAttributes", "", "", "onTTIDEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AppStartTTIDEvent;", "isSessionTracked", "", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RumSessionScopeStartupManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void onAppStartEvent(RumRawEvent.AppStartEvent event);

    void onTTFDEvent(RumRawEvent.AppStartTTFDEvent event, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer, RumContext rumContext, Map<String, ? extends Object> customAttributes);

    void onTTIDEvent(RumRawEvent.AppStartTTIDEvent event, boolean isSessionTracked, DatadogContext datadogContext, Function1<? super Function1<? super EventBatchWriter, Unit>, Unit> writeScope, DataWriter<Object> writer, RumContext rumContext, Map<String, ? extends Object> customAttributes);

    /* JADX INFO: compiled from: RumSessionScopeStartupManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumSessionScopeStartupManager$Companion;", "", "()V", "create", "Lcom/datadog/android/rum/internal/startup/RumSessionScopeStartupManager;", "rumVitalAppLaunchEventHelper", "Lcom/datadog/android/rum/internal/domain/scope/RumVitalAppLaunchEventHelper;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "rumAppStartupTelemetryReporter", "Lcom/datadog/android/rum/internal/startup/RumAppStartupTelemetryReporter;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final RumSessionScopeStartupManager create(RumVitalAppLaunchEventHelper rumVitalAppLaunchEventHelper, InternalSdkCore sdkCore, RumAppStartupTelemetryReporter rumAppStartupTelemetryReporter) {
            Intrinsics.checkNotNullParameter(rumVitalAppLaunchEventHelper, "rumVitalAppLaunchEventHelper");
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            Intrinsics.checkNotNullParameter(rumAppStartupTelemetryReporter, "rumAppStartupTelemetryReporter");
            return new RumSessionScopeStartupManagerImpl(rumVitalAppLaunchEventHelper, sdkCore, rumAppStartupTelemetryReporter);
        }
    }
}
