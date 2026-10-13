package com.datadog.android.api.feature;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: compiled from: Feature.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/datadog/android/api/feature/Feature;", "", "name", "", "getName", "()Ljava/lang/String;", "onInitialize", "", "appContext", "Landroid/content/Context;", "onStop", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Feature {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String FLAGS_EVALUATIONS_FEATURE_NAME = "flags-evaluations";
    public static final String FLAGS_FEATURE_NAME = "flags";
    public static final String LOGS_FEATURE_NAME = "logs";
    public static final String NDK_CRASH_REPORTS_FEATURE_NAME = "ndk-crash-reporting";
    public static final String PROFILING_FEATURE_NAME = "profiling";
    public static final String RUM_FEATURE_NAME = "rum";
    public static final String SESSION_REPLAY_FEATURE_NAME = "session-replay";
    public static final String SESSION_REPLAY_RESOURCES_FEATURE_NAME = "session-replay-resources";
    public static final String TRACING_FEATURE_NAME = "tracing";

    String getName();

    void onInitialize(Context appContext);

    void onStop();

    /* JADX INFO: compiled from: Feature.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/api/feature/Feature$Companion;", "", "()V", "FLAGS_EVALUATIONS_FEATURE_NAME", "", "FLAGS_FEATURE_NAME", "LOGS_FEATURE_NAME", "NDK_CRASH_REPORTS_FEATURE_NAME", "PROFILING_FEATURE_NAME", "RUM_FEATURE_NAME", "SESSION_REPLAY_FEATURE_NAME", "SESSION_REPLAY_RESOURCES_FEATURE_NAME", "TRACING_FEATURE_NAME", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String FLAGS_EVALUATIONS_FEATURE_NAME = "flags-evaluations";
        public static final String FLAGS_FEATURE_NAME = "flags";
        public static final String LOGS_FEATURE_NAME = "logs";
        public static final String NDK_CRASH_REPORTS_FEATURE_NAME = "ndk-crash-reporting";
        public static final String PROFILING_FEATURE_NAME = "profiling";
        public static final String RUM_FEATURE_NAME = "rum";
        public static final String SESSION_REPLAY_FEATURE_NAME = "session-replay";
        public static final String SESSION_REPLAY_RESOURCES_FEATURE_NAME = "session-replay-resources";
        public static final String TRACING_FEATURE_NAME = "tracing";

        private Companion() {
        }
    }
}
