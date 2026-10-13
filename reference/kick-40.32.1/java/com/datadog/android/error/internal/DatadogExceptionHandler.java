package com.datadog.android.error.internal;

import android.content.Context;
import androidx.work.WorkManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.feature.event.JvmCrash;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.core.internal.thread.ThreadPoolExecutorExtKt;
import com.datadog.android.core.internal.utils.WorkManagerUtilsKt;
import com.datadog.android.internal.utils.ThreadExtKt;
import com.datadog.android.internal.utils.ThrowableExtKt;
import com.datadog.android.rum.internal.RumFeature;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DatadogExceptionHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018H\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/datadog/android/error/internal/DatadogExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "sdkCore", "Lcom/datadog/android/api/feature/FeatureSdkCore;", "appContext", "Landroid/content/Context;", "(Lcom/datadog/android/api/feature/FeatureSdkCore;Landroid/content/Context;)V", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "previousHandler", "createCrashMessage", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "getThreadDumps", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "crashedThread", "Ljava/lang/Thread;", "e", "register", "", "safeGetAllStacktraces", "", "", "Ljava/lang/StackTraceElement;", "uncaughtException", "t", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static final String EXECUTOR_NOT_IDLED_WARNING_MESSAGE = "Datadog SDK is in an unexpected state due to an ongoing crash. Some events could be lost.";
    public static final long MAX_WAIT_FOR_IDLE_TIME_IN_MS = 100;
    public static final String MESSAGE = "Application crash detected";
    public static final String MISSING_RUM_FEATURE_INFO = "RUM feature is not registered, won't report crash as RUM event.";
    private final WeakReference<Context> contextRef;
    private Thread.UncaughtExceptionHandler previousHandler;
    private final FeatureSdkCore sdkCore;

    public DatadogExceptionHandler(FeatureSdkCore sdkCore, Context appContext) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.sdkCore = sdkCore;
        this.contextRef = new WeakReference<>(appContext);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread t, Throwable e) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(e, "e");
        List<ThreadDump> threadDumps = getThreadDumps(t, e);
        FeatureScope feature = this.sdkCore.getFeature("rum");
        if (feature != null) {
            feature.sendEvent(new JvmCrash.Rum(e, createCrashMessage(e), threadDumps));
        } else {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.error.internal.DatadogExceptionHandler.uncaughtException.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return DatadogExceptionHandler.MISSING_RUM_FEATURE_INFO;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        FeatureSdkCore featureSdkCore = this.sdkCore;
        if (featureSdkCore instanceof InternalSdkCore) {
            ExecutorService persistenceExecutorService = ((InternalSdkCore) featureSdkCore).getPersistenceExecutorService();
            ThreadPoolExecutor threadPoolExecutor = persistenceExecutorService instanceof ThreadPoolExecutor ? (ThreadPoolExecutor) persistenceExecutorService : null;
            if (!(threadPoolExecutor != null ? ThreadPoolExecutorExtKt.waitToIdle(threadPoolExecutor, 100L, this.sdkCore.getInternalLogger(), this.sdkCore.getTimeProvider()) : true)) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.error.internal.DatadogExceptionHandler.uncaughtException.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return DatadogExceptionHandler.EXECUTOR_NOT_IDLED_WARNING_MESSAGE;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        }
        Context context = this.contextRef.get();
        if (context != null && WorkManager.isInitialized()) {
            WorkManagerUtilsKt.triggerUploadWorker(context, this.sdkCore.getName(), this.sdkCore.getInternalLogger());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t, e);
        }
    }

    public final void register() {
        this.previousHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private final String createCrashMessage(Throwable throwable) {
        String message = throwable.getMessage();
        String str = message;
        if (str != null && !StringsKt.isBlank(str)) {
            return message;
        }
        String canonicalName = throwable.getClass().getCanonicalName();
        if (canonicalName == null) {
            canonicalName = throwable.getClass().getSimpleName();
        }
        return "Application crash detected: " + canonicalName;
    }

    private final List<ThreadDump> getThreadDumps(Thread crashedThread, Throwable e) {
        String name = crashedThread.getName();
        Thread.State state = crashedThread.getState();
        Intrinsics.checkNotNullExpressionValue(state, "crashedThread.state");
        String strAsString = ThreadExtKt.asString(state);
        String strLoggableStackTrace = ThrowableExtKt.loggableStackTrace(e);
        Intrinsics.checkNotNullExpressionValue(name, "name");
        List listMutableListOf = CollectionsKt.mutableListOf(new ThreadDump(name, strAsString, strLoggableStackTrace, true));
        Map<Thread, StackTraceElement[]> mapSafeGetAllStacktraces = safeGetAllStacktraces();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Thread, StackTraceElement[]> entry : mapSafeGetAllStacktraces.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), crashedThread)) {
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
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            Thread thread = (Thread) entry3.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry3.getValue();
            String name2 = thread.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "thread.name");
            Thread.State state2 = thread.getState();
            Intrinsics.checkNotNullExpressionValue(state2, "thread.state");
            arrayList.add(new ThreadDump(name2, ThreadExtKt.asString(state2), ThreadExtKt.loggableStackTrace(stackTraceElementArr), false));
        }
        return CollectionsKt.plus((Collection) listMutableListOf, (Iterable) arrayList);
    }

    private final Map<Thread, StackTraceElement[]> safeGetAllStacktraces() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Intrinsics.checkNotNullExpressionValue(allStackTraces, "{\n            Thread.getAllStackTraces()\n        }");
            return allStackTraces;
        } catch (Throwable th) {
            InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.error.internal.DatadogExceptionHandler.safeGetAllStacktraces.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to get all threads dump";
                }
            }, th, false, (Map) null, 48, (Object) null);
            return MapsKt.emptyMap();
        }
    }
}
