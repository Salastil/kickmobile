package org.h.s;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f595a;
    public final long b;
    public String c;

    public z3(String label, long j, z1 z1Var) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.f595a = label;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z3)) {
            return false;
        }
        z3 z3Var = (z3) obj;
        return Intrinsics.areEqual(this.f595a, z3Var.f595a) && this.b == z3Var.b && Intrinsics.areEqual((Object) null, (Object) null);
    }

    public final int hashCode() {
        return (Long.hashCode(this.b) + (this.f595a.hashCode() * 31)) * 31;
    }

    public final String toString() {
        return "Span(label=" + this.f595a + ", durationMs=" + this.b + ", metadata=null)";
    }
}
