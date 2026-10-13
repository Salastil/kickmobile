package com.datadog.trace.logger;

import com.datadog.android.api.InternalLogger;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class DatadogCoreTracerLogger implements Logger {
    private static final String LEGACY_ARG_PLACEHOLDER = "{}";
    private final InternalLogger internalLogger;
    private final String loggerName;

    @Override // com.datadog.trace.logger.Logger
    public boolean isDebugEnabled() {
        return false;
    }

    @Override // com.datadog.trace.logger.Logger
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // com.datadog.trace.logger.Logger
    public boolean isWarnEnabled() {
        return true;
    }

    static String generateLogMessage(String str, String str2, Object... objArr) {
        String strReplace = str2.replace(LEGACY_ARG_PLACEHOLDER, "%s");
        return String.format(Locale.US, str + ": " + strReplace, objArr);
    }

    static String bundleMessageWithTitle(String str, String str2) {
        return String.format(Locale.US, "%s: %s", str, str2);
    }

    public DatadogCoreTracerLogger(String str, InternalLogger internalLogger) {
        this.internalLogger = internalLogger;
        this.loggerName = str;
    }

    @Override // com.datadog.trace.logger.Logger
    public void debug(final String str) {
        this.internalLogger.log(InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11229lambda$debug$0$comdatadogtraceloggerDatadogCoreTracerLogger(str);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$debug$0$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11229lambda$debug$0$comdatadogtraceloggerDatadogCoreTracerLogger(String str) {
        return bundleMessageWithTitle(this.loggerName, str);
    }

    @Override // com.datadog.trace.logger.Logger
    public void debug(final String str, final Object obj) {
        this.internalLogger.log(InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11230lambda$debug$1$comdatadogtraceloggerDatadogCoreTracerLogger(str, obj);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$debug$1$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11230lambda$debug$1$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object obj) {
        return generateLogMessage(this.loggerName, str, obj);
    }

    @Override // com.datadog.trace.logger.Logger
    public void debug(final String str, final Object obj, final Object obj2) {
        this.internalLogger.log(InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11231lambda$debug$2$comdatadogtraceloggerDatadogCoreTracerLogger(str, obj, obj2);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$debug$2$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11231lambda$debug$2$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object obj, Object obj2) {
        return generateLogMessage(this.loggerName, str, obj, obj2);
    }

    @Override // com.datadog.trace.logger.Logger
    public void debug(final String str, final Object... objArr) {
        this.internalLogger.log(InternalLogger.Level.DEBUG, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11232lambda$debug$3$comdatadogtraceloggerDatadogCoreTracerLogger(str, objArr);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$debug$3$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11232lambda$debug$3$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object[] objArr) {
        return generateLogMessage(this.loggerName, str, objArr);
    }

    @Override // com.datadog.trace.logger.Logger
    public void debug(final String str, Throwable th) {
        this.internalLogger.log(InternalLogger.Level.DEBUG, Arrays.asList(InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY), new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11233lambda$debug$4$comdatadogtraceloggerDatadogCoreTracerLogger(str);
            }
        }, th, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$debug$4$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11233lambda$debug$4$comdatadogtraceloggerDatadogCoreTracerLogger(String str) {
        return bundleMessageWithTitle(this.loggerName, str);
    }

    @Override // com.datadog.trace.logger.Logger
    public void info(final String str) {
        this.internalLogger.log(InternalLogger.Level.INFO, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11239lambda$info$5$comdatadogtraceloggerDatadogCoreTracerLogger(str);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$info$5$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11239lambda$info$5$comdatadogtraceloggerDatadogCoreTracerLogger(String str) {
        return bundleMessageWithTitle(this.loggerName, str);
    }

    @Override // com.datadog.trace.logger.Logger
    public void info(final String str, final Object obj) {
        this.internalLogger.log(InternalLogger.Level.INFO, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11240lambda$info$6$comdatadogtraceloggerDatadogCoreTracerLogger(str, obj);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$info$6$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11240lambda$info$6$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object obj) {
        return generateLogMessage(this.loggerName, str, obj);
    }

    @Override // com.datadog.trace.logger.Logger
    public void info(final String str, final Object obj, final Object obj2) {
        this.internalLogger.log(InternalLogger.Level.INFO, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11241lambda$info$7$comdatadogtraceloggerDatadogCoreTracerLogger(str, obj, obj2);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$info$7$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11241lambda$info$7$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object obj, Object obj2) {
        return generateLogMessage(this.loggerName, str, obj, obj2);
    }

    @Override // com.datadog.trace.logger.Logger
    public void info(final String str, final Object... objArr) {
        this.internalLogger.log(InternalLogger.Level.INFO, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11242lambda$info$8$comdatadogtraceloggerDatadogCoreTracerLogger(str, objArr);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$info$8$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11242lambda$info$8$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object[] objArr) {
        return generateLogMessage(this.loggerName, str, objArr);
    }

    @Override // com.datadog.trace.logger.Logger
    public void info(final String str, Throwable th) {
        this.internalLogger.log(InternalLogger.Level.INFO, Arrays.asList(InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY), new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11243lambda$info$9$comdatadogtraceloggerDatadogCoreTracerLogger(str);
            }
        }, th, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$info$9$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11243lambda$info$9$comdatadogtraceloggerDatadogCoreTracerLogger(String str) {
        return bundleMessageWithTitle(this.loggerName, str);
    }

    @Override // com.datadog.trace.logger.Logger
    public void warn(final String str) {
        this.internalLogger.log(InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11244lambda$warn$10$comdatadogtraceloggerDatadogCoreTracerLogger(str);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$warn$10$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11244lambda$warn$10$comdatadogtraceloggerDatadogCoreTracerLogger(String str) {
        return bundleMessageWithTitle(this.loggerName, str);
    }

    @Override // com.datadog.trace.logger.Logger
    public void warn(final String str, final Object obj) {
        this.internalLogger.log(InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11245lambda$warn$11$comdatadogtraceloggerDatadogCoreTracerLogger(str, obj);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$warn$11$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11245lambda$warn$11$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object obj) {
        return generateLogMessage(this.loggerName, str, obj);
    }

    @Override // com.datadog.trace.logger.Logger
    public void warn(final String str, final Object obj, final Object obj2) {
        this.internalLogger.log(InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11246lambda$warn$12$comdatadogtraceloggerDatadogCoreTracerLogger(str, obj, obj2);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$warn$12$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11246lambda$warn$12$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object obj, Object obj2) {
        return generateLogMessage(this.loggerName, str, obj, obj2);
    }

    @Override // com.datadog.trace.logger.Logger
    public void warn(final String str, final Object... objArr) {
        this.internalLogger.log(InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11247lambda$warn$13$comdatadogtraceloggerDatadogCoreTracerLogger(str, objArr);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$warn$13$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11247lambda$warn$13$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object[] objArr) {
        return generateLogMessage(this.loggerName, str, objArr);
    }

    @Override // com.datadog.trace.logger.Logger
    public void warn(final String str, Throwable th) {
        this.internalLogger.log(InternalLogger.Level.WARN, Arrays.asList(InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY), new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11248lambda$warn$14$comdatadogtraceloggerDatadogCoreTracerLogger(str);
            }
        }, th, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$warn$14$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11248lambda$warn$14$comdatadogtraceloggerDatadogCoreTracerLogger(String str) {
        return bundleMessageWithTitle(this.loggerName, str);
    }

    @Override // com.datadog.trace.logger.Logger
    public void error(final String str) {
        this.internalLogger.log(InternalLogger.Level.ERROR, Arrays.asList(InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY), new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11234lambda$error$15$comdatadogtraceloggerDatadogCoreTracerLogger(str);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$error$15$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11234lambda$error$15$comdatadogtraceloggerDatadogCoreTracerLogger(String str) {
        return bundleMessageWithTitle(this.loggerName, str);
    }

    @Override // com.datadog.trace.logger.Logger
    public void error(final String str, final Object obj) {
        this.internalLogger.log(InternalLogger.Level.ERROR, Arrays.asList(InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY), new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11235lambda$error$16$comdatadogtraceloggerDatadogCoreTracerLogger(str, obj);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$error$16$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11235lambda$error$16$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object obj) {
        return generateLogMessage(this.loggerName, str, obj);
    }

    @Override // com.datadog.trace.logger.Logger
    public void error(final String str, final Object obj, final Object obj2) {
        this.internalLogger.log(InternalLogger.Level.ERROR, Arrays.asList(InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY), new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11236lambda$error$17$comdatadogtraceloggerDatadogCoreTracerLogger(str, obj, obj2);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$error$17$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11236lambda$error$17$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object obj, Object obj2) {
        return generateLogMessage(this.loggerName, str, obj, obj2);
    }

    @Override // com.datadog.trace.logger.Logger
    public void error(final String str, final Object... objArr) {
        this.internalLogger.log(InternalLogger.Level.ERROR, Arrays.asList(InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY), new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11237lambda$error$18$comdatadogtraceloggerDatadogCoreTracerLogger(str, objArr);
            }
        }, (Throwable) null, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$error$18$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11237lambda$error$18$comdatadogtraceloggerDatadogCoreTracerLogger(String str, Object[] objArr) {
        return generateLogMessage(this.loggerName, str, objArr);
    }

    @Override // com.datadog.trace.logger.Logger
    public void error(final String str, Throwable th) {
        this.internalLogger.log(InternalLogger.Level.ERROR, Arrays.asList(InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY), new Function0() { // from class: com.datadog.trace.logger.DatadogCoreTracerLogger$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m11238lambda$error$19$comdatadogtraceloggerDatadogCoreTracerLogger(str);
            }
        }, th, false, (Map<String, ? extends Object>) null);
    }

    /* JADX INFO: renamed from: lambda$error$19$com-datadog-trace-logger-DatadogCoreTracerLogger, reason: not valid java name */
    /* synthetic */ String m11238lambda$error$19$comdatadogtraceloggerDatadogCoreTracerLogger(String str) {
        return bundleMessageWithTitle(this.loggerName, str);
    }
}
