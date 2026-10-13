package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.widget.ExpandableListView;
import com.fingerprintjs.android.fpjs_pro.ProxyIntegrationSecretEnvironmentMismatch;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.Result;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final class X26477 {
    public static int D8871 = 0;
    private static int component5 = 0;
    public static int component9 = 0;
    private static int setPivotYN16904 = 1;

    public static /* synthetic */ Object setPivotYN16904(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
        int i7 = (~((~i4) | i6)) | (~(i6 | i2));
        int i8 = (~i6) | (~i2);
        int i9 = i7 | (~(i8 | i4));
        int i10 = (~i8) | i4;
        int i11 = ~(i2 | i4);
        int i12 = i4 + i6 + i + ((-417414852) * i5) + (1247522396 * i3);
        int i13 = i12 * i12;
        int i14 = (i4 * (-1219797419)) + 1526988800 + ((-1219797419) * i6) + (825712212 * i9) + ((-1651424424) * i10) + ((-825712212) * i11) + ((-2045509632) * i) + ((-2135949312) * i5) + ((-953155584) * i3) + ((-430374912) * i13);
        int i15 = ((i4 * 184508743) - 476012450) + (i6 * 184508743) + (i9 * (-996)) + (i10 * 1992) + (i11 * 996) + (i * 184509739) + (i5 * (-953474796)) + (i3 * (-288057996)) + (i13 * (-839712768));
        return i14 + ((i15 * i15) * 1709113344) != 1 ? setPivotYN16904(objArr) : D8871(objArr);
    }

    public static final /* synthetic */ String setPivotYN16904(X26477 x26477) throws NoSuchAlgorithmException {
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = (i2 & 83) + (i2 | 83);
        component5 = i3 % 128;
        int i4 = i3 % 2;
        String strComponent5 = component5();
        int i5 = component5;
        int i6 = ((i5 | 55) << 1) - (i5 ^ 55);
        setPivotYN16904 = i6 % 128;
        if (i6 % 2 == 0) {
            int i7 = 76 / 0;
        }
        return strComponent5;
    }

    private static /* synthetic */ Object D8871(Object[] objArr) throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr2 = {0L, false, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.X26477.5
                private static int $component5 = 1;
                private static int $setPivotYN16904;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() throws NoSuchAlgorithmException {
                    int i2 = 2 % 2;
                    int i3 = $component5;
                    int i4 = ((i3 | 83) << 1) - (i3 ^ 83);
                    $setPivotYN16904 = i4 % 128;
                    int i5 = i4 % 2;
                    String pivotYN16904 = setPivotYN16904();
                    int i6 = $component5 + 15;
                    $setPivotYN16904 = i6 % 128;
                    if (i6 % 2 == 0) {
                        return pivotYN16904;
                    }
                    throw null;
                }

                public final String setPivotYN16904() throws NoSuchAlgorithmException {
                    int i2 = 2 % 2;
                    int i3 = $component5 + 23;
                    $setPivotYN16904 = i3 % 128;
                    int i4 = i3 % 2;
                    String pivotYN16904 = X26477.setPivotYN16904(X26477.this);
                    if (i4 != 0) {
                        int i5 = 80 / 0;
                    }
                    return pivotYN16904;
                }

                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - Color.green(0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)), TextUtils.lastIndexOf("", '0') + 1804, -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr2);
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = setPivotYN16904;
                int i3 = (i2 ^ 15) + ((i2 & 15) << 1);
                component5 = i3 % 128;
                int i4 = i3 % 2;
                int i5 = i2 + 47;
                component5 = i5 % 128;
                int i6 = i5 % 2;
                objInvoke = null;
            }
            String str = (String) objInvoke;
            int i7 = component5;
            int i8 = (i7 & 41) + (i7 | 41);
            setPivotYN16904 = i8 % 128;
            if (i8 % 2 != 0) {
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

    private static String component5() throws NoSuchAlgorithmException {
        int i = 2 % 2;
        MediaDrm mediaDrm = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));
        byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
        int iD8871 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        int iD8872 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        int iD8873 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        setPivotYN16904(iD8872, iD8871, ProxyIntegrationSecretEnvironmentMismatch.D8871(), 1940184405, new Object[]{mediaDrm}, iD8873, -1940184405);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(propertyByteArray);
        String strComponent5 = cM3232.component5(messageDigest.digest());
        int i2 = component5;
        int i3 = ((i2 | 5) << 1) - (i2 ^ 5);
        setPivotYN16904 = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 43 / 0;
        }
        return strComponent5;
    }

    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) {
        MediaDrm mediaDrm = (MediaDrm) objArr[0];
        int i = 2 % 2;
        int i2 = component5;
        int i3 = ((i2 | 83) << 1) - (i2 ^ 83);
        setPivotYN16904 = i3 % 128;
        int i4 = i3 % 2;
        Object obj = null;
        if (Build.VERSION.SDK_INT < 28) {
            mediaDrm.release();
            int i5 = setPivotYN16904 + 87;
            component5 = i5 % 128;
            if (i5 % 2 == 0) {
                return null;
            }
            obj.hashCode();
            throw null;
        }
        int i6 = component5 + 53;
        setPivotYN16904 = i6 % 128;
        int i7 = i6 % 2;
        mediaDrm.release();
        int i8 = component5 + 53;
        setPivotYN16904 = i8 % 128;
        int i9 = i8 % 2;
        return null;
    }

    public static int component9() {
        int i = D8871;
        int i2 = i % 5507693;
        D8871 = i + 1;
        if (i2 != 0) {
            return component9;
        }
        int iMyPid = Process.myPid();
        component9 = iMyPid;
        return iMyPid;
    }

    private static void component9(MediaDrm mediaDrm) {
        int iD8871 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        int iD8872 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        int iD8873 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        setPivotYN16904(iD8872, iD8871, ProxyIntegrationSecretEnvironmentMismatch.D8871(), 1940184405, new Object[]{mediaDrm}, iD8873, -1940184405);
    }

    public final String vD14832N6715() {
        int iD8871 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        int iD8872 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        int iD8873 = ProxyIntegrationSecretEnvironmentMismatch.D8871();
        return (String) setPivotYN16904(iD8872, iD8871, ProxyIntegrationSecretEnvironmentMismatch.D8871(), 495862354, new Object[]{this}, iD8873, -495862353);
    }
}
