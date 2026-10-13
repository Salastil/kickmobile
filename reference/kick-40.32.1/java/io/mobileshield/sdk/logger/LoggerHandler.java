package io.mobileshield.sdk.logger;

import com.google.android.gms.cast.MediaError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lio/mobileshield/sdk/logger/LoggerHandler;", "", "log", "", "logEvent", "Lio/mobileshield/sdk/logger/LogEvent;", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface LoggerHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int ERROR = 2;
    public static final int INFO = 8;
    public static final int VERBOSE = 16;
    public static final int WARNING = 4;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/mobileshield/sdk/logger/LoggerHandler$Companion;", "", "()V", MediaError.ERROR_TYPE_ERROR, "", "INFO", "VERBOSE", "WARNING", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ERROR = 2;
        public static final int INFO = 8;
        public static final int VERBOSE = 16;
        public static final int WARNING = 4;

        private Companion() {
        }
    }

    void log(LogEvent logEvent);
}
