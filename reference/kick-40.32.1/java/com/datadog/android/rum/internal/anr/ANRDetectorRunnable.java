package com.datadog.android.rum.internal.anr;

import android.os.Handler;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.internal.utils.ThreadExtKt;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ANRDetectorRunnable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0010H\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable;", "Ljava/lang/Runnable;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "handler", "Landroid/os/Handler;", "anrThresholdMs", "", "anrTestDelayMs", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Landroid/os/Handler;JJ)V", "shouldStop", "", "reportAnr", "", "run", "safeGetAllStacktraces", "", "Ljava/lang/Thread;", "", "Ljava/lang/StackTraceElement;", "stop", "waitForAnrResolution", "callbackDone", "Ljava/util/concurrent/CountDownLatch;", "CallbackRunnable", "Companion", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ANRDetectorRunnable implements Runnable {
    public static final String ANR_MESSAGE = "Application Not Responding";
    private static final long ANR_TEST_DELAY_MS = 500;
    public static final long ANR_THRESHOLD_MS = 5000;
    private final long anrTestDelayMs;
    private final long anrThresholdMs;
    private final Handler handler;
    private final FeatureSdkCore sdkCore;
    private volatile boolean shouldStop;

    public ANRDetectorRunnable(FeatureSdkCore sdkCore, Handler handler, long j, long j2) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.sdkCore = sdkCore;
        this.handler = handler;
        this.anrThresholdMs = j;
        this.anrTestDelayMs = j2;
    }

    public /* synthetic */ ANRDetectorRunnable(FeatureSdkCore featureSdkCore, Handler handler, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, handler, (i & 4) != 0 ? 5000L : j, (i & 8) != 0 ? 500L : j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!Thread.currentThread().isInterrupted() && !this.shouldStop) {
            try {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                if (!this.handler.post(new CallbackRunnable(countDownLatch))) {
                    return;
                }
                if (!countDownLatch.await(this.anrThresholdMs, TimeUnit.MILLISECONDS)) {
                    reportAnr();
                    waitForAnrResolution(countDownLatch);
                }
                long j = this.anrTestDelayMs;
                if (j > 0) {
                    Thread.sleep(j);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public final void stop() {
        this.shouldStop = true;
    }

    private final void reportAnr() {
        Thread thread = this.handler.getLooper().getThread();
        Intrinsics.checkNotNullExpressionValue(thread, "handler.looper.thread");
        ANRException aNRException = new ANRException(thread);
        String name = thread.getName();
        Intrinsics.checkNotNullExpressionValue(name, "anrThread.name");
        Thread.State state = thread.getState();
        Intrinsics.checkNotNullExpressionValue(state, "anrThread.state");
        ANRException aNRException2 = aNRException;
        List listMutableListOf = CollectionsKt.mutableListOf(new ThreadDump(name, ThreadExtKt.asString(state), ThrowableExtKt.loggableStackTrace(aNRException2), false));
        Map<Thread, StackTraceElement[]> mapSafeGetAllStacktraces = safeGetAllStacktraces();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Thread, StackTraceElement[]> entry : mapSafeGetAllStacktraces.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), thread)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (!(((StackTraceElement[]) entry2.getValue()).length == 0)) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        LinkedHashMap linkedHashMap3 = linkedHashMap2;
        ArrayList arrayList = new ArrayList(linkedHashMap3.size());
        Iterator it = linkedHashMap3.entrySet().iterator();
        while (it.hasNext()) {
            Thread thread2 = (Thread) ((Map.Entry) it.next()).getKey();
            String name2 = thread2.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "thread.name");
            Thread.State state2 = thread2.getState();
            Intrinsics.checkNotNullExpressionValue(state2, "thread.state");
            String strAsString = ThreadExtKt.asString(state2);
            StackTraceElement[] stackTrace = thread2.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "thread.stackTrace");
            arrayList.add(new ThreadDump(name2, strAsString, ThreadExtKt.loggableStackTrace(stackTrace), false));
        }
        GlobalRumMonitor.get(this.sdkCore).addError(ANR_MESSAGE, RumErrorSource.SOURCE, aNRException2, MapsKt.mapOf(TuplesKt.to(RumAttributes.INTERNAL_ALL_THREADS, CollectionsKt.plus((Collection) listMutableListOf, (Iterable) arrayList))));
    }

    private final void waitForAnrResolution(CountDownLatch callbackDone) {
        try {
            callbackDone.await();
        } catch (InterruptedException e) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.anr.ANRDetectorRunnable.waitForAnrResolution.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Interrupted while waiting for ANR resolution.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            try {
                Thread.currentThread().interrupt();
            } catch (SecurityException e2) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.anr.ANRDetectorRunnable.waitForAnrResolution.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to restore interrupted state during ANR resolution.";
                    }
                }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            }
        }
    }

    private final Map<Thread, StackTraceElement[]> safeGetAllStacktraces() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Intrinsics.checkNotNullExpressionValue(allStackTraces, "{\n            Thread.getAllStackTraces()\n        }");
            return allStackTraces;
        } catch (Throwable th) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.rum.internal.anr.ANRDetectorRunnable.safeGetAllStacktraces.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to get all stack traces.";
                }
            }, th, false, (Map) null, 48, (Object) null);
            return MapsKt.emptyMap();
        }
    }

    /* JADX INFO: compiled from: ANRDetectorRunnable.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable$CallbackRunnable;", "Ljava/lang/Runnable;", "callbackDone", "Ljava/util/concurrent/CountDownLatch;", "(Ljava/util/concurrent/CountDownLatch;)V", "run", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CallbackRunnable implements Runnable {
        private final CountDownLatch callbackDone;

        public CallbackRunnable(CountDownLatch callbackDone) {
            Intrinsics.checkNotNullParameter(callbackDone, "callbackDone");
            this.callbackDone = callbackDone;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.callbackDone.countDown();
        }
    }
}
