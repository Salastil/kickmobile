package io.datazoom.sdk.utils;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: DurationsManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/datazoom/sdk/utils/DurationsManager;", "", "<init>", "()V", "_engagementDuration", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "value", "engagementDuration", "getEngagementDuration", "()Ljava/lang/Long;", "setEngagementDuration", "(Ljava/lang/Long;)V", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DurationsManager {
    public static final DurationsManager INSTANCE = new DurationsManager();
    private static final MutableStateFlow<Long> _engagementDuration = StateFlowKt.MutableStateFlow(null);

    private DurationsManager() {
    }

    public final Long getEngagementDuration() {
        return _engagementDuration.getValue();
    }

    public final void setEngagementDuration(Long l) {
        _engagementDuration.setValue(l);
    }
}
