package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MessagePassingQueueUtil;
import org.jctools.util.RangeUtil;

/* JADX INFO: loaded from: classes11.dex */
public class MpmcAtomicArrayQueue<E> extends MpmcAtomicArrayQueueL3Pad<E> {
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.mpmc.max.lookahead.step", 4096).intValue();
    private final int lookAheadStep;

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public MpmcAtomicArrayQueue(int i) {
        super(RangeUtil.checkGreaterThanOrEqual(i, 2, "capacity"));
        this.lookAheadStep = Math.max(2, Math.min(capacity() / 4, MAX_LOOK_AHEAD_STEP));
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (e == null) {
            throw null;
        }
        int i = this.mask;
        long j = i + 1;
        AtomicLongArray atomicLongArray = this.sequenceBuffer;
        long jLvConsumerIndex = Long.MIN_VALUE;
        while (true) {
            long jLvProducerIndex = lvProducerIndex();
            int iCalcCircularLongElementOffset = AtomicQueueUtil.calcCircularLongElementOffset(jLvProducerIndex, i);
            long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, iCalcCircularLongElementOffset);
            if (jLvLongElement < jLvProducerIndex) {
                long j2 = jLvProducerIndex - j;
                if (j2 >= jLvConsumerIndex) {
                    jLvConsumerIndex = lvConsumerIndex();
                    if (j2 >= jLvConsumerIndex) {
                        return false;
                    }
                }
                jLvLongElement = jLvProducerIndex + 1;
            }
            if (jLvLongElement <= jLvProducerIndex) {
                long j3 = 1 + jLvProducerIndex;
                if (casProducerIndex(jLvProducerIndex, j3)) {
                    AtomicQueueUtil.spRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(jLvProducerIndex, i), e);
                    AtomicQueueUtil.soLongElement(atomicLongArray, iCalcCircularLongElementOffset, j3);
                    return true;
                }
            }
        }
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        AtomicLongArray atomicLongArray = this.sequenceBuffer;
        int i = this.mask;
        long jLvProducerIndex = -1;
        while (true) {
            long jLvConsumerIndex = lvConsumerIndex();
            int iCalcCircularLongElementOffset = AtomicQueueUtil.calcCircularLongElementOffset(jLvConsumerIndex, i);
            long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, iCalcCircularLongElementOffset);
            long j = jLvConsumerIndex + 1;
            if (jLvLongElement < j) {
                if (jLvConsumerIndex >= jLvProducerIndex) {
                    jLvProducerIndex = lvProducerIndex();
                    if (jLvConsumerIndex == jLvProducerIndex) {
                        return null;
                    }
                }
                jLvLongElement = 2 + jLvConsumerIndex;
            }
            if (jLvLongElement <= j && casConsumerIndex(jLvConsumerIndex, j)) {
                long j2 = i;
                int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLvConsumerIndex, j2);
                E e = (E) AtomicQueueUtil.lpRefElement(this.buffer, iCalcCircularRefElementOffset);
                AtomicQueueUtil.spRefElement(this.buffer, iCalcCircularRefElementOffset, null);
                AtomicQueueUtil.soLongElement(atomicLongArray, iCalcCircularLongElementOffset, jLvConsumerIndex + j2 + 1);
                return e;
            }
        }
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicLongArray atomicLongArray = this.sequenceBuffer;
        int i = this.mask;
        long jLvProducerIndex = -1;
        while (true) {
            long jLvConsumerIndex = lvConsumerIndex();
            long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, AtomicQueueUtil.calcCircularLongElementOffset(jLvConsumerIndex, i));
            long j = 1 + jLvConsumerIndex;
            if (jLvLongElement < j) {
                if (jLvConsumerIndex >= jLvProducerIndex) {
                    jLvProducerIndex = lvProducerIndex();
                    if (jLvConsumerIndex == jLvProducerIndex) {
                        return null;
                    }
                } else {
                    continue;
                }
            } else if (jLvLongElement == j) {
                E e = (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(jLvConsumerIndex, i));
                if (lvConsumerIndex() == jLvConsumerIndex) {
                    return e;
                }
            } else {
                continue;
            }
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        if (e == null) {
            throw null;
        }
        int i = this.mask;
        AtomicLongArray atomicLongArray = this.sequenceBuffer;
        while (true) {
            long jLvProducerIndex = lvProducerIndex();
            int iCalcCircularLongElementOffset = AtomicQueueUtil.calcCircularLongElementOffset(jLvProducerIndex, i);
            long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, iCalcCircularLongElementOffset);
            if (jLvLongElement < jLvProducerIndex) {
                return false;
            }
            if (jLvLongElement <= jLvProducerIndex) {
                long j = 1 + jLvProducerIndex;
                if (casProducerIndex(jLvProducerIndex, j)) {
                    AtomicQueueUtil.spRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(jLvProducerIndex, i), e);
                    AtomicQueueUtil.soLongElement(atomicLongArray, iCalcCircularLongElementOffset, j);
                    return true;
                }
            }
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicLongArray atomicLongArray = this.sequenceBuffer;
        int i = this.mask;
        while (true) {
            long jLvConsumerIndex = lvConsumerIndex();
            int iCalcCircularLongElementOffset = AtomicQueueUtil.calcCircularLongElementOffset(jLvConsumerIndex, i);
            long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, iCalcCircularLongElementOffset);
            long j = jLvConsumerIndex + 1;
            if (jLvLongElement < j) {
                return null;
            }
            if (jLvLongElement <= j && casConsumerIndex(jLvConsumerIndex, j)) {
                long j2 = i;
                int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLvConsumerIndex, j2);
                E e = (E) AtomicQueueUtil.lpRefElement(this.buffer, iCalcCircularRefElementOffset);
                AtomicQueueUtil.spRefElement(this.buffer, iCalcCircularRefElementOffset, null);
                AtomicQueueUtil.soLongElement(atomicLongArray, iCalcCircularLongElementOffset, jLvConsumerIndex + j2 + 1);
                return e;
            }
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        AtomicLongArray atomicLongArray = this.sequenceBuffer;
        int i = this.mask;
        while (true) {
            long jLvConsumerIndex = lvConsumerIndex();
            long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, AtomicQueueUtil.calcCircularLongElementOffset(jLvConsumerIndex, i));
            long j = 1 + jLvConsumerIndex;
            if (jLvLongElement < j) {
                return null;
            }
            if (jLvLongElement == j) {
                E e = (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(jLvConsumerIndex, i));
                if (lvConsumerIndex() == jLvConsumerIndex) {
                    return e;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        MpmcAtomicArrayQueue<E> mpmcAtomicArrayQueue;
        MpmcAtomicArrayQueue<E> mpmcAtomicArrayQueue2 = this;
        int i2 = i;
        if (consumer == 0) {
            throw new IllegalArgumentException("c is null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("limit is negative: " + i2);
        }
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        AtomicLongArray atomicLongArray = mpmcAtomicArrayQueue2.sequenceBuffer;
        int i3 = mpmcAtomicArrayQueue2.mask;
        AtomicReferenceArray<E> atomicReferenceArray = mpmcAtomicArrayQueue2.buffer;
        int iMin = Math.min(mpmcAtomicArrayQueue2.lookAheadStep, i2);
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i2 - i4;
            int iMin2 = Math.min(i5, iMin);
            int i6 = i2;
            long jLvConsumerIndex = mpmcAtomicArrayQueue2.lvConsumerIndex();
            long j = ((long) iMin2) + jLvConsumerIndex;
            long j2 = 1;
            long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, AtomicQueueUtil.calcCircularLongElementOffset(j - 1, i3));
            if (jLvLongElement != j || !mpmcAtomicArrayQueue2.casConsumerIndex(jLvConsumerIndex, j)) {
                if (jLvLongElement < j) {
                    mpmcAtomicArrayQueue = this;
                    if (mpmcAtomicArrayQueue.notAvailable(jLvConsumerIndex, i3, atomicLongArray, jLvConsumerIndex + 1)) {
                        return i4;
                    }
                } else {
                    mpmcAtomicArrayQueue = this;
                }
                return i4 + mpmcAtomicArrayQueue.drainOneByOne(consumer, i5);
            }
            int i7 = 0;
            while (i7 < iMin2) {
                long j3 = ((long) i7) + jLvConsumerIndex;
                int iCalcCircularLongElementOffset = AtomicQueueUtil.calcCircularLongElementOffset(j3, i3);
                long j4 = jLvConsumerIndex;
                long j5 = i3;
                int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(j3, j5);
                while (AtomicQueueUtil.lvLongElement(atomicLongArray, iCalcCircularLongElementOffset) != j3 + j2) {
                }
                long j6 = j2;
                Object objLpRefElement = AtomicQueueUtil.lpRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
                AtomicQueueUtil.spRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
                AtomicQueueUtil.soLongElement(atomicLongArray, iCalcCircularLongElementOffset, j3 + j5 + j6);
                consumer.accept(objLpRefElement);
                i7++;
                jLvConsumerIndex = j4;
                j2 = j6;
            }
            i4 += iMin2;
            mpmcAtomicArrayQueue2 = this;
            i2 = i6;
            z = false;
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int drainOneByOne(MessagePassingQueue.Consumer<E> consumer, int i) {
        long jLvConsumerIndex;
        int iCalcCircularLongElementOffset;
        AtomicLongArray atomicLongArray = this.sequenceBuffer;
        int i2 = this.mask;
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        for (int i3 = 0; i3 < i; i3++) {
            while (true) {
                jLvConsumerIndex = lvConsumerIndex();
                iCalcCircularLongElementOffset = AtomicQueueUtil.calcCircularLongElementOffset(jLvConsumerIndex, i2);
                long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, iCalcCircularLongElementOffset);
                long j = jLvConsumerIndex + 1;
                if (jLvLongElement < j) {
                    return i3;
                }
                if (jLvLongElement > j || !casConsumerIndex(jLvConsumerIndex, j)) {
                }
            }
            long j2 = i2;
            int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(jLvConsumerIndex, j2);
            Object objLpRefElement = AtomicQueueUtil.lpRefElement(atomicReferenceArray, iCalcCircularRefElementOffset);
            AtomicQueueUtil.spRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, null);
            AtomicQueueUtil.soLongElement(atomicLongArray, iCalcCircularLongElementOffset, jLvConsumerIndex + j2 + 1);
            consumer.accept(objLpRefElement);
        }
        return i;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        MpmcAtomicArrayQueue<E> mpmcAtomicArrayQueue;
        MpmcAtomicArrayQueue<E> mpmcAtomicArrayQueue2 = this;
        int i2 = i;
        if (supplier == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("limit is negative:" + i2);
        }
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        AtomicLongArray atomicLongArray = mpmcAtomicArrayQueue2.sequenceBuffer;
        int i3 = mpmcAtomicArrayQueue2.mask;
        AtomicReferenceArray<E> atomicReferenceArray = mpmcAtomicArrayQueue2.buffer;
        int iMin = Math.min(mpmcAtomicArrayQueue2.lookAheadStep, i2);
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i2 - i4;
            int iMin2 = Math.min(i5, iMin);
            int i6 = i2;
            long jLvProducerIndex = mpmcAtomicArrayQueue2.lvProducerIndex();
            long j = ((long) iMin2) + jLvProducerIndex;
            long j2 = j - 1;
            long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, AtomicQueueUtil.calcCircularLongElementOffset(j2, i3));
            if (jLvLongElement != j2 || !mpmcAtomicArrayQueue2.casProducerIndex(jLvProducerIndex, j)) {
                if (jLvLongElement < j2) {
                    mpmcAtomicArrayQueue = this;
                    if (mpmcAtomicArrayQueue.notAvailable(jLvProducerIndex, i3, atomicLongArray, jLvProducerIndex)) {
                        return i4;
                    }
                } else {
                    mpmcAtomicArrayQueue = this;
                }
                return i4 + mpmcAtomicArrayQueue.fillOneByOne(supplier, i5);
            }
            int i7 = 0;
            while (i7 < iMin2) {
                long j3 = ((long) i7) + jLvProducerIndex;
                int iCalcCircularLongElementOffset = AtomicQueueUtil.calcCircularLongElementOffset(j3, i3);
                long j4 = jLvProducerIndex;
                int iCalcCircularRefElementOffset = AtomicQueueUtil.calcCircularRefElementOffset(j3, i3);
                while (AtomicQueueUtil.lvLongElement(atomicLongArray, iCalcCircularLongElementOffset) != j3) {
                }
                AtomicQueueUtil.soRefElement(atomicReferenceArray, iCalcCircularRefElementOffset, supplier.get());
                AtomicQueueUtil.soLongElement(atomicLongArray, iCalcCircularLongElementOffset, j3 + 1);
                i7++;
                jLvProducerIndex = j4;
            }
            i4 += iMin2;
            mpmcAtomicArrayQueue2 = this;
            i2 = i6;
            z = false;
        }
        return i2;
    }

    private boolean notAvailable(long j, int i, AtomicLongArray atomicLongArray, long j2) {
        return AtomicQueueUtil.lvLongElement(atomicLongArray, AtomicQueueUtil.calcCircularLongElementOffset(j, i)) < j2;
    }

    private int fillOneByOne(MessagePassingQueue.Supplier<E> supplier, int i) {
        long jLvProducerIndex;
        int iCalcCircularLongElementOffset;
        long j;
        AtomicLongArray atomicLongArray = this.sequenceBuffer;
        int i2 = this.mask;
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        for (int i3 = 0; i3 < i; i3++) {
            while (true) {
                jLvProducerIndex = lvProducerIndex();
                iCalcCircularLongElementOffset = AtomicQueueUtil.calcCircularLongElementOffset(jLvProducerIndex, i2);
                long jLvLongElement = AtomicQueueUtil.lvLongElement(atomicLongArray, iCalcCircularLongElementOffset);
                if (jLvLongElement < jLvProducerIndex) {
                    return i3;
                }
                if (jLvLongElement <= jLvProducerIndex) {
                    j = 1 + jLvProducerIndex;
                    if (casProducerIndex(jLvProducerIndex, j)) {
                        break;
                    }
                }
            }
            AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(jLvProducerIndex, i2), supplier.get());
            AtomicQueueUtil.soLongElement(atomicLongArray, iCalcCircularLongElementOffset, j);
        }
        return i;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return MessagePassingQueueUtil.drain(this, consumer);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        return MessagePassingQueueUtil.fillBounded(this, supplier);
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
