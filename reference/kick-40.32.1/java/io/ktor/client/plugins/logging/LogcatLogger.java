package io.ktor.client.plugins.logging;

import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggerJvm.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/logging/LogcatLogger;", "Lio/ktor/client/plugins/logging/Logger;", "Ljava/lang/Class;", "logClass", "fallback", "<init>", "(Ljava/lang/Class;Lio/ktor/client/plugins/logging/Logger;)V", "", "message", "", "log", "(Ljava/lang/String;)V", "Lio/ktor/client/plugins/logging/Logger;", "tag", "Ljava/lang/String;", "Ljava/lang/reflect/Method;", FirebaseAnalytics.Param.METHOD, "Ljava/lang/reflect/Method;", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class LogcatLogger implements Logger {
    private final Logger fallback;
    private final Method method;
    private final String tag;

    public LogcatLogger(Class<?> logClass, Logger fallback) {
        Method declaredMethod;
        Intrinsics.checkNotNullParameter(logClass, "logClass");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        this.fallback = fallback;
        this.tag = "Ktor Client";
        try {
            declaredMethod = logClass.getDeclaredMethod(ContextChain.TAG_INFRA, String.class, String.class);
        } catch (Throwable unused) {
            declaredMethod = null;
        }
        this.method = declaredMethod;
    }

    @Override // io.ktor.client.plugins.logging.Logger
    public void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Method method = this.method;
        if (method == null) {
            this.fallback.log(message);
            return;
        }
        try {
            method.invoke(null, this.tag, message);
        } catch (Throwable unused) {
            this.fallback.log(message);
        }
    }
}
