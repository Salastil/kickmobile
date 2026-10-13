package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PriorityThreadFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/imagepipeline/core/PriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "threadPriority", "", "prefix", "", "addThreadNumber", "", "<init>", "(ILjava/lang/String;Z)V", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "imagepipeline-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PriorityThreadFactory implements ThreadFactory {
    private final boolean addThreadNumber;
    private final String prefix;
    private final AtomicInteger threadNumber;
    private final int threadPriority;

    public PriorityThreadFactory(int i) {
        this(i, null, false, 6, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriorityThreadFactory(int i, String prefix) {
        this(i, prefix, false, 4, null);
        Intrinsics.checkNotNullParameter(prefix, "prefix");
    }

    public PriorityThreadFactory(int i, String prefix, boolean z) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.threadPriority = i;
        this.prefix = prefix;
        this.addThreadNumber = z;
        this.threadNumber = new AtomicInteger(1);
    }

    public /* synthetic */ PriorityThreadFactory(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "PriorityThreadFactory" : str, (i2 & 4) != 0 ? true : z);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.core.PriorityThreadFactory$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PriorityThreadFactory.newThread$lambda$0(this.f$0, runnable);
            }
        };
        boolean z = this.addThreadNumber;
        String str = this.prefix;
        if (z) {
            str = str + "-" + this.threadNumber.getAndIncrement();
        }
        return new Thread(runnable2, str);
    }

    static final void newThread$lambda$0(PriorityThreadFactory priorityThreadFactory, Runnable runnable) {
        try {
            Process.setThreadPriority(priorityThreadFactory.threadPriority);
        } catch (Throwable unused) {
        }
        runnable.run();
    }
}
