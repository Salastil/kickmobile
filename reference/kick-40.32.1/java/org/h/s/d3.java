package org.h.s;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class d3 extends e3 {
    public final String e;
    public String f;

    public /* synthetic */ d3(String str, String str2, int i) {
        this(str, str2);
    }

    public final String a() {
        return this.e;
    }

    public final String b() {
        return this.f;
    }

    public d3(String str, String str2) {
        super(str2, 0);
        this.e = str;
        this.f = str2;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }
}
