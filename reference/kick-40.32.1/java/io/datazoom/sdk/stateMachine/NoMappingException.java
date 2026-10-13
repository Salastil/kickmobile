package io.datazoom.sdk.stateMachine;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lio/datazoom/sdk/stateMachine/NoMappingException;", "", "oldState", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "newState", "<init>", "(Lio/datazoom/sdk/stateMachine/timeSync/model/State;Lio/datazoom/sdk/stateMachine/timeSync/model/State;)V", "getOldState", "()Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "getNewState", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class NoMappingException extends Throwable {
    private final State newState;
    private final State oldState;

    public static /* synthetic */ NoMappingException copy$default(NoMappingException noMappingException, State state, State state2, int i, Object obj) {
        if ((i & 1) != 0) {
            state = noMappingException.oldState;
        }
        if ((i & 2) != 0) {
            state2 = noMappingException.newState;
        }
        return noMappingException.copy(state, state2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final State getOldState() {
        return this.oldState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final State getNewState() {
        return this.newState;
    }

    public final NoMappingException copy(State oldState, State newState) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        return new NoMappingException(oldState, newState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoMappingException)) {
            return false;
        }
        NoMappingException noMappingException = (NoMappingException) other;
        return Intrinsics.areEqual(this.oldState, noMappingException.oldState) && Intrinsics.areEqual(this.newState, noMappingException.newState);
    }

    public int hashCode() {
        return (this.oldState.hashCode() * 31) + this.newState.hashCode();
    }

    public final State getOldState() {
        return this.oldState;
    }

    public final State getNewState() {
        return this.newState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoMappingException(State oldState, State newState) {
        super("No mapping found for state " + newState.log() + " from " + oldState.log());
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        this.oldState = oldState;
        this.newState = newState;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "No mapping found for state " + this.newState.log() + " from " + this.oldState.log();
    }
}
