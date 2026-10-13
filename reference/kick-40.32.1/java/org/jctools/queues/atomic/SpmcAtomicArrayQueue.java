package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MessagePassingQueueUtil;

/* JADX INFO: loaded from: classes11.dex */
public class SpmcAtomicArrayQueue<E> extends SpmcAtomicArrayQueueL3Pad<E> {
    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public SpmcAtomicArrayQueue(int i) {
        super(i);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw null;
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i = this.mask;
        long jLvProducerIndex = lvProducerIndex();
        long j = i;
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLvProducerIndex, j);
        if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset) != null) {
            if (jLvProducerIndex - lvConsumerIndex() > j) {
                return false;
            }
            while (AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset) != null) {
            }
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, e);
        soProducerIndex(jLvProducerIndex + 1);
        return true;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        long jLvConsumerIndex;
        long jLvProducerIndexCache = lvProducerIndexCache();
        do {
            jLvConsumerIndex = lvConsumerIndex();
            if (jLvConsumerIndex >= jLvProducerIndexCache) {
                jLvProducerIndexCache = lvProducerIndex();
                if (jLvConsumerIndex >= jLvProducerIndexCache) {
                    return null;
                }
                svProducerIndexCache(jLvProducerIndexCache);
            }
        } while (!casConsumerIndex(jLvConsumerIndex, 1 + jLvConsumerIndex));
        return removeElement(this.buffer, jLvConsumerIndex, this.mask);
    }

    private E removeElement(AtomicReferenceArray<E> atomicReferenceArray, long j, int i) {
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(j, i);
        E e = (E) AtomicQueueUtil.lpRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i = this.mask;
        long jLvProducerIndexCache = lvProducerIndexCache();
        long jLvConsumerIndex = lvConsumerIndex();
        while (true) {
            if (jLvConsumerIndex >= jLvProducerIndexCache) {
                jLvProducerIndexCache = lvProducerIndex();
                if (jLvConsumerIndex >= jLvProducerIndexCache) {
                    return null;
                }
                svProducerIndexCache(jLvProducerIndexCache);
            }
            E e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(jLvConsumerIndex, i));
            long jLvConsumerIndex2 = lvConsumerIndex();
            if (e != null && jLvConsumerIndex2 == jLvConsumerIndex) {
                return e;
            }
            jLvConsumerIndex = jLvConsumerIndex2;
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i = this.mask;
        long jLpProducerIndex = lpProducerIndex();
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpProducerIndex, i);
        if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset) != null) {
            return false;
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, e);
        soProducerIndex(jLpProducerIndex + 1);
        return true;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        return poll();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i = this.mask;
        long jLvConsumerIndex = lvConsumerIndex();
        while (true) {
            E e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(jLvConsumerIndex, i));
            long jLvConsumerIndex2 = lvConsumerIndex();
            if (jLvConsumerIndex2 == jLvConsumerIndex) {
                return e;
            }
            jLvConsumerIndex = jLvConsumerIndex2;
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        long jLvConsumerIndex;
        int iMin;
        if (consumer == null) {
            throw new IllegalArgumentException("c is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("limit is negative: " + i);
        }
        if (i == 0) {
            return 0;
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i2 = this.mask;
        long jLvProducerIndexCache = lvProducerIndexCache();
        do {
            jLvConsumerIndex = lvConsumerIndex();
            if (jLvConsumerIndex >= jLvProducerIndexCache) {
                jLvProducerIndexCache = lvProducerIndex();
                if (jLvConsumerIndex >= jLvProducerIndexCache) {
                    return 0;
                }
                svProducerIndexCache(jLvProducerIndexCache);
            }
            iMin = Math.min((int) (jLvProducerIndexCache - jLvConsumerIndex), i);
        } while (!casConsumerIndex(jLvConsumerIndex, ((long) iMin) + jLvConsumerIndex));
        for (int i3 = 0; i3 < iMin; i3++) {
            consumer.accept(removeElement(atomicReferenceArray, ((long) i3) + jLvConsumerIndex, i2));
        }
        return iMin;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("limit is negative:" + i);
        }
        if (i == 0) {
            return 0;
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i2 = this.mask;
        long jLpProducerIndex = lpProducerIndex();
        for (int i3 = 0; i3 < i; i3++) {
            int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpProducerIndex, i2);
            if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset) != null) {
                return i3;
            }
            jLpProducerIndex++;
            AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, supplier.get());
            soProducerIndex(jLpProducerIndex);
        }
        return i;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return MessagePassingQueueUtil.drain(this, consumer);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return fill(supplier, capacity());
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.drain(this, consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        MessagePassingQueueUtil.fill(this, supplier, waitStrategy, exitCondition);
    }
}
