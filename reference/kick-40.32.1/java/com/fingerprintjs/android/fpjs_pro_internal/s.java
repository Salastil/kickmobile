package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import androidx.compose.runtime.GapComposerKt;

/* JADX INFO: loaded from: classes6.dex */
public final class s extends f<Long> {
    public static int D8871 = 0;
    public static int component9 = 0;
    private static int setPivotYN16904 = 1;
    private static int vD14832N6715;
    private final long component5;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ Long setPivotYN16904() {
        int i = 2 % 2;
        int i2 = vD14832N6715 + 63;
        setPivotYN16904 = i2 % 128;
        int i3 = i2 % 2;
        Long lComponent5 = component5();
        int i4 = vD14832N6715 + GapComposerKt.nodeKey;
        setPivotYN16904 = i4 % 128;
        if (i4 % 2 != 0) {
            return lComponent5;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private Long component5() {
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = ((i2 | 29) << 1) - (i2 ^ 29);
        vD14832N6715 = i3 % 128;
        int i4 = i3 % 2;
        Long lValueOf = Long.valueOf(this.component5);
        int i5 = vD14832N6715 + 41;
        setPivotYN16904 = i5 % 128;
        if (i5 % 2 != 0) {
            return lValueOf;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public s(long j) {
        super(null);
        this.component5 = j;
    }

    public static int vD14832N6715() {
        int i = D8871;
        int i2 = i % 6243387;
        D8871 = i + 1;
        if (i2 != 0) {
            return component9;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        component9 = elapsedCpuTime;
        return elapsedCpuTime;
    }
}
