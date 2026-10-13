package com.datadog.android.rum.internal.startup;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.rum.internal.utils.window.RumWindowCallbacksRegistryImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RumFirstDrawTimeReporter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 \t2\u00020\u0001:\u0003\b\t\nJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter;", "", "subscribeToFirstFrameDrawn", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Handle;", "activity", "Landroid/app/Activity;", "callback", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Callback;", "Callback", "Companion", "Handle", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RumFirstDrawTimeReporter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: RumFirstDrawTimeReporter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Callback;", "", "onFirstFrameDrawn", "", "timestampNs", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Callback {
        void onFirstFrameDrawn(long timestampNs);
    }

    /* JADX INFO: compiled from: RumFirstDrawTimeReporter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Handle;", "", "unsubscribe", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Handle {
        void unsubscribe();
    }

    Handle subscribeToFirstFrameDrawn(Activity activity, Callback callback);

    /* JADX INFO: compiled from: RumFirstDrawTimeReporter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter$Companion;", "", "()V", "create", "Lcom/datadog/android/rum/internal/startup/RumFirstDrawTimeReporter;", "sdkCore", "Lcom/datadog/android/core/InternalSdkCore;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final RumFirstDrawTimeReporter create(final InternalSdkCore sdkCore) {
            Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
            return new RumFirstDrawTimeReporterImpl(sdkCore.getInternalLogger(), new Function0<Long>() { // from class: com.datadog.android.rum.internal.startup.RumFirstDrawTimeReporter$Companion$create$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Long invoke() {
                    return Long.valueOf(sdkCore.getTimeProvider().getDeviceElapsedTimeNanos());
                }
            }, new RumWindowCallbacksRegistryImpl(), new Handler(Looper.getMainLooper()));
        }
    }
}
