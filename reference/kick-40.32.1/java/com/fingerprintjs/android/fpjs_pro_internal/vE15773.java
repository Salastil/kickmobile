package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface vE15773 {
    D8871<vD14832N6715, Throwable> D8871(byte[] bArr, rV4669 rv4669);

    public static final class vD14832N6715 {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static int $10;
        private static int $11;
        private static int D8871;
        private static int component5;
        private static char[] vD14832N6715;
        private final setSystemGestureExclusionRects component9;
        private final rV4669 setPivotYN16904;

        /* JADX WARN: Code duplicated, block: B:10:0x0020  */
        /* JADX WARN: Code duplicated, block: B:8:0x001a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0020 -> B:11:0x0024). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0020
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(int r6, int r7, short r8) {
            /*
                byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.vE15773.vD14832N6715.$$a
                int r8 = r8 + 4
                int r6 = r6 + 112
                int r7 = r7 * 2
                int r7 = r7 + 1
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L12
                r3 = r7
                r5 = r2
                goto L24
            L12:
                r3 = r2
            L13:
                byte r4 = (byte) r6
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r7) goto L20
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                return r6
            L20:
                int r8 = r8 + 1
                r3 = r0[r8]
            L24:
                int r6 = r6 + r3
                r3 = r5
                goto L13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.vE15773.vD14832N6715.$$c(int, int, short):java.lang.String");
        }

        static void init$0() {
            $$a = new byte[]{Ascii.DC2, 102, 73, -44};
            $$b = 210;
        }

        public vD14832N6715(rV4669 rv4669, setSystemGestureExclusionRects setsystemgestureexclusionrects) {
            this.setPivotYN16904 = rv4669;
            this.component9 = setsystemgestureexclusionrects;
        }

        public final rV4669 D8871() {
            int i = 2 % 2;
            int i2 = D8871 + 41;
            int i3 = i2 % 128;
            component5 = i3;
            int i4 = i2 % 2;
            rV4669 rv4669 = this.setPivotYN16904;
            int i5 = i3 + 113;
            D8871 = i5 % 128;
            int i6 = i5 % 2;
            return rv4669;
        }

        public final setSystemGestureExclusionRects component9() {
            int i = 2 % 2;
            int i2 = D8871;
            int i3 = i2 + 67;
            component5 = i3 % 128;
            int i4 = i3 % 2;
            setSystemGestureExclusionRects setsystemgestureexclusionrects = this.component9;
            int i5 = i2 + 53;
            component5 = i5 % 128;
            int i6 = i5 % 2;
            return setsystemgestureexclusionrects;
        }

        private static void a(boolean z, String str, int[] iArr, Object[] objArr) throws Throwable {
            int i;
            byte b;
            char[] cArr;
            char c;
            String str2 = str;
            int i2 = 2;
            int i3 = 2 % 2;
            Object bytes = str2;
            if (str2 != null) {
                bytes = str2.getBytes("ISO-8859-1");
            }
            byte[] bArr = (byte[]) bytes;
            co coVar = new co();
            int i4 = 0;
            int i5 = iArr[0];
            int i6 = iArr[1];
            int i7 = iArr[2];
            int i8 = iArr[3];
            char[] cArr2 = vD14832N6715;
            char c2 = '0';
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i9 = 0;
                while (i9 < length) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr2[i9])};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1270499692);
                        if (objComponent5 == null) {
                            int i10 = i4;
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(58 - TextUtils.lastIndexOf("", c2), (char) (Color.rgb(i4, i4, i4) + 16777216), ImageFormat.getBitsPerPixel(i10) + 4458, 420416783, false, $$c(3, i10, (short) -1), new Class[]{Integer.TYPE});
                        }
                        cArr3[i9] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                        i9++;
                        bArr = bArr;
                        i4 = 0;
                        c2 = '0';
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr2 = cArr3;
            }
            byte[] bArr2 = bArr;
            char[] cArr4 = new char[i6];
            System.arraycopy(cArr2, i5, cArr4, 0, i6);
            if (bArr2 != null) {
                int i11 = $10 + 53;
                $11 = i11 % 128;
                if (i11 % 2 == 0) {
                    b = 1;
                    coVar.component5 = 1;
                    cArr = new char[i6];
                    c = 1;
                } else {
                    b = 1;
                    coVar.component5 = 0;
                    cArr = new char[i6];
                    c = 0;
                }
                while (coVar.component5 < i6) {
                    if (bArr2[coVar.component5] == b) {
                        int i12 = $10 + 3;
                        $11 = i12 % 128;
                        int i13 = i12 % 2;
                        int i14 = coVar.component5;
                        char c3 = cArr4[coVar.component5];
                        Object[] objArr3 = new Object[i2];
                        objArr3[1] = Integer.valueOf(c);
                        objArr3[0] = Integer.valueOf(c3);
                        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1589966753);
                        if (objComponent6 == null) {
                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - Color.blue(0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 15380), KeyEvent.normalizeMetaState(0) + 2256, -208778180, false, "q", new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr[i14] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                    } else {
                        int i15 = coVar.component5;
                        Object[] objArr4 = {Integer.valueOf(cArr4[coVar.component5]), Integer.valueOf(c)};
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1656784792);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 50, (char) (KeyEvent.normalizeMetaState(0) + 27302), TextUtils.indexOf((CharSequence) "", '0', 0) + 2980, -813024245, false, $$c(0, 0, (short) -1), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        cArr[i15] = ((Character) ((Method) objComponent7).invoke(null, objArr4)).charValue();
                    }
                    c = cArr[coVar.component5];
                    Object[] objArr5 = {coVar, coVar};
                    Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(787585964);
                    if (objComponent8 == null) {
                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.combineMeasuredStates(0, 0) + 51, (char) (Process.getGidForName("") + 1), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 7092, 2084888527, false, $$c(7, 0, (short) -1), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent8).invoke(null, objArr5);
                    b = 1;
                    i2 = 2;
                }
                cArr4 = cArr;
            }
            if (i8 > 0) {
                int i16 = $10 + 61;
                $11 = i16 % 128;
                if (i16 % 2 == 0) {
                    char[] cArr5 = new char[i6];
                    i = 0;
                    System.arraycopy(cArr4, 0, cArr5, 1, i6);
                    int i17 = i6 << i8;
                    System.arraycopy(cArr5, 0, cArr4, i17, i8);
                    System.arraycopy(cArr5, i8, cArr4, 0, i17);
                } else {
                    i = 0;
                    char[] cArr6 = new char[i6];
                    System.arraycopy(cArr4, 0, cArr6, 0, i6);
                    int i18 = i6 - i8;
                    System.arraycopy(cArr6, 0, cArr4, i18, i8);
                    System.arraycopy(cArr6, i8, cArr4, 0, i18);
                }
            } else {
                i = 0;
            }
            if (z) {
                char[] cArr7 = new char[i6];
                coVar.component5 = i;
                while (coVar.component5 < i6) {
                    cArr7[coVar.component5] = cArr4[(i6 - coVar.component5) - 1];
                    coVar.component5++;
                }
                cArr4 = cArr7;
            }
            if (i7 > 0) {
                coVar.component5 = 0;
                while (coVar.component5 < i6) {
                    cArr4[coVar.component5] = (char) (cArr4[coVar.component5] - iArr[2]);
                    coVar.component5++;
                }
            }
            objArr[0] = new String(cArr4);
        }

        public static void D8871(long j, long j2) throws Throwable {
            int i = 2 % 2;
            long j3 = j ^ (j2 << 32);
            u.class.getField("vD14832N6715").get(null);
            int i2 = component5;
            int i3 = i2 + 73;
            D8871 = i3 % 128;
            int i4 = i3 % 2;
            int i5 = i2 + 57;
            D8871 = i5 % 128;
            int i6 = i5 % 2;
            try {
                Object[] objArr = {Long.valueOf(j3)};
                Object[] objArr2 = new Object[1];
                a(false, "\u0001\u0001\u0001\u0001\u0000\u0000\u0001", new int[]{0, 7, 195, 7}, objArr2);
                Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
                method.setAccessible(true);
                Object objInvoke = method.invoke(null, objArr);
                Object obj = w.class.getField("INSTANCE").get(null);
                Method method2 = w.class.getMethod("D8871", null);
                method2.setAccessible(true);
                Object objInvoke2 = method2.invoke(obj, null);
                Object[] objArr3 = new Object[1];
                a(false, "\u0001\u0000\u0000", new int[]{7, 3, 0, 0}, objArr3);
                Object[] objArr4 = {(String) objArr3[0], objInvoke};
                Object[] objArr5 = new Object[1];
                a(false, "\u0000\u0001\u0001", new int[]{10, 3, 0, 0}, objArr5);
                Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
                method3.setAccessible(true);
                method3.invoke(objInvoke2, objArr4);
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
            component5 = 0;
            D8871 = 1;
            vD14832N6715 = new char[]{46782, 46860, 46859, 46865, 46866, 46911, 46911, 46650, 46614, 46618, 46618, 46672, 46678};
        }
    }
}
