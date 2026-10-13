package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class oD4563 {
    private static int D8871 = 0;
    public static int component5 = 0;
    public static int component9 = 0;
    private static int setPivotYN16904 = 1;

    public static final /* synthetic */ int component5(ac acVar) {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = (i2 & 5) + (i2 | 5);
        setPivotYN16904 = i3 % 128;
        Object obj = null;
        if (i3 % 2 == 0) {
            vD14832N6715(acVar);
            obj.hashCode();
            throw null;
        }
        int iVD14832N6715 = vD14832N6715(acVar);
        int i4 = setPivotYN16904 + 113;
        D8871 = i4 % 128;
        if (i4 % 2 == 0) {
            return iVD14832N6715;
        }
        throw null;
    }

    private static final int vD14832N6715(ac acVar) {
        int i = 2 % 2;
        if (Intrinsics.areEqual(acVar, ac.component13.INSTANCE)) {
            int i2 = setPivotYN16904 + 71;
            int i3 = i2 % 128;
            D8871 = i3;
            int i4 = i2 % 2;
            int i5 = i3 + 113;
            setPivotYN16904 = i5 % 128;
            int i6 = i5 % 2;
            return 0;
        }
        if (Intrinsics.areEqual(acVar, ac.component5.INSTANCE)) {
            return 1;
        }
        if (Intrinsics.areEqual(acVar, ac.vD14832N6715.INSTANCE)) {
            int i7 = D8871;
            int i8 = (i7 & 27) + (i7 | 27);
            int i9 = i8 % 128;
            setPivotYN16904 = i9;
            int i10 = i8 % 2;
            int i11 = (i9 & 31) + (i9 | 31);
            D8871 = i11 % 128;
            if (i11 % 2 == 0) {
                return 2;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        if (Intrinsics.areEqual(acVar, ac.setPivotYN16904.INSTANCE)) {
            int i12 = setPivotYN16904 + 75;
            D8871 = i12 % 128;
            return i12 % 2 != 0 ? 4 : 3;
        }
        if (Intrinsics.areEqual(acVar, ac.component8.INSTANCE)) {
            int i13 = setPivotYN16904;
            int i14 = ((i13 | 43) << 1) - (i13 ^ 43);
            D8871 = i14 % 128;
            int i15 = i14 % 2;
            return 4;
        }
        if (!Intrinsics.areEqual(acVar, ac.D8871.INSTANCE)) {
            if (Intrinsics.areEqual(acVar, ac.component9.INSTANCE)) {
                return 6;
            }
            throw new NoWhenBranchMatchedException();
        }
        int i16 = setPivotYN16904 + 45;
        D8871 = i16 % 128;
        int i17 = i16 % 2;
        return 5;
    }

    public static int vD14832N6715() {
        int i = component9;
        int i2 = i % 9207316;
        component9 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iMyTid = Process.myTid();
        component5 = iMyTid;
        return iMyTid;
    }
}
