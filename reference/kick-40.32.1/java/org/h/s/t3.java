package org.h.s;

/* JADX INFO: loaded from: classes11.dex */
public final class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f574a;
    public final long b;
    public final long c;

    public t3(int i, long j, long j2) {
        this.f574a = i;
        this.b = j;
        this.c = j2;
    }

    public final long a() {
        return this.c;
    }

    public final String toString() {
        return "Parameter{totalAttempts=" + this.f574a + ", timeOutMs=" + this.b + ", nextDelayMs=" + this.c + ", multiplier=0.0}";
    }
}
