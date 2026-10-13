package com.datadog.trace.api.profiling;

/* JADX INFO: loaded from: classes6.dex */
public interface Timer {

    public enum TimerType {
        QUEUEING
    }

    Timing start(TimerType timerType);

    public static final class NoOp implements Timer {
        public static final Timer INSTANCE = new NoOp();

        @Override // com.datadog.trace.api.profiling.Timer
        public Timing start(TimerType timerType) {
            return Timing.NoOp.INSTANCE;
        }
    }
}
