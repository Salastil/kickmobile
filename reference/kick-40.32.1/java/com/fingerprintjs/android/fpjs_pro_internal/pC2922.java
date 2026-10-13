package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.ContentResolver;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class pC2922 {
    private static int D8871 = 1;
    public static int component5;
    private static int component9;
    public static int vD14832N6715;
    private final ContentResolver setPivotYN16904;

    public pC2922(ContentResolver contentResolver) {
        this.setPivotYN16904 = contentResolver;
    }

    public static final /* synthetic */ ContentResolver D8871(pC2922 pc2922) {
        int i = 2 % 2;
        int i2 = D8871 + 95;
        int i3 = i2 % 128;
        component9 = i3;
        int i4 = i2 % 2;
        ContentResolver contentResolver = pc2922.setPivotYN16904;
        int i5 = ((i3 | 55) << 1) - (i3 ^ 55);
        D8871 = i5 % 128;
        if (i5 % 2 != 0) {
            return contentResolver;
        }
        throw null;
    }

    public final String vD14832N6715() throws Throwable {
        int i = 2 % 2;
        try {
            Object[] objArr = {0L, false, false, new Function0<String>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.pC2922.5
                private static int $component5 = 1;
                private static int $vD14832N6715;

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ String invoke() {
                    int i2 = 2 % 2;
                    int iComponent5 = av.component5();
                    int i3 = (~(((-841364133) & iComponent5) | ((-841364133) ^ iComponent5))) | 268706340;
                    int i4 = ~iComponent5;
                    int i5 = (i4 ^ 425045628) | (i4 & 425045628);
                    int i6 = ~((i5 & 841364132) | (i5 ^ 841364132));
                    int i7 = -(-(((i3 & i6) | (i3 ^ i6)) * (-470)));
                    int i8 = (((-1290629320) | i7) << 1) - (i7 ^ (-1290629320));
                    int i9 = ~((iComponent5 & (-572657793)) | ((-572657793) ^ iComponent5));
                    int i10 = ~((i4 ^ 425045628) | (i4 & 425045628) | 841364132);
                    int i11 = (i8 - (~(((i9 & i10) | (i9 ^ i10)) * 470))) - 1;
                    int iIdentityHashCode = System.identityHashCode(this);
                    int i12 = ~((~iIdentityHashCode) | 562845997);
                    int i13 = ((i12 & (-1739480944)) | ((-1739480944) ^ i12)) * 446;
                    int i14 = ~((iIdentityHashCode & (-1176634947)) | ((-1176634947) ^ iIdentityHashCode));
                    int i15 = (((((-361126358) | i13) << 1) - (i13 ^ (-361126358))) - (~(-(-(((i14 & 536893484) | (536893484 ^ i14)) * 446))))) - (-1580579551);
                    String strVD14832N6715 = vD14832N6715();
                    if (i11 <= i15) {
                        int i16 = 46 / 0;
                    }
                    return strVD14832N6715;
                }

                public final String vD14832N6715() {
                    int i2 = 2 % 2;
                    int i3 = $component5;
                    int i4 = ((i3 | 55) << 1) - (i3 ^ 55);
                    $vD14832N6715 = i4 % 128;
                    int i5 = i4 % 2;
                    pC2922 pc2922 = pC2922.this;
                    if (i5 == 0) {
                        ContentResolver contentResolverD8871 = pC2922.D8871(pc2922);
                        Intrinsics.checkNotNull(contentResolverD8871);
                        String string = Settings.Secure.getString(contentResolverD8871, "android_id");
                        Intrinsics.checkNotNull(string);
                        return string;
                    }
                    ContentResolver contentResolverD8872 = pC2922.D8871(pc2922);
                    Intrinsics.checkNotNull(contentResolverD8872);
                    Intrinsics.checkNotNull(Settings.Secure.getString(contentResolverD8872, "android_id"));
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }

                {
                    super(0);
                }
            }, 7, null};
            Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(-1143857645);
            Object obj = "";
            if (objComponent5 == null) {
                objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ViewConfiguration.getTapTimeout() >> 16) + 52, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), 1803 - TextUtils.getTrimmedLength(""), -379102608, false, "vD14832N6715", new Class[]{Long.TYPE, Boolean.TYPE, Boolean.TYPE, Function0.class, Integer.TYPE, Object.class});
            }
            Object objInvoke = ((Method) objComponent5).invoke(null, objArr);
            if (Result.m12690isFailureimpl(objInvoke)) {
                int i2 = D8871 + 21;
                component9 = i2 % 128;
                int i3 = i2 % 2;
            } else {
                int i4 = component9 + 35;
                D8871 = i4 % 128;
                int i5 = i4 % 2;
                obj = objInvoke;
            }
            String str = (String) obj;
            int i6 = component9;
            int i7 = (i6 & 69) + (i6 | 69);
            D8871 = i7 % 128;
            if (i7 % 2 == 0) {
                int i8 = 29 / 0;
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

    public static int component9() {
        int i = vD14832N6715;
        int i2 = i % 7609593;
        vD14832N6715 = i + 1;
        if (i2 != 0) {
            return component5;
        }
        int iMyTid = Process.myTid();
        component5 = iMyTid;
        return iMyTid;
    }
}
