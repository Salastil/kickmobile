package org.h.s;

import io.ktor.sse.ServerSentEventKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public abstract class y {
    public static final String a(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(exc, "<this>");
        String simpleName = exc.getClass().getSimpleName();
        String message = exc.getMessage();
        return simpleName + ServerSentEventKt.SPACE + (message != null ? StringsKt.take(message, 50) : null);
    }

    public static final void b(Exception exc, w0 exceptionLog) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(exceptionLog, "exceptionLog");
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(exceptionLog, "exceptionLog");
        s3 s3Var = f1.f506a;
        f1.a(exceptionLog, a(exc));
        throw exc;
    }

    public static final void a(Exception exc, w0 exceptionLog) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(exceptionLog, "exceptionLog");
        s3 s3Var = f1.f506a;
        f1.a(exceptionLog, a(exc));
    }
}
