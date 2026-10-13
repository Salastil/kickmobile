package io.ktor.client.plugins.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/plugins/logging/EmptyLogger;", "Lio/ktor/client/plugins/logging/Logger;", "<init>", "()V", "", "message", "", "log", "(Ljava/lang/String;)V", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class EmptyLogger implements Logger {
    public static final EmptyLogger INSTANCE = new EmptyLogger();

    @Override // io.ktor.client.plugins.logging.Logger
    public void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    private EmptyLogger() {
    }
}
