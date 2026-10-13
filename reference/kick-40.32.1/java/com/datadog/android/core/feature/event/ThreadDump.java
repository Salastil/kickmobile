package com.datadog.android.core.feature.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThreadDump.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/core/feature/event/ThreadDump;", "", "name", "", "state", "stack", "crashed", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCrashed", "()Z", "getName", "()Ljava/lang/String;", "getStack", "getState", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ThreadDump {
    private final boolean crashed;
    private final String name;
    private final String stack;
    private final String state;

    public static /* synthetic */ ThreadDump copy$default(ThreadDump threadDump, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = threadDump.name;
        }
        if ((i & 2) != 0) {
            str2 = threadDump.state;
        }
        if ((i & 4) != 0) {
            str3 = threadDump.stack;
        }
        if ((i & 8) != 0) {
            z = threadDump.crashed;
        }
        return threadDump.copy(str, str2, str3, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStack() {
        return this.stack;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCrashed() {
        return this.crashed;
    }

    public final ThreadDump copy(String name, String state, String stack, boolean crashed) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(stack, "stack");
        return new ThreadDump(name, state, stack, crashed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadDump)) {
            return false;
        }
        ThreadDump threadDump = (ThreadDump) other;
        return Intrinsics.areEqual(this.name, threadDump.name) && Intrinsics.areEqual(this.state, threadDump.state) && Intrinsics.areEqual(this.stack, threadDump.stack) && this.crashed == threadDump.crashed;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.state.hashCode()) * 31) + this.stack.hashCode()) * 31) + Boolean.hashCode(this.crashed);
    }

    public String toString() {
        return "ThreadDump(name=" + this.name + ", state=" + this.state + ", stack=" + this.stack + ", crashed=" + this.crashed + ")";
    }

    public ThreadDump(String name, String state, String stack, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.name = name;
        this.state = state;
        this.stack = stack;
        this.crashed = z;
    }

    public final String getName() {
        return this.name;
    }

    public final String getState() {
        return this.state;
    }

    public final String getStack() {
        return this.stack;
    }

    public final boolean getCrashed() {
        return this.crashed;
    }
}
