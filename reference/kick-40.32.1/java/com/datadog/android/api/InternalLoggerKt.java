package com.datadog.android.api;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternalLogger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, d2 = {"logToUser", "", "Lcom/datadog/android/api/InternalLogger;", FirebaseAnalytics.Param.LEVEL, "Lcom/datadog/android/api/InternalLogger$Level;", "onlyOnce", "", "messageBuilder", "Lkotlin/Function0;", "", "dd-sdk-android-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InternalLoggerKt {
    public static /* synthetic */ void logToUser$default(InternalLogger internalLogger, InternalLogger.Level level, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        logToUser(internalLogger, level, z, function0);
    }

    public static final void logToUser(InternalLogger internalLogger, InternalLogger.Level level, boolean z, Function0<String> messageBuilder) {
        Intrinsics.checkNotNullParameter(internalLogger, "<this>");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        InternalLogger.DefaultImpls.log$default(internalLogger, level, InternalLogger.Target.USER, messageBuilder, (Throwable) null, z, (Map) null, 40, (Object) null);
    }
}
