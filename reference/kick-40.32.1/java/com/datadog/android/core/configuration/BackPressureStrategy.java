package com.datadog.android.core.configuration;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackPressureStrategy.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/datadog/android/core/configuration/BackPressureStrategy;", "", "capacity", "", "onThresholdReached", "Lkotlin/Function0;", "", "onItemDropped", "Lkotlin/Function1;", "backpressureMitigation", "Lcom/datadog/android/core/configuration/BackPressureMitigation;", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/datadog/android/core/configuration/BackPressureMitigation;)V", "getBackpressureMitigation", "()Lcom/datadog/android/core/configuration/BackPressureMitigation;", "getCapacity", "()I", "getOnItemDropped", "()Lkotlin/jvm/functions/Function1;", "getOnThresholdReached", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BackPressureStrategy {
    private final BackPressureMitigation backpressureMitigation;
    private final int capacity;
    private final Function1<Object, Unit> onItemDropped;
    private final Function0<Unit> onThresholdReached;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackPressureStrategy copy$default(BackPressureStrategy backPressureStrategy, int i, Function0 function0, Function1 function1, BackPressureMitigation backPressureMitigation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = backPressureStrategy.capacity;
        }
        if ((i2 & 2) != 0) {
            function0 = backPressureStrategy.onThresholdReached;
        }
        if ((i2 & 4) != 0) {
            function1 = backPressureStrategy.onItemDropped;
        }
        if ((i2 & 8) != 0) {
            backPressureMitigation = backPressureStrategy.backpressureMitigation;
        }
        return backPressureStrategy.copy(i, function0, function1, backPressureMitigation);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCapacity() {
        return this.capacity;
    }

    public final Function0<Unit> component2() {
        return this.onThresholdReached;
    }

    public final Function1<Object, Unit> component3() {
        return this.onItemDropped;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final BackPressureMitigation getBackpressureMitigation() {
        return this.backpressureMitigation;
    }

    public final BackPressureStrategy copy(int capacity, Function0<Unit> onThresholdReached, Function1<Object, Unit> onItemDropped, BackPressureMitigation backpressureMitigation) {
        Intrinsics.checkNotNullParameter(onThresholdReached, "onThresholdReached");
        Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
        Intrinsics.checkNotNullParameter(backpressureMitigation, "backpressureMitigation");
        return new BackPressureStrategy(capacity, onThresholdReached, onItemDropped, backpressureMitigation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackPressureStrategy)) {
            return false;
        }
        BackPressureStrategy backPressureStrategy = (BackPressureStrategy) other;
        return this.capacity == backPressureStrategy.capacity && Intrinsics.areEqual(this.onThresholdReached, backPressureStrategy.onThresholdReached) && Intrinsics.areEqual(this.onItemDropped, backPressureStrategy.onItemDropped) && this.backpressureMitigation == backPressureStrategy.backpressureMitigation;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.capacity) * 31) + this.onThresholdReached.hashCode()) * 31) + this.onItemDropped.hashCode()) * 31) + this.backpressureMitigation.hashCode();
    }

    public String toString() {
        return "BackPressureStrategy(capacity=" + this.capacity + ", onThresholdReached=" + this.onThresholdReached + ", onItemDropped=" + this.onItemDropped + ", backpressureMitigation=" + this.backpressureMitigation + ")";
    }

    public BackPressureStrategy(int i, Function0<Unit> onThresholdReached, Function1<Object, Unit> onItemDropped, BackPressureMitigation backpressureMitigation) {
        Intrinsics.checkNotNullParameter(onThresholdReached, "onThresholdReached");
        Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
        Intrinsics.checkNotNullParameter(backpressureMitigation, "backpressureMitigation");
        this.capacity = i;
        this.onThresholdReached = onThresholdReached;
        this.onItemDropped = onItemDropped;
        this.backpressureMitigation = backpressureMitigation;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final Function0<Unit> getOnThresholdReached() {
        return this.onThresholdReached;
    }

    public final Function1<Object, Unit> getOnItemDropped() {
        return this.onItemDropped;
    }

    public final BackPressureMitigation getBackpressureMitigation() {
        return this.backpressureMitigation;
    }
}
