package com.datadog.android.log.internal.logger;

import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: LogHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001Jo\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011J]\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/log/internal/logger/LogHandler;", "", "handleLog", "", FirebaseAnalytics.Param.LEVEL, "", "message", "", "errorKind", "errorMessage", "errorStacktrace", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "tags", "", "timestamp", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", RumFeature.EVENT_THROWABLE_PROPERTY, "", "(ILjava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;Ljava/util/Set;Ljava/lang/Long;)V", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LogHandler {
    void handleLog(int level, String message, String errorKind, String errorMessage, String errorStacktrace, Map<String, ? extends Object> attributes, Set<String> tags, Long timestamp);

    void handleLog(int level, String message, Throwable throwable, Map<String, ? extends Object> attributes, Set<String> tags, Long timestamp);

    /* JADX INFO: compiled from: LogHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void handleLog$default(LogHandler logHandler, int i, String str, Throwable th, Map map, Set set, Long l, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleLog");
            }
            if ((i2 & 4) != 0) {
                th = null;
            }
            if ((i2 & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i2 & 16) != 0) {
                set = SetsKt.emptySet();
            }
            if ((i2 & 32) != 0) {
                l = null;
            }
            logHandler.handleLog(i, str, th, map, set, l);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void handleLog$default(LogHandler logHandler, int i, String str, String str2, String str3, String str4, Map map, Set set, Long l, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleLog");
            }
            logHandler.handleLog(i, str, str2, str3, str4, (i2 & 32) != 0 ? MapsKt.emptyMap() : map, (i2 & 64) != 0 ? SetsKt.emptySet() : set, (i2 & 128) != 0 ? null : l);
        }
    }
}
