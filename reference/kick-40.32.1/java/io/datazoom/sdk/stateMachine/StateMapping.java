package io.datazoom.sdk.stateMachine;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u0012#\b\u0002\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J$\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003J$\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003Jm\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00072#\b\u0002\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R,\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006#"}, d2 = {"Lio/datazoom/sdk/stateMachine/StateMapping;", "", "state", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "transactions", "", "onExit", "Lkotlin/Function1;", "Lio/datazoom/sdk/stateMachine/Transition;", "Lkotlin/ParameterName;", "name", "transition", "", "onEntry", "<init>", "(Lio/datazoom/sdk/stateMachine/timeSync/model/State;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getState", "()Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "getTransactions", "()Ljava/util/Set;", "getOnExit", "()Lkotlin/jvm/functions/Function1;", "getOnEntry", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class StateMapping {
    private final Function1<Transition, Unit> onEntry;
    private final Function1<Transition, Unit> onExit;
    private final State state;
    private final Set<State> transactions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StateMapping copy$default(StateMapping stateMapping, State state, Set set, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            state = stateMapping.state;
        }
        if ((i & 2) != 0) {
            set = stateMapping.transactions;
        }
        if ((i & 4) != 0) {
            function1 = stateMapping.onExit;
        }
        if ((i & 8) != 0) {
            function2 = stateMapping.onEntry;
        }
        return stateMapping.copy(state, set, function1, function2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public final Set<State> component2() {
        return this.transactions;
    }

    public final Function1<Transition, Unit> component3() {
        return this.onExit;
    }

    public final Function1<Transition, Unit> component4() {
        return this.onEntry;
    }

    public final StateMapping copy(State state, Set<? extends State> transactions, Function1<? super Transition, Unit> onExit, Function1<? super Transition, Unit> onEntry) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        Intrinsics.checkNotNullParameter(onExit, "onExit");
        Intrinsics.checkNotNullParameter(onEntry, "onEntry");
        return new StateMapping(state, transactions, onExit, onEntry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StateMapping)) {
            return false;
        }
        StateMapping stateMapping = (StateMapping) other;
        return Intrinsics.areEqual(this.state, stateMapping.state) && Intrinsics.areEqual(this.transactions, stateMapping.transactions) && Intrinsics.areEqual(this.onExit, stateMapping.onExit) && Intrinsics.areEqual(this.onEntry, stateMapping.onEntry);
    }

    public int hashCode() {
        return (((((this.state.hashCode() * 31) + this.transactions.hashCode()) * 31) + this.onExit.hashCode()) * 31) + this.onEntry.hashCode();
    }

    public String toString() {
        return "StateMapping(state=" + this.state + ", transactions=" + this.transactions + ", onExit=" + this.onExit + ", onEntry=" + this.onEntry + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StateMapping(State state, Set<? extends State> transactions, Function1<? super Transition, Unit> onExit, Function1<? super Transition, Unit> onEntry) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        Intrinsics.checkNotNullParameter(onExit, "onExit");
        Intrinsics.checkNotNullParameter(onEntry, "onEntry");
        this.state = state;
        this.transactions = transactions;
        this.onExit = onExit;
        this.onEntry = onEntry;
    }

    public final State getState() {
        return this.state;
    }

    public final Set<State> getTransactions() {
        return this.transactions;
    }

    public /* synthetic */ StateMapping(State state, Set set, Function1 function1, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, set, (i & 4) != 0 ? new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMapping$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMapping._init_$lambda$0((Transition) obj);
            }
        } : function1, (i & 8) != 0 ? new Function1() { // from class: io.datazoom.sdk.stateMachine.StateMapping$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StateMapping._init_$lambda$1((Transition) obj);
            }
        } : function2);
    }

    static final Unit _init_$lambda$0(Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<Transition, Unit> getOnExit() {
        return this.onExit;
    }

    static final Unit _init_$lambda$1(Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<Transition, Unit> getOnEntry() {
        return this.onEntry;
    }
}
