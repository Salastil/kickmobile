package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class bb {
    public static final <T> D8871<T, Throwable> setPivotYN16904(Object obj) {
        if (Result.m12691isSuccessimpl(obj)) {
            ResultKt.throwOnFailure(obj);
            return new vD14832N6715(obj);
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(obj);
        Intrinsics.checkNotNull(thM12687exceptionOrNullimpl);
        return new setPivotYN16904(thM12687exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <V, E> D8871<V, E> component9(D8871<? extends D8871<? extends V, ? extends E>, ? extends E> d8871) {
        if (d8871 instanceof vD14832N6715) {
            return (D8871) ((vD14832N6715) d8871).setPivotYN16904;
        }
        if (d8871 instanceof setPivotYN16904) {
            return d8871;
        }
        throw new NoWhenBranchMatchedException();
    }
}
