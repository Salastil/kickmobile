package com.datadog.android.core.internal.utils;

import com.datadog.android.api.InternalLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RuntimeUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"unboundInternalLogger", "Lcom/datadog/android/api/InternalLogger;", "getUnboundInternalLogger", "()Lcom/datadog/android/api/InternalLogger;", "setUnboundInternalLogger", "(Lcom/datadog/android/api/InternalLogger;)V", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RuntimeUtilsKt {
    private static InternalLogger unboundInternalLogger = InternalLogger.INSTANCE.getUNBOUND();

    public static final InternalLogger getUnboundInternalLogger() {
        return unboundInternalLogger;
    }

    public static final void setUnboundInternalLogger(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "<set-?>");
        unboundInternalLogger = internalLogger;
    }
}
