package io.ktor.client.plugins.logging;

import kotlin.Metadata;

/* JADX INFO: compiled from: LogBodyFilter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0001\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/client/plugins/logging/LogBodyFilter;", "BinaryLogBodyFilter", "Lio/ktor/client/plugins/logging/LogBodyFilter;", "getBinaryLogBodyFilter", "()Lio/ktor/client/plugins/logging/LogBodyFilter;", "ktor-client-logging"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LogBodyFilterKt {
    private static final LogBodyFilter BinaryLogBodyFilter = new LogBodyFilterKt$BinaryLogBodyFilter$1();

    public static final LogBodyFilter getBinaryLogBodyFilter() {
        return BinaryLogBodyFilter;
    }
}
