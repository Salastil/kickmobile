package org.jctools.queues;

import java.util.Iterator;
import org.jctools.util.UnsafeRefArrayAccess;

/* JADX INFO: loaded from: classes11.dex */
public class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
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

    public SpscArrayQueue(int i) {
        super(Math.max(i, 4));
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        SpscArrayQueue<E> spscArrayQueue;
        if (e == null) {
            throw null;
        }
        E[] eArr = this.buffer;
        long j = this.mask;
        long jLpProducerIndex = lpProducerIndex();
        if (jLpProducerIndex >= this.producerLimit) {
            spscArrayQueue = this;
            if (!spscArrayQueue.offerSlowPath(eArr, j, jLpProducerIndex)) {
                return false;
            }
        } else {
            spscArrayQueue = this;
        }
        UnsafeRefArrayAccess.soRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpProducerIndex, j), e);
        spscArrayQueue.soProducerIndex(jLpProducerIndex + 1);
        return true;
    }

    private boolean offerSlowPath(E[] eArr, long j, long j2) {
        long j3 = ((long) this.lookAheadStep) + j2;
        if (UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(j3, j)) != null) {
            return UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(j2, j)) == null;
        }
        this.producerLimit = j3;
        return true;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        long jLpConsumerIndex = lpConsumerIndex();
        long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpConsumerIndex, this.mask);
        E[] eArr = this.buffer;
        E e = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset);
        if (e == null) {
            return null;
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 1);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        return (E) UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(lpConsumerIndex(), this.mask));
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
        return drain(consumer, capacity());
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return fill(supplier, capacity());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        if (consumer == 0) {
            throw new IllegalArgumentException("c is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("limit is negative: " + i);
        }
        if (i == 0) {
            return 0;
        }
        E[] eArr = this.buffer;
        long j = this.mask;
        long jLpConsumerIndex = lpConsumerIndex();
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = ((long) i2) + jLpConsumerIndex;
            long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(j2, j);
            Object objLvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset);
            if (objLvRefElement == null) {
                return i2;
            }
            UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, null);
            soConsumerIndex(j2 + 1);
            consumer.accept(objLvRefElement);
        }
        return i;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        int i2;
        long j;
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
        long j2 = this.mask;
        int i3 = this.lookAheadStep;
        long jLpProducerIndex = lpProducerIndex();
        int i4 = 0;
        while (i4 < i) {
            long j3 = ((long) i4) + jLpProducerIndex;
            if (UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(((long) i3) + j3, j2)) == null) {
                int iMin = Math.min(i3, i - i4);
                int i5 = 0;
                while (i5 < iMin) {
                    long j4 = ((long) i5) + j3;
                    UnsafeRefArrayAccess.soRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(j4, j2), supplier.get());
                    soProducerIndex(j4 + 1);
                    i5++;
                    i3 = i3;
                    jLpProducerIndex = jLpProducerIndex;
                }
                i2 = i3;
                j = jLpProducerIndex;
                i4 += iMin - 1;
            } else {
                i2 = i3;
                j = jLpProducerIndex;
                long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(j3, j2);
                if (UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset) != null) {
                    return i4;
                }
                UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, supplier.get());
                soProducerIndex(j3 + 1);
            }
            i4++;
            i3 = i2;
            jLpProducerIndex = j;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        if (consumer == 0) {
            throw new IllegalArgumentException("c is null");
        }
        if (waitStrategy == null) {
            throw new IllegalArgumentException("wait is null");
        }
        if (exitCondition == null) {
            throw new IllegalArgumentException("exit condition is null");
        }
        E[] eArr = this.buffer;
        long j = this.mask;
        long jLpConsumerIndex = lpConsumerIndex();
        int iIdle = 0;
        while (exitCondition.keepRunning()) {
            for (int i = 0; i < 4096; i++) {
                long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpConsumerIndex, j);
                Object objLvRefElement = UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset);
                if (objLvRefElement == null) {
                    iIdle = waitStrategy.idle(iIdle);
                } else {
                    jLpConsumerIndex++;
                    UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, null);
                    soConsumerIndex(jLpConsumerIndex);
                    consumer.accept(objLvRefElement);
                    iIdle = 0;
                }
            }
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        if (waitStrategy == null) {
            throw new IllegalArgumentException("waiter is null");
        }
        if (exitCondition == null) {
            throw new IllegalArgumentException("exit condition is null");
        }
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        E[] eArr = this.buffer;
        long j = this.mask;
        int i = this.lookAheadStep;
        long jLpProducerIndex = lpProducerIndex();
        while (true) {
            int iIdle = 0;
            while (exitCondition.keepRunning()) {
                if (UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(((long) i) + jLpProducerIndex, j)) == null) {
                    for (int i2 = 0; i2 < i; i2++) {
                        long jCalcCircularRefElementOffset = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpProducerIndex, j);
                        jLpProducerIndex++;
                        UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset, supplier.get());
                        soProducerIndex(jLpProducerIndex);
                    }
                } else {
                    long jCalcCircularRefElementOffset2 = UnsafeRefArrayAccess.calcCircularRefElementOffset(jLpProducerIndex, j);
                    if (UnsafeRefArrayAccess.lvRefElement(eArr, jCalcCircularRefElementOffset2) != null) {
                        iIdle = waitStrategy.idle(iIdle);
                    } else {
                        jLpProducerIndex++;
                        UnsafeRefArrayAccess.soRefElement(eArr, jCalcCircularRefElementOffset2, supplier.get());
                        soProducerIndex(jLpProducerIndex);
                    }
                }
            }
            return;
        }
    }
}
