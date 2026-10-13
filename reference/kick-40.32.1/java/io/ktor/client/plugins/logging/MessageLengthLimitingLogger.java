package io.ktor.client.plugins.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LoggerJvm.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\u0010¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/logging/MessageLengthLimitingLogger;", "Lio/ktor/client/plugins/logging/Logger;", "", "maxLength", "minLength", "delegate", "<init>", "(IILio/ktor/client/plugins/logging/Logger;)V", "", "message", "", "log", "(Ljava/lang/String;)V", "logLong", "I", "Lio/ktor/client/plugins/logging/Logger;", "ktor-client-logging"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MessageLengthLimitingLogger implements Logger {
    private final Logger delegate;
    private final int maxLength;
    private final int minLength;

    public MessageLengthLimitingLogger() {
        this(0, 0, null, 7, null);
    }

    public MessageLengthLimitingLogger(int i, int i2, Logger delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.maxLength = i;
        this.minLength = i2;
        this.delegate = delegate;
    }

    public /* synthetic */ MessageLengthLimitingLogger(int i, int i2, Logger logger, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 4000 : i, (i3 & 2) != 0 ? 3000 : i2, (i3 & 4) != 0 ? LoggerJvmKt.getDEFAULT(Logger.INSTANCE) : logger);
    }

    @Override // io.ktor.client.plugins.logging.Logger
    public void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        logLong(message);
    }

    private final void logLong(String message) {
        while (true) {
            int length = message.length();
            int i = this.maxLength;
            if (length > i) {
                String strSubstring = message.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                int i2 = this.maxLength;
                int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) strSubstring, '\n', 0, false, 6, (Object) null);
                if (iLastIndexOf$default >= this.minLength) {
                    strSubstring = strSubstring.substring(0, iLastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    i2 = iLastIndexOf$default + 1;
                }
                this.delegate.log(strSubstring);
                message = message.substring(i2);
                Intrinsics.checkNotNullExpressionValue(message, "substring(...)");
            } else {
                this.delegate.log(message);
                return;
            }
        }
    }
}
