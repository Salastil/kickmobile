package org.jctools.queues.spec;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated
public final class ConcurrentQueueSpec {
    public final int capacity;
    public final int consumers;
    public final Ordering ordering;
    public final Preference preference;
    public final int producers;

    public static ConcurrentQueueSpec createBoundedSpsc(int i) {
        return new ConcurrentQueueSpec(1, 1, i, Ordering.FIFO, Preference.NONE);
    }

    public static ConcurrentQueueSpec createBoundedMpsc(int i) {
        return new ConcurrentQueueSpec(0, 1, i, Ordering.FIFO, Preference.NONE);
    }

    public static ConcurrentQueueSpec createBoundedSpmc(int i) {
        return new ConcurrentQueueSpec(1, 0, i, Ordering.FIFO, Preference.NONE);
    }

    public static ConcurrentQueueSpec createBoundedMpmc(int i) {
        return new ConcurrentQueueSpec(0, 0, i, Ordering.FIFO, Preference.NONE);
    }

    public ConcurrentQueueSpec(int i, int i2, int i3, Ordering ordering, Preference preference) {
        this.producers = i;
        this.consumers = i2;
        this.capacity = i3 < 1 ? -1 : i3;
        this.ordering = ordering;
        this.preference = preference;
    }

    public boolean isSpsc() {
        return this.consumers == 1 && this.producers == 1;
    }

    public boolean isMpsc() {
        return this.consumers == 1 && this.producers != 1;
    }

    public boolean isSpmc() {
        return this.consumers != 1 && this.producers == 1;
    }

    public boolean isMpmc() {
        return (this.consumers == 1 || this.producers == 1) ? false : true;
    }

    public boolean isBounded() {
        return this.capacity != -1;
    }
}
