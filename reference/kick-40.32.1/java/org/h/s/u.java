package org.h.s;

import io.mobileshield.sdk.config.Config;
import java.io.Serializable;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f576a;
    public String b;
    public final m c;
    public final Config d;
    public boolean e;
    public String f;
    public final Integer g;

    public /* synthetic */ u(String str, String str2, m mVar, Config config, boolean z, String str3, int i) {
        this(str, str2, (i & 4) != 0 ? null : mVar, (i & 8) != 0 ? null : config, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str3, (Integer) null);
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final String b() {
        return this.f576a;
    }

    public final boolean c() {
        return this.e;
    }

    public final void d() {
        this.e = false;
    }

    public final void e() {
        long jA = k4.a(this);
        TimeUnit timeUnit = k4.f532a;
        Calendar calendar = Calendar.getInstance();
        switch (t.f571a[timeUnit.ordinal()]) {
            case 1:
                calendar.add(5, (int) jA);
                break;
            case 2:
                calendar.add(10, (int) jA);
                break;
            case 3:
                calendar.add(12, (int) jA);
                break;
            case 4:
                calendar.add(13, (int) jA);
                break;
            case 5:
            case 6:
            case 7:
                calendar.add(13, (int) timeUnit.toSeconds(jA));
                break;
        }
        m mVar = this.c;
        Intrinsics.checkNotNull(mVar);
        mVar.d = calendar.getTimeInMillis();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return Intrinsics.areEqual(this.f576a, uVar.f576a) && Intrinsics.areEqual(this.b, uVar.b) && Intrinsics.areEqual(this.c, uVar.c) && Intrinsics.areEqual(this.d, uVar.d) && this.e == uVar.e && Intrinsics.areEqual(this.f, uVar.f) && Intrinsics.areEqual(this.g, uVar.g);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.f576a.hashCode() * 31)) * 31;
        m mVar = this.c;
        int iHashCode2 = (iHashCode + (mVar == null ? 0 : mVar.hashCode())) * 31;
        Config config = this.d;
        int iHashCode3 = (Boolean.hashCode(this.e) + ((iHashCode2 + (config == null ? 0 : config.hashCode())) * 31)) * 31;
        String str = this.f;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.g;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        return "DomainData{domain='" + this.f576a + "', clientToken=" + this.c + ", userAgent='" + this.b + "', config=" + this.d + ", tokenReady=" + this.e + ", fingerprintURL='" + this.f + "', port=" + this.g + "}";
    }

    public u(String domain, String userAgent, m mVar, Config config, boolean z, String str, Integer num) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        this.f576a = domain;
        this.b = userAgent;
        this.c = mVar;
        this.d = config;
        this.e = z;
        this.f = str;
        this.g = num;
    }

    public final m a() {
        return this.c;
    }

    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f576a = config.getDomain();
        this.f = config.getDomain() + "/149e9513-01fa-4fb0-aad4-566afd725d1b/2d206a39-8ed7-437e-a3be-862e0f06eea3/fp";
    }
}
