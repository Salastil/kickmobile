package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.SystemClock;
import androidx.compose.runtime.GapComposerKt;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class component13 implements bp {
    public static int component9 = 0;
    private static int sG29839 = 0;
    private static int setTopP6481 = 1;
    public static int vD14832N6715;
    private final bm.vD14832N6715 D8871 = bm.vD14832N6715.INSTANCE;
    private final Map<String, String> component5 = MapsKt.emptyMap();
    private final String setPivotYN16904;

    public static /* synthetic */ Object vD14832N6715(int i, int i2, int i3, int i4, int i5, Object[] objArr, int i6) {
        int i7 = (~((~i3) | i)) | i6;
        int i8 = ~i6;
        int i9 = (~(i8 | i)) | (~(i8 | i3)) | (~(i | i3));
        int i10 = (~(i3 | (~i))) | i8;
        int i11 = i6 + i + i2 + ((-2137991558) * i4) + (111092868 * i5);
        int i12 = i11 * i11;
        int i13 = (((-431794203) * i6) - 566755328) + (427185167 * i) + (i7 * 1717982222) + (1717982222 * i9) + ((-1717982222) * i10) + ((-1290797056) * i2) + ((-1247805440) * i4) + ((-1807745024) * i5) + ((-591921152) * i12);
        int i14 = (i6 * (-1469267343)) + 1003592187 + (i * (-1469268429)) + (i7 * (-362)) + (i9 * (-362)) + (i10 * 362) + (i2 * (-1469268067)) + (i4 * 1951436498) + (i5 * (-746069772)) + (i12 * (-1529348096));
        return i13 + ((i14 * i14) * 1762131968) != 1 ? component5(objArr) : component9(objArr);
    }

    public component13(setTopP6481 settopp6481) {
        this.setPivotYN16904 = settopp6481.D8871();
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bp
    public final /* synthetic */ bm setPivotYN16904() {
        int i = 2 % 2;
        int i2 = setTopP6481 + 49;
        sG29839 = i2 % 128;
        int i3 = i2 % 2;
        bm.vD14832N6715 vd14832n6715D8871 = D8871();
        int i4 = setTopP6481 + 7;
        sG29839 = i4 % 128;
        int i5 = i4 % 2;
        return vd14832n6715D8871;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bp
    public final String component5() {
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = ((i2 | 37) << 1) - (i2 ^ 37);
        int i4 = i3 % 128;
        sG29839 = i4;
        int i5 = i3 % 2;
        String str = this.setPivotYN16904;
        int i6 = i4 + 47;
        setTopP6481 = i6 % 128;
        int i7 = i6 % 2;
        return str;
    }

    private bm.vD14832N6715 D8871() {
        int i = 2 % 2;
        int i2 = sG29839;
        int i3 = (i2 ^ GapComposerKt.nodeKey) + ((i2 & GapComposerKt.nodeKey) << 1);
        int i4 = i3 % 128;
        setTopP6481 = i4;
        int i5 = i3 % 2;
        bm.vD14832N6715 vd14832n6715 = this.D8871;
        if (i5 == 0) {
            int i6 = 26 / 0;
        }
        int i7 = i4 + 51;
        sG29839 = i7 % 128;
        int i8 = i7 % 2;
        return vd14832n6715;
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        component13 component13Var = (component13) objArr[0];
        int i = 2 % 2;
        int i2 = sG29839;
        int i3 = i2 + 113;
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        Map<String, String> map = component13Var.component5;
        int i5 = i2 + 71;
        setTopP6481 = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 65 / 0;
        }
        return map;
    }

    private static /* synthetic */ Object component5(Object[] objArr) {
        int i = 2 % 2;
        int i2 = setTopP6481 + 33;
        sG29839 = i2 % 128;
        int i3 = i2 % 2;
        Map mapEmptyMap = MapsKt.emptyMap();
        int i4 = setTopP6481;
        int i5 = (i4 ^ 89) + ((i4 & 89) << 1);
        sG29839 = i5 % 128;
        if (i5 % 2 == 0) {
            return mapEmptyMap;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public static int component9() {
        int i = component9;
        int i2 = i % 6290156;
        component9 = i + 1;
        if (i2 != 0) {
            return vD14832N6715;
        }
        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
        vD14832N6715 = iElapsedRealtime;
        return iElapsedRealtime;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bp
    public final Map<String, Object> vD14832N6715(bj bjVar) {
        int iComponent5 = br.component5();
        return (Map) vD14832N6715(-1079748923, br.component5(), iComponent5, br.component5(), br.component5(), new Object[]{this, bjVar}, 1079748923);
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.bp
    public final Map<String, String> vD14832N6715() {
        int iComponent5 = br.component5();
        return (Map) vD14832N6715(1719800131, br.component5(), iComponent5, br.component5(), br.component5(), new Object[]{this}, -1719800130);
    }
}
