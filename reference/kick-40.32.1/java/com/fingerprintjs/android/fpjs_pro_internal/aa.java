package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class aa {
    public static int component5 = 0;
    public static int component9 = 0;
    private static int setPivotYN16904 = 1;
    private static int vD14832N6715;
    private final z D8871;

    public aa(z zVar) {
        this.D8871 = zVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final D8871<List<y>, Throwable> component5() {
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 107;
        vD14832N6715 = i2 % 128;
        int i3 = i2 % 2;
        D8871 pivotYN16904 = au.setPivotYN16904(CollectionsKt.listOf(I30900.ad.INSTANCE.component5()));
        if (pivotYN16904 instanceof vD14832N6715) {
            int i4 = vD14832N6715;
            int i5 = (i4 & 107) + (i4 | 107);
            setPivotYN16904 = i5 % 128;
            int i6 = i5 % 2;
            return z.setPivotYN16904((String) ((vD14832N6715) pivotYN16904).setPivotYN16904);
        }
        if (!(pivotYN16904 instanceof setPivotYN16904)) {
            throw new NoWhenBranchMatchedException();
        }
        int i7 = vD14832N6715 + 69;
        setPivotYN16904 = i7 % 128;
        if (i7 % 2 == 0) {
            int i8 = 40 / 0;
        }
        return pivotYN16904;
    }

    public static int D8871() {
        int i = component9;
        int i2 = i % 9663459;
        component9 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iMyPid = Process.myPid();
        component5 = iMyPid;
        return iMyPid;
    }
}
