package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* JADX INFO: compiled from: MpscBlockingConsumerArrayQueue.java */
/* JADX INFO: loaded from: classes11.dex */
abstract class MpscBlockingConsumerArrayQueueConsumerFields<E> extends MpscBlockingConsumerArrayQueuePad3<E> {
    private volatile Thread blocked;
    protected final E[] consumerBuffer;
    private volatile long consumerIndex;
    protected final long consumerMask;
    private static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpscBlockingConsumerArrayQueueConsumerFields.class, "consumerIndex");
    private static final long BLOCKED_OFFSET = UnsafeAccess.fieldOffset(MpscBlockingConsumerArrayQueueConsumerFields.class, "blocked");

    MpscBlockingConsumerArrayQueueConsumerFields(long j, E[] eArr) {
        super(j, eArr);
        this.consumerMask = j;
        this.consumerBuffer = eArr;
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    final long lpConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, C_INDEX_OFFSET);
    }

    final void soConsumerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j);
    }

    final Thread lvBlocked() {
        return this.blocked;
    }

    final void soBlocked(Thread thread) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, BLOCKED_OFFSET, thread);
    }
}
