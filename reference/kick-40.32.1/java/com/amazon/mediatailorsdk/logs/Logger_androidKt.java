package com.amazon.mediatailorsdk.logs;

import kotlin.Metadata;

/* JADX INFO: compiled from: Logger.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"getLogger", "Lcom/amazon/mediatailorsdk/logs/Logger;", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class Logger_androidKt {
    public static final Logger getLogger() {
        return AndroidLogger.INSTANCE;
    }
}
