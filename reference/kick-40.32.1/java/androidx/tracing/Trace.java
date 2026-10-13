package androidx.tracing;

import android.os.Build;
import android.util.Log;
import expo.modules.notifications.service.NotificationsService;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Trace.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0010H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0007H\u0007J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u001c\u0010$\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\n\u0010%\u001a\u00060&j\u0002`'H\u0002J\f\u0010(\u001a\u00020\u0005*\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u00108BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b\u001e\u0010 ¨\u0006)"}, d2 = {"Landroidx/tracing/Trace;", "", "<init>", "()V", "TAG", "", "MAX_TRACE_LABEL_LENGTH", "", "traceTagApp", "", "isTagEnabledMethod", "Ljava/lang/reflect/Method;", "asyncTraceBeginMethod", "asyncTraceEndMethod", "traceCounterMethod", "hasAppTracingEnabled", "", "isEnabled", "forceEnableAppTracing", "", "beginSection", "label", "endSection", "beginAsyncSection", "methodName", "cookie", "endAsyncSection", "setCounter", "counterName", "counterValue", "isEnabledFallback", "isEnabledFallback$annotations", "()Z", "beginAsyncSectionFallback", "endAsyncSectionFallback", "setCounterFallback", "handleException", NotificationsService.EXCEPTION_KEY, "Ljava/lang/Exception;", "Lkotlin/Exception;", "truncatedTraceSectionLabel", "tracing"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Trace {
    public static final Trace INSTANCE = new Trace();
    public static final int MAX_TRACE_LABEL_LENGTH = 127;
    private static final String TAG = "Trace";
    private static Method asyncTraceBeginMethod;
    private static Method asyncTraceEndMethod;
    private static boolean hasAppTracingEnabled;
    private static Method isTagEnabledMethod;
    private static Method traceCounterMethod;
    private static long traceTagApp;

    private static /* synthetic */ void isEnabledFallback$annotations() {
    }

    private Trace() {
    }

    @JvmStatic
    public static final boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return TraceApi29Impl.INSTANCE.isEnabled();
        }
        return INSTANCE.isEnabledFallback();
    }

    @JvmStatic
    public static final void forceEnableAppTracing() throws Throwable {
        if (Build.VERSION.SDK_INT < 31) {
            try {
                if (hasAppTracingEnabled) {
                    return;
                }
                hasAppTracingEnabled = true;
                android.os.Trace.class.getMethod("setAppTracingAllowed", Boolean.TYPE).invoke(null, true);
            } catch (Exception e) {
                INSTANCE.handleException("setAppTracingAllowed", e);
            }
        }
    }

    @JvmStatic
    public static final void beginSection(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        android.os.Trace.beginSection(INSTANCE.truncatedTraceSectionLabel(label));
    }

    @JvmStatic
    public static final void endSection() {
        android.os.Trace.endSection();
    }

    @JvmStatic
    public static final void beginAsyncSection(String methodName, int cookie) throws Throwable {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.INSTANCE.beginAsyncSection(INSTANCE.truncatedTraceSectionLabel(methodName), cookie);
        } else {
            Trace trace = INSTANCE;
            trace.beginAsyncSectionFallback(trace.truncatedTraceSectionLabel(methodName), cookie);
        }
    }

    @JvmStatic
    public static final void endAsyncSection(String methodName, int cookie) throws Throwable {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.INSTANCE.endAsyncSection(INSTANCE.truncatedTraceSectionLabel(methodName), cookie);
        } else {
            Trace trace = INSTANCE;
            trace.endAsyncSectionFallback(trace.truncatedTraceSectionLabel(methodName), cookie);
        }
    }

    @JvmStatic
    public static final void setCounter(String counterName, int counterValue) throws Throwable {
        Intrinsics.checkNotNullParameter(counterName, "counterName");
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.INSTANCE.setCounter(INSTANCE.truncatedTraceSectionLabel(counterName), counterValue);
        } else {
            Trace trace = INSTANCE;
            trace.setCounterFallback(trace.truncatedTraceSectionLabel(counterName), counterValue);
        }
    }

    private final boolean isEnabledFallback() throws Throwable {
        try {
            if (isTagEnabledMethod == null) {
                traceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                isTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            Method method = isTagEnabledMethod;
            if (method == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Object objInvoke = method.invoke(null, Long.valueOf(traceTagApp));
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            handleException("isTagEnabled", e);
            return false;
        }
    }

    private final void beginAsyncSectionFallback(String methodName, int cookie) throws Throwable {
        try {
            if (asyncTraceBeginMethod == null) {
                asyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            Method method = asyncTraceBeginMethod;
            if (method == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            method.invoke(null, Long.valueOf(traceTagApp), methodName, Integer.valueOf(cookie));
        } catch (Exception e) {
            handleException("asyncTraceBegin", e);
        }
    }

    private final void endAsyncSectionFallback(String methodName, int cookie) throws Throwable {
        try {
            if (asyncTraceEndMethod == null) {
                asyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            Method method = asyncTraceEndMethod;
            if (method == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            method.invoke(null, Long.valueOf(traceTagApp), methodName, Integer.valueOf(cookie));
        } catch (Exception e) {
            handleException("asyncTraceEnd", e);
        }
    }

    private final void setCounterFallback(String counterName, int counterValue) throws Throwable {
        try {
            if (traceCounterMethod == null) {
                traceCounterMethod = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            Method method = traceCounterMethod;
            if (method == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            method.invoke(null, Long.valueOf(traceTagApp), counterName, Integer.valueOf(counterValue));
        } catch (Exception e) {
            handleException("traceCounter", e);
        }
    }

    private final void handleException(String methodName, Exception exception) throws Throwable {
        if (exception instanceof InvocationTargetException) {
            Throwable cause = ((InvocationTargetException) exception).getCause();
            if (cause instanceof RuntimeException) {
                throw cause;
            }
            throw new RuntimeException(cause);
        }
        Log.v(TAG, "Unable to call " + methodName + " via reflection", exception);
    }

    private final String truncatedTraceSectionLabel(String str) {
        String str2 = str.length() <= 127 ? str : null;
        if (str2 != null) {
            return str2;
        }
        String strSubstring = str.substring(0, 127);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }
}
