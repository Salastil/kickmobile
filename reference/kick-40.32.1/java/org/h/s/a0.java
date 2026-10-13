package org.h.s;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'g' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes11.dex */
public final class a0 {
    public static final z d;
    public static final a0 e;
    public static final a0 f;
    public static final a0 g;
    public static final a0 h;
    public static final a0 i;
    public static final a0 j;
    public static final a0 k;
    public static final a0 l;
    public static final /* synthetic */ a0[] m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486a;
    public final boolean b;
    public boolean c;

    /* JADX INFO: Fake field, exist only in values array */
    a0 EF0;

    static {
        a0 a0Var = new a0(0, 6, "MobileTestFlag", "sentinel.mobile.test-flag", false);
        a0 a0Var2 = new a0(1, 4, "PerformanceMetricsFlag", "sentinel.android.performance-metrics", true);
        e = a0Var2;
        a0 a0Var3 = new a0(2, 4, "RemoteLogFlag", "sentinel.android.remote-logging", true);
        f = a0Var3;
        int i2 = 4;
        a0 a0Var4 = new a0(3, i2, "OkhttpListenerFlag", "sentinel.android.okhttp-listener", true);
        g = a0Var4;
        a0 a0Var5 = new a0(i2, 4, "NetworkCheckOnResumeFlag", "sentinel.android.network-check-on-resume", true);
        h = a0Var5;
        a0 a0Var6 = new a0(5, 4, "PersistentLogsFlag", "sentinel.android.persistent-logs", false);
        i = a0Var6;
        a0 a0Var7 = new a0(6, "CheckNetworkBeforeInterrogating", "sentinel.android.check-network-on-interrogation", true, true);
        j = a0Var7;
        a0 a0Var8 = new a0(7, "OkhttpResumeOnIntercept", "sentinel.android.okhttp-resume-on-intercept", true, true);
        k = a0Var8;
        a0 a0Var9 = new a0(8, "OkhttpResumeWhenPaused", "sentinel.android.okhttp-resume-when-paused", true, true);
        l = a0Var9;
        a0[] a0VarArr = {a0Var, a0Var2, a0Var3, a0Var4, a0Var5, a0Var6, a0Var7, a0Var8, a0Var9};
        m = a0VarArr;
        EnumEntriesKt.enumEntries(a0VarArr);
        d = new z();
    }

    public /* synthetic */ a0(int i2, int i3, String str, String str2, boolean z) {
        this(i2, str, str2, (i3 & 2) != 0 ? false : z, false);
    }

    public static a0 valueOf(String str) {
        return (a0) Enum.valueOf(a0.class, str);
    }

    public static a0[] values() {
        return (a0[]) m.clone();
    }

    public final String a() {
        return this.f486a;
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        return this.b;
    }

    public a0(int i2, String str, String str2, boolean z, boolean z2) {
        super(str, i2);
        this.f486a = str2;
        this.b = z;
        this.c = z2;
    }

    public final void a(boolean z) {
        this.c = z;
    }
}
