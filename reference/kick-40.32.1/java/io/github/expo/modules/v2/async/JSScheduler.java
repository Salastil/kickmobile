package io.github.expo.modules.v2.async;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSScheduler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lio/github/expo/modules/v2/async/JSScheduler;", "", "isOnJSThread", "", "()Z", "post", "", "job", "Ljava/lang/Runnable;", "postOrExecuteIfOnJsThread", "drainPending", "", "awaitJob", "timeoutNanos", "", "close", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface JSScheduler {
    default boolean awaitJob(long timeoutNanos) {
        return false;
    }

    default void close() {
    }

    default int drainPending() {
        return 0;
    }

    boolean isOnJSThread();

    void post(Runnable job);

    /* JADX INFO: compiled from: JSScheduler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void postOrExecuteIfOnJsThread(JSScheduler jSScheduler, Runnable job) {
            Intrinsics.checkNotNullParameter(job, "job");
            JSScheduler.super.postOrExecuteIfOnJsThread(job);
        }

        @Deprecated
        public static int drainPending(JSScheduler jSScheduler) {
            return JSScheduler.super.drainPending();
        }

        @Deprecated
        public static boolean awaitJob(JSScheduler jSScheduler, long j) {
            return JSScheduler.super.awaitJob(j);
        }

        @Deprecated
        public static void close(JSScheduler jSScheduler) {
            JSScheduler.super.close();
        }
    }

    default void postOrExecuteIfOnJsThread(Runnable job) {
        Intrinsics.checkNotNullParameter(job, "job");
        if (isOnJSThread()) {
            job.run();
        } else {
            post(job);
        }
    }
}
