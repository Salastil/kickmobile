package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
public final class ay {
    public static final String setPivotYN16904(Throwable th) {
        Object objM12684constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(th.getStackTrace());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th2));
        }
        Object[] objArr = (Object[]) component9.component9(bb.setPivotYN16904(objM12684constructorimpl), null);
        if (objArr == null) {
            objArr = new StackTraceElement[0];
        }
        return CollectionsKt.joinToString$default(ArraysKt.filterNotNull(objArr), "\n", null, null, 0, null, new Function1<StackTraceElement, CharSequence>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.ay.4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: vD14832N6715, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(StackTraceElement stackTraceElement) {
                return stackTraceElement.toString();
            }
        }, 30, null);
    }
}
