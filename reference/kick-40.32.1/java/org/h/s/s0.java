package org.h.s;

import io.mobileshield.sdk.config.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569a;
    public final Method b;

    public s0(Method method, String endpoint) {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(method, "method");
        this.f569a = endpoint;
        this.b = method;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return Intrinsics.areEqual(this.f569a, s0Var.f569a) && this.b == s0Var.b;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f569a.hashCode() * 31);
    }

    public final String toString() {
        return "InternalPath(endpoint=" + this.f569a + ", method=" + this.b + ")";
    }
}
