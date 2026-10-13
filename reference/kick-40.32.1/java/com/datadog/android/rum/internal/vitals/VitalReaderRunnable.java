package com.datadog.android.rum.internal.vitals;

import com.datadog.android.api.feature.FeatureContextUpdateReceiver;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.rum.internal.domain.scope.RumViewType;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VitalReaderRunnable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0016J\b\u0010!\u001a\u00020\u001bH\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/datadog/android/rum/internal/vitals/VitalReaderRunnable;", "Ljava/lang/Runnable;", "Lcom/datadog/android/api/feature/FeatureContextUpdateReceiver;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "reader", "Lcom/datadog/android/rum/internal/vitals/VitalReader;", "observer", "Lcom/datadog/android/rum/internal/vitals/VitalObserver;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "periodMs", "", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Lcom/datadog/android/rum/internal/vitals/VitalReader;Lcom/datadog/android/rum/internal/vitals/VitalObserver;Ljava/util/concurrent/ScheduledExecutorService;J)V", "currentRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "getCurrentRumContext$dd_sdk_android_rum_release", "()Lcom/datadog/android/rum/internal/domain/RumContext;", "setCurrentRumContext$dd_sdk_android_rum_release", "(Lcom/datadog/android/rum/internal/domain/RumContext;)V", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "getObserver", "()Lcom/datadog/android/rum/internal/vitals/VitalObserver;", "getSdkCore", "()Lcom/datadog/android/api/feature/FeatureSdkCore;", "onContextUpdate", "", "featureName", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "", "", "run", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VitalReaderRunnable implements Runnable, FeatureContextUpdateReceiver {
    private volatile RumContext currentRumContext;
    private final ScheduledExecutorService executor;
    private final VitalObserver observer;
    private final long periodMs;
    private final VitalReader reader;
    private final FeatureSdkCore sdkCore;

    public VitalReaderRunnable(FeatureSdkCore sdkCore, VitalReader reader, VitalObserver observer, ScheduledExecutorService executor, long j) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.sdkCore = sdkCore;
        this.reader = reader;
        this.observer = observer;
        this.executor = executor;
        this.periodMs = j;
    }

    public final FeatureSdkCore getSdkCore() {
        return this.sdkCore;
    }

    public final VitalObserver getObserver() {
        return this.observer;
    }

    public final ScheduledExecutorService getExecutor() {
        return this.executor;
    }

    /* JADX INFO: renamed from: getCurrentRumContext$dd_sdk_android_rum_release, reason: from getter */
    public final RumContext getCurrentRumContext() {
        return this.currentRumContext;
    }

    public final void setCurrentRumContext$dd_sdk_android_rum_release(RumContext rumContext) {
        this.currentRumContext = rumContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        Double vitalData;
        RumContext rumContext = this.currentRumContext;
        if ((rumContext != null ? rumContext.getViewType() : null) == RumViewType.FOREGROUND && (vitalData = this.reader.readVitalData()) != null) {
            this.observer.onNewSample(vitalData.doubleValue());
        }
        ConcurrencyExtKt.scheduleSafe(this.executor, "Vitals monitoring", this.periodMs, TimeUnit.MILLISECONDS, this.sdkCore.getInternalLogger(), this);
    }

    @Override // com.datadog.android.api.feature.FeatureContextUpdateReceiver
    public void onContextUpdate(String featureName, Map<String, ? extends Object> context) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(featureName, "rum")) {
            this.currentRumContext = RumContext.INSTANCE.fromFeatureContext(context);
        }
    }
}
