package io.github.expo.kolibri;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isAscii", "", "", "runtime"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StringExtensionsKt {
    public static final boolean isAscii(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) >= 128) {
                return false;
            }
        }
        return true;
    }
}
