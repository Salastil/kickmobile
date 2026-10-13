package com.datadog.android.log.internal.domain;

import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpLogGenerator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J²\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J¬\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016¨\u0006&"}, d2 = {"Lcom/datadog/android/log/internal/domain/NoOpLogGenerator;", "Lcom/datadog/android/log/internal/domain/LogGenerator;", "()V", "generateLog", "Lcom/datadog/android/log/model/LogEvent;", FirebaseAnalytics.Param.LEVEL, "", "message", "", "errorKind", "errorMessage", "errorStack", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "tags", "", "timestamp", "", "threadName", "datadogContext", "Lcom/datadog/android/api/context/DatadogContext;", "attachNetworkInfo", "", "loggerName", "bundleWithTraces", "bundleWithRum", "userInfo", "Lcom/datadog/android/api/context/UserInfo;", "accountInfo", "Lcom/datadog/android/api/context/AccountInfo;", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", RumFeature.EVENT_THROWABLE_PROPERTY, "", "threads", "", "Lcom/datadog/android/core/feature/event/ThreadDump;", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpLogGenerator implements LogGenerator {
    @Override // com.datadog.android.log.internal.domain.LogGenerator
    public LogEvent generateLog(int level, String message, String errorKind, String errorMessage, String errorStack, Map<String, ? extends Object> attributes, Set<String> tags, long timestamp, String threadName, DatadogContext datadogContext, boolean attachNetworkInfo, String loggerName, boolean bundleWithTraces, boolean bundleWithRum, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        return null;
    }

    @Override // com.datadog.android.log.internal.domain.LogGenerator
    public LogEvent generateLog(int level, String message, Throwable throwable, Map<String, ? extends Object> attributes, Set<String> tags, long timestamp, String threadName, DatadogContext datadogContext, boolean attachNetworkInfo, String loggerName, boolean bundleWithTraces, boolean bundleWithRum, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo, List<ThreadDump> threads) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(threads, "threads");
        return null;
    }
}
