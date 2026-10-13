package com.datadog.trace.util;

import com.datadog.android.trace.internal.compat.function.Supplier;
import com.datadog.trace.api.Platform;
import com.datadog.trace.logger.Logger;
import com.datadog.trace.logger.LoggerFactory;

/* JADX INFO: loaded from: classes6.dex */
public final class PidHelper {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) PidHelper.class);
    private static final String PID = findPid();
    private static final long PID_AS_LONG = parsePid();

    public static String getPid() {
        return PID;
    }

    public static long getPidAsLong() {
        return PID_AS_LONG;
    }

    private static String findPid() {
        String strTrim;
        if (Platform.isJavaVersionAtLeast(9)) {
            try {
                strTrim = Strings.trim((String) ((Supplier) Class.forName("com.datadog.trace.util.JDK9PidSupplier").getDeclaredConstructor(null).newInstance(null)).get());
            } catch (Throwable th) {
                log.debug("JDK9PidSupplier not available", th);
                strTrim = "";
            }
        } else {
            strTrim = "";
        }
        strTrim.isEmpty();
        return strTrim;
    }

    private static long parsePid() {
        String str = PID;
        if (str.isEmpty()) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            log.warn("Cannot parse PID {} as number. Default to 0", PID, e);
            return 0L;
        }
    }
}
