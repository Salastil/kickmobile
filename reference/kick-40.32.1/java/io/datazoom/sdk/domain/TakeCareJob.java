package io.datazoom.sdk.domain;

import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: TakeCareJob.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/domain/TakeCareJob;", "", "timerTick", "Lkotlinx/coroutines/flow/SharedFlow;", "Lio/datazoom/sdk/domain/TimerState;", "getTimerTick", "()Lkotlinx/coroutines/flow/SharedFlow;", ViewProps.START, "", "intervalMs", "", "stop", "clear", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface TakeCareJob {
    void clear();

    SharedFlow<TimerState> getTimerTick();

    void start(long intervalMs);

    void stop();
}
