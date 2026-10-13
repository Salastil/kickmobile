package com.datadog.android.core.internal.thread;

import com.datadog.android.api.InternalLogger;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThreadExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"ERROR_UNCAUGHT_EXECUTION_EXCEPTION", "", "loggingAfterExecute", "", "task", "Ljava/lang/Runnable;", "t", "", "logger", "Lcom/datadog/android/api/InternalLogger;", "sleepSafe", "", "durationMs", "", "internalLogger", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThreadExtKt {
    public static final String ERROR_UNCAUGHT_EXECUTION_EXCEPTION = "Uncaught exception during the task execution";

    public static final boolean sleepSafe(long j, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            try {
                Thread.sleep(j);
                return false;
            } catch (SecurityException e) {
                InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.sleepSafe.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Thread was unable to set its own interrupted state";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                return true;
            }
        } catch (IllegalArgumentException e2) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.sleepSafe.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Thread tried to sleep for a negative amount of time";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return false;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0048  */
    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    public static final void loggingAfterExecute(Runnable runnable, Throwable th, InternalLogger logger) {
        Throwable th2;
        CancellationException cause;
        Intrinsics.checkNotNullParameter(logger, "logger");
        if (th == null && (runnable instanceof Future) && ((Future) runnable).isDone()) {
            try {
                try {
                    ((Future) runnable).get();
                } catch (SecurityException e) {
                    InternalLogger.DefaultImpls.log$default(logger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.loggingAfterExecute.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Thread was unable to set its own interrupted state";
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e2) {
                cause = e2;
                th2 = cause;
                if (th2 != null) {
                    InternalLogger.DefaultImpls.log$default(logger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.loggingAfterExecute.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return ThreadExtKt.ERROR_UNCAUGHT_EXECUTION_EXCEPTION;
                        }
                    }, th2, false, (Map) null, 48, (Object) null);
                }
            } catch (ExecutionException e3) {
                cause = e3.getCause();
                th2 = cause;
                if (th2 != null) {
                    InternalLogger.DefaultImpls.log$default(logger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.loggingAfterExecute.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return ThreadExtKt.ERROR_UNCAUGHT_EXECUTION_EXCEPTION;
                        }
                    }, th2, false, (Map) null, 48, (Object) null);
                }
            }
        }
        th2 = th;
        if (th2 != null) {
            InternalLogger.DefaultImpls.log$default(logger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.thread.ThreadExtKt.loggingAfterExecute.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return ThreadExtKt.ERROR_UNCAUGHT_EXECUTION_EXCEPTION;
                }
            }, th2, false, (Map) null, 48, (Object) null);
        }
    }
}
