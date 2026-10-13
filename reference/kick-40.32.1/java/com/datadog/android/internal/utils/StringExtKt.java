package com.datadog.android.internal.utils;

import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: StringExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0003"}, d2 = {"fromBase64", "", "toBase64", "dd-sdk-android-internal_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringExtKt {
    public static final String toBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(bytes, Base64.NO_WRAP)");
        return strEncodeToString;
    }

    public static final String fromBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            if (bArrDecode != null) {
                return new String(bArrDecode, Charsets.UTF_8);
            }
        } catch (IllegalArgumentException unused) {
        }
        return null;
    }
}
