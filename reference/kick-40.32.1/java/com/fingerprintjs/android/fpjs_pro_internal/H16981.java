package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.ContentResolver;
import android.graphics.ImageFormat;
import android.os.Process;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final class H16981 {
    public static int component5 = 0;
    public static int component9 = 0;
    private static int setPivotYN16904 = 0;
    private static int vD14832N6715 = 1;
    private final ContentResolver D8871;

    public H16981(ContentResolver contentResolver) {
        this.D8871 = contentResolver;
    }

    public static final /* synthetic */ String component5(H16981 h16981) {
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = (i2 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + (i2 | AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
        vD14832N6715 = i3 % 128;
        int i4 = i3 % 2;
        String strVD14832N6715 = h16981.vD14832N6715();
        int i5 = setPivotYN16904 + 29;
        vD14832N6715 = i5 % 128;
        if (i5 % 2 != 0) {
            return strVD14832N6715;
        }
        throw null;
    }

    public final String component5() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.H16981.5
                private static int $D8871 = 1;
                private static int $component5;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() {
                    int i2 = 2 % 2;
                    int i3 = $component5 + 21;
                    $D8871 = i3 % 128;
                    int i4 = i3 % 2;
                    String strD8871 = D8871();
                    if (i4 == 0) {
                        int i5 = 42 / 0;
                    }
                    int i6 = $D8871;
                    int i7 = (i6 ^ 73) + ((i6 & 73) << 1);
                    $component5 = i7 % 128;
                    if (i7 % 2 == 0) {
                        return strD8871;
                    }
                    throw null;
                }

                public final String D8871() {
                    int i2 = 2 % 2;
                    int i3 = $component5;
                    int i4 = (i3 ^ 41) + ((i3 & 41) << 1);
                    $D8871 = i4 % 128;
                    int i5 = i4 % 2;
                    H16981 h16981 = H16981.this;
                    if (i5 == 0) {
                        H16981.component5(h16981);
                        throw null;
                    }
                    String strComponent5 = H16981.component5(h16981);
                    int i6 = $D8871;
                    int i7 = (i6 & 77) + (i6 | 77);
                    $component5 = i7 % 128;
                    int i8 = i7 % 2;
                    return strComponent5;
                }

                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            Object obj = "";
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - ImageFormat.getBitsPerPixel(0), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), 1803 - TextUtils.getCapsMode("", 0, 0), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = setPivotYN16904;
                int i3 = (i2 ^ 103) + ((i2 & 103) << 1);
                vD14832N6715 = i3 % 128;
                int i4 = i3 % 2;
            } else {
                int i5 = setPivotYN16904;
                int i6 = (i5 ^ 41) + ((i5 & 41) << 1);
                vD14832N6715 = i6 % 128;
                int i7 = i6 % 2;
                obj = objInvoke;
            }
            return (String) obj;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0049, code lost:
    
        if (r11 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
    
        if (r11.moveToFirst() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
    
        r1 = com.fingerprintjs.android.fpjs_pro_internal.H16981.vD14832N6715;
        r2 = ((r1 | 19) << 1) - (r1 ^ 19);
        com.fingerprintjs.android.fpjs_pro_internal.H16981.setPivotYN16904 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
    
        if ((r2 % 2) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        if (r11.getColumnCount() >= 3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r11.getColumnCount() >= 2) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        r1 = java.lang.Long.toHexString(java.lang.Long.parseLong(r11.getString(1)));
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0081, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0094, code lost:
    
        r11 = com.fingerprintjs.android.fpjs_pro_internal.H16981.setPivotYN16904;
        r1 = ((r11 | 21) << 1) - (r11 ^ 21);
        com.fingerprintjs.android.fpjs_pro_internal.H16981.vD14832N6715 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
    
        if (r11 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String vD14832N6715() {
        /*
            r11 = this;
            r0 = 2
            int r1 = r0 % r0
            int r1 = com.fingerprintjs.android.fpjs_pro_internal.H16981.vD14832N6715
            r2 = r1 & 35
            r1 = r1 | 35
            int r2 = r2 + r1
            int r1 = r2 % 128
            com.fingerprintjs.android.fpjs_pro_internal.H16981.setPivotYN16904 = r1
            int r2 = r2 % r0
            java.lang.String r1 = "android_id"
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L31
            java.lang.String r2 = com.fingerprintjs.android.fpjs_pro_internal.oN11246.setPivotYN16904()
            android.net.Uri r6 = android.net.Uri.parse(r2)
            r2 = 0
            java.lang.String[] r9 = new java.lang.String[r2]
            r9[r4] = r1
            android.content.ContentResolver r5 = r11.D8871     // Catch: java.lang.Exception -> La1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: java.lang.Exception -> La1
            r8 = 0
            r10 = 0
            r7 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> La1
            if (r11 != 0) goto L4c
            goto L4b
        L31:
            java.lang.String r2 = com.fingerprintjs.android.fpjs_pro_internal.oN11246.setPivotYN16904()
            android.net.Uri r6 = android.net.Uri.parse(r2)
            java.lang.String[] r9 = new java.lang.String[]{r1}
            android.content.ContentResolver r5 = r11.D8871     // Catch: java.lang.Exception -> La1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: java.lang.Exception -> La1
            r8 = 0
            r10 = 0
            r7 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> La1
            if (r11 != 0) goto L4c
        L4b:
            return r3
        L4c:
            boolean r1 = r11.moveToFirst()     // Catch: java.lang.Exception -> La1
            if (r1 == 0) goto L91
            int r1 = com.fingerprintjs.android.fpjs_pro_internal.H16981.vD14832N6715
            r2 = r1 | 19
            int r2 = r2 << r4
            r1 = r1 ^ 19
            int r2 = r2 - r1
            int r1 = r2 % 128
            com.fingerprintjs.android.fpjs_pro_internal.H16981.setPivotYN16904 = r1
            int r2 = r2 % r0
            if (r2 == 0) goto L69
            int r1 = r11.getColumnCount()     // Catch: java.lang.Exception -> La1
            r2 = 3
            if (r1 >= r2) goto L70
            goto L91
        L69:
            int r1 = r11.getColumnCount()     // Catch: java.lang.Exception -> La1
            if (r1 >= r0) goto L70
            goto L91
        L70:
            java.lang.String r1 = r11.getString(r4)     // Catch: java.lang.NumberFormatException -> L81 java.lang.Exception -> La1
            long r1 = java.lang.Long.parseLong(r1)     // Catch: java.lang.NumberFormatException -> L81 java.lang.Exception -> La1
            java.lang.String r1 = java.lang.Long.toHexString(r1)     // Catch: java.lang.NumberFormatException -> L81 java.lang.Exception -> La1
            r11.close()     // Catch: java.lang.NumberFormatException -> L81 java.lang.Exception -> La1
            r3 = r1
            goto L84
        L81:
            r11.close()     // Catch: java.lang.Exception -> La1
        L84:
            int r11 = com.fingerprintjs.android.fpjs_pro_internal.H16981.vD14832N6715
            r1 = r11 & 81
            r11 = r11 | 81
            int r1 = r1 + r11
            int r11 = r1 % 128
            com.fingerprintjs.android.fpjs_pro_internal.H16981.setPivotYN16904 = r11
            int r1 = r1 % r0
            goto La1
        L91:
            r11.close()     // Catch: java.lang.Exception -> La1
            int r11 = com.fingerprintjs.android.fpjs_pro_internal.H16981.setPivotYN16904
            r1 = r11 | 21
            int r1 = r1 << r4
            r11 = r11 ^ 21
            int r1 = r1 - r11
            int r11 = r1 % 128
            com.fingerprintjs.android.fpjs_pro_internal.H16981.vD14832N6715 = r11
            int r1 = r1 % r0
        La1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.H16981.vD14832N6715():java.lang.String");
    }

    public static int setPivotYN16904() {
        int i = component9;
        int i2 = i % 7956688;
        component9 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iMyTid = Process.myTid();
        component5 = iMyTid;
        return iMyTid;
    }
}
