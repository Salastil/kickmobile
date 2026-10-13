package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: SpmcAtomicArrayQueue.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class SpmcAtomicArrayQueueConsumerIndexField<E> extends SpmcAtomicArrayQueueL2Pad<E> {
    private static final AtomicLongFieldUpdater<SpmcAtomicArrayQueueConsumerIndexField> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(SpmcAtomicArrayQueueConsumerIndexField.class, "consumerIndex");
    private volatile long consumerIndex;

    SpmcAtomicArrayQueueConsumerIndexField(int i) {
        super(i);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    final boolean casConsumerIndex(long j, long j2) {
        return C_INDEX_UPDATER.compareAndSet(this, j, j2);
    }
}
