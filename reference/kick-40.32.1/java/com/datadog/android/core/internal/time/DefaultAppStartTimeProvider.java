package com.datadog.android.core.internal.time;

import android.os.Process;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import com.datadog.android.internal.time.TimeProvider;
import com.datadog.android.rum.DdRumContentProvider;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: DefaultAppStartTimeProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/core/internal/time/DefaultAppStartTimeProvider;", "Lcom/datadog/android/core/internal/time/AppStartTimeProvider;", "timeProviderFactory", "Lkotlin/Function0;", "Lcom/datadog/android/internal/time/TimeProvider;", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(Lkotlin/jvm/functions/Function0;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "appStartTimeNs", "", "getAppStartTimeNs", "()J", "appStartTimeNs$delegate", "Lkotlin/Lazy;", "appUptimeNs", "getAppUptimeNs", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultAppStartTimeProvider implements AppStartTimeProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long PROCESS_START_TO_CP_START_DIFF_THRESHOLD_NS;

    /* JADX INFO: renamed from: appStartTimeNs$delegate, reason: from kotlin metadata */
    private final Lazy appStartTimeNs;
    private final Function0<TimeProvider> timeProviderFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultAppStartTimeProvider(Function0<? extends TimeProvider> timeProviderFactory, final BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(timeProviderFactory, "timeProviderFactory");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.timeProviderFactory = timeProviderFactory;
        this.appStartTimeNs = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Long>() { // from class: com.datadog.android.core.internal.time.DefaultAppStartTimeProvider$appStartTimeNs$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                long createTimeNs;
                if (buildSdkVersionProvider.getIsAtLeastN()) {
                    TimeProvider timeProvider = (TimeProvider) this.timeProviderFactory.invoke();
                    createTimeNs = timeProvider.getDeviceElapsedTimeNanos() - TimeUnit.MILLISECONDS.toNanos(timeProvider.getDeviceUptimeMillis() - Process.getStartUptimeMillis());
                    long createTimeNs2 = DdRumContentProvider.INSTANCE.getCreateTimeNs();
                    boolean z = createTimeNs > createTimeNs2;
                    boolean z2 = createTimeNs2 - createTimeNs > DefaultAppStartTimeProvider.INSTANCE.getPROCESS_START_TO_CP_START_DIFF_THRESHOLD_NS$dd_sdk_android_core_release();
                    if (z || z2) {
                        createTimeNs = createTimeNs2;
                    }
                } else {
                    createTimeNs = DdRumContentProvider.INSTANCE.getCreateTimeNs();
                }
                return Long.valueOf(createTimeNs);
            }
        });
    }

    public /* synthetic */ DefaultAppStartTimeProvider(Function0 function0, BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider);
    }

    @Override // com.datadog.android.core.internal.time.AppStartTimeProvider
    public long getAppStartTimeNs() {
        return ((Number) this.appStartTimeNs.getValue()).longValue();
    }

    @Override // com.datadog.android.core.internal.time.AppStartTimeProvider
    public long getAppUptimeNs() {
        return this.timeProviderFactory.invoke().getDeviceElapsedTimeNanos() - getAppStartTimeNs();
    }

    /* JADX INFO: compiled from: DefaultAppStartTimeProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/core/internal/time/DefaultAppStartTimeProvider$Companion;", "", "()V", "PROCESS_START_TO_CP_START_DIFF_THRESHOLD_NS", "", "getPROCESS_START_TO_CP_START_DIFF_THRESHOLD_NS$dd_sdk_android_core_release", "()J", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getPROCESS_START_TO_CP_START_DIFF_THRESHOLD_NS$dd_sdk_android_core_release() {
            return DefaultAppStartTimeProvider.PROCESS_START_TO_CP_START_DIFF_THRESHOLD_NS;
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        PROCESS_START_TO_CP_START_DIFF_THRESHOLD_NS = Duration.m14077getInWholeNanosecondsimpl(DurationKt.toDuration(10, DurationUnit.SECONDS));
    }
}
