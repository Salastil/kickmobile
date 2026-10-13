package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* JADX INFO: compiled from: MpUnboundedXaddArrayQueue.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class MpUnboundedXaddArrayQueueProducerFields<E> extends MpUnboundedXaddArrayQueuePad1<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpUnboundedXaddArrayQueueProducerFields.class, "producerIndex");
    private volatile long producerIndex;

    MpUnboundedXaddArrayQueueProducerFields() {
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final long getAndIncrementProducerIndex() {
        return UnsafeAccess.UNSAFE.getAndAddLong(this, P_INDEX_OFFSET, 1L);
    }

    final long getAndAddProducerIndex(long j) {
        return UnsafeAccess.UNSAFE.getAndAddLong(this, P_INDEX_OFFSET, j);
    }
}
