package com.amazonaws.ivs.player;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
class Fsm<States> {
    private States currentState;
    private final Map<States, List<States>> transitions;

    Fsm(Map<States, List<States>> map, States states) {
        this.currentState = states;
        this.transitions = map;
    }

    synchronized States getCurrentState() {
        return this.currentState;
    }

    synchronized boolean isValidNextState(States states) {
        return ((List) Objects.requireNonNull(this.transitions.get(this.currentState))).contains(states);
    }

    synchronized boolean changeState(States states) {
        if (states == this.currentState || !isValidNextState(states)) {
            return false;
        }
        this.currentState = states;
        return true;
    }

    synchronized boolean compareAndSet(States states, States states2) {
        if (this.currentState != states || !isValidNextState(states2)) {
            return false;
        }
        this.currentState = states2;
        return true;
    }
}
