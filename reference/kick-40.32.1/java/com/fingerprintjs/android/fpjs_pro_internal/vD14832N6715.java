package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class vD14832N6715<V> extends D8871 {
    public final V setPivotYN16904;

    public vD14832N6715(V v) {
        super(null);
        this.setPivotYN16904 = v;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Intrinsics.areEqual(this.setPivotYN16904, ((vD14832N6715) obj).setPivotYN16904);
    }

    public final int hashCode() {
        V v = this.setPivotYN16904;
        if (v != null) {
            return v.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Ok(" + this.setPivotYN16904 + ")";
    }
}
