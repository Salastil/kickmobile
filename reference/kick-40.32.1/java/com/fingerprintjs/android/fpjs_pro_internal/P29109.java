package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public final class P29109 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static char[] component5;
    private static int component8;
    private static char component9;
    private static int[] setPivotYN16904;
    private static int setTopP6481;
    private final String D8871;
    private final long vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r7, byte r8, int r9) {
        /*
            int r7 = r7 + 4
            int r8 = r8 * 4
            int r8 = 1 - r8
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.P29109.$$c
            int r9 = 122 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r9 = r7
            r3 = r8
            r4 = r2
            goto L29
        L13:
            r3 = r2
        L14:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r8) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L23:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r6
        L29:
            int r7 = r7 + r3
            r3 = r9
            r9 = r7
            r7 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.P29109.$$e(byte, byte, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void c(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 5
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.P29109.$$a
            int r8 = 15 - r8
            int r7 = 115 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r7
            r4 = r2
            r7 = r6
            goto L2a
        L13:
            r3 = r2
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r5
        L2a:
            int r3 = r3 + r6
            int r6 = r3 + (-5)
            int r7 = r7 + 1
            r3 = r7
            r7 = r6
            r6 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.P29109.c(int, byte, byte, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{0, -128, -73, -32, Ascii.DLE, 17, 6, Ascii.SO, -9, Ascii.DC4, -31, Ascii.RS, Ascii.DC2, -2, 10, -22, -6, -24, 10, 8, -4, 9};
        $$b = 15;
    }

    static void init$1() {
        $$c = new byte[]{60, 71, -9, 52};
        $$d = 57;
    }

    public P29109(String str, long j) {
        this.D8871 = str;
        this.vD14832N6715 = j;
    }

    public final String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = component8;
        int i3 = ((i2 | 29) << 1) - (i2 ^ 29);
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        String str = this.D8871;
        int i5 = (i2 ^ 13) + ((i2 & 13) << 1);
        setTopP6481 = i5 % 128;
        int i6 = i5 % 2;
        return str;
    }

    public final long component5() {
        int i = 2 % 2;
        int i2 = component8 + 105;
        setTopP6481 = i2 % 128;
        int i3 = i2 % 2;
        long j = this.vD14832N6715;
        if (i3 == 0) {
            return j;
        }
        throw null;
    }

    private static void a(int[] iArr, int i, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        ci ciVar = new ci();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = setPivotYN16904;
        int i4 = 1299132072;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i5 = 0;
            while (i5 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(iArr2[i5])};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(i4);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(Color.alpha(0) + 52, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 40762), 6421 - View.resolveSize(0, 0), 534407883, false, $$e((byte) -1, (byte) 0, 0), new Class[]{Integer.TYPE});
                    }
                    iArr3[i5] = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                    i5++;
                    i4 = i4;
                    i2 = i2;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            iArr2 = iArr3;
        }
        int i6 = i2;
        int i7 = i4;
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = setPivotYN16904;
        if (iArr5 != null) {
            int i8 = $11 + 25;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i10 = 0; i10 < length3; i10++) {
                Object[] objArr3 = {Integer.valueOf(iArr5[i10])};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i7);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 52, (char) (40761 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), TextUtils.indexOf("", "") + 6421, 534407883, false, $$e((byte) -1, (byte) 0, 0), new Class[]{Integer.TYPE});
                }
                iArr6[i10] = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
            }
            int i11 = $10 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            $11 = i11 % 128;
            int i12 = i11 % 2;
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        ciVar.component5 = 0;
        while (ciVar.component5 < iArr.length) {
            int i13 = 16;
            cArr[0] = (char) (iArr[ciVar.component5] >> 16);
            char c = 1;
            cArr[1] = (char) iArr[ciVar.component5];
            cArr[i6] = (char) (iArr[ciVar.component5 + 1] >> 16);
            char c2 = 3;
            cArr[3] = (char) iArr[ciVar.component5 + 1];
            ciVar.vD14832N6715 = (cArr[0] << 16) + cArr[1];
            ciVar.setPivotYN16904 = (cArr[i6] << 16) + cArr[3];
            ci.setPivotYN16904(iArr4);
            int i14 = $11 + 35;
            $10 = i14 % 128;
            int i15 = i14 % 2;
            int i16 = 0;
            while (i16 < i13) {
                ciVar.vD14832N6715 ^= iArr4[i16];
                int iD8871 = ci.D8871(ciVar.vD14832N6715);
                Object[] objArr4 = new Object[4];
                objArr4[c2] = ciVar;
                objArr4[i6] = ciVar;
                objArr4[c] = Integer.valueOf(iD8871);
                objArr4[0] = ciVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(63485357);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(86 - (Process.myTid() >> 22), (char) (ViewConfiguration.getFadingEdgeLength() >> i13), 249 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 1367208398, false, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue();
                ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                ciVar.setPivotYN16904 = iIntValue;
                i16++;
                i13 = i13;
                c = c;
                c2 = c2;
            }
            char c3 = c;
            char c4 = c2;
            int i17 = ciVar.vD14832N6715;
            ciVar.vD14832N6715 = ciVar.setPivotYN16904;
            ciVar.setPivotYN16904 = i17;
            ciVar.setPivotYN16904 ^= iArr4[i13];
            ciVar.vD14832N6715 ^= iArr4[17];
            int i18 = ciVar.vD14832N6715;
            int i19 = ciVar.setPivotYN16904;
            cArr[0] = (char) (ciVar.vD14832N6715 >>> 16);
            cArr[c3] = (char) ciVar.vD14832N6715;
            cArr[i6] = (char) (ciVar.setPivotYN16904 >>> 16);
            cArr[c4] = (char) ciVar.setPivotYN16904;
            ci.setPivotYN16904(iArr4);
            cArr2[ciVar.component5 * 2] = cArr[0];
            cArr2[(ciVar.component5 * 2) + 1] = cArr[c3];
            cArr2[(ciVar.component5 * 2) + 2] = cArr[i6];
            cArr2[(ciVar.component5 * 2) + 3] = cArr[c4];
            Object[] objArr5 = new Object[i6];
            objArr5[c3] = ciVar;
            objArr5[0] = ciVar;
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(743063861);
            if (objComponent8 == null) {
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16), 3578 - ExpandableListView.getPackedPositionChild(0L), 2130642262, false, $$e((byte) -1, (byte) 0, 54), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent8).invoke(null, objArr5);
            int i20 = $11 + 105;
            $10 = i20 % 128;
            i6 = 2;
            int i21 = i20 % 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    private static void b(int i, String str, byte b, Object[] objArr) throws Throwable {
        int i2;
        char c;
        int length;
        char[] cArr;
        int i3;
        char c2 = 2;
        int i4 = 2 % 2;
        char[] charArray = str != null ? str.toCharArray() : str;
        ce ceVar = new ce();
        char[] cArr2 = component5;
        long j = 0;
        char c3 = 5;
        if (cArr2 != null) {
            int i5 = $11 + 81;
            $10 = i5 % 128;
            if (i5 % 2 != 0) {
                length = cArr2.length;
                cArr = new char[length];
                i3 = 1;
            } else {
                length = cArr2.length;
                cArr = new char[length];
                i3 = 0;
            }
            while (i3 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i3])};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1083735746);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - ExpandableListView.getPackedPositionType(j), (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 8065), 3216 - ImageFormat.getBitsPerPixel(0), 304954017, false, $$e((byte) -1, (byte) 0, 5), new Class[]{Integer.TYPE});
                    }
                    cArr[i3] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    i3++;
                    j = j;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            cArr2 = cArr;
        } else {
            c2 = 2;
        }
        long j2 = j;
        Object[] objArr3 = {Integer.valueOf(component9)};
        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1083735746);
        char c4 = '\b';
        if (objComponent6 == null) {
            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getWindowTouchSlop() >> 8) + 52, (char) (8065 - (ViewConfiguration.getJumpTapTimeout() >> 16)), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 3217, 304954017, false, $$e((byte) -1, (byte) 0, 5), new Class[]{Integer.TYPE});
        }
        char cCharValue = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
        char[] cArr3 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr3[i2] = (char) (charArray[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            ceVar.component5 = 0;
            while (ceVar.component5 < i2) {
                ceVar.D8871 = charArray[ceVar.component5];
                ceVar.setPivotYN16904 = charArray[ceVar.component5 + 1];
                if (ceVar.D8871 == ceVar.setPivotYN16904) {
                    cArr3[ceVar.component5] = (char) (ceVar.D8871 - b);
                    cArr3[ceVar.component5 + 1] = (char) (ceVar.setPivotYN16904 - b);
                    c = c4;
                    c3 = c3;
                } else {
                    Object[] objArr4 = new Object[13];
                    objArr4[12] = ceVar;
                    c = c4;
                    objArr4[11] = Integer.valueOf(cCharValue);
                    objArr4[10] = ceVar;
                    objArr4[9] = ceVar;
                    objArr4[c] = Integer.valueOf(cCharValue);
                    objArr4[7] = ceVar;
                    objArr4[6] = ceVar;
                    objArr4[c3] = Integer.valueOf(cCharValue);
                    objArr4[4] = ceVar;
                    objArr4[3] = ceVar;
                    objArr4[c2] = Integer.valueOf(cCharValue);
                    objArr4[1] = ceVar;
                    objArr4[0] = ceVar;
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1087197054);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.getDefaultSize(0, 0), (char) (TextUtils.lastIndexOf("", '0', 0) + 47646), Process.getGidForName("") + 5215, 309857053, false, $$e((byte) -1, (byte) 0, 1), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                    }
                    if (((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue() == ceVar.component13) {
                        Object[] objArr5 = new Object[11];
                        objArr5[10] = ceVar;
                        objArr5[9] = Integer.valueOf(cCharValue);
                        objArr5[c] = ceVar;
                        objArr5[7] = Integer.valueOf(cCharValue);
                        objArr5[6] = Integer.valueOf(cCharValue);
                        objArr5[c3] = ceVar;
                        objArr5[4] = ceVar;
                        objArr5[3] = Integer.valueOf(cCharValue);
                        objArr5[c2] = Integer.valueOf(cCharValue);
                        objArr5[1] = ceVar;
                        objArr5[0] = ceVar;
                        Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1764120300);
                        if (objComponent8 == null) {
                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionChild(j2) + 53, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > j2 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j2 ? 0 : -1))), 5577 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 999494287, false, $$e((byte) -1, (byte) 0, 55), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                        }
                        int iIntValue = ((Integer) ((Method) objComponent8).invoke(null, objArr5)).intValue();
                        int i6 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                        cArr3[ceVar.component5] = cArr2[iIntValue];
                        cArr3[ceVar.component5 + 1] = cArr2[i6];
                    } else if (ceVar.component9 == ceVar.vD14832N6715) {
                        int i7 = $11 + 29;
                        $10 = i7 % 128;
                        int i8 = i7 % 2;
                        ceVar.N14263A23323 = ((ceVar.N14263A23323 + cCharValue) - 1) % cCharValue;
                        ceVar.component13 = ((ceVar.component13 + cCharValue) - 1) % cCharValue;
                        int i9 = (ceVar.component9 * cCharValue) + ceVar.N14263A23323;
                        int i10 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                        cArr3[ceVar.component5] = cArr2[i9];
                        cArr3[ceVar.component5 + 1] = cArr2[i10];
                    } else {
                        int i11 = (ceVar.component9 * cCharValue) + ceVar.component13;
                        int i12 = (ceVar.vD14832N6715 * cCharValue) + ceVar.N14263A23323;
                        cArr3[ceVar.component5] = cArr2[i11];
                        cArr3[ceVar.component5 + 1] = cArr2[i12];
                    }
                }
                ceVar.component5 += 2;
                c4 = c;
                c3 = c3;
            }
        }
        int i13 = $11 + 35;
        $10 = i13 % 128;
        int i14 = i13 % 2;
        for (int i15 = 0; i15 < i; i15++) {
            cArr3[i15] = (char) (cArr3[i15] ^ 13722);
        }
        objArr[0] = new String(cArr3);
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        setTopP6481 = 0;
        component8 = 1;
        component5 = new char[]{3900, 15050, 15096, 15048, 15089, 3897, 15093, 15053, 14986, 14981, 3901, 15094, 15007, 15041, 15061, 15049, 15069, 14987, 15075, 15044, 15023, 15043, 15058, 3902, 15098, 15059, 15084, 15057, 15054, 15082, 15083, 3899, 15068, 15102, 15056, 15047, 15042, 15062, 15055, 15076, 15063, 15080, 15040, 15052, 15051, 15046, 15073, 15078, 3898};
        component9 = (char) 3896;
        setPivotYN16904 = new int[]{2075115016, -955002951, -202783326, -2009052564, 1417057980, -291788416, 312299443, -1905846430, 463548429, -1269879856, 937891504, 822551032, 176182668, -622803263, 1886548083, -1390094015, -2081990862, 841327549};
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] component5(android.content.Context r51, int r52, int r53, int r54) {
        /*
            Method dump skipped, instruction units count: 9726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.P29109.component5(android.content.Context, int, int, int):java.lang.Object[]");
    }
}
