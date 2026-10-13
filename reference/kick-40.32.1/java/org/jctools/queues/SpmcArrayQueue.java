package org.jctools.queues;

import java.util.Iterator;
import org.jctools.util.UnsafeRefArrayAccess;

/* JADX INFO: loaded from: classes11.dex */
public class SpmcArrayQueue<E> extends SpmcArrayQueueL3Pad<E> {
    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return super.currentProducerIndex();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public SpmcArrayQueue(int i) {
        super(i);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw null;
        }
        E[] eArr = this.buffer;
        long j = this.mask;
        long jLvProducerIndex = lvProducerIndex();
        long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLvProducerIndex, j);
        if (UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset) != null) {
            if (jLvProducerIndex - lvConsumerIndex() > j) {
                return false;
            }
            while (UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset) != null) {
            }
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, e);
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

    private E removeElement(E[] eArr, long j, long j2) {
        long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(j, j2);
        E e = (E) UnsafeRefArrayAccess.lpRefElement(eArr, jCalcCircularRefElementOffset);
        UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, null);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        E[] eArr = this.buffer;
        long j = this.mask;
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
            E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(jLvConsumerIndex, j));
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
        E[] eArr = this.buffer;
        long j = this.mask;
        long jLpProducerIndex = lpProducerIndex();
        long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpProducerIndex, j);
        if (UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset) != null) {
            return false;
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, e);
        soProducerIndex(jLpProducerIndex + 1);
        return true;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        return poll();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        E[] eArr = this.buffer;
        long j = this.mask;
        long jLvConsumerIndex = lvConsumerIndex();
        while (true) {
            E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(jLvConsumerIndex, j));
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
        int i2 = 0;
        if (i == 0) {
            return 0;
        }
        E[] eArr = this.buffer;
        long j = this.mask;
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
        while (i2 < iMin) {
            SpmcArrayQueue<E> spmcArrayQueue = this;
            consumer.accept(spmcArrayQueue.removeElement(eArr, ((long) i2) + jLvConsumerIndex, j));
            i2++;
            this = spmcArrayQueue;
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
        E[] eArr = this.buffer;
        long j = this.mask;
        long jLpProducerIndex = lpProducerIndex();
        for (int i2 = 0; i2 < i; i2++) {
            long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpProducerIndex, j);
            if (UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset) != null) {
                return i2;
            }
            jLpProducerIndex++;
            UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, supplier.get());
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
