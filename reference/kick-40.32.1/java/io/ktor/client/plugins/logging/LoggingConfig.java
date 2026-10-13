package io.ktor.client.plugins.logging;

import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes9.dex */
@KtorDsl
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ+\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\r\u0010\u000eR4\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010(\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00067"}, d2 = {"Lio/ktor/client/plugins/logging/LoggingConfig;", "", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "predicate", "", ViewProps.FILTER, "(Lkotlin/jvm/functions/Function1;)V", "", "placeholder", "sanitizeHeader", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", "filters", "Ljava/util/List;", "getFilters$ktor_client_logging", "()Ljava/util/List;", "setFilters$ktor_client_logging", "(Ljava/util/List;)V", "Lio/ktor/client/plugins/logging/SanitizedHeader;", "sanitizedHeaders", "getSanitizedHeaders$ktor_client_logging", "Lio/ktor/client/plugins/logging/Logger;", "_logger", "Lio/ktor/client/plugins/logging/Logger;", "Lio/ktor/client/plugins/logging/LoggingFormat;", "format", "Lio/ktor/client/plugins/logging/LoggingFormat;", "getFormat", "()Lio/ktor/client/plugins/logging/LoggingFormat;", "setFormat", "(Lio/ktor/client/plugins/logging/LoggingFormat;)V", "value", "getLogger", "()Lio/ktor/client/plugins/logging/Logger;", "setLogger", "(Lio/ktor/client/plugins/logging/Logger;)V", "logger", "Lio/ktor/client/plugins/logging/LogLevel;", FirebaseAnalytics.Param.LEVEL, "Lio/ktor/client/plugins/logging/LogLevel;", "getLevel", "()Lio/ktor/client/plugins/logging/LogLevel;", "setLevel", "(Lio/ktor/client/plugins/logging/LogLevel;)V", "Lio/ktor/client/plugins/logging/LogBodyFilter;", "bodyFilter", "Lio/ktor/client/plugins/logging/LogBodyFilter;", "getBodyFilter", "()Lio/ktor/client/plugins/logging/LogBodyFilter;", "setBodyFilter", "(Lio/ktor/client/plugins/logging/LogBodyFilter;)V", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LoggingConfig {
    private Logger _logger;
    private List<Function1<HttpRequestBuilder, Boolean>> filters = new ArrayList();
    private final List<SanitizedHeader> sanitizedHeaders = new ArrayList();
    private LoggingFormat format = LoggingFormat.Default;
    private LogLevel level = LogLevel.HEADERS;
    private LogBodyFilter bodyFilter = LogBodyFilterKt.getBinaryLogBodyFilter();

    public final List<Function1<HttpRequestBuilder, Boolean>> getFilters$ktor_client_logging() {
        return this.filters;
    }

    public final void setFilters$ktor_client_logging(List<Function1<HttpRequestBuilder, Boolean>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.filters = list;
    }

    public final List<SanitizedHeader> getSanitizedHeaders$ktor_client_logging() {
        return this.sanitizedHeaders;
    }

    public final LoggingFormat getFormat() {
        return this.format;
    }

    public final void setFormat(LoggingFormat loggingFormat) {
        Intrinsics.checkNotNullParameter(loggingFormat, "<set-?>");
        this.format = loggingFormat;
    }

    public final Logger getLogger() {
        Logger logger = this._logger;
        return logger == null ? LoggerJvmKt.getDEFAULT(Logger.INSTANCE) : logger;
    }

    public final void setLogger(Logger value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._logger = value;
    }

    public final LogLevel getLevel() {
        return this.level;
    }

    public final void setLevel(LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
        this.level = logLevel;
    }

    public final LogBodyFilter getBodyFilter() {
        return this.bodyFilter;
    }

    public final void setBodyFilter(LogBodyFilter logBodyFilter) {
        Intrinsics.checkNotNullParameter(logBodyFilter, "<set-?>");
        this.bodyFilter = logBodyFilter;
    }

    public final void filter(Function1<? super HttpRequestBuilder, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.filters.add(predicate);
    }

    public static /* synthetic */ void sanitizeHeader$default(LoggingConfig loggingConfig, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "***";
        }
        loggingConfig.sanitizeHeader(str, function1);
    }

    public final void sanitizeHeader(String placeholder, Function1<? super String, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.sanitizedHeaders.add(new SanitizedHeader(placeholder, predicate));
    }
}
