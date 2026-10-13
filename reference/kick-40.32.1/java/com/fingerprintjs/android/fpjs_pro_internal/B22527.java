package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class B22527 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static char[] N14263A23323;
    private static int cW27173;
    private static int kC4266;
    private static char setTopP6481;
    private final getContentDescriptionT29053 D8871;
    private final U18116 component13;
    private final fQ24217 component5;
    private final component7X12099 component8;
    private final setScrollYX30569T8767 component9;
    private final W6392 sG29839;
    private final G8931 setPivotYN16904;
    private final toString vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(short r5, byte r6, int r7) {
        /*
            int r5 = r5 * 4
            int r0 = 1 - r5
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.B22527.$$a
            int r7 = r7 * 2
            int r7 = r7 + 67
            int r6 = r6 * 4
            int r6 = 4 - r6
            byte[] r0 = new byte[r0]
            r2 = 0
            int r5 = 0 - r5
            if (r1 != 0) goto L19
            r7 = r5
            r4 = r6
            r3 = r2
            goto L29
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r5) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L25:
            int r3 = r3 + 1
            r4 = r1[r6]
        L29:
            int r6 = r6 + 1
            int r7 = r7 + r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.B22527.$$c(short, byte, int):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{124, 59, 115, Ascii.VT};
        $$b = 58;
    }

    public static /* synthetic */ Object vD14832N6715(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
        int i7 = ~i4;
        int i8 = ~i6;
        int i9 = i7 | i8;
        int i10 = ~(i9 | i5);
        int i11 = ~i5;
        int i12 = (~(i7 | i6)) | (~(i8 | i11)) | (~(i8 | i4));
        int i13 = ~(i11 | i9);
        int i14 = i4 + i6 + i3 + (1938118820 * i2) + ((-1869228383) * i);
        int i15 = i14 * i14;
        int i16 = (i4 * (-1046486968)) + 2037645312 + ((-1046486968) * i6) + (1604861810 * i10) + (i12 * (-1345052743)) + ((-1345052743) * i13) + (1903427584 * i3) + ((-1907359744) * i2) + (1374945280 * i) + (1516044288 * i15);
        int i17 = ((i4 * 647972376) - 1941852458) + (i6 * 647972376) + (i10 * 1702) + (i12 * 851) + (i13 * 851) + (i3 * 647973227) + (i2 * (-1260466036)) + (i * 1557372491) + (i15 * 1239351296);
        if (i16 + (i17 * i17 * 490405888) != 1) {
            int i18 = 2 % 2;
            d dVar = new d(((B22527) objArr[0]).component5.component5());
            int i19 = cW27173 + 95;
            kC4266 = i19 % 128;
            int i20 = i19 % 2;
            return dVar;
        }
        int i21 = 2 % 2;
        b bVar = new b(((B22527) objArr[0]).vD14832N6715.vD14832N6715());
        int i22 = cW27173 + 47;
        kC4266 = i22 % 128;
        int i23 = i22 % 2;
        return bVar;
    }

    public B22527(toString tostring, setScrollYX30569T8767 setscrollyx30569t8767, getContentDescriptionT29053 getcontentdescriptiont29053, G8931 g8931, fQ24217 fq24217, W6392 w6392, component7X12099 component7x12099, U18116 u18116) {
        this.vD14832N6715 = tostring;
        this.component9 = setscrollyx30569t8767;
        this.D8871 = getcontentdescriptiont29053;
        this.setPivotYN16904 = g8931;
        this.component5 = fq24217;
        this.sG29839 = w6392;
        this.component8 = component7x12099;
        this.component13 = u18116;
    }

    public final l component9() {
        int i = 2 % 2;
        l lVar = new l(this.component13.component9());
        int i2 = cW27173 + 13;
        kC4266 = i2 % 128;
        int i3 = i2 % 2;
        return lVar;
    }

    public final j vD14832N6715() {
        int i = 2 % 2;
        j jVar = new j(this.component13.component5());
        int i2 = kC4266 + 57;
        cW27173 = i2 % 128;
        int i3 = i2 % 2;
        return jVar;
    }

    public final s component5() {
        int i = 2 % 2;
        s sVar = new s(this.component9.setPivotYN16904());
        int i2 = kC4266 + 3;
        cW27173 = i2 % 128;
        int i3 = i2 % 2;
        return sVar;
    }

    public final o setPivotYN16904() {
        int i = 2 % 2;
        o oVar = new o(this.component9.component9());
        int i2 = kC4266 + 73;
        cW27173 = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 25 / 0;
        }
        return oVar;
    }

    public final m D8871() {
        int i = 2 % 2;
        m mVar = new m(this.vD14832N6715.component9());
        int i2 = cW27173 + 55;
        kC4266 = i2 % 128;
        if (i2 % 2 != 0) {
            return mVar;
        }
        throw null;
    }

    public final n component13() {
        int i = 2 % 2;
        n nVar = new n(this.D8871.vD14832N6715());
        int i2 = cW27173 + 19;
        kC4266 = i2 % 128;
        int i3 = i2 % 2;
        return nVar;
    }

    public final k N14263A23323() {
        int i = 2 % 2;
        k kVar = new k(this.setPivotYN16904.component9());
        int i2 = kC4266 + 25;
        cW27173 = i2 % 128;
        int i3 = i2 % 2;
        return kVar;
    }

    public final i sG29839() {
        int i = 2 % 2;
        i iVar = new i(this.component5.vD14832N6715());
        int i2 = cW27173 + 17;
        kC4266 = i2 % 128;
        int i3 = i2 % 2;
        return iVar;
    }

    public final e setTopP6481() {
        int i = 2 % 2;
        e eVar = new e(this.sG29839.setPivotYN16904());
        int i2 = cW27173 + 29;
        kC4266 = i2 % 128;
        int i3 = i2 % 2;
        return eVar;
    }

    public final h Y16199() {
        int i = 2 % 2;
        h hVar = new h(this.component8.component5());
        int i2 = kC4266 + 37;
        cW27173 = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 10 / 0;
        }
        return hVar;
    }

    public final g kC4266() {
        int i = 2 % 2;
        g gVar = new g(this.vD14832N6715.setPivotYN16904());
        int i2 = kC4266 + 119;
        cW27173 = i2 % 128;
        if (i2 % 2 == 0) {
            return gVar;
        }
        throw null;
    }

    private static void a(byte b, int i, String str, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        int i5 = $10 + 29;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        char[] charArray = str != null ? str.toCharArray() : str;
        ce ceVar = new ce();
        char[] cArr = N14263A23323;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i7 = $11 + 87;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            for (int i9 = 0; i9 < length; i9++) {
                int i10 = $10 + 57;
                $11 = i10 % 128;
                int i11 = i10 % 2;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[i9])};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1083735746);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.MeasureSpec.getMode(0), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 8065), 3217 - KeyEvent.normalizeMetaState(0), 304954017, false, $$c((short) 0, (byte) 0, 25), new Class[]{Integer.TYPE});
                    }
                    cArr2[i9] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            int i12 = $11 + 91;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            cArr = cArr2;
        }
        Object[] objArr3 = {Integer.valueOf(setTopP6481)};
        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1083735746);
        if (objComponent6 == null) {
            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (TextUtils.getCapsMode("", 0, 0) + 8065), AndroidCharacter.getMirror('0') + 3169, 304954017, false, $$c((short) 0, (byte) 0, 25), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
        char[] cArr3 = new char[i];
        if (i % 2 != 0) {
            int i14 = $11 + 115;
            $10 = i14 % 128;
            if (i14 % 2 != 0) {
                i2 = i + GapComposerKt.nodeKey;
                cArr3[i2] = (char) (charArray[i2] % b);
            } else {
                i2 = i - 1;
                cArr3[i2] = (char) (charArray[i2] - b);
            }
        } else {
            i2 = i;
        }
        int i15 = 1;
        if (i2 > 1) {
            int i16 = $11 + 85;
            $10 = i16 % 128;
            int i17 = i16 % 2;
            ceVar.component5 = 0;
            while (ceVar.component5 < i2) {
                int i18 = $11 + 55;
                $10 = i18 % 128;
                int i19 = i18 % i3;
                ceVar.D8871 = charArray[ceVar.component5];
                ceVar.setPivotYN16904 = charArray[ceVar.component5 + i15];
                if (ceVar.D8871 == ceVar.setPivotYN16904) {
                    cArr3[ceVar.component5] = (char) (ceVar.D8871 - b);
                    cArr3[ceVar.component5 + i15] = (char) (ceVar.setPivotYN16904 - b);
                    i3 = i3;
                    i15 = i15;
                } else {
                    Object[] objArr4 = new Object[13];
                    objArr4[12] = ceVar;
                    objArr4[11] = Integer.valueOf(cCharValue);
                    objArr4[10] = ceVar;
                    objArr4[9] = ceVar;
                    objArr4[8] = Integer.valueOf(cCharValue);
                    objArr4[7] = ceVar;
                    objArr4[6] = ceVar;
                    objArr4[5] = Integer.valueOf(cCharValue);
                    objArr4[4] = ceVar;
                    objArr4[3] = ceVar;
                    objArr4[i3] = Integer.valueOf(cCharValue);
                    objArr4[i15] = ceVar;
                    objArr4[0] = ceVar;
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1087197054);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 51, (char) (ImageFormat.getBitsPerPixel(0) + 47646), 5213 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 309857053, false, $$c((short) 0, (byte) 0, 27), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue() == ceVar.component13) {
                        int i20 = $10 + 29;
                        $11 = i20 % 128;
                        int i21 = i20 % 2;
                        Object[] objArr5 = new Object[11];
                        objArr5[10] = ceVar;
                        objArr5[9] = Integer.valueOf(cCharValue);
                        objArr5[8] = ceVar;
                        objArr5[7] = Integer.valueOf(cCharValue);
                        objArr5[6] = Integer.valueOf(cCharValue);
                        objArr5[5] = ceVar;
                        objArr5[4] = ceVar;
                        objArr5[3] = Integer.valueOf(cCharValue);
                        objArr5[i3] = Integer.valueOf(cCharValue);
                        objArr5[i15] = ceVar;
                        objArr5[0] = ceVar;
                        Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1764120300);
                        if (objComponent8 == null) {
                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ExpandableListView.getPackedPositionType(0L), 5576 - Gravity.getAbsoluteGravity(0, 0), 999494287, false, $$c((short) 0, (byte) 0, 0), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objComponent8).invoke(null, objArr5)).intValue();
                        int i22 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                        cArr3[ceVar.component5] = cArr[iIntValue];
                        cArr3[ceVar.component5 + 1] = cArr[i22];
                    } else if (ceVar.component9 == ceVar.vD14832N6715) {
                        ceVar.N14263A23323 = ((ceVar.N14263A23323 + cCharValue) - 1) % cCharValue;
                        ceVar.component13 = ((ceVar.component13 + cCharValue) - 1) % cCharValue;
                        int i23 = (ceVar.component9 * cCharValue) + ceVar.N14263A23323;
                        int i24 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                        cArr3[ceVar.component5] = cArr[i23];
                        cArr3[ceVar.component5 + 1] = cArr[i24];
                    } else {
                        int i25 = (ceVar.component9 * cCharValue) + ceVar.component13;
                        int i26 = (ceVar.vD14832N6715 * cCharValue) + ceVar.N14263A23323;
                        cArr3[ceVar.component5] = cArr[i25];
                        cArr3[ceVar.component5 + 1] = cArr[i26];
                    }
                }
                ceVar.component5 += 2;
                i15 = i15;
                i3 = i3;
            }
        }
        for (int i27 = 0; i27 < i; i27++) {
            cArr3[i27] = (char) (cArr3[i27] ^ 13722);
        }
        objArr[0] = new String(cArr3);
    }

    public static void component9(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = kC4266 + 31;
        cW27173 = i2 % 128;
        int i3 = i2 % 2;
        long j3 = j ^ (j2 << 32);
        u.class.getField("vD14832N6715").get(null);
        int i4 = cW27173 + 107;
        kC4266 = i4 % 128;
        int i5 = i4 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a((byte) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 105), Gravity.getAbsoluteGravity(0, 0) + 7, "\u000f\u000b\u000e\u0003\u000f\u0001㙦", objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a((byte) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 52), Color.green(0) + 3, "㗟㗟㗠", objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a((byte) (42 - (ViewConfiguration.getEdgeSlop() >> 16)), Process.getGidForName("") + 4, "\u000e\u0000㘘", objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
            int i6 = cW27173 + 77;
            kC4266 = i6 % 128;
            int i7 = i6 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    static {
        init$0();
        $10 = 0;
        $11 = 1;
        cW27173 = 0;
        kC4266 = 1;
        N14263A23323 = new char[]{3901, 15057, 15056, 15082, 3899, 3898, 3900, 15044, 15043, 14995, 3902, 15059, 15061, 15040, 14996, 15049};
        setTopP6481 = (char) 3899;
    }

    public final b rP23717() {
        int iComponent9 = getContentSensitivity.Companion.component9();
        int iComponent10 = getContentSensitivity.Companion.component9();
        int iComponent11 = getContentSensitivity.Companion.component9();
        return (b) vD14832N6715(getContentSensitivity.Companion.component9(), iComponent11, iComponent10, 644253592, new Object[]{this}, iComponent9, -644253591);
    }

    public final d component8() {
        int iComponent9 = getContentSensitivity.Companion.component9();
        int iComponent10 = getContentSensitivity.Companion.component9();
        int iComponent11 = getContentSensitivity.Companion.component9();
        return (d) vD14832N6715(getContentSensitivity.Companion.component9(), iComponent11, iComponent10, -618098089, new Object[]{this}, iComponent9, 618098089);
    }
}
