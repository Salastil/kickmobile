package io.github.expo.kolibri.binary;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringBytes.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\b¨\u0006\u0005"}, d2 = {"copyAsciiTo", "", "", FirebaseAnalytics.Param.DESTINATION, "", "runtime"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StringBytesKt {
    public static final void copyAsciiTo(String str, byte[] destination) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        str.getBytes(0, str.length(), destination, 0);
    }
}
