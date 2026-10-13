package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* JADX INFO: loaded from: classes11.dex */
public class SpscGrowableAtomicArrayQueue<E> extends BaseSpscLinkedAtomicArrayQueue<E> {
    private long lookAheadStep;
    private final int maxQueueCapacity;

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return super.currentProducerIndex();
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return super.drain(consumer);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return super.drain(consumer, i);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier) {
        return super.fill(supplier);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier, int i) {
        return super.fill(supplier, i);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.fill(supplier, waitStrategy, exitCondition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return super.offer(obj);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return super.peek();
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return super.poll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return super.relaxedOffer(obj);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public SpscGrowableAtomicArrayQueue(int i) {
        this(Math.max(8, Pow2.roundToPowerOfTwo(i / 8)), i);
    }

    public SpscGrowableAtomicArrayQueue(int i, int i2) {
        RangeUtil.checkGreaterThanOrEqual(i2, 16, "capacity");
        RangeUtil.checkGreaterThanOrEqual(i, 8, "chunkSize");
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i2);
        this.maxQueueCapacity = iRoundToPowerOfTwo;
        int iRoundToPowerOfTwo2 = Pow2.roundToPowerOfTwo(i);
        RangeUtil.checkLessThan(iRoundToPowerOfTwo2, iRoundToPowerOfTwo, "chunkCapacity");
        long j = iRoundToPowerOfTwo2 - 1;
        AtomicReferenceArray<E> atomicReferenceArrayAllocateRefArray = AtomicQueueUtil.allocateRefArray(iRoundToPowerOfTwo2 + 1);
        this.producerBuffer = atomicReferenceArrayAllocateRefArray;
        this.producerMask = j;
        this.consumerBuffer = atomicReferenceArrayAllocateRefArray;
        this.consumerMask = j;
        this.producerBufferLimit = j - 1;
        adjustLookAheadStep(iRoundToPowerOfTwo2);
    }

    @Override // org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue
    final boolean offerColdPath(AtomicReferenceArray<E> atomicReferenceArray, long j, long j2, int i, E e, MessagePassingQueue.Supplier<? extends E> supplier) {
        long j3 = this.lookAheadStep;
        if (j3 > 0) {
            long j4 = j2 + j3;
            if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(j4, j)) == null) {
                this.producerBufferLimit = j4 - 1;
                writeToQueue(atomicReferenceArray, e == null ? supplier.get() : e, j2, i);
                return true;
            }
            int i2 = this.maxQueueCapacity;
            long j5 = j + 1;
            long j6 = i2;
            if (j5 == j6) {
                if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, i) != null) {
                    return false;
                }
                writeToQueue(atomicReferenceArray, e == null ? supplier.get() : e, j2, i);
                return true;
            }
            if (AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.calcCircularRefElementOffset(j2 + 1, j)) == null) {
                writeToQueue(atomicReferenceArray, e == null ? supplier.get() : e, j2, i);
            } else {
                AtomicReferenceArray<E> atomicReferenceArrayAllocateRefArray = AtomicQueueUtil.allocateRefArray((int) ((j5 * 2) + 1));
                this.producerBuffer = atomicReferenceArrayAllocateRefArray;
                this.producerMask = AtomicQueueUtil.length(atomicReferenceArrayAllocateRefArray) - 2;
                linkOldToNew(j2, atomicReferenceArray, i, atomicReferenceArrayAllocateRefArray, AtomicQueueUtil.calcCircularRefElementOffset(j2, this.producerMask), e == null ? supplier.get() : e);
                int i3 = (int) (this.producerMask + 1);
                if (i3 == i2) {
                    long jLvConsumerIndex = lvConsumerIndex();
                    this.lookAheadStep = -(j2 - jLvConsumerIndex);
                    this.producerBufferLimit = jLvConsumerIndex + j6;
                } else {
                    this.producerBufferLimit = (j2 + this.producerMask) - 1;
                    adjustLookAheadStep(i3);
                }
            }
            return true;
        }
        long j7 = -j3;
        long jLvConsumerIndex2 = lvConsumerIndex();
        int i4 = ((int) j) + 1;
        if (((int) (j2 - jLvConsumerIndex2)) == i4) {
            return false;
        }
        long j8 = i4;
        long j9 = (this.producerBufferLimit - j8) + j7;
        if (jLvConsumerIndex2 >= j9) {
            adjustLookAheadStep(i4);
        } else {
            this.lookAheadStep = (int) (jLvConsumerIndex2 - j9);
        }
        this.producerBufferLimit = jLvConsumerIndex2 + j8;
        writeToQueue(atomicReferenceArray, e == null ? supplier.get() : e, j2, i);
        return true;
    }

    private void adjustLookAheadStep(int i) {
        this.lookAheadStep = Math.min(i / 4, SpscAtomicArrayQueue.MAX_LOOK_AHEAD_STEP);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return this.maxQueueCapacity;
    }
}
