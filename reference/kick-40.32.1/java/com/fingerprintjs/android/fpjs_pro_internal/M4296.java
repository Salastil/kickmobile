package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class M4296 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static char D8871;
    private static int component13;
    private static char component5;
    private static int component9;
    private static char setPivotYN16904;
    private static char vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(short r6, byte r7, int r8) {
        /*
            int r8 = r8 * 2
            int r0 = r8 + 1
            int r6 = r6 * 2
            int r6 = r6 + 109
            int r7 = r7 + 4
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.M4296.$$a
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L15
            r3 = r7
            r6 = r8
            r4 = r2
            goto L2b
        L15:
            r3 = r2
        L16:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L21:
            int r3 = r3 + 1
            int r7 = r7 + 1
            r4 = r1[r7]
            r5 = r3
            r3 = r7
            r7 = r4
            r4 = r5
        L2b:
            int r6 = r6 + r7
            r7 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.M4296.$$c(short, byte, int):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{53, 108, 6, 98};
        $$b = 170;
    }

    private static void a(String str, int i, Object[] objArr) throws Throwable {
        int i2 = 2;
        int i3 = 2 % 2;
        int i4 = $11 + 19;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        char[] charArray = str != null ? str.toCharArray() : str;
        cj cjVar = new cj();
        char[] cArr = new char[charArray.length];
        short s = 0;
        cjVar.D8871 = 0;
        char[] cArr2 = new char[2];
        int i6 = $10 + 7;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        while (cjVar.D8871 < charArray.length) {
            cArr2[s] = charArray[cjVar.D8871];
            char c = 1;
            cArr2[1] = charArray[cjVar.D8871 + 1];
            int i8 = 58224;
            int i9 = s;
            while (i9 < 16) {
                char c2 = cArr2[c];
                char c3 = cArr2[s];
                char c4 = c;
                int i10 = (c3 + i8) ^ ((c3 << 4) + ((char) (((long) D8871) ^ 2653044645608467852L)));
                int i11 = c3 >>> 5;
                int i12 = i2;
                try {
                    Object[] objArr2 = new Object[4];
                    objArr2[3] = Integer.valueOf(setPivotYN16904);
                    objArr2[i12] = Integer.valueOf(i11);
                    objArr2[c4] = Integer.valueOf(i10);
                    objArr2[s] = Integer.valueOf(c2);
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), KeyEvent.getDeadChar(s, s) + 5420, -1101845982, false, $$c(s, (byte) -1, s), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    cArr2[c4] = cCharValue;
                    char c5 = cArr2[s];
                    int i13 = (cCharValue + i8) ^ ((cCharValue << 4) + ((char) (((long) vD14832N6715) ^ 2653044645608467852L)));
                    int i14 = cCharValue >>> 5;
                    Object[] objArr3 = new Object[4];
                    objArr3[3] = Integer.valueOf(component5);
                    objArr3[i12] = Integer.valueOf(i14);
                    objArr3[c4] = Integer.valueOf(i13);
                    objArr3[s] = Integer.valueOf(c5);
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-320442815);
                    if (objComponent6 == null) {
                        short s2 = s;
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((Process.myPid() >> 22) + 52, (char) (Process.myTid() >> 22), 5420 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), -1101845982, false, $$c(s2, (byte) -1, s2), new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    }
                    cArr2[0] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                    i8 -= 40503;
                    i9++;
                    c = c4;
                    i2 = i12;
                    s = 0;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            char c6 = c;
            cArr[cjVar.D8871] = cArr2[0];
            cArr[cjVar.D8871 + 1] = cArr2[c6];
            i2 = i2;
            Object[] objArr4 = new Object[i2];
            objArr4[c6] = cjVar;
            objArr4[0] = cjVar;
            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-417400915);
            if (objComponent7 == null) {
                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.combineMeasuredStates(0, 0) + 58, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 1187 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), -1247038514, false, "k", new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent7).invoke(null, objArr4);
            s = 0;
        }
        objArr[0] = new String(cArr, 0, i);
    }

    public static void D8871(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = component13 + 17;
        component9 = i2 % 128;
        int i3 = i2 % 2;
        long j3 = j ^ (j2 << 32);
        u.class.getField("vD14832N6715").get(null);
        int i4 = component9 + 27;
        component13 = i4 % 128;
        int i5 = i4 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a("劵\uec5a\uec7c摜అ\uee0b\uee32吔", 7 - View.MeasureSpec.getSize(0), objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a("澕鷬퓓軬", 3 - (ViewConfiguration.getLongPressTimeout() >> 16), objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a("숄蘀綕컉", (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2, objArr5);
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
        component9 = 0;
        component13 = 1;
        vD14832N6715 = (char) 16062;
        component5 = (char) 46211;
        D8871 = (char) 31740;
        setPivotYN16904 = (char) 55197;
    }
}
