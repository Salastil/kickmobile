package com.datadog.trace.logger;

import com.datadog.android.api.InternalLogger;

/* JADX INFO: loaded from: classes6.dex */
public interface ILoggerFactory {
    Logger getLogger(String str);

    Logger getLogger(String str, InternalLogger internalLogger);
}
