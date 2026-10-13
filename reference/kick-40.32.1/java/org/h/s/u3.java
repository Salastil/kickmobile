package org.h.s;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a4 f579a;
    public final int b;

    public u3(a4 state, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.f579a = state;
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    public final a4 b() {
        return this.f579a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u3)) {
            return false;
        }
        u3 u3Var = (u3) obj;
        return this.f579a == u3Var.f579a && this.b == u3Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f579a.hashCode() * 31);
    }

    public final String toString() {
        return "SdkState(state=" + this.f579a + ", errorCode=" + this.b + ")";
    }
}
