package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes6.dex */
public final class ax {
    public static final Long D8871() {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        return (Long) component9.vD14832N6715(bb.setPivotYN16904(objM12684constructorimpl));
    }
}
