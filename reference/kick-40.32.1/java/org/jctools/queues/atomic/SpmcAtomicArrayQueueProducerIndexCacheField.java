package org.jctools.queues.atomic;

/* JADX INFO: compiled from: SpmcAtomicArrayQueue.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class SpmcAtomicArrayQueueProducerIndexCacheField<E> extends SpmcAtomicArrayQueueMidPad<E> {
    private volatile long producerIndexCache;

    SpmcAtomicArrayQueueProducerIndexCacheField(int i) {
        super(i);
    }

    protected final long lvProducerIndexCache() {
        return this.producerIndexCache;
    }

    protected final void svProducerIndexCache(long j) {
        this.producerIndexCache = j;
    }
}
