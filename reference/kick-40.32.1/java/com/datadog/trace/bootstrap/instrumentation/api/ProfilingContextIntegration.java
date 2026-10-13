package com.datadog.trace.bootstrap.instrumentation.api;

import com.datadog.trace.api.Stateful;
import com.datadog.trace.api.profiling.Profiling;
import com.datadog.trace.api.profiling.ProfilingContextAttribute;
import com.datadog.trace.api.profiling.ProfilingScope;

/* JADX INFO: loaded from: classes6.dex */
public interface ProfilingContextIntegration extends Profiling {
    default int encode(CharSequence charSequence) {
        return 0;
    }

    default int encodeOperationName(CharSequence charSequence) {
        return 0;
    }

    default int encodeResourceName(CharSequence charSequence) {
        return 0;
    }

    String name();

    default void onAttach() {
    }

    default void onDetach() {
    }

    default void onStart() {
    }

    default Stateful newScopeState(ProfilerContext profilerContext) {
        return Stateful.DEFAULT;
    }

    public static final class NoOp implements ProfilingContextIntegration {
        public static final ProfilingContextIntegration INSTANCE = new NoOp();

        @Override // com.datadog.trace.bootstrap.instrumentation.api.ProfilingContextIntegration
        public void onAttach() {
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.ProfilingContextIntegration
        public void onDetach() {
        }

        @Override // com.datadog.trace.api.profiling.Profiling
        public ProfilingContextAttribute createContextAttribute(String str) {
            return ProfilingContextAttribute.NoOp.INSTANCE;
        }

        @Override // com.datadog.trace.api.profiling.Profiling
        public ProfilingScope newScope() {
            return ProfilingScope.NO_OP;
        }

        @Override // com.datadog.trace.bootstrap.instrumentation.api.ProfilingContextIntegration
        public String name() {
            return "none";
        }
    }
}
