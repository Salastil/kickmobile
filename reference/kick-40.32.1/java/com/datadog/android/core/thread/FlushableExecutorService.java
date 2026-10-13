package com.datadog.android.core.thread;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureStrategy;
import com.datadog.android.internal.time.TimeProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: FlushableExecutorService.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Lcom/datadog/android/core/thread/FlushableExecutorService;", "Ljava/util/concurrent/ExecutorService;", "drainTo", "", FirebaseAnalytics.Param.DESTINATION, "", "Ljava/lang/Runnable;", "Factory", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FlushableExecutorService extends ExecutorService, AutoCloseable {

    /* JADX INFO: compiled from: FlushableExecutorService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/datadog/android/core/thread/FlushableExecutorService$Factory;", "", "create", "Lcom/datadog/android/core/thread/FlushableExecutorService;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "executorContext", "", "backPressureStrategy", "Lcom/datadog/android/core/configuration/BackPressureStrategy;", "timeProvider", "Lcom/datadog/android/internal/time/TimeProvider;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Factory {
        FlushableExecutorService create(InternalLogger internalLogger, String executorContext, BackPressureStrategy backPressureStrategy, TimeProvider timeProvider);
    }

    @Override // java.lang.AutoCloseable
    /* synthetic */ default void close() {
        UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    void drainTo(Collection<Runnable> destination);
}
