package org.h.s;

import android.content.Context;
import android.content.SharedPreferences;
import io.mobileshield.sdk.logger.LocalLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public abstract class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineDispatcher f538a = Dispatchers.getIO();

    public static void a(Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("flagsAndConfigSP", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        boolean z = false;
        for (a0 a0Var : a0.values()) {
            if (a0Var.c() && !sharedPreferences.contains(a0Var.a())) {
                z = true;
            }
            a0Var.a(sharedPreferences.getBoolean(a0Var.a(), a0Var.b()));
        }
        w2 w2Var = e3.b;
        for (x2 x2Var : w2.a()) {
            if (!sharedPreferences.contains(x2Var.a())) {
                z = true;
            }
            x2Var.a(sharedPreferences.getInt(x2Var.a(), x2Var.b().intValue()));
        }
        w2 w2Var2 = e3.b;
        for (d3 d3Var : w2.b()) {
            if (!sharedPreferences.contains(d3Var.a())) {
                z = true;
            }
            String string2 = sharedPreferences.getString(d3Var.a(), d3Var.b());
            if (string2 == null) {
                string2 = d3Var.b();
            } else {
                Intrinsics.checkNotNull(string2);
            }
            d3Var.a(string2);
        }
        String str = g0.f510a;
        String str2 = "01";
        if (!z && (string = sharedPreferences.getString("hashValue", "01")) != null) {
            str2 = string;
        }
        g0.a(str2);
        LocalLogger.log(16, 12000L, a0.d + "\n" + e3.b);
    }
}
