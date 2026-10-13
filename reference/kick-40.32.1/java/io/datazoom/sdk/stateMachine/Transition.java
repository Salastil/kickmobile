package io.datazoom.sdk.stateMachine;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import io.datazoom.sdk.time.Time;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BJ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012'\b\u0002\u0010\u0005\u001a!\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0006j\u0002`\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0017\u001a\u00020\u0007H\u0096\u0080\u0004J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J(\u0010\u001a\u001a!\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0006j\u0002`\u000bHÆ\u0003J\t\u0010\u001b\u001a\u00020\rHÆ\u0003JP\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032'\b\u0002\u0010\u0005\u001a!\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0006j\u0002`\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R0\u0010\u0005\u001a!\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\t0\n0\u0006j\u0002`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lio/datazoom/sdk/stateMachine/Transition;", "", "oldState", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "newState", "payload", "Ljava/util/HashMap;", "", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "timestamp", "", "<init>", "(Lio/datazoom/sdk/stateMachine/timeSync/model/State;Lio/datazoom/sdk/stateMachine/timeSync/model/State;Ljava/util/HashMap;J)V", "getOldState", "()Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "getNewState", "getPayload", "()Ljava/util/HashMap;", "getTimestamp", "()J", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Transition {
    private final State newState;
    private final State oldState;
    private final HashMap<String, Object> payload;
    private final long timestamp;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Transition copy$default(Transition transition, State state, State state2, HashMap map, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            state = transition.oldState;
        }
        if ((i & 2) != 0) {
            state2 = transition.newState;
        }
        if ((i & 4) != 0) {
            map = transition.payload;
        }
        if ((i & 8) != 0) {
            j = transition.timestamp;
        }
        HashMap map2 = map;
        return transition.copy(state, state2, map2, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final State getOldState() {
        return this.oldState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final State getNewState() {
        return this.newState;
    }

    public final HashMap<String, Object> component3() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Transition copy(State oldState, State newState, HashMap<String, Object> payload, long timestamp) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new Transition(oldState, newState, payload, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Transition)) {
            return false;
        }
        Transition transition = (Transition) other;
        return Intrinsics.areEqual(this.oldState, transition.oldState) && Intrinsics.areEqual(this.newState, transition.newState) && Intrinsics.areEqual(this.payload, transition.payload) && this.timestamp == transition.timestamp;
    }

    public int hashCode() {
        return (((((this.oldState.hashCode() * 31) + this.newState.hashCode()) * 31) + this.payload.hashCode()) * 31) + Long.hashCode(this.timestamp);
    }

    public Transition(State oldState, State newState, HashMap<String, Object> payload, long j) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.oldState = oldState;
        this.newState = newState;
        this.payload = payload;
        this.timestamp = j;
    }

    public final State getOldState() {
        return this.oldState;
    }

    public final State getNewState() {
        return this.newState;
    }

    public /* synthetic */ Transition(State state, State state2, HashMap map, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, state2, (i & 4) != 0 ? new HashMap() : map, (i & 8) != 0 ? Time.INSTANCE.now() : j);
    }

    public final HashMap<String, Object> getPayload() {
        return this.payload;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return "Transition(oldState=" + this.oldState.log() + ", newState=" + this.newState.log() + ", payload=" + this.payload + ", timestamp=" + this.timestamp + ")";
    }
}
