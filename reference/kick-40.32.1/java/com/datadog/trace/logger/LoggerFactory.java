package com.datadog.trace.logger;

import com.datadog.android.api.InternalLogger;

/* JADX INFO: loaded from: classes6.dex */
public final class LoggerFactory {
    public static Logger getLogger(String str) {
        return new NoOpLogger();
    }

    public static Logger getLogger(String str, InternalLogger internalLogger) {
        return new DatadogCoreTracerLogger(str, internalLogger);
    }

    public static Logger getLogger(Class<?> cls) {
        return new NoOpLogger();
    }

    public static ILoggerFactory getILoggerFactory() {
        return new ILoggerFactory() { // from class: com.datadog.trace.logger.LoggerFactory.1
            @Override // com.datadog.trace.logger.ILoggerFactory
            public Logger getLogger(String str) {
                return new NoOpLogger();
            }

            @Override // com.datadog.trace.logger.ILoggerFactory
            public Logger getLogger(String str, InternalLogger internalLogger) {
                return new DatadogCoreTracerLogger(str, internalLogger);
            }
        };
    }
}
