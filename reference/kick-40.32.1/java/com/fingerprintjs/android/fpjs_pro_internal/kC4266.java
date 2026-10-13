package com.fingerprintjs.android.fpjs_pro_internal;

import android.net.Uri;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class kC4266 implements bp {
    private static int iA15411 = 1;
    private static int setTopP6481U32634;
    private final String D8871;
    private final String N14263A23323;
    private final boolean Y16199;
    private final String cW27173;
    private final Function1<bj, List<wX26196>> component13;
    private final String component5;
    private final String component8;
    private final String component9;
    private final List<Pair<String, String>> kC4266;
    private final String sG29839;
    private final String setPivotYN16904;
    private final Map<String, Object> setTopP6481;
    private final String vD14832N6715;
    private final bm.component5 rP23717 = bm.component5.INSTANCE;
    private final Map<String, String> component10 = MapsKt.mapOf(TuplesKt.to(I30900.getXH31455.INSTANCE.component5(), I30900.F12218.INSTANCE.component5()));

    public static /* synthetic */ Object D8871(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
        int i7 = ~i5;
        int i8 = ~(i7 | i);
        int i9 = ~(i7 | i4);
        int i10 = i8 | i9;
        int i11 = ~i;
        int i12 = (~((~i4) | i7 | i)) | (~(i7 | i11 | i4));
        int i13 = i9 | (~(i11 | i5));
        int i14 = i5 + i + i6 + ((-1696018712) * i3) + (2108813197 * i2);
        int i15 = i14 * i14;
        int i16 = ((212195308 * i5) - 2121662464) + (1221732374 * i) + (1009537066 * i10) + (i12 * (-504768533)) + ((-504768533) * i13) + (716963840 * i6) + (39845888 * i3) + (227278848 * i2) + ((-1705377792) * i15);
        int i17 = ((i5 * 362004572) - 1408384217) + (i * 362004174) + (i10 * (-398)) + (i12 * 199) + (i13 * 199) + (i6 * 362004373) + (i3 * (-1290304248)) + (i2 * 155295761) + (i15 * (-60686336));
        int i18 = i16 + (i17 * i17 * (-1680474112));
        if (i18 != 1) {
            return i18 != 2 ? component9(objArr) : vD14832N6715(objArr);
        }
        kC4266 kc4266 = (kC4266) objArr[0];
        int i19 = 2 % 2;
        int i20 = iA15411;
        int i21 = (i20 ^ 73) + ((i20 & 73) << 1);
        setTopP6481U32634 = i21 % 128;
        int i22 = i21 % 2;
        Uri uri = Uri.parse(kc4266.vD14832N6715);
        Intrinsics.checkNotNull(uri);
        Uri.Builder builderBuildUpon = uri.buildUpon();
        Intrinsics.checkNotNull(builderBuildUpon);
        String strComponent5 = I30900.uH18377.INSTANCE.component5();
        component8 component8Var = component8.INSTANCE;
        builderBuildUpon.appendQueryParameter(strComponent5, component8.D8871(kc4266.sG29839));
        builderBuildUpon.appendQueryParameter(I30900.bm.INSTANCE.component5(), kc4266.component9);
        Iterator<T> it = kc4266.kC4266.iterator();
        int i23 = setTopP6481U32634 + 37;
        iA15411 = i23 % 128;
        int i24 = i23 % 2;
        while (it.hasNext()) {
            openContextMenu.Companion.setPivotYN16904();
            System.identityHashCode(kc4266);
            Pair pair = (Pair) it.next();
            builderBuildUpon.appendQueryParameter(I30900.aq.INSTANCE.component5(), pair.getFirst() + DomExceptionUtils.SEPARATOR + pair.getSecond());
        }
        String string = builderBuildUpon.build().toString();
        int i25 = iA15411 + 7;
        setTopP6481U32634 = i25 % 128;
        int i26 = i25 % 2;
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public kC4266(String str, String str2, String str3, String str4, String str5, String str6, Function1<? super bj, ? extends List<? extends wX26196>> function1, Map<String, ? extends Object> map, String str7, String str8, boolean z, List<Pair<String, String>> list, String str9) {
        this.vD14832N6715 = str;
        this.component9 = str2;
        this.component5 = str3;
        this.D8871 = str4;
        this.setPivotYN16904 = str5;
        this.component8 = str6;
        this.component13 = function1;
        this.setTopP6481 = map;
        this.sG29839 = str7;
        this.N14263A23323 = str8;
        this.Y16199 = z;
        this.kC4266 = list;
        this.cW27173 = str9;
    }

    private static /* synthetic */ Object vD14832N6715(Object[] objArr) {
        kC4266 kc4266 = (kC4266) objArr[0];
        int i = 2 % 2;
        int i2 = setTopP6481U32634 + 41;
        iA15411 = i2 % 128;
        int i3 = i2 % 2;
        bm.component5 component5VarD8871 = kc4266.D8871();
        if (i3 != 0) {
            return component5VarD8871;
        }
        throw null;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bp
    public final String component5() {
        int i = 2 % 2;
        int i2 = iA15411;
        int i3 = (i2 ^ 3) + ((i2 & 3) << 1);
        setTopP6481U32634 = i3 % 128;
        if (i3 % 2 == 0) {
            int pivotYN16904 = openContextMenu.Companion.setPivotYN16904();
            int pivotYN16905 = openContextMenu.Companion.setPivotYN16904();
            int pivotYN16906 = openContextMenu.Companion.setPivotYN16904();
            return (String) D8871(-1010648550, openContextMenu.Companion.setPivotYN16904(), pivotYN16906, pivotYN16904, new Object[]{this}, 1010648551, pivotYN16905);
        }
        int pivotYN16907 = openContextMenu.Companion.setPivotYN16904();
        int pivotYN16908 = openContextMenu.Companion.setPivotYN16904();
        int pivotYN16909 = openContextMenu.Companion.setPivotYN16904();
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private bm.component5 D8871() {
        int i = 2 % 2;
        int i2 = iA15411 + 105;
        int i3 = i2 % 128;
        setTopP6481U32634 = i3;
        int i4 = i2 % 2;
        bm.component5 component5Var = this.rP23717;
        int i5 = ((i3 | 101) << 1) - (i3 ^ 101);
        iA15411 = i5 % 128;
        int i6 = i5 % 2;
        return component5Var;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bp
    public final Map<String, String> vD14832N6715() {
        int i = 2 % 2;
        int i2 = setTopP6481U32634;
        int i3 = ((i2 | 9) << 1) - (i2 ^ 9);
        iA15411 = i3 % 128;
        int i4 = i3 % 2;
        Map<String, String> map = this.component10;
        if (i4 == 0) {
            int i5 = 91 / 0;
        }
        int i6 = i2 + 115;
        iA15411 = i6 % 128;
        int i7 = i6 % 2;
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0137  */
    /* JADX WARN: Code duplicated, block: B:32:0x0194  */
    private static /* synthetic */ Object component9(Object[] objArr) {
        boolean z = false;
        kC4266 kc4266 = (kC4266) objArr[0];
        bj bjVar = (bj) objArr[1];
        int i = 2 % 2;
        HashMap map = new HashMap();
        Pair[] pairArr = new Pair[2];
        String strComponent5 = I30900.cz.INSTANCE.component5();
        Pair[] pairArr2 = new Pair[2];
        String str = (String) iA15411.component9(ap.component9(), 1499940174, -1499940170, ap.component9(), ap.component9(), ap.component9(), new Object[0]);
        String str2 = kc4266.component8;
        String str3 = "";
        if (str2 == null) {
            int i2 = iA15411;
            int i3 = (i2 & 59) + (i2 | 59);
            setTopP6481U32634 = i3 % 128;
            if (i3 % 2 != 0) {
                throw null;
            }
            str2 = "";
        }
        pairArr2[0] = TuplesKt.to(str, str2);
        pairArr2[1] = TuplesKt.to(iA15411.cW27173(), I30900.setSystemGestureExclusionRectsL30479.INSTANCE.component5());
        pairArr[0] = TuplesKt.to(strComponent5, MapsKt.mapOf(pairArr2));
        pairArr[1] = TuplesKt.to(I30900.bs.INSTANCE.component5(), 0);
        Map mapMapOf = MapsKt.mapOf(pairArr);
        HashMap map2 = map;
        map2.put((String) iA15411.component9(ap.component9(), -1611028640, 1611028641, ap.component9(), ap.component9(), ap.component9(), new Object[0]), kc4266.component9);
        String str4 = (String) iA15411.component9(ap.component9(), 1059067314, -1059067312, ap.component9(), ap.component9(), ap.component9(), new Object[0]);
        String str5 = kc4266.N14263A23323;
        if (str5 == null) {
            int i4 = setTopP6481U32634;
            int i5 = (i4 & 95) + (i4 | 95);
            iA15411 = i5 % 128;
            if (i5 % 2 == 0) {
                throw null;
            }
            int i6 = ((i4 | 1) << 1) - (i4 ^ 1);
            iA15411 = i6 % 128;
            int i7 = i6 % 2;
        } else {
            str3 = str5;
        }
        map2.put(str4, str3);
        map2.put(iA15411.component13(), mapMapOf);
        String str6 = kc4266.component5;
        if (str6 != null) {
            int i8 = iA15411 + 81;
            setTopP6481U32634 = i8 % 128;
            int i9 = i8 % 2;
            if (str6.length() == 0) {
                map2.put(iA15411.component5(), MapsKt.mapOf(TuplesKt.to(I30900.bs.INSTANCE.component5(), -1)));
            } else {
                map2.put(iA15411.component5(), MapsKt.mapOf(TuplesKt.to(I30900.bs.INSTANCE.component5(), 0), TuplesKt.to(I30900.cz.INSTANCE.component5(), kc4266.component5)));
            }
        } else {
            map2.put(iA15411.component5(), MapsKt.mapOf(TuplesKt.to(I30900.bs.INSTANCE.component5(), -1)));
        }
        String str7 = kc4266.D8871;
        if (str7 != null) {
            int i10 = setTopP6481U32634 + 9;
            iA15411 = i10 % 128;
            if (i10 % 2 == 0) {
                str7.length();
                throw null;
            }
            if (str7.length() == 0) {
                int i11 = setTopP6481U32634 + 69;
                iA15411 = i11 % 128;
                int i12 = i11 % 2;
                map2.put(iA15411.sG29839(), MapsKt.mapOf(TuplesKt.to(I30900.bs.INSTANCE.component5(), -1)));
                int i13 = iA15411;
                int i14 = (i13 & 53) + (i13 | 53);
                setTopP6481U32634 = i14 % 128;
                int i15 = i14 % 2;
            } else {
                map2.put(iA15411.sG29839(), MapsKt.mapOf(TuplesKt.to(I30900.bs.INSTANCE.component5(), 0), TuplesKt.to(I30900.cz.INSTANCE.component5(), kc4266.D8871)));
            }
        } else {
            int i16 = setTopP6481U32634 + 69;
            iA15411 = i16 % 128;
            int i17 = i16 % 2;
            map2.put(iA15411.sG29839(), MapsKt.mapOf(TuplesKt.to(I30900.bs.INSTANCE.component5(), -1)));
            int i18 = iA15411;
            int i19 = (i18 & 53) + (i18 | 53);
            setTopP6481U32634 = i19 % 128;
            int i110 = i19 % 2;
        }
        String str8 = kc4266.setPivotYN16904;
        if (str8 == null || str8.length() == 0) {
            int i20 = setTopP6481U32634 + 79;
            iA15411 = i20 % 128;
            if (i20 % 2 == 0) {
                map2.put((String) iA15411.component9(ap.component9(), 2137067900, -2137067900, ap.component9(), ap.component9(), ap.component9(), new Object[0]), MapsKt.mapOf(TuplesKt.to(I30900.bs.INSTANCE.component5(), -1)));
                int i21 = 8 / 0;
            } else {
                map2.put((String) iA15411.component9(ap.component9(), 2137067900, -2137067900, ap.component9(), ap.component9(), ap.component9(), new Object[0]), MapsKt.mapOf(TuplesKt.to(I30900.bs.INSTANCE.component5(), -1)));
            }
        } else {
            map2.put((String) iA15411.component9(ap.component9(), 2137067900, -2137067900, ap.component9(), ap.component9(), ap.component9(), new Object[0]), MapsKt.mapOf(TuplesKt.to(I30900.bs.INSTANCE.component5(), 0), TuplesKt.to(I30900.cz.INSTANCE.component5(), kc4266.setPivotYN16904)));
        }
        if (kc4266.Y16199) {
            map2.put((String) iA15411.component9(ap.component9(), -864773200, 864773206, ap.component9(), ap.component9(), ap.component9(), new Object[0]), 1);
            int i22 = iA15411;
            int i23 = ((i22 | 103) << 1) - (i22 ^ 103);
            setTopP6481U32634 = i23 % 128;
            int i24 = i23 % 2;
        }
        if (kc4266.cW27173.length() > 0) {
            int i25 = iA15411;
            int i26 = ((i25 | 33) << 1) - (i25 ^ 33);
            setTopP6481U32634 = i26 % 128;
            int i27 = i26 % 2;
            map2.put(iA15411.setTopP6481(), kc4266.cW27173);
        }
        if (!kc4266.setTopP6481.isEmpty()) {
            int i28 = iA15411 + 67;
            int i29 = i28 % 128;
            setTopP6481U32634 = i29;
            z = i28 % 2 == 0;
            int i30 = i29 + 103;
            iA15411 = i30 % 128;
            int i31 = i30 % 2;
        }
        if (z) {
            map2.put(iA15411.vD14832N6715(), kc4266.setTopP6481);
        }
        for (wX26196 wx26196 : kc4266.component13.invoke(bjVar)) {
            map2.put(wx26196.setPivotYN16904(), wx26196.component9());
        }
        return map2;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bp
    public final /* synthetic */ bm setPivotYN16904() {
        int pivotYN16904 = openContextMenu.Companion.setPivotYN16904();
        int pivotYN16905 = openContextMenu.Companion.setPivotYN16904();
        int pivotYN16906 = openContextMenu.Companion.setPivotYN16904();
        return (bm) D8871(-1020401945, openContextMenu.Companion.setPivotYN16904(), pivotYN16906, pivotYN16904, new Object[]{this}, 1020401947, pivotYN16905);
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bp
    public final Map<String, Object> vD14832N6715(bj bjVar) {
        int pivotYN16904 = openContextMenu.Companion.setPivotYN16904();
        int pivotYN16905 = openContextMenu.Companion.setPivotYN16904();
        int pivotYN16906 = openContextMenu.Companion.setPivotYN16904();
        return (Map) D8871(428054603, openContextMenu.Companion.setPivotYN16904(), pivotYN16906, pivotYN16904, new Object[]{this, bjVar}, -428054603, pivotYN16905);
    }

    private final String component9() {
        int pivotYN16904 = openContextMenu.Companion.setPivotYN16904();
        int pivotYN16905 = openContextMenu.Companion.setPivotYN16904();
        int pivotYN16906 = openContextMenu.Companion.setPivotYN16904();
        return (String) D8871(-1010648550, openContextMenu.Companion.setPivotYN16904(), pivotYN16906, pivotYN16904, new Object[]{this}, 1010648551, pivotYN16905);
    }
}
