package io.ktor.client.plugins.logging;

import io.ktor.client.HttpClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

/* JADX INFO: compiled from: LoggerJvm.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0006\u001a\u00020\u0000*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\n\u001a\u00020\u0000*\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0005¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/logging/Logger;", "getAndroidLogger", "()Lio/ktor/client/plugins/logging/Logger;", "Lio/ktor/client/plugins/logging/Logger$Companion;", "getDEFAULT", "(Lio/ktor/client/plugins/logging/Logger$Companion;)Lio/ktor/client/plugins/logging/Logger;", "DEFAULT", "ANDROID$delegate", "Lkotlin/Lazy;", "getANDROID", "ANDROID", "ktor-client-logging"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LoggerJvmKt {
    private static final Lazy ANDROID$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.client.plugins.logging.LoggerJvmKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return LoggerJvmKt.getAndroidLogger();
        }
    });

    public static final Logger getDEFAULT(Logger.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new Logger() { // from class: io.ktor.client.plugins.logging.LoggerJvmKt$DEFAULT$1
            private final org.slf4j.Logger delegate;

            {
                org.slf4j.Logger logger = LoggerFactory.getLogger((Class<?>) HttpClient.class);
                Intrinsics.checkNotNull(logger);
                this.delegate = logger;
            }

            @Override // io.ktor.client.plugins.logging.Logger
            public void log(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                this.delegate.info(message);
            }
        };
    }

    public static final Logger getANDROID(Logger.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return (Logger) ANDROID$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Logger getAndroidLogger() {
        Logger logger = getDEFAULT(Logger.INSTANCE);
        try {
            Class<?> cls = Class.forName("android.util.Log");
            if (!(LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory)) {
                return new MessageLengthLimitingLogger(0, 0, logger, 3, null);
            }
            Intrinsics.checkNotNull(cls);
            return new MessageLengthLimitingLogger(0, 0, new LogcatLogger(cls, logger), 3, null);
        } catch (ClassNotFoundException unused) {
            return new MessageLengthLimitingLogger(0, 0, logger, 3, null);
        }
    }
}
