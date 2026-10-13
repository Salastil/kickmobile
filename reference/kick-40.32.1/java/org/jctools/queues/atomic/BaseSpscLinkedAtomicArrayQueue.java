package org.jctools.queues.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.IndexedQueueSizeUtil;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MessagePassingQueueUtil;
import org.jctools.queues.QueueProgressIndicators;
import org.jctools.util.PortableJvmInfo;

/* JADX INFO: loaded from: classes11.dex */
abstract class BaseSpscLinkedAtomicArrayQueue<E> extends BaseSpscLinkedAtomicArrayQueueProducerColdFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final Object JUMP = new Object();

    abstract boolean offerColdPath(AtomicReferenceArray<E> atomicReferenceArray, long j, long j2, int i, E e, MessagePassingQueue.Supplier<? extends E> supplier);

    BaseSpscLinkedAtomicArrayQueue() {
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

    protected final void soNext(AtomicReferenceArray<E> atomicReferenceArray, AtomicReferenceArray<E> atomicReferenceArray2) {
        AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.nextArrayOffset(atomicReferenceArray), atomicReferenceArray2);
    }

    protected final AtomicReferenceArray<E> lvNextArrayAndUnlink(AtomicReferenceArray<E> atomicReferenceArray) {
        int iNextArrayOffset = AtomicQueueUtil.nextArrayOffset(atomicReferenceArray);
        AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iNextArrayOffset);
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iNextArrayOffset, null);
        return atomicReferenceArray2;
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
        BaseSpscLinkedAtomicArrayQueue<E> baseSpscLinkedAtomicArrayQueue;
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
            AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
            long jLpProducerIndex = this.lpProducerIndex();
            long j = this.producerMask;
            int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpProducerIndex, j);
            if (jLpProducerIndex < this.producerBufferLimit) {
                baseSpscLinkedAtomicArrayQueue = this;
                baseSpscLinkedAtomicArrayQueue.writeToQueue(atomicReferenceArray, supplier.get(), jLpProducerIndex, iCalcCircularRefElementOffset);
                supplier2 = supplier;
            } else {
                baseSpscLinkedAtomicArrayQueue = this;
                supplier2 = supplier;
                if (!baseSpscLinkedAtomicArrayQueue.offerColdPath(atomicReferenceArray, j, jLpProducerIndex, iCalcCircularRefElementOffset, null, supplier2)) {
                    return i2;
                }
            }
            i2++;
            this = baseSpscLinkedAtomicArrayQueue;
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
        AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
        long jLpProducerIndex = lpProducerIndex();
        long j = this.producerMask;
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpProducerIndex, j);
        if (jLpProducerIndex < this.producerBufferLimit) {
            writeToQueue(atomicReferenceArray, e, jLpProducerIndex, iCalcCircularRefElementOffset);
            return true;
        }
        return offerColdPath(atomicReferenceArray, j, jLpProducerIndex, iCalcCircularRefElementOffset, e, null);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpConsumerIndex, this.consumerMask);
        E e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
        boolean z = e == JUMP;
        if (e == null || z) {
            if (z) {
                return newBufferPoll(atomicReferenceArray, jLpConsumerIndex);
            }
            return null;
        }
        soConsumerIndex(jLpConsumerIndex + 1);
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        E e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(jLpConsumerIndex, this.consumerMask));
        return e == JUMP ? newBufferPeek(atomicReferenceArray, jLpConsumerIndex) : e;
    }

    final void linkOldToNew(long j, AtomicReferenceArray<E> atomicReferenceArray, int i, AtomicReferenceArray<E> atomicReferenceArray2, int i2, E e) {
        AtomicQueueUtil.soRefElement(atomicReferenceArray2, i2, e);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        AtomicQueueUtil.soRefElement(atomicReferenceArray, i, JUMP);
        soProducerIndex(j + 1);
    }

    final void writeToQueue(AtomicReferenceArray<E> atomicReferenceArray, E e, long j, int i) {
        AtomicQueueUtil.soRefElement(atomicReferenceArray, i, e);
        soProducerIndex(j + 1);
    }

    private E newBufferPeek(AtomicReferenceArray<E> atomicReferenceArray, long j) {
        AtomicReferenceArray<E> atomicReferenceArrayLvNextArrayAndUnlink = lvNextArrayAndUnlink(atomicReferenceArray);
        this.consumerBuffer = atomicReferenceArrayLvNextArrayAndUnlink;
        long length = AtomicQueueUtil.length(atomicReferenceArrayLvNextArrayAndUnlink) - 2;
        this.consumerMask = length;
        return (E) AtomicQueueUtil.lvRefElement(atomicReferenceArrayLvNextArrayAndUnlink, AtomicQueueUtil.calcCircularRefElementOffset(j, length));
    }

    private E newBufferPoll(AtomicReferenceArray<E> atomicReferenceArray, long j) {
        AtomicReferenceArray<E> atomicReferenceArrayLvNextArrayAndUnlink = lvNextArrayAndUnlink(atomicReferenceArray);
        this.consumerBuffer = atomicReferenceArrayLvNextArrayAndUnlink;
        long length = AtomicQueueUtil.length(atomicReferenceArrayLvNextArrayAndUnlink) - 2;
        this.consumerMask = length;
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(j, length);
        E e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArrayLvNextArrayAndUnlink, iCalcCircularRefElementOffset);
        if (e == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        soConsumerIndex(j + 1);
        AtomicQueueUtil.soRefElement(atomicReferenceArrayLvNextArrayAndUnlink, iCalcCircularRefElementOffset, null);
        return e;
    }
}
