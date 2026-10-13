package com.datadog.android.rum.internal.vitals;

import android.view.Window;
import androidx.metrics.performance.JankStats;
import com.datadog.android.api.InternalLogger;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JankStatsProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/JankStatsProvider;", "", "createJankStatsAndTrack", "Landroidx/metrics/performance/JankStats;", "window", "Landroid/view/Window;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/metrics/performance/JankStats$OnFrameListener;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface JankStatsProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    JankStats createJankStatsAndTrack(Window window, JankStats.OnFrameListener listener, InternalLogger internalLogger);

    /* JADX INFO: compiled from: JankStatsProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/JankStatsProvider$Companion;", "", "()V", "DEFAULT", "Lcom/datadog/android/rum/internal/vitals/JankStatsProvider;", "getDEFAULT", "()Lcom/datadog/android/rum/internal/vitals/JankStatsProvider;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final JankStatsProvider DEFAULT = new JankStatsProvider() { // from class: com.datadog.android.rum.internal.vitals.JankStatsProvider$Companion$DEFAULT$1
            @Override // com.datadog.android.rum.internal.vitals.JankStatsProvider
            public JankStats createJankStatsAndTrack(Window window, JankStats.OnFrameListener listener, InternalLogger internalLogger) {
                Intrinsics.checkNotNullParameter(window, "window");
                Intrinsics.checkNotNullParameter(listener, "listener");
                Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
                try {
                    return JankStats.INSTANCE.createAndTrack(window, listener);
                } catch (IllegalStateException e) {
                    InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.vitals.JankStatsProvider$Companion$DEFAULT$1$createJankStatsAndTrack$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Unable to attach JankStats to the current window";
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                    return null;
                }
            }
        };

        private Companion() {
        }

        public final JankStatsProvider getDEFAULT() {
            return DEFAULT;
        }
    }
}
