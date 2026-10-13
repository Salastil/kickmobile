package org.jctools.queues;

import java.util.Iterator;
import org.jctools.util.PortableJvmInfo;
import org.jctools.util.UnsafeRefArrayAccess;

/* JADX INFO: loaded from: classes11.dex */
abstract class BaseSpscLinkedArrayQueue<E> extends BaseSpscLinkedArrayQueueProducerColdFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final Object JUMP = new Object();

    abstract boolean offerColdPath(E[] eArr, long j, long j2, long j3, E e, MessagePassingQueue.Supplier<? extends E> supplier);

    BaseSpscLinkedArrayQueue() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    protected final void soNext(E[] eArr, E[] eArr2) {
        UnsafeRefArrayAccess.soRefElement(eArr, LinkedArrayQueueUtil.nextArrayOffset(eArr), eArr2);
    }

    protected final E[] lvNextArrayAndUnlink(E[] eArr) {
        long jNextArrayOffset = LinkedArrayQueueUtil.nextArrayOffset(eArr);
        E[] eArr2 = (E[]) ((Object[]) UnsafeRefArrayAccess.lvRefElement(eArr, jNextArrayOffset));
        UnsafeRefArrayAccess.soRefElement(eArr, jNextArrayOffset, null);
        return eArr2;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        return poll();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return peek();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return MessagePassingQueueUtil.drain(this, consumer);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        int iCapacity = capacity();
        long j = 0;
        do {
            int iFill = fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (iFill == 0) {
                return (int) j;
            }
            j += (long) iFill;
        } while (j <= iCapacity);
        return (int) j;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        return MessagePassingQueueUtil.drain(this, consumer, i);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        BaseSpscLinkedArrayQueue<E> baseSpscLinkedArrayQueue;
        MessagePassingQueue.Supplier<E> supplier2;
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("limit is negative:" + i);
        }
        int i2 = 0;
        if (i == 0) {
            return 0;
        }
        while (i2 < i) {
            E[] eArr = this.producerBuffer;
            long jLpProducerIndex = this.lpProducerIndex();
            long j = this.producerMask;
            long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpProducerIndex, j);
            if (jLpProducerIndex < this.producerBufferLimit) {
                baseSpscLinkedArrayQueue = this;
                baseSpscLinkedArrayQueue.writeToQueue(eArr, supplier.get(), jLpProducerIndex, jCalcCircularRefElementOffset);
                supplier2 = supplier;
            } else {
                baseSpscLinkedArrayQueue = this;
                supplier2 = supplier;
                if (!baseSpscLinkedArrayQueue.offerColdPath(eArr, j, jLpProducerIndex, jCalcCircularRefElementOffset, null, supplier2)) {
                    return i2;
                }
            }
            i2++;
            this = baseSpscLinkedArrayQueue;
            supplier = supplier2;
        }
        return i;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw null;
        }
        E[] eArr = this.producerBuffer;
        long jLpProducerIndex = lpProducerIndex();
        long j = this.producerMask;
        long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpProducerIndex, j);
        if (jLpProducerIndex < this.producerBufferLimit) {
            writeToQueue(eArr, e, jLpProducerIndex, jCalcCircularRefElementOffset);
            return true;
        }
        return offerColdPath(eArr, j, jLpProducerIndex, jCalcCircularRefElementOffset, e, null);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        E[] eArr = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpConsumerIndex, this.consumerMask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset);
        boolean z = e == JUMP;
        if (e == null || z) {
            if (z) {
                return newBufferPoll(eArr, jLpConsumerIndex);
            }
            return null;
        }
        soConsumerIndex(jLpConsumerIndex + 1);
        UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, null);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        E[] eArr = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpConsumerIndex, this.consumerMask));
        return e == JUMP ? newBufferPeek(eArr, jLpConsumerIndex) : e;
    }

    final void linkOldToNew(long j, E[] eArr, long j2, E[] eArr2, long j3, E e) {
        UnsafeRefArrayAccess.soRefElement(eArr2, j3, e);
        soNext(eArr, eArr2);
        UnsafeRefArrayAccess.soRefElement(eArr, j2, JUMP);
        soProducerIndex(j + 1);
    }

    final void writeToQueue(E[] eArr, E e, long j, long j2) {
        UnsafeRefArrayAccess.soRefElement(eArr, j2, e);
        soProducerIndex(j + 1);
    }

    private E newBufferPeek(E[] eArr, long j) {
        E[] eArrLvNextArrayAndUnlink = lvNextArrayAndUnlink(eArr);
        this.consumerBuffer = eArrLvNextArrayAndUnlink;
        long length = LinkedArrayQueueUtil.length(eArrLvNextArrayAndUnlink) - 2;
        this.consumerMask = length;
        return (E) UnsafeRefArrayAccess.lvRefElement(eArrLvNextArrayAndUnlink, UnsafeRefArrayAccess.calcCircularRefElementOffset(j, length));
    }

    private E newBufferPoll(E[] eArr, long j) {
        E[] eArrLvNextArrayAndUnlink = lvNextArrayAndUnlink(eArr);
        this.consumerBuffer = eArrLvNextArrayAndUnlink;
        long length = LinkedArrayQueueUtil.length(eArrLvNextArrayAndUnlink) - 2;
        this.consumerMask = length;
        long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(j, length);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArrLvNextArrayAndUnlink, jCalcCircularRefElementOffset);
        if (e == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        soConsumerIndex(j + 1);
        UnsafeRefArrayAccess.soRefElement(eArrLvNextArrayAndUnlink, jCalcCircularRefElementOffset, null);
        return e;
    }
}
