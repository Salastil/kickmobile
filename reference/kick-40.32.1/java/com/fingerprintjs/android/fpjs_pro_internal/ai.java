package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import androidx.media3.muxer.WebmConstants;
import com.facebook.common.callercontext.ContextChain;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes6.dex */
public final class ai {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static long D8871;
    private static char N14263A23323;
    private static int component10;
    private static char[] component13;
    private static boolean component8;
    private static int component9;
    private static int kC4266;
    private static int sG29839;
    private static boolean setTopP6481;
    private final Boolean component5;
    private final Boolean setPivotYN16904;
    private final Integer vD14832N6715;

    private static String $$e(byte b, short s, byte b2) {
        int i = s * 4;
        byte[] bArr = $$c;
        int i2 = (b2 * 4) + 4;
        int i3 = 103 - b;
        byte[] bArr2 = new byte[i + 1];
        int i4 = -1;
        if (bArr == null) {
            i2++;
            i3 = i + i3;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i3;
            if (i4 == i) {
                return new String(bArr2, 0);
            }
            byte b3 = bArr[i2];
            i2++;
            i3 += b3;
        }
    }

    private static void b(int i, int i2, int i3, Object[] objArr) {
        byte[] bArr = $$a;
        int i4 = i + 98;
        int i5 = 7 - (i2 * 3);
        byte[] bArr2 = new byte[15 - i3];
        int i6 = 14 - i3;
        int i7 = -1;
        if (bArr == null) {
            i4 = (i6 + i5) - 5;
            i5++;
            i7 = -1;
        }
        while (true) {
            int i8 = i7 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i5;
            i4 = (i4 + bArr[i5]) - 5;
            i5 = i9 + 1;
            i7 = i8;
        }
    }

    static void init$0() {
        $$a = new byte[]{Ascii.DC4, -36, -83, 73, 17, 6, Ascii.SO, -9, Ascii.DC4, -31, Ascii.RS, Ascii.DC2, -2, 10, -22, -6, -24, 10, 8, -4, 9};
        $$b = 153;
    }

    static void init$1() {
        $$c = new byte[]{34, -7, PSSSigner.TRAILER_IMPLICIT, -126};
        $$d = WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY;
    }

    public static /* synthetic */ Object vD14832N6715(int i, Object[] objArr, int i2, int i3, int i4, int i5, int i6) {
        int i7 = ~i2;
        int i8 = ~(i7 | i6);
        int i9 = (~(i | i2)) | i8;
        int i10 = (~(i2 | (~i6))) | (~((~i) | i7)) | i8;
        int i11 = i7 | i | i6;
        int i12 = i + i6 + i4 + (1050315579 * i5) + (2086215248 * i3);
        int i13 = i12 * i12;
        int i14 = (i * (-1156115713)) + 1671168000 + ((-1156115713) * i6) + ((-1856302338) * i9) + (i10 * 1856302338) + (1856302338 * i11) + (700186624 * i4) + ((-1303117824) * i5) + (314572800 * i3) + (431423488 * i13);
        int i15 = ((i * (-961373039)) - 1316831794) + (i6 * (-961373039)) + (i9 * (-990)) + (i10 * 990) + (i11 * 990) + (i4 * (-961372049)) + (i5 * 755842709) + (i3 * (-1858722640)) + (i13 * (-2040987648));
        if (i14 + (i15 * i15 * 1361641472) == 1) {
            return component9(objArr);
        }
        ai aiVar = (ai) objArr[0];
        int i16 = 2 % 2;
        int i17 = kC4266 + 37;
        int i18 = i17 % 128;
        component10 = i18;
        int i19 = i17 % 2;
        Boolean bool = aiVar.setPivotYN16904;
        int i20 = i18 + 99;
        kC4266 = i20 % 128;
        int i21 = i20 % 2;
        return bool;
    }

    public ai(Integer num, Boolean bool, Boolean bool2) {
        this.vD14832N6715 = num;
        this.setPivotYN16904 = bool;
        this.component5 = bool2;
    }

