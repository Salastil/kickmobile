package com.datadog.android.internal.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ThrowableExt.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"loggableStackTrace", "", "", "dd-sdk-android-internal_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThrowableExtKt {
    public static final String loggableStackTrace(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        try {
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(string, "{\n        @Suppress(\"Uns…ngWriter.toString()\n    }");
            return string;
        } catch (Throwable unused) {
            String string2 = stringWriter.toString();
            if (StringsKt.isBlank(string2)) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
                string2 = ThreadExtKt.loggableStackTrace(stackTrace);
            }
            Intrinsics.checkNotNullExpressionValue(string2, "{\n        // printStackT…gableStackTrace() }\n    }");
            return string2;
        }
    }
}
