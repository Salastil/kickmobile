package org.h.s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.webkit.WebViewCompat;
import io.mobileshield.sdk.logger.LocalLogger;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public abstract class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f549a;
    public static String b;

    public static final HashMap a(Context context, u uVar) {
        String str;
        m token;
        long jCurrentTimeMillis;
        if (uVar == null || (str = uVar.f576a) == null) {
            str = "";
        }
        LocalLogger.log(8, 22008L, str);
        HashMap map = new HashMap();
        if (uVar != null && (token = uVar.c) != null) {
            map.put("x-kpsdk-v", t4.a());
            String str2 = token.c;
            if (str2 != null && str2.length() > 0) {
                map.put("x-kpsdk-ct", str2);
            }
            o oVar = o.f548a;
            Intrinsics.checkNotNullParameter("tp-v2-input", "platformInput");
            Intrinsics.checkNotNullParameter(token, "token");
            ArrayList arrayList = new ArrayList();
            f fVar = new f();
            if (o.b != null) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String strSubstring = string.substring(0, 32);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                long timeInMillis = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC")).getTimeInMillis() - token.e;
                fVar.c = timeInMillis;
                try {
                    o oVar2 = o.f548a;
                    String strA = o.a(timeInMillis, strSubstring, 5.0d, arrayList);
                    jCurrentTimeMillis = System.currentTimeMillis();
                    fVar.d = token.e;
                    fVar.e = token.g;
                    fVar.f = token.f;
                    Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
                    fVar.b = arrayList;
                    Intrinsics.checkNotNullParameter(strA, "<set-?>");
                    Intrinsics.checkNotNullParameter(strSubstring, "<set-?>");
                    fVar.f504a = strSubstring;
                } catch (Exception e) {
                    LocalLogger.log(16, 26000L, e.getMessage());
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                fVar.g = new e(jCurrentTimeMillis2, jCurrentTimeMillis);
            }
            map.put("x-kpsdk-h", g0.f510a);
            map.put("x-kpsdk-cd", fVar.a());
            map.put("x-kpsdk-dv", a(context));
            map.put("User-Agent", uVar.b);
        }
        return map;
    }

    public static String a(Context context) {
        if (f549a == null) {
            PackageInfo currentWebViewPackage = context != null ? WebViewCompat.getCurrentWebViewPackage(context) : null;
            String str = currentWebViewPackage != null ? currentWebViewPackage.versionName : null;
            if (str == null) {
                str = "unknown";
            }
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            String strValueOf = String.valueOf(t4.b());
            String DEVICE = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
            String PRODUCT = Build.PRODUCT;
            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
            f549a = v.a(new s(BRAND, MODEL, strValueOf, DEVICE, PRODUCT, str));
        }
        String str2 = f549a;
        if (str2 != null) {
            return str2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("encodedDeviceInfo");
        return null;
    }

    public static boolean a() {
        return b != null;
    }

    public static Long a(String input, String token) {
        b = null;
        if (input != null && input.length() != 0 && token != null && token.length() != 0) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(token, "token");
            String strSubstring = input.substring(StringsKt.indexOf$default((CharSequence) input, '-', 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strA = v.a(strSubstring, token);
            Long longOrNull = strA != null ? StringsKt.toLongOrNull(strA) : null;
            if (longOrNull != null) {
                long jLongValue = longOrNull.longValue();
                b = input;
                return Long.valueOf(k4.f532a.convert(jLongValue, TimeUnit.SECONDS));
            }
        }
        return null;
    }
}
