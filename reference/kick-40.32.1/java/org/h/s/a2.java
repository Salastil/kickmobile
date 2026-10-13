package org.h.s;

import com.datadog.trace.api.config.ProfilingConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a2 {
    public static String a(String stringToXor, int i) {
        Intrinsics.checkNotNullParameter(stringToXor, "stringToXor");
        return i + v.a(stringToXor);
    }

    public static String a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.endsWith$default(url, ProfilingConfig.PROFILING_DATADOG_PROFILER_CSTACK_DEFAULT, false, 2, (Object) null)) {
            return ProfilingConfig.PROFILING_DATADOG_PROFILER_CSTACK_DEFAULT;
        }
        if (StringsKt.endsWith$default(url, "tl", false, 2, (Object) null)) {
            return "tl";
        }
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) "ips", false, 2, (Object) null)) {
            return "ips";
        }
        return null;
    }
}
