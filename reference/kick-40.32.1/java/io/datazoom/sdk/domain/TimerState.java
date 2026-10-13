package io.datazoom.sdk.domain;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.time.Time;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TakeCareJob.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0019"}, d2 = {"Lio/datazoom/sdk/domain/TimerState;", "", "state", "Lio/datazoom/sdk/domain/TimerState$State;", "time", "", "<init>", "(Lio/datazoom/sdk/domain/TimerState$State;J)V", "getState", "()Lio/datazoom/sdk/domain/TimerState$State;", "getTime", "()J", "isRunning", "", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "State", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class TimerState {
    private final State state;
    private final long time;

    /* JADX INFO: compiled from: TakeCareJob.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/domain/TimerState$State;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "STOPPED", "PULSE", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum State {
        STARTED,
        STOPPED,
        PULSE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ TimerState copy$default(TimerState timerState, State state, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            state = timerState.state;
        }
        if ((i & 2) != 0) {
            j = timerState.time;
        }
        return timerState.copy(state, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final TimerState copy(State state, long time) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new TimerState(state, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimerState)) {
            return false;
        }
        TimerState timerState = (TimerState) other;
        return this.state == timerState.state && this.time == timerState.time;
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "TimerState(state=" + this.state + ", time=" + this.time + ")";
    }

    public TimerState(State state, long j) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.time = j;
    }

    public /* synthetic */ TimerState(State state, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, (i & 2) != 0 ? Time.INSTANCE.now() : j);
    }

    public final State getState() {
        return this.state;
    }

    public final long getTime() {
        return this.time;
    }

    public final boolean isRunning() {
        return this.state == State.STARTED || this.state == State.PULSE;
    }
}
