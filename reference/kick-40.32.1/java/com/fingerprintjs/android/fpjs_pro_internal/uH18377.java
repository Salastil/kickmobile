package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.NoWhenBranchMatchedException;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class uH18377 implements vE15773 {
    private final ca component9;

    public uH18377(ca caVar) {
        this.component9 = caVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fingerprintjs.android.fpjs_pro_internal.vE15773
    public final D8871<vE15773.vD14832N6715, Throwable> D8871(byte[] bArr, rV4669 rv4669) {
        setPivotYN16904 setpivotyn16904;
        try {
            uH18377 uh18377 = this;
            setpivotyn16904 = new vD14832N6715(this.component9.component9(bArr));
        } catch (Throwable th) {
            setpivotyn16904 = new setPivotYN16904(th);
        }
        if (setpivotyn16904 instanceof vD14832N6715) {
            return setPivotYN16904((byte[]) ((vD14832N6715) setpivotyn16904).setPivotYN16904, rv4669);
        }
        if (setpivotyn16904 instanceof setPivotYN16904) {
            return setpivotyn16904;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final D8871<vE15773.vD14832N6715, Throwable> setPivotYN16904(byte[] bArr, rV4669 rv4669) {
        boolean pivotYN16904;
        long jComponent9;
        int iComponent5;
        int iD8871;
        boolean zVD14832N6715;
        long jComponent8;
        int iN14263A23323;
        int iComponent13;
        boolean zSG29839;
        boolean topP6481;
        long jRP23717;
        int iComponent10;
        boolean zY16199;
        boolean zCW27173;
        try {
            uH18377 uh18377 = this;
            JSONObject jSONObject = new JSONObject(new String(bArr, Charsets.UTF_8));
            String strVD14832N6715 = ap.vD14832N6715(jSONObject, I30900.cd.INSTANCE.component5());
            setSystemGestureExclusionRects.Companion companion = setSystemGestureExclusionRects.INSTANCE;
            setSystemGestureExclusionRects setsystemgestureexclusionrectsD8871 = setSystemGestureExclusionRects.Companion.D8871(strVD14832N6715);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(I30900.cc.INSTANCE.component5());
            Boolean boolComponent5 = jSONObjectOptJSONObject != null ? ap.component5(jSONObjectOptJSONObject, I30900.component13G7994.INSTANCE.component5()) : null;
            Long lD8871 = jSONObjectOptJSONObject != null ? ap.D8871(jSONObjectOptJSONObject, I30900.gF31878.INSTANCE.component5()) : null;
            Integer numComponent9 = jSONObjectOptJSONObject != null ? ap.component9(jSONObjectOptJSONObject, I30900.setOnReceiveContentListener.INSTANCE.component5()) : null;
            Integer numComponent10 = jSONObjectOptJSONObject != null ? ap.component9(jSONObjectOptJSONObject, I30900.setYL16781T19680.INSTANCE.component5()) : null;
            Boolean boolComponent6 = jSONObjectOptJSONObject != null ? ap.component5(jSONObjectOptJSONObject, I30900.aj.INSTANCE.component5()) : null;
            Long lD8872 = jSONObjectOptJSONObject != null ? ap.D8871(jSONObjectOptJSONObject, I30900.al.INSTANCE.component5()) : null;
            Integer numComponent11 = jSONObjectOptJSONObject != null ? ap.component9(jSONObjectOptJSONObject, I30900.ai.INSTANCE.component5()) : null;
            Integer numComponent12 = jSONObjectOptJSONObject != null ? ap.component9(jSONObjectOptJSONObject, I30900.ae.INSTANCE.component5()) : null;
            Boolean boolComponent7 = jSONObjectOptJSONObject != null ? ap.component5(jSONObjectOptJSONObject, I30900.aw.INSTANCE.component5()) : null;
            Boolean boolComponent8 = jSONObjectOptJSONObject != null ? ap.component5(jSONObjectOptJSONObject, I30900.av.INSTANCE.component5()) : null;
            Long lD8873 = jSONObjectOptJSONObject != null ? ap.D8871(jSONObjectOptJSONObject, I30900.at.INSTANCE.component5()) : null;
            Integer numComponent13 = jSONObjectOptJSONObject != null ? ap.component9(jSONObjectOptJSONObject, I30900.au.INSTANCE.component5()) : null;
            Boolean boolComponent9 = jSONObjectOptJSONObject != null ? ap.component5(jSONObjectOptJSONObject, I30900.bi.INSTANCE.component5()) : null;
            Boolean boolComponent10 = jSONObjectOptJSONObject != null ? ap.component5(jSONObjectOptJSONObject, I30900.bg.INSTANCE.component5()) : null;
            if (boolComponent5 != null) {
                pivotYN16904 = boolComponent5.booleanValue();
            } else {
                pivotYN16904 = rv4669.setPivotYN16904();
            }
            boolean z = pivotYN16904;
            if (lD8871 != null) {
                jComponent9 = lD8871.longValue();
            } else {
                jComponent9 = rv4669.component9();
            }
            long j = jComponent9;
            if (numComponent9 != null) {
                iComponent5 = numComponent9.intValue();
            } else {
                iComponent5 = rv4669.component5();
            }
            int i = iComponent5;
            if (numComponent10 != null) {
                iD8871 = numComponent10.intValue();
            } else {
                iD8871 = rv4669.D8871();
            }
            int i2 = iD8871;
            if (boolComponent6 != null) {
                zVD14832N6715 = boolComponent6.booleanValue();
            } else {
                zVD14832N6715 = rv4669.vD14832N6715();
            }
            boolean z2 = zVD14832N6715;
            if (lD8872 != null) {
                jComponent8 = lD8872.longValue();
            } else {
                jComponent8 = rv4669.component8();
            }
            long j2 = jComponent8;
            if (numComponent11 != null) {
                iN14263A23323 = numComponent11.intValue();
            } else {
                iN14263A23323 = rv4669.N14263A23323();
            }
            int i3 = iN14263A23323;
            if (numComponent12 != null) {
                iComponent13 = numComponent12.intValue();
            } else {
                iComponent13 = rv4669.component13();
            }
            int i4 = iComponent13;
            if (boolComponent7 != null) {
                zSG29839 = boolComponent7.booleanValue();
            } else {
                zSG29839 = rv4669.sG29839();
            }
            boolean z3 = zSG29839;
            if (boolComponent8 != null) {
                topP6481 = boolComponent8.booleanValue();
            } else {
                topP6481 = rv4669.setTopP6481();
            }
            boolean z4 = topP6481;
            if (lD8873 != null) {
                jRP23717 = lD8873.longValue();
            } else {
                jRP23717 = rv4669.rP23717();
            }
            long j3 = jRP23717;
            if (numComponent13 != null) {
                iComponent10 = numComponent13.intValue();
            } else {
                iComponent10 = rv4669.component10();
            }
            int i5 = iComponent10;
            if (boolComponent9 != null) {
                zY16199 = boolComponent9.booleanValue();
            } else {
                zY16199 = rv4669.Y16199();
            }
            boolean z5 = zY16199;
            if (boolComponent10 != null) {
                zCW27173 = boolComponent10.booleanValue();
            } else {
                zCW27173 = rv4669.cW27173();
            }
            return new vD14832N6715(new vE15773.vD14832N6715(new rV4669(z, j, i, i2, z2, j2, i3, i4, z3, z4, j3, i5, z5, zCW27173), setsystemgestureexclusionrectsD8871));
        } catch (Throwable th) {
            return new setPivotYN16904(th);
        }
    }
}
