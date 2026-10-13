package com.datadog.android.internal.telemetry;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TracingHeaderTypesSet.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/datadog/android/internal/telemetry/TracingHeaderTypesSet;", "", "types", "", "Lcom/datadog/android/internal/telemetry/TracingHeaderType;", "(Ljava/util/Set;)V", "getTypes", "()Ljava/util/Set;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TracingHeaderTypesSet {
    private final Set<TracingHeaderType> types;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TracingHeaderTypesSet copy$default(TracingHeaderTypesSet tracingHeaderTypesSet, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = tracingHeaderTypesSet.types;
        }
        return tracingHeaderTypesSet.copy(set);
    }

    public final Set<TracingHeaderType> component1() {
        return this.types;
    }

    public final TracingHeaderTypesSet copy(Set<? extends TracingHeaderType> types) {
        Intrinsics.checkNotNullParameter(types, "types");
        return new TracingHeaderTypesSet(types);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TracingHeaderTypesSet) && Intrinsics.areEqual(this.types, ((TracingHeaderTypesSet) other).types);
    }

    public int hashCode() {
        return this.types.hashCode();
    }

    public String toString() {
        return "TracingHeaderTypesSet(types=" + this.types + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TracingHeaderTypesSet(Set<? extends TracingHeaderType> types) {
        Intrinsics.checkNotNullParameter(types, "types");
        this.types = types;
    }

    public final Set<TracingHeaderType> getTypes() {
        return this.types;
    }
}
