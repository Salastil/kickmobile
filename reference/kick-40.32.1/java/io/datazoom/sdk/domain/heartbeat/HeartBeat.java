package io.datazoom.sdk.domain.heartbeat;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.time.Time;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: HeartBeat.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0015BG\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/datazoom/sdk/domain/heartbeat/HeartBeat;", "", "fireHeartbeatEvent", "Lkotlin/Function0;", "", "getConfigInterval", "", "isContentSessionEnding", "", "isContentOrAdPlaying", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/datazoom/sdk/domain/heartbeat/HeartBeat$State;", "onPlayerStateChange", "onPlayHeadUpdate", "checkHeartbeat", "stopHeartbeat", "restartHeartbeat", "clear", "State", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeartBeat {
    private Function0<Unit> fireHeartbeatEvent;
    private Function0<Long> getConfigInterval;
    private Function0<Boolean> isContentOrAdPlaying;
    private Function0<Boolean> isContentSessionEnding;
    private final MutableStateFlow<State> state = StateFlowKt.MutableStateFlow(new State(0, false, 3, null));

    public HeartBeat(Function0<Unit> function0, Function0<Long> function1, Function0<Boolean> function2, Function0<Boolean> function3) {
        this.fireHeartbeatEvent = function0;
        this.getConfigInterval = function1;
        this.isContentSessionEnding = function2;
        this.isContentOrAdPlaying = function3;
    }

    /* JADX INFO: compiled from: HeartBeat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/datazoom/sdk/domain/heartbeat/HeartBeat$State;", "", "nextHeartbeatTime", "", "heartbeatContinuation", "", "<init>", "(JZ)V", "getNextHeartbeatTime", "()J", "getHeartbeatContinuation", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final /* data */ class State {
        private final boolean heartbeatContinuation;
        private final long nextHeartbeatTime;

        public State() {
            this(0L, false, 3, null);
        }

        public static /* synthetic */ State copy$default(State state, long j, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = state.nextHeartbeatTime;
            }
            if ((i & 2) != 0) {
                z = state.heartbeatContinuation;
            }
            return state.copy(j, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getNextHeartbeatTime() {
            return this.nextHeartbeatTime;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHeartbeatContinuation() {
            return this.heartbeatContinuation;
        }

        public final State copy(long nextHeartbeatTime, boolean heartbeatContinuation) {
            return new State(nextHeartbeatTime, heartbeatContinuation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.nextHeartbeatTime == state.nextHeartbeatTime && this.heartbeatContinuation == state.heartbeatContinuation;
        }

        public int hashCode() {
            return (Long.hashCode(this.nextHeartbeatTime) * 31) + Boolean.hashCode(this.heartbeatContinuation);
        }

        public String toString() {
            return "State(nextHeartbeatTime=" + this.nextHeartbeatTime + ", heartbeatContinuation=" + this.heartbeatContinuation + ")";
        }

        public State(long j, boolean z) {
            this.nextHeartbeatTime = j;
            this.heartbeatContinuation = z;
        }

        public /* synthetic */ State(long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? false : z);
        }

        public final long getNextHeartbeatTime() {
            return this.nextHeartbeatTime;
        }

        public final boolean getHeartbeatContinuation() {
            return this.heartbeatContinuation;
        }
    }

    public final void onPlayerStateChange() {
        Function0<Boolean> function0;
        Function0<Long> function1;
        State value;
        long nextHeartbeatTime;
        State stateCopy;
        Function0<Boolean> function2 = this.isContentSessionEnding;
        if (function2 == null || (function0 = this.isContentOrAdPlaying) == null || (function1 = this.getConfigInterval) == null) {
            return;
        }
        MutableStateFlow<State> mutableStateFlow = this.state;
        do {
            value = mutableStateFlow.getValue();
            State state = value;
            if (function2.invoke().booleanValue()) {
                stateCopy = State.copy$default(state, 0L, false, 2, null);
            } else {
                if (function0.invoke().booleanValue() && state.getNextHeartbeatTime() == 0) {
                    nextHeartbeatTime = Time.INSTANCE.now() + function1.invoke().longValue();
                } else {
                    nextHeartbeatTime = state.getNextHeartbeatTime();
                }
                stateCopy = state.copy(nextHeartbeatTime, true);
            }
        } while (!mutableStateFlow.compareAndSet(value, stateCopy));
    }

    public final void onPlayHeadUpdate() {
        Function0<Long> function0;
        State value;
        State stateCopy;
        long nextHeartbeatTime;
        Function0<Boolean> function1 = this.isContentOrAdPlaying;
        if (function1 == null || (function0 = this.getConfigInterval) == null) {
            return;
        }
        MutableStateFlow<State> mutableStateFlow = this.state;
        do {
            value = mutableStateFlow.getValue();
            stateCopy = value;
            if (function1.invoke().booleanValue()) {
                if (stateCopy.getNextHeartbeatTime() == 0) {
                    nextHeartbeatTime = Time.INSTANCE.now() + function0.invoke().longValue();
                } else {
                    nextHeartbeatTime = stateCopy.getNextHeartbeatTime();
                }
                stateCopy = stateCopy.copy(nextHeartbeatTime, true);
            }
        } while (!mutableStateFlow.compareAndSet(value, stateCopy));
    }

    public final void checkHeartbeat() {
        Function0<Long> function0;
        State value;
        State stateCopy;
        Function0<Unit> function1 = this.fireHeartbeatEvent;
        if (function1 == null || (function0 = this.getConfigInterval) == null) {
            return;
        }
        long jNow = Time.INSTANCE.now();
        MutableStateFlow<State> mutableStateFlow = this.state;
        boolean z = false;
        do {
            value = mutableStateFlow.getValue();
            stateCopy = value;
            if (stateCopy.getNextHeartbeatTime() > 0 && jNow >= stateCopy.getNextHeartbeatTime()) {
                if (stateCopy.getHeartbeatContinuation()) {
                    stateCopy = stateCopy.copy(Time.INSTANCE.now() + function0.invoke().longValue(), false);
                    z = true;
                } else {
                    stateCopy = stateCopy.copy(0L, false);
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, stateCopy));
        if (z) {
            function1.invoke();
        }
    }

    public final void stopHeartbeat() {
        MutableStateFlow<State> mutableStateFlow = this.state;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new State(0L, false))) {
        }
    }

    public final void restartHeartbeat() {
        Function0<Long> function0 = this.getConfigInterval;
        if (function0 == null) {
            return;
        }
        MutableStateFlow<State> mutableStateFlow = this.state;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new State(Time.INSTANCE.now() + function0.invoke().longValue(), true))) {
        }
    }

    public final void clear() {
        stopHeartbeat();
        this.fireHeartbeatEvent = null;
        this.getConfigInterval = null;
        this.isContentSessionEnding = null;
        this.isContentOrAdPlaying = null;
    }
}
