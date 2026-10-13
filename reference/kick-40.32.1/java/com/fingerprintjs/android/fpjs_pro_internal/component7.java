package com.fingerprintjs.android.fpjs_pro_internal;

import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.compose.runtime.GapComposerKt;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class component7 implements toString {
    private static int D8871 = 1;
    private static int vD14832N6715;

    public static /* synthetic */ Object component9(int i, int i2, int i3, int i4, int i5, Object[] objArr, int i6) {
        int i7 = ~i4;
        int i8 = ~i5;
        int i9 = ~(i7 | i8);
        int i10 = i2 | i9;
        int i11 = ~i2;
        int i12 = i9 | (~(i11 | i4));
        int i13 = (~(i5 | i7 | i2)) | (~(i8 | i11 | i7));
        int i14 = i4 + i2 + i3 + ((-619979367) * i) + (68302741 * i6);
        int i15 = i14 * i14;
        int i16 = (i4 * 561304900) + 382271488 + (561304900 * i2) + ((-1585293958) * i10) + (792646979 * i12) + ((-792646979) * i13) + ((-231342080) * i3) + (1615200256 * i) + ((-1821507584) * i6) + (428933120 * i15);
        int i17 = ((i4 * (-96142684)) - 56799437) + (i2 * (-96142684)) + (i10 * 1642) + (i12 * (-821)) + (i13 * 821) + (i3 * (-96141863)) + (i * (-1380774991)) + (i6 * (-1175232947)) + (i15 * (-118947840));
        int i18 = i16 + (i17 * i17 * (-1369505792));
        if (i18 == 1) {
            return vD14832N6715(objArr);
        }
        if (i18 == 2) {
            return component9(objArr);
        }
        if (i18 != 3) {
            return i18 != 4 ? component5(objArr) : setPivotYN16904(objArr);
        }
        return D8871(objArr);
    }

    public static final /* synthetic */ setBottomR12227 setPivotYN16904(component7 component7Var) {
        int i = 2 % 2;
        int i2 = D8871;
        int i3 = ((i2 | 3) << 1) - (i2 ^ 3);
        vD14832N6715 = i3 % 128;
        int i4 = i3 % 2;
        int iVD14832N6715 = lI23295.AnonymousClass2.vD14832N6715();
        int iVD14832N6716 = lI23295.AnonymousClass2.vD14832N6715();
        setBottomR12227 setbottomr12227 = (setBottomR12227) component9(lI23295.AnonymousClass2.vD14832N6715(), 2103380573, iVD14832N6716, -2103380571, iVD14832N6715, new Object[0], lI23295.AnonymousClass2.vD14832N6715());
        int i5 = D8871;
        int i6 = ((i5 | 79) << 1) - (i5 ^ 79);
        vD14832N6715 = i6 % 128;
        int i7 = i6 % 2;
        return setbottomr12227;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.toString
    public final setBottomR12227 component9() throws Throwable {
        int i = 2 % 2;
        try {
            Object obj = null;
            Object[] objArr = {0L, false, false, new Function0<setBottomR12227>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component7.2
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static int $10;
                private static int $11;
                private static int $component9;
                private static int $vD14832N6715;
                private static int[] setPivotYN16904;

                /* JADX WARN: Code duplicated, block: B:10:0x0025  */
                /* JADX WARN: Code duplicated, block: B:8:0x001f  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0025
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                private static java.lang.String $$c(byte r5, int r6, byte r7) {
                    /*
                        int r5 = r5 * 54
                        int r5 = r5 + 68
                        int r6 = r6 * 2
                        int r6 = r6 + 1
                        int r7 = r7 * 3
                        int r7 = r7 + 4
                        byte[] r0 = com.fingerprintjs.android.fpjs_pro_internal.component7.AnonymousClass2.$$a
                        byte[] r1 = new byte[r6]
                        r2 = 0
                        if (r0 != 0) goto L17
                        r4 = r5
                        r5 = r6
                        r3 = r2
                        goto L27
                    L17:
                        r3 = r2
                    L18:
                        byte r4 = (byte) r5
                        r1[r3] = r4
                        int r3 = r3 + 1
                        if (r3 != r6) goto L25
                        java.lang.String r5 = new java.lang.String
                        r5.<init>(r1, r2)
                        return r5
                    L25:
                        r4 = r0[r7]
                    L27:
                        int r7 = r7 + 1
                        int r5 = r5 + r4
                        goto L18
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.component7.AnonymousClass2.$$c(byte, int, byte):java.lang.String");
                }

                static void init$0() {
                    $$a = new byte[]{48, -53, -22, 107};
                    $$b = 58;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ setBottomR12227 invoke() {
                    int i2 = 2 % 2;
                    int i3 = $component9 + 103;
                    $vD14832N6715 = i3 % 128;
                    int i4 = i3 % 2;
                    setBottomR12227 setbottomr12227Component9 = component9();
                    if (i4 == 0) {
                        int i5 = 90 / 0;
                    }
                    int i6 = $component9 + 7;
                    $vD14832N6715 = i6 % 128;
                    if (i6 % 2 != 0) {
                        return setbottomr12227Component9;
                    }
                    Object obj2 = null;
                    obj2.hashCode();
                    throw null;
                }

                public final setBottomR12227 component9() {
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + 1;
                    $component9 = i3 % 128;
                    int i4 = i3 % 2;
                    setBottomR12227 pivotYN16904 = component7.setPivotYN16904(component7.this);
                    int i5 = $vD14832N6715 + 55;
                    $component9 = i5 % 128;
                    if (i5 % 2 == 0) {
                        return pivotYN16904;
                    }
                    Object obj2 = null;
                    obj2.hashCode();
                    throw null;
                }

                private static void a(int[] iArr, int i2, Object[] objArr2) throws Throwable {
                    int i3;
                    int i4;
                    long j;
                    int i5 = 2;
                    int i6 = 2 % 2;
                    ci ciVar = new ci();
                    char[] cArr = new char[4];
                    char[] cArr2 = new char[iArr.length * 2];
                    int[] iArr2 = setPivotYN16904;
                    int i7 = 16;
                    if (iArr2 != null) {
                        i3 = 40761;
                        int length = iArr2.length;
                        i4 = 1299132072;
                        int[] iArr3 = new int[length];
                        int i8 = 0;
                        j = 0;
                        while (i8 < length) {
                            int i9 = $10 + 47;
                            int i10 = i5;
                            $11 = i9 % 128;
                            if (i9 % 2 == 0) {
                                try {
                                    Object[] objArr3 = {Integer.valueOf(iArr2[i8])};
                                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1299132072);
                                    if (objComponent5 == null) {
                                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf((CharSequence) "", '0', 0) + 53, (char) (40761 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), 6421 - TextUtils.indexOf("", "", 0), 534407883, false, $$c((byte) 1, 0, (byte) 0), new Class[]{Integer.TYPE});
                                    }
                                    iArr3[i8] = ((Integer) ((Method) objComponent5).invoke(null, objArr3)).intValue();
                                    i8 >>= 1;
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause == null) {
                                        throw th;
                                    }
                                    throw cause;
                                }
                            } else {
                                Object[] objArr4 = {Integer.valueOf(iArr2[i8])};
                                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1299132072);
                                if (objComponent6 == null) {
                                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - View.MeasureSpec.getSize(0), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 40761), ExpandableListView.getPackedPositionChild(0L) + 6422, 534407883, false, $$c((byte) 1, 0, (byte) 0), new Class[]{Integer.TYPE});
                                }
                                iArr3[i8] = ((Integer) ((Method) objComponent6).invoke(null, objArr4)).intValue();
                                i8++;
                            }
                            i5 = i10;
                        }
                        iArr2 = iArr3;
                    } else {
                        i3 = 40761;
                        i4 = 1299132072;
                        j = 0;
                    }
                    int i11 = i5;
                    int length2 = iArr2.length;
                    int[] iArr4 = new int[length2];
                    int[] iArr5 = setPivotYN16904;
                    if (iArr5 != null) {
                        int i12 = $11 + 79;
                        int i13 = i12 % 128;
                        $10 = i13;
                        int i14 = i12 % 2;
                        int length3 = iArr5.length;
                        int[] iArr6 = new int[length3];
                        int i15 = i13 + 65;
                        $11 = i15 % 128;
                        int i16 = i15 % 2;
                        int i17 = 0;
                        while (i17 < length3) {
                            Object[] objArr5 = {Integer.valueOf(iArr5[i17])};
                            Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(i4);
                            if (objComponent7 == null) {
                                objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.getCapsMode("", 0, 0) + 52, (char) (ExpandableListView.getPackedPositionType(j) + i3), 6421 - (KeyEvent.getMaxKeyCode() >> 16), 534407883, false, $$c((byte) 1, 0, (byte) 0), new Class[]{Integer.TYPE});
                            }
                            iArr6[i17] = ((Integer) ((Method) objComponent7).invoke(null, objArr5)).intValue();
                            i17++;
                            i7 = i7;
                        }
                        iArr5 = iArr6;
                    }
                    int i18 = i7;
                    System.arraycopy(iArr5, 0, iArr4, 0, length2);
                    ciVar.component5 = 0;
                    while (ciVar.component5 < iArr.length) {
                        int i19 = $11 + 73;
                        $10 = i19 % 128;
                        int i20 = i19 % 2;
                        cArr[0] = (char) (iArr[ciVar.component5] >> 16);
                        cArr[1] = (char) iArr[ciVar.component5];
                        cArr[i11] = (char) (iArr[ciVar.component5 + 1] >> 16);
                        char c = 3;
                        cArr[3] = (char) iArr[ciVar.component5 + 1];
                        ciVar.vD14832N6715 = (cArr[0] << 16) + cArr[1];
                        ciVar.setPivotYN16904 = (cArr[i11] << 16) + cArr[3];
                        ci.setPivotYN16904(iArr4);
                        int i21 = 0;
                        for (int i22 = i18; i21 < i22; i22 = 16) {
                            int i23 = $10 + 29;
                            $11 = i23 % 128;
                            if (i23 % 2 == 0) {
                                ciVar.vD14832N6715 ^= iArr4[i21];
                                int iD8871 = ci.D8871(ciVar.vD14832N6715);
                                Object[] objArr6 = new Object[4];
                                objArr6[c] = ciVar;
                                objArr6[i11] = ciVar;
                                objArr6[1] = Integer.valueOf(iD8871);
                                objArr6[0] = ciVar;
                                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(63485357);
                                if (objComponent8 == null) {
                                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 85, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > j ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j ? 0 : -1))), 250 - (Process.myPid() >> 22), 1367208398, false, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                                }
                                int iIntValue = ((Integer) ((Method) objComponent8).invoke(null, objArr6)).intValue();
                                ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                                ciVar.setPivotYN16904 = iIntValue;
                                i21 += 3;
                            } else {
                                c = c;
                                ciVar.vD14832N6715 ^= iArr4[i21];
                                int iD8872 = ci.D8871(ciVar.vD14832N6715);
                                Object[] objArr7 = new Object[4];
                                objArr7[c] = ciVar;
                                objArr7[i11] = ciVar;
                                objArr7[1] = Integer.valueOf(iD8872);
                                objArr7[0] = ciVar;
                                Object objComponent9 = setSystemGestureExclusionRectsL30479.component5(63485357);
                                if (objComponent9 == null) {
                                    objComponent9 = setSystemGestureExclusionRectsL30479.vD14832N6715((ExpandableListView.getPackedPositionForChild(0, 0) > j ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == j ? 0 : -1)) + 87, (char) TextUtils.getTrimmedLength(""), (KeyEvent.getMaxKeyCode() >> 16) + 250, 1367208398, false, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, new Class[]{Object.class, Integer.TYPE, Object.class, Object.class});
                                }
                                int iIntValue2 = ((Integer) ((Method) objComponent9).invoke(null, objArr7)).intValue();
                                ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                                ciVar.setPivotYN16904 = iIntValue2;
                                i21++;
                            }
                            c = c;
                        }
                        char c2 = c;
                        int i24 = ciVar.vD14832N6715;
                        ciVar.vD14832N6715 = ciVar.setPivotYN16904;
                        ciVar.setPivotYN16904 = i24;
                        ciVar.setPivotYN16904 ^= iArr4[16];
                        ciVar.vD14832N6715 ^= iArr4[17];
                        int i25 = ciVar.vD14832N6715;
                        int i26 = ciVar.setPivotYN16904;
                        cArr[0] = (char) (ciVar.vD14832N6715 >>> 16);
                        cArr[1] = (char) ciVar.vD14832N6715;
                        cArr[i11] = (char) (ciVar.setPivotYN16904 >>> 16);
                        cArr[c2] = (char) ciVar.setPivotYN16904;
                        ci.setPivotYN16904(iArr4);
                        cArr2[ciVar.component5 * 2] = cArr[0];
                        cArr2[(ciVar.component5 * 2) + 1] = cArr[1];
                        cArr2[(ciVar.component5 * 2) + 2] = cArr[i11];
                        cArr2[(ciVar.component5 * 2) + 3] = cArr[c2];
                        int i27 = i11;
                        Object[] objArr8 = new Object[i27];
                        objArr8[1] = ciVar;
                        objArr8[0] = ciVar;
                        Object objComponent10 = setSystemGestureExclusionRectsL30479.component5(743063861);
                        if (objComponent10 == null) {
                            i18 = 16;
                            objComponent10 = setSystemGestureExclusionRectsL30479.vD14832N6715(53 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) TextUtils.indexOf("", "", 0, 0), 3579 - (KeyEvent.getMaxKeyCode() >> 16), 2130642262, false, $$c((byte) 0, 0, (byte) 0), new Class[]{Object.class, Object.class});
                        } else {
                            i18 = 16;
                        }
                        ((Method) objComponent10).invoke(null, objArr8);
                        i11 = i27;
                    }
                    objArr2[0] = new String(cArr2, 0, i2);
                }

                public static void vD14832N6715(long j, long j2) throws Throwable {
                    int i2 = 2 % 2;
                    int i3 = $vD14832N6715 + 23;
                    $component9 = i3 % 128;
                    int i4 = i3 % 2;
                    long j3 = j ^ (j2 << 32);
                    u.class.getField("vD14832N6715").get(null);
                    int i5 = $component9 + 15;
                    $vD14832N6715 = i5 % 128;
                    int i6 = i5 % 2;
                    try {
                        Object[] objArr2 = {Long.valueOf(j3)};
                        Object[] objArr3 = new Object[1];
                        a(new int[]{1723731005, 514915505, -1175989867, -1721119385}, 7 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr3);
                        Method method = Long.class.getMethod((String) objArr3[0], Long.TYPE);
                        method.setAccessible(true);
                        Object objInvoke = method.invoke(null, objArr2);
                        Object obj2 = w.class.getField("INSTANCE").get(null);
                        Method method2 = w.class.getMethod("D8871", null);
                        method2.setAccessible(true);
                        Object objInvoke2 = method2.invoke(obj2, null);
                        Object[] objArr4 = new Object[1];
                        a(new int[]{1683056948, 338620686}, TextUtils.lastIndexOf("", '0') + 4, objArr4);
                        Object[] objArr5 = {(String) objArr4[0], objInvoke};
                        Object[] objArr6 = new Object[1];
                        a(new int[]{1104468506, 1633198853}, (ViewConfiguration.getFadingEdgeLength() >> 16) + 3, objArr6);
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
                    $component9 = 0;
                    $vD14832N6715 = 1;
                    setPivotYN16904 = new int[]{1461004765, -792493552, 1041369249, 878997378, 1795904673, 236152926, 619437541, 394556458, 1074248427, -354146167, -811931089, -1596493803, -454252039, -1546153681, -1360168722, -560213232, -1040516551, 1260748580};
                }

                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 51, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 1803 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            setBottomR12227.Companion companion = setBottomR12227.INSTANCE;
            setBottomR12227 pivotYN16904 = setBottomR12227.Companion.setPivotYN16904();
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = D8871;
                int i3 = ((i2 | 69) << 1) - (i2 ^ 69);
                vD14832N6715 = i3 % 128;
                if (i3 % 2 != 0) {
                    obj.hashCode();
                    throw null;
                }
                objInvoke = pivotYN16904;
            } else {
                int i4 = vD14832N6715;
                int i5 = (i4 & 75) + (i4 | 75);
                D8871 = i5 % 128;
                int i6 = i5 % 2;
            }
            setBottomR12227 setbottomr12227 = (setBottomR12227) objInvoke;
            int i7 = D8871;
            int i8 = (i7 & 41) + (i7 | 41);
            vD14832N6715 = i8 % 128;
            if (i8 % 2 != 0) {
                int i9 = 63 / 0;
            }
            return setbottomr12227;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static /* synthetic */ Object vD14832N6715(Object[] objArr) throws Throwable {
        int i = 2 % 2;
        int i2 = vD14832N6715 + 67;
        D8871 = i2 % 128;
        int i3 = i2 % 2;
        try {
            Object[] objArr2 = {0L, false, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component7.4
                private static int $D8871 = 1;
                private static int $component5 = 0;
                private static int $component9 = 0;
                private static int $vD14832N6715 = 1;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() {
                    int i4 = 2 % 2;
                    int i5 = $component5 + 33;
                    $vD14832N6715 = i5 % 128;
                    Object obj = null;
                    if (i5 % 2 == 0) {
                        component5();
                        obj.hashCode();
                        throw null;
                    }
                    String strComponent5 = component5();
                    int i6 = $component5 + 41;
                    $vD14832N6715 = i6 % 128;
                    if (i6 % 2 != 0) {
                        return strComponent5;
                    }
                    obj.hashCode();
                    throw null;
                }

                public final String component5() {
                    int i4 = 2 % 2;
                    int i5 = $vD14832N6715 + 91;
                    $component5 = i5 % 128;
                    int i6 = i5 % 2;
                    String str = Build.SUPPORTED_ABIS[0];
                    Intrinsics.checkNotNull(str);
                    int i7 = $vD14832N6715 + 91;
                    $component5 = i7 % 128;
                    int i8 = i7 % 2;
                    return str;
                }

                static {
                    int i4 = $D8871;
                    int i5 = (i4 ^ 65) + ((i4 & 65) << 1);
                    $component9 = i5 % 128;
                    int i6 = i5 % 2;
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            Object obj = "";
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(53 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getJumpTapTimeout() >> 16), 1803 - TextUtils.getOffsetBefore("", 0), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr2);
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i4 = D8871 + 13;
                vD14832N6715 = i4 % 128;
                if (i4 % 2 != 0) {
                    int i5 = 1 / 0;
                }
            } else {
                obj = objInvoke;
            }
            String str = (String) obj;
            int i6 = D8871;
            int i7 = (i6 & 83) + (i6 | 83);
            vD14832N6715 = i7 % 128;
            if (i7 % 2 != 0) {
                int i8 = 1 / 0;
            }
            return str;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:20:0x00f2 A[PHI: r0
      0x00f2: PHI (r0v10 java.lang.Object) = (r0v2 java.lang.Object), (r0v19 java.lang.Object) binds: [B:18:0x00e2, B:10:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fingerprintjs.android.fpjs_pro_internal.toString
    public final int setPivotYN16904() throws Throwable {
        Object objInvoke;
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = (i2 & 39) + (i2 | 39);
        D8871 = i3 % 128;
        Object obj = 0;
        try {
            if (i3 % 2 == 0) {
                Object[] objArr = {0L, true, true, new Function0<Integer>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component7.5
                    private static int $D8871 = 1;
                    private static int $component5 = 1;
                    private static int $setPivotYN16904;
                    private static int $vD14832N6715;

                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ Integer invoke() {
                        int i4 = 2 % 2;
                        int i5 = $D8871 + 97;
                        $vD14832N6715 = i5 % 128;
                        int i6 = i5 % 2;
                        Integer numComponent5 = component5();
                        int i7 = $D8871 + 75;
                        $vD14832N6715 = i7 % 128;
                        if (i7 % 2 == 0) {
                            return numComponent5;
                        }
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }

                    public final Integer component5() {
                        int i4 = 2 % 2;
                        int i5 = $vD14832N6715 + 51;
                        $D8871 = i5 % 128;
                        int i6 = i5 % 2;
                        Runtime runtime = Runtime.getRuntime();
                        Intrinsics.checkNotNull(runtime);
                        Integer numValueOf = Integer.valueOf(runtime.availableProcessors());
                        if (i6 == 0) {
                            int i7 = 71 / 0;
                        }
                        return numValueOf;
                    }

                    static {
                        int i4 = $component5;
                        int i5 = (i4 & 87) + (i4 | 87);
                        $setPivotYN16904 = i5 % 128;
                        int i6 = i5 % 2;
                    }
                }, 54, null};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1803, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
                }
                objInvoke = ((Method) objComponent5).invoke(null, objArr);
                if (Result.m12690isFailureimpl(objInvoke)) {
                    int i4 = D8871;
                    int i5 = (i4 ^ 11) + ((i4 & 11) << 1);
                    vD14832N6715 = i5 % 128;
                    int i6 = i5 % 2;
                } else {
                    obj = objInvoke;
                    int i7 = D8871 + 87;
                    vD14832N6715 = i7 % 128;
                    int i8 = i7 % 2;
                }
            } else {
                Object[] objArr2 = {0L, false, false, new Function0<Integer>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component7.5
                    private static int $D8871 = 1;
                    private static int $component5 = 1;
                    private static int $setPivotYN16904;
                    private static int $vD14832N6715;

                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ Integer invoke() {
                        int i9 = 2 % 2;
                        int i10 = $D8871 + 97;
                        $vD14832N6715 = i10 % 128;
                        int i11 = i10 % 2;
                        Integer numComponent5 = component5();
                        int i12 = $D8871 + 75;
                        $vD14832N6715 = i12 % 128;
                        if (i12 % 2 == 0) {
                            return numComponent5;
                        }
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }

                    public final Integer component5() {
                        int i9 = 2 % 2;
                        int i10 = $vD14832N6715 + 51;
                        $D8871 = i10 % 128;
                        int i11 = i10 % 2;
                        Runtime runtime = Runtime.getRuntime();
                        Intrinsics.checkNotNull(runtime);
                        Integer numValueOf = Integer.valueOf(runtime.availableProcessors());
                        if (i11 == 0) {
                            int i12 = 71 / 0;
                        }
                        return numValueOf;
                    }

                    static {
                        int i9 = $component5;
                        int i10 = (i9 & 87) + (i9 | 87);
                        $setPivotYN16904 = i10 % 128;
                        int i11 = i10 % 2;
                    }
                }, 7, null};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.getCapsMode("", 0, 0) + 52, (char) TextUtils.indexOf("", "", 0), 1803 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
                }
                objInvoke = ((Method) objComponent6).invoke(null, objArr2);
                if (Result.m12690isFailureimpl(objInvoke)) {
                    int i9 = D8871;
                    int i10 = (i9 ^ 11) + ((i9 & 11) << 1);
                    vD14832N6715 = i10 % 128;
                    int i11 = i10 % 2;
                } else {
                    obj = objInvoke;
                    int i12 = D8871 + 87;
                    vD14832N6715 = i12 % 128;
                    int i13 = i12 % 2;
                }
            }
            return ((Number) obj).intValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        int i = 2 % 2;
        Object obj = null;
        setBottomR12227 setbottomr12227Component9 = component9(FilesKt.readText$default(new File("/proc/cpuinfo"), null, 1, null));
        int i2 = D8871 + 99;
        vD14832N6715 = i2 % 128;
        if (i2 % 2 == 0) {
            return setbottomr12227Component9;
        }
        obj.hashCode();
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x004a A[PHI: r11
      0x004a: PHI (r11v16 java.util.List) = (r11v3 java.util.List), (r11v17 java.util.List) binds: [B:8:0x003d, B:5:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:9:0x003f A[PHI: r11
      0x003f: PHI (r11v4 java.util.List) = (r11v3 java.util.List), (r11v17 java.util.List) binds: [B:8:0x003d, B:5:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    private static /* synthetic */ Object D8871(Object[] objArr) {
        List listSplit$default;
        boolean z;
        String strSubstring;
        String strSubstring2;
        String str = (String) objArr[0];
        int i = 2 % 2;
        int i2 = D8871 + 21;
        vD14832N6715 = i2 % 128;
        String str2 = str;
        if (i2 % 2 != 0) {
            String[] strArr = new String[1];
            strArr[1] = ServerSentEventKt.COLON;
            listSplit$default = StringsKt.split$default((CharSequence) str2, strArr, true, 3, 4, (Object) null);
            if (listSplit$default.size() == 4) {
                int i3 = D8871 + 85;
                vD14832N6715 = i3 % 128;
                int i4 = i3 % 2;
                z = true;
            } else {
                z = false;
            }
        } else {
            listSplit$default = StringsKt.split$default((CharSequence) str2, new String[]{ServerSentEventKt.COLON}, false, 2, 2, (Object) null);
            if (listSplit$default.size() == 2) {
                int i5 = D8871 + 85;
                vD14832N6715 = i5 % 128;
                int i6 = i5 % 2;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            int i7 = D8871 + 21;
            vD14832N6715 = i7 % 128;
            if (i7 % 2 != 0) {
                throw null;
            }
        } else {
            int i8 = D8871;
            int i9 = (i8 ^ 99) + ((i8 & 99) << 1);
            vD14832N6715 = i9 % 128;
            int i10 = i9 % 2;
            listSplit$default = null;
        }
        if (listSplit$default == null) {
            return null;
        }
        List list = listSplit$default;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        int i11 = D8871;
        int i12 = ((i11 | 9) << 1) - (i11 ^ 9);
        vD14832N6715 = i12 % 128;
        while (true) {
            int i13 = i12 % 2;
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            int length = str3.length();
            int i14 = D8871;
            int i15 = (i14 ^ 27) + ((i14 & 27) << 1);
            vD14832N6715 = i15 % 128;
            int i16 = i15 % 2;
            int i17 = 0;
            while (true) {
                strSubstring = "";
                if (i17 >= length) {
                    strSubstring2 = "";
                    break;
                }
                if (!CharsKt.isWhitespace(str3.charAt(i17))) {
                    int i18 = vD14832N6715;
                    int i19 = (i18 ^ 13) + ((i18 & 13) << 1);
                    D8871 = i19 % 128;
                    if (i19 % 2 != 0) {
                        strSubstring2 = str3.substring(i17);
                        break;
                    }
                    strSubstring2 = str3.substring(i17);
                    int i20 = 57 / 0;
                    break;
                }
                i17++;
            }
            int lastIndex = StringsKt.getLastIndex(strSubstring2);
            while (lastIndex >= 0) {
                int i21 = vD14832N6715;
                int i22 = ((i21 | 83) << 1) - (i21 ^ 83);
                D8871 = i22 % 128;
                if (i22 % 2 == 0) {
                    int i23 = 20 / 0;
                    if (!CharsKt.isWhitespace(strSubstring2.charAt(lastIndex))) {
                        int i24 = vD14832N6715 + 7;
                        D8871 = i24 % 128;
                        int i25 = i24 % 2;
                        strSubstring = strSubstring2.substring(0, ((lastIndex | 1) << 1) - (lastIndex ^ 1));
                        break;
                    }
                    int i26 = ((lastIndex | 64) << 1) - (lastIndex ^ 64);
                    lastIndex = ((i26 | (-65)) << 1) - (i26 ^ (-65));
                } else {
                    if (!CharsKt.isWhitespace(strSubstring2.charAt(lastIndex))) {
                        int i27 = vD14832N6715 + 7;
                        D8871 = i27 % 128;
                        int i28 = i27 % 2;
                        strSubstring = strSubstring2.substring(0, ((lastIndex | 1) << 1) - (lastIndex ^ 1));
                        break;
                        break;
                    }
                    int i29 = ((lastIndex | 64) << 1) - (lastIndex ^ 64);
                    lastIndex = ((i29 | (-65)) << 1) - (i29 ^ (-65));
                }
            }
            arrayList.add(strSubstring);
            int i30 = vD14832N6715;
            i12 = (i30 & 29) + (i30 | 29);
            D8871 = i12 % 128;
        }
        ArrayList arrayList2 = arrayList;
        Pair pair = TuplesKt.to(arrayList2.get(0), arrayList2.get(1));
        int i31 = vD14832N6715;
        int i32 = (i31 ^ 119) + ((i31 & 119) << 1);
        D8871 = i32 % 128;
        if (i32 % 2 != 0) {
            return pair;
        }
        throw null;
    }

    private static /* synthetic */ Object component5(Object[] objArr) {
        Pair pair = (Pair) objArr[0];
        int i = 2 % 2;
        int i2 = vD14832N6715;
        int i3 = (i2 & 121) + (i2 | 121);
        D8871 = i3 % 128;
        if (i3 % 2 == 0) {
            Intrinsics.areEqual(pair.getFirst(), "processor");
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        if (Intrinsics.areEqual(pair.getFirst(), "processor")) {
            CharSequence charSequence = (CharSequence) pair.getSecond();
            int i4 = D8871 + 117;
            vD14832N6715 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = 0;
            while (i6 < charSequence.length()) {
                int i7 = vD14832N6715;
                int i8 = (i7 & 105) + (i7 | 105);
                D8871 = i8 % 128;
                int i9 = i8 % 2;
                if (Character.isDigit(charSequence.charAt(i6))) {
                    int i10 = i6 - 63;
                    i6 = ((i10 & 64) << 1) + (i10 ^ 64);
                    int i11 = vD14832N6715 + 79;
                    D8871 = i11 % 128;
                    int i12 = i11 % 2;
                } else {
                    int i13 = vD14832N6715;
                    int i14 = (i13 ^ 37) + ((i13 & 37) << 1);
                    D8871 = i14 % 128;
                    int i15 = i14 % 2;
                    int i16 = i13 + 7;
                    D8871 = i16 % 128;
                    int i17 = i16 % 2;
                }
            }
            int i18 = vD14832N6715;
            int i19 = (i18 ^ 103) + ((i18 & 103) << 1);
            D8871 = i19 % 128;
            int i20 = i19 % 2;
            return true;
        }
        int i21 = D8871 + 65;
        vD14832N6715 = i21 % 128;
        int i22 = i21 % 2;
        return false;
    }

    private static final List<Pair<String, String>> D8871(List<Pair<String, String>> list) {
        int i = 2 % 2;
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (Object obj : list) {
            int i2 = vD14832N6715;
            int i3 = (i2 ^ 107) + ((i2 & 107) << 1);
            D8871 = i3 % 128;
            int i4 = i3 % 2;
            if (!z) {
                int iVD14832N6715 = lI23295.AnonymousClass2.vD14832N6715();
                if (((Boolean) component9(lI23295.AnonymousClass2.vD14832N6715(), 1929462503, lI23295.AnonymousClass2.vD14832N6715(), -1929462503, iVD14832N6715, new Object[]{(Pair) obj}, lI23295.AnonymousClass2.vD14832N6715())).booleanValue()) {
                    int i5 = D8871;
                    int i6 = ((i5 | 21) << 1) - (i5 ^ 21);
                    vD14832N6715 = i6 % 128;
                    int i7 = i6 % 2;
                    int i8 = (i5 ^ 65) + ((i5 & 65) << 1);
                    vD14832N6715 = i8 % 128;
                    int i9 = i8 % 2;
                    arrayList.add(obj);
                    z = true;
                } else {
                    int i10 = D8871;
                    int i11 = ((i10 | 39) << 1) - (i10 ^ 39);
                    vD14832N6715 = i11 % 128;
                    int i12 = i11 % 2;
                    int i13 = i10 + 23;
                    vD14832N6715 = i13 % 128;
                    int i14 = i13 % 2;
                }
            } else {
                int i15 = vD14832N6715 + 17;
                D8871 = i15 % 128;
                if (i15 % 2 == 0) {
                    arrayList.add(obj);
                    throw null;
                }
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        int i16 = vD14832N6715;
        int i17 = (i16 & 37) + (i16 | 37);
        D8871 = i17 % 128;
        int i18 = i17 % 2;
        return arrayList2;
    }

    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) {
        int i = 2 % 2;
        List list = (List) objArr[0];
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            int i2 = vD14832N6715;
            int i3 = ((i2 | 101) << 1) - (i2 ^ 101);
            D8871 = i3 % 128;
            int i4 = i3 % 2;
            int iVD14832N6715 = lI23295.AnonymousClass2.vD14832N6715();
            int iVD14832N6716 = lI23295.AnonymousClass2.vD14832N6715();
            if (((Boolean) component9(lI23295.AnonymousClass2.vD14832N6715(), 1929462503, iVD14832N6716, -1929462503, iVD14832N6715, new Object[]{(Pair) obj}, lI23295.AnonymousClass2.vD14832N6715())).booleanValue()) {
                int i5 = vD14832N6715 + 111;
                D8871 = i5 % 128;
                int i6 = i5 % 2;
                break;
            }
            int i7 = vD14832N6715;
            int i8 = (i7 & 111) + (i7 | 111);
            D8871 = i8 % 128;
            if (i8 % 2 == 0) {
                break;
            }
            int i9 = (i7 & 91) + (i7 | 91);
            D8871 = i9 % 128;
            if (i9 % 2 == 0) {
                arrayList.add(obj);
                Object obj2 = null;
                obj2.hashCode();
                throw null;
            }
            arrayList.add(obj);
        }
        ArrayList arrayList2 = arrayList;
        int i10 = D8871 + 111;
        vD14832N6715 = i10 % 128;
        int i11 = i10 % 2;
        return arrayList2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0067 A[PHI: r7 r8
      0x0067: PHI (r7v46 java.lang.Object) = (r7v43 java.lang.Object), (r7v47 java.lang.Object) binds: [B:11:0x0065, B:8:0x0052] A[DONT_GENERATE, DONT_INLINE]
      0x0067: PHI (r8v4 int) = (r8v2 int), (r8v5 int) binds: [B:11:0x0065, B:8:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:78:0x02fb A[PHI: r9
      0x02fb: PHI (r9v6 java.lang.Object) = (r9v5 java.lang.Object), (r9v9 java.lang.Object) binds: [B:77:0x02f9, B:74:0x02cb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:79:0x02fd A[PHI: r9
      0x02fd: PHI (r9v8 java.lang.Object) = (r9v5 java.lang.Object), (r9v9 java.lang.Object) binds: [B:77:0x02f9, B:74:0x02cb] A[DONT_GENERATE, DONT_INLINE]] */
    private static setBottomR12227 component9(String str) {
        Object next;
        boolean z;
        Object next2;
        int i;
        int i2 = 2 % 2;
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.listOf(""), (Iterable) StringsKt.lines(str)), (Iterable) CollectionsKt.listOf(""));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
        Iterator it = listPlus.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i4 = vD14832N6715 + 21;
            D8871 = i4 % 128;
            if (i4 % 2 == 0) {
                next2 = it.next();
                i = i3 + 47;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
            } else {
                next2 = it.next();
                int i5 = (i3 & (-91)) + (i3 | (-91));
                i = ((i5 | 92) << 1) - (i5 ^ 92);
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
            }
            arrayList.add(TuplesKt.to((String) next2, Integer.valueOf(i3)));
            i3 = i;
        }
        List listFilterNotNull = CollectionsKt.filterNotNull(CollectionsKt.windowed(arrayList, 2, 1, false, new Function1<List<? extends Pair<? extends String, ? extends Integer>>, Integer>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component7.1
            private static int $D8871 = 0;
            private static int $component5 = 0;
            private static int $component9 = 1;
            private static int $vD14832N6715 = 1;

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Integer invoke(List<? extends Pair<? extends String, ? extends Integer>> list) {
                int i6 = 2 % 2;
                int i7 = $D8871 + 75;
                $component9 = i7 % 128;
                int i8 = i7 % 2;
                Integer numComponent9 = component9(list);
                int i9 = $component9;
                int i10 = (i9 & 37) + (i9 | 37);
                $D8871 = i10 % 128;
                int i11 = i10 % 2;
                return numComponent9;
            }

            public final Integer component9(List<Pair<String, Integer>> list) {
                int i6 = 2 % 2;
                System.identityHashCode(this);
                System.identityHashCode(this);
                String strComponent1 = list.get(0).component1();
                Pair<String, Integer> pair = list.get(1);
                String strComponent2 = pair.component1();
                int iIntValue = pair.component2().intValue();
                if (StringsKt.isBlank(strComponent1)) {
                    int i7 = $D8871;
                    int i8 = (i7 & 115) + (i7 | 115);
                    $component9 = i8 % 128;
                    int i9 = i8 % 2;
                    if (StringsKt.isBlank(strComponent2)) {
                        int i10 = $D8871;
                        int i11 = (i10 & 71) + (i10 | 71);
                        $component9 = i11 % 128;
                        int i12 = i11 % 2;
                        Integer numValueOf = Integer.valueOf(iIntValue);
                        int i13 = $component9 + 79;
                        $D8871 = i13 % 128;
                        int i14 = i13 % 2;
                        return numValueOf;
                    }
                }
                int i15 = $D8871 + 19;
                $component9 = i15 % 128;
                if (i15 % 2 != 0) {
                    return null;
                }
                throw null;
            }

            static {
                int i6 = $component5 + 19;
                $vD14832N6715 = i6 % 128;
                int i7 = i6 % 2;
            }
        }));
        ArrayList arrayList2 = new ArrayList();
        int i6 = 0;
        for (Object obj : listPlus) {
            int i7 = D8871;
            int i8 = ((i7 | 67) << 1) - (i7 ^ 67);
            vD14832N6715 = i8 % 128;
            int i9 = i8 % 2;
            int i10 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (!listFilterNotNull.contains(Integer.valueOf(i6))) {
                int i11 = vD14832N6715 + 23;
                D8871 = i11 % 128;
                int i12 = i11 % 2;
                arrayList2.add(obj);
            }
            i6 = i10;
        }
        final ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        int i13 = 0;
        for (Object obj2 : arrayList4) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Integer numValueOf = Integer.valueOf(i13);
            if (StringsKt.isBlank((String) obj2)) {
                int i15 = D8871 + 15;
                vD14832N6715 = i15 % 128;
                int i16 = i15 % 2;
            } else {
                numValueOf = null;
            }
            arrayList5.add(numValueOf);
            i13 = i14;
        }
        List<List> listWindowed = CollectionsKt.windowed(CollectionsKt.filterNotNull(arrayList5), 2, 1, false, new Function1<List<? extends Integer>, List<? extends String>>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.component7.3
            private static int $component5 = 1;
            private static int $component9;

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ List<? extends String> invoke(List<? extends Integer> list) {
                int i17 = 2 % 2;
                int i18 = $component9;
                int i19 = (i18 & 11) + (i18 | 11);
                $component5 = i19 % 128;
                int i20 = i19 % 2;
                List<String> listD8871 = D8871(list);
                int i21 = $component9;
                int i22 = ((i21 | 113) << 1) - (i21 ^ 113);
                $component5 = i22 % 128;
                if (i22 % 2 != 0) {
                    return listD8871;
                }
                Object obj3 = null;
                obj3.hashCode();
                throw null;
            }

            public final List<String> D8871(List<Integer> list) {
                int i17 = 2 % 2;
                List<String> list2 = arrayList3;
                int iIntValue = list.get(0).intValue();
                int iIdentityHashCode = System.identityHashCode(this);
                int i18 = -(-(iIntValue * 628));
                int i19 = (628 & i18) + (i18 | 628);
                int i20 = (iIntValue ^ iIdentityHashCode) | (iIntValue & iIdentityHashCode);
                int i21 = -(-(((i20 & (-2)) | (i20 ^ (-2))) * (-627)));
                int i22 = (i19 ^ i21) + ((i21 & i19) << 1);
                int i23 = ~iIntValue;
                int i24 = ((~((i23 & iIdentityHashCode) | (i23 ^ iIdentityHashCode))) | 1) * (-627);
                int i25 = ((i22 | i24) << 1) - (i24 ^ i22);
                int i26 = ~iIdentityHashCode;
                int i27 = ~((iIntValue & i26) | (i26 ^ iIntValue));
                int i28 = ~((iIdentityHashCode & 1) | (iIdentityHashCode ^ 1));
                int i29 = ((i28 & i27) | (i27 ^ i28)) * 627;
                List<String> listSlice = CollectionsKt.slice((List) list2, new IntRange(((i25 | i29) << 1) - (i29 ^ i25), list.get(1).intValue() - 1));
                int i30 = $component5 + 91;
                $component9 = i30 % 128;
                if (i30 % 2 == 0) {
                    return listSlice;
                }
                Object obj3 = null;
                obj3.hashCode();
                throw null;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }
        });
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listWindowed, 10));
        for (List list : listWindowed) {
            ArrayList arrayList7 = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int i17 = vD14832N6715 + 39;
                D8871 = i17 % 128;
                int i18 = i17 % 2;
                Object[] objArr = {(String) it2.next()};
                Pair pair = (Pair) component9(lI23295.AnonymousClass2.vD14832N6715(), -1974695675, lI23295.AnonymousClass2.vD14832N6715(), 1974695678, lI23295.AnonymousClass2.vD14832N6715(), objArr, lI23295.AnonymousClass2.vD14832N6715());
                if (pair != null) {
                    arrayList7.add(pair);
                }
            }
            arrayList6.add(arrayList7);
            int i19 = D8871 + 27;
            vD14832N6715 = i19 % 128;
            int i20 = i19 % 2;
        }
        ArrayList arrayList8 = new ArrayList();
        for (Object obj3 : arrayList6) {
            int i21 = D8871 + 95;
            vD14832N6715 = i21 % 128;
            int i22 = i21 % 2;
            if (!((List) obj3).isEmpty()) {
                arrayList8.add(obj3);
            }
        }
        ArrayList arrayList9 = arrayList8;
        ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
        Iterator it3 = arrayList9.iterator();
        while (it3.hasNext()) {
            int i23 = vD14832N6715;
            int i24 = ((i23 | 117) << 1) - (i23 ^ 117);
            D8871 = i24 % 128;
            if (i24 % 2 == 0) {
                arrayList10.add(D8871((List<Pair<String, String>>) it3.next()));
                int i25 = 42 / 0;
            } else {
                arrayList10.add(D8871((List<Pair<String, String>>) it3.next()));
            }
        }
        ArrayList arrayList11 = new ArrayList();
        for (Object obj4 : arrayList10) {
            if (((List) obj4).isEmpty()) {
                int i26 = D8871 + 101;
                vD14832N6715 = i26 % 128;
                int i27 = i26 % 2;
            } else {
                int i28 = vD14832N6715 + 65;
                D8871 = i28 % 128;
                int i29 = i28 % 2;
                arrayList11.add(obj4);
                int i30 = D8871;
                int i31 = (i30 ^ 99) + ((i30 & 99) << 1);
                vD14832N6715 = i31 % 128;
                int i32 = i31 % 2;
            }
        }
        ArrayList<List> arrayList12 = arrayList11;
        ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList12, 10));
        for (List list2 : arrayList12) {
            ArrayList arrayList14 = new ArrayList();
            Iterator it4 = list2.iterator();
            while (it4.hasNext()) {
                int i33 = D8871 + 19;
                vD14832N6715 = i33 % 128;
                if (i33 % 2 != 0) {
                    next = it4.next();
                    int iVD14832N6715 = lI23295.AnonymousClass2.vD14832N6715();
                    int i34 = 15 / 0;
                    if (((Boolean) component9(lI23295.AnonymousClass2.vD14832N6715(), 1929462503, lI23295.AnonymousClass2.vD14832N6715(), -1929462503, iVD14832N6715, new Object[]{(Pair) next}, lI23295.AnonymousClass2.vD14832N6715())).booleanValue()) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    next = it4.next();
                    int iVD14832N6716 = lI23295.AnonymousClass2.vD14832N6715();
                    if (((Boolean) component9(lI23295.AnonymousClass2.vD14832N6715(), 1929462503, lI23295.AnonymousClass2.vD14832N6715(), -1929462503, iVD14832N6716, new Object[]{(Pair) next}, lI23295.AnonymousClass2.vD14832N6715())).booleanValue()) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
                if (z) {
                    arrayList14.add(next);
                }
            }
            arrayList13.add(arrayList14);
        }
        ArrayList arrayList15 = arrayList13;
        ArrayList arrayList16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
        Iterator it5 = arrayList9.iterator();
        while (it5.hasNext()) {
            Object[] objArr2 = {(List) it5.next()};
            arrayList16.add((List) component9(lI23295.AnonymousClass2.vD14832N6715(), 446991701, lI23295.AnonymousClass2.vD14832N6715(), -446991697, lI23295.AnonymousClass2.vD14832N6715(), objArr2, lI23295.AnonymousClass2.vD14832N6715()));
        }
        ArrayList arrayList17 = new ArrayList();
        for (Object obj5 : arrayList16) {
            int i35 = vD14832N6715 + 45;
            D8871 = i35 % 128;
            int i36 = i35 % 2;
            if (!((List) obj5).isEmpty()) {
                int i37 = vD14832N6715 + GapComposerKt.nodeKey;
                D8871 = i37 % 128;
                int i38 = i37 % 2;
                arrayList17.add(obj5);
            }
        }
        setBottomR12227 setbottomr12227 = new setBottomR12227(CollectionsKt.flatten(arrayList17), arrayList15);
        int i39 = D8871;
        int i40 = ((i39 | 91) << 1) - (i39 ^ 91);
        vD14832N6715 = i40 % 128;
        int i41 = i40 % 2;
        return setbottomr12227;
    }

    private static final List<Pair<String, String>> setPivotYN16904(List<Pair<String, String>> list) {
        int iVD14832N6715 = lI23295.AnonymousClass2.vD14832N6715();
        int iVD14832N6716 = lI23295.AnonymousClass2.vD14832N6715();
        return (List) component9(lI23295.AnonymousClass2.vD14832N6715(), 446991701, iVD14832N6716, -446991697, iVD14832N6715, new Object[]{list}, lI23295.AnonymousClass2.vD14832N6715());
    }

    private static final boolean D8871(Pair<String, String> pair) {
        int iVD14832N6715 = lI23295.AnonymousClass2.vD14832N6715();
        int iVD14832N6716 = lI23295.AnonymousClass2.vD14832N6715();
        return ((Boolean) component9(lI23295.AnonymousClass2.vD14832N6715(), 1929462503, iVD14832N6716, -1929462503, iVD14832N6715, new Object[]{pair}, lI23295.AnonymousClass2.vD14832N6715())).booleanValue();
    }

    private static final Pair<String, String> D8871(String str) {
        int iVD14832N6715 = lI23295.AnonymousClass2.vD14832N6715();
        int iVD14832N6716 = lI23295.AnonymousClass2.vD14832N6715();
        return (Pair) component9(lI23295.AnonymousClass2.vD14832N6715(), -1974695675, iVD14832N6716, 1974695678, iVD14832N6715, new Object[]{str}, lI23295.AnonymousClass2.vD14832N6715());
    }

    private static setBottomR12227 component5() {
        int iVD14832N6715 = lI23295.AnonymousClass2.vD14832N6715();
        int iVD14832N6716 = lI23295.AnonymousClass2.vD14832N6715();
        return (setBottomR12227) component9(lI23295.AnonymousClass2.vD14832N6715(), 2103380573, iVD14832N6716, -2103380571, iVD14832N6715, new Object[0], lI23295.AnonymousClass2.vD14832N6715());
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.toString
    public final String vD14832N6715() {
        int iVD14832N6715 = lI23295.AnonymousClass2.vD14832N6715();
        int iVD14832N6716 = lI23295.AnonymousClass2.vD14832N6715();
        return (String) component9(lI23295.AnonymousClass2.vD14832N6715(), -1120452507, iVD14832N6716, 1120452508, iVD14832N6715, new Object[]{this}, lI23295.AnonymousClass2.vD14832N6715());
    }
}
