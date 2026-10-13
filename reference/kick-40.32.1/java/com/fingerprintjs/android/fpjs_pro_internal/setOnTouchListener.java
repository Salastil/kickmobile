package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class setOnTouchListener {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static long component5;
    private static int component8;
    private static int component9;
    private static int sG29839;
    private static long setPivotYN16904;
    private static int setTopP6481;
    private final String D8871;
    private final String vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(short r5, byte r6, short r7) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.setOnTouchListener.$$c
            int r7 = r7 * 2
            int r7 = 114 - r7
            int r6 = r6 * 3
            int r1 = 1 - r6
            int r5 = r5 * 2
            int r5 = r5 + 4
            byte[] r1 = new byte[r1]
            r2 = 0
            int r6 = 0 - r6
            if (r0 != 0) goto L19
            r4 = r5
            r7 = r6
            r3 = r2
            goto L29
        L19:
            r3 = r2
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            return r5
        L25:
            r4 = r0[r5]
            int r3 = r3 + 1
        L29:
            int r5 = r5 + 1
            int r7 = r7 + r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setOnTouchListener.$$e(short, byte, short):java.lang.String");
    }

    private static void c(short s, short s2, int i, Object[] objArr) {
        int i2 = s + 4;
        byte[] bArr = $$a;
        int i3 = s2 * 3;
        int i4 = (i * 2) + 99;
        byte[] bArr2 = new byte[i3 + 4];
        int i5 = i3 + 3;
        int i6 = -1;
        if (bArr == null) {
            i4 = i5 + (-i4) + 6;
            i6 = -1;
        }
        while (true) {
            int i7 = i6 + 1;
            i2++;
            bArr2[i7] = (byte) i4;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            } else {
                i4 = i4 + (-bArr[i2]) + 6;
                i6 = i7;
            }
        }
    }

    static void init$0() {
        $$a = new byte[]{62, 106, 120, -80, -6, 5, -3};
        $$b = 80;
    }

    static void init$1() {
        $$c = new byte[]{65, -118, 1, 100};
        $$d = 112;
    }

    public setOnTouchListener(String str, String str2) {
        this.vD14832N6715 = str;
        this.D8871 = str2;
    }

    public final String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = component9 + 73;
        int i3 = i2 % 128;
        setTopP6481 = i3;
        int i4 = i2 % 2;
        String str = this.vD14832N6715;
        if (i4 == 0) {
            throw null;
        }
        int i5 = i3 + 23;
        component9 = i5 % 128;
        int i6 = i5 % 2;
        return str;
    }

    public final String component5() {
        int i = 2 % 2;
        int i2 = component9;
        int i3 = i2 + 43;
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        String str = this.D8871;
        int i5 = i2 + 59;
        setTopP6481 = i5 % 128;
        int i6 = i5 % 2;
        return str;
    }

    private static void b(String str, int i, Object[] objArr) throws Throwable {
        char[] charArray;
        int i2 = 2 % 2;
        if (str != null) {
            charArray = str.toCharArray();
            int i3 = $10 + 37;
            $11 = i3 % 128;
            int i4 = i3 % 2;
        } else {
            charArray = str;
        }
        cl clVar = new cl();
        char[] pivotYN16904 = cl.setPivotYN16904(setPivotYN16904 ^ (-8731904840774042312L), charArray, i);
        clVar.vD14832N6715 = 4;
        while (clVar.vD14832N6715 < pivotYN16904.length) {
            int i5 = $11 + 51;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            clVar.setPivotYN16904 = clVar.vD14832N6715 - 4;
            int i7 = clVar.vD14832N6715;
            try {
                Object[] objArr2 = {Long.valueOf(pivotYN16904[clVar.vD14832N6715] ^ pivotYN16904[clVar.vD14832N6715 % 4]), Long.valueOf(clVar.setPivotYN16904), Long.valueOf(setPivotYN16904)};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(353813021);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - Color.red(0), (char) (43651 - ((byte) KeyEvent.getModifierMetaStateMask())), (ViewConfiguration.getJumpTapTimeout() >> 16) + 752, 1201899134, false, "t", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                }
                pivotYN16904[i7] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {clVar, clVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1575730918);
                if (objComponent6 == null) {
                    int maxKeyCode = (KeyEvent.getMaxKeyCode() >> 16) + 52;
                    char cLastIndexOf = (char) (TextUtils.lastIndexOf("", '0') + 1);
                    int jumpTapTimeout = 5420 - (ViewConfiguration.getJumpTapTimeout() >> 16);
                    byte b = (byte) ($$c[2] - 1);
                    byte b2 = b;
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(maxKeyCode, cLastIndexOf, jumpTapTimeout, 257882757, false, $$e(b, b2, b2), new Class[]{Object.class, Object.class});
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
        objArr[0] = new String(pivotYN16904, 4, pivotYN16904.length - 4);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:43:0x01cf  */
    private static void a(String str, int i, Object[] objArr) throws Throwable {
        Object obj;
        Throwable cause;
        int i2;
        int i3;
        int i4 = 2 % 2;
        int i5 = $10 + 111;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        char[] charArray = str != null ? str.toCharArray() : str;
        cb cbVar = new cb();
        cbVar.setPivotYN16904 = i;
        int length = charArray.length;
        long[] jArr = new long[length];
        cbVar.D8871 = 0;
        int i7 = $10 + 79;
        while (true) {
            $11 = i7 % 128;
            int i8 = i7 % 2;
            obj = null;
            if (cbVar.D8871 >= charArray.length) {
                break;
            }
            int i9 = cbVar.D8871;
            try {
                Object[] objArr2 = {Integer.valueOf(charArray[cbVar.D8871]), cbVar, cbVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1515487230);
                if (objComponent5 == null) {
                    int maximumFlingVelocity = (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 52;
                    char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.SYN);
                    int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 5956;
                    byte[] bArr = $$c;
                    i2 = 55223;
                    byte b = (byte) (bArr[2] - 1);
                    i3 = 2106881226;
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(maximumFlingVelocity, modifierMetaStateMask, iIndexOf, 148978589, false, $$e(b, b, (byte) bArr.length), new Class[]{Integer.TYPE, Object.class, Object.class});
                } else {
                    i2 = 55223;
                    i3 = 2106881226;
                }
                jArr[i9] = ((Long) ((Method) objComponent5).invoke(null, objArr2)).longValue() ^ (component5 ^ (-1805496993403714128L));
                Object[] objArr3 = {cbVar, cbVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i3);
                if (objComponent6 == null) {
                    int fadingEdgeLength = 52 - (ViewConfiguration.getFadingEdgeLength() >> 16);
                    char doubleTapTimeout = (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + i2);
                    int keyRepeatDelay = 3269 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                    byte b2 = (byte) ($$c[2] - 1);
                    byte b3 = b2;
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(fadingEdgeLength, doubleTapTimeout, keyRepeatDelay, 790704297, false, $$e(b2, b3, (byte) (b3 + 5)), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent6).invoke(null, objArr3);
                i7 = $10 + 95;
            } catch (Throwable th) {
                cause = th.getCause();
                if (cause != null) {
                    throw th;
                }
                throw cause;
            }
            cause = th.getCause();
            if (cause != null) {
                throw th;
            }
            throw cause;
        }
        char[] cArr = new char[length];
        cbVar.D8871 = 0;
        while (cbVar.D8871 < charArray.length) {
            int i10 = $11 + 75;
            $10 = i10 % 128;
            if (i10 % 2 != 0) {
                cArr[cbVar.D8871] = (char) jArr[cbVar.D8871];
                Object[] objArr4 = {cbVar, cbVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(2106881226);
                if (objComponent7 == null) {
                    int iCombineMeasuredStates = View.combineMeasuredStates(0, 0) + 52;
                    char fadingEdgeLength2 = (char) (55223 - (ViewConfiguration.getFadingEdgeLength() >> 16));
                    int i11 = 3270 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                    byte b4 = (byte) ($$c[2] - 1);
                    byte b5 = b4;
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(iCombineMeasuredStates, fadingEdgeLength2, i11, 790704297, false, $$e(b4, b5, (byte) (b5 + 5)), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                obj.hashCode();
                throw null;
            }
            cArr[cbVar.D8871] = (char) jArr[cbVar.D8871];
            Object[] objArr5 = {cbVar, cbVar};
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(2106881226);
            if (objComponent8 == null) {
                int i12 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 51;
                char cResolveSize = (char) (55223 - View.resolveSize(0, 0));
                int i13 = (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 3268;
                byte b6 = (byte) ($$c[2] - 1);
                byte b7 = b6;
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(i12, cResolveSize, i13, 790704297, false, $$e(b6, b7, (byte) (b7 + 5)), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent8).invoke(null, objArr5);
        }
        objArr[0] = new String(cArr);
    }

    public static void component5(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = setTopP6481 + 9;
        component9 = i2 % 128;
        int i3 = i2 % 2;
        long j3 = j ^ (j2 << 32);
        Object obj = null;
        u.class.getField("vD14832N6715").get(null);
        int i4 = setTopP6481 + 77;
        component9 = i4 % 128;
        int i5 = i4 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a("庮ꢾ늺벸蚡邴骔", 62983 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj2 = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj2, null);
            Object[] objArr3 = new Object[1];
            a("廪㨝霃", (ViewConfiguration.getTapTimeout() >> 16) + 25841, objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a("庨僴䈞", 3673 - View.resolveSizeAndState(0, 0, 0), objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
            int i6 = setTopP6481 + 3;
            component9 = i6 % 128;
            if (i6 % 2 == 0) {
                return;
            }
            obj.hashCode();
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    static void D8871() {
        setPivotYN16904 = 2466161926570256240L;
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        component8 = 0;
        sG29839 = 1;
        component9 = 0;
        setTopP6481 = 1;
        D8871();
        component5 = 9200755186229287784L;
        int i = component8 + 5;
        sG29839 = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:47:0x03a2 A[Catch: Exception -> 0x03d2, TRY_LEAVE, TryCatch #7 {Exception -> 0x03d2, blocks: (B:44:0x0385, B:47:0x03a2, B:49:0x03c3, B:51:0x03cb, B:52:0x03d1, B:48:0x03ac), top: B:93:0x0385, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:58:0x03f2 A[Catch: Exception -> 0x0422, TRY_LEAVE, TryCatch #6 {Exception -> 0x0422, blocks: (B:55:0x03d5, B:58:0x03f2, B:60:0x0413, B:62:0x041b, B:63:0x0421, B:59:0x03fc), top: B:92:0x03d5, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0425  */
    /* JADX WARN: Code duplicated, block: B:68:0x0431 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x0433  */
    /* JADX WARN: Code duplicated, block: B:71:0x047e  */
    /* JADX WARN: Code duplicated, block: B:92:0x03d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Object[] component9(int i, int i2) throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        String str;
        boolean zEquals;
        boolean zEquals2;
        int i3;
        int i4;
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        File file2;
        FileReader fileReader2;
        BufferedReader bufferedReader2;
        String[] strArr;
        int i5;
        int i6 = 2 % 2;
        int i7 = setTopP6481 + 51;
        component9 = i7 % 128;
        try {
            if (i7 % 2 != 0) {
                strArr = new String[3];
                Object[] objArr3 = new Object[1];
                b("\udee7춦㧮\ude8e첮힝ഺ舓랥亻ꐹ笱ೂ⅜㽽\uedd9\ue5e9顠噻䛵稓猋\ue09a", ViewConfiguration.getJumpTapTimeout() * 114, objArr3);
                strArr[0] = (String) objArr3[0];
                Object[] objArr4 = new Object[1];
                b("並좸\u1cfc輻Ⴉ튑⠅帅錹䮾脫ꜗ⡟⑂ᩨ㇔셲鵥獫髶底瘂", Color.green(0), objArr4);
                strArr[0] = (String) objArr4[0];
                i5 = 1;
            } else {
                Object[] objArr5 = new Object[1];
                b("\udee7춦㧮\ude8e첮힝ഺ舓랥亻ꐹ笱ೂ⅜㽽\uedd9\ue5e9顠噻䛵稓猋\ue09a", ViewConfiguration.getJumpTapTimeout() >> 16, objArr5);
                String str2 = (String) objArr5[0];
                Object[] objArr6 = new Object[1];
                b("並좸\u1cfc輻Ⴉ튑⠅帅錹䮾脫ꜗ⡟⑂ᩨ㇔셲鵥獫髶底瘂", Color.green(0), objArr6);
                strArr = new String[]{str2, (String) objArr6[0]};
                i5 = 0;
            }
            while (true) {
                if (i5 >= 2) {
                    objArr = new Object[]{new int[]{i}, null, new int[]{i}, new int[1]};
                    int iMyPid = Process.myPid();
                    int i8 = ~iMyPid;
                    int i9 = ~(331448413 | i8);
                    int i10 = i2 + 1791659845 + ((1277967616 | i9) * (-712)) + (((~(iMyPid | 1609416029)) | (~(i8 | (-1277967617)))) * (-712)) + (((-1579957521) | i9) * 712);
                    int i11 = (i10 << 13) ^ i10;
                    int i12 = i11 ^ (i11 >>> 17);
                    ((int[]) objArr[3])[0] = i12 ^ (i12 << 5);
                    break;
                }
                String str3 = strArr[i5];
                Object[] objArr7 = new Object[1];
                b("ቹ\ue57f⒨መ\uf6aaｙၜ렀笶晾를䅼쁖\u0984≖ퟶ⥼낵䬭糵", 1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr7);
                Class<?> cls = Class.forName((String) objArr7[0]);
                if (((Boolean) cls.getMethod(str3, null).invoke(cls, null)).booleanValue()) {
                    objArr = new Object[]{new int[]{i}, null, new int[]{i ^ 1}, new int[1]};
                    int i13 = ~(Process.myUid() | 1881450250);
                    int i14 = i2 + ((((-582621905) + (((-29955684) | i13) * (-220))) + ((i13 | (-1911404396)) * 220)) - 199083218);
                    int i15 = (i14 << 13) ^ i14;
                    int i16 = i15 ^ (i15 >>> 17);
                    ((int[]) objArr[3])[0] = i16 ^ (i16 << 5);
                    break;
                }
                i5++;
            }
        } catch (Exception unused) {
            objArr = new Object[]{new int[]{i}, null, new int[]{i ^ 2}, new int[1]};
            int i17 = ~((int) Process.getElapsedCpuTime());
            int i18 = i2 + 1000719822 + (((~((-1831453815) | i17)) | (-79952120)) * (-983)) + (((~(i17 | (-79952120))) | 12728449) * 983) + 16;
            int i19 = (i18 << 13) ^ i18;
            int i20 = i19 ^ (i19 >>> 17);
            ((int[]) objArr[3])[0] = i20 ^ (i20 << 5);
        }
        if (i != ((int[]) objArr[2])[0]) {
            int i21 = component9 + 117;
            setTopP6481 = i21 % 128;
            int i22 = i21 % 2;
            return objArr;
        }
        try {
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1966788839);
            if (objComponent5 == null) {
                int iKeyCodeFromString = KeyEvent.keyCodeFromString("") + 52;
                char cCombineMeasuredStates = (char) (View.combineMeasuredStates(0, 0) + 3284);
                int tapTimeout = 6627 - (ViewConfiguration.getTapTimeout() >> 16);
                Object[] objArr8 = new Object[1];
                c((short) -1, (short) 0, 0, objArr8);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iKeyCodeFromString, cCombineMeasuredStates, tapTimeout, 663721092, false, (String) objArr8[0], new Class[0]);
            }
            long jLongValue = ((Long) ((Method) objComponent5).invoke(null, null)).longValue();
            long j = (-1020709944960L) + ((-1917) * jLongValue);
            long j2 = jLongValue ^ (-1);
            long j3 = (int) Runtime.getRuntime().totalMemory();
            long j4 = j3 ^ (-1);
            long j5 = 1852945606 + j + ((((j2 | j4) ^ (-1)) | (((-1063239526) | j3) ^ (-1))) * 959) + ((-959) * j2) + (959 * (((j3 | j2) ^ (-1)) | ((j4 | (-1063239526)) ^ (-1))));
            int i23 = ~((-69585060) | i);
            int i24 = ~i;
            int i25 = i23 | (~(1367641351 | i24));
            int i26 = ~(69585059 | i24);
            int i27 = ((int) (j5 >> 32)) & (1655077914 + ((i25 | i26) * (-516)) + (((~((-296964) | i)) | (~((-1367344389) | i24))) * 516) + ((1367344388 | i26) * 516));
            int i28 = 1334822819 + (((~((-1001233150) | i24)) | 570490961) * (-1188));
            int i29 = 570490961 | (~(1001233149 | i));
            int i30 = ~((-435993261) | i24);
            if ((i27 | (((int) j5) & (i28 + ((i29 | i30) * 594) + (((~(1001233149 | i24)) | 5251072 | i30) * 594)))) == 1) {
                objArr2 = new Object[]{new int[]{i}, null, new int[]{i ^ 10}, new int[]{i ^ (i << 5)}};
                int i31 = i2 + 1961619135 + ((1305327949 | i) * 614) + (((~((-459094545) | i24)) | 156055552 | (~(1452311389 | i24))) * (-1228)) + (((~((-303038993) | i24)) | (~(1608366941 | i24))) * 614) + 16;
                int i32 = (i31 << 13) ^ i31;
                int i33 = i32 ^ (i32 >>> 17);
            } else {
                objArr2 = new Object[]{new int[]{i}, null, new int[]{i}, new int[]{i ^ (i << 5)}};
                int i34 = i2 + (-716349437) + (((~((-190663849) | i)) | 156044328 | (~(1720742085 | i))) * (-754)) + (((~((-156044329) | i)) | (~(1876786413 | i24))) * (-754)) + (((-190663849) | i24) * 754);
                int i35 = (i34 << 13) ^ i34;
                int i36 = i35 ^ (i35 >>> 17);
            }
            if (i != ((int[]) objArr2[2])[0]) {
                int i37 = setTopP6481 + 39;
                component9 = i37 % 128;
                int i38 = i37 % 2;
                return objArr2;
            }
            try {
                Object[] objArr9 = new Object[1];
                b("\ue6ed㏎ﲱ\ue6c2傳⧵졘Ḙ迢냍慤\ue739㓃\udf23嗀熄\udde9昃錣\udafe䈊贩◕ꎙ\ueb2cᑅ뻨ಥ遊ꋩ垂镞㥿즔\ue8a4繥꾙僙腕윙咬ￅᩤ倹", ViewConfiguration.getKeyRepeatDelay() >> 16, objArr9);
                File file3 = new File((String) objArr9[0]);
                try {
                    if (file3.canRead()) {
                        FileReader fileReader3 = new FileReader(file3);
                        BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                        try {
                            String line = bufferedReader3.readLine();
                            Object[] objArr10 = new Object[1];
                            b("ﾯ餯\ue18a\uffc1\ud90e茈핪", KeyEvent.getMaxKeyCode() >> 16, objArr10);
                            if (line.equals((String) objArr10[0])) {
                                fileReader3.close();
                                bufferedReader3.close();
                            } else {
                                fileReader3.close();
                                bufferedReader3.close();
                                str = line;
                            }
                            Object[] objArr11 = new Object[1];
                            b("\u0383鑡뭡ά㺊蹙较瀽櫀ᜦ⚢褋톰磆뷚ῷ㢑솧퓴듞Ꜭ⫏戅춠โ돪老抭甦ԇၐﭰ\udc0f測꽵", (-1) - Process.getGidForName(""), objArr11);
                            file2 = new File((String) objArr11[0]);
                            if (file2.canRead()) {
                                fileReader2 = new FileReader(file2);
                                bufferedReader2 = new BufferedReader(fileReader2);
                                try {
                                    String line2 = bufferedReader2.readLine();
                                    Object[] objArr12 = new Object[1];
                                    b("近쿛仰迠䥐", Process.myPid() >> 22, objArr12);
                                    zEquals = line2.equals((String) objArr12[0]);
                                    fileReader2.close();
                                    bufferedReader2.close();
                                } catch (Throwable th) {
                                    fileReader2.close();
                                    bufferedReader2.close();
                                    throw th;
                                }
                            } else {
                                zEquals = false;
                            }
                            if (zEquals) {
                                try {
                                    Object[] objArr13 = new Object[1];
                                    b("䕉欏\uef06䕦矒焴\udbef㥹ⱆ\ue80c狓쁘靧蟢\ue9ba囥繍㻂肔ﶟ\ue1ae헨㙢蓸䢈䲄굟⯄㏮﨨䐢눸髈酄ײַ处మ࠘鋹\ue064", ViewConfiguration.getDoubleTapTimeout() >> 16, objArr13);
                                    file = new File((String) objArr13[0]);
                                    if (file.canRead()) {
                                        fileReader = new FileReader(file);
                                        bufferedReader = new BufferedReader(fileReader);
                                        try {
                                            String line3 = bufferedReader.readLine();
                                            Object[] objArr14 = new Object[1];
                                            b("近쿛仰迠䥐", ViewConfiguration.getPressedStateDuration() >> 16, objArr14);
                                            zEquals2 = line3.equals((String) objArr14[0]);
                                            fileReader.close();
                                            bufferedReader.close();
                                        } catch (Throwable th2) {
                                            fileReader.close();
                                            bufferedReader.close();
                                            throw th2;
                                        }
                                    } else {
                                        zEquals2 = false;
                                    }
                                } catch (Exception unused2) {
                                    zEquals2 = false;
                                }
                                if (zEquals2) {
                                    i3 = component9;
                                    i4 = i3 + 47;
                                    setTopP6481 = i4 % 128;
                                    if (i4 % 2 != 0) {
                                        throw null;
                                    }
                                    if (str != null) {
                                        int i39 = i3 + 123;
                                        setTopP6481 = i39 % 128;
                                        int i40 = i39 % 2;
                                        Object[] objArr15 = {new int[]{i}, str, new int[]{i ^ 20}, new int[]{i ^ (i << 5)}};
                                        int i41 = i2 + ((((~((-50796506) | i)) | 16847433) * (-283)) - 1910705120) + ((~(i | (-33949073))) * 283) + 16;
                                        int i42 = i41 ^ (i41 << 13);
                                        int i43 = i42 ^ (i42 >>> 17);
                                        return objArr15;
                                    }
                                }
                            }
                            Object[] objArr16 = {new int[]{i}, null, new int[]{i}, new int[]{i ^ (i << 5)}};
                            int i44 = i2 + (((~(i | 463023107)) | 1448382826) * 56) + 2121121077 + ((463023107 | (~(1448382826 | i24))) * 56);
                            int i45 = i44 ^ (i44 << 13);
                            int i46 = i45 ^ (i45 >>> 17);
                            return objArr16;
                        } catch (Throwable th3) {
                            fileReader3.close();
                            bufferedReader3.close();
                            throw th3;
                        }
                    }
                    Object[] objArr17 = new Object[1];
                    b("\u0383鑡뭡ά㺊蹙较瀽櫀ᜦ⚢褋톰磆뷚ῷ㢑솧퓴듞Ꜭ⫏戅춠โ돪老抭甦ԇၐﭰ\udc0f測꽵", (-1) - Process.getGidForName(""), objArr17);
                    file2 = new File((String) objArr17[0]);
                    if (file2.canRead()) {
                        zEquals = false;
                    } else {
                        fileReader2 = new FileReader(file2);
                        bufferedReader2 = new BufferedReader(fileReader2);
                        String line4 = bufferedReader2.readLine();
                        Object[] objArr18 = new Object[1];
                        b("近쿛仰迠䥐", Process.myPid() >> 22, objArr18);
                        zEquals = line4.equals((String) objArr18[0]);
                        fileReader2.close();
                        bufferedReader2.close();
                    }
                } catch (Exception unused3) {
                    zEquals = false;
                }
            } catch (Exception unused4) {
            }
            str = null;
            if (zEquals) {
                Object[] objArr19 = new Object[1];
                b("䕉欏\uef06䕦矒焴\udbef㥹ⱆ\ue80c狓쁘靧蟢\ue9ba囥繍㻂肔ﶟ\ue1ae헨㙢蓸䢈䲄굟⯄㏮﨨䐢눸髈酄ײַ处మ࠘鋹\ue064", ViewConfiguration.getDoubleTapTimeout() >> 16, objArr19);
                file = new File((String) objArr19[0]);
                if (file.canRead()) {
                    zEquals2 = false;
                } else {
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);
                    String line5 = bufferedReader.readLine();
                    Object[] objArr110 = new Object[1];
                    b("近쿛仰迠䥐", ViewConfiguration.getPressedStateDuration() >> 16, objArr110);
                    zEquals2 = line5.equals((String) objArr110[0]);
                    fileReader.close();
                    bufferedReader.close();
                }
                if (zEquals2) {
                    i3 = component9;
                    i4 = i3 + 47;
                    setTopP6481 = i4 % 128;
                    if (i4 % 2 != 0) {
                        throw null;
                    }
                    if (str != null) {
                        int i310 = i3 + 123;
                        setTopP6481 = i310 % 128;
                        int i47 = i310 % 2;
                        Object[] objArr111 = {new int[]{i}, str, new int[]{i ^ 20}, new int[]{i43 ^ (i43 << 5)}};
                        int i48 = i2 + ((((~((-50796506) | i)) | 16847433) * (-283)) - 1910705120) + ((~(i | (-33949073))) * 283) + 16;
                        int i49 = i48 ^ (i48 << 13);
                        int i410 = i49 ^ (i49 >>> 17);
                        return objArr111;
                    }
                }
            }
            Object[] objArr112 = {new int[]{i}, null, new int[]{i}, new int[]{i46 ^ (i46 << 5)}};
            int i411 = i2 + (((~(i | 463023107)) | 1448382826) * 56) + 2121121077 + ((463023107 | (~(1448382826 | i24))) * 56);
            int i412 = i411 ^ (i411 << 13);
            int i413 = i412 ^ (i412 >>> 17);
            return objArr112;
        } catch (Throwable th4) {
            Throwable cause = th4.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th4;
        }
    }
}
