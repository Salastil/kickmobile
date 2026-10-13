package com.datadog.android.log.internal.logger;

import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConditionalLogHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJi\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001cJU\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u0010\u001eR(\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/log/internal/logger/ConditionalLogHandler;", "Lcom/datadog/android/log/internal/logger/LogHandler;", "delegateHandler", "condition", "Lkotlin/Function2;", "", "", "", "(Lcom/datadog/android/log/internal/logger/LogHandler;Lkotlin/jvm/functions/Function2;)V", "getCondition$dd_sdk_android_logs_release", "()Lkotlin/jvm/functions/Function2;", "getDelegateHandler$dd_sdk_android_logs_release", "()Lcom/datadog/android/log/internal/logger/LogHandler;", "handleLog", "", FirebaseAnalytics.Param.LEVEL, "message", "", "errorKind", "errorMessage", "errorStacktrace", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "", "tags", "", "timestamp", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", RumFeature.EVENT_THROWABLE_PROPERTY, "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConditionalLogHandler implements LogHandler {
    private final Function2<Integer, Throwable, Boolean> condition;
    private final LogHandler delegateHandler;

    /* JADX WARN: Multi-variable type inference failed */
    public ConditionalLogHandler(LogHandler delegateHandler, Function2<? super Integer, ? super Throwable, Boolean> condition) {
        Intrinsics.checkNotNullParameter(delegateHandler, "delegateHandler");
        Intrinsics.checkNotNullParameter(condition, "condition");
        this.delegateHandler = delegateHandler;
        this.condition = condition;
    }

    /* JADX INFO: renamed from: getDelegateHandler$dd_sdk_android_logs_release, reason: from getter */
    public final LogHandler getDelegateHandler() {
        return this.delegateHandler;
    }

    public final Function2<Integer, Throwable, Boolean> getCondition$dd_sdk_android_logs_release() {
        return this.condition;
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int level, String message, Throwable throwable, Map<String, ? extends Object> attributes, Set<String> tags, Long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (this.condition.invoke(Integer.valueOf(level), throwable).booleanValue()) {
            this.delegateHandler.handleLog(level, message, throwable, attributes, tags, timestamp);
        }
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int level, String message, String errorKind, String errorMessage, String errorStacktrace, Map<String, ? extends Object> attributes, Set<String> tags, Long timestamp) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (this.condition.invoke(Integer.valueOf(level), null).booleanValue()) {
            this.delegateHandler.handleLog(level, message, errorKind, errorMessage, errorStacktrace, attributes, tags, timestamp);
        }
    }
}
