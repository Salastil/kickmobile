package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.media3.muxer.WebmConstants;
import com.datadog.reactnative.ProxyAuthenticator;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.imageutils.JfifUtil;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public final class getExplicitStyle extends wX26196 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static char D8871;
    private static long component5;
    private static int component9;
    private static int vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(byte r6, int r7, byte r8) {
        /*
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.getExplicitStyle.$$a
            int r7 = r7 * 4
            int r1 = 1 - r7
            int r6 = r6 * 2
            int r6 = 3 - r6
            int r8 = r8 + 102
            byte[] r1 = new byte[r1]
            r2 = 0
            int r7 = 0 - r7
            if (r0 != 0) goto L17
            r8 = r6
            r3 = r7
            r4 = r2
            goto L2c
        L17:
            r3 = r2
        L18:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            return r6
        L27:
            r3 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r5
        L2c:
            int r3 = -r3
            int r6 = r6 + r3
            r3 = r8
            r8 = r6
            r6 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.getExplicitStyle.$$c(byte, int, byte):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{101, -78, -82, -26};
        $$b = 141;
    }

    public getExplicitStyle(Boolean bool, wX26196.setPivotYN16904 setpivotyn16904) {
        super(I30900.component10.INSTANCE.component5(), bool, setpivotyn16904);
    }

    private static void a(String str, int i, String str2, char c, String str3, Object[] objArr) throws Throwable {
        char[] charArray;
        int i2 = 2;
        int i3 = 2 % 2;
        char[] charArray2 = str3 != null ? str3.toCharArray() : str3;
        char[] charArray3 = str2 != null ? str2.toCharArray() : str2;
        if (str != null) {
            charArray = str.toCharArray();
            int i4 = $11 + 17;
            $10 = i4 % 128;
            int i5 = i4 % 2;
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        cn cnVar = new cn();
        int length = charArray2.length;
        char[] cArr2 = new char[length];
        int length2 = charArray3.length;
        char[] cArr3 = new char[length2];
        byte b = 0;
        System.arraycopy(charArray2, 0, cArr2, 0, length);
        System.arraycopy(charArray3, 0, cArr3, 0, length2);
        cArr2[0] = (char) (cArr2[0] ^ c);
        cArr3[2] = (char) (cArr3[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr4 = new char[length3];
        cnVar.setPivotYN16904 = 0;
        while (cnVar.setPivotYN16904 < length3) {
            int i6 = $11 + 1;
            $10 = i6 % 128;
            int i7 = i6 % i2;
            try {
                Object[] objArr2 = {cnVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(528238139);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(85 - Process.getGidForName(""), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 55625), 423 - ((Process.getThreadPriority(b) + 20) >> 6), 1305018968, false, "c", new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {cnVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1013236775);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(53 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (55222 - Process.getGidForName("")), Color.blue((int) b) + 3269, -1859223622, false, $$c(b, b, (byte) 1), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                int i8 = cArr2[cnVar.setPivotYN16904 % 4] * 32718;
                Object[] objArr4 = new Object[3];
                objArr4[i2] = Integer.valueOf(cArr3[iIntValue]);
                objArr4[1] = Integer.valueOf(i8);
                objArr4[b] = cnVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-523427508);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (TypedValue.complexToFraction(b, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(b, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (AndroidCharacter.getMirror('0') + 41995), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2308, -1300732625, false, ContextChain.TAG_INFRA, new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                int i9 = cArr2[iIntValue2] * 32718;
                Object[] objArr5 = new Object[2];
                objArr5[1] = Integer.valueOf(cArr3[iIntValue]);
                objArr5[b] = Integer.valueOf(i9);
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1175171274);
                if (objComponent8 == null) {
                    byte b2 = b;
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 52, (char) (58885 - TextUtils.indexOf("", "", b2, b2)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 6886, 348058793, false, $$c(b2, b2, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr3[iIntValue2] = ((Character) ((Method) objComponent8).invoke(null, objArr5)).charValue();
                cArr2[iIntValue2] = cnVar.D8871;
                cArr4[cnVar.setPivotYN16904] = (char) (((((long) (cArr[cnVar.setPivotYN16904] ^ cArr2[iIntValue2])) ^ (component5 ^ (-8233799196330309486L))) ^ ((long) ((int) (((long) vD14832N6715) ^ (-8233799196330309486L))))) ^ ((long) ((char) (((long) D8871) ^ (-8233799196330309486L)))));
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

    private static void b(int i, boolean z, int i2, int i3, String str, Object[] objArr) throws Throwable {
        char[] charArray;
        int i4;
        int i5 = 2 % 2;
        Object obj = null;
        if (str != null) {
            int i6 = $11 + 113;
            $10 = i6 % 128;
            if (i6 % 2 != 0) {
                str.toCharArray();
                obj.hashCode();
                throw null;
            }
            charArray = str.toCharArray();
        } else {
            charArray = str;
        }
        char[] cArr = charArray;
        cm cmVar = new cm();
        char[] cArr2 = new char[i3];
        cmVar.component9 = 0;
        while (cmVar.component9 < i3) {
            int i7 = $10 + 117;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            cmVar.setPivotYN16904 = cArr[cmVar.component9];
            cArr2[cmVar.component9] = (char) (i2 + cmVar.setPivotYN16904);
            int i9 = cmVar.component9;
            try {
                Object[] objArr2 = {Integer.valueOf(cArr2[i9]), Integer.valueOf(component9)};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1226238903);
                if (objComponent5 == null) {
                    i4 = -2009915307;
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 49, (char) (35724 - TextUtils.lastIndexOf("", '0', 0, 0)), 2878 - (ViewConfiguration.getEdgeSlop() >> 16), 463712212, false, $$c((byte) 0, 0, Ascii.DC2), new Class[]{Integer.TYPE, Integer.TYPE});
                } else {
                    i4 = -2009915307;
                }
                cArr2[i9] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                Object[] objArr3 = {cmVar, cmVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i4);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 69, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 19667), 1954 - AndroidCharacter.getMirror('0'), -628726730, false, "v", new Class[]{Object.class, Object.class});
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
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - cmVar.vD14832N6715, cmVar.vD14832N6715);
            System.arraycopy(cArr3, cmVar.vD14832N6715, cArr2, 0, i3 - cmVar.vD14832N6715);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            cmVar.component9 = 0;
            while (cmVar.component9 < i3) {
                cArr4[cmVar.component9] = cArr2[(i3 - cmVar.component9) - 1];
                Object[] objArr4 = {cmVar, cmVar};
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-2009915307);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(70 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 19666), 1905 - TextUtils.lastIndexOf("", '0', 0), -628726730, false, "v", new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent7).invoke(null, objArr4);
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    static {
        init$0();
        $10 = 0;
        $11 = 1;
        component5 = -8233799196330309486L;
        vD14832N6715 = 1725286546;
        D8871 = (char) 48207;
        component9 = 1125199075;
    }

    public static Object[] setPivotYN16904(Context context, int i, int i2) {
        char c;
        String str = "";
        int i3 = 1;
        if (context == null) {
            Object[] objArr = {new int[]{i}, null, new int[]{i}, new int[1]};
            int iMyTid = Process.myTid();
            int i4 = ~((-65732764) | iMyTid);
            int i5 = 1827852121 + ((32047113 | i4) * (-280)) + ((i4 | (~((-1845673171) | iMyTid))) * 140);
            int i6 = ~((-33685651) | iMyTid);
            int i7 = ~iMyTid;
            int i8 = i2 + i5 + (((~(i7 | (-1811987521))) | i6 | (~((-32047114) | i7))) * 140);
            int i9 = i8 << 13;
            int i10 = (i8 | i9) & (~(i8 & i9));
            int i11 = i10 ^ (i10 >>> 17);
            int i12 = i11 << 5;
            ((int[]) objArr[3])[0] = ((~i11) & i12) | ((~i12) & i11);
            return objArr;
        }
        try {
            int fadingEdgeLength = ViewConfiguration.getFadingEdgeLength() >> 16;
            char mirror = AndroidCharacter.getMirror('0');
            int i13 = mirror * 367;
            c = 3;
            int i14 = (i13 & (-17616)) + (i13 | (-17616)) + (((mirror ^ 65488) | (mirror & 65488)) * (-366));
            int i15 = -(-(((~((47 ^ i) | (47 & i))) | mirror) * (-366)));
            int i16 = (i14 & i15) + (i14 | i15);
            int i17 = ~mirror;
            int i18 = ~((i17 & (-48)) | (i17 ^ (-48)));
            int i19 = ~(mirror | '/' | i);
            try {
                Object[] objArr2 = new Object[1];
                a("ꘆ퓿\udb41臞\ud81bᆽ꧱葌靦粝\uef99ᒠᚣᨕӛⳇ㰀\uf589\uefdc徇䃆\ue3b2국\ud88aꕟ缸ū镆\ue5e9孏鞰䓼䀭꤅땖ち쳻\ue85a", fadingEdgeLength, "\u0000\u0000\u0000\u0000", (char) (i16 + (((i18 & i19) | (i18 ^ i19)) * 366)), "앰斲叅钾", objArr2);
                Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
                int i20 = (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                int i21 = (i20 & 45258890) + (i20 | 45258890);
                int i22 = -Color.red(0);
                int i23 = ~i22;
                int i24 = ~((i23 ^ (-56824)) | (i23 & (-56824)));
                int i25 = ~i;
                int i26 = ((-56824) ^ i25) | ((-56824) & i25);
                int i27 = ~i26;
                int i28 = (i24 ^ i27) | (i27 & i24);
                int i29 = i22 | 56823;
                int i30 = ~((i29 ^ i) | (i29 & i));
                int i31 = (((i22 * 253) + 14376219) - (~(-(-(((i28 ^ i30) | (i28 & i30)) * (-252)))))) - 1;
                int i32 = (i22 ^ 56823) | (i22 & 56823);
                int i33 = i31 + (i32 * (-252));
                int i34 = -(-(((~((i32 & i) | (i32 ^ i))) | (~(i22 | i26))) * 252));
                Object[] objArr4 = new Object[1];
                a("\udd6e蘫Ꮊ়\uf83dⱥ㏊犻筩貯\uf563\ue6fc縪荻\ud99f䇃ᑱ玑퀢\ud93b䬯″鬼焹襆㠞\ue323⦁쒊圇퀺", i21, "\u0000\u0000\u0000\u0000", (char) (((i33 | i34) << 1) - (i34 ^ i33)), "褌늘\uf702\uf6dd", objArr4);
                try {
                    Object[] objArr5 = {(String) objArr4[0]};
                    int iBlue = Color.blue(0);
                    int i35 = -(-TextUtils.lastIndexOf("", '0'));
                    Object[] objArr6 = new Object[1];
                    a("ꘆ퓿\udb41臞\ud81bᆽ꧱葌靦粝\uef99ᒠᚣᨕӛⳇ㰀\uf589\uefdc徇䃆\ue3b2국\ud88aꕟ缸ū镆\ue5e9孏鞰䓼䀭꤅땖ち쳻\ue85a", iBlue, "\u0000\u0000\u0000\u0000", (char) ((i35 & 1) + (i35 | 1)), "앰斲叅钾", objArr6);
                    objArr3[0] = Class.forName((String) objArr6[0]).getDeclaredConstructor(String.class).newInstance(objArr5);
                    int iBlue2 = Color.blue(0);
                    int i36 = ~(((-6) ^ iBlue2) | ((-6) & iBlue2));
                    int i37 = ~(i | 5);
                    int i38 = ((iBlue2 * (-391)) - 975) + (((i36 ^ i37) | (i36 & i37)) * (-196));
                    int i39 = (iBlue2 | 5) * 392;
                    int i40 = (i38 ^ i39) + ((i38 & i39) << 1) + (((~((~iBlue2) | (-6))) | (~((i ^ 5) | (i & 5)))) * 196);
                    int i41 = 156 - (~(-(SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))));
                    int i42 = -((byte) KeyEvent.getModifierMetaStateMask());
                    int i43 = i42 * 989;
                    int i44 = (i43 ^ (-29610)) + ((i43 & (-29610)) << 1);
                    int i45 = ~i;
                    int i46 = (-31) | i45;
                    int i47 = ~((i46 ^ i42) | (i46 & i42));
                    int i48 = (i42 ^ 30) | (i42 & 30);
                    char c2 = '0';
                    int i49 = ~((i48 ^ i) | (i48 & i));
                    int i50 = ((i44 + (((i47 ^ i49) | (i49 & i47)) * 988)) - (~(-(-(((i42 ^ (-31)) | (i42 & (-31))) * (-988)))))) - 1;
                    int i51 = ~i42;
                    int i52 = ~((i51 & (-31)) | (i51 ^ (-31)));
                    int i53 = ~(((-31) ^ i) | ((-31) & i));
                    int i54 = (i52 ^ i53) | (i52 & i53);
                    int i55 = i42 | i45;
                    int i56 = ~((i55 & 30) | (i55 ^ 30));
                    int i57 = ((i54 & i56) | (i54 ^ i56)) * 988;
                    int i58 = ((i50 | i57) << 1) - (i57 ^ i50);
                    Object[] objArr7 = new Object[1];
                    b(i40, true, i41, i58, "ￗ\ufffe\u0000￨￮\u0012 \r\u0010\uffefￋ\u000f\u0014\u001a\u001d\u000f\u0019￬￨\ufff9￮ￗ\u000f\u0014\u001a\u001d\u000f\u0019￬￨\ufffa", objArr7);
                    try {
                        Object[] objArr8 = {(String) objArr7[0]};
                        int deadChar = KeyEvent.getDeadChar(0, 0);
                        int i59 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                        Object[] objArr9 = new Object[1];
                        a("ꘆ퓿\udb41臞\ud81bᆽ꧱葌靦粝\uef99ᒠᚣᨕӛⳇ㰀\uf589\uefdc徇䃆\ue3b2국\ud88aꕟ缸ū镆\ue5e9孏鞰䓼䀭꤅땖ち쳻\ue85a", deadChar, "\u0000\u0000\u0000\u0000", (char) ((i59 & 1) + (i59 | 1)), "앰斲叅钾", objArr9);
                        objArr3[1] = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                        try {
                            int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 15;
                            int mirror2 = AndroidCharacter.getMirror('0') + '|';
                            int i60 = -(PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1));
                            int i61 = (i60 * 592) - 13570;
                            int i62 = ~i60;
                            int i63 = -(-((~(i62 | 23)) * (-1182)));
                            int i64 = (i61 & i63) + (i61 | i63);
                            int i65 = ((~((i62 ^ (-24)) | (i62 & (-24)) | i25)) | (~((i60 ^ 23) | (i60 & 23)))) * (-591);
                            int i66 = (((i64 | i65) << 1) - (i64 ^ i65)) + (((~i60) | i | (-24)) * 591);
                            Object[] objArr10 = new Object[1];
                            b(maximumDrawingCacheSize, false, mirror2, i66, "\ufffe\n\t\u000f\u0000\t\u000f\uffc9\uffde\n\t\u000f\u0000\u0013\u000f￼\t\uffff\r\n\u0004\uffff\uffc9", objArr10);
                            Class<?> cls = Class.forName((String) objArr10[0]);
                            int i67 = 1329253818 - (~ExpandableListView.getPackedPositionChild(0L));
                            int i68 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                            Object[] objArr11 = new Object[1];
                            a("膖⏾쭕솤䠾⾹킷\ud816㐿鍛뻡Ⲡ謒ྉỳΆ궊", i67, "\u0000\u0000\u0000\u0000", (char) ((i68 ^ 4921) + ((i68 & 4921) << 1)), "뫧㫍㥏氓", objArr11);
                            Object objInvoke = cls.getMethod((String) objArr11[0], null).invoke(context, null);
                            try {
                                int i69 = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                                int i70 = (i69 & 15) + (i69 | 15);
                                int tapTimeout = ViewConfiguration.getTapTimeout() >> 16;
                                int i71 = (tapTimeout & 172) + (tapTimeout | 172);
                                int i72 = -TextUtils.getOffsetAfter("", 0);
                                int i73 = (i72 * (-375)) - 8625;
                                int i74 = ~((~i72) | (-24));
                                float f = 0.0f;
                                int i75 = ~((i72 ^ 23) | (i72 & 23));
                                int i76 = ((i ^ i74) | (i74 & i) | i75) * 376;
                                int i77 = (i73 & i76) + (i73 | i76);
                                int i78 = ~((i25 ^ i72) | (i25 & i72));
                                int i79 = ((i75 & i78) | (i78 ^ i75)) * (-376);
                                int i80 = (i77 & i79) + (i77 | i79);
                                int i81 = ~i72;
                                int i82 = ((~((i81 & i) | (i81 ^ i))) | 23) * 376;
                                int i83 = (i80 ^ i82) + ((i82 & i80) << 1);
                                Object[] objArr12 = new Object[1];
                                b(i70, false, i71, i83, "\ufffe\n\t\u000f\u0000\t\u000f\uffc9\uffde\n\t\u000f\u0000\u0013\u000f￼\t\uffff\r\n\u0004\uffff\uffc9", objArr12);
                                Class<?> cls2 = Class.forName((String) objArr12[0]);
                                int i84 = 10 - (~View.MeasureSpec.getSize(0));
                                int i85 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                                int i86 = (i85 & 170) + (i85 | 170);
                                int i87 = -(ViewConfiguration.getPressedStateDuration() >> 16);
                                int i88 = i87 * (-830);
                                int i89 = ((-15) & i87) | ((-15) ^ i87);
                                int i90 = (((((i88 | 11648) << 1) - (i88 ^ 11648)) - (~(((~(((i87 ^ 14) | (i87 & 14)) | i)) | (~(((-15) ^ i45) | ((-15) & i45)))) * (-831)))) - 1) + ((~((i89 & i) | (i89 ^ i))) * (-1662));
                                int i91 = ~i87;
                                int i92 = ~((i91 & i25) | (i91 ^ i25));
                                int i93 = ~((i87 & i) | (i87 ^ i));
                                int i94 = (i92 & i93) | (i92 ^ i93);
                                int i95 = ~((i ^ 14) | (i & 14));
                                int i96 = (i90 - (~(((i94 & i95) | (i94 ^ i95)) * 831))) - 1;
                                Object[] objArr13 = new Object[1];
                                b(i84, false, i86, i96, "￭\ufffe\u0000\b\ufffe\u0004\u0002￫\ufffe\n\u0002\u0004\u0002\u0011", objArr13);
                                try {
                                    Object[] objArr14 = {cls2.getMethod((String) objArr13[0], null).invoke(context, null), 64};
                                    int i97 = -((Process.getThreadPriority(0) + 20) >> 6);
                                    int i98 = (i97 & 5) + (i97 | 5);
                                    int i99 = -Gravity.getAbsoluteGravity(0, 0);
                                    int i100 = ~i99;
                                    int i101 = ~((i100 ^ i25) | (i100 & i25));
                                    int i102 = ~(((-170) ^ i) | ((-170) & i));
                                    int i103 = (((i99 * (-433)) - 36504) - (~(((i101 ^ i102) | (i101 & i102)) * JfifUtil.MARKER_EOI))) - 1;
                                    int i104 = ~(i100 | (-170));
                                    int i105 = ~((i100 & i) | (i100 ^ i));
                                    int i106 = (i103 - (~(-(-(((i105 & i104) | (i104 ^ i105)) * JfifUtil.MARKER_EOI))))) - 1;
                                    int i107 = -(-((i99 | (~(((-170) ^ i25) | ((-170) & i25)))) * JfifUtil.MARKER_EOI));
                                    int i108 = (i106 ^ i107) + ((i107 & i106) << 1);
                                    int i109 = -(ViewConfiguration.getDoubleTapTimeout() >> 16);
                                    int iVD14832N6715 = qU20128.vD14832N6715();
                                    int i110 = i109 * (-300);
                                    int i111 = (i110 ^ 9966) + ((i110 & 9966) << 1);
                                    int i112 = (i109 ^ 33) | (i109 & 33);
                                    int i113 = (~((i112 & iVD14832N6715) | (i112 ^ iVD14832N6715))) * (-301);
                                    int i114 = (i111 & i113) + (i113 | i111);
                                    int i115 = ~((-34) | iVD14832N6715);
                                    int i116 = ~((~iVD14832N6715) | i109);
                                    int i117 = ~i109;
                                    int i118 = ((i114 + (((i115 ^ i116) | (i115 & i116)) * (-301))) - (~(-(-(((~((i117 & iVD14832N6715) | (i117 ^ iVD14832N6715))) | (-34)) * 301))))) - 1;
                                    Object[] objArr15 = new Object[1];
                                    b(i98, true, i108, i118, "\r\u0010\u0002\f\uffff\u0010\u0003\u0005\uffff\f\uffff￫\u0003\u0005\uffff\t\u0001\uffff￮ￌ\u000b\u000eￌ\u0012\f\u0003\u0012\f\r\u0001ￌ\u0002\u0007", objArr15);
                                    Class<?> cls3 = Class.forName((String) objArr15[0]);
                                    Object[] objArr16 = new Object[1];
                                    a("汆㨃흙ᘦ\uebda\u2dcf\ue79c଼ᅭ깠\uf1da泡騃ᢛ", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), "\u0000\u0000\u0000\u0000", (char) (29871 - (~(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))), "駕滿놁詴", objArr16);
                                    Object objInvoke2 = cls3.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke, objArr14);
                                    int i119 = -(-View.combineMeasuredStates(0, 0));
                                    int i120 = (i119 & 2) + (i119 | 2);
                                    int i121 = -View.resolveSize(0, 0);
                                    int i122 = i121 * 758;
                                    int i123 = (i122 ^ (-127008)) + ((i122 & (-127008)) << 1) + ((i121 | i45) * (-757));
                                    int i124 = (~(((-169) ^ i121) | ((-169) & i121) | i)) * 1514;
                                    int i125 = ((i123 | i124) << 1) - (i124 ^ i123);
                                    int i126 = ~i121;
                                    int i127 = (i121 & 168) | (i121 ^ 168);
                                    int i128 = (i125 - (~(-(-(((~((i127 & i) | (i127 ^ i))) | ((~((-169) | i45)) | (~((i126 & (-169)) | (i126 ^ (-169)))))) * 757))))) - 1;
                                    int i129 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                    int i130 = i129 * (-830);
                                    int i131 = (i130 & 24128) + (i130 | 24128);
                                    int i132 = ~(((-30) & i45) | ((-30) ^ i45));
                                    int i133 = ~(i129 | 29 | i);
                                    int i134 = -(-(((i132 & i133) | (i132 ^ i133)) * (-831)));
                                    int i135 = (i131 & i134) + (i134 | i131);
                                    int i136 = ((-30) & i129) | ((-30) ^ i129);
                                    int i137 = i135 + ((~((i136 & i) | (i136 ^ i))) * (-1662));
                                    int i138 = ~i129;
                                    int i139 = ~((i138 & i25) | (i138 ^ i25));
                                    int i140 = ~((i129 & i) | (i129 ^ i));
                                    int i141 = (i140 & i139) | (i139 ^ i140);
                                    int i142 = ~(i | 29);
                                    int i143 = ((i141 & i142) | (i141 ^ i142)) * 831;
                                    int i144 = ((i137 | i143) << 1) - (i143 ^ i137);
                                    Object[] objArr17 = new Object[1];
                                    b(i120, true, i128, i144, "\r\u0000\u000e\u0005\r￨\u0004\u0006\u0000\n\u0002\u0000\uffefￍ\f\u000fￍ\u0013\r\u0004\u0013\r\u000e\u0002ￍ\u0003\b\u000e\u0011\u0003", objArr17);
                                    Class<?> cls4 = Class.forName((String) objArr17[0]);
                                    int longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
                                    int i145 = -(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1));
                                    int iVD14832N6716 = qU20128.vD14832N6715();
                                    int i146 = ~i145;
                                    int i147 = ((i145 * (-159)) - 159) + (((i146 & 1) | (i146 ^ 1)) * WebmConstants.MkvEbmlElement.BLOCK_GROUP);
                                    int i148 = ~iVD14832N6716;
                                    int i149 = ((~((i148 & i145) | (i148 ^ i145))) | (~((i145 ^ 1) | (i145 & 1)))) * (-160);
                                    int i150 = ((i147 | i149) << 1) - (i147 ^ i149);
                                    int i151 = ~iVD14832N6716;
                                    int i152 = ~((i151 & (-2)) | ((-2) ^ i151));
                                    int i153 = ((i145 & i152) | (i145 ^ i152)) * WebmConstants.MkvEbmlElement.BLOCK_GROUP;
                                    Object[] objArr18 = new Object[1];
                                    a("\ue686䲒\ue927䟸䤀㩔쑕⩥✘ᅪ", longPressTimeout, "\u0000\u0000\u0000\u0000", (char) ((i150 ^ i153) + ((i153 & i150) << 1)), "눎\ueca1㉔\uf349", objArr18);
                                    Object[] objArr19 = (Object[]) cls4.getField((String) objArr18[0]).get(objInvoke2);
                                    int length = objArr19.length;
                                    int i154 = 0;
                                    while (i154 < length) {
                                        Object obj = objArr19[i154];
                                        float f2 = f;
                                        Object[] objArr20 = new Object[i3];
                                        a("訞䥧㡹㤻唓", 1242695520 - (TypedValue.complexToFraction(0, f2, f2) > f2 ? 1 : (TypedValue.complexToFraction(0, f2, f2) == f2 ? 0 : -1)), "\u0000\u0000\u0000\u0000", (char) (4372 - (~ImageFormat.getBitsPerPixel(0))), "惠ሇᑊ琑", objArr20);
                                        try {
                                            Object[] objArr21 = {(String) objArr20[0]};
                                            int i155 = -(-(ViewConfiguration.getTouchSlop() >> 8));
                                            int iLastIndexOf = TextUtils.lastIndexOf(str, c2, 0, 0);
                                            Object[] objArr22 = new Object[i3];
                                            a("\uf83d\uffd0ꆡ爫羢怿\u0bdf캎ﶔ鞍絬싌ԑ⧎\ud804ﳬꜞꘂꛀ鏆獮々\ud9d5醺堨\u0cf9ꍛ䲛\udbc9ꏷ铢\uf62a躦᭔忖悒洕", (i155 ^ (-1637422518)) + ((i155 & (-1637422518)) << i3), "\u0000\u0000\u0000\u0000", (char) ((iLastIndexOf ^ 1) + ((iLastIndexOf & 1) << i3)), "䩌曪ƞ\ue3d6", objArr22);
                                            Class<?> cls5 = Class.forName((String) objArr22[0]);
                                            f = 0.0f;
                                            int i156 = -(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                                            int i157 = (i156 * (-559)) - 1723132996;
                                            int i158 = -(-((~((i25 ^ i156) | (i25 & i156))) * (-560)));
                                            int i159 = ((i157 | i158) << 1) - (i157 ^ i158);
                                            int i160 = ((-969229437) & i156) | ((-969229437) ^ i156);
                                            int i161 = i159 + ((~((i160 & i) | (i160 ^ i))) * (-560));
                                            int i162 = ~i156;
                                            Object[] objArr23 = new Object[i3];
                                            a("凾邠\uf01c奛灳鴮拹⎜蓃앜\uef69", (i161 - (~(((~((i162 & 969229436) | (i162 ^ 969229436))) | (~((969229436 & i25) | (i25 ^ 969229436)))) * 560))) - 1, "\u0000\u0000\u0000\u0000", (char) ((Process.getThreadPriority(0) + 20) >> 6), "糀아㼹ᇑ", objArr23);
                                            Object objInvoke3 = cls5.getMethod((String) objArr23[0], String.class).invoke(null, objArr21);
                                            try {
                                                int i163 = -(ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                                                int iVD14832N6717 = qU20128.vD14832N6715();
                                                int i164 = i163 * 302;
                                                int i165 = (i164 & 3015) + (i164 | 3015);
                                                int i166 = ~i163;
                                                Object[] objArr24 = objArr19;
                                                int i167 = ~iVD14832N6717;
                                                int i168 = ~((i166 ^ i167) | (i167 & i166));
                                                int i169 = -(-(((i168 ^ 5) | (i168 & 5)) * (-602)));
                                                int i170 = (i165 & i169) + (i169 | i165);
                                                int i171 = ~(i166 | (-6));
                                                int i172 = ~((i166 ^ iVD14832N6717) | (i166 & iVD14832N6717));
                                                int i173 = (i171 & i172) | (i171 ^ i172);
                                                int i174 = ~iVD14832N6717;
                                                int i175 = (i163 & i174) | (i174 ^ i163);
                                                int i176 = i170 + ((i173 | (~((i175 & 5) | (i175 ^ 5)))) * (-301));
                                                int i177 = -(-((~((i174 ^ 5) | (i174 & 5))) * 301));
                                                Object[] objArr25 = new Object[1];
                                                b((i176 & i177) + (i176 | i177), true, 169 - (~(-TextUtils.indexOf((CharSequence) str, '0'))), (ViewConfiguration.getFadingEdgeLength() >> 16) + 28, "\u000e\u0000\n�\u0001\u000e\u0011\u0010�\n\u0003\u0005\uffefￊ\t\fￊ\u0010\n\u0001\u0010\n\u000b\uffffￊ\u0000\u0005\u000b", objArr25);
                                                Class<?> cls6 = Class.forName((String) objArr25[0]);
                                                int i178 = -TextUtils.lastIndexOf(str, '0', 0);
                                                int i179 = (i178 ^ 3) + ((i178 & 3) << 1);
                                                int i180 = -View.resolveSizeAndState(0, 0, 0);
                                                Object[] objArr26 = new Object[1];
                                                b(i179, false, (i180 & WebmConstants.MkvEbmlElement.TRACK_ENTRY) + (i180 | WebmConstants.MkvEbmlElement.TRACK_ENTRY), 9 - (~(-MotionEvent.axisFromString(str))), "\u000b\u000b\ufffa\u0012\r\bￛ\u0012\r\ufffeￚ", objArr26);
                                                try {
                                                    Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr26[0], null).invoke(obj, null))};
                                                    Object[] objArr28 = new Object[1];
                                                    a("\uf83d\uffd0ꆡ爫羢怿\u0bdf캎ﶔ鞍絬싌ԑ⧎\ud804ﳬꜞꘂꛀ鏆獮々\ud9d5醺堨\u0cf9ꍛ䲛\udbc9ꏷ铢\uf62a躦᭔忖悒洕", (-1637422519) - (~(-(-TextUtils.indexOf(str, str, 0)))), "\u0000\u0000\u0000\u0000", (char) View.getDefaultSize(0, 0), "䩌曪ƞ\ue3d6", objArr28);
                                                    Class<?> cls7 = Class.forName((String) objArr28[0]);
                                                    int i181 = -Color.red(0);
                                                    int i182 = i181 * (-661);
                                                    int i183 = (i182 ^ (-1511022438)) + ((i182 & (-1511022438)) << 1);
                                                    int i184 = ~i181;
                                                    int i185 = ~((i184 ^ 1420706225) | (1420706225 & i184));
                                                    int i186 = i183 + (((i45 ^ i185) | (i185 & i45)) * 1324);
                                                    int i187 = ~((i181 ^ i) | (i181 & i));
                                                    int i188 = ~((i ^ (-1420706226)) | (i & (-1420706226)));
                                                    int i189 = (i186 - (~(((i187 ^ i188) | (i188 & i187)) * (-1324)))) - 1;
                                                    int i190 = ~((i184 ^ (-1420706226)) | (i184 & (-1420706226)));
                                                    int i191 = ~((i181 & 1420706225) | (1420706225 ^ i181));
                                                    int i192 = (i189 - (~(-(-(((i191 & i190) | (i190 ^ i191)) * 662))))) - 1;
                                                    int i193 = -(ViewConfiguration.getMaximumDrawingCacheSize() >> 24);
                                                    Object[] objArr29 = new Object[1];
                                                    a("讔᩷\uee60ꖀ⾲篇뙼宦麹疐鿌\uee25\uaafd֯櫐躄ᬈ勤ꊴ", i192, "\u0000\u0000\u0000\u0000", (char) (((i193 | 26256) << 1) - (i193 ^ 26256)), "亀冾邫穦", objArr29);
                                                    Object objInvoke4 = cls7.getMethod((String) objArr29[0], InputStream.class).invoke(objInvoke3, objArr27);
                                                    int length2 = objArr3.length;
                                                    int i194 = 0;
                                                    while (i194 < 2) {
                                                        Object obj2 = objArr3[i194];
                                                        try {
                                                            int i195 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                            int i196 = ((i195 | 1) << 1) - (i195 ^ 1);
                                                            int fadingEdgeLength2 = ViewConfiguration.getFadingEdgeLength() >> 16;
                                                            int i197 = ~fadingEdgeLength2;
                                                            int i198 = ~((i197 ^ i45) | (i197 & i45));
                                                            int i199 = ((-167) ^ i) | ((-167) & i);
                                                            String str2 = str;
                                                            int i200 = ~i199;
                                                            int i201 = ((fadingEdgeLength2 * (-574)) - 95284) + (((i198 ^ i200) | (i200 & i198)) * 1150);
                                                            int i202 = ~i199;
                                                            int i203 = ~((i25 ^ WebmConstants.MkvEbmlElement.BLOCK_MORE) | (i25 & WebmConstants.MkvEbmlElement.BLOCK_MORE));
                                                            int i204 = i201 + (((i202 & i203) | (i202 ^ i203)) * (-575));
                                                            int i205 = ~((i197 ^ i) | (i197 & i));
                                                            int i206 = ~(fadingEdgeLength2 | i45);
                                                            Object[] objArr30 = new Object[1];
                                                            b(i196, true, i204 + (((i205 & i206) | (i205 ^ i206)) * 575), 33 - (~(CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), "\u000b\u0006\u0015\u0002\u0004\n\u0007\n\u0015\u0013\u0006￤ￚ\uffd1ￖ\ufff9ￏ\u0015\u0013\u0006\u0004ￏ\u001a\u0015\n\u0013\u0016\u0004\u0006\u0014ￏ\u0002\u0017\u0002", objArr30);
                                                            Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                            Object[] objArr31 = new Object[1];
                                                            a("궻犛᧹쎆ጵ㷶\uea57\ud91a\udb0a\u0fe2\ue524℉譻\uda17囱ꦮ⇓ꀫ濁礈♥ⴳ뛷", (-665195783) - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), "\u0000\u0000\u0000\u0000", (char) ExpandableListView.getPackedPositionGroup(0L), "\uf89a姪⻘툷", objArr31);
                                                            if (obj2.equals(cls8.getMethod((String) objArr31[0], null).invoke(objInvoke4, null))) {
                                                                Object[] objArr32 = {new int[]{i}, null, new int[]{i ^ 1}, new int[]{(i | i) & (~(i & i))}};
                                                                int i207 = 652249440 + (((~((-33605009) | i)) | (~((-1640768005) | i25))) * 497) + (((~((-237032922) | i25)) | 203427913 | (~((-1640768005) | i))) * 497);
                                                                int i208 = -(-(i207 * (-493)));
                                                                int i209 = ((7920 | i208) << 1) - (i208 ^ 7920);
                                                                int i210 = ~i207;
                                                                int i211 = (i209 - (~(-(-(((i210 & 16) | (i210 ^ 16)) * (-988)))))) - 1;
                                                                int i212 = (i207 ^ (-17)) | (i207 & (-17));
                                                                int i213 = i211 + (((i212 & i25) | (i212 ^ i25)) * 494);
                                                                int i214 = ~i207;
                                                                int i215 = ~((i214 & (-17)) | ((-17) ^ i214));
                                                                int i216 = ~((i25 ^ i207) | (i25 & i207));
                                                                int i217 = (i215 & i216) | (i215 ^ i216);
                                                                int i218 = ~(i207 | 16);
                                                                int i219 = (i2 - (~(i213 + (((i217 & i218) | (i217 ^ i218)) * 494)))) - 1;
                                                                int i220 = i219 << 13;
                                                                int i221 = ((~i219) & i220) | ((~i220) & i219);
                                                                int i222 = i221 >>> 17;
                                                                int i223 = ((~i221) & i222) | ((~i222) & i221);
                                                                int i224 = i223 << 5;
                                                                return objArr32;
                                                            }
                                                            i194++;
                                                            str = str2;
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    i154 = (i154 ^ 1) + ((i154 & 1) << 1);
                                                    objArr19 = objArr24;
                                                    str = str;
                                                    i3 = 1;
                                                    c2 = '0';
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 != null) {
                                                        throw cause2;
                                                    }
                                                    throw th2;
                                                }
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
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 != null) {
                                        throw cause5;
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th6) {
                                Throwable cause6 = th6.getCause();
                                if (cause6 != null) {
                                    throw cause6;
                                }
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            Throwable cause7 = th7.getCause();
                            if (cause7 != null) {
                                throw cause7;
                            }
                            throw th7;
                        }
                    } catch (Throwable th8) {
                        Throwable cause8 = th8.getCause();
                        if (cause8 != null) {
                            throw cause8;
                        }
                        throw th8;
                    }
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 != null) {
                        throw cause9;
                    }
                    throw th9;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            c = 3;
        }
        Object[] objArr33 = new Object[4];
        objArr33[0] = new int[]{i};
        objArr33[2] = new int[]{i};
        objArr33[c] = new int[1];
        objArr33[1] = null;
        int iFreeMemory = (int) Runtime.getRuntime().freeMemory();
        int i225 = ~iFreeMemory;
        int i226 = 1724602732 + (((~((-1480186456) | i225)) | (~(1505491799 | iFreeMemory))) * (-831)) + ((~((-1074272322) | iFreeMemory)) * (-1662)) + (((~(iFreeMemory | 1480186455)) | (~(i225 | (-431219479))) | (~(431219478 | iFreeMemory))) * 831);
        int i227 = -(-(i226 * (-49)));
        int i228 = (i227 << 1) - i227;
        int i229 = -(-(i * (-50)));
        int i230 = (i228 ^ i229) + ((i229 & i228) << 1);
        int i231 = ~i226;
        int i232 = ((-1) ^ i231) | i231;
        int i233 = ~((i232 & i) | (i232 ^ i));
        int i234 = ~i226;
        int i235 = ~i;
        int i236 = ~((i234 & i235) | (i234 ^ i235));
        int i237 = -(-(((i233 & i236) | (i233 ^ i236)) * 50));
        int i238 = (i230 ^ i237) + ((i237 & i230) << 1);
        int i239 = ~((i231 ^ i235) | (i231 & i235));
        int i240 = ~i231;
        int i241 = (i240 & i239) | (i239 ^ i240);
        int i242 = ~i235;
        int i243 = ((i241 & i242) | (i241 ^ i242)) * 50;
        int i244 = ((i238 | i243) << 1) - (i243 ^ i238);
        int i245 = (i244 * (-813)) + (i2 * 408);
        int i246 = ~i2;
        int i247 = ~((i246 & i244) | (i246 ^ i244));
        int i248 = ~((i244 ^ i) | (i244 & i));
        int i249 = -(-(((i247 & i248) | (i247 ^ i248)) * (-814)));
        int i250 = (i245 & i249) + (i245 | i249);
        int i251 = ~i2;
        int i252 = ~i;
        int i253 = ~((i251 & i252) | (i251 ^ i252));
        int i254 = ~((~i244) | i2);
        int i255 = (i253 & i254) | (i253 ^ i254);
        int i256 = ((i255 & i248) | (i255 ^ i248)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE;
        int i257 = ((i250 | i256) << 1) - (i256 ^ i250);
        int i258 = ~i244;
        int i259 = ~((i258 ^ i2) | (i258 & i2));
        int i260 = ~((i258 & i) | (i258 ^ i));
        int i261 = (i260 & i259) | (i259 ^ i260);
        int i262 = ~((i & i2) | (i2 ^ i));
        int i263 = ((i262 & i261) | (i261 ^ i262)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE;
        int i264 = ((i257 | i263) << 1) - (i263 ^ i257);
        int i265 = i264 << 13;
        int i266 = (i265 | i264) & (~(i264 & i265));
        int i267 = i266 >>> 17;
        int i268 = ((~i266) & i267) | ((~i267) & i266);
        int i269 = i268 << 5;
        ((int[]) objArr33[c])[0] = ((~i268) & i269) | ((~i269) & i268);
        return objArr33;
    }
}
