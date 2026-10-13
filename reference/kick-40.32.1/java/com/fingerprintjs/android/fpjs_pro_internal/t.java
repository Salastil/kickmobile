package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public final class t {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static int D8871;
    private static long component5;
    private static char[] component9;
    private static boolean setPivotYN16904;
    private static boolean vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(short r6, short r7, short r8) {
        /*
            int r7 = r7 + 66
            int r8 = r8 * 3
            int r0 = r8 + 1
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.t.$$a
            int r6 = r6 + 4
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L13
            r3 = r7
            r4 = r2
            r7 = r6
            goto L29
        L13:
            r3 = r2
        L14:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L23:
            r3 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r5
        L29:
            int r6 = r6 + r3
            r3 = r7
            r7 = r6
            r6 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.t.$$c(short, short, short):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{70, 75, -118, 8};
        $$b = 112;
    }

    private static void a(String str, int i, Object[] objArr) throws Throwable {
        char[] charArray;
        int i2;
        int i3;
        int i4 = 2 % 2;
        if (str != null) {
            int i5 = $10 + 113;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            charArray = str.toCharArray();
            int i7 = $10 + 47;
            $11 = i7 % 128;
            int i8 = i7 % 2;
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        cb cbVar = new cb();
        cbVar.setPivotYN16904 = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        cbVar.D8871 = 0;
        while (cbVar.D8871 < cArr.length) {
            int i9 = cbVar.D8871;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[cbVar.D8871]), cbVar, cbVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                if (objComponent5 == null) {
                    i2 = 55222;
                    i3 = 2106881226;
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(Color.argb(0, 0, 0, 0) + 52, (char) (60693 - Color.blue(0)), 5955 - TextUtils.getOffsetAfter("", 0), 148978589, false, $$c((short) -1, (short) 40, (short) 0), new Class[]{Integer.TYPE, Object.class, Object.class});
                } else {
                    i2 = 55222;
                    i3 = 2106881226;
                }
                jArr[i9] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() ^ (component5 ^ (-1805496993403714128L));
                Object[] objArr3 = {cbVar, cbVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i3);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.combineMeasuredStates(0, 0) + 52, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + i2), 3269 - (ViewConfiguration.getLongPressTimeout() >> 16), 790704297, false, $$c((short) -1, (short) 38, (short) 0), new Class[]{Object.class, Object.class});
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
        int i10 = $11 + 75;
        $10 = i10 % 128;
        int i11 = i10 % 2;
        while (cbVar.D8871 < cArr.length) {
            cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
            Object[] objArr4 = {cbVar, cbVar};
            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(2106881226);
            if (objComponent7 == null) {
                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 52, (char) (55222 - ImageFormat.getBitsPerPixel(0)), ImageFormat.getBitsPerPixel(0) + 3270, 790704297, false, $$c((short) -1, (short) 38, (short) 0), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent7).invoke(null, objArr4);
        }
        objArr[0] = new String(cArr2);
    }

    private static void b(String str, int i, int[] iArr, String str2, Object[] objArr) throws Throwable {
        int i2;
        String str3 = str2;
        int i3 = 2;
        int i4 = 2 % 2;
        Object bytes = str3;
        if (str3 != null) {
            int i5 = $10 + 15;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            bytes = str3.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        char[] charArray = str != null ? str.toCharArray() : str;
        cg cgVar = new cg();
        char[] cArr = component9;
        if (cArr != null) {
            int i7 = $10 + 71;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i9 = 0;
            while (i9 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[i9])};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-180220690);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.indexOf("", ""), (char) (Color.blue(0) + 34442), (ViewConfiguration.getPressedStateDuration() >> 16) + 5524, -1476966259, false, $$c((short) -1, (short) 0, (short) 0), new Class[]{Integer.TYPE});
                    }
                    cArr2[i9] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    i9++;
                    i3 = i3;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr = cArr2;
        }
        int i10 = i3;
        Object[] objArr3 = {Integer.valueOf(D8871)};
        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1693797315);
        long j = 0;
        if (objComponent6 == null) {
            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.resolveSize(0, 0) + 52, (char) View.combineMeasuredStates(0, 0), 4191 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), -910167970, false, $$c((short) -1, (short) 5, (short) 0), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
        int i11 = 1771590243;
        if (setPivotYN16904) {
            int i12 = $11 + 9;
            $10 = i12 % 128;
            int i13 = i12 % 2;
            cgVar.vD14832N6715 = bArr.length;
            char[] cArr3 = new char[cgVar.vD14832N6715];
            cgVar.setPivotYN16904 = 0;
            while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                cArr3[cgVar.setPivotYN16904] = (char) (cArr[bArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] + i] - iIntValue);
                Object[] objArr4 = new Object[i10];
                objArr4[1] = cgVar;
                objArr4[0] = cgVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1771590243);
                if (objComponent7 == null) {
                    int i14 = 53 - (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1));
                    char longPressTimeout = (char) (60693 - (ViewConfiguration.getLongPressTimeout() >> 16));
                    int touchSlop = (ViewConfiguration.getTouchSlop() >> 8) + 5955;
                    byte length2 = (byte) $$a.length;
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(i14, longPressTimeout, touchSlop, 992810496, false, $$c((short) -1, length2, (byte) (length2 - 4)), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                j = j;
                i10 = 2;
            }
            objArr[0] = new String(cArr3);
            return;
        }
        if (!vD14832N6715) {
            cgVar.vD14832N6715 = iArr.length;
            char[] cArr4 = new char[cgVar.vD14832N6715];
            cgVar.setPivotYN16904 = 0;
            while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                int i15 = $10 + 33;
                $11 = i15 % 128;
                if (i15 % 2 == 0) {
                    cArr4[cgVar.setPivotYN16904] = (char) (cArr[iArr[cgVar.vD14832N6715 >>> cgVar.setPivotYN16904] / i] << iIntValue);
                    i2 = cgVar.setPivotYN16904;
                } else {
                    cArr4[cgVar.setPivotYN16904] = (char) (cArr[iArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i] - iIntValue);
                    i2 = cgVar.setPivotYN16904 + 1;
                }
                cgVar.setPivotYN16904 = i2;
                int i16 = $10 + 107;
                $11 = i16 % 128;
                int i17 = i16 % 2;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        cgVar.vD14832N6715 = charArray.length;
        char[] cArr5 = new char[cgVar.vD14832N6715];
        cgVar.setPivotYN16904 = 0;
        while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
            int i18 = $10 + 51;
            $11 = i18 % 128;
            int i19 = i18 % 2;
            cArr5[cgVar.setPivotYN16904] = (char) (cArr[charArray[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i] - iIntValue);
            Object[] objArr5 = {cgVar, cgVar};
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(i11);
            if (objComponent8 == null) {
                int minimumFlingVelocity = 52 - (ViewConfiguration.getMinimumFlingVelocity() >> 16);
                char cLastIndexOf = (char) (60692 - TextUtils.lastIndexOf("", '0', 0));
                int i20 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 5954;
                byte length3 = (byte) $$a.length;
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(minimumFlingVelocity, cLastIndexOf, i20, 992810496, false, $$c((short) -1, length3, (byte) (length3 - 4)), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent8).invoke(null, objArr5);
            i11 = 1771590243;
        }
        objArr[0] = new String(cArr5);
    }

    static {
        init$0();
        $10 = 0;
        $11 = 1;
        component5 = -5382152050969292226L;
        component9 = new char[]{30182, 30189, 30172, 30168, 30093, 30087, 30089, 30090, 30080, 30011, 30183, 30084, 30201, 30100, 30082, 30159, 30186, 30196, 30198, 30200, 30157, 30086, 30103, 30099, 30091, 30092, 30187, 30094, 30188, 30176, 30085, 30102, 30081, 30101, 30096, 30181, 30195, 30164, 30155, 30160};
        D8871 = 1313764635;
        vD14832N6715 = true;
        setPivotYN16904 = true;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] component5(android.content.Context r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 2265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.t.component5(android.content.Context, int, int):java.lang.Object[]");
    }
}
