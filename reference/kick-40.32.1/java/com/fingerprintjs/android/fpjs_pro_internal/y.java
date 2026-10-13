package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class y {
    private static int D8871 = 0;
    private static int component13 = 1;
    public static int component5;
    public static int component9;
    private final String setPivotYN16904;
    private final String vD14832N6715;

    public static /* synthetic */ Object component5(Object[] objArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = ~i6;
        int i8 = ~i3;
        int i9 = (~(i7 | i8)) | i;
        int i10 = i3 | i7;
        int i11 = (~(i3 | i)) | (~(i7 | (~i) | i8)) | (~(i | i6));
        int i12 = i + i6 + i5 + (764943627 * i2) + (189947931 * i4);
        int i13 = i12 * i12;
        int i14 = ((i * (-973936384)) - 801505280) + ((-973936384) * i6) + (1838296578 * i9) + (1228335359 * i10) + ((-1228335359) * i11) + (2092695552 * i5) + ((-1475084288) * i2) + ((-1479278592) * i4) + ((-626393088) * i13);
        int i15 = (i * 1860537600) + 224780607 + (i6 * 1860537600) + (i9 * 1034) + (i10 * (-517)) + (i11 * 517) + (i5 * 1860538117) + (i2 * (-1861700041)) + (i4 * (-831392377)) + (i13 * 995229696);
        return i14 + ((i15 * i15) * 1053163520) != 1 ? D8871(objArr) : component5(objArr);
    }

    public y(String str, String str2) {
        this.setPivotYN16904 = str;
        this.vD14832N6715 = str2;
    }

    public final String D8871() {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = i2 + 79;
        component13 = i3 % 128;
        int i4 = i3 % 2;
        String str = this.setPivotYN16904;
        int i5 = (i2 & 93) + (i2 | 93);
        component13 = i5 % 128;
        int i6 = i5 % 2;
        return str;
    }

    private static /* synthetic */ Object D8871(Object[] objArr) {
        y yVar = (y) objArr[0];
        int i = 2 % 2;
        int i2 = component13 + 69;
        D8871 = i2 % 128;
        int i3 = i2 % 2;
        String str = yVar.vD14832N6715;
        if (i3 == 0) {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final String toString() {
        int i = 2 % 2;
        int i2 = component13;
        int i3 = (i2 ^ 73) + ((i2 & 73) << 1);
        D8871 = i3 % 128;
        if (i3 % 2 == 0) {
            return "";
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object component5(Object[] objArr) {
        y yVar = (y) objArr[0];
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = ((i2 | 97) << 1) - (i2 ^ 97);
        component13 = i3 % 128;
        int i4 = i3 % 2;
        int iHashCode = yVar.setPivotYN16904.hashCode();
        int iHashCode2 = i4 == 0 ? ((iHashCode ^ (-54)) + ((iHashCode & (-54)) << 1)) * yVar.vD14832N6715.hashCode() : (iHashCode * 31) + yVar.vD14832N6715.hashCode();
        int i5 = D8871;
        int i6 = (i5 & 5) + (i5 | 5);
        component13 = i6 % 128;
        if (i6 % 2 != 0) {
            return Integer.valueOf(iHashCode2);
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public static int setPivotYN16904() {
        int i = component5;
        int i2 = i % 6324615;
        component5 = i + 1;
        if (i2 != 0) {
            return component9;
        }
        int elapsedCpuTime = (int) Process.getElapsedCpuTime();
        component9 = elapsedCpuTime;
        return elapsedCpuTime;
    }

    public final boolean equals(Object obj) {
        int i;
        int i2 = 2 % 2;
        if (this == obj) {
            int i3 = D8871;
            int i4 = (i3 ^ 49) + ((i3 & 49) << 1);
            component13 = i4 % 128;
            return i4 % 2 != 0;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (!Intrinsics.areEqual(this.setPivotYN16904, yVar.setPivotYN16904)) {
                wX26196.component8();
                System.identityHashCode(this);
                i = component13 + 47;
            } else {
                if (Intrinsics.areEqual(this.vD14832N6715, yVar.vD14832N6715)) {
                    int i5 = component13;
                    int i6 = (i5 & 9) + (i5 | 9);
                    D8871 = i6 % 128;
                    if (i6 % 2 == 0) {
                        return true;
                    }
                    Object obj2 = null;
                    obj2.hashCode();
                    throw null;
                }
                i = D8871 + 59;
                component13 = i % 128;
            }
            int i7 = i % 2;
            return false;
        }
        i = component13 + 15;
        D8871 = i % 128;
        int i8 = i % 2;
        return false;
    }

    public final int hashCode() {
        return ((Integer) component5(new Object[]{this}, 1217341668, wX26196.component8(), wX26196.component8(), wX26196.component8(), wX26196.component8(), -1217341667)).intValue();
    }

    public final String component9() {
        return (String) component5(new Object[]{this}, 1948914066, wX26196.component8(), wX26196.component8(), wX26196.component8(), wX26196.component8(), -1948914066);
    }
}
