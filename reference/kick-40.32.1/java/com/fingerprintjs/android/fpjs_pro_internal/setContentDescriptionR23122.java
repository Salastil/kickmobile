package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.media3.common.PlaybackException;
import androidx.media3.muxer.WebmConstants;
import com.facebook.common.callercontext.ContextChain;
import com.google.common.base.Ascii;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public final class setContentDescriptionR23122 extends wX26196 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static long D8871;
    private static int component5;
    private static int component9;
    private static int setPivotYN16904;
    private static char vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r6, byte r7, short r8) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.setContentDescriptionR23122.$$c
            int r6 = r6 * 3
            int r6 = 3 - r6
            int r7 = r7 * 4
            int r1 = 1 - r7
            int r8 = r8 + 102
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L16
            r3 = r6
            r4 = r2
            goto L2f
        L16:
            r3 = r8
            r8 = r6
            r6 = r3
            r3 = r2
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L25:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L2f:
            int r8 = -r8
            int r6 = r6 + r8
            r8 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setContentDescriptionR23122.$$e(byte, byte, short):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x001f -> B:11:0x0029). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x001f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 68
            int r8 = r8 + 4
            int r0 = r7 + 1
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.setContentDescriptionR23122.$$a
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L11
            r6 = r7
            r3 = r8
            r4 = r2
            goto L29
        L11:
            r3 = r2
        L12:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r7) goto L1f
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            r9[r2] = r6
            return
        L1f:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r1[r8]
            r5 = r3
            r3 = r8
            r8 = r4
            r4 = r5
        L29:
            int r6 = r6 + r8
            int r6 = r6 + (-5)
            r8 = r3
            r3 = r4
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.setContentDescriptionR23122.b(short, byte, int, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{70, 44, 80, 63, -9, Ascii.DC4, -31, Ascii.RS, Ascii.DC2, -2, 10, -22, -6, -24, 10, 8, -4, 9, -7, 5, 4, -1, 17, 6, Ascii.SO};
        $$b = 60;
    }

    static void init$1() {
        $$c = new byte[]{51, -107, 109, -75};
        $$d = 255;
    }

    public setContentDescriptionR23122(String str, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.component12.INSTANCE.component5(), str, setpivotyn16904);
    }

    private static void a(String str, int i, String str2, char c, String str3, Object[] objArr) throws Throwable {
        char[] charArray;
        char[] charArray2;
        int i2 = 2 % 2;
        if (str3 != null) {
            int i3 = $11 + 51;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            charArray = str3.toCharArray();
        } else {
            charArray = str3;
        }
        char[] cArr = charArray;
        char[] charArray3 = str2 != null ? str2.toCharArray() : str2;
        if (str != null) {
            int i5 = $10 + 23;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            charArray2 = str.toCharArray();
        } else {
            charArray2 = str;
        }
        char[] cArr2 = charArray2;
        cn cnVar = new cn();
        int length = cArr.length;
        char[] cArr3 = new char[length];
        int length2 = charArray3.length;
        char[] cArr4 = new char[length2];
        byte b = 0;
        System.arraycopy(cArr, 0, cArr3, 0, length);
        System.arraycopy(charArray3, 0, cArr4, 0, length2);
        cArr3[0] = (char) (cArr3[0] ^ c);
        cArr4[2] = (char) (cArr4[2] + ((char) i));
        int length3 = cArr2.length;
        char[] cArr5 = new char[length3];
        cnVar.setPivotYN16904 = 0;
        while (cnVar.setPivotYN16904 < length3) {
            int i7 = $11 + 39;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            try {
                Object[] objArr2 = {cnVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(528238139);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getEdgeSlop() >> 16) + 86, (char) (Gravity.getAbsoluteGravity(b, b) + 55624), Color.alpha((int) b) + 423, 1305018968, false, "c", new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {cnVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1013236775);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.lastIndexOf("", '0', b, b), (char) (55223 - (ViewConfiguration.getTouchSlop() >> 8)), 3269 - Color.argb((int) b, (int) b, (int) b, (int) b), -1859223622, false, $$e(b, b, (short) 1), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                int i9 = cArr3[cnVar.setPivotYN16904 % 4] * 32718;
                Object[] objArr4 = new Object[3];
                objArr4[2] = Integer.valueOf(cArr4[iIntValue]);
                objArr4[1] = Integer.valueOf(i9);
                objArr4[b] = cnVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-523427508);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((KeyEvent.getMaxKeyCode() >> 16) + 52, (char) (42044 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), TextUtils.getTrimmedLength("") + 2308, -1300732625, false, ContextChain.TAG_INFRA, new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                int i10 = cArr3[iIntValue2] * 32718;
                Object[] objArr5 = new Object[2];
                objArr5[1] = Integer.valueOf(cArr4[iIntValue]);
                objArr5[b] = Integer.valueOf(i10);
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1175171274);
                if (objComponent8 == null) {
                    byte b2 = b;
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.resolveSizeAndState(b2, b2, b2), (char) (58885 - (ViewConfiguration.getEdgeSlop() >> 16)), 6887 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 348058793, false, $$e((byte) 0, (byte) 0, (short) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr4[iIntValue2] = ((Character) ((Method) objComponent8).invoke(null, objArr5)).charValue();
                cArr3[iIntValue2] = cnVar.D8871;
                cArr5[cnVar.setPivotYN16904] = (char) (((((long) (cArr3[iIntValue2] ^ cArr2[cnVar.setPivotYN16904])) ^ (D8871 ^ (-8233799196330309486L))) ^ ((long) ((int) (((long) setPivotYN16904) ^ (-8233799196330309486L))))) ^ ((long) ((char) (((long) vD14832N6715) ^ (-8233799196330309486L)))));
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
        objArr[0] = new String(cArr5);
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        component5 = 0;
        component9 = 1;
        D8871 = -8233799196330309486L;
        setPivotYN16904 = 1725286546;
        vD14832N6715 = (char) 55852;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0400  */
    /* JADX WARN: Code duplicated, block: B:36:0x0406  */
    /* JADX WARN: Code duplicated, block: B:38:0x046a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x046b  */
    /* JADX WARN: Code duplicated, block: B:54:0x04f9 A[Catch: all -> 0x05ef, TryCatch #4 {all -> 0x05ef, blocks: (B:52:0x04ec, B:54:0x04f9, B:55:0x0535), top: B:103:0x04ec, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x05de  */
    /* JADX WARN: Code duplicated, block: B:65:0x05f8 A[Catch: Exception -> 0x0735, TRY_LEAVE, TryCatch #2 {Exception -> 0x0735, blocks: (B:44:0x0480, B:51:0x0497, B:56:0x0541, B:61:0x05f0, B:63:0x05f6, B:64:0x05f7, B:65:0x05f8, B:70:0x06ab, B:72:0x072d, B:74:0x0733, B:75:0x0734, B:47:0x0487, B:66:0x0657, B:68:0x0664, B:69:0x06a5, B:52:0x04ec, B:54:0x04f9, B:55:0x0535), top: B:100:0x047e, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0664 A[Catch: all -> 0x072c, TryCatch #3 {all -> 0x072c, blocks: (B:66:0x0657, B:68:0x0664, B:69:0x06a5), top: B:101:0x0657, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0735  */
    /* JADX WARN: Code duplicated, block: B:78:0x0738  */
    public static Object[] component5(Context context, int i, int i2, int i3) throws Throwable {
        Object[] objArr;
        Object[] objArr2;
        int i4;
        boolean zEquals;
        Object objComponent5;
        Object objComponent6;
        long j;
        int i5;
        int iUptimeMillis;
        int i6;
        int i7;
        int i8 = 2 % 2;
        int i9 = component9 + 23;
        int i10 = i9 % 128;
        component5 = i10;
        if (i9 % 2 != 0) {
            throw null;
        }
        if (context == null) {
            Object[] objArr3 = {new int[]{i}, null, new int[]{i}, new int[]{((~i) & i) | ((~i) & i)}};
            int i11 = ~i;
            int i12 = 440569191 + (((~(1202969570 | i11)) | 671621129) * PlaybackException.ERROR_CODE_SETUP_REQUIRED) + (((~(i11 | 708436363)) | (~((-708436364) | i)) | 1166154336) * 54) + ((i | 1166154336) * 54);
            int i13 = (-1) - (~(i12 * 192));
            int i14 = (((i13 | 191) << 1) - (i13 ^ 191)) + ((~((i12 ^ i) | (i12 & i))) * 191);
            int i15 = ~(((-1) ^ i12) | i12);
            int i16 = ~i;
            int i17 = (i3 - (~(-(-((i14 - (~(-(-(((~((i16 & i12) | (i16 ^ i12))) | i15) * 191))))) - 1))))) - 1;
            int i18 = i17 << 13;
            int i19 = ((~i17) & i18) | ((~i18) & i17);
            int i20 = i19 >>> 17;
            int i21 = (i19 | i20) & (~(i19 & i20));
            int i22 = i21 << 5;
            return objArr3;
        }
        int i23 = (i10 ^ 7) + ((i10 & 7) << 1);
        component9 = i23 % 128;
        int i24 = i23 % 2;
        try {
            int i25 = -(ViewConfiguration.getScrollBarSize() >> 8);
            Object[] objArr4 = new Object[1];
            a("仼骼ၴ\udb91쁶뮎욢흲㝬䄟ϣ늘㲽ⶡ㬖ᵄ饙\uedc6˻ٟ☘랥ᙍ", (i25 ^ 1882488069) + ((i25 & 1882488069) << 1), "\u0000\u0000\u0000\u0000", (char) Color.alpha(0), "ז㑽杰嵩", objArr4);
            Class<?> cls = Class.forName((String) objArr4[0]);
            int touchSlop = ViewConfiguration.getTouchSlop() >> 8;
            int i26 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
            int i27 = i26 * 495;
            int i28 = (i27 ^ (-11382877)) + ((i27 & (-11382877)) << 1);
            int i29 = ((i26 ^ (-23090)) | (i26 & (-23090))) * (-988);
            int i30 = ((i28 | i29) << 1) - (i28 ^ i29);
            int i31 = ~i26;
            int i32 = (i31 ^ 23089) | (i31 & 23089);
            int i33 = ~i;
            int i34 = ((i32 ^ i33) | (i32 & i33)) * 494;
            int i35 = ((i30 | i34) << 1) - (i30 ^ i34);
            int i36 = ~((i31 & (-23090)) | (i31 ^ (-23090)));
            int i37 = ~i;
            int i38 = ~((i37 & 23089) | (i37 ^ 23089));
            int i39 = (i36 & i38) | (i36 ^ i38);
            int i40 = ~((i26 ^ 23089) | (i26 & 23089));
            int i41 = ((i39 & i40) | (i39 ^ i40)) * 494;
            char c = (char) ((i35 ^ i41) + ((i35 & i41) << 1));
            Object[] objArr5 = new Object[1];
            a("\ufe1e㞈짷㭜珁荱靇㨬瓣컕컸潈骊跥녴苫\ue700㓎", touchSlop, "\u0000\u0000\u0000\u0000", c, "隚\ue4eeㅚ퍚", objArr5);
            Object objInvoke = cls.getMethod((String) objArr5[0], null).invoke(context, null);
            Object[] objArr6 = new Object[1];
            a("ꜚﷰ쌭蹉\ude44厃ꅖ䭌뺄벿퉑钆悮踤䶃공ﭱ座\uef3e渉葞疒\uee53獦僘\uead7\udd07⣜⧛恹큟\uef93揮欆", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), "\u0000\u0000\u0000\u0000", (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), "\uf727蒳ደ⿂", objArr6);
            Class<?> cls2 = Class.forName((String) objArr6[0]);
            int i42 = -View.resolveSize(0, 0);
            Object[] objArr7 = new Object[1];
            a("箳薉◷誻藖", ((i42 | (-369775015)) << 1) - (i42 ^ (-369775015)), "\u0000\u0000\u0000\u0000", (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 29621), "奲\uf5ae뛩ㅳ", objArr7);
            if ((cls2.getField((String) objArr7[0]).getInt(objInvoke) & 2) != 0) {
                int i43 = component9;
                int i44 = i43 + 45;
                component5 = i44 % 128;
                int i45 = i44 % 2;
                int i46 = ((i43 | 31) << 1) - (i43 ^ 31);
                component5 = i46 % 128;
                int i47 = i46 % 2;
                objArr = new Object[]{new int[]{i}, null, new int[]{(i & (-2)) | (i37 & 1)}, new int[1]};
                int i48 = (int) Runtime.getRuntime().totalMemory();
                int i49 = 2120997875 + ((1776368209 | i48) * 614);
                int i50 = ~i48;
                int i51 = i49 + (((~((-98978704) | i50)) | 31459841 | (~(1812427230 | i50))) * (-1228)) + (((~(i50 | 1843887071)) | (~((-67518863) | i50))) * 614);
                int i52 = (i51 ^ 16) + ((i51 & 16) << 1);
                int i53 = ((i52 * (-183)) - (~(i3 * 185))) - 1;
                int i54 = ~i52;
                int i55 = ~((i54 ^ i3) | (i54 & i3));
                int i56 = ~(i33 | i3);
                int i57 = -(-(((i55 & i56) | (i55 ^ i56)) * 184));
                int i58 = (i53 ^ i57) + ((i53 & i57) << 1);
                int i59 = ~i3;
                int i60 = ~((i52 & i59) | (i59 ^ i52));
                int i61 = -(-(((i60 & i) | (i ^ i60)) * (-184)));
                int i62 = ((((i58 | i61) << 1) - (i61 ^ i58)) - (~(-(-((~((i54 ^ i37) | (i54 & i37))) * 184))))) - 1;
                int i63 = (i62 << 13) ^ i62;
                int i64 = i63 ^ (i63 >>> 17);
                ((int[]) objArr[3])[0] = i64 ^ (i64 << 5);
            } else {
                objArr = new Object[]{new int[]{i}, null, new int[]{i}, new int[]{i ^ (i << 5)}};
                int i65 = 1397391278 + (((~((-185787432) | i37)) | (-1725618503)) * (-865)) + ((~(i | 185787431)) * 865) + (((~(185787431 | i37)) | (~((-1725618503) | i37))) * 865);
                int i66 = i65 * (-495);
                int i67 = -(-(i3 * (-495)));
                int i68 = (i66 ^ i67) + ((i66 & i67) << 1);
                int i69 = ~i65;
                int i70 = ~i3;
                int i71 = ~((i70 & i69) | (i69 ^ i70));
                int i72 = ~((i69 ^ i) | (i69 & i));
                int i73 = (i68 - (~((i71 | i72) * 992))) - 1;
                int i74 = ~i3;
                int i75 = ~((i69 & i74) | (i69 ^ i74));
                int i76 = (i75 & i72) | (i75 ^ i72);
                int i77 = ~((i37 ^ i65) | (i65 & i37) | i3);
                int i78 = i73 + (((i76 & i77) | (i76 ^ i77)) * (-496));
                int i79 = ((i3 ^ i) | (i3 & i)) * 496;
                int i80 = ((i78 | i79) << 1) - (i79 ^ i78);
                int i81 = (i80 << 13) ^ i80;
                int i82 = i81 >>> 17;
                int i83 = (i81 | i82) & (~(i81 & i82));
            }
            if (((int[]) objArr[2])[0] != i) {
                int i84 = component9;
                int i85 = (i84 & 117) + (i84 | 117);
                component5 = i85 % 128;
                int i86 = i85 % 2;
                return objArr;
            }
            try {
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1185383580);
                if (objComponent7 == null) {
                    int edgeSlop = 52 - (ViewConfiguration.getEdgeSlop() >> 16);
                    char c2 = (char) (34443 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)));
                    int size = 5524 - View.MeasureSpec.getSize(0);
                    byte[] bArr = $$a;
                    Object[] objArr8 = new Object[1];
                    b((short) 47, bArr[24], bArr[21], objArr8);
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(edgeSlop, c2, size, -336773369, false, (String) objArr8[0], new Class[0]);
                }
                Set set = (Set) ((Method) objComponent7).invoke(null, null);
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1204470180);
                if (objComponent8 == null) {
                    int i87 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 52;
                    char c3 = (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 34442);
                    int i88 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 5523;
                    byte[] bArr2 = $$a;
                    byte b = (byte) (bArr2[21] + 1);
                    byte b2 = bArr2[20];
                    Object[] objArr9 = new Object[1];
                    b(b, b2, (byte) (b2 | 9), objArr9);
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(i87, c3, i88, 360678855, false, (String) objArr9[0], null);
                }
                if (!set.contains(((Field) objComponent8).get(null))) {
                    Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(-986694391);
                    if (objComponent9 == null) {
                        int iResolveOpacity = 52 - Drawable.resolveOpacity(0, 0);
                        char scrollBarFadeDuration = (char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 34442);
                        int scrollDefaultDelay = 5524 - (ViewConfiguration.getScrollDefaultDelay() >> 16);
                        byte[] bArr3 = $$a;
                        Object[] objArr10 = new Object[1];
                        b((short) 47, bArr3[24], bArr3[21], objArr10);
                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(iResolveOpacity, scrollBarFadeDuration, scrollDefaultDelay, -1752860310, false, (String) objArr10[0], null);
                    }
                    if (set.contains(((Field) objComponent9).get(null))) {
                        if (Build.VERSION.SDK_INT == 30) {
                            objArr2 = new Object[]{new int[]{i}, null, new int[]{i}, new int[1]};
                            int iNextInt = new Random().nextInt();
                            int i89 = 1469324191 + (((-34719233) | (~iNextInt)) * (-490)) + (((~(iNextInt | (-1780086573))) | 1745367340) * 490) + 78022060;
                            int i90 = (i3 & i89) + (i3 | i89);
                            int i91 = i90 << 13;
                            int i92 = (i90 | i91) & (~(i90 & i91));
                            int i93 = i92 ^ (i92 >>> 17);
                            int i94 = i93 << 5;
                            ((int[]) objArr2[3])[0] = ((~i93) & i94) | ((~i94) & i93);
                            i4 = component5 + 117;
                            component9 = i4 % 128;
                            if (i4 % 2 != 0) {
                                return objArr2;
                            }
                            throw null;
                        }
                    }
                } else if (Build.VERSION.SDK_INT == 30) {
                    objArr2 = new Object[]{new int[]{i}, null, new int[]{i}, new int[1]};
                    int iNextInt2 = new Random().nextInt();
                    int i810 = 1469324191 + (((-34719233) | (~iNextInt2)) * (-490)) + (((~(iNextInt2 | (-1780086573))) | 1745367340) * 490) + 78022060;
                    int i95 = (i3 & i810) + (i3 | i810);
                    int i96 = i95 << 13;
                    int i97 = (i95 | i96) & (~(i95 & i96));
                    int i98 = i97 ^ (i97 >>> 17);
                    int i99 = i98 << 5;
                    ((int[]) objArr2[3])[0] = ((~i98) & i99) | ((~i99) & i98);
                    i4 = component5 + 117;
                    component9 = i4 % 128;
                    if (i4 % 2 != 0) {
                        return objArr2;
                    }
                    throw null;
                }
                if ((i2 & 32) == 0) {
                    int i100 = component9;
                    int i101 = (i100 ^ 3) + ((i100 & 3) << 1);
                    component5 = i101 % 128;
                    try {
                        if (i101 % 2 != 0) {
                            if (Build.VERSION.SDK_INT > 74) {
                                int i102 = component5 + 111;
                                component9 = i102 % 128;
                                int i103 = i102 % 2;
                                int scrollBarSize = ViewConfiguration.getScrollBarSize() >> 8;
                                int touchSlop2 = ViewConfiguration.getTouchSlop() >> 8;
                                int iComponent9 = u.Companion.component9();
                                int i104 = touchSlop2 * (-159);
                                int i105 = (((i104 | (-1967625)) << 1) - (i104 ^ (-1967625))) + (((~touchSlop2) | 12375) * WebmConstants.MkvEbmlElement.BLOCK_GROUP);
                                int i106 = ~iComponent9;
                                int i107 = ~((i106 & touchSlop2) | (i106 ^ touchSlop2));
                                int i108 = ~((touchSlop2 & 12375) | (touchSlop2 ^ 12375));
                                int i109 = i105 + (((i108 & i107) | (i107 ^ i108)) * (-160));
                                int i110 = ~((~iComponent9) | (-12376));
                                int i111 = ((touchSlop2 & i110) | (touchSlop2 ^ i110)) * WebmConstants.MkvEbmlElement.BLOCK_GROUP;
                                char c4 = (char) ((i109 ^ i111) + ((i111 & i109) << 1));
                                Object[] objArr11 = new Object[1];
                                a("\uf123쾯퀫໕䬤凑ီ驭ં診ꎶ嵟ⷁ근磶㓿⍢ḽ淴Ԗݞ\uecd5菉蜵︙糎၀볏", scrollBarSize, "\u0000\u0000\u0000\u0000", c4, "䒸䙚垿\uf030", objArr11);
                                try {
                                    Object[] objArr12 = {(String) objArr11[0]};
                                    objComponent6 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                    if (objComponent6 == null) {
                                        int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 53;
                                        char defaultSize = (char) (59725 - View.getDefaultSize(0, 0));
                                        int size2 = View.MeasureSpec.getSize(0) + 6317;
                                        byte[] bArr4 = $$a;
                                        byte b3 = (byte) (-bArr4[6]);
                                        Object[] objArr13 = new Object[1];
                                        b(b3, (byte) (b3 & 3), bArr4[22], objArr13);
                                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionChild, defaultSize, size2, 1385817144, false, (String) objArr13[0], new Class[]{String.class});
                                    }
                                    long jLongValue = ((Long) ((Method) objComponent6).invoke(null, objArr12)).longValue();
                                    long jElapsedRealtime = (int) SystemClock.elapsedRealtime();
                                    j = 648073289664L + (434 * jLongValue) + ((((1500169651 | (jElapsedRealtime ^ (-1))) | jLongValue) ^ (-1)) * 433) + ((-433) * (1500169651 | (((jLongValue ^ (-1)) | jElapsedRealtime) ^ (-1)))) + (433 * ((((-1500169652) | jLongValue) ^ (-1)) | ((1500169651 | jElapsedRealtime) ^ (-1)))) + 1904749558;
                                    i5 = (int) (j >> 32);
                                    iUptimeMillis = (int) SystemClock.uptimeMillis();
                                    i6 = ~((-276204079) | iUptimeMillis);
                                    i7 = ~iUptimeMillis;
                                    if (((i5 & (425441850 + ((i6 | (~(1161022332 | i7))) * (-1808)) + (((~((-3312173) | iUptimeMillis)) | (~(i7 | 1433914238))) * 904) + (((~(iUptimeMillis | (-1161022333))) | 272891906 | (~(276204078 | i7))) * 904))) | (((int) j) & ((-1704616964) + (((~(2059342258 | i)) | (-2143263156)) * 305) + (((~(2059342258 | i37)) | (-798398628)) * 305)))) == 1) {
                                        int i112 = component5;
                                        int i113 = ((i112 | 25) << 1) - (i112 ^ 25);
                                        component9 = i113 % 128;
                                        int i114 = i113 % 2;
                                        zEquals = true;
                                    } else {
                                        zEquals = false;
                                    }
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause != null) {
                                        throw cause;
                                    }
                                    throw th;
                                }
                            } else {
                                int i115 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                                int iComponent10 = u.Companion.component9();
                                int i116 = i115 * (-947);
                                int i117 = ((i116 | 242879375) << 1) - (i116 ^ 242879375);
                                int i118 = ~i115;
                                int i119 = i117 + (((~((1855314764 ^ iComponent10) | (1855314764 & iComponent10))) | i118) * (-948));
                                int i120 = (i118 & 1855314764) | (i118 ^ 1855314764);
                                int i121 = ~iComponent10;
                                int i122 = (~((i121 & i120) | (i120 ^ i121))) * (-948);
                                int i123 = (i119 & i122) + (i122 | i119);
                                int i124 = -(-(((i115 & 1855314764) | (i115 ^ 1855314764)) * 948));
                                int i125 = (i123 & i124) + (i124 | i123);
                                int i126 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                Object[] objArr14 = new Object[1];
                                a("蒁\ueaa4Ꮾ똦ﲒᏰ蟻羪અ賎䐘虾㓧", i125, "\u0000\u0000\u0000\u0000", (char) ((i126 ^ 25330) + ((i126 & 25330) << 1)), "덌樤\uf291ﵢ", objArr14);
                                try {
                                    Object[] objArr15 = {(String) objArr14[0]};
                                    objComponent5 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                    if (objComponent5 == null) {
                                        int doubleTapTimeout = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 52;
                                        char cRed = (char) Color.red(0);
                                        int i127 = 6473 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                        byte[] bArr5 = $$a;
                                        Object[] objArr16 = new Object[1];
                                        b((byte) (bArr5[7] - 1), (byte) (bArr5[r3] + 1), bArr5[5], objArr16);
                                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(doubleTapTimeout, cRed, i127, 1068791596, false, (String) objArr16[0], new Class[]{String.class});
                                    }
                                    Object objInvoke2 = ((Method) objComponent5).invoke(null, objArr15);
                                    int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0, 0);
                                    int i128 = iLastIndexOf * (-112);
                                    int i129 = ((i128 | (-2137056192)) << 1) - (i128 ^ (-2137056192));
                                    int i130 = ~((632833819 ^ i37) | (632833819 & i37));
                                    int i131 = -(-(((i130 & iLastIndexOf) | (iLastIndexOf ^ i130)) * 226));
                                    int i132 = (i129 ^ i131) + ((i131 & i129) << 1);
                                    int i133 = ~iLastIndexOf;
                                    int i134 = ~(((-632833820) & i133) | (i133 ^ (-632833820)));
                                    int i135 = ~((i133 & i) | (i133 ^ i));
                                    int i136 = (i135 & i134) | (i134 ^ i135);
                                    int i137 = (632833819 & i37) | (632833819 ^ i37);
                                    int i138 = ~((iLastIndexOf & i137) | (i137 ^ iLastIndexOf));
                                    int i139 = ((i138 & i136) | (i136 ^ i138)) * (-113);
                                    int i140 = (i132 & i139) + (i139 | i132);
                                    int i141 = (~((632833819 ^ i) | (632833819 & i))) * 113;
                                    int i142 = ((i140 | i141) << 1) - (i141 ^ i140);
                                    int i143 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                                    Object[] objArr17 = new Object[1];
                                    a("\ufb1b", i142, "\u0000\u0000\u0000\u0000", (char) (((i143 | 60898) << 1) - (i143 ^ 60898)), "\ue36a䞸\ue2da쇭", objArr17);
                                    zEquals = objInvoke2.equals((String) objArr17[0]);
                                } catch (Throwable th2) {
                                    Throwable cause2 = th2.getCause();
                                    if (cause2 != null) {
                                        throw cause2;
                                    }
                                    throw th2;
                                }
                            }
                            if (zEquals) {
                                u.Companion.component9();
                                Object[] objArr18 = {new int[]{i}, null, new int[]{(~(i & 10)) & (i | 10)}, new int[1]};
                                int i144 = ((((~((-1019692733) | i)) | 165752845) * 398) - 671453343) + (((~((-1019692733) | i37)) | 165752845) * 398);
                                int iComponent11 = u.Companion.component9();
                                int i145 = i144 * (-613);
                                int i146 = (9840 ^ i145) + ((i145 & 9840) << 1);
                                int i147 = ((-17) ^ i144) | ((-17) & i144);
                                int i148 = (~i147) | iComponent11;
                                int i149 = ~i144;
                                int i150 = ~((i149 ^ 16) | (i149 & 16));
                                int i151 = -(-(((i148 & i150) | (i148 ^ i150)) * 614));
                                int i152 = ((i146 | i151) << 1) - (i146 ^ i151);
                                int i153 = ~iComponent11;
                                int i154 = ~((-17) | i153);
                                int i155 = ~i147;
                                int i156 = ((i155 & i154) | (i154 ^ i155) | (~((i153 ^ i144) | (i153 & i144)))) * (-1228);
                                int i157 = ((i152 | i156) << 1) - (i156 ^ i152);
                                int i158 = ((-17) & i149) | ((-17) ^ i149);
                                int i159 = ~((i158 & i153) | (i158 ^ i153));
                                int i160 = ~iComponent11;
                                int i161 = (i160 & 16) | (i160 ^ 16);
                                int i162 = ~((i161 & i144) | (i161 ^ i144));
                                int i163 = -(-(((i162 & i159) | (i159 ^ i162)) * 614));
                                int i164 = (i157 & i163) + (i163 | i157);
                                int i165 = ((i164 * (-419)) - (~(-(-(i3 * 421))))) - 1;
                                int i166 = (~((i & i3) | (i3 ^ i))) * 420;
                                int i167 = (i165 ^ i166) + ((i165 & i166) << 1);
                                int i168 = -(-(((~i164) | i3) * (-420)));
                                int i169 = (i167 ^ i168) + ((i168 & i167) << 1);
                                int i170 = ~i164;
                                int i171 = ~i3;
                                int i172 = -(-(((~((i170 & i171) | (i170 ^ i171))) | (~((i3 & i37) | (i37 ^ i3)))) * 420));
                                int i173 = (i169 & i172) + (i172 | i169);
                                int i174 = i173 << 13;
                                int i175 = (i174 & (~i173)) | ((~i174) & i173);
                                int i176 = i175 >>> 17;
                                int i177 = (i175 | i176) & (~(i175 & i176));
                                int i178 = i177 << 5;
                                ((int[]) objArr18[3])[0] = (i177 | i178) & (~(i177 & i178));
                                return objArr18;
                            }
                        } else {
                            if (Build.VERSION.SDK_INT > 33) {
                                int i1010 = component5 + 111;
                                component9 = i1010 % 128;
                                int i1011 = i1010 % 2;
                                int scrollBarSize2 = ViewConfiguration.getScrollBarSize() >> 8;
                                int touchSlop3 = ViewConfiguration.getTouchSlop() >> 8;
                                int iComponent12 = u.Companion.component9();
                                int i1012 = touchSlop3 * (-159);
                                int i1013 = (((i1012 | (-1967625)) << 1) - (i1012 ^ (-1967625))) + (((~touchSlop3) | 12375) * WebmConstants.MkvEbmlElement.BLOCK_GROUP);
                                int i1014 = ~iComponent12;
                                int i1015 = ~((i1014 & touchSlop3) | (i1014 ^ touchSlop3));
                                int i1016 = ~((touchSlop3 & 12375) | (touchSlop3 ^ 12375));
                                int i1017 = i1013 + (((i1016 & i1015) | (i1015 ^ i1016)) * (-160));
                                int i1110 = ~((~iComponent12) | (-12376));
                                int i1111 = ((touchSlop3 & i1110) | (touchSlop3 ^ i1110)) * WebmConstants.MkvEbmlElement.BLOCK_GROUP;
                                char c5 = (char) ((i1017 ^ i1111) + ((i1111 & i1017) << 1));
                                Object[] objArr19 = new Object[1];
                                a("\uf123쾯퀫໕䬤凑ီ驭ં診ꎶ嵟ⷁ근磶㓿⍢ḽ淴Ԗݞ\uecd5菉蜵︙糎၀볏", scrollBarSize2, "\u0000\u0000\u0000\u0000", c5, "䒸䙚垿\uf030", objArr19);
                                Object[] objArr110 = {(String) objArr19[0]};
                                objComponent6 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                if (objComponent6 == null) {
                                    int packedPositionChild2 = ExpandableListView.getPackedPositionChild(0L) + 53;
                                    char defaultSize2 = (char) (59725 - View.getDefaultSize(0, 0));
                                    int size3 = View.MeasureSpec.getSize(0) + 6317;
                                    byte[] bArr6 = $$a;
                                    byte b4 = (byte) (-bArr6[6]);
                                    Object[] objArr111 = new Object[1];
                                    b(b4, (byte) (b4 & 3), bArr6[22], objArr111);
                                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionChild2, defaultSize2, size3, 1385817144, false, (String) objArr111[0], new Class[]{String.class});
                                }
                                long jLongValue2 = ((Long) ((Method) objComponent6).invoke(null, objArr110)).longValue();
                                long jElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                                j = 648073289664L + (434 * jLongValue2) + ((((1500169651 | (jElapsedRealtime2 ^ (-1))) | jLongValue2) ^ (-1)) * 433) + ((-433) * (1500169651 | (((jLongValue2 ^ (-1)) | jElapsedRealtime2) ^ (-1)))) + (433 * ((((-1500169652) | jLongValue2) ^ (-1)) | ((1500169651 | jElapsedRealtime2) ^ (-1)))) + 1904749558;
                                i5 = (int) (j >> 32);
                                iUptimeMillis = (int) SystemClock.uptimeMillis();
                                i6 = ~((-276204079) | iUptimeMillis);
                                i7 = ~iUptimeMillis;
                                if (((i5 & (425441850 + ((i6 | (~(1161022332 | i7))) * (-1808)) + (((~((-3312173) | iUptimeMillis)) | (~(i7 | 1433914238))) * 904) + (((~(iUptimeMillis | (-1161022333))) | 272891906 | (~(276204078 | i7))) * 904))) | (((int) j) & ((-1704616964) + (((~(2059342258 | i)) | (-2143263156)) * 305) + (((~(2059342258 | i37)) | (-798398628)) * 305)))) == 1) {
                                    int i1112 = component5;
                                    int i1113 = ((i1112 | 25) << 1) - (i1112 ^ 25);
                                    component9 = i1113 % 128;
                                    int i1114 = i1113 % 2;
                                    zEquals = true;
                                } else {
                                    zEquals = false;
                                }
                            } else {
                                int i1115 = -(ViewConfiguration.getFadingEdgeLength() >> 16);
                                int iComponent13 = u.Companion.component9();
                                int i1116 = i1115 * (-947);
                                int i1117 = ((i1116 | 242879375) << 1) - (i1116 ^ 242879375);
                                int i1118 = ~i1115;
                                int i1119 = i1117 + (((~((1855314764 ^ iComponent13) | (1855314764 & iComponent13))) | i1118) * (-948));
                                int i1210 = (i1118 & 1855314764) | (i1118 ^ 1855314764);
                                int i1211 = ~iComponent13;
                                int i1212 = (~((i1211 & i1210) | (i1210 ^ i1211))) * (-948);
                                int i1213 = (i1119 & i1212) + (i1212 | i1119);
                                int i1214 = -(-(((i1115 & 1855314764) | (i1115 ^ 1855314764)) * 948));
                                int i1215 = (i1213 & i1214) + (i1214 | i1213);
                                int i1216 = -(ViewConfiguration.getEdgeSlop() >> 16);
                                Object[] objArr112 = new Object[1];
                                a("蒁\ueaa4Ꮾ똦ﲒᏰ蟻羪અ賎䐘虾㓧", i1215, "\u0000\u0000\u0000\u0000", (char) ((i1216 ^ 25330) + ((i1216 & 25330) << 1)), "덌樤\uf291ﵢ", objArr112);
                                Object[] objArr113 = {(String) objArr112[0]};
                                objComponent5 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                if (objComponent5 == null) {
                                    int doubleTapTimeout2 = (ViewConfiguration.getDoubleTapTimeout() >> 16) + 52;
                                    char cRed2 = (char) Color.red(0);
                                    int i1217 = 6473 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                                    byte[] bArr7 = $$a;
                                    Object[] objArr114 = new Object[1];
                                    b((byte) (bArr7[7] - 1), (byte) (bArr7[r3] + 1), bArr7[5], objArr114);
                                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(doubleTapTimeout2, cRed2, i1217, 1068791596, false, (String) objArr114[0], new Class[]{String.class});
                                }
                                Object objInvoke3 = ((Method) objComponent5).invoke(null, objArr113);
                                int iLastIndexOf2 = TextUtils.lastIndexOf("", '0', 0, 0);
                                int i1218 = iLastIndexOf2 * (-112);
                                int i1219 = ((i1218 | (-2137056192)) << 1) - (i1218 ^ (-2137056192));
                                int i1310 = ~((632833819 ^ i37) | (632833819 & i37));
                                int i1311 = -(-(((i1310 & iLastIndexOf2) | (iLastIndexOf2 ^ i1310)) * 226));
                                int i1312 = (i1219 ^ i1311) + ((i1311 & i1219) << 1);
                                int i1313 = ~iLastIndexOf2;
                                int i1314 = ~(((-632833820) & i1313) | (i1313 ^ (-632833820)));
                                int i1315 = ~((i1313 & i) | (i1313 ^ i));
                                int i1316 = (i1315 & i1314) | (i1314 ^ i1315);
                                int i1317 = (632833819 & i37) | (632833819 ^ i37);
                                int i1318 = ~((iLastIndexOf2 & i1317) | (i1317 ^ iLastIndexOf2));
                                int i1319 = ((i1318 & i1316) | (i1316 ^ i1318)) * (-113);
                                int i1410 = (i1312 & i1319) + (i1319 | i1312);
                                int i1411 = (~((632833819 ^ i) | (632833819 & i))) * 113;
                                int i1412 = ((i1410 | i1411) << 1) - (i1411 ^ i1410);
                                int i1413 = -(ViewConfiguration.getLongPressTimeout() >> 16);
                                Object[] objArr115 = new Object[1];
                                a("\ufb1b", i1412, "\u0000\u0000\u0000\u0000", (char) (((i1413 | 60898) << 1) - (i1413 ^ 60898)), "\ue36a䞸\ue2da쇭", objArr115);
                                zEquals = objInvoke3.equals((String) objArr115[0]);
                            }
                            if (zEquals) {
                                u.Companion.component9();
                                Object[] objArr116 = {new int[]{i}, null, new int[]{(~(i & 10)) & (i | 10)}, new int[1]};
                                int i1414 = ((((~((-1019692733) | i)) | 165752845) * 398) - 671453343) + (((~((-1019692733) | i37)) | 165752845) * 398);
                                int iComponent14 = u.Companion.component9();
                                int i1415 = i1414 * (-613);
                                int i1416 = (9840 ^ i1415) + ((i1415 & 9840) << 1);
                                int i1417 = ((-17) ^ i1414) | ((-17) & i1414);
                                int i1418 = (~i1417) | iComponent14;
                                int i1419 = ~i1414;
                                int i1510 = ~((i1419 ^ 16) | (i1419 & 16));
                                int i1511 = -(-(((i1418 & i1510) | (i1418 ^ i1510)) * 614));
                                int i1512 = ((i1416 | i1511) << 1) - (i1416 ^ i1511);
                                int i1513 = ~iComponent14;
                                int i1514 = ~((-17) | i1513);
                                int i1515 = ~i1417;
                                int i1516 = ((i1515 & i1514) | (i1514 ^ i1515) | (~((i1513 ^ i1414) | (i1513 & i1414)))) * (-1228);
                                int i1517 = ((i1512 | i1516) << 1) - (i1516 ^ i1512);
                                int i1518 = ((-17) & i1419) | ((-17) ^ i1419);
                                int i1519 = ~((i1518 & i1513) | (i1518 ^ i1513));
                                int i1610 = ~iComponent14;
                                int i1611 = (i1610 & 16) | (i1610 ^ 16);
                                int i1612 = ~((i1611 & i1414) | (i1611 ^ i1414));
                                int i1613 = -(-(((i1612 & i1519) | (i1519 ^ i1612)) * 614));
                                int i1614 = (i1517 & i1613) + (i1613 | i1517);
                                int i1615 = ((i1614 * (-419)) - (~(-(-(i3 * 421))))) - 1;
                                int i1616 = (~((i & i3) | (i3 ^ i))) * 420;
                                int i1617 = (i1615 ^ i1616) + ((i1615 & i1616) << 1);
                                int i1618 = -(-(((~i1614) | i3) * (-420)));
                                int i1619 = (i1617 ^ i1618) + ((i1618 & i1617) << 1);
                                int i179 = ~i1614;
                                int i1710 = ~i3;
                                int i1711 = -(-(((~((i179 & i1710) | (i179 ^ i1710))) | (~((i3 & i37) | (i37 ^ i3)))) * 420));
                                int i1712 = (i1619 & i1711) + (i1711 | i1619);
                                int i1713 = i1712 << 13;
                                int i1714 = (i1713 & (~i1712)) | ((~i1713) & i1712);
                                int i1715 = i1714 >>> 17;
                                int i1716 = (i1714 | i1715) & (~(i1714 & i1715));
                                int i1717 = i1716 << 5;
                                ((int[]) objArr116[3])[0] = (i1716 | i1717) & (~(i1716 & i1717));
                                return objArr116;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                Object[] objArr20 = {new int[]{i}, null, new int[]{i}, new int[]{(i | i) & (~(i & i))}};
                int i180 = 1798830163 + (((~((-1426318132) | i)) | (~(1575746363 | i37))) * (-406)) + ((~((-1090658562) | i37)) * (-406)) + (((~((-485087803) | i)) | (~(1426318131 | i37))) * 406);
                int i181 = ((i180 * WebmConstants.MkvEbmlElement.VOID) - (~(i3 * 471))) - 1;
                int i182 = ~i180;
                int i183 = ~(i37 | i182);
                int i184 = (i181 - (~(((i183 & i3) | (i3 ^ i183)) * (-235)))) - 1;
                int i185 = ~i180;
                int i186 = ~((i185 & i) | (i185 ^ i));
                int i187 = ((i186 & i3) | (i3 ^ i186)) * (-470);
                int i188 = (i184 ^ i187) + ((i184 & i187) << 1);
                int i189 = ~i3;
                int i190 = i188 + (((~(i | i3 | i182)) | (~((i189 & i180) | (i189 ^ i180)))) * 235);
                int i191 = (i190 << 13) ^ i190;
                int i192 = i191 ^ (i191 >>> 17);
                int i193 = i192 << 5;
                int i194 = component5;
                int i195 = (i194 & 69) + (i194 | 69);
                component9 = i195 % 128;
                if (i195 % 2 != 0) {
                    return objArr20;
                }
                throw null;
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 != null) {
                throw cause4;
            }
            throw th4;
        }
    }
}
