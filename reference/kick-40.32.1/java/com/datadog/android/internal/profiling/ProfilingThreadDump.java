package com.datadog.android.internal.profiling;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfilingThreadDump.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/internal/profiling/ProfilingThreadDump;", "", "name", "", "state", "Ljava/lang/Thread$State;", "stack", "(Ljava/lang/String;Ljava/lang/Thread$State;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getStack", "getState", "()Ljava/lang/Thread$State;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProfilingThreadDump {
    private final String name;
    private final String stack;
    private final Thread.State state;

    public static /* synthetic */ ProfilingThreadDump copy$default(ProfilingThreadDump profilingThreadDump, String str, Thread.State state, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profilingThreadDump.name;
        }
        if ((i & 2) != 0) {
            state = profilingThreadDump.state;
        }
        if ((i & 4) != 0) {
            str2 = profilingThreadDump.stack;
        }
        return profilingThreadDump.copy(str, state, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Thread.State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStack() {
        return this.stack;
    }

    public final ProfilingThreadDump copy(String name, Thread.State state, String stack) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(stack, "stack");
        return new ProfilingThreadDump(name, state, stack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfilingThreadDump)) {
            return false;
        }
        ProfilingThreadDump profilingThreadDump = (ProfilingThreadDump) other;
        return Intrinsics.areEqual(this.name, profilingThreadDump.name) && this.state == profilingThreadDump.state && Intrinsics.areEqual(this.stack, profilingThreadDump.stack);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.state.hashCode()) * 31) + this.stack.hashCode();
    }

    public String toString() {
        return "ProfilingThreadDump(name=" + this.name + ", state=" + this.state + ", stack=" + this.stack + ")";
    }

    public ProfilingThreadDump(String name, Thread.State state, String stack) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.name = name;
        this.state = state;
        this.stack = stack;
    }

    public final String getName() {
        return this.name;
    }

    public final Thread.State getState() {
        return this.state;
    }

    public final String getStack() {
        return this.stack;
    }
}
