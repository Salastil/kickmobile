package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class setPivotYN16904<E> extends D8871 {
    public final E setPivotYN16904;

    public setPivotYN16904(E e) {
        super(null);
        this.setPivotYN16904 = e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Intrinsics.areEqual(this.setPivotYN16904, ((setPivotYN16904) obj).setPivotYN16904);
    }

    public final int hashCode() {
        E e = this.setPivotYN16904;
        if (e != null) {
            return e.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Err(" + this.setPivotYN16904 + ")";
    }
}
