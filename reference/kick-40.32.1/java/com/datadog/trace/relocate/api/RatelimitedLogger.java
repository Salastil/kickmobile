package com.datadog.trace.relocate.api;

import com.datadog.trace.api.time.SystemTimeSource;
import com.datadog.trace.api.time.TimeSource;
import com.datadog.trace.logger.Logger;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public class RatelimitedLogger {
    private final long delayNanos;
    private final Logger log;
    private final AtomicLong nextLogNanos;
    private final String noLogMessage;
    private final TimeSource timeSource;

    public RatelimitedLogger(Logger logger, int i, TimeUnit timeUnit) {
        this(logger, i, timeUnit, SystemTimeSource.INSTANCE);
    }

    RatelimitedLogger(Logger logger, int i, TimeUnit timeUnit, TimeSource timeSource) {
        this.log = logger;
        this.delayNanos = timeUnit.toNanos(i);
        this.noLogMessage = createNoLogMessage(" (Will not log warnings for ", ")", i, timeUnit);
        this.timeSource = timeSource;
        this.nextLogNanos = new AtomicLong(timeSource.getNanoTicks());
    }

    public boolean warn(String str, Object... objArr) {
        boolean zIsDebugEnabled = this.log.isDebugEnabled();
        Logger logger = this.log;
        if (zIsDebugEnabled) {
            logger.warn(str, objArr);
            return true;
        }
        if (!logger.isWarnEnabled()) {
            return false;
        }
        long j = this.nextLogNanos.get();
        long nanoTicks = this.timeSource.getNanoTicks();
        if (nanoTicks - j < 0 || !this.nextLogNanos.compareAndSet(j, nanoTicks + this.delayNanos)) {
            return false;
        }
        this.log.warn(str + this.noLogMessage, objArr);
        return true;
    }

    private static String createNoLogMessage(String str, String str2, int i, TimeUnit timeUnit) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(' ');
        String lowerCase = timeUnit.name().toLowerCase(Locale.ROOT);
        if (i == 1) {
            lowerCase = lowerCase.substring(0, lowerCase.length() - 1);
        }
        sb.append(lowerCase);
        sb.append(str2);
        return sb.toString();
    }
}
