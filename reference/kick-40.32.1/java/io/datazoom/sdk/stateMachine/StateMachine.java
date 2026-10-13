package io.datazoom.sdk.stateMachine;

import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import io.datazoom.sdk.time.Time;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000b\u001a\u00020\u0003H&J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0007H&JC\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00032'\b\u0002\u0010\u001c\u001a!\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\t0!0\u001dj\u0002`\"2\b\b\u0002\u0010#\u001a\u00020\u0010H&J\b\u0010$\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016¨\u0006%À\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/stateMachine/StateMachine;", "", "currentState", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "getCurrentState", "()Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "defineState", "", "mapping", "Lio/datazoom/sdk/stateMachine/StateMapping;", "setInitialState", "state", "stateHistory", "", "Lio/datazoom/sdk/stateMachine/Transition;", "stateTime", "", "currentTime", "clearHistory", "transitions", "Lkotlinx/coroutines/flow/SharedFlow;", "getTransitions", "()Lkotlinx/coroutines/flow/SharedFlow;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_ERRORS_KEY, "", "getErrors", "setState", "newState", "payload", "Ljava/util/HashMap;", "", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "timestamp", "finish", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StateMachine {
    void clearHistory();

    void defineState(StateMapping mapping);

    void finish();

    State getCurrentState();

    SharedFlow<Throwable> getErrors();

    SharedFlow<Transition> getTransitions();

    void setInitialState(State state);

    void setState(State newState, HashMap<String, Object> payload, long timestamp);

    List<Transition> stateHistory(State state);

    long stateTime(State state, long currentTime);

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ long stateTime$default(StateMachine stateMachine, State state, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stateTime");
        }
        if ((i & 2) != 0) {
            j = Time.INSTANCE.now();
        }
        return stateMachine.stateTime(state, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void setState$default(StateMachine stateMachine, State state, HashMap map, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setState");
        }
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        if ((i & 4) != 0) {
            j = Time.INSTANCE.now();
        }
        stateMachine.setState(state, map, j);
    }
}
