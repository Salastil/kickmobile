package com.fingerprintjs.android.fpjs_pro_internal;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class B9336 implements component7X12099 {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static int component9;
    private static int setPivotYN16904;
    private static char[] vD14832N6715;
    private final ActivityManager component5;

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0022
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(int r5, int r6, int r7) {
        /*
            int r5 = r5 * 3
            int r5 = 4 - r5
            int r6 = r6 + 112
            int r7 = r7 * 4
            int r0 = 1 - r7
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.B9336.$$a
            byte[] r0 = new byte[r0]
            r2 = 0
            int r7 = 0 - r7
            if (r1 != 0) goto L16
            r4 = r5
            r3 = r2
            goto L26
        L16:
            r3 = r2
        L17:
            byte r4 = (byte) r6
            r0[r3] = r4
            if (r3 != r7) goto L22
            java.lang.String r5 = new java.lang.String
            r5.<init>(r0, r2)
            return r5
        L22:
            int r3 = r3 + 1
            r4 = r1[r5]
        L26:
            int r5 = r5 + 1
            int r6 = r6 + r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.B9336.$$c(int, int, int):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{104, 70, -12, 62};
        $$b = 75;
    }

    public B9336(ActivityManager activityManager) {
        this.component5 = activityManager;
    }

    public static final /* synthetic */ ActivityManager vD14832N6715(B9336 b9336) {
        int i = 2 % 2;
        int i2 = component9 + 57;
        int i3 = i2 % 128;
        setPivotYN16904 = i3;
        int i4 = i2 % 2;
        ActivityManager activityManager = b9336.component5;
        int i5 = i3 + 33;
        component9 = i5 % 128;
        if (i5 % 2 != 0) {
            return activityManager;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.component7X12099
    public final String component5() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.B9336.1
                private static int $D8871 = 1;
                private static int $component9;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() {
                    int i2 = 2 % 2;
                    int i3 = $component9 + 95;
                    $D8871 = i3 % 128;
                    int i4 = i3 % 2;
                    String strD8871 = D8871();
                    if (i4 == 0) {
                        int i5 = 13 / 0;
                    }
                    return strD8871;
                }

                public final String D8871() {
                    int i2 = 2 % 2;
                    int i3 = $component9 + 35;
                    $D8871 = i3 % 128;
                    int i4 = i3 % 2;
                    ActivityManager activityManagerVD14832N6715 = B9336.vD14832N6715(B9336.this);
                    Intrinsics.checkNotNull(activityManagerVD14832N6715);
                    ConfigurationInfo deviceConfigurationInfo = activityManagerVD14832N6715.getDeviceConfigurationInfo();
                    Intrinsics.checkNotNull(deviceConfigurationInfo);
                    String glEsVersion = deviceConfigurationInfo.getGlEsVersion();
                    Intrinsics.checkNotNull(glEsVersion);
                    int i5 = $component9 + 83;
                    $D8871 = i5 % 128;
                    if (i5 % 2 == 0) {
                        int i6 = 27 / 0;
                    }
                    return glEsVersion;
                }

                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            Object obj = "";
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1803, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = setPivotYN16904 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                component9 = i2 % 128;
                int i3 = i2 % 2;
            } else {
                obj = objInvoke;
            }
            String str = (String) obj;
            int i4 = setPivotYN16904 + 25;
            component9 = i4 % 128;
            int i5 = i4 % 2;
            return str;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static void a(boolean z, String str, int[] iArr, Object[] objArr) throws Throwable {
        int i;
        long j;
        String str2 = str;
        int i2 = 2;
        int i3 = 2 % 2;
        int i4 = $10;
        int i5 = i4 + 35;
        $11 = i5 % 128;
        int i6 = i5 % 2;
        Object bytes = str2;
        if (str2 != null) {
            int i7 = i4 + 27;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            bytes = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        co coVar = new co();
        int i9 = iArr[0];
        byte b = 1;
        int i10 = iArr[1];
        int i11 = iArr[2];
        int i12 = iArr[3];
        char[] cArr = vD14832N6715;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i13 = 0;
            j = 0;
            while (i13 < length) {
                int i14 = $11 + 107;
                int i15 = i2;
                $10 = i14 % 128;
                int i16 = i14 % 2;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr[i13])};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1270499692);
                    if (objComponent5 == null) {
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(ExpandableListView.getPackedPositionChild(0L) + 60, (char) View.resolveSize(0, 0), (-16772759) - Color.rgb(0, 0, 0), 420416783, false, $$c(0, 3, 0), new Class[]{Integer.TYPE});
                    }
                    cArr2[i13] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    i13++;
                    i2 = i15;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            i = i2;
            int i17 = $11 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
            $10 = i17 % 128;
            int i18 = i17 % 2;
            cArr = cArr2;
        } else {
            i = 2;
            j = 0;
        }
        char[] cArr3 = new char[i10];
        System.arraycopy(cArr, i9, cArr3, 0, i10);
        if (bArr != null) {
            char[] cArr4 = new char[i10];
            coVar.component5 = 0;
            char c = 0;
            while (coVar.component5 < i10) {
                if (bArr[coVar.component5] == b) {
                    int i19 = coVar.component5;
                    char c2 = cArr3[coVar.component5];
                    Object[] objArr3 = new Object[i];
                    objArr3[b] = Integer.valueOf(c);
                    objArr3[0] = Integer.valueOf(c2);
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1589966753);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.getOffsetAfter("", 0) + 52, (char) (TextUtils.getOffsetBefore("", 0) + 15379), 2256 - Color.green(0), -208778180, false, "q", new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i19] = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
                } else {
                    b = b;
                    int i20 = coVar.component5;
                    char c3 = cArr3[coVar.component5];
                    Object[] objArr4 = new Object[2];
                    objArr4[b] = Integer.valueOf(c);
                    objArr4[0] = Integer.valueOf(c3);
                    Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-1656784792);
                    if (objComponent7 == null) {
                        objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(50 - ImageFormat.getBitsPerPixel(0), (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 27302), (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) + 2978, -813024245, false, $$c(0, 0, 0), new Class[]{Integer.TYPE, Integer.TYPE});
                    }
                    cArr4[i20] = ((Character) ((Method) objComponent7).invoke(null, objArr4)).charValue();
                }
                c = cArr4[coVar.component5];
                Object[] objArr5 = new Object[2];
                objArr5[b] = coVar;
                objArr5[0] = coVar;
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(787585964);
                if (objComponent8 == null) {
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - (ViewConfiguration.getTouchSlop() >> 8), (char) (TextUtils.lastIndexOf("", '0') + 1), (ViewConfiguration.getEdgeSlop() >> 16) + 7092, 2084888527, false, $$c(0, 7, 0), new Class[]{Object.class, Object.class});
                }
                ((Method) objComponent8).invoke(null, objArr5);
                b = b;
                i = 2;
            }
            cArr3 = cArr4;
        }
        if (i12 > 0) {
            char[] cArr5 = new char[i10];
            System.arraycopy(cArr3, 0, cArr5, 0, i10);
            int i21 = i10 - i12;
            System.arraycopy(cArr5, 0, cArr3, i21, i12);
            System.arraycopy(cArr5, i12, cArr3, 0, i21);
        }
        if (z) {
            char[] cArr6 = new char[i10];
            coVar.component5 = 0;
            while (coVar.component5 < i10) {
                cArr6[coVar.component5] = cArr3[(i10 - coVar.component5) - 1];
                coVar.component5++;
            }
            cArr3 = cArr6;
        }
        if (i11 > 0) {
            int i22 = $11 + 31;
            $10 = i22 % 128;
            int i23 = i22 % 2;
            coVar.component5 = 0;
            while (coVar.component5 < i10) {
                cArr3[coVar.component5] = (char) (cArr3[coVar.component5] - iArr[2]);
                coVar.component5++;
            }
        }
        objArr[0] = new String(cArr3);
    }

    public static void component5(long j, long j2) throws Throwable {
        int i = 2 % 2;
        int i2 = setPivotYN16904 + 95;
        component9 = i2 % 128;
        int i3 = i2 % 2;
        long j3 = j ^ (j2 << 32);
        u.class.getField("vD14832N6715").get(null);
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a(true, "\u0001\u0001\u0000\u0001\u0000\u0000\u0001", new int[]{0, 7, 0, 2}, objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a(true, "\u0000\u0000\u0000", new int[]{7, 3, 121, 0}, objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a(false, "\u0000\u0000\u0001", new int[]{10, 3, 0, 1}, objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
            int i4 = setPivotYN16904 + 3;
            component9 = i4 % 128;
            int i5 = i4 % 2;
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
        setPivotYN16904 = 0;
        component9 = 1;
        vD14832N6715 = new char[]{46610, 46665, 46668, 46712, 46712, 46671, 46674, 46715, 46739, 46735, 46616, 46672, 46672};
    }
}
