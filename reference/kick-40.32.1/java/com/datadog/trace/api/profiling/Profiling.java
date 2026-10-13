package com.datadog.trace.api.profiling;

/* JADX INFO: loaded from: classes6.dex */
public interface Profiling {

    public static final class NoOp implements Profiling {
        public static final NoOp INSTANCE = new NoOp();
    }

    default ProfilingScope newScope() {
        return ProfilingScope.NO_OP;
    }

    default ProfilingContextAttribute createContextAttribute(String str) {
        return ProfilingContextAttribute.NoOp.INSTANCE;
    }
}
