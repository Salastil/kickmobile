package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes6.dex */
public final class N14263A23323<E> implements sG29839<E> {
    public setPivotYN16904<? extends E> vD14832N6715;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.sG29839
    public final <V> V D8871(D8871<? extends V, ? extends E> d8871) throws component5 {
        if (!(d8871 instanceof vD14832N6715)) {
            if (!(d8871 instanceof setPivotYN16904)) {
                throw new NoWhenBranchMatchedException();
            }
            this.vD14832N6715 = (setPivotYN16904) d8871;
            throw component5.INSTANCE;
        }
        return ((vD14832N6715) d8871).setPivotYN16904;
    }
}
