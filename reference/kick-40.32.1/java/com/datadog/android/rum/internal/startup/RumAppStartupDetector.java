package com.datadog.android.rum.internal.startup;

import android.app.Application;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.startup.AppStartupActivityPredicate;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumAppStartupDetector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector;", "", "destroy", "", "Companion", "Listener", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RumAppStartupDetector {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: RumAppStartupDetector.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector$Listener;", "", "onAppStartupDetected", "", RumAppStartupTelemetryReporterImpl.KEY_SCENARIO, "Lcom/datadog/android/rum/internal/startup/RumStartupScenario;", "onTTIDComputed", "durationNs", "", "wasForwarded", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Listener {
        void onAppStartupDetected(RumStartupScenario scenario);

        void onTTIDComputed(RumStartupScenario scenario, long durationNs, boolean wasForwarded);
    }

    void destroy();

    /* JADX INFO: compiled from: RumAppStartupDetector.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector$Companion;", "", "()V", "create", "Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector;", "application", "Landroid/app/Application;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/datadog/android/rum/internal/startup/RumAppStartupDetector$Listener;", "appStartupActivityPredicate", "Lcom/datadog/android/rum/startup/AppStartupActivityPredicate;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final RumAppStartupDetector create(Application application, final InternalSdkCore sdkCore, Listener listener, AppStartupActivityPredicate appStartupActivityPredicate) {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(appStartupActivityPredicate, "appStartupActivityPredicate");
            return new RumAppStartupDetectorImpl(application, BuildSdkVersionProvider.INSTANCE.getDEFAULT(), new Function0<Time>() { // from class: com.datadog.android.rum.internal.startup.RumAppStartupDetector$Companion$create$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Time invoke() {
                    return Time.INSTANCE.fromNanoTime(sdkCore.getAppStartTimeNs(), sdkCore.getTimeProvider());
                }
            }, new Function0<Time>() { // from class: com.datadog.android.rum.internal.startup.RumAppStartupDetector$Companion$create$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Time invoke() {
                    return Time.INSTANCE.now(sdkCore.getTimeProvider());
                }
            }, listener, appStartupActivityPredicate, RumFirstDrawTimeReporter.INSTANCE.create(sdkCore));
        }
    }
}
