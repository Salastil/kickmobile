package org.jctools.queues;

import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;
import org.jctools.util.UnsafeRefArrayAccess;

/* JADX INFO: loaded from: classes11.dex */
public class SpscGrowableArrayQueue<E> extends BaseSpscLinkedArrayQueue<E> {
    private long lookAheadStep;
    private final int maxQueueCapacity;

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return super.currentProducerIndex();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return super.drain(consumer);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return super.drain(consumer, i);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier) {
        return super.fill(supplier);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier, int i) {
        return super.fill(supplier, i);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        super.fill(supplier, waitStrategy, exitCondition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return super.offer(obj);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return super.peek();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return super.poll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return super.relaxedOffer(obj);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public SpscGrowableArrayQueue(int i) {
        this(Math.max(8, Pow2.roundToPowerOfTwo(i / 8)), i);
    }

    public SpscGrowableArrayQueue(int i, int i2) {
        RangeUtil.checkGreaterThanOrEqual(i2, 16, "capacity");
        RangeUtil.checkGreaterThanOrEqual(i, 8, "chunkSize");
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i2);
        this.maxQueueCapacity = iRoundToPowerOfTwo;
        int iRoundToPowerOfTwo2 = Pow2.roundToPowerOfTwo(i);
        RangeUtil.checkLessThan(iRoundToPowerOfTwo2, iRoundToPowerOfTwo, "chunkCapacity");
        long j = iRoundToPowerOfTwo2 - 1;
        E[] eArr = (E[]) UnsafeRefArrayAccess.allocateRefArray(iRoundToPowerOfTwo2 + 1);
        this.producerBuffer = eArr;
        this.producerMask = j;
        this.consumerBuffer = eArr;
        this.consumerMask = j;
        this.producerBufferLimit = j - 1;
        adjustLookAheadStep(iRoundToPowerOfTwo2);
    }

    @Override // org.jctools.queues.BaseSpscLinkedArrayQueue
    final boolean offerColdPath(E[] eArr, long j, long j2, long j3, E e, MessagePassingQueue.Supplier<? extends E> supplier) {
        long j4 = this.lookAheadStep;
        if (j4 > 0) {
            long j5 = j2 + j4;
            if (UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(j5, j)) == null) {
                this.producerBufferLimit = j5 - 1;
                writeToQueue(eArr, e == null ? supplier.get() : e, j2, j3);
                return true;
            }
            int i = this.maxQueueCapacity;
            long j6 = j + 1;
            long j7 = i;
            if (j6 == j7) {
                if (UnsafeRefArrayAccess.lvRefElement(eArr, j3) != null) {
                    return false;
                }
                writeToQueue(eArr, e == null ? supplier.get() : e, j2, j3);
                return true;
            }
            if (UnsafeRefArrayAccess.lvRefElement(eArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(j2 + 1, j)) == null) {
                writeToQueue(eArr, e == null ? supplier.get() : e, j2, j3);
            } else {
                E[] eArr2 = (E[]) UnsafeRefArrayAccess.allocateRefArray((int) ((j6 * 2) + 1));
                this.producerBuffer = eArr2;
                this.producerMask = LinkedArrayQueueUtil.length(eArr2) - 2;
                linkOldToNew(j2, eArr, j3, eArr2, UnsafeRefArrayAccess.calcCircularRefElementOffset(j2, this.producerMask), e == null ? supplier.get() : e);
                int i2 = (int) (this.producerMask + 1);
                if (i2 == i) {
                    long jLvConsumerIndex = lvConsumerIndex();
                    this.lookAheadStep = -(j2 - jLvConsumerIndex);
                    this.producerBufferLimit = jLvConsumerIndex + j7;
                } else {
                    this.producerBufferLimit = (j2 + this.producerMask) - 1;
                    adjustLookAheadStep(i2);
                }
            }
            return true;
        }
        long j8 = -j4;
        long jLvConsumerIndex2 = lvConsumerIndex();
        int i3 = ((int) j) + 1;
        if (((int) (j2 - jLvConsumerIndex2)) == i3) {
            return false;
        }
        long j9 = i3;
        long j10 = (this.producerBufferLimit - j9) + j8;
        if (jLvConsumerIndex2 >= j10) {
            adjustLookAheadStep(i3);
        } else {
            this.lookAheadStep = (int) (jLvConsumerIndex2 - j10);
        }
        this.producerBufferLimit = jLvConsumerIndex2 + j9;
        writeToQueue(eArr, e == null ? supplier.get() : e, j2, j3);
        return true;
    }

    private void adjustLookAheadStep(int i) {
        this.lookAheadStep = Math.min(i / 4, SpscArrayQueue.MAX_LOOK_AHEAD_STEP);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return this.maxQueueCapacity;
    }
}
