package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
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
import com.google.android.gms.cast.MediaError;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes6.dex */
public final class ah {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int D8871;
    private static int component9;
    private final TelephonyManager setPivotYN16904;

    public static /* synthetic */ Object D8871(Object[] objArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = (~((~i4) | i6)) | (~(i4 | i3));
        int i8 = ~i6;
        int i9 = (~(i8 | i3)) | i4;
        int i10 = (~(i3 | i6)) | (~(i8 | (~i3))) | i4;
        int i11 = i6 + i4 + i + ((-737137436) * i5) + ((-1840598144) * i2);
        int i12 = i11 * i11;
        int i13 = (((-699670985) * i6) - 818937856) + (24099949 * i4) + (723770934 * i7) + ((-1447541868) * i9) + ((-723770934) * i10) + ((-1423441920) * i) + (1335885824 * i5) + ((-1946157056) * i2) + ((-1593638912) * i12);
        int i14 = (i6 * 1252406331) + 1981669868 + (i4 * 1252405337) + (i7 * (-994)) + (i9 * 1988) + (i10 * 994) + (i * 1252407325) + (i5 * (-1820396076)) + (i2 * 1320834432) + (i12 * (-447283200));
        return i13 + ((i14 * i14) * 1511325696) != 1 ? setPivotYN16904(objArr) : vD14832N6715(objArr);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static void a(short r5, int r6, byte r7, java.lang.Object[] r8) {
        /*
            int r6 = r6 * 2
            int r6 = 99 - r6
            int r5 = r5 * 3
            int r5 = r5 + 10
            byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.ah.$$a
            int r7 = r7 * 3
            int r7 = 4 - r7
            byte[] r1 = new byte[r5]
            r2 = 0
            if (r0 != 0) goto L16
            r4 = r5
            r3 = r2
            goto L28
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r5) goto L26
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L26:
            r4 = r0[r7]
        L28:
            int r7 = r7 + 1
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-25)
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ah.a(short, int, byte, java.lang.Object[]):void");
    }

    static void init$0() {
        $$a = new byte[]{74, -125, 38, 125, -37, -23, -28, -24, -24, -16, -34, -31, 38};
        $$b = 60;
    }

    public ah(TelephonyManager telephonyManager) {
        this.setPivotYN16904 = telephonyManager;
    }

    private static /* synthetic */ Object vD14832N6715(Object[] objArr) {
        ah ahVar = (ah) objArr[0];
        int i = 2 % 2;
        int i2 = D8871 + 19;
        component9 = i2 % 128;
        int i3 = i2 % 2;
        TelephonyManager telephonyManager = ahVar.setPivotYN16904;
        if (i3 == 0) {
            return telephonyManager;
        }
        throw null;
    }

    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr2 = {0L, new Function0<ac>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.ah.3
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static final byte[] $$c = null;
                private static final int $$d = 0;
                private static int $10;
                private static int $11;
                private static int $component5;
                private static int $component9;
                private static char D8871;
                private static char[] vD14832N6715;

                /* JADX WARN: Code duplicated, block: B:10:0x0027  */
                /* JADX WARN: Code duplicated, block: B:8:0x0021  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0029). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$e(byte r5, short r6, short r7) {
                    /*
                        int r6 = r6 + 4
                        int r5 = r5 * 2
                        int r5 = r5 + 67
                        byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass3.$$c
                        int r7 = r7 * 3
                        int r1 = 1 - r7
                        byte[] r1 = new byte[r1]
                        r2 = 0
                        int r7 = 0 - r7
                        if (r0 != 0) goto L17
                        r3 = r5
                        r5 = r7
                        r4 = r2
                        goto L29
                    L17:
                        r3 = r2
                    L18:
                        int r6 = r6 + 1
                        byte r4 = (byte) r5
                        r1[r3] = r4
                        int r4 = r3 + 1
                        if (r3 != r7) goto L27
                        java.lang.String r5 = new java.lang.String
                        r5.<init>(r1, r2)
                        return r5
                    L27:
                        r3 = r0[r6]
                    L29:
                        int r5 = r5 + r3
                        r3 = r4
                        goto L18
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass3.$$e(byte, short, short):java.lang.String");
                }

                private static void b(short s, short s2, short s3, Object[] objArr3) {
                    int i2 = 99 - (s2 * 2);
                    int i3 = s3 + 4;
                    byte[] bArr = $$a;
                    int i4 = s * 2;
                    byte[] bArr2 = new byte[4 - i4];
                    int i5 = 3 - i4;
                    int i6 = -1;
                    if (bArr == null) {
                        i2 = i2 + (-i5) + 6;
                    }
                    while (true) {
                        i6++;
                        bArr2[i6] = (byte) i2;
                        if (i6 == i5) {
                            objArr3[0] = new String(bArr2, 0);
                            return;
                        } else {
                            i3++;
                            i2 = i2 + (-bArr[i3]) + 6;
                        }
                    }
                }

                static void init$0() {
                    $$a = new byte[]{112, -15, 19, -25, -6, 5, -3};
                    $$b = 79;
                }

                static void init$1() {
                    $$c = new byte[]{104, 70, -12, 62};
                    $$d = 9;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ ac invoke() throws Exception {
                    int i2 = 2 % 2;
                    int i3 = $component5 + 25;
                    $component9 = i3 % 128;
                    int i4 = i3 % 2;
                    ac acVarD8871 = D8871();
                    int i5 = $component9;
                    int i6 = (i5 ^ 89) + ((i5 & 89) << 1);
                    $component5 = i6 % 128;
                    if (i6 % 2 != 0) {
                        return acVarD8871;
                    }
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                public final ac D8871() throws Exception {
                    int i2 = 2 % 2;
                    int i3 = $component9 + 79;
                    $component5 = i3 % 128;
                    int i4 = i3 % 2;
                    Object[] objArr3 = {ah.this};
                    int iD8871 = aa.D8871();
                    TelephonyManager telephonyManager = (TelephonyManager) ah.D8871(objArr3, aa.D8871(), aa.D8871(), iD8871, -1588400053, aa.D8871(), 1588400054);
                    Intrinsics.checkNotNull(telephonyManager);
                    Object obj = null;
                    switch (telephonyManager.getDataState()) {
                        case -1:
                            return ac.component13.INSTANCE;
                        case 0:
                            return ac.component5.INSTANCE;
                        case 1:
                            return ac.vD14832N6715.INSTANCE;
                        case 2:
                            return ac.setPivotYN16904.INSTANCE;
                        case 3:
                            ac.component8 component8Var = ac.component8.INSTANCE;
                            int i5 = $component5 + 101;
                            $component9 = i5 % 128;
                            int i6 = i5 % 2;
                            return component8Var;
                        case 4:
                            ac.D8871 d8871 = ac.D8871.INSTANCE;
                            int i7 = $component9;
                            int i8 = (i7 ^ 75) + ((i7 & 75) << 1);
                            $component5 = i8 % 128;
                            if (i8 % 2 != 0) {
                                return d8871;
                            }
                            obj.hashCode();
                            throw null;
                        case 5:
                            ac.component9 component9Var = ac.component9.INSTANCE;
                            int i9 = $component5;
                            int i10 = (i9 & 27) + (i9 | 27);
                            $component9 = i10 % 128;
                            if (i10 % 2 == 0) {
                                return component9Var;
                            }
                            obj.hashCode();
                            throw null;
                        default:
                            throw new Exception();
                    }
                }

                /* JADX WARN: Code duplicated, block: B:8:0x0019  */
                /* JADX WARN: Code duplicated, block: B:9:0x001e  */
                private static void a(int i2, String str, byte b, Object[] objArr3) throws Throwable {
                    Object charArray;
                    int i3;
                    long j;
                    char c = 2;
                    int i4 = 2 % 2;
                    int i5 = $11 + 57;
                    $10 = i5 % 128;
                    if (i5 % 2 != 0) {
                        int i6 = 73 / 0;
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
                    ce ceVar = new ce();
                    char[] cArr2 = vD14832N6715;
                    int i7 = 1083735746;
                    long j2 = 0;
                    if (cArr2 != null) {
                        int length = cArr2.length;
                        char[] cArr3 = new char[length];
                        int i8 = 0;
                        while (i8 < length) {
                            int i9 = $11 + 119;
                            char c2 = c;
                            $10 = i9 % 128;
                            if (i9 % 2 != 0) {
                                try {
                                    Object[] objArr4 = {Integer.valueOf(cArr2[i8])};
                                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(i7);
                                    if (objComponent5 == null) {
                                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 51, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 8064), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 3216, 304954017, false, $$e((byte) ($$d | 16), (short) -1, (short) 0), new Class[]{Integer.TYPE});
                                    }
                                    cArr3[i8] = ((Character) ((Method) objComponent5).invoke(null, objArr4)).charValue();
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause == null) {
                                        throw th;
                                    }
                                    throw cause;
                                }
                            } else {
                                i7 = i7;
                                Object[] objArr5 = {Integer.valueOf(cArr2[i8])};
                                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i7);
                                if (objComponent6 == null) {
                                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (8065 - Color.green(0)), Color.blue(0) + 3217, 304954017, false, $$e((byte) ($$d | 16), (short) -1, (short) 0), new Class[]{Integer.TYPE});
                                }
                                cArr3[i8] = ((Character) ((Method) objComponent6).invoke(null, objArr5)).charValue();
                                i8++;
                            }
                            c = c2;
                            i7 = i7;
                        }
                        cArr2 = cArr3;
                    }
                    char c3 = c;
                    int i10 = i7;
                    Object[] objArr6 = {Integer.valueOf(D8871)};
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i10);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (8065 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1))), 3217 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 304954017, false, $$e((byte) ($$d | 16), (short) -1, (short) 0), new Class[]{Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objComponent7).invoke(null, objArr6)).charValue();
                    char[] cArr4 = new char[i2];
                    int i11 = 13;
                    if (i2 % 2 != 0) {
                        int i12 = $11 + 13;
                        $10 = i12 % 128;
                        if (i12 % 2 != 0) {
                            i3 = i2 + 77;
                            cArr4[i3] = (char) (cArr[i3] / b);
                        } else {
                            i3 = i2 - 1;
                            cArr4[i3] = (char) (cArr[i3] - b);
                        }
                    } else {
                        i3 = i2;
                    }
                    int i13 = 1;
                    if (i3 > 1) {
                        ceVar.component5 = 0;
                        while (ceVar.component5 < i3) {
                            int i14 = $11 + 75;
                            $10 = i14 % 128;
                            int i15 = i14 % 2;
                            ceVar.D8871 = cArr[ceVar.component5];
                            ceVar.setPivotYN16904 = cArr[ceVar.component5 + i13];
                            if (ceVar.D8871 == ceVar.setPivotYN16904) {
                                cArr4[ceVar.component5] = (char) (ceVar.D8871 - b);
                                cArr4[ceVar.component5 + i13] = (char) (ceVar.setPivotYN16904 - b);
                                j = j2;
                                i13 = i13;
                            } else {
                                Object[] objArr7 = new Object[i11];
                                objArr7[12] = ceVar;
                                j = j2;
                                objArr7[11] = Integer.valueOf(cCharValue);
                                objArr7[10] = ceVar;
                                objArr7[9] = ceVar;
                                objArr7[8] = Integer.valueOf(cCharValue);
                                objArr7[7] = ceVar;
                                objArr7[6] = ceVar;
                                objArr7[5] = Integer.valueOf(cCharValue);
                                objArr7[4] = ceVar;
                                objArr7[3] = ceVar;
                                objArr7[c3] = Integer.valueOf(cCharValue);
                                objArr7[i13] = ceVar;
                                objArr7[0] = ceVar;
                                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1087197054);
                                if (objComponent8 == null) {
                                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.lastIndexOf("", '0', 0), (char) (47645 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), 5214 - (Process.myPid() >> 22), 309857053, false, $$e((byte) ($$d | 18), (short) -1, (short) 0), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                                }
                                if (((Integer) ((Method) objComponent8).invoke(null, objArr7)).intValue() == ceVar.component13) {
                                    Object[] objArr8 = new Object[11];
                                    objArr8[10] = ceVar;
                                    objArr8[9] = Integer.valueOf(cCharValue);
                                    objArr8[8] = ceVar;
                                    objArr8[7] = Integer.valueOf(cCharValue);
                                    objArr8[6] = Integer.valueOf(cCharValue);
                                    objArr8[5] = ceVar;
                                    objArr8[4] = ceVar;
                                    objArr8[3] = Integer.valueOf(cCharValue);
                                    objArr8[c3] = Integer.valueOf(cCharValue);
                                    objArr8[i13] = ceVar;
                                    objArr8[0] = ceVar;
                                    Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(1764120300);
                                    if (objComponent9 == null) {
                                        objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715((SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1)) + 51, (char) (Process.myTid() >> 22), (ViewConfiguration.getTouchSlop() >> 8) + 5576, 999494287, false, $$e((byte) 0, (short) -1, (short) 0), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                    }
                                    int iIntValue = ((Integer) ((Method) objComponent9).invoke(null, objArr8)).intValue();
                                    int i16 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                                    cArr4[ceVar.component5] = cArr2[iIntValue];
                                    cArr4[ceVar.component5 + 1] = cArr2[i16];
                                } else if (ceVar.component9 == ceVar.vD14832N6715) {
                                    ceVar.N14263A23323 = ((ceVar.N14263A23323 + cCharValue) - 1) % cCharValue;
                                    ceVar.component13 = ((ceVar.component13 + cCharValue) - 1) % cCharValue;
                                    int i17 = (ceVar.component9 * cCharValue) + ceVar.N14263A23323;
                                    int i18 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                                    cArr4[ceVar.component5] = cArr2[i17];
                                    cArr4[ceVar.component5 + 1] = cArr2[i18];
                                } else {
                                    int i19 = (ceVar.component9 * cCharValue) + ceVar.component13;
                                    int i20 = (ceVar.vD14832N6715 * cCharValue) + ceVar.N14263A23323;
                                    cArr4[ceVar.component5] = cArr2[i19];
                                    cArr4[ceVar.component5 + 1] = cArr2[i20];
                                }
                            }
                            ceVar.component5 += 2;
                            j2 = j;
                            i13 = i13;
                            i11 = 13;
                        }
                    }
                    for (int i21 = 0; i21 < i2; i21++) {
                        cArr4[i21] = (char) (cArr4[i21] ^ 13722);
                    }
                    objArr3[0] = new String(cArr4);
                }

                static {
                    init$1();
                    $10 = 0;
                    $11 = 1;
                    init$0();
                    $component9 = 0;
                    $component5 = 1;
                    vD14832N6715 = new char[]{15054, 15045, 15075, 14655, 15046, 15056, 15061, 14649, 15063, 15047, 14650, 15062, 15078, 14996, 15044, 15053, 15051, 15040, 14654, 15098, 15043, 15041, 15050, 15048, 14651, 15042, 14987, 15049, 15068, 15052, 15057, 15073, 14653, 14986, 14652, 15058};
                    D8871 = (char) 3897;
                }

                /* JADX WARN: Code duplicated, block: B:115:0x07d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:67:0x073c  */
                /* JADX WARN: Code duplicated, block: B:68:0x0748 A[Catch: Exception -> 0x07d0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x07d0, blocks: (B:65:0x072a, B:68:0x0748, B:70:0x07bf, B:72:0x07c7, B:73:0x07cd, B:69:0x0752), top: B:105:0x072a, inners: #3 }] */
                /* JADX WARN: Code duplicated, block: B:79:0x083c  */
                /* JADX WARN: Code duplicated, block: B:80:0x083e A[Catch: Exception -> 0x0946, TRY_LEAVE, TryCatch #6 {Exception -> 0x0946, blocks: (B:77:0x07d3, B:80:0x083e, B:82:0x092a, B:85:0x093f, B:86:0x0945, B:81:0x0848), top: B:115:0x07d3, inners: #9 }] */
                /* JADX WARN: Code duplicated, block: B:93:0x0a10  */
                public static Object[] component5(int i2, int i3) throws Throwable {
                    int i4;
                    Object[] objArr3;
                    Throwable th;
                    int i5;
                    Object[] objArr4;
                    long j;
                    char c;
                    Object obj;
                    int i6;
                    boolean zEquals;
                    boolean zEquals2;
                    int i7;
                    File file;
                    FileReader fileReader;
                    BufferedReader bufferedReader;
                    File file2;
                    FileReader fileReader2;
                    BufferedReader bufferedReader2;
                    int i8 = 2 % 2;
                    int i9 = $component9;
                    int i10 = ((i9 | 59) << 1) - (i9 ^ 59);
                    $component5 = i10 % 128;
                    int i11 = i10 % 2;
                    try {
                        int i12 = 18 - (~(ViewConfiguration.getPressedStateDuration() >> 16));
                        int iLastIndexOf = TextUtils.lastIndexOf("", '0', 0);
                        int i13 = iLastIndexOf * 70;
                        int i14 = (i13 ^ (-272)) + ((i13 & (-272)) << 1);
                        int i15 = ~iLastIndexOf;
                        int i16 = i15 | (-5);
                        i4 = 5;
                        int i17 = ~((i16 ^ i2) | (i16 & i2));
                        int i18 = ~((iLastIndexOf ^ 4) | (iLastIndexOf & 4) | i2);
                        int i19 = -(-(((i17 ^ i18) | (i17 & i18)) * 69));
                        int i20 = (i14 & i19) + (i19 | i14);
                        int i21 = ~((i15 ^ 4) | (i15 & 4));
                        int i22 = ~((i15 & i2) | (i15 ^ i2));
                        int i23 = (i21 & i22) | (i21 ^ i22);
                        int i24 = ~(i2 | 4);
                        byte b = (byte) (((i20 + (((i23 & i24) | (i23 ^ i24)) * (-69))) - (~(-(-((~(((-5) & iLastIndexOf) | ((-5) ^ iLastIndexOf))) * 69))))) - 1);
                        try {
                            Object[] objArr5 = new Object[1];
                            a(i12, "#\u0011#\r\u000b\u0003㘀㘀\u000e\u000b\u0010\u0012㗷㗷\u0010\u0005#\f㘁", b, objArr5);
                            String str = (String) objArr5[0];
                            int keyRepeatDelay = ViewConfiguration.getKeyRepeatDelay() >> 16;
                            int iComponent9 = component8T18414.AnonymousClass5.component9();
                            int i25 = keyRepeatDelay * WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL;
                            int i26 = (i25 & (-2934)) + (i25 | (-2934));
                            int i27 = ~iComponent9;
                            int i28 = ~(i27 | 18);
                            int i29 = ((i28 & keyRepeatDelay) | (keyRepeatDelay ^ i28)) * (-328);
                            int i30 = (i26 ^ i29) + ((i26 & i29) << 1) + ((keyRepeatDelay | iComponent9) * 164);
                            int i31 = ~keyRepeatDelay;
                            int i32 = ~((i31 & (-19)) | (i31 ^ (-19)));
                            int i33 = ~(((-19) & iComponent9) | ((-19) ^ iComponent9));
                            int i34 = (i33 & i32) | (i32 ^ i33);
                            int i35 = keyRepeatDelay | i27;
                            int i36 = ~((i35 & 18) | (i35 ^ 18));
                            int i37 = ((i36 & i34) | (i34 ^ i36)) * 164;
                            Object[] objArr6 = new Object[1];
                            a(((i30 | i37) << 1) - (i37 ^ i30), " \u0011\u0018#\u001c\u0011\u001a\u0001\u0014\n#\r\u000b\u0003㘂㘂\u000e\u000b", (byte) (TextUtils.indexOf("", "", 0, 0) + 5), objArr6);
                            String[] strArr = {str, (String) objArr6[0]};
                            int i38 = 0;
                            while (true) {
                                if (i38 >= 2) {
                                    objArr3 = new Object[]{new int[]{i2}, null, new int[]{i2}, new int[1]};
                                    int iMyUid = Process.myUid();
                                    int i39 = ~iMyUid;
                                    int i40 = ~(417553132 | i39);
                                    int i41 = (-562375723) + ((1091051521 | i40) * (-712)) + (((~(iMyUid | 1508604653)) | (~(i39 | (-1091051522)))) * (-712)) + (((-1493852802) | i40) * 712);
                                    int i42 = (i41 * JfifUtil.MARKER_EOI) + (i3 * (-215));
                                    int i43 = -(-((~(i41 | i2)) * JfifUtil.MARKER_SOI));
                                    int i44 = ((i42 | i43) << 1) - (i42 ^ i43);
                                    int i45 = ~i3;
                                    int i46 = (i45 & i41) | (i41 ^ i45);
                                    int i47 = ~i2;
                                    int i48 = i44 + (((i46 & i47) | (i46 ^ i47)) * (-216));
                                    int i49 = ~i2;
                                    int i50 = ~((i49 & i41) | (i49 ^ i41));
                                    int i51 = -(-(((i50 & i3) | (i3 ^ i50)) * JfifUtil.MARKER_SOI));
                                    int i52 = ((i48 | i51) << 1) - (i51 ^ i48);
                                    int i53 = (i52 << 13) ^ i52;
                                    int i54 = i53 >>> 17;
                                    int i55 = ((~i53) & i54) | ((~i54) & i53);
                                    int i56 = i55 << 5;
                                    ((int[]) objArr3[3])[0] = ((~i55) & i56) | ((~i56) & i55);
                                    component8T18414.AnonymousClass5.component9();
                                    break;
                                }
                                String str2 = strArr[i38];
                                Object[] objArr7 = new Object[1];
                                a(Drawable.resolveOpacity(0, 0) + 16, "\u000f\u0011\u0014\t\u0017\u001c\u0014\u001b\u0017\n\u0019 \u000f\u000b\u0001\u001d", (byte) (47 - (~(-View.MeasureSpec.makeMeasureSpec(0, 0)))), objArr7);
                                Class<?> cls = Class.forName((String) objArr7[0]);
                                if (((Boolean) cls.getMethod(str2, null).invoke(cls, null)).booleanValue()) {
                                    int i57 = $component9;
                                    int i58 = (i57 ^ 115) + ((i57 & 115) << 1);
                                    $component5 = i58 % 128;
                                    int i59 = i58 % 2;
                                    objArr3 = new Object[]{new int[]{i2}, null, new int[]{(~(i2 & 1)) & (i2 | 1)}, new int[]{i ^ (i << 5)}};
                                    int i60 = ~i2;
                                    int i61 = 621794648 + (((~((-716455524) | i60)) | 1194950410) * (-602)) + (((~((-716455524) | i2)) | 36716034 | (~(1874689899 | i60))) * (-301)) + ((~(i60 | 1194950410)) * 301);
                                    int i62 = (i3 - (~(((i61 | 16) << 1) - (i61 ^ 16)))) - 1;
                                    int i63 = i62 ^ (i62 << 13);
                                    int i64 = i63 >>> 17;
                                    int i65 = ((~i63) & i64) | ((~i64) & i63);
                                    break;
                                }
                                i38++;
                            }
                        } catch (Exception unused) {
                            int i66 = ~i2;
                            Object[] objArr8 = {new int[]{i2}, null, new int[]{(i2 & (-3)) | (i66 & 2)}, new int[]{(i | i) & (~(i & i))}};
                            int i67 = 774663852 + (((~(i2 | 530256922)) | (-1608236380)) * 305) + (((~(530256922 | i66)) | (-1381149012)) * 305);
                            int i68 = -(-((i67 & 16) + (i67 | 16)));
                            int i69 = (i3 & i68) + (i68 | i3);
                            int i70 = i69 << 13;
                            int i71 = (i70 | i69) & (~(i69 & i70));
                            int i72 = i71 >>> 17;
                            int i73 = ((~i71) & i72) | ((~i72) & i71);
                            int i74 = i73 << 5;
                            objArr3 = objArr8;
                        }
                    } catch (Exception unused2) {
                        i4 = 5;
                    }
                    if (i2 != ((int[]) objArr3[2])[0]) {
                        int i75 = $component5;
                        int i76 = (i75 & 101) + (i75 | 101);
                        $component9 = i76 % 128;
                        if (i76 % 2 != 0) {
                            int i77 = i4 / 0;
                        }
                        return objArr3;
                    }
                    try {
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1966788839);
                        if (objComponent5 == null) {
                            int i78 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 51;
                            char cMyTid = (char) ((Process.myTid() >> 22) + 3284);
                            int packedPositionType = ExpandableListView.getPackedPositionType(0L) + 6627;
                            Object[] objArr9 = new Object[1];
                            b((short) 0, (short) 0, (short) -1, objArr9);
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(i78, cMyTid, packedPositionType, 663721092, false, (String) objArr9[0], new Class[0]);
                        }
                        long jLongValue = ((Long) ((Method) objComponent5).invoke(null, null)).longValue();
                        long j2 = i2;
                        long j3 = j2 ^ (-1);
                        long j4 = (-797846515196L) + ((-1343) * jLongValue) + ((jLongValue | (((-1185507452) | j2) ^ (-1))) * 672) + ((-672) * (((1185507451 | j3) ^ (-1)) | ((j2 | jLongValue) ^ (-1))));
                        long j5 = jLongValue ^ (-1);
                        long j6 = j4 + (672 * (((j5 | (-1185507452)) ^ (-1)) | ((j5 | j3) ^ (-1)))) + 1975213532;
                        int iElapsedRealtime = (int) SystemClock.elapsedRealtime();
                        int i79 = ~iElapsedRealtime;
                        int i80 = ((int) (j6 >> 32)) & ((-1921717046) + (((-1597833199) | (~(i79 | (-1259907687)))) * 220) + (((~((-1528610663) | i79)) | (-1329130223)) * (-440)) + (((-1259907687) | iElapsedRealtime) * 220));
                        int i81 = ~i2;
                        int i82 = ((int) j6) & (1091174838 + (((~(1407074217 | i81)) | (~((-141345) | i2)) | (~((-1376780682) | i2))) * 765) + (((-1407074218) | (~(1406932873 | i81))) * 1530) + (((~(1406932873 | i2)) | (~((-1376780682) | i81))) * 765));
                        if (((i80 & i82) | (i80 ^ i82)) == 1) {
                            component8T18414.AnonymousClass5.component9();
                            i5 = -17;
                            objArr4 = new Object[]{new int[]{i2}, null, new int[]{(i2 & (-11)) | (i81 & 10)}, new int[1]};
                            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                            int i83 = ~elapsedCpuTime;
                            th = null;
                            int i84 = (-837284160) + (((~((-838861329) | elapsedCpuTime)) | (~(i83 | 912599888)) | (-1072544606)) * 717) + (((~(elapsedCpuTime | 912599888)) | (~((-838861329) | i83)) | (-1072544606)) * 717);
                            int i85 = 4367 - (~(-(-(i84 * (-271)))));
                            int i86 = ~i84;
                            int i87 = ((-17) & i86) | ((-17) ^ i86);
                            int i88 = ~((i87 & i81) | (i87 ^ i81));
                            int i89 = (i84 ^ 16) | (i84 & 16);
                            int i90 = ~((i89 & i2) | (i89 ^ i2));
                            int i91 = i85 + (((i88 & i90) | (i88 ^ i90)) * (-272));
                            int i92 = ~(((-17) ^ i84) | ((-17) & i84));
                            int i93 = ~(((-17) ^ i2) | ((-17) & i2));
                            int i94 = (i91 - (~(((i92 & i93) | (i92 ^ i93)) * (-272)))) - 1;
                            int i95 = ~((i2 ^ 16) | (i2 & 16));
                            int i96 = (i94 - (~(-(-(((i95 & i84) | (i84 ^ i95)) * 272))))) - 1;
                            int iComponent10 = component8T18414.AnonymousClass5.component9();
                            int i97 = (((i96 * 367) - (~(-(-(i3 * 367))))) - 1) + ((i96 | i3) * (-366));
                            int i98 = ~i3;
                            int i99 = ~((i98 & iComponent10) | (i98 ^ iComponent10));
                            int i100 = -(-(((i99 & i96) | (i96 ^ i99)) * (-366)));
                            int i101 = ((i97 | i100) << 1) - (i97 ^ i100);
                            int i102 = ~i96;
                            int i103 = ~((i102 & i3) | (i102 ^ i3));
                            int i104 = ~i3;
                            int i105 = -(-(((~((i104 ^ i96) | (i96 & i104) | iComponent10)) | i103) * 366));
                            int i106 = (i101 & i105) + (i105 | i101);
                            int i107 = (i106 << 13) ^ i106;
                            int i108 = i107 >>> 17;
                            int i109 = (i107 | i108) & (~(i107 & i108));
                            int i110 = i109 << 5;
                            ((int[]) objArr4[3])[0] = ((~i109) & i110) | ((~i110) & i109);
                        } else {
                            th = null;
                            i5 = -17;
                            objArr4 = new Object[]{new int[]{i2}, null, new int[]{i2}, new int[1]};
                            int i111 = ~((int) Runtime.getRuntime().freeMemory());
                            int i112 = 1791160633 + ((~(1841037111 | i111)) * 52) + (((~(213499447 | i111)) | (~((-1697906487) | i111)) | 1627537664) * (-52)) + (((~(i111 | (-213499448))) | 143130625) * 52);
                            int iComponent11 = component8T18414.AnonymousClass5.component9();
                            int i113 = i112 * 421;
                            int i114 = (~(i112 | iComponent11)) * 420;
                            int i115 = (i113 ^ i114) + ((i113 & i114) << 1);
                            int i116 = -(-(((i112 ^ (-1)) | i112) * (-420)));
                            int i117 = ((i115 | i116) << 1) - (i116 ^ i115);
                            int i118 = ~iComponent11;
                            int i119 = -(-((~((i118 & i112) | (i118 ^ i112))) * 420));
                            int i120 = i3 + (i117 ^ i119) + ((i119 & i117) << 1);
                            int i121 = i120 ^ (i120 << 13);
                            int i122 = i121 >>> 17;
                            int i123 = (i121 | i122) & (~(i121 & i122));
                            int i124 = i123 << 5;
                            ((int[]) objArr4[3])[0] = ((~i123) & i124) | ((~i124) & i123);
                        }
                        if (i2 != ((int[]) objArr4[2])[0]) {
                            int i125 = $component9;
                            int i126 = ((i125 | 117) << 1) - (i125 ^ 117);
                            $component5 = i126 % 128;
                            if (i126 % 2 == 0) {
                                throw th;
                            }
                            int i127 = (i125 ^ 35) + ((i125 & 35) << 1);
                            $component5 = i127 % 128;
                            if (i127 % 2 != 0) {
                                return objArr4;
                            }
                            th.hashCode();
                            throw th;
                        }
                        try {
                            try {
                                try {
                                    int i128 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1));
                                    int i129 = (i128 * (-563)) + 22035;
                                    int i130 = ~i128;
                                    int i131 = (~((-40) | i81)) | i130;
                                    int i132 = ~((i2 ^ 39) | (i2 & 39));
                                    int i133 = -(-(((i131 ^ i132) | (i131 & i132)) * (-564)));
                                    int i134 = (((i129 ^ i133) + ((i129 & i133) << 1)) - (~((~((i130 | 39) | i2)) * 1128))) - 1;
                                    int i135 = ~i2;
                                    int i136 = ~((i130 & i135) | (i130 ^ i135));
                                    int i137 = ~(i128 | 39);
                                    int i138 = ((i137 & i136) | (i136 ^ i137)) * 564;
                                    int i139 = (i134 & i138) + (i138 | i134);
                                    int i140 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                                    int iComponent12 = component8T18414.AnonymousClass5.component9();
                                    j = 0;
                                    int i141 = (((i140 * 860) - 18018) - (~(((i140 ^ iComponent12) | (i140 & iComponent12)) * (-859)))) - 1;
                                    int i142 = ~((~iComponent12) | i140);
                                    c = 2;
                                    int i143 = (~i140) | (-22);
                                    int i144 = ~((i143 ^ iComponent12) | (i143 & iComponent12));
                                    int i145 = ((i142 ^ i144) | (i142 & i144)) * 859;
                                    int i146 = (i141 ^ i145) + ((i141 & i145) << 1);
                                    int i147 = ~iComponent12;
                                    int i148 = ~(((-22) & i147) | ((-22) ^ i147));
                                    int i149 = ~(((-22) ^ i140) | ((-22) & i140));
                                    int i150 = -(-(((i148 & i149) | (i148 ^ i149)) * 859));
                                    try {
                                        Object[] objArr10 = new Object[1];
                                        a(i139, "#\t\u001d\n\u001e\u0003\u000e\u000b\u0011\f!\u0003\u0017\u000f\u000b\u0003\u001b\u001f \u0006\u0010\u0002\u001c\u0011\u001b\u001f\u0005\u0000㗼㗼\f\u0011\u001f\u0012 \u0006\u0010\u0002\u000e\u000b", (byte) ((i146 ^ i150) + ((i150 & i146) << 1)), objArr10);
                                        File file3 = new File((String) objArr10[0]);
                                        if (file3.canRead()) {
                                            FileReader fileReader3 = new FileReader(file3);
                                            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
                                            try {
                                                String line = bufferedReader3.readLine();
                                                int pressedStateDuration = ViewConfiguration.getPressedStateDuration() >> 16;
                                                int i151 = pressedStateDuration * (-375);
                                                int i152 = (i151 ^ (-1125)) + ((i151 & (-1125)) << 1);
                                                int i153 = ~pressedStateDuration;
                                                int i154 = ~(i153 | (-4));
                                                int i155 = ((i154 & i2) | (i2 ^ i154) | (~((pressedStateDuration ^ 3) | (pressedStateDuration & 3)))) * 376;
                                                int i156 = ((i152 | i155) << 1) - (i152 ^ i155);
                                                int i157 = ((~((i135 & pressedStateDuration) | (i135 ^ pressedStateDuration))) | (~(pressedStateDuration | 3))) * (-376);
                                                int i158 = (i156 & i157) + (i157 | i156);
                                                int i159 = -(-(((~((i153 ^ i2) | (i153 & i2))) | 3) * 376));
                                                int i160 = ((i158 | i159) << 1) - (i159 ^ i158);
                                                int iRed = Color.red(0);
                                                Object[] objArr11 = new Object[1];
                                                a(i160, "\u0016\u001c㙃", (byte) ((iRed & 89) + (iRed | 89)), objArr11);
                                                if (line.equals((String) objArr11[0])) {
                                                    fileReader3.close();
                                                    bufferedReader3.close();
                                                    int i161 = $component5;
                                                    int i162 = (i161 & 23) + (i161 | 23);
                                                    $component9 = i162 % 128;
                                                    if (i162 % 2 != 0) {
                                                        int i163 = 3 % 2;
                                                    }
                                                } else {
                                                    int i164 = $component5;
                                                    int i165 = (i164 ^ 5) + ((i164 & 5) << 1);
                                                    $component9 = i165 % 128;
                                                    if (i165 % 2 != 0) {
                                                        fileReader3.close();
                                                        bufferedReader3.close();
                                                        throw th;
                                                    }
                                                    fileReader3.close();
                                                    bufferedReader3.close();
                                                    obj = line;
                                                }
                                                int packedPositionChild = ExpandableListView.getPackedPositionChild(j);
                                                int i166 = packedPositionChild * (-520);
                                                int i167 = (i166 ^ 16704) + ((i166 & 16704) << 1);
                                                int i168 = ~packedPositionChild;
                                                int i169 = (i168 ^ 32) | (i168 & 32);
                                                int i170 = i167 + ((~((i169 & i2) | (i169 ^ i2))) * 521);
                                                int i171 = (packedPositionChild & (-33)) | ((-33) ^ packedPositionChild);
                                                int i172 = (~i171) * (-1042);
                                                int i173 = (i170 & i172) + (i170 | i172);
                                                int i174 = ~i171;
                                                int i175 = (i168 & i81) | (i168 ^ i81);
                                                int i176 = ~((i175 & 32) | (i175 ^ 32));
                                                int i177 = ((i174 & i176) | (i174 ^ i176)) * 521;
                                                int i178 = (i173 ^ i177) + ((i177 & i173) << 1);
                                                int i179 = (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1));
                                                int i180 = i179 * 881;
                                                int i181 = (i180 ^ 25549) + ((i180 & 25549) << 1);
                                                int i182 = ~i179;
                                                i6 = -2;
                                                int i183 = -(-(((~((i182 ^ i2) | (i182 & i2))) | (~(i182 | (-30))) | (~(((-30) ^ i2) | ((-30) & i2)))) * (-880)));
                                                int i184 = (i181 & i183) + (i183 | i181);
                                                int i185 = ~i2;
                                                int i186 = ~((i185 & i182) | (i182 ^ i185));
                                                int i187 = (i186 & 29) | (i186 ^ 29);
                                                int i188 = (i179 & i2) | (i179 ^ i2);
                                                int i189 = ~i188;
                                                int i190 = ((i187 & i189) | (i187 ^ i189)) * (-880);
                                                int i191 = (i184 & i190) + (i190 | i184);
                                                int i192 = -(-((~i188) * 880));
                                                Object[] objArr12 = new Object[1];
                                                a(i178, "\u001e\t\n\u0014\u0003\"\n\u001d\t#\u0005\f\n\u000e\u000f\u001d \u0015 \u0006\u0010\u0002\r\u0017\f\u0011\u000f\b\u001d\u000f㘛", (byte) ((i191 ^ i192) + ((i192 & i191) << 1)), objArr12);
                                                file2 = new File((String) objArr12[0]);
                                                if (file2.canRead()) {
                                                    fileReader2 = new FileReader(file2);
                                                    bufferedReader2 = new BufferedReader(fileReader2);
                                                    try {
                                                        String line2 = bufferedReader2.readLine();
                                                        int i193 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                                        int i194 = i193 * 595;
                                                        int i195 = (i194 ^ (-1187)) + ((i194 & (-1187)) << 1);
                                                        int i196 = -(-(((~((~i193) | 1)) | (~((i81 ^ 1) | (i81 & 1)))) * (-1188)));
                                                        int i197 = (i195 & i196) + (i196 | i195);
                                                        int i198 = (~((~i193) | 1)) | (~(((-2) ^ i2) | ((-2) & i2)));
                                                        int i199 = ~((i81 ^ i193) | (i81 & i193));
                                                        int i200 = ((i198 & i199) | (i198 ^ i199)) * 594;
                                                        int i201 = ((i197 | i200) << 1) - (i200 ^ i197);
                                                        int i202 = (~((-2) | i81)) | (~(((-2) ^ i193) | ((-2) & i193)));
                                                        int i203 = ~(i193 | i81);
                                                        Object[] objArr13 = new Object[1];
                                                        a((i201 - (~(((i203 & i202) | (i202 ^ i203)) * 594))) - 1, "㖷", (byte) (12 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), objArr13);
                                                        zEquals = line2.equals((String) objArr13[0]);
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                    } catch (Throwable th2) {
                                                        fileReader2.close();
                                                        bufferedReader2.close();
                                                        throw th2;
                                                    }
                                                } else {
                                                    int i204 = $component9 + 19;
                                                    $component5 = i204 % 128;
                                                    int i205 = i204 % 2;
                                                    zEquals = false;
                                                }
                                                if (zEquals) {
                                                    try {
                                                        int i206 = -MotionEvent.axisFromString("");
                                                        int i207 = i206 * 450;
                                                        int i208 = (i207 ^ (-15680)) + ((i207 & (-15680)) << 1);
                                                        int i209 = ~i206;
                                                        int i210 = ~((i209 & 35) | (i209 ^ 35));
                                                        int i211 = ((-36) ^ i206) | ((-36) & i206);
                                                        int i212 = ~((i211 & i2) | (i211 ^ i2));
                                                        int i213 = i208 + (((i210 & i212) | (i210 ^ i212)) * 449);
                                                        int i214 = ~i206;
                                                        int i215 = (i213 - (~((~((i214 ^ 35) | (i214 & 35))) * (-1347)))) - 1;
                                                        int i216 = ~(i214 | 35);
                                                        int i217 = ((-36) & i81) | ((-36) ^ i81);
                                                        int i218 = ~((i206 & i217) | (i217 ^ i206));
                                                        Object[] objArr14 = new Object[1];
                                                        a((i215 - (~(-(-(((i218 & i216) | (i216 ^ i218)) * 449))))) - 1, "#\t\u001d\n\u001e\u0003\u000e\u000b\u0011\f!\u0003\u0017\u000f\u000b\u0003\u001b\u001f \u0006\u0010\u0002\u001c\u0011\u001b\u001f \u0006\u0010\u0002\u001c\u0011\u001f\u0019\u001c\u0016", (byte) (67 - (~((byte) KeyEvent.getModifierMetaStateMask()))), objArr14);
                                                        file = new File((String) objArr14[0]);
                                                        if (file.canRead()) {
                                                            fileReader = new FileReader(file);
                                                            bufferedReader = new BufferedReader(fileReader);
                                                            try {
                                                                String line3 = bufferedReader.readLine();
                                                                int i219 = -(KeyEvent.getMaxKeyCode() >> 16);
                                                                int iComponent13 = component8T18414.AnonymousClass5.component9();
                                                                int i220 = i219 * 569;
                                                                int i221 = (i220 & 569) + (i220 | 569);
                                                                int i222 = ~i219;
                                                                int i223 = ~((i222 & (-2)) | (i222 ^ (-2)));
                                                                int i224 = ~i219;
                                                                int i225 = ~iComponent13;
                                                                int i226 = ~((i224 ^ i225) | (i224 & i225));
                                                                int i227 = (i223 ^ i226) | (i226 & i223);
                                                                int i228 = ~iComponent13;
                                                                int i229 = ~((i6 ^ i228) | (i6 & i228));
                                                                int i230 = -(-(((i227 ^ i229) | (i229 & i227)) * (-1136)));
                                                                int i231 = (i221 & i230) + (i230 | i221);
                                                                int i232 = ~((i224 ^ iComponent13) | (i224 & iComponent13));
                                                                int i233 = ~((i6 ^ iComponent13) | (i6 & iComponent13));
                                                                int i234 = (i232 ^ i233) | (i232 & i233);
                                                                int i235 = (i228 ^ i219) | (i228 & i219);
                                                                int i236 = ~((i235 ^ 1) | (i235 & 1));
                                                                int i237 = i231 + (((i234 ^ i236) | (i234 & i236)) * (-568));
                                                                int i238 = ~((i225 ^ i219) | (i219 & i225));
                                                                int i239 = ~((i228 ^ 1) | (i228 & 1));
                                                                int i240 = (i238 & i239) | (i238 ^ i239);
                                                                int i241 = (i224 ^ (-2)) | (i224 & (-2));
                                                                int i242 = ~((i241 & iComponent13) | (i241 ^ iComponent13));
                                                                int i243 = -(-(((i240 & i242) | (i240 ^ i242)) * 568));
                                                                int i244 = (i237 & i243) + (i243 | i237);
                                                                int absoluteGravity = Gravity.getAbsoluteGravity(0, 0);
                                                                int i245 = absoluteGravity * 866;
                                                                int i246 = (i245 ^ (-10368)) + ((i245 & (-10368)) << 1);
                                                                int i247 = ~((~absoluteGravity) | i81);
                                                                int i248 = ((i247 & (-13)) | ((-13) ^ i247)) * (-865);
                                                                int i249 = (((i246 & i248) + (i248 | i246)) - (~(-(-((~((absoluteGravity ^ i2) | (absoluteGravity & i2))) * 865))))) - 1;
                                                                int i250 = ~(((-13) & i81) | ((-13) ^ i81));
                                                                int i251 = ~((absoluteGravity & i81) | (i81 ^ absoluteGravity));
                                                                int i252 = -(-(((i251 & i250) | (i250 ^ i251)) * 865));
                                                                Object[] objArr15 = new Object[1];
                                                                a(i244, "㖷", (byte) ((i249 & i252) + (i252 | i249)), objArr15);
                                                                zEquals2 = line3.equals((String) objArr15[0]);
                                                                fileReader.close();
                                                                bufferedReader.close();
                                                                int i253 = $component5;
                                                                int i254 = (i253 & 55) + (i253 | 55);
                                                                $component9 = i254 % 128;
                                                                int i255 = i254 % 2;
                                                            } catch (Throwable th3) {
                                                                fileReader.close();
                                                                bufferedReader.close();
                                                                throw th3;
                                                            }
                                                        } else {
                                                            zEquals2 = false;
                                                        }
                                                    } catch (Exception unused3) {
                                                    }
                                                    if (!zEquals2 && obj != null) {
                                                        int i256 = $component9 + 71;
                                                        $component5 = i256 % 128;
                                                        int i257 = i256 % 2;
                                                        int i258 = (~(i2 & 20)) & (i2 | 20);
                                                        Object[] objArr16 = new Object[4];
                                                        objArr16[0] = new int[]{i2};
                                                        objArr16[c] = new int[]{i258};
                                                        objArr16[3] = new int[1];
                                                        objArr16[1] = obj;
                                                        int iNextInt = new Random().nextInt(1362780875);
                                                        int i259 = ~((-1047289428) | iNextInt);
                                                        int i260 = ~iNextInt;
                                                        int i261 = (-1029799469) + ((i259 | (~(1072521051 | i260))) * (-406)) + ((~((-208404546) | i260)) * (-406)) + (((~(iNextInt | (-864116507))) | (~(1047289427 | i260))) * 406);
                                                        int i262 = -(-(i261 * (-520)));
                                                        int i263 = (8352 ^ i262) + ((i262 & 8352) << 1);
                                                        int i264 = ~(i81 | i261);
                                                        int i265 = -(-(((i264 & 16) | (i264 ^ 16)) * (-1042)));
                                                        int i266 = (i263 & i265) + (i265 | i263);
                                                        int i267 = -(-(((i261 ^ i2) | (i261 & i2)) * 521));
                                                        int i268 = (i266 ^ i267) + ((i267 & i266) << 1);
                                                        int i269 = ~i261;
                                                        int i270 = (~((i5 & i269) | (i5 ^ i269))) | (~((i5 & i2) | (i5 ^ i2)));
                                                        int i271 = (i81 ^ 16) | (i81 & 16);
                                                        int i272 = ~((i271 & i261) | (i271 ^ i261));
                                                        int i273 = ((i270 & i272) | (i270 ^ i272)) * 521;
                                                        int i274 = (i268 & i273) + (i273 | i268);
                                                        int i275 = (i3 & i274) + (i274 | i3);
                                                        int i276 = i275 ^ (i275 << 13);
                                                        int i277 = i276 ^ (i276 >>> 17);
                                                        ((int[]) objArr16[3])[0] = i277 ^ (i277 << 5);
                                                        return objArr16;
                                                    }
                                                    i7 = 4;
                                                } else {
                                                    i7 = 4;
                                                }
                                                Object[] objArr17 = new Object[i7];
                                                objArr17[0] = new int[]{i2};
                                                objArr17[c] = new int[]{i2};
                                                objArr17[3] = new int[1];
                                                objArr17[1] = th;
                                                int iElapsedRealtime2 = (int) SystemClock.elapsedRealtime();
                                                int i278 = (-934432171) + ((~(iElapsedRealtime2 | 183577226)) * JfifUtil.MARKER_SOI);
                                                int i279 = ~iElapsedRealtime2;
                                                int i280 = -(-(i278 + (((-1678544994) | i279) * (-216)) + (((~(i279 | 183577226)) | 1727828707) * JfifUtil.MARKER_SOI)));
                                                int i281 = (i3 & i280) + (i280 | i3);
                                                int i282 = i281 << 13;
                                                int i283 = (i282 & (~i281)) | ((~i282) & i281);
                                                int i284 = i283 ^ (i283 >>> 17);
                                                int i285 = i284 << 5;
                                                ((int[]) objArr17[3])[0] = ((~i284) & i285) | ((~i285) & i284);
                                                return objArr17;
                                            } catch (Throwable th4) {
                                                fileReader3.close();
                                                bufferedReader3.close();
                                                throw th4;
                                            }
                                        }
                                    } catch (Exception unused4) {
                                    }
                                } catch (Exception unused5) {
                                    j = 0;
                                    c = 2;
                                }
                                Object[] objArr18 = new Object[1];
                                a(i178, "\u001e\t\n\u0014\u0003\"\n\u001d\t#\u0005\f\n\u000e\u000f\u001d \u0015 \u0006\u0010\u0002\r\u0017\f\u0011\u000f\b\u001d\u000f㘛", (byte) ((i191 ^ i192) + ((i192 & i191) << 1)), objArr18);
                                file2 = new File((String) objArr18[0]);
                                if (file2.canRead()) {
                                    int i2010 = $component9 + 19;
                                    $component5 = i2010 % 128;
                                    int i2011 = i2010 % 2;
                                    zEquals = false;
                                } else {
                                    fileReader2 = new FileReader(file2);
                                    bufferedReader2 = new BufferedReader(fileReader2);
                                    String line4 = bufferedReader2.readLine();
                                    int i1910 = -(ViewConfiguration.getMaximumFlingVelocity() >> 16);
                                    int i1911 = i1910 * 595;
                                    int i1912 = (i1911 ^ (-1187)) + ((i1911 & (-1187)) << 1);
                                    int i1913 = -(-(((~((~i1910) | 1)) | (~((i81 ^ 1) | (i81 & 1)))) * (-1188)));
                                    int i1914 = (i1912 & i1913) + (i1913 | i1912);
                                    int i1915 = (~((~i1910) | 1)) | (~(((-2) ^ i2) | ((-2) & i2)));
                                    int i1916 = ~((i81 ^ i1910) | (i81 & i1910));
                                    int i2012 = ((i1915 & i1916) | (i1915 ^ i1916)) * 594;
                                    int i2013 = ((i1914 | i2012) << 1) - (i2012 ^ i1914);
                                    int i2014 = (~((-2) | i81)) | (~(((-2) ^ i1910) | ((-2) & i1910)));
                                    int i2015 = ~(i1910 | i81);
                                    Object[] objArr19 = new Object[1];
                                    a((i2013 - (~(((i2015 & i2014) | (i2014 ^ i2015)) * 594))) - 1, "㖷", (byte) (12 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), objArr19);
                                    zEquals = line4.equals((String) objArr19[0]);
                                    fileReader2.close();
                                    bufferedReader2.close();
                                }
                            } catch (Exception unused6) {
                            }
                            int packedPositionChild2 = ExpandableListView.getPackedPositionChild(j);
                            int i1610 = packedPositionChild2 * (-520);
                            int i1611 = (i1610 ^ 16704) + ((i1610 & 16704) << 1);
                            int i1612 = ~packedPositionChild2;
                            int i1613 = (i1612 ^ 32) | (i1612 & 32);
                            int i1710 = i1611 + ((~((i1613 & i2) | (i1613 ^ i2))) * 521);
                            int i1711 = (packedPositionChild2 & (-33)) | ((-33) ^ packedPositionChild2);
                            int i1712 = (~i1711) * (-1042);
                            int i1713 = (i1710 & i1712) + (i1710 | i1712);
                            int i1714 = ~i1711;
                            int i1715 = (i1612 & i81) | (i1612 ^ i81);
                            int i1716 = ~((i1715 & 32) | (i1715 ^ 32));
                            int i1717 = ((i1714 & i1716) | (i1714 ^ i1716)) * 521;
                            int i1718 = (i1713 ^ i1717) + ((i1717 & i1713) << 1);
                            int i1719 = (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1));
                            int i1810 = i1719 * 881;
                            int i1811 = (i1810 ^ 25549) + ((i1810 & 25549) << 1);
                            int i1812 = ~i1719;
                            i6 = -2;
                            int i1813 = -(-(((~((i1812 ^ i2) | (i1812 & i2))) | (~(i1812 | (-30))) | (~(((-30) ^ i2) | ((-30) & i2)))) * (-880)));
                            int i1814 = (i1811 & i1813) + (i1813 | i1811);
                            int i1815 = ~i2;
                            int i1816 = ~((i1815 & i1812) | (i1812 ^ i1815));
                            int i1817 = (i1816 & 29) | (i1816 ^ 29);
                            int i1818 = (i1719 & i2) | (i1719 ^ i2);
                            int i1819 = ~i1818;
                            int i1917 = ((i1817 & i1819) | (i1817 ^ i1819)) * (-880);
                            int i1918 = (i1814 & i1917) + (i1917 | i1814);
                            int i1919 = -(-((~i1818) * 880));
                        } catch (Exception unused7) {
                            i6 = -2;
                        }
                        obj = th;
                        if (zEquals) {
                            int i2016 = -MotionEvent.axisFromString("");
                            int i2017 = i2016 * 450;
                            int i2018 = (i2017 ^ (-15680)) + ((i2017 & (-15680)) << 1);
                            int i2019 = ~i2016;
                            int i2110 = ~((i2019 & 35) | (i2019 ^ 35));
                            int i2111 = ((-36) ^ i2016) | ((-36) & i2016);
                            int i2112 = ~((i2111 & i2) | (i2111 ^ i2));
                            int i2113 = i2018 + (((i2110 & i2112) | (i2110 ^ i2112)) * 449);
                            int i2114 = ~i2016;
                            int i2115 = (i2113 - (~((~((i2114 ^ 35) | (i2114 & 35))) * (-1347)))) - 1;
                            int i2116 = ~(i2114 | 35);
                            int i2117 = ((-36) & i81) | ((-36) ^ i81);
                            int i2118 = ~((i2016 & i2117) | (i2117 ^ i2016));
                            Object[] objArr110 = new Object[1];
                            a((i2115 - (~(-(-(((i2118 & i2116) | (i2116 ^ i2118)) * 449))))) - 1, "#\t\u001d\n\u001e\u0003\u000e\u000b\u0011\f!\u0003\u0017\u000f\u000b\u0003\u001b\u001f \u0006\u0010\u0002\u001c\u0011\u001b\u001f \u0006\u0010\u0002\u001c\u0011\u001f\u0019\u001c\u0016", (byte) (67 - (~((byte) KeyEvent.getModifierMetaStateMask()))), objArr110);
                            file = new File((String) objArr110[0]);
                            if (file.canRead()) {
                                zEquals2 = false;
                            } else {
                                fileReader = new FileReader(file);
                                bufferedReader = new BufferedReader(fileReader);
                                String line5 = bufferedReader.readLine();
                                int i2119 = -(KeyEvent.getMaxKeyCode() >> 16);
                                int iComponent14 = component8T18414.AnonymousClass5.component9();
                                int i2210 = i2119 * 569;
                                int i2211 = (i2210 & 569) + (i2210 | 569);
                                int i2212 = ~i2119;
                                int i2213 = ~((i2212 & (-2)) | (i2212 ^ (-2)));
                                int i2214 = ~i2119;
                                int i2215 = ~iComponent14;
                                int i2216 = ~((i2214 ^ i2215) | (i2214 & i2215));
                                int i2217 = (i2213 ^ i2216) | (i2216 & i2213);
                                int i2218 = ~iComponent14;
                                int i2219 = ~((i6 ^ i2218) | (i6 & i2218));
                                int i2310 = -(-(((i2217 ^ i2219) | (i2219 & i2217)) * (-1136)));
                                int i2311 = (i2211 & i2310) + (i2310 | i2211);
                                int i2312 = ~((i2214 ^ iComponent14) | (i2214 & iComponent14));
                                int i2313 = ~((i6 ^ iComponent14) | (i6 & iComponent14));
                                int i2314 = (i2312 ^ i2313) | (i2312 & i2313);
                                int i2315 = (i2218 ^ i2119) | (i2218 & i2119);
                                int i2316 = ~((i2315 ^ 1) | (i2315 & 1));
                                int i2317 = i2311 + (((i2314 ^ i2316) | (i2314 & i2316)) * (-568));
                                int i2318 = ~((i2215 ^ i2119) | (i2119 & i2215));
                                int i2319 = ~((i2218 ^ 1) | (i2218 & 1));
                                int i2410 = (i2318 & i2319) | (i2318 ^ i2319);
                                int i2411 = (i2214 ^ (-2)) | (i2214 & (-2));
                                int i2412 = ~((i2411 & iComponent14) | (i2411 ^ iComponent14));
                                int i2413 = -(-(((i2410 & i2412) | (i2410 ^ i2412)) * 568));
                                int i2414 = (i2317 & i2413) + (i2413 | i2317);
                                int absoluteGravity2 = Gravity.getAbsoluteGravity(0, 0);
                                int i2415 = absoluteGravity2 * 866;
                                int i2416 = (i2415 ^ (-10368)) + ((i2415 & (-10368)) << 1);
                                int i2417 = ~((~absoluteGravity2) | i81);
                                int i2418 = ((i2417 & (-13)) | ((-13) ^ i2417)) * (-865);
                                int i2419 = (((i2416 & i2418) + (i2418 | i2416)) - (~(-(-((~((absoluteGravity2 ^ i2) | (absoluteGravity2 & i2))) * 865))))) - 1;
                                int i2510 = ~(((-13) & i81) | ((-13) ^ i81));
                                int i2511 = ~((absoluteGravity2 & i81) | (i81 ^ absoluteGravity2));
                                int i2512 = -(-(((i2511 & i2510) | (i2510 ^ i2511)) * 865));
                                Object[] objArr111 = new Object[1];
                                a(i2414, "㖷", (byte) ((i2419 & i2512) + (i2512 | i2419)), objArr111);
                                zEquals2 = line5.equals((String) objArr111[0]);
                                fileReader.close();
                                bufferedReader.close();
                                int i2513 = $component5;
                                int i2514 = (i2513 & 55) + (i2513 | 55);
                                $component9 = i2514 % 128;
                                int i2515 = i2514 % 2;
                            }
                            if (!zEquals2) {
                            }
                            i7 = 4;
                        } else {
                            i7 = 4;
                        }
                        Object[] objArr112 = new Object[i7];
                        objArr112[0] = new int[]{i2};
                        objArr112[c] = new int[]{i2};
                        objArr112[3] = new int[1];
                        objArr112[1] = th;
                        int iElapsedRealtime3 = (int) SystemClock.elapsedRealtime();
                        int i2710 = (-934432171) + ((~(iElapsedRealtime3 | 183577226)) * JfifUtil.MARKER_SOI);
                        int i2711 = ~iElapsedRealtime3;
                        int i286 = -(-(i2710 + (((-1678544994) | i2711) * (-216)) + (((~(i2711 | 183577226)) | 1727828707) * JfifUtil.MARKER_SOI)));
                        int i287 = (i3 & i286) + (i286 | i3);
                        int i288 = i287 << 13;
                        int i289 = (i288 & (~i287)) | ((~i288) & i287);
                        int i2810 = i289 ^ (i289 >>> 17);
                        int i2811 = i2810 << 5;
                        ((int[]) objArr112[3])[0] = ((~i2810) & i2811) | ((~i2811) & i2810);
                        return objArr112;
                    } catch (Throwable th5) {
                        Throwable cause = th5.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th5;
                    }
                }

                {
                    super(0);
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 51;
                char gidForName = (char) ((-1) - Process.getGidForName(""));
                int defaultSize = 1077 - View.getDefaultSize(0, 0);
                Object[] objArr3 = new Object[1];
                a((short) 0, 0, (byte) 0, objArr3);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(maximumDrawingCacheSize, gidForName, defaultSize, -438900356, false, (String) objArr3[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr2);
            int i2 = component9;
            int i3 = (i2 & 91) + (i2 | 91);
            D8871 = i3 % 128;
            if (i3 % 2 != 0) {
                return objInvoke;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final D8871<String, Throwable> component5() throws Throwable {
        int i = 2 % 2;
        try {
            Object obj = null;
            Object[] objArr = {0L, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.ah.4
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static final byte[] $$c = null;
                private static final int $$d = 0;
                private static int $10;
                private static int $11;
                private static int $component13;
                private static int $component8;
                private static short[] N14263A23323;
                private static int component5;
                private static int component9;
                private static byte[] setPivotYN16904;
                private static int vD14832N6715;

                /* JADX WARN: Code duplicated, block: B:10:0x0021  */
                /* JADX WARN: Code duplicated, block: B:8:0x001b  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0025). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$e(byte r5, int r6, short r7) {
                    /*
                        int r6 = 111 - r6
                        int r5 = r5 * 4
                        int r5 = r5 + 4
                        int r7 = r7 * 2
                        int r0 = r7 + 1
                        byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass4.$$c
                        byte[] r0 = new byte[r0]
                        r2 = 0
                        if (r1 != 0) goto L15
                        r4 = r6
                        r6 = r7
                        r3 = r2
                        goto L25
                    L15:
                        r3 = r2
                    L16:
                        byte r4 = (byte) r6
                        r0[r3] = r4
                        if (r3 != r7) goto L21
                        java.lang.String r5 = new java.lang.String
                        r5.<init>(r0, r2)
                        return r5
                    L21:
                        int r3 = r3 + 1
                        r4 = r1[r5]
                    L25:
                        int r6 = r6 + r4
                        int r5 = r5 + 1
                        goto L16
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass4.$$e(byte, int, short):java.lang.String");
                }

                /* JADX WARN: Code duplicated, block: B:10:0x0021  */
                /* JADX WARN: Code duplicated, block: B:8:0x0019  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0027). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static void b(short r7, short r8, byte r9, java.lang.Object[] r10) {
                    /*
                        int r7 = r7 + 1
                        int r9 = r9 + 68
                        byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass4.$$a
                        int r8 = r8 + 4
                        byte[] r1 = new byte[r7]
                        r2 = 0
                        if (r0 != 0) goto L11
                        r3 = r9
                        r4 = r2
                        r9 = r8
                        goto L27
                    L11:
                        r3 = r2
                    L12:
                        int r4 = r3 + 1
                        byte r5 = (byte) r9
                        r1[r3] = r5
                        if (r4 != r7) goto L21
                        java.lang.String r7 = new java.lang.String
                        r7.<init>(r1, r2)
                        r10[r2] = r7
                        return
                    L21:
                        r3 = r0[r8]
                        r6 = r9
                        r9 = r8
                        r8 = r3
                        r3 = r6
                    L27:
                        int r8 = -r8
                        int r9 = r9 + 1
                        int r3 = r3 + r8
                        int r8 = r3 + (-5)
                        r3 = r9
                        r9 = r8
                        r8 = r3
                        r3 = r4
                        goto L12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass4.b(short, short, byte, java.lang.Object[]):void");
                }

                static void init$0() {
                    $$a = new byte[]{101, Ascii.SO, 96, -49, 9, -20, Ascii.US, -30, -18, 2, -10, Ascii.SYN, 6, Ascii.CAN, -10, -8, 4, -9, 7, -5, -4, 1, -17, -6, -14};
                    $$b = 52;
                }

                static void init$1() {
                    $$c = new byte[]{78, -53, 68, 46};
                    $$d = 227;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() {
                    int i2 = 2 % 2;
                    int i3 = $component8 + 57;
                    $component13 = i3 % 128;
                    if (i3 % 2 != 0) {
                        vD14832N6715();
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }
                    String strVD14832N6715 = vD14832N6715();
                    int i4 = $component13 + 67;
                    $component8 = i4 % 128;
                    if (i4 % 2 == 0) {
                        int i5 = 48 / 0;
                    }
                    return strVD14832N6715;
                }

                public final String vD14832N6715() {
                    int i2 = 2 % 2;
                    int i3 = $component13;
                    int i4 = (i3 ^ 77) + ((i3 & 77) << 1);
                    $component8 = i4 % 128;
                    int i5 = i4 % 2;
                    ah ahVar = ah.this;
                    if (i5 != 0) {
                        int iD8871 = aa.D8871();
                        TelephonyManager telephonyManager = (TelephonyManager) ah.D8871(new Object[]{ahVar}, aa.D8871(), aa.D8871(), iD8871, -1588400053, aa.D8871(), 1588400054);
                        Intrinsics.checkNotNull(telephonyManager);
                        String networkCountryIso = telephonyManager.getNetworkCountryIso();
                        Intrinsics.checkNotNull(networkCountryIso);
                        return networkCountryIso;
                    }
                    int iD8872 = aa.D8871();
                    TelephonyManager telephonyManager2 = (TelephonyManager) ah.D8871(new Object[]{ahVar}, aa.D8871(), aa.D8871(), iD8872, -1588400053, aa.D8871(), 1588400054);
                    Intrinsics.checkNotNull(telephonyManager2);
                    Intrinsics.checkNotNull(telephonyManager2.getNetworkCountryIso());
                    Object obj2 = null;
                    obj2.hashCode();
                    throw null;
                }

                private static void a(int i2, byte b, int i3, short s, int i4, Object[] objArr2) throws Throwable {
                    char c;
                    long j;
                    int i5;
                    int i6 = 2 % 2;
                    ch chVar = new ch();
                    StringBuilder sb = new StringBuilder();
                    try {
                        Object[] objArr3 = {Integer.valueOf(i4), Integer.valueOf(vD14832N6715)};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(572769811);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 52, (char) (AndroidCharacter.getMirror('0') + 58837), 6886 - TextUtils.getCapsMode("", 0, 0), 1888911984, false, $$e((byte) 0, 0, (short) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                        }
                        int iIntValue = ((Integer) ((Method) objComponent5).invoke(null, objArr3)).intValue();
                        boolean z = iIntValue == -1;
                        char c2 = 3;
                        if (z) {
                            int i7 = $11 + 39;
                            int i8 = i7 % 128;
                            $10 = i8;
                            int i9 = i7 % 2;
                            byte[] bArr = setPivotYN16904;
                            if (bArr != null) {
                                int i10 = i8 + 3;
                                $11 = i10 % 128;
                                int i11 = i10 % 2;
                                int length = bArr.length;
                                byte[] bArr2 = new byte[length];
                                int i12 = 0;
                                while (i12 < length) {
                                    char c3 = c2;
                                    int i13 = $10 + 59;
                                    $11 = i13 % 128;
                                    if (i13 % 2 == 0) {
                                        Object[] objArr4 = {Integer.valueOf(bArr[i12])};
                                        Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1729585796);
                                        if (objComponent6 == null) {
                                            objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(KeyEvent.normalizeMetaState(0) + 58, (char) TextUtils.getOffsetBefore("", 0), ExpandableListView.getPackedPositionChild(0L) + 1540, -899819233, false, "l", new Class[]{Integer.TYPE});
                                        }
                                        bArr2[i12] = ((Byte) ((Method) objComponent6).invoke(null, objArr4)).byteValue();
                                    } else {
                                        Object[] objArr5 = {Integer.valueOf(bArr[i12])};
                                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1729585796);
                                        if (objComponent7 == null) {
                                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(58 - (Process.myTid() >> 22), (char) Color.blue(0), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1538, -899819233, false, "l", new Class[]{Integer.TYPE});
                                        }
                                        bArr2[i12] = ((Byte) ((Method) objComponent7).invoke(null, objArr5)).byteValue();
                                        i12++;
                                    }
                                    c2 = c3;
                                }
                                bArr = bArr2;
                            }
                            c = c2;
                            j = -7710232700957351395L;
                            if (bArr != null) {
                                byte[] bArr3 = setPivotYN16904;
                                Object[] objArr6 = {Integer.valueOf(i2), Integer.valueOf(component5)};
                                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(572769811);
                                if (objComponent8 == null) {
                                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getScrollDefaultDelay() >> 16) + 52, (char) (58885 - Drawable.resolveOpacity(0, 0)), 6886 - ((Process.getThreadPriority(0) + 20) >> 6), 1888911984, false, $$e((byte) 0, 0, (short) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                                }
                                iIntValue = (byte) (((byte) (((long) bArr3[((Integer) ((Method) objComponent8).invoke(null, objArr6)).intValue()]) ^ (-7710232700957351395L))) + ((int) (((long) vD14832N6715) ^ (-7710232700957351395L))));
                            } else {
                                iIntValue = (short) (((short) (((long) N14263A23323[i2 + ((int) (((long) component5) ^ (-7710232700957351395L)))]) ^ (-7710232700957351395L))) + ((int) (((long) vD14832N6715) ^ (-7710232700957351395L))));
                            }
                        } else {
                            c = 3;
                            j = -7710232700957351395L;
                        }
                        if (iIntValue > 0) {
                            int i14 = $11 + 77;
                            int i15 = i14 % 128;
                            $10 = i15;
                            int i16 = i14 % 2;
                            int i17 = ((i2 + iIntValue) - 2) + ((int) (((long) component5) ^ j));
                            if (z) {
                                int i18 = i15 + 99;
                                $11 = i18 % 128;
                                int i19 = i18 % 2;
                                i5 = 1;
                            } else {
                                i5 = 0;
                            }
                            chVar.D8871 = i17 + i5;
                            int i20 = component9;
                            Object[] objArr7 = new Object[4];
                            objArr7[c] = sb;
                            objArr7[2] = Integer.valueOf(i20);
                            objArr7[1] = Integer.valueOf(i3);
                            objArr7[0] = chVar;
                            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(74627481);
                            if (objComponent9 == null) {
                                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) Drawable.resolveOpacity(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0) + 4727, 1455947258, false, $$e((byte) 0, 1, (short) 0), new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Object.class});
                            }
                            ((StringBuilder) ((Method) objComponent9).invoke(null, objArr7)).append(chVar.vD14832N6715);
                            chVar.component9 = chVar.vD14832N6715;
                            byte[] bArr4 = setPivotYN16904;
                            if (bArr4 != null) {
                                int length2 = bArr4.length;
                                byte[] bArr5 = new byte[length2];
                                for (int i21 = 0; i21 < length2; i21++) {
                                    int i22 = $11 + 17;
                                    $10 = i22 % 128;
                                    int i23 = i22 % 2;
                                    bArr5[i21] = (byte) (((long) bArr4[i21]) ^ j);
                                }
                                bArr4 = bArr5;
                            }
                            boolean z2 = bArr4 != null;
                            chVar.setPivotYN16904 = 1;
                            while (chVar.setPivotYN16904 < iIntValue) {
                                if (z2) {
                                    byte[] bArr6 = setPivotYN16904;
                                    int i24 = chVar.D8871;
                                    chVar.D8871 = i24 - 1;
                                    chVar.vD14832N6715 = (char) (chVar.component9 + (((byte) (((byte) (((long) bArr6[i24]) ^ j)) + s)) ^ b));
                                } else {
                                    short[] sArr = N14263A23323;
                                    int i25 = chVar.D8871;
                                    chVar.D8871 = i25 - 1;
                                    chVar.vD14832N6715 = (char) (chVar.component9 + (((short) (((short) (((long) sArr[i25]) ^ j)) + s)) ^ b));
                                    int i26 = $10 + 33;
                                    $11 = i26 % 128;
                                    if (i26 % 2 == 0) {
                                        int i27 = 4 % 2;
                                    }
                                }
                                sb.append(chVar.vD14832N6715);
                                chVar.component9 = chVar.vD14832N6715;
                                chVar.setPivotYN16904++;
                            }
                        }
                        objArr2[0] = sb.toString();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }

                static {
                    init$1();
                    $10 = 0;
                    $11 = 1;
                    init$0();
                    $component13 = 0;
                    $component8 = 1;
                    component5 = 573791589;
                    vD14832N6715 = -2083118540;
                    component9 = -1766687657;
                    setPivotYN16904 = new byte[]{47, -64, 34, -43, 44, -1, -58, 105, -43, -38, 34, -43, 44, -33, -26, Ascii.EM, 40, 41, 46, -35, 37, -34, -6, Ascii.VT, -42, 40, Ascii.FF, -11, 6, -32, Ascii.CR, 9, Ascii.SO, Ascii.SI, -13, -36, 62, -4, Ascii.CR, 89, -88, 117, -117, -81, 86, -91, 67, -82, -86, -83, -84, 80, 127, 67, -111, -83, Ascii.DC2, -22, 86, 89, -95, 86, -81, 92, 101, -102, -85, -86, -83, 94, -90, 93, -86, -96, 83, -96, -17, 90, -41, -25, Ascii.DC4, Ascii.US, -28, Ascii.RS, -20, Ascii.CR, -29, Ascii.US, 41, -41, -25, -31, Ascii.RS, 35, -91, Ascii.NAK, -27, Ascii.ESC, 36, -46, -15, 17, 40, -73, 68, 79, -76, 78, PSSSigner.TRAILER_IMPLICIT, 93, -77, 79, 120, -15, -77, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS, Ascii.GS};
                }

                /* JADX WARN: Code duplicated, block: B:37:0x0751  */
                /* JADX WARN: Code duplicated, block: B:39:0x0757  */
                public static Object[] vD14832N6715(Context context, int i2, int i3, int i4) throws Throwable {
                    Object[] objArr2;
                    boolean zEquals;
                    int i5 = 2 % 2;
                    int i6 = $component8;
                    int i7 = (i6 ^ 63) + ((i6 & 63) << 1);
                    $component13 = i7 % 128;
                    int i8 = i7 % 2;
                    if (context == null) {
                        Object[] objArr3 = {new int[]{i2}, null, new int[]{i2}, new int[1]};
                        int i9 = ~i2;
                        int i10 = (-1185180579) + ((~(490623124 | i9)) * (-560)) + ((~(i2 | (-1082207306))) * (-560)) + (((~(1420782809 | i9)) | 152047620) * 560);
                        int iD8871 = aw.D8871();
                        int i11 = i10 * (-375);
                        int i12 = (i11 << 1) - i11;
                        int i13 = ~i10;
                        int i14 = ~(i13 | ((-1) ^ i13));
                        int i15 = -(-(((i14 & iD8871) | (iD8871 ^ i14) | (~i10)) * 376));
                        int i16 = ((i12 | i15) << 1) - (i15 ^ i12);
                        int i17 = ~(~iD8871);
                        int i18 = ~i10;
                        int i19 = ((i17 & i18) | (i17 ^ i18)) * (-376);
                        int i20 = ((i16 | i19) << 1) - (i19 ^ i16);
                        int i21 = -(-(i10 * 376));
                        int i22 = (i20 ^ i21) + ((i21 & i20) << 1);
                        int iD8872 = aw.D8871();
                        int i23 = i22 * 483;
                        int i24 = i4 * 242;
                        int i25 = ((i23 | i24) << 1) - (i23 ^ i24);
                        int i26 = ~i22;
                        int i27 = ~i4;
                        int i28 = ~((i26 ^ i27) | (i26 & i27));
                        int i29 = ~i22;
                        int i30 = ~iD8872;
                        int i31 = i25 + ((i28 | (~((i29 & i30) | (i29 ^ i30)))) * (-241));
                        int i32 = -(-((i22 | i4) * (-482)));
                        int i33 = i30 | i26;
                        int i34 = (((i31 | i32) << 1) - (i31 ^ i32)) + (((~((i33 & i4) | (i33 ^ i4))) | (~((i22 & i27) | (i27 ^ i22)))) * WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION);
                        int i35 = i34 << 13;
                        int i36 = (i35 & (~i34)) | ((~i35) & i34);
                        int i37 = i36 >>> 17;
                        int i38 = (i36 | i37) & (~(i36 & i37));
                        int i39 = i38 << 5;
                        ((int[]) objArr3[3])[0] = (i38 | i39) & (~(i38 & i39));
                        return objArr3;
                    }
                    int i40 = i6 - (-1);
                    $component13 = i40 % 128;
                    int i41 = i40 % 2;
                    try {
                        int iIndexOf = TextUtils.indexOf("", "");
                        int i42 = iIndexOf * (-300);
                        int i43 = (i42 ^ 54763632) + ((i42 & 54763632) << 1);
                        int i44 = (1578795144 & iIndexOf) | (iIndexOf ^ 1578795144);
                        int i45 = i43 + ((~((i44 & i2) | (i44 ^ i2))) * (-301));
                        int i46 = ~(((-1578795145) & i2) | ((-1578795145) ^ i2));
                        int i47 = ~i2;
                        int i48 = ~(i47 | iIndexOf);
                        int i49 = -(-(((i46 ^ i48) | (i46 & i48)) * (-301)));
                        int i50 = ~iIndexOf;
                        int i51 = ~((i50 & i2) | (i50 ^ i2));
                        int i52 = (((i45 & i49) + (i49 | i45)) - (~(-(-(((i51 & (-1578795145)) | ((-1578795145) ^ i51)) * 301))))) - 1;
                        int iResolveOpacity = Drawable.resolveOpacity(0, 0);
                        int i53 = iResolveOpacity * (-433);
                        int i54 = ((i53 | 10800) << 1) - (i53 ^ 10800);
                        int i55 = ~iResolveOpacity;
                        int i56 = ~((i55 ^ i47) | (i55 & i47));
                        int i57 = ~((49 ^ i2) | (49 & i2));
                        int i58 = ((i56 ^ i57) | (i57 & i56)) * JfifUtil.MARKER_EOI;
                        int i59 = ((i54 | i58) << 1) - (i58 ^ i54);
                        int i60 = ~iResolveOpacity;
                        int i61 = ((~((i60 & 49) | (i60 ^ 49))) | (~((i55 & i2) | (i55 ^ i2)))) * JfifUtil.MARKER_EOI;
                        int i62 = ((i59 | i61) << 1) - (i61 ^ i59);
                        int i63 = ~((49 ^ i47) | (49 & i47));
                        int i64 = ((i63 & iResolveOpacity) | (iResolveOpacity ^ i63)) * JfifUtil.MARKER_EOI;
                        byte b = (byte) (((i62 | i64) << 1) - (i64 ^ i62));
                        int pressedStateDuration = ViewConfiguration.getPressedStateDuration() >> 16;
                        int i65 = ((pressedStateDuration | (-358899177)) << 1) - (pressedStateDuration ^ (-358899177));
                        int i66 = -(ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1));
                        int iD8873 = aw.D8871();
                        int i67 = ~i66;
                        int i68 = (((i66 * (-496)) - 496) - (~(-(-((~((i67 ^ (-2)) | (i67 & (-2)))) * 497))))) - 1;
                        int i69 = i67 | (-2);
                        int i70 = ~((i69 ^ iD8873) | (i69 & iD8873));
                        int i71 = ~iD8873;
                        int i72 = ((-2) ^ i71) | ((-2) & i71);
                        int i73 = ~((i72 ^ i66) | (i72 & i66));
                        int i74 = (i68 - (~(((i70 ^ i73) | (i70 & i73)) * 497))) - 1;
                        int i75 = ~i66;
                        int i76 = ~((i71 & i75) | (i75 ^ i71));
                        int i77 = ~(i75 | 1);
                        int i78 = (i77 & i76) | (i76 ^ i77);
                        int i79 = (-2) | i66;
                        int i80 = ~((i79 & iD8873) | (i79 ^ iD8873));
                        Object[] objArr4 = new Object[1];
                        a(i52, b, i65, (short) ((i74 - (~(-(-(((i80 & i78) | (i78 ^ i80)) * 497))))) - 1), Process.getGidForName("") - 17, objArr4);
                        Class<?> cls = Class.forName((String) objArr4[0]);
                        int i81 = -Process.getGidForName("");
                        int i82 = i81 * 495;
                        int i83 = ((((i82 | (-956935769)) << 1) - (i82 ^ (-956935769))) - (~(-(-(((i81 ^ (-1578795166)) | (i81 & (-1578795166))) * (-988)))))) - 1;
                        int i84 = ~i81;
                        int i85 = ((i84 & 1578795165) | (i84 ^ 1578795165) | i47) * 494;
                        int i86 = ((i83 | i85) << 1) - (i85 ^ i83);
                        int i87 = ~i81;
                        int i88 = ~(((-1578795166) & i87) | (i87 ^ (-1578795166)));
                        int i89 = ~((i47 ^ 1578795165) | (i47 & 1578795165));
                        int i90 = (i88 & i89) | (i88 ^ i89);
                        int i91 = ~((i81 & 1578795165) | (i81 ^ 1578795165));
                        int i92 = -(-(((i91 & i90) | (i90 ^ i91)) * 494));
                        int i93 = (i86 & i92) + (i92 | i86);
                        byte bBlue = (byte) (Color.blue(0) - 18);
                        int iIndexOf2 = (-358899171) - TextUtils.indexOf("", "", 0, 0);
                        short sIndexOf = (short) TextUtils.indexOf("", "", 0);
                        int i94 = -(-(ViewConfiguration.getScrollBarSize() >> 8));
                        int i95 = (i94 ^ (-23)) + ((i94 & (-23)) << 1);
                        Object[] objArr5 = new Object[1];
                        a(i93, bBlue, iIndexOf2, sIndexOf, i95, objArr5);
                        Object objInvoke = cls.getMethod((String) objArr5[0], null).invoke(context, null);
                        int i96 = 1578795184 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                        int i97 = -(ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1));
                        int iD8874 = aw.D8871();
                        int i98 = i97 * 595;
                        int i99 = (i98 & (-91399)) + (i98 | (-91399));
                        int i100 = ~i97;
                        int i101 = ~(i100 | 77);
                        int i102 = ~iD8874;
                        int i103 = ~((i102 ^ 77) | (i102 & 77));
                        int i104 = i99 + (((i101 & i103) | (i101 ^ i103)) * (-1188));
                        int i105 = ~((i100 & 77) | (i100 ^ 77));
                        int i106 = ~((-78) | iD8874);
                        int i107 = (i105 & i106) | (i105 ^ i106);
                        int i108 = ~iD8874;
                        int i109 = ~((i108 ^ i97) | (i108 & i97));
                        int i110 = -(-(((i107 & i109) | (i107 ^ i109)) * 594));
                        int i111 = (i104 & i110) + (i104 | i110);
                        int i112 = -(-(((~((i97 & i102) | (i102 ^ i97))) | (~((i108 & (-78)) | ((-78) ^ i108))) | (~(((-78) & i97) | ((-78) ^ i97)))) * 594));
                        byte b2 = (byte) ((i111 & i112) + (i112 | i111));
                        int i113 = -TextUtils.indexOf("", "", 0, 0);
                        int iD8875 = aw.D8871();
                        int i114 = (i113 * 253) - 607178565;
                        int i115 = ~i113;
                        int i116 = ~((i115 & 358899176) | (i115 ^ 358899176));
                        int i117 = ~iD8875;
                        int i118 = ~((358899176 ^ i117) | (358899176 & i117));
                        int i119 = i113 | (-358899177);
                        int i120 = -(-(((i116 ^ i118) | (i116 & i118) | (~((i119 ^ iD8875) | (i119 & iD8875)))) * (-252)));
                        int i121 = ((i114 | i120) << 1) - (i114 ^ i120);
                        int i122 = (i113 ^ (-358899177)) | (i113 & (-358899177));
                        int i123 = i122 * (-252);
                        int i124 = ((i121 | i123) << 1) - (i123 ^ i121);
                        int i125 = (358899176 ^ i117) | (358899176 & i117);
                        int i126 = ~((i113 & i125) | (i125 ^ i113));
                        int i127 = ~(iD8875 | i122);
                        int i128 = -(-(((i126 & i127) | (i126 ^ i127)) * 252));
                        int i129 = ((i124 | i128) << 1) - (i124 ^ i128);
                        short s = (short) (0 - (~((byte) KeyEvent.getModifierMetaStateMask())));
                        int i130 = -(-Color.rgb(0, 0, 0));
                        int i131 = ((i130 | 16777209) << 1) - (i130 ^ 16777209);
                        Object[] objArr6 = new Object[1];
                        a(i96, b2, i129, s, i131, objArr6);
                        Class<?> cls2 = Class.forName((String) objArr6[0]);
                        int i132 = -ExpandableListView.getPackedPositionChild(0L);
                        int i133 = (i132 * (-496)) - 1398378768;
                        int i134 = ~i132;
                        int i135 = -(-((~((i134 ^ (-1578795216)) | (i134 & (-1578795216)))) * 497));
                        int i136 = (i133 & i135) + (i133 | i135);
                        int i137 = ~((i134 ^ (-1578795216)) | (i134 & (-1578795216)) | i2);
                        int i138 = ~i2;
                        int i139 = ((-1578795216) ^ i138) | ((-1578795216) & i138);
                        int i140 = ~((i139 ^ i132) | (i139 & i132));
                        int i141 = ((i137 ^ i140) | (i140 & i137)) * 497;
                        int i142 = (~((i134 ^ 1578795215) | (i134 & 1578795215))) | (~((i134 ^ i138) | (i134 & i138)));
                        int i143 = (-1578795216) | i132;
                        int i144 = ~((i143 & i2) | (i143 ^ i2));
                        int i145 = ((((i136 | i141) << 1) - (i141 ^ i136)) - (~(-(-(((i144 & i142) | (i142 ^ i144)) * 497))))) - 1;
                        int i146 = -TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                        int i147 = -(KeyEvent.getMaxKeyCode() >> 16);
                        int i148 = ~i147;
                        int i149 = ~((i148 ^ 358899171) | (i148 & 358899171));
                        int i150 = ~((358899171 ^ i2) | (358899171 & i2));
                        int i151 = (i149 ^ i150) | (i150 & i149);
                        int i152 = (i47 ^ i147) | (i47 & i147);
                        int i153 = ~((i152 ^ (-358899172)) | (i152 & (-358899172)));
                        int i154 = ((i147 * 1773) - 201812684) + (((i151 ^ i153) | (i151 & i153)) * 886);
                        int i155 = ~((i47 ^ (-358899172)) | (i47 & (-358899172)));
                        int i156 = ((i155 & i147) | (i147 ^ i155)) * (-1772);
                        int i157 = ((i154 | i156) << 1) - (i156 ^ i154);
                        int i158 = -(-((~((i138 & i147) | (i138 ^ i147))) * 886));
                        Object[] objArr7 = new Object[1];
                        a(i145, (byte) (((i146 | (-70)) << 1) - (i146 ^ (-70))), ((i157 | i158) << 1) - (i158 ^ i157), (short) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (-36) - (~(-(-TextUtils.lastIndexOf("", '0', 0)))), objArr7);
                        if ((cls2.getField((String) objArr7[0]).getInt(objInvoke) & 2) != 0) {
                            int i159 = $component8;
                            int i160 = (i159 & 29) + (i159 | 29);
                            $component13 = i160 % 128;
                            int i161 = i160 % 2;
                            objArr2 = new Object[]{new int[]{i2}, null, new int[]{i2 ^ 1}, new int[1]};
                            int iMyUid = Process.myUid();
                            int i162 = (-1005842931) + (((~((-885131788) | iMyUid)) | (-1026274147)) * (-964)) + (((~((~iMyUid) | (-885131788))) | 12584969) * (-964));
                            int iD8876 = aw.D8871();
                            int i163 = 8351 - (~(i162 * (-520)));
                            int i164 = ~iD8876;
                            int i165 = ~((i164 ^ i162) | (i164 & i162));
                            int i166 = ((i165 & 16) | (i165 ^ 16)) * (-1042);
                            int i167 = (((i163 | i166) << 1) - (i163 ^ i166)) + ((i162 | iD8876) * 521);
                            int i168 = ~((~i162) | (-17));
                            int i169 = ~((iD8876 & (-17)) | ((-17) ^ iD8876));
                            int i170 = (i169 & i168) | (i168 ^ i169);
                            int i171 = ~(i164 | 16 | i162);
                            int i172 = i167 + (((i170 & i171) | (i170 ^ i171)) * 521);
                            int iD8877 = aw.D8871();
                            int i173 = ((((i172 * 367) - (~(i4 * 367))) - 1) - (~(-(-(((i172 ^ i4) | (i172 & i4)) * (-366)))))) - 1;
                            int i174 = ((~((~i4) | iD8877)) | i172) * (-366);
                            int i175 = (i173 & i174) + (i173 | i174);
                            int i176 = ~i172;
                            int i177 = ~((i176 & i4) | (i176 ^ i4));
                            int i178 = (~i4) | i172;
                            int i179 = ~((iD8877 & i178) | (i178 ^ iD8877));
                            int i180 = ((i179 & i177) | (i177 ^ i179)) * 366;
                            int i181 = (i175 & i180) + (i180 | i175);
                            int i182 = (i181 << 13) ^ i181;
                            int i183 = i182 ^ (i182 >>> 17);
                            int i184 = i183 << 5;
                            ((int[]) objArr2[3])[0] = (i183 | i184) & (~(i183 & i184));
                            int i185 = $component13 + 21;
                            $component8 = i185 % 128;
                            int i186 = i185 % 2;
                        } else {
                            objArr2 = new Object[]{new int[]{i2}, null, new int[]{i2}, new int[1]};
                            int iMyUid2 = Process.myUid();
                            int i187 = ~iMyUid2;
                            int i188 = -(-(61611697 + (((~(1576779970 | i187)) | 334625963) * (-328)) + ((iMyUid2 | 334625963) * 164) + (((~(iMyUid2 | (-1576779971))) | 301056130 | (~(i187 | 1610349803))) * 164)));
                            int i189 = ((i4 | i188) << 1) - (i188 ^ i4);
                            int i190 = (i189 << 13) ^ i189;
                            int i191 = i190 >>> 17;
                            int i192 = (i190 | i191) & (~(i190 & i191));
                            int i193 = i192 << 5;
                            ((int[]) objArr2[3])[0] = (i192 | i193) & (~(i192 & i193));
                        }
                        if (((int[]) objArr2[2])[0] != i2) {
                            return objArr2;
                        }
                        try {
                            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1185383580);
                            if (objComponent5 == null) {
                                int i194 = (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 52;
                                char c = (char) (34442 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)));
                                int iMakeMeasureSpec = 5524 - View.MeasureSpec.makeMeasureSpec(0, 0);
                                byte[] bArr = $$a;
                                byte b3 = bArr[1];
                                byte b4 = (byte) (bArr[21] - 1);
                                Object[] objArr8 = new Object[1];
                                b(b3, b4, (byte) (b4 | 47), objArr8);
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(i194, c, iMakeMeasureSpec, -336773369, false, (String) objArr8[0], new Class[0]);
                            }
                            Set set = (Set) ((Method) objComponent5).invoke(null, null);
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1204470180);
                            if (objComponent6 == null) {
                                int defaultSize = 52 - View.getDefaultSize(0, 0);
                                char c2 = (char) (34442 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                                int pressedStateDuration2 = (ViewConfiguration.getPressedStateDuration() >> 16) + 5524;
                                byte[] bArr2 = $$a;
                                Object[] objArr9 = new Object[1];
                                b(bArr2[16], bArr2[1], (byte) (bArr2[21] - 1), objArr9);
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(defaultSize, c2, pressedStateDuration2, 360678855, false, (String) objArr9[0], null);
                            }
                            if (!set.contains(((Field) objComponent6).get(null))) {
                                int i195 = $component13;
                                int i196 = (i195 ^ 67) + ((i195 & 67) << 1);
                                $component8 = i196 % 128;
                                if (i196 % 2 == 0) {
                                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-986694391);
                                    if (objComponent7 == null) {
                                        int minimumFlingVelocity = (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 52;
                                        char c3 = (char) (34443 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)));
                                        int i197 = (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 5523;
                                        byte[] bArr3 = $$a;
                                        byte b5 = bArr3[1];
                                        byte b6 = (byte) (bArr3[21] - 1);
                                        Object[] objArr10 = new Object[1];
                                        b(b5, b6, (byte) (b6 | 47), objArr10);
                                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(minimumFlingVelocity, c3, i197, -1752860310, false, (String) objArr10[0], null);
                                    }
                                    Object obj2 = null;
                                    set.contains(((Field) objComponent7).get(null));
                                    obj2.hashCode();
                                    throw null;
                                }
                                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-986694391);
                                if (objComponent8 == null) {
                                    int iIndexOf3 = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 53;
                                    char keyRepeatTimeout = (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 34442);
                                    int i198 = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 5523;
                                    byte[] bArr4 = $$a;
                                    byte b7 = bArr4[1];
                                    byte b8 = (byte) (bArr4[21] - 1);
                                    Object[] objArr11 = new Object[1];
                                    b(b7, b8, (byte) (b8 | 47), objArr11);
                                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf3, keyRepeatTimeout, i198, -1752860310, false, (String) objArr11[0], null);
                                }
                                if (set.contains(((Field) objComponent8).get(null))) {
                                    if (Build.VERSION.SDK_INT == 30) {
                                        int i199 = $component13;
                                        int i200 = (i199 & 3) + (i199 | 3);
                                        $component8 = i200 % 128;
                                        int i201 = i200 % 2;
                                        Object[] objArr12 = {new int[]{i2}, null, new int[]{i2}, new int[1]};
                                        int iNextInt = new Random().nextInt();
                                        int i202 = (((-718936689) + (((~iNextInt) | 888161792) * 1324)) + (((~(iNextInt | 888956513)) | (~(1022449420 | iNextInt))) * (-1324))) - 769798178;
                                        int i203 = -(-(i202 * 989));
                                        int i204 = ~(((-1) ^ i202) | i202);
                                        int i205 = -(-(((i204 & i2) | (i2 ^ i204)) * 988));
                                        int i206 = ((i203 | i205) << 1) - (i203 ^ i205);
                                        int i207 = ~i202;
                                        int i208 = ~i207;
                                        int i209 = ~i47;
                                        int i210 = -(-(((i208 & i209) | (i208 ^ i209)) * (-1976)));
                                        int i211 = ~((i2 & i207) | (i207 ^ i2));
                                        int i212 = ~((i47 ^ i202) | (i47 & i202));
                                        int i213 = (i206 ^ i210) + ((i210 & i206) << 1) + (((i211 & i212) | (i211 ^ i212)) * 988);
                                        int i214 = ((i4 | i213) << 1) - (i4 ^ i213);
                                        int i215 = i214 << 13;
                                        int i216 = (i214 | i215) & (~(i214 & i215));
                                        int i217 = i216 ^ (i216 >>> 17);
                                        int i218 = i217 << 5;
                                        ((int[]) objArr12[3])[0] = ((~i217) & i218) | ((~i218) & i217);
                                        return objArr12;
                                    }
                                }
                            } else if (Build.VERSION.SDK_INT == 30) {
                                int i1910 = $component13;
                                int i2010 = (i1910 & 3) + (i1910 | 3);
                                $component8 = i2010 % 128;
                                int i2011 = i2010 % 2;
                                Object[] objArr13 = {new int[]{i2}, null, new int[]{i2}, new int[1]};
                                int iNextInt2 = new Random().nextInt();
                                int i2012 = (((-718936689) + (((~iNextInt2) | 888161792) * 1324)) + (((~(iNextInt2 | 888956513)) | (~(1022449420 | iNextInt2))) * (-1324))) - 769798178;
                                int i2013 = -(-(i2012 * 989));
                                int i2014 = ~(((-1) ^ i2012) | i2012);
                                int i2015 = -(-(((i2014 & i2) | (i2 ^ i2014)) * 988));
                                int i2016 = ((i2013 | i2015) << 1) - (i2013 ^ i2015);
                                int i2017 = ~i2012;
                                int i2018 = ~i2017;
                                int i2019 = ~i47;
                                int i219 = -(-(((i2018 & i2019) | (i2018 ^ i2019)) * (-1976)));
                                int i2110 = ~((i2 & i2017) | (i2017 ^ i2));
                                int i2111 = ~((i47 ^ i2012) | (i47 & i2012));
                                int i2112 = (i2016 ^ i219) + ((i219 & i2016) << 1) + (((i2110 & i2111) | (i2110 ^ i2111)) * 988);
                                int i2113 = ((i4 | i2112) << 1) - (i4 ^ i2112);
                                int i2114 = i2113 << 13;
                                int i2115 = (i2113 | i2114) & (~(i2113 & i2114));
                                int i2116 = i2115 ^ (i2115 >>> 17);
                                int i2117 = i2116 << 5;
                                ((int[]) objArr13[3])[0] = ((~i2116) & i2117) | ((~i2117) & i2116);
                                return objArr13;
                            }
                            if ((i3 & 32) == 0) {
                                try {
                                    if (Build.VERSION.SDK_INT > 33) {
                                        int iMyPid = Process.myPid() >> 22;
                                        int iD8878 = aw.D8871();
                                        int i220 = iMyPid * 273;
                                        int i221 = (i220 & 1643224980) + (i220 | 1643224980);
                                        int i222 = ~iMyPid;
                                        int i223 = ((-1578795221) & i222) | (i222 ^ (-1578795221));
                                        int i224 = ~iD8878;
                                        int i225 = ~((i223 & i224) | (i223 ^ i224));
                                        int i226 = iMyPid | 1578795220;
                                        int i227 = ~((i226 & iD8878) | (i226 ^ iD8878));
                                        int i228 = ((i225 & i227) | (i225 ^ i227)) * (-272);
                                        int i229 = (i221 ^ i228) + ((i228 & i221) << 1);
                                        int i230 = ~(i222 | 1578795220);
                                        int i231 = ~((i222 & iD8878) | (i222 ^ iD8878));
                                        int i232 = ((i231 & i230) | (i230 ^ i231)) * (-272);
                                        int i233 = ((i229 | i232) << 1) - (i232 ^ i229);
                                        int i234 = ~((iMyPid & iD8878) | (iMyPid ^ iD8878));
                                        int i235 = ((i234 & 1578795220) | (i234 ^ 1578795220)) * 272;
                                        int i236 = (i233 & i235) + (i235 | i233);
                                        int i237 = -(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                                        byte b9 = (byte) ((i237 ^ 4) + ((i237 & 4) << 1));
                                        int i238 = -MotionEvent.axisFromString("");
                                        int i239 = i238 * (-813);
                                        int i240 = (i239 & (-401996960)) + (i239 | (-401996960));
                                        int i241 = ~(358899227 | i238);
                                        int i242 = (i238 ^ i2) | (i238 & i2);
                                        int i243 = ~i242;
                                        int i244 = ((i241 & i243) | (i241 ^ i243)) * (-814);
                                        int i245 = (i240 ^ i244) + ((i244 & i240) << 1);
                                        int i246 = ~((358899227 & i47) | (358899227 ^ i47));
                                        int i247 = ~i238;
                                        int i248 = (i247 ^ (-358899228)) | (i247 & (-358899228));
                                        int i249 = ~i248;
                                        int i250 = (i246 & i249) | (i246 ^ i249);
                                        int i251 = ~i242;
                                        int i252 = -(-(((i250 & i251) | (i250 ^ i251)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE));
                                        int i253 = (i245 & i252) + (i252 | i245);
                                        int i254 = (~((i247 & i2) | (i247 ^ i2))) | (~i248);
                                        int i255 = ~((i2 ^ (-358899228)) | ((-358899228) & i2));
                                        int i256 = (i253 - (~(-(-(((i254 & i255) | (i254 ^ i255)) * ProxyAuthenticator.PROXY_AUTHORIZATION_REQUIRED_STATUS_CODE))))) - 1;
                                        short sResolveSizeAndState = (short) View.resolveSizeAndState(0, 0, 0);
                                        int i257 = -Color.rgb(0, 0, 0);
                                        int i258 = ((i257 | (-16777229)) << 1) - (i257 ^ (-16777229));
                                        Object[] objArr14 = new Object[1];
                                        a(i236, b9, i256, sResolveSizeAndState, i258, objArr14);
                                        try {
                                            Object[] objArr15 = {(String) objArr14[0]};
                                            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(2924635);
                                            if (objComponent9 == null) {
                                                int scrollBarSize = 52 - (ViewConfiguration.getScrollBarSize() >> 8);
                                                char mirror = (char) (59773 - AndroidCharacter.getMirror('0'));
                                                int iNormalizeMetaState = KeyEvent.normalizeMetaState(0) + 6317;
                                                byte[] bArr5 = $$a;
                                                Object[] objArr16 = new Object[1];
                                                b((byte) (bArr5[16] - 1), (byte) (-bArr5[8]), bArr5[6], objArr16);
                                                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(scrollBarSize, mirror, iNormalizeMetaState, 1385817144, false, (String) objArr16[0], new Class[]{String.class});
                                            }
                                            long jLongValue = ((Long) ((Method) objComponent9).invoke(null, objArr15)).longValue();
                                            long j = i2;
                                            long j2 = (190578164 | jLongValue) ^ (-1);
                                            long j3 = jLongValue ^ (-1);
                                            long j4 = (-117205571475L) + ((-613) * jLongValue) + ((j | j2 | ((j3 | (-190578165)) ^ (-1))) * 614);
                                            long j5 = j ^ (-1);
                                            long j6 = j4 + ((-1228) * (((190578164 | j5) ^ (-1)) | j2 | ((j5 | jLongValue) ^ (-1)))) + (614 * (((jLongValue | (j5 | (-190578165))) ^ (-1)) | (((190578164 | j3) | j5) ^ (-1)))) + 595158071;
                                            int i259 = (int) (j6 >> 32);
                                            int elapsedCpuTime = (int) Process.getElapsedCpuTime();
                                            int i260 = i259 & ((-1291472990) + (((~(1367420432 | elapsedCpuTime)) | 1350577152) * (-502)) + ((~((~elapsedCpuTime) | (-139743301))) * (-502)) + (((~(elapsedCpuTime | 1490320452)) | 1367420432) * 502));
                                            int i261 = (int) j6;
                                            int iUptimeMillis = (int) SystemClock.uptimeMillis();
                                            int i262 = i261 & (((818885255 + (((~iUptimeMillis) | 336986240) * 1324)) + (((~(iUptimeMillis | (-1774837567))) | (~(337611156 | iUptimeMillis))) * (-1324))) - 1749294642);
                                            if (((i260 & i262) | (i260 ^ i262)) == 1) {
                                                int i263 = $component13;
                                                int i264 = i263 + 59;
                                                $component8 = i264 % 128;
                                                zEquals = i264 % 2 != 0;
                                                int i265 = i263 + 75;
                                                $component8 = i265 % 128;
                                                int i266 = i265 % 2;
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
                                        int i267 = -TextUtils.indexOf((CharSequence) "", '0');
                                        int iD8879 = aw.D8871();
                                        int i268 = i267 * 829;
                                        int i269 = (i268 ^ (-1143766346)) + ((i268 & (-1143766346)) << 1);
                                        int i270 = ~((~i267) | (-1578795247));
                                        int i271 = ~iD8879;
                                        int i272 = i271 | i267;
                                        int i273 = ~((i272 & 1578795246) | (i272 ^ 1578795246));
                                        int i274 = (i269 - (~(-(-(((i270 & i273) | (i270 ^ i273)) * (-828)))))) - 1;
                                        int i275 = (i267 & 1578795246) | (i267 ^ 1578795246);
                                        int i276 = -(-(((i271 & i275) | (i275 ^ i271)) * (-828)));
                                        int i277 = (((i274 | i276) << 1) - (i276 ^ i274)) + ((~i275) * 828);
                                        int i278 = -(SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                        byte b10 = (byte) (((i278 | 84) << 1) - (i278 ^ 84));
                                        int i279 = -Color.blue(0);
                                        Object[] objArr17 = new Object[1];
                                        a(i277, b10, (i279 ^ (-358899160)) + ((i279 & (-358899160)) << 1), (short) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getTouchSlop() >> 8) - 28, objArr17);
                                        try {
                                            Object[] objArr18 = {(String) objArr17[0]};
                                            Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(1828795215);
                                            if (objComponent10 == null) {
                                                int i280 = (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 51;
                                                char cAxisFromString = (char) ((-1) - MotionEvent.axisFromString(""));
                                                int keyRepeatDelay = 6473 - (ViewConfiguration.getKeyRepeatDelay() >> 16);
                                                byte b11 = (byte) ($$a[21] - 1);
                                                byte b12 = (byte) (b11 | Ascii.NAK);
                                                Object[] objArr19 = new Object[1];
                                                b(b11, b12, (byte) (b12 | 8), objArr19);
                                                objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(i280, cAxisFromString, keyRepeatDelay, 1068791596, false, (String) objArr19[0], new Class[]{String.class});
                                            }
                                            Object objInvoke2 = ((Method) objComponent10).invoke(null, objArr18);
                                            int i281 = 1578795260 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
                                            int i282 = -(-TextUtils.lastIndexOf("", '0'));
                                            byte b13 = (byte) ((i282 ^ MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE) + ((i282 & MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE) << 1));
                                            int i283 = -ExpandableListView.getPackedPositionChild(0L);
                                            int iD88710 = aw.D8871();
                                            int i284 = (i283 * 284) - 1869633372;
                                            int i285 = ~i283;
                                            int i286 = -(-(((~(i285 | iD88710)) | (~(((-358899226) & i285) | (i285 ^ (-358899226))))) * (-283)));
                                            int i287 = ((((i284 | i286) << 1) - (i284 ^ i286)) - (~((~((358899225 & i283) | (358899225 ^ i283))) * 283))) - 1;
                                            int i288 = ~i283;
                                            int i289 = (i288 & 358899225) | (i288 ^ 358899225);
                                            int i290 = i287 + ((~((i289 & iD88710) | (i289 ^ iD88710))) * 283);
                                            short sCombineMeasuredStates = (short) View.combineMeasuredStates(0, 0);
                                            int iGreen = Color.green(0);
                                            int i291 = (iGreen & (-40)) + (iGreen | (-40));
                                            Object[] objArr20 = new Object[1];
                                            a(i281, b13, i290, sCombineMeasuredStates, i291, objArr20);
                                            zEquals = objInvoke2.equals((String) objArr20[0]);
                                            int i292 = $component8 + 11;
                                            $component13 = i292 % 128;
                                            if (i292 % 2 != 0) {
                                                int i293 = 3 % 3;
                                            }
                                        } catch (Throwable th2) {
                                            Throwable cause2 = th2.getCause();
                                            if (cause2 != null) {
                                                throw cause2;
                                            }
                                            throw th2;
                                        }
                                    }
                                } catch (Exception unused) {
                                }
                                if (zEquals) {
                                    Object[] objArr21 = {new int[]{i2}, null, new int[]{i2 ^ 10}, new int[1]};
                                    int iNextInt3 = new Random().nextInt(1569069172);
                                    int i294 = ~iNextInt3;
                                    int i295 = (((~((-1307925286) | i294)) | (~((-603480649) | iNextInt3)) | (~(i294 | 603480648))) * 959) + 786858796 + (((~(iNextInt3 | 603480648)) | (~(i294 | (-603480649))) | (~((-1307925286) | iNextInt3))) * 959);
                                    int i296 = (-2673) - (~(i295 * (-167)));
                                    int i297 = ~i295;
                                    int i298 = ~((-17) | i297);
                                    int i299 = ~(i297 | i2);
                                    int i300 = i296 + (((i298 & i299) | (i298 ^ i299)) * 336);
                                    int i301 = ~(i295 | 16);
                                    int i302 = ~((i2 & 16) | (i2 ^ 16));
                                    int i303 = ((i302 & i301) | (i301 ^ i302)) * (-168);
                                    int i304 = (i300 ^ i303) + ((i300 & i303) << 1);
                                    int i305 = ~((i47 ^ 16) | (i47 & 16));
                                    int i306 = (i304 - (~(-(-(((i305 & i297) | (i297 ^ i305)) * 168))))) - 1;
                                    int iD88711 = aw.D8871();
                                    int i307 = (i306 * 51) + (i4 * (-49));
                                    int i308 = ((i306 ^ iD88711) | (i306 & iD88711)) * (-50);
                                    int i309 = (i307 ^ i308) + ((i307 & i308) << 1);
                                    int i310 = ~i306;
                                    int i311 = ~i4;
                                    int i312 = (i310 & i311) | (i310 ^ i311);
                                    int i313 = ~((i312 & iD88711) | (i312 ^ iD88711));
                                    int i314 = ~iD88711;
                                    int i315 = i311 | i314;
                                    int i316 = i309 + ((i313 | (~((i315 & i306) | (i315 ^ i306)))) * 50);
                                    int i317 = ~((i311 ^ i314) | (i311 & i314));
                                    int i318 = ~((i311 & i306) | (i311 ^ i306));
                                    int i319 = (i317 & i318) | (i317 ^ i318);
                                    int i320 = ~((i314 & i306) | (i314 ^ i306));
                                    int i321 = -(-(((i320 & i319) | (i319 ^ i320)) * 50));
                                    int i322 = ((i316 | i321) << 1) - (i321 ^ i316);
                                    int i323 = i322 << 13;
                                    int i324 = (i323 & (~i322)) | ((~i323) & i322);
                                    int i325 = i324 >>> 17;
                                    int i326 = (i324 | i325) & (~(i324 & i325));
                                    int i327 = i326 << 5;
                                    ((int[]) objArr21[3])[0] = ((~i326) & i327) | ((~i327) & i326);
                                    return objArr21;
                                }
                            }
                            Object[] objArr22 = {new int[]{i2}, null, new int[]{i2}, new int[1]};
                            int iNextInt4 = new Random().nextInt();
                            int i328 = ~iNextInt4;
                            int i329 = (~((-1552496642) | i328)) | 1216952321 | (~(358909292 | i328));
                            int i330 = 1753305299 + (((~(iNextInt4 | (-23364973))) | i329) * 590) + (i329 * (-1180)) + (((~((-358909293) | i328)) | (~(i328 | 1552496641))) * 590);
                            int i331 = ((i330 << 1) - i330) + i4;
                            int i332 = i331 << 13;
                            int i333 = (i331 | i332) & (~(i331 & i332));
                            int i334 = i333 >>> 17;
                            int i335 = (i333 | i334) & (~(i333 & i334));
                            int i336 = i335 << 5;
                            ((int[]) objArr22[3])[0] = ((~i335) & i336) | ((~i336) & i335);
                            return objArr22;
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

                {
                    super(0);
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) + 51;
                char scrollDefaultDelay = (char) (ViewConfiguration.getScrollDefaultDelay() >> 16);
                int i2 = 1078 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                Object[] objArr2 = new Object[1];
                a((short) 0, 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(scrollBarSize, scrollDefaultDelay, i2, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            D8871<String, Throwable> d8871 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            int i3 = component9;
            int i4 = ((i3 | 73) << 1) - (i3 ^ 73);
            D8871 = i4 % 128;
            if (i4 % 2 != 0) {
                return d8871;
            }
            obj.hashCode();
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final D8871<String, Throwable> component9() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.ah.1
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static final byte[] $$c = null;
                private static final int $$d = 0;
                private static int $10;
                private static int $11;
                private static int $D8871;
                private static int $component9;
                private static char[] component5;
                private static long vD14832N6715;

                /* JADX WARN: Code duplicated, block: B:10:0x0025  */
                /* JADX WARN: Code duplicated, block: B:8:0x001f  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002d). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$e(int r6, short r7, byte r8) {
                    /*
                        int r6 = r6 * 3
                        int r6 = 101 - r6
                        int r7 = r7 * 4
                        int r0 = 1 - r7
                        byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass1.$$c
                        int r8 = r8 + 4
                        byte[] r0 = new byte[r0]
                        r2 = 0
                        int r7 = 0 - r7
                        if (r1 != 0) goto L17
                        r6 = r7
                        r3 = r8
                        r4 = r2
                        goto L2d
                    L17:
                        r3 = r2
                    L18:
                        int r8 = r8 + 1
                        byte r4 = (byte) r6
                        r0[r3] = r4
                        if (r3 != r7) goto L25
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r0, r2)
                        return r6
                    L25:
                        r4 = r1[r8]
                        int r3 = r3 + 1
                        r5 = r3
                        r3 = r8
                        r8 = r4
                        r4 = r5
                    L2d:
                        int r6 = r6 + r8
                        r8 = r3
                        r3 = r4
                        goto L18
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass1.$$e(int, short, byte):java.lang.String");
                }

                private static void b(byte b, short s, short s2, Object[] objArr2) {
                    int i2 = (s2 * 4) + 99;
                    byte[] bArr = $$a;
                    int i3 = (b * 4) + 4;
                    int i4 = s * 4;
                    byte[] bArr2 = new byte[i4 + 4];
                    int i5 = i4 + 3;
                    int i6 = -1;
                    if (bArr == null) {
                        int i7 = i5 + (-i3);
                        i3++;
                        i2 = i7 + 6;
                        i6 = -1;
                    }
                    while (true) {
                        int i8 = i6 + 1;
                        bArr2[i8] = (byte) i2;
                        if (i8 == i5) {
                            objArr2[0] = new String(bArr2, 0);
                            return;
                        }
                        int i9 = i2;
                        int i10 = i3;
                        int i11 = i9 + (-bArr[i3]);
                        i3 = i10 + 1;
                        i2 = i11 + 6;
                        i6 = i8;
                    }
                }

                static void init$0() {
                    $$a = new byte[]{65, -51, -28, -122, -6, 5, -3};
                    $$b = 13;
                }

                static void init$1() {
                    $$c = new byte[]{115, 120, 102, -31};
                    $$d = 124;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() {
                    int i2 = 2 % 2;
                    int i3 = $component9;
                    int i4 = (i3 & 47) + (i3 | 47);
                    $D8871 = i4 % 128;
                    int i5 = i4 % 2;
                    String strD8871 = D8871();
                    int i6 = $component9;
                    int i7 = ((i6 | 87) << 1) - (i6 ^ 87);
                    $D8871 = i7 % 128;
                    int i8 = i7 % 2;
                    return strD8871;
                }

                public final String D8871() {
                    int i2 = 2 % 2;
                    int i3 = $D8871;
                    int i4 = (i3 & 61) + (i3 | 61);
                    $component9 = i4 % 128;
                    int i5 = i4 % 2;
                    Object[] objArr2 = {ah.this};
                    int iD8871 = aa.D8871();
                    TelephonyManager telephonyManager = (TelephonyManager) ah.D8871(objArr2, aa.D8871(), aa.D8871(), iD8871, -1588400053, aa.D8871(), 1588400054);
                    Intrinsics.checkNotNull(telephonyManager);
                    String simCountryIso = telephonyManager.getSimCountryIso();
                    Intrinsics.checkNotNull(simCountryIso);
                    int i6 = $D8871 + 83;
                    $component9 = i6 % 128;
                    int i7 = i6 % 2;
                    return simCountryIso;
                }

                private static void a(char c, int i2, int i3, Object[] objArr2) throws Throwable {
                    char c2;
                    int i4 = 2;
                    int i5 = 2 % 2;
                    ck ckVar = new ck();
                    long[] jArr = new long[i3];
                    ckVar.setPivotYN16904 = 0;
                    while (ckVar.setPivotYN16904 < i3) {
                        int i6 = $10 + 105;
                        $11 = i6 % 128;
                        if (i6 % i4 == 0) {
                            int i7 = ckVar.setPivotYN16904;
                            try {
                                Object[] objArr3 = {Integer.valueOf(component5[i2 - i7])};
                                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                                if (objComponent5 == null) {
                                    c2 = 3;
                                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 50, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 5904, -173582907, false, $$e(0, (short) 0, (byte) -1), new Class[]{Integer.TYPE});
                                } else {
                                    c2 = 3;
                                }
                                Long l = (Long) ((Method) objComponent5).invoke(null, objArr3);
                                l.longValue();
                                int i8 = i4;
                                ck ckVar2 = ckVar;
                                long j = i7;
                                long j2 = vD14832N6715;
                                Object[] objArr4 = new Object[4];
                                objArr4[c2] = Integer.valueOf(c);
                                objArr4[i8] = Long.valueOf(j2);
                                objArr4[1] = Long.valueOf(j);
                                objArr4[0] = l;
                                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(752268889);
                                if (objComponent6 == null) {
                                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(53 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) Color.argb(0, 0, 0, 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 5058, 2120479290, false, $$e(1, (short) 0, (byte) -1), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                                }
                                jArr[i7] = ((Long) ((Method) objComponent6).invoke(null, objArr4)).longValue();
                                Object[] objArr5 = new Object[i8];
                                objArr5[1] = ckVar2;
                                objArr5[0] = ckVar2;
                                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                                if (objComponent7 == null) {
                                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(View.MeasureSpec.getMode(0) + 51, (char) TextUtils.getOffsetBefore("", 0), TextUtils.getOffsetAfter("", 0) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                                }
                                ((Method) objComponent7).invoke(null, objArr5);
                                ckVar = ckVar2;
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        } else {
                            ck ckVar3 = ckVar;
                            int i9 = ckVar3.setPivotYN16904;
                            Object[] objArr6 = {Integer.valueOf(component5[i2 + i9])};
                            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-1491988058);
                            if (objComponent8 == null) {
                                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.indexOf("", "", 0, 0), (char) (MotionEvent.axisFromString("") + 1), 5905 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), -173582907, false, $$e(0, (short) 0, (byte) -1), new Class[]{Integer.TYPE});
                            }
                            Long l2 = (Long) ((Method) objComponent8).invoke(null, objArr6);
                            l2.longValue();
                            Object[] objArr7 = {l2, Long.valueOf(i9), Long.valueOf(vD14832N6715), Integer.valueOf(c)};
                            Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(752268889);
                            if (objComponent9 == null) {
                                objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.getOffsetAfter("", 0), (char) TextUtils.getOffsetBefore("", 0), 5106 - AndroidCharacter.getMirror('0'), 2120479290, false, $$e(1, (short) 0, (byte) -1), new Class[]{Long.TYPE, Long.TYPE, Long.TYPE, Integer.TYPE});
                            }
                            jArr[i9] = ((Long) ((Method) objComponent9).invoke(null, objArr7)).longValue();
                            Object[] objArr8 = {ckVar3, ckVar3};
                            Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                            if (objComponent10 == null) {
                                objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getScrollDefaultDelay() >> 16) + 51, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 2463 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), -2019168866, false, "a", new Class[]{Object.class, Object.class});
                            }
                            ((Method) objComponent10).invoke(null, objArr8);
                            ckVar = ckVar3;
                        }
                        i4 = 2;
                    }
                    ck ckVar4 = ckVar;
                    char[] cArr = new char[i3];
                    ckVar4.setPivotYN16904 = 0;
                    while (ckVar4.setPivotYN16904 < i3) {
                        int i10 = $10 + 49;
                        $11 = i10 % 128;
                        int i11 = i10 % 2;
                        cArr[ckVar4.setPivotYN16904] = (char) jArr[ckVar4.setPivotYN16904];
                        Object[] objArr9 = {ckVar4, ckVar4};
                        Object objComponent11 = setSystemGestureExclusionRectsL30479.component5(-720328195);
                        if (objComponent11 == null) {
                            objComponent11 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.indexOf("", "", 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getJumpTapTimeout() >> 16) + 2464, -2019168866, false, "a", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent11).invoke(null, objArr9);
                        int i12 = $10 + 93;
                        $11 = i12 % 128;
                        int i13 = i12 % 2;
                    }
                    objArr2[0] = new String(cArr);
                }

                static {
                    init$1();
                    $10 = 0;
                    $11 = 1;
                    init$0();
                    $component9 = 0;
                    $D8871 = 1;
                    component5 = new char[]{34896, 37743, 48695, 55603, 58575, 4085, 10880, 13917, 20852, 31750, 34568, 41665, 52715, 59574, 62554, 8049, 14877, 17705, 24775, 24204, 17855, 26840, 4064, 12806, 55596, 64578, 57534, 34748, 43716, 20941, 29705, 6949, 15983, 8858, 51639, 60622, 37884, 33109, 39551, 46874, 53289, 60879, 1764, 9102, 16153, 22643, 29962, 36456, 44007, 50413, 57783, 64839, 5752, 58874, 65155, 54246, 46281, 35182, 25095, 18286, 23460, 15507, 4605, 60107, 53101, 40973, 34129, 39345, 29323, 22498, 10383, 3387, 58904, 64336, 57279, 45202, 38376, 28362, 17255, 9332, 14663, 7595, 63126, 52198, 44224, 33025, 39503, 32587, 21416, 13440, 2543, 58062, 50948, 20032, 21860, 30740, 24276, 17838, 26819, 4091, 12812, 55661, 64598, 57473, 34720, 43673, 20962, 29705, 6965, 15988, 8856, 51644, 60548, 37864, 46613, 23862, 16510, 25745, 2992, 12023, 54758, 63496, 40792, 33406, 42651, 19887, 28873, 24266, 24276, 17837, 26824, 4071, 12864, 55593, 64576, 57482, 34749, 43731, 20965, 29763, 6947, 15999, 8863, 51621, 60620, 37793, 46613, 23862, 16510, 25745, 3004, 11974, 54756, 63561, 40781, 33390, 42646, 19881, 28868, 6126, 14908, 8545, 50302, 59546};
                    vD14832N6715 = 3314972284736980446L;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v157, types: [java.lang.Object[]] */
                /* JADX WARN: Type inference failed for: r11v0 */
                /* JADX WARN: Type inference failed for: r11v1 */
                /* JADX WARN: Type inference failed for: r11v18 */
                /* JADX WARN: Type inference failed for: r11v2 */
                /* JADX WARN: Type inference failed for: r1v11 */
                /* JADX WARN: Type inference failed for: r25v1 */
                /* JADX WARN: Type inference failed for: r25v10 */
                /* JADX WARN: Type inference failed for: r25v11 */
                /* JADX WARN: Type inference failed for: r25v2 */
                /* JADX WARN: Type inference failed for: r25v3 */
                /* JADX WARN: Type inference failed for: r25v5 */
                /* JADX WARN: Type inference failed for: r25v7 */
                /* JADX WARN: Type inference failed for: r25v8 */
                /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
                /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
                    java.util.NoSuchElementException
                    	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
                    	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
                    	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
                    	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
                    */
                public static java.lang.Object[] setPivotYN16904(int r33, int r34) {
                    /*
                        Method dump skipped, instruction units count: 3313
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass1.setPivotYN16904(int, int):java.lang.Object[]");
                }

                {
                    super(0);
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int mode = View.MeasureSpec.getMode(0) + 51;
                char jumpTapTimeout = (char) (ViewConfiguration.getJumpTapTimeout() >> 16);
                int iResolveOpacity = Drawable.resolveOpacity(0, 0) + 1077;
                Object[] objArr2 = new Object[1];
                a((short) 0, 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(mode, jumpTapTimeout, iResolveOpacity, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            D8871<String, Throwable> d8871 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            int i2 = D8871;
            int i3 = (i2 & 35) + (i2 | 35);
            component9 = i3 % 128;
            int i4 = i3 % 2;
            return d8871;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final D8871<af, Throwable> D8871() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, new Function0<af>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.ah.5
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static int $10;
                private static int $11;
                private static int $setTopP6481;
                private static int $vD14832N6715;
                private static int D8871;
                private static long component5;
                private static char setPivotYN16904;

                /* JADX WARN: Code duplicated, block: B:10:0x0021  */
                /* JADX WARN: Code duplicated, block: B:8:0x001b  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$c(byte r6, byte r7, byte r8) {
                    /*
                        int r8 = r8 * 4
                        int r0 = r8 + 1
                        byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass5.$$a
                        int r7 = r7 + 102
                        int r6 = r6 + 4
                        byte[] r0 = new byte[r0]
                        r2 = 0
                        if (r1 != 0) goto L13
                        r4 = r7
                        r3 = r2
                        r7 = r6
                        goto L28
                    L13:
                        r3 = r2
                    L14:
                        byte r4 = (byte) r7
                        int r6 = r6 + 1
                        r0[r3] = r4
                        if (r3 != r8) goto L21
                        java.lang.String r6 = new java.lang.String
                        r6.<init>(r0, r2)
                        return r6
                    L21:
                        int r3 = r3 + 1
                        r4 = r1[r6]
                        r5 = r7
                        r7 = r6
                        r6 = r5
                    L28:
                        int r4 = -r4
                        int r6 = r6 + r4
                        r5 = r7
                        r7 = r6
                        r6 = r5
                        goto L14
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass5.$$c(byte, byte, byte):java.lang.String");
                }

                static void init$0() {
                    $$a = new byte[]{122, -2, -85, 4};
                    $$b = 14;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ af invoke() throws Exception {
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + 45;
                    $setTopP6481 = i3 % 128;
                    int i4 = i3 % 2;
                    af afVarComponent5 = component5();
                    int i5 = $vD14832N6715 + 61;
                    $setTopP6481 = i5 % 128;
                    int i6 = i5 % 2;
                    return afVarComponent5;
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0073, code lost:
                
                    if (r11 == 3) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0079, code lost:
                
                    return com.fingerprintjs.android.fpjs_pro_internal.af.component5.INSTANCE;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x007f, code lost:
                
                    throw new java.lang.Exception();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:8:0x0043, code lost:
                
                    if (r11 == 3) goto L15;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final com.fingerprintjs.android.fpjs_pro_internal.af component5() throws java.lang.Exception {
                    /*
                        r11 = this;
                        r0 = 2
                        int r1 = r0 % r0
                        int r1 = com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass5.$vD14832N6715
                        int r1 = r1 + 109
                        int r2 = r1 % 128
                        com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass5.$setTopP6481 = r2
                        int r1 = r1 % r0
                        com.fingerprintjs.android.fpjs_pro_internal.ah r11 = com.fingerprintjs.android.fpjs_pro_internal.ah.this
                        r2 = 3
                        r3 = 1
                        if (r1 != 0) goto L46
                        java.lang.Object[] r4 = new java.lang.Object[]{r11}
                        int r7 = com.fingerprintjs.android.fpjs_pro_internal.aa.D8871()
                        int r5 = com.fingerprintjs.android.fpjs_pro_internal.aa.D8871()
                        int r9 = com.fingerprintjs.android.fpjs_pro_internal.aa.D8871()
                        int r6 = com.fingerprintjs.android.fpjs_pro_internal.aa.D8871()
                        r10 = 1588400054(0x5ead0fb6, float:6.235193E18)
                        r8 = -1588400053(0xffffffffa152f04b, float:-7.1468793E-19)
                        java.lang.Object r11 = com.fingerprintjs.android.fpjs_pro_internal.ah.D8871(r4, r5, r6, r7, r8, r9, r10)
                        android.telephony.TelephonyManager r11 = (android.telephony.TelephonyManager) r11
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
                        int r11 = r11.getPhoneType()
                        r1 = 82
                        int r1 = r1 / 0
                        if (r11 == 0) goto L8a
                        if (r11 == r3) goto L85
                        if (r11 == r0) goto L80
                        if (r11 != r2) goto L7a
                        goto L75
                    L46:
                        java.lang.Object[] r4 = new java.lang.Object[]{r11}
                        int r7 = com.fingerprintjs.android.fpjs_pro_internal.aa.D8871()
                        int r5 = com.fingerprintjs.android.fpjs_pro_internal.aa.D8871()
                        int r9 = com.fingerprintjs.android.fpjs_pro_internal.aa.D8871()
                        int r6 = com.fingerprintjs.android.fpjs_pro_internal.aa.D8871()
                        r10 = 1588400054(0x5ead0fb6, float:6.235193E18)
                        r8 = -1588400053(0xffffffffa152f04b, float:-7.1468793E-19)
                        java.lang.Object r11 = com.fingerprintjs.android.fpjs_pro_internal.ah.D8871(r4, r5, r6, r7, r8, r9, r10)
                        android.telephony.TelephonyManager r11 = (android.telephony.TelephonyManager) r11
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
                        int r11 = r11.getPhoneType()
                        if (r11 == 0) goto L8a
                        if (r11 == r3) goto L85
                        if (r11 == r0) goto L80
                        if (r11 != r2) goto L7a
                    L75:
                        com.fingerprintjs.android.fpjs_pro_internal.af$component5 r11 = com.fingerprintjs.android.fpjs_pro_internal.af.component5.INSTANCE
                        com.fingerprintjs.android.fpjs_pro_internal.af r11 = (com.fingerprintjs.android.fpjs_pro_internal.af) r11
                        return r11
                    L7a:
                        java.lang.Exception r11 = new java.lang.Exception
                        r11.<init>()
                        throw r11
                    L80:
                        com.fingerprintjs.android.fpjs_pro_internal.af$D8871 r11 = com.fingerprintjs.android.fpjs_pro_internal.af.D8871.INSTANCE
                        com.fingerprintjs.android.fpjs_pro_internal.af r11 = (com.fingerprintjs.android.fpjs_pro_internal.af) r11
                        return r11
                    L85:
                        com.fingerprintjs.android.fpjs_pro_internal.af$setPivotYN16904 r11 = com.fingerprintjs.android.fpjs_pro_internal.af.setPivotYN16904.INSTANCE
                        com.fingerprintjs.android.fpjs_pro_internal.af r11 = (com.fingerprintjs.android.fpjs_pro_internal.af) r11
                        return r11
                    L8a:
                        com.fingerprintjs.android.fpjs_pro_internal.af$component9 r11 = com.fingerprintjs.android.fpjs_pro_internal.af.component9.INSTANCE
                        com.fingerprintjs.android.fpjs_pro_internal.af r11 = (com.fingerprintjs.android.fpjs_pro_internal.af) r11
                        int r1 = com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass5.$setTopP6481
                        int r1 = r1 + 105
                        int r2 = r1 % 128
                        com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass5.$vD14832N6715 = r2
                        int r1 = r1 % r0
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.ah.AnonymousClass5.component5():com.fingerprintjs.android.fpjs_pro_internal.af");
                }

                private static void a(int i2, String str, char c, String str2, String str3, Object[] objArr2) throws Throwable {
                    char[] charArray;
                    int i3 = 2;
                    int i4 = 2 % 2;
                    int i5 = $10 + 111;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    char[] charArray2 = str3 != null ? str3.toCharArray() : str3;
                    Object obj = null;
                    if (str2 != null) {
                        int i7 = $10 + 111;
                        $11 = i7 % 128;
                        if (i7 % 2 == 0) {
                            str2.toCharArray();
                            obj.hashCode();
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
                    int length2 = charArray3.length;
                    char[] cArr3 = new char[length2];
                    int i8 = 0;
                    System.arraycopy(charArray2, 0, cArr2, 0, length);
                    System.arraycopy(charArray3, 0, cArr3, 0, length2);
                    cArr2[0] = (char) (cArr2[0] ^ c);
                    cArr3[2] = (char) (cArr3[2] + ((char) i2));
                    int length3 = cArr.length;
                    char[] cArr4 = new char[length3];
                    cnVar.setPivotYN16904 = 0;
                    while (cnVar.setPivotYN16904 < length3) {
                        try {
                            Object[] objArr3 = {cnVar};
                            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(528238139);
                            if (objComponent5 == null) {
                                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(Process.getGidForName("") + 87, (char) (Color.rgb(i8, i8, i8) + 16832840), 423 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1305018968, false, "c", new Class[]{Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objComponent5).invoke(obj, objArr3)).intValue();
                            Object[] objArr4 = {cnVar};
                            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1013236775);
                            if (objComponent6 == null) {
                                int iMyTid = 52 - (Process.myTid() >> 22);
                                char c2 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 55222);
                                int offsetAfter = 3269 - TextUtils.getOffsetAfter("", i8);
                                byte b = (byte) ($$a[1] + 1);
                                byte b2 = (byte) (-b);
                                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(iMyTid, c2, offsetAfter, -1859223622, false, $$c(b, b2, (byte) (b2 - 1)), new Class[]{Object.class});
                            }
                            int iIntValue2 = ((Integer) ((Method) objComponent6).invoke(obj, objArr4)).intValue();
                            int i9 = cArr2[cnVar.setPivotYN16904 % 4] * 32718;
                            Object[] objArr5 = new Object[3];
                            objArr5[i3] = Integer.valueOf(cArr3[iIntValue]);
                            objArr5[r13] = Integer.valueOf(i9);
                            objArr5[i8] = cnVar;
                            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-523427508);
                            if (objComponent7 == null) {
                                int i10 = i8;
                                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.indexOf((CharSequence) "", '0', i10, i10), (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 42043), View.combineMeasuredStates(i10, i10) + 2308, -1300732625, false, ContextChain.TAG_INFRA, new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                            }
                            ((Method) objComponent7).invoke(null, objArr5);
                            int i11 = cArr2[iIntValue2] * 32718;
                            int i12 = i3;
                            Object[] objArr6 = new Object[i12];
                            objArr6[r13] = Integer.valueOf(cArr3[iIntValue]);
                            objArr6[0] = Integer.valueOf(i11);
                            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1175171274);
                            if (objComponent8 == null) {
                                int iAxisFromString = 51 - MotionEvent.axisFromString("");
                                char cGreen = (char) (58885 - Color.green(0));
                                int keyRepeatTimeout = (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 6886;
                                byte b3 = (byte) ($$a[1] + 1);
                                byte b4 = (byte) (b3 + 1);
                                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(iAxisFromString, cGreen, keyRepeatTimeout, 348058793, false, $$c(b3, b4, b4), new Class[]{Integer.TYPE, Integer.TYPE});
                            }
                            cArr3[iIntValue2] = ((Character) ((Method) objComponent8).invoke(null, objArr6)).charValue();
                            cArr2[iIntValue2] = cnVar.D8871;
                            cArr4[cnVar.setPivotYN16904] = (char) (((((long) (cArr2[iIntValue2] ^ cArr[cnVar.setPivotYN16904])) ^ (component5 ^ (-8233799196330309486L))) ^ ((long) ((int) (((long) D8871) ^ (-8233799196330309486L))))) ^ ((long) ((char) (((long) setPivotYN16904) ^ (-8233799196330309486L)))));
                            cnVar.setPivotYN16904++;
                            obj = null;
                            i3 = i12;
                            i8 = 0;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    objArr2[0] = new String(cArr4);
                }

                public static void vD14832N6715(long j, long j2) throws Throwable {
                    int i2 = 2 % 2;
                    int i3 = $setTopP6481 + 123;
                    $vD14832N6715 = i3 % 128;
                    int i4 = i3 % 2;
                    long j3 = j ^ (j2 << 32);
                    u.class.getField("vD14832N6715").get(null);
                    int i5 = $setTopP6481;
                    int i6 = i5 + 99;
                    $vD14832N6715 = i6 % 128;
                    int i7 = i6 % 2;
                    int i8 = i5 + 37;
                    $vD14832N6715 = i8 % 128;
                    int i9 = i8 % 2;
                    try {
                        Object[] objArr2 = {Long.valueOf(j3)};
                        Object[] objArr3 = new Object[1];
                        a(849238485 - View.getDefaultSize(0, 0), "\u0000\u0000\u0000\u0000", (char) (ViewConfiguration.getTapTimeout() >> 16), "\ue70b៑\ue0d1\ue939륊Ⅼ꿈", "햸鹙\uf532⥥", objArr3);
                        Method method = Long.class.getMethod((String) objArr3[0], Long.TYPE);
                        method.setAccessible(true);
                        Object objInvoke = method.invoke(null, objArr2);
                        Object obj = w.class.getField("INSTANCE").get(null);
                        Method method2 = w.class.getMethod("D8871", null);
                        method2.setAccessible(true);
                        Object objInvoke2 = method2.invoke(obj, null);
                        Object[] objArr4 = new Object[1];
                        a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1975994192, "\u0000\u0000\u0000\u0000", (char) (Gravity.getAbsoluteGravity(0, 0) + 63434), "丹왙䲍", "冺읇쩵忷", objArr4);
                        Object[] objArr5 = {(String) objArr4[0], objInvoke};
                        Object[] objArr6 = new Object[1];
                        a(KeyEvent.getDeadChar(0, 0) + 579003373, "\u0000\u0000\u0000\u0000", (char) (((Process.getThreadPriority(0) + 20) >> 6) + 39003), "ꎐ\uda5a竛", "\ued57苣嬢ᖘ", objArr6);
                        Method method3 = Map.class.getMethod((String) objArr6[0], Object.class, Object.class);
                        method3.setAccessible(true);
                        method3.invoke(objInvoke2, objArr5);
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
                    $vD14832N6715 = 0;
                    $setTopP6481 = 1;
                    component5 = -8233799196330309486L;
                    D8871 = 1725286546;
                    setPivotYN16904 = (char) 10615;
                }

                {
                    super(0);
                }
            }, 1, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1218204385);
            if (objComponent5 == null) {
                int iIndexOf = TextUtils.indexOf((CharSequence) "", '0') + 52;
                char offsetBefore = (char) TextUtils.getOffsetBefore("", 0);
                int defaultSize = View.getDefaultSize(0, 0) + 1077;
                Object[] objArr2 = new Object[1];
                a((short) 0, 0, (byte) 0, objArr2);
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(iIndexOf, offsetBefore, defaultSize, -438900356, false, (String) objArr2[0], new Class[]{Long.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            D8871<af, Throwable> d8871 = (D8871) ((Method) objComponent5).invoke(null, objArr);
            int i2 = D8871;
            int i3 = ((i2 | 121) << 1) - (i2 ^ 121);
            component9 = i3 % 128;
            if (i3 % 2 == 0) {
                return d8871;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static {
        init$0();
        component9 = 0;
        D8871 = 1;
    }

    public static final /* synthetic */ TelephonyManager component5(ah ahVar) {
        int iD8871 = aa.D8871();
        return (TelephonyManager) D8871(new Object[]{ahVar}, aa.D8871(), aa.D8871(), iD8871, -1588400053, aa.D8871(), 1588400054);
    }

    public final D8871<ac, Throwable> setPivotYN16904() {
        int iD8871 = aa.D8871();
        return (D8871) D8871(new Object[]{this}, aa.D8871(), aa.D8871(), iD8871, 630384798, aa.D8871(), -630384798);
    }
}
