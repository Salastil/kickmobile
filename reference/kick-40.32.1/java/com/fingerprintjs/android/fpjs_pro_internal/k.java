package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.PlaybackException;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.facebook.common.callercontext.ContextChain;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class k extends f<List<? extends tM9319B53>> {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static int[] D8871;
    private static int N14263A23323;
    private static int component5;
    private static char setPivotYN16904;
    private static int setTopP6481;
    private static long vD14832N6715;
    private final List<tM9319B53> component9;

    /* JADX WARN: Code duplicated, block: B:10:0x0023  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0023
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(short r6, short r7, int r8) {
        /*
            int r8 = r8 + 68
            int r6 = r6 * 2
            int r0 = 1 - r6
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.k.$$a
            int r7 = r7 * 4
            int r7 = r7 + 4
            byte[] r0 = new byte[r0]
            r2 = 0
            int r6 = 0 - r6
            if (r1 != 0) goto L17
            r4 = r8
            r3 = r2
            r8 = r7
            goto L2a
        L17:
            r3 = r2
        L18:
            byte r4 = (byte) r8
            r0[r3] = r4
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L23:
            int r3 = r3 + 1
            r4 = r1[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2a:
            int r7 = r7 + r4
            int r8 = r8 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.k.$$c(short, short, int):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{101, Ascii.SO, 96, -49};
        $$b = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.f
    public final /* synthetic */ List<? extends tM9319B53> setPivotYN16904() {
        int i = 2 % 2;
        int i2 = setTopP6481 + 29;
        N14263A23323 = i2 % 128;
        int i3 = i2 % 2;
        List<tM9319B53> listComponent5 = component5();
        if (i3 == 0) {
            int i4 = 96 / 0;
        }
        return listComponent5;
    }

    private List<tM9319B53> component5() {
        int i = 2 % 2;
        int i2 = N14263A23323;
        int i3 = i2 + 47;
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        List<tM9319B53> list = this.component9;
        if (i4 != 0) {
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        int i5 = (i2 ^ 13) + ((i2 & 13) << 1);
        setTopP6481 = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 84 / 0;
        }
        return list;
    }

    public k(List<tM9319B53> list) {
        super(null);
        this.component9 = list;
    }

    private static void b(int i, String str, String str2, char c, String str3, Object[] objArr) throws Throwable {
        char[] charArray;
        char[] charArray2;
        int i2 = 2;
        int i3 = 2 % 2;
        boolean z = true;
        if (str3 != null) {
            int i4 = $10 + 21;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            charArray = str3.toCharArray();
            int i6 = $11 + 1;
            $10 = i6 % 128;
            int i7 = i6 % 2;
        } else {
            charArray = str3;
        }
        char[] cArr = charArray;
        Object obj = null;
        if (str2 != null) {
            int i8 = $11 + 47;
            $10 = i8 % 128;
            if (i8 % 2 != 0) {
                str2.toCharArray();
                obj.hashCode();
                throw null;
            }
            charArray2 = str2.toCharArray();
        } else {
            charArray2 = str2;
        }
        char[] cArr2 = charArray2;
        char[] charArray3 = str != null ? str.toCharArray() : str;
        cn cnVar = new cn();
        int length = cArr2.length;
        char[] cArr3 = new char[length];
        int length2 = charArray3.length;
        char[] cArr4 = new char[length2];
        short s = 0;
        System.arraycopy(cArr2, 0, cArr3, 0, length);
        System.arraycopy(charArray3, 0, cArr4, 0, length2);
        cArr3[0] = (char) (cArr3[0] ^ c);
        cArr4[2] = (char) (cArr4[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr5 = new char[length3];
        cnVar.setPivotYN16904 = 0;
        while (cnVar.setPivotYN16904 < length3) {
            int i9 = $11 + 111;
            $10 = i9 % 128;
            int i10 = i9 % i2;
            try {
                Object[] objArr2 = {cnVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(528238139);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(86 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (TextUtils.indexOf("", "", s, s) + 55624), 422 - ExpandableListView.getPackedPositionChild(0L), 1305018968, false, "c", new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objComponent5).invoke(obj, objArr2)).intValue();
                Object[] objArr3 = {cnVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1013236775);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(((byte) KeyEvent.getModifierMetaStateMask()) + 53, (char) (TextUtils.indexOf("", "", s) + 55223), ExpandableListView.getPackedPositionGroup(0L) + 3269, -1859223622, false, $$c(s, s, 35), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objComponent6).invoke(obj, objArr3)).intValue();
                int i11 = cArr3[cnVar.setPivotYN16904 % 4] * 32718;
                Object[] objArr4 = new Object[3];
                objArr4[i2] = Integer.valueOf(cArr4[iIntValue]);
                objArr4[z] = Integer.valueOf(i11);
                objArr4[s] = cnVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-523427508);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 52, (char) (View.combineMeasuredStates(s, s) + 42043), 2307 - ((byte) KeyEvent.getModifierMetaStateMask()), -1300732625, false, ContextChain.TAG_INFRA, new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                int i12 = cArr3[iIntValue2] * 32718;
                Object[] objArr5 = new Object[2];
                objArr5[z] = Integer.valueOf(cArr4[iIntValue]);
                objArr5[s] = Integer.valueOf(i12);
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1175171274);
                if (objComponent8 == null) {
                    short s2 = s;
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.lastIndexOf("", '0', s2) + 53, (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 58885), ImageFormat.getBitsPerPixel(s2) + 6887, 348058793, false, $$c(s2, s2, 34), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr4[iIntValue2] = ((Character) ((Method) objComponent8).invoke(null, objArr5)).charValue();
                cArr3[iIntValue2] = cnVar.D8871;
                cArr5[cnVar.setPivotYN16904] = (char) (((((long) (cArr3[iIntValue2] ^ cArr[cnVar.setPivotYN16904])) ^ (vD14832N6715 ^ (-8233799196330309486L))) ^ ((long) ((int) (((long) component5) ^ (-8233799196330309486L))))) ^ ((long) ((char) (((long) setPivotYN16904) ^ (-8233799196330309486L)))));
                cnVar.setPivotYN16904++;
                i2 = 2;
                s = 0;
                obj = null;
                z = z;
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

    private static void a(int[] iArr, int i, Object[] objArr) throws Throwable {
        int i2;
        int i3 = 2;
        int i4 = 2 % 2;
        ci ciVar = new ci();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = D8871;
        int i5 = 1299132072;
        int i6 = 16;
        if (iArr2 != null) {
            int i7 = $11 + 7;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i9 = 0;
            while (i9 < length) {
                try {
                    Object[] objArr2 = {Integer.valueOf(iArr2[i9])};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(i5);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 52, (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 40761), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 6421, 534407883, false, $$c((short) 0, (short) 0, 54), new Class[]{Integer.TYPE});
                    }
                    iArr3[i9] = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                    i9++;
                    i5 = i5;
                    i3 = i3;
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
        int i10 = i3;
        int i11 = i5;
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = D8871;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i12 = 0;
            while (i12 < length3) {
                Object[] objArr3 = {Integer.valueOf(iArr5[i12])};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i11);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.indexOf("", "", 0, 0), (char) (TextUtils.lastIndexOf("", '0') + 40762), 6420 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 534407883, false, $$c((short) 0, (short) 0, 54), new Class[]{Integer.TYPE});
                }
                iArr6[i12] = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                i12++;
                i6 = i6;
            }
            i2 = i6;
            int i13 = $11 + 69;
            $10 = i13 % 128;
            int i14 = i13 % 2;
            iArr5 = iArr6;
        } else {
            i2 = 16;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        ciVar.component5 = 0;
        while (ciVar.component5 < iArr.length) {
            int i15 = $10 + 85;
            $11 = i15 % 128;
            int i16 = i15 % 2;
            cArr[0] = (char) (iArr[ciVar.component5] >> 16);
            byte b = 1;
            cArr[1] = (char) iArr[ciVar.component5];
            cArr[i10] = (char) (iArr[ciVar.component5 + 1] >> 16);
            char c = 3;
            cArr[3] = (char) iArr[ciVar.component5 + 1];
            ciVar.vD14832N6715 = (cArr[0] << 16) + cArr[1];
            ciVar.setPivotYN16904 = (cArr[i10] << 16) + cArr[3];
            ci.setPivotYN16904(iArr4);
            int i17 = 0;
            for (int i18 = i2; i17 < i18; i18 = 16) {
                int i19 = $10 + 71;
                $11 = i19 % 128;
                if (i19 % 2 == 0) {
                    ciVar.vD14832N6715 ^= iArr4[i17];
                    int iD8871 = ci.D8871(ciVar.vD14832N6715);
                    Object[] objArr4 = new Object[4];
                    objArr4[c] = ciVar;
                    objArr4[i10] = ciVar;
                    objArr4[b] = Integer.valueOf(iD8871);
                    objArr4[0] = ciVar;
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(63485357);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(87 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + b), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 250, 1367208398, false, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue = ((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue();
                    ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                    ciVar.setPivotYN16904 = iIntValue;
                    i17 += 124;
                    b = b;
                } else {
                    byte b2 = b;
                    ciVar.vD14832N6715 ^= iArr4[i17];
                    int iD8872 = ci.D8871(ciVar.vD14832N6715);
                    Object[] objArr5 = new Object[4];
                    objArr5[c] = ciVar;
                    objArr5[i10] = ciVar;
                    objArr5[b2] = Integer.valueOf(iD8872);
                    objArr5[0] = ciVar;
                    Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(63485357);
                    if (objComponent8 == null) {
                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(86 - TextUtils.getCapsMode("", 0, 0), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), KeyEvent.normalizeMetaState(0) + 250, 1367208398, false, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                    }
                    int iIntValue2 = ((Integer) ((Method) objComponent8).invoke(null, objArr5)).intValue();
                    ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                    ciVar.setPivotYN16904 = iIntValue2;
                    i17++;
                    b = b2;
                    c = c;
                }
            }
            byte b3 = b;
            char c2 = c;
            int i20 = ciVar.vD14832N6715;
            ciVar.vD14832N6715 = ciVar.setPivotYN16904;
            ciVar.setPivotYN16904 = i20;
            ciVar.setPivotYN16904 ^= iArr4[16];
            ciVar.vD14832N6715 ^= iArr4[17];
            int i21 = ciVar.vD14832N6715;
            int i22 = ciVar.setPivotYN16904;
            cArr[0] = (char) (ciVar.vD14832N6715 >>> 16);
            cArr[b3] = (char) ciVar.vD14832N6715;
            cArr[i10] = (char) (ciVar.setPivotYN16904 >>> 16);
            cArr[c2] = (char) ciVar.setPivotYN16904;
            ci.setPivotYN16904(iArr4);
            cArr2[ciVar.component5 * 2] = cArr[0];
            cArr2[(ciVar.component5 * 2) + 1] = cArr[b3];
            cArr2[(ciVar.component5 * 2) + 2] = cArr[i10];
            cArr2[(ciVar.component5 * 2) + 3] = cArr[c2];
            int i23 = i10;
            Object[] objArr6 = new Object[i23];
            objArr6[b3] = ciVar;
            objArr6[0] = ciVar;
            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(743063861);
            if (objComponent9 == null) {
                i2 = 16;
                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - Process.getGidForName(""), (char) (ViewConfiguration.getEdgeSlop() >> 16), Color.red(0) + 3579, 2130642262, false, $$c((short) 0, (short) 0, 0), new Class[]{Object.class, Object.class});
            } else {
                i2 = 16;
            }
            ((Method) objComponent9).invoke(null, objArr6);
            i10 = i23;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    static {
        init$0();
        $10 = 0;
        $11 = 1;
        setTopP6481 = 0;
        N14263A23323 = 1;
        D8871 = new int[]{1075970249, -407371499, -820232058, 5693249, -52699132, 1491073622, -1167245789, -1359032292, 526675439, -1776951766, -597414929, 1938049282, 1862470670, 1531793500, -941952927, 1305535098, -1742759748, -1205803653};
        vD14832N6715 = 7426102746147722750L;
        component5 = 1725286546;
        setPivotYN16904 = (char) 51346;
    }

    public static Object[] setPivotYN16904(Context context, int i, int i2) {
        char c;
        String str = "";
        int i3 = 1;
        if (context == null) {
            Object[] objArr = {new int[]{i}, null, new int[]{i}, new int[1]};
            int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
            int i4 = 1509188576 + (((~(iElapsedRealtime | 1349939600)) | (-561466334)) * (-465)) + ((1349939600 | (~((-561466334) | iElapsedRealtime))) * 930) + ((iElapsedRealtime | (-553716302)) * 465);
            int iComponent9 = getYJ21310.component9();
            int i5 = -(-(i4 * (-67)));
            int i6 = ~i4;
            int i7 = i6 | ((-1) ^ i6);
            int i8 = ~iComponent9;
            int i9 = ~((i7 & i8) | (i7 ^ i8));
            int i10 = ~i4;
            int i11 = (i9 & i10) | (i9 ^ i10);
            int i12 = ~((i4 ^ iComponent9) | (i4 & iComponent9));
            int i13 = -(-(((i11 & i12) | (i11 ^ i12)) * (-68)));
            int i14 = ~iComponent9;
            int i15 = (((i5 ^ i13) + ((i5 & i13) << 1)) - (~(-(-((~(((-1) ^ i4) | i4)) * (-68)))))) - 1;
            int i16 = ~i4;
            int i17 = ~((i14 & i16) | (i16 ^ i14));
            int i18 = i2 + i15 + ((i17 | ((-1) ^ i17)) * 68);
            int i19 = i18 << 13;
            int i20 = ((~i18) & i19) | ((~i19) & i18);
            int i21 = i20 ^ (i20 >>> 17);
            int i22 = i21 << 5;
            ((int[]) objArr[3])[0] = (i21 | i22) & (~(i21 & i22));
            return objArr;
        }
        int i23 = 20;
        try {
            int iRed = Color.red(0);
            int iComponent10 = getYJ21310.component9();
            int i24 = (iRed * 765) - 58026;
            int i25 = ~iComponent10;
            int i26 = (i25 & iRed) | (i25 ^ iRed);
            int i27 = ((~i26) | 38) * 764;
            int i28 = (i24 & i27) + (i24 | i27);
            int i29 = ~iRed;
            int i30 = ~((i29 & 38) | (i29 ^ 38));
            int i31 = ~iComponent10;
            int i32 = ~((i31 & 38) | (i31 ^ 38));
            int i33 = ((i32 & i30) | (i30 ^ i32)) * (-1528);
            int i34 = (i28 ^ i33) + ((i28 & i33) << 1);
            int i35 = ~(((-39) ^ iRed) | (iRed & (-39)));
            int i36 = (i35 & i30) | (i30 ^ i35);
            int i37 = ~i26;
            int i38 = (i34 - (~(-(-(((i36 & i37) | (i36 ^ i37)) * 764))))) - 1;
            Object[] objArr2 = new Object[1];
            a(new int[]{-627877696, -1026297093, -1419789573, 1968984476, -2132190617, -304005015, 1991282390, -1543999506, -926709674, 1815333190, -1958058294, 1242591535, -2070169665, 1215208681, -1141307530, -585489246, -1699178820, -1867633570, 307457314, -300794696}, i38, objArr2);
            Object[] objArr3 = (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 2);
            int mode = View.MeasureSpec.getMode(0);
            int i39 = (mode ^ 31) + ((mode & 31) << 1);
            Object[] objArr4 = new Object[1];
            a(new int[]{1249628014, 606736963, -801136290, 414033470, -1863272085, 1868210433, 747520646, -667924807, -2074896827, 955005734, -801136290, 414033470, -365048717, 834160546, 1068300072, -1208766982}, i39, objArr4);
            try {
                try {
                    Object[] objArr5 = {(String) objArr4[0]};
                    Object[] objArr6 = new Object[1];
                    a(new int[]{-627877696, -1026297093, -1419789573, 1968984476, -2132190617, -304005015, 1991282390, -1543999506, -926709674, 1815333190, -1958058294, 1242591535, -2070169665, 1215208681, -1141307530, -585489246, -1699178820, -1867633570, 307457314, -300794696}, Color.argb(0, 0, 0, 0) + 38, objArr6);
                    objArr3[0] = Class.forName((String) objArr6[0]).getDeclaredConstructor(String.class).newInstance(objArr5);
                    int i40 = -TextUtils.indexOf((CharSequence) "", '0', 0);
                    int i41 = i40 * 615;
                    int i42 = ((i41 | 1533175769) << 1) - (i41 ^ 1533175769);
                    int i43 = ~i40;
                    c = 3;
                    int i44 = (i43 ^ (-1011433061)) | (i43 & (-1011433061));
                    int i45 = ~i44;
                    int i46 = (i ^ i45) | (i45 & i);
                    int i47 = ~((1011433060 ^ i40) | (1011433060 & i40));
                    int i48 = ((i46 ^ i47) | (i47 & i46)) * 614;
                    int i49 = (i42 & i48) + (i48 | i42);
                    int i50 = ~i;
                    int i51 = -(-(((~i44) | (~((i43 ^ i50) | (i43 & i50))) | (~((i50 ^ (-1011433061)) | (i50 & (-1011433061))))) * (-1228)));
                    int i52 = ((i49 | i51) << 1) - (i51 ^ i49);
                    int i53 = 1011433060 | i43;
                    int i54 = ~i;
                    int i55 = ~((i53 & i54) | (i53 ^ i54));
                    int i56 = i40 | i54;
                    int i57 = ~((i56 & (-1011433061)) | (i56 ^ (-1011433061)));
                    int i58 = i52 + (((i55 & i57) | (i55 ^ i57)) * 614);
                    int i59 = -(ViewConfiguration.getScrollDefaultDelay() >> 16);
                    int iComponent11 = getYJ21310.component9();
                    int i60 = (i59 * (-317)) - (-5037648);
                    int i61 = ~i59;
                    int i62 = (i61 ^ (-15793)) | (i61 & (-15793));
                    int i63 = ~((i62 & iComponent11) | (i62 ^ iComponent11));
                    int i64 = ~iComponent11;
                    int i65 = -(-((i63 | (~((i64 ^ i59) | (i64 & i59) | 15792))) * (-318)));
                    int i66 = ((i60 | i65) << 1) - (i65 ^ i60);
                    int i67 = ~(((-15793) ^ i59) | ((-15793) & i59));
                    int i68 = ~(i59 | iComponent11);
                    int i69 = ((i67 ^ i68) | (i67 & i68)) * (-318);
                    int i70 = (i66 ^ i69) + ((i69 & i66) << 1);
                    int i71 = ~i59;
                    int i72 = ~((i71 & iComponent11) | (i71 ^ iComponent11));
                    int i73 = ((i72 & (-15793)) | ((-15793) ^ i72)) * TypedValues.Attributes.TYPE_PIVOT_TARGET;
                    Object[] objArr7 = new Object[1];
                    b(i58, "\udd6c彥穛\ueab5", "鱣뛁냃ᬽ", (char) ((i70 & i73) + (i73 | i70)), "겤\uea75翊㯹現\uebb0ꅀ婖뢽ӓ뗂챭纥ㄥ킻䷥ó샴ꮓ翤퇔ꗷ刷掾괦袍ا䮊靘腩䵕", objArr7);
                    try {
                        Object[] objArr8 = {(String) objArr7[0]};
                        int i74 = -(AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1));
                        int i75 = (i74 * 302) + 22914;
                        int i76 = ~i74;
                        int i77 = ~((i76 ^ i50) | (i76 & i50));
                        int i78 = -(-(((i77 ^ 38) | (i77 & 38)) * (-602)));
                        int i79 = (i75 & i78) + (i78 | i75);
                        int i80 = ~((i76 ^ (-39)) | (i76 & (-39)));
                        int i81 = ~i74;
                        int i82 = ~((i81 & i) | (i81 ^ i));
                        int i83 = (i80 & i82) | (i80 ^ i82);
                        int i84 = (i74 & i50) | (i50 ^ i74);
                        int i85 = ~((i84 & 38) | (i84 ^ 38));
                        int i86 = -(-(((i85 & i83) | (i83 ^ i85)) * (-301)));
                        int i87 = ((i79 | i86) << 1) - (i79 ^ i86);
                        int i88 = -(-((~((i54 ^ 38) | (i54 & 38))) * 301));
                        int i89 = (i87 ^ i88) + ((i88 & i87) << 1);
                        Object[] objArr9 = new Object[1];
                        a(new int[]{-627877696, -1026297093, -1419789573, 1968984476, -2132190617, -304005015, 1991282390, -1543999506, -926709674, 1815333190, -1958058294, 1242591535, -2070169665, 1215208681, -1141307530, -585489246, -1699178820, -1867633570, 307457314, -300794696}, i89, objArr9);
                        objArr3[1] = Class.forName((String) objArr9[0]).getDeclaredConstructor(String.class).newInstance(objArr8);
                        try {
                            int tapTimeout = ViewConfiguration.getTapTimeout() >> 16;
                            int iComponent12 = getYJ21310.component9();
                            int i90 = (tapTimeout * 628) - 1608168784;
                            int i91 = (iComponent12 ^ (-1500328036)) | (iComponent12 & (-1500328036));
                            int i92 = ~tapTimeout;
                            int i93 = ((i91 ^ i92) | (i91 & i92)) * (-627);
                            int i94 = (i90 ^ i93) + ((i90 & i93) << 1);
                            int i95 = ~((1500328035 & iComponent12) | (1500328035 ^ iComponent12));
                            int i96 = ((i95 & tapTimeout) | (tapTimeout ^ i95)) * (-627);
                            int i97 = ((i94 | i96) << 1) - (i96 ^ i94);
                            int i98 = ~iComponent12;
                            int i99 = ~((i98 & (-1500328036)) | (i98 ^ (-1500328036)));
                            int i100 = ~((tapTimeout & iComponent12) | (tapTimeout ^ iComponent12));
                            Object[] objArr10 = new Object[1];
                            b(i97 + (((i100 & i99) | (i99 ^ i100)) * 627), "\udd6c彥穛\ueab5", "鲱鋏㒦ꨁ", (char) Color.red(0), "ꂒ겾ﴟꏪ셚圻熉즈奆\uee17\ue2f3鳰\uf4f0맦蘏彼䎒⫬\ude4a⛗ഗ燇阈", objArr10);
                            Class<?> cls = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            a(new int[]{205646269, 1257333975, -1074063611, 1762276812, 379170838, -1855792908, -804724923, -1581215878, 1189647736, -903068899}, 17 - (~(-(SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)))), objArr11);
                            Object objInvoke = cls.getMethod((String) objArr11[0], null).invoke(context, null);
                            try {
                                Object[] objArr12 = new Object[1];
                                b((-1500328037) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), "\udd6c彥穛\ueab5", "鲱鋏㒦ꨁ", (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), "ꂒ겾ﴟꏪ셚圻熉즈奆\uee17\ue2f3鳰\uf4f0맦蘏彼䎒⫬\ude4a⛗ഗ燇阈", objArr12);
                                Class<?> cls2 = Class.forName((String) objArr12[0]);
                                int tapTimeout2 = ViewConfiguration.getTapTimeout() >> 16;
                                int i101 = -TextUtils.indexOf("", "");
                                Object[] objArr13 = new Object[1];
                                b(tapTimeout2, "\udd6c彥穛\ueab5", "큺켼켨덠", (char) ((i101 ^ 24783) + ((i101 & 24783) << 1)), "ሲ驂铌ࣴ썓\ufde7၅颥탓获䕁搿\u0df7튮", objArr13);
                                try {
                                    Object[] objArr14 = {cls2.getMethod((String) objArr13[0], null).invoke(context, null), 64};
                                    int i102 = -(Process.myPid() >> 22);
                                    Object[] objArr15 = new Object[1];
                                    b((i102 & 981744022) + (i102 | 981744022), "\udd6c彥穛\ueab5", "雞萹踺న", (char) View.MeasureSpec.makeMeasureSpec(0, 0), "嫪⧰៶Ꞡ㜅\ude90捼\uf840훸籁ӝ又㤞렲渵ཤ歬醈䵀쾕셓徙힂ᚿᐽ塦̿쀥얣걱䉗\uf6b7쇠", objArr15);
                                    Class<?> cls3 = Class.forName((String) objArr15[0]);
                                    int i103 = -(-(TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                                    int i104 = ((i103 | 14) << 1) - (i103 ^ 14);
                                    Object[] objArr16 = new Object[1];
                                    a(new int[]{205646269, 1257333975, -1074063611, 1762276812, 1080597116, 1350804934, 834742112, -1396254736}, i104, objArr16);
                                    Object objInvoke2 = cls3.getMethod((String) objArr16[0], String.class, Integer.TYPE).invoke(objInvoke, objArr14);
                                    int i105 = -(-Color.rgb(0, 0, 0));
                                    int i106 = (i105 ^ 16777246) + ((i105 & 16777246) << 1);
                                    Object[] objArr17 = new Object[1];
                                    a(new int[]{-648228374, 1687479159, -835026064, 906338386, -1734077453, 1232974437, 353009822, 2129867793, -1360870603, -1044828899, -1074063611, 1762276812, 1080597116, 1350804934, 834742112, -1396254736}, i106, objArr17);
                                    Class<?> cls4 = Class.forName((String) objArr17[0]);
                                    int iMyTid = Process.myTid() >> 22;
                                    int i107 = -Color.rgb(0, 0, 0);
                                    int iComponent13 = getYJ21310.component9();
                                    int i108 = i107 * 477;
                                    int i109 = (i108 & (-620756992)) + (i108 | (-620756992));
                                    int i110 = ~((~i107) | (-16777216));
                                    int i111 = (16777215 ^ i107) | (16777215 & i107);
                                    int i112 = ~((i111 ^ iComponent13) | (i111 & iComponent13));
                                    int i113 = ((i110 ^ i112) | (i110 & i112)) * (-476);
                                    int i114 = (i109 & i113) + (i113 | i109) + ((~((16777215 & i107) | (16777215 ^ i107) | iComponent13)) * 952);
                                    int i115 = ~iComponent13;
                                    int i116 = -(-((~(i107 | (i115 & ViewCompat.MEASURED_SIZE_MASK) | (16777215 ^ i115))) * 476));
                                    Object[] objArr18 = new Object[1];
                                    b(iMyTid, "\udd6c彥穛\ueab5", "\uf8dc䵺䉕1", (char) (((i114 | i116) << 1) - (i116 ^ i114)), "蚾\ud9f7\uf5ca㏸\uf15cᅼᇫ\udfb8ⳙ꠲", objArr18);
                                    Object[] objArr19 = (Object[]) cls4.getField((String) objArr18[0]).get(objInvoke2);
                                    int length = objArr19.length;
                                    int i117 = 0;
                                    while (i117 < length) {
                                        Object obj = objArr19[i117];
                                        Object[] objArr20 = new Object[i3];
                                        b((-1440472184) - (~(-(ViewConfiguration.getJumpTapTimeout() >> 16))), "\udd6c彥穛\ueab5", "觢␣Ⴊ䣬", (char) (TextUtils.indexOf((CharSequence) str, '0') + 60433), "㪱竞❛ჹ䋓", objArr20);
                                        try {
                                            Object[] objArr21 = {(String) objArr20[0]};
                                            int[] iArr = new int[i23];
                                            // fill-array-data instruction
                                            iArr[0] = -627877696;
                                            iArr[1] = -1026297093;
                                            iArr[2] = -1441416371;
                                            iArr[3] = 1423840550;
                                            iArr[4] = 1494130333;
                                            iArr[5] = 310955980;
                                            iArr[6] = 1726859813;
                                            iArr[7] = 1944392409;
                                            iArr[8] = 552189494;
                                            iArr[9] = 886962976;
                                            iArr[10] = -1828205749;
                                            iArr[11] = -377135722;
                                            iArr[12] = 714479942;
                                            iArr[13] = -932452882;
                                            iArr[14] = -1549343783;
                                            iArr[15] = 1479150933;
                                            iArr[16] = 931207296;
                                            iArr[17] = 1193353035;
                                            iArr[18] = -2078530963;
                                            iArr[19] = -1053162386;
                                            int i118 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                            int i119 = i23;
                                            int i120 = i118 * 758;
                                            int i121 = (i120 & (-27216)) + (i120 | (-27216));
                                            int i122 = ((i118 ^ i50) | (i118 & i50)) * (-757);
                                            int i123 = ((i121 | i122) << 1) - (i121 ^ i122);
                                            int i124 = ((-37) & i118) | ((-37) ^ i118);
                                            int i125 = -(-((~((i124 & i) | (i124 ^ i))) * 1514));
                                            int i126 = ((i123 | i125) << i3) - (i123 ^ i125);
                                            int i127 = ~((~i118) | (-37));
                                            int i128 = ~(((-37) ^ i50) | ((-37) & i50));
                                            int i129 = (i127 ^ i128) | (i127 & i128);
                                            int i130 = i118 | 36;
                                            int i131 = ~((i130 & i) | (i130 ^ i));
                                            int i132 = ((i129 & i131) | (i129 ^ i131)) * 757;
                                            int i133 = (i126 & i132) + (i132 | i126);
                                            Object[] objArr22 = new Object[1];
                                            a(iArr, i133, objArr22);
                                            Class<?> cls5 = Class.forName((String) objArr22[0]);
                                            int iIndexOf = TextUtils.indexOf(str, str) - 1289299066;
                                            int threadPriority = Process.getThreadPriority(0);
                                            int i134 = ~threadPriority;
                                            int i135 = ~(((-21) ^ i134) | (i134 & (-21)));
                                            int i136 = ~threadPriority;
                                            Object[] objArr23 = objArr19;
                                            int i137 = ~(i136 | i50);
                                            int i138 = (-3340) + (threadPriority * (-167)) + (((i135 ^ i137) | (i137 & i135)) * 168);
                                            int i139 = -(-((~(((-21) ^ i136) | ((-21) & i136) | i)) * 168));
                                            Object[] objArr24 = new Object[1];
                                            b(iIndexOf, "\udd6c彥穛\ueab5", "虅⛛銳﷿", (char) (((((i138 | i139) << 1) - (i139 ^ i138)) + ((((~(((-21) ^ i54) | ((-21) & i54))) | (~(threadPriority | (-21)))) | (~(((i136 ^ 20) | (i136 & 20)) | i))) * 168)) >> 6), "ɤꙧ롈艡뙢֟\u0cfe뉢辧䉶봃", objArr24);
                                            Object objInvoke3 = cls5.getMethod((String) objArr24[0], String.class).invoke(null, objArr21);
                                            try {
                                                int jumpTapTimeout = ViewConfiguration.getJumpTapTimeout() >> 16;
                                                int i140 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                Object[] objArr25 = new Object[1];
                                                b(jumpTapTimeout, "\udd6c彥穛\ueab5", "ٌ䷃잱\ufdee", (char) ((i140 ^ 61127) + ((i140 & 61127) << 1)), "\ude43⢀許帢㟜礊읖鰂핱脓滹뗓蹠樓랹斾鍸홯䯅퇨ﮖ因휝袿ꕅ䍘滀\ue3f3", objArr25);
                                                Class<?> cls6 = Class.forName((String) objArr25[0]);
                                                int packedPositionChild = ExpandableListView.getPackedPositionChild(0L);
                                                int i141 = packedPositionChild * 46;
                                                int i142 = ~((563024432 ^ i54) | (563024432 & i54));
                                                int i143 = ((((i141 | (-129320142)) << 1) - (i141 ^ (-129320142))) - (~(-(-(((packedPositionChild ^ i142) | (i142 & packedPositionChild)) * (-90)))))) - 1;
                                                int i144 = ((~(packedPositionChild | (-563024433))) | (~((563024432 ^ i) | (563024432 & i)))) * (-45);
                                                int i145 = (i143 & i144) + (i144 | i143);
                                                int i146 = ~((~packedPositionChild) | i);
                                                int i147 = (563024432 & i146) | (563024432 ^ i146);
                                                int i148 = ~((packedPositionChild & i50) | (i50 ^ packedPositionChild));
                                                int i149 = (i145 - (~(((i148 & i147) | (i147 ^ i148)) * 45))) - 1;
                                                int i150 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                                Object[] objArr26 = new Object[1];
                                                b(i149, "\udd6c彥穛\ueab5", "컑热㻞ퟛ", (char) (((i150 | 1) << 1) - (i150 ^ 1)), "㞏죘\ue269脔뢞旞ᶈꌄ\u2d29꾯✲", objArr26);
                                                try {
                                                    Object[] objArr27 = {new ByteArrayInputStream((byte[]) cls6.getMethod((String) objArr26[0], null).invoke(obj, null))};
                                                    int[] iArr2 = new int[i119];
                                                    // fill-array-data instruction
                                                    iArr2[0] = -627877696;
                                                    iArr2[1] = -1026297093;
                                                    iArr2[2] = -1441416371;
                                                    iArr2[3] = 1423840550;
                                                    iArr2[4] = 1494130333;
                                                    iArr2[5] = 310955980;
                                                    iArr2[6] = 1726859813;
                                                    iArr2[7] = 1944392409;
                                                    iArr2[8] = 552189494;
                                                    iArr2[9] = 886962976;
                                                    iArr2[10] = -1828205749;
                                                    iArr2[11] = -377135722;
                                                    iArr2[12] = 714479942;
                                                    iArr2[13] = -932452882;
                                                    iArr2[14] = -1549343783;
                                                    iArr2[15] = 1479150933;
                                                    iArr2[16] = 931207296;
                                                    iArr2[17] = 1193353035;
                                                    iArr2[18] = -2078530963;
                                                    iArr2[19] = -1053162386;
                                                    int edgeSlop = ViewConfiguration.getEdgeSlop() >> 16;
                                                    int iComponent14 = getYJ21310.component9();
                                                    int i151 = edgeSlop * (-523);
                                                    int i152 = ((i151 | 9731) << 1) - (i151 ^ 9731);
                                                    int i153 = ~edgeSlop;
                                                    int i154 = ~((i153 ^ 37) | (i153 & 37));
                                                    String str2 = str;
                                                    int i155 = ~(((-38) ^ edgeSlop) | ((-38) & edgeSlop));
                                                    int i156 = (i154 ^ i155) | (i155 & i154);
                                                    int i157 = ~(((-38) ^ iComponent14) | ((-38) & iComponent14));
                                                    int i158 = (((i152 - (~(-(-(((i156 ^ i157) | (i156 & i157)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED))))) - 1) - (~((~((-38) | edgeSlop)) * (-786)))) - 1;
                                                    int i159 = ~iComponent14;
                                                    int i160 = ~(((-38) & i159) | ((-38) ^ i159));
                                                    int i161 = ~(i153 | 37);
                                                    int i162 = (i160 & i161) | (i160 ^ i161);
                                                    int i163 = ~(((-38) ^ edgeSlop) | ((-38) & edgeSlop));
                                                    int i164 = ((i162 & i163) | (i162 ^ i163)) * GlobalMediaRouter.CallbackHandler.MSG_ROUTE_SELECTED;
                                                    int i165 = ((i158 | i164) << 1) - (i164 ^ i158);
                                                    Object[] objArr28 = new Object[1];
                                                    a(iArr2, i165, objArr28);
                                                    Class<?> cls7 = Class.forName((String) objArr28[0]);
                                                    int i166 = -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1));
                                                    int i167 = ((i166 | 18) << 1) - (i166 ^ 18);
                                                    Object[] objArr29 = new Object[1];
                                                    a(new int[]{1102786320, -1021139612, -1883619193, -1042436257, 1445006085, 194915129, -855375946, 131389547, -1671285438, 909182912}, i167, objArr29);
                                                    Object objInvoke4 = cls7.getMethod((String) objArr29[0], InputStream.class).invoke(objInvoke3, objArr27);
                                                    int length2 = objArr3.length;
                                                    for (int i168 = 0; i168 < 2; i168++) {
                                                        Object obj2 = objArr3[i168];
                                                        try {
                                                            int iAxisFromString = MotionEvent.axisFromString(str2);
                                                            int iComponent15 = getYJ21310.component9();
                                                            int i169 = iAxisFromString * 960;
                                                            int i170 = (i169 & (-1917)) + (i169 | (-1917));
                                                            int i171 = ~iComponent15;
                                                            int i172 = ((~((i171 & (-2)) | ((-2) ^ i171))) | (~((iAxisFromString ^ iComponent15) | (iAxisFromString & iComponent15)))) * 959;
                                                            int i173 = (i170 ^ i172) + ((i172 & i170) << 1);
                                                            int i174 = (i173 ^ 1918) + ((i173 & 1918) << 1);
                                                            int i175 = ~(((-2) ^ iComponent15) | ((-2) & iComponent15));
                                                            int i176 = ~iComponent15;
                                                            int i177 = ~((iAxisFromString & i176) | (i176 ^ iAxisFromString));
                                                            int i178 = ((i177 & i175) | (i175 ^ i177)) * 959;
                                                            Object[] objArr30 = new Object[1];
                                                            b((i174 & i178) + (i178 | i174), "\udd6c彥穛\ueab5", "鼋驣췢耳", (char) (ViewConfiguration.getTapTimeout() >> 16), "\ue49a㢳崑\uf453✝ޖ꿴譑迦ᷣ擙瀑蜘\ue403럵긼ᥘꂑ製鲍긷逢퐏ל離랩溑뾺铒ٌ䁋콂鞜愑", objArr30);
                                                            Class<?> cls8 = Class.forName((String) objArr30[0]);
                                                            int i179 = -View.combineMeasuredStates(0, 0);
                                                            int i180 = i179 * PlaybackException.ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED;
                                                            int i181 = (i180 & (-2369)) + (i180 | (-2369));
                                                            int i182 = ~((~i179) | (-24));
                                                            int i183 = ~(((-24) ^ i) | ((-24) & i));
                                                            int i184 = ((i182 ^ i183) | (i182 & i183)) * 104;
                                                            int i185 = (i181 ^ i184) + ((i184 & i181) << 1);
                                                            int i186 = -(-((~(i54 | i179 | 23)) * PlaybackException.ERROR_CODE_CONCURRENT_STREAM_LIMIT));
                                                            int i187 = ((i185 | i186) << 1) - (i186 ^ i185);
                                                            int i188 = -(-((i179 | i) * 104));
                                                            int i189 = ((i187 | i188) << 1) - (i187 ^ i188);
                                                            Object[] objArr31 = new Object[1];
                                                            a(new int[]{-1241781065, 1098950209, 335632371, 936942870, 1684812961, 259380878, -732348598, 1118095423, -1740705735, -1398953036, 447074945, -1330227253}, i189, objArr31);
                                                            if (obj2.equals(cls8.getMethod((String) objArr31[0], null).invoke(objInvoke4, null))) {
                                                                Object[] objArr32 = {new int[]{i}, null, new int[]{(~(i & 1)) & (i | 1)}, new int[1]};
                                                                int iMyTid2 = Process.myTid();
                                                                int i190 = ~iMyTid2;
                                                                int i191 = (-1646568222) + (((~((-370225922) | i190)) | (-1541180013)) * (-865)) + ((~(iMyTid2 | 370225921)) * 865) + (((~((-1541180013) | i190)) | (~(i190 | 370225921))) * 865);
                                                                int iComponent16 = getYJ21310.component9();
                                                                int i192 = -(-(i191 * (-139)));
                                                                int i193 = (2256 ^ i192) + ((i192 & 2256) << 1);
                                                                int i194 = ~(((-17) ^ i191) | ((-17) & i191));
                                                                int i195 = ~(((-17) & iComponent16) | ((-17) ^ iComponent16));
                                                                int i196 = -(-(((i195 & i194) | (i194 ^ i195)) * (-280)));
                                                                int i197 = (i193 ^ i196) + ((i196 & i193) << 1);
                                                                int i198 = ~((-17) | iComponent16);
                                                                int i199 = ~i191;
                                                                int i200 = ~(i199 | iComponent16);
                                                                int i201 = i197 + (((i198 & i200) | (i198 ^ i200)) * 140);
                                                                int i202 = ~((~i191) | (-17) | iComponent16);
                                                                int i203 = ~iComponent16;
                                                                int i204 = ((-17) & i203) | ((-17) ^ i203);
                                                                int i205 = -(-(((~((i203 & i199) | (i199 ^ i203) | 16)) | (~((i204 & i191) | (i204 ^ i191))) | i202) * 140));
                                                                int i206 = (i201 ^ i205) + ((i205 & i201) << 1);
                                                                int iComponent17 = getYJ21310.component9();
                                                                int i207 = ~i206;
                                                                int i208 = ~i2;
                                                                int i209 = (i206 * (-575)) + (i2 * (-575)) + (((~((i207 ^ i208) | (i207 & i208))) | (~((i208 ^ iComponent17) | (i208 & iComponent17)))) * 576);
                                                                int i210 = ~((i207 & i2) | (i207 ^ i2));
                                                                int i211 = ~iComponent17;
                                                                int i212 = (i211 & i208) | (i208 ^ i211);
                                                                int i213 = ~((i212 & i206) | (i212 ^ i206));
                                                                int i214 = ((i213 & i210) | (i210 ^ i213)) * 576;
                                                                int i215 = (i209 & i214) + (i214 | i209);
                                                                int i216 = ~i206;
                                                                int i217 = ~i2;
                                                                int i218 = (i215 - (~(-(-((~((i216 & i217) | (i216 ^ i217))) * 576))))) - 1;
                                                                int i219 = i218 << 13;
                                                                int i220 = (i219 | i218) & (~(i218 & i219));
                                                                int i221 = i220 ^ (i220 >>> 17);
                                                                ((int[]) objArr32[c])[0] = i221 ^ (i221 << 5);
                                                                return objArr32;
                                                            }
                                                        } catch (Throwable th) {
                                                            Throwable cause = th.getCause();
                                                            if (cause != null) {
                                                                throw cause;
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    i117++;
                                                    objArr19 = objArr23;
                                                    str = str2;
                                                    i3 = 1;
                                                    i23 = 20;
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
        int i222 = ~i;
        int i223 = (-1449408630) + ((1844248575 | i222) * (-369)) + (((~((-75562992) | i222)) | 1835842942) * (-369)) + (((~(i | 75562991)) | 1768685584 | (~(i222 | (-8405634)))) * 369);
        int i224 = (i223 << 1) - i223;
        int iComponent18 = getYJ21310.component9();
        int i225 = i224 * (-518);
        int i226 = i2 * (-518);
        int i227 = (i225 ^ i226) + ((i225 & i226) << 1);
        int i228 = ~i224;
        int i229 = ~iComponent18;
        int i230 = ~(i228 | i229);
        int i231 = i227 + (((i230 & i2) | (i2 ^ i230)) * 519);
        int i232 = (i228 & i229) | (i228 ^ i229);
        int i233 = ~((i232 & i2) | (i232 ^ i2));
        int i234 = (i224 ^ i2) | (i224 & i2);
        int i235 = ~((i234 & iComponent18) | (i234 ^ iComponent18));
        int i236 = ((i233 & i235) | (i233 ^ i235)) * (-519);
        int i237 = (i231 & i236) + (i236 | i231);
        int i238 = ~((i2 & iComponent18) | (i2 ^ iComponent18));
        int i239 = -(-(((i224 & i238) | (i224 ^ i238)) * 519));
        int i240 = (i237 ^ i239) + ((i239 & i237) << 1);
        int i241 = i240 << 13;
        int i242 = (i241 | i240) & (~(i240 & i241));
        int i243 = i242 >>> 17;
        int i244 = (i242 | i243) & (~(i242 & i243));
        int i245 = i244 << 5;
        ((int[]) objArr33[c])[0] = (i244 | i245) & (~(i244 & i245));
        return objArr33;
    }
}
