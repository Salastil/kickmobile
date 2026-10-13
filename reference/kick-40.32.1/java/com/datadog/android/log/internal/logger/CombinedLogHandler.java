package com.datadog.android.log.internal.logger;

import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CombinedLogHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001¢\u0006\u0002\u0010\u0004Ji\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018JU\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u001bR\u001e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/datadog/android/log/internal/logger/CombinedLogHandler;", "Lcom/datadog/android/log/internal/logger/LogHandler;", "handlers", "", "([Lcom/datadog/android/log/internal/logger/LogHandler;)V", "getHandlers$dd_sdk_android_logs_release", "()[Lcom/datadog/android/log/internal/logger/LogHandler;", "[Lcom/datadog/android/log/internal/logger/LogHandler;", "handleLog", "", FirebaseAnalytics.Param.LEVEL, "", "message", "", "errorKind", "errorMessage", "errorStacktrace", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "tags", "", "timestamp", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", RumFeature.EVENT_THROWABLE_PROPERTY, "", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CombinedLogHandler implements LogHandler {
    private final LogHandler[] handlers;

    public CombinedLogHandler(LogHandler... handlers) {
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        this.handlers = handlers;
    }

    /* JADX INFO: renamed from: getHandlers$dd_sdk_android_logs_release, reason: from getter */
    public final LogHandler[] getHandlers() {
        return this.handlers;
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int level, String message, Throwable throwable, Map<String, ? extends Object> attributes, Set<String> tags, Long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        for (LogHandler logHandler : this.handlers) {
            logHandler.handleLog(level, message, throwable, attributes, tags, timestamp);
        }
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int level, String message, String errorKind, String errorMessage, String errorStacktrace, Map<String, ? extends Object> attributes, Set<String> tags, Long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Map<String, ? extends Object> attributes2 = attributes;
        Intrinsics.checkNotNullParameter(attributes2, "attributes");
        Set<String> tags2 = tags;
        Intrinsics.checkNotNullParameter(tags2, "tags");
        LogHandler[] logHandlerArr = this.handlers;
        int length = logHandlerArr.length;
        int i = 0;
        while (i < length) {
            logHandlerArr[i].handleLog(level, message, errorKind, errorMessage, errorStacktrace, attributes2, tags2, timestamp);
            i++;
            attributes2 = attributes;
            tags2 = tags;
        }
    }
}
