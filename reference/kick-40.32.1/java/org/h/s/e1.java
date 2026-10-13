package org.h.s;

import com.google.android.gms.cast.MediaError;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f500a = new d1();

    public static final String a(long j) {
        Object obj = f500a.get();
        if (obj == null) {
            throw new IllegalArgumentException("SimpleDateFormat not initialized".toString());
        }
        String str = ((SimpleDateFormat) obj).format(new Date(j));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String a(int i) {
        if (i == 4) {
            return "WARNING";
        }
        if (i == 8) {
            return "INFO";
        }
        if (i != 16) {
            return MediaError.ERROR_TYPE_ERROR;
        }
        return "VERBOSE";
    }
}
