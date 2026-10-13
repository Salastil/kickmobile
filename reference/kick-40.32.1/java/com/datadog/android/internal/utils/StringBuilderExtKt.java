package com.datadog.android.internal.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringBuilderExt.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"appendIfNotEmpty", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "char", "", "str", "", "dd-sdk-android-internal_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringBuilderExtKt {
    public static final StringBuilder appendIfNotEmpty(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        if (sb.length() > 0) {
            sb.append(str);
        }
        return sb;
    }

    public static final StringBuilder appendIfNotEmpty(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        if (sb.length() > 0) {
            sb.append(c);
        }
        return sb;
    }
}
