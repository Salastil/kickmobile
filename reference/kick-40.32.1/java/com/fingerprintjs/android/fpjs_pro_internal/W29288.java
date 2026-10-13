package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.lang.reflect.Method;
import java.util.Random;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class W29288 implements U18116 {
    private static int D8871 = 1;
    private static int component5;
    public static int setPivotYN16904;
    public static int vD14832N6715;

    /* JADX WARN: Code duplicated, block: B:19:0x00df  */
    /* JADX WARN: Code duplicated, block: B:20:0x00e9 A[PHI: r1
      0x00e9: PHI (r1v22 java.lang.Object) = (r1v9 java.lang.Object), (r1v30 java.lang.Object) binds: [B:18:0x00dd, B:10:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x00f9  */
    @Override // com.fingerprintjs.android.fpjs_pro_internal.U18116
    public final String component5() throws Throwable {
        Object objInvoke;
        int i;
        int i2 = 2 % 2;
        int i3 = D8871;
        int i4 = (i3 & 87) + (i3 | 87);
        component5 = i4 % 128;
        Object obj = "";
        try {
            if (i4 % 2 != 0) {
                Object[] objArr = {0L, true, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.W29288.1
                    private static int $component5 = 1;
                    private static int $component9 = 1;
                    private static int $setPivotYN16904;
                    private static int $vD14832N6715;

                    public final String component5() {
                        int i5 = 2 % 2;
                        int i6 = $vD14832N6715;
                        int i7 = (i6 & 67) + (i6 | 67);
                        $component5 = i7 % 128;
                        int i8 = i7 % 2;
                        String str = Build.MODEL;
                        Intrinsics.checkNotNull(str);
                        if (i8 != 0) {
                            return str;
                        }
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ String invoke() {
                        int i5 = 2 % 2;
                        int i6 = $component5;
                        int i7 = (i6 ^ 63) + ((i6 & 63) << 1);
                        $vD14832N6715 = i7 % 128;
                        if (i7 % 2 != 0) {
                            component5();
                            throw null;
                        }
                        String strComponent5 = component5();
                        int i8 = $component5;
                        int i9 = (i8 & 13) + (i8 | 13);
                        $vD14832N6715 = i9 % 128;
                        int i10 = i9 % 2;
                        return strComponent5;
                    }

                    static {
                        int i5 = $setPivotYN16904;
                        int i6 = ((i5 | 83) << 1) - (i5 ^ 83);
                        $component9 = i6 % 128;
                        int i7 = i6 % 2;
                    }
                }, 74, null};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.getOffsetAfter("", 0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), (ViewConfiguration.getEdgeSlop() >> 16) + 1803, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
                }
                objInvoke = ((Method) objComponent5).invoke(null, objArr);
                if (Result.m12690isFailureimpl(objInvoke)) {
                    int i5 = component5 + 65;
                    D8871 = i5 % 128;
                    int i6 = i5 % 2;
                } else {
                    obj = objInvoke;
                    int i7 = D8871;
                    i = ((i7 | 83) << 1) - (i7 ^ 83);
                    component5 = i % 128;
                    if (i % 2 != 0) {
                        int i8 = 2 % 5;
                    }
                }
            } else {
                Object[] objArr2 = {0L, false, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.W29288.1
                    private static int $component5 = 1;
                    private static int $component9 = 1;
                    private static int $setPivotYN16904;
                    private static int $vD14832N6715;

                    public final String component5() {
                        int i9 = 2 % 2;
                        int i10 = $vD14832N6715;
                        int i11 = (i10 & 67) + (i10 | 67);
                        $component5 = i11 % 128;
                        int i12 = i11 % 2;
                        String str = Build.MODEL;
                        Intrinsics.checkNotNull(str);
                        if (i12 != 0) {
                            return str;
                        }
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ String invoke() {
                        int i9 = 2 % 2;
                        int i10 = $component5;
                        int i11 = (i10 ^ 63) + ((i10 & 63) << 1);
                        $vD14832N6715 = i11 % 128;
                        if (i11 % 2 != 0) {
                            component5();
                            throw null;
                        }
                        String strComponent5 = component5();
                        int i12 = $component5;
                        int i13 = (i12 & 13) + (i12 | 13);
                        $vD14832N6715 = i13 % 128;
                        int i14 = i13 % 2;
                        return strComponent5;
                    }

                    static {
                        int i9 = $setPivotYN16904;
                        int i10 = ((i9 | 83) << 1) - (i9 ^ 83);
                        $component9 = i10 % 128;
                        int i11 = i10 % 2;
                    }
                }, 7, null};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.getTrimmedLength(""), (char) ((-1) - ImageFormat.getBitsPerPixel(0)), (ViewConfiguration.getEdgeSlop() >> 16) + 1803, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
                }
                objInvoke = ((Method) objComponent6).invoke(null, objArr2);
                if (Result.m12690isFailureimpl(objInvoke)) {
                    int i9 = component5 + 65;
                    D8871 = i9 % 128;
                    int i10 = i9 % 2;
                } else {
                    obj = objInvoke;
                    int i11 = D8871;
                    i = ((i11 | 83) << 1) - (i11 ^ 83);
                    component5 = i % 128;
                    if (i % 2 != 0) {
                        int i12 = 2 % 5;
                    }
                }
            }
            String str = (String) obj;
            int i13 = component5;
            int i14 = ((i13 | 45) << 1) - (i13 ^ 45);
            D8871 = i14 % 128;
            if (i14 % 2 != 0) {
                return str;
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

    /* JADX WARN: Code duplicated, block: B:19:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:20:0x00f6 A[PHI: r1
      0x00f6: PHI (r1v19 java.lang.Object) = (r1v9 java.lang.Object), (r1v25 java.lang.Object) binds: [B:18:0x00e0, B:10:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fingerprintjs.android.fpjs_pro_internal.U18116
    public final String component9() throws Throwable {
        Object objInvoke;
        int i;
        int i2 = 2 % 2;
        int i3 = component5;
        int i4 = (i3 & 115) + (i3 | 115);
        D8871 = i4 % 128;
        Object obj = "";
        try {
            if (i4 % 2 == 0) {
                Object[] objArr = {0L, true, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.W29288.3
                    private static int $D8871 = 1;
                    private static int $component5 = 0;
                    private static int $setPivotYN16904 = 0;
                    private static int $vD14832N6715 = 1;

                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ String invoke() {
                        int i5 = 2 % 2;
                        int i6 = $vD14832N6715 + 97;
                        $setPivotYN16904 = i6 % 128;
                        if (i6 % 2 == 0) {
                            return setPivotYN16904();
                        }
                        setPivotYN16904();
                        throw null;
                    }

                    public final String setPivotYN16904() {
                        int i5 = 2 % 2;
                        int i6 = $vD14832N6715 + 99;
                        $setPivotYN16904 = i6 % 128;
                        int i7 = i6 % 2;
                        String str = Build.MANUFACTURER;
                        Intrinsics.checkNotNull(str);
                        if (i7 == 0) {
                            return str;
                        }
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }

                    static {
                        int i5 = $D8871;
                        int i6 = (i5 & 25) + (i5 | 25);
                        $component5 = i6 % 128;
                        int i7 = i6 % 2;
                    }
                }, 53, null};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(KeyEvent.normalizeMetaState(0) + 52, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1803, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
                }
                objInvoke = ((Method) objComponent5).invoke(null, objArr);
                if (Result.m12690isFailureimpl(objInvoke)) {
                    int i5 = component5;
                    int i6 = (i5 ^ 25) + ((i5 & 25) << 1);
                    D8871 = i6 % 128;
                    int i7 = i6 % 2;
                    i = ((i5 | 27) << 1) - (i5 ^ 27);
                } else {
                    obj = objInvoke;
                    int i8 = component5;
                    i = (i8 & 55) + (i8 | 55);
                }
            } else {
                Object[] objArr2 = {0L, false, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.W29288.3
                    private static int $D8871 = 1;
                    private static int $component5 = 0;
                    private static int $setPivotYN16904 = 0;
                    private static int $vD14832N6715 = 1;

                    @Override // kotlin.jvm.functions.Function0
                    public final /* synthetic */ String invoke() {
                        int i9 = 2 % 2;
                        int i10 = $vD14832N6715 + 97;
                        $setPivotYN16904 = i10 % 128;
                        if (i10 % 2 == 0) {
                            return setPivotYN16904();
                        }
                        setPivotYN16904();
                        throw null;
                    }

                    public final String setPivotYN16904() {
                        int i9 = 2 % 2;
                        int i10 = $vD14832N6715 + 99;
                        $setPivotYN16904 = i10 % 128;
                        int i11 = i10 % 2;
                        String str = Build.MANUFACTURER;
                        Intrinsics.checkNotNull(str);
                        if (i11 == 0) {
                            return str;
                        }
                        Object obj2 = null;
                        obj2.hashCode();
                        throw null;
                    }

                    static {
                        int i9 = $D8871;
                        int i10 = (i9 & 25) + (i9 | 25);
                        $component5 = i10 % 128;
                        int i11 = i10 % 2;
                    }
                }, 7, null};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 52, (char) Color.red(0), 1803 - Drawable.resolveOpacity(0, 0), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
                }
                objInvoke = ((Method) objComponent6).invoke(null, objArr2);
                if (Result.m12690isFailureimpl(objInvoke)) {
                    int i9 = component5;
                    int i10 = (i9 ^ 25) + ((i9 & 25) << 1);
                    D8871 = i10 % 128;
                    int i11 = i10 % 2;
                    i = ((i9 | 27) << 1) - (i9 ^ 27);
                } else {
                    obj = objInvoke;
                    int i12 = component5;
                    i = (i12 & 55) + (i12 | 55);
                }
            }
            D8871 = i % 128;
            int i13 = i % 2;
            return (String) obj;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int D8871() {
        int i = setPivotYN16904;
        int i2 = i % 8356912;
        setPivotYN16904 = i + 1;
        if (i2 != 0) {
            return vD14832N6715;
        }
        int iNextInt = new Random().nextInt(484115802);
        vD14832N6715 = iNextInt;
        return iNextInt;
    }
}
