package io.ktor.client.plugins.logging;

import com.datadog.trace.api.config.ProfilingConfig;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: compiled from: LogLevel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\f\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/logging/LogLevel;", "", "", "info", "headers", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "<init>", "(Ljava/lang/String;IZZZ)V", "Z", "getInfo", "()Z", "getHeaders", "getBody", Rule.ALL, "HEADERS", "BODY", "INFO", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum LogLevel {
    ALL(true, true, true),
    HEADERS(true, true, false),
    BODY(true, false, true),
    INFO(true, false, false),
    NONE(false, false, false);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final boolean body;
    private final boolean headers;
    private final boolean info;

    public static EnumEntries<LogLevel> getEntries() {
        return $ENTRIES;
    }

    LogLevel(boolean z, boolean z2, boolean z3) {
        this.info = z;
        this.headers = z2;
        this.body = z3;
    }

    public final boolean getInfo() {
        return this.info;
    }

    public final boolean getHeaders() {
        return this.headers;
    }

    public final boolean getBody() {
        return this.body;
    }
}
