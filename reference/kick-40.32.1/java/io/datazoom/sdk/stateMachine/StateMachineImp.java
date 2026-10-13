package io.datazoom.sdk.stateMachine;

import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0016J?\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\t2%\u0010'\u001a!\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\t0-0(j\u0002`.2\u0006\u0010/\u001a\u00020\u001bH\u0016J\b\u00100\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"¨\u00061"}, d2 = {"Lio/datazoom/sdk/stateMachine/StateMachineImp;", "Lio/datazoom/sdk/stateMachine/StateMachine;", "<init>", "()V", "history", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lio/datazoom/sdk/stateMachine/Transition;", "_currentState", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "errorFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "transitionFlow", "stateMappings", "", "Lio/datazoom/sdk/stateMachine/StateMapping;", "currentState", "getCurrentState", "()Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "defineState", "", "mapping", "setInitialState", "state", "stateHistory", "stateTime", "", "currentTime", "currentStateTime", "clearHistory", "transitions", "Lkotlinx/coroutines/flow/SharedFlow;", "getTransitions", "()Lkotlinx/coroutines/flow/SharedFlow;", SessionEndedMetric.NO_VIEW_EVENTS_COUNT_ERRORS_KEY, "getErrors", "setState", "newState", "payload", "Ljava/util/HashMap;", "", "", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "timestamp", "finish", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StateMachineImp implements StateMachine {
    private final MutableStateFlow<Map<State, StateMapping>> stateMappings;
    private final MutableSharedFlow<Transition> transitionFlow;
    private final SharedFlow<Transition> transitions;
    private final MutableStateFlow<List<Transition>> history = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final MutableStateFlow<State> _currentState = StateFlowKt.MutableStateFlow(State.Content.IDLE.INSTANCE);
    private final MutableSharedFlow<Throwable> errorFlow = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);

    public StateMachineImp() {
        MutableSharedFlow<Transition> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.transitionFlow = mutableSharedFlowMutableSharedFlow$default;
        this.stateMappings = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this.transitions = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public State getCurrentState() {
        return this._currentState.getValue();
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public void defineState(StateMapping mapping) {
        Map<State, StateMapping> value;
        Map<State, StateMapping> mutableMap;
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        MutableStateFlow<Map<State, StateMapping>> mutableStateFlow = this.stateMappings;
        do {
            value = mutableStateFlow.getValue();
            mutableMap = MapsKt.toMutableMap(value);
            mutableMap.put(mapping.getState(), mapping);
        } while (!mutableStateFlow.compareAndSet(value, mutableMap));
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public void setInitialState(State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this._currentState.setValue(state);
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public List<Transition> stateHistory(State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        List listSortedWith = CollectionsKt.sortedWith(this.history.getValue(), new Comparator() { // from class: io.datazoom.sdk.stateMachine.StateMachineImp$stateHistory$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((Transition) t).getTimestamp()), Long.valueOf(((Transition) t2).getTimestamp()));
            }
        });
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSortedWith) {
            Transition transition = (Transition) obj;
            if (Intrinsics.areEqual(transition.getNewState(), state) || Intrinsics.areEqual(transition.getOldState(), state)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public long stateTime(State state, long currentTime) {
        Transition transition;
        Intrinsics.checkNotNullParameter(state, "state");
        Iterator<T> it = stateHistory(state).iterator();
        long timestamp = 0;
        loop0: while (true) {
            Long lValueOf = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                transition = (Transition) it.next();
                if (Intrinsics.areEqual(transition.getNewState(), state)) {
                    if (lValueOf == null) {
                        lValueOf = Long.valueOf(transition.getTimestamp());
                    }
                } else if (!Intrinsics.areEqual(transition.getOldState(), state) || lValueOf == null) {
                }
            }
            timestamp += transition.getTimestamp() - lValueOf.longValue();
        }
        if (timestamp < 200) {
            timestamp = 0;
        }
        return timestamp + (Intrinsics.areEqual(getCurrentState(), state) ? currentStateTime(currentTime) : 0L);
    }

    private final long currentStateTime(long currentTime) {
        Transition transitionPrevious;
        List<Transition> value = this.history.getValue();
        ListIterator<Transition> listIterator = value.listIterator(value.size());
        do {
            if (!listIterator.hasPrevious()) {
                transitionPrevious = null;
                break;
            }
            transitionPrevious = listIterator.previous();
        } while (!Intrinsics.areEqual(transitionPrevious.getNewState(), getCurrentState()));
        Transition transition = transitionPrevious;
        if (transition == null) {
            return 0L;
        }
        long timestamp = currentTime - transition.getTimestamp();
        if (timestamp < 200) {
            return 0L;
        }
        return timestamp;
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public void clearHistory() {
        MutableStateFlow<List<Transition>> mutableStateFlow = this.history;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), CollectionsKt.emptyList())) {
        }
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public SharedFlow<Transition> getTransitions() {
        return this.transitions;
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public SharedFlow<Throwable> getErrors() {
        return FlowKt.asSharedFlow(this.errorFlow);
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public void setState(State newState, HashMap<String, Object> payload, long timestamp) {
        List<Transition> value;
        Function1<Transition, Unit> onEntry;
        Set<State> transactions;
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(payload, "payload");
        State value2 = this._currentState.getValue();
        if (Intrinsics.areEqual(newState, value2)) {
            return;
        }
        Map<State, StateMapping> value3 = this.stateMappings.getValue();
        StateMapping stateMapping = value3.get(value2);
        StateMapping stateMapping2 = value3.get(newState);
        if (Intrinsics.areEqual((Object) ((stateMapping == null || (transactions = stateMapping.getTransactions()) == null) ? null : Boolean.valueOf(transactions.contains(newState))), (Object) true)) {
            Transition transition = new Transition(value2, newState, payload, timestamp);
            MutableStateFlow<List<Transition>> mutableStateFlow = this.history;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.plus((Collection<? extends Transition>) value, transition)));
            this.transitionFlow.tryEmit(transition);
            stateMapping.getOnExit().invoke(transition);
            this._currentState.setValue(newState);
            if (stateMapping2 != null && (onEntry = stateMapping2.getOnEntry()) != null) {
                onEntry.invoke(transition);
            }
            Logger_androidKt.getLogger().v("Transition: " + transition);
            return;
        }
        NoMappingException noMappingException = new NoMappingException(value2, newState);
        Logger_androidKt.getLogger().v("TransitionError: " + noMappingException);
        this.errorFlow.tryEmit(noMappingException);
    }

    @Override // io.datazoom.sdk.stateMachine.StateMachine
    public void finish() {
        MutableStateFlow<Map<State, StateMapping>> mutableStateFlow = this.stateMappings;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MapsKt.emptyMap())) {
        }
        clearHistory();
        this._currentState.setValue(State.Content.IDLE.INSTANCE);
    }
}
