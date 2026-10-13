package com.datadog.android.core.internal.time;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.rum.internal.RumFeature;
import com.lyft.kronos.SyncListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggingSyncListener.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/datadog/android/core/internal/time/LoggingSyncListener;", "Lcom/lyft/kronos/SyncListener;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "onError", "", LogAttributes.HOST, "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "onStartSync", "onSuccess", "ticksDelta", "", "responseTimeMs", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LoggingSyncListener implements SyncListener {
    private final InternalLogger internalLogger;

    @Override // com.lyft.kronos.SyncListener
    public void onStartSync(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
    }

    @Override // com.lyft.kronos.SyncListener
    public void onSuccess(long ticksDelta, long responseTimeMs) {
    }

    public LoggingSyncListener(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.lyft.kronos.SyncListener
    public void onError(final String host, Throwable throwable) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.time.LoggingSyncListener.onError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Kronos onError @host:" + host;
            }
        }, throwable, false, (Map) null, 48, (Object) null);
    }
}
