package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExecutorSupplier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "", "forLocalStorageRead", "Ljava/util/concurrent/Executor;", "forLocalStorageWrite", "forDecode", "forBackgroundTasks", "scheduledExecutorServiceForBackgroundTasks", "Ljava/util/concurrent/ScheduledExecutorService;", "forLightweightBackgroundTasks", "forThumbnailProducer", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ExecutorSupplier {
    Executor forBackgroundTasks();

    Executor forDecode();

    Executor forLightweightBackgroundTasks();

    Executor forLocalStorageRead();

    Executor forLocalStorageWrite();

    Executor forThumbnailProducer();

    ScheduledExecutorService scheduledExecutorServiceForBackgroundTasks();
}
