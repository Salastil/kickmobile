package com.datadog.android.core.internal.thread;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureStrategy;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScheduledExecutorServiceFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/datadog/android/core/internal/thread/ScheduledExecutorServiceFactory;", "", "create", "Ljava/util/concurrent/ScheduledExecutorService;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "executorContext", "", "backPressureStrategy", "Lcom/datadog/android/core/configuration/BackPressureStrategy;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ScheduledExecutorServiceFactory {
    ScheduledExecutorService create(InternalLogger internalLogger, String executorContext, BackPressureStrategy backPressureStrategy);
}