    public final Integer D8871() {
        int i = 2 % 2;
        int i2 = kC4266;
        int i3 = (i2 ^ 45) + ((i2 & 45) << 1);
        component10 = i3 % 128;
        int i4 = i3 % 2;
        Integer num = this.vD14832N6715;
        if (i4 != 0) {
            return num;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final Boolean component9() {
        int i = 2 % 2;
        int i2 = kC4266 + 17;
        int i3 = i2 % 128;
        component10 = i3;
        int i4 = i2 % 2;
        Boolean bool = this.component5;
        int i5 = i3 + GapComposerKt.nodeKey;
        kC4266 = i5 % 128;
        int i6 = i5 % 2;
        return bool;
    }

    private static void a(String str, int i, String str2, char c, String str3, Object[] objArr) throws Throwable {
        char[] charArray;
        int i2 = 2;
        int i3 = 2 % 2;
        char[] charArray2 = str3 != null ? str3.toCharArray() : str3;
        if (str2 != null) {
            int i4 = $11 + 21;
            $10 = i4 % 128;
            if (i4 % 2 != 0) {
                str2.toCharArray();
                throw null;
            }
            charArray = str2.toCharArray();
        } else {
            charArray = str2;
        }
        char[] cArr = charArray;
        char[] charArray3 = str != null ? str.toCharArray() : str;
        cn cnVar = new cn();
        int length = charArray2.length;
        char[] cArr2 = new char[length];
        int length2 = cArr.length;
        char[] cArr3 = new char[length2];
        byte b = 0;
        System.arraycopy(charArray2, 0, cArr2, 0, length);
        System.arraycopy(cArr, 0, cArr3, 0, length2);
        cArr2[0] = (char) (cArr2[0] ^ c);
        cArr3[2] = (char) (cArr3[2] + ((char) i));
        int length3 = charArray3.length;
        char[] cArr4 = new char[length3];
        cnVar.setPivotYN16904 = 0;
        while (cnVar.setPivotYN16904 < length3) {
            int i5 = $11 + 101;
            $10 = i5 % 128;
            int i6 = i5 % i2;
            try {
                Object[] objArr2 = {cnVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(528238139);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(86 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', b) + 55625), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 422, 1305018968, false, "c", new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {cnVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1013236775);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionGroup(0L) + 52, (char) (55224 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 3269 - KeyEvent.normalizeMetaState(b), -1859223622, false, $$e(b, b, b), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                int i7 = cArr2[cnVar.setPivotYN16904 % 4] * 32718;
                Object[] objArr4 = new Object[3];
                objArr4[i2] = Integer.valueOf(cArr3[iIntValue]);
                objArr4[1] = Integer.valueOf(i7);
                objArr4[b] = cnVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-523427508);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getScrollFriction() > 0 ? 1 : (ViewConfiguration.getScrollFriction() == 0 ? 0 : -1)) + 51, (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 42043), 2309 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1)), -1300732625, false, ContextChain.TAG_INFRA, new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                int i8 = cArr2[iIntValue2] * 32718;
                Object[] objArr5 = new Object[2];
                objArr5[1] = Integer.valueOf(cArr3[iIntValue]);
                objArr5[b] = Integer.valueOf(i8);
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1175171274);
                if (objComponent8 == null) {
                    int packedPositionChild = ExpandableListView.getPackedPositionChild(r13) + 53;
                    char cAxisFromString = (char) (MotionEvent.axisFromString("") + 58886);
                    byte b2 = b;
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(b2, b2) + 6886;
                    byte b3 = (byte) ($$d & 3);
                    byte b4 = (byte) (b3 - 1);
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionChild, cAxisFromString, iMakeMeasureSpec, 348058793, false, $$e(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr3[iIntValue2] = ((Character) ((Method) objComponent8).invoke(null, objArr5)).charValue();
                cArr2[iIntValue2] = cnVar.D8871;
                cArr4[cnVar.setPivotYN16904] = (char) (((((long) (charArray3[cnVar.setPivotYN16904] ^ cArr2[iIntValue2])) ^ (D8871 ^ (-8233799196330309486L))) ^ ((long) ((int) (((long) component9) ^ (-8233799196330309486L))))) ^ ((long) ((char) (((long) N14263A23323) ^ (-8233799196330309486L)))));
                cnVar.setPivotYN16904++;
                i2 = 2;
                b = 0;
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

    private static void c(String str, int i, int[] iArr, String str2, Object[] objArr) throws Throwable {
        char[] charArray;
        String str3 = str2;
        int i2 = 2;
        int i3 = 2 % 2;
        Object obj = null;
        Object bytes = str3;
        if (str3 != null) {
            int i4 = $11 + 15;
            $10 = i4 % 128;
            if (i4 % 2 != 0) {
                str3.getBytes("ISO-8859-1");
                obj.hashCode();
                throw null;
            }
            bytes = str3.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        if (str != null) {
            int i5 = $11 + 121;
            $10 = i5 % 128;
            if (i5 % 2 != 0) {
                charArray = str.toCharArray();
                int i6 = 4 / 0;
            } else {
                charArray = str.toCharArray();
            }
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        cg cgVar = new cg();
        char[] cArr2 = component13;
        if (cArr2 != null) {
            int i7 = $11 + 123;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i9 = 0; i9 < length; i9++) {
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i9])};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-180220690);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((-16777164) - Color.rgb(0, 0, 0), (char) (Gravity.getAbsoluteGravity(0, 0) + 34442), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 5524, -1476966259, false, $$e((byte) ($$d & 111), (short) 0, (byte) 0), new Class[]{Integer.TYPE});
                    }
                    cArr3[i9] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
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
        Object[] objArr3 = {Integer.valueOf(sG29839)};
        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1693797315);
        char c = '0';
        if (objComponent6 == null) {
            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.combineMeasuredStates(0, 0) + 52, (char) View.resolveSizeAndState(0, 0, 0), 4191 - TextUtils.indexOf((CharSequence) "", '0'), -910167970, false, $$e((byte) ($$d & 104), (short) 0, (byte) 0), new Class[]{Integer.TYPE});
        }
        int iIntValue = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
        int i10 = 60693;
        if (component8) {
            cgVar.vD14832N6715 = bArr.length;
            char[] cArr4 = new char[cgVar.vD14832N6715];
            cgVar.setPivotYN16904 = 0;
            while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                int i11 = $10 + 9;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                cArr4[cgVar.setPivotYN16904] = (char) (cArr2[bArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] + i] - iIntValue);
                Object[] objArr4 = {cgVar, cgVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1771590243);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - ExpandableListView.getPackedPositionGroup(0L), (char) (i10 - ExpandableListView.getPackedPositionType(0L)), Color.green(0) + 5955, 992810496, false, $$e((byte) ($$d & 107), (short) 0, (byte) 0), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                i10 = i10;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (!setTopP6481) {
            cgVar.vD14832N6715 = iArr.length;
            char[] cArr5 = new char[cgVar.vD14832N6715];
            cgVar.setPivotYN16904 = 0;
            while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
                int i13 = $11 + 41;
                $10 = i13 % 128;
                int i14 = i13 % 2;
                cArr5[cgVar.setPivotYN16904] = (char) (cArr2[iArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i] - iIntValue);
                cgVar.setPivotYN16904++;
            }
            objArr[0] = new String(cArr5);
            return;
        }
        cgVar.vD14832N6715 = cArr.length;
        char[] cArr6 = new char[cgVar.vD14832N6715];
        cgVar.setPivotYN16904 = 0;
        int i15 = $10 + 103;
        $11 = i15 % 128;
        if (i15 % 2 == 0) {
            int i16 = 4 / 3;
        }
        while (cgVar.setPivotYN16904 < cgVar.vD14832N6715) {
            int i17 = $11 + 25;
            $10 = i17 % 128;
            int i18 = i17 % i2;
            cArr6[cgVar.setPivotYN16904] = (char) (cArr2[cArr[(cgVar.vD14832N6715 - 1) - cgVar.setPivotYN16904] - i] - iIntValue);
            Object[] objArr5 = new Object[i2];
            objArr5[1] = cgVar;
            objArr5[0] = cgVar;
            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1771590243);
            if (objComponent8 == null) {
                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf("", c) + 53, (char) (60693 - (Process.myPid() >> 22)), View.resolveSizeAndState(0, 0, 0) + 5955, 992810496, false, $$e((byte) ($$d & 107), (short) 0, (byte) 0), new Class[]{Object.class, Object.class});
            }
            ((Method) objComponent8).invoke(null, objArr5);
            i2 = i2;
            c = '0';
        }
        objArr[0] = new String(cArr6);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0f8f A[Catch: all -> 0x159b, TryCatch #18 {all -> 0x159b, blocks: (B:100:0x0f82, B:102:0x0f8f, B:103:0x0fbb), top: B:347:0x0f82 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x1339 A[Catch: Exception -> 0x15c1, all -> 0x15e3, IOException -> 0x15ee, TryCatch #1 {, blocks: (B:91:0x0ef6, B:92:0x0f15, B:94:0x0f2a, B:99:0x0f7e, B:104:0x0fc1, B:111:0x1071, B:135:0x1328, B:136:0x132b, B:138:0x1339, B:139:0x1376, B:141:0x138c, B:142:0x13c4, B:143:0x13d5, B:145:0x140b, B:147:0x144a, B:149:0x1472, B:151:0x149e, B:153:0x14be, B:155:0x14c6, B:173:0x157b, B:174:0x157e, B:203:0x15c1, B:204:0x15e2, B:176:0x1580, B:178:0x1586, B:179:0x1587, B:187:0x1593, B:189:0x1599, B:190:0x159a, B:192:0x159c, B:194:0x15a8, B:195:0x15a9, B:197:0x15ab, B:199:0x15b7, B:200:0x15b8), top: B:323:0x0ef6 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x138c A[Catch: Exception -> 0x15c1, all -> 0x15e3, IOException -> 0x15ee, TryCatch #1 {, blocks: (B:91:0x0ef6, B:92:0x0f15, B:94:0x0f2a, B:99:0x0f7e, B:104:0x0fc1, B:111:0x1071, B:135:0x1328, B:136:0x132b, B:138:0x1339, B:139:0x1376, B:141:0x138c, B:142:0x13c4, B:143:0x13d5, B:145:0x140b, B:147:0x144a, B:149:0x1472, B:151:0x149e, B:153:0x14be, B:155:0x14c6, B:173:0x157b, B:174:0x157e, B:203:0x15c1, B:204:0x15e2, B:176:0x1580, B:178:0x1586, B:179:0x1587, B:187:0x1593, B:189:0x1599, B:190:0x159a, B:192:0x159c, B:194:0x15a8, B:195:0x15a9, B:197:0x15ab, B:199:0x15b7, B:200:0x15b8), top: B:323:0x0ef6 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x140b A[Catch: all -> 0x15e3, IOException -> 0x15ee, TryCatch #1 {, blocks: (B:91:0x0ef6, B:92:0x0f15, B:94:0x0f2a, B:99:0x0f7e, B:104:0x0fc1, B:111:0x1071, B:135:0x1328, B:136:0x132b, B:138:0x1339, B:139:0x1376, B:141:0x138c, B:142:0x13c4, B:143:0x13d5, B:145:0x140b, B:147:0x144a, B:149:0x1472, B:151:0x149e, B:153:0x14be, B:155:0x14c6, B:173:0x157b, B:174:0x157e, B:203:0x15c1, B:204:0x15e2, B:176:0x1580, B:178:0x1586, B:179:0x1587, B:187:0x1593, B:189:0x1599, B:190:0x159a, B:192:0x159c, B:194:0x15a8, B:195:0x15a9, B:197:0x15ab, B:199:0x15b7, B:200:0x15b8), top: B:323:0x0ef6 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x144a A[Catch: all -> 0x15e3, IOException -> 0x15ee, TryCatch #1 {, blocks: (B:91:0x0ef6, B:92:0x0f15, B:94:0x0f2a, B:99:0x0f7e, B:104:0x0fc1, B:111:0x1071, B:135:0x1328, B:136:0x132b, B:138:0x1339, B:139:0x1376, B:141:0x138c, B:142:0x13c4, B:143:0x13d5, B:145:0x140b, B:147:0x144a, B:149:0x1472, B:151:0x149e, B:153:0x14be, B:155:0x14c6, B:173:0x157b, B:174:0x157e, B:203:0x15c1, B:204:0x15e2, B:176:0x1580, B:178:0x1586, B:179:0x1587, B:187:0x1593, B:189:0x1599, B:190:0x159a, B:192:0x159c, B:194:0x15a8, B:195:0x15a9, B:197:0x15ab, B:199:0x15b7, B:200:0x15b8), top: B:323:0x0ef6 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x1472 A[Catch: all -> 0x15e3, IOException -> 0x15ee, TryCatch #1 {, blocks: (B:91:0x0ef6, B:92:0x0f15, B:94:0x0f2a, B:99:0x0f7e, B:104:0x0fc1, B:111:0x1071, B:135:0x1328, B:136:0x132b, B:138:0x1339, B:139:0x1376, B:141:0x138c, B:142:0x13c4, B:143:0x13d5, B:145:0x140b, B:147:0x144a, B:149:0x1472, B:151:0x149e, B:153:0x14be, B:155:0x14c6, B:173:0x157b, B:174:0x157e, B:203:0x15c1, B:204:0x15e2, B:176:0x1580, B:178:0x1586, B:179:0x1587, B:187:0x1593, B:189:0x1599, B:190:0x159a, B:192:0x159c, B:194:0x15a8, B:195:0x15a9, B:197:0x15ab, B:199:0x15b7, B:200:0x15b8), top: B:323:0x0ef6 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x149e A[Catch: all -> 0x15e3, IOException -> 0x15ee, TryCatch #1 {, blocks: (B:91:0x0ef6, B:92:0x0f15, B:94:0x0f2a, B:99:0x0f7e, B:104:0x0fc1, B:111:0x1071, B:135:0x1328, B:136:0x132b, B:138:0x1339, B:139:0x1376, B:141:0x138c, B:142:0x13c4, B:143:0x13d5, B:145:0x140b, B:147:0x144a, B:149:0x1472, B:151:0x149e, B:153:0x14be, B:155:0x14c6, B:173:0x157b, B:174:0x157e, B:203:0x15c1, B:204:0x15e2, B:176:0x1580, B:178:0x1586, B:179:0x1587, B:187:0x1593, B:189:0x1599, B:190:0x159a, B:192:0x159c, B:194:0x15a8, B:195:0x15a9, B:197:0x15ab, B:199:0x15b7, B:200:0x15b8), top: B:323:0x0ef6 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x14be A[Catch: all -> 0x15e3, IOException -> 0x15ee, TRY_LEAVE, TryCatch #1 {, blocks: (B:91:0x0ef6, B:92:0x0f15, B:94:0x0f2a, B:99:0x0f7e, B:104:0x0fc1, B:111:0x1071, B:135:0x1328, B:136:0x132b, B:138:0x1339, B:139:0x1376, B:141:0x138c, B:142:0x13c4, B:143:0x13d5, B:145:0x140b, B:147:0x144a, B:149:0x1472, B:151:0x149e, B:153:0x14be, B:155:0x14c6, B:173:0x157b, B:174:0x157e, B:203:0x15c1, B:204:0x15e2, B:176:0x1580, B:178:0x1586, B:179:0x1587, B:187:0x1593, B:189:0x1599, B:190:0x159a, B:192:0x159c, B:194:0x15a8, B:195:0x15a9, B:197:0x15ab, B:199:0x15b7, B:200:0x15b8), top: B:323:0x0ef6 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x15f0  */
    /* JADX WARN: Code duplicated, block: B:218:0x1689 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:219:0x168a  */
    /* JADX WARN: Code duplicated, block: B:221:0x16fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:222:0x16fe  */
    /* JADX WARN: Code duplicated, block: B:224:0x1703  */
    /* JADX WARN: Code duplicated, block: B:227:0x17dc A[Catch: all -> 0x1c3d, TRY_LEAVE, TryCatch #20 {all -> 0x1c3d, blocks: (B:225:0x1732, B:227:0x17dc, B:233:0x183e), top: B:349:0x1732 }] */
    /* JADX WARN: Code duplicated, block: B:229:0x1830  */
    /* JADX WARN: Code duplicated, block: B:232:0x183a  */
    /* JADX WARN: Code duplicated, block: B:239:0x1983  */
    /* JADX WARN: Code duplicated, block: B:242:0x19a6 A[Catch: all -> 0x258d, TryCatch #9 {all -> 0x258d, blocks: (B:5:0x00bd, B:7:0x00ca, B:9:0x010f, B:18:0x02f0, B:20:0x02fd, B:21:0x0341, B:30:0x04e8, B:32:0x04f5, B:33:0x0531, B:42:0x0723, B:44:0x0730, B:45:0x076a, B:61:0x0a19, B:63:0x0a32, B:65:0x0a7d, B:240:0x198f, B:242:0x19a6, B:243:0x19ea, B:258:0x1c6c, B:260:0x1c79, B:261:0x1cbe, B:270:0x1eae, B:272:0x1ebb, B:273:0x1f00, B:282:0x2110, B:284:0x211d, B:285:0x2160, B:294:0x239b, B:296:0x23a8, B:297:0x23e8, B:76:0x0c4c, B:78:0x0c65, B:80:0x0cb8), top: B:337:0x009f }] */
    /* JADX WARN: Code duplicated, block: B:247:0x1b8a A[LOOP:2: B:238:0x1981->B:247:0x1b8a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:248:0x1b90 A[EDGE_INSN: B:248:0x1b90->B:249:0x1c34 BREAK  A[LOOP:1: B:230:0x1834->B:363:0x1834]] */
    /* JADX WARN: Code duplicated, block: B:251:0x1c3c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:260:0x1c79 A[Catch: all -> 0x258d, TryCatch #9 {all -> 0x258d, blocks: (B:5:0x00bd, B:7:0x00ca, B:9:0x010f, B:18:0x02f0, B:20:0x02fd, B:21:0x0341, B:30:0x04e8, B:32:0x04f5, B:33:0x0531, B:42:0x0723, B:44:0x0730, B:45:0x076a, B:61:0x0a19, B:63:0x0a32, B:65:0x0a7d, B:240:0x198f, B:242:0x19a6, B:243:0x19ea, B:258:0x1c6c, B:260:0x1c79, B:261:0x1cbe, B:270:0x1eae, B:272:0x1ebb, B:273:0x1f00, B:282:0x2110, B:284:0x211d, B:285:0x2160, B:294:0x239b, B:296:0x23a8, B:297:0x23e8, B:76:0x0c4c, B:78:0x0c65, B:80:0x0cb8), top: B:337:0x009f }] */
    /* JADX WARN: Code duplicated, block: B:264:0x1d59  */
    /* JADX WARN: Code duplicated, block: B:265:0x1e20  */
    /* JADX WARN: Code duplicated, block: B:268:0x1e98 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:269:0x1e99  */
    /* JADX WARN: Code duplicated, block: B:272:0x1ebb A[Catch: all -> 0x258d, TryCatch #9 {all -> 0x258d, blocks: (B:5:0x00bd, B:7:0x00ca, B:9:0x010f, B:18:0x02f0, B:20:0x02fd, B:21:0x0341, B:30:0x04e8, B:32:0x04f5, B:33:0x0531, B:42:0x0723, B:44:0x0730, B:45:0x076a, B:61:0x0a19, B:63:0x0a32, B:65:0x0a7d, B:240:0x198f, B:242:0x19a6, B:243:0x19ea, B:258:0x1c6c, B:260:0x1c79, B:261:0x1cbe, B:270:0x1eae, B:272:0x1ebb, B:273:0x1f00, B:282:0x2110, B:284:0x211d, B:285:0x2160, B:294:0x239b, B:296:0x23a8, B:297:0x23e8, B:76:0x0c4c, B:78:0x0c65, B:80:0x0cb8), top: B:337:0x009f }] */
    /* JADX WARN: Code duplicated, block: B:276:0x1f9a  */
    /* JADX WARN: Code duplicated, block: B:277:0x2074  */
    /* JADX WARN: Code duplicated, block: B:280:0x20f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:281:0x20f1  */
    /* JADX WARN: Code duplicated, block: B:284:0x211d A[Catch: all -> 0x258d, TryCatch #9 {all -> 0x258d, blocks: (B:5:0x00bd, B:7:0x00ca, B:9:0x010f, B:18:0x02f0, B:20:0x02fd, B:21:0x0341, B:30:0x04e8, B:32:0x04f5, B:33:0x0531, B:42:0x0723, B:44:0x0730, B:45:0x076a, B:61:0x0a19, B:63:0x0a32, B:65:0x0a7d, B:240:0x198f, B:242:0x19a6, B:243:0x19ea, B:258:0x1c6c, B:260:0x1c79, B:261:0x1cbe, B:270:0x1eae, B:272:0x1ebb, B:273:0x1f00, B:282:0x2110, B:284:0x211d, B:285:0x2160, B:294:0x239b, B:296:0x23a8, B:297:0x23e8, B:76:0x0c4c, B:78:0x0c65, B:80:0x0cb8), top: B:337:0x009f }] */
    /* JADX WARN: Code duplicated, block: B:288:0x2230  */
    /* JADX WARN: Code duplicated, block: B:289:0x2303  */
    /* JADX WARN: Code duplicated, block: B:292:0x236b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:293:0x236c  */
    /* JADX WARN: Code duplicated, block: B:296:0x23a8 A[Catch: all -> 0x258d, TryCatch #9 {all -> 0x258d, blocks: (B:5:0x00bd, B:7:0x00ca, B:9:0x010f, B:18:0x02f0, B:20:0x02fd, B:21:0x0341, B:30:0x04e8, B:32:0x04f5, B:33:0x0531, B:42:0x0723, B:44:0x0730, B:45:0x076a, B:61:0x0a19, B:63:0x0a32, B:65:0x0a7d, B:240:0x198f, B:242:0x19a6, B:243:0x19ea, B:258:0x1c6c, B:260:0x1c79, B:261:0x1cbe, B:270:0x1eae, B:272:0x1ebb, B:273:0x1f00, B:282:0x2110, B:284:0x211d, B:285:0x2160, B:294:0x239b, B:296:0x23a8, B:297:0x23e8, B:76:0x0c4c, B:78:0x0c65, B:80:0x0cb8), top: B:337:0x009f }] */
    /* JADX WARN: Code duplicated, block: B:300:0x2482  */
    /* JADX WARN: Code duplicated, block: B:302:0x251e  */
    /* JADX WARN: Code duplicated, block: B:323:0x0ef6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:359:0x1b90 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x1971 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:361:0x1980 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:362:0x1ab7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:364:0x1834 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:365:0x1834 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:367:0x0d6f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:368:0x0e38 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:370:0x1613 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:374:0x15ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:375:0x154d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:376:0x154d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:377:0x154d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:378:0x154d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0c42  */
    /* JADX WARN: Code duplicated, block: B:75:0x0c45  */
    /* JADX WARN: Code duplicated, block: B:78:0x0c65 A[Catch: all -> 0x258d, TryCatch #9 {all -> 0x258d, blocks: (B:5:0x00bd, B:7:0x00ca, B:9:0x010f, B:18:0x02f0, B:20:0x02fd, B:21:0x0341, B:30:0x04e8, B:32:0x04f5, B:33:0x0531, B:42:0x0723, B:44:0x0730, B:45:0x076a, B:61:0x0a19, B:63:0x0a32, B:65:0x0a7d, B:240:0x198f, B:242:0x19a6, B:243:0x19ea, B:258:0x1c6c, B:260:0x1c79, B:261:0x1cbe, B:270:0x1eae, B:272:0x1ebb, B:273:0x1f00, B:282:0x2110, B:284:0x211d, B:285:0x2160, B:294:0x239b, B:296:0x23a8, B:297:0x23e8, B:76:0x0c4c, B:78:0x0c65, B:80:0x0cb8), top: B:337:0x009f }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0cb2  */
    /* JADX WARN: Code duplicated, block: B:84:0x0e2e A[LOOP:3: B:74:0x0c43->B:84:0x0e2e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:85:0x0e38 A[PHI: r3
      0x0e38: PHI (r3v325 java.lang.String) = (r3v324 java.lang.String), (r3v448 java.lang.String) binds: [B:72:0x0c40, B:368:0x0e38] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:87:0x0ea0  */
    /* JADX WARN: Code duplicated, block: B:89:0x0eda  */
    /* JADX WARN: Code duplicated, block: B:97:0x0f4c A[Catch: all -> 0x15aa, TryCatch #6 {all -> 0x15aa, blocks: (B:95:0x0f3f, B:97:0x0f4c, B:98:0x0f78), top: B:332:0x0f3f }] */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x14c7, code lost:
    
        r0 = new java.lang.Object[]{new int[1], new int[1], r1, null, new int[1]};
        r3 = (~(r4 & 20)) & (r4 | 20);
        r1 = (java.lang.String) java.lang.Class.forName(r27).getField(r11).get(r1);
        ((int[]) r0[1])[0] = r4;
        ((int[]) r0[0])[0] = r3;
        r1 = android.os.Process.myPid();
        r3 = ~r1;
        r5 = (((984621583 + (((~(r3 | 761491820)) | ((~(545316012 | r3)) | (-769916397))) * 464)) + (((-224600385) | r1) * (-464))) + (((~(r1 | 761491820)) | (-769916397)) * 464)) + 16;
        r1 = ((r8 | r5) << 1) - (r8 ^ r5);
        r3 = r1 << 13;
        r1 = ((~r1) & r3) | ((~r3) & r1);
        r3 = r1 >>> 17;
        r1 = ((~r1) & r3) | ((~r3) & r1);
        ((int[]) r0[4])[0] = r1 ^ (r1 << 5);
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ java.lang.Object component9(java.lang.Object[] r50) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 9631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ai.component9(java.lang.Object[]):java.lang.Object");
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        kC4266 = 0;
        component10 = 1;
        D8871 = -8233799196330309486L;
        component9 = 1725286546;
        N14263A23323 = (char) 51161;
        component13 = new char[]{29704, 29908, 29918, 29909, 29890, 29898, 29907, 29897, 29889, 29896, 29899, 29752, 29894, 29892, 29893, 29911, 29902, 29707, 29732, 29905, 29817, 29901, 29900, 29888, 29807, 29731, 29727, 29733, 29737, 29738, 29739, 29891, 29736, 29904, 29734};
        sG29839 = 1313764441;
        setTopP6481 = true;
        component8 = true;
    }

    public static Object[] vD14832N6715(Context context, int i, int i2, int i3) {
        return (Object[]) vD14832N6715(-997924118, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}, X26477.component9(), X26477.component9(), X26477.component9(), X26477.component9(), 997924119);
    }

    public final Boolean component5() {
        return (Boolean) vD14832N6715(-273996157, new Object[]{this}, X26477.component9(), X26477.component9(), X26477.component9(), X26477.component9(), 273996157);
    }
}
