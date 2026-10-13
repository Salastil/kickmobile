package com.fingerprintjs.android.fpjs_pro;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.common.callercontext.ContextChain;
import com.fingerprintjs.android.fpjs_pro_internal.cn;
import com.fingerprintjs.android.fpjs_pro_internal.setSystemGestureExclusionRectsL30479;
import java.lang.reflect.Method;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/NotAvailableWithoutUA;", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "", "requestId", "errorDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NotAvailableWithoutUA extends Error {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static int D8871;
    private static int component5;
    private static long component9;
    private static int setPivotYN16904;
    private static char vD14832N6715;

    private static String $$e(int i, byte b, short s) {
        int i2 = s * 3;
        byte[] bArr = $$c;
        int i3 = 103 - b;
        int i4 = i + 4;
        byte[] bArr2 = new byte[i2 + 1];
        int i5 = -1;
        if (bArr == null) {
            i3 = i4 + i2;
            i4 = i4;
            i5 = -1;
        }
        while (true) {
            int i6 = i5 + 1;
            bArr2[i6] = (byte) i3;
            int i7 = i4 + 1;
            if (i6 == i2) {
                return new String(bArr2, 0);
            }
            i3 = bArr[i7] + i3;
            i4 = i7;
            i5 = i6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0029
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 99 - r8
            int r7 = r7 * 4
            int r0 = r7 + 4
            byte[] r1 = com.fingerprintjs.android.fpjs_pro.NotAvailableWithoutUA.$$a
            int r6 = r6 + 4
            byte[] r0 = new byte[r0]
            int r7 = r7 + 3
            r2 = 0
            if (r1 != 0) goto L17
            r3 = r8
            r4 = r2
            r8 = r6
            goto L2e
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r0[r3] = r4
            int r6 = r6 + 1
            int r4 = r3 + 1
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r1[r6]
            r5 = r8
            r8 = r6
            r6 = r5
        L2e:
            int r6 = r6 + r3
            int r6 = r6 + 6
            r3 = r8
            r8 = r6
            r6 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro.NotAvailableWithoutUA.b(int, short, byte, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{0, -74, -56, 111, 6, -5, 3};
        $$b = 37;
    }

    static void init$1() {
        $$c = new byte[]{32, -31, 56, 81};
        $$d = 98;
    }

    public NotAvailableWithoutUA(String str, String str2) {
        super(str, str2, null);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private static void a(String str, int i, String str2, char c, String str3, Object[] objArr) throws Throwable {
        Object charArray;
        char[] charArray2;
        char[] charArray3;
        int i2 = 2 % 2;
        int i3 = $10 + 7;
        $11 = i3 % 128;
        byte b = 0;
        if (i3 % 2 == 0) {
            int i4 = 44 / 0;
            if (str3 != null) {
                charArray = str3.toCharArray();
            } else {
                charArray = str3;
            }
        } else if (str3 != null) {
            charArray = str3.toCharArray();
        } else {
            charArray = str3;
        }
        char[] cArr = (char[]) charArray;
        if (str2 != null) {
            int i5 = $11 + 11;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            charArray2 = str2.toCharArray();
        } else {
            charArray2 = str2;
        }
        char[] cArr2 = charArray2;
        if (str != null) {
            int i7 = $11 + 123;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            charArray3 = str.toCharArray();
            int i9 = $10 + 33;
            $11 = i9 % 128;
            int i10 = i9 % 2;
        } else {
            charArray3 = str;
        }
        char[] cArr3 = charArray3;
        cn cnVar = new cn();
        int length = cArr.length;
        char[] cArr4 = new char[length];
        int length2 = cArr2.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr, 0, cArr4, 0, length);
        System.arraycopy(cArr2, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        cnVar.setPivotYN16904 = 0;
        while (cnVar.setPivotYN16904 < length3) {
            try {
                Object[] objArr2 = {cnVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(528238139);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(86 - View.getDefaultSize(b, b), (char) (55624 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), 423 - (TypedValue.complexToFloat(b) > 0.0f ? 1 : (TypedValue.complexToFloat(b) == 0.0f ? 0 : -1)), 1305018968, false, "c", new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {cnVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1013236775);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - Color.argb((int) b, (int) b, (int) b, (int) b), (char) (Color.blue((int) b) + 55223), View.resolveSizeAndState(b, b, b) + 3269, -1859223622, false, $$e(-1, b, b), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                int i11 = cArr4[cnVar.setPivotYN16904 % 4] * 32718;
                Object[] objArr4 = new Object[3];
                objArr4[2] = Integer.valueOf(cArr5[iIntValue]);
                objArr4[1] = Integer.valueOf(i11);
                objArr4[b] = cnVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-523427508);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(ImageFormat.getBitsPerPixel(b) + 53, (char) (42043 - View.combineMeasuredStates(b, b)), ImageFormat.getBitsPerPixel(b) + 2309, -1300732625, false, ContextChain.TAG_INFRA, new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                int i12 = cArr4[iIntValue2] * 32718;
                Object[] objArr5 = new Object[2];
                objArr5[r14] = Integer.valueOf(cArr5[iIntValue]);
                objArr5[b] = Integer.valueOf(i12);
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1175171274);
                if (objComponent8 == null) {
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (KeyEvent.getMaxKeyCode() >> 16), (char) (58886 - (AudioTrack.getMaxVolume() > 0 ? 1 : (AudioTrack.getMaxVolume() == 0 ? 0 : -1))), 6885 - Process.getGidForName(""), 348058793, false, $$e(-1, (byte) 1, b), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr5[iIntValue2] = ((Character) ((Method) objComponent8).invoke(null, objArr5)).charValue();
                cArr4[iIntValue2] = cnVar.D8871;
                cArr6[cnVar.setPivotYN16904] = (char) (((((long) (cArr3[cnVar.setPivotYN16904] ^ cArr4[iIntValue2])) ^ (component9 ^ (-8233799196330309486L))) ^ ((long) ((int) (((long) setPivotYN16904) ^ (-8233799196330309486L))))) ^ ((long) ((char) (((long) vD14832N6715) ^ (-8233799196330309486L)))));
                cnVar.setPivotYN16904++;
                b = 0;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArr6);
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        component5 = 0;
        D8871 = 1;
        component9 = -1146284122201754938L;
        setPivotYN16904 = 1725286546;
        vD14832N6715 = (char) 51346;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v124, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v2, types: [float] */
    /* JADX WARN: Type inference failed for: r18v3, types: [java.lang.Object, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public static java.lang.Object[] component5(int r29, int r30) {
        /*
            Method dump skipped, instruction units count: 2516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro.NotAvailableWithoutUA.component5(int, int):java.lang.Object[]");
    }
}
