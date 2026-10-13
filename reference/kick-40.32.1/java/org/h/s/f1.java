package org.h.s;

import android.content.Context;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s3 f506a = new s3(Dispatchers.getIO(), Dispatchers.getDefault(), new l1(), new y0());

    public static void a(w0 logData, String str) {
        Intrinsics.checkNotNullParameter(logData, "logData");
        int iOrdinal = logData.b.ordinal();
        int i = 2;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                i = 4;
            } else if (iOrdinal == 2) {
                i = 8;
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i = 16;
            }
        }
        LocalLogger.log(i, logData.f584a, str);
        if (a0.f.c) {
            s3 s3Var = f506a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            s3Var.getClass();
            Intrinsics.checkNotNullParameter(logData, "logData");
            y0 y0Var = s3Var.d;
            String str2 = z2.g.f;
            y0Var.getClass();
            x0 severityLevel = y0.a(str2);
            if (severityLevel != null) {
                y0 y0Var2 = s3Var.d;
                x0 logLevel = logData.b;
                y0Var2.getClass();
                Intrinsics.checkNotNullParameter(logLevel, "logLevel");
                Intrinsics.checkNotNullParameter(severityLevel, "severityLevel");
                if (logLevel.ordinal() <= severityLevel.ordinal()) {
                    j3 j3Var = new j3(logData.name(), logData.b, str, jCurrentTimeMillis);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(s3Var.b), new k3(CoroutineExceptionHandler.INSTANCE), null, new l3(s3Var, j3Var, logData, null), 2, null);
                }
            }
        }
    }

    public static void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        s3 s3Var = f506a;
        s3Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(s3Var.f570a), null, null, new m3(context, s3Var, null), 3, null);
    }
}
