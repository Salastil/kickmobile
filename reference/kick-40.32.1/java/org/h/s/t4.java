package org.h.s;

import android.os.Build;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public abstract class t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeUnit f575a = TimeUnit.MILLISECONDS;

    public static int a(boolean z) {
        return z ? 1 : 0;
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static final String a() {
        return "a-1.21.0";
    }

    public static final String a(String str) {
        return str == null ? "" : str;
    }
}
