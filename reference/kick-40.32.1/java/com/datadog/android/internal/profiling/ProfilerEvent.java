package com.datadog.android.internal.profiling;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfilerEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/internal/profiling/ProfilerEvent;", "", "()V", "RumAnrEvent", "RumLongTaskEvent", "RumVitalEvent", "TTIDNotTracked", "Lcom/datadog/android/internal/profiling/ProfilerEvent$RumAnrEvent;", "Lcom/datadog/android/internal/profiling/ProfilerEvent$RumLongTaskEvent;", "Lcom/datadog/android/internal/profiling/ProfilerEvent$RumVitalEvent;", "Lcom/datadog/android/internal/profiling/ProfilerEvent$TTIDNotTracked;", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ProfilerEvent {
    public /* synthetic */ ProfilerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProfilerEvent() {
    }

    /* JADX INFO: compiled from: ProfilerEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/datadog/android/internal/profiling/ProfilerEvent$TTIDNotTracked;", "Lcom/datadog/android/internal/profiling/ProfilerEvent;", "()V", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TTIDNotTracked extends ProfilerEvent {
        public static final TTIDNotTracked INSTANCE = new TTIDNotTracked();

        private TTIDNotTracked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ProfilerEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/internal/profiling/ProfilerEvent$RumAnrEvent;", "Lcom/datadog/android/internal/profiling/ProfilerEvent;", "id", "", "startMs", "", "durationNs", "rumContext", "Lcom/datadog/android/internal/profiling/ProfilingRumContext;", "(Ljava/lang/String;JJLcom/datadog/android/internal/profiling/ProfilingRumContext;)V", "getDurationNs", "()J", "getId", "()Ljava/lang/String;", "getRumContext", "()Lcom/datadog/android/internal/profiling/ProfilingRumContext;", "getStartMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class RumAnrEvent extends ProfilerEvent {
        private final long durationNs;
        private final String id;
        private final ProfilingRumContext rumContext;
        private final long startMs;

        public static /* synthetic */ RumAnrEvent copy$default(RumAnrEvent rumAnrEvent, String str, long j, long j2, ProfilingRumContext profilingRumContext, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rumAnrEvent.id;
            }
            if ((i & 2) != 0) {
                j = rumAnrEvent.startMs;
            }
            if ((i & 4) != 0) {
                j2 = rumAnrEvent.durationNs;
            }
            if ((i & 8) != 0) {
                profilingRumContext = rumAnrEvent.rumContext;
            }
            ProfilingRumContext profilingRumContext2 = profilingRumContext;
            return rumAnrEvent.copy(str, j, j2, profilingRumContext2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getStartMs() {
            return this.startMs;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getDurationNs() {
            return this.durationNs;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ProfilingRumContext getRumContext() {
            return this.rumContext;
        }

        public final RumAnrEvent copy(String id, long startMs, long durationNs, ProfilingRumContext rumContext) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(rumContext, "rumContext");
            return new RumAnrEvent(id, startMs, durationNs, rumContext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RumAnrEvent)) {
                return false;
            }
            RumAnrEvent rumAnrEvent = (RumAnrEvent) other;
            return Intrinsics.areEqual(this.id, rumAnrEvent.id) && this.startMs == rumAnrEvent.startMs && this.durationNs == rumAnrEvent.durationNs && Intrinsics.areEqual(this.rumContext, rumAnrEvent.rumContext);
        }

        public int hashCode() {
            return (((((this.id.hashCode() * 31) + Long.hashCode(this.startMs)) * 31) + Long.hashCode(this.durationNs)) * 31) + this.rumContext.hashCode();
        }

        public String toString() {
            return "RumAnrEvent(id=" + this.id + ", startMs=" + this.startMs + ", durationNs=" + this.durationNs + ", rumContext=" + this.rumContext + ")";
        }

        public final String getId() {
            return this.id;
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public final long getDurationNs() {
            return this.durationNs;
        }

        public final ProfilingRumContext getRumContext() {
            return this.rumContext;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RumAnrEvent(String id, long j, long j2, ProfilingRumContext rumContext) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(rumContext, "rumContext");
            this.id = id;
            this.startMs = j;
            this.durationNs = j2;
            this.rumContext = rumContext;
        }
    }

    /* JADX INFO: compiled from: ProfilerEvent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/internal/profiling/ProfilerEvent$RumLongTaskEvent;", "Lcom/datadog/android/internal/profiling/ProfilerEvent;", "id", "", "startMs", "", "durationNs", "rumContext", "Lcom/datadog/android/internal/profiling/ProfilingRumContext;", "(Ljava/lang/String;JJLcom/datadog/android/internal/profiling/ProfilingRumContext;)V", "getDurationNs", "()J", "getId", "()Ljava/lang/String;", "getRumContext", "()Lcom/datadog/android/internal/profiling/ProfilingRumContext;", "getStartMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class RumLongTaskEvent extends ProfilerEvent {
        private final long durationNs;
        private final String id;
        private final ProfilingRumContext rumContext;
        private final long startMs;

        public static /* synthetic */ RumLongTaskEvent copy$default(RumLongTaskEvent rumLongTaskEvent, String str, long j, long j2, ProfilingRumContext profilingRumContext, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rumLongTaskEvent.id;
            }
            if ((i & 2) != 0) {
                j = rumLongTaskEvent.startMs;
            }
            if ((i & 4) != 0) {
                j2 = rumLongTaskEvent.durationNs;
            }
            if ((i & 8) != 0) {
                profilingRumContext = rumLongTaskEvent.rumContext;
            }
            ProfilingRumContext profilingRumContext2 = profilingRumContext;
            return rumLongTaskEvent.copy(str, j, j2, profilingRumContext2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getStartMs() {
            return this.startMs;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getDurationNs() {
            return this.durationNs;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ProfilingRumContext getRumContext() {
            return this.rumContext;
        }

        public final RumLongTaskEvent copy(String id, long startMs, long durationNs, ProfilingRumContext rumContext) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(rumContext, "rumContext");
            return new RumLongTaskEvent(id, startMs, durationNs, rumContext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RumLongTaskEvent)) {
                return false;
            }
            RumLongTaskEvent rumLongTaskEvent = (RumLongTaskEvent) other;
            return Intrinsics.areEqual(this.id, rumLongTaskEvent.id) && this.startMs == rumLongTaskEvent.startMs && this.durationNs == rumLongTaskEvent.durationNs && Intrinsics.areEqual(this.rumContext, rumLongTaskEvent.rumContext);
        }

        public int hashCode() {
            return (((((this.id.hashCode() * 31) + Long.hashCode(this.startMs)) * 31) + Long.hashCode(this.durationNs)) * 31) + this.rumContext.hashCode();
        }

        public String toString() {
            return "RumLongTaskEvent(id=" + this.id + ", startMs=" + this.startMs + ", durationNs=" + this.durationNs + ", rumContext=" + this.rumContext + ")";
        }

        public final String getId() {
            return this.id;
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public final long getDurationNs() {
            return this.durationNs;
        }

        public final ProfilingRumContext getRumContext() {
            return this.rumContext;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RumLongTaskEvent(String id, long j, long j2, ProfilingRumContext rumContext) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(rumContext, "rumContext");
            this.id = id;
            this.startMs = j;
            this.durationNs = j2;
            this.rumContext = rumContext;
        }
    }

    /* JADX INFO: compiled from: ProfilerEvent.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001%B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/datadog/android/internal/profiling/ProfilerEvent$RumVitalEvent;", "Lcom/datadog/android/internal/profiling/ProfilerEvent;", "id", "", "name", "type", "Lcom/datadog/android/internal/profiling/ProfilerEvent$RumVitalEvent$Type;", "startMs", "", "durationNs", "rumContext", "Lcom/datadog/android/internal/profiling/ProfilingRumContext;", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/internal/profiling/ProfilerEvent$RumVitalEvent$Type;JJLcom/datadog/android/internal/profiling/ProfilingRumContext;)V", "getDurationNs", "()J", "getId", "()Ljava/lang/String;", "getName", "getRumContext", "()Lcom/datadog/android/internal/profiling/ProfilingRumContext;", "getStartMs", "getType", "()Lcom/datadog/android/internal/profiling/ProfilerEvent$RumVitalEvent$Type;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Type", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class RumVitalEvent extends ProfilerEvent {
        private final long durationNs;
        private final String id;
        private final String name;
        private final ProfilingRumContext rumContext;
        private final long startMs;
        private final Type type;

        /* JADX INFO: compiled from: ProfilerEvent.kt */
        /* JADX INFO: loaded from: classes6.dex */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/datadog/android/internal/profiling/ProfilerEvent$RumVitalEvent$Type;", "", "(Ljava/lang/String;I)V", "TTID", "TTFD", "OPERATION", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum Type {
            TTID,
            TTFD,
            OPERATION
        }

        public static /* synthetic */ RumVitalEvent copy$default(RumVitalEvent rumVitalEvent, String str, String str2, Type type, long j, long j2, ProfilingRumContext profilingRumContext, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rumVitalEvent.id;
            }
            if ((i & 2) != 0) {
                str2 = rumVitalEvent.name;
            }
            if ((i & 4) != 0) {
                type = rumVitalEvent.type;
            }
            if ((i & 8) != 0) {
                j = rumVitalEvent.startMs;
            }
            if ((i & 16) != 0) {
                j2 = rumVitalEvent.durationNs;
            }
            if ((i & 32) != 0) {
                profilingRumContext = rumVitalEvent.rumContext;
            }
            ProfilingRumContext profilingRumContext2 = profilingRumContext;
            long j3 = j2;
            Type type2 = type;
            return rumVitalEvent.copy(str, str2, type2, j, j3, profilingRumContext2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getStartMs() {
            return this.startMs;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getDurationNs() {
            return this.durationNs;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ProfilingRumContext getRumContext() {
            return this.rumContext;
        }

        public final RumVitalEvent copy(String id, String name, Type type, long startMs, long durationNs, ProfilingRumContext rumContext) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(rumContext, "rumContext");
            return new RumVitalEvent(id, name, type, startMs, durationNs, rumContext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RumVitalEvent)) {
                return false;
            }
            RumVitalEvent rumVitalEvent = (RumVitalEvent) other;
            return Intrinsics.areEqual(this.id, rumVitalEvent.id) && Intrinsics.areEqual(this.name, rumVitalEvent.name) && this.type == rumVitalEvent.type && this.startMs == rumVitalEvent.startMs && this.durationNs == rumVitalEvent.durationNs && Intrinsics.areEqual(this.rumContext, rumVitalEvent.rumContext);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.startMs)) * 31) + Long.hashCode(this.durationNs)) * 31) + this.rumContext.hashCode();
        }

        public String toString() {
            return "RumVitalEvent(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", startMs=" + this.startMs + ", durationNs=" + this.durationNs + ", rumContext=" + this.rumContext + ")";
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final Type getType() {
            return this.type;
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public final long getDurationNs() {
            return this.durationNs;
        }

        public final ProfilingRumContext getRumContext() {
            return this.rumContext;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RumVitalEvent(String id, String str, Type type, long j, long j2, ProfilingRumContext rumContext) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(rumContext, "rumContext");
            this.id = id;
            this.name = str;
            this.type = type;
            this.startMs = j;
            this.durationNs = j2;
            this.rumContext = rumContext;
        }
    }
}
