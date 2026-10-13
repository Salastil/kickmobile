package com.fingerprintjs.android.fpjs_pro;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import com.facebook.common.callercontext.ContextChain;
import com.fingerprintjs.android.fpjs_pro_internal.cb;
import com.fingerprintjs.android.fpjs_pro_internal.cn;
import com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/Failed;", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "", "requestId", "errorDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Failed extends Error {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static long D8871;
    private static int N14263A23323;
    private static int component5;
    private static long component9;
    private static int setPivotYN16904;
    private static char vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r6, short r7, int r8) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 4
            byte[] r0 = com.fingerprintjs.android.fpjs_pro.Failed.$$c
            int r6 = r6 * 4
            int r6 = r6 + 1
            int r8 = r8 + 102
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r8
            r5 = r2
            r8 = r6
            goto L25
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L23:
            r3 = r0[r7]
        L25:
            int r8 = r8 + r3
            int r7 = r7 + 1
            r3 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro.Failed.$$e(short, short, int):java.lang.String");
    }

    private static void a(byte b, short s, short s2, Object[] objArr) {
        int i = s + 97;
        int i2 = 7 - (b * 3);
        int i3 = s2 * 3;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[4 - i3];
        int i4 = 3 - i3;
        int i5 = -1;
        if (bArr == null) {
            i = i2 + i4 + 6;
            i2++;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i6 = i;
            int i7 = i2 + 1;
            i = i6 + bArr[i2] + 6;
            i2 = i7;
        }
    }

    static void init$0() {
        $$a = new byte[]{57, -85, -86, -123, 6, -5, 3};
        $$b = 116;
    }

    static void init$1() {
        $$c = new byte[]{Ascii.US, -43, -84, -74};
        $$d = 66;
    }

    public Failed(String str, String str2) {
        super(str, str2, null);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private static void c(String str, int i, Object[] objArr) throws Throwable {
        Object charArray;
        int i2;
        long j;
        int i3 = 2 % 2;
        int i4 = $11 + 69;
        $10 = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 9 / 0;
            if (str != null) {
                charArray = str.toCharArray();
            } else {
                charArray = str;
            }
        } else if (str != null) {
            charArray = str.toCharArray();
        } else {
            charArray = str;
        }
        char[] cArr = (char[]) charArray;
        cb cbVar = new cb();
        cbVar.setPivotYN16904 = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        cbVar.D8871 = 0;
        while (cbVar.D8871 < cArr.length) {
            int i6 = $10 + 3;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
                int i7 = cbVar.D8871;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[cbVar.D8871]), cbVar, cbVar};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                    if (objComponent5 == null) {
                        i2 = 2106881226;
                        j = -1805496993403714128L;
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.indexOf("", ""), (char) (ImageFormat.getBitsPerPixel(0) + 60694), Color.blue(0) + 5955, 148978589, false, $$e((short) 0, (short) 0, (byte) $$c.length), new Class[]{Integer.TYPE, Object.class, Object.class});
                    } else {
                        i2 = 2106881226;
                        j = -1805496993403714128L;
                    }
                    jArr[i7] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() & (D8871 * j);
                    Object[] objArr3 = {cbVar, cbVar};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i2);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(KeyEvent.keyCodeFromString("") + 52, (char) (Color.green(0) + 55223), 3269 - (ViewConfiguration.getWindowTouchSlop() >> 8), 790704297, false, $$e((short) 0, (short) 0, 2), new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent6).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } else {
                int i8 = cbVar.D8871;
                Object[] objArr4 = {Integer.valueOf(cArr[cbVar.D8871]), cbVar, cbVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 52, (char) (60693 - (ViewConfiguration.getWindowTouchSlop() >> 8)), View.resolveSizeAndState(0, 0, 0) + 5955, 148978589, false, $$e((short) 0, (short) 0, (byte) $$c.length), new Class[]{Integer.TYPE, Object.class, Object.class});
                }
                jArr[i8] = ((Long) ((Method) objComponent7).invoke(null, objArr4)).longValue() ^ (D8871 ^ (-1805496993403714128L));
                Object[] objArr5 = {cbVar, cbVar};
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                if (objComponent8 == null) {
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getLongPressTimeout() >> 16) + 52, (char) (55223 - View.MeasureSpec.getMode(0)), 3269 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 790704297, false, $$e((short) 0, (short) 0, 2), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent8).invoke(null, objArr5);
            }
        }
        char[] cArr2 = new char[length];
        cbVar.D8871 = 0;
        int i9 = $11 + 7;
        $10 = i9 % 128;
        int i10 = i9 % 2;
        while (cbVar.D8871 < cArr.length) {
            int i11 = $11 + 29;
            $10 = i11 % 128;
            if (i11 % 2 != 0) {
                cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
                Object[] objArr6 = {cbVar, cbVar};
                Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                if (objComponent9 == null) {
                    objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (Color.blue(0) + 55223), View.resolveSize(0, 0) + 3269, 790704297, false, $$e((short) 0, (short) 0, 2), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent9).invoke(null, objArr6);
                int i12 = 70 / 0;
            } else {
                cArr2[cbVar.D8871] = (char) jArr[cbVar.D8871];
                Object[] objArr7 = {cbVar, cbVar};
                Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                if (objComponent10 == null) {
                    objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 52, (char) (55224 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 3269 - TextUtils.indexOf("", "", 0), 790704297, false, $$e((short) 0, (short) 0, 2), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent10).invoke(null, objArr7);
            }
        }
        objArr[0] = new String(cArr2);
    }

    private static void b(String str, int i, String str2, char c, String str3, Object[] objArr) throws Throwable {
        char[] charArray;
        int i2 = 2 % 2;
        int i3 = $11 + GapComposerKt.nodeKey;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        char[] charArray2 = str3 != null ? str3.toCharArray() : str3;
        char[] charArray3 = str2 != null ? str2.toCharArray() : str2;
        if (str != null) {
            int i5 = $11 + 73;
            $10 = i5 % 128;
            if (i5 % 2 != 0) {
                str.toCharArray();
                throw null;
            }
            charArray = str.toCharArray();
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        cn cnVar = new cn();
        int length = charArray2.length;
        char[] cArr2 = new char[length];
        int length2 = charArray3.length;
        char[] cArr3 = new char[length2];
        short s = 0;
        System.arraycopy(charArray2, 0, cArr2, 0, length);
        System.arraycopy(charArray3, 0, cArr3, 0, length2);
        cArr2[0] = (char) (cArr2[0] ^ c);
        cArr3[2] = (char) (cArr3[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr4 = new char[length3];
        cnVar.setPivotYN16904 = 0;
        while (cnVar.setPivotYN16904 < length3) {
            try {
                Object[] objArr2 = {cnVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(528238139);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(Color.argb((int) s, (int) s, (int) s, (int) s) + 86, (char) (55624 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), 423 - Color.argb((int) s, (int) s, (int) s, (int) s), 1305018968, false, "c", new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {cnVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1013236775);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((KeyEvent.getMaxKeyCode() >> 16) + 52, (char) (55223 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), 3269 - TextUtils.indexOf("", ""), -1859223622, false, $$e(s, s, 1), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                int i6 = cArr2[cnVar.setPivotYN16904 % 4] * 32718;
                Object[] objArr4 = new Object[3];
                objArr4[2] = Integer.valueOf(cArr3[iIntValue]);
                objArr4[1] = Integer.valueOf(i6);
                objArr4[s] = cnVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-523427508);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.getOffsetAfter("", s), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 42042), 2309 - (AudioTrack.getMaxVolume() > 0 ? 1 : (AudioTrack.getMaxVolume() == 0 ? 0 : -1)), -1300732625, false, ContextChain.TAG_INFRA, new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                int i7 = cArr2[iIntValue2] * 32718;
                Object[] objArr5 = new Object[2];
                objArr5[1] = Integer.valueOf(cArr3[iIntValue]);
                objArr5[s] = Integer.valueOf(i7);
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1175171274);
                if (objComponent8 == null) {
                    short s2 = s;
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (58884 - (ExpandableListView.getPackedPositionForChild(s2, s2) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(s2, s2) == 0L ? 0 : -1))), (ViewConfiguration.getPressedStateDuration() >> 16) + 6886, 348058793, false, $$e(s2, s2, s2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr3[iIntValue2] = ((Character) ((Method) objComponent8).invoke(null, objArr5)).charValue();
                cArr2[iIntValue2] = cnVar.D8871;
                cArr4[cnVar.setPivotYN16904] = (char) (((((long) (cArr2[iIntValue2] ^ cArr[cnVar.setPivotYN16904])) ^ (component9 ^ (-8233799196330309486L))) ^ ((long) ((int) (((long) setPivotYN16904) ^ (-8233799196330309486L))))) ^ ((long) ((char) (((long) vD14832N6715) ^ (-8233799196330309486L)))));
                cnVar.setPivotYN16904++;
                s = 0;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArr4);
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        component5 = 0;
        N14263A23323 = 1;
        component9 = -8233799196330309486L;
        setPivotYN16904 = 1725286546;
        vD14832N6715 = (char) 1324;
        D8871 = 3204162386603768234L;
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] vD14832N6715$6ed60776(int r64, java.lang.Object r65) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 16082
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro.Failed.vD14832N6715$6ed60776(int, java.lang.Object):java.lang.Object[]");
    }
}
