package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;

/* JADX INFO: loaded from: classes11.dex */
public class SpscAtomicArrayQueue<E> extends SpscAtomicArrayQueueL3Pad<E> {
    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public SpscAtomicArrayQueue(int i) {
        super(Math.max(i, 4));
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw null;
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i = this.mask;
        long jLpProducerIndex = lpProducerIndex();
        if (jLpProducerIndex >= this.producerLimit && !offerSlowPath(atomicReferenceArray, i, jLpProducerIndex)) {
            return false;
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(jLpProducerIndex, i), e);
        soProducerIndex(jLpProducerIndex + 1);
        return true;
    }

    private boolean offerSlowPath(AtomicReferenceArray<E> atomicReferenceArray, int i, long j) {
        long j2 = ((long) this.lookAheadStep) + j;
        long j3 = i;
        if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(j2, j3)) != null) {
            return AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(j, j3)) == null;
        }
        this.producerLimit = j2;
        return true;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        long jLpConsumerIndex = lpConsumerIndex();
        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpConsumerIndex, this.mask);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E e = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
        if (e == null) {
            return null;
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 1);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        return (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex(), this.mask));
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
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i2 = this.mask;
        long jLpConsumerIndex = lpConsumerIndex();
        for (int i3 = 0; i3 < i; i3++) {
            long j = ((long) i3) + jLpConsumerIndex;
            int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(j, i2);
            Object objLvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
            if (objLvRefElement == null) {
                return i3;
            }
            AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
            soConsumerIndex(j + 1);
            consumer.accept(objLvRefElement);
        }
        return i;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        int i2;
        int i3;
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("limit is negative:" + i);
        }
        int i4 = 0;
        if (i == 0) {
            return 0;
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i5 = this.mask;
        int i6 = this.lookAheadStep;
        long jLpProducerIndex = lpProducerIndex();
        int i7 = 0;
        while (i7 < i) {
            long j = ((long) i7) + jLpProducerIndex;
            long j2 = i5;
            if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(((long) i6) + j, j2)) == null) {
                int iMin = Math.min(i6, i - i7);
                int i8 = i4;
                while (i8 < iMin) {
                    long j3 = ((long) i8) + j;
                    atomicReferenceArray = atomicReferenceArray;
                    AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(j3, j2), supplier.get());
                    soProducerIndex(j3 + 1);
                    i8++;
                    i5 = i5;
                    i6 = i6;
                }
                i2 = i5;
                i3 = i6;
                i7 += iMin - 1;
            } else {
                i2 = i5;
                i3 = i6;
                int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(j, j2);
                if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset) != null) {
                    return i7;
                }
                AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, supplier.get());
                soProducerIndex(j + 1);
            }
            i7++;
            i5 = i2;
            i6 = i3;
            i4 = 0;
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
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i = this.mask;
        long jLpConsumerIndex = lpConsumerIndex();
        int iIdle = 0;
        while (exitCondition.keepRunning()) {
            for (int i2 = 0; i2 < 4096; i2++) {
                int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpConsumerIndex, i);
                Object objLvRefElement = AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
                if (objLvRefElement == null) {
                    iIdle = waitStrategy.idle(iIdle);
                } else {
                    jLpConsumerIndex++;
                    AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
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
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i = this.mask;
        int i2 = this.lookAheadStep;
        long jLpProducerIndex = lpProducerIndex();
        while (true) {
            int iIdle = 0;
            while (exitCondition.keepRunning()) {
                long j = i;
                if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(((long) i2) + jLpProducerIndex, j)) == null) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLpProducerIndex, j);
                        jLpProducerIndex++;
                        AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, supplier.get());
                        soProducerIndex(jLpProducerIndex);
                    }
                } else {
                    int iCalcCircularRefElementOffset2 = AtomicQueueUtil.calcCircularRefElementOffset(jLpProducerIndex, j);
                    if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, iCalcCircularRefElementOffset2) != null) {
                        iIdle = waitStrategy.idle(iIdle);
                    } else {
                        jLpProducerIndex++;
                        AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset2, supplier.get());
                        soProducerIndex(jLpProducerIndex);
                    }
                }
            }
            return;
        }
    }
}
