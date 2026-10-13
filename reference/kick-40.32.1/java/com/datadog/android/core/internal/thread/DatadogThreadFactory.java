package com.datadog.android.core.internal.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogThreadFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/core/internal/thread/DatadogThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "newThreadContext", "", "(Ljava/lang/String;)V", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogThreadFactory implements ThreadFactory {
    private final String newThreadContext;
    private final AtomicInteger threadNumber;

    public DatadogThreadFactory(String newThreadContext) {
        Intrinsics.checkNotNullParameter(newThreadContext, "newThreadContext");
        this.newThreadContext = newThreadContext;
        this.threadNumber = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r) {
        int andIncrement = this.threadNumber.getAndIncrement();
        Thread thread = new Thread(r, "datadog-" + this.newThreadContext + "-thread-" + andIncrement);
        thread.setPriority(5);
        thread.setDaemon(false);
        return thread;
    }
}
