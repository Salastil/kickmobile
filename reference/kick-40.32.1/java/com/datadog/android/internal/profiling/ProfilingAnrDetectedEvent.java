package com.datadog.android.internal.profiling;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfilingAnrDetectedEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/datadog/android/internal/profiling/ProfilingAnrDetectedEvent;", "", "detectedAtMs", "", "anrThreadStack", "", "Ljava/lang/StackTraceElement;", "anrThreadName", "", "anrThreadState", "Ljava/lang/Thread$State;", "allThreads", "Lcom/datadog/android/internal/profiling/ProfilingThreadDump;", "(JLjava/util/List;Ljava/lang/String;Ljava/lang/Thread$State;Ljava/util/List;)V", "getAllThreads", "()Ljava/util/List;", "getAnrThreadName", "()Ljava/lang/String;", "getAnrThreadStack", "getAnrThreadState", "()Ljava/lang/Thread$State;", "getDetectedAtMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProfilingAnrDetectedEvent {
    private final List<ProfilingThreadDump> allThreads;
    private final String anrThreadName;
    private final List<StackTraceElement> anrThreadStack;
    private final Thread.State anrThreadState;
    private final long detectedAtMs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfilingAnrDetectedEvent copy$default(ProfilingAnrDetectedEvent profilingAnrDetectedEvent, long j, List list, String str, Thread.State state, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = profilingAnrDetectedEvent.detectedAtMs;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            list = profilingAnrDetectedEvent.anrThreadStack;
        }
        List list3 = list;
        if ((i & 4) != 0) {
            str = profilingAnrDetectedEvent.anrThreadName;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            state = profilingAnrDetectedEvent.anrThreadState;
        }
        Thread.State state2 = state;
        if ((i & 16) != 0) {
            list2 = profilingAnrDetectedEvent.allThreads;
        }
        return profilingAnrDetectedEvent.copy(j2, list3, str2, state2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDetectedAtMs() {
        return this.detectedAtMs;
    }

    public final List<StackTraceElement> component2() {
        return this.anrThreadStack;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAnrThreadName() {
        return this.anrThreadName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Thread.State getAnrThreadState() {
        return this.anrThreadState;
    }

    public final List<ProfilingThreadDump> component5() {
        return this.allThreads;
    }

    public final ProfilingAnrDetectedEvent copy(long detectedAtMs, List<StackTraceElement> anrThreadStack, String anrThreadName, Thread.State anrThreadState, List<ProfilingThreadDump> allThreads) {
        Intrinsics.checkNotNullParameter(anrThreadStack, "anrThreadStack");
        Intrinsics.checkNotNullParameter(anrThreadName, "anrThreadName");
        Intrinsics.checkNotNullParameter(anrThreadState, "anrThreadState");
        Intrinsics.checkNotNullParameter(allThreads, "allThreads");
        return new ProfilingAnrDetectedEvent(detectedAtMs, anrThreadStack, anrThreadName, anrThreadState, allThreads);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfilingAnrDetectedEvent)) {
            return false;
        }
        ProfilingAnrDetectedEvent profilingAnrDetectedEvent = (ProfilingAnrDetectedEvent) other;
        return this.detectedAtMs == profilingAnrDetectedEvent.detectedAtMs && Intrinsics.areEqual(this.anrThreadStack, profilingAnrDetectedEvent.anrThreadStack) && Intrinsics.areEqual(this.anrThreadName, profilingAnrDetectedEvent.anrThreadName) && this.anrThreadState == profilingAnrDetectedEvent.anrThreadState && Intrinsics.areEqual(this.allThreads, profilingAnrDetectedEvent.allThreads);
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.detectedAtMs) * 31) + this.anrThreadStack.hashCode()) * 31) + this.anrThreadName.hashCode()) * 31) + this.anrThreadState.hashCode()) * 31) + this.allThreads.hashCode();
    }

    public String toString() {
        return "ProfilingAnrDetectedEvent(detectedAtMs=" + this.detectedAtMs + ", anrThreadStack=" + this.anrThreadStack + ", anrThreadName=" + this.anrThreadName + ", anrThreadState=" + this.anrThreadState + ", allThreads=" + this.allThreads + ")";
    }

    public ProfilingAnrDetectedEvent(long j, List<StackTraceElement> anrThreadStack, String anrThreadName, Thread.State anrThreadState, List<ProfilingThreadDump> allThreads) {
        Intrinsics.checkNotNullParameter(anrThreadStack, "anrThreadStack");
        Intrinsics.checkNotNullParameter(anrThreadName, "anrThreadName");
        Intrinsics.checkNotNullParameter(anrThreadState, "anrThreadState");
        Intrinsics.checkNotNullParameter(allThreads, "allThreads");
        this.detectedAtMs = j;
        this.anrThreadStack = anrThreadStack;
        this.anrThreadName = anrThreadName;
        this.anrThreadState = anrThreadState;
        this.allThreads = allThreads;
    }

    public final long getDetectedAtMs() {
        return this.detectedAtMs;
    }

    public final List<StackTraceElement> getAnrThreadStack() {
        return this.anrThreadStack;
    }

    public final String getAnrThreadName() {
        return this.anrThreadName;
    }

    public final Thread.State getAnrThreadState() {
        return this.anrThreadState;
    }

    public final List<ProfilingThreadDump> getAllThreads() {
        return this.allThreads;
    }
}
