package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public final class aj {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static char[] D8871;
    private static boolean component5;
    private static boolean component9;
    private static int setPivotYN16904;
    private static int[] vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(int r6, byte r7, byte r8) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.aj.$$a
            int r8 = r8 + 66
            int r7 = r7 * 3
            int r1 = r7 + 1
            int r6 = r6 * 4
            int r6 = 3 - r6
            byte[] r1 = new byte[r1]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r4 = r2
            r8 = r6
            goto L2a
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L23:
            int r6 = r6 + 1
            r3 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r5
        L2a:
            int r6 = r6 + r3
            r3 = r8
            r8 = r6
            r6 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.aj.$$c(int, byte, byte):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{10, -109, 37, Ascii.GS};
        $$b = 71;
    }

    private static void a(int[] iArr, int i, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        ci ciVar = new ci();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = vD14832N6715;
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
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 51, (char) (Color.blue(0) + 40761), 6421 - ExpandableListView.getPackedPositionGroup(0L), 534407883, false, $$c(0, (byte) 0, (byte) 56), new Class[]{Integer.TYPE});
                    }
                    iArr3[i5] = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                    i5++;
                    i4 = i4;
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
        int i6 = i4;
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = vD14832N6715;
        if (iArr5 != null) {
            int i7 = $10 + 15;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i9 = 0;
            while (i9 < length3) {
                int i10 = i2;
                Object[] objArr3 = {Integer.valueOf(iArr5[i9])};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i6);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf((CharSequence) "", '0') + 53, (char) (40760 - TextUtils.lastIndexOf("", '0')), View.MeasureSpec.getSize(0) + 6421, 534407883, false, $$c(0, (byte) 0, (byte) 56), new Class[]{Integer.TYPE});
                }
                iArr6[i9] = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                i9++;
                i2 = i10;
            }
            iArr5 = iArr6;
        }
        int i11 = i2;
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        ciVar.component5 = 0;
        while (ciVar.component5 < iArr.length) {
            int i12 = 16;
            cArr[0] = (char) (iArr[ciVar.component5] >> 16);
            char c = 1;
            cArr[1] = (char) iArr[ciVar.component5];
            cArr[i11] = (char) (iArr[ciVar.component5 + 1] >> 16);
            cArr[3] = (char) iArr[ciVar.component5 + 1];
            ciVar.vD14832N6715 = (cArr[0] << 16) + cArr[1];
            ciVar.setPivotYN16904 = (cArr[i11] << 16) + cArr[3];
            ci.setPivotYN16904(iArr4);
            int i13 = 0;
            while (i13 < i12) {
                ciVar.vD14832N6715 ^= iArr4[i13];
                int iD8871 = ci.D8871(ciVar.vD14832N6715);
                Object[] objArr4 = new Object[4];
                objArr4[3] = ciVar;
                objArr4[i11] = ciVar;
                objArr4[c] = Integer.valueOf(iD8871);
                objArr4[0] = ciVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(63485357);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(86 - TextUtils.getTrimmedLength(""), (char) Color.red(0), Color.argb(0, 0, 0, 0) + 250, 1367208398, false, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                }
                int iIntValue = ((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue();
                ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                ciVar.setPivotYN16904 = iIntValue;
                i13++;
                i12 = i12;
                c = c;
            }
            char c2 = c;
            int i14 = ciVar.vD14832N6715;
            ciVar.vD14832N6715 = ciVar.setPivotYN16904;
            ciVar.setPivotYN16904 = i14;
            ciVar.setPivotYN16904 ^= iArr4[i12];
            ciVar.vD14832N6715 ^= iArr4[17];
            int i15 = ciVar.vD14832N6715;
            int i16 = ciVar.setPivotYN16904;
            cArr[0] = (char) (ciVar.vD14832N6715 >>> 16);
            cArr[c2] = (char) ciVar.vD14832N6715;
            cArr[i11] = (char) (ciVar.setPivotYN16904 >>> 16);
            cArr[3] = (char) ciVar.setPivotYN16904;
            ci.setPivotYN16904(iArr4);
            cArr2[ciVar.component5 * 2] = cArr[0];
            cArr2[(ciVar.component5 * 2) + 1] = cArr[c2];
            cArr2[(ciVar.component5 * 2) + 2] = cArr[i11];
            cArr2[(ciVar.component5 * 2) + 3] = cArr[3];
            Object[] objArr5 = new Object[i11];
            objArr5[c2] = ciVar;
            objArr5[0] = ciVar;
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(743063861);
            if (objComponent8 == null) {
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - Color.red(0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 3580 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 2130642262, false, $$c(0, (byte) 0, (byte) 2), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent8).invoke(null, objArr5);
            int i17 = $10 + 97;
            $11 = i17 % 128;
            if (i17 % 2 == 0) {
                int i18 = 3 / 4;
            }
            i11 = 2;
        }
        String str = new String(cArr2, 0, i);
        int i19 = $11 + 67;
        $10 = i19 % 128;
        int i20 = i19 % 2;
        objArr[0] = str;
    }

    private static void b(String str, int i, int[] iArr, String str2, Object[] objArr) throws Throwable {
        String str3 = str2;
        int i2 = 2;
        int i3 = 2 % 2;
        Object bytes = str3;
        if (str3 != null) {
            bytes = str3.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        char[] charArray = str != null ? str.toCharArray() : str;
        cg cgVar = new cg();
        char[] cArr = D8871;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i4 = 0; i4 < length; i4++) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[i4])};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-180220690);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34441), 5524 - View.getDefaultSize(0, 0), -1476966259, false, $$c(0, (byte) 0, (byte) 0), new Class[]{Integer.TYPE});
                    }
                    cArr2[i4] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
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
        Object[] objArr3 = {Integer.valueOf(setPivotYN16904)};
        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1693797315);
        if (objComponent6 == null) {
            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 52, (char) TextUtils.getTrimmedLength(""), (Process.myTid() >> 22) + 4192, -910167970, false, $$c(0, (byte) 0, (byte) 5), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
        int i5 = 60693;
        int i6 = 1771590243;
        if (component5) {
            int i7 = $11 + 29;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            cgVar.vD14832N6715 = bArr.length;
            char[] cArr3 = new char[cgVar.vD14832N6715];
            cgVar.setPivotYN16904 = 0;
            int i9 = $11 + 71;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                cArr3[cgVar.setPivotYN16904] = (char) (cArr[bArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] + i] - iIntValue);
                Object[] objArr4 = {cgVar, cgVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i6);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((KeyEvent.getMaxKeyCode() >> 16) + 52, (char) (i5 - View.MeasureSpec.getSize(0)), TextUtils.getOffsetBefore("", 0) + 5955, 992810496, false, $$c(0, (byte) 0, (byte) $$a.length), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                i5 = i5;
                i6 = i6;
            }
            objArr[0] = new String(cArr3);
            return;
        }
        if (!component9) {
            cgVar.vD14832N6715 = iArr.length;
            char[] cArr4 = new char[cgVar.vD14832N6715];
            cgVar.setPivotYN16904 = 0;
            while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                cArr4[cgVar.setPivotYN16904] = (char) (cArr[iArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i] - iIntValue);
                cgVar.setPivotYN16904++;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        cgVar.vD14832N6715 = charArray.length;
        char[] cArr5 = new char[cgVar.vD14832N6715];
        cgVar.setPivotYN16904 = 0;
        while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
            cArr5[cgVar.setPivotYN16904] = (char) (cArr[charArray[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i] - iIntValue);
            Object[] objArr5 = new Object[i2];
            objArr5[1] = cgVar;
            objArr5[0] = cgVar;
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1771590243);
            if (objComponent8 == null) {
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.getOffsetAfter("", 0), (char) (60693 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), 5954 - ImageFormat.getBitsPerPixel(0), 992810496, false, $$c(0, (byte) 0, (byte) $$a.length), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent8).invoke(null, objArr5);
            i2 = i2;
        }
        String str4 = new String(cArr5);
        int i11 = $11 + 23;
        $10 = i11 % 128;
        int i12 = i11 % 2;
        objArr[0] = str4;
    }

    static {
        init$0();
        $10 = 0;
        $11 = 1;
        vD14832N6715 = new int[]{-2129065002, -504373586, 1982008759, 2047959173, 996663073, -732613926, 1953536583, 444610573, -561513470, 1161772965, -327425085, -525251781, -1350958781, 591616911, 547043520, 1926674544, 1381149078, -1336598368};
        D8871 = new char[]{29739, 29756, 29750, 29752, 29757, 29747, 29820, 29737, 29894, 29751, 29754, 29759, 29722, 29745, 29749, 29715, 29748, 29753, 29895, 29730, 29703, 29818, 29699, 29721, 29704, 29891, 29707, 29736, 29744, 29758};
        setPivotYN16904 = 1313764426;
        component9 = true;
        component5 = true;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] component9(android.content.Context r28, int r29, int r30) {
        /*
            Method dump skipped, instruction units count: 2740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.aj.component9(android.content.Context, int, int):java.lang.Object[]");
    }
}
