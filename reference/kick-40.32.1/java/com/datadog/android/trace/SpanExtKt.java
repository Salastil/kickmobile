package com.datadog.android.trace;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.trace.api.scope.DatadogScope;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.api.tracer.DatadogTracer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpanExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\t¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"withinSpan", ExifInterface.GPS_DIRECTION_TRUE, "operationName", "", "parentSpan", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "activate", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lcom/datadog/android/trace/api/span/DatadogSpan;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "dd-sdk-android-trace_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpanExtKt {
    public static /* synthetic */ Object withinSpan$default(String operationName, DatadogSpan datadogSpan, boolean z, Function1 block, int i, Object obj) {
        if ((i & 2) != 0) {
            datadogSpan = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(block, "block");
        DatadogTracer datadogTracer = GlobalDatadogTracer.get();
        DatadogSpan datadogSpanStart = datadogTracer.buildSpan(operationName).withParentSpan(datadogSpan).start();
        DatadogScope datadogScopeActivateSpan = z ? datadogTracer.activateSpan(datadogSpanStart) : null;
        try {
            Object objInvoke = block.invoke(datadogSpanStart);
            datadogSpanStart.finish();
            if (datadogScopeActivateSpan != null) {
                datadogScopeActivateSpan.close();
            }
            return objInvoke;
        } catch (Throwable th) {
            try {
                datadogSpanStart.logThrowable(th);
                throw th;
            } catch (Throwable th2) {
                datadogSpanStart.finish();
                if (datadogScopeActivateSpan != null) {
                    datadogScopeActivateSpan.close();
                }
                throw th2;
            }
        }
    }

    public static final <T> T withinSpan(String operationName, DatadogSpan datadogSpan, boolean z, Function1<? super DatadogSpan, ? extends T> block) {
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(block, "block");
        DatadogTracer datadogTracer = GlobalDatadogTracer.get();
        DatadogSpan datadogSpanStart = datadogTracer.buildSpan(operationName).withParentSpan(datadogSpan).start();
        DatadogScope datadogScopeActivateSpan = z ? datadogTracer.activateSpan(datadogSpanStart) : null;
        try {
            T tInvoke = block.invoke(datadogSpanStart);
            datadogSpanStart.finish();
            if (datadogScopeActivateSpan != null) {
                datadogScopeActivateSpan.close();
            }
            return tInvoke;
        } catch (Throwable th) {
            try {
                datadogSpanStart.logThrowable(th);
                throw th;
            } catch (Throwable th2) {
                datadogSpanStart.finish();
                if (datadogScopeActivateSpan != null) {
                    datadogScopeActivateSpan.close();
                }
                throw th2;
            }
        }
    }
}
