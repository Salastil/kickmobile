package org.h.s;

import com.google.android.gms.cast.MediaError;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class y0 {
    public static x0 a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String upperCase = name.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        int iHashCode = upperCase.hashCode();
        if (iHashCode == 2251950) {
            if (upperCase.equals("INFO")) {
                return x0.INFO;
            }
            return null;
        }
        if (iHashCode == 66247144) {
            if (upperCase.equals(MediaError.ERROR_TYPE_ERROR)) {
                return x0.ERROR;
            }
            return null;
        }
        if (iHashCode == 1069090146) {
            if (upperCase.equals("VERBOSE")) {
                return x0.VERBOSE;
            }
            return null;
        }
        if (iHashCode == 1842428796 && upperCase.equals("WARNING")) {
            return x0.WARNING;
        }
        return null;
    }
}
