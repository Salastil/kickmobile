package com.datadog.android.log.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.event.EventMapper;
import com.datadog.android.log.model.LogEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogEventMapperWrapper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/log/internal/domain/event/LogEventMapperWrapper;", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/log/model/LogEvent;", "wrappedEventMapper", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/event/EventMapper;Lcom/datadog/android/api/InternalLogger;)V", "getInternalLogger$dd_sdk_android_logs_release", "()Lcom/datadog/android/api/InternalLogger;", "getWrappedEventMapper$dd_sdk_android_logs_release", "()Lcom/datadog/android/event/EventMapper;", "map", "event", "Companion", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LogEventMapperWrapper implements EventMapper<LogEvent> {
    public static final String EVENT_NULL_WARNING_MESSAGE = "LogEventMapper: the returned mapped object was null. This event will be dropped: %s";
    public static final String NOT_SAME_EVENT_INSTANCE_WARNING_MESSAGE = "LogEventMapper: the returned mapped object was not the same instance as the original object. This event will be dropped: %s";
    private final InternalLogger internalLogger;
    private final EventMapper<LogEvent> wrappedEventMapper;

    public LogEventMapperWrapper(EventMapper<LogEvent> wrappedEventMapper, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(wrappedEventMapper, "wrappedEventMapper");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.wrappedEventMapper = wrappedEventMapper;
        this.internalLogger = internalLogger;
    }

    public final EventMapper<LogEvent> getWrappedEventMapper$dd_sdk_android_logs_release() {
        return this.wrappedEventMapper;
    }

    /* JADX INFO: renamed from: getInternalLogger$dd_sdk_android_logs_release, reason: from getter */
    public final InternalLogger getInternalLogger() {
        return this.internalLogger;
    }

    @Override // com.datadog.android.event.EventMapper
    public LogEvent map(final LogEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LogEvent map = this.wrappedEventMapper.map(event);
        if (map == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.internal.domain.event.LogEventMapperWrapper.map.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, LogEventMapperWrapper.EVENT_NULL_WARNING_MESSAGE, Arrays.copyOf(new Object[]{event}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return null;
        }
        if (map == event) {
            return map;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.log.internal.domain.event.LogEventMapperWrapper.map.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, LogEventMapperWrapper.NOT_SAME_EVENT_INSTANCE_WARNING_MESSAGE, Arrays.copyOf(new Object[]{event}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return null;
    }
}
