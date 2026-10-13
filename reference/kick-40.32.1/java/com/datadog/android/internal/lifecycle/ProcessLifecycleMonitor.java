package com.datadog.android.internal.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProcessLifecycleMonitor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0018H\u0017J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006!"}, d2 = {"Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callback", "Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor$Callback;", "(Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor$Callback;)V", "activitiesResumedCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "getActivitiesResumedCounter", "()Ljava/util/concurrent/atomic/AtomicInteger;", "activitiesStartedCounter", "getActivitiesStartedCounter", "getCallback", "()Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor$Callback;", "wasPaused", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getWasPaused", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "wasStopped", "getWasStopped", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "Callback", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessLifecycleMonitor implements Application.ActivityLifecycleCallbacks {
    private final AtomicInteger activitiesResumedCounter;
    private final AtomicInteger activitiesStartedCounter;
    private final Callback callback;
    private final AtomicBoolean wasPaused;
    private final AtomicBoolean wasStopped;

    /* JADX INFO: compiled from: ProcessLifecycleMonitor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/internal/lifecycle/ProcessLifecycleMonitor$Callback;", "", "onPaused", "", "onResumed", "onStarted", "onStopped", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Callback {
        void onPaused();

        void onResumed();

        void onStarted();

        void onStopped();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    public ProcessLifecycleMonitor(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.activitiesResumedCounter = new AtomicInteger(0);
        this.activitiesStartedCounter = new AtomicInteger(0);
        this.wasPaused = new AtomicBoolean(true);
        this.wasStopped = new AtomicBoolean(true);
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final AtomicInteger getActivitiesResumedCounter() {
        return this.activitiesResumedCounter;
    }

    public final AtomicInteger getActivitiesStartedCounter() {
        return this.activitiesStartedCounter;
    }

    public final AtomicBoolean getWasPaused() {
        return this.wasPaused;
    }

    public final AtomicBoolean getWasStopped() {
        return this.wasStopped;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.activitiesResumedCounter.decrementAndGet() != 0 || this.wasPaused.getAndSet(true)) {
            return;
        }
        this.callback.onPaused();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.activitiesStartedCounter.incrementAndGet() == 1 && this.wasStopped.getAndSet(false)) {
            this.callback.onStarted();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.activitiesStartedCounter.decrementAndGet() == 0 && this.wasPaused.get()) {
            this.callback.onStopped();
            this.wasStopped.set(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.activitiesResumedCounter.incrementAndGet() == 1 && this.wasPaused.getAndSet(false)) {
            this.callback.onResumed();
        }
    }
}
