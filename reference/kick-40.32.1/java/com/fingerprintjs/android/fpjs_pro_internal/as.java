package com.fingerprintjs.android.fpjs_pro_internal;

import com.datadog.trace.api.config.ProfilingConfig;
import com.fingerprintjs.android.fpjs_pro.raw_signal_providers.file_timestamps.FileTimestamps;

/* JADX INFO: loaded from: classes6.dex */
public final class as {
    public final native FileTimestamps component9(String str);

    public as() {
        System.loadLibrary(ProfilingConfig.PROFILING_DATADOG_PROFILER_CSTACK_DEFAULT);
    }
}
