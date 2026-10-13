package org.h.s;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f498a;
    public final long b;

    public e(long j, long j2) {
        this.f498a = j;
        this.b = j2;
    }

    public final float a() {
        return this.b - this.f498a;
    }

    public final String toString() {
        return "Duration{startMs=" + this.f498a + ", endMs=" + this.b + "}";
    }
}
