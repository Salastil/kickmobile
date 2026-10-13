package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class i extends f<String> {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static long D8871;
    private static int component5;
    private static int setPivotYN16904;
    private final String vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0024
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(int r7, short r8, short r9) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.i.$$a
            int r8 = r8 * 3
            int r8 = r8 + 1
            int r7 = r7 * 2
            int r7 = 4 - r7
            int r9 = r9 * 2
            int r9 = r9 + 104
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r8
            r5 = r2
            goto L29
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L24:
            r3 = r0[r7]
            r6 = r3
            r3 = r9
            r9 = r6
        L29:
            int r7 = r7 + 1
            int r9 = -r9
            int r9 = r9 + r3
            r3 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.i.$$c(int, short, short):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{63, 19, -108, 103};
        $$b = 95;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 57;
        component5 = i2 % 128;
        if (i2 % 2 == 0) {
            vD14832N6715();
            throw null;
        }
        String strVD14832N6715 = vD14832N6715();
        int i3 = setPivotYN16904 + 107;
        component5 = i3 % 128;
        if (i3 % 2 != 0) {
            return strVD14832N6715;
        }
        throw null;
    }

    private String vD14832N6715() {
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = i2 + 71;
        component5 = i3 % 128;
        int i4 = i3 % 2;
        String str = this.vD14832N6715;
        if (i4 == 0) {
            throw null;
        }
        int i5 = i2 + 9;
        component5 = i5 % 128;
        int i6 = i5 % 2;
        return str;
    }

    public i(String str) {
        super(null);
        this.vD14832N6715 = str;
    }

    private static void a(String str, int i, Object[] objArr) throws Throwable {
        char[] charArray;
        int i2;
        int i3;
        int i4 = 2 % 2;
        int i5 = $10 + 107;
        int i6 = i5 % 128;
        $11 = i6;
        int i7 = i5 % 2;
        if (str != null) {
            int i8 = i6 + 59;
            $10 = i8 % 128;
            if (i8 % 2 != 0) {
                str.toCharArray();
                throw null;
            }
            charArray = str.toCharArray();
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        cb cbVar = new cb();
        cbVar.setPivotYN16904 = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        cbVar.D8871 = 0;
        int i9 = $11 + 15;
        $10 = i9 % 128;
        int i10 = i9 % 2;
        while (cbVar.D8871 < cArr.length) {
            int i11 = cbVar.D8871;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[cbVar.D8871]), cbVar, cbVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                if (objComponent5 == null) {
                    i2 = 55223;
                    i3 = 2106881226;
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.getCapsMode("", 0, 0), (char) (TextUtils.indexOf("", "", 0, 0) + 60693), ((byte) KeyEvent.getModifierMetaStateMask()) + 5956, 148978589, false, $$c(0, (short) 0, (short) 1), new Class[]{Integer.TYPE, Object.class, Object.class});
                } else {
                    i2 = 55223;
                    i3 = 2106881226;
                }
                jArr[i11] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() ^ (D8871 ^ (-1805496993403714128L));
                Object[] objArr3 = {cbVar, cbVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i3);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.getDefaultSize(0, 0) + 52, (char) (i2 - (ViewConfiguration.getTapTimeout() >> 16)), 3270 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 790704297, false, $$c(0, (short) 0, (short) 0), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent6).invoke(null, objArr3);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        char[] cArr2 = new char[length];
        cbVar.D8871 = 0;
        while (cbVar.D8871 < cArr.length) {
            cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
            Object[] objArr4 = {cbVar, cbVar};
            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(2106881226);
            if (objComponent7 == null) {
                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (View.combineMeasuredStates(0, 0) + 55223), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 3269, 790704297, false, $$c(0, (short) 0, (short) 0), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent7).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2);
    }

    public static void component9(long j, long j2) throws Throwable {
        long j3;
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 73;
        component5 = i2 % 128;
        if (i2 % 2 == 0) {
            j3 = j - (j2 << 77);
            u.class.getField("vD14832N6715").get(null);
        } else {
            j3 = j ^ (j2 << 32);
            u.class.getField("vD14832N6715").get(null);
        }
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a("뤬⠜魸ਗ਼ﶣ泖\udfd6", Color.alpha(0) + 37159, objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a("륫赡텰", KeyEvent.getDeadChar(0, 0) + 13327, objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a("뤪ʞ칌", 48050 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
            int i3 = component5 + 61;
            setPivotYN16904 = i3 % 128;
            int i4 = i3 % 2;
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
        setPivotYN16904 = 0;
        component5 = 1;
        D8871 = -8768117370427900694L;
    }
}
