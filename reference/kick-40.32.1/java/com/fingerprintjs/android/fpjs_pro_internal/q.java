package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes6.dex */
public final class q {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static final byte[] $$c = null;
    private static final int $$d = 0;
    private static int $10;
    private static int $11;
    private static int D8871;
    private static int component5;
    private static int setPivotYN16904;
    private final String component9;
    private final String vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$e(byte r7, short r8, int r9) {
        /*
            int r9 = r9 * 2
            int r9 = 120 - r9
            int r7 = r7 * 4
            int r7 = r7 + 1
            int r8 = r8 * 4
            int r8 = 3 - r8
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.q.$$c
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r9
            r4 = r2
            r9 = r8
            goto L2c
        L17:
            r3 = r2
        L18:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            return r7
        L27:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r6
        L2c:
            int r8 = r8 + r3
            r3 = r9
            r9 = r8
            r8 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.q.$$e(byte, short, int):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void b(short r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            int r5 = 24 - r5
            int r7 = 115 - r7
            int r0 = 15 - r6
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.q.$$a
            byte[] r0 = new byte[r0]
            int r6 = 14 - r6
            r2 = 0
            if (r1 != 0) goto L13
            r7 = r5
            r3 = r6
            r4 = r2
            goto L2a
        L13:
            r3 = r7
            r7 = r5
            r5 = r3
            r3 = r2
        L17:
            byte r4 = (byte) r5
            r0[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L26
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            r8[r2] = r5
            return
        L26:
            int r7 = r7 + 1
            r3 = r1[r7]
        L2a:
            int r5 = r5 + r3
            int r5 = r5 + (-5)
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.q.b(short, int, int, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{Ascii.US, -43, -84, -74, -9, Ascii.DC4, -31, Ascii.RS, Ascii.DC2, -2, 10, -22, -6, -24, 10, 8, -4, 9, -7, 5, 4, -1, 17, 6, Ascii.SO};
        $$b = 189;
    }

    static void init$1() {
        $$c = new byte[]{62, 106, 120, -80};
        $$d = 18;
    }

    public q(String str, String str2) {
        this.component9 = str;
        this.vD14832N6715 = str2;
    }

    public final String setPivotYN16904() {
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 87;
        int i3 = i2 % 128;
        D8871 = i3;
        int i4 = i2 % 2;
        String str = this.vD14832N6715;
        int i5 = ((i3 | 53) << 1) - (i3 ^ 53);
        setPivotYN16904 = i5 % 128;
        int i6 = i5 % 2;
        return str;
    }

    private static void a(String str, int i, boolean z, int i2, int i3, Object[] objArr) throws Throwable {
        int i4 = 2 % 2;
        char[] charArray = str != null ? str.toCharArray() : str;
        cm cmVar = new cm();
        char[] cArr = new char[i2];
        cmVar.component9 = 0;
        while (cmVar.component9 < i2) {
            int i5 = $11 + 115;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            cmVar.setPivotYN16904 = charArray[cmVar.component9];
            cArr[cmVar.component9] = (char) (i3 + cmVar.setPivotYN16904);
            int i7 = cmVar.component9;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr[i7]), Integer.valueOf(component5)};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1226238903);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(49 - (Process.myTid() >> 22), (char) (35725 - TextUtils.indexOf("", "", 0)), Gravity.getAbsoluteGravity(0, 0) + 2878, 463712212, false, $$e((byte) 0, (short) 0, 0), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr[i7] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {cmVar, cmVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-2009915307);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionType(0L) + 70, (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 19666), 1906 - (ViewConfiguration.getPressedStateDuration() >> 16), -628726730, false, "v", new Class[]{Object.class, Object.class});
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
        if (i > 0) {
            cmVar.vD14832N6715 = i;
            char[] cArr2 = new char[i2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            System.arraycopy(cArr2, 0, cArr, i2 - cmVar.vD14832N6715, cmVar.vD14832N6715);
            System.arraycopy(cArr2, cmVar.vD14832N6715, cArr, 0, i2 - cmVar.vD14832N6715);
        }
        if (z) {
            int i8 = $11 + 11;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            char[] cArr3 = new char[i2];
            cmVar.component9 = 0;
            while (cmVar.component9 < i2) {
                int i10 = $11 + 5;
                $10 = i10 % 128;
                if (i10 % 2 != 0) {
                    cArr3[cmVar.component9] = cArr[i2 / cmVar.component9];
                    Object[] objArr4 = {cmVar, cmVar};
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-2009915307);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(70 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (19666 - (ViewConfiguration.getLongPressTimeout() >> 16)), 1906 - TextUtils.getTrimmedLength(""), -628726730, false, "v", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent7).invoke(null, objArr4);
                } else {
                    cArr3[cmVar.component9] = cArr[(i2 - cmVar.component9) - 1];
                    Object[] objArr5 = {cmVar, cmVar};
                    Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-2009915307);
                    if (objComponent8 == null) {
                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(69 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (19665 - TextUtils.indexOf((CharSequence) "", '0', 0)), (Process.myTid() >> 22) + 1906, -628726730, false, "v", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent8).invoke(null, objArr5);
                }
            }
            int i11 = $10 + 73;
            $11 = i11 % 128;
            int i12 = i11 % 2;
            cArr = cArr3;
        }
        objArr[0] = new String(cArr);
    }

    static {
        init$1();
        $10 = 0;
        $11 = 1;
        init$0();
        D8871 = 0;
        setPivotYN16904 = 1;
        component5 = 1125199012;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0567  */
    /* JADX WARN: Code duplicated, block: B:37:0x056d  */
    /* JADX WARN: Code duplicated, block: B:39:0x05f7  */
    public static Object[] setPivotYN16904(Context context, int i, int i2, int i3) throws Throwable {
        Object[] objArr;
        int i4;
        boolean zEquals;
        int i5 = 2 % 2;
        Object obj = null;
        if (context == null) {
            Object[] objArr2 = {new int[]{i}, null, new int[]{i}, new int[1]};
            int i6 = ((1704643114 + (((~((-34735491) | i)) | (~(1876670443 | i))) * 69)) + (((~(i | 1268430762)) | ((~((-642975172) | i)) | 608239681)) * (-69))) - 774372152;
            int iVD14832N6715 = n.vD14832N6715();
            int i7 = i6 * 185;
            int i8 = (i7 << 1) - i7;
            int i9 = -(-(((i6 ^ (-1)) | i6) * (-368)));
            int i10 = (i8 ^ i9) + ((i9 & i8) << 1);
            int i11 = ~i6;
            int i12 = ~iVD14832N6715;
            int i13 = ((i11 & i12) | (i11 ^ i12)) * 184;
            int i14 = (i10 ^ i13) + ((i13 & i10) << 1);
            int i15 = ~i6;
            int i16 = ~(i15 | ((-1) ^ i15));
            int i17 = ~i12;
            int i18 = ((i17 & i16) | (i16 ^ i17) | (~i6)) * 184;
            int i19 = -(-(((i14 | i18) << 1) - (i18 ^ i14)));
            int i20 = ((i3 | i19) << 1) - (i3 ^ i19);
            int i21 = (i20 << 13) ^ i20;
            int i22 = i21 >>> 17;
            int i23 = (i21 | i22) & (~(i21 & i22));
            ((int[]) objArr2[3])[0] = i23 ^ (i23 << 5);
            return objArr2;
        }
        int i24 = setPivotYN16904;
        int i25 = (i24 ^ 85) + ((i24 & 85) << 1);
        D8871 = i25 % 128;
        int i26 = i25 % 2;
        try {
            int i27 = -KeyEvent.keyCodeFromString("");
            int iVD14832N6716 = n.vD14832N6715();
            int i28 = (i27 * (-494)) - 3458;
            int i29 = -(-((~((i27 ^ 7) | (i27 & 7))) * (-495)));
            int i30 = (i28 ^ i29) + ((i28 & i29) << 1);
            int i31 = ~iVD14832N6716;
            int i32 = -(-((i27 | i31) * 495));
            int i33 = (i30 & i32) + (i32 | i30);
            int i34 = ~i27;
            int i35 = ~((i34 & (-8)) | (i34 ^ (-8)));
            int i36 = ~((i27 & i31) | (i31 ^ i27));
            int i37 = (i33 - (~(((i36 & i35) | (i35 ^ i36)) * 495))) - 1;
            int i38 = -TextUtils.indexOf("", "", 0);
            int i39 = i38 * 934;
            int i40 = ((i39 | (-21436)) << 1) - (i39 ^ (-21436));
            int i41 = ~i38;
            int i42 = ~i;
            int i43 = ~((i41 ^ i42) | (i41 & i42));
            int i44 = i40 + ((((-24) ^ i43) | ((-24) & i43)) * (-933));
            int i45 = ~((-24) | i42);
            int i46 = ~(((-24) ^ i38) | ((-24) & i38));
            int i47 = (i44 - (~(((i45 ^ i46) | (i45 & i46)) * 933))) - 1;
            int i48 = -(-((~((i38 ^ 23) | (i38 & 23))) * 933));
            Object[] objArr3 = new Object[1];
            a("\uffde\n\t\u000f\u0000\u0013\u000f￼\t\uffff\r\n\u0004\uffff\uffc9\ufffe\n\t\u000f\u0000\t\u000f\uffc9", i37, false, (i47 ^ i48) + ((i48 & i47) << 1), 100 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            int i49 = -(-(KeyEvent.getMaxKeyCode() >> 16));
            Object[] objArr4 = new Object[1];
            a("￢\u0007\uffff\b\u0000\ufffe\rￚ\t\t\u0005\u0002￼\ufffa\r\u0002\b\u0007", ((i49 & 4) << 1) + (i49 ^ 4), false, 16777234 + Color.rgb(0, 0, 0), 103 - (ViewConfiguration.getScrollBarSize() >> 8), objArr4);
            Object objInvoke = cls.getMethod((String) objArr4[0], null).invoke(context, null);
            int i50 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
            int i51 = (i50 * (-665)) + 10020;
            int i52 = ~i50;
            int i53 = -(-(i52 * (-333)));
            int i54 = (i51 ^ i53) + ((i51 & i53) << 1);
            int i55 = ~i;
            int i56 = ~((i52 ^ i55) | (i52 & i55));
            int i57 = ~((i ^ 30) | (i & 30));
            int i58 = (i54 - (~(-(-(((i56 ^ i57) | (i57 & i56)) * 333))))) - 1;
            int i59 = ~((i52 ^ i) | (i52 & i));
            int i60 = ~((i42 ^ 30) | (i42 & 30));
            int i61 = i58 + (((i59 & i60) | (i59 ^ i60)) * 333);
            int i62 = -Drawable.resolveOpacity(0, 0);
            int i63 = (i62 & 34) + (i62 | 34);
            int i64 = -View.combineMeasuredStates(0, 0);
            int i65 = (i64 * 677) - 66825;
            int i66 = i64 | i;
            int i67 = ((i66 ^ (-100)) | (i66 & (-100))) * (-676);
            int i68 = (i65 & i67) + (i65 | i67);
            int i69 = ~((-100) | i64);
            int i70 = ~(i42 | i64);
            int i71 = -(-(((i69 ^ i70) | (i70 & i69)) * 676));
            int i72 = (i68 ^ i71) + ((i68 & i71) << 1);
            int i73 = ~i64;
            int i74 = ~((i73 ^ (-100)) | (i73 & (-100)));
            int i75 = ~(((-100) ^ i42) | ((-100) & i42));
            int i76 = (i74 ^ i75) | (i74 & i75);
            int i77 = (i64 & 99) | (i64 ^ 99);
            int i78 = ~((i77 & i) | (i77 ^ i));
            int i79 = i72 + (((i78 & i76) | (i76 ^ i78)) * 676);
            Object[] objArr5 = new Object[1];
            a("\f\u0006\u0001ￋ\u0000\f\u000b\u0011\u0002\u000b\u0011ￋ\r\nￋ\uffde\r\r\t\u0006\u0000\ufffe\u0011\u0006\f\u000b￦\u000b\u0003\f\ufffe\u000b\u0001\u000f", i61, false, i63, i79, objArr5);
            Class<?> cls2 = Class.forName((String) objArr5[0]);
            int size = View.MeasureSpec.getSize(0);
            int iVD14832N6717 = n.vD14832N6715();
            int i80 = (size * (-721)) - 721;
            int i81 = ~iVD14832N6717;
            int i82 = ~size;
            int i83 = ~((i82 ^ (-2)) | (i82 & (-2)));
            int i84 = (i81 ^ i83) | (i83 & i81);
            int i85 = (size ^ 1) | (size & 1);
            int i86 = ~i85;
            int i87 = ((i84 ^ i86) | (i84 & i86)) * 1444;
            int i88 = (i80 & i87) + (i87 | i80);
            int i89 = ~i85;
            int i90 = ~((size ^ iVD14832N6717) | (size & iVD14832N6717));
            int i91 = (i89 & i90) | (i89 ^ i90);
            int i92 = ~((iVD14832N6717 & 1) | (iVD14832N6717 ^ 1));
            int i93 = (i88 - (~(-(-(((i91 & i92) | (i91 ^ i92)) * (-1444)))))) - 1;
            int i94 = ~(i82 | 1);
            int i95 = ~((size & (-2)) | ((-2) ^ size));
            int i96 = i93 + (((i95 & i94) | (i94 ^ i95)) * 722);
            int threadPriority = (Process.getThreadPriority(0) + 20) >> 6;
            int i97 = ~threadPriority;
            int i98 = (((threadPriority * (-381)) + 960) - (~(-(-(i97 * (-191)))))) - 1;
            int i99 = ~((i ^ 5) | (i & 5));
            int i100 = -(-(((threadPriority & i99) | (threadPriority ^ i99)) * 191));
            int i101 = (i98 ^ i100) + ((i100 & i98) << 1);
            int i102 = ((~((i97 ^ 5) | (i97 & 5))) | (~(i55 | 5))) * 191;
            int i103 = (i101 & i102) + (i102 | i101);
            int i104 = -Color.blue(0);
            int i105 = i104 * (-464);
            int i106 = (i105 ^ (-97545)) + ((i105 & (-97545)) << 1);
            int i107 = ~i104;
            int i108 = ~(i | 105);
            int i109 = ((i107 & i108) | (i107 ^ i108)) * (-465);
            int i110 = ((i106 | i109) << 1) - (i109 ^ i106);
            int i111 = ~i104;
            int i112 = ~(i111 | i);
            int i113 = -(-(((i112 & 105) | (i112 ^ 105)) * 930));
            int i114 = ((i110 | i113) << 1) - (i113 ^ i110);
            int i115 = (i ^ 105) | (i & 105);
            int i116 = -(-(((i111 & i115) | (i115 ^ i111)) * 465));
            int i117 = ((i114 | i116) << 1) - (i116 ^ i114);
            Object[] objArr6 = new Object[1];
            a("�\n\ufffe\ufff8\u0003", i96, true, i103, i117, objArr6);
            if ((cls2.getField((String) objArr6[0]).getInt(objInvoke) & 2) != 0) {
                int i118 = D8871;
                int i119 = i118 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                setPivotYN16904 = i119 % 128;
                int i120 = i119 % 2;
                int i121 = ((i118 | 73) << 1) - (i118 ^ 73);
                setPivotYN16904 = i121 % 128;
                int i122 = i121 % 2;
                objArr = new Object[]{new int[]{i}, null, new int[]{i ^ 1}, new int[]{((~i) & i) | ((~i) & i)}};
                int i123 = i3 + 1831690685 + ((~(656660347 | i55)) * (-560)) + ((~((-1221075073) | i)) * (-560)) + (((~(1254745586 | i55)) | 622989833) * 560) + 16;
                int i124 = i123 << 13;
                int i125 = (i124 & (~i123)) | ((~i124) & i123);
                int i126 = i125 >>> 17;
                int i127 = ((~i125) & i126) | ((~i126) & i125);
                int i128 = i127 << 5;
            } else {
                objArr = new Object[]{new int[]{i}, null, new int[]{i}, new int[]{((~i) & i) | ((~i) & i)}};
                int i129 = 576593513 + (((-1073844578) | i) * (-676)) + (((~(433728522 | i55)) | 1073844577) * 676) + (((~((-1477677412) | i55)) | 403832834 | (~(1507573099 | i))) * 676);
                int i130 = (-(-(i129 * (-756)))) + (i42 * (-757));
                int i131 = ~i129;
                int i132 = -(-((~((i131 ^ i) | (i131 & i))) * 1514));
                int i133 = ((i130 | i132) << 1) - (i130 ^ i132);
                int i134 = ~(((-1) ^ i131) | i131);
                int i135 = ~i129;
                int i136 = i134 | (~((i135 & i55) | (i135 ^ i55)));
                int i137 = ~((i129 & i) | (i129 ^ i));
                int i138 = i3 + i133 + (((i136 & i137) | (i136 ^ i137)) * 757);
                int i139 = i138 << 13;
                int i140 = (i139 | i138) & (~(i138 & i139));
                int i141 = i140 >>> 17;
                int i142 = (i140 | i141) & (~(i140 & i141));
                int i143 = i142 << 5;
                int i144 = D8871;
                int i145 = (i144 & 49) + (i144 | 49);
                setPivotYN16904 = i145 % 128;
                int i146 = i145 % 2;
            }
            if (((int[]) objArr[2])[0] != i) {
                int i147 = D8871;
                int i148 = i147 + 87;
                setPivotYN16904 = i148 % 128;
                if (i148 % 2 == 0) {
                    obj.hashCode();
                    throw null;
                }
                int i149 = i147 + 87;
                setPivotYN16904 = i149 % 128;
                int i150 = i149 % 2;
                return objArr;
            }
            try {
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1185383580);
                if (objComponent5 == null) {
                    int iLastIndexOf = TextUtils.lastIndexOf("", '0') + 53;
                    char modifierMetaStateMask = (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 34443);
                    int defaultSize = View.getDefaultSize(0, 0) + 5524;
                    byte b = (byte) ($$b & 87);
                    byte b2 = (byte) ($$a[21] + 1);
                    Object[] objArr7 = new Object[1];
                    b(b, b2, b2, objArr7);
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iLastIndexOf, modifierMetaStateMask, defaultSize, -336773369, false, (String) objArr7[0], new Class[0]);
                }
                Set set = (Set) ((Method) objComponent5).invoke(null, null);
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1204470180);
                if (objComponent6 == null) {
                    int packedPositionType = 52 - ExpandableListView.getPackedPositionType(0L);
                    char touchSlop = (char) (34442 - (ViewConfiguration.getTouchSlop() >> 8));
                    int pressedStateDuration = (ViewConfiguration.getPressedStateDuration() >> 16) + 5524;
                    byte[] bArr = $$a;
                    byte b3 = (byte) (-bArr[18]);
                    byte b4 = bArr[10];
                    Object[] objArr8 = new Object[1];
                    b(b3, b4, (byte) (b4 | 37), objArr8);
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(packedPositionType, touchSlop, pressedStateDuration, 360678855, false, (String) objArr8[0], null);
                }
                if (!set.contains(((Field) objComponent6).get(null))) {
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-986694391);
                    if (objComponent7 == null) {
                        int maximumFlingVelocity = 52 - (ViewConfiguration.getMaximumFlingVelocity() >> 16);
                        char c = (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34441);
                        int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 5524;
                        byte b5 = (byte) ($$b & 87);
                        byte b6 = (byte) ($$a[21] + 1);
                        Object[] objArr9 = new Object[1];
                        b(b5, b6, b6, objArr9);
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(maximumFlingVelocity, c, keyRepeatTimeout, -1752860310, false, (String) objArr9[0], null);
                    }
                    if (set.contains(((Field) objComponent7).get(null))) {
                        if (Build.VERSION.SDK_INT == 30) {
                            int i151 = setPivotYN16904 + 59;
                            D8871 = i151 % 128;
                            int i152 = i151 % 2;
                            Object[] objArr10 = {new int[]{i}, null, new int[]{i}, new int[1]};
                            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                            int i153 = ~iElapsedRealtime;
                            int i154 = (-739252943) + (((~((-233901162) | i153)) | 32505856 | (~((-1677504773) | i153)) | (~(1878900077 | iElapsedRealtime))) * (-84));
                            int i155 = (~(iElapsedRealtime | (-1677504773))) | 233901161;
                            int i156 = ~(i153 | 1677504772);
                            int i157 = -(-(i154 + ((i155 | i156) * (-84)) + (((-1878900078) | i156) * 84)));
                            int i158 = ((i3 | i157) << 1) - (i3 ^ i157);
                            int i159 = i158 << 13;
                            int i160 = (i159 & (~i158)) | ((~i159) & i158);
                            int i161 = i160 ^ (i160 >>> 17);
                            int i162 = i161 << 5;
                            ((int[]) objArr10[3])[0] = (i161 | i162) & (~(i161 & i162));
                            i4 = setPivotYN16904 + 25;
                            D8871 = i4 % 128;
                            if (i4 % 2 != 0) {
                                int i163 = 12 / 0;
                            }
                            return objArr10;
                        }
                    }
                } else if (Build.VERSION.SDK_INT == 30) {
                    int i1510 = setPivotYN16904 + 59;
                    D8871 = i1510 % 128;
                    int i1511 = i1510 % 2;
                    Object[] objArr11 = {new int[]{i}, null, new int[]{i}, new int[1]};
                    int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                    int i1512 = ~iElapsedRealtime2;
                    int i1513 = (-739252943) + (((~((-233901162) | i1512)) | 32505856 | (~((-1677504773) | i1512)) | (~(1878900077 | iElapsedRealtime2))) * (-84));
                    int i1514 = (~(iElapsedRealtime2 | (-1677504773))) | 233901161;
                    int i1515 = ~(i1512 | 1677504772);
                    int i1516 = -(-(i1513 + ((i1514 | i1515) * (-84)) + (((-1878900078) | i1515) * 84)));
                    int i1517 = ((i3 | i1516) << 1) - (i3 ^ i1516);
                    int i1518 = i1517 << 13;
                    int i164 = (i1518 & (~i1517)) | ((~i1518) & i1517);
                    int i165 = i164 ^ (i164 >>> 17);
                    int i166 = i165 << 5;
                    ((int[]) objArr11[3])[0] = (i165 | i166) & (~(i165 & i166));
                    i4 = setPivotYN16904 + 25;
                    D8871 = i4 % 128;
                    if (i4 % 2 != 0) {
                        int i167 = 12 / 0;
                    }
                    return objArr11;
                }
                if ((i2 & 32) == 0) {
                    try {
                        if (Build.VERSION.SDK_INT > 33) {
                            int i168 = D8871;
                            int i169 = (i168 ^ 83) + ((i168 & 83) << 1);
                            setPivotYN16904 = i169 % 128;
                            int i170 = i169 % 2;
                            int i171 = -AndroidCharacter.getMirror('0');
                            int i172 = (i171 & 49) + (i171 | 49);
                            int i173 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            int i174 = ~(((-29) ^ i42) | ((-29) & i42));
                            int i175 = ((i173 * (-112)) - 3136) + (((i174 & i173) | (i173 ^ i174)) * 226);
                            int i176 = ~i173;
                            int i177 = ~((i176 & 28) | (i176 ^ 28));
                            int i178 = ~((~i173) | i);
                            int i179 = (i177 & i178) | (i177 ^ i178);
                            int i180 = (-29) | i55;
                            int i181 = ~((i173 & i180) | (i180 ^ i173));
                            int i182 = -(-(((i181 & i179) | (i179 ^ i181)) * (-113)));
                            int i183 = (((i175 | i182) << 1) - (i182 ^ i175)) + ((~((-29) | i)) * 113);
                            int iIndexOf = TextUtils.indexOf("", "", 0, 0);
                            int i184 = iIndexOf * (-1335);
                            int i185 = (i184 & (-62698)) + (i184 | (-62698));
                            int i186 = ~((iIndexOf ^ i) | (iIndexOf & i));
                            int i187 = i185 + (((i186 & (-95)) | ((-95) ^ i186)) * (-668));
                            int i188 = ~((-95) | i);
                            int i189 = ((i188 & iIndexOf) | (iIndexOf ^ i188)) * 1336;
                            int i190 = iIndexOf | i;
                            int i191 = (((i187 & i189) + (i189 | i187)) - (~(-(-(((i190 & (-95)) | (i190 ^ (-95))) * 668))))) - 1;
                            Object[] objArr12 = new Object[1];
                            a("\uffd1\u0005\u0014\uffd0\u0007\u000e\u0004\u0003\t\t\u0017\u0004\u0007\u0006ￏ\u0006\r\u000e\u000e\uffd1\u0016\u000b\u0010\u000b\uffd1\u0005\u0016\u0007", i172, true, i183, i191, objArr12);
                            try {
                                Object[] objArr13 = {(String) objArr12[0]};
                                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                if (objComponent8 == null) {
                                    int i192 = 53 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                    char cIndexOf = (char) (59725 - TextUtils.indexOf("", ""));
                                    int i193 = 6317 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                    byte b7 = (byte) ($$a[20] - 1);
                                    byte b8 = (byte) (b7 | 8);
                                    Object[] objArr14 = new Object[1];
                                    b(b7, b8, (byte) (b8 + 5), objArr14);
                                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(i192, cIndexOf, i193, 1385817144, false, (String) objArr14[0], new Class[]{String.class});
                                }
                                long jLongValue = ((Long) ((Method) objComponent8).invoke(null, objArr13)).longValue();
                                long jElapsedRealtime = (int) SystemClock.elapsedRealtime();
                                long j = jElapsedRealtime ^ (-1);
                                long j2 = (-139979728800L) + ((-520) * jLongValue) + ((-1042) * ((-268160400) | ((j | jLongValue) ^ (-1)))) + ((jLongValue | jElapsedRealtime) * 521) + (521 * ((((j | (-268160400)) | jLongValue) ^ (-1)) | ((268160399 | (jLongValue ^ (-1))) ^ (-1)) | ((268160399 | jElapsedRealtime) ^ (-1)))) + 672740306;
                                int i194 = (~(1411127156 | i55)) | 35750016 | (~((-1446613729) | i55));
                                int i195 = ((int) (j2 >> 32)) & (899467410 + (((~((-263445) | i)) | i194) * 590) + (i194 * (-1180)) + (((~(1446613728 | i55)) | (~((-1411127157) | i55))) * 590));
                                int i196 = ((int) j2) & (818885255 + ((710934630 | i55) * 1324) + (((~(711305318 | i)) | (~(2146435567 | i))) * (-1324)) + 1359243334);
                                if (((i195 & i196) | (i195 ^ i196)) == 1) {
                                    int i197 = setPivotYN16904;
                                    int i198 = ((i197 | 81) << 1) - (i197 ^ 81);
                                    D8871 = i198 % 128;
                                    if (i198 % 2 != 0) {
                                        int i199 = 5 % 3;
                                    }
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
                            int i200 = (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                            int i201 = ~((~i200) | (-9) | i42);
                            int i202 = ~((i ^ 8) | (i & 8));
                            int i203 = (i200 * (-519)) + 4168 + (((i201 & i202) | (i201 ^ i202)) * 520);
                            int i204 = ~(((-9) ^ i55) | ((-9) & i55));
                            int i205 = ~(i200 | i);
                            int i206 = i203 + (((i204 & i205) | (i204 ^ i205)) * (-1040));
                            int i207 = ~i200;
                            int i208 = ~((i207 & i55) | (i207 ^ i55));
                            int i209 = ~((-9) | i200);
                            int i210 = (i208 & i209) | (i208 ^ i209);
                            int i211 = ~((i200 & i) | (i200 ^ i));
                            int i212 = (i206 - (~(-(-(((i211 & i210) | (i210 ^ i211)) * 520))))) - 1;
                            int i213 = -(ViewConfiguration.getKeyRepeatDelay() >> 16);
                            int i214 = (i213 * (-830)) + 10816;
                            int i215 = ~(((-14) ^ i55) | ((-14) & i55));
                            int i216 = ~(i213 | 13 | i);
                            int i217 = ((i215 & i216) | (i215 ^ i216)) * (-831);
                            int i218 = (i214 & i217) + (i214 | i217) + ((~((-14) | i213 | i)) * (-1662));
                            int i219 = ~i213;
                            int i220 = ~((i219 & i55) | (i219 ^ i55));
                            int i221 = ~(i213 | i);
                            int i222 = (i221 & i220) | (i220 ^ i221);
                            int i223 = ~(i | 13);
                            int i224 = -(-(((i222 & i223) | (i222 ^ i223)) * 831));
                            int i225 = ((i218 | i224) << 1) - (i224 ^ i218);
                            int i226 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                            int i227 = i226 * (-129);
                            int i228 = (((i227 | 12838) << 1) - (i227 ^ 12838)) + ((~(((-99) ^ i55) | ((-99) & i55) | i226)) * 130);
                            int i229 = ((-99) & i226) | ((-99) ^ i226);
                            int i230 = -(-((~i229) * (-260)));
                            int i231 = (i228 & i230) + (i228 | i230);
                            int i232 = ~i226;
                            int i233 = ~((i232 & 98) | (i232 ^ 98));
                            int i234 = ~((i229 & i) | (i229 ^ i));
                            int i235 = ((i233 & i234) | (i233 ^ i234)) * 130;
                            int i236 = ((i231 | i235) << 1) - (i235 ^ i231);
                            Object[] objArr15 = new Object[1];
                            a("\u0004\u0004\u0012\uffff\u0002\u0001ￋ\f\u000f\u0002\t\uffff\ufffe", i212, true, i225, i236, objArr15);
                            try {
                                Object[] objArr16 = {(String) objArr15[0]};
                                Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                if (objComponent9 == null) {
                                    int mirror = AndroidCharacter.getMirror('0') + 4;
                                    char c2 = (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1);
                                    int keyRepeatDelay = (ViewConfiguration.getKeyRepeatDelay() >> 16) + 6473;
                                    byte[] bArr2 = $$a;
                                    Object[] objArr17 = new Object[1];
                                    b((byte) (bArr2[21] + 1), bArr2[24], bArr2[8], objArr17);
                                    objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(mirror, c2, keyRepeatDelay, 1068791596, false, (String) objArr17[0], new Class[]{String.class});
                                }
                                Object objInvoke2 = ((Method) objComponent9).invoke(null, objArr16);
                                int i237 = -(ViewConfiguration.getTapTimeout() >> 16);
                                int i238 = (i237 ^ 1) + ((i237 & 1) << 1);
                                int i239 = -TextUtils.lastIndexOf("", '0');
                                int iRgb = Color.rgb(0, 0, 0);
                                int i240 = iRgb * (-209);
                                int i241 = (i240 ^ 788518911) + ((i240 & 788518911) << 1);
                                int i242 = ~iRgb;
                                int i243 = (~((i242 ^ (-16777266)) | (i242 & (-16777266)))) * 210;
                                int i244 = ((i241 | i243) << 1) - (i241 ^ i243);
                                int i245 = ~(((-16777266) ^ i42) | ((-16777266) & i42));
                                int i246 = ~((i242 ^ i) | (i242 & i));
                                int i247 = (i244 - (~(((i245 & i246) | (i245 ^ i246)) * 210))) - 1;
                                int i248 = (i242 & i55) | (i242 ^ i55);
                                int i249 = ~((i248 & 16777265) | (i248 ^ 16777265));
                                int i250 = (iRgb & (-16777266)) | ((-16777266) ^ iRgb);
                                int i251 = ~((i250 & i) | (i250 ^ i));
                                int i252 = (i247 - (~(-(-(((i251 & i249) | (i249 ^ i251)) * 210))))) - 1;
                                Object[] objArr18 = new Object[1];
                                a(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, i238, true, i239, i252, objArr18);
                                zEquals = objInvoke2.equals((String) objArr18[0]);
                            } catch (Throwable th2) {
                                Throwable cause2 = th2.getCause();
                                if (cause2 != null) {
                                    throw cause2;
                                }
                                throw th2;
                            }
                        }
                    } catch (Exception unused) {
                        zEquals = false;
                    }
                    if (zEquals) {
                        Object[] objArr19 = {new int[]{i}, null, new int[]{(i & (-11)) | (i55 & 10)}, new int[]{i ^ (i << 5)}};
                        int i253 = (-1730354545) + (((~((-369210911) | i)) | (-1542195024)) * (-318)) + (((~((-1542195024) | i)) | (~(1609414495 | i55))) * TypedValues.Attributes.TYPE_PIVOT_TARGET) + (((~((-1240203586) | i55)) | (~(i | 1609414495))) * TypedValues.Attributes.TYPE_PIVOT_TARGET);
                        int i254 = (i253 ^ 16) + ((i253 & 16) << 1);
                        int i255 = (i3 ^ i254) + ((i3 & i254) << 1);
                        int i256 = i255 << 13;
                        int i257 = (i256 | i255) & (~(i255 & i256));
                        int i258 = i257 ^ (i257 >>> 17);
                        return objArr19;
                    }
                }
                Object[] objArr20 = {new int[]{i}, null, new int[]{i}, new int[1]};
                int i259 = ((560824323 + (((-1843405322) | i55) * 1444)) + (((~(i | 1273425851)) | ((~(637980082 | i)) | (-1877405628))) * (-1444))) - 501219998;
                int iVD14832N6718 = n.vD14832N6715();
                int i260 = ~i259;
                int i261 = (i259 * (-209)) + ((~(i260 | ((-1) ^ i260))) * 210);
                int i262 = ~i259;
                int i263 = ~iVD14832N6718;
                int i264 = -(-(((~((i262 ^ i263) | (i262 & i263))) | (~(((-1) ^ iVD14832N6718) | iVD14832N6718))) * 210));
                int i265 = (i261 & i264) + (i261 | i264);
                int i266 = ~(((-1) ^ i263) | i263 | i259);
                int i267 = ~((iVD14832N6718 & i262) | (i262 ^ iVD14832N6718));
                int i268 = ((i267 & i266) | (i266 ^ i267)) * 210;
                int i269 = (i3 - (~((i265 & i268) + (i268 | i265)))) - 1;
                int i270 = i269 ^ (i269 << 13);
                int i271 = i270 >>> 17;
                int i272 = ((~i270) & i271) | ((~i271) & i270);
                ((int[]) objArr20[3])[0] = i272 ^ (i272 << 5);
                return objArr20;
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
