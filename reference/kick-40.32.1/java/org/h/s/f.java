package org.h.s;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f {
    public long c;
    public long d;
    public long e;
    public long f;
    public e g;
    public List b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f504a = "";

    public final String a() {
        String string = Long.toString(this.c);
        String str = this.f504a;
        List list = this.b;
        String string2 = Long.toString(this.d);
        String string3 = Long.toString(this.e);
        String string4 = Long.toString(this.f);
        e eVar = this.g;
        Intrinsics.checkNotNull(eVar);
        return "{\"workTime\":" + string + ",\"id\":\"" + str + "\",\"answers\":" + list + ",\"d\":" + string2 + ",\"rst\":" + string3 + ",\"st\":" + string4 + ",\"duration\":" + Float.toString(eVar.a()) + "}";
    }
}
