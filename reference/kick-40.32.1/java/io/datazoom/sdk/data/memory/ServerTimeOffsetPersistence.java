package io.datazoom.sdk.data.memory;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ServerTimeOffsetPersistence.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J \u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/datazoom/sdk/data/memory/ServerTimeOffsetPersistence;", "", "<init>", "()V", "_serverTimeOffset", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getServerTimeOffset", "setServerTimeOffset", "", "requestTime", "responseTime", "serverTime", "calculateTimeOffset", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ServerTimeOffsetPersistence {
    public static final ServerTimeOffsetPersistence INSTANCE = new ServerTimeOffsetPersistence();
    private static final MutableStateFlow<Long> _serverTimeOffset = StateFlowKt.MutableStateFlow(0L);

    private ServerTimeOffsetPersistence() {
    }

    public final long getServerTimeOffset() {
        return _serverTimeOffset.getValue().longValue();
    }

    public final void setServerTimeOffset(long requestTime, long responseTime, long serverTime) {
        _serverTimeOffset.setValue(Long.valueOf(calculateTimeOffset(requestTime, responseTime, serverTime)));
    }

    private final long calculateTimeOffset(long requestTime, long responseTime, long serverTime) {
        return (serverTime - responseTime) - ((responseTime - requestTime) / 2);
    }
}
