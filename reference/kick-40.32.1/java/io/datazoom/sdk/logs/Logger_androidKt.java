package io.datazoom.sdk.logs;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: Logger.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"getLogger", "Lio/datazoom/sdk/logs/Logger;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class Logger_androidKt {
    public static final Logger getLogger() {
        return AndroidLogger.INSTANCE;
    }
}
