package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.imageutils.TiffUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class kP9958 {
    private static int component9 = 1;
    private static int setPivotYN16904;

    public static /* synthetic */ Object setPivotYN16904(int i, int i2, int i3, int i4, int i5, Object[] objArr, int i6) {
        int i7 = ~i5;
        int i8 = i7 | i3;
        int i9 = (~i8) | (~(i7 | i2));
        int i10 = (~((~i2) | i7 | (~i3))) | (~(i5 | i3));
        int i11 = i5 + i3 + i + ((-540997959) * i4) + (162607451 * i6);
        int i12 = i11 * i11;
        int i13 = ((-612843245) * i5) + 1723858944 + (1667710703 * i3) + (i9 * (-1007206674)) + (1007206674 * i8) + ((-1007206674) * i10) + ((-1620049920) * i) + ((-672137216) * i4) + (483393536 * i6) + (377683968 * i12);
        int i14 = (i5 * 228155117) + 240245784 + (i3 * 228155665) + (i9 * TiffUtil.TIFF_TAG_ORIENTATION) + (i8 * (-274)) + (i10 * TiffUtil.TIFF_TAG_ORIENTATION) + (i * 228155391) + (i4 * (-329950905)) + (i6 * (-2026639707)) + (i12 * 159186944);
        if (i13 + (i14 * i14 * (-1451425792)) != 1) {
            return vD14832N6715(objArr);
        }
        List list = (List) objArr[0];
        int i15 = 2 % 2;
        int i16 = component9 + 11;
        setPivotYN16904 = i16 % 128;
        int i17 = i16 % 2;
        int iComponent9 = component9(list);
        int i18 = component9;
        int i19 = (i18 ^ 91) + ((i18 & 91) << 1);
        setPivotYN16904 = i19 % 128;
        int i20 = i19 % 2;
        return Integer.valueOf(iComponent9);
    }

    private static /* synthetic */ Object vD14832N6715(Object[] objArr) {
        List list = (List) objArr[0];
        int i = 2 % 2;
        int i2 = component9;
        int i3 = (i2 ^ 33) + ((i2 & 33) << 1);
        setPivotYN16904 = i3 % 128;
        int i4 = i3 % 2;
        long jVD14832N6715 = vD14832N6715((List<K5264>) list);
        int i5 = setPivotYN16904;
        int i6 = ((i5 | 91) << 1) - (i5 ^ 91);
        component9 = i6 % 128;
        if (i6 % 2 != 0) {
            return Long.valueOf(jVD14832N6715);
        }
        throw null;
    }

    private static final long vD14832N6715(List<K5264> list) {
        Object next;
        long jLongValue;
        int i = 2 % 2;
        Iterator<T> it = list.iterator();
        Long lValueOf = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                Long l = ((K5264) next).N14263A23323;
                long jLongValue2 = l != null ? l.longValue() : 0L;
                do {
                    Object next2 = it.next();
                    Long l2 = ((K5264) next2).N14263A23323;
                    if (l2 != null) {
                        int i2 = setPivotYN16904 + 61;
                        component9 = i2 % 128;
                        if (i2 % 2 == 0) {
                            l2.longValue();
                            throw null;
                        }
                        jLongValue = l2.longValue();
                    } else {
                        jLongValue = 0;
                    }
                    if (jLongValue2 < jLongValue) {
                        int i3 = component9;
                        int i4 = (i3 ^ 11) + ((i3 & 11) << 1);
                        setPivotYN16904 = i4 % 128;
                        int i5 = i4 % 2;
                        next = next2;
                        jLongValue2 = jLongValue;
                    }
                } while (it.hasNext());
                int i6 = component9;
                int i7 = (i6 & 71) + (i6 | 71);
                setPivotYN16904 = i7 % 128;
                if (i7 % 2 != 0) {
                    lValueOf.hashCode();
                    throw null;
                }
            } else {
                int i8 = component9;
                int i9 = ((i8 | 97) << 1) - (i8 ^ 97);
                setPivotYN16904 = i9 % 128;
                if (i9 % 2 != 0) {
                    int i10 = 5 % 4;
                }
            }
        } else {
            int i11 = component9;
            int i12 = (i11 ^ 47) + ((i11 & 47) << 1);
            setPivotYN16904 = i12 % 128;
            if (i12 % 2 != 0) {
                int i13 = 51 / 0;
            }
            next = null;
        }
        K5264 k5264 = (K5264) next;
        if (k5264 != null) {
            int i14 = component9 + 119;
            setPivotYN16904 = i14 % 128;
            if (i14 % 2 != 0) {
                Long l3 = k5264.N14263A23323;
                throw null;
            }
            Long l4 = k5264.N14263A23323;
            if (l4 != null) {
                long jLongValue3 = l4.longValue();
                Long l5 = k5264.setTopP6481;
                if (l5 != null) {
                    int i15 = setPivotYN16904;
                    int i16 = ((i15 | 53) << 1) - (i15 ^ 53);
                    component9 = i16 % 128;
                    int i17 = i16 % 2;
                    lValueOf = Long.valueOf(jLongValue3 - l5.longValue());
                    int i18 = setPivotYN16904;
                    int i19 = (i18 & 77) + (i18 | 77);
                    component9 = i19 % 128;
                    int i20 = i19 % 2;
                } else {
                    int i21 = setPivotYN16904;
                    int i22 = (i21 & 19) + (i21 | 19);
                    component9 = i22 % 128;
                    int i23 = i22 % 2;
                }
            }
            if (lValueOf != null) {
                int i24 = setPivotYN16904;
                int i25 = (i24 & 35) + (i24 | 35);
                component9 = i25 % 128;
                int i26 = i25 % 2;
                return lValueOf.longValue();
            }
        }
        return 0L;
    }

    private static final int component9(List<K5264> list) {
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 111;
        int i3 = i2 % 128;
        component9 = i3;
        int i4 = i2 % 2;
        List<K5264> list2 = list;
        int i5 = 0;
        if (list2 instanceof Collection) {
            int i6 = ((i3 | 13) << 1) - (i3 ^ 13);
            setPivotYN16904 = i6 % 128;
            if (i6 % 2 != 0) {
                list2.isEmpty();
                throw null;
            }
            if (list2.isEmpty()) {
                return 0;
            }
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            int i7 = setPivotYN16904;
            int i8 = ((i7 | 35) << 1) - (i7 ^ 35);
            component9 = i8 % 128;
            if (i8 % 2 == 0) {
                String str = ((K5264) it.next()).component9;
                throw null;
            }
            if (((K5264) it.next()).component9 != null) {
                int i9 = setPivotYN16904;
                int i10 = (i9 & 103) + (i9 | 103);
                component9 = i10 % 128;
                int i11 = i10 % 2;
                i5 = (i5 & 1) + (i5 | 1);
                if (i5 < 0) {
                    CollectionsKt.throwCountOverflow();
                    int i12 = setPivotYN16904;
                    int i13 = (i12 & 43) + (i12 | 43);
                    component9 = i13 % 128;
                    int i14 = i13 % 2;
                }
            } else {
                int i15 = setPivotYN16904 + 111;
                component9 = i15 % 128;
                int i16 = i15 % 2;
            }
        }
        int i17 = setPivotYN16904 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        component9 = i17 % 128;
        int i18 = i17 % 2;
        return i5;
    }

    public static final /* synthetic */ int component5(List list) {
        int iComponent5 = av.component5();
        return ((Integer) setPivotYN16904(av.component5(), iComponent5, -1719091942, av.component5(), 1719091943, new Object[]{list}, av.component5())).intValue();
    }

    public static final /* synthetic */ long setPivotYN16904(List list) {
        int iComponent5 = av.component5();
        return ((Long) setPivotYN16904(av.component5(), iComponent5, -1583343660, av.component5(), 1583343660, new Object[]{list}, av.component5())).longValue();
    }
}
